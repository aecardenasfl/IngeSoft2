package co.edu.poli.ejemplo.controlador;

import java.io.IOException;
import java.util.Scanner;

import co.edu.poli.ejemplo.servicios.Singleton;
import co.edu.poli.ejemplo.vista.Main;
import javafx.fxml.FXML;

public class MainController {

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Cliente");
            System.out.println("2. Pedido");
            System.out.println("3. Producto");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Opción seleccionada: Cliente");
                    // Llamamos al menú del controlador de Cliente
                    ClientController clientController = new ClientController();
                    clientController.mostrarMenu();
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Pedido");
                    // Llamamos al menú del controlador de Pedido
                    PedidoController pedidoController = new PedidoController();
                    pedidoController.mostrarMenu();
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Producto");
                    // Llamamos al menú del controlador de Producto
                    ProductoController productoController = new ProductoController();
                    productoController.mostrarMenu();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();  // Cerrar el scanner antes de salir
                    Singleton.cerrarConexion();  // Cerrar la conexión antes de salir
                    System.exit(0);  // Salir del programa
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    @FXML
    private void abrirCliente() throws IOException {
        Main.setRoot("cliente");
    }

}
