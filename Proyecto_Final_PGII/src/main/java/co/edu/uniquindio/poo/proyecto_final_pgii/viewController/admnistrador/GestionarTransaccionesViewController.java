package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class GestionarTransaccionesViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuTransaccion;

    @FXML
    private Button Button_AgregarDinero;

    @FXML
    private Button Button_EnviarDinero;

    @FXML
    private Button Button_RetirarDinero;

    @FXML
    private Label Label_BancoCuenta;

    @FXML
    private Label Label_NumeroCuenta;

    @FXML
    private Label Label_SaldoCuenta;

    @FXML
    private ListView<?> TableView_CuentasTransaccion;

    @FXML
    void onClick_AgregarDinero(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/agregarDinero.fxml");
    }

    @FXML
    void onClick_EnviarDinero(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/enviarDinero.fxml");
    }

    @FXML
    void onClick_RetirarDinero(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/retirarDinero.fxml");
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuTransaccion != null : "fx:id=\"AnchorPane_MenuTransaccion\" was not injected: check your FXML file 'gestionarTransacciones.fxml'.";
        assert Button_AgregarDinero != null : "fx:id=\"Button_AgregarDinero\" was not injected: check your FXML file 'gestionarTransacciones.fxml'.";
        assert Button_EnviarDinero != null : "fx:id=\"Button_EnviarDinero\" was not injected: check your FXML file 'gestionarTransacciones.fxml'.";
        assert Button_RetirarDinero != null : "fx:id=\"Button_RetirarDinero\" was not injected: check your FXML file 'gestionarTransacciones.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'gestionarTransacciones.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'gestionarTransacciones.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'gestionarTransacciones.fxml'.";
        assert TableView_CuentasTransaccion != null : "fx:id=\"TableView_CuentasTransaccion\" was not injected: check your FXML file 'gestionarTransacciones.fxml'.";

    }


    private void cargarVista(String nombreFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreFXML));
            Parent vista = loader.load();
            AnchorPane_MenuTransaccion.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
