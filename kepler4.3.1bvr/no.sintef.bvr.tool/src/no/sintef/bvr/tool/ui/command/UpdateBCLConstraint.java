package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.RuleNode;

import no.sintef.bvr.constraints.bcl.BCLBuilder;
import no.sintef.bvr.constraints.bcl.BCLLexer;
import no.sintef.bvr.constraints.bcl.BCLParser;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.NamedElement;
import bvr.Variable;

public class UpdateBCLConstraint extends UpdateVSpec {

	private String text;
	private BCLConstraint bcl;

	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		this.bcl = (BCLConstraint)p;
		return super.init(rootPanel, p, parent, vmMap, nodes, bindings, view);
	}

	@Override
	public JComponent execute() {
		//System.out.println("Update BCL Constraint!! to " + text);
		
		//RuleNode root = parseBCL(text);
		//BCLExpression e = new BCLBuilder().recurse(root, 0, view.getBVRModel(), false);
		//Context.eINSTANCE.getEditorCommands().clearBCLConstraintExpressions(bcl);
		//Context.eINSTANCE.getEditorCommands().addBCLExpressionConstraint(bcl, e);
		//bcl.getExpression().clear();
		//bcl.getExpression().add(e);
		
		
		//view.notifyVspecViewUpdate();
		return null;
	}

	private RuleNode parseBCL(String s){
		CharStream input = new ANTLRInputStream(s);
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		RuleNode root = parser.constraint().getRuleContext();
		return root;
	}

	public void setConstraint(String text) {
		this.text = text;  
	}

	@Override
	public void setVariable(Variable v, String name, String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setComment(String text) {
		// TODO Auto-generated method stub
		
	}

}
