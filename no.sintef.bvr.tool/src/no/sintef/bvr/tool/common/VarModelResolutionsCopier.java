package no.sintef.bvr.tool.common;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import no.sintef.bvr.tool.interfaces.common.IVarModelResolutionsCopier;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import bvr.BVRModel;
import bvr.CompoundNode;
import bvr.CompoundResolution;

public class VarModelResolutionsCopier extends Copier implements IVarModelResolutionsCopier {

	private static final long serialVersionUID = -4440298144268645637L;

	private CompoundNode originalVM;
	private EList<CompoundResolution> originalRes;
	private CompoundNode copiedVM;
	private EList<CompoundResolution> copiedRes;
	private BVRModel original;
	private BVRModel copied;

	@Override
	public void copyAbsractions(BVRModel model) {
		clear();
		original = model;

		originalVM = model.getVariabilityModel();
		originalRes = model.getResolutionModels();

		copy(model);
		copyReferences();

		copied = (BVRModel) get(original);
		copied.getRealizationModel().clear();

		copiedRes = new BasicEList<CompoundResolution>();
		for (CompoundResolution copiedResolution : originalRes)
			copiedRes.add((CompoundResolution) get(copiedResolution));

		copiedVM = copied.getVariabilityModel();
	}

	@Override
	public CompoundNode getOriginalVariabilityModel() {
		return originalVM;
	}

	@Override
	public List<CompoundResolution> getOriginalResolutions() {
		return originalRes;
	}

	@Override
	public CompoundNode getCopiedVariabilityModel() {
		return copiedVM;
	}

	@Override
	public List<CompoundResolution> getCopiedResolutions() {
		return copiedRes;
	}

	@Override
	public BVRModel getOriginalBVRModel() {
		return original;
	}

	@Override
	public BVRModel getCopiedBVRModel() {
		return copied;
	}

	@Override
	public EObject getOriginalEObject(EObject eObject) {
		Set<Entry<EObject, EObject>> entrySet = entrySet();
		for (Entry<EObject, EObject> entry : entrySet) {
			if (entry.getValue().equals(eObject))
				return entry.getKey();
		}
		return null;
	}

}
