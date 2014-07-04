package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddResolution;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.VSpec;

public class NewResolutionV2Event implements ActionListener {
	private ConfigurableUnit cu;
	private BVRView view;

	public NewResolutionV2Event(ConfigurableUnit cu, BVRView bvrView) {
		this.cu = cu;
		this.view = bvrView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// cu.getOwnedVSpecResolution().add(cr);

		/* TODO add checks for type here */
		// create resolution editor pane
		ChoiceResolutuion cr = BvrFactory.eINSTANCE.createChoiceResolutuion();
		Context.eINSTANCE.getEditorCommands().createNewResolution(cr, cu);
		// populate top choice
		VSpec x = cu.getOwnedVSpec().get(0);
		if (x instanceof Choice) {
			Context.eINSTANCE.getEditorCommands().addChoiceResolved((Choice) x, cr, cr);
			Context.eINSTANCE.getEditorCommands().setResolutionDecision( cr, true);
		} else {
			System.err.println("model must start with a choice");
			// Context.eINSTANCE.getEditorCommands().addVInstance((VSpecResolution) cu, (VInstance)x);
		}

		(new Iterators()).iterateEmptyWithChildren(this.view, new AddResolution(), x, cr, false);
	}
}