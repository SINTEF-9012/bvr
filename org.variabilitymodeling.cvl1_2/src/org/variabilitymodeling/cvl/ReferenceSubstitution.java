/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;


import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.ReferenceSubstitution#getPlacement <em>Placement</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.ReferenceSubstitution#getReplacement <em>Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getReferenceSubstitution()
 * @model annotation="doc description='The Reference Substitution defines a substitution that will change a reference attribute in the base model.' semantics='The semantics of a reference substitution rs is:\r\n\r\nATTR(rs.placement.propertyName, vs.placement.targetObject) = rs.replacement.targetObject\r\n\r\nwhere ATTR is a reflective operation that, given a string and a reference to a model element, returns a reference (L-value) to the attribute (of the model element) with name given by the string.'"
 * @generated
 */
public interface ReferenceSubstitution extends Substitution {
	/**
	 * Returns the value of the '<em><b>Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement</em>' reference.
	 * @see #setPlacement(PlacementObject)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getReferenceSubstitution_Placement()
	 * @model required="true"
	 *        annotation="doc description='Specifies the reference to be changed.'"
	 * @generated
	 */
	PlacementObject getPlacement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ReferenceSubstitution#getPlacement <em>Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement</em>' reference.
	 * @see #getPlacement()
	 * @generated
	 */
	void setPlacement(PlacementObject value);

	/**
	 * Returns the value of the '<em><b>Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replacement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replacement</em>' reference.
	 * @see #setReplacement(ReplacementObject)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getReferenceSubstitution_Replacement()
	 * @model required="true"
	 *        annotation="doc description='Specifies the new object to be referred.'"
	 * @generated
	 */
	ReplacementObject getReplacement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ReferenceSubstitution#getReplacement <em>Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replacement</em>' reference.
	 * @see #getReplacement()
	 * @generated
	 */
	void setReplacement(ReplacementObject value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitReferenceSubstitution(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitReferenceSubstitution(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ReferenceSubstitution
