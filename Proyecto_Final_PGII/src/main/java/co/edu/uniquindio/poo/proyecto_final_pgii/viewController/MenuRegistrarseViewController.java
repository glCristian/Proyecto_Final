package co.edu.uniquindio.poo.proyecto_final_pgii.viewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import co.edu.uniquindio.poo.proyecto_final_pgii.app.App;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.ServicioBilleteraVirtual;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MenuRegistrarseViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Button_AtrasMenuInicio;

    @FXML
    private Button Button_Registrarse;

    @FXML
    private TextField TextField_IngresarApellidos;

    @FXML
    private TextField TextField_IngresarCrearContrasenia;

    @FXML
    private TextField TextField_IngresarEmail;

    @FXML
    private TextField TextField_IngresarNombres;

    @FXML
    private TextField TextField_IngresarTelefono;

    private ServicioBilleteraVirtual servicio;

    /**
     * Maneja el evento de click en el boton atras
     * regresa a la vista del menu de inciio
     * @param event
     */
    @FXML
    void onClick_AtrasMenuInicio(ActionEvent event) {
        try {
            App.cargarVista("/co/edu/uniquindio/poo/proyecto_final_pgii/menuInicio.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Maneja el evento de click en el boton registrarse
     * inicia el proceso para crear un nuevo usuario complto
     * @param event
     */
    @FXML
    void onClick_Registrarse(ActionEvent event) {
        crearUsuarioCompleto();
    }


    /**
     * Metodo de inicializacion llamado automaticamente al cargar la vista
     * Verifica que todos los componentes esten correctamente inyectados
     */
    @FXML
    void initialize() {
        assert Button_AtrasMenuInicio != null : "fx:id=\"Button_AtrasMenuInicio\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";
        assert Button_Registrarse != null : "fx:id=\"Button_Registrarse\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";
        assert TextField_IngresarApellidos != null : "fx:id=\"TextField_IngresarApellidos\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";
        assert TextField_IngresarCrearContrasenia != null : "fx:id=\"TextField_IngresarCrearContrasenia\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";
        assert TextField_IngresarEmail != null : "fx:id=\"TextField_IngresarEmail\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";
        assert TextField_IngresarNombres != null : "fx:id=\"TextField_IngresarNombres\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";
        assert TextField_IngresarTelefono != null : "fx:id=\"TextField_IngresarTelefono\" was not injected: check your FXML file 'menuRegistrarse.fxml'.";

        servicio = new ServicioBilleteraVirtual();
    }

    /**
     * MÉTODO QUE USA PATRÓN BUILDER PARA CREAR USUARIO COMPLEJO
     */
    private void crearUsuarioCompleto() {
        try {
            // 1. Obtener datos del formulario
            String nombres = TextField_IngresarNombres.getText().trim();
            String apellidos = TextField_IngresarApellidos.getText().trim();
            String email = TextField_IngresarEmail.getText().trim();
            String telefono = TextField_IngresarTelefono.getText().trim();
            String contrasena = TextField_IngresarCrearContrasenia.getText();

            // 2. Validaciones básicas
            if (nombres.isEmpty() || apellidos.isEmpty() || email.isEmpty() ||
                    telefono.isEmpty() || contrasena.isEmpty()) {
                mostrarAlerta("Error", "Todos los campos son obligatorios");
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

            // 3. USAR PATRÓN BUILDER PARA CREAR USUARIO COMPLEJO
            String idUsuario = UUID.randomUUID().toString().substring(0, 8);

            // Crear cuentas iniciales automáticamente
            Cuenta cuentaAhorro = new Cuenta(
                    UUID.randomUUID().toString().substring(0, 8),
                    "Banco Digital", // Banco por defecto
                    generarNumeroCuenta(),
                    TipoCuenta.AHORRO
            );
            cuentaAhorro.depositar(50000.0); // Bono de bienvenida

            // Crear presupuesto inicial
            Categoria categoriaGeneral = new Categoria(
                    UUID.randomUUID().toString(),
                    "Gastos Generales",
                    "Presupuesto inicial para gastos diversos"
            );

            Presupuesto presupuestoInicial = new Presupuesto(
                    UUID.randomUUID().toString().substring(0, 8),
                    "Mi Primer Presupuesto",
                    10000.0, // $10,000 de presupuesto inicial
                    0.0,
                    categoriaGeneral
            );

            // Crear notificación de bienvenida personalizada
            Notificacion notificacionBienvenida = new Notificacion(
                    UUID.randomUUID().toString(),
                    "¡Bienvenido/a " + nombres + "! Tu cuenta ha sido creada exitosamente. " +
                            "Tienes un bono de $50,000 en tu cuenta de ahorro y un presupuesto inicial configurado.",
                    new java.util.Date(),
                    "BIENVENIDA_PREMIUM"
            );

            // 4. CONSTRUIR USUARIO USANDO PATRÓN BUILDER
            Usuario usuarioComplejo = new UsuarioBuilder()
                    .setNombres(nombres)
                    .setApellidos(apellidos)
                    .setEmail(email)
                    .setTelefono(telefono)
                    .setDireccion("Por definir") // Se puede actualizar después
                    .setIdUsuario(idUsuario)
                    .setContrasena(contrasena)
                    .agregarCuentaInicial(cuentaAhorro)        // Cuenta con bono
                    .agregarPresupuestoInicial(presupuestoInicial) // Presupuesto configurado
                    .setNotificacionBienvenida(notificacionBienvenida) // Notificación personalizada
                    .build();

            // 5. Registrar en el sistema
            BilleteraVirtual.getInstancia().getPerfiles().add(usuarioComplejo);
            BilleteraVirtual.getInstancia().getCuentas().add(cuentaAhorro);

            // 6. CONFIGURAR OBSERVADORES (PATRÓN OBSERVER)
            if (servicio == null) {
                servicio = new ServicioBilleteraVirtual();
            }
            servicio.agregarNotificacionEmail(email); // Notificaciones automáticas

            // 7. CONFIGURAR ESTRATEGIA DE COMISIONES (PATRÓN STRATEGY)
            servicio.configurarComisiones("ESCALONADA", 0); // Sin comisión para nuevos usuarios

            // 8. Mostrar éxito y detalles
            mostrarExitoRegistro(usuarioComplejo, cuentaAhorro, presupuestoInicial);

            // 9. Limpiar formulario
            limpiarFormulario();

        } catch (Exception e) {
            mostrarAlerta("Error", "Error creando usuario: " + e.getMessage());
            e.printStackTrace();
        }

    }


    /**
     * Mostrar detalles del usuario creado
     */
    private void mostrarExitoRegistro(Usuario usuario, Cuenta cuenta, Presupuesto presupuesto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("¡Registro Exitoso!");
        alert.setHeaderText("Usuario creado correctamente");

        String mensaje = String.format(
                "¡Bienvenido/a %s %s!\n\n" +
                        "📧 Email: %s\n" +
                        "🆔 ID Usuario: %s\n\n" +
                        "🎁 BENEFICIOS INCLUIDOS:\n" +
                        "💰 Cuenta de Ahorro: %s\n" +
                        "💵 Bono de Bienvenida: $%.2f\n" +
                        "📊 Presupuesto Inicial: %s ($%.2f)\n" +
                        "🔔 Notificaciones: Activadas\n" +
                        "💳 Comisiones: Sin costo inicial\n\n" +
                        "¡Ya puedes iniciar sesión!",
                usuario.getNombres(), usuario.getApellidos(),
                usuario.getEmail(),
                usuario.getIdUsuario(),
                cuenta.getNumeroCuenta(),
                cuenta.getSaldoTotal(),
                presupuesto.getNombre(),
                presupuesto.getMontoAsignado()
        );

        alert.setContentText(mensaje);
        alert.showAndWait();
    }


    /**
     * Generar número de cuenta aleatorio
     */
    private String generarNumeroCuenta() {
        return String.format("%04d %04d %04d %04d",
                (int)(Math.random() * 10000),
                (int)(Math.random() * 10000),
                (int)(Math.random() * 10000),
                (int)(Math.random() * 10000));
    }

    /**
     * Mostrar alertas
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    /**
     * Limpiar formulario después del registro
     */
    private void limpiarFormulario() {
        TextField_IngresarNombres.clear();
        TextField_IngresarApellidos.clear();
        TextField_IngresarEmail.clear();
        TextField_IngresarTelefono.clear();
        TextField_IngresarCrearContrasenia.clear();
    }


}
