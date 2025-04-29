package co.edu.poli.modelo;

import java.util.HashMap;
import java.util.Map;

public class ProveedorFactory {
    private static final Map<String, Proveedor> proveedores = new HashMap<>();

    public static Proveedor obtenerProveedor(String nombre, String contacto) {
        String clave = nombre + "_" + contacto;
        if (!proveedores.containsKey(clave)) {
            proveedores.put(clave, new Proveedor(nombre, contacto));
        }
        return proveedores.get(clave);
    }
}