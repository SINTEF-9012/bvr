package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.CloneRes;
import bvr.BvrFactory;
import bvr.ChoiceResolutuion;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.VariableValueAssignment;

public class AddMissingResolutions implements ResCommand{
	private BVRView view;
	private VSpec target;

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
		ArrayList<VSpecResolution>thisResolution = new ArrayList<VSpecResolution>();
		for(VSpecResolution x : parent.getChild()){
			System.out.println("parent: " + parent);
			System.out.println("x: " +x);
			System.out.println("target: " + target);
			if(x.getResolvedVSpec().equals(target)){
				VSpecResolution y = null; 
				if (x instanceof ChoiceResolutuion) {
					y = BvrFactory.eINSTANCE.createChoiceResolutuion();

				} else if (x instanceof VariableValueAssignment) {
					y = BvrFactory.eINSTANCE.createVariableValueAssignment();

				} else if (x instanceof VInstance) {
					y = BvrFactory.eINSTANCE.createVInstance();
				}
				CloneRes.getInstance().cloneRes(y, x, view);		
				thisResolution.add(y);
			}
			
		}
			if(thisResolution.size() == 0)
			thisResolution = (ArrayList<VSpecResolution>) (new AddResolution().init(view, target, parent, false)).execute();
		
			return thisResolution;
	}

}
