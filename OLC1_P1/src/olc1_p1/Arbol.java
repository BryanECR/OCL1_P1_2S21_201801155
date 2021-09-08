/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1_p1;


/**
 *
 * @author Bryan Caal
 */
public class Arbol {
    public Nodo raiz;
    
    public Arbol(Nodo raiz){
        this.raiz = raiz;
    }
    
    public String Reporte(){
        String reporte = Reporte(this.raiz, "0"); 
        return reporte;
    }
     
    private String Reporte(Nodo nodo, String i){
        String cadena = "";
        int k=0; 

        for(int j =0 ; j<=nodo.hijos.size()-1; j++){
            cadena= cadena + Reporte(nodo.hijos.get(j), ""+i+k);
            k++;
        }
        
        if( !(nodo.lexema.equals("")) ){
            cadena+="<tr>\n";
            cadena+="<td>"+nodo.token+"</td>\n";
            cadena+="<td>"+nodo.lexema+"</td>\n";
            cadena+="<td>"+nodo.linea+"</td>\n";
            cadena+="<td>"+nodo.column+"</td>\n";
            cadena+="</tr>\n";
        }
        
        return cadena;
    }
}
