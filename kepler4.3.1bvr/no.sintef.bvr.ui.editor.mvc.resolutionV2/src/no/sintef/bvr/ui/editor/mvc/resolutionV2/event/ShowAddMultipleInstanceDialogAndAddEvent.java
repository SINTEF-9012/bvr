package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import bvr.VClassifier;
import bvr.VSpecResolution;

public class ShowAddMultipleInstanceDialogAndAddEvent implements ActionListener {
	VClassifier c;
	VSpecResolution parent;
	BVRResolutionToolView  view;
	public ShowAddMultipleInstanceDialogAndAddEvent(VClassifier c, VSpecResolution parent, BVRResolutionToolView  view) {		
		this.c = c;
		this.parent = parent;
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		int currentInstances = 0;
		for (VSpecResolution x : parent.getChild()) {
			if (x.getResolvedVSpec() == c) {
				if (x.getResolvedVSpec() == c) {
					currentInstances++;
				}
			}
		}
		Component cParent = Context.eINSTANCE.getActiveJApplet();
		Object[] possibilities = null;
		
		//create Dialog
		String requestedInstancesAsString = (String)JOptionPane.showInputDialog(
				cParent,
		                    "Set nr of VInstances to add, min total: " +c.getInstanceMultiplicity().getLower()+ " max total: "+ ((c.getInstanceMultiplicity().getUpper() == -1)? "*" : c.getInstanceMultiplicity().getUpper() ) +"\n" 
		                    + "nr of instances left to add: " +(( c.getInstanceMultiplicity().getUpper() == -1 )? "*" : (c.getInstanceMultiplicity().getUpper() - currentInstances)),
		                    "Customized Dialog",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null, possibilities,
		                    null);
		
		//If a string was returned, say so.
		if ((requestedInstancesAsString != null) && (requestedInstancesAsString.length() > 0)) {
		  new AddMultipleInstanceTreesEvent(Integer.parseInt(requestedInstancesAsString), parent, c, view).actionPerformed(e);
		}
	*/
	}
}