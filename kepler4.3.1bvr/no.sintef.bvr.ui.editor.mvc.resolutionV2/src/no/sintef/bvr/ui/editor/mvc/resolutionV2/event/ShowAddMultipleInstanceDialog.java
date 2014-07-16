package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.VClassifier;
import bvr.VSpecResolution;

public class ShowAddMultipleInstanceDialog implements ActionListener {
	VClassifier c;
	VSpecResolution parent;
	BVRView view;
	public ShowAddMultipleInstanceDialog(VClassifier c, VSpecResolution parent, BVRView view) {		
		this.c = c;
		this.parent = parent;
		this.view = view;
		
	

	}
	@Override
	public void actionPerformed(ActionEvent e) {
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
		String s = (String)JOptionPane.showInputDialog(
				cParent,
		                    "Set nr of VInstances to add, min total: " +c.getInstanceMultiplicity().getLower()+ " max total: "+ ((c.getInstanceMultiplicity().getUpper() == -1)? "*" : c.getInstanceMultiplicity().getUpper() ) +"\n" 
		                    + "nr of instances left to add: " +(( c.getInstanceMultiplicity().getUpper() == -1 )? "*" : (c.getInstanceMultiplicity().getUpper() - currentInstances)),
		                    "Customized Dialog",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null, possibilities,
		                    null);
		
		//If a string was returned, say so.
		if ((s != null) && (s.length() > 0)) {
		  new AddMultipleInstanceTreesEvent(Integer.parseInt(s), parent, c, view).actionPerformed(e);
		}
		
		/*
		VInstanceMultiplicityPanel content = new VInstanceMultiplicityPanel( c,  parent,  view);
		Dialog.ModalityType mode = Dialog.ModalityType.APPLICATION_MODAL;
		Component cParent = Context.eINSTANCE.getActiveJApplet();
		Window parentWindow = findWindow(cParent);
		JDialog dialog = new JDialog(parentWindow, "Properties editor", mode);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setContentPane(content);
		dialog.pack();
		dialog.setLocationRelativeTo(parentWindow);
		dialog.setVisible(true);
*/		
	}
}