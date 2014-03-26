package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.ui.command.event.ClearSelectionRelalizationEvent;
import no.sintef.bvr.tool.ui.command.event.CreateFragmentSubstitutionEvent;
import no.sintef.bvr.tool.ui.loader.BVRView;

public class FragmentSubstitutionDropDown extends JPopupMenu {

	private static final long serialVersionUID = 1L;
	
    public FragmentSubstitutionDropDown(BVRView _view){
		JMenuItem createFragmentSubstitution = new JMenuItem(Constants.REALIZATION_CR_FS_NAME);
		createFragmentSubstitution.addActionListener(new CreateFragmentSubstitutionEvent(_view));
		add(createFragmentSubstitution);
    	
    	add(new JSeparator());
		JMenuItem clearSelection = new JMenuItem(Constants.REALIZATION_CLEAR_SELECTION_NAME);
		clearSelection.addActionListener(new ClearSelectionRelalizationEvent(_view));
		add(clearSelection);
    }
}
