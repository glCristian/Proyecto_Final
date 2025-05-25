package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.List;

/**
 * Patron adapter, permite que diferentes formatos de reporte trabajen con la misma interfaz
 */
public interface ReporteExportable {

    String generarReporte(List<Transaccion> transacciones);
    String getFormatoArchivo();


}
