package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import no.sintef.bvr.tool.controller.BVRNotifiableController;


public class AddVariableEvent implements ActionListener {
	
	private JComponent p;
	private BVRNotifiableController controller;

	public AddVariableEvent(JComponent p, BVRNotifiableController controller) {
		this.p = p;
		this.controller = controller;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.getVSpecControllerInterface().addVariable(p);
	}

}
