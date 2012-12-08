/**
 */
package ari;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ari.ExpressionNode#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see ari.ariPackage#getExpressionNode()
 * @model
 * @generated
 */
public interface ExpressionNode extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
	 * The list contents are of type {@link ari.ExpressionNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference list.
	 * @see ari.ariPackage#getExpressionNode_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ExpressionNode> getExpression();

} // ExpressionNode
