package no.sintef.bvr.tool.visitor;

import no.sintef.bvr.tool.primitive.SymbolEObject;

public interface NodeVisitor {
	
	void visitNamedElement(SymbolEObject element);

}
