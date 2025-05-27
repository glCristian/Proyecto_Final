package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Interfaz que define el contrato para las estrategias de calculo de comision
 * Permite implementar diferentes algoritmos de calculo que pueden cambiarse dinamicamente
 * usando el patron Strategy
 */
public interface EstrategiaComision {

    /**
     * calcula la comision aplicada sobre una transaccion dada
     * @param transaccion
     * @return
     */
    double calcularComision(Transaccion transaccion);

    /**
     * Obtiene el nombre de la estrategia de comision implementada
     * @return
     */
    String getNombreEstrategia();

}
