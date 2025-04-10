package co.edu.poli.modelo;

public class ClienteFachada {
private GestorInformacionCliente gestorInformacion;
    private GestorPedidos gestorPedidos;
    private GestorPagos gestorPagos;

    public ClienteFachada() {
        this.gestorInformacion = new GestorInformacionCliente();
        this.gestorPedidos = new GestorPedidos();
        this.gestorPagos = new GestorPagos();
    }

    // Métodos de la fachada

    public String actualizarInformacionCliente(String nombre, String correo) {
       return gestorInformacion.actualizarInformacion(nombre, correo);
    }

    public String mostrarInformacionCliente() {
        return gestorInformacion.mostrarInformacion();
    }

    public String realizarPedidoCliente(String pedido) {
        return gestorPedidos.realizarPedido(pedido);
    }

    public String mostrarHistorialPedidosCliente() {
       return gestorPedidos.mostrarHistorialPedidos();
    }

    public String bloquearMetodoPagoCliente(String metodo, boolean activo) {
        return gestorPagos.bloquearMetodoPago(metodo, activo);
    }

    public String mostrarMetodosPagoActivosCliente() {
       return gestorPagos.mostrarMetodosPagoActivos();
    }
}
