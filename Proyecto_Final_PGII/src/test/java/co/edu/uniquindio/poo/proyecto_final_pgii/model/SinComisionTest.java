package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SinComisionTest {

    @Test
    void calcularComisionSiempreRetornaCero() {
        SinComision sinComision = new SinComision();
        Transaccion transaccion = null;
        double comision = sinComision.calcularComision(transaccion);
        assertEquals(0.0, comision, 0.0001, "La comisión debe ser 0.0");
    }

    @Test
    void getNombreEstrategiaRetornaSinComision() {
        SinComision sinComision = new SinComision();
        assertEquals("Sin Comisión", sinComision.getNombreEstrategia());
    }
}