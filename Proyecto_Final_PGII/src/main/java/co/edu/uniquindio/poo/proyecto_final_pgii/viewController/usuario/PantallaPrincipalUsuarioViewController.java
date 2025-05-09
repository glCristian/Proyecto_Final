package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class PantallaPrincipalUsuarioViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_PantallaPrincipalUsuario;

    @FXML
    private Button Button_CerrarSesionUsuario;

    @FXML
    private Button Button_MenuCuentas;

    @FXML
    private Button Button_MenuMovimientos;

    @FXML
    private Button Button_MenuPresupuesto;

    @FXML
    private Button Button_MenuTransaccion;

    @FXML
    private Button Button_PerfilUsuario;

    @FXML
    private Label Label_SaldoTotal;

    @FXML
    private ListView<?> TableView_Movimientos;

    @FXML
    void onClick_MenuCuentas(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/cuentasUsuario.fxml");
    }

    @FXML
    void onClick_MenuMovimientos(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/movimientosUsuario.fxml");
    }

    @FXML
    void onClick_MenuPresupuesto(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/presupuestoUsuario.fxml");
    }

    @FXML
    void onClick_MenuTransaccion(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/transaccionUsuario.fxml");
    }

    @FXML
    void onClick_PerfilUsuario(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/perfilUsuario.fxml");
    }

    @FXML
    void onClick_CerrarSesionUsuario(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPane_PantallaPrincipalUsuario != null : "fx:id=\"AnchorPane_PantallaPrincipalUsuario\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert Button_CerrarSesionUsuario != null : "fx:id=\"Button_CerrarSesionUsuario\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert Button_MenuCuentas != null : "fx:id=\"Button_MenuCuentas\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert Button_MenuMovimientos != null : "fx:id=\"Button_MenuMovimientos\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert Button_MenuPresupuesto != null : "fx:id=\"Button_MenuPresupuesto\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert Button_MenuTransaccion != null : "fx:id=\"Button_MenuTransaccion\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert Button_PerfilUsuario != null : "fx:id=\"Button_PerfilUsuario\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert Label_SaldoTotal != null : "fx:id=\"Label_SaldoTotal\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";
        assert TableView_Movimientos != null : "fx:id=\"TableView_Movimientos\" was not injected: check your FXML file 'pantallaPrincipalUsuario.fxml'.";

    }



    private void cargarVista(String nombreFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreFXML));
            Parent vista = loader.load();
            AnchorPane_PantallaPrincipalUsuario.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
