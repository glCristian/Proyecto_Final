package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.Node;

public class PantallaPrincipalUsuarioViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Button_MenuCuentas;

    @FXML
    private Button Button_MenuMovimientos;

    @FXML
    private Button Button_MenuPerfilUsuario;

    @FXML
    private Button Button_MenuPresupuesto;

    @FXML
    private Button Button_MenuTransaccion;

    @FXML
    private Label Label_MostrarSaldoTotal;

    @FXML
    private ListView<?> ListView_MostrarResumenMovimientos;

    @FXML
    void onClick_MenuCuentas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/parcial_2/.fxml"));
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
    void onClick_MenuMovimientos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/parcial_2/.fxml"));
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
    void onClick_MenuPerfilUsuario(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/parcial_2/.fxml"));
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
    void onClick_MenuPresupuesto(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/parcial_2/.fxml"));
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
    void onClick_MenuTransaccion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/parcial_2/.fxml"));
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
        assert Button_MenuCuentas != null : "fx:id=\"Button_MenuCuentas\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert Button_MenuMovimientos != null : "fx:id=\"Button_MenuMovimientos\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert Button_MenuPerfilUsuario != null : "fx:id=\"Button_MenuPerfilUsuario\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert Button_MenuPresupuesto != null : "fx:id=\"Button_MenuPresupuesto\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert Button_MenuTransaccion != null : "fx:id=\"Button_MenuTransaccion\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert Label_MostrarSaldoTotal != null : "fx:id=\"Label_MostrarSaldoTotal\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert ListView_MostrarResumenMovimientos != null : "fx:id=\"ListView_MostrarResumenMovimientos\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";

    }
}
