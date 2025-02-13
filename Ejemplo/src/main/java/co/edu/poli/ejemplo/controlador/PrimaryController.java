package co.edu.poli.ejemplo.controlador;

import java.io.IOException;

import co.edu.poli.ejemplo.vista.Main;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        Main.setRoot("secondary");
    }
}
