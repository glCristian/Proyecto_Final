package co.edu.uniquindio.poo.proyecto_final_pgii.model;


import java.time.LocalDateTime;

public class Administrador extends Persona{

    private String contrasena;
    private String idAministrador;



    /**
     * Constructor de la clase Administrador
     * @param nombres
     * @param apellidos
     * @param email
     * @param telefono
     * @param direccion
     * @param idAministrador
     */
    public Administrador(String nombres, String apellidos, String email, String telefono, String direccion, String idAministrador, String contrasena) {
        super(nombres, apellidos, email, telefono, direccion);
        this.contrasena = contrasena;
        this.idAministrador = idAministrador;
    }

    public String getContrasena() {
        return contrasena;
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





    //-------------------------------------Gestion de transacciones------------------//

    public void crearTransaccion(String idTransaccion,
                                 double monto, String descripcion, String cuentaOrigen,
                                 String cuentaDestino, Categoria categoria, TipoTransaccion tipoTransaccion){
        Transaccion transaccionNueva = new Transaccion(idTransaccion, LocalDateTime.now(), monto, descripcion,
                cuentaOrigen, cuentaDestino, categoria, tipoTransaccion );

    }

//    public void listarTransaccion(){
//        billeteraVirtual.getTransacciones();
//    }



}