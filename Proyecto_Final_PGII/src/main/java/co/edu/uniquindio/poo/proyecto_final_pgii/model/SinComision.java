package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Estrategia de comision que no aplica ningun cargo adicional al transaccion
 */
public class SinComision implements EstrategiaComision{

    /**
     * Calcula la comision de la transaccion, que en este caso es siempre 0
     * @param transaccion
     * @return
     */
    @Override
    public double calcularComision(Transaccion transaccion) {
        return 0.0;
    }

    /**
     * Retorna el nombre de la estartegia de comision
     * @return
     */
    @Override
    public String getNombreEstrategia() {
        return "Sin Comisión";
    }
}
