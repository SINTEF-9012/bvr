package no.sintef.cvl.ui.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import cvl.CvlFactory;
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
import cvl.VInstance;
import cvl.VSpecResolution;

import no.sintef.cvl.engine.common.CVLFragmentCopier;
import no.sintef.cvl.engine.common.Utility;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.fragment.impl.ReplacementElementHolder;
import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.primitive.Symbol;
import no.sintef.cvl.ui.primitive.SymbolTable;
import no.sintef.cvl.ui.strategy.ScopeResolverStrategy;

public class DefaultScopeResolverStrategy implements ScopeResolverStrategy {
	
	private HashMap<ReplacementFragmentType, HashMap<SymbolTable, ReplacementFragmentType>> replcmntSymbolMap;
	private HashMap<ReplacementFragmentType, CVLFragmentCopier> replacementCopyMap;
	private HashMap<ReplacementFragmentType, HashSet<PlacementFragment>> replcmntPlcmntMap;
	private HashMap<PlacementFragment, HashSet<ReplacementFragmentType>> plcmntReplcmntMap;

	@Override
	public void resolveScopes(SymbolTable table) {
		replacementCopyMap = new HashMap<ReplacementFragmentType, CVLFragmentCopier>();
		replcmntSymbolMap = new HashMap<ReplacementFragmentType, HashMap<SymbolTable, ReplacementFragmentType>>();
		EList<FragmentSubstitution> fssToResolve = new BasicEList<FragmentSubstitution>(getFragmentSubstitutionsToResolve(table));
		System.out.println(fssToResolve);
		EList<HashMap> maps = Utility.caluclateReplacementPlacementIntersections(fssToResolve);
		replcmntPlcmntMap = maps.get(0);
		plcmntReplcmntMap = maps.get(1);
		
		symbolTableResolver(table);
		
		System.out.println("!@!!!!!!!!!!!!!!!!!!!!");
		System.out.println(new BasicEList<FragmentSubstitution>(getFragmentSubstitutionsToResolve(table)));
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
			
			FragmentSubstitution newFragmentSubstitution = CvlFactory.eINSTANCE.createFragmentSubstitution();
			PlacementFragment newPlacement;
			
			HashSet<ReplacementFragmentType> containingReplacements = plcmntReplcmntMap.get(placement);
			if(containingReplacements.contains(replacement)){
				HashMap<SymbolTable, ReplacementFragmentType> rSymbolMap = replcmntSymbolMap.get(replacement);
				if(rSymbolMap == null){
					newPlacement = EcoreUtil.copy(placement);
					continue;
				}
				ReplacementFragmentType copiedReplacement = rSymbolMap.get(symbol.getScope().getParent());
				if(copiedReplacement == null)
					throw new UnsupportedOperationException("can not find copied replacement in the parent scope");
				CVLFragmentCopier copyReplacementMap = replacementCopyMap.get(copiedReplacement);
				if(copyReplacementMap == null)
					throw new UnsupportedOperationException("replacement that containd a given placement was copied, but can not find map that contines original objects");
				
				newPlacement = createPlacementFragmentFromOriginal(copiedReplacement, copyReplacementMap, placement);
			}else{
				newPlacement = EcoreUtil.copy(placement);
			}
			
			ReplacementFragmentType newReplacement;
			
			HashMap<SymbolTable, ReplacementFragmentType> rSymbolMap = replcmntSymbolMap.get(replacement);
			
			if(rSymbolMap == null){
				rSymbolMap = new HashMap<SymbolTable, ReplacementFragmentType>();
				
				ReplacementElementHolder replacementHolder;
				try {
					replacementHolder = new ReplacementElementHolder(replacement);
				} catch (BasicCVLEngineException e) {
					throw new UnsupportedOperationException(e);
				}
				CVLFragmentCopier rplCopier = new CVLFragmentCopier();
				HashSet<EObject> replacementInnerElements = replacementHolder.getElements();
				rplCopier.copyFragment(replacementInnerElements);
				
				newReplacement = createReplacementFromOriginal(rplCopier, replacement);
				rSymbolMap.put(symbol.getScope(), newReplacement);
				replcmntSymbolMap.put(replacement, rSymbolMap);
				
				replacementCopyMap.put(newReplacement, rplCopier);
			}else{
				newReplacement = rSymbolMap.get(symbol.getScope());
				
				ReplacementElementHolder replacementHolder;
				try {
					replacementHolder = new ReplacementElementHolder(replacement);
				} catch (BasicCVLEngineException e) {
					throw new UnsupportedOperationException(e);
				}
				CVLFragmentCopier rplCopier = new CVLFragmentCopier();
				HashSet<EObject> replacementInnerElements = replacementHolder.getElements();
				rplCopier.copyFragment(replacementInnerElements);
				
				newReplacement = createReplacementFromOriginal(rplCopier, replacement);
				rSymbolMap.put(symbol.getScope(), newReplacement);
				
				replacementCopyMap.put(newReplacement, rplCopier);
			}
			
			
			newFragmentSubstitution.setName(symbol.getVSpecResolution().getName() + ":" + fragSub.getName());
			newFragmentSubstitution.setPlacement(newPlacement);
			newFragmentSubstitution.setReplacement(newReplacement);
			symbol.getScope().getConfigurableUnit().getOwnedVariabletype().add(newReplacement);
			symbol.getScope().getConfigurableUnit().getOwnedVariationPoint().add(newPlacement);
			symbol.getFragmentSubstitutions().add(newFragmentSubstitution);
			symbol.getFragmentSubstitutions().remove(fragSub);
		}
	}

	private ReplacementFragmentType createReplacementFromOriginal(CVLFragmentCopier rplCopier, ReplacementFragmentType replacement){
		EList<ReplacementBoundaryElement> boundaryElements = replacement.getReplacementBoundaryElement();
		ReplacementFragmentType newReplacement = CvlFactory.eINSTANCE.createReplacementFragmentType();
		for(ReplacementBoundaryElement boundary : boundaryElements){
			if(boundary instanceof ToReplacement){
				if(!Utility.isDummyToReplacement((ToReplacement) boundary)){
					ToReplacement newToReplacement = CvlFactory.eINSTANCE.createToReplacement();
					ObjectHandle objectHandleOutsideBElOrg = ((ToReplacement) boundary).getOutsideBoundaryElement();
					EObject eObject = objectHandleOutsideBElOrg.getMOFRef();
					
					ObjectHandle objectHandle = Utility.getObjectHandle(eObject, newReplacement.getSourceObject());
					if(objectHandle == null){
						objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
						objectHandle.setMOFRef(eObject);
						newReplacement.getSourceObject().add(objectHandle);
					}
					newToReplacement.setOutsideBoundaryElement(objectHandle);
					
					EList<ObjectHandle> objectHandleInsideBElOrg = ((ToReplacement) boundary).getInsideBoundaryElement();
					for(ObjectHandle oHandle : objectHandleInsideBElOrg){
						eObject = oHandle.getMOFRef();
						EObject copyEObject = rplCopier.get(eObject);
						if(copyEObject == null)
							throw new UnsupportedOperationException("can not fined element of the copied replacement in the map");
						objectHandle = Utility.getObjectHandle(copyEObject, newReplacement.getSourceObject());
						if(objectHandle == null){
							objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
							objectHandle.setMOFRef(copyEObject);
							newReplacement.getSourceObject().add(objectHandle);
						}
						newToReplacement.getInsideBoundaryElement().add(objectHandle);
					}
					newReplacement.getReplacementBoundaryElement().add(newToReplacement);
				}else{
					no.sintef.cvl.ui.common.Utility.testNullToReplacement(replacement);
				}
			}
			if(boundary instanceof FromReplacement){
				FromReplacement newFromReplacement = CvlFactory.eINSTANCE.createFromReplacement();
				ObjectHandle objectHandleInsideBElOrg = ((FromReplacement) boundary).getInsideBoundaryElement();
				EObject eObject = objectHandleInsideBElOrg.getMOFRef();
				EObject copyEObject = rplCopier.get(eObject);
				if(copyEObject == null)
					throw new UnsupportedOperationException("can not fined element of the copied replacement in the map");
				ObjectHandle objectHandle = Utility.getObjectHandle(copyEObject, newReplacement.getSourceObject());
				if(objectHandle == null){
					objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
					objectHandle.setMOFRef(copyEObject);
					newReplacement.getSourceObject().add(objectHandle);
				}
				newFromReplacement.setInsideBoundaryElement(objectHandle);
				
				EList<ObjectHandle> objectHandleOutsideBElOrg = ((FromReplacement) boundary).getOutsideBoundaryElement();
				for(ObjectHandle oHandle : objectHandleOutsideBElOrg){
					eObject = oHandle.getMOFRef();
					objectHandle = Utility.getObjectHandle(eObject, newReplacement.getSourceObject());
					if(objectHandle == null){
						objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
						objectHandle.setMOFRef(eObject);
						newReplacement.getSourceObject().add(objectHandle);
					}
					newFromReplacement.getOutsideBoundaryElement().add(objectHandle);
				}
				newReplacement.getReplacementBoundaryElement().add(newFromReplacement);
			}
		}
		return newReplacement;
	}
	
	private PlacementFragment createPlacementFragmentFromOriginal(ReplacementFragmentType replacementCopied, CVLFragmentCopier replacementCopyMap, PlacementFragment originalPlacement){
		HashSet<ObjectHandle> outsideElements = new HashSet<ObjectHandle>();
		EList<ReplacementBoundaryElement> replacementBoundaryElements = replacementCopied.getReplacementBoundaryElement();
		for(ReplacementBoundaryElement boundary : replacementBoundaryElements){
			if(boundary instanceof ToReplacement){
				outsideElements.add(((ToReplacement) boundary).getOutsideBoundaryElement());
			}
			if(boundary instanceof FromReplacement){
				outsideElements.addAll(((FromReplacement) boundary).getOutsideBoundaryElement());
			}
		}
		
		PlacementFragment newPlacement = CvlFactory.eINSTANCE.createPlacementFragment();
		EList<PlacementBoundaryElement> boundaryElements = originalPlacement.getPlacementBoundaryElement();
		for(PlacementBoundaryElement boundary : boundaryElements){
			if(boundary instanceof ToPlacement){
				ToPlacement toPlacementNew = CvlFactory.eINSTANCE.createToPlacement();
				ToPlacement toPlacementOriginal = (ToPlacement) boundary;
				ObjectHandle outsideBElOhOrg = toPlacementOriginal.getOutsideBoundaryElement();
				EObject outsideEObject = outsideBElOhOrg.getMOFRef();
				EObject copyEObject = replacementCopyMap.get(outsideEObject);
				ObjectHandle objectHandle = null;
				if(copyEObject != null){
					objectHandle = Utility.getObjectHandle(copyEObject, newPlacement.getSourceObject());
					if(objectHandle == null){
						objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
						objectHandle.setMOFRef(copyEObject);
						newPlacement.getSourceObject().add(objectHandle);
					}
				}else{
					if(outsideElements.contains(outsideBElOhOrg))
						objectHandle = EcoreUtil.copy(outsideBElOhOrg);
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
			}
			if(boundary instanceof FromPlacement){
				if(!Utility.isDummyFromPlacement((FromPlacement) boundary)){	
					FromPlacement fromPlacementNew = CvlFactory.eINSTANCE.createFromPlacement();
					FromPlacement fromPlacementOriginal = (FromPlacement) boundary;
					
					ObjectHandle insideBElOhOrg = fromPlacementOriginal.getInsideBoundaryElement();
					EObject outsideEObject = insideBElOhOrg.getMOFRef();
					EObject copyEObject = replacementCopyMap.get(outsideEObject);
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
						if(outsideElements.contains(objectHandleOrg)){		
							objectHandle = Utility.getObjectHandle(objectHandleOrg.getMOFRef(), newPlacement.getSourceObject());
							if(objectHandle == null){
								objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
								objectHandle.setMOFRef(objectHandleOrg.getMOFRef());
								newPlacement.getSourceObject().add(objectHandle);
							}	
						}else{
							EObject eObjectOriginal = objectHandleOrg.getMOFRef();
							copyEObject = replacementCopyMap.get(eObjectOriginal);
							if(copyEObject == null)
								throw new UnsupportedOperationException("can not find oiutsideBoundaryElement to reference in the copied replacement for a new placement");
							objectHandle = Utility.getObjectHandle(copyEObject, newPlacement.getSourceObject());
							if(objectHandle == null){
								objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
								objectHandle.setMOFRef(copyEObject);
								newPlacement.getSourceObject().add(objectHandle);
							}
						}						
						fromPlacementNew.getOutsideBoundaryElement().add(objectHandle);
					}
					newPlacement.getPlacementBoundaryElement().add(fromPlacementNew);
				}else{
					no.sintef.cvl.ui.common.Utility.testNullFromPlacement(newPlacement);
				}
			}
		}
		return newPlacement;
	}
}
