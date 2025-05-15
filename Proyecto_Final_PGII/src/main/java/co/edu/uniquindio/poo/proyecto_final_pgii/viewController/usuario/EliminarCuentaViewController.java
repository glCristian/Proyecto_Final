package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.Cuenta;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.GestorSesion;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Usuario;
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

public class EliminarCuentaViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuEliminarCuenta;

    @FXML
    private Button Button_AtrasMenuCuentas;

    @FXML
    private Button Button_EliminarCuenta;

    @FXML
    private Label Label_BancoCuenta;

    @FXML
    private Label Label_NumeroCuenta;

    @FXML
    private Label Label_SaldoCuenta;

    @FXML
    private TextField TextField_AgregarBancoCuenta;

    @FXML
    private TextField TextField_AgregarNumeroCuenta;

    @FXML
    void onClick_AtrasMenuCuentas(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuEliminarCuenta.getParent();

            PantallaPrincipalUsuarioViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/cuentasUsuario.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_EliminarCuenta(ActionEvent event) {
        String numeroCuenta = TextField_AgregarNumeroCuenta.getText();

        Usuario usuario = GestorSesion.getInstancia().getUsuarioActual();

        if (usuario != null && numeroCuenta != null && !numeroCuenta.isBlank()){
            Cuenta cuentaEncontrada = null;

            for (Cuenta cuenta : usuario.getListaCuentas()){
                if (cuenta.getNumeroCuenta().equals(numeroCuenta)){
                    cuentaEncontrada = cuenta;
                    break;
                }
            }
            if (cuentaEncontrada != null){
                Label_BancoCuenta.setText(cuentaEncontrada.getNombreBanco());
                Label_NumeroCuenta.setText(cuentaEncontrada.getNumeroCuenta());
                Label_SaldoCuenta.setText(String.format("$ %.2f", cuentaEncontrada.getSaldoTotal()));

                usuario.getListaCuentas().remove(cuentaEncontrada);

                Label_BancoCuenta.setText("");
                Label_NumeroCuenta.setText("");
                Label_SaldoCuenta.setText("");

                System.out.println("Cuenta eliminada correctamente");
            } else {
                System.out.println("No se encontro la cuena con ese numero");
            }
        }
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuEliminarCuenta != null : "fx:id=\"AnchorPane_MenuEliminarCuenta\" was not injected: check your FXML file 'eliminarCuenta.fxml'.";
        assert Button_AtrasMenuCuentas != null : "fx:id=\"Button_AtrasMenuCuentas\" was not injected: check your FXML file 'eliminarCuenta.fxml'.";
        assert Button_EliminarCuenta != null : "fx:id=\"Button_EliminarCuenta\" was not injected: check your FXML file 'eliminarCuenta.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'eliminarCuenta.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'eliminarCuenta.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'eliminarCuenta.fxml'.";
        assert TextField_AgregarBancoCuenta != null : "fx:id=\"TextField_AgregarBancoCuenta\" was not injected: check your FXML file 'eliminarCuenta.fxml'.";
        assert TextField_AgregarNumeroCuenta != null : "fx:id=\"TextField_AgregarNumeroCuenta\" was not injected: check your FXML file 'eliminarCuenta.fxml'.";

    }

}
