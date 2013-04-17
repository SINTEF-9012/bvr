/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A literal expression that represents Boolean values ('true' or 'false').</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.BooleanLiteralExp#isBool <em>Bool</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.CvlPackage#getBooleanLiteralExp()
 * @model
 * @generated
 */
public interface BooleanLiteralExp extends BCLExpression {
	/**
	 * Returns the value of the '<em><b>Bool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The boolean literal value of this expression.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bool</em>' attribute.
	 * @see #setBool(boolean)
	 * @see cvl.CvlPackage#getBooleanLiteralExp_Bool()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isBool();

	/**
	 * Sets the value of the '{@link cvl.BooleanLiteralExp#isBool <em>Bool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bool</em>' attribute.
	 * @see #isBool()
	 * @generated
	 */
	void setBool(boolean value);

} // BooleanLiteralExp
