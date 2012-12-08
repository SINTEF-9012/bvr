/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.variabilitymodeling.cvl.*;
import org.variabilitymodeling.cvl.visitors.Visitable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.variabilitymodeling.cvl.CvlPackage
 * @generated
 */
public class CvlSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CvlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CvlSwitch() {
		if (modelPackage == null) {
			modelPackage = CvlPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CvlPackage.CVL_MODEL: {
				CVLModel cvlModel = (CVLModel)theEObject;
				T result = caseCVLModel(cvlModel);
				if (result == null) result = caseCVLNamedElement(cvlModel);
				if (result == null) result = caseCVLElement(cvlModel);
				if (result == null) result = caseVisitable(cvlModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.SUBSTITUTION: {
				Substitution substitution = (Substitution)theEObject;
				T result = caseSubstitution(substitution);
				if (result == null) result = caseExecutablePrimitive(substitution);
				if (result == null) result = caseVariabilitySpecification(substitution);
				if (result == null) result = caseCVLNamedElement(substitution);
				if (result == null) result = caseCVLElement(substitution);
				if (result == null) result = caseVisitable(substitution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.REFERENCE_SUBSTITUTION: {
				ReferenceSubstitution referenceSubstitution = (ReferenceSubstitution)theEObject;
				T result = caseReferenceSubstitution(referenceSubstitution);
				if (result == null) result = caseSubstitution(referenceSubstitution);
				if (result == null) result = caseExecutablePrimitive(referenceSubstitution);
				if (result == null) result = caseVariabilitySpecification(referenceSubstitution);
				if (result == null) result = caseCVLNamedElement(referenceSubstitution);
				if (result == null) result = caseCVLElement(referenceSubstitution);
				if (result == null) result = caseVisitable(referenceSubstitution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VALUE_SUBSTITUTION: {
				ValueSubstitution valueSubstitution = (ValueSubstitution)theEObject;
				T result = caseValueSubstitution(valueSubstitution);
				if (result == null) result = caseSubstitution(valueSubstitution);
				if (result == null) result = caseExecutablePrimitive(valueSubstitution);
				if (result == null) result = caseVariabilitySpecification(valueSubstitution);
				if (result == null) result = caseCVLNamedElement(valueSubstitution);
				if (result == null) result = caseCVLElement(valueSubstitution);
				if (result == null) result = caseVisitable(valueSubstitution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.FRAGMENT_SUBSTITUTION: {
				FragmentSubstitution fragmentSubstitution = (FragmentSubstitution)theEObject;
				T result = caseFragmentSubstitution(fragmentSubstitution);
				if (result == null) result = caseSubstitution(fragmentSubstitution);
				if (result == null) result = caseExecutablePrimitive(fragmentSubstitution);
				if (result == null) result = caseVariabilitySpecification(fragmentSubstitution);
				if (result == null) result = caseCVLNamedElement(fragmentSubstitution);
				if (result == null) result = caseCVLElement(fragmentSubstitution);
				if (result == null) result = caseVisitable(fragmentSubstitution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.PLACEMENT_FRAGMENT: {
				PlacementFragment placementFragment = (PlacementFragment)theEObject;
				T result = casePlacementFragment(placementFragment);
				if (result == null) result = casePlacementLiteral(placementFragment);
				if (result == null) result = caseCVLElement(placementFragment);
				if (result == null) result = caseDeclaration(placementFragment);
				if (result == null) result = caseVisitable(placementFragment);
				if (result == null) result = caseVariabilitySpecification(placementFragment);
				if (result == null) result = caseCVLNamedElement(placementFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.REPLACEMENT_FRAGMENT: {
				ReplacementFragment replacementFragment = (ReplacementFragment)theEObject;
				T result = caseReplacementFragment(replacementFragment);
				if (result == null) result = caseReplacementFragmentAbstract(replacementFragment);
				if (result == null) result = caseCVLElement(replacementFragment);
				if (result == null) result = caseReplacementLiteral(replacementFragment);
				if (result == null) result = caseVisitable(replacementFragment);
				if (result == null) result = caseDeclaration(replacementFragment);
				if (result == null) result = caseVariabilitySpecification(replacementFragment);
				if (result == null) result = caseCVLNamedElement(replacementFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.PLACEMENT_BOUNDARY_ELEMENT: {
				PlacementBoundaryElement placementBoundaryElement = (PlacementBoundaryElement)theEObject;
				T result = casePlacementBoundaryElement(placementBoundaryElement);
				if (result == null) result = caseCVLNamedElement(placementBoundaryElement);
				if (result == null) result = caseCVLElement(placementBoundaryElement);
				if (result == null) result = caseVisitable(placementBoundaryElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.REPLACEMENT_BOUNDARY_ELEMENT: {
				ReplacementBoundaryElement replacementBoundaryElement = (ReplacementBoundaryElement)theEObject;
				T result = caseReplacementBoundaryElement(replacementBoundaryElement);
				if (result == null) result = caseCVLNamedElement(replacementBoundaryElement);
				if (result == null) result = caseCVLElement(replacementBoundaryElement);
				if (result == null) result = caseVisitable(replacementBoundaryElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.FROM_PLACEMENT: {
				FromPlacement fromPlacement = (FromPlacement)theEObject;
				T result = caseFromPlacement(fromPlacement);
				if (result == null) result = casePlacementBoundaryElement(fromPlacement);
				if (result == null) result = caseCVLNamedElement(fromPlacement);
				if (result == null) result = caseCVLElement(fromPlacement);
				if (result == null) result = caseVisitable(fromPlacement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.TO_PLACEMENT: {
				ToPlacement toPlacement = (ToPlacement)theEObject;
				T result = caseToPlacement(toPlacement);
				if (result == null) result = casePlacementBoundaryElement(toPlacement);
				if (result == null) result = caseCVLNamedElement(toPlacement);
				if (result == null) result = caseCVLElement(toPlacement);
				if (result == null) result = caseVisitable(toPlacement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.TO_REPLACEMENT: {
				ToReplacement toReplacement = (ToReplacement)theEObject;
				T result = caseToReplacement(toReplacement);
				if (result == null) result = caseReplacementBoundaryElement(toReplacement);
				if (result == null) result = caseCVLNamedElement(toReplacement);
				if (result == null) result = caseCVLElement(toReplacement);
				if (result == null) result = caseVisitable(toReplacement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.FROM_REPLACEMENT: {
				FromReplacement fromReplacement = (FromReplacement)theEObject;
				T result = caseFromReplacement(fromReplacement);
				if (result == null) result = caseReplacementBoundaryElement(fromReplacement);
				if (result == null) result = caseCVLNamedElement(fromReplacement);
				if (result == null) result = caseCVLElement(fromReplacement);
				if (result == null) result = caseVisitable(fromReplacement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.CVL_ELEMENT: {
				CVLElement cvlElement = (CVLElement)theEObject;
				T result = caseCVLElement(cvlElement);
				if (result == null) result = caseVisitable(cvlElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.BOUNDARY_ELEMENT_BINDING: {
				BoundaryElementBinding boundaryElementBinding = (BoundaryElementBinding)theEObject;
				T result = caseBoundaryElementBinding(boundaryElementBinding);
				if (result == null) result = caseCVLNamedElement(boundaryElementBinding);
				if (result == null) result = caseCVLElement(boundaryElementBinding);
				if (result == null) result = caseVisitable(boundaryElementBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.TO_BINDING: {
				ToBinding toBinding = (ToBinding)theEObject;
				T result = caseToBinding(toBinding);
				if (result == null) result = caseBoundaryElementBinding(toBinding);
				if (result == null) result = caseCVLNamedElement(toBinding);
				if (result == null) result = caseCVLElement(toBinding);
				if (result == null) result = caseVisitable(toBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.FROM_BINDING: {
				FromBinding fromBinding = (FromBinding)theEObject;
				T result = caseFromBinding(fromBinding);
				if (result == null) result = caseBoundaryElementBinding(fromBinding);
				if (result == null) result = caseCVLNamedElement(fromBinding);
				if (result == null) result = caseCVLElement(fromBinding);
				if (result == null) result = caseVisitable(fromBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.COMPOSITE_VARIABILITY: {
				CompositeVariability compositeVariability = (CompositeVariability)theEObject;
				T result = caseCompositeVariability(compositeVariability);
				if (result == null) result = caseExecutablePrimitive(compositeVariability);
				if (result == null) result = caseVariabilitySpecification(compositeVariability);
				if (result == null) result = caseCVLNamedElement(compositeVariability);
				if (result == null) result = caseCVLElement(compositeVariability);
				if (result == null) result = caseVisitable(compositeVariability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VARIABILITY_SPECIFICATION: {
				VariabilitySpecification variabilitySpecification = (VariabilitySpecification)theEObject;
				T result = caseVariabilitySpecification(variabilitySpecification);
				if (result == null) result = caseCVLNamedElement(variabilitySpecification);
				if (result == null) result = caseCVLElement(variabilitySpecification);
				if (result == null) result = caseVisitable(variabilitySpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.CVL_NAMED_ELEMENT: {
				CVLNamedElement cvlNamedElement = (CVLNamedElement)theEObject;
				T result = caseCVLNamedElement(cvlNamedElement);
				if (result == null) result = caseCVLElement(cvlNamedElement);
				if (result == null) result = caseVisitable(cvlNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.PLACEMENT_LITERAL: {
				PlacementLiteral placementLiteral = (PlacementLiteral)theEObject;
				T result = casePlacementLiteral(placementLiteral);
				if (result == null) result = caseDeclaration(placementLiteral);
				if (result == null) result = caseVariabilitySpecification(placementLiteral);
				if (result == null) result = caseCVLNamedElement(placementLiteral);
				if (result == null) result = caseCVLElement(placementLiteral);
				if (result == null) result = caseVisitable(placementLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.REPLACEMENT_LITERAL: {
				ReplacementLiteral replacementLiteral = (ReplacementLiteral)theEObject;
				T result = caseReplacementLiteral(replacementLiteral);
				if (result == null) result = caseDeclaration(replacementLiteral);
				if (result == null) result = caseVariabilitySpecification(replacementLiteral);
				if (result == null) result = caseCVLNamedElement(replacementLiteral);
				if (result == null) result = caseCVLElement(replacementLiteral);
				if (result == null) result = caseVisitable(replacementLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.PLACEMENT_VALUE: {
				PlacementValue placementValue = (PlacementValue)theEObject;
				T result = casePlacementValue(placementValue);
				if (result == null) result = casePlacementLiteral(placementValue);
				if (result == null) result = caseDeclaration(placementValue);
				if (result == null) result = caseVariabilitySpecification(placementValue);
				if (result == null) result = caseCVLNamedElement(placementValue);
				if (result == null) result = caseCVLElement(placementValue);
				if (result == null) result = caseVisitable(placementValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.PLACEMENT_OBJECT: {
				PlacementObject placementObject = (PlacementObject)theEObject;
				T result = casePlacementObject(placementObject);
				if (result == null) result = casePlacementLiteral(placementObject);
				if (result == null) result = caseDeclaration(placementObject);
				if (result == null) result = caseVariabilitySpecification(placementObject);
				if (result == null) result = caseCVLNamedElement(placementObject);
				if (result == null) result = caseCVLElement(placementObject);
				if (result == null) result = caseVisitable(placementObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.REPLACEMENT_VALUE: {
				ReplacementValue replacementValue = (ReplacementValue)theEObject;
				T result = caseReplacementValue(replacementValue);
				if (result == null) result = caseReplacementLiteral(replacementValue);
				if (result == null) result = caseDeclaration(replacementValue);
				if (result == null) result = caseVariabilitySpecification(replacementValue);
				if (result == null) result = caseCVLNamedElement(replacementValue);
				if (result == null) result = caseCVLElement(replacementValue);
				if (result == null) result = caseVisitable(replacementValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.REPLACEMENT_OBJECT: {
				ReplacementObject replacementObject = (ReplacementObject)theEObject;
				T result = caseReplacementObject(replacementObject);
				if (result == null) result = caseReplacementLiteral(replacementObject);
				if (result == null) result = caseDeclaration(replacementObject);
				if (result == null) result = caseVariabilitySpecification(replacementObject);
				if (result == null) result = caseCVLNamedElement(replacementObject);
				if (result == null) result = caseCVLElement(replacementObject);
				if (result == null) result = caseVisitable(replacementObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.RESOLUTION_SPECIFICATION: {
				ResolutionSpecification resolutionSpecification = (ResolutionSpecification)theEObject;
				T result = caseResolutionSpecification(resolutionSpecification);
				if (result == null) result = caseCVLNamedElement(resolutionSpecification);
				if (result == null) result = caseCVLElement(resolutionSpecification);
				if (result == null) result = caseVisitable(resolutionSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.RESOLUTION_ELEMENT: {
				ResolutionElement resolutionElement = (ResolutionElement)theEObject;
				T result = caseResolutionElement(resolutionElement);
				if (result == null) result = caseResolutionSpecification(resolutionElement);
				if (result == null) result = caseCVLNamedElement(resolutionElement);
				if (result == null) result = caseCVLElement(resolutionElement);
				if (result == null) result = caseVisitable(resolutionElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = caseDeclaration(type);
				if (result == null) result = caseVariabilitySpecification(type);
				if (result == null) result = caseCVLNamedElement(type);
				if (result == null) result = caseCVLElement(type);
				if (result == null) result = caseVisitable(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.INVOCATION: {
				Invocation invocation = (Invocation)theEObject;
				T result = caseInvocation(invocation);
				if (result == null) result = caseExecutablePrimitive(invocation);
				if (result == null) result = caseVariabilitySpecification(invocation);
				if (result == null) result = caseCVLNamedElement(invocation);
				if (result == null) result = caseCVLElement(invocation);
				if (result == null) result = caseVisitable(invocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.ITERATOR_RESOLUTION: {
				IteratorResolution iteratorResolution = (IteratorResolution)theEObject;
				T result = caseIteratorResolution(iteratorResolution);
				if (result == null) result = caseResolutionSpecification(iteratorResolution);
				if (result == null) result = caseCVLNamedElement(iteratorResolution);
				if (result == null) result = caseCVLElement(iteratorResolution);
				if (result == null) result = caseVisitable(iteratorResolution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.ITERATOR: {
				Iterator iterator = (Iterator)theEObject;
				T result = caseIterator(iterator);
				if (result == null) result = caseCompositeVariability(iterator);
				if (result == null) result = caseExecutablePrimitive(iterator);
				if (result == null) result = caseVariabilitySpecification(iterator);
				if (result == null) result = caseCVLNamedElement(iterator);
				if (result == null) result = caseCVLElement(iterator);
				if (result == null) result = caseVisitable(iterator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.REPLACEMENT_FRAGMENT_REFERENCE: {
				ReplacementFragmentReference replacementFragmentReference = (ReplacementFragmentReference)theEObject;
				T result = caseReplacementFragmentReference(replacementFragmentReference);
				if (result == null) result = caseReplacementFragmentAbstract(replacementFragmentReference);
				if (result == null) result = caseReplacementLiteral(replacementFragmentReference);
				if (result == null) result = caseDeclaration(replacementFragmentReference);
				if (result == null) result = caseVariabilitySpecification(replacementFragmentReference);
				if (result == null) result = caseCVLNamedElement(replacementFragmentReference);
				if (result == null) result = caseCVLElement(replacementFragmentReference);
				if (result == null) result = caseVisitable(replacementFragmentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.REPLACEMENT_FRAGMENT_ABSTRACT: {
				ReplacementFragmentAbstract replacementFragmentAbstract = (ReplacementFragmentAbstract)theEObject;
				T result = caseReplacementFragmentAbstract(replacementFragmentAbstract);
				if (result == null) result = caseReplacementLiteral(replacementFragmentAbstract);
				if (result == null) result = caseDeclaration(replacementFragmentAbstract);
				if (result == null) result = caseVariabilitySpecification(replacementFragmentAbstract);
				if (result == null) result = caseCVLNamedElement(replacementFragmentAbstract);
				if (result == null) result = caseCVLElement(replacementFragmentAbstract);
				if (result == null) result = caseVisitable(replacementFragmentAbstract);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.ASSIGNMENT: {
				Assignment assignment = (Assignment)theEObject;
				T result = caseAssignment(assignment);
				if (result == null) result = caseExecutablePrimitive(assignment);
				if (result == null) result = caseVariabilitySpecification(assignment);
				if (result == null) result = caseCVLNamedElement(assignment);
				if (result == null) result = caseCVLElement(assignment);
				if (result == null) result = caseVisitable(assignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.DECLARATION: {
				Declaration declaration = (Declaration)theEObject;
				T result = caseDeclaration(declaration);
				if (result == null) result = caseVariabilitySpecification(declaration);
				if (result == null) result = caseCVLNamedElement(declaration);
				if (result == null) result = caseCVLElement(declaration);
				if (result == null) result = caseVisitable(declaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.EXECUTABLE_PRIMITIVE: {
				ExecutablePrimitive executablePrimitive = (ExecutablePrimitive)theEObject;
				T result = caseExecutablePrimitive(executablePrimitive);
				if (result == null) result = caseVariabilitySpecification(executablePrimitive);
				if (result == null) result = caseCVLNamedElement(executablePrimitive);
				if (result == null) result = caseCVLElement(executablePrimitive);
				if (result == null) result = caseVisitable(executablePrimitive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = caseDeclaration(constraint);
				if (result == null) result = caseVariabilitySpecification(constraint);
				if (result == null) result = caseCVLNamedElement(constraint);
				if (result == null) result = caseCVLElement(constraint);
				if (result == null) result = caseVisitable(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.NOT: {
				NOT not = (NOT)theEObject;
				T result = caseNOT(not);
				if (result == null) result = caseConstraint(not);
				if (result == null) result = caseDeclaration(not);
				if (result == null) result = caseVariabilitySpecification(not);
				if (result == null) result = caseCVLNamedElement(not);
				if (result == null) result = caseCVLElement(not);
				if (result == null) result = caseVisitable(not);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.OR: {
				OR or = (OR)theEObject;
				T result = caseOR(or);
				if (result == null) result = caseBinary(or);
				if (result == null) result = caseConstraint(or);
				if (result == null) result = caseDeclaration(or);
				if (result == null) result = caseVariabilitySpecification(or);
				if (result == null) result = caseCVLNamedElement(or);
				if (result == null) result = caseCVLElement(or);
				if (result == null) result = caseVisitable(or);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.IMPLIES: {
				IMPLIES implies = (IMPLIES)theEObject;
				T result = caseIMPLIES(implies);
				if (result == null) result = caseBinary(implies);
				if (result == null) result = caseConstraint(implies);
				if (result == null) result = caseDeclaration(implies);
				if (result == null) result = caseVariabilitySpecification(implies);
				if (result == null) result = caseCVLNamedElement(implies);
				if (result == null) result = caseCVLElement(implies);
				if (result == null) result = caseVisitable(implies);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.EXECUTABLE_PRIMITIVE_TERM: {
				ExecutablePrimitiveTerm executablePrimitiveTerm = (ExecutablePrimitiveTerm)theEObject;
				T result = caseExecutablePrimitiveTerm(executablePrimitiveTerm);
				if (result == null) result = caseConstraint(executablePrimitiveTerm);
				if (result == null) result = caseDeclaration(executablePrimitiveTerm);
				if (result == null) result = caseVariabilitySpecification(executablePrimitiveTerm);
				if (result == null) result = caseCVLNamedElement(executablePrimitiveTerm);
				if (result == null) result = caseCVLElement(executablePrimitiveTerm);
				if (result == null) result = caseVisitable(executablePrimitiveTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.AND_: {
				AND_ anD_ = (AND_)theEObject;
				T result = caseAND_(anD_);
				if (result == null) result = caseBinary(anD_);
				if (result == null) result = caseConstraint(anD_);
				if (result == null) result = caseDeclaration(anD_);
				if (result == null) result = caseVariabilitySpecification(anD_);
				if (result == null) result = caseCVLNamedElement(anD_);
				if (result == null) result = caseCVLElement(anD_);
				if (result == null) result = caseVisitable(anD_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.BINARY: {
				Binary binary = (Binary)theEObject;
				T result = caseBinary(binary);
				if (result == null) result = caseConstraint(binary);
				if (result == null) result = caseDeclaration(binary);
				if (result == null) result = caseVariabilitySpecification(binary);
				if (result == null) result = caseCVLNamedElement(binary);
				if (result == null) result = caseCVLElement(binary);
				if (result == null) result = caseVisitable(binary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.RESOLUTION_VALUE: {
				ResolutionValue resolutionValue = (ResolutionValue)theEObject;
				T result = caseResolutionValue(resolutionValue);
				if (result == null) result = caseResolutionElement(resolutionValue);
				if (result == null) result = caseResolutionSpecification(resolutionValue);
				if (result == null) result = caseCVLNamedElement(resolutionValue);
				if (result == null) result = caseCVLElement(resolutionValue);
				if (result == null) result = caseVisitable(resolutionValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVL Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVL Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVLModel(CVLModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Substitution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubstitution(Substitution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Substitution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceSubstitution(ReferenceSubstitution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Substitution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueSubstitution(ValueSubstitution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragment Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragment Substitution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFragmentSubstitution(FragmentSubstitution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Placement Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Placement Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlacementFragment(PlacementFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replacement Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replacement Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplacementFragment(ReplacementFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Placement Boundary Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Placement Boundary Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlacementBoundaryElement(PlacementBoundaryElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replacement Boundary Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replacement Boundary Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplacementBoundaryElement(ReplacementBoundaryElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>From Placement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From Placement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFromPlacement(FromPlacement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>To Placement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To Placement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToPlacement(ToPlacement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>To Replacement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To Replacement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToReplacement(ToReplacement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>From Replacement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From Replacement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFromReplacement(FromReplacement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVL Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVL Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVLElement(CVLElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boundary Element Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boundary Element Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundaryElementBinding(BoundaryElementBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>To Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToBinding(ToBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>From Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFromBinding(FromBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Variability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Variability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeVariability(CompositeVariability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variability Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variability Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariabilitySpecification(VariabilitySpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVL Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVL Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVLNamedElement(CVLNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Placement Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Placement Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlacementLiteral(PlacementLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replacement Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replacement Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplacementLiteral(ReplacementLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Placement Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Placement Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlacementValue(PlacementValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Placement Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Placement Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlacementObject(PlacementObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replacement Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replacement Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplacementValue(ReplacementValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replacement Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replacement Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplacementObject(ReplacementObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolution Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolution Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResolutionSpecification(ResolutionSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolution Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolution Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResolutionElement(ResolutionElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invocation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invocation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvocation(Invocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Resolution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratorResolution(IteratorResolution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterator(Iterator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replacement Fragment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replacement Fragment Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplacementFragmentReference(ReplacementFragmentReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replacement Fragment Abstract</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replacement Fragment Abstract</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplacementFragmentAbstract(ReplacementFragmentAbstract object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignment(Assignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclaration(Declaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Executable Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Executable Primitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutablePrimitive(ExecutablePrimitive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NOT</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NOT</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNOT(NOT object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OR</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OR</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOR(OR object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMPLIES</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMPLIES</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMPLIES(IMPLIES object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Executable Primitive Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Executable Primitive Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutablePrimitiveTerm(ExecutablePrimitiveTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AND </em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AND </em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAND_(AND_ object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinary(Binary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolution Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolution Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResolutionValue(ResolutionValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitable(Visitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //CvlSwitch
