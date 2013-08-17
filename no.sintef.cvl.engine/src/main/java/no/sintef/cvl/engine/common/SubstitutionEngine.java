package no.sintef.cvl.engine.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import no.sintef.cvl.common.logging.Logger;
import no.sintef.cvl.engine.adjacent.AdjacentFinder;
import no.sintef.cvl.engine.adjacent.AdjacentResolver;
import no.sintef.cvl.engine.adjacent.impl.AdjacentFinderImpl;
import no.sintef.cvl.engine.adjacent.impl.AdjacentResolverImpl;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.error.ContainmentCVLModelException;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.operation.impl.FragmentSubOperation;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectEList;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import cvl.FragmentSubstitution;
import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.ObjectHandle;
import cvl.PlacementBoundaryElement;
import cvl.PlacementFragment;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragmentType;
import cvl.ToPlacement;
import cvl.ToReplacement;

public final class SubstitutionEngine {

	public static final SubstitutionEngine eINSTANCE = getEngine();
	
	private final SubstitutionContext context = SubstitutionContext.ME;
	
	private HashMap<FragmentSubstitution, FragmentSubstitutionHolder> fsMap;
	private AdjacentFinder adjFinder;
	private AdjacentResolver adjResolver;
	private HashMap<ReplacementFragmentType, HashSet<PlacementFragment>> replcmntPlcmntMap;
	private HashMap<PlacementFragment, HashSet<ReplacementFragmentType>> plcmntReplcmntMap;
	private HashMap<PlacementFragment, HashMap<ReplacementFragmentType, HashMap<ToPlacement, HashSet<ToReplacement>>>> adjacentToBoundaries;
	private HashMap<PlacementFragment, HashMap<ReplacementFragmentType, HashMap<FromPlacement, HashSet<FromReplacement>>>> adjacentFromBoundaries;

	private static SubstitutionEngine getEngine() {
		return new SubstitutionEngine();
	}
	
	public void setLogger(Logger logger){
		context.setLogger(logger);
	}
	
	public void init(EList<FragmentSubstitution> fragmentSubstitutions){
		adjacentToBoundaries = new HashMap<PlacementFragment, HashMap<ReplacementFragmentType, HashMap<ToPlacement, HashSet<ToReplacement>>>>();
		adjacentFromBoundaries = new HashMap<PlacementFragment, HashMap<ReplacementFragmentType, HashMap<FromPlacement, HashSet<FromReplacement>>>>();
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
		EList<HashMap> maps = Utility.caluclateReplacementPlacementIntersections(fragmentSubstitutions);
		replcmntPlcmntMap = maps.get(0);
		plcmntReplcmntMap = maps.get(1);
		System.out.println(replcmntPlcmntMap);
		System.out.println(plcmntReplcmntMap);
		findAdjacentBoundaries();
	}
	
	public void subsitute(FragmentSubstitution fragmentSubstitution, boolean replace) throws ContainmentCVLModelException{
		FragmentSubstitutionHolder fragmentHolder = fsMap.get(fragmentSubstitution);
		if(fragmentHolder == null){
			context.getLogger().warn("engine is not initialized with this fragment substitution " + fragmentSubstitution);
			return;
		}
		FragmentSubOperation subsOperation = new FragmentSubOperation(fragmentHolder);
		try {
			subsOperation.execute(replace);
			adjResolver.resolve(fragmentHolder);
			adjustBoundaries(fragmentHolder);
		} catch (BasicCVLEngineException e) {
			context.getLogger().error("", e);
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
	
	private void adjustBoundaries(FragmentSubstitutionHolder fragmentHolder){
		PlacementFragment placement = fragmentHolder.getPlacement().getPlacementFragment();
		
		HashMap<ReplacementFragmentType, HashMap<ToPlacement, HashSet<ToReplacement>>> replacementToBoundary = adjacentToBoundaries.get(placement);
		if(replacementToBoundary != null){
			for(Map.Entry<ReplacementFragmentType, HashMap<ToPlacement, HashSet<ToReplacement>>> entry : replacementToBoundary.entrySet()){
				HashMap<ToPlacement, HashSet<ToReplacement>> boundarysMap = entry.getValue();
				for(Map.Entry<ToPlacement, HashSet<ToReplacement>> boundaryMap : boundarysMap.entrySet()){
					ToPlacement toPlacement = boundaryMap.getKey();
					HashSet<ToReplacement> toReplacements = boundaryMap.getValue();
					for(ToReplacement toReplacement : toReplacements){
						EList<EObject> invalidEObjects = findInvalidObjects(toReplacement);
						removeInvalidReferences(toReplacement, invalidEObjects);
						adjustInsideBoundaryRefereneces(toReplacement, toPlacement, placement);
					}
				}
			}
		}
		
		HashMap<ReplacementFragmentType, HashMap<FromPlacement, HashSet<FromReplacement>>> replacementFromBoundary = adjacentFromBoundaries.get(placement);
		if(replacementFromBoundary != null){
			for(Map.Entry<ReplacementFragmentType, HashMap<FromPlacement, HashSet<FromReplacement>>> entry : replacementFromBoundary.entrySet()){
				HashMap<FromPlacement, HashSet<FromReplacement>> boundarysMap = entry.getValue();
				for(Map.Entry<FromPlacement, HashSet<FromReplacement>> boundaryMap : boundarysMap.entrySet()){
					FromPlacement fromPlacement = boundaryMap.getKey();
					HashSet<FromReplacement> fromReplacements = boundaryMap.getValue();
					EObject insideElementPlac = fromPlacement.getInsideBoundaryElement().getMOFRef();
					for(FromReplacement fromReplacement : fromReplacements){
						EObject insideElementRepl = fromReplacement.getInsideBoundaryElement().getMOFRef();
						if(!insideElementPlac.equals(insideElementRepl)){
							ObjectHandle objectHandle = no.sintef.cvl.common.Utility.testObjectHandle(entry.getKey(), insideElementPlac);
							fromReplacement.setInsideBoundaryElement(objectHandle);
						}
					}
				}
			}
		}
	}
	
	private void adjustInsideBoundaryRefereneces(ToReplacement toReplacement, ToPlacement toPlacement, PlacementFragment placement){
		EList<EObject> insideEObjectsRepl = Utility.resolveProxies(toReplacement.getInsideBoundaryElement());
		EList<EObject> insideEObjectsPlc = Utility.resolveProxies(toPlacement.getInsideBoundaryElement());
		for(EObject eObject : insideEObjectsPlc){
			if(insideEObjectsRepl.indexOf(eObject) < 0){
				ObjectHandle objectHandle = no.sintef.cvl.common.Utility.testObjectHandle(placement, eObject);
				toReplacement.getInsideBoundaryElement().add(objectHandle);
			}
		}
	}
	
	private void removeInvalidReferences(ToReplacement toReplacement, EList<EObject> invalidEObjects){
		if(invalidEObjects.isEmpty())
			return;
		EList<ObjectHandle> objectHandles = toReplacement.getInsideBoundaryElement();
		Iterator<ObjectHandle> iterator = objectHandles.iterator();
		while(iterator.hasNext()){
			ObjectHandle objectHandle = iterator.next();
			EObject eObject = objectHandle.getMOFRef();
			if(invalidEObjects.indexOf(eObject) >= 0){
				//objectHandles.remove(objectHandle);
				iterator.remove();
			}
		}
	}
	
	private EList<EObject> findInvalidObjects(ToReplacement toReplacement){
		EObject outsideBoundaryElement = toReplacement.getOutsideBoundaryElement().getMOFRef();
		EList<EObject> referencedEObjects = getReferencedObjects(outsideBoundaryElement);
		EList<ObjectHandle> objectHandles = toReplacement.getInsideBoundaryElement();
		EList<EObject> insideBoundaryElements = Utility.resolveProxies(objectHandles);
		SetView<EObject> difference = Sets.difference(new HashSet<EObject>(insideBoundaryElements), new HashSet<EObject>(referencedEObjects));
		return new BasicEList<EObject>(difference);
	}
	
	private EList<EObject> getReferencedObjects(EObject eObject){
		EList<EObject> eObjects = new BasicEList<EObject>();
		EList<EReference> references = eObject.eClass().getEAllReferences();
		for(EReference reference : references){
			Object targetObject = eObject.eGet(reference);
			if(no.sintef.cvl.common.Utility.isDerived(reference) != 0)
				continue;
			if(targetObject instanceof EObject){
				EObject targetEObject = (EObject) targetObject;
				eObjects.add(targetEObject);
			}else if(targetObject instanceof BasicEList){
				EList<EObject> eEObjects =  (BasicEList<EObject>) targetObject;
				eObjects.addAll(eEObjects);
			}else if(targetObject != null){
				System.out.println(targetObject.getClass());
				context.getLogger().warn("an element referenced by " + reference + " is neither EObject nor EObjectList: " + targetObject);
			}
		}
		return eObjects;
	}
	
	private void findAdjacentBoundaries(){
		for(Map.Entry<PlacementFragment, HashSet<ReplacementFragmentType>> entry : plcmntReplcmntMap.entrySet()){
			PlacementFragment placement = entry.getKey();
			HashSet<ReplacementFragmentType> replacements = entry.getValue();
			EList<PlacementBoundaryElement> pBoundaries = placement.getPlacementBoundaryElement();
			for(ReplacementFragmentType replacement : replacements){
				EList<ReplacementBoundaryElement> rBoundaries = replacement.getReplacementBoundaryElement();
				for(PlacementBoundaryElement pBoundary : pBoundaries){
					if(pBoundary instanceof ToPlacement){
						ToPlacement toPlacement = (ToPlacement) pBoundary;
						for(ReplacementBoundaryElement rBoundary : rBoundaries){
							if(rBoundary instanceof ToReplacement){
								ToReplacement toReplacement = (ToReplacement) rBoundary;
								if(isToBoundaryAdjacent(toPlacement, toReplacement)){
									HashMap<ReplacementFragmentType, HashMap<ToPlacement, HashSet<ToReplacement>>> replacementBoundaryMap = adjacentToBoundaries.get(placement);
									if(replacementBoundaryMap == null){
										replacementBoundaryMap = new HashMap<ReplacementFragmentType, HashMap<ToPlacement, HashSet<ToReplacement>>>();
										HashMap<ToPlacement, HashSet<ToReplacement>> toBoundaryMap = new HashMap<ToPlacement, HashSet<ToReplacement>>();
										replacementBoundaryMap.put(replacement, toBoundaryMap);
										adjacentToBoundaries.put(placement, replacementBoundaryMap);
									}
									HashMap<ToPlacement, HashSet<ToReplacement>> toBoundaryMap = replacementBoundaryMap.get(replacement);
									HashSet<ToReplacement> toReplacements = toBoundaryMap.get(toPlacement);
									if(toReplacements == null){
										toReplacements = new HashSet<ToReplacement>();
										toBoundaryMap.put(toPlacement, toReplacements);
									}
									toReplacements.add(toReplacement);
								}
							}
						}
					}
					if(pBoundary instanceof FromPlacement){
						FromPlacement fromPlacement = (FromPlacement) pBoundary;
						for(ReplacementBoundaryElement rBoundary : rBoundaries){
							if(rBoundary instanceof FromReplacement){
								FromReplacement fromReplacement = (FromReplacement) rBoundary;
								if(isFromBoundaryAdjacent(fromPlacement, fromReplacement)){
									HashMap<ReplacementFragmentType, HashMap<FromPlacement, HashSet<FromReplacement>>> replacementBoundaryMap = adjacentFromBoundaries.get(placement);
									if(replacementBoundaryMap == null){
										replacementBoundaryMap = new HashMap<ReplacementFragmentType, HashMap<FromPlacement, HashSet<FromReplacement>>>();
										HashMap<FromPlacement, HashSet<FromReplacement>> fromBoundaryMap = new HashMap<FromPlacement, HashSet<FromReplacement>>();
										replacementBoundaryMap.put(replacement, fromBoundaryMap);
										adjacentFromBoundaries.put(placement, replacementBoundaryMap);
									}
									HashMap<FromPlacement, HashSet<FromReplacement>> fromBoundaryMap = replacementBoundaryMap.get(replacement);
									HashSet<FromReplacement> fromReplacements = fromBoundaryMap.get(fromPlacement);
									if(fromReplacements == null){
										fromReplacements = new HashSet<FromReplacement>();
										fromBoundaryMap.put(fromPlacement, fromReplacements);
									}
									fromReplacements.add(fromReplacement);
								}
							}
						}
					}
				}
			}
		}
	}
	
	private boolean isToBoundaryAdjacent(ToPlacement toPlacement, ToReplacement toReplacement){
		if(toPlacement.getOutsideBoundaryElement().getMOFRef().equals(toReplacement.getOutsideBoundaryElement().getMOFRef())){
			EList<EObject> insideBoundaryPlacement = Utility.resolveProxies(toPlacement.getInsideBoundaryElement());
			EList<EObject> insideBoundaryReplacement = Utility.resolveProxies(toReplacement.getInsideBoundaryElement());
			SetView<EObject> intersection = Sets.intersection(new HashSet<EObject>(insideBoundaryPlacement), new HashSet<EObject>(insideBoundaryReplacement));
			if(!intersection.isEmpty()){
				return true;
			}
		}
		return false;
	}
	
	private boolean isFromBoundaryAdjacent(FromPlacement fromPlacement, FromReplacement fromReplacement){
		if(fromReplacement.getInsideBoundaryElement().getMOFRef().equals(fromPlacement.getInsideBoundaryElement().getMOFRef())){
			EList<EObject> outsideBoundaryPlacement = Utility.resolveProxies(fromPlacement.getOutsideBoundaryElement());
			EList<EObject> outsideBoundaryReplacement = Utility.resolveProxies(fromReplacement.getOutsideBoundaryElement());
			SetView<EObject> intersection = Sets.intersection(new HashSet<EObject>(outsideBoundaryPlacement), new HashSet<EObject>(outsideBoundaryReplacement));
			if(!intersection.isEmpty()){
				return true;
			}
		}
		return false;
	}
}
