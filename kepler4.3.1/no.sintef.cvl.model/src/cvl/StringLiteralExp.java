/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A literal expression that represents strings.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.StringLiteralExp#getString <em>String</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.CvlPackage#getStringLiteralExp()
 * @model
 * @generated
 */
public interface StringLiteralExp extends BCLExpression {
	/**
	 * Returns the value of the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The string value of this StringLiteralExpression.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>String</em>' attribute.
	 * @see #setString(String)
	 * @see cvl.CvlPackage#getStringLiteralExp_String()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getString();

	/**
	 * Sets the value of the '{@link cvl.StringLiteralExp#getString <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String</em>' attribute.
	 * @see #getString()
	 * @generated
	 */
	void setString(String value);

} // StringLiteralExp
