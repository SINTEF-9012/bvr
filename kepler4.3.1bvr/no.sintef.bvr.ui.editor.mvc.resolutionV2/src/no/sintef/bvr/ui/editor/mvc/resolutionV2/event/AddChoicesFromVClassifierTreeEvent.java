package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddResolution;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.BvrFactory;
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
		System.out.println("AddChoicesFromVClassifierTreeEvent running but not implemented");
		/*
		 * VInstance root = BvrFactory.eINSTANCE.createVInstance();
		 * root.setResolvedVSpec(target);
		 * root.setName("I" + view.getIncrementedNameCounter());
		 * Iterators.getInstance().iterateEmptyOnChildren(view, new AddResolution(), target, root, false);
		 * Context.eINSTANCE.getEditorCommands().addVInstance(c, root);
		 */
	}

}