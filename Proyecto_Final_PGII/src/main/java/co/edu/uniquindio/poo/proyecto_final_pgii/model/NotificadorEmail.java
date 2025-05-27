package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Clase que implementa el patron observer para manejar notificaciones por email cuando
 * se realiza una transaccion.
 * Esta clase actua como un observador que reacciona a eventos relacionados con transacciones
 */
public class NotificadorEmail implements ObservadorTransacciones{

    private String emailDestino;

    /**
     * Constructor de la clase NotificadorEmail
     * @param emailDestino
     */
    public NotificadorEmail(String emailDestino) {
        this.emailDestino = emailDestino;
    }

    /**
     * Metodo que se ejecuta cuando ocurre un evento sobre una transaccion
     * @param transaccion
     * @param tipoEvento
     */
    @Override
    public void notificarTransaccion(Transaccion transaccion, String tipoEvento) {
        System.out.println("📧 EMAIL enviado a " + emailDestino + ":");
        System.out.println("Evento: " + tipoEvento);
        System.out.println("Transacción ID: " + transaccion.getIdTransaccion());
        System.out.println("Monto: $" + transaccion.getMonto());
        System.out.println("--------------------");
    }
}
