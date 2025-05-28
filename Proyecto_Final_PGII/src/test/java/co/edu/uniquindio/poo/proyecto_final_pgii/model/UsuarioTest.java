package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    static class CuentaDummy extends Cuenta {
        private double saldo = 0;
        private final String id;

        public CuentaDummy(String id) {
            super(id, "Nequi", "TestCuenta", null);
            this.id = id;
        }

        @Override
        public boolean retirar(double monto) {
            if (saldo >= monto) {
                saldo -= monto;
                return true;
            }
            return false;
        }

        @Override
        public void depositar(double monto) {
            saldo += monto;
        }

        @Override
        public double consultarSaldo() {
            return saldo;
        }

        @Override
        public String getIdCuenta() {
            return id;
        }

        @Override
        public LinkedList<Transaccion> getListaTransacciones() {
            return new LinkedList<>();
        }
    }

    static class PresupuestoDummy extends Presupuesto {
        public PresupuestoDummy(String id, String nombre, double monto) {
            super(id, nombre, monto, 0, null);
        }
    }

    private Usuario usuario;
    private CuentaDummy cuenta1;
    private CuentaDummy cuenta2;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Juan", "Pérez", "juan@mail.com", "123", "Calle 1", "u1", "pass");
        cuenta1 = new CuentaDummy("c1");
        cuenta2 = new CuentaDummy("c2");
        usuario.agregarCuenta(cuenta1);
        usuario.agregarCuenta(cuenta2);
    }

    @Test
    void agregarCuentaLaIncluyeEnLaLista() {
        CuentaDummy cuenta3 = new CuentaDummy("c3");
        usuario.agregarCuenta(cuenta3);
        assertTrue(usuario.getListaCuentas().contains(cuenta3));
    }

    @Test
    void eliminarCuentaLaQuitaDeLaLista() {
        usuario.eliminarCuenta("c1");
        assertFalse(usuario.getListaCuentas().stream().anyMatch(c -> c.getIdCuenta().equals("c1")));
    }

    @Test
    void agregarDineroDepositaEnCuentaYRegistraTransaccion() {
        boolean resultado = usuario.agregarDinero(cuenta1, 100);
        assertTrue(resultado);
        assertEquals(100, cuenta1.consultarSaldo());
        assertFalse(usuario.getListaTransacciones().isEmpty());
    }

    @Test
    void retirarDineroRestaSaldoYRegistraTransaccion() {
        usuario.agregarDinero(cuenta1, 200);
        boolean resultado = usuario.retirarDinero(cuenta1, 50);
        assertTrue(resultado);
        assertEquals(150, cuenta1.consultarSaldo());
        assertFalse(usuario.getListaTransacciones().isEmpty());
    }

    @Test
    void transferirDineroEntreCuentas() {
        usuario.agregarDinero(cuenta1, 300);
        usuario.transferirDinero(cuenta1, cuenta2, 100);
        assertEquals(200, cuenta1.consultarSaldo());
        assertEquals(100, cuenta2.consultarSaldo());
    }

    @Test
    void agregarPresupuestoLoIncluyeEnLaLista() {
        PresupuestoDummy presupuesto = new PresupuestoDummy("p1", "Presu", 500);
        usuario.agregarPresupuesto(presupuesto);
        assertTrue(usuario.getListaPresupuestos().contains(presupuesto));
    }

    @Test
    void eliminarPresupuestoLoQuitaDeLaLista() {
        PresupuestoDummy presupuesto = new PresupuestoDummy("p2", "Presu2", 100);
        usuario.agregarPresupuesto(presupuesto);
        usuario.eliminarPresupuesto("p2");
        assertFalse(usuario.getListaPresupuestos().stream().anyMatch(p -> p.getIdPresupuesto().equals("p2")));
    }
}