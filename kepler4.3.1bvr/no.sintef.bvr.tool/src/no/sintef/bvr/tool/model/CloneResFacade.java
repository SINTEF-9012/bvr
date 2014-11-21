package no.sintef.bvr.tool.model;


import no.sintef.bvr.common.CommonUtility;
import bvr.BvrFactory;
import bvr.CompoundResolution;
import bvr.NegResolution;
import bvr.PosResolution;
import bvr.PrimitiveValueSpecification;
import bvr.VSpecResolution;
import bvr.ValueResolution;
import bvr.Variable;


public class CloneResFacade {
	private static CloneResFacade clone = null;

	private CloneResFacade() {

	}

	public static synchronized CloneResFacade getResolution() {
		if (clone == null) {
			clone = new CloneResFacade();
		}
		return clone;
	}

	public VSpecResolution cloneRes(VSpecResolution copyFrom, BVRToolModel view) {
		VSpecResolution copyTo = null;
		
		if (copyFrom instanceof PosResolution) {
			copyTo = BvrFactory.eINSTANCE.createPosResolution();
		} else if(copyFrom instanceof NegResolution){
			copyTo = BvrFactory.eINSTANCE.createNegResolution();

		} else if (copyFrom instanceof ValueResolution) {
			copyTo = BvrFactory.eINSTANCE.createValueResolution();
			Variable vSpecFound = (Variable) copyFrom.getResolvedVSpec();
			String vString = PrimitiveTypeFacade.getInstance().getValueAsString(((ValueResolution) copyFrom));
			PrimitiveValueSpecification value = PrimitiveTypeFacade.getInstance().makeValueSpecification(vSpecFound, vString);
			((ValueResolution) copyTo).setValue(value);
		}
		
		CommonUtility.setResolved(copyTo, copyFrom.getResolvedVSpec());
		copyTo.setName(copyFrom.getName());
		return copyTo;
		
	}

	public VSpecResolution cloneItStart(VSpecResolution parentFrom, BVRToolModel view) {
		VSpecResolution parentTo = cloneRes(parentFrom, view);
		cloneIterate(parentTo, parentFrom, view);
		return parentTo;
	}

	public void cloneIterate(VSpecResolution parentTo, VSpecResolution parentFrom, BVRToolModel view) {
		if ((parentFrom != null) &&(parentFrom instanceof CompoundResolution)) {
			VSpecResolution newNode = null;
			
			for (VSpecResolution x : ((CompoundResolution)parentFrom).getMembers()) {
				newNode = cloneRes(x, view);
				((CompoundResolution)parentTo).getMembers().add(newNode);
				cloneIterate(newNode, x, view);
			}
		}
	}
}
