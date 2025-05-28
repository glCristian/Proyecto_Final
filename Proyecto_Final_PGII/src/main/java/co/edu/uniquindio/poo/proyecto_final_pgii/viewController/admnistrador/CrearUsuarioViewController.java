package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.admnistrador;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.BilleteraVirtual;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Usuario;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.UsuarioBuilder;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.ServicioBilleteraVirtual;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CrearUsuarioViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuCrearUsuario;

    @FXML
    private Button Button_AtrasMenuUsuarios;

    @FXML
    private Button Button_CrearUsuario;

    @FXML
    private TextField TextField_AgregarApellidosUsuario;

    @FXML
    private TextField TextField_AgregarDireccionUsuario;

    @FXML
    private TextField TextField_AgregarEmailUsuario;

    @FXML
    private TextField TextField_AgregarIDUsuario;

    @FXML
    private TextField TextField_AgregarNombreUsuario1;

    @FXML
    private TextField TextField_AgregarNumeroTelefonoUsuario;

    @FXML
    private TextField TextField_AgregarContrasenaUsuario;

    private ServicioBilleteraVirtual servicio;

    @FXML
    void onClick_AtrasMenuUsuarios(ActionEvent event) {
        try {
            AnchorPane contenedorPrincipal = (AnchorPane) AnchorPane_MenuCrearUsuario.getParent();

            PantallaPrincipalAdministradorViewController.cargarVistaEnPantallaPrincipal(
                    contenedorPrincipal,
                    "/co/edu/uniquindio/poo/proyecto_final_pgii/admnistrador/gestionarUsuarios.fxml"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_CrearUsuario(ActionEvent event) {
        try {
        String nombre = TextField_AgregarNombreUsuario1.getText();
        String apellido = TextField_AgregarApellidosUsuario.getText();
        String email = TextField_AgregarEmailUsuario.getText();
        String telefono = TextField_AgregarNumeroTelefonoUsuario.getText();
        String direccion = TextField_AgregarDireccionUsuario.getText();
        String idUsuario = TextField_AgregarIDUsuario.getText();
        String contrasena = TextField_AgregarContrasenaUsuario.getText();

        if (nombre.isBlank() || apellido.isBlank() || email.isBlank() || telefono.isBlank()
        || direccion.isBlank() || idUsuario.isBlank() || contrasena.isBlank()) {
            System.out.println("Todos los campos son obligatorios.");
            return;
        }

        if (!email.contains("@")) {
            mostrarAlerta("Error", "Email inválido");
            return;
        }

        if (contrasena.length() < 6) {
            mostrarAlerta("Error", "La contraseña debe tener al menos 6 caracteres");
            return;
        }

        Usuario usuarioComplejo = new UsuarioBuilder()
                .setNombres(nombre)
                .setApellidos(apellido)
                .setEmail(email)
                .setTelefono(telefono)
                .setDireccion(direccion)
                .setIdUsuario(idUsuario)
                .setContrasena(contrasena)
                .build();

        BilleteraVirtual.getInstancia().getPerfiles().add(usuarioComplejo);

        if (servicio == null) {
            servicio = new ServicioBilleteraVirtual();
        }
        servicio.agregarNotificacionEmail(email);

        servicio.configurarComisiones("ESCALONADA", 0);

        System.out.println("Se Creó exitosamente el Usuario " + usuarioComplejo.getNombres());

        } catch (Exception e) {
            mostrarAlerta("Error", "Error creando usuario: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @FXML
    void initialize() {
        assert AnchorPane_MenuCrearUsuario != null : "fx:id=\"AnchorPane_MenuCrearUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert Button_AtrasMenuUsuarios != null : "fx:id=\"Button_AtrasMenuUsuarios\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert Button_CrearUsuario != null : "fx:id=\"Button_CrearUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert TextField_AgregarApellidosUsuario != null : "fx:id=\"TextField_AgregarApellidosUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert TextField_AgregarDireccionUsuario != null : "fx:id=\"TextField_AgregarDireccionUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert TextField_AgregarEmailUsuario != null : "fx:id=\"TextField_AgregarEmailUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert TextField_AgregarIDUsuario != null : "fx:id=\"TextField_AgregarIDUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert TextField_AgregarNombreUsuario1 != null : "fx:id=\"TextField_AgregarNombreUsuario1\" was not injected: check your FXML file 'crearUsuario.fxml'.";
        assert TextField_AgregarNumeroTelefonoUsuario != null : "fx:id=\"TextField_AgregarNumeroTelefonoUsuario\" was not injected: check your FXML file 'crearUsuario.fxml'.";

        servicio = new ServicioBilleteraVirtual();
    }

    /**
     * Muestra una alerta con el mensaje de error proporcionado
     * @param titulo Titulo de la alerta
     * @param mensaje Mensaje de error a mostrar
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    /**
     * Limpia los campos del formulario de creación de usuario
     */
    private void limpiarFormulario() {
        TextField_AgregarNombreUsuario1.clear();
        TextField_AgregarApellidosUsuario.clear();
        TextField_AgregarEmailUsuario.clear();
        TextField_AgregarNumeroTelefonoUsuario.clear();
        TextField_AgregarDireccionUsuario.clear();
        TextField_AgregarIDUsuario.clear();
        TextField_AgregarContrasenaUsuario.clear();

    }
}
