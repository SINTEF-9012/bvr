package no.sintef.bvr.tool.ui.command.event;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.context.StaticUICommands;


public class ValidateEvent implements ActionListener{
	private JComponent component;
	private BVRNotifiableController controller;
	
	public ValidateEvent(JComponent _component, BVRNotifiableController _controller) {
		component = _component;
		controller = _controller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		List<String> results = controller.getResolutionControllerInterface().validateResolutionNode(component);
		if(results.size() == 0) {
			StaticUICommands.showMessageInformationDialog(Context.eINSTANCE.getActiveJApplet(), "Valid!");
			return;
		}

		String message = "";
		for(String result : results)
			message += result + "\n";	
		StaticUICommands.showMessageInformationDialog(Context.eINSTANCE.getActiveJApplet(), message);
	}
}
