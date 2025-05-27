package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilleteraVirtualTest {

    private BilleteraVirtual billeteraVirtual;

    @Test
    public void testSingleton() {
        System.out.println("Inicio prueba");
        BilleteraVirtual instancia1 = BilleteraVirtual.getInstancia();
        BilleteraVirtual instancia2 = BilleteraVirtual.getInstancia();

        assertNotNull(instancia1, "La instancia no debe ser null");
        assertSame(instancia1, instancia2, "Debe ser la misma instancia singleton");
        System.out.println("Fin prueba");
    }


}