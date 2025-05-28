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


    /**
     * Maneja el evento de click sobre el boton actualizar perfil
     * obtiene los valores de los campos de texto y actualiza el perfil del usuario actual
     * @param event
     */
    @FXML
    void onClick_ActualizarPerfil(ActionEvent event) {
        GestorPerfiles gestorPerfiles = GestorPerfiles.getInstancia();
        Usuario usuario = GestorSesion.getInstancia().getUsuarioActual();

        if (usuario != null) {
            String nuevoNombre = TextField_AgregarNombreUsuario.getText();
            String nuevoEmail = TextField_AgregarEmailUsuario.getText();
            String nuevoTelefono = TextField_AgregarNumeroTelefonoUsuario.getText();

            String idUsuario = usuario.getIdUsuario();


            gestorPerfiles.actualizarUsuario(idUsuario, nuevoNombre,null,  nuevoEmail, nuevoTelefono, null, null);

            System.out.println("Perfil actualizado correctamente");
        }
    }

    /**
     * Metodo de inicializacion llamado automaticamente al cargar la vista
     * Verifica que todos los componentes esten correctamente inyectados
     */
    @FXML
    void initialize() {
        assert AnchorPane_MenuPerfil != null : "fx:id=\"AnchorPane_MenuPerfil\" was not injected: check your FXML file 'perfilUsuario.fxml'.";
        assert Button_ActualizarPerfil != null : "fx:id=\"Button_ActualizarPerfil\" was not injected: check your FXML file 'perfilUsuario.fxml'.";
        assert TextField_AgregarEmailUsuario != null : "fx:id=\"TextField_AgregarEmailUsuario\" was not injected: check your FXML file 'perfilUsuario.fxml'.";
        assert TextField_AgregarNombreUsuario != null : "fx:id=\"TextField_AgregarNombreUsuario\" was not injected: check your FXML file 'perfilUsuario.fxml'.";
        assert TextField_AgregarNumeroTelefonoUsuario != null : "fx:id=\"TextField_AgregarNumeroTelefonoUsuario\" was not injected: check your FXML file 'perfilUsuario.fxml'.";

        // Obtener el usuario actual de la sesión
        Usuario usuarioActual = GestorSesion.getInstancia().getUsuarioActual();

        // Verificar si hay un usuario en sesión
        if (usuarioActual != null) {
            // Establecer los datos del usuario en los campos de texto
            TextField_AgregarNombreUsuario.setText(usuarioActual.getNombres());
            TextField_AgregarEmailUsuario.setText(usuarioActual.getEmail());
            TextField_AgregarNumeroTelefonoUsuario.setText(usuarioActual.getTelefono());
        }



    }

}

