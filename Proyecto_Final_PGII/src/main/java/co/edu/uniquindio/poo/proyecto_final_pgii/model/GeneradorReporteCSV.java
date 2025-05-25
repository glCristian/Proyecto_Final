package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.List;

/**
 * Clase que genera reportes en CSV
 */
public class GeneradorReporteCSV {

    public String crearCSV(List<Transaccion> datos) {
        StringBuilder csv = new StringBuilder();
        csv.append("ID,Fecha,Tipo,Monto,Descripcion,CuentaOrigen,CuentaDestino\n");

        for (Transaccion t : datos) {
            csv.append(t.getIdTransaccion()).append(",")
                    .append(t.getFecha()).append(",")
                    .append(t.getTipoTransaccion()).append(",")
                    .append(t.getMonto()).append(",")
                    .append(t.getDescripcion()).append(",")
                    .append(t.getCuentaOrigen() != null ? t.getCuentaOrigen() : "N/A").append(",")
                    .append(t.getCuentaDestino() != null ? t.getCuentaDestino() : "N/A").append("\n");
        }

        return csv.toString();
    }
}
