package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;

public class AddSubTreeEvent implements ActionListener {

	private JComponent parent;
	private BVRNotifiableController controller;

	public AddSubTreeEvent(JComponent p, BVRNotifiableController controller) {
		super();
		this.parent = p;
		this.controller = controller;
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		SimpleExeCommandInterface command = controller.getResolutionControllerInterface().createResolveSubtreeCommand(parent);
		command.execute();
	}


	
	
}
