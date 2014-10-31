package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.controller.command.AddResolution;
import no.sintef.bvr.tool.model.ResolutionModelIterator;
import bvr.BvrFactory;
import bvr.PosResolution;
//import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;

public class AddChoicesFromVClassifierTreeEvent implements ActionListener {

	private BVRResolutionToolView view;
	private VSpec target;
	VSpecResolution c;

	public AddChoicesFromVClassifierTreeEvent(VSpecResolution parent, VSpec target, BVRResolutionToolView view) {

		this.view = view;
		this.target = target;
		this.c = parent;
	}

	public void actionPerformed(ActionEvent arg0) {

		  PosResolution root = BvrFactory.eINSTANCE.createPosResolution();
		  CommonUtility.setResolved(root, target);
		  root.setName("I" + view.getIncrementedNameCounter());
		  //ResolutionModelIterator.getInstance().iterateEmptyOnChildren(view, new AddResolution(), target, root, false);
		  Context.eINSTANCE.getEditorCommands().addPosChoiceResoulution(c, root);
		 
	}

}