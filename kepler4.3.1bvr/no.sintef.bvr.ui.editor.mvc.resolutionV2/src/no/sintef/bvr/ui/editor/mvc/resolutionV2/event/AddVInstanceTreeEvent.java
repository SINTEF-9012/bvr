package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddResolution;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.BvrFactory;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;

public class AddVInstanceTreeEvent implements ActionListener {

	private BVRView view;
	private VSpec target;
	VSpecResolution c;

	public AddVInstanceTreeEvent(VSpecResolution c, VSpec x, BVRView view) {

		this.view = view;
		this.target = x;
		this.c = c;
	}
	public void actionPerformed(ActionEvent arg0) {
	
		VInstance root = BvrFactory.eINSTANCE.createVInstance();
		root.setResolvedVSpec(target);
		root.setName(target.getName());
		
		//List<VSpecResolution> thisResolution = new ArrayList<VSpecResolution>();
		//thisResolution = new AddResolution().init(view, target, c, true).execute();
		new Iterators().iterateEmptyOnChildren(view, new AddResolution(), target, root, false);
		Context.eINSTANCE.getEditorCommands().addVInstance(c, root);
		
	}

}
