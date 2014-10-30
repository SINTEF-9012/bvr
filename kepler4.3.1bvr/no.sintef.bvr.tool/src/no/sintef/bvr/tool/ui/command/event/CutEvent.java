package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import no.sintef.bvr.tool.controller.BVRNotifiableController;


public class CutEvent implements ActionListener {

	private JPanel p;
	private BVRNotifiableController controller;

	public CutEvent(JPanel cp, BVRNotifiableController controller) {
		this.p = cp;
		this.controller = controller;
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		controller.getVSpecControllerInterface().cutNamedElement(p);
	}

}
