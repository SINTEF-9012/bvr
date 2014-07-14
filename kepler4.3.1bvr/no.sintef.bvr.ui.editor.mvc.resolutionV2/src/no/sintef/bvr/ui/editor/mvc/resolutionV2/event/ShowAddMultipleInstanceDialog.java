package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import bvr.VClassifier;
import bvr.VSpecResolution;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.VInstanceMultiplicityPanel;

public class ShowAddMultipleInstanceDialog implements ActionListener {
	VClassifier c;
	VSpecResolution parent;
	BVRView view;
	public ShowAddMultipleInstanceDialog(VClassifier c, VSpecResolution parent, BVRView view) {		
		this.c = c;
		this.parent = parent;
		this.view = view;
		
	

	}

	public static Window findWindow(Component c) {
		if (c == null) {
			return JOptionPane.getRootFrame();
		} else if (c instanceof Window) {
			return (Window) c;
		} else {
			return findWindow(c.getParent());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Component cParent = Context.eINSTANCE.getActiveJApplet();
		Window parentWindow = findWindow(cParent);
		Object[] possibilities = null;
		String s = (String)JOptionPane.showInputDialog(
							cParent,
		                    "Set nr of VInstances, min: " +c.getInstanceMultiplicity().getLower()+ " max: "+c.getInstanceMultiplicity().getUpper() +"\n",
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