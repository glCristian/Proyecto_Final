package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
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
import co.edu.uniquindio.poo.proyecto_final_pgii.app.App;

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
    private ListView<String> TableView_Movimientos;

    /**
     * Carga la vista de cuentas del usuario
     * @param event
     */
    @FXML
    void onClick_MenuCuentas(ActionEvent event) {
        cargarVistaEnPantallaPrincipal(AnchorPane_PantallaPrincipalUsuario, "/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/cuentasUsuario.fxml");
    }

    /**
     * Carga la vista de movimientos del usuario
     * @param event
     */
    @FXML
    void onClick_MenuMovimientos(ActionEvent event) {
        cargarVistaEnPantallaPrincipal(AnchorPane_PantallaPrincipalUsuario, "/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/movimientosUsuario.fxml");
    }

    /**
     * Carga la vista de presupuestos del usuario
     * @param event
     */
    @FXML
    void onClick_MenuPresupuesto(ActionEvent event) {
        cargarVistaEnPantallaPrincipal(AnchorPane_PantallaPrincipalUsuario, "/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/presupuestoUsuario.fxml");
    }

    /**
     * Carga la vista de transaccion del usuario
     * @param event
     */
    @FXML
    void onClick_MenuTransaccion(ActionEvent event) {
        cargarVistaEnPantallaPrincipal(AnchorPane_PantallaPrincipalUsuario, "/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/transaccionUsuario.fxml");
    }

    /**
     * Carga la vista de prefil del usuario
     * @param event
     */
    @FXML
    void onClick_PerfilUsuario(ActionEvent event) {
        cargarVistaEnPantallaPrincipal(AnchorPane_PantallaPrincipalUsuario, "/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/perfilUsuario.fxml");
    }

    /**
     * Cierra la sesion del usuario y redirige al menu de inicio
     * @param event
     */
    @FXML
    void onClick_CerrarSesionUsuario(ActionEvent event) {
        GestorSesion.getInstancia().cerrarSesion();
        DatosCompartidos.getInstancia().setCuentaSeleccionada(null);
        try {
            App.cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/menuInicio.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inicializa la vista principla del usuario
     * carga el saldo total actual del usuario
     */
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


        Label_SaldoTotal.setText(String.valueOf(GestorSesion.getInstancia().getUsuarioActual().getSaldoTotal()));
    }


    /**
     * Carga una vista dentro del contener principal de la pantalla
     * @param contenedor
     * @param nombreFXML
     */
    public static void cargarVistaEnPantallaPrincipal(AnchorPane contenedor, String nombreFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(PantallaPrincipalUsuarioViewController.class.getResource(nombreFXML));
            Parent vista = loader.load();
            contenedor.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Carga y muestra los movimientos del usuario actual en la lista
     */
    private void cargarMovimientos(){
        Usuario usuarioActual = GestorSesion.getInstancia().getUsuarioActual();
        if (usuarioActual != null){
            Collection<Transaccion> transacciones = usuarioActual.mostrarTodosLosMovimientos();
            ObservableList<String> items = FXCollections.observableArrayList();

            for (Transaccion t : transacciones){
                String descripcion = String.format("%s - $%.2f - %s",
                        t.getTipoTransaccion(), t.getMonto(), t.getFecha());
                items.add(descripcion);
            }
            TableView_Movimientos.setItems(items);
        }
    }


}
