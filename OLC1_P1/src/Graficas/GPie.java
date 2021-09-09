/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficas;


import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import olc1_p1.Ventana;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author Bryan Caal
 */
public class GPie {
    
    public LinkedList<Caracteristica> lista_caracteristica;
    String titulo_grafica ;
    public LinkedList<String> ejex = new LinkedList<>();
    public LinkedList<Object> valores = new LinkedList<>();
    
    public GPie(LinkedList<Caracteristica> lista_caracteristica){
        this.lista_caracteristica = lista_caracteristica;
    }
    
    public void valores(){
        for(Caracteristica caract : this.lista_caracteristica){
            
            
            switch(caract.tipo){
                case 0: //titulo  
                    System.out.println("titulo -> " + caract.valor.valor);
                    if(caract.valor.valor instanceof String){
                        titulo_grafica = caract.valor.valor.toString();
                    }
                    
                    break;
                case 1: //ejex
                    System.out.println("ejex -> ");
                    for(Valor val : caract.lista_valores){
                        if(val.tipo == 1 || val.tipo == 2 || val.tipo == 4){ 
                            this.ejex.add(val.valor.toString());
                        }else if(val.tipo == 3){ //id
                            //se recomienda tener una lista de variables donde se guarde su nombre y valor 
                            for(Variables variable: Ventana.variables_FCA){
                                if(variable.getIdentificador().equalsIgnoreCase(val.valor.toString())){
                                    this.ejex.add(variable.getValor().toString());
                                }
                            }
                        }
                        System.out.println("val: " + val.valor);
                    }
                    break;
                case 2: //valores
                    System.out.println("valores -> ");
                    for(Valor val : caract.lista_valores){
                       
                        if(val.tipo == 1 || val.tipo == 2 || val.tipo == 4){ 
                            this.valores.add(val.valor);
                        }else if(val.tipo == 3){ //id
                            //se recomienda tener una lista de variables donde se guarde su nombre y valor 
                            for(Variables variable: Ventana.variables_FCA){
                                if(variable.getIdentificador().equalsIgnoreCase(val.valor.toString())){
                                    this.valores.add(variable.getValor());
                                }
                            }
                        }
                    }
            }            
        }
    }
    
    public void generar_graficaPie(int numero){
        
        /*
            SE PROCEDE A GRAFICAR 
        */
            DefaultPieDataset PieDataset = new DefaultPieDataset(); //se utilizo la libreria jfreechart-1.5.3
            
            //recorro la lista de "ejex" y "valores"
           for(int i=0; i < this.ejex.size(); i++){
               if(this.valores.get(i) instanceof Integer){
                    PieDataset.setValue(this.ejex.get(i), (int)this.valores.get(i) );
                   
               }else if(this.valores.get(i) instanceof Double){
                   PieDataset.setValue(this.ejex.get(i),(double)this.valores.get(i));
               }
           }
            
            JFreeChart chart = ChartFactory.createPieChart(
                titulo_grafica, 
                PieDataset,
                true,  
                false,  
                false      
           );
 
            //GENERAR IMAGEN
            int width = 640;   
            int height = 480;
        
            File PieChart = new File( "PieChart"+Integer.toString(numero)+".jpeg" ); 
            try {
                ChartUtilities.saveChartAsJPEG( PieChart , chart , width , height );    //se utilizo jfreechart-1.0.1
            
            } catch (IOException ex) {
                Logger.getLogger(GPie.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            
    }   
}
