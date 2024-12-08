/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication74;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author trenalsur1
 */
public class GraficoBarras extends JFrame {

    public GraficoBarras(String title) {
        super(title);

        // Crear el dataset
        DefaultCategoryDataset dataset = crearDataset();

        // Crear el gráfico de barras
        JFreeChart barChart = ChartFactory.createBarChart(
                "Tiempo de Atención por Día",
                "Día de la Semana",
                "Tiempo (minutos)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Crear un panel para el gráfico
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset crearDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Datos simulados
        Map<String, Double> tiemposAtencion = new HashMap<>();
        tiemposAtencion.put("Lunes", 5.0);
        tiemposAtencion.put("Martes", 7.0);
        tiemposAtencion.put("Miércoles", 6.0);
        tiemposAtencion.put("Jueves", 4.5);
        tiemposAtencion.put("Viernes", 8.0);

        // Agregar datos al dataset
        for (Map.Entry<String, Double> entry : tiemposAtencion.entrySet()) {
            dataset.addValue(entry.getValue(), "Tiempo de Atención", entry.getKey());
        }

        return dataset;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            GraficoBarras example = new GraficoBarras("Gráfico de Barras Ejemplo");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
