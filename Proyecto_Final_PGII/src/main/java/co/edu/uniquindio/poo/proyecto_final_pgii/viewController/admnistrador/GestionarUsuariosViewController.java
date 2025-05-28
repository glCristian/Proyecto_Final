package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.BilleteraVirtual;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.GestorSesion;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Persona;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorPerfiles;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ListView<Usuario> TableView_Usuarios;

    private Usuario usuarioSeleccionado;

    @FXML
    void onClick_ActualizarUsuario(ActionEvent event) {
        usuarioSeleccionado = TableView_Usuarios.getSelectionModel().getSelectedItem();

        DatosCompartidos.getInstancia().setUsuarioSeleccionado(usuarioSeleccionado);

        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/actualizarUsuario.fxml");
    }

    @FXML
    void onClick_CrearUsuario(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/crearUsuario.fxml");
    }

    @FXML
    void onClick_EliminarUsuario(ActionEvent event) {
        usuarioSeleccionado = TableView_Usuarios.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado != null){
            GestorPerfiles.getInstancia().eliminarPerfil(usuarioSeleccionado.getIdUsuario());
            actualizarTableViewUsuarios();
        }
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuGestionarUsuarios != null : "fx:id=\"AnchorPane_MenuGestionarUsuarios\" was not injected: check your FXML file 'gestionarUsuarios.fxml'.";
        assert Button_ActulizarUsuario != null : "fx:id=\"Button_ActulizarUsuario\" was not injected: check your FXML file 'gestionarUsuarios.fxml'.";
        assert Button_CrearUsuario != null : "fx:id=\"Button_CrearUsuario\" was not injected: check your FXML file 'gestionarUsuarios.fxml'.";
        assert Button_EliminarUsuario != null : "fx:id=\"Button_EliminarUsuario\" was not injected: check your FXML file 'gestionarUsuarios.fxml'.";
        assert TableView_Usuarios != null : "fx:id=\"TableView_Usuarios\" was not injected: check your FXML file 'gestionarUsuarios.fxml'.";

        cargarUsuarios();
    }

    /**
     * Carga la vista especificada en el AnchorPane_MenuGestionarUsuarios.
     *
     * @param nombreFXML Ruta del archivo FXML a cargar.
     */
    private void cargarVista(String nombreFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreFXML));
            Parent vista = loader.load();
            AnchorPane_MenuGestionarUsuarios.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga los usuarios desde la BilleteraVirtual y los muestra en el TableView.
     */
    private void cargarUsuarios() {
        List<Usuario> listaUsuarios = BilleteraVirtual.getInstancia().getPerfiles().stream()
                .filter(p -> p instanceof Usuario)
                .map(p -> (Usuario) p)
                .toList();

        ObservableList<Usuario> usuarios = FXCollections.observableArrayList(listaUsuarios);
        TableView_Usuarios.setItems(usuarios);
    }


    /**
     * Actualiza el TableView de usuarios con la lista actualizada de usuarios.
     */
    public void actualizarTableViewUsuarios(){
        List<Usuario> listaUsuariosActualizados = BilleteraVirtual.getInstancia().getPerfiles().stream()
                .filter(p -> p instanceof Usuario)
                .map(p -> (Usuario) p).toList();

        ObservableList<Usuario> usuariosActualizados = FXCollections.observableArrayList(listaUsuariosActualizados);
        TableView_Usuarios.setItems(usuariosActualizados);
    }
}
