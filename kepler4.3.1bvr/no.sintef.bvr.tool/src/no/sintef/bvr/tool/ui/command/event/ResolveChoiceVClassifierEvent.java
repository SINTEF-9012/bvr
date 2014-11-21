package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class ResolveChoiceVClassifierEvent implements ActionListener {
	JComponent p;
	BVRNotifiableController controller;
	EObject x;

	public ResolveChoiceVClassifierEvent(JComponent p, EObject x, BVRNotifiableController controller) {
		this.p = p;
		this.controller = controller;
		this.x = x;
	}
	@Override
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		controller.getResolutionControllerInterface().addChoiceOrVClassifierResolution(p, x);
	}

}
