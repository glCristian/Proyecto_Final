package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
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
    private ListView<Cuenta> TableView_CuentasTransaccion;

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

        cargarCuentas();
        configurarSeleccionCuenta();

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





    /**
     * carga las cuentas del usuario en la listViw para su selecciom
     */
    private void cargarCuentas(){
        List<Cuenta> todasLasCuentas = new ArrayList<>();

        for (Persona persona : BilleteraVirtual.getInstancia().getPerfiles()) {
            if (persona instanceof Usuario usuario) {
                todasLasCuentas.addAll(usuario.getListaCuentas());
            }
        }

        TableView_CuentasTransaccion.setItems(FXCollections.observableArrayList(todasLasCuentas));
    }

    /**
     * Configura el comportamiento al seleccionar una cuenta en la lista
     */
    private void configurarSeleccionCuenta(){
        TableView_CuentasTransaccion.setOnMouseClicked(mouseEvent -> {
            Cuenta cuentaSeleccionada = TableView_CuentasTransaccion.getSelectionModel().getSelectedItem();
            if (cuentaSeleccionada != null)
                Label_BancoCuenta.setText(cuentaSeleccionada.getNombreBanco());
            Label_NumeroCuenta.setText(cuentaSeleccionada.getNumeroCuenta());
            Label_SaldoCuenta.setText(String.format("$ %.2f", cuentaSeleccionada.getSaldoTotal()));

            DatosCompartidos.getInstancia().setCuentaSeleccionada(cuentaSeleccionada);
        });
    }

}
