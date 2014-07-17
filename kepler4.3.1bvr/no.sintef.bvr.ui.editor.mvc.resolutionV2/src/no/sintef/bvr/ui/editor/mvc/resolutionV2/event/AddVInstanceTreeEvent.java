package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRViewV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddResolution;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.BvrFactory;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;

public class AddVInstanceTreeEvent implements ActionListener {

	private BVRViewV2  view;
	private VSpec target;
	VSpecResolution c;

	public AddVInstanceTreeEvent(VSpecResolution parent, VSpec target, BVRViewV2  view) {

		this.view = view;
		this.target = target;
		this.c = parent;
	}
	public void actionPerformed(ActionEvent arg0) {

		VInstance root = BvrFactory.eINSTANCE.createVInstance();
		root.setResolvedVSpec(target);
		root.setName("I" + view.getIncrementedNameCounter());

		//List<VSpecResolution> thisResolution = new ArrayList<VSpecResolution>();
		//thisResolution = new AddResolution().init(view, target, c, true).execute();
		Iterators.getInstance().iterateEmptyOnChildren(view, new AddResolution(), target, root, false);
		Context.eINSTANCE.getEditorCommands().addVInstance(c, root);

	}

}