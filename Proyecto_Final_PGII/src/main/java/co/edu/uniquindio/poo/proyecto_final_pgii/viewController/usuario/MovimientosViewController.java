package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.GestorSesion;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Movimiento;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Transaccion;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class MovimientosViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane_MenuMovimientos;

    @FXML
    private ComboBox<String> ComboBox_CategoriaMovimientos;

    @FXML
    private ListView<Movimiento> TableView_Movimientos;

    Usuario usuarioActual = GestorSesion.getInstancia().getUsuarioActual();



    @FXML
    void initialize() {
        assert AnchorPane_MenuMovimientos != null : "fx:id=\"AnchorPane_MenuMovimientos\" was not injected: check your FXML file 'movimientosUsuario.fxml'.";
        assert ComboBox_CategoriaMovimientos != null : "fx:id=\"ComboBox_CategoriaMovimientos\" was not injected: check your FXML file 'movimientosUsuario.fxml'.";
        assert TableView_Movimientos != null : "fx:id=\"TableView_Movimientos\" was not injected: check your FXML file 'movimientosUsuario.fxml'.";

        ComboBox_CategoriaMovimientos.getItems().addAll("Todos ", "Envios " , "Depositos " , "Retiros ");
        ComboBox_CategoriaMovimientos.setValue("Todos ");

        //ComboBox_CategoriaMovimientos.setOnAction(event -> filtrarMovimientos());


    }



}
