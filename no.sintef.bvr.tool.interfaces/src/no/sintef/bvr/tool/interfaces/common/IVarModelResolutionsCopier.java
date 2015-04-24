package no.sintef.bvr.tool.interfaces.common;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import bvr.BVRModel;
import bvr.CompoundNode;
import bvr.CompoundResolution;

public interface IVarModelResolutionsCopier {

	public void copyAbsractions(BVRModel model);

	public CompoundNode getOriginalVariabilityModel();

	public List<CompoundResolution> getOriginalResolutions();

	public CompoundNode getCopiedVariabilityModel();

	public List<CompoundResolution> getCopiedResolutions();

	public BVRModel getOriginalBVRModel();

	public BVRModel getCopiedBVRModel();

	public EObject getOriginalEObject(EObject eObject);

}
