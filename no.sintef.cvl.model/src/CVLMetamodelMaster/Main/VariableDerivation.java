/**
 */
package CVLMetamodelMaster.Main;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Derivation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A variable derivation is a specification how to derive the value of a particular variable from an expression over VSpecs.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.VariableDerivation#getDerivingExpression <em>Deriving Expression</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.VariableDerivation#getDerivedVariable <em>Derived Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see CVLMetamodelMaster.Main.MainPackage#getVariableDerivation()
 * @model
 * @generated
 */
public interface VariableDerivation extends VSpecDerivation {
	/**
	 * Returns the value of the '<em><b>Deriving Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The expression utilized for derivation.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Deriving Expression</em>' containment reference.
	 * @see #setDerivingExpression(BCLExpression)
	 * @see CVLMetamodelMaster.Main.MainPackage#getVariableDerivation_DerivingExpression()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	BCLExpression getDerivingExpression();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.VariableDerivation#getDerivingExpression <em>Deriving Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deriving Expression</em>' containment reference.
	 * @see #getDerivingExpression()
	 * @generated
	 */
	void setDerivingExpression(BCLExpression value);

	/**
	 * Returns the value of the '<em><b>Derived Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The variable it is derived from.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Derived Variable</em>' reference.
	 * @see #setDerivedVariable(Variable)
	 * @see CVLMetamodelMaster.Main.MainPackage#getVariableDerivation_DerivedVariable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Variable getDerivedVariable();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.VariableDerivation#getDerivedVariable <em>Derived Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived Variable</em>' reference.
	 * @see #getDerivedVariable()
	 * @generated
	 */
	void setDerivedVariable(Variable value);

} // VariableDerivation
