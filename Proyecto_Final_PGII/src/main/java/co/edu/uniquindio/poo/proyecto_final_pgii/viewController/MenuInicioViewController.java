package co.edu.uniquindio.poo.proyecto_final_pgii.viewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorPerfiles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import co.edu.uniquindio.poo.proyecto_final_pgii.app.App;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;

public class MenuInicioViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Button_IniciarSesion;

    @FXML
    private Button Button_Registrarse;


    @FXML
    private PasswordField TextField_IngresarContrasenia;

    @FXML
    private TextField TextField_IngresarEmail;

    /**
     * Maneja el eento de incio de sesion
     * @param event
     */
    @FXML
    void onClick_IniciarSesion(ActionEvent event) {
        String email = TextField_IngresarEmail.getText();
        String contrasenia = TextField_IngresarContrasenia.getText();

        if (email.isEmpty() || contrasenia.isEmpty()) {
            mostrarAlerta("Por favor, complete todos los campos.");
            return;
        }

        boolean sesionIniciada = GestorPerfiles.getInstancia().autenticar(email, contrasenia);

        if (!sesionIniciada) {
            mostrarAlerta("Credenciales incorrectas. Por favor, intente nuevamente.");
            return;
        }

        if (sesionIniciada) {

            if (GestorSesion.getInstancia().esAdministrador()) {
                try {
                    App.cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/pantallaPrincipalAdministrador.fxml", event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (GestorSesion.getInstancia().esUsuario()) {
                try {
                    App.cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/pantallaPrincipalUsuario.fxml", event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No se pudo iniciar sesión.");
            }
        }
    }

    /**
     * Maneja el evento para ir a la pantala de registro
     * @param event
     */
    @FXML
    void onClick_Registrarse(ActionEvent event) {
        try {
            App.cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/menuRegistrarse.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Metodo de inicializacion llamado automaticamente al cargar la vista
     * Verifica que todos los componentes esten correctamente inyectados
     */
    @FXML
    void initialize() {
        assert Button_IniciarSesion != null : "fx:id=\"Button_IniciarSesion\" was not injected: check your FXML file 'menuInicio.fxml'.";
        assert Button_Registrarse != null : "fx:id=\"Button_Registrarse\" was not injected: check your FXML file 'menuInicio.fxml'.";
        assert TextField_IngresarContrasenia != null : "fx:id=\"TextField_IngresarContrasenia\" was not injected: check your FXML file 'menuInicio.fxml'.";
        assert TextField_IngresarEmail != null : "fx:id=\"TextField_IngresarEmail\" was not injected: check your FXML file 'menuInicio.fxml'.";

    }

    /**
     * Muestra una alerta de error con el mensaje proporcionado.
     * @param mensaje Mensaje a mostrar en la alerta.
     */
    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
