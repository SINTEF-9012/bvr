package no.sintef.bvr.ui.editor.commands;


import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;

import bvr.Choice;
import bvr.ConfigurableUnit;
import bvr.VSpec;

public class EditorEMFTransactionalCommands implements EditorCommands {

	static private EditorEMFTransactionalCommands eINSTANCE = null;
	
	static public EditorEMFTransactionalCommands Get(){
		if(eINSTANCE == null){
			eINSTANCE = new EditorEMFTransactionalCommands();
		}
		return eINSTANCE;
	}
	
	@Override
	public void addChoice(Choice choice, ConfigurableUnit cu) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addChoice(Choice choice, VSpec vs) {
		throw new UnsupportedOperationException();
	}

	@Override
	public TransactionalEditingDomain testTransactionalEditingDomain() {
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain(Constants.EDITOR_DOMAIN); //$NON-NLS-1$
		if (editingDomain == null) {
			editingDomain = DiagramEditingDomainFactory.getInstance()
					.createEditingDomain();
			editingDomain.setID(Constants.EDITOR_DOMAIN); //$NON-NLS-1$
		}
		return editingDomain;
	}

}
