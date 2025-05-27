package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    private Administrador administrador;

    @BeforeEach
    public void setUp() {
        administrador = new Administrador(
                "Juan",
                "Perez",
                "juan.perez@email.com",
                "3001234567",
                "Calle 123",
                "admin01",
                "secreta123"
        );
    }


    @Test
    public void testSetIdAdministrador() {
        administrador.setIdAministrador("admin02");
        assertEquals("admin02", administrador.getIdAministrador());
    }

    @Test
    public void testCrearTransaccionNoLanzaError() {
        // Llamar crearTransaccion y verificar que no lance excepción
        assertDoesNotThrow(() -> administrador.crearTransaccion(
                "tx001",
                1000.0,
                "Pago servicio",
                "cuenta001",
                "cuenta002",
                new Categoria("cat01", "Gastos", "Gastos mensuales"),
                TipoTransaccion.TRANSFERENCIA
        ));
    }

}