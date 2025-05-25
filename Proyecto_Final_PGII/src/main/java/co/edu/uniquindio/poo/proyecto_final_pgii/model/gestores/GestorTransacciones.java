package co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class GestorTransacciones {

    private static GestorTransacciones instancia;
    private SujetoTransacciones sujetoNotificaciones;
    private CalculadoraComisiones calculadoraComisiones;

    private GestorTransacciones() {
        super();
        this.sujetoNotificaciones = new SujetoTransacciones();
        this.calculadoraComisiones = new CalculadoraComisiones(new SinComision());

        // Configurar observadores por defecto
        configurarObservadoresPorDefecto();
    }



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
                        cuenta.depositar(monto); // deposita el monto a la cuenta
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
     * Realiza un deposito a una cuenta, genera la transaccion y la registra
     * @param idCuentaDestino
     * @param monto
     * @param descripcion
     * @param categoria
     * @return
     */
    public boolean realizarDeposito(String idCuentaDestino, double monto, String descripcion, Categoria categoria) {
        if (depositarDinero(idCuentaDestino, monto)) {
            Transaccion t = Transaccion.crearDeposito(idCuentaDestino, monto, descripcion, categoria);
            registrarTransaccion(t);
            return true;
        }
        return false;
    }


    /**
     * Realiza un retiro de una cuenta, genera la transaccion y la registra
     * @param idCuentaOrigen
     * @param monto
     * @param descripcion
     * @param categoria
     * @return
     */
    public boolean realizarRetiro(String idCuentaOrigen, double monto, String descripcion, Categoria categoria) {
        if (retirarDinero(idCuentaOrigen, monto)) {
            Transaccion t = Transaccion.crearRetiro(idCuentaOrigen, monto, descripcion, categoria);
            registrarTransaccion(t);
            return true;
        }
        return false;
    }


    /**
     * Metodo generico para resgitrar una transaccion
     * @param transaccion
     */
    private void registrarTransaccion(Transaccion transaccion) {
        if (transaccion == null) return;

        // Añadir a la cuenta origen si es necesario
        if (transaccion.getCuentaOrigen() != null) {
            Cuenta cuentaOrigen = buscarCuentaPorId(transaccion.getCuentaOrigen());
            if (cuentaOrigen != null) {
                cuentaOrigen.getListaTransacciones().add(transaccion);
            }
        }

        // Añadir a la cuenta destino si es necesario y es distinta a la de origen
        if (transaccion.getCuentaDestino() != null && !transaccion.getCuentaDestino().equals(transaccion.getCuentaOrigen())) {
            Cuenta cuentaDestino = buscarCuentaPorId(transaccion.getCuentaDestino());
            if (cuentaDestino != null) {
                cuentaDestino.getListaTransacciones().add(transaccion);
            }
        }

        BilleteraVirtual.getInstancia().getTransacciones().add(transaccion);
    }








    public boolean realizarTransferencia(String idCuentaOrigen, String idCuentaDestino,
                                         double monto, String descripcion, Categoria categoria) {

        // Realizar la transferencia original
        boolean exito = realizarTransferencia(idCuentaOrigen, idCuentaDestino, monto, descripcion, categoria);

        if (exito) {
            // Crear transacción para notificaciones
            Transaccion transaccion = Transaccion.crearTransferencia(
                    idCuentaOrigen, idCuentaDestino, monto, descripcion, categoria);

            // Calcular comisión
            double comision = calculadoraComisiones.calcular(transaccion);
            if (comision > 0) {
                System.out.println(" Comisión aplicada: $" + comision +
                        " (" + calculadoraComisiones.getEstrategiaActual() + ")");
            }

            // Notificar a observadores
            sujetoNotificaciones.notificarObservadores(transaccion, "TRANSFERENCIA_COMPLETADA");
        }

        return exito;
    }


    public void agregarObservador(ObservadorTransacciones observador) {
        sujetoNotificaciones.agregarObservador(observador);
    }

    public void setEstrategiaComision(EstrategiaComision estrategia) {
        calculadoraComisiones.setEstrategia(estrategia);
    }

    private void configurarObservadoresPorDefecto() {
        // Agregar observadores básicos
        sujetoNotificaciones.agregarObservador(new RegistradorAuditoria());
        sujetoNotificaciones.agregarObservador(new ControladorLimites());
    }


}
