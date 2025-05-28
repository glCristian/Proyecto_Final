package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import co.edu.uniquindio.poo.proyecto_final_pgii.app.App;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
import co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario.PantallaPrincipalUsuarioViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    private ListView<Usuario> TableView_Usuarios;

    @FXML
    void onClick_CerrarSesionAdmin(ActionEvent event) {
        GestorSesion.getInstancia().cerrarSesion();
        DatosCompartidos.getInstancia().limpiarDatosCompartidos();
        try {
            App.cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/menuInicio.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_MenuCuentas(ActionEvent event) {
        cargarVistaEnPantallaPrincipal(AnchorPane_PantallaPrincipalAdministrador,"/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/gestionarCuentas.fxml");
    }

    @FXML
    void onClick_MenuEstadisticas(ActionEvent event) {
        cargarVistaEnPantallaPrincipal(AnchorPane_PantallaPrincipalAdministrador, "/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/estadisticas.fxml");
    }

    @FXML
    void onClick_MenuTransaccion(ActionEvent event) {
        cargarVistaEnPantallaPrincipal(AnchorPane_PantallaPrincipalAdministrador, "/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/gestionarTransacciones.fxml");
    }

    @FXML
    void onClick_MenuUsuarios(ActionEvent event) {
        cargarVistaEnPantallaPrincipal(AnchorPane_PantallaPrincipalAdministrador, "/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/gestionarUsuarios.fxml");
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

        cargarUsuariosEnListView();
    }

    public static void cargarVistaEnPantallaPrincipal(AnchorPane contenedor, String nombreFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(PantallaPrincipalUsuarioViewController.class.getResource(nombreFXML));
            Parent vista = loader.load();
            contenedor.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarUsuariosEnListView() {
        // Obtener todos los perfiles registrados
        Collection<Persona> perfiles = BilleteraVirtual.getInstancia().getPerfiles();

        // Filtrar solo los usuarios
        List<Usuario> usuarios = perfiles.stream()
                .filter(p -> p instanceof Usuario)
                .map(p -> (Usuario) p)
                .collect(Collectors.toList());

        // Convertir a ObservableList para JavaFX
        ObservableList<Usuario> observableUsuarios = FXCollections.observableArrayList(usuarios);

        // Asignar la lista al ListView
        TableView_Usuarios.setItems(observableUsuarios);
    }

}

