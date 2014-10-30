package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;


public class AddClassifierEvent implements ActionListener {
	private JComponent parent;
	private BVRNotifiableController controller;

	public AddClassifierEvent(JComponent p, BVRNotifiableController controller) {
		this.controller = controller;
		this.parent = p;
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		controller.getVSpecControllerInterface().addVClassifier(parent);
	}

}
