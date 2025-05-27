package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

/**
 * Clase que representa a un usuario del sistema, extiende de persona
 */
public class Usuario extends Persona{

    private String idUsuario;
    private String contrasena;
    private double saldoTotal;
    private Notificacion notificacion;
    private Collection<Transaccion> listaTransacciones;
    private Collection<Cuenta> listaCuentas;
    private Collection<Presupuesto> listaPresupuestos;


    /**
     * Constructor de la clase Usuario
     * @param nombres
     * @param apellidos
     * @param email
     * @param telefono
     * @param direccion
     * @param idUsuario
     *
     */
    public Usuario(String nombres, String apellidos, String email, String telefono, String direccion, String idUsuario, String contrasena) {
        super(nombres, apellidos, email, telefono, direccion);
        this.idUsuario = idUsuario;

        assert contrasena != null : "La contraseña no puede ser nulo";

        this.contrasena = contrasena;
        this.notificacion = notificacion;
        this.listaTransacciones = mostrarTodosLosMovimientos();
        this.listaCuentas = new LinkedList<>();
        this.listaPresupuestos = new LinkedList<>();
        this.saldoTotal = getSaldoTotal();
    }


    /**
     * Metodo que obtiene el ID de un usuario
     * @return
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * Metodo que establece el ID de un usuario
     * @param idUsuario
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public double getSaldoTotal() {
        double total = 0;
        for (Cuenta cuenta : listaCuentas){
            total+= cuenta.getSaldoTotal();
        }
        return total;
    }


    /**
     * Metodo que obtiene una notificacion
     * @return
     */
    public Notificacion getNotificacion() {
        return notificacion;
    }

    /**
     * Metodo que establece una notificacion
     * @param notificacion
     */
    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }



    /**
     * Metodo que obtiene las cuentas
     * @return
     */
    public Collection<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    /**
     * Metodo que establece las cuentas
     * @param listaCuentas
     */
    public void setListaCuentas(Collection<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    /**
     * Metodo que obtiene los presupuestos
     * @return
     */
    public Collection<Presupuesto> getListaPresupuestos() {
        return listaPresupuestos;
    }

    /**
     * Metodo que establece los presupuestos
     * @param listaPresupuestos
     */
    public void setListaPresupuestos(Collection<Presupuesto> listaPresupuestos) {
        this.listaPresupuestos = listaPresupuestos;
    }


    /**
     * Agrega una cuenta a la lista de cuentas del usuario
     * @param cuenta
     */
    public void agregarCuenta(Cuenta cuenta) {
        listaCuentas.add(cuenta);
        System.out.println("Cuenta agregada: " + cuenta.getIdCuenta());
    }

    /**
     * Elimina una cuenta de la lista segun su ID
     * @param idCuenta
     */
    public void eliminarCuenta(String idCuenta) {
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getIdCuenta().equals(idCuenta)) {
                listaCuentas.remove(cuenta);
                System.out.println("Cuenta eliminada");
            }
        }
    }

    /**
     * Consulta y devuelve todas las cuentas del usuario
     * @return
     */
    public Collection<Cuenta> consultarCuentas() {
        return listaCuentas;
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
     * Realiza un deposito de dinero en una cuenta si esta pertence al usuario
     * registra la transaccion en la lista de transacciones
     */
    public boolean agregarDinero(Cuenta cuenta, double monto) {
        if (listaCuentas.contains(cuenta)) {
            cuenta.depositar(monto);

            Transaccion transaccion = new Transaccion(generarIdUnico(), obtenerFechaActual(), monto, "Deposito",
                    null, cuenta.getIdCuenta(), null, TipoTransaccion.DEPOSITO);

            listaTransacciones.add(transaccion);
            System.out.println("Depósito de " + monto + " realizado a la cuenta " + cuenta.getIdCuenta());
            return true;
        } else {
            System.out.println("Cuenta no encontrada.");
            return false;
        }
    }

    /**
     * Retira dinero de una cuenta si hay saldo suficiente
     * registra la transaccion en la lista de transacciones
     */
    public boolean retirarDinero(Cuenta cuenta, double monto) {
        if (cuenta.retirar(monto)) {

            Transaccion transaccion = new Transaccion(generarIdUnico(), obtenerFechaActual(), monto, "Retiro", cuenta.getIdCuenta(),
                    null, null, TipoTransaccion.RETIRO);
            listaTransacciones.add(transaccion);
            System.out.println("Retiro exitoso de la cuenta " + cuenta.getIdCuenta());
            return true;
        } else {
            System.out.println("Saldo insuficiente en la cuenta " + cuenta.getIdCuenta());
            return false;
        }
    }

    /**
     * Tranfiere dinero entre dos cuentas si la cuenta origen tiene saldo suficiente
     * registra la transaccion de transferencia
     * @param cuentaOrigen
     * @param cuentaDestino
     * @param monto
     */
    public void transferirDinero(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto){
        if (cuentaOrigen.retirar(monto)) {
            cuentaDestino.depositar(monto);

            Transaccion transaccion = new Transaccion(generarIdUnico(), obtenerFechaActual(), monto, "Deposito a otra cuenta. ",
                    cuentaOrigen.getIdCuenta(), cuentaDestino.getIdCuenta(), null, TipoTransaccion.TRANSFERENCIA );
            listaTransacciones.add(transaccion);
            System.out.println("Transferencia exitosa de " + monto + " desde " + cuentaOrigen.getIdCuenta() + " hacia " + cuentaDestino.getIdCuenta());
        }

    }

    /**
     * Agrega un presupuesto a la lista de presupuestos del usuario
     * @param presupuesto
     */
    public void agregarPresupuesto(Presupuesto presupuesto){
        listaPresupuestos.add(presupuesto);
        System.out.println("Presupuesto creado: " + presupuesto.getNombre());
    }

    /**
     * Modifica un presupuesto existente identificado por su ID
     * actualiza el monto asignado del presupuesto
     * @param id
     * @param nuevoPresupuesto
     */
    public void modificarPresupuesto(String id, Presupuesto nuevoPresupuesto) {
        for (Presupuesto presupuesto : listaPresupuestos) {
            if (presupuesto.getIdPresupuesto().equals(id)) {
                presupuesto.actualizarPresupuesto(nuevoPresupuesto.getMontoAsignado());
                System.out.println("Presupuesto actualizado: " + nuevoPresupuesto.getNombre());
            }
        }
    }

    /**
     * Elimina un presupuesto de la lista por su ID
     * @param idPresupuesto
     */
    public void eliminarPresupuesto(String idPresupuesto) {
        listaPresupuestos.removeIf(p -> p.getIdPresupuesto().equals(idPresupuesto));
        System.out.println("Presupuesto eliminado.");
    }

    /**
     * Consulta todos los movimientos o transacciones del usuario
     * @return
     */
    public Collection<Transaccion> consultarTransacciones() {
        return listaTransacciones;
    }

    /**
     * Consulta el saldo total disponible sumando el saldo de todas las cuentas del usuario
     * @return
     */
    public double consultarSaldo() {
        double saldoTotal = 0;
        for (Cuenta cuenta : listaCuentas) {
            saldoTotal += cuenta.consultarSaldo();
        }
        return saldoTotal;
    }

    /**
     * Filtra las transacciones del usuario por el tipo de transaccion especificado
     * @param tipo
     * @return
     */
   public LinkedList<Transaccion> fitrarPorTipoTransaccion(TipoTransaccion tipo) {
        return (LinkedList<Transaccion>) listaTransacciones.stream().filter(t -> t.getTipoTransaccion()
                .equals(tipo)).collect(Collectors.toList());
   }

    /**
     * Busca una cuenta dentro de la lista de cuentas del usuario dado un ID
     * @param idCuenta
     * @return
     */
    public Cuenta buscarCuenta(String idCuenta) {
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getIdCuenta().equals(idCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    /**
     * Metodo que obtiene todas las transacciones de todas las cuentas
     * del usuario que actualmente ha iniciado sesion
     * @return (Una Collection con todas las transacciones de todas las cuentas del usuario actual)
     */
   public Collection<Transaccion> mostrarTodosLosMovimientos(){
        Usuario usuario = GestorSesion.getInstancia().getUsuarioActual();
        Collection<Transaccion> todasTransacciones = new LinkedList<>();

        if (usuario != null){
            for(Cuenta cuenta : usuario.getListaCuentas()){
                Collection<Transaccion> transaccionesCuenta = cuenta.getListaTransacciones();
                if (transaccionesCuenta != null){
                    todasTransacciones.addAll(transaccionesCuenta);
                }
            }
        }
        return todasTransacciones;
   }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombres='" + getNombres() + '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                ", cantidadCuentas=" + (listaCuentas != null ? listaCuentas.size() : 0) +
                '}';
    }

}