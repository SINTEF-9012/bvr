/**
 */
package ari;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ari.ExpressionModel#getVariable <em>Variable</em>}</li>
 *   <li>{@link ari.ExpressionModel#getExpressionNode <em>Expression Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see ari.ariPackage#getExpressionModel()
 * @model
 * @generated
 */
public interface ExpressionModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link ari.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see ari.ariPackage#getExpressionModel_Variable()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getVariable();

	/**
	 * Returns the value of the '<em><b>Expression Node</b></em>' containment reference list.
	 * The list contents are of type {@link ari.ExpressionNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Node</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression Node</em>' containment reference list.
	 * @see ari.ariPackage#getExpressionModel_ExpressionNode()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ExpressionNode> getExpressionNode();

} // ExpressionModel
