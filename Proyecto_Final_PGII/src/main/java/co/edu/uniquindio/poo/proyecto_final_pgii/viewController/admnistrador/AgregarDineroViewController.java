package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.Categoria;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Cuenta;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.DatosCompartidos;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.GestorSesion;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorTransacciones;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    private TextField TextField_CategoriaTransaccion;

    @FXML
    private TextField TextField_DescripcionAgregar;

    @FXML
    private TextField TextField_MontoAgregarDinero;

    @FXML
    private TextField TextField_NumeroCuentaOrigenAgregar;

    /**
     * Maneja el evento de click en el boton de agregarDinero
     * Valida los datps ingresador y realiza la opetacion de deposito
     * @param event
     */
    @FXML
    void onClick_AgregarDinero(ActionEvent event) {
        String montoStr = TextField_MontoAgregarDinero.getText();
        String descripcion = TextField_DescripcionAgregar.getText();
        String cuentaDestino = TextField_NumeroCuentaOrigenAgregar.getText();
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

        GestorTransacciones.getInstancia().realizarDeposito(cuentaDestino, monto, descripcion, categoria1);

        System.out.println("Deposito realizado con exito");
    }


    @FXML
    void onClick_AtrasMenuTransaccion(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuAgregarDinero.getParent();

            PantallaPrincipalAdministradorViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/gestionarTransacciones.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuAgregarDinero != null : "fx:id=\"AnchorPane_MenuAgregarDinero\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert Button_AgregarDinero != null : "fx:id=\"Button_AgregarDinero\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert Button_AtrasMenuTransaccion != null : "fx:id=\"Button_AtrasMenuTransaccion\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert TextField_CategoriaTransaccion != null : "fx:id=\"TextField_CategoriaTransaccion\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert TextField_DescripcionAgregar != null : "fx:id=\"TextField_DescripcionAgregar\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert TextField_MontoAgregarDinero != null : "fx:id=\"TextField_MontoAgregarDinero\" was not injected: check your FXML file 'agregarDinero.fxml'.";
        assert TextField_NumeroCuentaOrigenAgregar != null : "fx:id=\"TextField_NumeroCuentaOrigenAgregar\" was not injected: check your FXML file 'agregarDinero.fxml'.";

        cargarDatosCuenta();

    }

    /**
     * Carga los datos de la cuenta seleccionada en los labels correspondientes
     */
    public void cargarDatosCuenta(){
        Cuenta cuenta = DatosCompartidos.getInstancia().getCuentaSeleccionada();
        if (cuenta != null){
            Label_BancoCuenta.setText(cuenta.getNombreBanco());
            Label_NumeroCuenta.setText(cuenta.getNumeroCuenta());
            Label_SaldoCuenta.setText(String.format("$ %.2f", cuenta.getSaldoTotal()));
        }
    }



}