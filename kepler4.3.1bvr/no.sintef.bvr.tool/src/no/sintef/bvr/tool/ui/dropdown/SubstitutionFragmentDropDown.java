package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.ui.command.event.ClearSelectionRelalizationEvent;
import no.sintef.bvr.tool.ui.command.event.CreatePlacementFragmentEvent;
import no.sintef.bvr.tool.ui.command.event.CreateReplacementFragmentEvent;
import no.sintef.bvr.tool.ui.loader.BVRView;

public class SubstitutionFragmentDropDown extends JPopupMenu {

	private static final long serialVersionUID = 1L;
	
    public SubstitutionFragmentDropDown(BVRView _view){

    	
		JMenuItem createPlacment = new JMenuItem(Constants.REALIZATION_CR_PLCMT_NAME);
		createPlacment.addActionListener(new CreatePlacementFragmentEvent(_view));
		add(createPlacment);
		
		JMenuItem createReplacment = new JMenuItem(Constants.REALIZATION_CR_RPLCMT_NAME);
		createReplacment.addActionListener(new CreateReplacementFragmentEvent(_view));
		add(createReplacment);
		
		add(new JSeparator());
		
		JMenuItem clearSelection = new JMenuItem(Constants.REALIZATION_CLEAR_SELECTION_NAME);
		clearSelection.addActionListener(new ClearSelectionRelalizationEvent(_view));
		add(clearSelection);
		
    }
}
