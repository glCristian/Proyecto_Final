package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorCuentas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class CuentasUsuarioViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuCuentas;

    @FXML
    private Button Button_ActualizarCuenta;

    @FXML
    private Button Button_AnadirCuenta;

    @FXML
    private Button Button_EliminarCuenta;

    @FXML
    private Label Label_BancoCuenta;

    @FXML
    private Label Label_NumeroCuenta;

    @FXML
    private Label Label_SaldoCuenta;

    @FXML
    private ListView<Cuenta> ListView_Cuentas;

    private Cuenta cuentaSeleccionada;

    /**
     * Accion al hacer click en el boton de actualizar cuenta
     * abre la vista para editar la cuenta seleccionada
     * @param event
     */
    @FXML
    void onClick_ActualizarCuenta(ActionEvent event) {
        cuentaSeleccionada = ListView_Cuentas.getSelectionModel().getSelectedItem();
        if (cuentaSeleccionada != null){
            DatosCompartidos.getInstancia().setCuentaSeleccionada(cuentaSeleccionada);

            cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/actualizarCuentaUsuario.fxml");
        }

    }

    /**
     * Accion al hacer click en el boton de eliminar cuenta
     * elimina la cuneta seleccionada del usuario actual
     * @param event
     */
    @FXML
    void onClick_EliminarCuenta(ActionEvent event) {
        cuentaSeleccionada = ListView_Cuentas.getSelectionModel().getSelectedItem();
        if (cuentaSeleccionada != null){
            GestorSesion.getInstancia().getUsuarioActual().eliminarCuenta(cuentaSeleccionada.getIdCuenta());
            actualizarListViewCuentas();
        }
    }

    /**
     * Accion al hacer click en el boton de añadir cuenta
     * abre la vusta para crear una nueva cuenta
     * @param event
     */
    @FXML
    void onClick_anadirCuenta(ActionEvent event) {
        cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/agregarCuenta.fxml");

    }

    /**
     * Metodo de inicializacion llamado automaticamente al cargar la vista
     * Verifica que todos los componentes esten correctamente inyectados e inicializa la lista de cuenta y
     * configura el comportamiento al selccionar una cuenta
     */
    @FXML
    void initialize() {
        assert AnchorPane_MenuCuentas != null : "fx:id=\"AnchorPane_MenuCuentas\" was not injected: check your FXML file 'cuentasUsuario.fxml'.";
        assert Button_ActualizarCuenta != null : "fx:id=\"Button_ActualizarCuenta\" was not injected: check your FXML file 'cuentasUsuario.fxml'.";
        assert Button_AnadirCuenta != null : "fx:id=\"Button_AnadirCuenta\" was not injected: check your FXML file 'cuentasUsuario.fxml'.";
        assert Button_EliminarCuenta != null : "fx:id=\"Button_EliminarCuenta\" was not injected: check your FXML file 'cuentasUsuario.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'cuentasUsuario.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'cuentasUsuario.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'cuentasUsuario.fxml'.";
        assert ListView_Cuentas != null : "fx:id=\"ListView_Cuentas\" was not injected: check your FXML file 'cuentasUsuario.fxml'.";

        cargarCuentasUsuario();

        mostrarDetallesCuentaSelected();

    }

    /**
     * Carga una vista FXML dentro del anchorPane menuCuentas
     * @param nombreFXML
     */
    private void cargarVista(String nombreFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreFXML));
            Parent vista = loader.load();
            AnchorPane_MenuCuentas.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga las cuentas asociadas al usuaruo actual y las muestra en la listView
     */
    private void cargarCuentasUsuario(){
        Usuario usuario = GestorSesion.getInstancia().getUsuarioActual();
        if(usuario != null){
            ObservableList<Cuenta> cuentas = FXCollections.observableArrayList(usuario.getListaCuentas());
            ListView_Cuentas.setItems(cuentas);
        }
    }


    /**
     * Muestra los detalles de la cuenta seleccionada en los labels
     * tambien guarda la cuenta seleccionada en datosCompartidos
     */
    private void mostrarDetallesCuentaSelected(){
        ListView_Cuentas.setOnMouseClicked(mouseEvent -> {
            Cuenta cuentaSeleccionada = ListView_Cuentas.getSelectionModel().getSelectedItem();
            if (cuentaSeleccionada != null)
                Label_BancoCuenta.setText("Banco: " + cuentaSeleccionada.getNombreBanco());
            Label_NumeroCuenta.setText(cuentaSeleccionada.getNumeroCuenta());
            Label_SaldoCuenta.setText(String.format("$ %.2f", cuentaSeleccionada.getSaldoTotal()));

            DatosCompartidos.getInstancia().setCuentaSeleccionada(cuentaSeleccionada);
        });
    }

    /**
     * Actualiza la listView con las cuentas actuales del usuario
     */
    public void actualizarListViewCuentas (){
        Usuario usuario = GestorSesion.getInstancia().getUsuarioActual();
        if (usuario != null){
            ObservableList<Cuenta> cuentasActualizadas = FXCollections.observableArrayList(usuario.getListaCuentas());
            ListView_Cuentas.setItems(cuentasActualizadas);
        }
    }
}
