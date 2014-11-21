package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class MaximizeVSpecEvent implements ActionListener {

	private JComponent cp;
	private BVRNotifiableController controller;

	public MaximizeVSpecEvent(JComponent cp, BVRNotifiableController controller) {
		this.cp = cp;
		this.controller = controller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		controller.getVSpecControllerInterface().maximizeNode(cp);
	}

}
