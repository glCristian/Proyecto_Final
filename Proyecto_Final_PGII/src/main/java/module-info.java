module co.edu.uniquindio.poo.proyecto_final_pgii {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    opens co.edu.uniquindio.poo.proyecto_final_pgii.viewController to javafx.fxml;
    exports co.edu.uniquindio.poo.proyecto_final_pgii.viewController;

    opens co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario to javafx.fxml;
    exports co.edu.uniquindio.poo.proyecto_final_pgii.viewController.usuario;

    opens co.edu.uniquindio.poo.proyecto_final_pgii.app to javafx.fxml;
    exports co.edu.uniquindio.poo.proyecto_final_pgii.app;

    opens co.edu.uniquindio.poo.proyecto_final_pgii.model to javafx.fxml;
    exports co.edu.uniquindio.poo.proyecto_final_pgii.model;



}