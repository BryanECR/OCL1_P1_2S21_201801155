/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1_p1;


import Analizadores.Analizador_lexicoFCA;
import Analizadores.Analizador_lexico_JS;
import Analizadores.SintacticoFCA;
import Analizadores.SintacticoJS2;
import Graficas.GBarras;
import Graficas.GPie;
import Graficas.Puntajes;
import Graficas.Variables;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan Caal
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
    }

    LinkedList<String> variables = new LinkedList<String>();
    public static  LinkedList<Archivo> datos_archivos = new LinkedList<>();
    static LinkedList<Object> instrucciones = new LinkedList<Object>();
    public static LinkedList<Errores> lista_errores = new LinkedList<>();
    public static LinkedList<String> lista_comentarios = new LinkedList<>();
    
    public int cont_variables_repetidas = 0;
    public int cont_comment_repetido = 0;
    
    public static LinkedList<Variables> variables_FCA = new LinkedList<>();
    public static LinkedList<Puntajes> lista_puntajesEspecificos = new LinkedList<>();
    
    /**
     * Metodo para recorrer el arbol sintactico generado con el archivo .js
     * @param nodo recibe el nodo padre a recorrer 
     * @param variables recibe la lista de variables 
     */
    public void analizar_entrada(Nodo nodo, LinkedList<String> variables){
        
        for(Nodo instruccion : nodo.hijos){
            //Si encuentra un nodo tipo declaracion guardo el id en la lista de variables 
            if(instruccion.token == "DECLARACION"){
                for(Nodo decla : instruccion.hijos){
                    if(decla.token == "identificador"){
                        variables.add(decla.lexema);
                    }
                } 
            }
            
            if(instruccion.lexema == ""){
                analizar_entrada(instruccion, variables);
            }
        }
    }
  

    
    
    /**
     * Metodo para verificar los archivos dentro de una carpeta 
     * @param ruta_proy1 indica la ruta donde se encuentra la carpeta del proyecto 1
     * @param ruta_proy2 indica la ruta donde se encuentra la carpeta del proyecto 2
     */
    public void archivos_carpetas(String ruta_proy1, String ruta_proy2){
        
        try{
            DirectoryStream<Path> stream_p1 = Files.newDirectoryStream(Paths.get(ruta_proy1), "*.js");
            
           //Recorremos los archivos del proyecto 1
            for (Path file_p1: stream_p1) {
                DirectoryStream<Path> stream_p2 = Files.newDirectoryStream(Paths.get(ruta_proy2), "*.js");
                
                String nombre_archivo1 = file_p1.getFileName().toString(); 
                File archivo = new File (file_p1.toString());
                FileReader fr = new FileReader (archivo);
                Archivo nuevo_archivo1 = null;
                Archivo nuevo_archivo2 = null;
                //Vamos a comparar el archivo del proyecto1 con los archivos de la carpeta2 para saber si se llaman igual 
                for(Path file_p2 : stream_p2){
                    String nombre_archivo2 = file_p2.getFileName().toString();
                    File archivo2 = new File (file_p2.toString());
                    FileReader fr2 = new FileReader (archivo2);
                    //Si se llaman igual se comienza el proceso para analizar copias
                    if(nombre_archivo1.equals(nombre_archivo2)){
                        System.out.println("Los nombres son iguales, vamos a comparar --> " + file_p1.getFileName());
                        //--> 1ero vamos a analizar el archivo1 del proyecto 1
                        try{
                            
                            System.out.println("----------- " + nombre_archivo1 + " en PROYECTO 1 ----------- ");
                            Nodo raiz = null;
                            //Mandamos a analizar el archivo del proyecto 1 
                            SintacticoJS2 parse = new SintacticoJS2(new Analizador_lexico_JS(new BufferedReader(fr)));
                            parse.parse();

                            raiz = parse.getRaiz();
                            if(raiz == null){
                                System.out.println("No se genero bien el arbol");
                            }else{
                                
                                nuevo_archivo1 = new Archivo(nombre_archivo1, new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
                                //--> vamos a guardar las variables encontradas en el archivo
                                analizar_entrada(raiz,nuevo_archivo1.variables ); 
                                //-->agregamos los comentarios encontrados (la lista se lleno en el archivo Analizador_Lexico_JS.jflex)
                                for(String comment : lista_comentarios){
                                    nuevo_archivo1.comentarios.add(comment);
                                }
                                //-->agregamos los errores encontrados (la lista se lleno en los archivos A_Lexico_FCA.jflex y A_sintacticos_FCA.cup)
                                for(Errores error : lista_errores){
                                    //--> guardamos los errore indicando el nombre del archivo
                                    Errores nuevo_error = new Errores(error.tipo, error.valor, nuevo_archivo1.nombre_archivo, error.fila, error.columna);
                                    nuevo_archivo1.lista_errores.add(nuevo_error);
                                }

                                
                                //-->guardamos el archivo en una lista
                                this.datos_archivos.add(nuevo_archivo1);
                                //-->limpiamos variables
                                lista_errores.clear();
                                lista_comentarios.clear();
                                
                            }
                        }catch(Exception ex){
                            System.out.println("Error en analizar el archivo del proyecto.");
                            System.out.println("Causa: "+ex.getCause());
                        }
                        //--> 2do vamos a analizar el archivo2
                        try{
                            
                            System.out.println("----------- " + nombre_archivo2 + " en PROYECTO 2----------- ");
                            Nodo raiz = null;
                            //Mandamos a analizar el archivo del proyecto 2
                            SintacticoJS2 parse = new SintacticoJS2(new Analizador_lexico_JS(new BufferedReader(fr2)));
                            parse.parse();

                            raiz = parse.getRaiz();
                            if(raiz == null){
                                System.out.println("No se genero bien el arbol");
                            }else{
                                
                                nuevo_archivo2 = new Archivo(nombre_archivo2, new LinkedList<>(), new LinkedList<>(),new LinkedList<>());
                                //--> vamos a guardar las variables encontradas en el archivo
                                analizar_entrada(raiz, nuevo_archivo2.variables); 
                                //-->agregamos los comentarios encontrados (la lista se lleno en el archivo A_Lexico_FCA.jflex)
                                for(String comment : lista_comentarios){
                                    nuevo_archivo2.comentarios.add(comment);
                                }
                                //-->agregamos los errores encontrados (la lista se lleno en los archivos A_Lexico_FCA.jflex y A_sintacticos_FCA.cup)
                                for(Errores error : lista_errores){
                                    //--> guardamos los errore indicando el nombre del archivo
                                    Errores nuevo_error = new Errores(error.tipo, error.valor, nuevo_archivo2.nombre_archivo, error.fila, error.columna);
                                    nuevo_archivo2.lista_errores.add(nuevo_error);
                                }

                                //-->guardamos el archivo en una lista
                                this.datos_archivos.add(nuevo_archivo2);
                                //-->limpiamos variables
                                lista_errores.clear();
                                lista_comentarios.clear();
                                
                            }
                        }catch(Exception ex){
                            System.out.println("Error en analizar el archivo del proyecto.");
                            System.out.println("Causa: "+ex.getCause());
                        }
                        
                        //--> detectamos copias entre estos dos archivos 
                        if(nuevo_archivo1 != null && nuevo_archivo2 != null){
                            variables_repetidas(nuevo_archivo1, nuevo_archivo2);
                            comentarios_repetidos(nuevo_archivo1, nuevo_archivo2);
                        }
                    }
                }
            }
        } catch (IOException | DirectoryIteratorException ex) {
		    System.err.println(ex);
		}
    }
    

     /**
     * Metodo para verificar las variables repetidas en ambos archivos
     * @param archivo1 recibe el archivo del proyecto 1 con toda su informacion
     * @param archivo2 recibe el archivo del proyecto 2 con toda su informacion
     */
    public void variables_repetidas(Archivo archivo1, Archivo archivo2){
        //dar el punteo. 
        for(String id_variable_arch1 : archivo1.variables){
            for(String id_variable_arch2 : archivo2.variables){
                if(id_variable_arch1.equals(id_variable_arch2)){
                    TextAreaConsola.append("Variable repetida \"" + id_variable_arch1 +"\" en archivos " + archivo1.nombre_archivo + "\n");
                    this.cont_variables_repetidas++;
                }
            }
        }
    }

    
    /**
     * Metodo para verificar los comentarios repetidos en ambos archivos
     * @param archivo1 recibe el archivo del proyecto 1 con toda su informacion
     * @param archivo2 recibe el archivo del proyecto 2 con toda su informacion
     */
    public void comentarios_repetidos(Archivo archivo1, Archivo archivo2){
        for(String comment : archivo1.comentarios){
            for(String comment2 : archivo2.comentarios){
                if(comment.equalsIgnoreCase(comment2)){
                    TextAreaConsola.append("Comentario repetido \"" + comment +"\" en archivos " + archivo2.nombre_archivo + "\n");
                    this.cont_comment_repetido++;
                }
            }
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaConsola = new javax.swing.JTextArea();
        btnArchivo = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextAreaEditor = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextAreaConsola.setColumns(20);
        TextAreaConsola.setRows(5);
        jScrollPane1.setViewportView(TextAreaConsola);

        btnArchivo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnArchivo.setText("Archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        btnEjecutar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        btnReportes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnReportes.setText("Reportes");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("OLC1 Proyecto 1");

        TextAreaEditor.setColumns(20);
        TextAreaEditor.setRows(5);
        jScrollPane2.setViewportView(TextAreaEditor);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Editor");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Consola");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnArchivo)
                        .addGap(54, 54, 54)
                        .addComponent(btnEjecutar)
                        .addGap(58, 58, 58)
                        .addComponent(btnReportes)
                        .addGap(73, 73, 73))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(261, 261, 261))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReportes)
                        .addComponent(btnEjecutar)
                        .addComponent(btnArchivo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        // TODO add your handling code here:
        Nodo raiz = null;
        
        try {   
            //se ejecuta el lexico y sintactico para analizar el archivo FCA 
            SintacticoFCA sintactico_fca =new SintacticoFCA(new Analizador_lexicoFCA(new BufferedReader( new StringReader(TextAreaEditor.getText()))));
            sintactico_fca.parse();
            instrucciones = sintactico_fca.instrucciones;
            
            //Recorre las instrucciones encontradas en el archivo FCA
            //--> ejecutamos primero el comando comparar 
            for(Object ins : instrucciones){
                if(ins instanceof Comparar){
                    Comparar comp = (Comparar)ins;
                    archivos_carpetas(comp.getRuta1(), comp.getRuta2());
                }
            }
        
        } catch (Exception ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        JFileChooser fc = new JFileChooser();
        
        int seleccion = fc.showOpenDialog(this);
        
        if(seleccion == JFileChooser.APPROVE_OPTION){
            
            File fichero = fc.getSelectedFile();
            
            try(FileReader fr = new FileReader(fichero)){
                String cadena = "";
                int valor = fr.read();
                while(valor != -1){
                    cadena = cadena +(char) valor;
                    valor = fr.read();
                }
                this.TextAreaEditor.setText(cadena);
            } catch (IOException el){
                el.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnArchivoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TextAreaConsola;
    private javax.swing.JTextArea TextAreaEditor;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
