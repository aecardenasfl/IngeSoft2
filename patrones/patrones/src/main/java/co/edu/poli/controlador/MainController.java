package co.edu.poli.controlador;

import co.edu.poli.modelo.ClienteFachada;
import co.edu.poli.modelo.ProductoProxy;
import co.edu.poli.modelo.ProductoReal;
import co.edu.poli.modelo.Proveedor;
import co.edu.poli.modelo.ProveedorFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private Button botonRealizar, botonAutenticar;
    @FXML
    private TextArea textResultado, textResultado2, textResultado3;
    @FXML
    private ComboBox<String> comboRol;

    @FXML
    public void initialize() {
        fachada = new ClienteFachada();
        comboRol.setItems(FXCollections.observableArrayList("admin", "cliente"));
        comboRol.setValue("cliente");  // Establecemos un valor predeterminado
    }

    @FXML
    void actualizarCliente(ActionEvent event) {
        String resultado = fachada.gestionarInformacionCliente("Carlos Díaz", "carlos@mail.com");
        textResultado.setText("Gestión de información del cliente:\n" + resultado);

    }

    @FXML
    void verPedidos(ActionEvent event) {
        String resultado = fachada.gestionarHistorialPedidos("Teclado mecánico");
        textResultado.setText("Gestión de pedidos:\n" + resultado);
    }

    @FXML
    void cambiarEstadoPagos(ActionEvent event) {
        String resultado = fachada.gestionarMetodosPago("Nequi", true);
        textResultado.setText("Gestión de métodos de pago:\n" + resultado);
    }

    @FXML
    public void verProducto(ActionEvent event) {
        // Obtener el valor seleccionado del ComboBox (admin, gerente, cliente)
        String rolSeleccionado = comboRol.getValue();

        // Mostrar el rol seleccionado en el TextArea
        textResultado2.setText("Rol seleccionado: " + rolSeleccionado);

        // Datos ficticios del producto
        String nombreProducto = "Producto A";
        double precioProducto = 100.0;
        String descripcionProducto = "Descripción del Producto A";

        Proveedor proveedor = new Proveedor("Proveedor A", "1234567890");

        // Crear el objeto ProductoReal con los datos
        ProductoReal productoReal = new ProductoReal(nombreProducto, precioProducto, descripcionProducto, proveedor);

        // Crear el Proxy con el ProductoReal y el rol seleccionado
        ProductoProxy productoProxy = new ProductoProxy(productoReal, rolSeleccionado);

        // Usar el Proxy para obtener los detalles del producto
        String resultado = productoProxy.obtenerDetalles();

        // Mostrar el resultado en el TextArea
        textResultado2.appendText("\n" + resultado);
    }

    @FXML
    private void mostrarProductosConProveedorCompartido() {
        // Crear proveedor compartido usando el Flyweight (factory)
        Proveedor proveedorCompartido = ProveedorFactory.obtenerProveedor("Distribuidora ABC", "contacto@abc.com");

        // Crear productos que usan ese proveedor
        ProductoReal producto1 = new ProductoReal("Producto A", 100.0, "Descripción A", proveedorCompartido);
        ProductoReal producto2 = new ProductoReal("Producto B", 150.0, "Descripción B", proveedorCompartido);

        // Mostrar en el TextArea
        StringBuilder sb = new StringBuilder();
        sb.append("=== Producto 1 ===\n").append(producto1.obtenerDetalles()).append("\n\n");
        sb.append("=== Producto 2 ===\n").append(producto2.obtenerDetalles());

        textResultado3.setText(sb.toString());
    }

}
