package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.DatosCompartidos;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.GestorSesion;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Presupuesto;
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

public class EliminarPresupuestoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuEliminarPresupuesto;

    @FXML
    private Button Button_AtrasMenuPresupuesto;

    @FXML
    private Button Button_EliminarPresupuesto;

    @FXML
    private Label Label_SaldoPresupuesto;

    @FXML
    private TextField TextField_AgregarIDPresupuesto;

    @FXML
    void onClick_AtrasMenuPresupuesto(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuEliminarPresupuesto.getParent();

            PantallaPrincipalUsuarioViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/PresupuestoUsuario.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_EliminarPresupuesto(ActionEvent event) {
        String id = TextField_AgregarIDPresupuesto.getText();
        if (id.isBlank()){
            System.out.println("Ingrese un ID valido");
            return;
        }

        Presupuesto presupuesto = buscarPresupuesto(id);
        if (presupuesto != null) {
            GestorSesion.getInstancia().getUsuarioActual().getListaPresupuestos().remove(presupuesto);
            Label_SaldoPresupuesto.setText("$ 0.00");
            System.out.println("Presupuesto eliminado con éxito.");
        } else {
            System.out.println("No se encontró ningún presupuesto con ese ID.");
        }
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuEliminarPresupuesto != null : "fx:id=\"AnchorPane_MenuEliminarPresupuesto\" was not injected: check your FXML file 'eliminarPresupuestoUsuario.fxml'.";
        assert Button_AtrasMenuPresupuesto != null : "fx:id=\"Button_AtrasMenuPresupuesto\" was not injected: check your FXML file 'eliminarPresupuestoUsuario.fxml'.";
        assert Button_EliminarPresupuesto != null : "fx:id=\"Button_EliminarPresupuesto\" was not injected: check your FXML file 'eliminarPresupuestoUsuario.fxml'.";
        assert Label_SaldoPresupuesto != null : "fx:id=\"Label_SaldoPresupuesto\" was not injected: check your FXML file 'eliminarPresupuestoUsuario.fxml'.";
        assert TextField_AgregarIDPresupuesto != null : "fx:id=\"TextField_AgregarIDPresupuesto\" was not injected: check your FXML file 'eliminarPresupuestoUsuario.fxml'.";

        cargarSaldoPresupuesto();
    }

    private void cargarSaldoPresupuesto(){
        TextField_AgregarIDPresupuesto.textProperty().addListener((obs, oldVal, newVal) -> {
            Presupuesto presupuesto = buscarPresupuesto(newVal);
            if (presupuesto != null) {
                Label_SaldoPresupuesto.setText(String.format("$ %.2f", presupuesto.getMontoTotal()));
            } else {
                Label_SaldoPresupuesto.setText("$ 0.00");
            }
        });
    }

}

