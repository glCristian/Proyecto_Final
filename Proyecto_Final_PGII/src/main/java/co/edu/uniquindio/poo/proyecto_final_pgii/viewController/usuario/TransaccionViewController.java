package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.Cuenta;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.DatosCompartidos;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.GestorSesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class TransaccionViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuTransaccion;

    @FXML
    private Button Button_AgregarDinero;

    @FXML
    private Button Button_EnviarDinero;

    @FXML
    private Button Button_RetirarDinero;

    @FXML
    private Label Label_BancoCuenta;

    @FXML
    private Label Label_NumeroCuenta;

    @FXML
    private Label Label_SaldoCuenta;

    @FXML
    private ListView<Cuenta> TableView_CuentasTransaccion;

    /**
     * Evento que carga la vista para agregar dinero a la cuenta seleccionada
     * @param event
     */
    @FXML
    void onClick_AgregarDinero(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/agregarDineroUsuario.fxml");
    }

    /**
     * Evento que carga la vista para enviar dinero desde la cuenta seleccionada
     * @param event
     */
    @FXML
    void onClick_EnviarDinero(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/enviarDineroUsuario.fxml");
    }

    /**
     * Evento que carga la vista para retirar dinero de la cuenta seleccionada
     * @param event
     */
    @FXML
    void onClick_RetirarDinero(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/sacarDineroUsuario.fxml");
    }

    /**
     * Metodo de inicializacion llamado automaticamente al cargar la vista
     * Verifica que todos los componentes esten correctamente inyectados
     */
    @FXML
    void initialize() {
        assert AnchorPane_MenuTransaccion != null : "fx:id=\"AnchorPane_MenuTransaccion\" was not injected: check your FXML file 'transaccionUsuario.fxml'.";
        assert Button_AgregarDinero != null : "fx:id=\"Button_AgregarDinero\" was not injected: check your FXML file 'transaccionUsuario.fxml'.";
        assert Button_EnviarDinero != null : "fx:id=\"Button_EnviarDinero\" was not injected: check your FXML file 'transaccionUsuario.fxml'.";
        assert Button_RetirarDinero != null : "fx:id=\"Button_RetirarDinero\" was not injected: check your FXML file 'transaccionUsuario.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'transaccionUsuario.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'transaccionUsuario.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'transaccionUsuario.fxml'.";
        assert TableView_CuentasTransaccion != null : "fx:id=\"TableView_CuentasTransaccion\" was not injected: check your FXML file 'transaccionUsuario.fxml'.";

        cargarCuentas();
        configurarSeleccionCuenta();
    }

    /**
     * Carga la vista especificada dentro del anchopane principal
     * @param nombreFXML
     */
    private void cargarVista(String nombreFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreFXML));
            Parent vista = loader.load();
            AnchorPane_MenuTransaccion.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * carga las cuentas del usuario actual en la listViw para su selecciom
     */
    private void cargarCuentas(){
        TableView_CuentasTransaccion.setItems(
                javafx.collections.FXCollections.observableArrayList(
                        GestorSesion.getInstancia().getUsuarioActual().getListaCuentas()
                )
        );
    }

    /**
     * Configura el comportamiento al seleccionar una cuenta en la lista
     */
    private void configurarSeleccionCuenta(){
        TableView_CuentasTransaccion.setOnMouseClicked(mouseEvent -> {
            Cuenta cuentaSeleccionada = TableView_CuentasTransaccion.getSelectionModel().getSelectedItem();
            if (cuentaSeleccionada != null)
                Label_BancoCuenta.setText(cuentaSeleccionada.getNombreBanco());
            Label_NumeroCuenta.setText(cuentaSeleccionada.getNumeroCuenta());
            Label_SaldoCuenta.setText(String.format("$ %.2f", cuentaSeleccionada.getSaldoTotal()));

            DatosCompartidos.getInstancia().setCuentaSeleccionada(cuentaSeleccionada);
        });
    }


}
