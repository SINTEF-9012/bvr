package no.sintef.bvr.tool.strategy;

import org.eclipse.emf.ecore.EObject;

public interface ModifyNodeStrategy {

	public void modify(EObject eObject);
	
	public boolean accept(EObject eObject);
}
