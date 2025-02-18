package co.edu.poli.ejemplo.servicios;

import java.util.List;

/**
 * Interfaz genérica CRUD para cualquier clase de modelo
 */
public interface CRUD<T> {

    /**
     * Crea una nueva instancia de tipo T en la base de datos.
     * @param t El objeto de tipo T a crear.
     * @return Mensaje que indica el resultado de la operación.
     */
    public String create(T t);

    /**
     * Obtiene todos los objetos de tipo T desde la base de datos.
     * @return Una lista con todos los objetos de tipo T.
     */
    public List<T> readAll();

    /**
     * Obtiene un objeto de tipo T de la base de datos usando su ID.
     * @param id El ID del objeto a obtener.
     * @return El objeto de tipo T, o null si no se encuentra.
     */
    public T read(String id);

    /**
     * Actualiza un objeto de tipo T en la base de datos.
     * @param id El ID del objeto a actualizar.
     * @param t El objeto con los nuevos datos.
     * @return Mensaje que indica el resultado de la operación.
     */
    public String update(String id, T t);

    /**
     * Elimina un objeto de tipo T de la base de datos usando su ID.
     * @param id El ID del objeto a eliminar.
     */
    public void delete(String id);
}
