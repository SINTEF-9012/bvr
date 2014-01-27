/**
 */
package bvr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Replacement Fragment Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>Replacement Fragment Type defines a fragment of the base model that will be used as replacement for some placement fragment<br>of the base model.</p><p>Constraints:</p><p>The placements contained in a replacement fragments should only involve model elements which are inside the replacement fragment. These placements can be used in all instances of a replacement fragment.</p><p>Semantics:</p><p>The semantics of Replacement Fragment Type can be found under Fragment Substitution.</p><p>####BVRSemanticStart####</p><p>Invariant :</p><p>OCL :</p><p></p><p>####BVRSemanticEnd####</p><p></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.ReplacementFragmentType#getReplacementBoundaryElement <em>Replacement Boundary Element</em>}</li>
 *   <li>{@link bvr.ReplacementFragmentType#getPlacementFragment <em>Placement Fragment</em>}</li>
 *   <li>{@link bvr.ReplacementFragmentType#getSourceObject <em>Source Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getReplacementFragmentType()
 * @model
 * @generated
 */
public interface ReplacementFragmentType extends Variabletype {
	/**
	 * Returns the value of the '<em><b>Replacement Boundary Element</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.ReplacementBoundaryElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The boundary elements captures all the relations from and to the fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Replacement Boundary Element</em>' containment reference list.
	 * @see bvr.BvrPackage#getReplacementFragmentType_ReplacementBoundaryElement()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ReplacementBoundaryElement> getReplacementBoundaryElement();

	/**
	 * Returns the value of the '<em><b>Placement Fragment</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.PlacementFragment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Set of placements contained by the replacement fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Placement Fragment</em>' containment reference list.
	 * @see bvr.BvrPackage#getReplacementFragmentType_PlacementFragment()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PlacementFragment> getPlacementFragment();

	/**
	 * Returns the value of the '<em><b>Source Object</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.ObjectHandle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Object</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Object</em>' containment reference list.
	 * @see bvr.BvrPackage#getReplacementFragmentType_SourceObject()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ObjectHandle> getSourceObject();

} // ReplacementFragmentType
