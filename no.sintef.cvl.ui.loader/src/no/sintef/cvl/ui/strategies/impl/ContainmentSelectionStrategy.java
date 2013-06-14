package no.sintef.cvl.ui.strategies.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;

import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.exceptions.UnexpectedException;
import no.sintef.cvl.ui.common.UnifiedModelSelector;
import no.sintef.cvl.ui.strategies.SelectionStrategy;

public class ContainmentSelectionStrategy implements SelectionStrategy {

	@Override
	public EList<EObject> getSelectedObjects(IWorkbenchWindow workbenchWindow) throws AbstractError {
		UnifiedModelSelector unifiedSelector = new UnifiedModelSelector(workbenchWindow); 
		ISelection selection = workbenchWindow.getActivePage().getActiveEditor().getSite().getSelectionProvider().getSelection();
		
		StructuredSelection structuredSelection = (StructuredSelection) selection;
		EList<EObject> selected = new BasicEList<EObject>();
		for(Object object: structuredSelection.toList()){
			EObject eObject = unifiedSelector.getEObject(object);
			if(eObject == null){
				throw new UnexpectedException("no model element is found from a given selection");
			}
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
