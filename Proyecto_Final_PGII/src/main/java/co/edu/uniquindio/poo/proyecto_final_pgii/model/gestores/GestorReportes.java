package co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * PATRÓN SINGLETON + ADAPTER
 * Gestor para manejar la generación de reportes usando diferentes adaptadores
 */
public class GestorReportes {

    private static GestorReportes instancia;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private GestorReportes() {}

    public static GestorReportes getInstancia() {
        if (instancia == null) {
            instancia = new GestorReportes();
        }
        return instancia;
    }

    /**
     * ESPECIAL: Generar reporte de gastos más comunes (para el controlador)
     */
    public String generarReporteGastosMasComunes(String formato) {
        List<Transaccion> todasTransacciones = new ArrayList<>(
                BilleteraVirtual.getInstancia().getTransacciones()
        );

        if (todasTransacciones.isEmpty()) {
            return crearReporteVacio(formato, "No hay datos para analizar gastos");
        }

        // Filtrar solo gastos (retiros y transferencias)
        List<Transaccion> soloGastos = todasTransacciones.stream()
                .filter(t -> t.getTipoTransaccion() == TipoTransaccion.RETIRO ||
                        t.getTipoTransaccion() == TipoTransaccion.TRANSFERENCIA)
                .collect(Collectors.toList());

        if (soloGastos.isEmpty()) {
            return crearReporteVacio(formato, "No hay gastos registrados para analizar");
        }

        return generarReporteConAnalisisGastos(soloGastos, formato);
    }

    /**
     * Generar reporte con análisis especial de gastos más comunes
     */
    private String generarReporteConAnalisisGastos(List<Transaccion> gastos, String formato) {
        // Análisis de categorías más comunes
        Map<String, Double> gastosPorCategoria = new HashMap<>();
        Map<String, Integer> contadorPorCategoria = new HashMap<>();

        for (Transaccion gasto : gastos) {
            String categoria = gasto.getCategoria() != null ?
                    gasto.getCategoria().getNombre() : "Sin Categoría";

            gastosPorCategoria.put(categoria,
                    gastosPorCategoria.getOrDefault(categoria, 0.0) + gasto.getMonto());
            contadorPorCategoria.put(categoria,
                    contadorPorCategoria.getOrDefault(categoria, 0) + 1);
        }

        // Obtener top 5 categorías
        List<Map.Entry<String, Double>> top5Categorias = gastosPorCategoria.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toList());

        // PATRÓN ADAPTER - Usar adaptador apropiado
        ReporteExportable generador = obtenerGeneradorReporte(formato);

        if (generador == null) {
            return crearReporteError(formato, "Formato no soportado: " + formato);
        }

        // Generar reporte específico de gastos más comunes
        if (formato.equalsIgnoreCase("CSV")) {
            return generarReporteGastosCSV(gastos, top5Categorias, contadorPorCategoria);
        } else {
            return generarReporteGastosPDF(gastos, top5Categorias, contadorPorCategoria);
        }
    }

    /**
     * PATRÓN ADAPTER - Obtener el generador apropiado según formato
     */
    private ReporteExportable obtenerGeneradorReporte(String formato) {
        switch (formato.toUpperCase()) {
            case "CSV":
                return new AdaptadorReporteCSV();
            case "PDF":
                return new AdaptadorReportePDF();
            default:
                return null;
        }
    }

    /**
     * Generar reporte de gastos en formato CSV
     */
    private String generarReporteGastosCSV(List<Transaccion> gastos,
                                           List<Map.Entry<String, Double>> top5,
                                           Map<String, Integer> contador) {
        StringBuilder csv = new StringBuilder();

        // Metadatos del reporte
        csv.append("# REPORTE DE GASTOS MAS COMUNES - FORMATO CSV\n");
        csv.append("# Generado: ").append(LocalDateTime.now().format(formatter)).append("\n");
        csv.append("# Total de gastos analizados: ").append(gastos.size()).append("\n");
        csv.append("# Sistema: Billetera Virtual con Patrones de Diseño\n");
        csv.append("#\n");

        // TOP 5 categorías
        csv.append("RANKING,CATEGORIA,MONTO_TOTAL,NUM_TRANSACCIONES,PROMEDIO_POR_TRANSACCION\n");

        for (int i = 0; i < top5.size(); i++) {
            Map.Entry<String, Double> entry = top5.get(i);
            String categoria = entry.getKey();
            double monto = entry.getValue();
            int numTransacciones = contador.get(categoria);
            double promedio = monto / numTransacciones;

            csv.append(i + 1).append(",")
                    .append(escaparCSV(categoria)).append(",")
                    .append(String.format("%.2f", monto)).append(",")
                    .append(numTransacciones).append(",")
                    .append(String.format("%.2f", promedio)).append("\n");
        }

        return csv.toString();
    }

    /**
     * Generar reporte de gastos en formato PDF
     */
    private String generarReporteGastosPDF(List<Transaccion> gastos,
                                           List<Map.Entry<String, Double>> top5,
                                           Map<String, Integer> contador) {
        StringBuilder pdf = new StringBuilder();

        // Encabezado principal
        pdf.append("═".repeat(80)).append("\n");
        pdf.append("                 REPORTE DE GASTOS MÁS COMUNES \n");
        pdf.append("═".repeat(80)).append("\n");
        pdf.append("Fecha de generación: ").append(LocalDateTime.now().format(formatter)).append("\n");
        pdf.append("Total de gastos analizados: ").append(gastos.size()).append("\n");
        pdf.append("Tipos incluidos: Retiros y Transferencias\n");
        pdf.append("Sistema: Billetera Virtual con Patrones de Diseño\n");
        pdf.append("═".repeat(80)).append("\n\n");

        // Ranking de categorías más comunes
        pdf.append("🏆 RANKING DE CATEGORÍAS MÁS COMUNES:\n");
        pdf.append("═".repeat(80)).append("\n");

        String[] medallas = {"🥇", "🥈", "🥉", "🏅", "🏅"};

        for (int i = 0; i < top5.size(); i++) {
            Map.Entry<String, Double> entry = top5.get(i);
            String categoria = entry.getKey();
            double monto = entry.getValue();
            int numTransacciones = contador.get(categoria);
            double promedio = monto / numTransacciones;

            pdf.append(String.format("%s PUESTO #%d - %s\n",
                    medallas[i], i + 1, categoria.toUpperCase()));
            pdf.append(String.format("  Total gastado: $%,.2f\n", monto));
            pdf.append(String.format("   Transacciones: %d\n", numTransacciones));
            pdf.append(String.format("   Promedio: $%,.2f\n", promedio));
            pdf.append("   ").append("─".repeat(60)).append("\n");
        }

        pdf.append("\n").append("═".repeat(80)).append("\n");

        return pdf.toString();
    }

    // Métodos auxiliares
    private String crearReporteError(String formato, String mensajeError) {
        if (formato.equalsIgnoreCase("CSV")) {
            return "# ERROR\n# " + mensajeError + "\n";
        } else {
            return "═══ ERROR ═══\n" + mensajeError + "\n═════════════\n";
        }
    }

    private String crearReporteVacio(String formato, String mensaje) {
        if (formato.equalsIgnoreCase("CSV")) {
            return "# REPORTE VACÍO\n# " + mensaje + "\n# Fecha: " +
                    LocalDateTime.now().format(formatter) + "\n";
        } else {
            return "═══ REPORTE VACÍO ═══\n\n" + mensaje +
                    "\n\nFecha: " + LocalDateTime.now().format(formatter) +
                    "\n\n═══════════════════════\n";
        }
    }

    private String escaparCSV(String valor) {
        if (valor == null) return "";

        if (valor.contains(",") || valor.contains("\"") || valor.contains("\n")) {
            return "\"" + valor.replace("\"", "\"\"") + "\"";
        }
        return valor;
    }

    public String[] getFormatosSoportados() {
        return new String[]{"CSV", "PDF"};
    }
}
