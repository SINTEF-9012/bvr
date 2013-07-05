package no.sintef.cvl.ui.strategy.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import cvl.CvlFactory;
import cvl.FromPlacement;
import cvl.ObjectHandle;
import cvl.PlacementFragment;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.strategy.AbstractBoundaryCalculator;
import no.sintef.cvl.ui.strategy.PlacementBoundaryCalcStrategy;

public class DefaultPlacementBoundaryCalcStrategy extends AbstractBoundaryCalculator implements PlacementBoundaryCalcStrategy {
	
	@Override
	public void calculateBoundaries(PlacementFragment placement, EList<EObject> selection) {
		HashSet<FromPlacement> fromPlacements = new HashSet<FromPlacement>();
		for(EObject eObject : selection){
			//calculate toPlacement-s
			Collection<Setting> refSittings = EcoreUtil.UsageCrossReferencer.find(eObject, eObject.eResource());
			for(Setting setting : refSittings){
				EObject sourceEObject = setting.getEObject();
				//object is referenced form inside of the selection
				if(selection.indexOf(sourceEObject) >= 0)
					continue;
				EStructuralFeature property = setting.getEStructuralFeature();
				if(!isReferenceToCut(property))
					continue;
				testToPlacementBoundary(placement, sourceEObject, eObject, property);
			}
			//containment
			EObject sourceEObject = eObject.eContainer();
			if(selection.indexOf(sourceEObject) < 0){
				EStructuralFeature property = eObject.eContainingFeature();
				if(!isReferenceToCut(property))
					continue;
				testToPlacementBoundary(placement, sourceEObject, eObject, property);
			}
			
			//calculate fromPlacement-s
			EList<EReference> references = eObject.eClass().getEAllReferences();
			for(EStructuralFeature reference : references){
				Object targetObject = eObject.eGet(reference);
				if(reference.getUpperBound() == 1){
					if(!(targetObject instanceof EObject))
						continue;
					EObject targetEObject = (EObject) targetObject;
					if(selection.indexOf(targetEObject) >= 0)
						continue;
					if(!isReferenceToCut(reference))
						continue;
					fromPlacements.add(testFromPlacementBoundary(placement, eObject, targetEObject, reference));
				}else{
					EList<?> targetListObjects = (EList<?>) targetObject;
					for(Object object : targetListObjects){
						if(!(object instanceof EObject))
							continue;
						EObject trgEObject = (EObject) object;
						if(selection.indexOf(trgEObject) >= 0)
							continue;
						if(!isReferenceToCut(reference))
							continue;
						fromPlacements.add(testFromPlacementBoundary(placement, eObject, trgEObject, reference));
					}
				}
			}
		}
		permutateFromPlacements(placement, fromPlacements);
		Utility.testNullFromPlacement(placement);
	}
	
	private void permutateFromPlacements(PlacementFragment placement, HashSet<FromPlacement> fromPlacements){
		for(FromPlacement fromPlacement : fromPlacements){
			EList<ObjectHandle> outsideBoundaryElements = fromPlacement.getOutsideBoundaryElement();
			ICombinatoricsVector<ObjectHandle> initialSet = Factory.createVector(outsideBoundaryElements);
			Generator<ObjectHandle> generator = Factory.createSubSetGenerator(initialSet);
			for (ICombinatoricsVector<ObjectHandle> subSet : generator) {
				List<ObjectHandle> combination = subSet.getVector();
				if(combination.size() == 0 || combination.size() == outsideBoundaryElements.size())
					continue;
				FromPlacement mutatedFromPlacement = CvlFactory.eINSTANCE.createFromPlacement();
				mutatedFromPlacement.setInsideBoundaryElement(fromPlacement.getInsideBoundaryElement());
				mutatedFromPlacement.getOutsideBoundaryElement().addAll(combination);
				
				String name = fromPlacement.getName();
				Pattern pattern = Pattern.compile("(>)(\\w+)(\\[)");
				Matcher matcher = pattern.matcher(name); matcher.find();
				String propertyName = matcher.group(matcher.groupCount() - 1);
				EObject sourceEObject = fromPlacement.getInsideBoundaryElement().getMOFRef();
				EStructuralFeature property = sourceEObject.eClass().getEStructuralFeature(propertyName);
				mutatedFromPlacement.setName(createBoundaryName(sourceEObject, Utility.resolveProxies(new BasicEList<ObjectHandle>(combination)), property, true));
				placement.getPlacementBoundaryElement().add(mutatedFromPlacement);
			}
		}
	}
}
