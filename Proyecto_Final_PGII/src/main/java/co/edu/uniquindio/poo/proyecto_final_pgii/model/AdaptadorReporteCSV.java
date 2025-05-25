package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.List;

/**
 * Adaptador que permite usar GeneradorReporteCSV con la interfaz ReporteExportable
 */
public class AdaptadorReporteCSV implements ReporteExportable{
    private GeneradorReporteCSV generadorCSV;

    public AdaptadorReporteCSV() {
        this.generadorCSV = new GeneradorReporteCSV();
    }

    @Override
    public String generarReporte(List<Transaccion> transacciones) {
        return generadorCSV.crearCSV(transacciones);
    }

    @Override
    public String getFormatoArchivo() {
        return "CSV";
    }
}
