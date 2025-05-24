package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CrearUsuarioViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuCrearUsuario;

    @FXML
    private Button Button_AtrasMenuUsuarios;

    @FXML
    private Button Button_CrearUsuario;

    @FXML
    private TextField TextField_AgregarApellidosUsuario;

    @FXML
    private TextField TextField_AgregarDireccionUsuario;

    @FXML
    private TextField TextField_AgregarEmailUsuario;

    @FXML
    private TextField TextField_AgregarIDUsuario;

    @FXML
    private TextField TextField_AgregarNombreUsuario1;

    @FXML
    private TextField TextField_AgregarNumeroTelefonoUsuario;

    @FXML
    void onClick_AtrasMenuUsuarios(ActionEvent event) {

    }

    @FXML
    void onClick_CrearUsuario(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuCrearUsuario != null : "fx:id=\"AnchorPane_MenuCrearUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert Button_AtrasMenuUsuarios != null : "fx:id=\"Button_AtrasMenuUsuarios\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert Button_CrearUsuario != null : "fx:id=\"Button_CrearUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert TextField_AgregarApellidosUsuario != null : "fx:id=\"TextField_AgregarApellidosUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert TextField_AgregarDireccionUsuario != null : "fx:id=\"TextField_AgregarDireccionUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert TextField_AgregarEmailUsuario != null : "fx:id=\"TextField_AgregarEmailUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert TextField_AgregarIDUsuario != null : "fx:id=\"TextField_AgregarIDUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert TextField_AgregarNombreUsuario1 != null : "fx:id=\"TextField_AgregarNombreUsuario1\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert TextField_AgregarNumeroTelefonoUsuario != null : "fx:id=\"TextField_AgregarNumeroTelefonoUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";

    }

}
