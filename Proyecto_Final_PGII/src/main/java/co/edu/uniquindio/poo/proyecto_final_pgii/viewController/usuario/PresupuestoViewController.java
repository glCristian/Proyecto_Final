package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.GestorSesion;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Presupuesto;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class PresupuestoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuPresupuesto;

    @FXML
    private Button Button_CrearPresupuesto;

    @FXML
    private Button Button_EliminarPresupuesto;

    @FXML
    private Button Button_ModificarPresupuesto;

    @FXML
    private ListView<Presupuesto> TableView_Presupuestos;


    @FXML
    void onClick_CrearPresupuesto(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/crearPresupuestoUsuario.fxml");
    }

    @FXML
    void onClick_EliminarPresupuesto(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/eliminarPresupuestoUsuario.fxml");
    }


    @FXML
    void onClick_ModificarPresupuesto(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/actualizarPresupuestoUsuario.fxml");
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuPresupuesto != null : "fx:id=\"AnchorPane_MenuPresupuesto\" was not injected: check your FXML file 'presupuestoUsuario.fxml'.";
        assert Button_CrearPresupuesto != null : "fx:id=\"Button_CrearPresupuesto\" was not injected: check your FXML file 'presupuestoUsuario.fxml'.";
        assert Button_EliminarPresupuesto != null : "fx:id=\"Button_EliminarPresupuesto\" was not injected: check your FXML file 'presupuestoUsuario.fxml'.";
        assert Button_ModificarPresupuesto != null : "fx:id=\"Button_ModificarPresupuesto\" was not injected: check your FXML file 'presupuestoUsuario.fxml'.";
        assert TableView_Presupuestos != null : "fx:id=\"TableView_Presupuestos\" was not injected: check your FXML file 'presupuestoUsuario.fxml'.";

        cargarPresupuestos();
    }

    private void cargarVista(String nombreFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreFXML));
            Parent vista = loader.load();
            AnchorPane_MenuPresupuesto.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void cargarPresupuestos(){
        Usuario usuarioActual = GestorSesion.getInstancia().getUsuarioActual();

        if (usuarioActual != null){
            TableView_Presupuestos.getItems().clear();
            TableView_Presupuestos.getItems().addAll(usuarioActual.getListaPresupuestos());
        }
    }
}

