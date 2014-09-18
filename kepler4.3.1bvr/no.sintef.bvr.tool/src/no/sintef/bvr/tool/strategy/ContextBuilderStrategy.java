package no.sintef.bvr.tool.strategy;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.primitive.SymbolTableEObject;


public interface ContextBuilderStrategy {

		public void testEObject(EObject parent, EObject child);
		
		public void reset();
		
		public SymbolTableEObject getRootScope();
}
