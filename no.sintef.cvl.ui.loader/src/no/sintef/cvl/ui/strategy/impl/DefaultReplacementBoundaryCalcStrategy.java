package no.sintef.cvl.ui.strategy.impl;

import java.util.Collection;
import java.util.HashMap;
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
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import cvl.CvlFactory;
import cvl.ObjectHandle;
import cvl.ReplacementFragmentType;
import cvl.ToReplacement;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.strategy.AbstractBoundaryCalculator;
import no.sintef.cvl.ui.strategy.ReplacementBoundaryCalcStrategy;

public class DefaultReplacementBoundaryCalcStrategy extends AbstractBoundaryCalculator implements ReplacementBoundaryCalcStrategy {
	
	@Override
	public void calculateBoundaries(ReplacementFragmentType replacement, EList<EObject> selection) {
		HashSet<ToReplacement> toReplacements = new HashSet<ToReplacement>();
		refToReplacMap = new HashMap<EStructuralFeature, ToReplacement>();
		for(EObject eObject : selection){
			//calculate toReplacement-s
			Collection<Setting> refSittings = EcoreUtil.UsageCrossReferencer.find(eObject, eObject.eResource());
			for(Setting setting : refSittings){
				EObject sourceEObject = setting.getEObject();
				//object is referenced form inside of the selection
				if(selection.indexOf(sourceEObject) >= 0)
					continue;
				EStructuralFeature property = setting.getEStructuralFeature();
				if(!isReferenceToCut(property))
					continue;
				ToReplacement toReplacement = testToReplacementBoundary(replacement, sourceEObject, eObject, property);
				toReplacements.add(toReplacement);
				refToReplacMap.put(property, toReplacement);
			}
			//containment
			EObject sourceEObject = eObject.eContainer();
			if(selection.indexOf(sourceEObject) < 0){
				EStructuralFeature property = eObject.eContainingFeature();
				if(!isReferenceToCut(property))
					continue;
				ToReplacement toReplacement = testToReplacementBoundary(replacement, sourceEObject, eObject, property);
				toReplacements.add(toReplacement);
				refToReplacMap.put(property, toReplacement);
			}
			
			//calculate fromReplacement-s
			EList<EReference> references = eObject.eClass().getEAllReferences();
			for(EStructuralFeature reference : references){
				Object targetObject = eObject.eGet(reference);
				if(!isReferenceToCut(reference))
					continue;
				if(targetObject instanceof EObject){
					EObject targetEObject = (EObject) targetObject;
					if(selection.indexOf(targetEObject) >= 0)
						continue;
					testFromReplacementBoundary(replacement, eObject, targetEObject, reference);
				}else if(targetObject instanceof EObjectEList){
					EList<EObject> eObjects =  (EList<EObject>) targetObject;
					for(EObject trgEObject : eObjects){
						if(selection.indexOf(trgEObject) >= 0)
							continue;
						testFromReplacementBoundary(replacement, eObject, trgEObject, reference);
					}
				}else if(targetObject != null){
					LOGGER.warn("an element referenced by " + reference + " is neither EObject nor EObjectList: " + targetObject);
				}
			}
		}
		permutateToReplacements(replacement, toReplacements);
		Utility.testNullToReplacement(replacement);
	}
	
	private void permutateToReplacements(ReplacementFragmentType replacement, HashSet<ToReplacement> toReplacements){
		for(ToReplacement toReplacement : toReplacements){
			EList<ObjectHandle> insideBoundaryElements = toReplacement.getInsideBoundaryElement();
			ICombinatoricsVector<ObjectHandle> initialSet = Factory.createVector(insideBoundaryElements);
			Generator<ObjectHandle> generator = Factory.createSubSetGenerator(initialSet);
			for (ICombinatoricsVector<ObjectHandle> subSet : generator) {
				List<ObjectHandle> combination = subSet.getVector();
				if(combination.size() == 0 || combination.size() == insideBoundaryElements.size())
					continue;
				ToReplacement mutatedToReplacement = CvlFactory.eINSTANCE.createToReplacement();
				mutatedToReplacement.setOutsideBoundaryElement(toReplacement.getOutsideBoundaryElement());
				mutatedToReplacement.getInsideBoundaryElement().addAll(combination);
				
				String name = toReplacement.getName();
				Pattern pattern = Pattern.compile("(>)(\\w+)(\\[)");
				Matcher matcher = pattern.matcher(name); matcher.find();
				String propertyName = matcher.group(matcher.groupCount() - 1);
				EObject sourceEObject = toReplacement.getOutsideBoundaryElement().getMOFRef();
				EStructuralFeature property = sourceEObject.eClass().getEStructuralFeature(propertyName);
				mutatedToReplacement.setName(createBoundaryName(sourceEObject, Utility.resolveProxies(new BasicEList<ObjectHandle>(combination)), property, true));
				replacement.getReplacementBoundaryElement().add(mutatedToReplacement);
			}
		}
	}
}
