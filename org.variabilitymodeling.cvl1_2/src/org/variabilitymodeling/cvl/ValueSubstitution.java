/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;

import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.ValueSubstitution#getPlacement <em>Placement</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.ValueSubstitution#getReplacement <em>Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getValueSubstitution()
 * @model annotation="doc description='The ValueSubstitution defines a substitution that will change the value of an attribute of a base model element.' semantics='The semantics of a ValueSubstitution vs is:\r\n\r\nATTR(vs.placement.propertyName, vs.placement.targetObject) = vs.replacement.value\r\n\r\nwhere ATTR is a reflective operation that given a string and a reference to a model element returns the reference (L-value) to the attribute (of the model element) with name given by the string.' constraint='propertyName must be the name of an attribute of the model element.'"
 * @generated
 */
public interface ValueSubstitution extends Substitution {
	/**
	 * Returns the value of the '<em><b>Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement</em>' reference.
	 * @see #setPlacement(PlacementValue)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getValueSubstitution_Placement()
	 * @model required="true"
	 *        annotation="doc description='Specifies the attribute to be changed.'"
	 * @generated
	 */
	PlacementValue getPlacement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ValueSubstitution#getPlacement <em>Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement</em>' reference.
	 * @see #getPlacement()
	 * @generated
	 */
	void setPlacement(PlacementValue value);

	/**
	 * Returns the value of the '<em><b>Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replacement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replacement</em>' reference.
	 * @see #setReplacement(ReplacementValue)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getValueSubstitution_Replacement()
	 * @model required="true"
	 *        annotation="doc description='Specifies the new value of the attribute.'"
	 * @generated
	 */
	ReplacementValue getReplacement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ValueSubstitution#getReplacement <em>Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replacement</em>' reference.
	 * @see #getReplacement()
	 * @generated
	 */
	void setReplacement(ReplacementValue value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitValueSubstitution(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitValueSubstitution(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ValueSubstitution
