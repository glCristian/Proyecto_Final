package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Observador que controla limites de transacciones
 */
public class ControladorLimites implements ObservadorTransacciones{

    private double limiteDaily = 10000.0; // Límite diario
    private double acumuladoHoy = 0.0;

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

    public void resetearAcumulado() {
        this.acumuladoHoy = 0.0;
    }
}
