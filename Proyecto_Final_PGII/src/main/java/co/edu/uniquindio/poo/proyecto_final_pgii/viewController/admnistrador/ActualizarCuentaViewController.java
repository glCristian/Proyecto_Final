package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;


import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.Cuenta;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.DatosCompartidos;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.TipoCuenta;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ActualizarCuentaViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuActualizarCuenta;

    @FXML
    private Button Button_ActualizarCuenta;

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
    private ComboBox<TipoCuenta> cmb_select_tipoCuenta;

    @FXML
    void onClick_ActualizarCuenta(ActionEvent event) {
        Cuenta cuenta = DatosCompartidos.getInstancia().getCuentaSeleccionada();

        if (cuenta != null){
            String nuevoBanco = TextField_AgregarBancoCuenta.getText();
            TipoCuenta nuevoTipoCuenta = cmb_select_tipoCuenta.getValue();

            if (nuevoBanco != null && !nuevoBanco.isBlank()){
                cuenta.setNombreBanco(nuevoBanco);
            }

            if(nuevoTipoCuenta != null){
                cuenta.setTipoCuenta(nuevoTipoCuenta);
            }

            Label_BancoCuenta.setText(cuenta.getNombreBanco());
            Label_NumeroCuenta.setText(cuenta.getNumeroCuenta());
            Label_SaldoCuenta.setText(String.format("$ %.2f", cuenta.getSaldoTotal()));
        }
    }

    @FXML
    void onClick_AtrasMenuCuentas(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuActualizarCuenta.getParent();

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
        assert AnchorPane_MenuActualizarCuenta != null : "fx:id=\"AnchorPane_MenuActualizarCuenta\" was not injected: check your FXML file 'actualizarCuentaAdmin.fxml'.";
        assert Button_ActualizarCuenta != null : "fx:id=\"Button_ActualizarCuenta\" was not injected: check your FXML file 'actualizarCuentaAdmin.fxml'.";
        assert Button_AtrasMenuCuentas != null : "fx:id=\"Button_AtrasMenuCuentas\" was not injected: check your FXML file 'actualizarCuentaAdmin.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'actualizarCuentaAdmin.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'actualizarCuentaAdmin.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'actualizarCuentaAdmin.fxml'.";
        assert TextField_AgregarBancoCuenta != null : "fx:id=\"TextField_AgregarBancoCuenta\" was not injected: check your FXML file 'actualizarCuentaAdmin.fxml'.";
        assert cmb_select_tipoCuenta != null : "fx:id=\"cmb_select_tipoCuenta\" was not injected: check your FXML file 'actualizarCuentaAdmin.fxml'.";

        cargarComboBoxTipoCuenta();
    }

    private void cargarComboBoxTipoCuenta() {
        cmb_select_tipoCuenta.setItems(FXCollections.observableArrayList(TipoCuenta.values()));
        cmb_select_tipoCuenta.getSelectionModel().selectFirst();
    }

}
