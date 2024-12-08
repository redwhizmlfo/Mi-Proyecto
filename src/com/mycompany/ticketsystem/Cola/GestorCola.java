/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketsystem.Cola;

import com.mycompany.ticketsystem.Clientes.Cliente;
import com.mycompany.ticketsystem.Tickets.Ticket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author trenalsur1
 */
public class GestorCola {
    private BlockingQueue<Ticket> cola;
    private List<Ticket> historial;
    private int numeroActual;
    
    public GestorCola() {
        this.cola = new LinkedBlockingQueue<>();
        this.historial = new ArrayList<>();
        this.numeroActual = 0;
    }
    
    public synchronized Ticket generarTicket(Cliente cliente) {
        numeroActual++;
        Ticket ticket = new Ticket(numeroActual, cliente);
        cola.offer(ticket);
        historial.add(ticket);
        return ticket;
    }
    
    public Ticket siguiente() throws InterruptedException {
        Ticket ticket = cola.take();
        ticket.setEstado("EN_ATENCION");
        return ticket;
    }
    
    public void finalizarAtencion(Ticket ticket) {
        ticket.setEstado("ATENDIDO");
    }
    
    public int getTamañoCola() {
        return cola.size();
    }
    
    public List<Ticket> getHistorial() {
        return new ArrayList<>(historial);
    }

}
