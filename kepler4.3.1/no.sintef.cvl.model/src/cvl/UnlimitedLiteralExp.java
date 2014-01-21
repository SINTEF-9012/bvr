/**
 */
package cvl;


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
 *   <li>{@link cvl.UnlimitedLiteralExp#getUnlimited <em>Unlimited</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.CvlPackage#getUnlimitedLiteralExp()
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
	 * @see cvl.CvlPackage#getUnlimitedLiteralExp_Unlimited()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getUnlimited();

	/**
	 * Sets the value of the '{@link cvl.UnlimitedLiteralExp#getUnlimited <em>Unlimited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unlimited</em>' attribute.
	 * @see #getUnlimited()
	 * @generated
	 */
	void setUnlimited(int value);

} // UnlimitedLiteralExp
