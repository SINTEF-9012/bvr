package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import bvr.FragmentSubstitution;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRRealizationUIKernelInterface;
import no.sintef.bvr.tool.ui.editor.BindingJTable;
import no.sintef.bvr.tool.ui.model.BindingTableModel;


public class DeleteBindingAllEvent implements ActionListener {

	private BVRNotifiableController view;

	public DeleteBindingAllEvent(BVRNotifiableController _view){
		view = _view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BVRRealizationUIKernelInterface kernel = view.getRealizationControllerInterface().getUIKernel();
		BindingJTable jtable = (BindingJTable) kernel.getBindingTable();
		BindingTableModel model = (BindingTableModel) jtable.getModel();
		FragmentSubstitution fragmentSubstitution = model.getFragmentSubstitution();
		if(fragmentSubstitution == null){
			JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), Messages.DIALOG_MSG_NO_FRAG_SUB_DETECTED);
			return;
		}
		
		if(fragmentSubstitution.getBoundaryElementBinding().size() != 0)
			Context.eINSTANCE.getEditorCommands().clearBoudaryElementBindings(fragmentSubstitution);
	}

}
