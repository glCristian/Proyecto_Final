package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ComisionEscalonadaTest {

    private ComisionEscalonada comisionEscalonada;
    private Transaccion transaccion;

    @BeforeEach
    void setUp() {
        comisionEscalonada = new ComisionEscalonada();
        transaccion = new Transaccion(
                "T001",
                LocalDateTime.now(),
                0,
                "Descripción test",
                "CuentaOrigen001",
                "CuentaDestino001",
                new Categoria("C001", "Cat Test", "Categoría de prueba"),
                TipoTransaccion.TRANSFERENCIA
        );
    }

    @Test
    void testComisionMontoMenorIgual1000() {
        transaccion.setMonto(1000);
        double comision = comisionEscalonada.calcularComision(transaccion);
        assertEquals(0, comision, 0.001);
    }

    @Test
    void testComisionMontoEntre1001y10000() {
        transaccion.setMonto(5000);
        double comision = comisionEscalonada.calcularComision(transaccion);
        assertEquals(5000 * 0.001, comision, 0.001); // 5.0
    }

    @Test
    void testComisionMontoEntre10001y100000() {
        transaccion.setMonto(20000);
        double comision = comisionEscalonada.calcularComision(transaccion);
        assertEquals(20000 * 0.005, comision, 0.001); // 100.0
    }

    @Test
    void testComisionMontoMayor100000() {
        transaccion.setMonto(200000);
        double comision = comisionEscalonada.calcularComision(transaccion);
        assertEquals(200000 * 0.01, comision, 0.001); // 2000.0
    }

    @Test
    void testNombreEstrategia() {
        assertEquals("Comisión Escalonada", comisionEscalonada.getNombreEstrategia());
    }

}