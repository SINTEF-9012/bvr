package no.sintef.bvr.ui.editor.commands;


import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;

import bvr.BvrPackage;
import bvr.Choice;
import bvr.ChoiceResolutuion;
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
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpec(), choice);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addChoice(Choice choice, VSpec vs) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, vs, BvrPackage.eINSTANCE.getVSpec_Child(), choice);
		editingDomain.getCommandStack().execute(cmd);
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

	@Override
	public void createNewResolution(ChoiceResolutuion cr, ConfigurableUnit cu) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpecResolution(), cr);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void setResolutionDecision(ChoiceResolutuion cr, boolean decision) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = new SetCommand(editingDomain, cr, BvrPackage.eINSTANCE.getChoiceResolutuion_Decision(), decision);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void setChoiceResolvedVSpec(ChoiceResolutuion cr, Choice choice) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, cr, BvrPackage.eINSTANCE.getChoiceResolutuion_ResolvedChoice(), choice);
		editingDomain.getCommandStack().execute(cmd);
	}

}
