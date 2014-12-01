package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class RemoveVTypeEvent implements ActionListener {
	private JComponent parent;
	private BVRNotifiableController controller;

	public RemoveVTypeEvent(JComponent p, BVRNotifiableController controller) {
		this.controller = controller;
		this.parent = p;
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		controller.getVTypeControllerInterface().removeVType(parent);
	}
}
