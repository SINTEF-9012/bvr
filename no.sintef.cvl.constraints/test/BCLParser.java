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
		T__23=1, T__22=2, T__21=3, T__20=4, T__19=5, T__18=6, T__17=7, T__16=8, 
		T__15=9, T__14=10, T__13=11, T__12=12, T__11=13, T__10=14, T__9=15, T__8=16, 
		T__7=17, T__6=18, T__5=19, T__4=20, T__3=21, T__2=22, T__1=23, T__0=24, 
		ID=25, NUMBER=26, StringLiteral=27, WS=28;
	public static final String[] tokenNames = {
		"<INVALID>", "'xor'", "')'", "'.'", "'implies'", "'+'", "'or'", "'-'", 
		"'*'", "'not'", "'('", "':'", "'isDefined'", "'<'", "'='", "'false'", 
		"'inv'", "'<='", "'isUndefined'", "'>'", "'and'", "'/'", "'>='", "'true'", 
		"'context'", "ID", "NUMBER", "StringLiteral", "WS"
	};
	public static final int
		RULE_constraint = 0, RULE_expLog = 1, RULE_expRel = 2, RULE_expMulDiv = 3, 
		RULE_expPlusMin = 4, RULE_expAriUnary = 5, RULE_expterm = 6, RULE_opUnLog = 7, 
		RULE_opDef = 8, RULE_opUnAri = 9, RULE_opLog = 10, RULE_opRel = 11, RULE_opAriMulDiv = 12, 
		RULE_opAriPlusMinus = 13, RULE_vspec = 14, RULE_literalexp = 15;
	public static final String[] ruleNames = {
		"constraint", "expLog", "expRel", "expMulDiv", "expPlusMin", "expAriUnary", 
		"expterm", "opUnLog", "opDef", "opUnAri", "opLog", "opRel", "opAriMulDiv", 
		"opAriPlusMinus", "vspec", "literalexp"
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
			setState(37);
			_la = _input.LA(1);
			if (_la==24) {
				{
				setState(32); match(24);
				setState(33); vspec();
				setState(34); match(16);
				setState(35); match(11);
				}
			}

			setState(39); expLog(0);
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
		public List<ExpLogContext> expLog() {
			return getRuleContexts(ExpLogContext.class);
		}
		public OpDefContext opDef() {
			return getRuleContext(OpDefContext.class,0);
		}
		public OpUnLogContext opUnLog() {
			return getRuleContext(OpUnLogContext.class,0);
		}
		public List<ExpRelContext> expRel() {
			return getRuleContexts(ExpRelContext.class);
		}
		public ExpRelContext expRel(int i) {
			return getRuleContext(ExpRelContext.class,i);
		}
		public VspecContext vspec() {
			return getRuleContext(VspecContext.class,0);
		}
		public ExpLogContext expLog(int i) {
			return getRuleContext(ExpLogContext.class,i);
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(42); expRel();
				setState(46);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(43); opLog();
					setState(44); expRel();
					}
					break;
				}
				}
				break;

			case 2:
				{
				setState(49);
				_la = _input.LA(1);
				if (_la==9) {
					{
					setState(48); opUnLog();
					}
				}

				setState(51); match(10);
				setState(54);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(52); expLog(0);
					}
					break;

				case 2:
					{
					setState(53); expRel();
					}
					break;
				}
				setState(56); match(2);
				}
				break;

			case 3:
				{
				setState(60);
				switch (_input.LA(1)) {
				case 9:
					{
					setState(58); opUnLog();
					}
					break;
				case 12:
				case 18:
					{
					setState(59); opDef();
					}
					break;
				case ID:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(62); vspec();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(73);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpLogContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expLog);
						setState(65);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(66); opLog();
						setState(67); expRel();
						}
						break;

					case 2:
						{
						_localctx = new ExpLogContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expLog);
						setState(69);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(70); opLog();
						setState(71); expLog(0);
						}
						break;
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 4, RULE_expRel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); expMulDiv(0);
			setState(79); opRel();
			setState(80); expMulDiv(0);
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
		int _startState = 6;
		enterRecursionRule(_localctx, RULE_expMulDiv);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(83); expPlusMin(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpMulDivContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_expMulDiv);
					setState(85);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(86); opAriMulDiv();
					setState(87); expPlusMin(0);
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		int _startState = 8;
		enterRecursionRule(_localctx, RULE_expPlusMin);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(95); expAriUnary();
			}
			_ctx.stop = _input.LT(-1);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpPlusMinContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_expPlusMin);
					setState(97);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(98); opAriPlusMinus();
					setState(99); expAriUnary();
					}
					} 
				}
				setState(105);
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
		enterRule(_localctx, 10, RULE_expAriUnary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if (_la==7) {
				{
				setState(106); opUnAri();
				}
			}

			setState(109); expterm();
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
		enterRule(_localctx, 12, RULE_expterm);
		try {
			setState(117);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(111); vspec();
				}
				break;
			case 15:
			case 23:
			case NUMBER:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(112); literalexp();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 3);
				{
				setState(113); match(10);
				setState(114); expMulDiv(0);
				setState(115); match(2);
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
		enterRule(_localctx, 14, RULE_opUnLog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); match(9);
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
		enterRule(_localctx, 16, RULE_opDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if ( !(_la==12 || _la==18) ) {
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
		enterRule(_localctx, 18, RULE_opUnAri);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(7);
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
		enterRule(_localctx, 20, RULE_opLog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 4) | (1L << 6) | (1L << 20))) != 0)) ) {
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
		enterRule(_localctx, 22, RULE_opRel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 14) | (1L << 17) | (1L << 19) | (1L << 22))) != 0)) ) {
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
		enterRule(_localctx, 24, RULE_opAriMulDiv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_la = _input.LA(1);
			if ( !(_la==8 || _la==21) ) {
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
		enterRule(_localctx, 26, RULE_opAriPlusMinus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_la = _input.LA(1);
			if ( !(_la==5 || _la==7) ) {
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
		enterRule(_localctx, 28, RULE_vspec);
		try {
			setState(137);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133); match(ID);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134); match(ID);
				setState(135); match(3);
				setState(136); vspec();
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
		enterRule(_localctx, 30, RULE_literalexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << 23) | (1L << NUMBER) | (1L << StringLiteral))) != 0)) ) {
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

		case 3: return expMulDiv_sempred((ExpMulDivContext)_localctx, predIndex);

		case 4: return expPlusMin_sempred((ExpPlusMinContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expLog_sempred(ExpLogContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 5 >= _localctx._p;

		case 1: return 4 >= _localctx._p;
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
		"\2\3\36\u0090\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\3\2\3\2\3\2\3\2\3\2\5\2(\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\5\3\61\n\3\3\3\5\3\64\n\3\3\3\3\3\3\3\5\39\n\3\3\3\3\3\3\3\3\3\5\3?\n"+
		"\3\3\3\5\3B\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3L\n\3\f\3\16\3O\13"+
		"\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\\\n\5\f\5\16\5_\13"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6h\n\6\f\6\16\6k\13\6\3\7\5\7n\n\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bx\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u008c\n\20\3"+
		"\21\3\21\3\21\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\b\4\16\16"+
		"\24\24\6\3\3\6\6\b\b\26\26\6\17\20\23\23\25\25\30\30\4\n\n\27\27\4\7\7"+
		"\t\t\5\21\21\31\31\34\35\u008f\2\'\3\2\2\2\4A\3\2\2\2\6P\3\2\2\2\bT\3"+
		"\2\2\2\n`\3\2\2\2\fm\3\2\2\2\16w\3\2\2\2\20y\3\2\2\2\22{\3\2\2\2\24}\3"+
		"\2\2\2\26\177\3\2\2\2\30\u0081\3\2\2\2\32\u0083\3\2\2\2\34\u0085\3\2\2"+
		"\2\36\u008b\3\2\2\2 \u008d\3\2\2\2\"#\7\32\2\2#$\5\36\20\2$%\7\22\2\2"+
		"%&\7\r\2\2&(\3\2\2\2\'\"\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\5\4\3\2*\3\3\2"+
		"\2\2+,\b\3\1\2,\60\5\6\4\2-.\5\26\f\2./\5\6\4\2/\61\3\2\2\2\60-\3\2\2"+
		"\2\60\61\3\2\2\2\61B\3\2\2\2\62\64\5\20\t\2\63\62\3\2\2\2\63\64\3\2\2"+
		"\2\64\65\3\2\2\2\658\7\f\2\2\669\5\4\3\2\679\5\6\4\28\66\3\2\2\28\67\3"+
		"\2\2\29:\3\2\2\2:;\7\4\2\2;B\3\2\2\2<?\5\20\t\2=?\5\22\n\2><\3\2\2\2>"+
		"=\3\2\2\2>?\3\2\2\2?@\3\2\2\2@B\5\36\20\2A+\3\2\2\2A\63\3\2\2\2A>\3\2"+
		"\2\2BM\3\2\2\2CD\6\3\2\3DE\5\26\f\2EF\5\6\4\2FL\3\2\2\2GH\6\3\3\3HI\5"+
		"\26\f\2IJ\5\4\3\2JL\3\2\2\2KC\3\2\2\2KG\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN"+
		"\3\2\2\2N\5\3\2\2\2OM\3\2\2\2PQ\5\b\5\2QR\5\30\r\2RS\5\b\5\2S\7\3\2\2"+
		"\2TU\b\5\1\2UV\5\n\6\2V]\3\2\2\2WX\6\5\4\3XY\5\32\16\2YZ\5\n\6\2Z\\\3"+
		"\2\2\2[W\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\t\3\2\2\2_]\3\2\2\2`"+
		"a\b\6\1\2ab\5\f\7\2bi\3\2\2\2cd\6\6\5\3de\5\34\17\2ef\5\f\7\2fh\3\2\2"+
		"\2gc\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\13\3\2\2\2ki\3\2\2\2ln\5\24"+
		"\13\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2op\5\16\b\2p\r\3\2\2\2qx\5\36\20\2"+
		"rx\5 \21\2st\7\f\2\2tu\5\b\5\2uv\7\4\2\2vx\3\2\2\2wq\3\2\2\2wr\3\2\2\2"+
		"ws\3\2\2\2x\17\3\2\2\2yz\7\13\2\2z\21\3\2\2\2{|\t\2\2\2|\23\3\2\2\2}~"+
		"\7\t\2\2~\25\3\2\2\2\177\u0080\t\3\2\2\u0080\27\3\2\2\2\u0081\u0082\t"+
		"\4\2\2\u0082\31\3\2\2\2\u0083\u0084\t\5\2\2\u0084\33\3\2\2\2\u0085\u0086"+
		"\t\6\2\2\u0086\35\3\2\2\2\u0087\u008c\7\33\2\2\u0088\u0089\7\33\2\2\u0089"+
		"\u008a\7\5\2\2\u008a\u008c\5\36\20\2\u008b\u0087\3\2\2\2\u008b\u0088\3"+
		"\2\2\2\u008c\37\3\2\2\2\u008d\u008e\t\7\2\2\u008e!\3\2\2\2\17\'\60\63"+
		"8>AKM]imw\u008b";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}