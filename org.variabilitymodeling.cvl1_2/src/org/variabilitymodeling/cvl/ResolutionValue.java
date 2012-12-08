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
 * A representation of the model object '<em><b>Resolution Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.ResolutionValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getResolutionValue()
 * @model annotation="doc description='The resolution value gives the arguments to a value substitution.' semantics='The resolution value will override the replacement value in the value substitution.' constraint='The type of the resolution value has to be of the same kind as the placement value.'"
 * @generated
 */
public interface ResolutionValue extends ResolutionElement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getResolutionValue_Value()
	 * @model annotation="doc description='Defines a value to be used in a value substitution.'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ResolutionValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitResolutionValue(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitResolutionValue(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ResolutionValue
