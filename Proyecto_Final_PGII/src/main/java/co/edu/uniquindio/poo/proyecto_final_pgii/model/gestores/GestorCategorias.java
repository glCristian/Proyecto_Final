package co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.Categoria;
import java.util.Collection;
import java.util.LinkedList;
import java.util.UUID;

public class GestorCategorias {
    private static GestorCategorias instancia;
    private Collection<Categoria> categoriasPredefinidas;

    private GestorCategorias() {
        categoriasPredefinidas = new LinkedList<>();
        inicializarCategoriasPredefinidas();
    }

    public static GestorCategorias getInstancia() {
        if (instancia == null) {
            instancia = new GestorCategorias();
        }
        return instancia;
    }



    /**
     * Inicializa las categorías predefinidas para gastos, ingresos y transferencias.
     */
    private void inicializarCategoriasPredefinidas() {
        // Categorías para gastos
        agregarCategoriaPredefinida("Alimentación", "Gastos relacionados con comida y bebida");
        agregarCategoriaPredefinida("Transporte", "Gastos de movilidad y combustible");
        agregarCategoriaPredefinida("Entretenimiento", "Gastos en ocio y diversión");
        agregarCategoriaPredefinida("Servicios", "Pagos de servicios públicos y suscripciones");
        agregarCategoriaPredefinida("Salud", "Gastos médicos y medicamentos");

        // Categorías para ingresos
        agregarCategoriaPredefinida("Salario", "Ingresos por trabajo");
        agregarCategoriaPredefinida("Inversiones", "Rendimientos financieros");
        agregarCategoriaPredefinida("Ventas", "Ingresos por ventas personales");

        // Categorías para transferencias
        agregarCategoriaPredefinida("Transferencia Personal", "Entre cuentas propias");
        agregarCategoriaPredefinida("Pago de Deudas", "Pagos a terceros");
        agregarCategoriaPredefinida("Otros", "Categoría general para otros movimientos");
    }

    /**
     * Agrega una categoría predefinida a la colección.
     *
     * @param nombre      Nombre de la categoría.
     * @param descripcion Descripción de la categoría.
     */
    private void agregarCategoriaPredefinida(String nombre, String descripcion) {
        categoriasPredefinidas.add(new Categoria(
                UUID.randomUUID().toString(),
                nombre,
                descripcion
        ));
    }

    /**
     * Obtiene todas las categorías predefinidas.
     *
     * @return Colección de categorías predefinidas.
     */
    public Collection<Categoria> obtenerCategoriasPredefinidas() {
        return new LinkedList<>(categoriasPredefinidas);
    }

    /**
     * Obtiene una categoría por su nombre.
     *
     * @param nombre Nombre de la categoría a buscar.
     * @return La categoría encontrada o null si no existe.
     */
    public Categoria obtenerCategoriaPorNombre(String nombre) {
        return categoriasPredefinidas.stream()
                .filter(c -> c.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }
}