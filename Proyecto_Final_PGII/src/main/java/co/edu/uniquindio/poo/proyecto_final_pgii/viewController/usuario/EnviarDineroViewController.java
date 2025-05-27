package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorTransacciones;
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
    private TextField TextField_DescripcionTransferencia;

    @FXML
    private TextField TextField_MontoTransferencia;

    @FXML
    private TextField TextField_NumeroCuentaDestinoTransferencia;

    @FXML
    private TextField TextField_CategoriaTransaccion;

    /**
     * Regresa a la pantalla anterior del menu de transacciones
     * se ejecuta al hacer click en el boton atras
     * @param event
     */
    @FXML
    void onClick_AtrasMenuTransaccion(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuEnviarDinero.getParent();

            PantallaPrincipalUsuarioViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/transaccionUsuario.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Ejecuta la logica para realizar una transferencia de dinero entre cuentas
     * verifica monto, cuenta destino y realiza la transaccion si es valida
     * @param event
     */
    @FXML
    void onClick_EnviarDinero(ActionEvent event) {

        Cuenta cuentaSeleccionada = DatosCompartidos.getInstancia().getCuentaSeleccionada();

        if (cuentaSeleccionada == null) {
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
            if (monto <= 0) {
                System.out.println("El monto debe ser mayor a cero");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Monto invalido");
            return;
        }

        GestorTransacciones.getInstancia().realizarTransferencia(cuentaOrigen, numeroDestino, monto, descripcion, categoria1);

        System.out.println("Transferencia realizada con exito");

    }

    /**
     * Metodo de inicializacion llamado automaticamente al cargar la vista
     * Verifica que todos los componentes esten correctamente inyectados
     */
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

        cargarDatosCuenta();
    }


    /**
     * Carga los datos de la cuenta seleccionada en los labels de la interfaz grafica
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
