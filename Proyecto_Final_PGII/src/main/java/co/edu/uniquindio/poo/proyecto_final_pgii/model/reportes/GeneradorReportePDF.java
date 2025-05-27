package co.edu.uniquindio.poo.proyecto_final_pgii.model.reportes;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfPTable;

/**
 * Clase responsable de generar un reporte PDF
 * Se utiliza la libreria openPDF para la creacion del documento
 */
public class GeneradorReportePDF {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /**
     * Genera un archivo PDF en memoria que contiene el reporte
     * @param gastos
     * @param top5
     * @param contador
     * @return
     * @throws DocumentException
     */
    public byte[] crearPDF(List<Transaccion> gastos, List<Map.Entry<String, Double>> top5, Map<String, Integer> contador) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);

        document.open();

        // Título
        Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD);
        Paragraph title = new Paragraph("Reporte de Gastos Más Comunes", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph("Fecha de generación: " + LocalDateTime.now().format(formatter)));
        document.add(new Paragraph("Total de gastos analizados: " + gastos.size()));
        document.add(new Paragraph("Tipos incluidos: Retiros y Transferencias"));
        document.add(new Paragraph("Sistema: Billetera Virtual con Patrones de Diseño"));
        document.add(new Paragraph(" "));

        // Tabla de ranking
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.addCell("Ranking");
        table.addCell("Categoría");
        table.addCell("Monto total");
        table.addCell("Transacciones");
        table.addCell("Promedio");

        String[] medallas = {"🥇", "🥈", "🥉", "🏅", "🏅"};
        for (int i = 0; i < top5.size(); i++) {
            Map.Entry<String, Double> entry = top5.get(i);
            String categoria = entry.getKey();
            double monto = entry.getValue();
            int numTransacciones = contador.get(categoria);
            double promedio = monto / numTransacciones;

            table.addCell(medallas[i] + " Puesto #" + (i + 1));
            table.addCell(categoria.toUpperCase());
            table.addCell(String.format("$%,.2f", monto));
            table.addCell(String.valueOf(numTransacciones));
            table.addCell(String.format("$%,.2f", promedio));
        }

        document.add(table);
        document.close();

        return baos.toByteArray();
    }

    /**
     * Genera un archivo PDF en una ruta especifica del sistema de archivos
     * @param gastos
     * @param top5
     * @param contador
     * @param rutaArchivo
     * @throws IOException
     * @throws DocumentException
     */
    public void crearPDFenArchivo(List<Transaccion> gastos, List<Map.Entry<String, Double>> top5, Map<String, Integer> contador, String rutaArchivo) throws IOException, DocumentException {
        byte[] pdfBytes = crearPDF(gastos, top5, contador);
        try (FileOutputStream fos = new FileOutputStream(rutaArchivo)) {
            fos.write(pdfBytes);
        }
    }
}