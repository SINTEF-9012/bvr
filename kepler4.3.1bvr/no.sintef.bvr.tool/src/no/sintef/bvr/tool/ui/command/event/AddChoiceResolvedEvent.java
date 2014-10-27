package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import org.eclipse.emf.ecore.EObject;
import no.sintef.bvr.tool.controller.BVRNotifiableController;


public class AddChoiceResolvedEvent implements ActionListener {
	JComponent p;
	BVRNotifiableController controller;
	EObject x;

	public AddChoiceResolvedEvent(JComponent p, EObject x, BVRNotifiableController controller) {
		this.p = p;
		this.controller = controller;
		this.x = x;
		// cr = a;
		// target = b;
		// this.view = view;
	}
	@Override
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		controller.getResolutionControllerInterface().addChoiceResolution(p, x);
		
		// ChoiceResolutuion ncr = BvrFactory.eINSTANCE.createChoiceResolutuion();

		// Context.eINSTANCE.getEditorCommands().addChoiceResolved(target, cr, ncr);
	}

}
