/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
// Generated from TestData/BCL.g4 by ANTLR 4.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BCLLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__24=1, T__23=2, T__22=3, T__21=4, T__20=5, T__19=6, T__18=7, T__17=8, 
		T__16=9, T__15=10, T__14=11, T__13=12, T__12=13, T__11=14, T__10=15, T__9=16, 
		T__8=17, T__7=18, T__6=19, T__5=20, T__4=21, T__3=22, T__2=23, T__1=24, 
		T__0=25, ID=26, NUMBER=27, StringLiteral=28, WS=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'implies'", "'*'", "'-'", "'or'", "':'", "'not'", "'('", "'<'", "'isDefined'", 
		"'false'", "'inv'", "'<='", "'isUndefined'", "'and'", "'true'", "'xor'", 
		"'.'", "')'", "'+'", "'iff'", "'='", "'>'", "'/'", "'>='", "'context'", 
		"ID", "NUMBER", "StringLiteral", "WS"
	};
	public static final String[] ruleNames = {
		"T__24", "T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", 
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"ID", "NUMBER", "StringLiteral", "EscapeSequence", "OctalEscape", "UnicodeEscape", 
		"HexDigit", "WS"
	};


	public BCLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BCL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 32: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\37\u00e8\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\7\33\u00ac\n\33\f\33\16\33\u00af\13\33\3\34\6\34\u00b2"+
		"\n\34\r\34\16\34\u00b3\3\34\3\34\6\34\u00b8\n\34\r\34\16\34\u00b9\5\34"+
		"\u00bc\n\34\3\35\3\35\3\35\7\35\u00c1\n\35\f\35\16\35\u00c4\13\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\5\36\u00cc\n\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\5\37\u00d7\n\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3\"\6\"\u00e3"+
		"\n\"\r\"\16\"\u00e4\3\"\3\"\2#\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17"+
		"\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22"+
		"\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1"+
		"\67\35\19\36\1;\2\1=\2\1?\2\1A\2\1C\37\2\3\2\n\5C\\aac|\6\62;C\\aac|\3"+
		"\62;\3\62;\4$$^^\n$$))^^ddhhppttvv\5\62;CHch\5\13\f\16\17\"\"\u00ee\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2C\3\2"+
		"\2\2\3E\3\2\2\2\5M\3\2\2\2\7O\3\2\2\2\tQ\3\2\2\2\13T\3\2\2\2\rV\3\2\2"+
		"\2\17Z\3\2\2\2\21\\\3\2\2\2\23^\3\2\2\2\25h\3\2\2\2\27n\3\2\2\2\31r\3"+
		"\2\2\2\33u\3\2\2\2\35\u0081\3\2\2\2\37\u0085\3\2\2\2!\u008a\3\2\2\2#\u008e"+
		"\3\2\2\2%\u0090\3\2\2\2\'\u0092\3\2\2\2)\u0094\3\2\2\2+\u0098\3\2\2\2"+
		"-\u009a\3\2\2\2/\u009c\3\2\2\2\61\u009e\3\2\2\2\63\u00a1\3\2\2\2\65\u00a9"+
		"\3\2\2\2\67\u00b1\3\2\2\29\u00bd\3\2\2\2;\u00cb\3\2\2\2=\u00d6\3\2\2\2"+
		"?\u00d8\3\2\2\2A\u00df\3\2\2\2C\u00e2\3\2\2\2EF\7k\2\2FG\7o\2\2GH\7r\2"+
		"\2HI\7n\2\2IJ\7k\2\2JK\7g\2\2KL\7u\2\2L\4\3\2\2\2MN\7,\2\2N\6\3\2\2\2"+
		"OP\7/\2\2P\b\3\2\2\2QR\7q\2\2RS\7t\2\2S\n\3\2\2\2TU\7<\2\2U\f\3\2\2\2"+
		"VW\7p\2\2WX\7q\2\2XY\7v\2\2Y\16\3\2\2\2Z[\7*\2\2[\20\3\2\2\2\\]\7>\2\2"+
		"]\22\3\2\2\2^_\7k\2\2_`\7u\2\2`a\7F\2\2ab\7g\2\2bc\7h\2\2cd\7k\2\2de\7"+
		"p\2\2ef\7g\2\2fg\7f\2\2g\24\3\2\2\2hi\7h\2\2ij\7c\2\2jk\7n\2\2kl\7u\2"+
		"\2lm\7g\2\2m\26\3\2\2\2no\7k\2\2op\7p\2\2pq\7x\2\2q\30\3\2\2\2rs\7>\2"+
		"\2st\7?\2\2t\32\3\2\2\2uv\7k\2\2vw\7u\2\2wx\7W\2\2xy\7p\2\2yz\7f\2\2z"+
		"{\7g\2\2{|\7h\2\2|}\7k\2\2}~\7p\2\2~\177\7g\2\2\177\u0080\7f\2\2\u0080"+
		"\34\3\2\2\2\u0081\u0082\7c\2\2\u0082\u0083\7p\2\2\u0083\u0084\7f\2\2\u0084"+
		"\36\3\2\2\2\u0085\u0086\7v\2\2\u0086\u0087\7t\2\2\u0087\u0088\7w\2\2\u0088"+
		"\u0089\7g\2\2\u0089 \3\2\2\2\u008a\u008b\7z\2\2\u008b\u008c\7q\2\2\u008c"+
		"\u008d\7t\2\2\u008d\"\3\2\2\2\u008e\u008f\7\60\2\2\u008f$\3\2\2\2\u0090"+
		"\u0091\7+\2\2\u0091&\3\2\2\2\u0092\u0093\7-\2\2\u0093(\3\2\2\2\u0094\u0095"+
		"\7k\2\2\u0095\u0096\7h\2\2\u0096\u0097\7h\2\2\u0097*\3\2\2\2\u0098\u0099"+
		"\7?\2\2\u0099,\3\2\2\2\u009a\u009b\7@\2\2\u009b.\3\2\2\2\u009c\u009d\7"+
		"\61\2\2\u009d\60\3\2\2\2\u009e\u009f\7@\2\2\u009f\u00a0\7?\2\2\u00a0\62"+
		"\3\2\2\2\u00a1\u00a2\7e\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7p\2\2\u00a4"+
		"\u00a5\7v\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7z\2\2\u00a7\u00a8\7v\2\2"+
		"\u00a8\64\3\2\2\2\u00a9\u00ad\t\2\2\2\u00aa\u00ac\t\3\2\2\u00ab\u00aa"+
		"\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\66\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\t\4\2\2\u00b1\u00b0\3\2\2"+
		"\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00bb"+
		"\3\2\2\2\u00b5\u00b7\7\60\2\2\u00b6\u00b8\t\5\2\2\u00b7\u00b6\3\2\2\2"+
		"\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc"+
		"\3\2\2\2\u00bb\u00b5\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc8\3\2\2\2\u00bd"+
		"\u00c2\7$\2\2\u00be\u00c1\5;\36\2\u00bf\u00c1\n\6\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6\7$"+
		"\2\2\u00c6:\3\2\2\2\u00c7\u00c8\7^\2\2\u00c8\u00cc\t\7\2\2\u00c9\u00cc"+
		"\5? \2\u00ca\u00cc\5=\37\2\u00cb\u00c7\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00ca\3\2\2\2\u00cc<\3\2\2\2\u00cd\u00ce\7^\2\2\u00ce\u00cf\4\62\65\2"+
		"\u00cf\u00d0\4\629\2\u00d0\u00d7\4\629\2\u00d1\u00d2\7^\2\2\u00d2\u00d3"+
		"\4\629\2\u00d3\u00d7\4\629\2\u00d4\u00d5\7^\2\2\u00d5\u00d7\4\629\2\u00d6"+
		"\u00cd\3\2\2\2\u00d6\u00d1\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7>\3\2\2\2"+
		"\u00d8\u00d9\7^\2\2\u00d9\u00da\7w\2\2\u00da\u00db\5A!\2\u00db\u00dc\5"+
		"A!\2\u00dc\u00dd\5A!\2\u00dd\u00de\5A!\2\u00de@\3\2\2\2\u00df\u00e0\t"+
		"\b\2\2\u00e0B\3\2\2\2\u00e1\u00e3\t\t\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4"+
		"\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e7\b\"\2\2\u00e7D\3\2\2\2\f\2\u00ad\u00b3\u00b9\u00bb\u00c0\u00c2"+
		"\u00cb\u00d6\u00e4";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}
