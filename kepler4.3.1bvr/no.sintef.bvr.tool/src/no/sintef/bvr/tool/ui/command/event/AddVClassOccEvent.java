package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;



public class AddVClassOccEvent implements ActionListener {
	private JComponent p;
	private BVRNotifiableController controller;

	public AddVClassOccEvent(JComponent p, BVRNotifiableController controller) {
		this.p = p;
		this.controller = controller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		controller.getVSpecControllerInterface().addVClassOccurence(p);
	}
}
