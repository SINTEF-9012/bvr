package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRRealizationUIKernelInterface;
import no.sintef.bvr.tool.ui.command.event.DeletePlacementReplacementFragmentEvent;
import no.sintef.bvr.tool.ui.editor.SubstitutionFragmentJTable;

public class SubstitutionFragmentTableDropDown extends
		SubstitutionFragmentDropDown {

	private static final long serialVersionUID = 4816222671270004432L;
	
	public SubstitutionFragmentTableDropDown(BVRNotifiableController _controller) {
		super(_controller);
		BVRRealizationUIKernelInterface kenrel = controller.getRealizationControllerInterface().getUIKernel();
		SubstitutionFragmentJTable jtable = (SubstitutionFragmentJTable) kenrel.getSubsitutionFragmentTable();
		if(jtable.getSelectedRows().length != 0){
			add(new JSeparator());
		
			JMenuItem deletePlacementReplacement = new JMenuItem(Constants.REALIZATION_DL_PLCMT_RPLCMT_NAME);
			deletePlacementReplacement.addActionListener(new DeletePlacementReplacementFragmentEvent(controller));
			add(deletePlacementReplacement);
		}
	}
}
