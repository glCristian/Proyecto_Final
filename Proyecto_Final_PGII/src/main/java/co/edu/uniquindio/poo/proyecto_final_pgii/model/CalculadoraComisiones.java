package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Calculadora de comisiones que usa Strategy
 */
public class CalculadoraComisiones {

    private EstrategiaComision estrategia;

    public CalculadoraComisiones(EstrategiaComision estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaComision estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(Transaccion transaccion) {
        return estrategia.calcularComision(transaccion);
    }

    public String getEstrategiaActual() {
        return estrategia.getNombreEstrategia();
    }
}
