package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    private Cuenta cuenta;

    @BeforeEach
    public void setUp() {
        cuenta = new Cuenta("C001", "Banco de Prueba", "1234567890", TipoCuenta.AHORRO);
    }


    @Test
    public void testDepositarMontoValido() {
        cuenta.depositar(1000.0);
        assertEquals(1000.0, cuenta.getSaldoTotal());
    }

    @Test
    public void testDepositarMontoInvalido() {
        cuenta.depositar(-100.0);
        // saldo no debe cambiar
        assertEquals(0.0, cuenta.getSaldoTotal());
    }

    @Test
    public void testRetirarMontoConSaldoSuficiente() {
        cuenta.depositar(1000.0);
        boolean resultado = cuenta.retirar(500.0);
        assertTrue(resultado);
        assertEquals(500.0, cuenta.getSaldoTotal());
    }

    @Test
    public void testRetirarMontoConSaldoInsuficiente() {
        cuenta.depositar(200.0);
        boolean resultado = cuenta.retirar(500.0);
        assertFalse(resultado);
        assertEquals(200.0, cuenta.getSaldoTotal());
    }

    @Test
    public void testConsultarSaldo() {
        cuenta.depositar(300.0);
        assertEquals(300.0, cuenta.consultarSaldo());
    }

}