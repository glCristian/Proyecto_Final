package co.edu.uniquindio.poo.proyecto_final_pgii.model;

public class ComisionEscalonada implements EstrategiaComision{

    @Override
    public double calcularComision(Transaccion transaccion) {
        double monto = transaccion.getMonto();

        if (monto <= 1000) {
            return 0; // Sin comisión para montos pequeños
        } else if (monto <= 10000) {
            return monto * 0.001; // 0.1%
        } else if (monto <= 100000) {
            return monto * 0.005; // 0.5%
        } else {
            return monto * 0.01; // 1%
        }
    }

    @Override
    public String getNombreEstrategia() {
        return "Comisión Escalonada";
    }
}
