package co.edu.poli.ejemplo.controlador;

import java.util.List;
import java.util.Scanner;

import co.edu.poli.ejemplo.modelo.Producto;
import co.edu.poli.ejemplo.servicios.DAOProducto;

public class ProductoController {

    DAOProducto daoProducto;

    public ProductoController() {
        daoProducto = new DAOProducto();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in); // Crear un solo scanner
        int opcion = 0;

        try {
            while (opcion != 6) {
                System.out.println("\n--- Menú Producto ---");
                System.out.println("1. Crear Producto");
                System.out.println("2. Ver todos los Productos");
                System.out.println("3. Consultar producto por ID");
                System.out.println("4. Actualizar Producto");
                System.out.println("5. Eliminar Producto");
                System.out.println("6. Volver al menú principal");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer del scanner

                switch (opcion) {
                    case 1:
                        crearProducto(scanner);  // Pasar el scanner
                        break;
                    case 2:
                        verTodosLosProductos();  // Ver todos los productos
                        break;
                    case 3:
                        consultarProducto(scanner);  // Pasar el scanner
                        break;
                    case 4:
                        actualizarProducto(scanner);  // Pasar el scanner
                        break;
                    case 5:
                        eliminarProducto(scanner);  // Pasar el scanner
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

    // Método para crear un producto
    public void crearProducto(Scanner scanner) { // Recibir scanner como parámetro
        System.out.print("Ingrese el ID del producto: ");
        String idCrear = scanner.nextLine();
        System.out.print("Ingrese la descripción del producto: ");
        String descripcionCrear = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precioCrear = scanner.nextDouble();
        
        Producto nuevoProducto = new Producto(descripcionCrear, idCrear, precioCrear);
        
        String mensaje = daoProducto.create(nuevoProducto);  // Llamar a DAOProducto para crear el producto
        System.out.println(mensaje);  
    }

    // Método para ver todos los productos
    public void verTodosLosProductos() {
        List<Producto> productos = daoProducto.readAll();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto p : productos) {
                System.out.println("ID: " + p.getId() + ", Descripción: " + p.getDescripcion() + ", Precio: " + p.getPrecio());
            }
        }
    }

    // Método para consultar un producto específico
    public void consultarProducto(Scanner scanner) { // Recibir scanner como parámetro
        System.out.print("Ingrese el ID del producto que desea consultar: ");
        String idConsultar = scanner.nextLine();
        
        Producto producto = daoProducto.read(idConsultar);
        if (producto != null) {
            System.out.println("Producto encontrado:");
            System.out.println("ID: " + producto.getId() + ", Descripción: " + producto.getDescripcion() + ", Precio: " + producto.getPrecio());
        } else {
            System.out.println("Producto con ID " + idConsultar + " no encontrado.");
        }
    }

    // Método para actualizar un producto
    public void actualizarProducto(Scanner scanner) { // Recibir scanner como parámetro
        System.out.print("Ingrese el ID del producto a actualizar: ");
        String idActualizar = scanner.nextLine();
        
        Producto productoActualizar = daoProducto.read(idActualizar);
        if (productoActualizar != null) {
            System.out.print("Ingrese la nueva descripción del producto: ");
            String nuevaDescripcion = scanner.nextLine();
            System.out.print("Ingrese el nuevo precio del producto: ");
            double nuevoPrecio = scanner.nextDouble();
            productoActualizar.setDescripcion(nuevaDescripcion);
            productoActualizar.setPrecio(nuevoPrecio);
            
            String mensaje = daoProducto.update(idActualizar, productoActualizar);  // Llamar a DAOProducto para actualizar
            System.out.println(mensaje);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Método para eliminar un producto
    public void eliminarProducto(Scanner scanner) { // Recibir scanner como parámetro
        System.out.print("Ingrese el ID del producto a eliminar: ");
        String idEliminar = scanner.nextLine();
        
        Producto productoEliminar = daoProducto.read(idEliminar);
        if (productoEliminar != null) {
            daoProducto.delete(idEliminar);  // Llamar a DAOProducto para eliminar
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
