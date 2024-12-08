/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ticketsystem.formularios;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class frmGestor extends javax.swing.JFrame {
    
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String numeroCola;
    
    public frmGestor(String numeroCola) {
        this.numeroCola = numeroCola;
         
        initComponents();
        txtNumeroCola.setText(numeroCola);
        
        
        
        
        conectarServidor();
        
        
        btnFinalizarAtencion.addActionListener(this::btnFinalizarAtencionActionPerformed);
        
        
        ChartPanel chartPanel = createStatisticalGraph();
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 200)); // Ajustar tamaño del panel
        graficaPanel.setLayout(new BorderLayout());
        graficaPanel.add(chartPanel, BorderLayout.CENTER);
        graficaPanel.validate();
        
    }
    private void btnFinalizarAtencionActionPerformed(ActionEvent evt) {
        try {
            // Enviar mensaje al servidor para finalizar atención
            out.println("FINALIZAR_ATENCION:" + numeroCola);
            String respuesta = in.readLine();
            
            if ("ATENCION_FINALIZADA".equals(respuesta)) {
                JOptionPane.showMessageDialog(this, "Atención finalizada exitosamente");
                
                // Abrir nuevamente el formulario de cliente de atención
                frmClienteAtencion clienteAtencion = new frmClienteAtencion();
                clienteAtencion.setVisible(true);
                
                // Cerrar ventana actual
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al finalizar la atención");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error de comunicación: " + e.getMessage());
        }
    }

    private void conectarServidor() {
        try {
            socket = new Socket("localhost", 5000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar con el servidor: " + e.getMessage());
        }
    }

    private ChartPanel createStatisticalGraph() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        // Datos de ejemplo: Tiempos de espera para diferentes tipos de trámites
        dataset.addValue(15, "Tiempo de Espera", "lunes");
        dataset.addValue(25, "Tiempo de Espera", "martes");
        dataset.addValue(10, "Tiempo de Espera", "miercoles");
        dataset.addValue(30, "Tiempo de Espera", "jueves");
         dataset.addValue(45, "Tiempo de Espera", "viernes");
          dataset.addValue(60, "Tiempo de Espera", "sabado");
        
        JFreeChart chart = ChartFactory.createBarChart(
            "Tiempo de Espera por Trámite",  // Título del gráfico
            "Tipo de Trámite",               // Etiqueta del eje X
            "Minutos",                       // Etiqueta del eje Y
            dataset,                          // Conjunto de datos
            PlotOrientation.VERTICAL,        // Orientación del gráfico
            false, true, false               // Mostrar leyenda, tooltips, urls
        );
        
        return new ChartPanel(chart);
    }
    

    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graficaPanel = new javax.swing.JPanel();
        txtNumeroCola = new javax.swing.JTextField();
        txtMaxCola = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnFinalizarAtencion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout graficaPanelLayout = new javax.swing.GroupLayout(graficaPanel);
        graficaPanel.setLayout(graficaPanelLayout);
        graficaPanelLayout.setHorizontalGroup(
            graficaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graficaPanelLayout.setVerticalGroup(
            graficaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );

        txtNumeroCola.setEditable(false);
        txtNumeroCola.setBackground(new java.awt.Color(255, 255, 0));
        txtNumeroCola.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        txtNumeroCola.setBorder(new javax.swing.border.MatteBorder(null));
        txtNumeroCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroColaActionPerformed(evt);
            }
        });

        txtMaxCola.setEditable(false);
        txtMaxCola.setBackground(new java.awt.Color(255, 255, 0));
        txtMaxCola.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        txtMaxCola.setText("20");

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("MINIMA COLA");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("MAXIMO COLA");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel3.setText("Adminitrador de Cola");

        btnFinalizarAtencion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFinalizarAtencion.setText("Cerrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNumeroCola, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaxCola, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graficaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnFinalizarAtencion)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaxCola, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroCola, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(graficaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinalizarAtencion)
                        .addGap(54, 54, 54))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroColaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroColaActionPerformed

    
    public static void main(String args[]) {
    SwingUtilities.invokeLater(() -> {
        frmGestor formulario = new frmGestor("1");
        formulario.setVisible(true);
    });
}
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarAtencion;
    private javax.swing.JPanel graficaPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtMaxCola;
    private javax.swing.JTextField txtNumeroCola;
    // End of variables declaration//GEN-END:variables
}
