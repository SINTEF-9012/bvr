package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;

import java.util.List;

import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.ResCommand;
import bvr.VSpec;
import bvr.VSpecResolution;

public class Iterators {
static long i;

	public void iterateEmpty(BVRView view, ResCommand command, VSpec vsParent, VSpecResolution vsrParent, boolean onlyOneInstance) {
		List<VSpecResolution> newResolutions = command.init(view, vsParent, vsrParent, onlyOneInstance).execute();
		if (newResolutions != null) {
			for (VSpecResolution newResolution : newResolutions) {
				iterateEmptyWithChildren(view, command, vsParent, newResolution, onlyOneInstance);
			}
		}
		//System.out.println("no new resolutions");
	}

	public void iterateEmptyWithChildren(BVRView view, ResCommand command, VSpec vsParent, VSpecResolution vsrParent, boolean onlyOneInstance) {
		if (vsParent != null) {
			for (VSpec x : vsParent.getChild()) {
				
				
				command.init(view, x, vsrParent, onlyOneInstance);
				List<VSpecResolution> newResolutions = command.execute();
				for (VSpecResolution newResolution : newResolutions) {
					System.out.println("resolution to resolve: "+ ((newResolution.getName()!= null)? newResolution.getName() : newResolution.getResolvedVSpec().getName()));
					iterateEmptyWithChildren(view, command, x, newResolution, onlyOneInstance);
				}
			}
		}
	}
	public void iterateExisting(BVRView view, ResCommand command,VSpec vsParent,  VSpecResolution vsrParent, boolean onlyOneInstance){
		command.init(view, vsParent, vsrParent, onlyOneInstance).execute();
		for(VSpecResolution vsr : vsrParent.getChild()){
			i = System.currentTimeMillis();
			command.init(view, vsParent, vsrParent, onlyOneInstance).execute();
			System.out.print("doing operation to " +vsr.getResolvedVSpec().getName() +"is taking" + (System.currentTimeMillis()-i) + "milliseconds \n");
			iterateExisting(view, command, vsParent, vsr, onlyOneInstance);			
		}
	}

}