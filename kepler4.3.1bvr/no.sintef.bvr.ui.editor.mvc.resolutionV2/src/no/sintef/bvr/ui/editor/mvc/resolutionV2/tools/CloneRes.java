package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;


import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.model.PrimitiveTypeFacade;
import bvr.BvrFactory;
import bvr.CompoundResolution;
import bvr.NegResolution;
import bvr.PosResolution;
import bvr.PrimitiveTypeEnum;
//import bvr.ChoiceResolution;
//import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
//import bvr.VInstance;
import bvr.VSpecResolution;
import bvr.ValueResolution;
import bvr.Variable;
//import bvr.VariableValueAssignment;
//import bvr.common.PrimitiveTypeHandler;

public class CloneRes {
	private static CloneRes clone = null;

	private CloneRes() {

	}

	public static synchronized CloneRes getResolution() {
		if (clone == null) {
			clone = new CloneRes();
		}
		return clone;
	}

	public VSpecResolution cloneRes(VSpecResolution copyFrom, BVRResolutionToolView view) {
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
			//PrimitiveTypeEnum type = ((PrimitveType) ((Variable) vSpecFound).getType()).getType();
			// Try searching for a type
			//System.out.println("copyFrom: " + copyFrom);
			//System.out.println("copyTo: " + copyTo);
			//System.out.println("type: " + type);
			//System.out.println("view: " + view);
		//	PrimitveType vt = PrimitiveTypeFactory.getInstance().makeValueSpecification(type);
		//	value.setType(vt);

			((ValueResolution) copyTo).setValue(value);
		}
		
		CommonUtility.setResolved(copyTo, copyFrom.getResolvedVSpec());
		copyTo.setName(copyFrom.getName());
		return copyTo;
		
	}

	public VSpecResolution cloneItStart(VSpecResolution parentFrom, BVRResolutionToolView view) {
		VSpecResolution parentTo = cloneRes(parentFrom, view);
		cloneIterate(parentTo, parentFrom, view);
		return parentTo;
	}

	public void cloneIterate(VSpecResolution parentTo, VSpecResolution parentFrom, BVRResolutionToolView view) {
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
