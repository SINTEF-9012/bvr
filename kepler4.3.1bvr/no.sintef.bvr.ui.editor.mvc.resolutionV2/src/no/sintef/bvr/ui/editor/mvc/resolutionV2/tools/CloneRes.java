package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;

import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import bvr.BvrFactory;
//import bvr.ChoiceResolutuion;
//import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
//import bvr.VInstance;
import bvr.VSpecResolution;
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
		/*
		if (copyFrom instanceof ChoiceResolutuion) {
			copyTo = BvrFactory.eINSTANCE.createChoiceResolutuion();
			((ChoiceResolutuion) copyTo).setDecision(((ChoiceResolutuion) copyFrom).isDecision());
		} else if (copyFrom instanceof VariableValueAssignment) {
			copyTo = BvrFactory.eINSTANCE.createVariableValueAssignment();
			Variable vSpecFound = (Variable) copyFrom.getResolvedVSpec();
			String vString = PrimitiveTypeHandler.getInstance().getValueAsString(((VariableValueAssignment) copyFrom));
			PrimitiveValueSpecification value = PrimitiveTypeHandler.getInstance().makeValueSpecification(vSpecFound, vString);
			PrimitiveTypeEnum type = ((PrimitveType) ((Variable) vSpecFound).getType()).getType();
			// Try searching for a type
			System.out.println("copyFrom: " + copyFrom);
			System.out.println("copyTo: " + copyTo);
			System.out.println("type: " + type);
			System.out.println("view: " + view);
			PrimitveType vt = PrimitiveTypeHandler.getInstance().makeType(view.getCU(), type);
			value.setType(vt);

			((VariableValueAssignment) copyTo).setValue(value);
		} else if (copyFrom instanceof VInstance) {
			copyTo = BvrFactory.eINSTANCE.createVInstance();
		}
		
		copyTo.setResolvedVSpec(copyFrom.getResolvedVSpec());
		copyTo.setName(copyFrom.getName());
		return copyTo;*/
		return null;
	}

	public VSpecResolution cloneItStart(VSpecResolution parentFrom, BVRResolutionToolView view) {
		VSpecResolution parentTo = cloneRes(parentFrom, view);
		cloneIterate(parentTo, parentFrom, view);
		return parentTo;
	}

	public void cloneIterate(VSpecResolution parentTo, VSpecResolution parentFrom, BVRResolutionToolView view) {
		/*if (parentFrom != null) {
			VSpecResolution newNode = null;
			for (VSpecResolution x : parentFrom.getChild()) {
				newNode = cloneRes(x, view);
				parentTo.getChild().add(newNode);
				cloneIterate(newNode, x, view);
			}
		}*/
	}
}
