/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ticketsystem.formularios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class frmServidor extends javax.swing.JFrame {

    
    private ServerSocket serverSocketTickets;
    private ServerSocket serverSocketAtencion;
    private BlockingQueue<String> cola;
    private int numeroCola;
    private String IP;
    private int puerto;

    
    public frmServidor() {
        initComponents();
        cola = new LinkedBlockingQueue<>();
        numeroCola = 0;
        IP = "127.0.0.1";
        puerto = 5000;
        txtIP.setText(IP);
        txtPuerto.setText(Integer.toString(puerto));
        

        iniciarServidor();
    }
    //frmClienteAtencion
    
    private void iniciarServidor() {
        // Hilo para recibir tickets
        new Thread(() -> {
            try {
                serverSocketTickets = new ServerSocket(puerto);
                while (true) {
                    Socket clientSocket = serverSocketTickets.accept();
                    manejarCliente(clientSocket);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error en el servidor de tickets: " + e.getMessage());
            }
        }).start();

        // Hilo para atención al cliente
        new Thread(() -> {
            try {
                serverSocketAtencion = new ServerSocket(puerto + 1);
                while (true) {
                    Socket clienteAtencion = serverSocketAtencion.accept();
                    manejarAtencionCliente(clienteAtencion);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error en el servidor de atención: " + e.getMessage());
            }
        }).start();
    }
    
    
    private void manejarCliente(Socket socket) {
        new Thread(() -> {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String mensaje;
                while ((mensaje = in.readLine()) != null) {
                    if (mensaje.startsWith("TICKET|")) {
                        numeroCola++;
                        SwingUtilities.invokeLater(() -> {
                            txtNumCola.setText(String.valueOf(numeroCola));
                        });
                        cola.put(mensaje.substring(7));
                    }
                }
            } catch (IOException | InterruptedException e) {
                JOptionPane.showMessageDialog(this, "Error al manejar cliente: " + e.getMessage());
            }
        }).start();
    }

    private void manejarAtencionCliente(Socket socket) {
        new Thread(() -> {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                while (true) {
                    String datos = cola.take();
                    out.println(datos);
                }
            } catch (IOException | InterruptedException e) {
                JOptionPane.showMessageDialog(this, "Error al manejar atención: " + e.getMessage());
            }
        }).start();
    }



    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIP = new javax.swing.JTextField();
        txtPuerto = new javax.swing.JTextField();
        txtNumCola = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control/Servidor");

        txtIP.setEditable(false);
        txtIP.setBackground(new java.awt.Color(255, 153, 0));
        txtIP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtIP.setCaretColor(new java.awt.Color(255, 51, 0));

        txtPuerto.setEditable(false);
        txtPuerto.setBackground(new java.awt.Color(255, 153, 0));
        txtPuerto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtNumCola.setEditable(false);
        txtNumCola.setBackground(new java.awt.Color(0, 204, 204));
        txtNumCola.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("direccion IP:");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("Puerto:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setText("Clientes en Cola:");

        jButton1.setBackground(new java.awt.Color(102, 255, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 153, 0));
        jTextField1.setText("20");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setText("Tamaño Maximo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIP, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(txtPuerto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNumCola, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(99, 99, 99)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(txtNumCola, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(33, 33, 33))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new frmServidor().setVisible(true);
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtNumCola;
    private javax.swing.JTextField txtPuerto;
    // End of variables declaration//GEN-END:variables
}
