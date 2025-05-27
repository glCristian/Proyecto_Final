package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.List;

/**
 * Interfaz que define el contrato para generar reportes exportabes en diferentes formatos
 * Este es un patron adapater que permite que diferentes formatos de reporte trabajen con una misma
 * interfaz comun
 */
public interface ReporteExportable {

    /**
     * Genera un reporte en el formato especifico a partir de una lista de transacciones
     * @param transacciones
     * @return
     */
    String generarReporte(List<Transaccion> transacciones);

    /**
     * Obtiene el formato de archivo en que se exporta el reporte
     * @return
     */
    String getFormatoArchivo();


}
