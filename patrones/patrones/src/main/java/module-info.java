module co.edu.poli {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.vista to javafx.fxml;
    opens co.edu.poli.modelo to javafx.fxml;
    opens co.edu.poli.controlador to javafx.fxml;
    exports co.edu.poli.vista;
    exports co.edu.poli.modelo;
    exports co.edu.poli.controlador;

}

