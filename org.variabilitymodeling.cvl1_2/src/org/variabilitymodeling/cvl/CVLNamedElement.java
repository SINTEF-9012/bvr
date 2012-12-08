/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CVL Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.CVLNamedElement#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getCVLNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface CVLNamedElement extends CVLElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getCVLNamedElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.CVLNamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // CVLNamedElement
