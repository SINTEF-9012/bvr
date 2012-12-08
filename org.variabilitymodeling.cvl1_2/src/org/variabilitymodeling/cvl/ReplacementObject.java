/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;


import org.eclipse.emf.ecore.EObject;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Replacement Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.ReplacementObject#getTargetObject <em>Target Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getReplacementObject()
 * @model annotation="doc description='Represents the model element that a reference attribute will denote after a reference substitution.' semantics='The semantics of Replacement Value can be found under Reference Substitution.'"
 * @generated
 */
public interface ReplacementObject extends ReplacementLiteral {
	/**
	 * Returns the value of the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Object</em>' reference.
	 * @see #setTargetObject(EObject)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getReplacementObject_TargetObject()
	 * @model annotation="doc description='Reference to the element to be used as value in the substitution.'"
	 * @generated
	 */
	EObject getTargetObject();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ReplacementObject#getTargetObject <em>Target Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Object</em>' reference.
	 * @see #getTargetObject()
	 * @generated
	 */
	void setTargetObject(EObject value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitReplacementObject(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitReplacementObject(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ReplacementObject
