/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticketsystem.Basedatos.Conection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author trenalsur1
 */
public class Conexion {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    
    public Conexion(String host, int puerto) throws IOException {
        this.socket = new Socket(host, puerto);
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    
    public void enviarMensaje(String mensaje) {
        out.println(mensaje);
    }
    
    public String recibirMensaje() throws IOException {
        return in.readLine();
    }
    
    public void cerrar() {
        try {
            if (out != null) out.close();
            if (in != null) in.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
