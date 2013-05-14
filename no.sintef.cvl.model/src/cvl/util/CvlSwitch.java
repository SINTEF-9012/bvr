/**
 */
package cvl.util;

import cvl.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
 * @see cvl.CvlPackage
 * @generated
 */
public class CvlSwitch<T> extends Switch<T> {
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
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CvlPackage.CHOICE: {
				Choice choice = (Choice)theEObject;
				T result = caseChoice(choice);
				if (result == null) result = caseVSpec(choice);
				if (result == null) result = caseVPackageable(choice);
				if (result == null) result = caseNamedElement(choice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VSPEC: {
				VSpec vSpec = (VSpec)theEObject;
				T result = caseVSpec(vSpec);
				if (result == null) result = caseVPackageable(vSpec);
				if (result == null) result = caseNamedElement(vSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VPACKAGEABLE: {
				VPackageable vPackageable = (VPackageable)theEObject;
				T result = caseVPackageable(vPackageable);
				if (result == null) result = caseNamedElement(vPackageable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.MULTIPLICITY_INTERVAL: {
				MultiplicityInterval multiplicityInterval = (MultiplicityInterval)theEObject;
				T result = caseMultiplicityInterval(multiplicityInterval);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VSPEC_DERIVATION: {
				VSpecDerivation vSpecDerivation = (VSpecDerivation)theEObject;
				T result = caseVSpecDerivation(vSpecDerivation);
				if (result == null) result = caseVPackageable(vSpecDerivation);
				if (result == null) result = caseNamedElement(vSpecDerivation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VCLASSIFIER: {
				VClassifier vClassifier = (VClassifier)theEObject;
				T result = caseVClassifier(vClassifier);
				if (result == null) result = caseVSpec(vClassifier);
				if (result == null) result = caseVPackageable(vClassifier);
				if (result == null) result = caseNamedElement(vClassifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VSPEC_RESOLUTION: {
				VSpecResolution vSpecResolution = (VSpecResolution)theEObject;
				T result = caseVSpecResolution(vSpecResolution);
				if (result == null) result = caseVPackageable(vSpecResolution);
				if (result == null) result = caseNamedElement(vSpecResolution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.CHOICE_RESOLUTUION: {
				ChoiceResolutuion choiceResolutuion = (ChoiceResolutuion)theEObject;
				T result = caseChoiceResolutuion(choiceResolutuion);
				if (result == null) result = caseVSpecResolution(choiceResolutuion);
				if (result == null) result = caseVPackageable(choiceResolutuion);
				if (result == null) result = caseNamedElement(choiceResolutuion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VINSTANCE: {
				VInstance vInstance = (VInstance)theEObject;
				T result = caseVInstance(vInstance);
				if (result == null) result = caseVSpecResolution(vInstance);
				if (result == null) result = caseVPackageable(vInstance);
				if (result == null) result = caseNamedElement(vInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VARIATION_POINT: {
				VariationPoint variationPoint = (VariationPoint)theEObject;
				T result = caseVariationPoint(variationPoint);
				if (result == null) result = caseVPackageable(variationPoint);
				if (result == null) result = caseNamedElement(variationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.FRAGMENT_SUBSTITUTION: {
				FragmentSubstitution fragmentSubstitution = (FragmentSubstitution)theEObject;
				T result = caseFragmentSubstitution(fragmentSubstitution);
				if (result == null) result = caseChoiceVariationPoint(fragmentSubstitution);
				if (result == null) result = caseRepeatableVariationPoint(fragmentSubstitution);
				if (result == null) result = caseVariationPoint(fragmentSubstitution);
				if (result == null) result = caseVPackageable(fragmentSubstitution);
				if (result == null) result = caseNamedElement(fragmentSubstitution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.CHOICE_VARIATION_POINT: {
				ChoiceVariationPoint choiceVariationPoint = (ChoiceVariationPoint)theEObject;
				T result = caseChoiceVariationPoint(choiceVariationPoint);
				if (result == null) result = caseVariationPoint(choiceVariationPoint);
				if (result == null) result = caseVPackageable(choiceVariationPoint);
				if (result == null) result = caseNamedElement(choiceVariationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.REPEATABLE_VARIATION_POINT: {
				RepeatableVariationPoint repeatableVariationPoint = (RepeatableVariationPoint)theEObject;
				T result = caseRepeatableVariationPoint(repeatableVariationPoint);
				if (result == null) result = caseVariationPoint(repeatableVariationPoint);
				if (result == null) result = caseVPackageable(repeatableVariationPoint);
				if (result == null) result = caseNamedElement(repeatableVariationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.BOUNDARY_ELEMENT_BINDING: {
				BoundaryElementBinding boundaryElementBinding = (BoundaryElementBinding)theEObject;
				T result = caseBoundaryElementBinding(boundaryElementBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.PLACEMENT_FRAGMENT: {
				PlacementFragment placementFragment = (PlacementFragment)theEObject;
				T result = casePlacementFragment(placementFragment);
				if (result == null) result = caseVariationPoint(placementFragment);
				if (result == null) result = caseVPackageable(placementFragment);
				if (result == null) result = caseNamedElement(placementFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.PLACEMENT_BOUNDARY_ELEMENT: {
				PlacementBoundaryElement placementBoundaryElement = (PlacementBoundaryElement)theEObject;
				T result = casePlacementBoundaryElement(placementBoundaryElement);
				if (result == null) result = caseVariationPoint(placementBoundaryElement);
				if (result == null) result = caseVPackageable(placementBoundaryElement);
				if (result == null) result = caseNamedElement(placementBoundaryElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.REPLACEMENT_FRAGMENT: {
				ReplacementFragment replacementFragment = (ReplacementFragment)theEObject;
				T result = caseReplacementFragment(replacementFragment);
				if (result == null) result = caseVariationPoint(replacementFragment);
				if (result == null) result = caseVPackageable(replacementFragment);
				if (result == null) result = caseNamedElement(replacementFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VARIABLETYPE: {
				Variabletype variabletype = (Variabletype)theEObject;
				T result = caseVariabletype(variabletype);
				if (result == null) result = caseVPackageable(variabletype);
				if (result == null) result = caseNamedElement(variabletype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.REPLACEMENT_BOUNDARY_ELEMENT: {
				ReplacementBoundaryElement replacementBoundaryElement = (ReplacementBoundaryElement)theEObject;
				T result = caseReplacementBoundaryElement(replacementBoundaryElement);
				if (result == null) result = caseVariationPoint(replacementBoundaryElement);
				if (result == null) result = caseVPackageable(replacementBoundaryElement);
				if (result == null) result = caseNamedElement(replacementBoundaryElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.OBJECT_SUBSTITUTION: {
				ObjectSubstitution objectSubstitution = (ObjectSubstitution)theEObject;
				T result = caseObjectSubstitution(objectSubstitution);
				if (result == null) result = caseChoiceVariationPoint(objectSubstitution);
				if (result == null) result = caseVariationPoint(objectSubstitution);
				if (result == null) result = caseVPackageable(objectSubstitution);
				if (result == null) result = caseNamedElement(objectSubstitution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.OBJECT_HANDLE: {
				ObjectHandle objectHandle = (ObjectHandle)theEObject;
				T result = caseObjectHandle(objectHandle);
				if (result == null) result = caseBaseModelHandle(objectHandle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.BASE_MODEL_HANDLE: {
				BaseModelHandle baseModelHandle = (BaseModelHandle)theEObject;
				T result = caseBaseModelHandle(baseModelHandle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseVSpec(variable);
				if (result == null) result = caseVPackageable(variable);
				if (result == null) result = caseNamedElement(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VALUE_SPECIFICATION: {
				ValueSpecification valueSpecification = (ValueSpecification)theEObject;
				T result = caseValueSpecification(valueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VARIABLE_VALUE_ASSIGNMENT: {
				VariableValueAssignment variableValueAssignment = (VariableValueAssignment)theEObject;
				T result = caseVariableValueAssignment(variableValueAssignment);
				if (result == null) result = caseVSpecResolution(variableValueAssignment);
				if (result == null) result = caseVPackageable(variableValueAssignment);
				if (result == null) result = caseNamedElement(variableValueAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.PRIMITVE_TYPE: {
				PrimitveType primitveType = (PrimitveType)theEObject;
				T result = casePrimitveType(primitveType);
				if (result == null) result = caseVariabletype(primitveType);
				if (result == null) result = caseVPackageable(primitveType);
				if (result == null) result = caseNamedElement(primitveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.OBJECT_TYPE: {
				ObjectType objectType = (ObjectType)theEObject;
				T result = caseObjectType(objectType);
				if (result == null) result = caseVariabletype(objectType);
				if (result == null) result = caseVPackageable(objectType);
				if (result == null) result = caseNamedElement(objectType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VINTERFACE: {
				VInterface vInterface = (VInterface)theEObject;
				T result = caseVInterface(vInterface);
				if (result == null) result = caseVPackageable(vInterface);
				if (result == null) result = caseNamedElement(vInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = caseVPackageable(constraint);
				if (result == null) result = caseNamedElement(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.SLOT_ASSIGNMENT: {
				SlotAssignment slotAssignment = (SlotAssignment)theEObject;
				T result = caseSlotAssignment(slotAssignment);
				if (result == null) result = caseChoiceVariationPoint(slotAssignment);
				if (result == null) result = caseVariationPoint(slotAssignment);
				if (result == null) result = caseVPackageable(slotAssignment);
				if (result == null) result = caseNamedElement(slotAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.OBJECT_EXISTENCE: {
				ObjectExistence objectExistence = (ObjectExistence)theEObject;
				T result = caseObjectExistence(objectExistence);
				if (result == null) result = caseChoiceVariationPoint(objectExistence);
				if (result == null) result = caseVariationPoint(objectExistence);
				if (result == null) result = caseVPackageable(objectExistence);
				if (result == null) result = caseNamedElement(objectExistence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.LINK_END_SUBSTITUTION: {
				LinkEndSubstitution linkEndSubstitution = (LinkEndSubstitution)theEObject;
				T result = caseLinkEndSubstitution(linkEndSubstitution);
				if (result == null) result = caseChoiceVariationPoint(linkEndSubstitution);
				if (result == null) result = caseVariationPoint(linkEndSubstitution);
				if (result == null) result = caseVPackageable(linkEndSubstitution);
				if (result == null) result = caseNamedElement(linkEndSubstitution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.LINK_HANDLE: {
				LinkHandle linkHandle = (LinkHandle)theEObject;
				T result = caseLinkHandle(linkHandle);
				if (result == null) result = caseBaseModelHandle(linkHandle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.CONFIGURABLE_UNIT: {
				ConfigurableUnit configurableUnit = (ConfigurableUnit)theEObject;
				T result = caseConfigurableUnit(configurableUnit);
				if (result == null) result = caseCompositeVariationPoint(configurableUnit);
				if (result == null) result = caseVariationPoint(configurableUnit);
				if (result == null) result = caseVPackageable(configurableUnit);
				if (result == null) result = caseNamedElement(configurableUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.COMPOSITE_VARIATION_POINT: {
				CompositeVariationPoint compositeVariationPoint = (CompositeVariationPoint)theEObject;
				T result = caseCompositeVariationPoint(compositeVariationPoint);
				if (result == null) result = caseVariationPoint(compositeVariationPoint);
				if (result == null) result = caseVPackageable(compositeVariationPoint);
				if (result == null) result = caseNamedElement(compositeVariationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.CV_SPEC: {
				CVSpec cvSpec = (CVSpec)theEObject;
				T result = caseCVSpec(cvSpec);
				if (result == null) result = caseVSpec(cvSpec);
				if (result == null) result = caseVPackageable(cvSpec);
				if (result == null) result = caseNamedElement(cvSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VCONFIGURATION: {
				VConfiguration vConfiguration = (VConfiguration)theEObject;
				T result = caseVConfiguration(vConfiguration);
				if (result == null) result = caseVSpecResolution(vConfiguration);
				if (result == null) result = caseVPackageable(vConfiguration);
				if (result == null) result = caseNamedElement(vConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.LINK_EXISTENCE: {
				LinkExistence linkExistence = (LinkExistence)theEObject;
				T result = caseLinkExistence(linkExistence);
				if (result == null) result = caseChoiceVariationPoint(linkExistence);
				if (result == null) result = caseVariationPoint(linkExistence);
				if (result == null) result = caseVPackageable(linkExistence);
				if (result == null) result = caseNamedElement(linkExistence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.OPAQUE_VARIATION_POINT: {
				OpaqueVariationPoint opaqueVariationPoint = (OpaqueVariationPoint)theEObject;
				T result = caseOpaqueVariationPoint(opaqueVariationPoint);
				if (result == null) result = caseVariationPoint(opaqueVariationPoint);
				if (result == null) result = caseVPackageable(opaqueVariationPoint);
				if (result == null) result = caseNamedElement(opaqueVariationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.OVP_TYPE: {
				OVPType ovpType = (OVPType)theEObject;
				T result = caseOVPType(ovpType);
				if (result == null) result = caseVPackageable(ovpType);
				if (result == null) result = caseNamedElement(ovpType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.OVP_SEMANTIC_SPEC: {
				OVPSemanticSpec ovpSemanticSpec = (OVPSemanticSpec)theEObject;
				T result = caseOVPSemanticSpec(ovpSemanticSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.OBJECT_SPECIFICATION: {
				ObjectSpecification objectSpecification = (ObjectSpecification)theEObject;
				T result = caseObjectSpecification(objectSpecification);
				if (result == null) result = caseValueSpecification(objectSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.REPLACEMENT_FRAGMENT_SPECIFICATION: {
				ReplacementFragmentSpecification replacementFragmentSpecification = (ReplacementFragmentSpecification)theEObject;
				T result = caseReplacementFragmentSpecification(replacementFragmentSpecification);
				if (result == null) result = caseValueSpecification(replacementFragmentSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VPACKAGE: {
				VPackage vPackage = (VPackage)theEObject;
				T result = caseVPackage(vPackage);
				if (result == null) result = caseVPackageable(vPackage);
				if (result == null) result = caseNamedElement(vPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.TO_BINDING: {
				ToBinding toBinding = (ToBinding)theEObject;
				T result = caseToBinding(toBinding);
				if (result == null) result = caseBoundaryElementBinding(toBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.TO_PLACEMENT: {
				ToPlacement toPlacement = (ToPlacement)theEObject;
				T result = caseToPlacement(toPlacement);
				if (result == null) result = casePlacementBoundaryElement(toPlacement);
				if (result == null) result = caseVariationPoint(toPlacement);
				if (result == null) result = caseVPackageable(toPlacement);
				if (result == null) result = caseNamedElement(toPlacement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.TO_REPLACEMENT: {
				ToReplacement toReplacement = (ToReplacement)theEObject;
				T result = caseToReplacement(toReplacement);
				if (result == null) result = caseReplacementBoundaryElement(toReplacement);
				if (result == null) result = caseVariationPoint(toReplacement);
				if (result == null) result = caseVPackageable(toReplacement);
				if (result == null) result = caseNamedElement(toReplacement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.FROM_BINDING: {
				FromBinding fromBinding = (FromBinding)theEObject;
				T result = caseFromBinding(fromBinding);
				if (result == null) result = caseBoundaryElementBinding(fromBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.FROM_PLACEMENT: {
				FromPlacement fromPlacement = (FromPlacement)theEObject;
				T result = caseFromPlacement(fromPlacement);
				if (result == null) result = casePlacementBoundaryElement(fromPlacement);
				if (result == null) result = caseVariationPoint(fromPlacement);
				if (result == null) result = caseVPackageable(fromPlacement);
				if (result == null) result = caseNamedElement(fromPlacement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.FROM_REPLACEMENT: {
				FromReplacement fromReplacement = (FromReplacement)theEObject;
				T result = caseFromReplacement(fromReplacement);
				if (result == null) result = caseReplacementBoundaryElement(fromReplacement);
				if (result == null) result = caseVariationPoint(fromReplacement);
				if (result == null) result = caseVPackageable(fromReplacement);
				if (result == null) result = caseNamedElement(fromReplacement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VSPEC_REF: {
				VSpecRef vSpecRef = (VSpecRef)theEObject;
				T result = caseVSpecRef(vSpecRef);
				if (result == null) result = caseBCLExpression(vSpecRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.BCL_EXPRESSION: {
				BCLExpression bclExpression = (BCLExpression)theEObject;
				T result = caseBCLExpression(bclExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.OPAQUE_CONSTRAINT: {
				OpaqueConstraint opaqueConstraint = (OpaqueConstraint)theEObject;
				T result = caseOpaqueConstraint(opaqueConstraint);
				if (result == null) result = caseConstraint(opaqueConstraint);
				if (result == null) result = caseVPackageable(opaqueConstraint);
				if (result == null) result = caseNamedElement(opaqueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.PARAMETRIC_VARIATION_POINT: {
				ParametricVariationPoint parametricVariationPoint = (ParametricVariationPoint)theEObject;
				T result = caseParametricVariationPoint(parametricVariationPoint);
				if (result == null) result = caseVariationPoint(parametricVariationPoint);
				if (result == null) result = caseVPackageable(parametricVariationPoint);
				if (result == null) result = caseNamedElement(parametricVariationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.SLOT_VALUE_EXISTENCE: {
				SlotValueExistence slotValueExistence = (SlotValueExistence)theEObject;
				T result = caseSlotValueExistence(slotValueExistence);
				if (result == null) result = caseChoiceVariationPoint(slotValueExistence);
				if (result == null) result = caseVariationPoint(slotValueExistence);
				if (result == null) result = caseVPackageable(slotValueExistence);
				if (result == null) result = caseNamedElement(slotValueExistence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION: {
				ParametricLinkEndSubstitution parametricLinkEndSubstitution = (ParametricLinkEndSubstitution)theEObject;
				T result = caseParametricLinkEndSubstitution(parametricLinkEndSubstitution);
				if (result == null) result = caseParametricVariationPoint(parametricLinkEndSubstitution);
				if (result == null) result = caseVariationPoint(parametricLinkEndSubstitution);
				if (result == null) result = caseVPackageable(parametricLinkEndSubstitution);
				if (result == null) result = caseNamedElement(parametricLinkEndSubstitution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.PARAMETRIC_OBJECT_SUBSTITUTION: {
				ParametricObjectSubstitution parametricObjectSubstitution = (ParametricObjectSubstitution)theEObject;
				T result = caseParametricObjectSubstitution(parametricObjectSubstitution);
				if (result == null) result = caseParametricVariationPoint(parametricObjectSubstitution);
				if (result == null) result = caseVariationPoint(parametricObjectSubstitution);
				if (result == null) result = caseVPackageable(parametricObjectSubstitution);
				if (result == null) result = caseNamedElement(parametricObjectSubstitution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.PARAMETRIC_SLOT_ASSIGNMET: {
				ParametricSlotAssignmet parametricSlotAssignmet = (ParametricSlotAssignmet)theEObject;
				T result = caseParametricSlotAssignmet(parametricSlotAssignmet);
				if (result == null) result = caseParametricVariationPoint(parametricSlotAssignmet);
				if (result == null) result = caseVariationPoint(parametricSlotAssignmet);
				if (result == null) result = caseVPackageable(parametricSlotAssignmet);
				if (result == null) result = caseNamedElement(parametricSlotAssignmet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.CHOICE_DERIVATION: {
				ChoiceDerivation choiceDerivation = (ChoiceDerivation)theEObject;
				T result = caseChoiceDerivation(choiceDerivation);
				if (result == null) result = caseVSpecDerivation(choiceDerivation);
				if (result == null) result = caseVPackageable(choiceDerivation);
				if (result == null) result = caseNamedElement(choiceDerivation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.VARIABLE_DERIVATION: {
				VariableDerivation variableDerivation = (VariableDerivation)theEObject;
				T result = caseVariableDerivation(variableDerivation);
				if (result == null) result = caseVSpecDerivation(variableDerivation);
				if (result == null) result = caseVPackageable(variableDerivation);
				if (result == null) result = caseNamedElement(variableDerivation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.CV_SPEC_DERIVATION: {
				CVSpecDerivation cvSpecDerivation = (CVSpecDerivation)theEObject;
				T result = caseCVSpecDerivation(cvSpecDerivation);
				if (result == null) result = caseVSpecDerivation(cvSpecDerivation);
				if (result == null) result = caseVPackageable(cvSpecDerivation);
				if (result == null) result = caseNamedElement(cvSpecDerivation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.CONFIGURABLE_UNIT_USAGE: {
				ConfigurableUnitUsage configurableUnitUsage = (ConfigurableUnitUsage)theEObject;
				T result = caseConfigurableUnitUsage(configurableUnitUsage);
				if (result == null) result = caseCompositeVariationPoint(configurableUnitUsage);
				if (result == null) result = caseVariationPoint(configurableUnitUsage);
				if (result == null) result = caseVPackageable(configurableUnitUsage);
				if (result == null) result = caseNamedElement(configurableUnitUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.PRIMITIVE_VALUE_SPECIFICATION: {
				PrimitiveValueSpecification primitiveValueSpecification = (PrimitiveValueSpecification)theEObject;
				T result = casePrimitiveValueSpecification(primitiveValueSpecification);
				if (result == null) result = caseValueSpecification(primitiveValueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.BCL_CONSTRAINT: {
				BCLConstraint bclConstraint = (BCLConstraint)theEObject;
				T result = caseBCLConstraint(bclConstraint);
				if (result == null) result = caseConstraint(bclConstraint);
				if (result == null) result = caseVPackageable(bclConstraint);
				if (result == null) result = caseNamedElement(bclConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.OPERATION_CALL_EXP: {
				OperationCallExp operationCallExp = (OperationCallExp)theEObject;
				T result = caseOperationCallExp(operationCallExp);
				if (result == null) result = caseBCLExpression(operationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.BOOLEAN_LITERAL_EXP: {
				BooleanLiteralExp booleanLiteralExp = (BooleanLiteralExp)theEObject;
				T result = caseBooleanLiteralExp(booleanLiteralExp);
				if (result == null) result = caseBCLExpression(booleanLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.STRING_LITERAL_EXP: {
				StringLiteralExp stringLiteralExp = (StringLiteralExp)theEObject;
				T result = caseStringLiteralExp(stringLiteralExp);
				if (result == null) result = caseBCLExpression(stringLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.NUMERIC_LITERAL_EXP: {
				NumericLiteralExp numericLiteralExp = (NumericLiteralExp)theEObject;
				T result = caseNumericLiteralExp(numericLiteralExp);
				if (result == null) result = caseBCLExpression(numericLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.INTEGER_LITERAL_EXP: {
				IntegerLiteralExp integerLiteralExp = (IntegerLiteralExp)theEObject;
				T result = caseIntegerLiteralExp(integerLiteralExp);
				if (result == null) result = caseNumericLiteralExp(integerLiteralExp);
				if (result == null) result = caseBCLExpression(integerLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.UNLIMITED_LITERAL_EXP: {
				UnlimitedLiteralExp unlimitedLiteralExp = (UnlimitedLiteralExp)theEObject;
				T result = caseUnlimitedLiteralExp(unlimitedLiteralExp);
				if (result == null) result = caseNumericLiteralExp(unlimitedLiteralExp);
				if (result == null) result = caseBCLExpression(unlimitedLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CvlPackage.REAL_LITERAL_EXP: {
				RealLiteralExp realLiteralExp = (RealLiteralExp)theEObject;
				T result = caseRealLiteralExp(realLiteralExp);
				if (result == null) result = caseNumericLiteralExp(realLiteralExp);
				if (result == null) result = caseBCLExpression(realLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoice(Choice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VSpec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VSpec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVSpec(VSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VPackageable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VPackageable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVPackageable(VPackageable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicity Interval</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicity Interval</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicityInterval(MultiplicityInterval object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VSpec Derivation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VSpec Derivation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVSpecDerivation(VSpecDerivation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VClassifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VClassifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVClassifier(VClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VSpec Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VSpec Resolution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVSpecResolution(VSpecResolution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice Resolutuion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice Resolutuion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoiceResolutuion(ChoiceResolutuion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VInstance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VInstance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVInstance(VInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variation Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variation Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariationPoint(VariationPoint object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Choice Variation Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice Variation Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoiceVariationPoint(ChoiceVariationPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repeatable Variation Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repeatable Variation Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepeatableVariationPoint(RepeatableVariationPoint object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Variabletype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variabletype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariabletype(Variabletype object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Object Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Substitution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectSubstitution(ObjectSubstitution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Handle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Handle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectHandle(ObjectHandle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Model Handle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Model Handle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseModelHandle(BaseModelHandle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueSpecification(ValueSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Value Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Value Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableValueAssignment(VariableValueAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitve Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitve Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitveType(PrimitveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectType(ObjectType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VInterface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VInterface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVInterface(VInterface object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Slot Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Slot Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSlotAssignment(SlotAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Existence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Existence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectExistence(ObjectExistence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link End Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link End Substitution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkEndSubstitution(LinkEndSubstitution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Handle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Handle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkHandle(LinkHandle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configurable Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configurable Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurableUnit(ConfigurableUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Variation Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Variation Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeVariationPoint(CompositeVariationPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CV Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CV Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVSpec(CVSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VConfiguration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VConfiguration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVConfiguration(VConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Existence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Existence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkExistence(LinkExistence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Opaque Variation Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opaque Variation Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpaqueVariationPoint(OpaqueVariationPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OVP Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OVP Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOVPType(OVPType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OVP Semantic Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OVP Semantic Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOVPSemanticSpec(OVPSemanticSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectSpecification(ObjectSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replacement Fragment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replacement Fragment Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplacementFragmentSpecification(ReplacementFragmentSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VPackage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VPackage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVPackage(VPackage object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>VSpec Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VSpec Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVSpecRef(VSpecRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BCL Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBCLExpression(BCLExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Opaque Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opaque Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpaqueConstraint(OpaqueConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parametric Variation Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parametric Variation Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParametricVariationPoint(ParametricVariationPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Slot Value Existence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Slot Value Existence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSlotValueExistence(SlotValueExistence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parametric Link End Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parametric Link End Substitution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParametricLinkEndSubstitution(ParametricLinkEndSubstitution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parametric Object Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parametric Object Substitution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParametricObjectSubstitution(ParametricObjectSubstitution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parametric Slot Assignmet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parametric Slot Assignmet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParametricSlotAssignmet(ParametricSlotAssignmet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice Derivation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice Derivation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoiceDerivation(ChoiceDerivation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Derivation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Derivation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDerivation(VariableDerivation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CV Spec Derivation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CV Spec Derivation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVSpecDerivation(CVSpecDerivation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configurable Unit Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configurable Unit Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurableUnitUsage(ConfigurableUnitUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Value Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveValueSpecification(PrimitiveValueSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BCL Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BCL Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBCLConstraint(BCLConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCallExp(OperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteralExp(BooleanLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteralExp(StringLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericLiteralExp(NumericLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteralExp(IntegerLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unlimited Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unlimited Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnlimitedLiteralExp(UnlimitedLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealLiteralExp(RealLiteralExp object) {
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
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CvlSwitch
