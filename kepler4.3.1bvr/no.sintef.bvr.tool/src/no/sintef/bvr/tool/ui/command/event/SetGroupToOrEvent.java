package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;


public class SetGroupToOrEvent implements ActionListener {
	private JComponent p;
	private BVRNotifiableController controller;

	public SetGroupToOrEvent(JComponent p, BVRNotifiableController controller) {
		this.p = p;
		this.controller = controller;
	}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		controller.getVSpecControllerInterface().setGroupMultiplicityOr(p);
	}
}
