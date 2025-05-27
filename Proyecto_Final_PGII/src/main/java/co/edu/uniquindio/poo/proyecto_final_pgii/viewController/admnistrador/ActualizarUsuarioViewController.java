package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.DatosCompartidos;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.GestorSesion;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Usuario;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorPerfiles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ActualizarUsuarioViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuActualizaUsuario;

    @FXML
    private Button Button_ActualizarUsuario;

    @FXML
    private Button Button_AtrasMenuUsuarios;

    @FXML
    private TextField TextField_AgregarDireccionUsuario;

    @FXML
    private TextField TextField_AgregarEmailUsuario;

    @FXML
    private TextField TextField_AgregarNombreUsuario1;

    @FXML
    private TextField TextField_AgregarNumeroTelefonoUsuario;

    @FXML
    void onClick_ActualizarUsuario(ActionEvent event) {
        GestorPerfiles gestorPerfiles = GestorPerfiles.getInstancia();
        Usuario usuario = DatosCompartidos.getInstancia().getUsuarioSeleccionado();

        if (usuario != null) {
            String nuevoNombre = TextField_AgregarNombreUsuario1.getText();
            String nuevoEmail = TextField_AgregarEmailUsuario.getText();
            String nuevoTelefono = TextField_AgregarNumeroTelefonoUsuario.getText();
            String nuevaDireccion = TextField_AgregarDireccionUsuario.getText();

            gestorPerfiles.actualizarUsuario(usuario.getIdUsuario(), nuevoNombre,null,  nuevoEmail, nuevoTelefono, nuevaDireccion, null);

            System.out.println("Perfil actualizado correctamente");
        }
    }

    @FXML
    void onClick_AtrasMenuUsuarios(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuActualizaUsuario.getParent();

            PantallaPrincipalAdministradorViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/gestionarUsuarios.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuActualizaUsuario != null : "fx:id=\"AnchorPane_MenuActualizaUsuario\" was not injected: check your FXML file 'actualizarUsuario.fxml'.";
        assert Button_ActualizarUsuario != null : "fx:id=\"Button_ActualizarUsuario\" was not injected: check your FXML file 'actualizarUsuario.fxml'.";
        assert Button_AtrasMenuUsuarios != null : "fx:id=\"Button_AtrasMenuUsuarios\" was not injected: check your FXML file 'actualizarUsuario.fxml'.";
        assert TextField_AgregarDireccionUsuario != null : "fx:id=\"TextField_AgregarDireccionUsuario\" was not injected: check your FXML file 'actualizarUsuario.fxml'.";
        assert TextField_AgregarEmailUsuario != null : "fx:id=\"TextField_AgregarEmailUsuario\" was not injected: check your FXML file 'actualizarUsuario.fxml'.";
        assert TextField_AgregarNombreUsuario1 != null : "fx:id=\"TextField_AgregarNombreUsuario1\" was not injected: check your FXML file 'actualizarUsuario.fxml'.";
        assert TextField_AgregarNumeroTelefonoUsuario != null : "fx:id=\"TextField_AgregarNumeroTelefonoUsuario\" was not injected: check your FXML file 'actualizarUsuario.fxml'.";

    }

}
