package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Patron Command, encapsula operaciones como objetos, permitiendo deshacer acciones
 */
public interface Comando {

    void ejecutar();
    void deshacer();
    String getDescripcion();

}
