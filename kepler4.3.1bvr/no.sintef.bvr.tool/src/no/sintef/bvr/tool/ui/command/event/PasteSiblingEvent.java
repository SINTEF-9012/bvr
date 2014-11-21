package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class PasteSiblingEvent implements ActionListener {

	private JPanel p;
	private BVRNotifiableController controller;

	public PasteSiblingEvent(JPanel cp, BVRNotifiableController controller) {
		this.p = cp;
		this.controller = controller;
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		controller.getVSpecControllerInterface().pastNamedElementAsSibling(p);
	}

}
