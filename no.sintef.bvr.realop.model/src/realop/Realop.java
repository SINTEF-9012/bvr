/**
 */
package realop;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Realop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link realop.Realop#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see realop.RealopPackage#getRealop()
 * @model
 * @generated
 */
public interface Realop extends EObject {
	/**
	 * Returns the value of the '<em><b>Operators</b></em>' containment reference list.
	 * The list contents are of type {@link realop.Operator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' containment reference list.
	 * @see realop.RealopPackage#getRealop_Operators()
	 * @model containment="true"
	 * @generated
	 */
	EList<Operator> getOperators();

} // Realop
