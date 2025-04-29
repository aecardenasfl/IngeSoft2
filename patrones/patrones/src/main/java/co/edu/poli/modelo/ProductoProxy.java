package co.edu.poli.modelo;

public class ProductoProxy implements ProductoInterface {

    private ProductoReal productoReal;
    private String nivelUsuario;

    public ProductoProxy(ProductoReal productoReal, String nivelUsuario) {
        this.productoReal = productoReal;
        this.nivelUsuario = nivelUsuario;
        
    }

    @Override
    public String obtenerDetalles() {
        if (nivelUsuario.equalsIgnoreCase("admin") || nivelUsuario.equalsIgnoreCase("gerente")) {
            return productoReal.obtenerDetalles();
        } else {
            return "Acceso denegado:\nNo tienes permisos para ver los detalles del producto.";
        }
    }
}