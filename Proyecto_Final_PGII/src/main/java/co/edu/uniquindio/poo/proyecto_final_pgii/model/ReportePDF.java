package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.List;

/**
 * Implementacion de la interfaz ReporteExportable para generar reportes en formato PDF
 */
public class ReportePDF implements ReporteExportable{

    /**
     * Genera un reporte en formato PDF con la informacion de las transacciones (simulado como texto)
     * @param transacciones
     * @return
     */
    @Override
    public String generarReporte(List<Transaccion> transacciones) {
        StringBuilder pdf = new StringBuilder();
        pdf.append("=== REPORTE DE TRANSACCIONES PDF ===\n\n");

        for (Transaccion t : transacciones) {
            pdf.append("Transacción: ").append(t.getIdTransaccion()).append("\n")
                    .append("Fecha: ").append(t.getFecha()).append("\n")
                    .append("Tipo: ").append(t.getTipoTransaccion()).append("\n")
                    .append("Monto: $").append(t.getMonto()).append("\n")
                    .append("Descripción: ").append(t.getDescripcion()).append("\n")
                    .append("----------------------------------------\n");
        }

        return pdf.toString();
    }

    /**
     * Retorna el formato de archivo que representa esta implemetacion
     * @return
     */
    @Override
    public String getFormatoArchivo() {
        return "PDF";
    }
}
