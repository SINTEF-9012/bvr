package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import bvr.Choice;
import bvr.BvrFactory;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.VSpecResolution;

public class AddChoiceFromVClassifierEvent implements ActionListener {
	private JComponent cr;
	private EObject target;
	private BVRNotifiableController controller;
	
	public AddChoiceFromVClassifierEvent(JComponent parent, EObject toResolve, BVRNotifiableController controller) {
		cr = parent;
		target = toResolve;
		this.controller = controller;
	}
	
	static int count = 0;

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		controller.getResolutionControllerInterface().addChoiceOrVClassifierResolution(cr, target);
	}
}
