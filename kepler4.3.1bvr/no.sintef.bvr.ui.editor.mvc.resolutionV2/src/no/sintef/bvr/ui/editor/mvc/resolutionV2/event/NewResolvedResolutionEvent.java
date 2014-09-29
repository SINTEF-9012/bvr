package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddResolution;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.BvrFactory;
import bvr.Choice;
//import bvr.ChoiceResolutuion;
//import bvr.ConfigurableUnit;
import bvr.VSpec;

public class NewResolvedResolutionEvent implements ActionListener {
	//private ConfigurableUnit cu;
	private BVRResolutionToolView view;

	public NewResolvedResolutionEvent(/*ConfigurableUnit cu,*/ BVRResolutionToolView bvrView) {
//		this.cu = cu;
		this.view = bvrView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
/*
		ChoiceResolutuion root = BvrFactory.eINSTANCE.createChoiceResolutuion();

		VSpec x = cu.getOwnedVSpec().get(0);

		// populate top choice
		if (x instanceof Choice) {
			root.setResolvedVSpec(x);
			root.setName(x.getName() + " resolution");
			Iterators.getInstance().iterateEmptyOnChildren(this.view, new AddResolution(), x, root, false);
			root.setDecision(false);

			// create resolution model
			Context.eINSTANCE.getEditorCommands().createNewResolution(root, cu);
			Context.eINSTANCE.getEditorCommands().addChoiceResolved((Choice) x, root, root);
		} else {
			throw new UnsupportedOperationException("model must start with a choice");
		}*/
	}
}