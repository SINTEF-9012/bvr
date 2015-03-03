// Generated from BCL.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BCLParser}.
 */
public interface BCLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BCLParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(BCLParser.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link BCLParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(BCLParser.ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link BCLParser#expLogIff}.
	 * @param ctx the parse tree
	 */
	void enterExpLogIff(BCLParser.ExpLogIffContext ctx);
	/**
	 * Exit a parse tree produced by {@link BCLParser#expLogIff}.
	 * @param ctx the parse tree
	 */
	void exitExpLogIff(BCLParser.ExpLogIffContext ctx);
	/**
	 * Enter a parse tree produced by {@link BCLParser#expLogImplies}.
	 * @param ctx the parse tree
	 */
	void enterExpLogImplies(BCLParser.ExpLogImpliesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BCLParser#expLogImplies}.
	 * @param ctx the parse tree
	 */
	void exitExpLogImplies(BCLParser.ExpLogImpliesContext ctx);
	/**
	 * Enter a parse tree produced by {@link BCLParser#expLogOr}.
	 * @param ctx the parse tree
	 */
	void enterExpLogOr(BCLParser.ExpLogOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link BCLParser#expLogOr}.
	 * @param ctx the parse tree
	 */
	void exitExpLogOr(BCLParser.ExpLogOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link BCLParser#expLogAnd}.
	 * @param ctx the parse tree
	 */
	void enterExpLogAnd(BCLParser.ExpLogAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link BCLParser#expLogAnd}.
	 * @param ctx the parse tree
	 */
	void exitExpLogAnd(BCLParser.ExpLogAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link BCLParser#expLogUn}.
	 * @param ctx the parse tree
	 */
	void enterExpLogUn(BCLParser.ExpLogUnContext ctx);
	/**
	 * Exit a parse tree produced by {@link BCLParser#expLogUn}.
	 * @param ctx the parse tree
	 */
	void exitExpLogUn(BCLParser.ExpLogUnContext ctx);
	/**
	 * Enter a parse tree produced by {@link BCLParser#expRel}.
	 * @param ctx the parse tree
	 */
	void enterExpRel(BCLParser.ExpRelContext ctx);
	/**
	 * Exit a parse tree produced by {@link BCLParser#expRel}.
	 * @param ctx the parse tree
	 */
	void exitExpRel(BCLParser.ExpRelContext ctx);
	/**
	 * Enter a parse tree produced by {@link BCLParser#expPlusMin}.
	 * @param ctx the parse tree
	 */
	void enterExpPlusMin(BCLParser.ExpPlusMinContext ctx);
	/**
	 * Exit a parse tree produced by {@link BCLParser#expPlusMin}.
	 * @param ctx the parse tree
	 */
	void exitExpPlusMin(BCLParser.ExpPlusMinContext ctx);
	/**
	 * Enter a parse tree produced by {@link BCLParser#expMulDiv}.
	 * @param ctx the parse tree
	 */
	void enterExpMulDiv(BCLParser.ExpMulDivContext ctx);
	/**
	 * Exit a parse tree produced by {@link BCLParser#expMulDiv}.
	 * @param ctx the parse tree
	 */
	void exitExpMulDiv(BCLParser.ExpMulDivContext ctx);
	/**
	 * Enter a parse tree produced by {@link BCLParser#expAriUnary}.
	 * @param ctx the parse tree
	 */
	void enterExpAriUnary(BCLParser.ExpAriUnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BCLParser#expAriUnary}.
	 * @param ctx the parse tree
	 */
	void exitExpAriUnary(BCLParser.ExpAriUnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BCLParser#expterm}.
	 * @param ctx the parse tree
	 */
	void enterExpterm(BCLParser.ExptermContext ctx);
	/**
	 * Exit a parse tree produced by {@link BCLParser#expterm}.
	 * @param ctx the parse tree
	 */
	void exitExpterm(BCLParser.ExptermContext ctx);
	/**
	 * Enter a parse tree produced by {@link BCLParser#vspec}.
	 * @param ctx the parse tree
	 */
	void enterVspec(BCLParser.VspecContext ctx);
	/**
	 * Exit a parse tree produced by {@link BCLParser#vspec}.
	 * @param ctx the parse tree
	 */
	void exitVspec(BCLParser.VspecContext ctx);
	/**
	 * Enter a parse tree produced by {@link BCLParser#literalexp}.
	 * @param ctx the parse tree
	 */
	void enterLiteralexp(BCLParser.LiteralexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BCLParser#literalexp}.
	 * @param ctx the parse tree
	 */
	void exitLiteralexp(BCLParser.LiteralexpContext ctx);
}