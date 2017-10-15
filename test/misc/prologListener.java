// Generated from prolog.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link prologParser}.
 */
public interface prologListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link prologParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(prologParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(prologParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#clauselist}.
	 * @param ctx the parse tree
	 */
	void enterClauselist(prologParser.ClauselistContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#clauselist}.
	 * @param ctx the parse tree
	 */
	void exitClauselist(prologParser.ClauselistContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterClause(prologParser.ClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitClause(prologParser.ClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#predicatelist}.
	 * @param ctx the parse tree
	 */
	void enterPredicatelist(prologParser.PredicatelistContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#predicatelist}.
	 * @param ctx the parse tree
	 */
	void exitPredicatelist(prologParser.PredicatelistContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(prologParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(prologParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#termlist}.
	 * @param ctx the parse tree
	 */
	void enterTermlist(prologParser.TermlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#termlist}.
	 * @param ctx the parse tree
	 */
	void exitTermlist(prologParser.TermlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(prologParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(prologParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructure(prologParser.StructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructure(prologParser.StructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(prologParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(prologParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(prologParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(prologParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#smallatom}.
	 * @param ctx the parse tree
	 */
	void enterSmallatom(prologParser.SmallatomContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#smallatom}.
	 * @param ctx the parse tree
	 */
	void exitSmallatom(prologParser.SmallatomContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(prologParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(prologParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#numeral}.
	 * @param ctx the parse tree
	 */
	void enterNumeral(prologParser.NumeralContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#numeral}.
	 * @param ctx the parse tree
	 */
	void exitNumeral(prologParser.NumeralContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#character}.
	 * @param ctx the parse tree
	 */
	void enterCharacter(prologParser.CharacterContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#character}.
	 * @param ctx the parse tree
	 */
	void exitCharacter(prologParser.CharacterContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#special}.
	 * @param ctx the parse tree
	 */
	void enterSpecial(prologParser.SpecialContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#special}.
	 * @param ctx the parse tree
	 */
	void exitSpecial(prologParser.SpecialContext ctx);
	/**
	 * Enter a parse tree produced by {@link prologParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(prologParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link prologParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(prologParser.StringContext ctx);
}