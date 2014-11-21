package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class SATValidateResolutions implements ActionListener {
	private BVRNotifiableController controller;

	public SATValidateResolutions(BVRNotifiableController _controller) {
		this.controller = _controller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		boolean result = controller.getResolutionControllerInterface().performSATValidation();
		List<String> message = controller.getResolutionControllerInterface().getSATValidationMessage();
		JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), "Valid: " + result + " " + message);
	}
}
