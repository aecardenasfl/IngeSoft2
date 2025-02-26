package co.edu.poli.ejemplo.modelo;

public class ProductoAlimentos extends Producto{

    private float aporteCalorico;

    public float getAporteCalorico() {
        return aporteCalorico;
    }

    public void setAporteCalorico(float aporteCalorico) {
        this.aporteCalorico = aporteCalorico;
    }

    public ProductoAlimentos(float aporteCalorico) {
        this.aporteCalorico = aporteCalorico;
    }

    public ProductoAlimentos(String descripcion, String id, double precio, float aporteCalorico) {
        super(descripcion, id, precio);
        this.aporteCalorico = aporteCalorico;
    }


}
