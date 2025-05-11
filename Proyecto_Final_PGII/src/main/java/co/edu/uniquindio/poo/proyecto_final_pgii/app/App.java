package co.edu.uniquindio.poo.proyecto_final_pgii.app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/co/edu/uniquindio/poo/proyecto_final_pgii/menuInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Inicio");
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Metodo estático para cargar vistas FXML desde cualquier parte de la aplicación
     * @param rutaFXML Ruta del archivo FXML a cargar
     * @param event Evento que dispara el cambio de vista
     * @throws IOException Si hay un error al cargar el archivo FXML
     */
    public static void cargarVista(String rutaFXML, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(rutaFXML));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}