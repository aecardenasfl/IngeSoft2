package co.edu.poli.modelo;

public class GestorPagos {

    public String bloquearMetodoPago(String metodo, boolean activo) {
        return "Método: " + metodo+" estado:"+(activo ? " Activado" : " Bloqueado");
    }

    public String mostrarMetodosPagoActivos() {
        return "Tarjeta de crédito\nNequi\nEfectivo";
    }
}
