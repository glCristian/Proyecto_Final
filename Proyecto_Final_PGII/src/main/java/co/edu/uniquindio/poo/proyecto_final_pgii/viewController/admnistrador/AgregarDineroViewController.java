package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AgregarDineroViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuAgregarDinero;

    @FXML
    private Button Button_AgregarDinero;

    @FXML
    private Button Button_AtrasMenuTransaccion;

    @FXML
    private Label Label_BancoCuenta;

    @FXML
    private Label Label_NumeroCuenta;

    @FXML
    private Label Label_SaldoCuenta;

    @FXML
    private TextField TextField_CategoriaTransaccion;

    @FXML
    private TextField TextField_DescripcionAgregar;

    @FXML
    private TextField TextField_MontoAgregarDinero;

    @FXML
    private TextField TextField_NumeroCuentaOrigenAgregar;

    @FXML
    void onClick_AgregarDinero(ActionEvent event) {

    }

    @FXML
    void onClick_AtrasMenuTransaccion(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuAgregarDinero != null : "fx:id=\"AnchorPane_MenuAgregarDinero\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert Button_AgregarDinero != null : "fx:id=\"Button_AgregarDinero\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert Button_AtrasMenuTransaccion != null : "fx:id=\"Button_AtrasMenuTransaccion\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert TextField_CategoriaTransaccion != null : "fx:id=\"TextField_CategoriaTransaccion\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert TextField_DescripcionAgregar != null : "fx:id=\"TextField_DescripcionAgregar\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert TextField_MontoAgregarDinero != null : "fx:id=\"TextField_MontoAgregarDinero\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert TextField_NumeroCuentaOrigenAgregar != null : "fx:id=\"TextField_NumeroCuentaOrigenAgregar\" was not injected: check your FXML file 'agregarDinero.fxml'.";

    }

}