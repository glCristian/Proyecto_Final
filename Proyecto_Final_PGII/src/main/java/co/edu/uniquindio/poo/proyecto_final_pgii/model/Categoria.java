package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Clase que represenra una categoria
 */
public class Categoria {

    private String idCategoria;
    private String nombre;
    private String descripcion;

    private Collection<Categoria> listaCategorias = new LinkedList<>();

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


    /**
     * Metodo que crea una nueva categoria y la agrega a la lista interna
     * @param idCategoria
     * @param nombre
     * @param descripcion
     */
    public void crearCategoria(String idCategoria, String nombre, String descripcion) {
        Categoria nuevaCategoria = new Categoria(idCategoria, nombre, descripcion);
        listaCategorias.add(nuevaCategoria);
        System.out.println("Se ha creado una nueva categoría con id " + idCategoria);
    }


    /**
     * Metodo que actualiza el nombre y la descripcion de la categoria actual
     * @param nombre
     * @param descripcion
     */
    public void actualizarCategoria(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        System.out.println("Categoría actualizada: " + nombre);
    }


    /**
     * Metodo que elimina una categoria de la lista interna segun su ID
     * @param idCategoria
     * @return
     */
    public boolean eliminarCategoria(String idCategoria) {
        for (Categoria categoria : listaCategorias) {
            if (categoria.getIdCategoria().equals(idCategoria)) {
                listaCategorias.remove(categoria);
                System.out.println("La categoría con id " + idCategoria + " ha sido eliminada.");
                return true;
            }
        }
        System.out.println("No se encontró una categoría con id " + idCategoria);
        return false;
    }

    /**
     * representacion en string de la categoria, que devuelve su nombre
     * @return
     */
    @Override
    public String toString() {
        return nombre;
    }
}