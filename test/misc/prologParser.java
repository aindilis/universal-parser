// Generated from prolog.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class prologParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, LCLETTER=20, UCLETTER=21, DIGIT=22, WS=23;
	public static final int
		RULE_program = 0, RULE_clauselist = 1, RULE_clause = 2, RULE_predicatelist = 3, 
		RULE_predicate = 4, RULE_termlist = 5, RULE_term = 6, RULE_structure = 7, 
		RULE_query = 8, RULE_atom = 9, RULE_smallatom = 10, RULE_variable = 11, 
		RULE_numeral = 12, RULE_character = 13, RULE_special = 14, RULE_string = 15;
	public static final String[] ruleNames = {
		"program", "clauselist", "clause", "predicatelist", "predicate", "termlist", 
		"term", "structure", "query", "atom", "smallatom", "variable", "numeral", 
		"character", "special", "string"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "':-'", "','", "'('", "')'", "'?-'", "'''", "'+'", "'-'", 
		"'*'", "'/'", "'\\'", "'^'", "'~'", "':'", "'?'", "'#'", "'$'", "'&'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "LCLETTER", "UCLETTER", 
		"DIGIT", "WS"
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
	public String getGrammarFileName() { return "prolog.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public prologParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public ClauselistContext clauselist() {
			return getRuleContext(ClauselistContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			clauselist();
			setState(34);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(33);
				query();
				}
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

	public static class ClauselistContext extends ParserRuleContext {
		public List<ClauseContext> clause() {
			return getRuleContexts(ClauseContext.class);
		}
		public ClauseContext clause(int i) {
			return getRuleContext(ClauseContext.class,i);
		}
		public ClauselistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clauselist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterClauselist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitClauselist(this);
		}
	}

	public final ClauselistContext clauselist() throws RecognitionException {
		ClauselistContext _localctx = new ClauselistContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_clauselist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6 || _la==LCLETTER) {
				{
				{
				setState(36);
				clause();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ClauseContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicatelistContext predicatelist() {
			return getRuleContext(PredicatelistContext.class,0);
		}
		public ClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitClause(this);
		}
	}

	public final ClauseContext clause() throws RecognitionException {
		ClauseContext _localctx = new ClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_clause);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(42);
				predicate();
				setState(43);
				match(T__0);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(45);
				predicate();
				setState(46);
				match(T__1);
				}
				{
				setState(48);
				predicatelist();
				setState(49);
				match(T__0);
				}
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

	public static class PredicatelistContext extends ParserRuleContext {
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public PredicatelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatelist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterPredicatelist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitPredicatelist(this);
		}
	}

	public final PredicatelistContext predicatelist() throws RecognitionException {
		PredicatelistContext _localctx = new PredicatelistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_predicatelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			predicate();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(54);
				match(T__2);
				setState(55);
				predicate();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class PredicateContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TermlistContext termlist() {
			return getRuleContext(TermlistContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_predicate);
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				atom();
				setState(63);
				match(T__3);
				setState(64);
				termlist(0);
				setState(65);
				match(T__4);
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

	public static class TermlistContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermlistContext termlist() {
			return getRuleContext(TermlistContext.class,0);
		}
		public TermlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterTermlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitTermlist(this);
		}
	}

	public final TermlistContext termlist() throws RecognitionException {
		return termlist(0);
	}

	private TermlistContext termlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermlistContext _localctx = new TermlistContext(_ctx, _parentState);
		TermlistContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_termlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(70);
			term();
			}
			_ctx.stop = _input.LT(-1);
			setState(77);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_termlist);
					setState(72);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(73);
					match(T__2);
					setState(74);
					term();
					}
					} 
				}
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class TermContext extends ParserRuleContext {
		public NumeralContext numeral() {
			return getRuleContext(NumeralContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public StructureContext structure() {
			return getRuleContext(StructureContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_term);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				numeral(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				atom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				variable(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				structure();
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

	public static class StructureContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TermlistContext termlist() {
			return getRuleContext(TermlistContext.class,0);
		}
		public StructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitStructure(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_structure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			atom();
			setState(87);
			match(T__3);
			setState(88);
			termlist(0);
			setState(89);
			match(T__4);
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

	public static class QueryContext extends ParserRuleContext {
		public PredicatelistContext predicatelist() {
			return getRuleContext(PredicatelistContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__5);
			setState(92);
			predicatelist();
			setState(93);
			match(T__0);
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

	public static class AtomContext extends ParserRuleContext {
		public SmallatomContext smallatom() {
			return getRuleContext(SmallatomContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atom);
		try {
			setState(100);
			switch (_input.LA(1)) {
			case LCLETTER:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				smallatom(0);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				match(T__6);
				setState(97);
				string(0);
				setState(98);
				match(T__6);
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

	public static class SmallatomContext extends ParserRuleContext {
		public TerminalNode LCLETTER() { return getToken(prologParser.LCLETTER, 0); }
		public SmallatomContext smallatom() {
			return getRuleContext(SmallatomContext.class,0);
		}
		public CharacterContext character() {
			return getRuleContext(CharacterContext.class,0);
		}
		public SmallatomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_smallatom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterSmallatom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitSmallatom(this);
		}
	}

	public final SmallatomContext smallatom() throws RecognitionException {
		return smallatom(0);
	}

	private SmallatomContext smallatom(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SmallatomContext _localctx = new SmallatomContext(_ctx, _parentState);
		SmallatomContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_smallatom, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(103);
			match(LCLETTER);
			}
			_ctx.stop = _input.LT(-1);
			setState(109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SmallatomContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_smallatom);
					setState(105);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(106);
					character();
					}
					} 
				}
				setState(111);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode UCLETTER() { return getToken(prologParser.UCLETTER, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public CharacterContext character() {
			return getRuleContext(CharacterContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		return variable(0);
	}

	private VariableContext variable(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VariableContext _localctx = new VariableContext(_ctx, _parentState);
		VariableContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_variable, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(113);
			match(UCLETTER);
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VariableContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_variable);
					setState(115);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(116);
					character();
					}
					} 
				}
				setState(121);
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

	public static class NumeralContext extends ParserRuleContext {
		public TerminalNode DIGIT() { return getToken(prologParser.DIGIT, 0); }
		public NumeralContext numeral() {
			return getRuleContext(NumeralContext.class,0);
		}
		public NumeralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterNumeral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitNumeral(this);
		}
	}

	public final NumeralContext numeral() throws RecognitionException {
		return numeral(0);
	}

	private NumeralContext numeral(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NumeralContext _localctx = new NumeralContext(_ctx, _parentState);
		NumeralContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_numeral, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(123);
			match(DIGIT);
			}
			_ctx.stop = _input.LT(-1);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NumeralContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_numeral);
					setState(125);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(126);
					match(DIGIT);
					}
					} 
				}
				setState(131);
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

	public static class CharacterContext extends ParserRuleContext {
		public TerminalNode LCLETTER() { return getToken(prologParser.LCLETTER, 0); }
		public TerminalNode UCLETTER() { return getToken(prologParser.UCLETTER, 0); }
		public TerminalNode DIGIT() { return getToken(prologParser.DIGIT, 0); }
		public SpecialContext special() {
			return getRuleContext(SpecialContext.class,0);
		}
		public CharacterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterCharacter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitCharacter(this);
		}
	}

	public final CharacterContext character() throws RecognitionException {
		CharacterContext _localctx = new CharacterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_character);
		try {
			setState(136);
			switch (_input.LA(1)) {
			case LCLETTER:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(LCLETTER);
				}
				break;
			case UCLETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				match(UCLETTER);
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(134);
				match(DIGIT);
				}
				break;
			case T__0:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				special();
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

	public static class SpecialContext extends ParserRuleContext {
		public SpecialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_special; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterSpecial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitSpecial(this);
		}
	}

	public final SpecialContext special() throws RecognitionException {
		SpecialContext _localctx = new SpecialContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_special);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
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

	public static class StringContext extends ParserRuleContext {
		public CharacterContext character() {
			return getRuleContext(CharacterContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prologListener ) ((prologListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		return string(0);
	}

	private StringContext string(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StringContext _localctx = new StringContext(_ctx, _parentState);
		StringContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_string, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(141);
			character();
			}
			_ctx.stop = _input.LT(-1);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StringContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_string);
					setState(143);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(144);
					character();
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return termlist_sempred((TermlistContext)_localctx, predIndex);
		case 10:
			return smallatom_sempred((SmallatomContext)_localctx, predIndex);
		case 11:
			return variable_sempred((VariableContext)_localctx, predIndex);
		case 12:
			return numeral_sempred((NumeralContext)_localctx, predIndex);
		case 15:
			return string_sempred((StringContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean termlist_sempred(TermlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean smallatom_sempred(SmallatomContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean variable_sempred(VariableContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean numeral_sempred(NumeralContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean string_sempred(StringContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u0099\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\5\2%\n\2\3\3\7\3(\n\3\f\3\16\3+\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4\66\n\4\3\5\3\5\3\5\7\5;\n\5\f\5\16\5>\13\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6F\n\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7N\n\7\f\7\16\7Q\13\7\3\b\3"+
		"\b\3\b\3\b\5\bW\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\5\13g\n\13\3\f\3\f\3\f\3\f\3\f\7\fn\n\f\f\f\16\fq\13\f\3\r"+
		"\3\r\3\r\3\r\3\r\7\rx\n\r\f\r\16\r{\13\r\3\16\3\16\3\16\3\16\3\16\7\16"+
		"\u0082\n\16\f\16\16\16\u0085\13\16\3\17\3\17\3\17\3\17\5\17\u008b\n\17"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\7\21\u0094\n\21\f\21\16\21\u0097\13"+
		"\21\3\21\2\7\f\26\30\32 \22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2"+
		"\3\4\2\3\3\n\25\u0099\2\"\3\2\2\2\4)\3\2\2\2\6\65\3\2\2\2\b\67\3\2\2\2"+
		"\nE\3\2\2\2\fG\3\2\2\2\16V\3\2\2\2\20X\3\2\2\2\22]\3\2\2\2\24f\3\2\2\2"+
		"\26h\3\2\2\2\30r\3\2\2\2\32|\3\2\2\2\34\u008a\3\2\2\2\36\u008c\3\2\2\2"+
		" \u008e\3\2\2\2\"$\5\4\3\2#%\5\22\n\2$#\3\2\2\2$%\3\2\2\2%\3\3\2\2\2&"+
		"(\5\6\4\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2\2\2+)\3\2\2"+
		"\2,-\5\n\6\2-.\7\3\2\2.\66\3\2\2\2/\60\5\n\6\2\60\61\7\4\2\2\61\62\3\2"+
		"\2\2\62\63\5\b\5\2\63\64\7\3\2\2\64\66\3\2\2\2\65,\3\2\2\2\65/\3\2\2\2"+
		"\66\7\3\2\2\2\67<\5\n\6\289\7\5\2\29;\5\n\6\2:8\3\2\2\2;>\3\2\2\2<:\3"+
		"\2\2\2<=\3\2\2\2=\t\3\2\2\2><\3\2\2\2?F\5\24\13\2@A\5\24\13\2AB\7\6\2"+
		"\2BC\5\f\7\2CD\7\7\2\2DF\3\2\2\2E?\3\2\2\2E@\3\2\2\2F\13\3\2\2\2GH\b\7"+
		"\1\2HI\5\16\b\2IO\3\2\2\2JK\f\3\2\2KL\7\5\2\2LN\5\16\b\2MJ\3\2\2\2NQ\3"+
		"\2\2\2OM\3\2\2\2OP\3\2\2\2P\r\3\2\2\2QO\3\2\2\2RW\5\32\16\2SW\5\24\13"+
		"\2TW\5\30\r\2UW\5\20\t\2VR\3\2\2\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2W\17\3"+
		"\2\2\2XY\5\24\13\2YZ\7\6\2\2Z[\5\f\7\2[\\\7\7\2\2\\\21\3\2\2\2]^\7\b\2"+
		"\2^_\5\b\5\2_`\7\3\2\2`\23\3\2\2\2ag\5\26\f\2bc\7\t\2\2cd\5 \21\2de\7"+
		"\t\2\2eg\3\2\2\2fa\3\2\2\2fb\3\2\2\2g\25\3\2\2\2hi\b\f\1\2ij\7\26\2\2"+
		"jo\3\2\2\2kl\f\3\2\2ln\5\34\17\2mk\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2"+
		"\2p\27\3\2\2\2qo\3\2\2\2rs\b\r\1\2st\7\27\2\2ty\3\2\2\2uv\f\3\2\2vx\5"+
		"\34\17\2wu\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\31\3\2\2\2{y\3\2\2\2"+
		"|}\b\16\1\2}~\7\30\2\2~\u0083\3\2\2\2\177\u0080\f\3\2\2\u0080\u0082\7"+
		"\30\2\2\u0081\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\33\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u008b\7\26\2"+
		"\2\u0087\u008b\7\27\2\2\u0088\u008b\7\30\2\2\u0089\u008b\5\36\20\2\u008a"+
		"\u0086\3\2\2\2\u008a\u0087\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2"+
		"\2\2\u008b\35\3\2\2\2\u008c\u008d\t\2\2\2\u008d\37\3\2\2\2\u008e\u008f"+
		"\b\21\1\2\u008f\u0090\5\34\17\2\u0090\u0095\3\2\2\2\u0091\u0092\f\3\2"+
		"\2\u0092\u0094\5\34\17\2\u0093\u0091\3\2\2\2\u0094\u0097\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096!\3\2\2\2\u0097\u0095\3\2\2\2"+
		"\17$)\65<EOVfoy\u0083\u008a\u0095";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}