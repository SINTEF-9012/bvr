package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import bvr.BoundaryElementBinding;
import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.FromReplacement;
import bvr.NamedElement;
import bvr.ToBinding;
import bvr.ToPlacement;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.primitive.impl.DataBindingItem;
import no.sintef.bvr.tool.ui.loader.BVRRealizationView;
import no.sintef.bvr.tool.ui.model.BindingTableModel;

public class DeleteBindingEvent implements ActionListener {

	private BVRNotifiableController view;

	public DeleteBindingEvent(BVRNotifiableController _view){
		view = _view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int[] rowIndexes = ((BVRRealizationView) view).getBindingTable().getSelectedRows();
		BindingTableModel model = (BindingTableModel) ((BVRRealizationView) view).getBindingTable().getModel();
		FragmentSubstitution fragmentSubstitution = model.getFragmentSubstitution();
		if(fragmentSubstitution == null)
			return;
		
		EList<BoundaryElementBinding> list = new BasicEList<BoundaryElementBinding>();
		for(int index : rowIndexes){
			DataBindingItem row = (DataBindingItem) model.getData().get(index).get(Constants.BINDING_TYPE_CLMN);
			NamedElement binding = row.getNamedElement();
			if(binding instanceof ToBinding){
				ToPlacement toPlacement = ((ToBinding) binding).getToPlacement();
				if(toPlacement.getInsideBoundaryElement().size() == 1 && toPlacement.getInsideBoundaryElement().get(0).getMOFRef() == null){
					list.add((BoundaryElementBinding) binding);
				}else{
					int result = JOptionPane.showConfirmDialog(Context.eINSTANCE.getActiveJApplet(), Messages.DIALOG_MSG_BINDING_NOT_DUMMY, Messages.DIALOG_MSG_BINDING_REMOVE_TITLE, JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.NO_OPTION)
						continue;
					list.add((BoundaryElementBinding) binding);
				}
			}
			if(binding instanceof FromBinding){
				FromReplacement fromReplacement = ((FromBinding) binding).getFromReplacement();
				if(fromReplacement.getInsideBoundaryElement().getMOFRef() == null){
					list.add((BoundaryElementBinding) binding);
				}else{
					int result = JOptionPane.showConfirmDialog(Context.eINSTANCE.getActiveJApplet(), Messages.DIALOG_MSG_BINDING_NOT_DUMMY, Messages.DIALOG_MSG_BINDING_REMOVE_TITLE, JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.NO_OPTION)
						continue;
					list.add((BoundaryElementBinding) binding);
				}
			}
		}
		Context.eINSTANCE.getEditorCommands().removeBoudaryElementBindings(fragmentSubstitution, list);
	}

}
