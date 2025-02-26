package co.edu.poli.ejemplo.controlador;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import co.edu.poli.ejemplo.modelo.Cliente;
import co.edu.poli.ejemplo.servicios.DAOCliente;

public class ClientController {

    DAOCliente dao1;

    public ClientController() {
        dao1 = new DAOCliente();
    }

    public void mostrarMenu() throws Exception {
        Scanner scanner = new Scanner(System.in); // Crear un solo scanner
        int opcion = 0;

        try {
            while (opcion != 6) {
                System.out.println("\n--- Menú Cliente ---");
                System.out.println("1. Crear Cliente");
                System.out.println("2. Ver todos los Clientes");
                System.out.println("3. Consultar cliente por ID");
                System.out.println("4. Actualizar Cliente");
                System.out.println("5. Eliminar Cliente");
                System.out.println("6. Volver al menú principal");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer del scanner

                switch (opcion) {
                    case 1:
                        crearCliente(scanner);  // Pasar el scanner
                        break;
                    case 2:
                        verTodosLosClientes();  // Ver todos los clientes
                        break;
                    case 3:
                        consultarCliente(scanner);  // Pasar el scanner
                        break;
                    case 4:
                        actualizarCliente(scanner);  // Pasar el scanner
                        break;
                    case 5:
                        eliminarCliente(scanner);  // Pasar el scanner
                        break;
                    case 6:
                        System.out.println("Volviendo al menú principal...");
                        MainController main1 = new MainController();
                        main1.mostrarMenu();
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        } finally {
            scanner.close(); // Cerrar el scanner solo al final
        }
    }

    // Método para crear un cliente
    public void crearCliente(Scanner scanner) throws SQLException { // Recibir scanner como parámetro
        try {

            System.out.print("Ingrese el ID del cliente: ");
            String idCrear = scanner.nextLine();
            System.out.print("Ingrese el nombre del cliente: ");
            String nombreCrear = scanner.nextLine();

            Cliente nuevoCliente = new Cliente();
            nuevoCliente.setId(idCrear);
            nuevoCliente.setNombre(nombreCrear);

            String mensaje = dao1.create(nuevoCliente);  // Llamar a DAOCliente para crear el cliente
            System.out.println(mensaje);
        } catch (Exception e) {
        }

    }

    // Método para ver todos los clientes
    public void verTodosLosClientes() throws SQLException {

        try {

            List<Cliente> clientes = dao1.readAll();
            if (clientes.isEmpty()) {
                System.out.println("No hay clientes registrados.");
            } else {
                for (Cliente c : clientes) {
                    System.out.println("ID: " + c.getId() + ", Nombre: " + c.getNombre());
                }
            }
        } catch (Exception e) {
        }
    }

    // Método para consultar un cliente específico
    public void consultarCliente(Scanner scanner) throws SQLException { // Recibir scanner como parámetro
        try {
            System.out.print("Ingrese el ID del cliente que desea consultar: ");
            String idConsultar = scanner.nextLine();

            Cliente cliente = dao1.read(idConsultar);
            if (cliente != null) {
                System.out.println("Cliente encontrado:");
                System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre());
            } else {
                System.out.println("Cliente con ID " + idConsultar + " no encontrado.");
            }
        } catch (Exception e) {
        }
    }

    // Método para actualizar un cliente
    public void actualizarCliente(Scanner scanner) throws SQLException { // Recibir scanner como parámetro

        try {

            System.out.print("Ingrese el ID del cliente a actualizar: ");
            String idActualizar = scanner.nextLine();

            Cliente clienteActualizar = dao1.read(idActualizar);
            if (clienteActualizar != null) {
                System.out.print("Ingrese el nuevo nombre del cliente: ");
                String nuevoNombre = scanner.nextLine();
                clienteActualizar.setNombre(nuevoNombre);

                String mensaje = dao1.update(idActualizar, clienteActualizar);  // Llamar a DAOCliente para actualizar
                System.out.println(mensaje);
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (Exception e) {
        }

    }

    // Método para eliminar un cliente
    public void eliminarCliente(Scanner scanner) throws SQLException { // Recibir scanner como parámetro
        try {

            System.out.print("Ingrese el ID del cliente a eliminar: ");
            String idEliminar = scanner.nextLine();

            Cliente clienteEliminar = dao1.read(idEliminar);
            if (clienteEliminar != null) {
                dao1.delete(idEliminar);  // Llamar a DAOCliente para eliminar
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (Exception e) {
        }

    }
}
