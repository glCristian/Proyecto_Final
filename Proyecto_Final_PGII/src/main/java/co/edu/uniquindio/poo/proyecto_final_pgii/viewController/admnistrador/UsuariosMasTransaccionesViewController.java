package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class UsuariosMasTransaccionesViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuUsuariosMasTransacciones;

    @FXML
    private BarChart<?, ?> BarChart_UsuariosMasTransacciones;

    @FXML
    private Button Button_AtrasMenuEstadisticas;

    @FXML
    private Button Button_ExportarCSV;

    @FXML
    private Button Button_ExportarPDF;

    @FXML
    private TextField TextField_insertarFechaInicioFechaFin;

    @FXML
    void onClick_AtrasMenuEstadisticas(ActionEvent event) {

    }

    @FXML
    void onClick_ExportarCSV(ActionEvent event) {

    }

    @FXML
    void onClick_ExportarPDF(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuUsuariosMasTransacciones != null : "fx:id=\"AnchorPane_MenuUsuariosMasTransacciones\" was not injected: check your FXML file 'usuariosMasTransacciones.fxml'.";
        assert BarChart_UsuariosMasTransacciones != null : "fx:id=\"BarChart_UsuariosMasTransacciones\" was not injected: check your FXML file 'usuariosMasTransacciones.fxml'.";
        assert Button_AtrasMenuEstadisticas != null : "fx:id=\"Button_AtrasMenuEstadisticas\" was not injected: check your FXML file 'usuariosMasTransacciones.fxml'.";
        assert Button_ExportarCSV != null : "fx:id=\"Button_ExportarCSV\" was not injected: check your FXML file 'usuariosMasTransacciones.fxml'.";
        assert Button_ExportarPDF != null : "fx:id=\"Button_ExportarPDF\" was not injected: check your FXML file 'usuariosMasTransacciones.fxml'.";
        assert TextField_insertarFechaInicioFechaFin != null : "fx:id=\"TextField_insertarFechaInicioFechaFin\" was not injected: check your FXML file 'usuariosMasTransacciones.fxml'.";

    }

}

