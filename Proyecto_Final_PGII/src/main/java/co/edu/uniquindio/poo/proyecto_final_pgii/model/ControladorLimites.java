package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Observador que controla y notifica sobre los limites diarios de las transacciones realizadas
 * Implementa la interfaz observadorTransacciones para recibir notificaciones de transacciones
 */
public class ControladorLimites implements ObservadorTransacciones{

    private double limiteDaily = 10000.0; // Límite diario
    private double acumuladoHoy = 0.0; // acumulado del monto de transacciones del dia actual


    /**
     * Metodo que se llama al producirse un evento relacionado con una transaccion
     * Incrementa el acumulado diario si la transaccion fue creada y verifica si se alcanzan o superan
     * ciertos umbrales para mostrar alertas
     * @param transaccion
     * @param tipoEvento
     */
    @Override
    public void notificarTransaccion(Transaccion transaccion, String tipoEvento) {
        if ("CREADA".equals(tipoEvento)) {
            acumuladoHoy += transaccion.getMonto();

            if (acumuladoHoy > limiteDaily * 0.8) { // 80% del límite
                System.out.println(" ALERTA: Has usado el 80% de tu límite diario");
            }

            if (acumuladoHoy > limiteDaily) {
                System.out.println(" LÍMITE EXCEDIDO: Límite diario superado");
            }
        }
    }


    /**
     * Reinicia el acumulado diario a cero
     */
    public void resetearAcumulado() {
        this.acumuladoHoy = 0.0;
    }
}
