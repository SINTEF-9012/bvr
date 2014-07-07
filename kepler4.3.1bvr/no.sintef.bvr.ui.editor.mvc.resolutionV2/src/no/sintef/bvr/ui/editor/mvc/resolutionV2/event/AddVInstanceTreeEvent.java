package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddResolution;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.VClassifier;
import bvr.VSpecResolution;

public class AddVInstanceTreeEvent implements ActionListener {

	private BVRView view;
	private VClassifier x;
	VSpecResolution c;

	public AddVInstanceTreeEvent(VSpecResolution c, VClassifier x, BVRView view) {

		this.view = view;
		this.x = x;
		this.c = c;
	}
	public void actionPerformed(ActionEvent arg0) {
		List<VSpecResolution> thisResolution = new ArrayList<VSpecResolution>();
		thisResolution = new AddResolution().init(view, x, c, true).execute();
		new Iterators().iterateEmptyWithChildren(view, new AddResolution(), x, thisResolution.get(0), false);
	}

}
