/**
 */
package cvl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BCL Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>Top class of a constraint. Contains basic constraint language expressions. A constraint can have local context, which is a VSpec (we refer to it as the context VSpec), or it can have a global context (i.e., the constraint is global within its enclosing package or configurable unit, and it has no context VSpec). The context determines the VSpec(s) for which the constraint must hold.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.BCLConstraint#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.CvlPackage#getBCLConstraint()
 * @model
 * @generated
 */
public interface BCLConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.BCLExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The constraining expression of this BCLConstraint.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference list.
	 * @see cvl.CvlPackage#getBCLConstraint_Expression()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<BCLExpression> getExpression();

} // BCLConstraint
