package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Implementacion de la estrategia de comision que aplica una comosion fija
 * independientemente del monto de la transaccion
 */
public class ComisionFija implements EstrategiaComision{

    private double comisionFija;

    /**
     * Constructor de la clase ComisionFija
     * @param comisionFija
     */
    public ComisionFija(double comisionFija) {
        this.comisionFija = comisionFija;
    }


    /**
     * Calcula la comosion retornando el valor fijo predefinido
     * @param transaccion
     * @return
     */
    @Override
    public double calcularComision(Transaccion transaccion) {
        return comisionFija;
    }

    /**
     * Retorna el nombre de la estrategia junto con el valor fijo de la comision
     * @return
     */
    @Override
    public String getNombreEstrategia() {
        return "Comisión Fija: $" + comisionFija;
    }
}
