package no.sintef.bvr.tool.rule;

import bvr.Target;
import bvr.VSpec;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.Symbol;
import no.sintef.bvr.tool.primitive.SymbolEObject;
import no.sintef.bvr.tool.primitive.impl.SymbolCompoundNode;

public class SymbolVSpecTargetNotNullRule implements SymbolRule {
	
	@Override
	public void execute(Symbol symbol) {
		if(!(symbol instanceof SymbolCompoundNode && ((SymbolEObject) symbol).getSymbol() instanceof VSpec))
			return;
		VSpec vSpec = (VSpec) ((SymbolEObject) symbol).getSymbol();
		Target target = vSpec.getTarget();
		if(target == null)
			Context.eINSTANCE.problemLogger.warn("Target is not set for " + vSpec.toString());
	}

}
