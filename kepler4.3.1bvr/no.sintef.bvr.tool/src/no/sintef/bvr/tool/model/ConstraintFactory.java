package no.sintef.bvr.tool.model;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.RuleNode;

import no.sintef.bvr.constraints.bcl.BCLBuilder;
import no.sintef.bvr.constraints.bcl.BCLLexer;
import no.sintef.bvr.constraints.bcl.BCLParser;
import no.sintef.bvr.constraints.strategy.BVRToolBCLBuilderStrategy;
import no.sintef.bvr.engine.error.UnexpectedOperationFailure;
import no.sintef.bvr.tool.context.Context;
import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.BVRModel;
import bvr.BvrFactory;
import bvr.TargetRef;
import bvr.VNode;


public class ConstraintFactory {
	private static int constraintCount = 0;
	private static String defaultName = "Constraint";
	
	public static ConstraintFactory eINSTANCE = getInstance();
	
	private static ConstraintFactory getInstance() {
		if(eINSTANCE == null)
			eINSTANCE = new ConstraintFactory();
		return eINSTANCE;
	}

	public BCLConstraint createBCLConstraint(VNode node){
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		c.setName(defaultName+constraintCount);
		constraintCount++;
		
		TargetRef ref = BvrFactory.eINSTANCE.createTargetRef();
		ref.setTarget(null);		
		c.getExpression().add(ref);
		
		Context.eINSTANCE.getEditorCommands().addBCLConstraintVNode(node, c);
		return c;
	}
	
	public void updateBCLConstraint(BVRModel model, BCLConstraint constraint, String rawConstraint){
		try {
			RuleNode root = parseBCL(rawConstraint);
			BCLExpression expression = new BCLBuilder(new BVRToolBCLBuilderStrategy()).recurse(root, 0, model, false);
			Context.eINSTANCE.getEditorCommands().clearBCLConstraintExpressions(constraint);
			Context.eINSTANCE.getEditorCommands().addBCLExpressionConstraint(constraint, expression);
		} catch (UnsupportedOperationException e) {
			throw new UnexpectedOperationFailure("Failed to parse the constraint: '" + rawConstraint + "' reason: " + e.getMessage());
		}
	}
	
	private RuleNode parseBCL(String s){
		CharStream input = new ANTLRInputStream(s);
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		RuleNode root = parser.constraint().getRuleContext();
		return root;
	}
}
