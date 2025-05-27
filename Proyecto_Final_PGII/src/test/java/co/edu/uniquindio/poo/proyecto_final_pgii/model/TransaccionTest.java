package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransaccionTest {

    private Transaccion transaccion;
    private Categoria categoria;

    @Test
    public void testActualizarTransaccion() {
        Categoria original = new Categoria("098", "servicios", "destinado a servicios");
        Categoria nueva = new Categoria("098", "Educacion", "destinado a educacion");
        Transaccion transaccion = new Transaccion("id001", LocalDateTime.now(), 50.0,
                "Pago servicios", "001", "002", original, TipoTransaccion.TRANSFERENCIA);

        transaccion.actualizarTransaccion("Pago universidad", 200.0, "003", nueva);

        assertEquals("Pago universidad", transaccion.getDescripcion());
        assertEquals(200.0, transaccion.getMonto());
        assertEquals("003", transaccion.getCuentaDestino());
        assertEquals("Educacion", transaccion.getCategoria().getNombre());
    }

    @Test
    public void testEsValida() {
        Categoria categoria = new Categoria("3", "comida", "cena");
        Transaccion transaccion = new Transaccion("id002", LocalDateTime.now(), 100.0,
                "Descripción", "001", "002", categoria, TipoTransaccion.DEPOSITO);

        assertTrue(transaccion.esValida());

        Transaccion invalida = new Transaccion("id003", LocalDateTime.now(), 0,
                "Descripción", null, null, categoria, null);

        assertFalse(invalida.esValida());
    }

    @Test
    public void testCrearRetiro() {
        Categoria categoria = new Categoria("9", "Pasajes", "Pasajes para llegar a la casa");
        Transaccion retiro = Transaccion.crearRetiro("001", 80.0, "Retiro cajero", categoria);

        assertEquals("001", retiro.getCuentaOrigen());
        assertNull(retiro.getCuentaDestino());
        assertEquals(80.0, retiro.getMonto());
        assertEquals(TipoTransaccion.RETIRO, retiro.getTipoTransaccion());
    }

    @Test
    public void testCrearDeposito() {
        Categoria categoria = new Categoria("098", "Otros", "otros");
        Transaccion deposito = Transaccion.crearDeposito("002", 150.0, "Depósito en cuenta", categoria);

        assertNull(deposito.getCuentaOrigen());
        assertEquals("002", deposito.getCuentaDestino());
        assertEquals(150.0, deposito.getMonto());
        assertEquals(TipoTransaccion.DEPOSITO, deposito.getTipoTransaccion());
    }

    @Test
    public void testCrearTransferencia() {
        Categoria categoria = new Categoria("098", "Pago", "plata");
        Transaccion transferencia = Transaccion.crearTransferencia("001", "002", 250.0, "Pago amigo", categoria);

        assertEquals("001", transferencia.getCuentaOrigen());
        assertEquals("002", transferencia.getCuentaDestino());
        assertEquals(250.0, transferencia.getMonto());
        assertEquals(TipoTransaccion.TRANSFERENCIA, transferencia.getTipoTransaccion());
    }

}