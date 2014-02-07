package no.sintef.bvr.tool.ui.command;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.NamedElement;
import bvr.VSpec;

public class UpdateBCLConstraint extends UpdateVSpec {

	private String text;
	private BCLConstraint bcl;

	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRView view) {
		this.bcl = (BCLConstraint)p;
		return super.init(rootPanel, p, parent, vmMap, nodes, bindings, view);
	}

	@Override
	public JComponent execute() {
		//System.out.println("Update BCL Constraint!! to " + text);
		
		RuleNode root = parseBCL(text);
		BCLExpression e = new BCLBuilder().recurse(root, 0, view.getCU(), false);
		bcl.getExpression().clear();
		bcl.getExpression().add(e);
		
		super.execute();
		view.notifyVspecViewUpdate();
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

}
