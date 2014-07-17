package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.ui.editor.mvc.resolutionV2.ResolutionViewV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRViewV2;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.Variable;
import bvr.VariableValueAssignment;
import bvr.common.PrimitiveTypeHandler;

public class AddResolution implements ResCommand{
	private BVRViewV2 view;
	private VSpec target;
	private boolean onlyOneInstance;
	private VSpecResolution parent;
/**
 * NOT TRANSACTIONAL
 * For use on non-implemented root nodes
 */
	@Override
	public ResCommand init(BVRViewV2 view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance) {
		this.view = view;
		this.target = vs;
		this.parent = vsr;
		this.onlyOneInstance = onlyOneInstance;
		return this;
	}

	@Override
	public List<VSpecResolution> execute() {
		// TODO Auto-generated method stub
		List<VSpecResolution> thisResolution = new ArrayList<VSpecResolution>();
		if (target instanceof Choice) {
			thisResolution.add(addResolution((Choice) target, parent));
		}
		if (target instanceof VClassifier) {
			int min;
			if (((VClassifier) target).getInstanceMultiplicity() != null && !onlyOneInstance) {
				min = ((VClassifier) target).getInstanceMultiplicity().getLower();
			} else {
				System.err.println("instance error");
				min = 1;
			}
			for (int i = 0; i < min; i++) {
				thisResolution.add(addResolution((VClassifier) target, parent));
			}
			min = 0;
		}
		if (target instanceof Variable) {
			thisResolution.add(addResolution((Variable) target, parent));
		}
		if (thisResolution.size() == 0) {
			System.err.println("VSpecResolution of this type is not implemented");
		}
		return thisResolution;
	}

	private VSpecResolution addResolution(VClassifier target, VSpecResolution parent) {
		VInstance thisResolution = BvrFactory.eINSTANCE.createVInstance();
		// count++;
		// vi.setName("vInstance" + count);
		thisResolution.setName("I" + view.getIncrementedNameCounter());
		thisResolution.setResolvedVSpec(target);
		parent.getChild().add(thisResolution);
		return thisResolution;
	}

	// resolve Choice
	private VSpecResolution addResolution(Choice target, VSpecResolution parent) {
		ChoiceResolutuion thisResolution = BvrFactory.eINSTANCE.createChoiceResolutuion();
		thisResolution.setDecision(false);
		thisResolution.setName(target.getName() + " res");
		thisResolution.setResolvedVSpec(target);
		parent.getChild().add(thisResolution);

		return thisResolution;
	}

	// resolve Variable
	private VSpecResolution addResolution(Variable vSpecFound, VSpecResolution parent) {
		VSpecResolution thisResolution = BvrFactory.eINSTANCE.createVariableValueAssignment();
		thisResolution.setName(target.getName() + " Assignment");
		// Value		
		PrimitiveValueSpecification value = (PrimitiveTypeHandler.getInstance().makeValueSpecification((Variable) vSpecFound));
		PrimitiveTypeEnum type = ((PrimitveType) ((Variable)vSpecFound).getType()).getType();
		// Try searching for a type
		PrimitveType vt = PrimitiveTypeHandler.getInstance().makeType(view.getCU(), type);
		value.setType(vt);
		
		((VariableValueAssignment)thisResolution).setValue(value);
		thisResolution.setResolvedVSpec(vSpecFound);
		parent.getChild().add(thisResolution);
		
		return thisResolution;
	}
}
