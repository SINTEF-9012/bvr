package no.sintef.cvl.ui.strategies.impl;

import javax.swing.JOptionPane;

import no.sintef.cvl.ui.common.Messages;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.strategies.SelectionStrategy;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchWindow;

public class GetSelectionContext {
	
	private IWorkbenchWindow workbenchWindow;
	private SelectionStrategy defaultStrategy;

	public GetSelectionContext(IWorkbenchWindow workbenchWindow){
		this.workbenchWindow = workbenchWindow;
		this.defaultStrategy = new ContainmentSelectionStrategy();
	}
	
	public GetSelectionContext(IWorkbenchWindow workbenchWindow, SelectionStrategy selectStrategy){
		this.workbenchWindow = workbenchWindow;
		this.defaultStrategy = selectStrategy;
	}
	
	public EList<EObject> getSelectedObjects() throws AbstractError{
		if(workbenchWindow == null){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_NON_ECLIPSE_DETECTED);
			return new BasicEList<EObject>();
		}
		EList<EObject> objects = this.defaultStrategy.getSelectedObjects(workbenchWindow);
		return objects;
	}

}
