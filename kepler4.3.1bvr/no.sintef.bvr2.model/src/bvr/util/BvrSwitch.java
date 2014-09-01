/**
 */
package bvr.util;

import bvr.*;

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
 * @see bvr.BvrPackage
 * @generated
 */
public class BvrSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BvrPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BvrSwitch() {
		if (modelPackage == null) {
			modelPackage = BvrPackage.eINSTANCE;
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
			case BvrPackage.CHOICE: {
				Choice choice = (Choice)theEObject;
				T result = caseChoice(choice);
				if (result == null) result = caseVSpec(choice);
				if (result == null) result = caseCompoundNode(choice);
				if (result == null) result = caseNamedElement(choice);
				if (result == null) result = caseVNode(choice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VSPEC: {
				VSpec vSpec = (VSpec)theEObject;
				T result = caseVSpec(vSpec);
				if (result == null) result = caseNamedElement(vSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.NOTE: {
				Note note = (Note)theEObject;
				T result = caseNote(note);
				if (result == null) result = caseNamedElement(note);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.TARGET: {
				Target target = (Target)theEObject;
				T result = caseTarget(target);
				if (result == null) result = caseNamedElement(target);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.COMPOUND_NODE: {
				CompoundNode compoundNode = (CompoundNode)theEObject;
				T result = caseCompoundNode(compoundNode);
				if (result == null) result = caseVNode(compoundNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VNODE: {
				VNode vNode = (VNode)theEObject;
				T result = caseVNode(vNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.MULTIPLICITY_INTERVAL: {
				MultiplicityInterval multiplicityInterval = (MultiplicityInterval)theEObject;
				T result = caseMultiplicityInterval(multiplicityInterval);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = caseNamedElement(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseVSpec(variable);
				if (result == null) result = caseNamedElement(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VALUE_SPECIFICATION: {
				ValueSpecification valueSpecification = (ValueSpecification)theEObject;
				T result = caseValueSpecification(valueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VARIABLETYPE: {
				Variabletype variabletype = (Variabletype)theEObject;
				T result = caseVariabletype(variabletype);
				if (result == null) result = caseVPackageable(variabletype);
				if (result == null) result = caseNamedElement(variabletype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VPACKAGEABLE: {
				VPackageable vPackageable = (VPackageable)theEObject;
				T result = caseVPackageable(vPackageable);
				if (result == null) result = caseNamedElement(vPackageable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VCLASSIFIER: {
				VClassifier vClassifier = (VClassifier)theEObject;
				T result = caseVClassifier(vClassifier);
				if (result == null) result = caseVSpec(vClassifier);
				if (result == null) result = caseCompoundNode(vClassifier);
				if (result == null) result = caseNamedElement(vClassifier);
				if (result == null) result = caseVNode(vClassifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VSPEC_RESOLUTION: {
				VSpecResolution vSpecResolution = (VSpecResolution)theEObject;
				T result = caseVSpecResolution(vSpecResolution);
				if (result == null) result = caseNamedElement(vSpecResolution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.CHOICE_RESOLUTION: {
				ChoiceResolution choiceResolution = (ChoiceResolution)theEObject;
				T result = caseChoiceResolution(choiceResolution);
				if (result == null) result = caseVSpecResolution(choiceResolution);
				if (result == null) result = caseNamedElement(choiceResolution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.CHOICE_OCCURRENCE: {
				ChoiceOccurrence choiceOccurrence = (ChoiceOccurrence)theEObject;
				T result = caseChoiceOccurrence(choiceOccurrence);
				if (result == null) result = caseVSpec(choiceOccurrence);
				if (result == null) result = caseVNode(choiceOccurrence);
				if (result == null) result = caseNamedElement(choiceOccurrence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VTYPE: {
				VType vType = (VType)theEObject;
				T result = caseVType(vType);
				if (result == null) result = caseCompoundNode(vType);
				if (result == null) result = caseVPackageable(vType);
				if (result == null) result = caseVNode(vType);
				if (result == null) result = caseNamedElement(vType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VCLASS_OCCURRENCE: {
				VClassOccurrence vClassOccurrence = (VClassOccurrence)theEObject;
				T result = caseVClassOccurrence(vClassOccurrence);
				if (result == null) result = caseVSpec(vClassOccurrence);
				if (result == null) result = caseVNode(vClassOccurrence);
				if (result == null) result = caseNamedElement(vClassOccurrence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VARIATION_POINT: {
				VariationPoint variationPoint = (VariationPoint)theEObject;
				T result = caseVariationPoint(variationPoint);
				if (result == null) result = caseNamedElement(variationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.STAGED_VARIATION_POINT: {
				StagedVariationPoint stagedVariationPoint = (StagedVariationPoint)theEObject;
				T result = caseStagedVariationPoint(stagedVariationPoint);
				if (result == null) result = caseVariationPoint(stagedVariationPoint);
				if (result == null) result = caseNamedElement(stagedVariationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.FRAGMENT_SUBSTITUTION: {
				FragmentSubstitution fragmentSubstitution = (FragmentSubstitution)theEObject;
				T result = caseFragmentSubstitution(fragmentSubstitution);
				if (result == null) result = caseChoiceVariationPoint(fragmentSubstitution);
				if (result == null) result = caseRepeatableVariationPoint(fragmentSubstitution);
				if (result == null) result = caseVariationPoint(fragmentSubstitution);
				if (result == null) result = caseNamedElement(fragmentSubstitution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.CHOICE_VARIATION_POINT: {
				ChoiceVariationPoint choiceVariationPoint = (ChoiceVariationPoint)theEObject;
				T result = caseChoiceVariationPoint(choiceVariationPoint);
				if (result == null) result = caseVariationPoint(choiceVariationPoint);
				if (result == null) result = caseNamedElement(choiceVariationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.REPEATABLE_VARIATION_POINT: {
				RepeatableVariationPoint repeatableVariationPoint = (RepeatableVariationPoint)theEObject;
				T result = caseRepeatableVariationPoint(repeatableVariationPoint);
				if (result == null) result = caseVariationPoint(repeatableVariationPoint);
				if (result == null) result = caseNamedElement(repeatableVariationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.BOUNDARY_ELEMENT_BINDING: {
				BoundaryElementBinding boundaryElementBinding = (BoundaryElementBinding)theEObject;
				T result = caseBoundaryElementBinding(boundaryElementBinding);
				if (result == null) result = caseNamedElement(boundaryElementBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.PLACEMENT_FRAGMENT: {
				PlacementFragment placementFragment = (PlacementFragment)theEObject;
				T result = casePlacementFragment(placementFragment);
				if (result == null) result = caseVariationPoint(placementFragment);
				if (result == null) result = caseNamedElement(placementFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.PLACEMENT_BOUNDARY_ELEMENT: {
				PlacementBoundaryElement placementBoundaryElement = (PlacementBoundaryElement)theEObject;
				T result = casePlacementBoundaryElement(placementBoundaryElement);
				if (result == null) result = caseNamedElement(placementBoundaryElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.OBJECT_HANDLE: {
				ObjectHandle objectHandle = (ObjectHandle)theEObject;
				T result = caseObjectHandle(objectHandle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE: {
				ReplacementFragmentType replacementFragmentType = (ReplacementFragmentType)theEObject;
				T result = caseReplacementFragmentType(replacementFragmentType);
				if (result == null) result = caseVariabletype(replacementFragmentType);
				if (result == null) result = caseVPackageable(replacementFragmentType);
				if (result == null) result = caseNamedElement(replacementFragmentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.REPLACEMENT_BOUNDARY_ELEMENT: {
				ReplacementBoundaryElement replacementBoundaryElement = (ReplacementBoundaryElement)theEObject;
				T result = caseReplacementBoundaryElement(replacementBoundaryElement);
				if (result == null) result = caseNamedElement(replacementBoundaryElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VALUE_RESOLUTION: {
				ValueResolution valueResolution = (ValueResolution)theEObject;
				T result = caseValueResolution(valueResolution);
				if (result == null) result = caseVSpecResolution(valueResolution);
				if (result == null) result = caseNamedElement(valueResolution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.PRIMITVE_TYPE: {
				PrimitveType primitveType = (PrimitveType)theEObject;
				T result = casePrimitveType(primitveType);
				if (result == null) result = caseVariabletype(primitveType);
				if (result == null) result = caseVPackageable(primitveType);
				if (result == null) result = caseNamedElement(primitveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.OBJECT_TYPE: {
				ObjectType objectType = (ObjectType)theEObject;
				T result = caseObjectType(objectType);
				if (result == null) result = caseVariabletype(objectType);
				if (result == null) result = caseVPackageable(objectType);
				if (result == null) result = caseNamedElement(objectType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.SLOT_ASSIGNMENT: {
				SlotAssignment slotAssignment = (SlotAssignment)theEObject;
				T result = caseSlotAssignment(slotAssignment);
				if (result == null) result = caseChoiceVariationPoint(slotAssignment);
				if (result == null) result = caseVariationPoint(slotAssignment);
				if (result == null) result = caseNamedElement(slotAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.OPAQUE_VARIATION_POINT: {
				OpaqueVariationPoint opaqueVariationPoint = (OpaqueVariationPoint)theEObject;
				T result = caseOpaqueVariationPoint(opaqueVariationPoint);
				if (result == null) result = caseVariationPoint(opaqueVariationPoint);
				if (result == null) result = caseNamedElement(opaqueVariationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.OVP_TYPE: {
				OVPType ovpType = (OVPType)theEObject;
				T result = caseOVPType(ovpType);
				if (result == null) result = caseVPackageable(ovpType);
				if (result == null) result = caseNamedElement(ovpType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.OVP_SEMANTIC_SPEC: {
				OVPSemanticSpec ovpSemanticSpec = (OVPSemanticSpec)theEObject;
				T result = caseOVPSemanticSpec(ovpSemanticSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.OBJECT_SPECIFICATION: {
				ObjectSpecification objectSpecification = (ObjectSpecification)theEObject;
				T result = caseObjectSpecification(objectSpecification);
				if (result == null) result = caseValueSpecification(objectSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.REPLACEMENT_FRAGMENT_SPECIFICATION: {
				ReplacementFragmentSpecification replacementFragmentSpecification = (ReplacementFragmentSpecification)theEObject;
				T result = caseReplacementFragmentSpecification(replacementFragmentSpecification);
				if (result == null) result = caseValueSpecification(replacementFragmentSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VPACKAGE: {
				VPackage vPackage = (VPackage)theEObject;
				T result = caseVPackage(vPackage);
				if (result == null) result = caseVPackageable(vPackage);
				if (result == null) result = caseNamedElement(vPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.TO_BINDING: {
				ToBinding toBinding = (ToBinding)theEObject;
				T result = caseToBinding(toBinding);
				if (result == null) result = caseBoundaryElementBinding(toBinding);
				if (result == null) result = caseNamedElement(toBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.TO_PLACEMENT: {
				ToPlacement toPlacement = (ToPlacement)theEObject;
				T result = caseToPlacement(toPlacement);
				if (result == null) result = casePlacementBoundaryElement(toPlacement);
				if (result == null) result = caseNamedElement(toPlacement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.TO_REPLACEMENT: {
				ToReplacement toReplacement = (ToReplacement)theEObject;
				T result = caseToReplacement(toReplacement);
				if (result == null) result = caseReplacementBoundaryElement(toReplacement);
				if (result == null) result = caseNamedElement(toReplacement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.FROM_BINDING: {
				FromBinding fromBinding = (FromBinding)theEObject;
				T result = caseFromBinding(fromBinding);
				if (result == null) result = caseBoundaryElementBinding(fromBinding);
				if (result == null) result = caseNamedElement(fromBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.FROM_PLACEMENT: {
				FromPlacement fromPlacement = (FromPlacement)theEObject;
				T result = caseFromPlacement(fromPlacement);
				if (result == null) result = casePlacementBoundaryElement(fromPlacement);
				if (result == null) result = caseNamedElement(fromPlacement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.FROM_REPLACEMENT: {
				FromReplacement fromReplacement = (FromReplacement)theEObject;
				T result = caseFromReplacement(fromReplacement);
				if (result == null) result = caseReplacementBoundaryElement(fromReplacement);
				if (result == null) result = caseNamedElement(fromReplacement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.TARGET_REF: {
				TargetRef targetRef = (TargetRef)theEObject;
				T result = caseTargetRef(targetRef);
				if (result == null) result = caseBCLExpression(targetRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.BCL_EXPRESSION: {
				BCLExpression bclExpression = (BCLExpression)theEObject;
				T result = caseBCLExpression(bclExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.OPAQUE_CONSTRAINT: {
				OpaqueConstraint opaqueConstraint = (OpaqueConstraint)theEObject;
				T result = caseOpaqueConstraint(opaqueConstraint);
				if (result == null) result = caseConstraint(opaqueConstraint);
				if (result == null) result = caseNamedElement(opaqueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.PARAMETRIC_VARIATION_POINT: {
				ParametricVariationPoint parametricVariationPoint = (ParametricVariationPoint)theEObject;
				T result = caseParametricVariationPoint(parametricVariationPoint);
				if (result == null) result = caseVariationPoint(parametricVariationPoint);
				if (result == null) result = caseNamedElement(parametricVariationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT: {
				ParametricSlotAssignment parametricSlotAssignment = (ParametricSlotAssignment)theEObject;
				T result = caseParametricSlotAssignment(parametricSlotAssignment);
				if (result == null) result = caseParametricVariationPoint(parametricSlotAssignment);
				if (result == null) result = caseVariationPoint(parametricSlotAssignment);
				if (result == null) result = caseNamedElement(parametricSlotAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.PRIMITIVE_VALUE_SPECIFICATION: {
				PrimitiveValueSpecification primitiveValueSpecification = (PrimitiveValueSpecification)theEObject;
				T result = casePrimitiveValueSpecification(primitiveValueSpecification);
				if (result == null) result = caseValueSpecification(primitiveValueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.BCL_CONSTRAINT: {
				BCLConstraint bclConstraint = (BCLConstraint)theEObject;
				T result = caseBCLConstraint(bclConstraint);
				if (result == null) result = caseConstraint(bclConstraint);
				if (result == null) result = caseNamedElement(bclConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.OPERATION_CALL_EXP: {
				OperationCallExp operationCallExp = (OperationCallExp)theEObject;
				T result = caseOperationCallExp(operationCallExp);
				if (result == null) result = caseBCLExpression(operationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.BOOLEAN_LITERAL_EXP: {
				BooleanLiteralExp booleanLiteralExp = (BooleanLiteralExp)theEObject;
				T result = caseBooleanLiteralExp(booleanLiteralExp);
				if (result == null) result = caseBCLExpression(booleanLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.STRING_LITERAL_EXP: {
				StringLiteralExp stringLiteralExp = (StringLiteralExp)theEObject;
				T result = caseStringLiteralExp(stringLiteralExp);
				if (result == null) result = caseBCLExpression(stringLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.NUMERIC_LITERAL_EXP: {
				NumericLiteralExp numericLiteralExp = (NumericLiteralExp)theEObject;
				T result = caseNumericLiteralExp(numericLiteralExp);
				if (result == null) result = caseBCLExpression(numericLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.INTEGER_LITERAL_EXP: {
				IntegerLiteralExp integerLiteralExp = (IntegerLiteralExp)theEObject;
				T result = caseIntegerLiteralExp(integerLiteralExp);
				if (result == null) result = caseNumericLiteralExp(integerLiteralExp);
				if (result == null) result = caseBCLExpression(integerLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.UNLIMITED_LITERAL_EXP: {
				UnlimitedLiteralExp unlimitedLiteralExp = (UnlimitedLiteralExp)theEObject;
				T result = caseUnlimitedLiteralExp(unlimitedLiteralExp);
				if (result == null) result = caseNumericLiteralExp(unlimitedLiteralExp);
				if (result == null) result = caseBCLExpression(unlimitedLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.REAL_LITERAL_EXP: {
				RealLiteralExp realLiteralExp = (RealLiteralExp)theEObject;
				T result = caseRealLiteralExp(realLiteralExp);
				if (result == null) result = caseNumericLiteralExp(realLiteralExp);
				if (result == null) result = caseBCLExpression(realLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.COMPOUND_RESOLUTION: {
				CompoundResolution compoundResolution = (CompoundResolution)theEObject;
				T result = caseCompoundResolution(compoundResolution);
				if (result == null) result = caseChoiceResolution(compoundResolution);
				if (result == null) result = caseVSpecResolution(compoundResolution);
				if (result == null) result = caseNamedElement(compoundResolution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.NEG_RESOLUTION: {
				NegResolution negResolution = (NegResolution)theEObject;
				T result = caseNegResolution(negResolution);
				if (result == null) result = caseChoiceResolution(negResolution);
				if (result == null) result = caseVSpecResolution(negResolution);
				if (result == null) result = caseNamedElement(negResolution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.POS_RESOLUTION: {
				PosResolution posResolution = (PosResolution)theEObject;
				T result = casePosResolution(posResolution);
				if (result == null) result = caseCompoundResolution(posResolution);
				if (result == null) result = caseChoiceResolution(posResolution);
				if (result == null) result = caseVSpecResolution(posResolution);
				if (result == null) result = caseNamedElement(posResolution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VREF: {
				VRef vRef = (VRef)theEObject;
				T result = caseVRef(vRef);
				if (result == null) result = caseVariabletype(vRef);
				if (result == null) result = caseVPackageable(vRef);
				if (result == null) result = caseNamedElement(vRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.VREF_VALUE_SPECIFICATION: {
				VRefValueSpecification vRefValueSpecification = (VRefValueSpecification)theEObject;
				T result = caseVRefValueSpecification(vRefValueSpecification);
				if (result == null) result = caseValueSpecification(vRefValueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.RESOLUTION_LITERAL_DEFINITION: {
				ResolutionLiteralDefinition resolutionLiteralDefinition = (ResolutionLiteralDefinition)theEObject;
				T result = caseResolutionLiteralDefinition(resolutionLiteralDefinition);
				if (result == null) result = caseCompoundResolution(resolutionLiteralDefinition);
				if (result == null) result = caseChoiceResolution(resolutionLiteralDefinition);
				if (result == null) result = caseVSpecResolution(resolutionLiteralDefinition);
				if (result == null) result = caseNamedElement(resolutionLiteralDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.RESOLUTION_LITERAL_USE: {
				ResolutionLiteralUse resolutionLiteralUse = (ResolutionLiteralUse)theEObject;
				T result = caseResolutionLiteralUse(resolutionLiteralUse);
				if (result == null) result = caseChoiceResolution(resolutionLiteralUse);
				if (result == null) result = caseVSpecResolution(resolutionLiteralUse);
				if (result == null) result = caseNamedElement(resolutionLiteralUse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BvrPackage.BVR_MODEL: {
				BVRModel bvrModel = (BVRModel)theEObject;
				T result = caseBVRModel(bvrModel);
				if (result == null) result = caseVPackage(bvrModel);
				if (result == null) result = caseVPackageable(bvrModel);
				if (result == null) result = caseNamedElement(bvrModel);
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
	 * Returns the result of interpreting the object as an instance of '<em>Note</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Note</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNote(Note object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTarget(Target object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompoundNode(CompoundNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VNode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVNode(VNode object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Choice Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice Resolution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoiceResolution(ChoiceResolution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice Occurrence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoiceOccurrence(ChoiceOccurrence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VType</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VType</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVType(VType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VClass Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VClass Occurrence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVClassOccurrence(VClassOccurrence object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Staged Variation Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Staged Variation Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStagedVariationPoint(StagedVariationPoint object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Replacement Fragment Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replacement Fragment Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplacementFragmentType(ReplacementFragmentType object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Value Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Resolution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueResolution(ValueResolution object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Target Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetRef(TargetRef object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Parametric Slot Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parametric Slot Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParametricSlotAssignment(ParametricSlotAssignment object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Compound Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound Resolution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompoundResolution(CompoundResolution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Neg Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Neg Resolution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNegResolution(NegResolution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pos Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pos Resolution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePosResolution(PosResolution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VRef</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VRef</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVRef(VRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VRef Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VRef Value Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVRefValueSpecification(VRefValueSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolution Literal Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolution Literal Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResolutionLiteralDefinition(ResolutionLiteralDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolution Literal Use</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolution Literal Use</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResolutionLiteralUse(ResolutionLiteralUse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BVR Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BVR Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBVRModel(BVRModel object) {
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

} //BvrSwitch
