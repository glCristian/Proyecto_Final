package co.edu.uniquindio.poo.proyecto_final_pgii.viewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private TextField TextField_IngresarContrasenia;

    @FXML
    private TextField TextField_IngresarEmail;

    @FXML
    void onClick_IniciarSesion(ActionEvent event) {

    }

    @FXML
    void onClick_Registrarse(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyecto_final_pgii/menuRegistrarse.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert Button_IniciarSesion != null : "fx:id=\"Button_IniciarSesion\" was not injected: check your FXML file 'menuInicio.fxml'.";
        assert Button_Registrarse != null : "fx:id=\"Button_Registrarse\" was not injected: check your FXML file 'menuInicio.fxml'.";
        assert TextField_IngresarContrasenia != null : "fx:id=\"TextField_IngresarContrasenia\" was not injected: check your FXML file 'menuInicio.fxml'.";
        assert TextField_IngresarEmail != null : "fx:id=\"TextField_IngresarEmail\" was not injected: check your FXML file 'menuInicio.fxml'.";

    }

}
