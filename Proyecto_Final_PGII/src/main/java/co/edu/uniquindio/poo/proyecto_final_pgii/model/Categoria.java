package co.edu.uniquindio.poo.proyecto_final_pgii.model;


public class Categoria {

    private String idCategoria;
    private String nombre;
    private String descripcion;

    /**
     * Constructor de la clase Categoria
     * @param idCategoria
     * @param nombre
     * @param descripcion
     */
    public Categoria(String idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    /**
     * Metodo que obtiene el ID de la Categoria
     * @return
     */
    public String getIdCategoria() {
        return idCategoria;
    }

    /**
     * Metodo que establece el ID de la Categoria
     * @param idCategoria
     */
    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Metodo que obtiene el nombre de la Categoria
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre de la Categoria
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene la descripcion de la Categoria
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo que establece la descripcion de la Categoria
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}