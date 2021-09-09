/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1_p1;

import java.util.LinkedList;

/**
 *
 * @author Bryan Caal
 */
public class Archivo {
        
    String nombre_archivo = "";
    LinkedList<String> variables;
    LinkedList<String> comentarios;
    LinkedList<String> metodos;
    LinkedList<Errores> lista_errores;
    
    public Archivo(String nombre_archivo, LinkedList<String> variables, LinkedList<String> comentarios, LinkedList<Errores> lista_errores,LinkedList<String> metodos){
        this.nombre_archivo = nombre_archivo;
        this.variables = variables;
        this.comentarios = comentarios;
        this.lista_errores = lista_errores;
        this.metodos = metodos;
    }
    
    public String getNombreArchivo(){
        return this.nombre_archivo;
    }
    
    public LinkedList<String> getListaVariables(){
        return this.variables;
    }
    
    public LinkedList<String> getListaComentarios(){
        return this.comentarios;
    }
    
    public LinkedList<String> getMetodos(){
        return this.comentarios;
    }
    
    public LinkedList<Errores> getListaErrores(){
        return this.lista_errores;
    }
    
}
