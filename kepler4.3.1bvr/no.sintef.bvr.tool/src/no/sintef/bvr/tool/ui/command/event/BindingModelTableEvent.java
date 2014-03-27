package no.sintef.bvr.tool.ui.command.event;

import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.impl.DataBindingItem;
import no.sintef.bvr.tool.primitive.impl.DataBoundaryItem;
import no.sintef.bvr.tool.ui.editor.BindingJTable;
import no.sintef.bvr.tool.ui.model.BindingTableModel;
import bvr.BoundaryElementBinding;
import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.ToBinding;
import bvr.ToReplacement;

public class BindingModelTableEvent implements TableModelListener {


	private BindingJTable jtable;

	public BindingModelTableEvent(BindingJTable table) {
		jtable = table;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		BindingTableModel model = (BindingTableModel) e.getSource();
		ArrayList<ArrayList<Object>> data = model.getData();
		if(TableModelEvent.UPDATE == e.getType()){
			if(e.getLastRow() == e.getFirstRow()){
				int rowIndex = e.getLastRow();
				int columnIndex = e.getColumn();
				DataBindingItem bindingCell = (DataBindingItem) data.get(rowIndex).get(Constants.BINDING_TYPE_CLMN);
				BoundaryElementBinding binding = (BoundaryElementBinding) bindingCell.getNamedElement();
				if(columnIndex == Constants.BINDING_VALUE_CLMN){
					DataBoundaryItem valueCell = (DataBoundaryItem) data.get(rowIndex).get(Constants.BINDING_VALUE_CLMN);
					if(binding instanceof ToBinding){
						ToBinding toBinding = (ToBinding) binding;
						Context.eINSTANCE.getEditorCommands().setToBindingToReplacement(toBinding, (ToReplacement) valueCell.getNamedElement());
					}else if(binding instanceof FromBinding) {
						FromBinding fromBinding = (FromBinding) binding;
						Context.eINSTANCE.getEditorCommands().setFromBindingFromPlacement(fromBinding, (FromPlacement) valueCell.getNamedElement());
					}else{
						throw new UnexpectedException("OMG this should never happen!");
					}
				}else{
					throw new UnsupportedOperationException("edition operaton for this celll is not implemented");
				}
			}
		}

	}

}
