package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Clase que representa una Calculadora de comisiones que usa el patron Strategy
 * Permite definir diferenes estrategias de calculo de comisiones para transacciones
 */
public class CalculadoraComisiones {

    private EstrategiaComision estrategia;

    /**
     * Constructor de la clase CalculadoraComisiones
     * @param estrategia
     */
    public CalculadoraComisiones(EstrategiaComision estrategia) {
        this.estrategia = estrategia;
    }

    /**
     * Metodo que cambia la estrategia de calculo de comision
     * @param estrategia
     */
    public void setEstrategia(EstrategiaComision estrategia) {
        this.estrategia = estrategia;
    }

    /**
     * Metodo que calcula la comision para una transaccion segun la estrategia actual
     * @param transaccion
     * @return
     */
    public double calcular(Transaccion transaccion) {
        return estrategia.calcularComision(transaccion);
    }

    /**
     * Metodo que obtiene el nombre de la estrategia actual usada para calcular comosiones
     * @return
     */
    public String getEstrategiaActual() {
        return estrategia.getNombreEstrategia();
    }
}
