package no.sintef.cvl.ui.strategy.impl;

import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchWindow;

import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.exception.IllegalOperationException;
import no.sintef.cvl.ui.exception.UnexpectedException;
import no.sintef.cvl.ui.common.ThirdpartyEditorSelector;
import no.sintef.cvl.ui.strategy.SelectionStrategy;

public class ContainmentSelectionStrategy implements SelectionStrategy {

	@Override
	public EList<EObject> getSelectedObjects() throws AbstractError {
		ThirdpartyEditorSelector unifiedSelector = ThirdpartyEditorSelector.getEditorSelector();
		
		EList<EObject> selected = new BasicEList<EObject>();
		List<Object> selections = unifiedSelector.getSelections();
		for(Object object: selections){
			EObject eObject = unifiedSelector.getEObject(object);
			if(eObject == null)
				throw new UnexpectedException("no model element is found from a given selection");
			if(eObject.eContainer() == null)
				throw new IllegalOperationException("selected object is not contained anywhere or simply a top most element, not allowed yet " + eObject);
			selected.add(eObject);
		}
		
		EList<EObject> selectedObjects = this.includeContainedElements(selected);
		return selectedObjects;
	}
	
	private EList<EObject> includeContainedElements(EList<EObject> eObjects){
		HashSet<EObject> set = new HashSet<EObject>();
		for(EObject eObject : eObjects){
			set.add(eObject);
			for(TreeIterator<EObject> iterator = eObject.eAllContents(); iterator.hasNext();){
				EObject eObj = iterator.next();
				set.add(eObj);
			}
		}
		return new BasicEList<EObject>(set);
	}
}
