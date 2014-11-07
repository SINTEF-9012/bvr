package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;


public class RemoveVSpecResolutionEvent implements ActionListener  {
	private JComponent p;
	private BVRNotifiableController controller;

	public RemoveVSpecResolutionEvent(JComponent p, BVRNotifiableController controller) {
		this.p = p;
		this.controller = controller;
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		SimpleExeCommandInterface command = controller.getResolutionControllerInterface().createRemoveVSpecResolutionCommand(p);
		command.execute();
	}
}
