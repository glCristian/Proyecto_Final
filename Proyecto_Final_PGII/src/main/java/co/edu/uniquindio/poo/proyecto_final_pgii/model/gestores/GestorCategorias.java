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

    private void agregarCategoriaPredefinida(String nombre, String descripcion) {
        categoriasPredefinidas.add(new Categoria(
                UUID.randomUUID().toString(),
                nombre,
                descripcion
        ));
    }

    public Collection<Categoria> obtenerCategoriasPredefinidas() {
        return new LinkedList<>(categoriasPredefinidas);
    }

    public Categoria obtenerCategoriaPorNombre(String nombre) {
        return categoriasPredefinidas.stream()
                .filter(c -> c.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }
}