package co.edu.poli.ejemplo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements UnidadOrganizacional {

    private String nombre;
    private List<UnidadOrganizacional> elementos = new ArrayList<>();

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public void agregarElemento(UnidadOrganizacional elemento) {
        elementos.add(elemento);
    }

    public void eliminarElemento(UnidadOrganizacional elemento) {
        elementos.remove(elemento);
    }

    public String getNombre() {
        return nombre;
    }

    public List<UnidadOrganizacional> getElementos() {
        return elementos;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Departamento: " + nombre);
        for (UnidadOrganizacional elemento : elementos) {
            elemento.mostrarDetalles();
        }
    }

}
