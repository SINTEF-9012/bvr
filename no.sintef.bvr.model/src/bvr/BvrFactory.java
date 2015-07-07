/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
/**
 */
package bvr;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see bvr.BvrPackage
 * @generated
 */
public interface BvrFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BvrFactory eINSTANCE = bvr.impl.BvrFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice</em>'.
	 * @generated
	 */
	Choice createChoice();

	/**
	 * Returns a new object of class '<em>Note</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Note</em>'.
	 * @generated
	 */
	Note createNote();

	/**
	 * Returns a new object of class '<em>Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target</em>'.
	 * @generated
	 */
	Target createTarget();

	/**
	 * Returns a new object of class '<em>Multiplicity Interval</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicity Interval</em>'.
	 * @generated
	 */
	MultiplicityInterval createMultiplicityInterval();

	/**
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	Constraint createConstraint();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	Variable createVariable();

	/**
	 * Returns a new object of class '<em>VClassifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VClassifier</em>'.
	 * @generated
	 */
	VClassifier createVClassifier();

	/**
	 * Returns a new object of class '<em>Choice Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice Occurrence</em>'.
	 * @generated
	 */
	ChoiceOccurrence createChoiceOccurrence();

	/**
	 * Returns a new object of class '<em>VType</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VType</em>'.
	 * @generated
	 */
	VType createVType();

	/**
	 * Returns a new object of class '<em>VClass Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VClass Occurrence</em>'.
	 * @generated
	 */
	VClassOccurrence createVClassOccurrence();

	/**
	 * Returns a new object of class '<em>Staged Variation Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Staged Variation Point</em>'.
	 * @generated
	 */
	StagedVariationPoint createStagedVariationPoint();

	/**
	 * Returns a new object of class '<em>Fragment Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fragment Substitution</em>'.
	 * @generated
	 */
	FragmentSubstitution createFragmentSubstitution();

	/**
	 * Returns a new object of class '<em>Placement Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Placement Fragment</em>'.
	 * @generated
	 */
	PlacementFragment createPlacementFragment();

	/**
	 * Returns a new object of class '<em>Object Handle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Handle</em>'.
	 * @generated
	 */
	ObjectHandle createObjectHandle();

	/**
	 * Returns a new object of class '<em>Replacement Fragment Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replacement Fragment Type</em>'.
	 * @generated
	 */
	ReplacementFragmentType createReplacementFragmentType();

	/**
	 * Returns a new object of class '<em>Value Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Resolution</em>'.
	 * @generated
	 */
	ValueResolution createValueResolution();

	/**
	 * Returns a new object of class '<em>Primitve Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitve Type</em>'.
	 * @generated
	 */
	PrimitveType createPrimitveType();

	/**
	 * Returns a new object of class '<em>Object Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Type</em>'.
	 * @generated
	 */
	ObjectType createObjectType();

	/**
	 * Returns a new object of class '<em>Slot Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Slot Assignment</em>'.
	 * @generated
	 */
	SlotAssignment createSlotAssignment();

	/**
	 * Returns a new object of class '<em>Opaque Variation Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opaque Variation Point</em>'.
	 * @generated
	 */
	OpaqueVariationPoint createOpaqueVariationPoint();

	/**
	 * Returns a new object of class '<em>OVP Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OVP Type</em>'.
	 * @generated
	 */
	OVPType createOVPType();

	/**
	 * Returns a new object of class '<em>OVP Semantic Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OVP Semantic Spec</em>'.
	 * @generated
	 */
	OVPSemanticSpec createOVPSemanticSpec();

	/**
	 * Returns a new object of class '<em>Object Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Specification</em>'.
	 * @generated
	 */
	ObjectSpecification createObjectSpecification();

	/**
	 * Returns a new object of class '<em>Replacement Fragment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replacement Fragment Specification</em>'.
	 * @generated
	 */
	ReplacementFragmentSpecification createReplacementFragmentSpecification();

	/**
	 * Returns a new object of class '<em>VPackage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VPackage</em>'.
	 * @generated
	 */
	VPackage createVPackage();

	/**
	 * Returns a new object of class '<em>To Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To Binding</em>'.
	 * @generated
	 */
	ToBinding createToBinding();

	/**
	 * Returns a new object of class '<em>To Placement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To Placement</em>'.
	 * @generated
	 */
	ToPlacement createToPlacement();

	/**
	 * Returns a new object of class '<em>To Replacement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To Replacement</em>'.
	 * @generated
	 */
	ToReplacement createToReplacement();

	/**
	 * Returns a new object of class '<em>From Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>From Binding</em>'.
	 * @generated
	 */
	FromBinding createFromBinding();

	/**
	 * Returns a new object of class '<em>From Placement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>From Placement</em>'.
	 * @generated
	 */
	FromPlacement createFromPlacement();

	/**
	 * Returns a new object of class '<em>From Replacement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>From Replacement</em>'.
	 * @generated
	 */
	FromReplacement createFromReplacement();

	/**
	 * Returns a new object of class '<em>Target Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Ref</em>'.
	 * @generated
	 */
	TargetRef createTargetRef();

	/**
	 * Returns a new object of class '<em>BCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BCL Expression</em>'.
	 * @generated
	 */
	BCLExpression createBCLExpression();

	/**
	 * Returns a new object of class '<em>Opaque Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opaque Constraint</em>'.
	 * @generated
	 */
	OpaqueConstraint createOpaqueConstraint();

	/**
	 * Returns a new object of class '<em>Parametric Slot Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parametric Slot Assignment</em>'.
	 * @generated
	 */
	ParametricSlotAssignment createParametricSlotAssignment();

	/**
	 * Returns a new object of class '<em>Primitive Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Value Specification</em>'.
	 * @generated
	 */
	PrimitiveValueSpecification createPrimitiveValueSpecification();

	/**
	 * Returns a new object of class '<em>BCL Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BCL Constraint</em>'.
	 * @generated
	 */
	BCLConstraint createBCLConstraint();

	/**
	 * Returns a new object of class '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Call Exp</em>'.
	 * @generated
	 */
	OperationCallExp createOperationCallExp();

	/**
	 * Returns a new object of class '<em>Boolean Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal Exp</em>'.
	 * @generated
	 */
	BooleanLiteralExp createBooleanLiteralExp();

	/**
	 * Returns a new object of class '<em>String Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal Exp</em>'.
	 * @generated
	 */
	StringLiteralExp createStringLiteralExp();

	/**
	 * Returns a new object of class '<em>Numeric Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Literal Exp</em>'.
	 * @generated
	 */
	NumericLiteralExp createNumericLiteralExp();

	/**
	 * Returns a new object of class '<em>Integer Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Literal Exp</em>'.
	 * @generated
	 */
	IntegerLiteralExp createIntegerLiteralExp();

	/**
	 * Returns a new object of class '<em>Unlimited Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unlimited Literal Exp</em>'.
	 * @generated
	 */
	UnlimitedLiteralExp createUnlimitedLiteralExp();

	/**
	 * Returns a new object of class '<em>Real Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Literal Exp</em>'.
	 * @generated
	 */
	RealLiteralExp createRealLiteralExp();

	/**
	 * Returns a new object of class '<em>Neg Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Neg Resolution</em>'.
	 * @generated
	 */
	NegResolution createNegResolution();

	/**
	 * Returns a new object of class '<em>Pos Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pos Resolution</em>'.
	 * @generated
	 */
	PosResolution createPosResolution();

	/**
	 * Returns a new object of class '<em>VRef</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VRef</em>'.
	 * @generated
	 */
	VRef createVRef();

	/**
	 * Returns a new object of class '<em>VRef Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VRef Value Specification</em>'.
	 * @generated
	 */
	VRefValueSpecification createVRefValueSpecification();

	/**
	 * Returns a new object of class '<em>Resolution Literal Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolution Literal Definition</em>'.
	 * @generated
	 */
	ResolutionLiteralDefinition createResolutionLiteralDefinition();

	/**
	 * Returns a new object of class '<em>Resolution Literal Use</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolution Literal Use</em>'.
	 * @generated
	 */
	ResolutionLiteralUse createResolutionLiteralUse();

	/**
	 * Returns a new object of class '<em>BVR Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BVR Model</em>'.
	 * @generated
	 */
	BVRModel createBVRModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BvrPackage getBvrPackage();

} //BvrFactory
