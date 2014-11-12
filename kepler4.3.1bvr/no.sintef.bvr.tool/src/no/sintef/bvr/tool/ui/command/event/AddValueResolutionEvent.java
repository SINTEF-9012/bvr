package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import bvr.Variable;
import no.sintef.bvr.common.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.controller.BVRNotifiableController;


public class AddValueResolutionEvent implements ActionListener {
	private JComponent cr;
	private Variable target;
	private BVRNotifiableController controller;
	
	public AddValueResolutionEvent(JComponent parent, Variable toResolve, BVRNotifiableController controller) {
		cr = parent;
		target = toResolve;
		this.controller = controller;
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		SimpleExeCommandInterface command = controller.getResolutionControllerInterface().createVariableResolutionCommand(cr, target);
		command.execute();
	}
}
