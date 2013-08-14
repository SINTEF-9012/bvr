package no.sintef.cvl.engine.common;

import java.util.HashMap;
import java.util.HashSet;

import no.sintef.cvl.common.logging.Logger;
import no.sintef.cvl.engine.adjacent.AdjacentFinder;
import no.sintef.cvl.engine.adjacent.AdjacentResolver;
import no.sintef.cvl.engine.adjacent.impl.AdjacentFinderImpl;
import no.sintef.cvl.engine.adjacent.impl.AdjacentResolverImpl;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.error.ContainmentCVLModelException;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.fragment.impl.PlacementElementHolder;
import no.sintef.cvl.engine.fragment.impl.ReplacementElementHolder;
import no.sintef.cvl.engine.operation.impl.FragmentSubOperation;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import cvl.CvlFactory;
import cvl.FragmentSubstitution;
import cvl.ObjectHandle;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentType;

public final class SubstitutionEngine {

	public static final SubstitutionEngine eINSTANCE = getEngine();
	
	private final SubstitutionContext context = SubstitutionContext.ME;
	
	private HashMap<FragmentSubstitution, FragmentSubstitutionHolder> fsMap;
	private AdjacentFinder adjFinder;
	private AdjacentResolver adjResolver;

	private static SubstitutionEngine getEngine() {
		return new SubstitutionEngine();
	}
	
	public void setLogger(Logger logger){
		context.setLogger(logger);
	}
	
	public void init(EList<FragmentSubstitution> fragmentSubstitutions){
		fsMap = new HashMap<FragmentSubstitution, FragmentSubstitutionHolder>();
		try{
			for(FragmentSubstitution fragment : fragmentSubstitutions){
				fsMap.put(fragment, new FragmentSubstitutionHolder(fragment));
			}
			computeCopyBaseModel();
			adjFinder = new AdjacentFinderImpl(new BasicEList<FragmentSubstitutionHolder>(fsMap.values()));
			adjResolver = new AdjacentResolverImpl(adjFinder);
		} catch (BasicCVLEngineException e) {
			e.printStackTrace();
			throw new UnsupportedOperationException(e.getMessage());
		}
	}
	
	public void subsitute(FragmentSubstitution fragmentSubstitution, boolean replace) throws ContainmentCVLModelException{
		FragmentSubstitutionHolder frgamentHolder = fsMap.get(fragmentSubstitution);
		if(frgamentHolder == null){
			context.getLogger().warn("engine is not initialized with this fragment substitution " + fragmentSubstitution);
			return;
		}
		FragmentSubOperation subsOperation = new FragmentSubOperation(frgamentHolder);
		try {
			subsOperation.execute(replace);
			adjResolver.resolve(frgamentHolder);
		} catch (BasicCVLEngineException e) {
			e.printStackTrace();
			throw new UnsupportedOperationException(e.getMessage());
		}
		subsOperation.checkConsistence();
	}
	
	public HashMap<Resource, ResourceContentCopier> getCopiedBaseModels(){
		return context.getCopyBaseModelMap();
	}
	
	private void computeCopyBaseModel(){
		EList<Resource> baseResources = new BasicEList<Resource>();
		EList<FragmentSubstitution> fragments = new BasicEList<FragmentSubstitution>(fsMap.keySet());
		for(FragmentSubstitution fragment : fragments){
			EList<ObjectHandle> objectHandles = fragment.getPlacement().getSourceObject();
			EList<EObject> eObjects = Utility.resolveProxies(objectHandles);
			for(EObject eObject : eObjects){
				if(eObject != null && eObject.eResource() != null && baseResources.indexOf(eObject.eResource()) < 0){
					baseResources.add(eObject.eResource());
				}
			}
		}
		context.setBaseModel(baseResources);
		
		HashMap<Resource, ResourceContentCopier> copyMap = new HashMap<Resource, ResourceContentCopier>();
		for(Resource resource : baseResources){
			ResourceContentCopier copier = new ResourceContentCopier();
			copier.copyResource(resource);
			copyMap.put(resource, copier);
		}
		context.setCopyBaseModelMap(copyMap);
	}
	
	public FragmentSubstitution testFragmentSubstitution(FragmentSubstitution fragmentToCopy,  EList<FragmentSubstitution> testedFragments){
		//fragment = CvlFactory.eINSTANCE.createFragmentSubstitution();
		FragmentSubstitution fragment = EcoreUtil.copy(fragmentToCopy);
		ReplacementElementHolder replacementHolder = null;
		try {
			replacementHolder = new ReplacementElementHolder(fragmentToCopy.getReplacement());
		} catch (BasicCVLEngineException e) {
			throw new UnsupportedOperationException(e);
		}
		HashSet<PlacementElementHolder> placementHolders = new HashSet<PlacementElementHolder>();
		for(FragmentSubstitution fragSub : testedFragments){
			try {
				placementHolders.add(new PlacementElementHolder(fragSub.getPlacement()));
			} catch (BasicCVLEngineException e) {
				throw new UnsupportedOperationException(e);
			}
		}
		CVLFragmentCopier rplCopier = new CVLFragmentCopier();
		HashSet<EObject> replacementInnerElements = replacementHolder.getElements();
		rplCopier.copyFragment(replacementInnerElements);
		return fragment;
	}
}
