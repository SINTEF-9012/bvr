/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice Derivation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A choice derivation is a specification how to derive the decision for a particular choice from resolutions of other VSpecs using a constraint.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.ChoiceDerivation#getDerivingConstraint <em>Deriving Constraint</em>}</li>
 *   <li>{@link bvr.ChoiceDerivation#getDerivedChoice <em>Derived Choice</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getChoiceDerivation()
 * @model
 * @generated
 */
public interface ChoiceDerivation extends VSpecDerivation {
	/**
	 * Returns the value of the '<em><b>Deriving Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The deriving constraint.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Deriving Constraint</em>' containment reference.
	 * @see #setDerivingConstraint(Constraint)
	 * @see bvr.BvrPackage#getChoiceDerivation_DerivingConstraint()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Constraint getDerivingConstraint();

	/**
	 * Sets the value of the '{@link bvr.ChoiceDerivation#getDerivingConstraint <em>Deriving Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deriving Constraint</em>' containment reference.
	 * @see #getDerivingConstraint()
	 * @generated
	 */
	void setDerivingConstraint(Constraint value);

	/**
	 * Returns the value of the '<em><b>Derived Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The derived choice of this ChoiceDerivation.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Derived Choice</em>' reference.
	 * @see #setDerivedChoice(Choice)
	 * @see bvr.BvrPackage#getChoiceDerivation_DerivedChoice()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Choice getDerivedChoice();

	/**
	 * Sets the value of the '{@link bvr.ChoiceDerivation#getDerivedChoice <em>Derived Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived Choice</em>' reference.
	 * @see #getDerivedChoice()
	 * @generated
	 */
	void setDerivedChoice(Choice value);

} // ChoiceDerivation
