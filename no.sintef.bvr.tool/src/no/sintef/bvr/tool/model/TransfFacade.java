package no.sintef.bvr.tool.model;

import bvr.BVRModel;
import no.sintef.bvr.tool.interfaces.model.IBVRSPLCAModelTransformator;

public final class TransfFacade {
	
	public static TransfFacade eINSTANCE = getInstance();
	
	
	
	private static TransfFacade getInstance() {
		if(eINSTANCE == null) {
			eINSTANCE = new TransfFacade();
		}
		return eINSTANCE;
	}
	
	public IBVRSPLCAModelTransformator getSPLCATransformator(BVRModel model) {
		return new BVRSPLCAModelTransformator(model) ;
	}

}
