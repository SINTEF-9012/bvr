package no.sintef.bvr.tool.interfaces.model;

import no.sintef.bvr.tool.interfaces.common.IVarModelResolutionsCopier;
import bvr.CompoundNode;

public interface IBVRSPLCAModelTransformator {

	CompoundNode transformVarModelToSPLCA();

	IVarModelResolutionsCopier getModelCopier();

}
