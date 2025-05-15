package co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

import java.net.URL;
import java.util.ResourceBundle;
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
    private ComboBox<?> ComboBox_CategoriaMovimientos;

    @FXML
    private ListView<?> TableView_Movimientos;

    @FXML
    void initialize() {
        assert AnchorPane_MenuMovimientos != null : "fx:id=\"AnchorPane_MenuMovimientos\" was not injected: check your FXML file 'movimientosUsuario.fxml'.";
        assert ComboBox_CategoriaMovimientos != null : "fx:id=\"ComboBox_CategoriaMovimientos\" was not injected: check your FXML file 'movimientosUsuario.fxml'.";
        assert TableView_Movimientos != null : "fx:id=\"TableView_Movimientos\" was not injected: check your FXML file 'movimientosUsuario.fxml'.";

    }

}
