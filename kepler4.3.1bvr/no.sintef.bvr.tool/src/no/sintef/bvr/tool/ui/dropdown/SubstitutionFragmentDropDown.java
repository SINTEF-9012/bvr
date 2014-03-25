package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.ui.command.event.CreatePlacementFragmentEvent;
import no.sintef.bvr.tool.ui.loader.BVRView;

public class SubstitutionFragmentDropDown extends JPopupMenu {

	private static final long serialVersionUID = 1L;
	
	JMenuItem anItem;
    public SubstitutionFragmentDropDown(BVRView _view){
		JMenuItem createPlacment = new JMenuItem(Constants.REALIZATION_CR_PLCMT_NAME);
		createPlacment.addActionListener(new CreatePlacementFragmentEvent(_view));
		
		JMenuItem createReplacment = new JMenuItem(Constants.REALIZATION_CR_RPLCMT_NAME);
		add(createPlacment);
		add(createReplacment);
    }
}
