package co.edu.poli.ejemplo.modelo;

public class Empleado implements UnidadOrganizacional {

    private String id;
    private String nombre;
    private String cargo;

    public Empleado(String id, String nombre, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", cargo=").append(cargo);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("ID" + id + " - Empleado: " + nombre + " - Cargo: " + cargo);
    }
}
