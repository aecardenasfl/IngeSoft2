package co.edu.poli.modelo;

public class Proveedor {
    private String nombre;
    private String contacto;

    public Proveedor(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public String obtenerInformacion() {
        return "Proveedor: " + nombre + "\nContacto: " + contacto;
    }
}