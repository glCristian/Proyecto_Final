package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.stream.Collectors;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorCategorias;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorTransacciones;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private TextField TextField_DescripcionAgragar;

    @FXML
    private TextField TextField_MontoAgregarDinero;

    @FXML
    private TextField TextField_NumeroCuentaOrigenAgregar;

    @FXML
    private ComboBox<String> ComboBox_CategoriaTransaccion;


    /**
     * Maneja el evento de click en el boton de agregarDinero
     * Valida los datps ingresador y realiza la opetacion de deposito
     * @param event
     */
    @FXML
    void onClick_AgregarDinero(ActionEvent event) {

        String montoStr = TextField_MontoAgregarDinero.getText();
        String descripcion = TextField_DescripcionAgragar.getText();
        String cuentaDestino = TextField_NumeroCuentaOrigenAgregar.getText();

        String nombreCategoria = ComboBox_CategoriaTransaccion.getValue();
        Categoria categoria = GestorCategorias.getInstancia().obtenerCategoriaPorNombre(nombreCategoria);



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

        GestorTransacciones.getInstancia().realizarDeposito(cuentaDestino, monto, descripcion, categoria);

        System.out.println("Deposito realizado con exito");

    }

    /**
     * Maneja el evento de click en el boton de atras
     * Navega el regreso al menu de transacciones del usuario
     * @param event
     */
    @FXML
    void onClick_AtrasMenuTransaccion(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuAgregarDinero.getParent();

            PantallaPrincipalUsuarioViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/usuario/transaccionUsuario.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo de inicializacion llamado automaticamente al cargar la vista
     * Verifica que todos los componentes esten correctamente inyectados
     */
    @FXML
    void initialize() {
        assert AnchorPane_MenuAgregarDinero != null : "fx:id=\"AnchorPane_MenuAgregarDinero\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert Button_AgregarDinero != null : "fx:id=\"Button_AgregarDinero\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert Button_AtrasMenuTransaccion != null : "fx:id=\"Button_AtrasMenuTransaccion\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert Label_BancoCuenta != null : "fx:id=\"Label_BancoCuenta\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert Label_NumeroCuenta != null : "fx:id=\"Label_NumeroCuenta\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert Label_SaldoCuenta != null : "fx:id=\"Label_SaldoCuenta\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert TextField_DescripcionAgragar != null : "fx:id=\"TextField_DescripcionAgragar\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert TextField_MontoAgregarDinero != null : "fx:id=\"TextField_MontoAgregarDinero\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";
        assert TextField_NumeroCuentaOrigenAgregar != null : "fx:id=\"TextField_NumeroCuentaOrigenAgregar\" was not injected: check your FXML file 'agregarDineroUsuario.fxml'.";

        cargarCategorias();


        cargarDatosCuenta();
    }

    /**
     * Carga las categorias predefinidas en el comboBox de categorias
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
