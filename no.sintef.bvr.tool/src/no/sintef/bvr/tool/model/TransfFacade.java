package no.sintef.bvr.tool.model;

import no.sintef.bvr.tool.interfaces.model.IBVRModelTransformation;

public final class TransfFacade {
	
	public static TransfFacade eINSTANCE = getInstance();
	private IBVRModelTransformation transf;
	
	private TransfFacade() {
		transf = new ModelSPLCATransformation();
	}
	
	private static TransfFacade getInstance() {
		if(eINSTANCE == null) {
			eINSTANCE = new TransfFacade();
		}
		return eINSTANCE;
	}
	
	public IBVRModelTransformation getSPLCATransformator() {
		return transf;
	}

}
