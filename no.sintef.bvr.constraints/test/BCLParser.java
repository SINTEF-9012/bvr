/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
// Generated from BCL.g4 by ANTLR 4.5
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
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, ID=26, NUMBER=27, StringLiteral=28, WS=29;
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

	@Override
	public String getGrammarFileName() { return "BCL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

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
			if (_la==T__0) {
				{
				setState(26);
				match(T__0);
				setState(27);
				vspec();
				setState(28);
				match(T__1);
				setState(29);
				match(T__2);
				}
			}

			setState(33);
			expLogIff(0);
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
		public ExpLogImpliesContext expLogImplies() {
			return getRuleContext(ExpLogImpliesContext.class,0);
		}
		public ExpLogIffContext expLogIff() {
			return getRuleContext(ExpLogIffContext.class,0);
		}
		public ExpLogIffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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

	public final ExpLogIffContext expLogIff() throws RecognitionException {
		return expLogIff(0);
	}

	private ExpLogIffContext expLogIff(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpLogIffContext _localctx = new ExpLogIffContext(_ctx, _parentState);
		ExpLogIffContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expLogIff, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(36);
			expLogImplies(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpLogIffContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expLogIff);
					setState(38);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(39);
					match(T__3);
					setState(40);
					expLogImplies(0);
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
		public ExpLogOrContext expLogOr() {
			return getRuleContext(ExpLogOrContext.class,0);
		}
		public ExpLogImpliesContext expLogImplies() {
			return getRuleContext(ExpLogImpliesContext.class,0);
		}
		public ExpLogImpliesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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

	public final ExpLogImpliesContext expLogImplies() throws RecognitionException {
		return expLogImplies(0);
	}

	private ExpLogImpliesContext expLogImplies(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpLogImpliesContext _localctx = new ExpLogImpliesContext(_ctx, _parentState);
		ExpLogImpliesContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expLogImplies, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(47);
			expLogOr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpLogImpliesContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expLogImplies);
					setState(49);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(50);
					match(T__4);
					setState(51);
					expLogOr(0);
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
		public ExpLogAndContext expLogAnd() {
			return getRuleContext(ExpLogAndContext.class,0);
		}
		public ExpLogOrContext expLogOr() {
			return getRuleContext(ExpLogOrContext.class,0);
		}
		public ExpLogOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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

	public final ExpLogOrContext expLogOr() throws RecognitionException {
		return expLogOr(0);
	}

	private ExpLogOrContext expLogOr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpLogOrContext _localctx = new ExpLogOrContext(_ctx, _parentState);
		ExpLogOrContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expLogOr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(58);
			expLogAnd(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpLogOrContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expLogOr);
					setState(60);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(61);
					_la = _input.LA(1);
					if ( !(_la==T__5 || _la==T__6) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(62);
					expLogAnd(0);
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
		public ExpLogUnContext expLogUn() {
			return getRuleContext(ExpLogUnContext.class,0);
		}
		public ExpLogAndContext expLogAnd() {
			return getRuleContext(ExpLogAndContext.class,0);
		}
		public ExpLogAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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

	public final ExpLogAndContext expLogAnd() throws RecognitionException {
		return expLogAnd(0);
	}

	private ExpLogAndContext expLogAnd(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpLogAndContext _localctx = new ExpLogAndContext(_ctx, _parentState);
		ExpLogAndContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expLogAnd, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(69);
			expLogUn();
			}
			_ctx.stop = _input.LT(-1);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpLogAndContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expLogAnd);
					setState(71);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(72);
					match(T__7);
					setState(73);
					expLogUn();
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
				if (_la==T__8) {
					{
					setState(79);
					match(T__8);
					}
				}

				setState(82);
				match(T__9);
				setState(85);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(83);
					expLogIff(0);
					}
					break;
				case 2:
					{
					setState(84);
					expRel();
					}
					break;
				}
				setState(87);
				match(T__10);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__11) | (1L << T__12))) != 0)) {
					{
					setState(89);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__11) | (1L << T__12))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(92);
				vspec();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				expRel();
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
			setState(96);
			expPlusMin(0);
			setState(97);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(98);
			expPlusMin(0);
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
		public ExpMulDivContext expMulDiv() {
			return getRuleContext(ExpMulDivContext.class,0);
		}
		public ExpPlusMinContext expPlusMin() {
			return getRuleContext(ExpPlusMinContext.class,0);
		}
		public ExpPlusMinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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

	public final ExpPlusMinContext expPlusMin() throws RecognitionException {
		return expPlusMin(0);
	}

	private ExpPlusMinContext expPlusMin(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpPlusMinContext _localctx = new ExpPlusMinContext(_ctx, _parentState);
		ExpPlusMinContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expPlusMin, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(101);
			expMulDiv(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpPlusMinContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expPlusMin);
					setState(103);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(104);
					_la = _input.LA(1);
					if ( !(_la==T__18 || _la==T__19) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(105);
					expMulDiv(0);
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
		public ExpAriUnaryContext expAriUnary() {
			return getRuleContext(ExpAriUnaryContext.class,0);
		}
		public ExpMulDivContext expMulDiv() {
			return getRuleContext(ExpMulDivContext.class,0);
		}
		public ExpMulDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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

	public final ExpMulDivContext expMulDiv() throws RecognitionException {
		return expMulDiv(0);
	}

	private ExpMulDivContext expMulDiv(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpMulDivContext _localctx = new ExpMulDivContext(_ctx, _parentState);
		ExpMulDivContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expMulDiv, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(112);
			expAriUnary();
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpMulDivContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expMulDiv);
					setState(114);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(115);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(116);
					expAriUnary();
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
			if (_la==T__19) {
				{
				setState(122);
				match(T__19);
				}
			}

			setState(125);
			expterm();
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
		public VspecContext vspec() {
			return getRuleContext(VspecContext.class,0);
		}
		public LiteralexpContext literalexp() {
			return getRuleContext(LiteralexpContext.class,0);
		}
		public ExpPlusMinContext expPlusMin() {
			return getRuleContext(ExpPlusMinContext.class,0);
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
				setState(127);
				vspec();
				}
				break;
			case T__23:
			case T__24:
			case NUMBER:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				literalexp();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				match(T__9);
				setState(130);
				expPlusMin(0);
				setState(131);
				match(T__10);
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
				setState(135);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(ID);
				setState(137);
				match(T__22);
				setState(138);
				vspec();
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
		public TerminalNode NUMBER() { return getToken(BCLParser.NUMBER, 0); }
		public TerminalNode StringLiteral() { return getToken(BCLParser.StringLiteral, 0); }
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << NUMBER) | (1L << StringLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
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
		case 1:
			return expLogIff_sempred((ExpLogIffContext)_localctx, predIndex);
		case 2:
			return expLogImplies_sempred((ExpLogImpliesContext)_localctx, predIndex);
		case 3:
			return expLogOr_sempred((ExpLogOrContext)_localctx, predIndex);
		case 4:
			return expLogAnd_sempred((ExpLogAndContext)_localctx, predIndex);
		case 7:
			return expPlusMin_sempred((ExpPlusMinContext)_localctx, predIndex);
		case 8:
			return expMulDiv_sempred((ExpMulDivContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expLogIff_sempred(ExpLogIffContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expLogImplies_sempred(ExpLogImpliesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expLogOr_sempred(ExpLogOrContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expLogAnd_sempred(ExpLogAndContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expPlusMin_sempred(ExpPlusMinContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expMulDiv_sempred(ExpMulDivContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u0092\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\5\2\"\n\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\7\4\67\n\4\f\4\16\4:\13\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5B\n\5\f\5\16\5"+
		"E\13\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6M\n\6\f\6\16\6P\13\6\3\7\5\7S\n\7\3"+
		"\7\3\7\3\7\5\7X\n\7\3\7\3\7\3\7\5\7]\n\7\3\7\3\7\5\7a\n\7\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\tm\n\t\f\t\16\tp\13\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\7\nx\n\n\f\n\16\n{\13\n\3\13\5\13~\n\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u0088\n\f\3\r\3\r\3\r\3\r\5\r\u008e\n\r\3\16\3\16\3\16"+
		"\2\b\4\6\b\n\20\22\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\b\3\2\b\t\4\2"+
		"\13\13\16\17\3\2\20\24\3\2\25\26\3\2\27\30\4\2\32\33\35\36\u0094\2!\3"+
		"\2\2\2\4%\3\2\2\2\6\60\3\2\2\2\b;\3\2\2\2\nF\3\2\2\2\f`\3\2\2\2\16b\3"+
		"\2\2\2\20f\3\2\2\2\22q\3\2\2\2\24}\3\2\2\2\26\u0087\3\2\2\2\30\u008d\3"+
		"\2\2\2\32\u008f\3\2\2\2\34\35\7\3\2\2\35\36\5\30\r\2\36\37\7\4\2\2\37"+
		" \7\5\2\2 \"\3\2\2\2!\34\3\2\2\2!\"\3\2\2\2\"#\3\2\2\2#$\5\4\3\2$\3\3"+
		"\2\2\2%&\b\3\1\2&\'\5\6\4\2\'-\3\2\2\2()\f\4\2\2)*\7\6\2\2*,\5\6\4\2+"+
		"(\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\5\3\2\2\2/-\3\2\2\2\60\61\b\4"+
		"\1\2\61\62\5\b\5\2\628\3\2\2\2\63\64\f\4\2\2\64\65\7\7\2\2\65\67\5\b\5"+
		"\2\66\63\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\7\3\2\2\2:8\3\2\2"+
		"\2;<\b\5\1\2<=\5\n\6\2=C\3\2\2\2>?\f\4\2\2?@\t\2\2\2@B\5\n\6\2A>\3\2\2"+
		"\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\t\3\2\2\2EC\3\2\2\2FG\b\6\1\2GH\5\f"+
		"\7\2HN\3\2\2\2IJ\f\4\2\2JK\7\n\2\2KM\5\f\7\2LI\3\2\2\2MP\3\2\2\2NL\3\2"+
		"\2\2NO\3\2\2\2O\13\3\2\2\2PN\3\2\2\2QS\7\13\2\2RQ\3\2\2\2RS\3\2\2\2ST"+
		"\3\2\2\2TW\7\f\2\2UX\5\4\3\2VX\5\16\b\2WU\3\2\2\2WV\3\2\2\2XY\3\2\2\2"+
		"YZ\7\r\2\2Za\3\2\2\2[]\t\3\2\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^a\5\30"+
		"\r\2_a\5\16\b\2`R\3\2\2\2`\\\3\2\2\2`_\3\2\2\2a\r\3\2\2\2bc\5\20\t\2c"+
		"d\t\4\2\2de\5\20\t\2e\17\3\2\2\2fg\b\t\1\2gh\5\22\n\2hn\3\2\2\2ij\f\4"+
		"\2\2jk\t\5\2\2km\5\22\n\2li\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\21"+
		"\3\2\2\2pn\3\2\2\2qr\b\n\1\2rs\5\24\13\2sy\3\2\2\2tu\f\4\2\2uv\t\6\2\2"+
		"vx\5\24\13\2wt\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\23\3\2\2\2{y\3\2"+
		"\2\2|~\7\26\2\2}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\5\26\f\2\u0080"+
		"\25\3\2\2\2\u0081\u0088\5\30\r\2\u0082\u0088\5\32\16\2\u0083\u0084\7\f"+
		"\2\2\u0084\u0085\5\20\t\2\u0085\u0086\7\r\2\2\u0086\u0088\3\2\2\2\u0087"+
		"\u0081\3\2\2\2\u0087\u0082\3\2\2\2\u0087\u0083\3\2\2\2\u0088\27\3\2\2"+
		"\2\u0089\u008e\7\34\2\2\u008a\u008b\7\34\2\2\u008b\u008c\7\31\2\2\u008c"+
		"\u008e\5\30\r\2\u008d\u0089\3\2\2\2\u008d\u008a\3\2\2\2\u008e\31\3\2\2"+
		"\2\u008f\u0090\t\7\2\2\u0090\33\3\2\2\2\20!-8CNRW\\`ny}\u0087\u008d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
