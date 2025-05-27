package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaTest {

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        categoria = new Categoria("C001", "Servicios", "Gastos de servicios públicos");
    }

    @Test
    void testCrearCategoriaYEliminarCategoria() {
        categoria.crearCategoria("C003", "Educación", "Pagos de matrícula");
        assertTrue(categoria.eliminarCategoria("C003"));
    }

    @Test
    void testEliminarCategoriaInexistente() {
        assertFalse(categoria.eliminarCategoria("C999"));
    }

    @Test
    void testActualizarCategoria() {
        categoria.actualizarCategoria("Entretenimiento", "Suscripciones y ocio");
        assertEquals("Entretenimiento", categoria.getNombre());
        assertEquals("Suscripciones y ocio", categoria.getDescripcion());
    }

    @Test
    void testToStringDevuelveNombre() {
        assertEquals("Servicios", categoria.toString());
    }

}