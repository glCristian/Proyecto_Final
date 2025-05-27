package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Implementacion de un observador que registra en consola los eventos de auditoria
 * relacionados con las transacciones realizadas
 * Esta clase forma parte del patron observer
 *
 * Tener un registro claro y ordenado para revisar y verificar que paso, cuando y como
 */
public class RegistradorAuditoria implements ObservadorTransacciones{

    /**
     * Metodo que se ejecuta cuando courre una transaccion y se notifica a los observadores.
     * Imprime en consola un log con los detalles de la transaccion
     * @param transaccion
     * @param tipoEvento
     */
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
