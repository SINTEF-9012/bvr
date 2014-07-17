package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;

public class AddMissingResolutions implements ResCommand {
	private BVRView view;
	private VSpec target;
	boolean unresolved;
	private VSpecResolution parent;

	@Override
	public ResCommand init(BVRView view, VSpec target, VSpecResolution parent, boolean onlyOneInstance) {
		this.view = view;
		this.target = target;
		this.parent = parent;
		return this;
	}

	@Override
	public List<VSpecResolution> execute() {
		ArrayList<VSpecResolution> thisResolution = new ArrayList<VSpecResolution>();
		unresolved = true;
		int instances = 0;
		int min = 0;
		for (VSpecResolution x : parent.getChild()) {
			
			if (x.getResolvedVSpec().equals(target)) {
				thisResolution.add(x);
				unresolved = false;
				if(x instanceof VInstance){
					min = ((VClassifier)x.getResolvedVSpec()).getInstanceMultiplicity().getLower();
					instances++;
				}
			}			
		}
		while(instances < min ){
			thisResolution.addAll((ArrayList<VSpecResolution>) (new AddResolution().init(view, target, parent, true)).execute());
			instances++;
		}
		if(unresolved)
			thisResolution = (ArrayList<VSpecResolution>) (new AddResolution().init(view, target, parent, false)).execute();
		
		return thisResolution;
	}

}
