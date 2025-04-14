package co.edu.uniquindio.poo.proyecto_final_pgii.model;


import java.util.Collection;
import java.util.LinkedList;

public class Usuario extends Persona{

    private String idUsuario;
    private String contrasena;
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
    public Usuario(String nombres, String apellidos, String email, String telefono, String direccion, String idUsuario, String contrasena, Administrador administrador, Notificacion notificacion) {
        super(nombres, apellidos, email, telefono, direccion);
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
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




    public void modificarPerfil(String nombres, String apellidos, String email, String telefono, String direccion) {
        super.setNombres(nombres);
        super.setApellidos(apellidos);
        super.setEmail(email);
        super.setTelefono(telefono);
        super.setDireccion(direccion);
    }


    public void agregarCuenta(Cuenta cuenta) {
        listaCuentas.add(cuenta);
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


    public void agregarDinero(double monto) {
    }


    public boolean retirarDinero(double monto) {
    }

}