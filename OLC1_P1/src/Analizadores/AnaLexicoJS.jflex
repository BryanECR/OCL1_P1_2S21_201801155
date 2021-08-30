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
%class Analizador_lexico_JS
%cupsym Simbolos_JS
%cup
%char
%column
%full    
%line
%unicode

//------> Expresiones Regulares
numero              = [0-9]+("."[0-9])*
cadena              = [\"][^\"\n]+[\"]
identificador       = [A-z]+([A-z]|[0-9]|"_")*

//------> Estados

%%

/*------------------------------------------------
  ------------  3ra Area: Reglas Lexicas ---------
  ------------------------------------------------*/

//-----> Simbolos
( "==" | "!=" | "<" | ">" | "<=" | ">=" )         { System.out.println("Reconocio "+yytext()+" Op_rel"); return new Symbol(Simbolos_JS.Op_rel, yycolumn, yyline, yytext()); }
( "&&" | "||" | "!" )                             { System.out.println("Reconocio "+yytext()+" Op_log"); return new Symbol(Simbolos_JS.Op_log, yycolumn, yyline, yytext()); }
( "+" | "-" | "*" | "/" | "**" | "%" )            { System.out.println("Reconocio "+yytext()+" Op_ari"); return new Symbol(Simbolos_JS.Op_ari, yycolumn, yyline, yytext()); }
":"     { System.out.println("Reconocio "+yytext()+" dop"); return new Symbol(Simbolos_JS.dop, yycolumn, yyline, yytext()); }
";"     { System.out.println("Reconocio "+yytext()+" pyc"); return new Symbol(Simbolos_JS.pyc, yycolumn, yyline, yytext()); }
"("     { System.out.println("Reconocio "+yytext()+" para"); return new Symbol(Simbolos_JS.para, yycolumn, yyline, yytext()); }
")"     { System.out.println("Reconocio "+yytext()+" parc"); return new Symbol(Simbolos_JS.parc, yycolumn, yyline, yytext()); }
"{"     { System.out.println("Reconocio "+yytext()+" lla"); return new Symbol(Simbolos_JS.lla, yycolumn, yyline, yytext()); }
"}"     { System.out.println("Reconocio "+yytext()+" llc"); return new Symbol(Simbolos_JS.llc, yycolumn, yyline, yytext()); }
"="     { System.out.println("Reconocio "+yytext()+" igual"); return new Symbol(Simbolos_JS.igual, yycolumn, yyline, yytext()); }
"."     { System.out.println("Reconocio "+yytext()+" punto"); return new Symbol(Simbolos_JS.punto, yycolumn, yyline, yytext()); }



//-----> Palabras reservadas
( "var" | "let" |"const" )   { System.out.println("Reconocio "+yytext()+" variable"); return new Symbol(Simbolos_JS.variable, yycolumn, yyline, yytext()); }
"if"        { System.out.println("Reconocio "+yytext()+" If"); return new Symbol(Simbolos_JS.If, yycolumn, yyline, yytext()); }
"else"      { System.out.println("Reconocio "+yytext()+" Else"); return new Symbol(Simbolos_JS.Else, yycolumn, yyline, yytext()); }
"for"       { System.out.println("Reconocio "+yytext()+" For"); return new Symbol(Simbolos_JS.For, yycolumn, yyline, yytext()); }
"while"     { System.out.println("Reconocio "+yytext()+" While"); return new Symbol(Simbolos_JS.While, yycolumn, yyline, yytext()); }
"do"        { System.out.println("Reconocio "+yytext()+" Do"); return new Symbol(Simbolos_JS.Do, yycolumn, yyline, yytext()); }
"switch"    { System.out.println("Reconocio "+yytext()+" Switch"); return new Symbol(Simbolos_JS.Switch, yycolumn, yyline, yytext()); }
"require"   { System.out.println("Reconocio "+yytext()+" Require"); return new Symbol(Simbolos_JS.Require, yycolumn, yyline, yytext()); }
"class"     { System.out.println("Reconocio "+yytext()+" ClassJS"); return new Symbol(Simbolos_JS.ClassJS, yycolumn, yyline, yytext()); }
"case"     { System.out.println("Reconocio "+yytext()+" Case"); return new Symbol(Simbolos_JS.Case, yycolumn, yyline, yytext()); }
"break"     { System.out.println("Reconocio "+yytext()+" Break"); return new Symbol(Simbolos_JS.Break, yycolumn, yyline, yytext()); }

//-------> Simbolos ER
{numero}                                { System.out.println("Reconocio "+yytext()+" numero"); return new Symbol(Simbolos_JS.numero, yycolumn, yyline, yytext()); }
{cadena}                                { System.out.println("Reconocio "+yytext()+" cadena"); return new Symbol(Simbolos_JS.cadena, yycolumn, yyline, yytext()); }
{identificador}                         { System.out.println("Reconocio "+yytext()+" identificador"); return new Symbol(Simbolos_JS.identificador, yycolumn, yyline, yytext()); }


//------> Espacios
[ \t\r\n\f]             {/* Espacios en blanco, se ignoran */}

//-------> Errores Lexicos 
.           {System.out.println("Error Lexico " + yytext() + "Linea: " + yyline + "Columna: " + yycolumn); }




