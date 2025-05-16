package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorCuentas;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private TextField TextField_AgregarNumeroCuenta;

    @FXML
    private TextField TextField_IDdeLaCuenta;


    @FXML
    private ComboBox<TipoCuenta> cmb_select_tipoCuenta;

    @FXML
    private TextField TextField_AgregarBancoCuenta;

    @FXML
    void onClick_AtrasMenuCuentas(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuAgregarCuentas.getParent();

            PantallaPrincipalUsuarioViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/cuentasUsuario.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void onClick_anadirCuenta(ActionEvent event) {
        String idCuenta = TextField_IDdeLaCuenta.getText();
        String bancoCuenta = TextField_AgregarBancoCuenta.getText();
        String numeroCuenta = TextField_AgregarNumeroCuenta.getText();
        TipoCuenta tipoCuenta = cmb_select_tipoCuenta.getSelectionModel().getSelectedItem();
        double saldoCuenta = 0;


        GestorCuentas.getInstancia().crearCuenta(idCuenta, bancoCuenta, numeroCuenta, tipoCuenta);

        Cuenta cuentaAgregada = GestorCuentas.getInstancia().obtenerCuentaUsuario(idCuenta);

        if(cuentaAgregada != null){
            Label_BancoCuenta.setText(cuentaAgregada.getNombreBanco());
            Label_NumeroCuenta.setText(cuentaAgregada.getNumeroCuenta());
            Label_SaldoCuenta.setText(String.format("$ %.2f", cuentaAgregada.getSaldoTotal()));

        }
    }

    private void cargarComboBoxTipoCuenta() {
        cmb_select_tipoCuenta.setItems(FXCollections.observableArrayList(TipoCuenta.values()));
        cmb_select_tipoCuenta.getSelectionModel().selectFirst();
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuAgregarCuentas != null : "fx:id=\"AnchorPane_MenuAgregarCuentas\" was not injected: check your FXML file 'agregarCuenta.fxml'.";
        assert Button_AnadirCuenta != null : "fx:id=\"Button_AnadirCuenta\" was not injected: check your FXML file 'agregarCuenta.fxml'.";
        assert Button_AtrasMenuCuentas != null : "fx:id=\"Button_AtrasMenuCuentas\" was not injected: check your FXML file 'agregarCuenta.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'agregarCuenta.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'agregarCuenta.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'agregarCuenta.fxml'.";
        assert TextField_AgregarBancoCuenta != null : "fx:id=\"TextField_AgregarBancoCuenta\" was not injected: check your FXML file 'agregarCuenta.fxml'.";
        assert TextField_AgregarNumeroCuenta != null : "fx:id=\"TextField_AgregarNumeroCuenta\" was not injected: check your FXML file 'agregarCuenta.fxml'.";

        cargarComboBoxTipoCuenta();

    }


}
