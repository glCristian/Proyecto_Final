package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;


import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.stream.Collectors;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.Categoria;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Cuenta;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.DatosCompartidos;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorCategorias;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorTransacciones;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RetirarDineroViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuSacarDinero;

    @FXML
    private Button Button_AtrasMenuTransaccion;

    @FXML
    private Button Button_SacarDinero;

    @FXML
    private Label Label_BancoCuenta;

    @FXML
    private Label Label_NumeroCuenta;

    @FXML
    private Label Label_SaldoCuenta;

    @FXML
    private ComboBox<String> ComboBox_CategoriaTransaccion;

    @FXML
    private TextField TextField_DescripcionSacar;

    @FXML
    private TextField TextField_MontoSacarDinero;

    @FXML
    private TextField TextField_NumeroCuentaDestinoSacar;

    @FXML
    void onClick_AtrasMenuTransaccion(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuSacarDinero.getParent();

            PantallaPrincipalAdministradorViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/gestionarTransacciones.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_SacarDinero(ActionEvent event) {
        Cuenta cuentaSeleccionada = DatosCompartidos.getInstancia().getCuentaSeleccionada();

        if (cuentaSeleccionada == null){
            System.out.println("No hay cuenta seleccionada");
            return;
        }

        String montoTexto = TextField_MontoSacarDinero.getText();
        String descripcion = TextField_DescripcionSacar.getText();
        String numeroCuentaOrigen = cuentaSeleccionada.getNumeroCuenta();


        String nombreCategoria = ComboBox_CategoriaTransaccion.getValue();
        Categoria categoria = GestorCategorias.getInstancia().obtenerCategoriaPorNombre(nombreCategoria);


        double monto;
        try {
            monto = Double.parseDouble(montoTexto);
        } catch (NumberFormatException e){
            System.out.println("El monto debe ser un numero valido");
            return;
        }

        if (monto <= 0){
            System.out.println("El monto debe ser mayor a cero");
            return;
        }

        if (cuentaSeleccionada.getSaldoTotal() < monto){
            System.out.println("Saldo insuficiente para realizar el retiro");
            return;
        }

        GestorTransacciones.getInstancia().realizarRetiro(numeroCuentaOrigen, monto, descripcion, categoria);

        System.out.println("Dinero retirado exitosamente");
    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuSacarDinero != null : "fx:id=\"AnchorPane_MenuSacarDinero\" was not injected: check your FXML file 'retirarDinero.fxml'.";
        assert Button_AtrasMenuTransaccion != null : "fx:id=\"Button_AtrasMenuTransaccion\" was not injected: check your FXML file 'retirarDinero.fxml'.";
        assert Button_SacarDinero != null : "fx:id=\"Button_SacarDinero\" was not injected: check your FXML file 'retirarDinero.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'retirarDinero.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'retirarDinero.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'retirarDinero.fxml'.";
        assert TextField_DescripcionSacar != null : "fx:id=\"TextField_DescripcionSacar\" was not injected: check your FXML file 'retirarDinero.fxml'.";
        assert TextField_MontoSacarDinero != null : "fx:id=\"TextField_MontoSacarDinero\" was not injected: check your FXML file 'retirarDinero.fxml'.";
        assert TextField_NumeroCuentaDestinoSacar != null : "fx:id=\"TextField_NumeroCuentaDestinoSacar\" was not injected: check your FXML file 'retirarDinero.fxml'.";

        cargarCategorias();
        cargarDatosCuenta();
    }

    /**
     * Carga las categorias predefinidas en el ComboBox de categorias
     */
    private void cargarCategorias() {
        Collection<Categoria> categorias = GestorCategorias.getInstancia().obtenerCategoriasPredefinidas();
        List<String> nombresCategorias = categorias.stream()
                .map(Categoria::getNombre)
                .collect(Collectors.toList());

        ComboBox_CategoriaTransaccion.getItems().addAll(nombresCategorias);
        ComboBox_CategoriaTransaccion.setValue(nombresCategorias.get(0)); // Seleccionar primera categoría por defecto
    }

    /**
     * Carga y muestra los datos de la cuenta seleccionada en los labels
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

