package org.bangbangbang.cvl.system.vspec.custom.relation;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

public class RelationPropertyDescriptor extends PropertyDescriptor {

	public RelationPropertyDescriptor(Object id,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(id, itemPropertyDescriptor);

	}

	@Override
	public CellEditor createPropertyEditor(Composite parent) {
		return new ExtendedDialogCellEditor(parent, getLabelProvider()) {
			@Override
			protected Object openDialogBox(Control cellEditorWindow) {

				// Dialog creation
				// ConstraintDialog dialog = new ConstraintDialog(PlatformUI
				// .getWorkbench().getModalDialogShellProvider(),
				// (OpaqueConstraint) object);
				MessageDialog.openQuestion(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(), "Test",
						"Is it ok?");
				// dialog.setText((String) this.getValue());

				return null;
			}
		};
	}

}