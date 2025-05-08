package co.edu.uniquindio.poo.proyecto_final_pgii.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuRegistrarseViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Button_AtrasMenuInicio;

    @FXML
    private Button Button_Registrarse;

    @FXML
    private TextField TextField_IngresarApellidos;

    @FXML
    private TextField TextField_IngresarCrearContrasenia;

    @FXML
    private TextField TextField_IngresarEmail;

    @FXML
    private TextField TextField_IngresarNombres;

    @FXML
    private TextField TextField_IngresarTelefono;

    @FXML
    void onClick_AtrasMenuInicio(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyecto_final_pgii/menuInicio.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));

            Stage currentStage = (Stage) Button_AtrasMenuInicio.getScene().getWindow();
            currentStage.close();

            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_Registrarse(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Button_AtrasMenuInicio != null : "fx:id=\"Button_AtrasMenuInicio\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";
        assert Button_Registrarse != null : "fx:id=\"Button_Registrarse\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";
        assert TextField_IngresarApellidos != null : "fx:id=\"TextField_IngresarApellidos\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";
        assert TextField_IngresarCrearContrasenia != null : "fx:id=\"TextField_IngresarCrearContrasenia\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";
        assert TextField_IngresarEmail != null : "fx:id=\"TextField_IngresarEmail\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";
        assert TextField_IngresarNombres != null : "fx:id=\"TextField_IngresarNombres\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";
        assert TextField_IngresarTelefono != null : "fx:id=\"TextField_IngresarTelefono\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";

    }
}
