package no.sintef.cvl.ui.commands.events;

import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.eclipse.emf.ecore.EObject;

import cvl.ToBinding;

import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.common.ThirdpartyEditorSelector;
import no.sintef.cvl.ui.editors.BindingJTable;
import no.sintef.cvl.ui.models.BindingTableModel;
import no.sintef.cvl.ui.primitives.impl.DataBindingItem;

public class BindingRowSelectionEvent implements ListSelectionListener {

	private BindingJTable table;

	public BindingRowSelectionEvent(BindingJTable jtable){
		table = jtable;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		BindingTableModel model = (BindingTableModel) table.getModel();
		ArrayList<ArrayList<Object>> data = model.getData();
		DataBindingItem bindingCell = (DataBindingItem) data.get(0).get(Constants.BINDING_TYPE_CLMN);
		ToBinding toBinding = (ToBinding) bindingCell.getNamedElement();
		EObject eObject = toBinding.getToPlacement().getOutsideBoundaryElement().getMOFRef();
		ThirdpartyEditorSelector.getEditorSelector().highlightObject(eObject, 0);
	}

}
