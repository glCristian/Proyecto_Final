package co.edu.uniquindio.poo.proyectofinal_pgii.model;

public class Persona {

    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private String direccion;

    /**
     * Constructor de la clase Persona
     * @param nombres
     * @param apellidos
     * @param email
     * @param telefono
     * @param direccion
     */
    public Persona(String nombres, String apellidos, String email, String telefono, String direccion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }


    /**
     * Metodo que obtiene los nombres de una persona
     * @return
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Metodo que establece los nombres de una persona
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Metodo que obtiene los apellidos de una persona
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Metodo que establece los apellidos de una persona
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Metodo que obtiene el correo de una persona
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo que establece el correo de una persona
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo que obtiene el telefono de una persona
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo que establece el telefono de una persona
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo que obtiene la direccion de una persona
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo que establece la direccion de una persona
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
