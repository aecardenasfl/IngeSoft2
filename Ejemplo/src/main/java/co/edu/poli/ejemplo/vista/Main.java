package co.edu.poli.ejemplo.vista;

import java.io.IOException;

import co.edu.poli.ejemplo.controlador.MainController;
import co.edu.poli.ejemplo.modelo.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/co/edu/poli/ejemplo/vista/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        //launch();
        Cliente client1 = new Cliente("123", "Pepito");
        MainController main1 = new MainController();
        System.out.println(main1.crearUsuario(client1));
    }

}