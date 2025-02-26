package co.edu.poli.ejemplo.modelo;

public class ProductoElectronico extends Producto {

    private float voltajeEntrada;

    public ProductoElectronico(float voltajeEntrada) {
        this.voltajeEntrada = voltajeEntrada;
    }

    public ProductoElectronico(float voltajeEntrada, String descripcion, String id, double precio) {
        super(descripcion, id, precio);
        this.voltajeEntrada = voltajeEntrada;
    }

    public float getVoltajeEntrada() {
        return voltajeEntrada;
    }

    public void setVoltajeEntrada(float voltajeEntrada) {
        this.voltajeEntrada = voltajeEntrada;
    }

    
}
