/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketsystem.Tickets;

import com.mycompany.ticketsystem.Clientes.Cliente;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author trenalsur1
 */
public class Ticket implements Serializable{
     private int numero;
    private Cliente cliente;
    private LocalDateTime fechaHora;
    private String estado; // "PENDIENTE", "EN_ATENCION", "ATENDIDO"
    
    public Ticket(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.fechaHora = LocalDateTime.now();
        this.estado = "PENDIENTE";
    }
    
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }


}
