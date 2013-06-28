package no.sintef.cvl.ui.strategy;

import no.sintef.cvl.ui.exception.AbstractError;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchWindow;

public interface SelectionStrategy {

	EList<EObject> getSelectedObjects() throws AbstractError;
}
