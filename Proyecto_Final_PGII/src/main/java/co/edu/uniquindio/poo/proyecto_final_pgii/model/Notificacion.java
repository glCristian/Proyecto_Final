package co.edu.uniquindio.poo.proyecto_final_pgii.model;


public class Notificacion {

    private String idNotificacion;
    private String mensaje;
    private String fecha;
    private String tipo;

    /**
     * Constructor de la clase Notificacion
     * @param idNotificacion
     * @param mensaje
     * @param fecha
     * @param tipo
     */
    public Notificacion(String idNotificacion, String mensaje, String fecha, String tipo) {
        this.idNotificacion = idNotificacion;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.tipo = tipo;
    }


    /**
     * Metodo que obtiene el ID de una notificacion
     * @return
     */
    public String getIdNotificacion() {
        return idNotificacion;
    }

    /**
     * Metodo que establece el ID de una notificacion
     * @param idNotificacion
     */
    public void setIdNotificacion(String idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    /**
     * Metodo que obtiene el mensaje de una notificacion
     * @return
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Metodo que establece el mensaje de una notificacion
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Metodo que obtiene la fecha de una notificacion
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Metodo que establece la fecha de una notificacion
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Metodo que obtiene el tipo de notificacion
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo que establece el tipo de notificacion
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
