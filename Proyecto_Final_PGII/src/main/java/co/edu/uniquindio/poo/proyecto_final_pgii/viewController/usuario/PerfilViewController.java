package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.GestorSesion;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Usuario;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorCuentas;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorPerfiles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PerfilViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuPerfil;

    @FXML
    private Button Button_ActualizarPerfil;

    @FXML
    private TextField TextField_AgregarEmailUsuario;

    @FXML
    private TextField TextField_AgregarNombreUsuario;

    @FXML
    private TextField TextField_AgregarNumeroTelefonoUsuario;


    @FXML
    void onClick_ActualizarPerfil(ActionEvent event) {
        GestorPerfiles gestorPerfiles = GestorPerfiles.getInstancia();
        Usuario usuario = GestorSesion.getInstancia().getUsuarioActual();

        if (usuario != null) {
            String nuevoNombre = TextField_AgregarNombreUsuario.getText();
            String nuevoEmail = TextField_AgregarEmailUsuario.getText();
            String nuevoTelefono = TextField_AgregarNumeroTelefonoUsuario.getText();

            gestorPerfiles.actualizarUsuario(null, nuevoNombre,null,  nuevoEmail, nuevoTelefono, null, null);

            System.out.println("Perfil actualizado correctamente");
        }
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuPerfil != null : "fx:id=\"AnchorPane_MenuPerfil\" was not injected: check your FXML file 'perfilUsuario.fxml'.";
        assert Button_ActualizarPerfil != null : "fx:id=\"Button_ActualizarPerfil\" was not injected: check your FXML file 'perfilUsuario.fxml'.";
        assert TextField_AgregarEmailUsuario != null : "fx:id=\"TextField_AgregarEmailUsuario\" was not injected: check your FXML file 'perfilUsuario.fxml'.";
        assert TextField_AgregarNombreUsuario != null : "fx:id=\"TextField_AgregarNombreUsuario\" was not injected: check your FXML file 'perfilUsuario.fxml'.";
        assert TextField_AgregarNumeroTelefonoUsuario != null : "fx:id=\"TextField_AgregarNumeroTelefonoUsuario\" was not injected: check your FXML file 'perfilUsuario.fxml'.";
    }

}

