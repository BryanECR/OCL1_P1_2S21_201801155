/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficas;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Bryan Caal
 */
public class GLineas {
    
        public void GLineas(int varA, int comA,int metA,int varB, int comB,int metB){
        
        /*
            SE PROCEDE A GRAFICAR 
        */
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(varA, "Proyecto A", "Variables");
            dataset.addValue(comA, "Proyecto A", "Comentarios");
            dataset.addValue(metA, "Proyecto A", "Metodos");
            dataset.addValue(varB, "Proyecto B", "Variables");
            dataset.addValue(comB, "Proyecto B", "Comentarios");
            dataset.addValue(metB, "Proyecto B", "Metodos");

            JFreeChart linChart = ChartFactory.createLineChart(
                "Resumen",
                "Elementos Buscados", 
                "Cantidad",
                dataset, 
                PlotOrientation.VERTICAL, 
                true, 
                true, 
                false
            );
                     
           
            //GENERAR IMAGEN
            int width = 640;   
            int height = 480;
        
            File lineChart = new File( "LineChart.jpeg" ); 
            try {
                ChartUtilities.saveChartAsJPEG( lineChart , linChart , width , height );
            
            } catch (IOException ex) {
                Logger.getLogger(GLineas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
    }
    
}
