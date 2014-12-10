package no.sintef.bvr.table.resolution.editors.listeners;

import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.swt.widgets.Control;

import bvr.BvrPackage;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.VSpec;
import bvr.VSpecResolution;

/**
 * This listener handle change event of models and notify to the tree viewer
 * When model is changed by property view or Ctrl+Z, change tree view
 * 
 * @author DaisukeShimbara
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
	public void notifyChanged(Notification temp) {
		final Notification notification = temp;
		Control control = selectionViewer.getControl();
		if ((control != null) && !(control.isDisposed())) {
			control.getDisplay().asyncExec(new Runnable() {
				public void run() {
					selectionViewer.refresh();

					// for Change ChoiceResolution.decision from property
					// view or Ctrl+Z
					if (notification.getNotifier() instanceof ChoiceResolutuion
							&& (notification.getEventType() == Notification.SET || notification
									.getEventType() == Notification.UNSET)) {
						selectionViewer.setChecked(
								notification.getNotifier(),
								((ChoiceResolutuion) notification.getNotifier())
										.isDecision());
						// Spread to the child which is isImpliedParent
						for (Iterator<VSpecResolution> iterator = ((ChoiceResolutuion) notification
								.getNotifier()).getChild().iterator(); iterator
								.hasNext();) {
							VSpecResolution element = iterator.next();
							VSpec resolved = null;
							if (element instanceof ChoiceResolutuion
									&& ((ChoiceResolutuion) element)
											.getResolvedChoice() != null) {
								resolved = ((ChoiceResolutuion) element)
										.getResolvedChoice();
							} else if (element instanceof ChoiceResolutuion) {
								resolved = ((ChoiceResolutuion) element)
										.getResolvedVSpec();
							}
							if (element instanceof ChoiceResolutuion
									&& ((Choice) resolved)
											.isIsImpliedByParent()) {
								if (((ChoiceResolutuion) notification
										.getNotifier()).isDecision() != ((ChoiceResolutuion) element)
										.isDecision()) {
									Command setCommand = SetCommand
											.create(editingDomain,
													(ChoiceResolutuion) element,
													BvrPackage.eINSTANCE
															.getChoiceResolutuion_Decision(),
													((ChoiceResolutuion) notification
															.getNotifier())
															.isDecision());
									editingDomain.getCommandStack().execute(
											setCommand);
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
			});
		}
	}
}