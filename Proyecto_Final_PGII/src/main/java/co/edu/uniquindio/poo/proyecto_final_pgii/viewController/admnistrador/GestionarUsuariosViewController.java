package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/actualizarUsuario.fxml");
    }

    @FXML
    void onClick_CrearUsuario(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/crearUsuario.fxml");
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

    private void cargarVista(String nombreFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreFXML));
            Parent vista = loader.load();
            AnchorPane_MenuGestionarUsuarios.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
