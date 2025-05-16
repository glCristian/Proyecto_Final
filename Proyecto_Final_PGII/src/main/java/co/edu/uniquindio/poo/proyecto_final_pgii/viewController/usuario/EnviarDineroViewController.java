package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.UUID;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorCuentas;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorTransacciones;
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
    private TextField TextField_DescripcionTransferencia;

    @FXML
    private TextField TextField_MontoTransferencia;

    @FXML
    private TextField TextField_NumeroCuentaDestinoTransferencia;

    @FXML
    private TextField TextField_CategoriaTransaccion;

    @FXML
    void onClick_AtrasMenuTransaccion(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuEnviarDinero.getParent();

            PantallaPrincipalUsuarioViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/transaccionUsuario.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_EnviarDinero(ActionEvent event) {

        Cuenta cuentaSeleccionada = DatosCompartidos.getInstancia().getCuentaSeleccionada();

        if (cuentaSeleccionada == null){
            System.out.println("No hay cuenta seleccionada");
            return;
        }

        String cuentaOrigen = cuentaSeleccionada.getNumeroCuenta();
        String numeroDestino = TextField_NumeroCuentaDestinoTransferencia.getText();
        String montoStr = TextField_MontoTransferencia.getText();
        String descripcion = TextField_DescripcionTransferencia.getText();
        String categoria = TextField_CategoriaTransaccion.getText();
        Categoria categoria1 = new Categoria(UUID.randomUUID().toString(), categoria, "");

        double monto;
        try {
            monto = Double.parseDouble(montoStr);
            if (monto <= 0){
                System.out.println("El monto debe ser mayor a cero");
                return;
            }
        } catch (NumberFormatException e){
            System.out.println("Monto invalido");
            return;
        }

        GestorTransacciones.getInstancia().realizarTransferencia(cuentaOrigen, numeroDestino, monto, descripcion, categoria1);

        System.out.println("Transferencia realizada con exito");

    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuEnviarDinero != null : "fx:id=\"AnchorPane_MenuEnviarDinero\" was not injected: check your FXML file 'enviarDineroUsuario.fxml'.";
        assert Button_AtrasMenuTransaccion != null : "fx:id=\"Button_AtrasMenuTransaccion\" was not injected: check your FXML file 'enviarDineroUsuario.fxml'.";
        assert Button_EnviarDinero != null : "fx:id=\"Button_EnviarDinero\" was not injected: check your FXML file 'enviarDineroUsuario.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'enviarDineroUsuario.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'enviarDineroUsuario.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'enviarDineroUsuario.fxml'.";
        assert TextField_DescripcionTransferencia != null : "fx:id=\"TextField_DescripcionTransferencia\" was not injected: check your FXML file 'enviarDineroUsuario.fxml'.";
        assert TextField_MontoTransferencia != null : "fx:id=\"TextField_MontoTransferencia\" was not injected: check your FXML file 'enviarDineroUsuario.fxml'.";
        assert TextField_NumeroCuentaDestinoTransferencia != null : "fx:id=\"TextField_NumeroCuentaDestinoTransferencia\" was not injected: check your FXML file 'enviarDineroUsuario.fxml'.";
        assert TextField_CategoriaTransaccion != null : "fx:id=\"TextField_TipoTransaccion\" was not injected: check your FXML file 'enviarDineroUsuario.fxml'.";
    }

    public void cargarDatosCuenta(){
        Cuenta cuenta = DatosCompartidos.getInstancia().getCuentaSeleccionada();
        if (cuenta != null){
            Label_BancoCuenta.setText(cuenta.getNombreBanco());
            Label_NumeroCuenta.setText(cuenta.getNumeroCuenta());
            Label_SaldoCuenta.setText(String.format("$ %.2f", cuenta.getSaldoTotal()));
        }
    }
}
