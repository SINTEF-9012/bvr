package no.sintef.cvl.ui.strategies;

import no.sintef.cvl.ui.exceptions.AbstractError;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchWindow;

public interface SelectionStrategy {

	EList<EObject> getSelectedObjects() throws AbstractError;
}
