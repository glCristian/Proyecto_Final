package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class EstadisticasViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuEstadisticas;

    @FXML
    private Button Button_GastosMasComunes;

    @FXML
    private Button Button_SaldoPromedioDeUsuarios;

    @FXML
    private Button Button_UsuariosConMasTransacciones;

    @FXML
    void onClick_GastosMasComunes(ActionEvent event) {

    }

    @FXML
    void onClick_SaldoPromedioDeUsuarios(ActionEvent event) {

    }

    @FXML
    void onClick_UsuariosConMasTransacciones(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuEstadisticas != null : "fx:id=\"AnchorPane_MenuEstadisticas\" was not injected: check your FXML file 'estadisticas.fxml'.";
        assert Button_GastosMasComunes != null : "fx:id=\"Button_GastosMasComunes\" was not injected: check your FXML file 'estadisticas.fxml'.";
        assert Button_SaldoPromedioDeUsuarios != null : "fx:id=\"Button_SaldoPromedioDeUsuarios\" was not injected: check your FXML file 'estadisticas.fxml'.";
        assert Button_UsuariosConMasTransacciones != null : "fx:id=\"Button_UsuariosConMasTransacciones\" was not injected: check your FXML file 'estadisticas.fxml'.";

    }

}