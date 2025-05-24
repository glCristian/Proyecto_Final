package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class GestionarUsuariosViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuGestionarUsuarios;

    @FXML
    private Button Button_ActulizarUsuario;

    @FXML
    private Button Button_CrearUsuario;

    @FXML
    private Button Button_EliminarUsuario;

    @FXML
    private ListView<?> TableView_Usuarios;

    @FXML
    void onClick_ActualizarUsuario(ActionEvent event) {

    }

    @FXML
    void onClick_CrearUsuario(ActionEvent event) {

    }

    @FXML
    void onClick_EliminarUsuario(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuGestionarUsuarios != null : "fx:id=\"AnchorPane_MenuGestionarUsuarios\" was not injected: check your FXML file 'gestionarUsuarios.fxml'.";
        assert Button_ActulizarUsuario != null : "fx:id=\"Button_ActulizarUsuario\" was not injected: check your FXML file 'gestionarUsuarios.fxml'.";
        assert Button_CrearUsuario != null : "fx:id=\"Button_CrearUsuario\" was not injected: check your FXML file 'gestionarUsuarios.fxml'.";
        assert Button_EliminarUsuario != null : "fx:id=\"Button_EliminarUsuario\" was not injected: check your FXML file 'gestionarUsuarios.fxml'.";
        assert TableView_Usuarios != null : "fx:id=\"TableView_Usuarios\" was not injected: check your FXML file 'gestionarUsuarios.fxml'.";

    }

}
