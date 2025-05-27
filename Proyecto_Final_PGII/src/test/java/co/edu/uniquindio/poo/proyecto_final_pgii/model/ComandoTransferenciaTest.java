package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComandoTransferenciaTest {

    private ComandoTransferencia comandoTransferencia;


    @Test
    void testEjecutarYDeshacerCuentaNoEncontrada() {
        Categoria categoria = new Categoria("001", "Servicios", "Pago de servicios");
        ComandoTransferencia comando = new ComandoTransferencia(
                "CUENTA-1", "CUENTA-2", 200.0, "Pago luz", categoria);

        // Ejecutar la transferencia
        comando.ejecutar();

        comando.ejecutar(); // Ejecutar 2 veces seguidas no debe cambiar nada (sin excepción)

        // Deshacer la transferencia
        comando.deshacer();
        comando.deshacer();
    }

    @Test
    void testDescripcion() {
        Categoria categoria = new Categoria("001", "Servicios", "Pago de servicios");
        ComandoTransferencia comando = new ComandoTransferencia(
                "CUENTA-1", "CUENTA-2", 200.0, "Pago luz", categoria);

        String esperado = "Transferencia de $200.0 de CUENTA-1 a CUENTA-2";
        assertEquals(esperado, comando.getDescripcion());
    }

}