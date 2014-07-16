package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;

import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.BvrFactory;
import bvr.ChoiceResolutuion;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.VInstance;
import bvr.VSpecResolution;
import bvr.Variable;
import bvr.VariableValueAssignment;
import bvr.common.PrimitiveTypeHandler;

public class CloneRes {
	private static CloneRes clone = null;
	private CloneRes(){
		
	}
	public static synchronized CloneRes getInstance(){
		if(clone == null){
			clone = new CloneRes();
		}
		return clone;
	}
	
	public void cloneRes(VSpecResolution copyTo, VSpecResolution copyFrom, BVRView view) {

		if (copyFrom instanceof ChoiceResolutuion) {

			((ChoiceResolutuion) copyTo).setDecision(((ChoiceResolutuion) copyFrom).isDecision());

		} else if (copyFrom instanceof VariableValueAssignment) {
			Variable vSpecFound = (Variable) copyFrom.getResolvedVSpec();
			String vString = PrimitiveTypeHandler.getInstance().getValueAsString(((VariableValueAssignment) copyFrom));
			PrimitiveValueSpecification value = PrimitiveTypeHandler.getInstance().makeValueSpecification(vSpecFound, vString);
			PrimitiveTypeEnum type = ((PrimitveType) ((Variable) vSpecFound).getType()).getType();
			// Try searching for a type
			PrimitveType vt = PrimitiveTypeHandler.getInstance().makeType(view.getCU(), type);
			value.setType(vt);

			((VariableValueAssignment) copyTo).setValue(value);
			// ((VariableValueAssignment) copyFrom).getValue()
		} else if (copyFrom instanceof VInstance) {
			// copyTo = BvrFactory.eINSTANCE.createVInstance();

		}
		copyTo.setResolvedVSpec(copyFrom.getResolvedVSpec());
		copyTo.setName(copyFrom.getName());
	}

	public void cloneItStart(VSpecResolution parentTo, VSpecResolution parentFrom, BVRView view) {
		cloneRes(parentTo, parentFrom, view);
		cloneIterate(parentTo, parentFrom, view);
	}

	public void cloneIterate(VSpecResolution parentTo, VSpecResolution parentFrom, BVRView view) {
		if (parentFrom != null) {
			VSpecResolution newNode = null;
			for (VSpecResolution x : parentFrom.getChild()) {
				if (x instanceof ChoiceResolutuion) {
					newNode = BvrFactory.eINSTANCE.createChoiceResolutuion();

				} else if (x instanceof VariableValueAssignment) {
					newNode = BvrFactory.eINSTANCE.createVariableValueAssignment();

				} else if (x instanceof VInstance) {
					newNode = BvrFactory.eINSTANCE.createVInstance();
				}

				cloneRes(newNode, x, null);
				parentTo.getChild().add(newNode);
				cloneIterate(newNode, x, view);
			}
		}
	}
}
