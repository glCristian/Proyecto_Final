package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ActualizarPresupuestoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuActualizarPresupuesto;

    @FXML
    private Button Button_ActualizarPresupuesto;

    @FXML
    private Button Button_AtrasMenuPresupuesto;

    @FXML
    private Label Label_SaldoPresupuesto;

    @FXML
    private TextField TextField_AgregarCategoriaPresupuesto;

    @FXML
    private TextField TextField_AgregarIDPresupuesto;

    @FXML
    private TextField TextField_AgregarMontoTotalPresupuesto;

    @FXML
    private TextField TextField_AgregarNombrePresupuesto;

    @FXML
    void onClick_ActualizarPresupuesto(ActionEvent event) {

    }

    @FXML
    void onClick_AtrasMenuPresupuesto(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuActualizarPresupuesto != null : "fx:id=\"AnchorPane_MenuActualizarPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert Button_ActualizarPresupuesto != null : "fx:id=\"Button_ActualizarPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert Button_AtrasMenuPresupuesto != null : "fx:id=\"Button_AtrasMenuPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert Label_SaldoPresupuesto != null : "fx:id=\"Label_SaldoPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert TextField_AgregarCategoriaPresupuesto != null : "fx:id=\"TextField_AgregarCategoriaPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert TextField_AgregarIDPresupuesto != null : "fx:id=\"TextField_AgregarIDPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert TextField_AgregarMontoTotalPresupuesto != null : "fx:id=\"TextField_AgregarMontoTotalPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert TextField_AgregarNombrePresupuesto != null : "fx:id=\"TextField_AgregarNombrePresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";

    }

}
