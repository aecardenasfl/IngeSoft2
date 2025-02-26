package co.edu.poli.ejemplo.controlador;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import co.edu.poli.ejemplo.modelo.Producto;
import co.edu.poli.ejemplo.modelo.ProductoAlimentos;
import co.edu.poli.ejemplo.modelo.ProductoElectronico;
import co.edu.poli.ejemplo.servicios.DAOProducto;

public class ProductoController {

    DAOProducto daoProducto;

    public ProductoController() {
        daoProducto = new DAOProducto();
    }

    public void mostrarMenu() throws Exception {
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
                System.out.println("6. Ver producto por rango de precios");
                System.out.println("7. Volver al menú principal");
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
                        verProductosPorRangoDePrecios(scanner);
                        break;
                    case 7:
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

    public void crearProducto(Scanner scanner) throws Exception {
        try {
            System.out.println("\n--- Seleccione el tipo de producto ---");
            System.out.println("1. Producto Electrónico");
            System.out.println("2. Producto de Alimentos");
            System.out.print("Ingrese su elección: ");

            int tipoProducto = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            System.out.print("Ingrese el ID del producto: ");
            String idCrear = scanner.nextLine();

            // Validar si el producto ya existe
            if (daoProducto.read(idCrear) != null) {
                System.out.println("Error: Ya existe un producto con el ID " + idCrear);
                return;
            }

            System.out.print("Ingrese la descripción del producto: ");
            String descripcionCrear = scanner.nextLine();
            System.out.print("Ingrese el precio del producto: ");

            // Validar entrada del precio
            if (!scanner.hasNextDouble()) {
                System.out.println("Error: El precio debe ser un número válido.");
                scanner.nextLine(); // Limpiar buffer
                return;
            }
            double precioCrear = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer

            Producto nuevoProducto;

            switch (tipoProducto) {
                case 1: // Producto Electrónico
                    System.out.print("Ingrese el voltaje de entrada: ");
                    if (!scanner.hasNextFloat()) {
                        System.out.println("Error: El voltaje debe ser un número válido.");
                        scanner.nextLine(); // Limpiar buffer
                        return;
                    }
                    float voltajeEntrada = scanner.nextFloat();
                    nuevoProducto = new ProductoElectronico(voltajeEntrada, descripcionCrear, idCrear, precioCrear);
                    break;

                case 2: // Producto de Alimentos
                    System.out.print("Ingrese el aporte calórico: ");
                    if (!scanner.hasNextFloat()) {
                        System.out.println("Error: El aporte calórico debe ser un número válido.");
                        scanner.nextLine(); // Limpiar buffer
                        return;
                    }
                    float aporteCalorico = scanner.nextFloat();
                    nuevoProducto = new ProductoAlimentos(descripcionCrear, idCrear, precioCrear, aporteCalorico);
                    break;

                default:
                    System.out.println("Opción no válida. Cancelando operación.");
                    return;
            }

            // Enviar el producto creado a DAOProducto
            String mensaje = daoProducto.create(nuevoProducto);
            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método para ver todos los productos
    public void verTodosLosProductos() throws SQLException {
        try {
            List<Producto> productos = daoProducto.readAll();
            if (productos.isEmpty()) {
                System.out.println("No hay productos registrados.");
            } else {
                for (Producto p : productos) {
                    System.out.println("ID: " + p.getId() + ", Descripción: " + p.getDescripcion() + ", Precio: " + p.getPrecio());
                }
            }
        } catch (Exception e) {
        }
    }
// Método para ver productos dentro de un rango de precios

    public void verProductosPorRangoDePrecios(Scanner scanner) throws SQLException {
        try {

            System.out.print("Ingrese el precio mínimo (entero): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                scanner.nextLine(); // Limpiar buffer
                return;
            }
            int precioMinInt = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            double precioMin = (double) precioMinInt;

            System.out.print("Ingrese el precio máximo (entero): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                scanner.nextLine(); // Limpiar buffer
                return;
            }
            int precioMaxInt = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            double precioMax = (double) precioMaxInt;

            List<Producto> productos = daoProducto.readAll();
            boolean hayProductos = false;

            for (Producto p : productos) {
                if (p.getPrecio() >= precioMin && p.getPrecio() <= precioMax) {
                    System.out.println("ID: " + p.getId() + ", Descripción: " + p.getDescripcion() + ", Precio: " + p.getPrecio());
                    hayProductos = true;
                }
            }

            if (!hayProductos) {
                System.out.println("No hay productos en el rango de precios especificado.");
            }
        } catch (Exception e) {
        }
    }

    // Método para ver todos los productos
    public void consultaProductoPrecios() throws SQLException {
        try {
            List<Producto> productos = daoProducto.readAll();
            if (productos.isEmpty()) {
                System.out.println("No hay productos registrados.");
            } else {
                for (Producto p : productos) {
                    System.out.println("ID: " + p.getId() + ", Descripción: " + p.getDescripcion() + ", Precio: " + p.getPrecio());
                }
            }
        } catch (Exception e) {
        }

    }

    // Método para consultar un producto específico
    public void consultarProducto(Scanner scanner) throws SQLException { // Recibir scanner como parámetro

        try {

            System.out.print("Ingrese el ID del producto que desea consultar: ");
            String idConsultar = scanner.nextLine();

            Producto producto = daoProducto.read(idConsultar);
            if (producto != null) {
                System.out.println("Producto encontrado:");
                System.out.println("ID: " + producto.getId() + ", Descripción: " + producto.getDescripcion() + ", Precio: " + producto.getPrecio());
            } else {
                System.out.println("Producto con ID " + idConsultar + " no encontrado.");
            }
        } catch (Exception e) {
        }
    }
// Método para actualizar un producto

    public void actualizarProducto(Scanner scanner) throws SQLException { // Recibir scanner como parámetro

        try {

            System.out.print("Ingrese el ID del producto a actualizar: ");
            String idActualizar = scanner.nextLine();

            Producto productoActualizar = daoProducto.read(idActualizar);
            if (productoActualizar != null) {
                System.out.print("Ingrese la nueva descripción del producto: ");
                String nuevaDescripcion = scanner.nextLine();
                System.out.print("Ingrese el nuevo precio del producto: ");
                double nuevoPrecio = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea pendiente

                productoActualizar.setDescripcion(nuevaDescripcion);
                productoActualizar.setPrecio(nuevoPrecio);

                // Verificar el tipo de producto y solicitar datos adicionales
                if (productoActualizar instanceof ProductoAlimentos) {
                    System.out.print("Ingrese el nuevo aporte calórico: ");
                    float nuevoAporteCalorico = scanner.nextFloat();
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    ((ProductoAlimentos) productoActualizar).setAporteCalorico(nuevoAporteCalorico);
                } else if (productoActualizar instanceof ProductoElectronico) {
                    System.out.print("Ingrese el nuevo voltaje de entrada: ");
                    float nuevoVoltajeEntrada = scanner.nextFloat();
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    ((ProductoElectronico) productoActualizar).setVoltajeEntrada(nuevoVoltajeEntrada);
                }

                String mensaje = daoProducto.update(idActualizar, productoActualizar);  // Llamar a DAOProducto para actualizar
                System.out.println(mensaje);
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (Exception e) {
        }

    }

    // Método para eliminar un producto
    public void eliminarProducto(Scanner scanner) throws SQLException { // Recibir scanner como parámetro
        try {
            System.out.print("Ingrese el ID del producto a eliminar: ");
            String idEliminar = scanner.nextLine();

            Producto productoEliminar = daoProducto.read(idEliminar);
            if (productoEliminar != null) {
                daoProducto.delete(idEliminar);  // Llamar a DAOProducto para eliminar
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (Exception e) {
        }

    }

}
