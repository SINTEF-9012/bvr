package no.sintef.bvr.tool.visitor;

import no.sintef.bvr.tool.primitive.SymbolNamedElement;

public interface NodeVisitor {
	
	void visitNamedElement(SymbolNamedElement element);

}
