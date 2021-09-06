/*--------------------------------------------------
 ------------  1ra Area: Codigo de Usuario ---------
 ---------------------------------------------------*/

//------> Paquetes,importaciones
package Analizadores;
import java_cup.runtime.*;
import javax.swing.JOptionPane;
import olc1_p1.Ventana;
import olc1_p1.Errores;

/*----------------------------------------------------------
  ------------  2da Area: Opciones y Declaraciones ---------
  ----------------------------------------------------------*/
%%
%{
    //----> Codigo de usuario en sintaxis java
%}

//-------> Directivas
%public 
%class Analizador_lexico_JS
%cupsym Simbolos_JS2
%cup
%char
%column
%full    
%line
%unicode

//------> Expresiones Regulares
numero              = [0-9]+("."[0-9]+)*
cadena              = [\"][^\"\n]+[\"]
caracter            = [\'][^\'\n]+[\']
identificador       = [A-z]+([A-z]+|[0-9]+|"_")*

comentario              = ("/*"+[\s\S]*?"*/")|("/*"+.*"*/")|"//".*?[\r\n][\r\n]*


//------> Estados

%%

/*------------------------------------------------
  ------------  3ra Area: Reglas Lexicas ---------
  ------------------------------------------------*/

//-----> Simbolos
( "==" | "!=" | "<" | ">" | "<=" | ">=" )         { System.out.println("Reconocio "+yytext()+" Op_rel"); return new Symbol(Simbolos_JS2.Op_rel, yycolumn, yyline, yytext()); }
( "&&" | "||" | "!" )                             { System.out.println("Reconocio "+yytext()+" Op_log"); return new Symbol(Simbolos_JS2.Op_log, yycolumn, yyline, yytext()); }
( "+" | "-" | "*" | "/" | "**" | "%" )            { System.out.println("Reconocio "+yytext()+" Op_ari"); return new Symbol(Simbolos_JS2.Op_ari, yycolumn, yyline, yytext()); }
":"     { System.out.println("Reconocio "+yytext()+" dop"); return new Symbol(Simbolos_JS2.dop, yycolumn, yyline, yytext()); }
";"     { System.out.println("Reconocio "+yytext()+" pyc"); return new Symbol(Simbolos_JS2.pyc, yycolumn, yyline, yytext()); }
"("     { System.out.println("Reconocio "+yytext()+" para"); return new Symbol(Simbolos_JS2.para, yycolumn, yyline, yytext()); }
")"     { System.out.println("Reconocio "+yytext()+" parc"); return new Symbol(Simbolos_JS2.parc, yycolumn, yyline, yytext()); }
"{"     { System.out.println("Reconocio "+yytext()+" lla"); return new Symbol(Simbolos_JS2.lla, yycolumn, yyline, yytext()); }
"}"     { System.out.println("Reconocio "+yytext()+" llc"); return new Symbol(Simbolos_JS2.llc, yycolumn, yyline, yytext()); }
"="     { System.out.println("Reconocio "+yytext()+" igual"); return new Symbol(Simbolos_JS2.igual, yycolumn, yyline, yytext()); }
"."     { System.out.println("Reconocio "+yytext()+" punto"); return new Symbol(Simbolos_JS2.punto, yycolumn, yyline, yytext()); }
","     { System.out.println("Reconocio "+yytext()+" coma"); return new Symbol(Simbolos_JS2.coma, yycolumn, yyline, yytext()); }



//-----> Palabras reservadas
( "var" | "let" |"const" )   { System.out.println("Reconocio "+yytext()+" variable"); return new Symbol(Simbolos_JS2.variable, yycolumn, yyline, yytext()); }
"if"        { System.out.println("Reconocio "+yytext()+" If"); return new Symbol(Simbolos_JS2.If, yycolumn, yyline, yytext()); }
"else"      { System.out.println("Reconocio "+yytext()+" Else"); return new Symbol(Simbolos_JS2.Else, yycolumn, yyline, yytext()); }
"for"       { System.out.println("Reconocio "+yytext()+" For"); return new Symbol(Simbolos_JS2.For, yycolumn, yyline, yytext()); }
"while"     { System.out.println("Reconocio "+yytext()+" While"); return new Symbol(Simbolos_JS2.While, yycolumn, yyline, yytext()); }
"do"        { System.out.println("Reconocio "+yytext()+" Do"); return new Symbol(Simbolos_JS2.Do, yycolumn, yyline, yytext()); }
"switch"    { System.out.println("Reconocio "+yytext()+" Switch"); return new Symbol(Simbolos_JS2.Switch, yycolumn, yyline, yytext()); }
"require"   { System.out.println("Reconocio "+yytext()+" Require"); return new Symbol(Simbolos_JS2.Require, yycolumn, yyline, yytext()); }
"class"     { System.out.println("Reconocio "+yytext()+" ClassJS"); return new Symbol(Simbolos_JS2.ClassJS, yycolumn, yyline, yytext()); }
"case"      { System.out.println("Reconocio "+yytext()+" Case"); return new Symbol(Simbolos_JS2.Case, yycolumn, yyline, yytext()); }
"break"     { System.out.println("Reconocio "+yytext()+" Break"); return new Symbol(Simbolos_JS2.Break, yycolumn, yyline, yytext()); }
"default"   { System.out.println("Reconocio "+yytext()+" Default"); return new Symbol(Simbolos_JS2.Default, yycolumn, yyline, yytext()); }
"console"   { System.out.println("Reconocio "+yytext()+" Console"); return new Symbol(Simbolos_JS2.Console, yycolumn, yyline, yytext()); }
"log"       { System.out.println("Reconocio "+yytext()+" Log"); return new Symbol(Simbolos_JS2.Log, yycolumn, yyline, yytext()); }

//-------> Simbolos ER
{numero}                                { System.out.println("Reconocio "+yytext()+" numero"); return new Symbol(Simbolos_JS2.numero, yycolumn, yyline, yytext()); }
{cadena}                                { System.out.println("Reconocio "+yytext()+" cadena"); return new Symbol(Simbolos_JS2.cadena, yycolumn, yyline, yytext()); }
{caracter}                              { System.out.println("Reconocio "+yytext()+" caracter"); return new Symbol(Simbolos_JS2.caracter, yycolumn, yyline, yytext()); }
{identificador}                         { System.out.println("Reconocio "+yytext()+" identificador"); return new Symbol(Simbolos_JS2.identificador, yycolumn, yyline, yytext()); }


//------> Espacios
{comentario}         { System.out.println("Comentario: "+yytext());
                        Ventana.lista_comentarios.add(yytext());
                     }
[ \t\r\n\f]                {/* Espacios en blanco, se ignoran */}

//-------> Errores Lexicos 
.           {System.out.println("Error Lexico " + yytext() + "Linea: " + yyline + "Columna: " + yycolumn);
             Errores nuevo_error = new Errores("Error Lexico", yytext(), yyline, yycolumn);
             Ventana.lista_errores.add(nuevo_error);
            }




