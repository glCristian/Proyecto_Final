package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComandoCrearPresupuestoTest {

    private Usuario usuario;
    private Presupuesto presupuesto;
    private ComandoCrearPresupuesto comando;

    @BeforeEach
    void setUp() {
        // Crear usuario con lista de presupuestos vacía
        usuario = new Usuario("Juan", "Pérez", "juan@email.com", "123", "Calle 1", "90", "09");
        presupuesto = new Presupuesto("8", "viaje", 50000.0, 8000.0, new Categoria("78", "viaje", "viaje a brazil"));
        comando = new ComandoCrearPresupuesto(presupuesto, usuario);
    }

    @Test
    void testEjecutarAgregaPresupuesto() {
        assertTrue(usuario.getListaPresupuestos().isEmpty());
        comando.ejecutar();
        assertTrue(usuario.getListaPresupuestos().contains(presupuesto));
    }

    @Test
    void testDeshacerEliminaPresupuesto() {
        comando.ejecutar();
        assertTrue(usuario.getListaPresupuestos().contains(presupuesto));
        comando.deshacer();
        assertFalse(usuario.getListaPresupuestos().contains(presupuesto));
    }

    @Test
    void testDescripcionCorrecta() {
        String descripcionEsperada = "Crear presupuesto: viaje ($50000.0)";
        assertEquals(descripcionEsperada, comando.getDescripcion());
    }

    @Test
    void testEjecutarNoDuplicaPresupuesto() {
        comando.ejecutar();
        comando.ejecutar(); // No debería volver a agregar
        assertEquals(1, usuario.getListaPresupuestos().size());
    }

    @Test
    void testDeshacerSinEjecutarNoHaceNada() {
        comando.deshacer(); // No fue ejecutado aún
        assertTrue(usuario.getListaPresupuestos().isEmpty());
    }

}