package co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.reportes.GeneradorReportePDF;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase Singleton encargada de generar reportes a partir de los datos almacenados en la billetera virtual
 * permite obtener transacciones, cuentas y usuarios filtrador por distintos criterios
 */
public class GestorReportes {

    private static GestorReportes instancia;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /**
     * Constructor privado de la clase GestorReportes
     */
    private GestorReportes() {
    }

    /**
     * Metodo que retorna la instancia unica de gestorReportes, creando una nueva si no existe
     * @return
     */
    public static GestorReportes getInstancia() {
        if (instancia == null) {
            instancia = new GestorReportes();
        }
        return instancia;
    }


    /**
     * Metodo que recolecta y estructura los datos necesarios para generar el reporte.
     * Agrupa las transacciones por categoria y calcula los montos y porcentajes correspondientes a cada una
     * @return
     */
    private Map<String, Object> obtenerDatosReporte() {
        Map<String, Object> datos = new HashMap<>();

        try {
            List<Transaccion> transacciones = GestorTransacciones.getInstancia().obtenerTodasTransacciones();

            Map<String, Double> gastosPorCategoria = transacciones.stream()
                    .filter(t -> t.getTipoTransaccion() == TipoTransaccion.RETIRO ||
                            t.getTipoTransaccion() == TipoTransaccion.TRANSFERENCIA)
                    .collect(Collectors.groupingBy(
                            t -> t.getCategoria().getNombre(),
                            Collectors.summingDouble(Transaccion::getMonto)
                    ));

            List<Map.Entry<String, Double>> categoriasOrdenadas = new ArrayList<>(gastosPorCategoria.entrySet());
            categoriasOrdenadas.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            datos.put("titulo", "Reporte de Gastos más Comunes");
            datos.put("fecha", LocalDateTime.now().format(formatter));
            datos.put("categorias", categoriasOrdenadas);
            datos.put("transacciones", transacciones);

            double totalGastos = gastosPorCategoria.values().stream().mapToDouble(Double::doubleValue).sum();
            datos.put("totalGastos", totalGastos);

            List<Map.Entry<String, Double>> top5Categorias = categoriasOrdenadas.stream()
                    .limit(5)
                    .collect(Collectors.toList());
            datos.put("top5Categorias", top5Categorias);

            Map<String, Integer> porcentajes = new HashMap<>();
            for (Map.Entry<String, Double> entry : gastosPorCategoria.entrySet()) {
                int porcentaje = (int) ((entry.getValue() / totalGastos) * 100);
                porcentajes.put(entry.getKey(), porcentaje);
            }
            datos.put("porcentajes", porcentajes);

        } catch (Exception e) {
            System.err.println("Error al obtener datos para el reporte: " + e.getMessage());
            e.printStackTrace();
        }

        return datos;
    }


    /**
     * Genera un reporte en formato PDF con la informacion de gastos mas comunes por categoria
     * @param formato
     * @param rutaDestino
     * @throws IOException
     */
    public void generarReporteGastosMasComunes(String formato, String rutaDestino) throws IOException {
        if ("PDF".equals(formato)) {
            GeneradorReportePDF generador = new GeneradorReportePDF();
            Map<String, Object> datosReporte = obtenerDatosReporte();

            @SuppressWarnings("unchecked")
            List<Transaccion> transacciones = (List<Transaccion>) datosReporte.get("transacciones");
            @SuppressWarnings("unchecked")
            List<Map.Entry<String, Double>> top5Categorias = (List<Map.Entry<String, Double>>) datosReporte.get("top5Categorias");
            @SuppressWarnings("unchecked")
            Map<String, Integer> porcentajes = (Map<String, Integer>) datosReporte.get("porcentajes");

            generador.crearPDFenArchivo(
                    transacciones,
                    top5Categorias,
                    porcentajes,
                    rutaDestino
            );
        }
    }
}