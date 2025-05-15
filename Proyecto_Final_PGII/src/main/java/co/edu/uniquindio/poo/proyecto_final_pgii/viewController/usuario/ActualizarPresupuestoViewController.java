package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.Categoria;
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

public class ActualizarPresupuestoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuActualizarPresupuesto;

    @FXML
    private Button Button_ActualizarPresupuesto;

    @FXML
    private Button Button_AtrasMenuPresupuesto;

    @FXML
    private Label Label_SaldoPresupuesto;

    @FXML
    private TextField TextField_AgregarCategoriaPresupuesto;

    @FXML
    private TextField TextField_AgregarIDPresupuesto;

    @FXML
    private TextField TextField_AgregarMontoTotalPresupuesto;

    @FXML
    private TextField TextField_AgregarNombrePresupuesto;

    @FXML
    void onClick_ActualizarPresupuesto(ActionEvent event) {
        String id = TextField_AgregarIDPresupuesto.getText();
        String nombre = TextField_AgregarNombrePresupuesto.getText();
        String montoStr = TextField_AgregarMontoTotalPresupuesto.getText();
        String nombreCategoria = TextField_AgregarCategoriaPresupuesto.getText();

        if (id.isBlank() || nombre.isBlank() || montoStr.isBlank() || nombreCategoria.isBlank()) {
            System.out.println("Todos los campos son obligatorios");
            return;
        }

        double montoTotal;
        try {
            montoTotal = Double.parseDouble(montoStr);
            if (montoTotal <= 0) {
                System.out.println("El monto debe ser mayor a cero");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Monto inválido");
            return;
        }

        Categoria categoria = new Categoria(java.util.UUID.randomUUID().toString(), nombreCategoria, "");
        Presupuesto nuevoPresupuesto = new Presupuesto(id, nombre, montoTotal, 0, categoria);

        GestorSesion.getInstancia().getUsuarioActual().getListaPresupuestos().add(nuevoPresupuesto);

        Label_SaldoPresupuesto.setText(String.format("$ %.2f", montoTotal));

        System.out.println("Presupuesto actualizado con exito");
    }

    @FXML
    void onClick_AtrasMenuPresupuesto(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyecto_final_pgii/presupuestoUsuario.fxml"));
            Parent vista = loader.load();
            AnchorPane_MenuActualizarPresupuesto.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuActualizarPresupuesto != null : "fx:id=\"AnchorPane_MenuActualizarPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert Button_ActualizarPresupuesto != null : "fx:id=\"Button_ActualizarPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert Button_AtrasMenuPresupuesto != null : "fx:id=\"Button_AtrasMenuPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert Label_SaldoPresupuesto != null : "fx:id=\"Label_SaldoPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert TextField_AgregarCategoriaPresupuesto != null : "fx:id=\"TextField_AgregarCategoriaPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert TextField_AgregarIDPresupuesto != null : "fx:id=\"TextField_AgregarIDPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert TextField_AgregarMontoTotalPresupuesto != null : "fx:id=\"TextField_AgregarMontoTotalPresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";
        assert TextField_AgregarNombrePresupuesto != null : "fx:id=\"TextField_AgregarNombrePresupuesto\" was not injected: check your FXML file 'actualizarPresupuestoUsuario.fxml'.";

    }

}
