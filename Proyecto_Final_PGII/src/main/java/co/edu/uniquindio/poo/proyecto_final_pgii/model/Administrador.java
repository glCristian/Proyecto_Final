package co.edu.uniquindio.poo.proyecto_final_pgii.model;


import java.time.LocalDateTime;

public class Administrador extends Persona{

    private String idAministrador;
    private BilleteraVirtual billeteraVirtual;


    /**
     * Constructor de la clase Administrador
     * @param nombres
     * @param apellidos
     * @param email
     * @param telefono
     * @param direccion
     * @param idAministrador
     */
    public Administrador(String nombres, String apellidos, String email, String telefono, String direccion, String idAministrador) {
        super(nombres, apellidos, email, telefono, direccion);
        this.idAministrador = idAministrador;
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


    //------------------------------ Gestion de usuarios-----------------------------//


    public void crearUsuario(String nombres, String apellidos, String email, String telefono,
                             String direccion, String idUsuario, String contrasena){
        Usuario usuarioNuevo = new Usuario(nombres, apellidos, email, telefono, direccion,
                idUsuario, contrasena);
        billeteraVirtual.getUsuarios().add(usuarioNuevo);
    }

    public void eliminarUsuario(String idUsuario){
        for (Usuario usuario : billeteraVirtual.getUsuarios()) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                billeteraVirtual.getUsuarios().remove(usuario);
            }
        }
    }

    public void listarUsuarios(){
        billeteraVirtual.getUsuarios();
    }





    //--------------------------------Gestion de cuentas-----------------------------//
    public void agregarCuenta(String idCuenta, String nombreBanco, String numeroCuenta,
                               double saldoTotal, TipoCuenta tipoCuenta, Usuario usuario){
        Cuenta cuentanueva = new Cuenta(idCuenta, nombreBanco, numeroCuenta, saldoTotal, tipoCuenta);
        billeteraVirtual.getCuentas().add(cuentanueva);
        usuario.agregarCuenta(cuentanueva);
    }

    public void eliminarCuenta(String idCuenta,Usuario usuario){
        for (Cuenta cuenta : billeteraVirtual.getCuentas()) {
            if (cuenta.getIdCuenta().equals(idCuenta)) {
                billeteraVirtual.getCuentas().remove(cuenta);
                usuario.eliminarCuenta(idCuenta);
            }
        }
    }


    //-------------------------------------Gestion de transacciones------------------//

    public void crearTransaccion(String idTransaccion,
                                 double monto, String descripcion, String cuentaOrigen,
                                 String cuentaDestino, Categoria categoria, TipoTransaccion tipoTransaccion){
        Transaccion transaccionNueva = new Transaccion(idTransaccion, LocalDateTime.now(), monto, descripcion,
                cuentaOrigen, cuentaDestino, categoria, tipoTransaccion );

    }

    public void listarTransaccion(){
        billeteraVirtual.getTransacciones();
    }



}