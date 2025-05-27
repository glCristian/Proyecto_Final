package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraComisionesTest {

    private CalculadoraComisiones calculadoraComisiones;
    private Transaccion transaccion;
    private Categoria categoria;

    @BeforeEach
    void setUp() {
        categoria = new Categoria("124", "servicios", "pagos de servicios publicos");
        transaccion = Transaccion.crearTransferencia("123", "456", 1000, "Pago factura", categoria);
    }

    @Test
    void testCalculoConEstrategiaFija() {
        EstrategiaComision estrategiaFija = new EstrategiaComision() {
            @Override
            public double calcularComision(Transaccion transaccion) {
                return 500.0;
            }

            @Override
            public String getNombreEstrategia() {
                return "Comisión fija";
            }
        };

        CalculadoraComisiones calculadora = new CalculadoraComisiones(estrategiaFija);
        double comision = calculadora.calcular(transaccion);
        assertEquals(500.0, comision);
        assertEquals("Comisión fija", calculadora.getEstrategiaActual());
    }

    @Test
    void testCalculoConEstrategiaPorcentaje() {
        EstrategiaComision estrategiaPorcentaje = new EstrategiaComision() {
            @Override
            public double calcularComision(Transaccion transaccion) {
                return transaccion.getMonto() * 0.02; // 2%
            }

            @Override
            public String getNombreEstrategia() {
                return "Comisión 2%";
            }
        };

        CalculadoraComisiones calculadora = new CalculadoraComisiones(estrategiaPorcentaje);
        double comision = calculadora.calcular(transaccion);
        assertEquals(20.0, comision);
        assertEquals("Comisión 2%", calculadora.getEstrategiaActual());
    }

    @Test
    void testCambioDeEstrategia() {
        // Estrategia inicial que siempre devuelve comisión 0
        EstrategiaComision estrategiaInicial = new EstrategiaComision() {
            @Override
            public double calcularComision(Transaccion transaccion) {
                return 0;
            }

            @Override
            public String getNombreEstrategia() {
                return "Sin comisión";
            }
        };

        // Estrategia nueva que siempre devuelve comisión 10
        EstrategiaComision estrategiaNueva = new EstrategiaComision() {
            @Override
            public double calcularComision(Transaccion transaccion) {
                return 10;
            }

            @Override
            public String getNombreEstrategia() {
                return "Comisión fija";
            }
        };

        // Crear una transacción de prueba
        Transaccion transaccion = new Transaccion(
                "T001",
                LocalDateTime.now(),
                100.0,
                "Pago de servicio",
                "CUENTA123",
                "CUENTA456",
                new Categoria("890", "servicios", "pago de facturas"), // Ajusta según constructor real
                TipoTransaccion.TRANSFERENCIA
        );

        CalculadoraComisiones calculadora = new CalculadoraComisiones(estrategiaInicial);
        assertEquals(0, calculadora.calcular(transaccion));

        calculadora.setEstrategia(estrategiaNueva);
        assertEquals(10, calculadora.calcular(transaccion));
    }

}