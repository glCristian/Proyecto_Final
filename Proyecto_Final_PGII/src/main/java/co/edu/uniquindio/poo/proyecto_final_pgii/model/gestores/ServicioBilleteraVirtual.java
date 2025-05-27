package co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;

/**
 * Clase de servicio que actua como fachada intermediaria entre la interfaz de usuario y la logica interna de la billetera virtual
 * Utiliza patrones como facade, command, strategy, observer, adapter para delegar operaciones complejas de manera simplificada
 */
public class ServicioBilleteraVirtual {
    private BilleteraVirtualFacade facade;
    private GestorComandos gestorComandos;
    private GestorTransacciones gestorTransacciones;

    /**
     * Constructor de la clase ServicioBilleteraVirtual
     */
    public ServicioBilleteraVirtual() {
        this.facade = new BilleteraVirtualFacade();
        this.gestorComandos = GestorComandos.getInstancia();
        this.gestorTransacciones = GestorTransacciones.getInstancia();

        configurarSistema();
    }

    /**
     * Crear usuario completo (usando Facade + Builder)
     */
    public boolean crearUsuarioCompleto(String nombres, String apellidos, String email,
                                        String telefono, String direccion, String contrasena,
                                        String nombreBanco, String tipoCuenta) {
        return facade.crearUsuarioCompleto(nombres, apellidos, email, telefono, direccion,
                contrasena, nombreBanco, tipoCuenta);
    }

    /**
     * Realizar transferencia con comando reversible
     */
    public boolean realizarTransferenciaConHistorial(String cuentaOrigen, String cuentaDestino,
                                                     double monto, String descripcion, String categoria) {

        Categoria cat = new Categoria(java.util.UUID.randomUUID().toString(), categoria, "");

        ComandoTransferencia comando = new ComandoTransferencia(
                cuentaOrigen, cuentaDestino, monto, descripcion, cat);

        gestorComandos.ejecutarComando(comando);
        return true;
    }

    /**
     * Deshacer última operación
     */
    public void deshacerUltimaOperacion() {
        gestorComandos.deshacerUltimoComando();
    }

    /**
     * Generar reporte (usando Adapter)
     */
    public String generarReporte(String formato, String emailUsuario) {
        return facade.generarReporteCompleto(formato, emailUsuario);
    }

    /**
     * Configurar estrategia de comisiones
     */
    public void configurarComisiones(String tipoComision, double valor) {
        EstrategiaComision estrategia;

        switch (tipoComision.toUpperCase()) {
            case "FIJA":
                estrategia = new ComisionFija(valor);
                break;
            case "ESCALONADA":
                estrategia = new ComisionEscalonada();
                break;
            default:
                estrategia = new SinComision();
        }

        gestorTransacciones.setEstrategiaComision(estrategia);
    }

    /**
     * Agregar observador de notificaciones
     */
    public void agregarNotificacionEmail(String email) {
        gestorTransacciones.agregarObservador(new NotificadorEmail(email));
    }

    private void configurarSistema() {
        // Configurar estrategia de comisión por defecto
        gestorTransacciones.setEstrategiaComision(new ComisionEscalonada());

        // Agregar observadores para el usuario actual si existe
        Usuario usuarioActual = GestorSesion.getInstancia().getUsuarioActual();
        if (usuarioActual != null) {
            gestorTransacciones.agregarObservador(new NotificadorEmail(usuarioActual.getEmail()));
        }
    }
}
