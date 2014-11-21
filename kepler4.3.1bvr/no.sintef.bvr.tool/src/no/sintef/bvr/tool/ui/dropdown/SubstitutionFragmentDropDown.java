package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.event.ClearSelectionRelalizationEvent;
import no.sintef.bvr.tool.ui.command.event.CreatePlacementFragmentEvent;
import no.sintef.bvr.tool.ui.command.event.CreateReplacementFragmentEvent;

public class SubstitutionFragmentDropDown extends JPopupMenu {

	private static final long serialVersionUID = 1L;
	protected BVRNotifiableController controller;
	
    public SubstitutionFragmentDropDown(BVRNotifiableController _controller){
    	controller = _controller; 
    			
		JMenuItem createPlacment = new JMenuItem(Constants.REALIZATION_CR_PLCMT_NAME);
		createPlacment.addActionListener(new CreatePlacementFragmentEvent(controller, true));
		add(createPlacment);
		
	
		JMenuItem createReplacment = new JMenuItem(Constants.REALIZATION_CR_RPLCMT_NAME);
		createReplacment.addActionListener(new CreateReplacementFragmentEvent(controller, true));
		add(createReplacment);
		
		add(new JSeparator());
		
		JMenuItem createPlacmentCntLess = new JMenuItem(Constants.REALIZATION_CR_PLCMT_CNTLESS_NAME);
		createPlacmentCntLess.addActionListener(new CreatePlacementFragmentEvent(controller, false));
		add(createPlacmentCntLess);
		
	
		JMenuItem createReplacmentCntLess = new JMenuItem(Constants.REALIZATION_CR_RPLCMT_CNTLESS_NAME);
		createReplacmentCntLess.addActionListener(new CreateReplacementFragmentEvent(controller, false));
		add(createReplacmentCntLess);
		
		add(new JSeparator());
		
		JMenuItem clearSelection = new JMenuItem(Constants.REALIZATION_CLEAR_SELECTION_NAME);
		clearSelection.addActionListener(new ClearSelectionRelalizationEvent(controller));
		add(clearSelection);
		
    }
}
