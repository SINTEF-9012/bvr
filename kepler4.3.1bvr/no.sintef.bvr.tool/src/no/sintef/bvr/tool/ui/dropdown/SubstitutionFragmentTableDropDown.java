package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.ui.command.event.DeletePlacementReplacementFragmentEvent;
import no.sintef.bvr.tool.ui.loader.BVRRealizationView;
import no.sintef.bvr.tool.ui.loader.BVRToolView;

public class SubstitutionFragmentTableDropDown extends
		SubstitutionFragmentDropDown {

	private static final long serialVersionUID = 4816222671270004432L;
	
	public SubstitutionFragmentTableDropDown(BVRToolView _view) {
		super(_view);
		BVRRealizationView rView = (BVRRealizationView) _view;
		if(rView.getSubsitutionFragmentTable().getSelectedRows().length != 0){
			add(new JSeparator());
		
			JMenuItem deletePlacementReplacement = new JMenuItem(Constants.REALIZATION_DL_PLCMT_RPLCMT_NAME);
			deletePlacementReplacement.addActionListener(new DeletePlacementReplacementFragmentEvent(_view));
			add(deletePlacementReplacement);
		}
	}
}
