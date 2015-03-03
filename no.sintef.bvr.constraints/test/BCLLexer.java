// Generated from BCL.g4 by ANTLR 4.5
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
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, ID=26, NUMBER=27, StringLiteral=28, WS=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"ID", "NUMBER", "StringLiteral", "EscapeSequence", "OctalEscape", "UnicodeEscape", 
		"HexDigit", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'context'", "'inv'", "':'", "'iff'", "'implies'", "'or'", "'xor'", 
		"'and'", "'not'", "'('", "')'", "'isDefined'", "'isUndefined'", "'='", 
		"'<='", "'>='", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'", "'.'", "'true'", 
		"'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "ID", "NUMBER", "StringLiteral", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public BCLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BCL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00e8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\7\33\u00ac\n\33"+
		"\f\33\16\33\u00af\13\33\3\34\6\34\u00b2\n\34\r\34\16\34\u00b3\3\34\3\34"+
		"\6\34\u00b8\n\34\r\34\16\34\u00b9\5\34\u00bc\n\34\3\35\3\35\3\35\7\35"+
		"\u00c1\n\35\f\35\16\35\u00c4\13\35\3\35\3\35\3\36\3\36\3\36\3\36\5\36"+
		"\u00cc\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u00d7\n"+
		"\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3\"\6\"\u00e3\n\"\r\"\16\"\u00e4\3\"\3"+
		"\"\2\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35"+
		"9\36;\2=\2?\2A\2C\37\3\2\t\5\2C\\aac|\6\2\62;B\\aac|\3\2\62;\4\2$$^^\n"+
		"\2$$))^^ddhhppttvv\5\2\62;CHch\5\2\13\f\16\17\"\"\u00ee\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2C\3\2\2\2\3E\3\2\2"+
		"\2\5M\3\2\2\2\7Q\3\2\2\2\tS\3\2\2\2\13W\3\2\2\2\r_\3\2\2\2\17b\3\2\2\2"+
		"\21f\3\2\2\2\23j\3\2\2\2\25n\3\2\2\2\27p\3\2\2\2\31r\3\2\2\2\33|\3\2\2"+
		"\2\35\u0088\3\2\2\2\37\u008a\3\2\2\2!\u008d\3\2\2\2#\u0090\3\2\2\2%\u0092"+
		"\3\2\2\2\'\u0094\3\2\2\2)\u0096\3\2\2\2+\u0098\3\2\2\2-\u009a\3\2\2\2"+
		"/\u009c\3\2\2\2\61\u009e\3\2\2\2\63\u00a3\3\2\2\2\65\u00a9\3\2\2\2\67"+
		"\u00b1\3\2\2\29\u00bd\3\2\2\2;\u00cb\3\2\2\2=\u00d6\3\2\2\2?\u00d8\3\2"+
		"\2\2A\u00df\3\2\2\2C\u00e2\3\2\2\2EF\7e\2\2FG\7q\2\2GH\7p\2\2HI\7v\2\2"+
		"IJ\7g\2\2JK\7z\2\2KL\7v\2\2L\4\3\2\2\2MN\7k\2\2NO\7p\2\2OP\7x\2\2P\6\3"+
		"\2\2\2QR\7<\2\2R\b\3\2\2\2ST\7k\2\2TU\7h\2\2UV\7h\2\2V\n\3\2\2\2WX\7k"+
		"\2\2XY\7o\2\2YZ\7r\2\2Z[\7n\2\2[\\\7k\2\2\\]\7g\2\2]^\7u\2\2^\f\3\2\2"+
		"\2_`\7q\2\2`a\7t\2\2a\16\3\2\2\2bc\7z\2\2cd\7q\2\2de\7t\2\2e\20\3\2\2"+
		"\2fg\7c\2\2gh\7p\2\2hi\7f\2\2i\22\3\2\2\2jk\7p\2\2kl\7q\2\2lm\7v\2\2m"+
		"\24\3\2\2\2no\7*\2\2o\26\3\2\2\2pq\7+\2\2q\30\3\2\2\2rs\7k\2\2st\7u\2"+
		"\2tu\7F\2\2uv\7g\2\2vw\7h\2\2wx\7k\2\2xy\7p\2\2yz\7g\2\2z{\7f\2\2{\32"+
		"\3\2\2\2|}\7k\2\2}~\7u\2\2~\177\7W\2\2\177\u0080\7p\2\2\u0080\u0081\7"+
		"f\2\2\u0081\u0082\7g\2\2\u0082\u0083\7h\2\2\u0083\u0084\7k\2\2\u0084\u0085"+
		"\7p\2\2\u0085\u0086\7g\2\2\u0086\u0087\7f\2\2\u0087\34\3\2\2\2\u0088\u0089"+
		"\7?\2\2\u0089\36\3\2\2\2\u008a\u008b\7>\2\2\u008b\u008c\7?\2\2\u008c "+
		"\3\2\2\2\u008d\u008e\7@\2\2\u008e\u008f\7?\2\2\u008f\"\3\2\2\2\u0090\u0091"+
		"\7>\2\2\u0091$\3\2\2\2\u0092\u0093\7@\2\2\u0093&\3\2\2\2\u0094\u0095\7"+
		"-\2\2\u0095(\3\2\2\2\u0096\u0097\7/\2\2\u0097*\3\2\2\2\u0098\u0099\7,"+
		"\2\2\u0099,\3\2\2\2\u009a\u009b\7\61\2\2\u009b.\3\2\2\2\u009c\u009d\7"+
		"\60\2\2\u009d\60\3\2\2\2\u009e\u009f\7v\2\2\u009f\u00a0\7t\2\2\u00a0\u00a1"+
		"\7w\2\2\u00a1\u00a2\7g\2\2\u00a2\62\3\2\2\2\u00a3\u00a4\7h\2\2\u00a4\u00a5"+
		"\7c\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7u\2\2\u00a7\u00a8\7g\2\2\u00a8"+
		"\64\3\2\2\2\u00a9\u00ad\t\2\2\2\u00aa\u00ac\t\3\2\2\u00ab\u00aa\3\2\2"+
		"\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\66"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\t\4\2\2\u00b1\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00bb\3\2"+
		"\2\2\u00b5\u00b7\7\60\2\2\u00b6\u00b8\t\4\2\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\3\2"+
		"\2\2\u00bb\u00b5\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc8\3\2\2\2\u00bd\u00c2"+
		"\7$\2\2\u00be\u00c1\5;\36\2\u00bf\u00c1\n\5\2\2\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00bf\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6\7$\2\2\u00c6"+
		":\3\2\2\2\u00c7\u00c8\7^\2\2\u00c8\u00cc\t\6\2\2\u00c9\u00cc\5? \2\u00ca"+
		"\u00cc\5=\37\2\u00cb\u00c7\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00ca\3\2"+
		"\2\2\u00cc<\3\2\2\2\u00cd\u00ce\7^\2\2\u00ce\u00cf\4\62\65\2\u00cf\u00d0"+
		"\4\629\2\u00d0\u00d7\4\629\2\u00d1\u00d2\7^\2\2\u00d2\u00d3\4\629\2\u00d3"+
		"\u00d7\4\629\2\u00d4\u00d5\7^\2\2\u00d5\u00d7\4\629\2\u00d6\u00cd\3\2"+
		"\2\2\u00d6\u00d1\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7>\3\2\2\2\u00d8\u00d9"+
		"\7^\2\2\u00d9\u00da\7w\2\2\u00da\u00db\5A!\2\u00db\u00dc\5A!\2\u00dc\u00dd"+
		"\5A!\2\u00dd\u00de\5A!\2\u00de@\3\2\2\2\u00df\u00e0\t\7\2\2\u00e0B\3\2"+
		"\2\2\u00e1\u00e3\t\b\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\b\""+
		"\2\2\u00e7D\3\2\2\2\f\2\u00ad\u00b3\u00b9\u00bb\u00c0\u00c2\u00cb\u00d6"+
		"\u00e4\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}