// Generated from TestData/BCL.g4 by ANTLR 4.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BCLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__24=1, T__23=2, T__22=3, T__21=4, T__20=5, T__19=6, T__18=7, T__17=8, 
		T__16=9, T__15=10, T__14=11, T__13=12, T__12=13, T__11=14, T__10=15, T__9=16, 
		T__8=17, T__7=18, T__6=19, T__5=20, T__4=21, T__3=22, T__2=23, T__1=24, 
		T__0=25, ID=26, NUMBER=27, StringLiteral=28, WS=29;
	public static final String[] tokenNames = {
		"<INVALID>", "'implies'", "'*'", "'-'", "'or'", "':'", "'('", "'not'", 
		"'<'", "'isDefined'", "'false'", "'inv'", "'<='", "'isUndefined'", "'and'", 
		"'true'", "'xor'", "'.'", "')'", "'+'", "'iff'", "'='", "'>'", "'/'", 
		"'>='", "'context'", "ID", "NUMBER", "StringLiteral", "WS"
	};
	public static final int
		RULE_constraint = 0, RULE_expLog = 1, RULE_expLogPart = 2, RULE_expRel = 3, 
		RULE_expMulDiv = 4, RULE_expPlusMin = 5, RULE_expAriUnary = 6, RULE_expterm = 7, 
		RULE_opUnLog = 8, RULE_opDef = 9, RULE_opUnAri = 10, RULE_opLog = 11, 
		RULE_opRel = 12, RULE_opAriMulDiv = 13, RULE_opAriPlusMinus = 14, RULE_vspec = 15, 
		RULE_literalexp = 16;
	public static final String[] ruleNames = {
		"constraint", "expLog", "expLogPart", "expRel", "expMulDiv", "expPlusMin", 
		"expAriUnary", "expterm", "opUnLog", "opDef", "opUnAri", "opLog", "opRel", 
		"opAriMulDiv", "opAriPlusMinus", "vspec", "literalexp"
	};

	@Override
	public String getGrammarFileName() { return "BCL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public BCLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ConstraintContext extends ParserRuleContext {
		public ExpLogContext expLog() {
			return getRuleContext(ExpLogContext.class,0);
		}
		public VspecContext vspec() {
			return getRuleContext(VspecContext.class,0);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitConstraint(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_la = _input.LA(1);
			if (_la==25) {
				{
				setState(34); match(25);
				setState(35); vspec();
				setState(36); match(11);
				setState(37); match(5);
				}
			}

			setState(41); expLog(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpLogContext extends ParserRuleContext {
		public int _p;
		public ExpLogContext expLog() {
			return getRuleContext(ExpLogContext.class,0);
		}
		public List<ExpRelContext> expRel() {
			return getRuleContexts(ExpRelContext.class);
		}
		public ExpLogPartContext expLogPart() {
			return getRuleContext(ExpLogPartContext.class,0);
		}
		public ExpRelContext expRel(int i) {
			return getRuleContext(ExpRelContext.class,i);
		}
		public OpLogContext opLog() {
			return getRuleContext(OpLogContext.class,0);
		}
		public ExpLogContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpLogContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expLog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterExpLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitExpLog(this);
		}
	}

	public final ExpLogContext expLog(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpLogContext _localctx = new ExpLogContext(_ctx, _parentState, _p);
		ExpLogContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, RULE_expLog);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(44); expRel();
				setState(48);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(45); opLog();
					setState(46); expRel();
					}
					break;
				}
				}
				break;

			case 2:
				{
				setState(50); expLogPart();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(61);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpLogContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expLog);
						setState(53);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(54); opLog();
						setState(55); expRel();
						}
						break;

					case 2:
						{
						_localctx = new ExpLogContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expLog);
						setState(57);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(58); opLog();
						setState(59); expLogPart();
						}
						break;
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpLogPartContext extends ParserRuleContext {
		public ExpLogContext expLog() {
			return getRuleContext(ExpLogContext.class,0);
		}
		public OpDefContext opDef() {
			return getRuleContext(OpDefContext.class,0);
		}
		public OpUnLogContext opUnLog() {
			return getRuleContext(OpUnLogContext.class,0);
		}
		public ExpRelContext expRel() {
			return getRuleContext(ExpRelContext.class,0);
		}
		public VspecContext vspec() {
			return getRuleContext(VspecContext.class,0);
		}
		public ExpLogPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expLogPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterExpLogPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitExpLogPart(this);
		}
	}

	public final ExpLogPartContext expLogPart() throws RecognitionException {
		ExpLogPartContext _localctx = new ExpLogPartContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expLogPart);
		int _la;
		try {
			setState(81);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				_la = _input.LA(1);
				if (_la==7) {
					{
					setState(66); opUnLog();
					}
				}

				setState(69); match(6);
				setState(72);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(70); expLog(0);
					}
					break;

				case 2:
					{
					setState(71); expRel();
					}
					break;
				}
				setState(74); match(18);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				switch (_input.LA(1)) {
				case 7:
					{
					setState(76); opUnLog();
					}
					break;
				case 9:
				case 13:
					{
					setState(77); opDef();
					}
					break;
				case ID:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(80); vspec();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpRelContext extends ParserRuleContext {
		public ExpMulDivContext expMulDiv(int i) {
			return getRuleContext(ExpMulDivContext.class,i);
		}
		public OpRelContext opRel() {
			return getRuleContext(OpRelContext.class,0);
		}
		public List<ExpMulDivContext> expMulDiv() {
			return getRuleContexts(ExpMulDivContext.class);
		}
		public ExpRelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expRel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterExpRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitExpRel(this);
		}
	}

	public final ExpRelContext expRel() throws RecognitionException {
		ExpRelContext _localctx = new ExpRelContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expRel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); expMulDiv(0);
			setState(84); opRel();
			setState(85); expMulDiv(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpMulDivContext extends ParserRuleContext {
		public int _p;
		public ExpPlusMinContext expPlusMin() {
			return getRuleContext(ExpPlusMinContext.class,0);
		}
		public ExpMulDivContext expMulDiv() {
			return getRuleContext(ExpMulDivContext.class,0);
		}
		public OpAriMulDivContext opAriMulDiv() {
			return getRuleContext(OpAriMulDivContext.class,0);
		}
		public ExpMulDivContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpMulDivContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expMulDiv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterExpMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitExpMulDiv(this);
		}
	}

	public final ExpMulDivContext expMulDiv(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpMulDivContext _localctx = new ExpMulDivContext(_ctx, _parentState, _p);
		ExpMulDivContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, RULE_expMulDiv);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(88); expPlusMin(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpMulDivContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_expMulDiv);
					setState(90);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(91); opAriMulDiv();
					setState(92); expPlusMin(0);
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpPlusMinContext extends ParserRuleContext {
		public int _p;
		public ExpPlusMinContext expPlusMin() {
			return getRuleContext(ExpPlusMinContext.class,0);
		}
		public ExpAriUnaryContext expAriUnary() {
			return getRuleContext(ExpAriUnaryContext.class,0);
		}
		public OpAriPlusMinusContext opAriPlusMinus() {
			return getRuleContext(OpAriPlusMinusContext.class,0);
		}
		public ExpPlusMinContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpPlusMinContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expPlusMin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterExpPlusMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitExpPlusMin(this);
		}
	}

	public final ExpPlusMinContext expPlusMin(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpPlusMinContext _localctx = new ExpPlusMinContext(_ctx, _parentState, _p);
		ExpPlusMinContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, RULE_expPlusMin);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(100); expAriUnary();
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpPlusMinContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_expPlusMin);
					setState(102);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(103); opAriPlusMinus();
					setState(104); expAriUnary();
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpAriUnaryContext extends ParserRuleContext {
		public ExptermContext expterm() {
			return getRuleContext(ExptermContext.class,0);
		}
		public OpUnAriContext opUnAri() {
			return getRuleContext(OpUnAriContext.class,0);
		}
		public ExpAriUnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expAriUnary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterExpAriUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitExpAriUnary(this);
		}
	}

	public final ExpAriUnaryContext expAriUnary() throws RecognitionException {
		ExpAriUnaryContext _localctx = new ExpAriUnaryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expAriUnary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_la = _input.LA(1);
			if (_la==3) {
				{
				setState(111); opUnAri();
				}
			}

			setState(114); expterm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExptermContext extends ParserRuleContext {
		public LiteralexpContext literalexp() {
			return getRuleContext(LiteralexpContext.class,0);
		}
		public VspecContext vspec() {
			return getRuleContext(VspecContext.class,0);
		}
		public ExpMulDivContext expMulDiv() {
			return getRuleContext(ExpMulDivContext.class,0);
		}
		public ExptermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterExpterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitExpterm(this);
		}
	}

	public final ExptermContext expterm() throws RecognitionException {
		ExptermContext _localctx = new ExptermContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expterm);
		try {
			setState(122);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(116); vspec();
				}
				break;
			case 10:
			case 15:
			case NUMBER:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(117); literalexp();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 3);
				{
				setState(118); match(6);
				setState(119); expMulDiv(0);
				setState(120); match(18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpUnLogContext extends ParserRuleContext {
		public OpUnLogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opUnLog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterOpUnLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitOpUnLog(this);
		}
	}

	public final OpUnLogContext opUnLog() throws RecognitionException {
		OpUnLogContext _localctx = new OpUnLogContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_opUnLog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124); match(7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpDefContext extends ParserRuleContext {
		public OpDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterOpDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitOpDef(this);
		}
	}

	public final OpDefContext opDef() throws RecognitionException {
		OpDefContext _localctx = new OpDefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_opDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_la = _input.LA(1);
			if ( !(_la==9 || _la==13) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpUnAriContext extends ParserRuleContext {
		public OpUnAriContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opUnAri; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterOpUnAri(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitOpUnAri(this);
		}
	}

	public final OpUnAriContext opUnAri() throws RecognitionException {
		OpUnAriContext _localctx = new OpUnAriContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_opUnAri);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpLogContext extends ParserRuleContext {
		public OpLogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opLog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterOpLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitOpLog(this);
		}
	}

	public final OpLogContext opLog() throws RecognitionException {
		OpLogContext _localctx = new OpLogContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_opLog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 4) | (1L << 14) | (1L << 16) | (1L << 20))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpRelContext extends ParserRuleContext {
		public OpRelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opRel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterOpRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitOpRel(this);
		}
	}

	public final OpRelContext opRel() throws RecognitionException {
		OpRelContext _localctx = new OpRelContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_opRel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 8) | (1L << 12) | (1L << 21) | (1L << 22) | (1L << 24))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpAriMulDivContext extends ParserRuleContext {
		public OpAriMulDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opAriMulDiv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterOpAriMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitOpAriMulDiv(this);
		}
	}

	public final OpAriMulDivContext opAriMulDiv() throws RecognitionException {
		OpAriMulDivContext _localctx = new OpAriMulDivContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_opAriMulDiv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_la = _input.LA(1);
			if ( !(_la==2 || _la==23) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpAriPlusMinusContext extends ParserRuleContext {
		public OpAriPlusMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opAriPlusMinus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterOpAriPlusMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitOpAriPlusMinus(this);
		}
	}

	public final OpAriPlusMinusContext opAriPlusMinus() throws RecognitionException {
		OpAriPlusMinusContext _localctx = new OpAriPlusMinusContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_opAriPlusMinus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_la = _input.LA(1);
			if ( !(_la==3 || _la==19) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VspecContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BCLParser.ID, 0); }
		public VspecContext vspec() {
			return getRuleContext(VspecContext.class,0);
		}
		public VspecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vspec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterVspec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitVspec(this);
		}
	}

	public final VspecContext vspec() throws RecognitionException {
		VspecContext _localctx = new VspecContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_vspec);
		try {
			setState(142);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138); match(ID);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139); match(ID);
				setState(140); match(17);
				setState(141); vspec();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralexpContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(BCLParser.StringLiteral, 0); }
		public TerminalNode NUMBER() { return getToken(BCLParser.NUMBER, 0); }
		public LiteralexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterLiteralexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitLiteralexp(this);
		}
	}

	public final LiteralexpContext literalexp() throws RecognitionException {
		LiteralexpContext _localctx = new LiteralexpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_literalexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 15) | (1L << NUMBER) | (1L << StringLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return expLog_sempred((ExpLogContext)_localctx, predIndex);

		case 4: return expMulDiv_sempred((ExpMulDivContext)_localctx, predIndex);

		case 5: return expPlusMin_sempred((ExpPlusMinContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expLog_sempred(ExpLogContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 4 >= _localctx._p;

		case 1: return 3 >= _localctx._p;
		}
		return true;
	}
	private boolean expPlusMin_sempred(ExpPlusMinContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean expMulDiv_sempred(ExpMulDivContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return 2 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3\37\u0095\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\3\2\3\2\3\2\3\2\3\2\5\2*\n\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\5\3\63\n\3\3\3\5\3\66\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7"+
		"\3@\n\3\f\3\16\3C\13\3\3\4\5\4F\n\4\3\4\3\4\3\4\5\4K\n\4\3\4\3\4\3\4\3"+
		"\4\5\4Q\n\4\3\4\5\4T\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7"+
		"\6a\n\6\f\6\16\6d\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7m\n\7\f\7\16\7p"+
		"\13\7\3\b\5\bs\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t}\n\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\5\21\u0091\n\21\3\22\3\22\3\22\2\23\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"\2\b\4\13\13\17\17\7\3\3\6\6\20\20\22\22\26\26\6\n\n\16\16"+
		"\27\30\32\32\4\4\4\31\31\4\5\5\25\25\5\f\f\21\21\35\36\u0093\2)\3\2\2"+
		"\2\4\65\3\2\2\2\6S\3\2\2\2\bU\3\2\2\2\nY\3\2\2\2\fe\3\2\2\2\16r\3\2\2"+
		"\2\20|\3\2\2\2\22~\3\2\2\2\24\u0080\3\2\2\2\26\u0082\3\2\2\2\30\u0084"+
		"\3\2\2\2\32\u0086\3\2\2\2\34\u0088\3\2\2\2\36\u008a\3\2\2\2 \u0090\3\2"+
		"\2\2\"\u0092\3\2\2\2$%\7\33\2\2%&\5 \21\2&\'\7\r\2\2\'(\7\7\2\2(*\3\2"+
		"\2\2)$\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\5\4\3\2,\3\3\2\2\2-.\b\3\1\2.\62"+
		"\5\b\5\2/\60\5\30\r\2\60\61\5\b\5\2\61\63\3\2\2\2\62/\3\2\2\2\62\63\3"+
		"\2\2\2\63\66\3\2\2\2\64\66\5\6\4\2\65-\3\2\2\2\65\64\3\2\2\2\66A\3\2\2"+
		"\2\678\6\3\2\389\5\30\r\29:\5\b\5\2:@\3\2\2\2;<\6\3\3\3<=\5\30\r\2=>\5"+
		"\6\4\2>@\3\2\2\2?\67\3\2\2\2?;\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B"+
		"\5\3\2\2\2CA\3\2\2\2DF\5\22\n\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2GJ\7\b\2"+
		"\2HK\5\4\3\2IK\5\b\5\2JH\3\2\2\2JI\3\2\2\2KL\3\2\2\2LM\7\24\2\2MT\3\2"+
		"\2\2NQ\5\22\n\2OQ\5\24\13\2PN\3\2\2\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RT"+
		"\5 \21\2SE\3\2\2\2SP\3\2\2\2T\7\3\2\2\2UV\5\n\6\2VW\5\32\16\2WX\5\n\6"+
		"\2X\t\3\2\2\2YZ\b\6\1\2Z[\5\f\7\2[b\3\2\2\2\\]\6\6\4\3]^\5\34\17\2^_\5"+
		"\f\7\2_a\3\2\2\2`\\\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\13\3\2\2\2"+
		"db\3\2\2\2ef\b\7\1\2fg\5\16\b\2gn\3\2\2\2hi\6\7\5\3ij\5\36\20\2jk\5\16"+
		"\b\2km\3\2\2\2lh\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\r\3\2\2\2pn\3"+
		"\2\2\2qs\5\26\f\2rq\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\5\20\t\2u\17\3\2\2\2"+
		"v}\5 \21\2w}\5\"\22\2xy\7\b\2\2yz\5\n\6\2z{\7\24\2\2{}\3\2\2\2|v\3\2\2"+
		"\2|w\3\2\2\2|x\3\2\2\2}\21\3\2\2\2~\177\7\t\2\2\177\23\3\2\2\2\u0080\u0081"+
		"\t\2\2\2\u0081\25\3\2\2\2\u0082\u0083\7\5\2\2\u0083\27\3\2\2\2\u0084\u0085"+
		"\t\3\2\2\u0085\31\3\2\2\2\u0086\u0087\t\4\2\2\u0087\33\3\2\2\2\u0088\u0089"+
		"\t\5\2\2\u0089\35\3\2\2\2\u008a\u008b\t\6\2\2\u008b\37\3\2\2\2\u008c\u0091"+
		"\7\34\2\2\u008d\u008e\7\34\2\2\u008e\u008f\7\23\2\2\u008f\u0091\5 \21"+
		"\2\u0090\u008c\3\2\2\2\u0090\u008d\3\2\2\2\u0091!\3\2\2\2\u0092\u0093"+
		"\t\7\2\2\u0093#\3\2\2\2\20)\62\65?AEJPSbnr|\u0090";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}