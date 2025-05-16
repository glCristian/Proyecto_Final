package co.edu.uniquindio.poo.proyecto_final_pgii.app;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.print.PageRange;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/co/edu/uniquindio/poo/proyecto_final_pgii/menuInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Inicio");
        stage.setScene(scene);
        stage.show();
    }

private static void crearPerfilesPrueba() {
    // Obtener instancias de los gestores
    GestorPerfiles gestorPerfiles = GestorPerfiles.getInstancia();
    GestorCuentas gestorCuentas = GestorCuentas.getInstancia();

    // Crear usuarios de prueba
    Usuario carlos = new Usuario(
            "Carlos",
            "López",
            "carlos@email.com",
            "3001234567",
            "Calle 123",
            "USR001",
            "123456"
    );


    Usuario ana = new Usuario(
            "Ana",
            "Martínez",
            "ana@email.com",
            "3157894562",
            "Avenida 456",
            "USR002",
            "654321"
    );



    // Crear administrador
    gestorPerfiles.crearAdministrador(
            "Admin",
            "Principal",
            "admin@sistema.com",
            "3009876543",
            "Avenida Central",
            "ADM001",
            "admin123"
    );

    // Crear cuentas para Usuario 1 (Carlos)
    Cuenta carlos1 = new Cuenta("Cuenta Ahorros Carlos", "BBVA", "1234 7896 6573",TipoCuenta.AHORRO);
    carlos.agregarCuenta(carlos1);
    BilleteraVirtual.getInstancia().getCuentas().add(carlos1);

    Cuenta carlos2 = new Cuenta("Cuenta Corriente Carlos", "Visa", "1527 7893 8965",TipoCuenta.CORRIENTE);
    carlos.agregarCuenta(carlos2);
    BilleteraVirtual.getInstancia().getCuentas().add(carlos2);


    // Crear cuentas para Usuario 2 (Ana)
    Cuenta ana1 = new Cuenta("Cuenta Ahorros Ana","Bancolombia", "1678 8956 8907",TipoCuenta.AHORRO );
    ana.agregarCuenta(ana1);
    BilleteraVirtual.getInstancia().getCuentas().add(ana1);

    Cuenta ana2 = new Cuenta("Cuenta Corriente Ana", "ScotiaBank" ,"4567 4589 3421", TipoCuenta.CORRIENTE);
    ana.agregarCuenta(ana2);
    BilleteraVirtual.getInstancia().getCuentas().add(ana2);

    BilleteraVirtual.getInstancia().getPerfiles().add(carlos);
    BilleteraVirtual.getInstancia().getPerfiles().add(ana);


    System.out.println("Perfiles y cuentas de prueba creados exitosamente");
    System.out.println("Usuario 1: carlos@email.com / Contraseña: 123456");
    System.out.println("Usuario 2: ana@email.com / Contraseña: 654321");
    System.out.println("Admin: admin@sistema.com / Contraseña: admin123");


    System.out.println(BilleteraVirtual.getInstancia().getCuentas());

}



    /**
     * Metodo estático para cargar vistas FXML desde cualquier parte de la aplicación
     * @param rutaFXML Ruta del archivo FXML a cargar
     * @param event Evento que dispara el cambio de vista
     * @throws IOException Si hay un error al cargar el archivo FXML
     */
    public static void cargarVista(String rutaFXML, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(rutaFXML));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        crearPerfilesPrueba();
        launch();
    }
}