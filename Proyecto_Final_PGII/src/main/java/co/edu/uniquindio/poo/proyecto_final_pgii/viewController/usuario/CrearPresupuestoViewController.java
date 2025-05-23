package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.Categoria;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.GestorSesion;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Presupuesto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CrearPresupuestoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuCrearPresupuesto;

    @FXML
    private Button Button_AtrasMenuPresupuesto;

    @FXML
    private Button Button_CrearPresupuesto;

    @FXML
    private Label Label_SaldoTotal;

    @FXML
    private TextField TextField_AgregarCategoriaPresupuesto;

    @FXML
    private TextField TextField_AgregarIDPresupuesto;

    @FXML
    private TextField TextField_AgregarMontoGastadoPresupuesto;

    @FXML
    private TextField TextField_AgregarMontoTotalPresupuesto;

    @FXML
    private TextField TextField_AgregarNombrePresupuesto;

    @FXML
    void onClick_AtrasMenuPresupuesto(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuCrearPresupuesto.getParent();

            PantallaPrincipalUsuarioViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/presupuestoUsuario.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_CrearPresupuesto(ActionEvent event) {
        String id = TextField_AgregarIDPresupuesto.getText();
        String nombre = TextField_AgregarNombrePresupuesto.getText();
        String montoTotalStr = TextField_AgregarMontoTotalPresupuesto.getText();
        String montoGastadoStr = TextField_AgregarMontoGastadoPresupuesto.getText();
        String nombreCategoria = TextField_AgregarCategoriaPresupuesto.getText();

        if (id.isBlank() || nombre.isBlank() || montoTotalStr.isBlank() || nombreCategoria.isBlank() || montoGastadoStr.isBlank()) {
            System.out.println("Todos los campos son obligatorios.");
            return;
        }

        try {
            double montoTotal = Double.parseDouble(montoTotalStr);
            double montoGastado = Double.parseDouble(montoGastadoStr);

            if (montoTotal <= 0 || montoGastado < 0 || montoGastado > montoTotal) {
                System.out.println("Verifique los montos ingresados.");
                return;
            }

            Categoria categoria = new Categoria(java.util.UUID.randomUUID().toString(), nombreCategoria, "");
            Presupuesto presupuesto = new Presupuesto(id, nombre, montoTotal, 0, categoria );
            presupuesto.setMontoGastado(montoGastado);

            GestorSesion.getInstancia().getUsuarioActual().getListaPresupuestos().add(presupuesto);
            Label_SaldoTotal.setText(String.format("$ %.2f", montoTotal));

            System.out.println("Presupuesto creado con éxito.");
        } catch (NumberFormatException e) {
            System.out.println("Los montos deben ser números válidos.");
        }

    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuCrearPresupuesto != null : "fx:id=\"AnchorPane_MenuCrearPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert Button_AtrasMenuPresupuesto != null : "fx:id=\"Button_AtrasMenuPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert Button_CrearPresupuesto != null : "fx:id=\"Button_CrearPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert Label_SaldoTotal != null : "fx:id=\"Label_SaldoTotal\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert TextField_AgregarCategoriaPresupuesto != null : "fx:id=\"TextField_AgregarCategoriaPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert TextField_AgregarIDPresupuesto != null : "fx:id=\"TextField_AgregarIDPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert TextField_AgregarMontoGastadoPresupuesto != null : "fx:id=\"TextField_AgregarMontoGastadoPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert TextField_AgregarMontoTotalPresupuesto != null : "fx:id=\"TextField_AgregarMontoTotalPresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";
        assert TextField_AgregarNombrePresupuesto != null : "fx:id=\"TextField_AgregarNombrePresupuesto\" was not injected: check your FXML file 'crearPresupuestoUsuario.fxml'.";

        cargarSaldoTotal();
    }

    private void cargarSaldoTotal(){
        TextField_AgregarMontoTotalPresupuesto.textProperty().addListener((obs, oldValue, newValue) -> {
            try {
                double valor = Double.parseDouble(newValue);
                if (valor >= 0) {
                    Label_SaldoTotal.setText(String.format("$ %.2f", valor));
                } else {
                    Label_SaldoTotal.setText("$ 0.00");
                }
            } catch (NumberFormatException e) {
                Label_SaldoTotal.setText("$ 0.00");
            }
        });
    }

}
