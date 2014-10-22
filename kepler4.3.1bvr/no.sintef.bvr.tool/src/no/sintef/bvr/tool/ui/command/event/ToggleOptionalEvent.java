package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;


public class ToggleOptionalEvent implements ActionListener {
	private ChoicePanel p;
	private BVRNotifiableController view;

	public ToggleOptionalEvent(ChoicePanel p, BVRNotifiableController controller) {
		this.p = p;
		this.view = controller;
	}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		view.getVSpecControllerInterface().toggleChoiceOptionalMandotary(p);
	}
}
