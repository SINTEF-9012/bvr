package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddResolution;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.BVRModel;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.PosResolution;
import bvr.VSpec;

public class NewResolvedResolutionEvent implements ActionListener {
	BVRModel bvrModel;
	private BVRResolutionToolView view;

	public NewResolvedResolutionEvent(BVRModel bvrModel, BVRResolutionToolView bvrView) {
		this.bvrModel = bvrModel;
		this.view = bvrView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		ChoiceResolution root = BvrFactory.eINSTANCE.createPosResolution();

		
		//TODO possible error
		VSpec x = (VSpec) bvrModel.getVariabilityModel().getMember().get(0);

		// populate top choice
		if (x instanceof Choice) {
			root.setResolvedVSpec(x);
			root.setName(x.getName() + " resolution");

			//Iterators.getInstance().iterateEmptyOnChildren(this.view, new AddResolution(), x, root, false);
			

			// create resolution model
			System.out.println("creating new resolution");
			Context.eINSTANCE.getEditorCommands().createNewResolution((PosResolution) root, bvrModel);
			//TODO Context.eINSTANCE.getEditorCommands().ad
		} else {
			throw new UnsupportedOperationException("model must start with a choice");
		}
	}
}