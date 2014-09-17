package no.sintef.bvr.tool.visitor;

import java.util.Arrays;
import java.util.HashSet;

import no.sintef.bvr.tool.primitive.SymbolNamedElement;
import no.sintef.bvr.tool.rule.Rule;
import no.sintef.bvr.tool.rule.SymbolVSpecTargetNotNullRule;
import no.sintef.bvr.tool.rule.SymbolVSpecTargetScopeRule;

public class PropertyCheckNodeVisitor extends AbstractNodeVisitor {

	private HashSet<Rule> rulesSymbolNamedElement = new HashSet<Rule>(Arrays.asList(
			new SymbolVSpecTargetNotNullRule(),
			new SymbolVSpecTargetScopeRule()));
	
	@Override
	public void visitNamedElement(SymbolNamedElement element) {
		super.visitNamedElement(element);
		for(Rule rule : rulesSymbolNamedElement)
			rule.execute(element);
		
	}
}
