package co.edu.poli.controlador;

import co.edu.poli.modelo.ClienteFachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainController {

    private ClienteFachada fachada;

    @FXML
    private Button botonActualizarCliente;
    @FXML
    private Button botonEstadoPagos;

    @FXML
    private Button botonMostrarCliente;

    @FXML
    private Button botonMostrarHistorial;

    @FXML
    private Button botonMostrarMetodos;

    @FXML
    private Button botonRealizar;

    @FXML
    private TextArea textResultado;

    @FXML
    public void initialize() {
        fachada = new ClienteFachada();
    }

     @FXML
void actualizarCliente(ActionEvent event) {
    String msg1 = fachada.actualizarInformacionCliente("Carlos Díaz", "Calle 456");
    String msg2 = fachada.realizarPedidoCliente("Audífonos Bluetooth");
    String msg3 = fachada.bloquearMetodoPagoCliente("Efectivo", true);

    textResultado.setText(
    "Cliente actualizado, pedido agregado y método de pago cambiado.\n\n" +
    "Resultados:\n" +
    msg1 + "\n" +
    msg2 + "\n" +
    msg3
);

}

    @FXML
    void mostrarCliente(ActionEvent event) {
        String info = fachada.mostrarInformacionCliente();
        textResultado.setText("Información del cliente:\n" + info);
    }

    @FXML
    void verPedidos(ActionEvent event) {
        String pedidos = fachada.mostrarHistorialPedidosCliente();
        String pagos = fachada.mostrarMetodosPagoActivosCliente();
        textResultado.setText("Historial de pedidos:\n" + pedidos + "\n\nMétodos de pago:\n" + pagos);
    }
}

