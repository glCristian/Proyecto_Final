package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilleteraVirtualFacadeTest {

    private BilleteraVirtualFacade facade;

    @BeforeEach
    public void setUp(){
        facade = new BilleteraVirtualFacade();

        //configurar usuario autenticado en gestorSesion para probar transferencias
        Usuario usuario = new Usuario("diana", "garcia", "diana@email.com", "829292", "calle 4 #90-07", "908", "6789");
        usuario.setEmail("diana@email.com");
        GestorSesion.getInstancia().setPerfilActual(usuario);

        BilleteraVirtual.getInstancia().getPerfiles().clear();
    }

    @Test
    public void testCrearUsuarioCompletoConCuenta(){
        boolean resultado = facade.crearUsuarioCompleto("john","garcia", "john@email.com", "980656", "calle 8 N", "98765", "davivienda", "AHORRO");
        assertTrue(resultado);

        Usuario usuario = facade.buscarUsuarioPorEmail("john@email.com");
        assertNotNull(usuario);
        assertEquals("john@email.com", usuario.getEmail());
        assertFalse(usuario.getListaCuentas().isEmpty());
    }

    @Test
    public void testCrearUsuarioCompleto_SinCuenta() {
        boolean resultado = facade.crearUsuarioCompleto(
                "Ana", "Gomez", "ana@example.com", "3009876543", "Calle 456",
                "contrasena456", "", "");

        assertTrue(resultado);

        Usuario usuario = facade.buscarUsuarioPorEmail("ana@example.com");
        assertNotNull(usuario);
        assertEquals("ana@example.com", usuario.getEmail());
        assertTrue(usuario.getListaCuentas().isEmpty());
    }

    @Test
    public void testRealizarTransferenciaCompleta_UsuarioNoAutorizado() {
        // Cambiamos usuario autenticado a uno diferente para probar rechazo
        GestorSesion.getInstancia().setPerfilActual(new Usuario("juan", "moreno", "juanm@email.com", "829292", "carrera 21 #09-20", "828292", "65578") {{
            setEmail("juan@example.com");
        }});

        boolean resultado = facade.realizarTransferenciaCompleta(
                "maria@example.com", "1234", "5678", 100.0, "Pago", "Servicios");

        assertFalse(resultado);
    }

    @Test
    public void testGenerarReporteCompleto_UsuarioNoEncontrado() {
        String resultado = facade.generarReporteCompleto("PDF", "jacky@email.com");
        assertEquals("Usuario no encontrado", resultado);
    }

    @Test
    public void testGenerarReporteCompleto_FormatoNoSoportado() {
        // Crear usuario primero
        facade.crearUsuarioCompleto(
                "Laura", "Lopez", "laura@email.com", "300000", "Calle 789",
                "pass123", "Banco XYZ", "CORRIENTE");

        String resultado = facade.generarReporteCompleto("XML", "laura@email.com");
        assertEquals("Formato no soportado", resultado);
    }


}