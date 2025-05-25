package co.edu.uniquindio.poo.proyecto_final_pgii.model;

public class SinComision implements EstrategiaComision{
    @Override
    public double calcularComision(Transaccion transaccion) {
        return 0.0;
    }

    @Override
    public String getNombreEstrategia() {
        return "Sin Comisión";
    }
}
