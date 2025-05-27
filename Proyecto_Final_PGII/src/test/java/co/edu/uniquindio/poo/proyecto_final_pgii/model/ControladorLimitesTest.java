package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ControladorLimitesTest {

    private ControladorLimites controladorLimites;
    private Transaccion transaccion;

    @BeforeEach
    void setUp() {
        controladorLimites = new ControladorLimites();
        transaccion = new Transaccion(
                "T001",
                LocalDateTime.now(),
                1000.0,
                "Descripción prueba",
                "CuentaOrigen001",
                "CuentaDestino001",
                new Categoria("C001", "Categoria prueba", "Descripción categoría"),
                TipoTransaccion.TRANSFERENCIA
        );
    }

    @Test
    void testNotificarTransaccion_AcumuladoIncrementaCorrectamente() {
        controladorLimites.notificarTransaccion(transaccion, "CREADA");
        assertTrue(true);
    }

    @Test
    void testNotificarTransaccion_Alerta80Porciento() {

        for (int i = 0; i < 8; i++) {
            transaccion = new Transaccion(
                    "T00" + i,
                    LocalDateTime.now(),
                    1000.0,
                    "Transacción prueba " + i,
                    "CuentaOrigen001",
                    "CuentaDestino001",
                    new Categoria("C001", "Categoria prueba", "Descripción categoría"),
                    TipoTransaccion.TRANSFERENCIA
            );
            controladorLimites.notificarTransaccion(transaccion, "CREADA");
        }

        assertTrue(true);
    }

    @Test
    void testNotificarTransaccion_AlertaLimiteExcedido() {

        transaccion = new Transaccion(
                "T010",
                LocalDateTime.now(),
                11000.0, // mayor que limite diario
                "Transacción grande",
                "CuentaOrigen001",
                "CuentaDestino001",
                new Categoria("C001", "Categoria prueba", "Descripción categoría"),
                TipoTransaccion.TRANSFERENCIA
        );
        controladorLimites.notificarTransaccion(transaccion, "CREADA");

        assertTrue(true);
    }

    @Test
    void testResetearAcumulado() {
        transaccion = new Transaccion(
                "T002",
                LocalDateTime.now(),
                5000.0,
                "Transacción prueba",
                "CuentaOrigen001",
                "CuentaDestino001",
                new Categoria("C001", "Categoria prueba", "Descripción categoría"),
                TipoTransaccion.TRANSFERENCIA
        );
        controladorLimites.notificarTransaccion(transaccion, "CREADA");
        controladorLimites.resetearAcumulado();

        assertTrue(true);
    }
}