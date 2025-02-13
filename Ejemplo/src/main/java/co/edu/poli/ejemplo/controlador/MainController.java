package co.edu.poli.ejemplo.controlador;

import co.edu.poli.ejemplo.modelo.Cliente;
import co.edu.poli.ejemplo.servicios.DAOCliente;

public class MainController {

    DAOCliente dao1;

    public MainController() {
        dao1 = new DAOCliente();
    }

    public String crearUsuario(Cliente c){
        return dao1.createCliente(c);
    }

    public void borrarUsuario(Cliente c){
        dao1.deleteCliente(c.getId());
    }

}
