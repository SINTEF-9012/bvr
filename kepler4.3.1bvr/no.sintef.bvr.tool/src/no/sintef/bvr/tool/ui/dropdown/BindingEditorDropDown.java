package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.event.CreateToBindingEvent;
import no.sintef.bvr.tool.ui.command.event.DeleteBindingAllEvent;

public class BindingEditorDropDown extends JPopupMenu {

	private static final long serialVersionUID = 8629958457282670624L;
	
	public BindingEditorDropDown(BVRNotifiableController _view){
		
		JMenuItem createToBinding = new JMenuItem(Constants.REALIZATION_GENERATE_TO_BINDING);
		createToBinding.addActionListener(new CreateToBindingEvent(_view));
		add(createToBinding);
		
		add(new JSeparator());
		JMenuItem deleteAllBinding = new JMenuItem(Constants.REALIZATION_DELETE_ALL_BINDING);
		deleteAllBinding.addActionListener(new DeleteBindingAllEvent(_view));
		add(deleteAllBinding);
	}

}
