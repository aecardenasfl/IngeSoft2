package co.edu.poli.modelo;

public class GestorPagos {

    public String bloquearMetodoPago(String metodo, boolean activo) {
        return (activo ? "Activado" : "Bloqueado") + " método: " + metodo;
    }

    public String mostrarMetodosPagoActivos() {
        return "Tarjeta de crédito\nNequi\nEfectivo";
    }
}
