package co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;


/**
 * Clase para la gestión de perfiles tanto de usuarrios como de administradores
 */
public class GestorPerfiles {

    private static GestorPerfiles instancia;


    private GestorPerfiles() {
    }

    public static GestorPerfiles getInstancia() {
        if (instancia == null) {
            instancia = new GestorPerfiles();
        }
        return instancia;
    }

    /**
     * Metodo para autenticar un usuario o un admin para que inicie sesion
     * @param email
     * @param contrasena
     * @return boolean
     */
    public boolean autenticar(String email, String contrasena){
        for (Persona persona : BilleteraVirtual.getInstancia().getPerfiles()){

            if (persona instanceof Usuario && ((Usuario) persona).getEmail().equals(email) && ((Usuario) persona).getContrasena().equals(contrasena)){
                GestorSesion.getInstancia().iniciarSesion(persona);
                return true;
            }

            else if (persona instanceof Administrador && ((Administrador) persona).getEmail().equals(email) && ((Administrador) persona).getContrasena().equals(contrasena)){
                GestorSesion.getInstancia().iniciarSesion(persona);
                return true;
            }

        }
        return false;
    }


    /**
     * Metodo para crear un nuevo usuarios y agregarlo a la lista de perfiles
     * @param nombres
     * @param apellidos
     * @param email
     * @param telefono
     * @param direccion
     * @param idUsuario
     * @param contrasena
     */
    public void crearUsuario(String nombres, String apellidos, String email, String telefono,
                             String direccion, String idUsuario, String contrasena) {
        Usuario usuarioNuevo = new Usuario(nombres, apellidos, email, telefono, direccion, idUsuario, contrasena);
        BilleteraVirtual.getInstancia().getPerfiles().add(usuarioNuevo);
    }

    /**
     * Metodo para crear unn nuevo admin y agregarlo a la lista de perfiles
     * @param nombres
     * @param apellidos
     * @param email
     * @param telefono
     * @param direccion
     * @param idAdministrador
     * @param contrasena
     */
    public void crearAdministrador(String nombres, String apellidos, String email, String telefono,
                                   String direccion, String idAdministrador, String contrasena) {
        Administrador adminNuevo = new Administrador(nombres, apellidos, email, telefono, direccion, idAdministrador, contrasena);
        BilleteraVirtual.getInstancia().getPerfiles().add(adminNuevo);
    }

    /**
     * Metodo para elminar un perfil de la lista, ya sea de un usuario o de un admin
     * @param id
     */
    public void eliminarPerfil(String id) {
        BilleteraVirtual.getInstancia().getPerfiles().removeIf(persona -> {
            if (persona instanceof Usuario usuario) {
                return usuario.getIdUsuario().equals(id);
            } else if (persona instanceof Administrador admin) {
                return admin.getIdAministrador().equals(id);
            }
            return false;
        });
    }

    /**
     * Metodo para actualizar un perfil de un usuario
     * @param idUsuario
     * @param nombres
     * @param apellidos
     * @param email
     * @param telefono
     * @param direccion
     * @param contrasena
     */
    public void actualizarUsuario(String idUsuario, String nombres, String apellidos, String email,
                                  String telefono, String direccion, String contrasena) {
        for (Persona persona : BilleteraVirtual.getInstancia().getPerfiles()) {
            if (persona instanceof Usuario usuario && usuario.getIdUsuario().equals(idUsuario)) {
                if (nombres != null && !nombres.isBlank()) usuario.setNombres(nombres);
                if (apellidos != null && !apellidos.isBlank()) usuario.setApellidos(apellidos);
                if (email != null && !email.isBlank()) usuario.setEmail(email);
                if (telefono != null && !telefono.isBlank()) usuario.setTelefono(telefono);
                if (direccion != null && !direccion.isBlank()) usuario.setDireccion(direccion);
                if (contrasena != null && !contrasena.isBlank()) usuario.setContrasena(contrasena);
                break;
            }
        }
    }

    /**
     * Metodo para actualizar un perfil de un admin
     * @param idAdministrador
     * @param nombres
     * @param apellidos
     * @param email
     * @param telefono
     * @param direccion
     */
    public void actualizarAdministrador(String idAdministrador, String nombres, String apellidos,
                                        String email, String telefono, String direccion) {
        for (Persona persona : BilleteraVirtual.getInstancia().getPerfiles()) {
            if (persona instanceof Administrador admin && admin.getIdAministrador().equals(idAdministrador)) {
                if (nombres != null && !nombres.isBlank()) admin.setNombres(nombres);
                if (apellidos != null && !apellidos.isBlank()) admin.setApellidos(apellidos);
                if (email != null && !email.isBlank()) admin.setEmail(email);
                if (telefono != null && !telefono.isBlank()) admin.setTelefono(telefono);
                if (direccion != null && !direccion.isBlank()) admin.setDireccion(direccion);
                break;
            }
        }
    }

    /**
     * Metodo para listar los perfiles de la billetera virtual
     */
    public void listarPerfiles() {
        for (Persona persona : BilleteraVirtual.getInstancia().getPerfiles()) {
            System.out.println(persona);
        }
    }

}
