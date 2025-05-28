package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransaccionEncriptadaTest {

    static class CategoriaDummy extends Categoria {
        public CategoriaDummy() {
            super("TestCategoria", "TestCategoria", "TestCategoria");
        }
    }

    private TransaccionEncriptada transaccionEncriptada;

    @BeforeEach
    void setUp() {
        Transaccion transaccion = new Transaccion(
                "abc12345",
                LocalDateTime.now(),
                100.0,
                "Test",
                "origen",
                "destino",
                new CategoriaDummy(),
                TipoTransaccion.RETIRO
        );
        transaccionEncriptada = new TransaccionEncriptada(transaccion);
    }

    @Test
    void inicialmenteNoEstaEncriptada() {
        assertFalse(transaccionEncriptada.isEncriptada());
    }

    @Test
    void encriptarMarcaComoEncriptada() {
        transaccionEncriptada.encriptar();
        assertTrue(transaccionEncriptada.isEncriptada());
    }

    @Test
    void desencriptarMarcaComoNoEncriptada() {
        transaccionEncriptada.encriptar();
        transaccionEncriptada.desencriptar();
        assertFalse(transaccionEncriptada.isEncriptada());
    }

    @Test
    void mostrarTransaccionNoLanzaExcepcion() {
        assertDoesNotThrow(() -> transaccionEncriptada.mostrarTransaccion());
        transaccionEncriptada.encriptar();
        assertDoesNotThrow(() -> transaccionEncriptada.mostrarTransaccion());
    }
}