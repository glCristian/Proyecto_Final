package co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Clase singleton para gestionar las transacciones de la billetera virtual
 * permitiendo crear, consultar y eliminar transacciones asociadas al usuario actual
 */
public class GestorTransacciones {

    private static GestorTransacciones instancia;
    private SujetoTransacciones sujetoNotificaciones;
    private CalculadoraComisiones calculadoraComisiones;

    /**
     * Cosntructor privado de la clase GestorTransacciones
     */
    private GestorTransacciones() {
        super();
        this.sujetoNotificaciones = new SujetoTransacciones();
        this.calculadoraComisiones = new CalculadoraComisiones(new SinComision());

        // Configurar observadores por defecto
        configurarObservadoresPorDefecto();
    }


    /**
     * Metodo que retorna la instancia unica de gestorTransacciones, creando una nueva si no existe
     * @return
     */
    public static GestorTransacciones getInstancia(){
        if(instancia == null){
            instancia = new GestorTransacciones();
        }
        return instancia;
    }

    /**
     * Metodo que genera un ID de manera aleatoria
     * @return idUnico
     */
    public static String generarIdUnico() {
        return UUID.randomUUID().toString().substring(0, 8);
    }


    /**
     * Metodo que obtiene la fecha actual y la devuelve como String
     * @return fecha Actual
     */
    public static LocalDateTime obtenerFechaActual() {
        return LocalDateTime.now();
    }


    /**
     * Metodo para buscar una cuenta por su ID
     * @param idCuenta
     * @return cuenta
     */
    public Cuenta buscarCuentaPorId(String idCuenta) {
        for (Persona persona : BilleteraVirtual.getInstancia().getPerfiles()) {
            if (persona instanceof Usuario usuario) {
                for (Cuenta cuenta : usuario.getListaCuentas()) {
                    if (cuenta.getIdCuenta().equals(idCuenta)) {
                        return cuenta;
                    }
                }
            }
        }
        return null;
    }


    /**
     * Metodo para realiza la accion del deposito a la cuenta de un usuario en la base de datos usuario
     *
     * WARNING: Metodo auxiliar, utilizado como complemento de otros metodos
     */
    public boolean depositarDinero(String numeroCuentaa, double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
            return false;
        }

        for (Persona persona : BilleteraVirtual.getInstancia().getPerfiles()) {
            if (persona instanceof Usuario usuario) {
                for (Cuenta cuenta : usuario.getListaCuentas()) {
                    if (cuenta.getNumeroCuenta().equals(numeroCuentaa)) {
                        cuenta.depositar(monto);
                        return true;
                    }
                }
            }
        }

        System.out.println("Cuenta no encontrada para depósito.");
        return false;
    }


    /**
     * Metodo para realizar la accion del retiro a la cuenta de un usuario en la base de datos usuario
     *
     * WARNING: Metodo auxiliar, utilizado como complemento de otros metodos
     */
    public boolean retirarDinero(String numeroCuenta, double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
            return false;
        }

        for (Persona persona : BilleteraVirtual.getInstancia().getPerfiles()) {
            if (persona instanceof Usuario usuario) {
                for (Cuenta cuenta : usuario.getListaCuentas()) {
                    if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                        if (cuenta.getSaldoTotal() >= monto) {
                            cuenta.retirar(monto); // retira el monto de la cuenta
                            return true;
                        } else {
                            System.out.println("Saldo insuficiente en la cuenta.");
                            return false;
                        }
                    }
                }
            }
        }

        System.out.println("Cuenta no encontrada para retiro.");
        return false;
    }


    /**
     * Metodo que genera un deposito a una cuenta
     * @param idCuentaDestino cuenta destino del deposito
     * @param monto cantidad a depositar
     * @param descripcion descripcion del deposito
     * @param categoria categoria del deposito
     * @return true si el deposito fue exitoso, false en caso contrario
     */
    public boolean realizarDeposito(String idCuentaDestino, double monto, String descripcion, Categoria categoria) {
        if (depositarDinero(idCuentaDestino, monto)) {
            Transaccion transaccion = new Transaccion(
                    generarIdUnico(),
                    obtenerFechaActual(),
                    monto,
                    descripcion,
                    null,  // cuenta origen es null para depósitos
                    idCuentaDestino,
                    categoria,
                    TipoTransaccion.DEPOSITO
            );
            registrarTransaccion(transaccion);
            return true;
        }
        return false;
    }

    /**
     * Metodo que realiza un retiro de dinero de una cuenta
     * @param idCuentaOrigen cuenta de la que se retira el dinero
     * @param monto cantidad a retirar
     * @param descripcion descripcion del retiro
     * @param categoria categoria del retiro
     * @return true si el retiro fue exitoso, false en caso contrario
     */
    public boolean realizarRetiro(String idCuentaOrigen, double monto, String descripcion, Categoria categoria) {
        if (retirarDinero(idCuentaOrigen, monto)) {
            Transaccion transaccion = new Transaccion(
                    generarIdUnico(),
                    obtenerFechaActual(),
                    monto,
                    descripcion,
                    idCuentaOrigen,
                    null,  // cuenta destino es null para retiros
                    categoria,
                    TipoTransaccion.RETIRO
            );
            registrarTransaccion(transaccion);
            return true;
        }
        return false;
    }


    /**
     * Metodo que realiza una transferencia entre cuentas
     * @param idCuentaOrigen cuenta que envía el dinero
     * @param idCuentaDestino cuenta que recibe el dinero
     * @param monto cantidad a transferir
     * @param descripcion descripción de la transferencia
     * @param categoria categoría de la transferencia
     * @return true si la transferencia fue exitosa, false en caso contrario
     */
    public boolean realizarTransferencia(String idCuentaOrigen, String idCuentaDestino,
                                         double monto, String descripcion, Categoria categoria) {
        // 1. Intentar realizar el retiro
        if (retirarDinero(idCuentaOrigen, monto)) {
            // 2. Si el retiro fue exitoso, intentar realizar el depósito
            if (depositarDinero(idCuentaDestino, monto)) {
                try {
                    // 3. Crear la transacción usando el método factory
                    Transaccion transaccion = Transaccion.crearTransferencia(
                            idCuentaOrigen, idCuentaDestino, monto, descripcion, categoria);

                    // 4. Registrar la transacción en el sistema y en los usuarios
                    registrarTransaccion(transaccion);

                    // 5. Obtener los usuarios involucrados
                    Usuario usuarioOrigen = buscarUsuarioPorNumeroCuenta(idCuentaOrigen);
                    Usuario usuarioDestino = buscarUsuarioPorNumeroCuenta(idCuentaDestino);

                    // 6. Agregar la transacción a las listas de los usuarios
                    if (usuarioOrigen != null) {
                        usuarioOrigen.agregarTransaccion(transaccion);
                    }
                    if (usuarioDestino != null) {
                        usuarioDestino.agregarTransaccion(transaccion);
                    }

                    // 7. Calcular y aplicar comisión si corresponde
                    double comision = calculadoraComisiones.calcular(transaccion);
                    if (comision > 0) {
                        System.out.println(" Comisión aplicada: $" + String.format("%.2f", comision) +
                                " (" + calculadoraComisiones.getEstrategiaActual() + ")");

                        // Aplicar la comisión retirando el monto adicional
                        retirarDinero(idCuentaOrigen, comision);
                    }

                    // 8. Notificar a los observadores
                    sujetoNotificaciones.notificarObservadores(transaccion, "TRANSFERENCIA_COMPLETADA");

                    return true;

                } catch (Exception e) {
                    System.out.println("Error al procesar la transferencia: " + e.getMessage());
                    // Revertir las operaciones en caso de error
                    depositarDinero(idCuentaOrigen, monto);
                    retirarDinero(idCuentaDestino, monto);
                    return false;
                }
            } else {
                // Si falla el depósito, revertir el retiro
                depositarDinero(idCuentaOrigen, monto);
                System.out.println("No se pudo completar el depósito en la cuenta destino");
                return false;
            }
        }
        System.out.println("No se pudo realizar el retiro de la cuenta origen");
        return false;
    }




    /**
     * Metodo que busca un usuario por su cuenta
     * @param cuenta cuenta del usuario
     * @return usuario encontrado o null si no se encuentra
     */
    private Usuario buscarUsuarioPorCuenta(Cuenta cuenta) {
        for (Usuario usuario : BilleteraVirtual.getInstancia().getUsuarios()) {
            if (usuario.consultarCuentas().contains(cuenta)) {
                return usuario;
            }
            else{
                System.out.println("El metodo buscarUsuarioPorCuenta no encontró el usuario propietario de la cuenta.");
            }
        }
        return null;
    }

    /**
     * Metodo que busca un usuario por su numero de cuenta
     * @param numeroCuenta numero de cuenta del usuario
     * @return usuario encontrado o null si no se encuentra
     */
    private Usuario buscarUsuarioPorNumeroCuenta(String numeroCuenta) {
        for (Usuario usuario : BilleteraVirtual.getInstancia().getUsuarios()) {
            for (Cuenta cuenta : usuario.consultarCuentas()) {
                if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                    return usuario;
                }
            }
        }
        return null;
    }


    /**
     * Metodo generico para registrar una transaccion
     * @param transaccion
     */
    private void registrarTransaccion(Transaccion transaccion) {
        // Agregar al sistema
        BilleteraVirtual.getInstancia().getTransacciones().add(transaccion);

        // Buscar y agregar al usuario correspondiente
        if (transaccion.getCuentaOrigen() != null) {
            Usuario usuarioOrigen = buscarUsuarioPorNumeroCuenta(transaccion.getCuentaOrigen());
            if (usuarioOrigen != null) {
                usuarioOrigen.agregarTransaccion(transaccion);
            }
        }

        if (transaccion.getCuentaDestino() != null) {
            Usuario usuarioDestino = buscarUsuarioPorNumeroCuenta(transaccion.getCuentaDestino());
            if (usuarioDestino != null) {
                usuarioDestino.agregarTransaccion(transaccion);
            }
        }

        // Si es una transferencia, agregar a ambos usuarios
        if (transaccion.getTipoTransaccion() == TipoTransaccion.TRANSFERENCIA) {
            // La transacción ya se agregó a ambos usuarios arriba
            System.out.println("Transferencia registrada para ambos usuarios");
        }
    }





    /**
     * Metodo que elimina una transaccion del sistema
    public void agregarObservador(ObservadorTransacciones observador) {
        sujetoNotificaciones.agregarObservador(observador);
    }
     * @param idTransaccion id de la transaccion a eliminar
     * @return true si la transaccion fue eliminada, false en caso contrario
     */
    public void setEstrategiaComision(EstrategiaComision estrategia) {
        calculadoraComisiones.setEstrategia(estrategia);
    }


    /**
     * Configura los observadores por defecto para el sujeto de notificaciones
     */
    private void configurarObservadoresPorDefecto() {
        // Agregar observadores básicos
        sujetoNotificaciones.agregarObservador(new RegistradorAuditoria());
        sujetoNotificaciones.agregarObservador(new ControladorLimites());
    }

    /**
     * Elimina una transacción del sistema y notifica a los observadores
     * @param idTransaccion ID de la transacción a eliminar
     * @return true si la transacción fue eliminada, false en caso contrario
     */
    public List<Transaccion> obtenerTodasTransacciones() {
        return BilleteraVirtual.getInstancia().getTransacciones().stream().toList();
    }


    public void agregarObservador(NotificadorEmail notificadorEmail) {
        if (notificadorEmail != null) {
            sujetoNotificaciones.agregarObservador(notificadorEmail);
        } else {
            System.out.println("No se puede agregar un observador nulo");
        }
    }
}
