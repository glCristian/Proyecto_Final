package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.BilleteraVirtual;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorCuentas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class GestionarCuentasViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuCuentas;

    @FXML
    private Button Button_ActualizarCuenta;

    @FXML
    private Button Button_AnadirCuenta;

    @FXML
    private Button Button_EliminarCuenta;

    @FXML
    private Label Label_BancoCuenta;

    @FXML
    private Label Label_NumeroCuenta;

    @FXML
    private Label Label_SaldoCuenta;

    @FXML
    private ListView<Cuenta> ListView_Cuentas;

    private Cuenta cuentaSeleccionada;

    @FXML
    void onClick_ActualizarCuenta(ActionEvent event) {
        cuentaSeleccionada = ListView_Cuentas.getSelectionModel().getSelectedItem();
        if (cuentaSeleccionada != null){
            DatosCompartidos.getInstancia().setCuentaSeleccionada(cuentaSeleccionada);

            cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/actualizarCuentaAdmin.fxml");
        }
    }




    @FXML
    void onClick_EliminarCuenta(ActionEvent event) {
        cuentaSeleccionada = ListView_Cuentas.getSelectionModel().getSelectedItem();
        if (cuentaSeleccionada != null){
            GestorCuentas.getInstancia().eliminarCuentagenerico(cuentaSeleccionada);
            actualizarListViewCuentas();
        }
    }

    @FXML
    void onClick_anadirCuenta(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/agregarCuentaAdmin.fxml");
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuCuentas != null : "fx:id=\"AnchorPane_MenuCuentas\" was not injected: check your FXML file 'gestionarCuentas.fxml'.";
        assert Button_ActualizarCuenta != null : "fx:id=\"Button_ActualizarCuenta\" was not injected: check your FXML file 'gestionarCuentas.fxml'.";
        assert Button_AnadirCuenta != null : "fx:id=\"Button_AnadirCuenta\" was not injected: check your FXML file 'gestionarCuentas.fxml'.";
        assert Button_EliminarCuenta != null : "fx:id=\"Button_EliminarCuenta\" was not injected: check your FXML file 'gestionarCuentas.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'gestionarCuentas.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'gestionarCuentas.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'gestionarCuentas.fxml'.";
        assert ListView_Cuentas != null : "fx:id=\"ListView_Cuentas\" was not injected: check your FXML file 'gestionarCuentas.fxml'.";

        mostrarDatos();
        cargarCuentas();
    }

    private void cargarVista(String nombreFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreFXML));
            Parent vista = loader.load();
            AnchorPane_MenuCuentas.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarCuentas(){
        ObservableList<Cuenta> cuentas = FXCollections.observableArrayList(BilleteraVirtual.getInstancia().getCuentas());
        ListView_Cuentas.setItems(cuentas);
    }

    public void mostrarDatos(){
        ListView_Cuentas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            cuentaSeleccionada = newSelection;
            mostrarDatosCuentaSeleccionada();
        });
    }

    private void mostrarDatosCuentaSeleccionada() {
        if (cuentaSeleccionada != null) {
            Label_BancoCuenta.setText(cuentaSeleccionada.getNombreBanco());
            Label_NumeroCuenta.setText(cuentaSeleccionada.getNumeroCuenta());
            Label_SaldoCuenta.setText(String.format("%.2f", cuentaSeleccionada.getSaldoTotal()));
        } else {
            // Si no hay cuenta seleccionada, limpiar labels
            Label_BancoCuenta.setText("");
            Label_NumeroCuenta.setText("");
            Label_SaldoCuenta.setText("");
        }
    }

    public void actualizarListViewCuentas (){
            ObservableList<Cuenta> cuentasActualizadas = FXCollections.observableArrayList(BilleteraVirtual.getInstancia().getCuentas());
            ListView_Cuentas.setItems(cuentasActualizadas);

    }
}

