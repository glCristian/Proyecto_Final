package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AgregarCuentaViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuAgregarCuentas;

    @FXML
    private Button Button_AnadirCuenta;

    @FXML
    private Button Button_AtrasMenuCuentas;

    @FXML
    private Label Label_BancoCuenta;

    @FXML
    private Label Label_NumeroCuenta;

    @FXML
    private Label Label_SaldoCuenta;

    @FXML
    private TextField TextField_AgregarBancoCuenta;

    @FXML
    private TextField TextField_AgregarNumeroCuenta;

    @FXML
    private TextField TextField_IDdeLaCuenta;

    @FXML
    private ComboBox<?> cmb_select_tipoCuenta;

    @FXML
    void onClick_AtrasMenuCuentas(ActionEvent event) {

    }

    @FXML
    void onClick_anadirCuenta(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuAgregarCuentas.getParent();

            PantallaPrincipalAdministradorViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/gestionarCuentas.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuAgregarCuentas != null : "fx:id=\"AnchorPane_MenuAgregarCuentas\" was not injected: check your FXML file 'agregarCuentaAdmin.fxml'.";
        assert Button_AnadirCuenta != null : "fx:id=\"Button_AnadirCuenta\" was not injected: check your FXML file 'agregarCuentaAdmin.fxml'.";
        assert Button_AtrasMenuCuentas != null : "fx:id=\"Button_AtrasMenuCuentas\" was not injected: check your FXML file 'agregarCuentaAdmin.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'agregarCuentaAdmin.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'agregarCuentaAdmin.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'agregarCuentaAdmin.fxml'.";
        assert TextField_AgregarBancoCuenta != null : "fx:id=\"TextField_AgregarBancoCuenta\" was not injected: check your FXML file 'agregarCuentaAdmin.fxml'.";
        assert TextField_AgregarNumeroCuenta != null : "fx:id=\"TextField_AgregarNumeroCuenta\" was not injected: check your FXML file 'agregarCuentaAdmin.fxml'.";
        assert TextField_IDdeLaCuenta != null : "fx:id=\"TextField_IDdeLaCuenta\" was not injected: check your FXML file 'agregarCuentaAdmin.fxml'.";
        assert cmb_select_tipoCuenta != null : "fx:id=\"cmb_select_tipoCuenta\" was not injected: check your FXML file 'agregarCuentaAdmin.fxml'.";

    }

}
