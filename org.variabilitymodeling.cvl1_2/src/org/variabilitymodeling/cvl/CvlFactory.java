/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;

import org.eclipse.emf.ecore.EFactory;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.variabilitymodeling.cvl.CvlPackage
 * @generated
 */
public interface CvlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CvlFactory eINSTANCE = org.variabilitymodeling.cvl.impl.CvlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CVL Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVL Model</em>'.
	 * @generated
	 */
	CVLModel createCVLModel();

	/**
	 * Returns a new object of class '<em>Reference Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Substitution</em>'.
	 * @generated
	 */
	ReferenceSubstitution createReferenceSubstitution();

	/**
	 * Returns a new object of class '<em>Value Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Substitution</em>'.
	 * @generated
	 */
	ValueSubstitution createValueSubstitution();

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
	 * Returns a new object of class '<em>Replacement Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replacement Fragment</em>'.
	 * @generated
	 */
	ReplacementFragment createReplacementFragment();

	/**
	 * Returns a new object of class '<em>From Placement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>From Placement</em>'.
	 * @generated
	 */
	FromPlacement createFromPlacement();

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
	 * Returns a new object of class '<em>From Replacement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>From Replacement</em>'.
	 * @generated
	 */
	FromReplacement createFromReplacement();

	/**
	 * Returns a new object of class '<em>CVL Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVL Element</em>'.
	 * @generated
	 */
	CVLElement createCVLElement();

	/**
	 * Returns a new object of class '<em>To Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To Binding</em>'.
	 * @generated
	 */
	ToBinding createToBinding();

	/**
	 * Returns a new object of class '<em>From Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>From Binding</em>'.
	 * @generated
	 */
	FromBinding createFromBinding();

	/**
	 * Returns a new object of class '<em>Composite Variability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Variability</em>'.
	 * @generated
	 */
	CompositeVariability createCompositeVariability();

	/**
	 * Returns a new object of class '<em>Placement Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Placement Value</em>'.
	 * @generated
	 */
	PlacementValue createPlacementValue();

	/**
	 * Returns a new object of class '<em>Placement Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Placement Object</em>'.
	 * @generated
	 */
	PlacementObject createPlacementObject();

	/**
	 * Returns a new object of class '<em>Replacement Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replacement Value</em>'.
	 * @generated
	 */
	ReplacementValue createReplacementValue();

	/**
	 * Returns a new object of class '<em>Replacement Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replacement Object</em>'.
	 * @generated
	 */
	ReplacementObject createReplacementObject();

	/**
	 * Returns a new object of class '<em>Resolution Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolution Element</em>'.
	 * @generated
	 */
	ResolutionElement createResolutionElement();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	Type createType();

	/**
	 * Returns a new object of class '<em>Invocation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invocation</em>'.
	 * @generated
	 */
	Invocation createInvocation();

	/**
	 * Returns a new object of class '<em>Iterator Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterator Resolution</em>'.
	 * @generated
	 */
	IteratorResolution createIteratorResolution();

	/**
	 * Returns a new object of class '<em>Iterator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterator</em>'.
	 * @generated
	 */
	Iterator createIterator();

	/**
	 * Returns a new object of class '<em>Replacement Fragment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replacement Fragment Reference</em>'.
	 * @generated
	 */
	ReplacementFragmentReference createReplacementFragmentReference();

	/**
	 * Returns a new object of class '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment</em>'.
	 * @generated
	 */
	Assignment createAssignment();

	/**
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	Constraint createConstraint();

	/**
	 * Returns a new object of class '<em>NOT</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NOT</em>'.
	 * @generated
	 */
	NOT createNOT();

	/**
	 * Returns a new object of class '<em>OR</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OR</em>'.
	 * @generated
	 */
	OR createOR();

	/**
	 * Returns a new object of class '<em>IMPLIES</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IMPLIES</em>'.
	 * @generated
	 */
	IMPLIES createIMPLIES();

	/**
	 * Returns a new object of class '<em>Executable Primitive Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Executable Primitive Term</em>'.
	 * @generated
	 */
	ExecutablePrimitiveTerm createExecutablePrimitiveTerm();

	/**
	 * Returns a new object of class '<em>AND </em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AND </em>'.
	 * @generated
	 */
	AND_ createAND_();

	/**
	 * Returns a new object of class '<em>Resolution Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolution Value</em>'.
	 * @generated
	 */
	ResolutionValue createResolutionValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CvlPackage getCvlPackage();

} //CvlFactory
