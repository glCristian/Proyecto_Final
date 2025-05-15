package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.UUID;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
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

public class AgregarDineroViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuAgregarDinero;

    @FXML
    private Button Button_AgregarDinero;

    @FXML
    private Button Button_AtrasMenuTransaccion;

    @FXML
    private Label Label_BancoCuenta;

    @FXML
    private Label Label_NumeroCuenta;

    @FXML
    private Label Label_SaldoCuenta;

    @FXML
    private TextField TextField_DescripcionAgragar;

    @FXML
    private TextField TextField_MontoAgregarDinero;

    @FXML
    private TextField TextField_NumeroCuentaOrigenAgregar;

    @FXML
    private TextField TextField_CategoriaTransaccion;


    @FXML
    void onClick_AgregarDinero(ActionEvent event) {
        Cuenta cuentaSeleccionada = DatosCompartidos.getInstancia().getCuentaSeleccionada();

        if (cuentaSeleccionada == null){
            System.out.println("No hay cuenta seleccionada");
        }

        String montoStr = TextField_MontoAgregarDinero.getText();
        String descripcion = TextField_DescripcionAgragar.getText();
        String cuentaOrigen = TextField_NumeroCuentaOrigenAgregar.getText();
        String cuentsDestino = cuentaSeleccionada.getNumeroCuenta();
        String categoria = TextField_CategoriaTransaccion.getText();
        Categoria categoria1 = new Categoria(UUID.randomUUID().toString(), categoria, "");



        if (montoStr.isBlank()|| descripcion.isBlank() || categoria.isBlank() || cuentaOrigen.isBlank()){
            System.out.println("Todos los campos son obligatorios");
            return;
        }

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

        if (monto > cuentaSeleccionada.getSaldoTotal()){
            System.out.println("Saldo insuficiente");
            return;
        }


        cuentaSeleccionada.setSaldoTotal(cuentaSeleccionada.getSaldoTotal() + monto);
        Label_SaldoCuenta.setText(String.format("$ %.2f", cuentaSeleccionada.getSaldoTotal()));

        Transaccion transaccion = new Transaccion(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                monto,
                descripcion,
                cuentaOrigen,
                cuentsDestino,
                categoria1,
                TipoTransaccion.DEPOSITO
        );
        cuentaSeleccionada.getListaTransacciones().add(transaccion);
        System.out.println("Dinero agregado con exito");
    }

    @FXML
    void onClick_AtrasMenuTransaccion(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuAgregarDinero.getParent();

            PantallaPrincipalUsuarioViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/transaccionUsuario.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuAgregarDinero != null : "fx:id=\"AnchorPane_MenuAgregarDinero\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert Button_AgregarDinero != null : "fx:id=\"Button_AgregarDinero\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert Button_AtrasMenuTransaccion != null : "fx:id=\"Button_AtrasMenuTransaccion\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert TextField_DescripcionAgragar != null : "fx:id=\"TextField_DescripcionAgragar\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert TextField_MontoAgregarDinero != null : "fx:id=\"TextField_MontoAgregarDinero\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert TextField_NumeroCuentaOrigenAgregar != null : "fx:id=\"TextField_NumeroCuentaOrigenAgregar\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert TextField_CategoriaTransaccion != null : "fx:id=\"TextField_TipoTransaccion\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";

        cargarDatosCuenta();
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
