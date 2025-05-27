package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Interfaz que define el Patron Command
 * permite encapsular operaciones como objetos, permitiendo deshacer acciones
 */
public interface Comando {

    /**
     * Ejecuta la accion encapculada por el comando
     */
    void ejecutar();

    /**
     * Deshace la accion previamente ejcuatada por el comando
     */
    void deshacer();

    /**
     * Obtiene una descripcion del comando
     * @return
     */
    String getDescripcion();

}
