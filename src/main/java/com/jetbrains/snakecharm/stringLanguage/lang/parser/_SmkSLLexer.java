/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.jetbrains.snakecharm.stringLanguage.lang.parser;

import com.intellij.psi.tree.IElementType;
import com.intellij.lexer.FlexLexer;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>smk_sl.flex</tt>
 */
class _SmkSLLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int WAITING_IDENTIFIER = 2;
  public static final int WAITING_REGEXP = 4;
  public static final int WAITING_AFTER_IDENTIFIER = 6;
  public static final int WAITING_ACCESS_KEY = 8;
  public static final int WAITING_ACCESS_CLOSURE = 10;
  public static final int WAITING_LANGUAGE_CLOSURE = 12;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6, 6
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [11, 6, 4]
   * Total runtime size is 14368 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>10]<<6)|((ch>>4)&0x3f)]<<4)|(ch&0xf)];
  }

  /* The ZZ_CMAP_Z table has 1088 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\11\1\12\1\13\6\14\1\15\23\14\1\16"+
    "\1\14\1\17\1\20\12\14\1\21\10\11\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1"+
    "\32\1\33\1\34\1\35\2\11\1\14\1\36\3\11\1\37\10\11\1\40\1\41\5\14\1\42\1\43"+
    "\11\11\1\44\2\11\1\45\5\11\1\46\4\11\1\47\1\50\4\11\51\14\1\51\3\14\1\52\1"+
    "\53\4\14\1\54\12\11\1\55\u0381\11");

  /* The ZZ_CMAP_Y table has 2944 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\4\1\6\1\7\1\1\1\10\1\11\1\12\1\13\1\12\1\13\34"+
    "\12\1\14\1\15\1\16\10\1\1\17\1\20\1\12\1\21\4\12\1\22\10\12\1\23\12\12\1\4"+
    "\1\12\1\24\1\4\1\12\1\25\4\1\1\12\1\26\1\27\2\1\2\12\1\26\1\1\1\30\1\4\5\12"+
    "\1\31\1\32\1\33\1\1\1\34\1\12\1\1\1\35\5\12\1\36\1\37\1\40\1\12\1\26\1\41"+
    "\1\12\1\42\1\43\1\1\1\12\1\44\4\1\1\12\1\45\4\1\1\46\2\12\1\47\1\1\1\50\1"+
    "\51\1\4\1\52\1\53\1\54\1\55\1\56\1\57\1\51\1\15\1\60\1\53\1\54\1\61\1\1\1"+
    "\62\1\63\1\64\1\65\1\21\1\54\1\66\1\1\1\67\1\51\1\70\1\71\1\53\1\54\1\66\1"+
    "\1\1\57\1\51\1\37\1\72\1\73\1\74\1\75\1\1\1\67\1\63\1\1\1\76\1\34\1\54\1\47"+
    "\1\1\1\77\1\51\1\1\1\100\1\34\1\54\1\101\1\1\1\56\1\51\1\102\1\76\1\34\1\12"+
    "\1\103\1\56\1\104\1\51\1\105\1\106\1\107\1\12\1\110\1\111\1\1\1\63\1\1\1\4"+
    "\2\12\1\112\1\111\1\113\2\1\1\114\1\115\1\116\1\117\1\120\1\121\2\1\1\67\1"+
    "\1\1\113\1\1\1\122\1\12\1\123\1\1\1\124\7\1\2\12\1\26\1\125\1\113\1\126\1"+
    "\127\1\130\1\131\1\113\2\12\1\132\2\12\1\133\24\12\1\134\1\135\2\12\1\134"+
    "\2\12\1\136\1\137\1\13\3\12\1\137\3\12\1\26\2\1\1\12\1\1\5\12\1\140\1\4\45"+
    "\12\1\141\1\12\1\142\1\26\4\12\1\26\1\143\1\144\1\15\1\12\1\15\1\12\1\15\1"+
    "\144\1\67\3\12\1\145\1\1\1\146\1\113\2\1\1\113\5\12\1\25\1\147\1\12\1\150"+
    "\4\12\1\36\1\12\1\151\2\1\1\63\1\12\1\152\1\153\2\12\1\154\1\12\1\75\1\113"+
    "\2\1\1\12\1\111\3\12\1\153\2\1\2\113\1\155\5\1\1\106\2\12\1\145\1\156\1\113"+
    "\2\1\1\157\1\12\1\160\1\40\2\12\1\36\1\1\2\12\1\145\1\1\1\161\1\40\1\12\1"+
    "\152\1\44\5\1\1\162\1\163\14\12\4\1\21\12\1\140\2\12\1\140\1\164\1\12\1\152"+
    "\3\12\1\165\1\166\1\167\1\123\1\166\1\170\1\1\1\171\2\1\1\172\1\1\1\173\1"+
    "\1\1\123\6\1\1\174\1\175\1\176\1\177\1\200\3\1\1\201\147\1\2\12\1\151\2\12"+
    "\1\151\10\12\1\202\1\203\2\12\1\132\3\12\1\204\1\1\1\12\1\111\4\205\4\1\1"+
    "\125\35\1\1\206\2\1\1\207\1\4\4\12\1\210\1\4\4\12\1\133\1\106\1\12\1\152\1"+
    "\4\4\12\1\151\1\1\1\12\1\26\3\1\1\12\40\1\133\12\1\36\4\1\135\12\1\36\2\1"+
    "\10\12\1\123\4\1\2\12\1\152\20\12\1\123\1\12\1\211\1\1\2\12\1\151\1\125\1"+
    "\12\1\152\4\12\1\36\2\1\1\212\1\213\5\12\1\214\1\12\1\151\1\25\3\1\1\212\1"+
    "\215\1\12\1\27\1\1\3\12\1\145\1\213\2\12\1\145\1\1\1\113\1\1\1\216\1\40\1"+
    "\12\1\36\1\12\1\111\1\1\1\12\1\123\1\46\2\12\1\27\1\125\1\113\1\217\1\220"+
    "\2\12\1\44\1\1\1\221\1\113\1\12\1\222\3\12\1\223\1\224\1\225\1\26\1\64\1\226"+
    "\1\227\1\205\2\12\1\133\1\36\7\12\1\27\1\113\72\12\1\145\1\12\1\230\2\12\1"+
    "\154\20\1\26\12\1\152\6\12\1\75\2\1\1\111\1\231\1\54\1\232\1\233\6\12\1\15"+
    "\1\1\1\157\25\12\1\152\1\1\4\12\1\213\2\12\1\25\2\1\1\154\7\1\1\217\7\12\1"+
    "\123\1\1\1\113\1\4\1\26\1\4\1\26\1\234\4\12\1\151\1\235\1\236\2\1\1\237\1"+
    "\12\1\13\1\240\2\152\2\1\7\12\1\26\30\1\1\12\1\123\3\12\1\67\2\1\2\12\1\1"+
    "\1\12\1\241\2\12\1\36\1\12\1\152\2\12\1\242\3\1\11\12\1\152\1\113\2\12\1\242"+
    "\1\12\1\154\2\12\1\25\3\12\1\145\11\1\23\12\1\111\1\12\1\36\1\25\11\1\1\243"+
    "\2\12\1\244\1\12\1\36\1\12\1\111\1\12\1\151\4\1\1\12\1\245\1\12\1\36\1\12"+
    "\1\75\4\1\3\12\1\246\4\1\1\67\1\247\1\12\1\145\2\1\1\12\1\123\1\12\1\123\2"+
    "\1\1\122\1\12\1\153\1\1\3\12\1\36\1\12\1\36\1\12\1\27\1\12\1\15\6\1\4\12\1"+
    "\44\3\1\3\12\1\27\3\12\1\27\60\1\1\157\2\12\1\25\2\1\1\63\1\1\1\157\2\12\2"+
    "\1\1\12\1\44\1\113\1\157\1\12\1\111\1\63\1\1\2\12\1\250\1\157\2\12\1\27\1"+
    "\251\1\252\2\1\1\12\1\21\1\154\5\1\1\253\1\254\1\44\2\12\1\151\1\1\1\113\1"+
    "\71\1\53\1\54\1\66\1\1\1\255\1\15\11\1\3\12\1\153\1\256\1\113\2\1\3\12\1\1"+
    "\1\257\1\113\12\1\2\12\1\151\2\1\1\260\2\1\3\12\1\1\1\261\1\113\2\1\2\12\1"+
    "\26\1\1\1\113\3\1\1\12\1\75\1\1\1\113\26\1\4\12\1\113\1\125\34\1\3\12\1\44"+
    "\20\1\1\54\1\12\1\151\1\1\1\67\1\113\1\1\1\213\1\12\67\1\71\12\1\75\16\1\14"+
    "\12\1\145\53\1\2\12\1\151\75\1\44\12\1\111\33\1\43\12\1\44\1\12\1\151\1\113"+
    "\6\1\1\12\1\152\1\1\3\12\1\1\1\145\1\113\1\157\1\262\1\12\67\1\4\12\1\153"+
    "\1\67\3\1\1\157\4\1\1\67\1\1\76\12\1\123\1\1\57\12\1\27\20\1\1\15\77\1\6\12"+
    "\1\26\1\123\1\44\1\75\66\1\5\12\1\217\3\12\1\144\1\263\1\264\1\265\3\12\1"+
    "\266\1\267\1\12\1\270\1\271\1\34\24\12\1\272\1\12\1\34\1\133\1\12\1\133\1"+
    "\12\1\217\1\12\1\217\1\151\1\12\1\151\1\12\1\54\1\12\1\54\1\12\1\273\3\274"+
    "\14\12\1\153\3\1\4\12\1\145\1\113\112\1\1\265\1\12\1\275\1\276\1\277\1\300"+
    "\1\301\1\302\1\303\1\154\1\304\1\154\24\1\55\12\1\111\2\1\103\12\1\153\15"+
    "\12\1\152\150\12\1\15\25\1\41\12\1\152\36\1");

  /* The ZZ_CMAP_A table has 3152 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\5\2\22\0\1\2\13\0\1\7\1\0\1\11\1\0\12\3\1\4\6\0\32\1\1\12\1\0\1\10\1"+
    "\0\14\1\1\6\1\0\1\5\7\0\1\2\12\0\1\2\11\0\1\1\12\0\1\1\4\0\1\1\5\0\27\1\1"+
    "\0\12\1\4\0\14\1\16\0\5\1\7\0\1\1\1\0\1\1\1\0\5\1\1\0\2\1\2\0\4\1\1\0\1\1"+
    "\6\0\1\1\1\0\3\1\1\0\1\1\1\0\4\1\1\0\23\1\1\0\13\1\10\0\15\1\2\0\1\1\6\0\10"+
    "\1\10\0\13\1\5\0\3\1\15\0\12\3\4\0\6\1\1\0\1\1\17\0\2\1\7\0\2\1\12\3\3\1\2"+
    "\0\2\1\1\0\16\1\15\0\11\1\13\0\1\1\16\0\12\3\6\1\4\0\2\1\4\0\1\1\5\0\6\1\4"+
    "\0\1\1\11\0\1\1\3\0\1\1\7\0\11\1\7\0\5\1\1\0\10\1\6\0\26\1\3\0\1\1\2\0\1\1"+
    "\7\0\12\1\4\0\12\3\1\1\4\0\10\1\2\0\2\1\2\0\26\1\1\0\7\1\1\0\1\1\3\0\4\1\3"+
    "\0\1\1\20\0\1\1\15\0\2\1\1\0\1\1\5\0\6\1\4\0\2\1\1\0\2\1\1\0\2\1\1\0\2\1\17"+
    "\0\4\1\1\0\1\1\7\0\12\3\2\0\3\1\20\0\11\1\1\0\2\1\1\0\2\1\1\0\5\1\3\0\1\1"+
    "\2\0\1\1\30\0\1\1\13\0\10\1\2\0\1\1\3\0\1\1\1\0\6\1\3\0\3\1\1\0\4\1\3\0\2"+
    "\1\1\0\1\1\1\0\2\1\3\0\2\1\3\0\3\1\3\0\14\1\13\0\10\1\1\0\2\1\10\0\3\1\5\0"+
    "\1\1\4\0\10\1\1\0\6\1\1\0\5\1\3\0\1\1\3\0\2\1\15\0\13\1\2\0\1\1\6\0\3\1\10"+
    "\0\1\1\12\0\6\1\5\0\22\1\3\0\10\1\1\0\11\1\1\0\1\1\2\0\7\1\11\0\1\1\1\0\2"+
    "\1\14\0\12\3\7\0\2\1\1\0\1\1\2\0\2\1\1\0\1\1\2\0\1\1\6\0\4\1\1\0\7\1\1\0\3"+
    "\1\1\0\1\1\1\0\1\1\2\0\2\1\1\0\4\1\1\0\2\1\11\0\1\1\2\0\5\1\1\0\1\1\11\0\12"+
    "\3\2\0\14\1\1\0\24\1\13\0\5\1\22\0\7\1\4\0\4\1\3\0\1\1\3\0\2\1\7\0\3\1\4\0"+
    "\15\1\14\0\1\1\1\0\6\1\1\0\1\1\5\0\1\1\2\0\13\1\1\0\15\1\1\0\4\1\2\0\7\1\1"+
    "\0\1\1\1\0\4\1\2\0\1\1\1\0\4\1\2\0\7\1\1\0\1\1\1\0\4\1\2\0\16\1\2\0\6\1\2"+
    "\0\15\1\2\0\1\1\1\2\17\1\1\0\10\1\7\0\15\1\1\0\6\1\23\0\1\1\4\0\1\1\3\0\5"+
    "\1\2\0\22\1\1\0\1\1\5\0\17\1\1\0\16\1\2\0\5\1\13\0\14\1\13\0\1\1\15\0\7\1"+
    "\7\0\16\1\15\0\2\1\12\3\3\0\3\1\11\0\4\1\1\0\4\1\3\0\2\1\11\0\10\1\1\0\1\1"+
    "\1\0\1\1\1\0\1\1\1\0\6\1\1\0\7\1\1\0\1\1\3\0\3\1\1\0\7\1\3\0\4\1\2\0\6\1\4"+
    "\0\13\2\15\0\2\2\5\0\1\2\17\0\1\2\1\0\1\1\15\0\1\1\2\0\1\1\4\0\1\1\2\0\12"+
    "\1\1\0\1\1\3\0\5\1\6\0\1\1\1\0\1\1\1\0\1\1\1\0\4\1\1\0\13\1\2\0\4\1\5\0\5"+
    "\1\4\0\1\1\4\0\2\1\13\0\5\1\6\0\4\1\3\0\2\1\14\0\10\1\7\0\10\1\1\0\7\1\1\0"+
    "\1\2\4\0\2\1\12\0\5\1\5\0\2\1\3\0\7\1\6\0\3\1\12\3\2\1\13\0\11\1\2\0\27\1"+
    "\2\0\7\1\1\0\3\1\1\0\4\1\1\0\4\1\2\0\6\1\3\0\1\1\1\0\1\1\2\0\5\1\1\0\12\1"+
    "\12\3\5\1\1\0\3\1\1\0\10\1\4\0\7\1\3\0\1\1\3\0\2\1\1\0\1\1\3\0\2\1\2\0\5\1"+
    "\2\0\1\1\1\0\1\1\30\0\3\1\3\0\6\1\2\0\6\1\2\0\6\1\11\0\7\1\4\0\5\1\3\0\5\1"+
    "\5\0\1\1\1\0\10\1\1\0\5\1\1\0\1\1\1\0\2\1\1\0\2\1\1\0\12\1\6\0\12\1\2\0\6"+
    "\1\2\0\6\1\2\0\6\1\2\0\3\1\3\0\14\1\1\0\16\1\1\0\2\1\1\0\2\1\1\0\10\1\6\0"+
    "\4\1\4\0\16\1\2\0\1\1\1\0\14\1\1\0\2\1\3\0\1\1\2\0\4\1\1\0\2\1\12\0\10\1\6"+
    "\0\6\1\1\0\3\1\1\0\12\1\3\0\1\1\12\0\4\1\13\0\12\3\1\1\1\0\1\1\3\0\7\1\1\0"+
    "\1\1\1\0\4\1\1\0\17\1\1\0\2\1\14\0\3\1\7\0\4\1\11\0\2\1\1\0\1\1\20\0\4\1\10"+
    "\0\1\1\13\0\10\1\5\0\3\1\2\0\1\1\2\0\2\1\2\0\4\1\1\0\14\1\1\0\1\1\1\0\7\1"+
    "\1\0\21\1\1\0\4\1\2\0\10\1\1\0\7\1\1\0\14\1\1\0\4\1\1\0\5\1\1\0\1\1\3\0\14"+
    "\1\2\0\13\1\1\0\10\1\2\0\22\3\1\0\2\1\1\0\1\1\2\0\1\1\1\0\12\1\1\0\4\1\1\0"+
    "\1\1\1\0\1\1\6\0\1\1\4\0\1\1\1\0\1\1\1\0\1\1\1\0\3\1\1\0\2\1\1\0\1\1\2\0\1"+
    "\1\1\0\1\1\1\0\1\1\1\0\1\1\1\0\1\1\1\0\2\1\1\0\1\1\2\0\4\1\1\0\7\1\1\0\4\1"+
    "\1\0\4\1\1\0\1\1\1\0\12\1\1\0\5\1\1\0\3\1\1\0\5\1\1\0\5\1");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\4\0\1\2\1\3\1\4\1\5\1\6"+
    "\1\7\1\10\1\1\1\4\1\6\1\4\1\11\1\12"+
    "\1\13\1\14\3\0\1\15\2\0";

  private static int [] zzUnpackAction() {
    int [] result = new int[28];
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
    "\0\0\0\13\0\26\0\41\0\54\0\67\0\102\0\115"+
    "\0\130\0\143\0\156\0\171\0\143\0\143\0\204\0\217"+
    "\0\232\0\245\0\143\0\143\0\260\0\143\0\130\0\217"+
    "\0\273\0\245\0\306\0\321";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[28];
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
    "\6\10\1\11\4\10\1\12\1\13\1\14\2\12\1\15"+
    "\1\12\1\16\3\12\5\17\1\15\1\20\4\17\1\12"+
    "\1\21\1\14\1\12\1\22\1\15\1\12\1\16\1\12"+
    "\1\23\1\24\10\25\1\26\2\25\5\12\1\15\1\12"+
    "\1\16\1\26\7\12\1\15\1\12\1\16\3\12\6\10"+
    "\1\27\4\10\6\0\1\10\20\0\1\13\1\0\1\13"+
    "\11\0\1\14\10\0\5\17\1\0\1\30\4\17\3\0"+
    "\1\31\10\0\1\21\1\0\1\21\7\0\5\32\1\0"+
    "\5\32\10\25\1\0\2\25\3\0\1\31\1\0\1\17"+
    "\1\0\1\33\6\0\1\34\12\0\1\34\1\0\1\17"+
    "\5\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[220];
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
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\1\4\0\2\1\1\11\2\1\2\11\4\1"+
    "\2\11\1\1\1\11\3\0\1\1\2\0";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[28];
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
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  private SmkSLTokenTypes tokenTypes = SmkSLTokenTypes.INSTANCE;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  _SmkSLLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
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
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
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
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
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
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

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
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
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
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
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
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { yybegin(WAITING_LANGUAGE_CLOSURE); return tokenTypes.getREGEXP();
            } 
            // fall through
          case 14: break;
          case 2: 
            { yybegin(YYINITIAL); return tokenTypes.getSTRING_CONTENT();
            } 
            // fall through
          case 15: break;
          case 3: 
            { yybegin(WAITING_IDENTIFIER); return tokenTypes.getLBRACE();
            } 
            // fall through
          case 16: break;
          case 4: 
            { yybegin(WAITING_IDENTIFIER); return tokenTypes.getBAD_CHARACTER();
            } 
            // fall through
          case 17: break;
          case 5: 
            { yybegin(WAITING_AFTER_IDENTIFIER); return tokenTypes.getIDENTIFIER();
            } 
            // fall through
          case 18: break;
          case 6: 
            { return tokenTypes.getBAD_CHARACTER();
            } 
            // fall through
          case 19: break;
          case 7: 
            { yybegin(YYINITIAL); return tokenTypes.getRBRACE();
            } 
            // fall through
          case 20: break;
          case 8: 
            { yybegin(WAITING_REGEXP); return tokenTypes.getCOMMA();
            } 
            // fall through
          case 21: break;
          case 9: 
            { yybegin(WAITING_IDENTIFIER); return tokenTypes.getDOT();
            } 
            // fall through
          case 22: break;
          case 10: 
            { yybegin(WAITING_ACCESS_KEY); return tokenTypes.getLBRACKET();
            } 
            // fall through
          case 23: break;
          case 11: 
            { yybegin(WAITING_ACCESS_CLOSURE); return tokenTypes.getACCESS_KEY();
            } 
            // fall through
          case 24: break;
          case 12: 
            { yybegin(WAITING_AFTER_IDENTIFIER); return tokenTypes.getRBRACKET();
            } 
            // fall through
          case 25: break;
          case 13: 
            { yybegin(WAITING_LANGUAGE_CLOSURE); return tokenTypes.getFORMAT_SPECIFIER();
            } 
            // fall through
          case 26: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
