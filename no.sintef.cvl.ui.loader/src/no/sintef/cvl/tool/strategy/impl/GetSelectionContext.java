package no.sintef.cvl.tool.strategy.impl;

import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.exception.AbstractError;
import no.sintef.cvl.tool.strategy.SelectionStrategy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public class GetSelectionContext {
	
	private SelectionStrategy defaultStrategy;

	public GetSelectionContext(){
		this.defaultStrategy = (Context.eINSTANCE.getConfig().isContainmentSelectionMode()) ?
				new ContainmentSelectionStrategy() : new ContainmentLessSelectionStrategy();
	}
	
	public GetSelectionContext(SelectionStrategy selectStrategy){
		this.defaultStrategy = selectStrategy;
	}
	
	public EList<EObject> getSelectedObjects() throws AbstractError{
		EList<EObject> objects = this.defaultStrategy.getSelectedObjects();
		return objects;
	}

}
