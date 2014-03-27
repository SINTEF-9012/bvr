package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.ui.command.event.CreateToBindingEvent;
import no.sintef.bvr.tool.ui.command.event.DeleteBindingAllEvent;
import no.sintef.bvr.tool.ui.command.event.DeleteBindingEvent;
import no.sintef.bvr.tool.ui.loader.BVRView;

public class BindingEditorTableDropDown extends BindingEditorDropDown {

	private static final long serialVersionUID = 8629958457282670624L;
	
	public BindingEditorTableDropDown(BVRView _view){
		super(_view);
		
		add(new JSeparator());
		
		JMenuItem deleteBinding = new JMenuItem(Constants.REALIZATION_DELETE_BINDING);
		deleteBinding.addActionListener(new DeleteBindingEvent(_view));
		add(deleteBinding);
	}

}
