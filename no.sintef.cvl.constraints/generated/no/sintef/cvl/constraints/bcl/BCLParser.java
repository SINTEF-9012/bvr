package no.sintef.cvl.constraints.bcl;
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
		"<INVALID>", "'implies'", "'*'", "'-'", "'or'", "':'", "'not'", "'('", 
		"'<'", "'isDefined'", "'false'", "'inv'", "'<='", "'isUndefined'", "'and'", 
		"'true'", "'xor'", "'.'", "')'", "'+'", "'iff'", "'='", "'>'", "'/'", 
		"'>='", "'context'", "ID", "NUMBER", "StringLiteral", "WS"
	};
	public static final int
		RULE_constraint = 0, RULE_expLogIff = 1, RULE_expLogImplies = 2, RULE_expLogOr = 3, 
		RULE_expLogAnd = 4, RULE_expLogUn = 5, RULE_expRel = 6, RULE_expPlusMin = 7, 
		RULE_expMulDiv = 8, RULE_expAriUnary = 9, RULE_expterm = 10, RULE_vspec = 11, 
		RULE_literalexp = 12;
	public static final String[] ruleNames = {
		"constraint", "expLogIff", "expLogImplies", "expLogOr", "expLogAnd", "expLogUn", 
		"expRel", "expPlusMin", "expMulDiv", "expAriUnary", "expterm", "vspec", 
		"literalexp"
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
		public ExpLogIffContext expLogIff() {
			return getRuleContext(ExpLogIffContext.class,0);
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
			setState(31);
			_la = _input.LA(1);
			if (_la==25) {
				{
				setState(26); match(25);
				setState(27); vspec();
				setState(28); match(11);
				setState(29); match(5);
				}
			}

			setState(33); expLogIff(0);
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

	public static class ExpLogIffContext extends ParserRuleContext {
		public int _p;
		public ExpLogIffContext expLogIff() {
			return getRuleContext(ExpLogIffContext.class,0);
		}
		public ExpLogImpliesContext expLogImplies() {
			return getRuleContext(ExpLogImpliesContext.class,0);
		}
		public ExpLogIffContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpLogIffContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expLogIff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterExpLogIff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitExpLogIff(this);
		}
	}

	public final ExpLogIffContext expLogIff(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpLogIffContext _localctx = new ExpLogIffContext(_ctx, _parentState, _p);
		ExpLogIffContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, RULE_expLogIff);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(36); expLogImplies(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpLogIffContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_expLogIff);
					setState(38);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(39); match(20);
					setState(40); expLogImplies(0);
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class ExpLogImpliesContext extends ParserRuleContext {
		public int _p;
		public ExpLogOrContext expLogOr() {
			return getRuleContext(ExpLogOrContext.class,0);
		}
		public ExpLogImpliesContext expLogImplies() {
			return getRuleContext(ExpLogImpliesContext.class,0);
		}
		public ExpLogImpliesContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpLogImpliesContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expLogImplies; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterExpLogImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitExpLogImplies(this);
		}
	}

	public final ExpLogImpliesContext expLogImplies(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpLogImpliesContext _localctx = new ExpLogImpliesContext(_ctx, _parentState, _p);
		ExpLogImpliesContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, RULE_expLogImplies);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(47); expLogOr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpLogImpliesContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_expLogImplies);
					setState(49);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(50); match(1);
					setState(51); expLogOr(0);
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class ExpLogOrContext extends ParserRuleContext {
		public int _p;
		public ExpLogOrContext expLogOr() {
			return getRuleContext(ExpLogOrContext.class,0);
		}
		public ExpLogAndContext expLogAnd() {
			return getRuleContext(ExpLogAndContext.class,0);
		}
		public ExpLogOrContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpLogOrContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expLogOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterExpLogOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitExpLogOr(this);
		}
	}

	public final ExpLogOrContext expLogOr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpLogOrContext _localctx = new ExpLogOrContext(_ctx, _parentState, _p);
		ExpLogOrContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, RULE_expLogOr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(58); expLogAnd(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpLogOrContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_expLogOr);
					setState(60);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(61);
					_la = _input.LA(1);
					if ( !(_la==4 || _la==16) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(62); expLogAnd(0);
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class ExpLogAndContext extends ParserRuleContext {
		public int _p;
		public ExpLogUnContext expLogUn() {
			return getRuleContext(ExpLogUnContext.class,0);
		}
		public ExpLogAndContext expLogAnd() {
			return getRuleContext(ExpLogAndContext.class,0);
		}
		public ExpLogAndContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpLogAndContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expLogAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterExpLogAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitExpLogAnd(this);
		}
	}

	public final ExpLogAndContext expLogAnd(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpLogAndContext _localctx = new ExpLogAndContext(_ctx, _parentState, _p);
		ExpLogAndContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, RULE_expLogAnd);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(69); expLogUn();
			}
			_ctx.stop = _input.LT(-1);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpLogAndContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_expLogAnd);
					setState(71);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(72); match(14);
					setState(73); expLogUn();
					}
					} 
				}
				setState(78);
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

	public static class ExpLogUnContext extends ParserRuleContext {
		public ExpLogIffContext expLogIff() {
			return getRuleContext(ExpLogIffContext.class,0);
		}
		public ExpRelContext expRel() {
			return getRuleContext(ExpRelContext.class,0);
		}
		public VspecContext vspec() {
			return getRuleContext(VspecContext.class,0);
		}
		public ExpLogUnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expLogUn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).enterExpLogUn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BCLListener ) ((BCLListener)listener).exitExpLogUn(this);
		}
	}

	public final ExpLogUnContext expLogUn() throws RecognitionException {
		ExpLogUnContext _localctx = new ExpLogUnContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expLogUn);
		int _la;
		try {
			setState(94);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				_la = _input.LA(1);
				if (_la==6) {
					{
					setState(79); match(6);
					}
				}

				setState(82); match(7);
				setState(85);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(83); expLogIff(0);
					}
					break;

				case 2:
					{
					setState(84); expRel();
					}
					break;
				}
				setState(87); match(18);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 9) | (1L << 13))) != 0)) {
					{
					setState(89);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 9) | (1L << 13))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(92); vspec();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93); expRel();
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
		public List<ExpPlusMinContext> expPlusMin() {
			return getRuleContexts(ExpPlusMinContext.class);
		}
		public ExpPlusMinContext expPlusMin(int i) {
			return getRuleContext(ExpPlusMinContext.class,i);
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
		enterRule(_localctx, 12, RULE_expRel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); expPlusMin(0);
			setState(97);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 8) | (1L << 12) | (1L << 21) | (1L << 22) | (1L << 24))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(98); expPlusMin(0);
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

	public static class ExpPlusMinContext extends ParserRuleContext {
		public int _p;
		public ExpPlusMinContext expPlusMin() {
			return getRuleContext(ExpPlusMinContext.class,0);
		}
		public ExpAriUnaryContext expAriUnary() {
			return getRuleContext(ExpAriUnaryContext.class,0);
		}
		public ExpMulDivContext expMulDiv() {
			return getRuleContext(ExpMulDivContext.class,0);
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
		int _startState = 14;
		enterRecursionRule(_localctx, RULE_expPlusMin);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(101); expAriUnary();
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
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
					setState(103);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(104);
					_la = _input.LA(1);
					if ( !(_la==3 || _la==19) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(105); expMulDiv(0);
					}
					} 
				}
				setState(110);
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

	public static class ExpMulDivContext extends ParserRuleContext {
		public int _p;
		public ExpAriUnaryContext expAriUnary() {
			return getRuleContext(ExpAriUnaryContext.class,0);
		}
		public ExpMulDivContext expMulDiv() {
			return getRuleContext(ExpMulDivContext.class,0);
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
		int _startState = 16;
		enterRecursionRule(_localctx, RULE_expMulDiv);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(112); expAriUnary();
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpMulDivContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_expMulDiv);
					setState(114);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(115);
					_la = _input.LA(1);
					if ( !(_la==2 || _la==23) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(116); expAriUnary();
					}
					} 
				}
				setState(121);
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
		enterRule(_localctx, 18, RULE_expAriUnary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if (_la==3) {
				{
				setState(122); match(3);
				}
			}

			setState(125); expterm();
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
		public ExpPlusMinContext expPlusMin() {
			return getRuleContext(ExpPlusMinContext.class,0);
		}
		public LiteralexpContext literalexp() {
			return getRuleContext(LiteralexpContext.class,0);
		}
		public VspecContext vspec() {
			return getRuleContext(VspecContext.class,0);
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
		enterRule(_localctx, 20, RULE_expterm);
		try {
			setState(133);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(127); vspec();
				}
				break;
			case 10:
			case 15:
			case NUMBER:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(128); literalexp();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 3);
				{
				setState(129); match(7);
				setState(130); expPlusMin(0);
				setState(131); match(18);
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
		enterRule(_localctx, 22, RULE_vspec);
		try {
			setState(139);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135); match(ID);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136); match(ID);
				setState(137); match(17);
				setState(138); vspec();
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
		enterRule(_localctx, 24, RULE_literalexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
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
		case 1: return expLogIff_sempred((ExpLogIffContext)_localctx, predIndex);

		case 2: return expLogImplies_sempred((ExpLogImpliesContext)_localctx, predIndex);

		case 3: return expLogOr_sempred((ExpLogOrContext)_localctx, predIndex);

		case 4: return expLogAnd_sempred((ExpLogAndContext)_localctx, predIndex);

		case 7: return expPlusMin_sempred((ExpPlusMinContext)_localctx, predIndex);

		case 8: return expMulDiv_sempred((ExpMulDivContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expLogOr_sempred(ExpLogOrContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean expLogIff_sempred(ExpLogIffContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean expPlusMin_sempred(ExpPlusMinContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean expLogAnd_sempred(ExpLogAndContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean expMulDiv_sempred(ExpMulDivContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean expLogImplies_sempred(ExpLogImpliesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return 2 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3\37\u0092\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3"+
		"\2\5\2\"\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\7\5B\n\5\f\5\16\5E\13\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6M\n\6\f\6\16\6P"+
		"\13\6\3\7\5\7S\n\7\3\7\3\7\3\7\5\7X\n\7\3\7\3\7\3\7\5\7]\n\7\3\7\3\7\5"+
		"\7a\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\tm\n\t\f\t\16\tp\13"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\7\nx\n\n\f\n\16\n{\13\n\3\13\5\13~\n\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0088\n\f\3\r\3\r\3\r\3\r\5\r\u008e"+
		"\n\r\3\16\3\16\3\16\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\b\4\6\6\22"+
		"\22\5\b\b\13\13\17\17\6\n\n\16\16\27\30\32\32\4\5\5\25\25\4\4\4\31\31"+
		"\5\f\f\21\21\35\36\u0094\2!\3\2\2\2\4%\3\2\2\2\6\60\3\2\2\2\b;\3\2\2\2"+
		"\nF\3\2\2\2\f`\3\2\2\2\16b\3\2\2\2\20f\3\2\2\2\22q\3\2\2\2\24}\3\2\2\2"+
		"\26\u0087\3\2\2\2\30\u008d\3\2\2\2\32\u008f\3\2\2\2\34\35\7\33\2\2\35"+
		"\36\5\30\r\2\36\37\7\r\2\2\37 \7\7\2\2 \"\3\2\2\2!\34\3\2\2\2!\"\3\2\2"+
		"\2\"#\3\2\2\2#$\5\4\3\2$\3\3\2\2\2%&\b\3\1\2&\'\5\6\4\2\'-\3\2\2\2()\6"+
		"\3\2\3)*\7\26\2\2*,\5\6\4\2+(\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\5"+
		"\3\2\2\2/-\3\2\2\2\60\61\b\4\1\2\61\62\5\b\5\2\628\3\2\2\2\63\64\6\4\3"+
		"\3\64\65\7\3\2\2\65\67\5\b\5\2\66\63\3\2\2\2\67:\3\2\2\28\66\3\2\2\28"+
		"9\3\2\2\29\7\3\2\2\2:8\3\2\2\2;<\b\5\1\2<=\5\n\6\2=C\3\2\2\2>?\6\5\4\3"+
		"?@\t\2\2\2@B\5\n\6\2A>\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\t\3\2\2"+
		"\2EC\3\2\2\2FG\b\6\1\2GH\5\f\7\2HN\3\2\2\2IJ\6\6\5\3JK\7\20\2\2KM\5\f"+
		"\7\2LI\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\13\3\2\2\2PN\3\2\2\2QS\7"+
		"\b\2\2RQ\3\2\2\2RS\3\2\2\2ST\3\2\2\2TW\7\t\2\2UX\5\4\3\2VX\5\16\b\2WU"+
		"\3\2\2\2WV\3\2\2\2XY\3\2\2\2YZ\7\24\2\2Za\3\2\2\2[]\t\3\2\2\\[\3\2\2\2"+
		"\\]\3\2\2\2]^\3\2\2\2^a\5\30\r\2_a\5\16\b\2`R\3\2\2\2`\\\3\2\2\2`_\3\2"+
		"\2\2a\r\3\2\2\2bc\5\20\t\2cd\t\4\2\2de\5\20\t\2e\17\3\2\2\2fg\b\t\1\2"+
		"gh\5\24\13\2hn\3\2\2\2ij\6\t\6\3jk\t\5\2\2km\5\22\n\2li\3\2\2\2mp\3\2"+
		"\2\2nl\3\2\2\2no\3\2\2\2o\21\3\2\2\2pn\3\2\2\2qr\b\n\1\2rs\5\24\13\2s"+
		"y\3\2\2\2tu\6\n\7\3uv\t\6\2\2vx\5\24\13\2wt\3\2\2\2x{\3\2\2\2yw\3\2\2"+
		"\2yz\3\2\2\2z\23\3\2\2\2{y\3\2\2\2|~\7\5\2\2}|\3\2\2\2}~\3\2\2\2~\177"+
		"\3\2\2\2\177\u0080\5\26\f\2\u0080\25\3\2\2\2\u0081\u0088\5\30\r\2\u0082"+
		"\u0088\5\32\16\2\u0083\u0084\7\t\2\2\u0084\u0085\5\20\t\2\u0085\u0086"+
		"\7\24\2\2\u0086\u0088\3\2\2\2\u0087\u0081\3\2\2\2\u0087\u0082\3\2\2\2"+
		"\u0087\u0083\3\2\2\2\u0088\27\3\2\2\2\u0089\u008e\7\34\2\2\u008a\u008b"+
		"\7\34\2\2\u008b\u008c\7\23\2\2\u008c\u008e\5\30\r\2\u008d\u0089\3\2\2"+
		"\2\u008d\u008a\3\2\2\2\u008e\31\3\2\2\2\u008f\u0090\t\7\2\2\u0090\33\3"+
		"\2\2\2\20!-8CNRW\\`ny}\u0087\u008d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}