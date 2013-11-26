package org.bangbangbang.cvl.resolution.editors.listeners;

import org.bangbangbang.cvl.ChoiceResolutuion;
import org.bangbangbang.cvl.CvlPackage;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;

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