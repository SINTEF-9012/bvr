package no.sintef.cvl.table.resolution.editors.listeners;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Control;

/**
 * This listener handle change event of models and notify to the table viewer
 * When model is changed by outside editor
 * 
 * @author daisuke
 */
public final class TableNotifyChangedListener implements INotifyChangedListener {
	TableViewer selectionViewer;
	AdapterFactoryEditingDomain editingDomain;

	public TableNotifyChangedListener(TableViewer viewer,
			AdapterFactoryEditingDomain ed) {
		selectionViewer = viewer;
		editingDomain = ed;
	}

	@Override
	public void notifyChanged(Notification temp) {
		final Notification notification = temp;
		Control control = selectionViewer.getControl();
		if ((control != null) && !(control.isDisposed())) {
			control.getDisplay().syncExec(new Runnable() {
				public void run() {
					selectionViewer.refresh();
				}
			});
		}

	}
}