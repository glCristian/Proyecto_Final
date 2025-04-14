package co.edu.uniquindio.poo.proyecto_final_pgii.model;


import java.util.Collection;
import java.util.LinkedList;

public class Usuario extends Persona{

    private String idUsuario;
    private String contrasena;
    private double saldoTotal;
    private Administrador administrador;
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
     * @param administrador
     * @param notificacion
     */
    public Usuario(String nombres, String apellidos, String email, String telefono, String direccion, String idUsuario, String contrasena, double saldoTotal, Administrador administrador, Notificacion notificacion) {
        super(nombres, apellidos, email, telefono, direccion);
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.saldoTotal = 0;
        this.administrador = administrador;
        this.notificacion = notificacion;
        this.listaMovimientos = new LinkedList<>();
        this.listaCuentas = new LinkedList<>();
        this.listaPresupuestos = new LinkedList<>();
        this.listaTransacciones = new LinkedList<>();
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
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    /**
     * Metodo que obtiene el administrador
     * @return
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * Metodo que establece el administrador
     * @param administrador
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
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


    public boolean agregarDinero(Cuenta cuenta, double monto) {
        if (listaCuentas.contains(cuenta)) {
            cuenta.depositar(monto);

            Transaccion transaccion = new Transaccion("Depósito", monto, null, cuenta);
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

            Transaccion transaccion = new Transaccion("Retiro", monto, cuenta, null);
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

            Transaccion transaccion = new Transaccion("Transferencia", monto, cuentaOrigen, cuentaDestino);
            listaTransacciones.add(transaccion);
            System.out.println("Transferencia exitosa de " + monto + " desde " + cuentaOrigen.getIdCuenta() + " hacia " + cuentaDestino.getIdCuenta());
            return true;
        }
        return false;
    }

    public void crearPresupuesto(Presupuesto presupuesto){
        listaPresupuestos.add(presupuesto);
        System.out.println("Presupuesto creado: " + presupuesto.getNombre());
    }


    public void modificarPresupuesto(String id, Presupuesto nuevoPresupuesto) {
        for (Presupuesto presupuesto : listaPresupuestos) {
            if (presupuesto.getIdPresupuesto().equals(id)) {
                presupuesto.actualizar(nuevoPresupuesto.getMontoAsignado());
                System.out.println("Presupuesto actualizado: " + nuevoPresupuesto.getNombre());
            }
        }
    }


    public void eliminarPresupuesto(String idPresupuesto) {
        listaPresupuestos.removeIf(p -> p.getIdPresupuesto().equals(p.getIdPresupuesto()));
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

}