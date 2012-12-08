/**
 */
package ari;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ari.BinaryExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link ari.BinaryExpression#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see ari.ariPackage#getBinaryExpression()
 * @model abstract="true"
 * @generated
 */
public interface BinaryExpression extends ExpressionNode {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(ExpressionNode)
	 * @see ari.ariPackage#getBinaryExpression_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpressionNode getLeft();

	/**
	 * Sets the value of the '{@link ari.BinaryExpression#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(ExpressionNode value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(ExpressionNode)
	 * @see ari.ariPackage#getBinaryExpression_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpressionNode getRight();

	/**
	 * Sets the value of the '{@link ari.BinaryExpression#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(ExpressionNode value);

} // BinaryExpression
