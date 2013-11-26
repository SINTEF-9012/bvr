package org.bangbangbang.cvl.resolution.editors.listeners;

import java.util.Iterator;

import org.bangbangbang.cvl.ChoiceResolutuion;
import org.bangbangbang.cvl.ConfigurableUnit;
import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.VSpecResolution;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.jface.viewers.CheckboxTreeViewer;

/**
 * This listener handle change event of models and notify to the tree viewer
 * When model is changed by property view or Ctrl+Z, change tree view
 * 
 * @author daisuke
 */
public final class CheckBoxNotifyChangedListener implements
		INotifyChangedListener {
	CheckboxTreeViewer selectionViewer;
	AdapterFactoryEditingDomain editingDomain;

	public CheckBoxNotifyChangedListener(CheckboxTreeViewer viewer,
			AdapterFactoryEditingDomain ed) {
		selectionViewer = viewer;
		editingDomain = ed;
	}

	@Override
	public void notifyChanged(Notification notification) {
		selectionViewer.refresh();

		// for Change ChoiceResolution.decision from property
		// view or Ctrl+Z
		if (notification.getNotifier() instanceof ChoiceResolutuion
				&& (notification.getEventType() == Notification.SET || notification
						.getEventType() == Notification.UNSET)) {
			selectionViewer.setChecked(notification.getNotifier(),
					((ChoiceResolutuion) notification.getNotifier())
							.isDecision());
			// Spread to the child which is isImpliedParent
			for (Iterator<VSpecResolution> iterator = ((ChoiceResolutuion) notification
					.getNotifier()).getChild().iterator(); iterator.hasNext();) {
				VSpecResolution element = iterator.next();
				if (element instanceof ChoiceResolutuion
						&& ((ChoiceResolutuion) element).getResolvedChoice()
								.isIsImpliedByParent()) {
					if (((ChoiceResolutuion) notification.getNotifier())
							.isDecision() != ((ChoiceResolutuion) element)
							.isDecision()) {
						Command setCommand = SetCommand
								.create(editingDomain,
										(ChoiceResolutuion) element,
										CvlPackage.eINSTANCE
												.getChoiceResolutuion_Decision(),
										((ChoiceResolutuion) notification
												.getNotifier()).isDecision());
						editingDomain.getCommandStack().execute(setCommand);
					}
				}
			}

		}

		// for Add VSpecResolution as template
		else if (notification.getEventType() == Notification.ADD
				&& notification.getNewValue() instanceof VSpecResolution) {
			VSpecResolution element = (VSpecResolution) notification
					.getNewValue();
			if (element instanceof ChoiceResolutuion) {
				selectionViewer.setChecked(element,
						((ChoiceResolutuion) element).isDecision());
			} else if (element instanceof VSpecResolution
					|| element instanceof ConfigurableUnit) {
				selectionViewer.setGrayChecked(element, true);
			}
		}
	}
}