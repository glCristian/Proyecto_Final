package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PresupuestoTest {

    private Presupuesto presupuesto;
    private Categoria categoria;

    @BeforeEach
    public void setUp() {
        categoria = new Categoria("C001", "Transporte", "gestionar presupuesto transporte");
        presupuesto = new Presupuesto("P001", "Presupuesto Transporte", 1000.0, 200.0, categoria);
    }


    @Test
    public void testActualizarPresupuesto() {
        presupuesto.actualizarPresupuesto(1200.0);
        assertEquals(1200.0, presupuesto.getMontoAsignado());
    }

    @Test
    public void testAgregarGasto() {
        presupuesto.agregarGasto(300.0);
        assertEquals(500.0, presupuesto.getMontoGastado());
    }

    @Test
    public void testConsultarEstado() {
        String estado = presupuesto.consultarEstado();
        assertTrue(estado.contains("Presupuesto Transporte"));
        assertTrue(estado.contains("1000.0"));
        assertTrue(estado.contains("200.0"));
    }


}