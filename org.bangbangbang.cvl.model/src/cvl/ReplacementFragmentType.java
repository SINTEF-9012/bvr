/**
 */
package cvl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Replacement Fragment Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>Replacement?Fragment?Type?defines?a?fragment?of?the?base?model?that?will?be?used?as?replacement?for?some?placement?fragment<br>of?the?base?model.</p><p>Constraints:</p><p>The placements contained in a replacement fragments should only involve model elements which are inside the replacement fragment. These placements can be used in all instances of a replacement fragment.</p><p>Semantics:</p><p>The semantics of Replacement Fragment Type can be found under Fragment Substitution.</p><p>####CVLSemanticStart####</p><p>Invariant :</p><p>OCL :</p><p></p><p>####CVLSemanticEnd####</p><p></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.ReplacementFragmentType#getReplacementBoundaryElement <em>Replacement Boundary Element</em>}</li>
 *   <li>{@link cvl.ReplacementFragmentType#getPlacementFragment <em>Placement Fragment</em>}</li>
 *   <li>{@link cvl.ReplacementFragmentType#getSourceObject <em>Source Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.CvlPackage#getReplacementFragmentType()
 * @model
 * @generated
 */
public interface ReplacementFragmentType extends Variabletype {
	/**
	 * Returns the value of the '<em><b>Replacement Boundary Element</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.ReplacementBoundaryElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The boundary elements captures all the relations from and to the fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Replacement Boundary Element</em>' containment reference list.
	 * @see cvl.CvlPackage#getReplacementFragmentType_ReplacementBoundaryElement()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ReplacementBoundaryElement> getReplacementBoundaryElement();

	/**
	 * Returns the value of the '<em><b>Placement Fragment</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.PlacementFragment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Set of placements contained by the replacement fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Placement Fragment</em>' containment reference list.
	 * @see cvl.CvlPackage#getReplacementFragmentType_PlacementFragment()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PlacementFragment> getPlacementFragment();

	/**
	 * Returns the value of the '<em><b>Source Object</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.ObjectHandle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Object</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Object</em>' containment reference list.
	 * @see cvl.CvlPackage#getReplacementFragmentType_SourceObject()
	 * @model containment="true"
	 * @generated
	 */
	EList<ObjectHandle> getSourceObject();

} // ReplacementFragmentType
