package co.edu.poli.ejemplo.controlador;

import java.io.IOException;

import co.edu.poli.ejemplo.vista.Main;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        Main.setRoot("primary");
    }
}