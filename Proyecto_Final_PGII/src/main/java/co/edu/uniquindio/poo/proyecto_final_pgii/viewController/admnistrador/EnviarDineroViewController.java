package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EnviarDineroViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuEnviarDinero;

    @FXML
    private Button Button_AtrasMenuTransaccion;

    @FXML
    private Button Button_EnviarDinero;

    @FXML
    private Label Label_BancoCuenta;

    @FXML
    private Label Label_NumeroCuenta;

    @FXML
    private Label Label_SaldoCuenta;

    @FXML
    private TextField TextField_CategoriaTransaccion;

    @FXML
    private TextField TextField_DescripcionTransferencia;

    @FXML
    private TextField TextField_MontoTransferencia;

    @FXML
    private TextField TextField_NumeroCuentaDestinoTransferencia;

    @FXML
    void onClick_AtrasMenuTransaccion(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuEnviarDinero.getParent();

            PantallaPrincipalAdministradorViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/gestionarTransacciones.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_EnviarDinero(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuEnviarDinero != null : "fx:id=\"AnchorPane_MenuEnviarDinero\" was not injected: check your FXML file 'enviarDinero.fxml'.";
        assert Button_AtrasMenuTransaccion != null : "fx:id=\"Button_AtrasMenuTransaccion\" was not injected: check your FXML file 'enviarDinero.fxml'.";
        assert Button_EnviarDinero != null : "fx:id=\"Button_EnviarDinero\" was not injected: check your FXML file 'enviarDinero.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'enviarDinero.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'enviarDinero.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'enviarDinero.fxml'.";
        assert TextField_CategoriaTransaccion != null : "fx:id=\"TextField_CategoriaTransaccion\" was not injected: check your FXML file 'enviarDinero.fxml'.";
        assert TextField_DescripcionTransferencia != null : "fx:id=\"TextField_DescripcionTransferencia\" was not injected: check your FXML file 'enviarDinero.fxml'.";
        assert TextField_MontoTransferencia != null : "fx:id=\"TextField_MontoTransferencia\" was not injected: check your FXML file 'enviarDinero.fxml'.";
        assert TextField_NumeroCuentaDestinoTransferencia != null : "fx:id=\"TextField_NumeroCuentaDestinoTransferencia\" was not injected: check your FXML file 'enviarDinero.fxml'.";

    }

}
