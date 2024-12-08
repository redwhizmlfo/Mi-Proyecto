/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketsystem.Basedatos;

import com.mycompany.ticketsystem.Clientes.Cliente;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author trenalsur1
 */
public class BaseDatosClientes {
     private static Map<String, Cliente> clientes = new HashMap<>();
    
    static {
        // Inicializar algunos clientes de ejemplo
        clientes.put("12345678", new Cliente("12345678", "Juan Carlos", "Pérez Gómez"));
        clientes.put("23456789", new Cliente("23456789", "María Elena", "García López"));
        clientes.put("34567890", new Cliente("34567890", "Pedro Luis", "Martínez Ruiz"));
        clientes.put("45678901", new Cliente("45678901", "Ana María", "Sánchez Torres"));
        clientes.put("56789012", new Cliente("56789012", "Carlos Alberto", "Rodríguez Vargas"));
        clientes.put("67890123", new Cliente("67890123", "Laura Patricia", "González Castro"));
        clientes.put("78901234", new Cliente("78901234", "José Miguel", "Fernández Ríos"));
        clientes.put("89012345", new Cliente("89012345", "Carmen Rosa", "López Mendoza"));
        clientes.put("90123456", new Cliente("90123456", "Ricardo José", "Torres Silva"));
        clientes.put("01234567", new Cliente("01234567", "Isabel Cristina", "Morales Vega"));
    }
    
    public static Cliente buscarPorDNI(String dni) {
        return clientes.get(dni);
    }
    
    public static boolean existeCliente(String dni) {
        return clientes.containsKey(dni);
    }
    
    public static void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getDni(), cliente);
    }

}
