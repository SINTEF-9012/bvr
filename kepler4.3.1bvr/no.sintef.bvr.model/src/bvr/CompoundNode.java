/**
 */
package bvr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p class="MsoNormal"><span style="font-size:8pt;font-family:Tahoma;">CompoundNodes are roots in VNode subtrees.</span></p><p><span style="font-size:8pt;font-family:Tahoma;"></span></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.CompoundNode#getMember <em>Member</em>}</li>
 *   <li>{@link bvr.CompoundNode#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getCompoundNode()
 * @model abstract="true"
 * @generated
 */
public interface CompoundNode extends VNode {
	/**
	 * Returns the value of the '<em><b>Member</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.VNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The members of the compound node constituting the next level of the VSpec tree.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Member</em>' containment reference list.
	 * @see bvr.BvrPackage#getCompoundNode_Member()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VNode> getMember();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.Target}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Targets owned by this CompoundNode.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' containment reference list.
	 * @see bvr.BvrPackage#getCompoundNode_Target()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Target> getTarget();

} // CompoundNode
