package no.sintef.bvr.tool.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import bvr.BoundaryElementBinding;
import bvr.ChoiceResolutuion;
import bvr.BvrFactory;
import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.FromReplacement;
import bvr.ObjectHandle;
import bvr.PlacementBoundaryElement;
import bvr.PlacementFragment;
import bvr.ReplacementBoundaryElement;
import bvr.ReplacementFragmentType;
import bvr.ToBinding;
import bvr.ToPlacement;
import bvr.ToReplacement;
import bvr.VInstance;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.engine.common.BVRElementDeepCopier;
import no.sintef.bvr.engine.common.EngineUtility;
import no.sintef.bvr.engine.error.BasicBVREngineException;
import no.sintef.bvr.engine.fragment.impl.ReplacementElementHolder;
import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.BVRModelException;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.Symbol;
import no.sintef.bvr.tool.primitive.SymbolTable;
import no.sintef.bvr.tool.strategy.ScopeResolverStrategy;


public class ScopeResolverStrategyScopeable implements ScopeResolverStrategy {
	
	private HashMap<ReplacementFragmentType, HashMap<SymbolTable, ReplacementFragmentType>> replcmntSymbolMap;
	private HashMap<ReplacementFragmentType, BVRElementDeepCopier> replacementCopyMap;
	private HashMap<ReplacementFragmentType, HashSet<PlacementFragment>> replcmntPlcmntMap;
	private HashMap<PlacementFragment, HashSet<ReplacementFragmentType>> plcmntReplcmntMap;
	private HashMap<ReplacementFragmentType, HashMap<ReplacementBoundaryElement, ReplacementBoundaryElement>> replacementNewReplBoundaryMap;

	@Override
	public void resolveScopes(SymbolTable table) {
		replacementCopyMap = new HashMap<ReplacementFragmentType, BVRElementDeepCopier>();
		replcmntSymbolMap = new HashMap<ReplacementFragmentType, HashMap<SymbolTable, ReplacementFragmentType>>();
		replacementNewReplBoundaryMap = new HashMap<ReplacementFragmentType, HashMap<ReplacementBoundaryElement, ReplacementBoundaryElement>>();
		replcmntPlcmntMap = new HashMap<ReplacementFragmentType, HashSet<PlacementFragment>>();
		plcmntReplcmntMap = new HashMap<PlacementFragment, HashSet<ReplacementFragmentType>>();
		EList<FragmentSubstitution> fssToResolve = new BasicEList<FragmentSubstitution>(LoaderUtility.collectFragmentSubstitutionsInTable(table));
		caluclateReplacementPlacementIntersections(fssToResolve, replcmntPlcmntMap, plcmntReplcmntMap);
		symbolTableResolver(table);
	}
		
	private void symbolTableResolver(SymbolTable table){
		ArrayList<Symbol> symbols = prioritizeSymbols(table.getSymbols());
		for(Symbol symbol : symbols)
			resolverSymbol(symbol);
		ArrayList<SymbolTable> childScopes = table.getChildren();
		for(SymbolTable scope : childScopes){
			symbolTableResolver(scope);
		}
	}
	
	private ArrayList<Symbol> prioritizeSymbols(ArrayList<Symbol> symbols){
		ArrayList<Symbol> prioritizedSymbols = new ArrayList<Symbol>();
		Iterator<Symbol> iterator = symbols.iterator();
		while(iterator.hasNext()){
			Symbol symbol = iterator.next();
			if(symbol.getVSpecResolution() instanceof VInstance){
				prioritizedSymbols.add(0, symbol);
			}else{
				prioritizedSymbols.add(prioritizedSymbols.size(), symbol);
			}
		}
		return prioritizedSymbols;
	}
	
	private void resolverSymbol(Symbol symbol){
		EList<FragmentSubstitution> fragSubs = symbol.getFragmentSubstitutions();
		for(FragmentSubstitution fragSub : fragSubs){
			Context.eINSTANCE.logger.debug("ScopeResolverStrategyScopeable::resolverSymbol: processing " + fragSub + " of " + symbol.getVSpec().getName());
			
			PlacementFragment placement = fragSub.getPlacement();
			ReplacementFragmentType replacement = fragSub.getReplacement();
			
			HashSet<ReplacementFragmentType> containingReplacements = plcmntReplcmntMap.get(placement);
			if(containingReplacements != null){
				//if a placement is contained by any replacement, handle this
				for(ReplacementFragmentType containingReplacement : containingReplacements){
					PlacementFragment newPlacement;
					HashMap<PlacementBoundaryElement, PlacementBoundaryElement> placementBoundaryMap = new HashMap<PlacementBoundaryElement, PlacementBoundaryElement>();
					HashMap<SymbolTable, ReplacementFragmentType> rSymbolMap = replcmntSymbolMap.get(containingReplacement);
					if(rSymbolMap == null){
						//if a containing replacement has not been copied yet,
						//than we just create a pure copy of the placement
						//which still references the original model's elements
						newPlacement = copyPlacement(placement, placementBoundaryMap);
					}else{
						//if a containing replacement has been copied:
						//1) we proceed to the 'if' clause, if we have VInstance or CoiceResolution
						//(in case of VInstance, we need to make sure that the copied replacement in the correct scope. If not, then we just create a pure copy of the placement, see (2))
						//2) we proceed to the first 'else if' clause, if a resolved VSpec is VInstance and the copied replacement in another scope
						// where we simply create a pure copy of the placement
						//3) we proceed to the 'else' clause, if we do not know how to process VSpecResolution
						if((symbol.getVSpecResolution() instanceof VInstance && rSymbolMap.get(symbol.getParent().getScope()) != null)
								|| (symbol.getVSpecResolution() instanceof ChoiceResolutuion)){
							ReplacementFragmentType copiedReplacement;							
							if(symbol.getVSpecResolution() instanceof VInstance){
								copiedReplacement = rSymbolMap.get(symbol.getParent().getScope());
							}else if(symbol.getVSpecResolution() instanceof ChoiceResolutuion){
								copiedReplacement = rSymbolMap.get(symbol.getScope());
							}else{
								throw new UnsupportedOperationException("Epic fail: the nearest outermost loop should not allow processing symbols other than those which we process inside");
							}
							if(copiedReplacement == null)
								throw new UnsupportedOperationException("can not find copied replacement in the parent scope");
							BVRElementDeepCopier copyReplacementMap = replacementCopyMap.get(copiedReplacement);
							if(copyReplacementMap == null)
								throw new UnsupportedOperationException("replacement that containd a given placement was copied, but can not find map that contains original objects");
							newPlacement = createPlacementFragmentFromOriginal(copiedReplacement, copyReplacementMap, placement, placementBoundaryMap);
						}else if(symbol.getVSpecResolution() instanceof VInstance && rSymbolMap.get(symbol.getParent().getScope()) == null){
							newPlacement = copyPlacement(placement, placementBoundaryMap);
						}else{
							throw new UnsupportedOperationException("unsupported VSpecResolution, can not resolve a scope: " + symbol.getVSpecResolution());
						}
					}
					
					HashMap<ReplacementBoundaryElement, ReplacementBoundaryElement> replacementBoundaryMap = new HashMap<ReplacementBoundaryElement, ReplacementBoundaryElement>();
					ReplacementFragmentType newReplacement = testNewReplacementFragment(symbol, replacement, replacementBoundaryMap);
					//create a new fragment substitution with just created placement and replacement. We will eventually execute this fragment substitution
					createNewFragmentSubstitution(symbol, placementBoundaryMap, replacementBoundaryMap, newPlacement, newReplacement, fragSub);
				}
			}else{
				//if placement is not contained anyway create a copy of placement which references original elements and create a copy of the replacement fragment
				// it may be a case that the given replacement contains other placements
				HashMap<PlacementBoundaryElement, PlacementBoundaryElement> placementBoundaryMap = new HashMap<PlacementBoundaryElement, PlacementBoundaryElement>();
				PlacementFragment newPlacement = copyPlacement(placement, placementBoundaryMap);
				
				HashMap<ReplacementBoundaryElement, ReplacementBoundaryElement> replacementBoundaryMap = new HashMap<ReplacementBoundaryElement, ReplacementBoundaryElement>();
				ReplacementFragmentType newReplacement = testNewReplacementFragment(symbol, replacement, replacementBoundaryMap);
				createNewFragmentSubstitution(symbol, placementBoundaryMap, replacementBoundaryMap, newPlacement, newReplacement, fragSub);
			}
		}
	}
	
	private ReplacementFragmentType testNewReplacementFragment(
			Symbol symbol,
			ReplacementFragmentType replacement,
			HashMap<ReplacementBoundaryElement,
			ReplacementBoundaryElement> replacementBoundaryMap)
	{
		//create a copy of a replacement fragment in any case for a given fragment substitution
		ReplacementFragmentType newReplacement;
		HashMap<SymbolTable, ReplacementFragmentType> rSymbolTableReplcMap = replcmntSymbolMap.get(replacement);
		
		if(rSymbolTableReplcMap == null){
			//we here if we are sure that the given replacement has not been copied yet
			rSymbolTableReplcMap = new HashMap<SymbolTable, ReplacementFragmentType>();
			
			ReplacementElementHolder replacementHolder;
			try {
				replacementHolder = new ReplacementElementHolder(replacement);
			} catch (BasicBVREngineException e) {
				throw new UnsupportedOperationException(e);
			}
			BVRElementDeepCopier rplCopier = new BVRElementDeepCopier();
			//HashSet<EObject> replacementElements = replacementHolder.getNeighboringInsideElements();
			//replacementElements.addAll(replacementHolder.getNeighboringOutsideElements());
			HashSet<EObject> replacementElements = calculateReplacementCopiedElements(replacementHolder);
			rplCopier.copyElements(replacementElements);
			
			newReplacement = createReplacementFromOriginal(rplCopier, replacement, replacementBoundaryMap);
			checkReplacementConsistency(newReplacement);
			rSymbolTableReplcMap.put(symbol.getScope(), newReplacement);
			replcmntSymbolMap.put(replacement, rSymbolTableReplcMap);
			replacementNewReplBoundaryMap.put(newReplacement, replacementBoundaryMap);
			
			replacementCopyMap.put(newReplacement, rplCopier);
		}else{
			//make sure that the given replacement was copied for the correct scope if not then make a copy
			newReplacement = rSymbolTableReplcMap.get(symbol.getScope());
			if(newReplacement == null){
				ReplacementElementHolder replacementHolder;
				try {
					replacementHolder = new ReplacementElementHolder(replacement);
				} catch (BasicBVREngineException e) {
					throw new UnsupportedOperationException(e);
				}
				BVRElementDeepCopier rplCopier = new BVRElementDeepCopier();
				//HashSet<EObject> replacementElements = replacementHolder.getNeighboringInsideElements();
				//replacementElements.addAll(replacementHolder.getNeighboringOutsideElements());
				HashSet<EObject> replacementElements = calculateReplacementCopiedElements(replacementHolder);
				rplCopier.copyElements(replacementElements);
				
				newReplacement = createReplacementFromOriginal(rplCopier, replacement, replacementBoundaryMap);
				checkReplacementConsistency(newReplacement);
				rSymbolTableReplcMap.put(symbol.getScope(), newReplacement);
				replacementNewReplBoundaryMap.put(newReplacement, replacementBoundaryMap);
				
				replacementCopyMap.put(newReplacement, rplCopier);
			}else{
				replacementBoundaryMap.putAll(replacementNewReplBoundaryMap.get(newReplacement));
			}
		}
		return newReplacement;
	}
	
	private HashSet<EObject> calculateReplacementCopiedElements(
			ReplacementElementHolder replacementHolder){
		HashSet<EObject> elementsToCopy = new HashSet<EObject>();
		HashSet<EObject> insideReferencingElements = replacementHolder.getNeighboringInsideElements();
		HashSet<EObject> fromInsideReferencedElements = replacementHolder.getNeighboringOutsideElements();
		HashSet<EObject> innerFragmentElements = replacementHolder.getElements();
		elementsToCopy.addAll(insideReferencingElements);
		for(EObject outsideElement : fromInsideReferencedElements){
			EObject container = outsideElement.eContainer();
			if(!innerFragmentElements.contains(container) && !insideReferencingElements.contains(container))
				elementsToCopy.add(outsideElement);
		}
		return elementsToCopy;
	}
	
	private FragmentSubstitution createNewFragmentSubstitution(
			Symbol symbol,
			HashMap<PlacementBoundaryElement, PlacementBoundaryElement> placementBoundaryMap,
			HashMap<ReplacementBoundaryElement, ReplacementBoundaryElement> replacementBoundaryMap,
			PlacementFragment newPlacement,
			ReplacementFragmentType newReplacement,
			FragmentSubstitution oldFrgament)
	{
		FragmentSubstitution newFragmentSubstitution = BvrFactory.eINSTANCE.createFragmentSubstitution();
		newFragmentSubstitution.setName(symbol.getVSpecResolution().getName() + ":" + oldFrgament.getName());
		newFragmentSubstitution.setBindingVSpec(oldFrgament.getBindingVSpec());
		newFragmentSubstitution.setPlacement(newPlacement);
		newFragmentSubstitution.setReplacement(newReplacement);
		
		for(BoundaryElementBinding binding : oldFrgament.getBoundaryElementBinding()){
			if(binding instanceof ToBinding){
				ToBinding toBinding = (ToBinding) binding;
				ToBinding toBindingNew = BvrFactory.eINSTANCE.createToBinding();
				
				PlacementBoundaryElement toPlacementNew = placementBoundaryMap.get(toBinding.getToPlacement());
				if(toPlacementNew == null)
					throw new UnexpectedException("can not find copied toPlacement");
				toBindingNew.setToPlacement((ToPlacement) toPlacementNew);
				
				ReplacementBoundaryElement toReplacementNew = replacementBoundaryMap.get(toBinding.getToReplacement());
				if(toReplacementNew == null)
					throw new UnexpectedException("can not find copied toReplacement: " + toBinding.getToReplacement() + " in "
							+ replacementBoundaryMap + "("+ newPlacement +", "+ newReplacement +")");
				toBindingNew.setToReplacement((ToReplacement) toReplacementNew);
				
				newFragmentSubstitution.getBoundaryElementBinding().add(toBindingNew);
			}
			if(binding instanceof FromBinding){
				FromBinding fromBinding = (FromBinding) binding;
				FromBinding fromBindingNew = BvrFactory.eINSTANCE.createFromBinding();
				
				PlacementBoundaryElement fromPlacementNew = placementBoundaryMap.get(fromBinding.getFromPlacement());
				if(fromPlacementNew == null)
					throw new UnexpectedException("can not find copied fromPlacement: " + fromBinding.getFromPlacement() + " in "
							+ placementBoundaryMap + "("+ newPlacement +", "+ newReplacement +")");
				fromBindingNew.setFromPlacement((FromPlacement) fromPlacementNew);
				
				ReplacementBoundaryElement fromReplacementNew = replacementBoundaryMap.get(fromBinding.getFromReplacement());
				if(fromReplacementNew == null)
					throw new UnexpectedException("can not find copied fromReplacement: " + fromBinding.getFromReplacement() + " in "
							+ replacementBoundaryMap + "("+ newPlacement +", "+ newReplacement +")");
				fromBindingNew.setFromReplacement((FromReplacement) fromReplacementNew);
				
				newFragmentSubstitution.getBoundaryElementBinding().add(fromBindingNew);
			}
		}
		
		symbol.getScope().getConfigurableUnit().getOwnedVariabletype().add(newReplacement);
		symbol.getScope().getConfigurableUnit().getOwnedVariationPoint().add(newPlacement);
		symbol.setFragmentSubstitutionCopy(oldFrgament, newFragmentSubstitution);
		return newFragmentSubstitution;
	}

	private ReplacementFragmentType createReplacementFromOriginal(
			BVRElementDeepCopier rplCopier,
			ReplacementFragmentType replacement,
			HashMap<ReplacementBoundaryElement,
			ReplacementBoundaryElement> boundaryMap)
	{
		EList<ReplacementBoundaryElement> boundaryElements = replacement.getReplacementBoundaryElement();
		ReplacementFragmentType newReplacement = BvrFactory.eINSTANCE.createReplacementFragmentType();
		newReplacement.setName(replacement.getName());
		for(ReplacementBoundaryElement boundary : boundaryElements){
			if(boundary instanceof ToReplacement){
				if(!EngineUtility.isDummyToReplacement((ToReplacement) boundary)){
					ToReplacement newToReplacement = BvrFactory.eINSTANCE.createToReplacement();
					dublicateToReplacementAttr(newToReplacement, (ToReplacement) boundary);
					
					ObjectHandle objectHandleOutsideBElOrg = ((ToReplacement) boundary).getOutsideBoundaryElement();
					EObject eObject = objectHandleOutsideBElOrg.getMOFRef();
					EObject copyEObject = rplCopier.get(eObject);
					if(copyEObject == null)
						throw new UnexpectedException(
								"can not find an outside boundary element of the copied replacement '" +
								replacement.getName() + "' in the map for the element '" +
								eObject + "'");
					ObjectHandle objectHandle = EngineUtility.getObjectHandle(copyEObject, newReplacement.getSourceObject());
					if(objectHandle == null){
						objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
						objectHandle.setMOFRef(copyEObject);
						newReplacement.getSourceObject().add(objectHandle);
					}
					newToReplacement.setOutsideBoundaryElement(objectHandle);
					
					EList<ObjectHandle> objectHandleInsideBElOrg = ((ToReplacement) boundary).getInsideBoundaryElement();
					for(ObjectHandle oHandle : objectHandleInsideBElOrg){
						eObject = oHandle.getMOFRef();
						copyEObject = rplCopier.get(eObject);
						if(copyEObject == null)
							throw new UnexpectedException(
									"can not find an inside boundary element of the copied replacement '" +
									replacement.getName() + "' in the map for the element '" +
									eObject + "'");
						objectHandle = EngineUtility.getObjectHandle(copyEObject, newReplacement.getSourceObject());
						if(objectHandle == null){
							objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
							objectHandle.setMOFRef(copyEObject);
							newReplacement.getSourceObject().add(objectHandle);
						}
						newToReplacement.getInsideBoundaryElement().add(objectHandle);
					}
					newReplacement.getReplacementBoundaryElement().add(newToReplacement);
					boundaryMap.put(boundary, newToReplacement);
				}else{
					ToReplacement nullToReplacement = no.sintef.bvr.tool.common.LoaderUtility.testNullToReplacement(newReplacement);
					boundaryMap.put(boundary, nullToReplacement);
				}
			}
			if(boundary instanceof FromReplacement){
				FromReplacement newFromReplacement = BvrFactory.eINSTANCE.createFromReplacement();
				dublicateFromReplacementAttr(newFromReplacement, (FromReplacement) boundary);
				
				ObjectHandle objectHandleInsideBElOrg = ((FromReplacement) boundary).getInsideBoundaryElement();
				EObject copyEObject = rplCopier.get(objectHandleInsideBElOrg.getMOFRef());
				if(copyEObject == null)
					throw new UnexpectedException(
							"can not find inside boundary element of the copied replacement '" +
							replacement.getName() + "' in the map for the element '" +
							objectHandleInsideBElOrg.getMOFRef() + "'");
				ObjectHandle objectHandle = EngineUtility.getObjectHandle(copyEObject, newReplacement.getSourceObject());
				if(objectHandle == null){
					objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
					objectHandle.setMOFRef(copyEObject);
					newReplacement.getSourceObject().add(objectHandle);
				}
				newFromReplacement.setInsideBoundaryElement(objectHandle);
						
				EList<ObjectHandle> objectHandleOutsideBElOrg = ((FromReplacement) boundary).getOutsideBoundaryElement();
				for(ObjectHandle oHandle : objectHandleOutsideBElOrg){
					copyEObject = rplCopier.get(oHandle.getMOFRef());
					if(copyEObject == null)
						throw new UnexpectedException("can not find an outside boundary element of the copied replacement '" +
								replacement.getName() + "' in the map for the element '" +
								oHandle.getMOFRef());
					objectHandle = EngineUtility.getObjectHandle(copyEObject, newReplacement.getSourceObject());
					if(objectHandle == null){
						objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
						objectHandle.setMOFRef(copyEObject);
						newReplacement.getSourceObject().add(objectHandle);
					}
					newFromReplacement.getOutsideBoundaryElement().add(objectHandle);
				}
				
				newReplacement.getReplacementBoundaryElement().add(newFromReplacement);
				boundaryMap.put(boundary, newFromReplacement);
			}
		}
		return newReplacement;
	}
	
	private void checkReplacementConsistency(ReplacementFragmentType replacement){
		EList<ReplacementBoundaryElement> boundaries = replacement.getReplacementBoundaryElement();
		for(ReplacementBoundaryElement boundary : boundaries){
			if(boundary instanceof ToReplacement){
				ToReplacement toReplacement = (ToReplacement) boundary;
				EObject outsideBoundaryElement = toReplacement.getOutsideBoundaryElement().getMOFRef();
				if(outsideBoundaryElement == null)
					continue;
				EList<EObject> insideBoundaryElements = EngineUtility.resolveProxies(toReplacement.getInsideBoundaryElement());
				EList<EObject> referencedEObjects = CommonUtility.getReferencedEObjects(outsideBoundaryElement);
				SetView<EObject> difference = Sets.difference(new HashSet<EObject>(insideBoundaryElements),
						new HashSet<EObject>(referencedEObjects));
				if(!difference.isEmpty())
					throw new UnexpectedException("inconsistent replacement " +
							toReplacement + "elements " + difference +
							" insideBoundaryElements " + insideBoundaryElements);
			}
			if(boundary instanceof FromReplacement){
				FromReplacement fromReplacement = (FromReplacement) boundary;
				EObject insideBoundaryElement = fromReplacement.getInsideBoundaryElement().getMOFRef();
				EList<EObject> outsideBoundaryElements = EngineUtility.resolveProxies(fromReplacement.getOutsideBoundaryElement());
				EList<EObject> referencedEObjects = CommonUtility.getReferencedEObjects(insideBoundaryElement);
				SetView<EObject> difference = Sets.difference(new HashSet<EObject>(outsideBoundaryElements),
						new HashSet<EObject>(referencedEObjects));
				if(!difference.isEmpty())
					throw new UnexpectedException("inconsistent replacement " + 
							fromReplacement + "elements " + difference +
							" outsideBoundaryElements " + outsideBoundaryElements);
			}
		}
	}
	
	private PlacementFragment copyPlacement(PlacementFragment placement, HashMap<PlacementBoundaryElement, PlacementBoundaryElement> boundaryMap){
		PlacementFragment newPlacement = BvrFactory.eINSTANCE.createPlacementFragment();
		newPlacement.setName(placement.getName());
		for(ObjectHandle objectHandle : placement.getSourceObject()){
			ObjectHandle newObjectHandle = EcoreUtil.copy(objectHandle);
			newPlacement.getSourceObject().add(newObjectHandle);
		}
		
		for(PlacementBoundaryElement boundary : placement.getPlacementBoundaryElement()){
			if(boundary instanceof ToPlacement){
				ToPlacement toPlacement = (ToPlacement) boundary;
				ToPlacement newToPlacement = BvrFactory.eINSTANCE.createToPlacement();
				dublicateToPlacementAttr(newToPlacement, toPlacement);
				
				ObjectHandle outsideBoudaryElement = toPlacement.getOutsideBoundaryElement();
				ObjectHandle outsideBoundaryNew = EngineUtility.getObjectHandle(outsideBoudaryElement.getMOFRef(), newPlacement.getSourceObject());
				if(outsideBoundaryNew == null)
					throw new UnsupportedOperationException("can not find copied object handle");
				newToPlacement.setOutsideBoundaryElement(outsideBoundaryNew);
				
				for(ObjectHandle objectHandle : toPlacement.getInsideBoundaryElement()){
					ObjectHandle insideBoundaryNew = EngineUtility.getObjectHandle(objectHandle.getMOFRef(), newPlacement.getSourceObject());
					if(insideBoundaryNew == null)
						throw new UnsupportedOperationException("can not fined copied object handle");
					newToPlacement.getInsideBoundaryElement().add(insideBoundaryNew);
				}
				newPlacement.getPlacementBoundaryElement().add(newToPlacement);
				
				boundaryMap.put(toPlacement, newToPlacement);
			}
			if(boundary instanceof FromPlacement){
				FromPlacement fromPlacement = (FromPlacement) boundary;
				FromPlacement newFromPlacement = BvrFactory.eINSTANCE.createFromPlacement();
				dublicateFromPlacementAttr(newFromPlacement, fromPlacement);
				
				ObjectHandle insideBoudaryElement = fromPlacement.getInsideBoundaryElement();
				ObjectHandle insideBoundaryNew = EngineUtility.getObjectHandle(insideBoudaryElement.getMOFRef(), newPlacement.getSourceObject());
				if(insideBoundaryNew == null)
					throw new UnsupportedOperationException("can not find copied object handle");
				newFromPlacement.setInsideBoundaryElement(insideBoundaryNew);
				
				for(ObjectHandle objectHandle : fromPlacement.getOutsideBoundaryElement()){
					ObjectHandle outsideBoundaryNew = EngineUtility.getObjectHandle(objectHandle.getMOFRef(), newPlacement.getSourceObject());
					if(outsideBoundaryNew == null)
						throw new UnsupportedOperationException("can not fined copied object handle");
					newFromPlacement.getOutsideBoundaryElement().add(outsideBoundaryNew);
				}
				newPlacement.getPlacementBoundaryElement().add(newFromPlacement);
				
				boundaryMap.put(fromPlacement, newFromPlacement);
			}
		}
		
		return newPlacement;
	}
	
	private PlacementFragment createPlacementFragmentFromOriginal(
			ReplacementFragmentType replacementCopied,
			BVRElementDeepCopier replacementCopyMap,
			PlacementFragment originalPlacement,
			HashMap<PlacementBoundaryElement,
			PlacementBoundaryElement> boundaryMap)
	{		
		PlacementFragment newPlacement = BvrFactory.eINSTANCE.createPlacementFragment();
		newPlacement.setName(originalPlacement.getName());
		
		EList<PlacementBoundaryElement> boundaryElements = originalPlacement.getPlacementBoundaryElement();
		for(PlacementBoundaryElement boundary : boundaryElements){
			if(boundary instanceof ToPlacement){
				ToPlacement toPlacementNew = BvrFactory.eINSTANCE.createToPlacement();
				ToPlacement toPlacementOriginal = (ToPlacement) boundary;
				dublicateToPlacementAttr(toPlacementNew, toPlacementOriginal);
				
				ObjectHandle outsideBElOhOrg = toPlacementOriginal.getOutsideBoundaryElement();
				EObject outsideEObject = outsideBElOhOrg.getMOFRef();
				EObject copyEObject = replacementCopyMap.get(outsideEObject);
				ObjectHandle objectHandle = null;
				if(copyEObject != null){
					objectHandle = EngineUtility.getObjectHandle(copyEObject, newPlacement.getSourceObject());
					if(objectHandle == null){
						objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
						objectHandle.setMOFRef(copyEObject);
					}
				}
				
				if(objectHandle == null)
					throw new UnsupportedOperationException("can not find outdsideBoundaryElement to reference in the copied replacement for a new placement");
				newPlacement.getSourceObject().add(objectHandle);
				
				toPlacementNew.setOutsideBoundaryElement(objectHandle);
				
				EList<ObjectHandle> insideBElsOhOrg = toPlacementOriginal.getInsideBoundaryElement();
				EList<EObject> insideBElsOhOrgEObj = EngineUtility.resolveProxies(insideBElsOhOrg);
				for(EObject eObjectOrg : insideBElsOhOrgEObj){
					copyEObject = replacementCopyMap.get(eObjectOrg);
					if(copyEObject == null)
						throw new UnsupportedOperationException("can not find insideBoundaryElement to reference in the copied replacement for a new placement");
					objectHandle = EngineUtility.getObjectHandle(copyEObject, newPlacement.getSourceObject());
					if(objectHandle == null){
						objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
						objectHandle.setMOFRef(copyEObject);
						newPlacement.getSourceObject().add(objectHandle);
					}
					toPlacementNew.getInsideBoundaryElement().add(objectHandle);
				}
				newPlacement.getPlacementBoundaryElement().add(toPlacementNew);
				boundaryMap.put(boundary, toPlacementNew);
			}
			if(boundary instanceof FromPlacement){
				if(!EngineUtility.isDummyFromPlacement((FromPlacement) boundary)){	
					FromPlacement fromPlacementNew = BvrFactory.eINSTANCE.createFromPlacement();
					FromPlacement fromPlacementOriginal = (FromPlacement) boundary;
					dublicateFromPlacementAttr(fromPlacementNew, fromPlacementOriginal);
					
					ObjectHandle insideBElOhOrg = fromPlacementOriginal.getInsideBoundaryElement();
					EObject insideEObject = insideBElOhOrg.getMOFRef();
					EObject copyEObject = replacementCopyMap.get(insideEObject);
					if(copyEObject == null)
						throw new UnsupportedOperationException("can not find insideBoundaryElement to reference in the copied replacement for a new placement");
					ObjectHandle objectHandle = EngineUtility.getObjectHandle(copyEObject, newPlacement.getSourceObject());
					if(objectHandle == null){
						objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
						objectHandle.setMOFRef(copyEObject);
						newPlacement.getSourceObject().add(objectHandle);
					}
					fromPlacementNew.setInsideBoundaryElement(objectHandle);
					
					EList<ObjectHandle> outsideBElsOhOrg = fromPlacementOriginal.getOutsideBoundaryElement();
					for(ObjectHandle objectHandleOrg : outsideBElsOhOrg){
						objectHandle = null;
						EObject eObjectOriginal = objectHandleOrg.getMOFRef();
						copyEObject = replacementCopyMap.get(eObjectOriginal);
						if(copyEObject == null)
							throw new UnsupportedOperationException("can not find oiutsideBoundaryElement to reference in the copied replacement for a new placement");
						objectHandle = EngineUtility.getObjectHandle(copyEObject, newPlacement.getSourceObject());
						if(objectHandle == null){
							objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
							objectHandle.setMOFRef(copyEObject);
						}
						
						newPlacement.getSourceObject().add(objectHandle);
						fromPlacementNew.getOutsideBoundaryElement().add(objectHandle);
					}
					newPlacement.getPlacementBoundaryElement().add(fromPlacementNew);
					boundaryMap.put(boundary, fromPlacementNew);
				}else{
					FromPlacement nullFromPlacement = no.sintef.bvr.tool.common.LoaderUtility.testNullFromPlacement(newPlacement);
					boundaryMap.put(boundary, nullFromPlacement);
				}
			}
		}
		return newPlacement;
	}
	
	private void dublicateToPlacementAttr(ToPlacement newToPlacement, ToPlacement toPlacement){
		if(toPlacement.getName() != null)
			newToPlacement.setName(toPlacement.getName());
		if(toPlacement.getPropertyName() != null)
			newToPlacement.setPropertyName(toPlacement.getPropertyName());
		if(toPlacement.getToReplacement() != null)
			newToPlacement.setToReplacement(toPlacement.getToReplacement());
	}
	
	private void dublicateToReplacementAttr(ToReplacement newToReplacement, ToReplacement toReplacement){
		if(toReplacement.getName() != null)
			newToReplacement.setName(toReplacement.getName());
		if(toReplacement.getToPlacement() != null)
			newToReplacement.setToPlacement(toReplacement.getToPlacement());
	}
	
	private void dublicateFromPlacementAttr(FromPlacement newFromPlacement, FromPlacement fromPlacement){
		if(fromPlacement.getName() != null)
			newFromPlacement.setName(fromPlacement.getName());
		if(fromPlacement.getFromReplacement() != null)
			newFromPlacement.setFromReplacement(fromPlacement.getFromReplacement());
	}
	
	private void dublicateFromReplacementAttr(FromReplacement newFromReplacement, FromReplacement fromReplacement){
		if(fromReplacement.getName() != null)
			newFromReplacement.setName(fromReplacement.getName());
		if(fromReplacement.getFromPlacement() != null)
			newFromReplacement.setFromPlacement(fromReplacement.getFromPlacement());
		if(fromReplacement.getPropertyName() != null)
			newFromReplacement.setPropertyName(fromReplacement.getPropertyName());		
	}
	
	private void caluclateReplacementPlacementIntersections(
			EList<FragmentSubstitution> fragSubs,
			HashMap<ReplacementFragmentType, HashSet<PlacementFragment>> mapReplcmPlacm,
			HashMap<PlacementFragment, HashSet<ReplacementFragmentType>> mapPlcmReplcm)
	{
		HashSet<ReplacementFragmentType> replacements = new HashSet<ReplacementFragmentType>();
		HashSet<PlacementFragment> placements = new HashSet<PlacementFragment>();
		for(FragmentSubstitution fs : fragSubs){
			placements.add(fs.getPlacement());
			replacements.add(fs.getReplacement());
		}
		for(ReplacementFragmentType replacement : replacements){
			for(PlacementFragment placement : placements){
				int result = EngineUtility.testPlacementIntersection(replacement, placement);
				if(result == EngineUtility.CNTND){
					HashSet<PlacementFragment> plcmntList = mapReplcmPlacm.get(replacement);
					if(plcmntList == null){
						plcmntList = new HashSet<PlacementFragment>();
						plcmntList.add(placement);
						mapReplcmPlacm.put(replacement, plcmntList);
					}else{
						plcmntList.add(placement);
					}
					
					HashSet<ReplacementFragmentType> replcmList = mapPlcmReplcm.get(placement);
					if(replcmList == null){
						replcmList = new HashSet<ReplacementFragmentType>();
						replcmList.add(replacement);
						mapPlcmReplcm.put(placement, replcmList);
					}else{
						replcmList.add(replacement);
					}
				}else if(result == EngineUtility.P_CNTND){
					throw new BVRModelException("the placement: " + placement + " is partially contained in the replacement: " + replacement + ", can not handle");
				}
			}
		}
	}
}
