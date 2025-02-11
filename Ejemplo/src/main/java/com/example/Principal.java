package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.modelo.Cliente;
import com.example.modelo.Pedido;
import com.example.modelo.Producto;

public class Principal {

    public static void main(String[] args) {

        //Crear objetos cliente:
        Cliente cliente1 = new Cliente("123", "John Doe");
        //crear objetos producto:
        Producto producto1 = new Producto("papitas fritas", "456", 6550);
        Producto producto2 = new Producto("tostacos", "457", 5550);
        //crear lista de productos:
        List<Producto> productos = new ArrayList<>();
        //agregar productos a la lista:
        productos.add(producto1);
        productos.add(producto2);
        //crear objeto pedido con los objetos creados anteriormente:
        Pedido pedido1 = new Pedido(cliente1, "2025-02-11", "001", productos);
        //Prueba de consulta:
        System.out.println("Cliente: " + pedido1.getCliente().getNombre());    
    }

}
