package no.sintef.cvl.engine.adjacent.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.ObjectHandle;
import cvl.ToBinding;
import cvl.ToPlacement;

import no.sintef.cvl.engine.adjacent.AdjacentFinder;
import no.sintef.cvl.engine.adjacent.AdjacentFragment;
import no.sintef.cvl.engine.adjacent.AdjacentResolver;
import no.sintef.cvl.engine.common.EngineUtility;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.error.GeneralCVLEngineException;
import no.sintef.cvl.engine.error.IllegalCVLOperation;
import no.sintef.cvl.engine.error.IncorrectCVLModel;
import no.sintef.cvl.engine.error.UnexpectedOperationFailure;
import no.sintef.cvl.engine.fragment.FragSubHolder;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;

public class AdjacentResolverImpl implements AdjacentResolver {

	private AdjacentFinder adjacentFinder;

	public AdjacentResolverImpl(AdjacentFinder finder){
		this.adjacentFinder = finder;
	}
	
	@Override
	public void resolve(FragSubHolder fragmentHolderCurrent) throws BasicCVLEngineException {
		AdjacentFragment aFrag = this.adjacentFinder.getAdjacentMap().get(fragmentHolderCurrent);
		if(aFrag == null)
			return;
		
		HashSet<AdjacentFragment> adjacentFragments = aFrag.getAdjacentFragments();
		if(adjacentFragments.isEmpty())
			throw new GeneralCVLEngineException("can not find any adjacent fragments to the fragment that seems to be adjacent" + fragmentHolderCurrent);

		HashSet<AdjacentFragment> twinAFrag = aFrag.getTwinAdjacentFragments();
		
		for(AdjacentFragment adjacentFragment : adjacentFragments){
			FragSubHolder fragHolderAdjacent = adjacentFragment.getFragmentHolder();
			HashMap<FromBinding, ToBinding> adjacentBindingsToCurrent = EngineUtility.reverseMap(aFrag.getAdjacentToBindings(adjacentFragment));
			adjacentBindingsToCurrent = (adjacentBindingsToCurrent != null) ? adjacentBindingsToCurrent : new HashMap<FromBinding, ToBinding>();
			for(Map.Entry<FromBinding, ToBinding> entry : adjacentBindingsToCurrent.entrySet()){
				FromBinding fromBinding = entry.getKey();
				ToBinding toBinding = entry.getValue();
				EList<ObjectHandle> outsideBOHElmtsPlc = fromBinding.getFromPlacement().getOutsideBoundaryElement();
				EList<ObjectHandle> insideBOHElmtsPlcReplaced = calculateInsideBoundaryElements(twinAFrag, adjacentFragment, fromBinding, toBinding);
				
				HashMap<FromPlacement, HashSet<ObjectHandle>> insideBoundaryElementsFromPlacementMap = ((FragmentSubstitutionHolder) fragHolderAdjacent).getFromPlacementInsideBoundaryElementMap();
				HashSet<ObjectHandle> insideBoundaryElementsFromPlacement = insideBoundaryElementsFromPlacementMap.get(fromBinding.getFromPlacement());
				if(insideBoundaryElementsFromPlacement == null)
					throw new GeneralCVLEngineException("failed to find insideBoundaryElements in the map for a given fromPlacement " + fromBinding.getFromPlacement() + " of the fromBinding " + fromBinding);

				for(ObjectHandle objectHandle : insideBoundaryElementsFromPlacement){
					EObject insideBoundaryElementPlc = EngineUtility.resolveProxies(objectHandle);
					String propertyName = fromBinding.getFromReplacement().getPropertyName();
					EStructuralFeature property = insideBoundaryElementPlc.eClass().getEStructuralFeature(propertyName);
					if(property == null)
						throw new GeneralCVLEngineException("failed to find property to adjust, property name : " + propertyName);

					int upperBound = property.getUpperBound();
					if(upperBound == -1 || upperBound > 1){
						EList<EObject> values = EngineUtility.getListPropertyValue(insideBoundaryElementPlc, property);
						
						EList<EObject> elementsToRemove = EngineUtility.resolveProxies(outsideBOHElmtsPlc);
						EList<EObject> elementsToAdd = EngineUtility.resolveProxies(insideBOHElmtsPlcReplaced);
						EList<EObject> propertyValueNew = EngineUtility.subtractAugmentList(values, elementsToRemove, elementsToAdd);
						
						if(upperBound != -1 && propertyValueNew.size() > upperBound)
							throw new IllegalCVLOperation("cardinality does not correspond for property : " + propertyName + "of" + fragHolderAdjacent.getFragment());

						EngineUtility.setProperty(values, elementsToRemove, elementsToAdd);
						EList<EObject> propertyValueSet = EngineUtility.getListPropertyValue(insideBoundaryElementPlc, property);
						if(!propertyValueNew.equals(propertyValueSet))
							throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragHolderAdjacent.getFragment());
					}else{
						//property.getUpperBound() == 0 || == 1
						if(upperBound == 0)
							throw new IncorrectCVLModel("model is incorrect, cardianlity for reference is set to 0, but something is there" + insideBoundaryElementPlc.eGet(property));

						if(insideBOHElmtsPlcReplaced.size() != upperBound)
							throw new IllegalCVLOperation("cardinality does not match for property :" + propertyName + "of" + fragHolderAdjacent.getFragment());

						EObject propertyValueNew = EngineUtility.resolveProxies(insideBOHElmtsPlcReplaced).get(0);
						EngineUtility.setProperty(insideBoundaryElementPlc, property, propertyValueNew);
						
						Object propertyValueSet = insideBoundaryElementPlc.eGet(property);
						if(!propertyValueNew.equals(propertyValueSet))
							throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragHolderAdjacent.getFragment());					
					}
				}
				
				//update variability model : boundaries so the point to the correct elements
				fromBinding.getFromPlacement().getOutsideBoundaryElement().clear();
				fromBinding.getFromPlacement().getOutsideBoundaryElement().addAll(insideBOHElmtsPlcReplaced);
				
				HashMap<ToPlacement, HashSet<ObjectHandle>> outsideBoundaryElementsToPlacementMap = ((FragmentSubstitutionHolder) fragmentHolderCurrent).getToPlacementOutsideBoundaryElementMap();
				HashSet<ObjectHandle> outsideBoundaryElementsToPlacement = outsideBoundaryElementsToPlacementMap.get(toBinding.getToPlacement());
				outsideBoundaryElementsToPlacement.clear();
				outsideBoundaryElementsToPlacement.addAll(insideBoundaryElementsFromPlacement);
			}
			
			HashMap<FromBinding, ToBinding> adjacentBindingsFromCurrent = aFrag.getAdjacentFromBindings(adjacentFragment);
			adjacentBindingsFromCurrent = (adjacentBindingsFromCurrent != null) ? adjacentBindingsFromCurrent : new HashMap<FromBinding, ToBinding>();
			for(Map.Entry<FromBinding, ToBinding> entry : adjacentBindingsFromCurrent.entrySet()){
				FromBinding fromBinding = entry.getKey();
				ToBinding toBinding = entry.getValue();
				
				ObjectHandle insideBOHElmtsPlcReplaced = fromBinding.getFromPlacement().getInsideBoundaryElement();
				toBinding.getToPlacement().setOutsideBoundaryElement(insideBOHElmtsPlcReplaced);
				
				//update boundary toPlacement boundary map
				HashMap<FromPlacement, HashSet<ObjectHandle>> insideBoundaryElementsFromPlacementMap = ((FragmentSubstitutionHolder) fragmentHolderCurrent).getFromPlacementInsideBoundaryElementMap();
				HashSet<ObjectHandle> insideBoundaryElementsFromPlacement = insideBoundaryElementsFromPlacementMap.get(fromBinding.getFromPlacement());
				HashMap<ToPlacement, HashSet<ObjectHandle>> outsideBoundaryElementsToPlacementMap = ((FragmentSubstitutionHolder) fragHolderAdjacent).getToPlacementOutsideBoundaryElementMap();
				HashSet<ObjectHandle> outsideBoundaryElementsToPlacement = outsideBoundaryElementsToPlacementMap.get(toBinding.getToPlacement());
				outsideBoundaryElementsToPlacement.clear();
				outsideBoundaryElementsToPlacement.addAll(insideBoundaryElementsFromPlacement);
			}
			((FragmentSubstitutionHolder) fragHolderAdjacent).refresh();
		}
		((FragmentSubstitutionHolder) fragmentHolderCurrent).refresh();
	}
	
	private EList<ObjectHandle> calculateInsideBoundaryElements(
			HashSet<AdjacentFragment> twins,
			AdjacentFragment adjacentFragment,
			FromBinding fromBindingAdjacent,
			ToBinding toBindingCurrent)
	{
		HashSet<ObjectHandle> insideBEObjectHandles = new HashSet<ObjectHandle>();
		insideBEObjectHandles.addAll(toBindingCurrent.getToPlacement().getInsideBoundaryElement());
		for(AdjacentFragment twin : twins){
			HashMap<FromBinding, ToBinding> adjacentBindingsToCurrent =
					EngineUtility.reverseMap(twin.getAdjacentToBindings(adjacentFragment));
			if(adjacentBindingsToCurrent == null)
				throw new UnexpectedOperationFailure("a twin must have an adjacent bindings with the given adjacent fragment");
			ToBinding toBindingTwin = adjacentBindingsToCurrent.get(fromBindingAdjacent);
			if(toBindingTwin == null)
				throw new UnexpectedOperationFailure("twin must have an adjacent binding of the same kind");
			EList<ObjectHandle> insideBEObjectHandlesTwin = toBindingTwin.getToPlacement().getInsideBoundaryElement();
			insideBEObjectHandles.addAll(insideBEObjectHandlesTwin);
		}
		return new BasicEList<ObjectHandle>(insideBEObjectHandles);
	}
}
