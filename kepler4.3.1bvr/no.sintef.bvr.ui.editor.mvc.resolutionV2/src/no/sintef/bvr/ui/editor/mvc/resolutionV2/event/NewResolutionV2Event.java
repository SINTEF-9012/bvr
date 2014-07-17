package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRViewV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddResolution;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.VSpec;

public class NewResolutionV2Event implements ActionListener {
	private ConfigurableUnit cu;
	private BVRViewV2  view;

	public NewResolutionV2Event(ConfigurableUnit cu, BVRViewV2  bvrView) {
		this.cu = cu;
		this.view = bvrView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// cu.getOwnedVSpecResolution().add(cr);

		/* TODO add checks for type here */
		ChoiceResolutuion root = BvrFactory.eINSTANCE.createChoiceResolutuion();
		// populate top choice
		VSpec x = cu.getOwnedVSpec().get(0);
		root.setResolvedVSpec(x);
		root.setName(x.getName() + " resolution");
		System.out.println(x.getChild());
		if (x instanceof Choice) {
			Iterators.getInstance().iterateEmptyOnChildren(this.view, new AddResolution(), x, root, false);

			root.setDecision(false);
			// create resolution model
			Context.eINSTANCE.getEditorCommands().createNewResolution(root, cu);
			Context.eINSTANCE.getEditorCommands().addChoiceResolved((Choice) x, root, root);

		} else {
			System.err.println("model must start with a choice");
			// Context.eINSTANCE.getEditorCommands().addVInstance((VSpecResolution) cu, (VInstance)x);
		}
	}
}