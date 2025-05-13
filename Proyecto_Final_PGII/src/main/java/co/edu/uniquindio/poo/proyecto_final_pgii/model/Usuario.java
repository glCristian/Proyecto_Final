package co.edu.uniquindio.poo.proyecto_final_pgii.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class Usuario extends Persona{

    private String idUsuario;
    private String contrasena;
    private double saldoTotal;
    private Notificacion notificacion;
    private Collection<Movimiento> listaMovimientos;
    private Collection<Cuenta> listaCuentas;
    private Collection<Presupuesto> listaPresupuestos;
    private Collection<Transaccion> listaTransacciones;

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
        this.contrasena = contrasena;
        this.notificacion = notificacion;
        this.listaMovimientos = new LinkedList<>();
        this.listaCuentas = new LinkedList<>();
        this.listaPresupuestos = new LinkedList<>();
        this.listaTransacciones = new LinkedList<>();
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

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
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
     * Metodo que obtiene los movimientos
     * @return
     */
    public Collection<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    /**
     * Metodo que establece los movimientos
     * @param listaMovimientos
     */
    public void setListaMovimientos(Collection<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
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
     * Metodo que obtiene las transacciones
     * @return
     */
    public Collection<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    /**
     * Metodo que establece las transacciones
     * @param listaTransacciones
     */
    public void setListaTransacciones(Collection<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }




    public void agregarCuenta(Cuenta cuenta) {
        listaCuentas.add(cuenta);
        System.out.println("Cuenta agregada: " + cuenta.getIdCuenta());
    }

    public boolean eliminarCuenta(String idCuenta) {
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getIdCuenta().equals(idCuenta)) {
                listaCuentas.remove(cuenta);
                return true;
            }
        }
        return false;
    }



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


    public void transferirDinero(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto){
        if (cuentaOrigen.retirar(monto)) {
            cuentaDestino.depositar(monto);

            Transaccion transaccion = new Transaccion(generarIdUnico(), obtenerFechaActual(), monto, "Deposito a otra cuenta. ",
                    cuentaOrigen.getIdCuenta(), cuentaDestino.getIdCuenta(), null, TipoTransaccion.TRANSFERENCIA );
            listaTransacciones.add(transaccion);
            System.out.println("Transferencia exitosa de " + monto + " desde " + cuentaOrigen.getIdCuenta() + " hacia " + cuentaDestino.getIdCuenta());
        }

    }

    public void crearPresupuesto(Presupuesto presupuesto){
        listaPresupuestos.add(presupuesto);
        System.out.println("Presupuesto creado: " + presupuesto.getNombre());
    }


    public void modificarPresupuesto(String id, Presupuesto nuevoPresupuesto) {
        for (Presupuesto presupuesto : listaPresupuestos) {
            if (presupuesto.getIdPresupuesto().equals(id)) {
                presupuesto.actualizarPresupuesto(nuevoPresupuesto.getMontoAsignado());
                System.out.println("Presupuesto actualizado: " + nuevoPresupuesto.getNombre());
            }
        }
    }


    public void eliminarPresupuesto(String idPresupuesto) {
        listaPresupuestos.removeIf(p -> p.getIdPresupuesto().equals(idPresupuesto));
        System.out.println("Presupuesto eliminado.");
    }



    public Collection<Transaccion> consultarTransacciones() {
        return listaTransacciones;
    }

    public double consultarSaldo() {
        double saldoTotal = 0;
        for (Cuenta cuenta : listaCuentas) {
            saldoTotal += cuenta.consultarSaldo();
        }
        return saldoTotal;
    }

   public LinkedList<Transaccion> fitrarPorTipoTransaccion(TipoTransaccion tipo) {
        return (LinkedList<Transaccion>) listaTransacciones.stream().filter(t -> t.getTipoTransaccion()
                .equals(tipo)).collect(Collectors.toList());
   }

}