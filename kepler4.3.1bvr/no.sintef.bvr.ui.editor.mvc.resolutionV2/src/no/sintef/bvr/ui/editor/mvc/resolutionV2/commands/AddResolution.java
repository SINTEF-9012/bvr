package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.CompoundNode;
import bvr.CompoundResolution;
import bvr.PosResolution;
//import bvr.ChoiceResolution;
//import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.VClassifier;
//import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.Variable;
//import bvr.VariableValueAssignment;
//import bvr.common.PrimitiveTypeHandler;

public class AddResolution implements ResCommand{
	private BVRResolutionToolView view;
	private VSpec target;
	private boolean onlyOneInstance;
	private VSpecResolution parent;
/**
 * NOT TRANSACTIONAL
 * ONLY for use with nodes NOT added to model
 */
	@Override
	public ResCommand init(BVRResolutionToolView view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance) {
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

		return thisResolution;
	}

	private VSpecResolution addResolution(VClassifier target, VSpecResolution parent) {
	
		PosResolution thisResolution = BvrFactory.eINSTANCE.createPosResolution();
		 //count++;
		// vi.setName("vInstance" + count);
		thisResolution.setName("I" + view.getIncrementedNameCounter());
		thisResolution.setResolvedVSpec(target);
		
		((CompoundResolution) parent).getMembers().add(thisResolution);
		return thisResolution;
	}

	// resolve Choice
	private VSpecResolution addResolution(Choice target, VSpecResolution parent) {
		
		ChoiceResolution thisResolution = BvrFactory.eINSTANCE.createNegResolution();
		thisResolution.setName(target.getName());
		thisResolution.setResolvedVSpec(target);
		((CompoundResolution)parent).getMembers().add(thisResolution);
		return thisResolution;
	}

	// resolve Variable
	private VSpecResolution addResolution(Variable vSpecFound, VSpecResolution parent) {
		return null;
	
		//VSpecResolution thisResolution = BvrFactory.eINSTANCE.createValueResolution();
		//thisResolution.setName(target.getName());
		// Value		
		/*
		PrimitiveValueSpecification value = (Primi.getInstance().makeValueSpecification((Variable) vSpecFound));
		PrimitiveTypeEnum type = ((PrimitveType) ((Variable)vSpecFound).getType()).getType();
		// Try searching for a type
		PrimitveType vt = PrimitiveTypeHandler.getInstance().makeType(view.getCU(), type);
		value.setType(vt);
		
		((VariableValueAssignment)thisResolution).setValue(value);
		thisResolution.setResolvedVSpec(vSpecFound);
		parent.getChild().add(thisResolution);
*/		
		//return thisResolution;
	}
}
