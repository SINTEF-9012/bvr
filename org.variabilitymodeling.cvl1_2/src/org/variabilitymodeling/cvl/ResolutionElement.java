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
 * A representation of the model object '<em><b>Resolution Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.ResolutionElement#getElement <em>Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.ResolutionElement#getResolution <em>Resolution</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getResolutionElement()
 * @model annotation="doc description='ResolutionElement contains the resolution values that will bind one specific executable primitive.' semantics='A resolution element resolves a transformation represented by an executable primitive, so that this will be executed.'"
 * @generated
 */
public interface ResolutionElement extends ResolutionSpecification {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(ExecutablePrimitive)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getResolutionElement_Element()
	 * @model required="true"
	 *        annotation="doc description='Specifies the executable primitive to be executed.'"
	 * @generated
	 */
	ExecutablePrimitive getElement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ResolutionElement#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(ExecutablePrimitive value);

	/**
	 * Returns the value of the '<em><b>Resolution</b></em>' containment reference list.
	 * The list contents are of type {@link org.variabilitymodeling.cvl.IteratorResolution}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolution</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolution</em>' containment reference list.
	 * @see org.variabilitymodeling.cvl.CvlPackage#getResolutionElement_Resolution()
	 * @model containment="true"
	 *        annotation="doc description='Specifies further iterator resolutions that are resolved.'"
	 * @generated
	 */
	EList<IteratorResolution> getResolution();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitResolutionElement(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitResolutionElement(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ResolutionElement
