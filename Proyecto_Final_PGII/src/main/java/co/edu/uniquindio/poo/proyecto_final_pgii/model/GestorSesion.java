package co.edu.uniquindio.poo.proyecto_final_pgii.model;

public class GestorSesion {

    private static GestorSesion instancia;
    private Persona perfilActual;

    /**
     * Constructor privado para evitar instanciación directa.
     */
    private GestorSesion() {
    }

    /**
     * Devuelve la instancia única del GestorSesion.
     */
    public static GestorSesion getInstancia() {
        if (instancia == null) {
            instancia = new GestorSesion();
        }
        return instancia;
    }

    /**
     * Inicia la sesión con el usuario dado.
     */
    public void iniciarSesion(Persona persona) {
        this.perfilActual = persona;
    }

    /**
     * Retorna el usuario actualmente en sesión.
     */
    public Persona getPerfilActual() {
        return perfilActual;
    }

    /**
     * Cierra la sesión actual.
     */
    public void cerrarSesion() {
        perfilActual = null;
    }

    /**
     * Verifica si hay una sesión activa.
     */
    public boolean haySesionActiva() {
        return perfilActual != null;
    }


    /**
     * Verifica si el perfil actual es un usuario.
     */
    public boolean esUsuario() {
        return perfilActual instanceof Usuario;
    }

    /**
     * Verifica si el perfil actual es un administrador.
     */
    public boolean esAdministrador() {
        return perfilActual instanceof Administrador;
    }

    /**
     * Devuelve un usuario si el perfil actual es un usuario.
     */
    public Usuario getUsuarioActual() {
        if (perfilActual instanceof Usuario) {
            return (Usuario) perfilActual;
        }
        return null;
    }

    /**
     * Devuelve un admin si el perfil actual es un admin.
     */
    public Administrador getAdministradorActual() {
        if (perfilActual instanceof Administrador) {
            return (Administrador) perfilActual;
        }
        return null;
    }

}
