package no.sintef.bvr.engine.interfaces.common;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;

import bvr.FragmentSubstitution;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.engine.interfaces.fragment.IPlacementElementHolder;
import no.sintef.bvr.engine.interfaces.fragment.IReplacementElementHolder;


public interface ISubstitutionEngine {
	
	public void setLogger(Logger logger);
	
	public void init(EList<FragmentSubstitution> fragmentSubstitutions);
	
	public void subsitute(FragmentSubstitution fragmentSubstitution, boolean replace) throws RuntimeException;
	
	public HashMap<Resource, IResourceContentCopier> getCopiedBaseModels();
	
	public IBVRElementDeepCopier createBVRElementDeepCopier();
	
	public IEngineUtility getUtility();
	
	public IReplacementElementHolder createReplacementElementHolder(ReplacementFragmentType replacement);
	
	public IPlacementElementHolder createPlacementElementHolder(PlacementFragment placement);
	
}
