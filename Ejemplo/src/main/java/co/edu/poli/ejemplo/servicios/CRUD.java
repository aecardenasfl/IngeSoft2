package co.edu.poli.ejemplo.servicios;

import java.util.List;

import co.edu.poli.ejemplo.modelo.Cliente;

/**
 * 
 */
public interface CRUD {

    /**
     * @param c 
     * @return
     */
    public String createCliente(Cliente c);

    /**
     * @return
     */
    public List<Cliente> readAllCliente();

    /**
     * @param id 
     * @return
     */
    public Cliente readCliente(String id);

    /**
     * @param id 
     * @param c 
     * @return
     */
    public String updateCliente(String id, Cliente c);

    /**
     * @param id
     */
    public void deleteCliente(String id);

}