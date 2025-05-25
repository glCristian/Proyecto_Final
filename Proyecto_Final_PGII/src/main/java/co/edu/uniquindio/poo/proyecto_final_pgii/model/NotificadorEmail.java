package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Observador que maneja notificaciones por email
 */
public class NotificadorEmail implements ObservadorTransacciones{

    private String emailDestino;

    public NotificadorEmail(String emailDestino) {
        this.emailDestino = emailDestino;
    }

    @Override
    public void notificarTransaccion(Transaccion transaccion, String tipoEvento) {
        System.out.println("📧 EMAIL enviado a " + emailDestino + ":");
        System.out.println("Evento: " + tipoEvento);
        System.out.println("Transacción ID: " + transaccion.getIdTransaccion());
        System.out.println("Monto: $" + transaccion.getMonto());
        System.out.println("--------------------");
    }
}
