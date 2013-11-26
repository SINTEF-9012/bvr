/**
 */
package org.bangbangbang.cvl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.bangbangbang.cvl.CvlPackage
 * @generated
 */
public interface CvlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CvlFactory eINSTANCE = org.bangbangbang.cvl.impl.CvlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice</em>'.
	 * @generated
	 */
	Choice createChoice();

	/**
	 * Returns a new object of class '<em>Multiplicity Interval</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicity Interval</em>'.
	 * @generated
	 */
	MultiplicityInterval createMultiplicityInterval();

	/**
	 * Returns a new object of class '<em>VSpec Derivation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VSpec Derivation</em>'.
	 * @generated
	 */
	VSpecDerivation createVSpecDerivation();

	/**
	 * Returns a new object of class '<em>VClassifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VClassifier</em>'.
	 * @generated
	 */
	VClassifier createVClassifier();

	/**
	 * Returns a new object of class '<em>Choice Resolutuion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice Resolutuion</em>'.
	 * @generated
	 */
	ChoiceResolutuion createChoiceResolutuion();

	/**
	 * Returns a new object of class '<em>VInstance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VInstance</em>'.
	 * @generated
	 */
	VInstance createVInstance();

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
	 * Returns a new object of class '<em>Replacement Fragment Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replacement Fragment Type</em>'.
	 * @generated
	 */
	ReplacementFragmentType createReplacementFragmentType();

	/**
	 * Returns a new object of class '<em>Variabletype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variabletype</em>'.
	 * @generated
	 */
	Variabletype createVariabletype();

	/**
	 * Returns a new object of class '<em>Object Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Substitution</em>'.
	 * @generated
	 */
	ObjectSubstitution createObjectSubstitution();

	/**
	 * Returns a new object of class '<em>Object Handle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Handle</em>'.
	 * @generated
	 */
	ObjectHandle createObjectHandle();

	/**
	 * Returns a new object of class '<em>Base Model Handle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Model Handle</em>'.
	 * @generated
	 */
	BaseModelHandle createBaseModelHandle();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	Variable createVariable();

	/**
	 * Returns a new object of class '<em>Variable Value Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Value Assignment</em>'.
	 * @generated
	 */
	VariableValueAssignment createVariableValueAssignment();

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
	 * Returns a new object of class '<em>VInterface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VInterface</em>'.
	 * @generated
	 */
	VInterface createVInterface();

	/**
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	Constraint createConstraint();

	/**
	 * Returns a new object of class '<em>Slot Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Slot Assignment</em>'.
	 * @generated
	 */
	SlotAssignment createSlotAssignment();

	/**
	 * Returns a new object of class '<em>Object Existence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Existence</em>'.
	 * @generated
	 */
	ObjectExistence createObjectExistence();

	/**
	 * Returns a new object of class '<em>Link End Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link End Substitution</em>'.
	 * @generated
	 */
	LinkEndSubstitution createLinkEndSubstitution();

	/**
	 * Returns a new object of class '<em>Link Handle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Handle</em>'.
	 * @generated
	 */
	LinkHandle createLinkHandle();

	/**
	 * Returns a new object of class '<em>Configurable Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configurable Unit</em>'.
	 * @generated
	 */
	ConfigurableUnit createConfigurableUnit();

	/**
	 * Returns a new object of class '<em>CV Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CV Spec</em>'.
	 * @generated
	 */
	CVSpec createCVSpec();

	/**
	 * Returns a new object of class '<em>VConfiguration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VConfiguration</em>'.
	 * @generated
	 */
	VConfiguration createVConfiguration();

	/**
	 * Returns a new object of class '<em>Link Existence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Existence</em>'.
	 * @generated
	 */
	LinkExistence createLinkExistence();

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
	 * Returns a new object of class '<em>VSpec Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VSpec Ref</em>'.
	 * @generated
	 */
	VSpecRef createVSpecRef();

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
	 * Returns a new object of class '<em>Slot Value Existence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Slot Value Existence</em>'.
	 * @generated
	 */
	SlotValueExistence createSlotValueExistence();

	/**
	 * Returns a new object of class '<em>Parametric Link End Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parametric Link End Substitution</em>'.
	 * @generated
	 */
	ParametricLinkEndSubstitution createParametricLinkEndSubstitution();

	/**
	 * Returns a new object of class '<em>Parametric Object Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parametric Object Substitution</em>'.
	 * @generated
	 */
	ParametricObjectSubstitution createParametricObjectSubstitution();

	/**
	 * Returns a new object of class '<em>Parametric Slot Assignmet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parametric Slot Assignmet</em>'.
	 * @generated
	 */
	ParametricSlotAssignmet createParametricSlotAssignmet();

	/**
	 * Returns a new object of class '<em>Choice Derivation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice Derivation</em>'.
	 * @generated
	 */
	ChoiceDerivation createChoiceDerivation();

	/**
	 * Returns a new object of class '<em>Variable Derivation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Derivation</em>'.
	 * @generated
	 */
	VariableDerivation createVariableDerivation();

	/**
	 * Returns a new object of class '<em>CV Spec Derivation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CV Spec Derivation</em>'.
	 * @generated
	 */
	CVSpecDerivation createCVSpecDerivation();

	/**
	 * Returns a new object of class '<em>Configurable Unit Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configurable Unit Usage</em>'.
	 * @generated
	 */
	ConfigurableUnitUsage createConfigurableUnitUsage();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CvlPackage getCvlPackage();

} //CvlFactory
