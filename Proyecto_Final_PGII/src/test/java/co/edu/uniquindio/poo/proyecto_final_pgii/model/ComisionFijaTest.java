package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ComisionFijaTest {

    private ComisionFija comisionFija;
    private Transaccion transaccion;

    @BeforeEach
    void setUp() {
        comisionFija = new ComisionFija(50.0);

        transaccion = new Transaccion(
                "T001",
                LocalDateTime.now(),
                1000.0,
                "Pago prueba",
                "CuentaOrigen001",
                "CuentaDestino001",
                new Categoria("C001", "Categoria prueba", "Descripción categoría"),
                TipoTransaccion.TRANSFERENCIA
        );
    }

    @Test
    void testCalcularComisionSiempreRetornaValorFijo() {
        double comisionCalculada = comisionFija.calcularComision(transaccion);
        assertEquals(50.0, comisionCalculada, 0.001);
    }

    @Test
    void testGetNombreEstrategia() {
        String nombreEsperado = "Comisión Fija: $50.0";
        assertEquals(nombreEsperado, comisionFija.getNombreEstrategia());
    }
}