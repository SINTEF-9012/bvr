package no.sintef.bvr.tool.ui.command.event;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class BindingRowSelectionEvent implements ListSelectionListener {


	private BVRNotifiableController controller;

	public BindingRowSelectionEvent(BVRNotifiableController _controller){
		controller = _controller;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent event) {		
		int selectedIndex = ((ListSelectionModel) event.getSource()).getLeadSelectionIndex();
		if(!event.getValueIsAdjusting() && selectedIndex >= 0)
			controller.getRealizationControllerInterface().highlightBoundaryElements(selectedIndex);
	}
}
