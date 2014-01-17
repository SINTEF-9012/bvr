package no.sintef.cvl.table.resolution.editors.listeners;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;

import cvl.ChoiceResolutuion;
import cvl.CvlPackage;

public final class CheckBoxStateListener implements ICheckStateListener {
	CheckboxTreeViewer selectionViewer;
	AdapterFactoryEditingDomain editingDomain;

	public CheckBoxStateListener(CheckboxTreeViewer viewer,
			AdapterFactoryEditingDomain ed) {
		selectionViewer = viewer;
		editingDomain = ed;
	}

	public void checkStateChanged(CheckStateChangedEvent event) {
		if (event.getElement() instanceof ChoiceResolutuion) {
			Command setCommand = SetCommand.create(editingDomain,
					(ChoiceResolutuion) event.getElement(),
					CvlPackage.eINSTANCE.getChoiceResolutuion_Decision(),
					selectionViewer.getChecked(event.getElement()));
			editingDomain.getCommandStack().execute(setCommand);

		}

	}
}