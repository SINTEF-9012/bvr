package org.bangbangbang.cvl.diagram.custom.property;

import org.bangbangbang.cvl.OpaqueConstraint;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

public class ConstraintPropertyDescriptor extends PropertyDescriptor {

	public ConstraintPropertyDescriptor(Object id,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(id, itemPropertyDescriptor);

	}

	@Override
	public CellEditor createPropertyEditor(Composite parent) {
		return new ExtendedDialogCellEditor(parent, getLabelProvider()) {
			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
			
				// Dialog creation
				ConstraintDialog dialog = new ConstraintDialog(PlatformUI
						.getWorkbench().getModalDialogShellProvider(),
						(OpaqueConstraint) object);

				dialog.setText((String) this.getValue());

				// Open the dialog and retrieve the user selection
				int result = dialog.open();
				labelProvider.dispose();
				return result == Window.OK ? dialog.getText() : null;
			}
		};
	}

}
