package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa el patron builder para construir objetos usuasari
 * compeljos paso a paso
 */
public class UsuarioBuilder {

    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private String direccion;
    private String idUsuario;
    private String contrasena;
    private List<Cuenta> cuentasIniciales;
    private List<Presupuesto> presupuestosIniciales;
    private Notificacion notificacionBienvenida;

    /**
     * Constructor de la clase UsuarioBuilder
     */
    public UsuarioBuilder() {
        this.cuentasIniciales = new ArrayList<>();
        this.presupuestosIniciales = new ArrayList<>();
    }

    /**
     * Metodo que establece los nombres del usuario
     * @param nombres
     * @return
     */
    public UsuarioBuilder setNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    /**
     * Metodo que establece los apellidos del usuario
     * @param apellidos
     * @return
     */
    public UsuarioBuilder setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    /**
     * Metodo que establece el email del usuario
     * @param email
     * @return
     */
    public UsuarioBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Metodo que establece el telefono del usuario
     * @param telefono
     * @return
     */
    public UsuarioBuilder setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    /**
     * Metodo que establece la direccion del usuario
     * @param direccion
     * @return
     */
    public UsuarioBuilder setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    /**
     * Metodo que establece el ID del usuario
     * @param idUsuario
     * @return
     */
    public UsuarioBuilder setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    /**
     * Metodo que establece la contraseña del usuario
     * @param contrasena
     * @return
     */
    public UsuarioBuilder setContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    /**
     * Agrega una cuenta inicial que sera asociada al usuario cuendo se constrya
     * @param cuenta
     * @return
     */
    public UsuarioBuilder agregarCuentaInicial(Cuenta cuenta) {
        this.cuentasIniciales.add(cuenta);
        return this;
    }

    /**
     * Agrega un presupuesto inicial que sera asociado al usuario cuando se construya
     * @param presupuesto
     * @return
     */
    public UsuarioBuilder agregarPresupuestoInicial(Presupuesto presupuesto) {
        this.presupuestosIniciales.add(presupuesto);
        return this;
    }

    /**
     * Establece la notificacion de bienvenida que se asiganra al usuario creado
     * @param notificacion
     * @return
     */
    public UsuarioBuilder setNotificacionBienvenida(Notificacion notificacion) {
        this.notificacionBienvenida = notificacion;
        return this;
    }

    /**
     * Construye y retorna un objeto USUARIO con los atributos y listas configuradas
     * realiza validaciones para asegurarse que los campos obligatorios esten completos
     * @return
     */
    public Usuario build() {
        // Validaciones
        if (nombres == null || apellidos == null || email == null ||
                telefono == null || direccion == null || idUsuario == null || contrasena == null) {
            throw new IllegalStateException("Faltan campos obligatorios para crear el usuario");
        }

        Usuario usuario = new Usuario(nombres, apellidos, email, telefono, direccion, idUsuario, contrasena);

        // Agregar cuentas iniciales
        for (Cuenta cuenta : cuentasIniciales) {
            usuario.agregarCuenta(cuenta);
        }

        // Agregar presupuestos iniciales
        for (Presupuesto presupuesto : presupuestosIniciales) {
            usuario.getListaPresupuestos().add(presupuesto);
        }

        // Configurar notificación de bienvenida
        if (notificacionBienvenida != null) {
            usuario.setNotificacion(notificacionBienvenida);
        }

        return usuario;
    }

}
