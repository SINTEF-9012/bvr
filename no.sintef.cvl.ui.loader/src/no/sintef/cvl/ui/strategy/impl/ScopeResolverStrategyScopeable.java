package no.sintef.cvl.ui.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import cvl.BoundaryElementBinding;
import cvl.CvlFactory;
import cvl.FragmentSubstitution;
import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.ObjectHandle;
import cvl.PlacementBoundaryElement;
import cvl.PlacementFragment;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragmentType;
import cvl.ToBinding;
import cvl.ToPlacement;
import cvl.ToReplacement;
import cvl.VInstance;
import cvl.VSpecResolution;

import no.sintef.cvl.engine.common.CVLFragmentCopier;
import no.sintef.cvl.engine.common.Utility;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.error.ContainmentCVLModelException;
import no.sintef.cvl.engine.fragment.impl.ReplacementElementHolder;
import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.primitive.Symbol;
import no.sintef.cvl.ui.primitive.SymbolTable;
import no.sintef.cvl.ui.strategy.ScopeResolverStrategy;

public class ScopeResolverStrategyScopeable implements ScopeResolverStrategy {
	
	private HashMap<ReplacementFragmentType, HashMap<SymbolTable, ReplacementFragmentType>> replcmntSymbolMap;
	private HashMap<ReplacementFragmentType, CVLFragmentCopier> replacementCopyMap;
	private HashMap<ReplacementFragmentType, HashSet<PlacementFragment>> replcmntPlcmntMap;
	private HashMap<PlacementFragment, HashSet<ReplacementFragmentType>> plcmntReplcmntMap;

	@Override
	public void resolveScopes(SymbolTable table) {
		replacementCopyMap = new HashMap<ReplacementFragmentType, CVLFragmentCopier>();
		replcmntSymbolMap = new HashMap<ReplacementFragmentType, HashMap<SymbolTable, ReplacementFragmentType>>();
		EList<FragmentSubstitution> fssToResolve = new BasicEList<FragmentSubstitution>(getFragmentSubstitutionsToResolve(table));
		EList<HashMap> maps = Utility.caluclateReplacementPlacementIntersections(fssToResolve);
		replcmntPlcmntMap = maps.get(0);
		plcmntReplcmntMap = maps.get(1);
		symbolTableResolver(table);
	}
	
	private HashSet<FragmentSubstitution> getFragmentSubstitutionsToResolve(SymbolTable table){
		HashSet<FragmentSubstitution> fss = new HashSet<FragmentSubstitution>();
		ArrayList<Symbol> symbols = table.getSymbols();
		for(Symbol symbol : symbols){
			fss.addAll(symbol.getFragmentSubstitutions());
		}
		ArrayList<SymbolTable> tables = table.getChildren();
		for(SymbolTable symbolTable : tables){
			fss.addAll(getFragmentSubstitutionsToResolve(symbolTable));
		}
		return fss;
	}
	
	private void symbolTableResolver(SymbolTable table){
		SymbolTable parentScope = table.getParent();
		if(parentScope != null){
			ArrayList<Symbol> symbols = table.getSymbols();
			for(Symbol symbol : symbols){
				VSpecResolution vSpecResolution = symbol.getVSpecResolution();
				if(vSpecResolution instanceof VInstance){
					vInstanceResolver(symbol);
				}
			}
		}
		ArrayList<SymbolTable> childScopes = table.getChildren();
		for(SymbolTable scope : childScopes){
			symbolTableResolver(scope);
		}
	}
	
	private void vInstanceResolver(Symbol symbol){
		EList<FragmentSubstitution> fragSubs = symbol.getFragmentSubstitutions();
		for(FragmentSubstitution fragSub : fragSubs){
			PlacementFragment placement = fragSub.getPlacement();
			ReplacementFragmentType replacement = fragSub.getReplacement();
			
			HashSet<ReplacementFragmentType> containingReplacements = plcmntReplcmntMap.get(placement);
			if(containingReplacements != null){
				for(ReplacementFragmentType containingReplacement : containingReplacements){
					PlacementFragment newPlacement;
					HashMap<PlacementBoundaryElement, PlacementBoundaryElement> placementBoundaryMap = new HashMap<PlacementBoundaryElement, PlacementBoundaryElement>();
					HashMap<SymbolTable, ReplacementFragmentType> rSymbolMap = replcmntSymbolMap.get(containingReplacement);
					if(rSymbolMap == null){
						newPlacement = copyPlacement(placement, placementBoundaryMap);
					}else{
						ReplacementFragmentType copiedReplacement = rSymbolMap.get(symbol.getScope().getParent());
						if(copiedReplacement == null)
							throw new UnsupportedOperationException("can not find copied replacement in the parent scope");
						CVLFragmentCopier copyReplacementMap = replacementCopyMap.get(copiedReplacement);
						if(copyReplacementMap == null)
							throw new UnsupportedOperationException("replacement that containd a given placement was copied, but can not find map that contines original objects");
						newPlacement = createPlacementFragmentFromOriginal(copiedReplacement, copyReplacementMap, placement, placementBoundaryMap);
					}
					
					ReplacementFragmentType newReplacement;
					HashMap<SymbolTable, ReplacementFragmentType> rSymbolTableReplcMap = replcmntSymbolMap.get(replacement);
					HashMap<ReplacementBoundaryElement, ReplacementBoundaryElement> replacementBoundaryMap = new HashMap<ReplacementBoundaryElement, ReplacementBoundaryElement>();
					
					if(rSymbolTableReplcMap == null){
						rSymbolTableReplcMap = new HashMap<SymbolTable, ReplacementFragmentType>();
						
						ReplacementElementHolder replacementHolder;
						try {
							replacementHolder = new ReplacementElementHolder(replacement);
						} catch (BasicCVLEngineException e) {
							throw new UnsupportedOperationException(e);
						}
						CVLFragmentCopier rplCopier = new CVLFragmentCopier();
						//HashSet<EObject> replacementInnerElements = replacementHolder.getElements();
						HashSet<EObject> replacementInnerElements = replacementHolder.getOuterFragmentElements();
						rplCopier.copyFragment(replacementInnerElements);
						
						newReplacement = createReplacementFromOriginal(rplCopier, replacement, replacementBoundaryMap);
						rSymbolTableReplcMap.put(symbol.getScope(), newReplacement);
						replcmntSymbolMap.put(replacement, rSymbolTableReplcMap);
						
						replacementCopyMap.put(newReplacement, rplCopier);
					}else{
						newReplacement = rSymbolTableReplcMap.get(symbol.getScope());
						
						ReplacementElementHolder replacementHolder;
						try {
							replacementHolder = new ReplacementElementHolder(replacement);
						} catch (BasicCVLEngineException e) {
							throw new UnsupportedOperationException(e);
						}
						CVLFragmentCopier rplCopier = new CVLFragmentCopier();
						//HashSet<EObject> replacementInnerElements = replacementHolder.getElements();
						HashSet<EObject> replacementInnerElements = replacementHolder.getOuterFragmentElements();
						rplCopier.copyFragment(replacementInnerElements);
						
						newReplacement = createReplacementFromOriginal(rplCopier, replacement, replacementBoundaryMap);
						rSymbolTableReplcMap.put(symbol.getScope(), newReplacement);
						
						replacementCopyMap.put(newReplacement, rplCopier);
					}
					
					createNewFrgamentSubstitution(symbol, placementBoundaryMap, replacementBoundaryMap, newPlacement, newReplacement, fragSub);
				}
			}else{
				PlacementFragment newPlacement;
				HashMap<PlacementBoundaryElement, PlacementBoundaryElement> placementBoundaryMap = new HashMap<PlacementBoundaryElement, PlacementBoundaryElement>();
				newPlacement = copyPlacement(placement, placementBoundaryMap);
				
				ReplacementFragmentType newReplacement;
				HashMap<SymbolTable, ReplacementFragmentType> rSymbolTableReplcMap = replcmntSymbolMap.get(replacement);
				HashMap<ReplacementBoundaryElement, ReplacementBoundaryElement> replacementBoundaryMap = new HashMap<ReplacementBoundaryElement, ReplacementBoundaryElement>();
				
				if(rSymbolTableReplcMap == null){
					rSymbolTableReplcMap = new HashMap<SymbolTable, ReplacementFragmentType>();
					
					ReplacementElementHolder replacementHolder;
					try {
						replacementHolder = new ReplacementElementHolder(replacement);
					} catch (BasicCVLEngineException e) {
						throw new UnsupportedOperationException(e);
					}
					CVLFragmentCopier rplCopier = new CVLFragmentCopier();
					//HashSet<EObject> replacementInnerElements = replacementHolder.getElements();
					HashSet<EObject> replacementInnerElements = replacementHolder.getOuterFragmentElements();
					rplCopier.copyFragment(replacementInnerElements);
					
					newReplacement = createReplacementFromOriginal(rplCopier, replacement, replacementBoundaryMap);
					rSymbolTableReplcMap.put(symbol.getScope(), newReplacement);
					replcmntSymbolMap.put(replacement, rSymbolTableReplcMap);
					
					replacementCopyMap.put(newReplacement, rplCopier);
				}else{
					newReplacement = rSymbolTableReplcMap.get(symbol.getScope());
					
					ReplacementElementHolder replacementHolder;
					try {
						replacementHolder = new ReplacementElementHolder(replacement);
					} catch (BasicCVLEngineException e) {
						throw new UnsupportedOperationException(e);
					}
					CVLFragmentCopier rplCopier = new CVLFragmentCopier();
					//HashSet<EObject> replacementInnerElements = replacementHolder.getElements();
					HashSet<EObject> replacementInnerElements = replacementHolder.getOuterFragmentElements();
					rplCopier.copyFragment(replacementInnerElements);
					
					newReplacement = createReplacementFromOriginal(rplCopier, replacement, replacementBoundaryMap);
					rSymbolTableReplcMap.put(symbol.getScope(), newReplacement);
					
					replacementCopyMap.put(newReplacement, rplCopier);
				}
				createNewFrgamentSubstitution(symbol, placementBoundaryMap, replacementBoundaryMap, newPlacement, newReplacement, fragSub);
			}
		}
	}
	
	private FragmentSubstitution createNewFrgamentSubstitution(
			Symbol symbol,
			HashMap<PlacementBoundaryElement, PlacementBoundaryElement> placementBoundaryMap,
			HashMap<ReplacementBoundaryElement, ReplacementBoundaryElement> replacementBoundaryMap,
			PlacementFragment newPlacement,
			ReplacementFragmentType newReplacement,
			FragmentSubstitution oldFrgament)
	{
		FragmentSubstitution newFragmentSubstitution = CvlFactory.eINSTANCE.createFragmentSubstitution();
		newFragmentSubstitution.setName(symbol.getVSpecResolution().getName() + ":" + oldFrgament.getName());
		newFragmentSubstitution.setBindingVSpec(oldFrgament.getBindingVSpec());
		newFragmentSubstitution.setPlacement(newPlacement);
		newFragmentSubstitution.setReplacement(newReplacement);
		
		for(BoundaryElementBinding binding : oldFrgament.getBoundaryElementBinding()){
			if(binding instanceof ToBinding){
				ToBinding toBinding = (ToBinding) binding;
				ToBinding toBindingNew = CvlFactory.eINSTANCE.createToBinding();
				
				PlacementBoundaryElement toPlacementNew = placementBoundaryMap.get(toBinding.getToPlacement());
				if(toPlacementNew == null)
					throw new UnsupportedOperationException("can not find copied toPlacement");
				toBindingNew.setToPlacement((ToPlacement) toPlacementNew);
				
				ReplacementBoundaryElement toReplacementNew = replacementBoundaryMap.get(toBinding.getToReplacement());
				if(toReplacementNew == null)
					throw new UnsupportedOperationException("can not find copied toReplacement");
				toBindingNew.setToReplacement((ToReplacement) toReplacementNew);
				
				newFragmentSubstitution.getBoundaryElementBinding().add(toBindingNew);
			}
			if(binding instanceof FromBinding){
				FromBinding fromBinding = (FromBinding) binding;
				FromBinding fromBindingNew = CvlFactory.eINSTANCE.createFromBinding();
				
				PlacementBoundaryElement fromPlacementNew = placementBoundaryMap.get(fromBinding.getFromPlacement());
				if(fromPlacementNew == null)
					throw new UnsupportedOperationException("can not find copied fromPlacement");
				fromBindingNew.setFromPlacement((FromPlacement) fromPlacementNew);
				
				ReplacementBoundaryElement fromReplacementNew = replacementBoundaryMap.get(fromBinding.getFromReplacement());
				if(fromReplacementNew == null)
					throw new UnsupportedOperationException("can not find copied fromReplacement");
				fromBindingNew.setFromReplacement((FromReplacement) fromReplacementNew);
				
				newFragmentSubstitution.getBoundaryElementBinding().add(fromBindingNew);
			}
		}
		
		symbol.getScope().getConfigurableUnit().getOwnedVariabletype().add(newReplacement);
		symbol.getScope().getConfigurableUnit().getOwnedVariationPoint().add(newPlacement);
		symbol.getFragmentSubstitutions().add(newFragmentSubstitution);
		symbol.getFragmentSubstitutions().remove(oldFrgament);
		return newFragmentSubstitution;
	}

	private ReplacementFragmentType createReplacementFromOriginal(
			CVLFragmentCopier rplCopier,
			ReplacementFragmentType replacement,
			HashMap<ReplacementBoundaryElement,
			ReplacementBoundaryElement> boundaryMap)
	{
		EList<ReplacementBoundaryElement> boundaryElements = replacement.getReplacementBoundaryElement();
		ReplacementFragmentType newReplacement = CvlFactory.eINSTANCE.createReplacementFragmentType();
		newReplacement.setName(replacement.getName());
		for(ReplacementBoundaryElement boundary : boundaryElements){
			if(boundary instanceof ToReplacement){
				if(!Utility.isDummyToReplacement((ToReplacement) boundary)){
					ToReplacement newToReplacement = CvlFactory.eINSTANCE.createToReplacement();
					dublicateToReplacementAttr(newToReplacement, (ToReplacement) boundary);
					
					ObjectHandle objectHandleOutsideBElOrg = ((ToReplacement) boundary).getOutsideBoundaryElement();
					EObject eObject = objectHandleOutsideBElOrg.getMOFRef();
					EObject copyEObject = rplCopier.get(eObject);
					if(copyEObject == null)
						throw new UnsupportedOperationException("can not find an outside boundary element of the copied replacement in the map");
					ObjectHandle objectHandle = Utility.getObjectHandle(copyEObject, newReplacement.getSourceObject());
					if(objectHandle == null){
						objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
						objectHandle.setMOFRef(copyEObject);
						newReplacement.getSourceObject().add(objectHandle);
					}
					newToReplacement.setOutsideBoundaryElement(objectHandle);
					
					EList<ObjectHandle> objectHandleInsideBElOrg = ((ToReplacement) boundary).getInsideBoundaryElement();
					for(ObjectHandle oHandle : objectHandleInsideBElOrg){
						eObject = oHandle.getMOFRef();
						copyEObject = rplCopier.get(eObject);
						if(copyEObject == null)
							throw new UnsupportedOperationException("can not find an inside boundary element of the copied replacement in the map");
						objectHandle = Utility.getObjectHandle(copyEObject, newReplacement.getSourceObject());
						if(objectHandle == null){
							objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
							objectHandle.setMOFRef(copyEObject);
							newReplacement.getSourceObject().add(objectHandle);
						}
						newToReplacement.getInsideBoundaryElement().add(objectHandle);
					}
					newReplacement.getReplacementBoundaryElement().add(newToReplacement);
					boundaryMap.put(boundary, newToReplacement);
				}else{
					ToReplacement nullToReplacement = no.sintef.cvl.ui.common.Utility.testNullToReplacement(newReplacement);
					boundaryMap.put(boundary, nullToReplacement);
				}
			}
			if(boundary instanceof FromReplacement){
				FromReplacement newFromReplacement = CvlFactory.eINSTANCE.createFromReplacement();
				dublicateFromReplacementAttr(newFromReplacement, (FromReplacement) boundary);
				
				ObjectHandle objectHandleInsideBElOrg = ((FromReplacement) boundary).getInsideBoundaryElement();
				EObject copyEObject = rplCopier.get(objectHandleInsideBElOrg.getMOFRef());
				if(copyEObject == null)
					throw new UnsupportedOperationException("can not find inside boundary element of the copied replacement in the map");
				ObjectHandle objectHandle = Utility.getObjectHandle(copyEObject, newReplacement.getSourceObject());
				if(objectHandle == null){
					objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
					objectHandle.setMOFRef(copyEObject);
					newReplacement.getSourceObject().add(objectHandle);
				}
				newFromReplacement.setInsideBoundaryElement(objectHandle);
						
				EList<ObjectHandle> objectHandleOutsideBElOrg = ((FromReplacement) boundary).getOutsideBoundaryElement();
				for(ObjectHandle oHandle : objectHandleOutsideBElOrg){
					copyEObject = rplCopier.get(oHandle.getMOFRef());
					if(copyEObject == null)
						throw new UnsupportedOperationException("can not find an outside boundary element of the copied replacement in the map");
					objectHandle = Utility.getObjectHandle(copyEObject, newReplacement.getSourceObject());
					if(objectHandle == null){
						objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
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
	
	private PlacementFragment copyPlacement(PlacementFragment placement, HashMap<PlacementBoundaryElement, PlacementBoundaryElement> boundaryMap){
		PlacementFragment newPlacement = CvlFactory.eINSTANCE.createPlacementFragment();
		newPlacement.setName(placement.getName());
		for(ObjectHandle objectHandle : placement.getSourceObject()){
			ObjectHandle newObjectHandle = EcoreUtil.copy(objectHandle);
			newPlacement.getSourceObject().add(newObjectHandle);
		}
		
		for(PlacementBoundaryElement boundary : placement.getPlacementBoundaryElement()){
			if(boundary instanceof ToPlacement){
				ToPlacement toPlacement = (ToPlacement) boundary;
				ToPlacement newToPlacement = CvlFactory.eINSTANCE.createToPlacement();
				dublicateToPlacementAttr(newToPlacement, toPlacement);
				
				ObjectHandle outsideBoudaryElement = toPlacement.getOutsideBoundaryElement();
				ObjectHandle outsideBoundaryNew = Utility.getObjectHandle(outsideBoudaryElement.getMOFRef(), newPlacement.getSourceObject());
				if(outsideBoundaryNew == null)
					throw new UnsupportedOperationException("can not find copied object handle");
				newToPlacement.setOutsideBoundaryElement(outsideBoundaryNew);
				
				for(ObjectHandle objectHandle : toPlacement.getInsideBoundaryElement()){
					ObjectHandle insideBoundaryNew = Utility.getObjectHandle(objectHandle.getMOFRef(), newPlacement.getSourceObject());
					if(insideBoundaryNew == null)
						throw new UnsupportedOperationException("can not fined copied object handle");
					newToPlacement.getInsideBoundaryElement().add(insideBoundaryNew);
				}
				newPlacement.getPlacementBoundaryElement().add(newToPlacement);
				
				boundaryMap.put(toPlacement, newToPlacement);
			}
			if(boundary instanceof FromPlacement){
				FromPlacement fromPlacement = (FromPlacement) boundary;
				FromPlacement newFromPlacement = CvlFactory.eINSTANCE.createFromPlacement();
				dublicateFromPlacementAttr(newFromPlacement, fromPlacement);
				
				ObjectHandle insideBoudaryElement = fromPlacement.getInsideBoundaryElement();
				ObjectHandle insideBoundaryNew = Utility.getObjectHandle(insideBoudaryElement.getMOFRef(), newPlacement.getSourceObject());
				if(insideBoundaryNew == null)
					throw new UnsupportedOperationException("can not find copied object handle");
				newFromPlacement.setInsideBoundaryElement(insideBoundaryNew);
				
				for(ObjectHandle objectHandle : fromPlacement.getOutsideBoundaryElement()){
					ObjectHandle outsideBoundaryNew = Utility.getObjectHandle(objectHandle.getMOFRef(), newPlacement.getSourceObject());
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
			CVLFragmentCopier replacementCopyMap,
			PlacementFragment originalPlacement,
			HashMap<PlacementBoundaryElement,
			PlacementBoundaryElement> boundaryMap)
	{		
		PlacementFragment newPlacement = CvlFactory.eINSTANCE.createPlacementFragment();
		newPlacement.setName(originalPlacement.getName());
		
		EList<PlacementBoundaryElement> boundaryElements = originalPlacement.getPlacementBoundaryElement();
		for(PlacementBoundaryElement boundary : boundaryElements){
			if(boundary instanceof ToPlacement){
				ToPlacement toPlacementNew = CvlFactory.eINSTANCE.createToPlacement();
				ToPlacement toPlacementOriginal = (ToPlacement) boundary;
				dublicateToPlacementAttr(toPlacementNew, toPlacementOriginal);
				
				ObjectHandle outsideBElOhOrg = toPlacementOriginal.getOutsideBoundaryElement();
				EObject outsideEObject = outsideBElOhOrg.getMOFRef();
				EObject copyEObject = replacementCopyMap.get(outsideEObject);
				ObjectHandle objectHandle = null;
				if(copyEObject != null){
					objectHandle = Utility.getObjectHandle(copyEObject, newPlacement.getSourceObject());
					if(objectHandle == null){
						objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
						objectHandle.setMOFRef(copyEObject);
					}
				}
				
				if(objectHandle == null)
					throw new UnsupportedOperationException("can not find outdsideBoundaryElement to reference in the copied replacement for a new placement");
				newPlacement.getSourceObject().add(objectHandle);
				
				toPlacementNew.setOutsideBoundaryElement(objectHandle);
				
				EList<ObjectHandle> insideBElsOhOrg = toPlacementOriginal.getInsideBoundaryElement();
				EList<EObject> insideBElsOhOrgEObj = Utility.resolveProxies(insideBElsOhOrg);
				for(EObject eObjectOrg : insideBElsOhOrgEObj){
					copyEObject = replacementCopyMap.get(eObjectOrg);
					if(copyEObject == null)
						throw new UnsupportedOperationException("can not find insideBoundaryElement to reference in the copied replacement for a new placement");
					objectHandle = Utility.getObjectHandle(copyEObject, newPlacement.getSourceObject());
					if(objectHandle == null){
						objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
						objectHandle.setMOFRef(copyEObject);
						newPlacement.getSourceObject().add(objectHandle);
					}
					toPlacementNew.getInsideBoundaryElement().add(objectHandle);
				}
				newPlacement.getPlacementBoundaryElement().add(toPlacementNew);
				boundaryMap.put(boundary, toPlacementNew);
			}
			if(boundary instanceof FromPlacement){
				if(!Utility.isDummyFromPlacement((FromPlacement) boundary)){	
					FromPlacement fromPlacementNew = CvlFactory.eINSTANCE.createFromPlacement();
					FromPlacement fromPlacementOriginal = (FromPlacement) boundary;
					dublicateFromPlacementAttr(fromPlacementNew, fromPlacementOriginal);
					
					ObjectHandle insideBElOhOrg = fromPlacementOriginal.getInsideBoundaryElement();
					EObject insideEObject = insideBElOhOrg.getMOFRef();
					EObject copyEObject = replacementCopyMap.get(insideEObject);
					if(copyEObject == null)
						throw new UnsupportedOperationException("can not find insideBoundaryElement to reference in the copied replacement for a new placement");
					ObjectHandle objectHandle = Utility.getObjectHandle(copyEObject, newPlacement.getSourceObject());
					if(objectHandle == null){
						objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
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
						objectHandle = Utility.getObjectHandle(copyEObject, newPlacement.getSourceObject());
						if(objectHandle == null){
							objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
							objectHandle.setMOFRef(copyEObject);
						}
						
						newPlacement.getSourceObject().add(objectHandle);
						fromPlacementNew.getOutsideBoundaryElement().add(objectHandle);
					}
					newPlacement.getPlacementBoundaryElement().add(fromPlacementNew);
					boundaryMap.put(boundary, fromPlacementNew);
				}else{
					FromPlacement nullFromPlacement = no.sintef.cvl.ui.common.Utility.testNullFromPlacement(newPlacement);
					boundaryMap.put(boundary, nullFromPlacement);
				}
			}
		}
		return newPlacement;
	}
	
	private void dublicateToPlacementAttr(ToPlacement newToPlacement, ToPlacement toPlacement){
		if(toPlacement.getName() != null)
			newToPlacement.setName(toPlacement.getName());
		if(toPlacement.getBindingVSpec() != null)
			newToPlacement.setBindingVSpec(toPlacement.getBindingVSpec());
		if(toPlacement.getPropertyName() != null)
			newToPlacement.setPropertyName(toPlacement.getPropertyName());
		if(toPlacement.getToReplacement() != null)
			newToPlacement.setToReplacement(toPlacement.getToReplacement());
	}
	
	private void dublicateToReplacementAttr(ToReplacement newToReplacement, ToReplacement toReplacement){
		if(toReplacement.getName() != null)
			newToReplacement.setName(toReplacement.getName());
		if(toReplacement.getBindingVSpec() != null)
			newToReplacement.setBindingVSpec(toReplacement.getBindingVSpec());
		if(toReplacement.getToPlacement() != null)
			newToReplacement.setToPlacement(toReplacement.getToPlacement());
	}
	
	private void dublicateFromPlacementAttr(FromPlacement newFromPlacement, FromPlacement fromPlacement){
		if(fromPlacement.getName() != null)
			newFromPlacement.setName(fromPlacement.getName());
		if(fromPlacement.getBindingVSpec() != null)
			newFromPlacement.setBindingVSpec(fromPlacement.getBindingVSpec());
		if(fromPlacement.getFromReplacement() != null)
			newFromPlacement.setFromReplacement(fromPlacement.getFromReplacement());
	}
	
	private void dublicateFromReplacementAttr(FromReplacement newFromReplacement, FromReplacement fromReplacement){
		if(fromReplacement.getName() != null)
			newFromReplacement.setName(fromReplacement.getName());
		if(fromReplacement.getBindingVSpec() != null)
			newFromReplacement.setBindingVSpec(fromReplacement.getBindingVSpec());
		if(fromReplacement.getFromPlacement() != null)
			newFromReplacement.setFromPlacement(fromReplacement.getFromPlacement());
		if(fromReplacement.getPropertyName() != null)
			newFromReplacement.setPropertyName(fromReplacement.getPropertyName());		
	}
}
