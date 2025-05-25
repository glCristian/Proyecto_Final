package co.edu.uniquindio.poo.proyecto_final_pgii.model;

public class ComisionFija implements EstrategiaComision{

    private double comisionFija;

    public ComisionFija(double comisionFija) {
        this.comisionFija = comisionFija;
    }

    @Override
    public double calcularComision(Transaccion transaccion) {
        return comisionFija;
    }

    @Override
    public String getNombreEstrategia() {
        return "Comisión Fija: $" + comisionFija;
    }
}
