package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario.PantallaPrincipalUsuarioViewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CrearPresupuestoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuCrearPresupuesto;

    @FXML
    private Button Button_AtrasMenuPresupuesto;

    @FXML
    private Button Button_CrearPresupuesto;

    @FXML
    private Label Label_SaldoTotal;

    @FXML
    private TextField TextField_AgregarCategoriaPresupuesto;

    @FXML
    private TextField TextField_AgregarIDPresupuesto;

    @FXML
    private TextField TextField_AgregarMontoGastadoPresupuesto;

    @FXML
    private TextField TextField_AgregarMontoTotalPresupuesto;

    @FXML
    private TextField TextField_AgregarNombrePresupuesto;

    @FXML
    void onClick_AtrasMenuPresupuesto(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyecto_final_pgii/presupuestoUsuario.fxml"));
            Parent vista = loader.load();
            AnchorPane_MenuCrearPresupuesto.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_CrearPresupuesto(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuCrearPresupuesto != null : "fx:id=\"AnchorPane_MenuCrearPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert Button_AtrasMenuPresupuesto != null : "fx:id=\"Button_AtrasMenuPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert Button_CrearPresupuesto != null : "fx:id=\"Button_CrearPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert Label_SaldoTotal != null : "fx:id=\"Label_SaldoTotal\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert TextField_AgregarCategoriaPresupuesto != null : "fx:id=\"TextField_AgregarCategoriaPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert TextField_AgregarIDPresupuesto != null : "fx:id=\"TextField_AgregarIDPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert TextField_AgregarMontoGastadoPresupuesto != null : "fx:id=\"TextField_AgregarMontoGastadoPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert TextField_AgregarMontoTotalPresupuesto != null : "fx:id=\"TextField_AgregarMontoTotalPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert TextField_AgregarNombrePresupuesto != null : "fx:id=\"TextField_AgregarNombrePresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";

    }

}
