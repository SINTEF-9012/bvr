package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.model.BVRToolModel;
import bvr.CompoundResolution;
import bvr.VClassifier;
import bvr.VSpecResolution;

public class ShowAddMultipleChoicesFromVSpecDialogAndAddEvent implements ActionListener {
	VClassifier c;
	VSpecResolution parent;
	BVRToolModel view;

	public ShowAddMultipleChoicesFromVSpecDialogAndAddEvent(VClassifier c, VSpecResolution parent, BVRToolModel view) {
		this.c = c;
		this.parent = parent;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ShowAddMultipleChoicesFromVSpecDialogAndAddEvent running but not implemented");
		int currentInstances = 0;
		if (parent instanceof CompoundResolution)
			for (VSpecResolution x : ((CompoundResolution) parent).getMembers()) {
				if (x.getResolvedVSpec() == c) {
					if (x.getResolvedVSpec() == c) {
						currentInstances++;
					}
				}
			}
		Component cParent = Context.eINSTANCE.getActiveJApplet();
		Object[] possibilities = null;

		// create Dialog
		String requestedInstancesAsString = (String) JOptionPane.showInputDialog(cParent, "Set nr of VInstances to add, min total: "
				+ c.getInstanceMultiplicity().getLower() + " max total: "
				+ ((c.getInstanceMultiplicity().getUpper() == -1) ? "*" : c.getInstanceMultiplicity().getUpper()) + "\n"
				+ "nr of instances left to add: "
				+ ((c.getInstanceMultiplicity().getUpper() == -1) ? "*" : (c.getInstanceMultiplicity().getUpper() - currentInstances)),
				"Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, possibilities, null);

		// If a string was returned, say so.
		if ((requestedInstancesAsString != null) && (requestedInstancesAsString.length() > 0)) {
			new AddMultipleInstanceTreesEvent(Integer.parseInt(requestedInstancesAsString), parent, c, view).actionPerformed(e);
		}
	}
}