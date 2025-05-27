package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorReportes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;

public class GastosMasComunesViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuGastosMasComunes;

    @FXML
    private Button Button_AtrasMenuEstadisticas;

    @FXML
    private Button Button_ExportarCSV;

    @FXML
    private Button Button_ExportarPDF;

    @FXML
    private PieChart PieChart_GastosMasComunes;

    @FXML
    private TextField TextField_insertarFechaInicioFechaFin;

    private GestorReportes gestorReportes;

    @FXML
    void onClick_AtrasMenuEstadisticas(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuGastosMasComunes.getParent();

            PantallaPrincipalAdministradorViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/estadisticas.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void onClick_ExportarPDF(ActionEvent event) throws IOException {
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        fileChooser.setTitle("Selecciona la ubicación para guardar el PDF");
        fileChooser.getExtensionFilters().add(
                new javafx.stage.FileChooser.ExtensionFilter("Archivo PDF (*.pdf)", "*.pdf")
        );
        // Sugerir nombre por defecto
        fileChooser.setInitialFileName("reporte_gastos.pdf");

        // Obtener la ventana actual de JavaFX
        javafx.stage.Window stage = AnchorPane_MenuGastosMasComunes.getScene().getWindow();
        File fileToSave = fileChooser.showSaveDialog(stage);

        if (fileToSave != null) {
            String ruta = fileToSave.getAbsolutePath();
            // Asegura la extensión .pdf
            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }
            GestorReportes.getInstancia().generarReporteGastosMasComunes("PDF", ruta);
        }
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuGastosMasComunes != null : "fx:id=\"AnchorPane_MenuGastosMasComunes\" was not injected: check your FXML file 'gastosMasComunes.fxml'.";
        assert Button_AtrasMenuEstadisticas != null : "fx:id=\"Button_AtrasMenuEstadisticas\" was not injected: check your FXML file 'gastosMasComunes.fxml'.";
        assert Button_ExportarCSV != null : "fx:id=\"Button_ExportarCSV\" was not injected: check your FXML file 'gastosMasComunes.fxml'.";
        assert Button_ExportarPDF != null : "fx:id=\"Button_ExportarPDF\" was not injected: check your FXML file 'gastosMasComunes.fxml'.";
        assert PieChart_GastosMasComunes != null : "fx:id=\"PieChart_GastosMasComunes\" was not injected: check your FXML file 'gastosMasComunes.fxml'.";
        assert TextField_insertarFechaInicioFechaFin != null : "fx:id=\"TextField_insertarFechaInicioFechaFin\" was not injected: check your FXML file 'gastosMasComunes.fxml'.";


    }


}


