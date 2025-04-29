package co.edu.poli.modelo;

public class ClienteFachada {

    private GestorInformacionCliente gestorInformacion;
    private GestorPagos gestorPagos;
    private GestorPedidos gestorPedidos;

    public ClienteFachada() {
        this.gestorInformacion = new GestorInformacionCliente();
        this.gestorPagos = new GestorPagos();
        this.gestorPedidos = new GestorPedidos();
    }

    // Gestión completa de información personal
    public String gestionarInformacionCliente(String nombre, String correo) {
        String actualizacion = gestorInformacion.actualizarInformacion(nombre, correo);
        String informacion = gestorInformacion.mostrarInformacion();
        return actualizacion + "\n" + informacion;
    }

    // Gestión completa del historial de pedidos
    public String gestionarHistorialPedidos(String nuevoPedido) {
        String resultadoPedido = gestorPedidos.realizarPedido(nuevoPedido);
        String historial = gestorPedidos.mostrarHistorialPedidos();
        return resultadoPedido + "\n" + historial;
    }

    // Gestión completa de métodos de pago
    public String gestionarMetodosPago(String metodo, boolean activo) {
        
        String metodosActivos = gestorPagos.mostrarMetodosPagoActivos();
        String cambioEstado = gestorPagos.bloquearMetodoPago(metodo, activo);
        return metodosActivos + "\n" +cambioEstado;
    }
}
