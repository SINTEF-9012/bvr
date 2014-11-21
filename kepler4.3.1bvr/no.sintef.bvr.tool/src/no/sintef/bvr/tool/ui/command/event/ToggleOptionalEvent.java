package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;


public class ToggleOptionalEvent implements ActionListener {
	private ChoicePanel p;
	private BVRNotifiableController controller;

	public ToggleOptionalEvent(ChoicePanel p, BVRNotifiableController controller) {
		this.p = p;
		this.controller = controller;
	}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		controller.getVSpecControllerInterface().toggleChoiceOptionalMandotary(p);
	}
}
