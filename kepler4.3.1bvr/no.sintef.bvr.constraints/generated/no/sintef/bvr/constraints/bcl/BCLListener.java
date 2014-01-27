package no.sintef.bvr.constraints.bcl;
// Generated from TestData/BCL.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface BCLListener extends ParseTreeListener {
	void enterExpPlusMin(BCLParser.ExpPlusMinContext ctx);
	void exitExpPlusMin(BCLParser.ExpPlusMinContext ctx);

	void enterLiteralexp(BCLParser.LiteralexpContext ctx);
	void exitLiteralexp(BCLParser.LiteralexpContext ctx);

	void enterConstraint(BCLParser.ConstraintContext ctx);
	void exitConstraint(BCLParser.ConstraintContext ctx);

	void enterExpMulDiv(BCLParser.ExpMulDivContext ctx);
	void exitExpMulDiv(BCLParser.ExpMulDivContext ctx);

	void enterExpLogImplies(BCLParser.ExpLogImpliesContext ctx);
	void exitExpLogImplies(BCLParser.ExpLogImpliesContext ctx);

	void enterExpLogOr(BCLParser.ExpLogOrContext ctx);
	void exitExpLogOr(BCLParser.ExpLogOrContext ctx);

	void enterExpterm(BCLParser.ExptermContext ctx);
	void exitExpterm(BCLParser.ExptermContext ctx);

	void enterExpLogIff(BCLParser.ExpLogIffContext ctx);
	void exitExpLogIff(BCLParser.ExpLogIffContext ctx);

	void enterExpRel(BCLParser.ExpRelContext ctx);
	void exitExpRel(BCLParser.ExpRelContext ctx);

	void enterExpLogUn(BCLParser.ExpLogUnContext ctx);
	void exitExpLogUn(BCLParser.ExpLogUnContext ctx);

	void enterExpLogAnd(BCLParser.ExpLogAndContext ctx);
	void exitExpLogAnd(BCLParser.ExpLogAndContext ctx);

	void enterVspec(BCLParser.VspecContext ctx);
	void exitVspec(BCLParser.VspecContext ctx);

	void enterExpAriUnary(BCLParser.ExpAriUnaryContext ctx);
	void exitExpAriUnary(BCLParser.ExpAriUnaryContext ctx);
}