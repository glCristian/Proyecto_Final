package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorComandosTest {

    private GestorComandos gestor;

    @BeforeEach
    void setUp() {
        gestor = GestorComandos.getInstancia();

        // Limpiar historial si tiene comandos (por ser singleton)
        while (gestor.getTamañoHistorial() > 0) {
            gestor.deshacerUltimoComando();
        }
    }

    @Test
    void testEjecutarComando() {
        Comando cmd = new Comando() {
            boolean ejecutado = false;
            @Override
            public void ejecutar() { ejecutado = true; }
            @Override
            public void deshacer() { }
            @Override
            public String getDescripcion() { return "Comando Anónimo 1"; }
            public boolean isEjecutado() { return ejecutado; }
        };

        gestor.ejecutarComando(cmd);
        assertEquals(1, gestor.getTamañoHistorial(), "Historial debe tener 1 comando");

    }

    @Test
    void testDeshacerUltimoComando() {
        final boolean[] deshechoFlag = { false };

        Comando cmd = new Comando() {
            @Override
            public void ejecutar() { }
            @Override
            public void deshacer() { deshechoFlag[0] = true; }
            @Override
            public String getDescripcion() { return "Comando Anónimo 2"; }
        };

        gestor.ejecutarComando(cmd);
        assertEquals(1, gestor.getTamañoHistorial(), "Historial debe tener 1 comando");

        gestor.deshacerUltimoComando();
        assertTrue(deshechoFlag[0], "El comando debe haberse deshecho");
        assertEquals(0, gestor.getTamañoHistorial(), "Historial debe estar vacío luego de deshacer");
    }

    @Test
    void testDeshacerUltimoComando_SinComandos() {
        while (gestor.getTamañoHistorial() > 0) {
            gestor.deshacerUltimoComando();
        }
        gestor.deshacerUltimoComando();
        assertEquals(0, gestor.getTamañoHistorial(), "Historial debe estar vacío");
    }

    @Test
    void testMostrarHistorial() {
        Comando cmd1 = new Comando() {
            @Override
            public void ejecutar() {}
            @Override
            public void deshacer() {}
            @Override
            public String getDescripcion() { return "Comando Anónimo 1"; }
        };

        Comando cmd2 = new Comando() {
            @Override
            public void ejecutar() {}
            @Override
            public void deshacer() {}
            @Override
            public String getDescripcion() { return "Comando Anónimo 2"; }
        };

        gestor.ejecutarComando(cmd1);
        gestor.ejecutarComando(cmd2);

        gestor.mostrarHistorial();

        assertEquals(2, gestor.getTamañoHistorial(), "Historial debe tener 2 comandos");
    }

}