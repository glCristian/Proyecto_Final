package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SacarDineroViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuSacarDinero;

    @FXML
    private Button Button_AtrasMenuTransaccion;

    @FXML
    private Button Button_SacarDinero;

    @FXML
    private Label Label_BancoCuenta;

    @FXML
    private Label Label_NumeroCuenta;

    @FXML
    private Label Label_SaldoCuenta;

    @FXML
    private TextField TextField_DescripcionSacar;

    @FXML
    private TextField TextField_MontoSacarDinero;

    @FXML
    private TextField TextField_NumeroCuentaDestinoSacar;

    @FXML
    private TextField TextField_CategoriaTransaccion;


    @FXML
    void onClick_AtrasMenuTransaccion(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuSacarDinero.getParent();

            PantallaPrincipalUsuarioViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/transaccionUsuario.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_SacarDinero(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuSacarDinero != null : "fx:id=\"AnchorPane_MenuSacarDinero\" was not injected: check your FXML file 'sacarDineroUsuario.fxml'.";
        assert Button_AtrasMenuTransaccion != null : "fx:id=\"Button_AtrasMenuTransaccion\" was not injected: check your FXML file 'sacarDineroUsuario.fxml'.";
        assert Button_SacarDinero != null : "fx:id=\"Button_SacarDinero\" was not injected: check your FXML file 'sacarDineroUsuario.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'sacarDineroUsuario.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'sacarDineroUsuario.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'sacarDineroUsuario.fxml'.";
        assert TextField_DescripcionSacar != null : "fx:id=\"TextField_DescripcionSacar\" was not injected: check your FXML file 'sacarDineroUsuario.fxml'.";
        assert TextField_MontoSacarDinero != null : "fx:id=\"TextField_MontoSacarDinero\" was not injected: check your FXML file 'sacarDineroUsuario.fxml'.";
        assert TextField_NumeroCuentaDestinoSacar != null : "fx:id=\"TextField_NumeroCuentaDestinoSacar\" was not injected: check your FXML file 'sacarDineroUsuario.fxml'.";
        assert TextField_CategoriaTransaccion != null : "fx:id=\"TextField_TipoTransaccion\" was not injected: check your FXML file 'sacarDineroUsuario.fxml'.";

    }

}
