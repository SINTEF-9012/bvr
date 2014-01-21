/**
 */
package bvr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>An expression that represents operations on given subexpressions (arguments). Operations include logical, arithmetic, relational operations, and two predicates.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.OperationCallExp#getArgument <em>Argument</em>}</li>
 *   <li>{@link bvr.OperationCallExp#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getOperationCallExp()
 * @model
 * @generated
 */
public interface OperationCallExp extends BCLExpression {
	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.BCLExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Expressions for the arguments of the operation to be called.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see bvr.BvrPackage#getOperationCallExp_Argument()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<BCLExpression> getArgument();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * The literals are from the enumeration {@link bvr.Operation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Operation to be called.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see bvr.Operation
	 * @see #setOperation(Operation)
	 * @see bvr.BvrPackage#getOperationCallExp_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link bvr.OperationCallExp#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see bvr.Operation
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

} // OperationCallExp
