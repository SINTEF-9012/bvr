package no.sintef.cvl.ui.strategy.impl;

import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.strategy.SelectionStrategy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public class GetSelectionContext {
	
	private SelectionStrategy defaultStrategy;

	public GetSelectionContext(){
		this.defaultStrategy = new ContainmentSelectionStrategy();
	}
	
	public GetSelectionContext(SelectionStrategy selectStrategy){
		this.defaultStrategy = selectStrategy;
	}
	
	public EList<EObject> getSelectedObjects() throws AbstractError{
		EList<EObject> objects = this.defaultStrategy.getSelectedObjects();
		return objects;
	}

}
