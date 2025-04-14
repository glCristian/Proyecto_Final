package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BilleteraVirtual {

    private String nombre;
    private Collection<Usuario> listaUsuarios;
    private Usuario usuarioActual; //Uusuario en sesion
    private Administrador administrador;
    private Collection<Notificacion> listaNotificaciones;


    public BilleteraVirtual(String nombre, Administrador administrador) {
        this.nombre = nombre;
        this.listaUsuarios = new LinkedList<>();
        this.usuarioActual = null;
        this.administrador = administrador;
        this.listaNotificaciones = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(Collection<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Collection<Notificacion> getListaNotificaciones() {
        return listaNotificaciones;
    }

    public void setListaNotificaciones(Collection<Notificacion> listaNotificaciones) {
        this.listaNotificaciones = listaNotificaciones;
    }




    public void registrarUsuario(Usuario usuario) {
        boolean existe = false;
        for (Usuario u : listaUsuarios){
            if(u.getIdUsuario().equals(usuario.getIdUsuario())){
                existe = true;
                break;
            }
        }

        if(!existe){
            listaUsuarios.add(usuario);
        }
    }



    public boolean autenticarUsuario(String email, String contrasena) {
        for (Usuario u : listaUsuarios) {
            if (u.getEmail().equals(email) && u.getContrasena().equals(contrasena)) {
                usuarioActual = u;
                return true;
            }
        }
        return false;
    }



    public void cerrarSesion() {
        usuarioActual = null;
    }


    public Collection<Usuario> listarUsuarios() {
        return listaUsuarios;
    }


    public void enviarNotificacion(String mensaje) {
        if (usuarioActual != null) {

            String id = "N" + (listaNotificaciones.size() + 1);

            Date fecha = new Date();

            String tipo = "INFO";

            Notificacion notificacion = new Notificacion(id, mensaje, fecha, tipo);

            listaNotificaciones.add(notificacion);

            usuarioActual.recibirNotificacion(notificacion);
        }
    }


}
