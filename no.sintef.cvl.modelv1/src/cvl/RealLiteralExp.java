/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Real Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A literal expression that represents floating-point numbers.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.RealLiteralExp#getReal <em>Real</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getRealLiteralExp()
 * @model
 * @generated
 */
public interface RealLiteralExp extends NumericLiteralExp {
	/**
	 * Returns the value of the '<em><b>Real</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The real value of this RealLiteralExpression.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Real</em>' attribute.
	 * @see #setReal(double)
	 * @see cvl.cvlPackage#getRealLiteralExp_Real()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getReal();

	/**
	 * Sets the value of the '{@link cvl.RealLiteralExp#getReal <em>Real</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Real</em>' attribute.
	 * @see #getReal()
	 * @generated
	 */
	void setReal(double value);

} // RealLiteralExp
