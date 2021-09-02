/* The following code was generated by JFlex 1.6.1 */

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

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/Analizadores/AnaLexicoFCA.jflex</tt>
 */
public class Analizador_lexicoFCA implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0, 39,  4, 40, 39,  6,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    39,  0,  3,  7,  0,  0,  0,  0, 13, 14,  0,  0, 12,  0,  2,  0, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  9,  8,  0, 15,  0,  0, 
     0, 29, 37, 30, 36, 35, 38, 23, 31, 21,  5,  5, 25, 33, 22, 26, 
    34,  5, 19, 17, 18, 24, 32,  5, 27, 28,  5,  5,  5,  5,  5,  5, 
     5, 29, 37, 30, 36, 35, 38, 23, 31, 21,  5,  5, 25, 33, 22, 26, 
    34,  5, 19, 17, 18, 24, 32,  5, 27, 28,  5, 10,  0, 11,  0,  0, 
     0,  0,  0,  0,  0, 40,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\1\1\3\1\4\1\1\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\1"+
    "\6\4\1\2\1\0\1\15\1\0\1\4\1\0\7\4"+
    "\1\2\1\16\2\15\1\0\1\4\1\0\7\4\1\2"+
    "\1\0\1\4\1\0\6\4\1\0\1\4\1\0\1\4"+
    "\1\0\1\4\1\0\2\4\1\0\3\4\1\0\1\4"+
    "\2\17\2\20\1\0\2\4\1\0\2\4\1\21\1\0"+
    "\1\4\1\22\1\23\1\22\1\23\1\0\2\4\2\24"+
    "\1\25\1\0\1\4\3\0\4\4\1\0\1\4\3\0"+
    "\4\4\1\0\1\4\1\0\1\26\1\0\1\4\1\26"+
    "\2\4\1\0\1\4\1\0\2\4\1\0\1\4\1\0"+
    "\2\4\1\0\2\4\1\0\2\4\1\0\2\4\2\27"+
    "\1\0\1\4\1\0\1\4\1\0\1\4\1\0\1\4"+
    "\1\0\1\4\1\0\1\4\1\0\1\4\1\0\1\4"+
    "\1\0\1\4\2\30";

  private static int [] zzUnpackAction() {
    int [] result = new int[165];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\51\0\122\0\173\0\51\0\244\0\315\0\51"+
    "\0\51\0\51\0\51\0\51\0\51\0\51\0\51\0\366"+
    "\0\u011f\0\u0148\0\u0171\0\u019a\0\u01c3\0\u01ec\0\u0215\0\u023e"+
    "\0\u0267\0\u0290\0\u02b9\0\u02e2\0\u030b\0\u0334\0\u035d\0\u0386"+
    "\0\u03af\0\u03d8\0\u0401\0\u042a\0\51\0\51\0\u0453\0\u047c"+
    "\0\u04a5\0\u04ce\0\u04f7\0\u0520\0\u0549\0\u0572\0\u059b\0\u05c4"+
    "\0\u05ed\0\51\0\u0616\0\u063f\0\u0668\0\u0691\0\u06ba\0\u06e3"+
    "\0\u070c\0\u0735\0\u075e\0\u0787\0\u07b0\0\u07d9\0\u0802\0\u082b"+
    "\0\u0854\0\u087d\0\u08a6\0\u08cf\0\u08f8\0\u0921\0\u094a\0\u0973"+
    "\0\u099c\0\u09c5\0\51\0\244\0\u09ee\0\u0a17\0\u0a40\0\u0a69"+
    "\0\u0a92\0\u0abb\0\u0ae4\0\u0b0d\0\244\0\u0b36\0\u0b5f\0\51"+
    "\0\51\0\244\0\244\0\u0b88\0\u0bb1\0\u0bda\0\51\0\244"+
    "\0\244\0\u0c03\0\u0c2c\0\u0c55\0\u0c7e\0\u0ca7\0\u0cd0\0\u0cf9"+
    "\0\u0d22\0\u0d4b\0\u0d74\0\u0d9d\0\u0dc6\0\u0def\0\u0e18\0\u0e41"+
    "\0\u0e6a\0\u0e93\0\u0ebc\0\u0ee5\0\u0f0e\0\u0f37\0\51\0\u0f60"+
    "\0\u0f89\0\244\0\u0fb2\0\u0fdb\0\u1004\0\u102d\0\u1056\0\u107f"+
    "\0\u10a8\0\u10d1\0\u10fa\0\u1123\0\u114c\0\u1175\0\u119e\0\u11c7"+
    "\0\u11f0\0\u1219\0\u1242\0\u126b\0\u1294\0\u12bd\0\u12e6\0\51"+
    "\0\244\0\u130f\0\u1338\0\u1361\0\u138a\0\u13b3\0\u13dc\0\u1405"+
    "\0\u142e\0\u1457\0\u1480\0\u14a9\0\u14d2\0\u14fb\0\u1524\0\u154d"+
    "\0\u1576\0\u159f\0\u15c8\0\51\0\244";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[165];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\2\1\4\1\5\1\6\1\5\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\6\1\2\2\6\1\23\5\6"+
    "\1\24\1\25\5\6\1\26\2\6\1\5\53\0\1\3"+
    "\1\27\46\0\3\30\2\0\44\30\1\0\1\6\3\0"+
    "\1\6\13\0\3\6\1\0\22\6\11\0\1\31\63\0"+
    "\1\32\27\0\1\6\3\0\1\6\13\0\1\6\1\33"+
    "\1\6\1\0\22\6\3\0\1\6\3\0\1\6\13\0"+
    "\3\6\1\34\1\35\21\6\3\0\1\6\3\0\1\6"+
    "\13\0\2\6\1\36\1\0\16\6\1\37\3\6\3\0"+
    "\1\6\3\0\1\6\13\0\2\6\1\40\1\0\22\6"+
    "\3\0\1\6\3\0\1\6\13\0\3\6\1\0\5\6"+
    "\1\41\14\6\3\0\1\6\3\0\1\6\13\0\3\6"+
    "\1\0\5\6\1\42\10\6\1\43\3\6\3\0\1\44"+
    "\47\0\3\30\1\45\1\0\44\30\4\31\1\46\1\31"+
    "\1\47\42\31\23\0\1\50\26\0\1\6\3\0\1\6"+
    "\13\0\2\6\1\51\1\0\22\6\24\0\1\52\27\0"+
    "\1\6\3\0\1\6\13\0\1\6\1\53\1\6\1\0"+
    "\22\6\3\0\1\6\3\0\1\6\13\0\3\6\1\0"+
    "\10\6\1\54\11\6\3\0\1\6\3\0\1\6\13\0"+
    "\3\6\1\0\1\6\1\55\20\6\3\0\1\6\3\0"+
    "\1\6\13\0\3\6\1\0\11\6\1\56\10\6\3\0"+
    "\1\6\3\0\1\6\13\0\3\6\1\0\14\6\1\57"+
    "\5\6\3\0\1\6\3\0\1\6\13\0\3\6\1\0"+
    "\3\6\1\60\16\6\3\0\1\6\3\0\1\6\13\0"+
    "\3\6\1\0\21\6\1\61\3\0\1\62\53\0\1\46"+
    "\70\0\2\63\24\0\1\6\3\0\1\6\13\0\3\6"+
    "\1\63\1\64\21\6\32\0\1\65\21\0\1\6\3\0"+
    "\1\6\13\0\3\6\1\0\3\6\1\66\16\6\3\0"+
    "\1\6\3\0\1\6\13\0\3\6\1\0\21\6\1\67"+
    "\3\0\1\6\3\0\1\6\13\0\3\6\1\0\16\6"+
    "\1\70\3\6\3\0\1\6\3\0\1\6\13\0\3\6"+
    "\1\0\12\6\1\71\7\6\3\0\1\6\3\0\1\6"+
    "\13\0\3\6\1\0\15\6\1\72\4\6\3\0\1\6"+
    "\3\0\1\6\13\0\3\6\1\0\20\6\1\73\1\6"+
    "\3\0\1\6\3\0\1\6\13\0\3\6\1\74\1\75"+
    "\21\6\30\0\1\76\23\0\1\6\3\0\1\6\13\0"+
    "\3\6\1\0\1\6\1\77\20\6\33\0\1\100\20\0"+
    "\1\6\3\0\1\6\13\0\3\6\1\0\4\6\1\101"+
    "\15\6\3\0\1\6\3\0\1\6\13\0\3\6\1\102"+
    "\1\103\21\6\3\0\1\6\3\0\1\6\13\0\2\6"+
    "\1\104\1\0\22\6\3\0\1\6\3\0\1\6\13\0"+
    "\3\6\1\105\1\106\21\6\3\0\1\6\3\0\1\6"+
    "\13\0\3\6\1\0\10\6\1\107\11\6\3\0\1\6"+
    "\3\0\1\6\13\0\3\6\1\0\4\6\1\110\15\6"+
    "\30\0\1\111\23\0\1\6\3\0\1\6\13\0\3\6"+
    "\1\0\1\6\1\112\20\6\31\0\1\113\22\0\1\6"+
    "\3\0\1\6\13\0\3\6\1\0\2\6\1\114\17\6"+
    "\34\0\1\115\17\0\1\6\3\0\1\6\13\0\3\6"+
    "\1\0\5\6\1\116\14\6\40\0\1\117\13\0\1\6"+
    "\3\0\1\6\13\0\3\6\1\0\11\6\1\120\10\6"+
    "\3\0\1\6\3\0\1\6\13\0\3\6\1\0\10\6"+
    "\1\121\11\6\42\0\1\122\11\0\1\6\3\0\1\6"+
    "\13\0\3\6\1\0\13\6\1\123\6\6\3\0\1\6"+
    "\3\0\1\6\13\0\2\6\1\124\1\0\22\6\3\0"+
    "\1\6\3\0\1\6\13\0\3\6\1\0\16\6\1\125"+
    "\3\6\26\0\2\126\24\0\1\6\3\0\1\6\13\0"+
    "\3\6\1\126\1\127\21\6\35\0\1\130\1\131\15\0"+
    "\1\6\3\0\1\6\13\0\3\6\1\0\6\6\1\132"+
    "\1\133\12\6\37\0\1\134\14\0\1\6\3\0\1\6"+
    "\13\0\3\6\1\0\10\6\1\135\11\6\3\0\1\6"+
    "\3\0\1\6\13\0\2\6\1\136\1\0\22\6\34\0"+
    "\1\137\17\0\1\6\3\0\1\6\13\0\3\6\1\0"+
    "\5\6\1\140\14\6\3\0\1\6\3\0\1\6\13\0"+
    "\3\6\1\0\16\6\1\141\3\6\25\0\1\142\26\0"+
    "\1\6\3\0\1\6\13\0\2\6\1\143\1\0\22\6"+
    "\33\0\1\144\10\0\1\145\2\0\1\146\4\0\1\6"+
    "\3\0\1\6\13\0\3\6\1\0\4\6\1\147\10\6"+
    "\1\150\2\6\1\151\1\6\3\0\1\6\3\0\1\6"+
    "\13\0\2\6\1\152\1\0\22\6\31\0\1\153\22\0"+
    "\1\6\3\0\1\6\13\0\3\6\1\0\2\6\1\154"+
    "\17\6\26\0\2\155\47\0\2\156\60\0\1\157\14\0"+
    "\1\6\3\0\1\6\13\0\3\6\1\155\1\160\21\6"+
    "\3\0\1\6\3\0\1\6\13\0\3\6\1\156\1\161"+
    "\21\6\3\0\1\6\3\0\1\6\13\0\3\6\1\0"+
    "\10\6\1\162\11\6\3\0\1\6\3\0\1\6\13\0"+
    "\3\6\1\0\16\6\1\163\3\6\33\0\1\164\20\0"+
    "\1\6\3\0\1\6\13\0\3\6\1\0\4\6\1\165"+
    "\15\6\30\0\1\166\65\0\1\167\30\0\1\170\26\0"+
    "\1\6\3\0\1\6\13\0\3\6\1\0\1\6\1\171"+
    "\20\6\3\0\1\6\3\0\1\6\13\0\3\6\1\0"+
    "\16\6\1\172\3\6\3\0\1\6\3\0\1\6\13\0"+
    "\2\6\1\173\1\0\22\6\3\0\1\6\3\0\1\6"+
    "\13\0\3\6\1\0\15\6\1\174\4\6\34\0\1\175"+
    "\17\0\1\6\3\0\1\6\13\0\3\6\1\0\5\6"+
    "\1\176\14\6\45\0\1\177\30\0\1\177\26\0\1\6"+
    "\3\0\1\6\13\0\3\6\1\0\16\6\1\200\3\6"+
    "\3\0\1\6\3\0\1\6\13\0\2\6\1\200\1\0"+
    "\22\6\3\0\1\6\3\0\1\6\13\0\3\6\1\0"+
    "\5\6\1\201\14\6\47\0\1\202\4\0\1\6\3\0"+
    "\1\6\13\0\3\6\1\0\20\6\1\203\1\6\37\0"+
    "\1\204\14\0\1\6\3\0\1\6\13\0\3\6\1\0"+
    "\10\6\1\205\11\6\3\0\1\6\3\0\1\6\13\0"+
    "\2\6\1\206\1\0\22\6\37\0\1\207\14\0\1\6"+
    "\3\0\1\6\13\0\3\6\1\0\10\6\1\210\11\6"+
    "\22\0\2\167\30\0\1\6\3\0\1\6\12\0\1\167"+
    "\1\172\2\6\1\0\22\6\3\0\1\6\3\0\1\6"+
    "\13\0\1\6\1\211\1\6\1\0\22\6\33\0\1\212"+
    "\20\0\1\6\3\0\1\6\13\0\3\6\1\0\4\6"+
    "\1\213\15\6\3\0\1\6\3\0\1\6\13\0\3\6"+
    "\1\0\16\6\1\214\3\6\45\0\1\215\6\0\1\6"+
    "\3\0\1\6\13\0\3\6\1\0\16\6\1\216\3\6"+
    "\3\0\1\6\3\0\1\6\13\0\3\6\1\0\16\6"+
    "\1\217\3\6\22\0\2\220\30\0\1\6\3\0\1\6"+
    "\12\0\1\220\1\221\2\6\1\0\22\6\3\0\1\6"+
    "\3\0\1\6\12\0\1\222\1\223\2\6\1\0\22\6"+
    "\24\0\1\224\27\0\1\6\3\0\1\6\13\0\1\6"+
    "\1\225\1\6\1\0\22\6\37\0\1\226\14\0\1\6"+
    "\3\0\1\6\13\0\3\6\1\0\10\6\1\227\11\6"+
    "\46\0\1\230\5\0\1\6\3\0\1\6\13\0\3\6"+
    "\1\0\17\6\1\231\2\6\26\0\2\232\24\0\1\6"+
    "\3\0\1\6\13\0\3\6\1\232\1\233\21\6\22\0"+
    "\2\234\30\0\1\6\3\0\1\6\12\0\1\234\1\235"+
    "\2\6\1\0\22\6\24\0\1\236\27\0\1\6\3\0"+
    "\1\6\13\0\1\6\1\237\1\6\1\0\22\6\26\0"+
    "\2\240\24\0\1\6\3\0\1\6\13\0\3\6\1\240"+
    "\1\241\21\6\40\0\1\242\13\0\1\6\3\0\1\6"+
    "\13\0\3\6\1\0\11\6\1\243\10\6\34\0\1\244"+
    "\17\0\1\6\3\0\1\6\13\0\3\6\1\0\5\6"+
    "\1\245\14\6\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5617];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\2\1\10\11\10\1\1\0"+
    "\1\1\1\0\1\1\1\0\10\1\2\11\1\1\1\0"+
    "\1\1\1\0\7\1\1\11\1\0\1\1\1\0\6\1"+
    "\1\0\1\1\1\0\1\1\1\0\1\1\1\0\2\1"+
    "\1\0\3\1\1\0\1\1\1\11\3\1\1\0\2\1"+
    "\1\0\3\1\1\0\1\1\2\11\2\1\1\0\2\1"+
    "\1\11\2\1\1\0\1\1\3\0\4\1\1\0\1\1"+
    "\3\0\4\1\1\0\1\1\1\0\1\11\1\0\4\1"+
    "\1\0\1\1\1\0\2\1\1\0\1\1\1\0\2\1"+
    "\1\0\2\1\1\0\2\1\1\0\2\1\1\11\1\1"+
    "\1\0\1\1\1\0\1\1\1\0\1\1\1\0\1\1"+
    "\1\0\1\1\1\0\1\1\1\0\1\1\1\0\1\1"+
    "\1\0\1\1\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[165];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    //----> Codigo de usuario en sintaxis java


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Analizador_lexicoFCA(java.io.Reader in) {
    this.zzReader = in;
  }



  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(SimbolosFCA.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { System.out.println("Error Lexico " + yytext() + "Linea: " + yyline + "Columna: " + yycolumn);
            }
          case 25: break;
          case 2: 
            { System.out.println("Reconocio "+yytext()+" decimal"); return new Symbol(SimbolosFCA.decimal, yycolumn, yyline, yytext());
            }
          case 26: break;
          case 3: 
            { /* Espacios en blanco, se ignoran */
            }
          case 27: break;
          case 4: 
            { System.out.println("Reconocio "+yytext()+" identificador"); return new Symbol(SimbolosFCA.identificador, yycolumn, yyline, yytext());
            }
          case 28: break;
          case 5: 
            { System.out.println("Reconocio "+yytext()+" pyc"); return new Symbol(SimbolosFCA.pyc, yycolumn, yyline, yytext());
            }
          case 29: break;
          case 6: 
            { System.out.println("Reconocio "+yytext()+" dop"); return new Symbol(SimbolosFCA.dop, yycolumn, yyline, yytext());
            }
          case 30: break;
          case 7: 
            { System.out.println("Reconocio "+yytext()+" lla"); return new Symbol(SimbolosFCA.lla, yycolumn, yyline, yytext());
            }
          case 31: break;
          case 8: 
            { System.out.println("Reconocio "+yytext()+" llc"); return new Symbol(SimbolosFCA.llc, yycolumn, yyline, yytext());
            }
          case 32: break;
          case 9: 
            { System.out.println("Reconocio "+yytext()+" coma"); return new Symbol(SimbolosFCA.coma, yycolumn, yyline, yytext());
            }
          case 33: break;
          case 10: 
            { System.out.println("Reconocio "+yytext()+" para"); return new Symbol(SimbolosFCA.para, yycolumn, yyline, yytext());
            }
          case 34: break;
          case 11: 
            { System.out.println("Reconocio "+yytext()+" parc"); return new Symbol(SimbolosFCA.parc, yycolumn, yyline, yytext());
            }
          case 35: break;
          case 12: 
            { System.out.println("Reconocio "+yytext()+" igual"); return new Symbol(SimbolosFCA.igual, yycolumn, yyline, yytext());
            }
          case 36: break;
          case 13: 
            { System.out.println("Comentario: "+yytext());
            }
          case 37: break;
          case 14: 
            { System.out.println("Reconocio "+yytext()+" cadena"); return new Symbol(SimbolosFCA.cadena, yycolumn, yyline, yytext());
            }
          case 38: break;
          case 15: 
            { System.out.println("Reconocio "+yytext()+" string"); return new Symbol(SimbolosFCA.string, yycolumn, yyline, yytext());
            }
          case 39: break;
          case 16: 
            { System.out.println("Reconocio "+yytext()+" titulo"); return new Symbol(SimbolosFCA.titulo, yycolumn, yyline, yytext());
            }
          case 40: break;
          case 17: 
            { System.out.println("Reconocio "+yytext()+" doubleFCA"); return new Symbol(SimbolosFCA.doubleFCA, yycolumn, yyline, yytext());
            }
          case 41: break;
          case 18: 
            { System.out.println("Reconocio "+yytext()+" titulox"); return new Symbol(SimbolosFCA.titulox, yycolumn, yyline, yytext());
            }
          case 42: break;
          case 19: 
            { System.out.println("Reconocio "+yytext()+" tituloy"); return new Symbol(SimbolosFCA.tituloy, yycolumn, yyline, yytext());
            }
          case 43: break;
          case 20: 
            { System.out.println("Reconocio "+yytext()+" archivo"); return new Symbol(SimbolosFCA.archivo, yycolumn, yyline, yytext());
            }
          case 44: break;
          case 21: 
            { System.out.println("Reconocio "+yytext()+" compare"); return new Symbol(SimbolosFCA.compare, yycolumn, yyline, yytext());
            }
          case 45: break;
          case 22: 
            { System.out.println("Reconocio "+yytext()+" graficas"); return new Symbol(SimbolosFCA.graficas, yycolumn, yyline, yytext());
            }
          case 46: break;
          case 23: 
            { System.out.println("Reconocio "+yytext()+" globales"); return new Symbol(SimbolosFCA.globales, yycolumn, yyline, yytext());
            }
          case 47: break;
          case 24: 
            { System.out.println("Reconocio "+yytext()+" mein"); return new Symbol(SimbolosFCA.mein, yycolumn, yyline, yytext());
            }
          case 48: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
