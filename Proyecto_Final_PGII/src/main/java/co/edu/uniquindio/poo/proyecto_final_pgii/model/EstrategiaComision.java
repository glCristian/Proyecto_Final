package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Patron Strategy, permite cambiar algoritmos de calculo de comisiones dinamicamente
 */
public interface EstrategiaComision {

    double calcularComision(Transaccion transaccion);
    String getNombreEstrategia();

}
