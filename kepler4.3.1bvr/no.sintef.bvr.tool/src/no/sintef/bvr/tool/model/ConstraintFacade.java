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
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.UserInputError;
import no.sintef.ict.splcatool.BCLPrettyPrinter;
import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.BVRModel;
import bvr.BvrFactory;
import bvr.TargetRef;
import bvr.VNode;


public class ConstraintFacade {
	private static int constraintCount = 0;
	private static final String defaultName = "Constraint";
	private static final String defaultText = "[null]";
	
	public static ConstraintFacade eINSTANCE = getInstance();
	
	private static ConstraintFacade getInstance() {
		if(eINSTANCE == null)
			eINSTANCE = new ConstraintFacade();
		return eINSTANCE;
	}

	public BCLConstraint createBCLConstraint(VNode node){
		BCLConstraint constraint = BvrFactory.eINSTANCE.createBCLConstraint();
		constraint.setName(defaultName+constraintCount);
		constraintCount++;
		
		TargetRef ref = BvrFactory.eINSTANCE.createTargetRef();
		ref.setTarget(null);		
		constraint.getExpression().add(ref);
		
		Context.eINSTANCE.getEditorCommands().addBCLConstraintVNode(node, constraint);
		return constraint;
	}
	
	public void updateBCLConstraint(BVRModel model, BCLConstraint constraint, String rawConstraint){
		if(rawConstraint.equals(defaultText) || rawConstraint.equals(""))
			return;
		
		try {
			RuleNode root = parseBCL(rawConstraint);
			BCLExpression expression = new BCLBuilder(new BVRToolBCLBuilderStrategy()).recurse(root, 0, model, false);
			Context.eINSTANCE.getEditorCommands().clearBCLConstraintExpressions(constraint);
			Context.eINSTANCE.getEditorCommands().addBCLExpressionConstraint(constraint, expression);
		} catch (UnsupportedOperationException e) {
			throw new UserInputError("Failed to parse the constraint: '" + rawConstraint + "' reason: " + e.getMessage());
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

	public String getBCLConstraintString(BVRModel rootBVRModel, BCLConstraint constraint) {
		String text = defaultText;
		if(constraint != null && constraint.getExpression().size() != 0)
			text = new BCLPrettyPrinter().prettyPrint(constraint.getExpression().get(0), rootBVRModel);
		return text;
	}

	public String formatConstraintString(String s, int length) {
		String n = "";

		for(;;){
			if(s.length() < length){
				n += s;
				break;
			}
			int ws = s.substring(length).indexOf(" ");
			if(ws == -1){
				n += s;
				break;
			}else{
				ws += length;
				n += s.substring(0, ws).trim() + "\n";
				s = s.substring(ws).trim();
			}
		}
		return n;
	}
}
