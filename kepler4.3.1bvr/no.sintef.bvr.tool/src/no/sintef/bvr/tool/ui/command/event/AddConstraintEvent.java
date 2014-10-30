package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;


public class AddConstraintEvent implements ActionListener {

	private JComponent parent;
	private BVRNotifiableController controller;

	public AddConstraintEvent(JComponent p, BVRNotifiableController controller) {
		this.parent = p;
		this.controller = controller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		controller.getVSpecControllerInterface().addBCLConstraint(parent);
	}

}
