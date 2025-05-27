package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Etsratgeia de calculo de comisiones que aplica tarifas escalonadas segun el monto de la transaccion
 * Implementa la interfaz EstrategiaComicion
 */
public class ComisionEscalonada implements EstrategiaComision{

    /**
     * Metodo que calcula la comision para la transaccion segun los rangos definidos
     * @param transaccion
     * @return
     */
    @Override
    public double calcularComision(Transaccion transaccion) {
        double monto = transaccion.getMonto();

        if (monto <= 1000) {
            return 0; // 0%
        } else if (monto <= 10000) {
            return monto * 0.001; // 0.1%
        } else if (monto < 100000) {
            return monto * 0.005; // 0.5%
        } else {
            return monto * 0.01; // 1%
        }
    }

    /**
     * Metodo que retorna el nombre de la estrategia de comosion
     * @return
     */
    @Override
    public String getNombreEstrategia() {
        return "Comisión Escalonada";
    }
}
