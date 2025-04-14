package co.edu.uniquindio.poo.proyecto_final_pgii.model;


public class Administrador extends Persona{

    private String idAministrador;
    private Usuario usuario;

    /**
     * Constructor de la clase Administrador
     * @param nombres
     * @param apellidos
     * @param email
     * @param telefono
     * @param direccion
     * @param idAministrador
     * @param usuario
     */
    public Administrador(String nombres, String apellidos, String email, String telefono, String direccion, String idAministrador, Usuario usuario) {
        super(nombres, apellidos, email, telefono, direccion);
        this.idAministrador = idAministrador;
        this.usuario = usuario;
    }


    /**
     * Metodo que obtien el ID del administrador
     * @return
     */
    public String getIdAministrador() {
        return idAministrador;
    }

    /**
     * Metodo que establece el ID del administrador
     * @param idAministrador
     */
    public void setIdAministrador(String idAministrador) {
        this.idAministrador = idAministrador;
    }

    /**
     * Metodo que obtiene el usuario
     * @return
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Metodo que establece el usuario
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public void gestionarUsuarios(){

    }

    public void gestionarCuentas(){

    }

    public void gestionarTransacciones(){

    }
}