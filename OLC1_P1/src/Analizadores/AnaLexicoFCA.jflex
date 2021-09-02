/*--------------------------------------------------
 ------------  1ra Area: Codigo de Usuario ---------
 ---------------------------------------------------*/

//------> Paquetes,importaciones
package Analizadores;
import java_cup.runtime.*;
import javax.swing.JOptionPane;

/*----------------------------------------------------------
  ------------  2da Area: Opciones y Declaraciones ---------
  ----------------------------------------------------------*/
%%
%{
    //----> Codigo de usuario en sintaxis java
%}

//-------> Directivas
%public 
%class Analizador_lexicoFCA
%cupsym SimbolosFCA
%cup
%char
%column
%full
%ignorecase     
%line
%unicode

//------> Expresiones Regulares
decimal             = [0-9]+("."?[0-9]?[0-9]?)
cadena              = [\"][^\"\n]+[\"]
identificador       = [A-z]([A-z]|[0-9]|\_)*

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
comentariosimple    = "##" {InputCharacter}* {LineTerminator}?

//------> Estados

%%

/*------------------------------------------------
  ------------  3ra Area: Reglas Lexicas ---------
  ------------------------------------------------*/

//-----> Simbolos
";"          { System.out.println("Reconocio "+yytext()+" pyc"); return new Symbol(SimbolosFCA.pyc, yycolumn, yyline, yytext()); }
":"          { System.out.println("Reconocio "+yytext()+" dop"); return new Symbol(SimbolosFCA.dop, yycolumn, yyline, yytext()); }
"{"          { System.out.println("Reconocio "+yytext()+" lla"); return new Symbol(SimbolosFCA.lla, yycolumn, yyline, yytext()); }
"}"          { System.out.println("Reconocio "+yytext()+" llc"); return new Symbol(SimbolosFCA.llc, yycolumn, yyline, yytext()); }
","          { System.out.println("Reconocio "+yytext()+" coma"); return new Symbol(SimbolosFCA.coma, yycolumn, yyline, yytext()); }
"("          { System.out.println("Reconocio "+yytext()+" para"); return new Symbol(SimbolosFCA.para, yycolumn, yyline, yytext()); }
")"          { System.out.println("Reconocio "+yytext()+" parc"); return new Symbol(SimbolosFCA.parc, yycolumn, yyline, yytext()); }
"="          { System.out.println("Reconocio "+yytext()+" igual"); return new Symbol(SimbolosFCA.igual, yycolumn, yyline, yytext()); }


//-----> Palabras reservadas
"string"  { System.out.println("Reconocio "+yytext()+" string"); return new Symbol(SimbolosFCA.string, yycolumn, yyline, yytext()); }
"titulo"  { System.out.println("Reconocio "+yytext()+" titulo"); return new Symbol(SimbolosFCA.titulo, yycolumn, yyline, yytext()); }
"titulox" { System.out.println("Reconocio "+yytext()+" titulox"); return new Symbol(SimbolosFCA.titulox, yycolumn, yyline, yytext()); }
"tituloy" { System.out.println("Reconocio "+yytext()+" tituloy"); return new Symbol(SimbolosFCA.tituloy, yycolumn, yyline, yytext()); }
"archivo" { System.out.println("Reconocio "+yytext()+" archivo"); return new Symbol(SimbolosFCA.archivo, yycolumn, yyline, yytext()); }
"compare" { System.out.println("Reconocio "+yytext()+" compare"); return new Symbol(SimbolosFCA.compare, yycolumn, yyline, yytext()); }
"double"  { System.out.println("Reconocio "+yytext()+" doubleFCA"); return new Symbol(SimbolosFCA.doubleFCA, yycolumn, yyline, yytext()); }
"GenerarReporteEstadistico"                             { System.out.println("Reconocio "+yytext()+" mein"); return new Symbol(SimbolosFCA.mein, yycolumn, yyline, yytext()); }
"DefinirGlobales"                                       { System.out.println("Reconocio "+yytext()+" globales"); return new Symbol(SimbolosFCA.globales, yycolumn, yyline, yytext()); }
( "GraficaBarras" | "GraficaPie" | "GraficaLineas" )    { System.out.println("Reconocio "+yytext()+" graficas"); return new Symbol(SimbolosFCA.graficas, yycolumn, yyline, yytext()); }


//-------> Simbolos ER
{decimal}                               { System.out.println("Reconocio "+yytext()+" decimal"); return new Symbol(SimbolosFCA.decimal, yycolumn, yyline, yytext()); }
{cadena}                                { System.out.println("Reconocio "+yytext()+" cadena"); return new Symbol(SimbolosFCA.cadena, yycolumn, yyline, yytext()); }
{identificador}                         { System.out.println("Reconocio "+yytext()+" identificador"); return new Symbol(SimbolosFCA.identificador, yycolumn, yyline, yytext()); }


//------> Espacios
{comentariosimple}      {System.out.println("Comentario: "+yytext()); }
[ \t\r\n\f]             {/* Espacios en blanco, se ignoran */}

//-------> Errores Lexicos 
.           {System.out.println("Error Lexico " + yytext() + "Linea: " + yyline + "Columna: " + yycolumn); }



