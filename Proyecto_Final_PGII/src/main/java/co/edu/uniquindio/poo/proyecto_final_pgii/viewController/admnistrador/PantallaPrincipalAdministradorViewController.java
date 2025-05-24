package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class PantallaPrincipalAdministradorViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_PantallaPrincipalAdministrador;

    @FXML
    private Button Button_CerrarSesionAdmin;

    @FXML
    private Button Button_MenuCuentas;

    @FXML
    private Button Button_MenuEstadisticas;

    @FXML
    private Button Button_MenuTransaccion;

    @FXML
    private Button Button_MenuUsuarios;

    @FXML
    private ListView<?> TableView_Usuarios;

    @FXML
    void onClick_CerrarSesionAdmin(ActionEvent event) {

    }

    @FXML
    void onClick_MenuCuentas(ActionEvent event) {

    }

    @FXML
    void onClick_MenuEstadisticas(ActionEvent event) {

    }

    @FXML
    void onClick_MenuTransaccion(ActionEvent event) {

    }

    @FXML
    void onClick_MenuUsuarios(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPane_PantallaPrincipalAdministrador != null : "fx:id=\"AnchorPane_PantallaPrincipalAdministrador\" was not injected: check your FXML file 'pantallaPrincipalAdministrador.fxml'.";
        assert Button_CerrarSesionAdmin != null : "fx:id=\"Button_CerrarSesionAdmin\" was not injected: check your FXML file 'pantallaPrincipalAdministrador.fxml'.";
        assert Button_MenuCuentas != null : "fx:id=\"Button_MenuCuentas\" was not injected: check your FXML file 'pantallaPrincipalAdministrador.fxml'.";
        assert Button_MenuEstadisticas != null : "fx:id=\"Button_MenuEstadisticas\" was not injected: check your FXML file 'pantallaPrincipalAdministrador.fxml'.";
        assert Button_MenuTransaccion != null : "fx:id=\"Button_MenuTransaccion\" was not injected: check your FXML file 'pantallaPrincipalAdministrador.fxml'.";
        assert Button_MenuUsuarios != null : "fx:id=\"Button_MenuUsuarios\" was not injected: check your FXML file 'pantallaPrincipalAdministrador.fxml'.";
        assert TableView_Usuarios != null : "fx:id=\"TableView_Usuarios\" was not injected: check your FXML file 'pantallaPrincipalAdministrador.fxml'.";

    }

}

