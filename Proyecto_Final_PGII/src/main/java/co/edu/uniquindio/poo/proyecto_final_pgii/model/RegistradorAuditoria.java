package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Observador que registra logs de auditoria
 */
public class RegistradorAuditoria implements ObservadorTransacciones{

    @Override
    public void notificarTransaccion(Transaccion transaccion, String tipoEvento) {
        System.out.println(" LOG DE AUDITORÍA:");
        System.out.println("Timestamp: " + transaccion.getFecha());
        System.out.println("Evento: " + tipoEvento);
        System.out.println("ID Transacción: " + transaccion.getIdTransaccion());
        System.out.println("Tipo: " + transaccion.getTipoTransaccion());
        System.out.println("Monto: $" + transaccion.getMonto());
        System.out.println("--------------------");
    }
}
