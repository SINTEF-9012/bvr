package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.event.ClearSelectionRelalizationEvent;
import no.sintef.bvr.tool.ui.command.event.CreateFragmentSubstitutionEvent;

public class FragmentSubstitutionDropDown extends JPopupMenu {

	private static final long serialVersionUID = 1L;
	protected BVRNotifiableController controller;
	
    public FragmentSubstitutionDropDown(BVRNotifiableController _controller){
    	controller = _controller;
    	
		JMenuItem createFragmentSubstitution = new JMenuItem(Constants.REALIZATION_CR_FS_NAME);
		createFragmentSubstitution.addActionListener(new CreateFragmentSubstitutionEvent(controller));
		add(createFragmentSubstitution);
    	
    	add(new JSeparator());
		JMenuItem clearSelection = new JMenuItem(Constants.REALIZATION_CLEAR_SELECTION_NAME);
		clearSelection.addActionListener(new ClearSelectionRelalizationEvent(controller));
		add(clearSelection);
    }
}
