package co.edu.poli.modelo;

public class ProductoReal implements ProductoInterface {
    private String nombre;
    private double precio;
    private String descripcion;
    private Proveedor proveedor;

    public ProductoReal(String nombre, double precio, String descripcion, Proveedor proveedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    @Override
    public String obtenerDetalles() {
        return "Nombre: " + nombre + "\nPrecio: " + precio + "\nDescripción: " + descripcion +
               "\n" + proveedor.obtenerInformacion();
    }
}