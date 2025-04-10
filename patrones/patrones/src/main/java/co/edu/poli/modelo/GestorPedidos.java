package co.edu.poli.modelo;

public class GestorPedidos {


    public String realizarPedido(String pedido) {
        return "Pedido realizado: " + pedido;
    }

    public String mostrarHistorialPedidos() {
        return "Pedido #1 - Entregado\nPedido #2 - En camino";
    }
}
