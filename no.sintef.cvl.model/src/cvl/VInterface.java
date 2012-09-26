/**
 */
package cvl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VInterface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A VInterface is a collection of VSpecs, possibly organized in tree structures, which serves to specify what it takes to materialize a configurable unit.<span>  </span>Each Configurable unit must be bound to a CVSpec typed by a VInterface. The VInterface may be thought of as the "variability type" or "configuration type" of the configurable unit. A VInterface can be declared as the configuration type of several configurable units since several CVSpecs may be typed by the same VInterface.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.VInterface#getMember <em>Member</em>}</li>
 *   <li>{@link cvl.VInterface#getOwnedConstraint <em>Owned Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getVInterface()
 * @model
 * @generated
 */
public interface VInterface extends VPackageable {
	/**
	 * Returns the value of the '<em><b>Member</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.VSpec}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The members of the interface.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Member</em>' containment reference list.
	 * @see cvl.cvlPackage#getVInterface_Member()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VSpec> getMember();

	/**
	 * Returns the value of the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.Constraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Constraints&nbsp;over&nbsp;the&nbsp;VSPecs&nbsp;over&nbsp;this&nbsp;VInterface
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Constraint</em>' containment reference list.
	 * @see cvl.cvlPackage#getVInterface_OwnedConstraint()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Constraint> getOwnedConstraint();

} // VInterface
