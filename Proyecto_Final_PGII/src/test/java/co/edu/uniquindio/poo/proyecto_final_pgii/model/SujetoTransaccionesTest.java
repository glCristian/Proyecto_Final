package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SujetoTransaccionesTest {

    private SujetoTransacciones sujeto;
    private MockObservador observador;
    private Transaccion transaccion;

    static class MockObservador implements ObservadorTransacciones {
        boolean notificado = false;
        Transaccion transaccionRecibida = null;
        String tipoEventoRecibido = null;

        @Override
        public void notificarTransaccion(Transaccion transaccion, String tipoEvento) {
            this.notificado = true;
            this.transaccionRecibida = transaccion;
            this.tipoEventoRecibido = tipoEvento;
        }
    }

    @BeforeEach
    void setUp() {
        sujeto = new SujetoTransacciones();
        observador = new MockObservador();
        transaccion = null; // Puedes crear un mock o instancia real si es necesario
    }

    @Test
    void agregarObservadorRecibeNotificacion() {
        sujeto.agregarObservador(observador);
        sujeto.notificarObservadores(transaccion, "CREADA");
        assertTrue(observador.notificado);
        assertEquals(transaccion, observador.transaccionRecibida);
        assertEquals("CREADA", observador.tipoEventoRecibido);
    }

    @Test
    void removerObservadorNoRecibeNotificacion() {
        sujeto.agregarObservador(observador);
        sujeto.removerObservador(observador);
        sujeto.notificarObservadores(transaccion, "ELIMINADA");
        assertFalse(observador.notificado);
    }
}