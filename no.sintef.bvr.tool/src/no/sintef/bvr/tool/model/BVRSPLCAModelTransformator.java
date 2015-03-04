package no.sintef.bvr.tool.model;


import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import bvr.BVRModel;
import bvr.CompoundNode;
import no.sintef.bvr.tool.interfaces.model.IBVRSPLCAModelTransformator;
import no.sintef.bvr.tool.strategy.ModifyNodeStrategy;

public class BVRSPLCAModelTransformator implements IBVRSPLCAModelTransformator {
	
	private ModifyNodeStrategy[] modifiers = {};
	private BVRModel model;
	
	public BVRSPLCAModelTransformator(BVRModel _model) {
		model = _model;
	}

	@Override
	public CompoundNode transformVarModelToSPLCA() {
		CompoundNode varModel = EcoreUtil.copy(model.getVariabilityModel());
		TreeIterator<EObject> iterator = varModel.eAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			for(ModifyNodeStrategy modifier : modifiers) {
				if(modifier.accept(eObject))
					modifier.modify(eObject);
			}
		}
		return varModel;
	}

}
