/**
 */
package bvr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Resolution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>CompoundResolutions define roots of subtrees of VSpecResolutions.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.CompoundResolution#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getCompoundResolution()
 * @model abstract="true"
 * @generated
 */
public interface CompoundResolution extends ChoiceResolution {
	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.VSpecResolution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The members of the compound resolution constituting the next level of the resolution tree.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see bvr.BvrPackage#getCompoundResolution_Members()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VSpecResolution> getMembers();

} // CompoundResolution
