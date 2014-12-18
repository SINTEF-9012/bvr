package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;

public class RemoveUncontainedResolutionEvent implements ActionListener {
	private JComponent p;
	private BVRNotifiableController controller;

	public RemoveUncontainedResolutionEvent(JComponent p, BVRNotifiableController controller) {
		this.p = p;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.getResolutionControllerInterface().removeUncontainedResolutions(p);
	}

}
