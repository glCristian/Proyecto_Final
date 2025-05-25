package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Patron builder, permite construir usuario complejos paso a paso
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

    public UsuarioBuilder() {
        this.cuentasIniciales = new ArrayList<>();
        this.presupuestosIniciales = new ArrayList<>();
    }

    public UsuarioBuilder setNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public UsuarioBuilder setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public UsuarioBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public UsuarioBuilder setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public UsuarioBuilder setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioBuilder setContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public UsuarioBuilder agregarCuentaInicial(Cuenta cuenta) {
        this.cuentasIniciales.add(cuenta);
        return this;
    }

    public UsuarioBuilder agregarPresupuestoInicial(Presupuesto presupuesto) {
        this.presupuestosIniciales.add(presupuesto);
        return this;
    }

    public UsuarioBuilder setNotificacionBienvenida(Notificacion notificacion) {
        this.notificacionBienvenida = notificacion;
        return this;
    }

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
