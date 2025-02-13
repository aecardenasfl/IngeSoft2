package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class Producto {

    /**
     * Default constructor
     */
    public Producto() {
    }

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String descripcion;

    /**
     * 
     */
    private double precio;

    public Producto(String descripcion, String id, double precio) {
        this.descripcion = descripcion;
        this.id = id;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}