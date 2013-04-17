// Generated from TestData/BCL.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface BCLListener extends ParseTreeListener {
	void enterExpPlusMin(BCLParser.ExpPlusMinContext ctx);
	void exitExpPlusMin(BCLParser.ExpPlusMinContext ctx);

	void enterOpUnLog(BCLParser.OpUnLogContext ctx);
	void exitOpUnLog(BCLParser.OpUnLogContext ctx);

	void enterLiteralexp(BCLParser.LiteralexpContext ctx);
	void exitLiteralexp(BCLParser.LiteralexpContext ctx);

	void enterConstraint(BCLParser.ConstraintContext ctx);
	void exitConstraint(BCLParser.ConstraintContext ctx);

	void enterOpUnAri(BCLParser.OpUnAriContext ctx);
	void exitOpUnAri(BCLParser.OpUnAriContext ctx);

	void enterExpMulDiv(BCLParser.ExpMulDivContext ctx);
	void exitExpMulDiv(BCLParser.ExpMulDivContext ctx);

	void enterOpAriPlusMinus(BCLParser.OpAriPlusMinusContext ctx);
	void exitOpAriPlusMinus(BCLParser.OpAriPlusMinusContext ctx);

	void enterOpLog(BCLParser.OpLogContext ctx);
	void exitOpLog(BCLParser.OpLogContext ctx);

	void enterExpterm(BCLParser.ExptermContext ctx);
	void exitExpterm(BCLParser.ExptermContext ctx);

	void enterExpLog(BCLParser.ExpLogContext ctx);
	void exitExpLog(BCLParser.ExpLogContext ctx);

	void enterExpRel(BCLParser.ExpRelContext ctx);
	void exitExpRel(BCLParser.ExpRelContext ctx);

	void enterOpDef(BCLParser.OpDefContext ctx);
	void exitOpDef(BCLParser.OpDefContext ctx);

	void enterVspec(BCLParser.VspecContext ctx);
	void exitVspec(BCLParser.VspecContext ctx);

	void enterExpAriUnary(BCLParser.ExpAriUnaryContext ctx);
	void exitExpAriUnary(BCLParser.ExpAriUnaryContext ctx);

	void enterOpRel(BCLParser.OpRelContext ctx);
	void exitOpRel(BCLParser.OpRelContext ctx);

	void enterOpAriMulDiv(BCLParser.OpAriMulDivContext ctx);
	void exitOpAriMulDiv(BCLParser.OpAriMulDivContext ctx);
}