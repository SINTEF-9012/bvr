package org.bangbangbang.cvl.system.vspec.custom.relation;

import org.bangbangbang.cvl.VClassifier;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

public class ContextPropertyDescriptor extends PropertyDescriptor {

	public ContextPropertyDescriptor(Object id,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(id, itemPropertyDescriptor);

	}

	@Override
	public CellEditor createPropertyEditor(Composite parent) {
		return new ExtendedDialogCellEditor(parent, getLabelProvider()) {
			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
				// Get Target Choice instance
				VClassifier vclassifier = null;
				if (object instanceof VClassifier) {
					vclassifier = (VClassifier) object;
				}
				// Get uri
				URI uri = EcoreUtil.getURI(vclassifier).trimFragment();

				// Dialog creation
				ContextFormDialog dialog = new ContextFormDialog(PlatformUI
						.getWorkbench().getActiveWorkbenchWindow().getShell());
				dialog.setVClassifier(vclassifier);
				dialog.setURI(uri);

				dialog.open();

				return null;
			}
		};
	}

}