/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unlimited Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A literal expression that represents unlimited natural numbers.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.UnlimitedLiteralExp#getUnlimited <em>Unlimited</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getUnlimitedLiteralExp()
 * @model
 * @generated
 */
public interface UnlimitedLiteralExp extends NumericLiteralExp {
	/**
	 * Returns the value of the '<em><b>Unlimited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Value of this UnlimitedLiteralExpression.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unlimited</em>' attribute.
	 * @see #setUnlimited(int)
	 * @see bvr.BvrPackage#getUnlimitedLiteralExp_Unlimited()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getUnlimited();

	/**
	 * Sets the value of the '{@link bvr.UnlimitedLiteralExp#getUnlimited <em>Unlimited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unlimited</em>' attribute.
	 * @see #getUnlimited()
	 * @generated
	 */
	void setUnlimited(int value);

} // UnlimitedLiteralExp
