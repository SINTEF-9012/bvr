package no.sintef.bvr.tool.model;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.UnimplementedBVRException;

import org.eclipse.emf.common.util.EList;

import bvr.BvrFactory;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.Target;
import bvr.VClassifier;
import bvr.VSpec;

public class TargetFactory {
	
	public static TargetFactory eINSTANCE = getInstance();
	
	private static TargetFactory getInstance() {
		if(eINSTANCE == null)
			eINSTANCE = new TargetFactory();
		return eINSTANCE;
	}
	
	public Target getVSpecTarget(VSpec vSpec){
		return vSpec.getTarget();
	}
	
	public Target testVSpecTarget(VSpec vSpec){
		String name = vSpec.getName();
		Target target = ((VSpec) vSpec).getTarget();
		if(target == null){
			if((vSpec instanceof VClassifier || vSpec instanceof Choice) && vSpec instanceof CompoundNode){
				EList<Target> targets = ((CompoundNode) vSpec).getOwnedTargets();
				for(Target t : targets){
					if(t.getName().equals(name)){
						target = t;
						break;
					}
				}
				if(target == null){
					target = BvrFactory.eINSTANCE.createTarget();
					Context.eINSTANCE.getEditorCommands().addTargetToCompoundNode((CompoundNode) vSpec, target);
				}
				Context.eINSTANCE.getEditorCommands().setVSpecTarget((VSpec) vSpec, target);
			} else {
				throw new UnimplementedBVRException("Can not add target to " + vSpec);
			}
		}
		return target;
	}
	
}
