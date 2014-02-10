package org.bangbangbang.cvl.system.vspec.custom.relation;

import org.bangbangbang.cvl.Choice;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
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
				// Get Target Choice instance
				Choice choice = null;
				if (object instanceof Choice) {
					choice = (Choice) object;
				}
				// Get uri
				URI uri = EcoreUtil.getURI(choice).trimFragment();
				
				// Dialog creation
				RelationFormDialog dialog = new RelationFormDialog(PlatformUI
						.getWorkbench().getActiveWorkbenchWindow().getShell());
				dialog.setChoice(choice);
				dialog.setURI(uri);
				
				dialog.open();

				return null;
			}
		};
	}

}