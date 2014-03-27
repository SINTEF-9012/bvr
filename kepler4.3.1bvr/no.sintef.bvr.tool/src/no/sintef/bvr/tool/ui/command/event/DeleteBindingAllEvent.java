package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import bvr.FragmentSubstitution;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRRealizationView;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.model.BindingTableModel;


public class DeleteBindingAllEvent implements ActionListener {

	private BVRView view;

	public DeleteBindingAllEvent(BVRView _view){
		view = _view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		BindingTableModel model = (BindingTableModel) ((BVRRealizationView) view).getBindingTable().getModel();
		FragmentSubstitution fragmentSubstitution = model.getFragmentSubstitution();
		if(fragmentSubstitution == null){
			JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), Messages.DIALOG_MSG_NO_FRAG_SUB_DETECTED);
			return;
		}
		
		if(fragmentSubstitution.getBoundaryElementBinding().size() != 0)
			Context.eINSTANCE.getEditorCommands().clearBoudaryElementBindings(fragmentSubstitution);
	}

}
