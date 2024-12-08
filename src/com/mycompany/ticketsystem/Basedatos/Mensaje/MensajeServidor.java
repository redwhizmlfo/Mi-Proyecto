/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketsystem.Basedatos.Mensaje;

import java.io.Serializable;

/**
 *
 * @author trenalsur1
 */
public class MensajeServidor implements Serializable {
    private String tipo; // "NUEVO_TICKET", "ACTUALIZAR_ESTADO", "ERROR"
    private String contenido;
    
    public MensajeServidor(String tipo, String contenido) {
        this.tipo = tipo;
        this.contenido = contenido;
    }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    
    @Override
    public String toString() {
        return tipo + "|" + contenido;
    }

    
}
