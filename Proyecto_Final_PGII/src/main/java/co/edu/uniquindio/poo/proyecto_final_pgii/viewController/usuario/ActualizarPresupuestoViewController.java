package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.Categoria;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.DatosCompartidos;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Presupuesto;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorPresupuestos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.UUID;

public class ActualizarPresupuestoViewController {

    @FXML
    private AnchorPane AnchorPane_MenuActualizarPresupuesto;

    @FXML
    private Button Button_ActualizarPresupuesto;

    @FXML
    private Button Button_AtrasMenuPresupuesto;

    @FXML
    private Label Label_SaldoPresupuesto;

    @FXML
    private TextField TextField_AgregarNombrePresupuesto;


    @FXML
    private TextField TextField_AgregarMontoTotalPresupuesto;

    @FXML
    private TextField TextField_AgregarCategoriaPresupuesto;

    /**
     * Metodo que se ejecura al hacer click en el boton actualiza presupuesto
     * valida los datos, actualiza el presupuesto seleccionado y muestra el nuevo saldo
     * @param event
     */
    @FXML
    void onClick_ActualizarPresupuesto(ActionEvent event) {
        String id = DatosCompartidos.getInstancia().getPresupuestoSeleccionado().getIdPresupuesto();
        String nombre = TextField_AgregarNombrePresupuesto.getText();
        String montoStr = TextField_AgregarMontoTotalPresupuesto.getText();
        String nombreCategoria = TextField_AgregarCategoriaPresupuesto.getText();

        if (id.isBlank() || nombre.isBlank() || montoStr.isBlank() || nombreCategoria.isBlank()) {
            mostrarAlerta("Todos los campos son obligatorios");
            return;
        }

        try {
            double montoTotal = Double.parseDouble(montoStr);

            Presupuesto presupuestoExistente = GestorPresupuestos.getInstancia().buscarPresupuestoPorId(id);
            if (presupuestoExistente == null) {
                mostrarAlerta("No se encontró el presupuesto con el ID especificado");
                return;
            }

            Categoria categoria = new Categoria(UUID.randomUUID().toString(), nombreCategoria, "");

            GestorPresupuestos.getInstancia().actualizarPresupuesto(
                    presupuestoExistente,
                    nombre,
                    montoTotal,
                    presupuestoExistente.getMontoGastado(),
                    categoria
            );

            System.out.println("Presupuesto actualizado exitosamente");
            actualizarSaldoPresupuesto(presupuestoExistente);
            limpiarCampos();
            volverAMenuPresupuesto();
            DatosCompartidos.getInstancia().limpiarDatosCompartidos();

        } catch (NumberFormatException e) {
            mostrarAlerta("El monto debe ser un número válido");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que se ejecuta al hacer click en el boton atras
     * retorna a la vista del menu de presupuestos
     * @param event
     */
    @FXML
    void onClick_AtrasMenuPresupuesto(ActionEvent event) {
        volverAMenuPresupuesto();
    }

    /**
     * inicializa la vista con valores por defecto
     */
    @FXML
    void initialize() {
        Label_SaldoPresupuesto.setText("$ 0.00");
    }

    /**
     * Actualiza el label de saldo en la interfaz con base en los datos del presupuesto
     * @param presupuesto
     */
    private void actualizarSaldoPresupuesto(Presupuesto presupuesto) {
        if (presupuesto != null) {
            double saldo = presupuesto.getMontoAsignado() - presupuesto.getMontoGastado();
            Label_SaldoPresupuesto.setText(String.format("$ %.2f", saldo));
        }
    }

    /**
     * Limpia los campos del texto del formulario
     */
    private void limpiarCampos() {
        TextField_AgregarNombrePresupuesto.clear();
        TextField_AgregarMontoTotalPresupuesto.clear();
        TextField_AgregarCategoriaPresupuesto.clear();
    }

    /**
     * Carga la vusta del menu de presupuesto en el contenedor principal
     */
    private void volverAMenuPresupuesto() {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuActualizarPresupuesto.getParent();
            PantallaPrincipalUsuarioViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/presupuestoUsuario.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al volver al menú de presupuesto");
        }
    }

    /**
     * Muestra una alerta emergente con un mensaje determinado
     * @param mensaje
     */
    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validación");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}