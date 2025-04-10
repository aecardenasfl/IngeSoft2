package co.edu.poli.modelo;

public class GestorInformacionCliente {

    private String nombre;
    private String correo;

    public String actualizarInformacion(String nombre, String correo) {
        return "Actualizado: " + nombre + ", " + correo;
    }

    public String mostrarInformacion() {
        return "Nombre: Juan Pérez\nDirección: Calle 123";
    }
}
