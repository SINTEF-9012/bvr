package no.sintef.bvr.tool.ui.command.event;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
import bvr.CompoundResolution;
import bvr.VClassifier;
import bvr.VSpecResolution;

public class ShowAddMultipleChoicesFromVSpecDialogAndAddEvent implements ActionListener {
	VClassifier c;
	VSpecResolution parent;
	BVRToolModel view;
	private ChoiceResolutionPanel panel;
	private BVRNotifiableController controller;

	public ShowAddMultipleChoicesFromVSpecDialogAndAddEvent(VClassifier c, VSpecResolution parent, BVRToolModel view) {
		this.c = c;
		this.parent = parent;
		this.view = view;
	}

	public ShowAddMultipleChoicesFromVSpecDialogAndAddEvent(ChoiceResolutionPanel _cp, VClassifier _c, BVRNotifiableController _controller) {
		panel = _cp;
		controller = _controller;
		c = _c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		int currentInstances = controller.getResolutionControllerInterface().getReslovedVClassifierCount(panel, c);
		int lowerBound = c.getInstanceMultiplicity().getLower();
		int upperBound = c.getInstanceMultiplicity().getUpper();
		String message = "Set nr of VInstances to add, min total: "
				+ lowerBound + " max total: "
				+ ((upperBound == -1) ? "*" : upperBound) + "\n"
				+ "nr of instances left to add: "
				+ ((upperBound == -1) ? "*" : (upperBound - currentInstances));

		// create Dialog
		String requestedInstancesAsString = (String) JOptionPane.showInputDialog(
				Context.eINSTANCE.getActiveJApplet(), message,
				"Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
		
		int instancesToResolve = (requestedInstancesAsString != null) ?  Integer.parseInt(requestedInstancesAsString) : 0;
		instancesToResolve = (instancesToResolve > upperBound) ? upperBound : instancesToResolve;
		instancesToResolve = (instancesToResolve > 0) ? instancesToResolve - currentInstances : 0;
		
		SimpleExeCommandInterface command = controller.getResolutionControllerInterface().createResolveNVSpecCommand(panel, c, instancesToResolve);
		command.execute();
	}
}