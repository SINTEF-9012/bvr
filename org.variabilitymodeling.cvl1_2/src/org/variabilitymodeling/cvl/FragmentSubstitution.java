/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;

import org.eclipse.emf.common.util.EList;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fragment Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.FragmentSubstitution#getPlacement <em>Placement</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.FragmentSubstitution#getReplacement <em>Replacement</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.FragmentSubstitution#getRfRef <em>Rf Ref</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.FragmentSubstitution#getBoundaryElementBinding <em>Boundary Element Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getFragmentSubstitution()
 * @model annotation="doc description='Fragment Substitution substitutes a fragment of the base model with another fragment of the base model.' semantics='1. Delete the model elements defined by the PlacementFragment. \r\nThe placement model elements can be found through FragmentSubstitution.placement\'s placementBoundaryElements that are of class ToPlacement (using the model element references called insideBoundaryElement) and the transitive closure of all references from these, where the traversal is cut off at any reference that has \r\nthe same value as any of FragmentSubstitution.placement\'s PlacementBoundardyElement that are of class FromPlacement (using the model element references called outsideBoundaryElement). \r\n\r\n2. For the replacement fragments binding, copy its content onto the hole made by the deletion of the placement fragment. The placement and replacement boundary elements must correspond. \r\nThe content model elements can be found through FragmentSubstitution. replacement\'s  ReplacementBoundaryElement that are of type ToReplacement (using the model element references called insideBoundaryElement) and all model elements found through the transitive closure of all references from this set of model elements, where the traversal is cut off at any reference that has the same value as any of FragmentSubstitution.replacement\'s ReplacementBoundaryElement that are of type FromReplacement (using the model element references called outsideBoundaryElement).\r\n\r\n3. Binding boundary elements. The placement and replacement boundary elements are connected by bindings. The bindings are given by the BoundaryElementBindings.\r\n\r\n3.1. FromBinding: \r\n         fromReplacement.insideBoundaryElement.propertyName[] =      \r\n           fromPlacement.outsideBoundaryElement[]\r\n\r\n3.2. ToBinding: \r\n       toPlacement.outsideBoundaryElement.propertyName[] =  \r\n           toReplacement.insideBoundaryElement[]. \r\n\r\nThis definition in fact also covers attributes that have multiplicity. Such attributes may be seen as arrays or collections, and repeated reference assignments to such attributes during variability transformation will mean adding a new individual reference to the identifier collection.' constraint='The boundary elements define all references going in and out of the placement fragment.\r\nThe boundary elements fully define all references going in \r\nand out of the replacement fragment.'"
 * @generated
 */
public interface FragmentSubstitution extends Substitution {
	/**
	 * Returns the value of the '<em><b>Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement</em>' reference.
	 * @see #setPlacement(PlacementFragment)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getFragmentSubstitution_Placement()
	 * @model required="true"
	 *        annotation="doc description='Specifies the fragment to be replaced.'"
	 * @generated
	 */
	PlacementFragment getPlacement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.FragmentSubstitution#getPlacement <em>Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement</em>' reference.
	 * @see #getPlacement()
	 * @generated
	 */
	void setPlacement(PlacementFragment value);

	/**
	 * Returns the value of the '<em><b>Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replacement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replacement</em>' reference.
	 * @see #setReplacement(ReplacementFragmentAbstract)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getFragmentSubstitution_Replacement()
	 * @model required="true"
	 *        annotation="doc description='The new fragment to be copied and used as replacement.'"
	 * @generated
	 */
	ReplacementFragmentAbstract getReplacement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.FragmentSubstitution#getReplacement <em>Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replacement</em>' reference.
	 * @see #getReplacement()
	 * @generated
	 */
	void setReplacement(ReplacementFragmentAbstract value);

	/**
	 * Returns the value of the '<em><b>Rf Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rf Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rf Ref</em>' reference.
	 * @see #setRfRef(ReplacementFragmentReference)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getFragmentSubstitution_RfRef()
	 * @model annotation="doc description='Specifies which ReplacementFragmentReference that will store the instance of the replacement fragment used in this substitution.'"
	 * @generated
	 */
	ReplacementFragmentReference getRfRef();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.FragmentSubstitution#getRfRef <em>Rf Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rf Ref</em>' reference.
	 * @see #getRfRef()
	 * @generated
	 */
	void setRfRef(ReplacementFragmentReference value);

	/**
	 * Returns the value of the '<em><b>Boundary Element Binding</b></em>' containment reference list.
	 * The list contents are of type {@link org.variabilitymodeling.cvl.BoundaryElementBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boundary Element Binding</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boundary Element Binding</em>' containment reference list.
	 * @see org.variabilitymodeling.cvl.CvlPackage#getFragmentSubstitution_BoundaryElementBinding()
	 * @model containment="true"
	 *        annotation="doc description='Specifies the binding betwwen the placement and replacement fragments.'"
	 * @generated
	 */
	EList<BoundaryElementBinding> getBoundaryElementBinding();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitFragmentSubstitution(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitFragmentSubstitution(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // FragmentSubstitution
