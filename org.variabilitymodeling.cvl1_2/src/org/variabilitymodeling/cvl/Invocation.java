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
 * A representation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.Invocation#getType <em>Type</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.Invocation#getResolutionSpecification <em>Resolution Specification</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.Invocation#getRfRef <em>Rf Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getInvocation()
 * @model annotation="doc description='Invocation represents the invocation of a type, execution of the executable primitives of its body, and yielding as result a ReplacementFragmentReference.' semantics='The execution of an invocation implies the generation of an instance according to the type, execution of its executable primitives, and the return of a ReplacementFragmentReference that denotes the resulting replacement fragment.'"
 * @generated
 */
public interface Invocation extends ExecutablePrimitive {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getInvocation_Type()
	 * @model required="true"
	 *        annotation="doc description='The Type to be invoked.'"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.Invocation#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Resolution Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolution Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolution Specification</em>' containment reference.
	 * @see #setResolutionSpecification(ResolutionSpecification)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getInvocation_ResolutionSpecification()
	 * @model containment="true"
	 *        annotation="doc description='Specifies a resolution model to allow partial resolution of the type itself.'"
	 * @generated
	 */
	ResolutionSpecification getResolutionSpecification();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.Invocation#getResolutionSpecification <em>Resolution Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolution Specification</em>' containment reference.
	 * @see #getResolutionSpecification()
	 * @generated
	 */
	void setResolutionSpecification(ResolutionSpecification value);

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
	 * @see org.variabilitymodeling.cvl.CvlPackage#getInvocation_RfRef()
	 * @model required="true"
	 *        annotation="doc description='Specifies which ReplacementFragmentReference that will store the instance of the replacement fragment returned from the type.'"
	 * @generated
	 */
	ReplacementFragmentReference getRfRef();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.Invocation#getRfRef <em>Rf Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rf Ref</em>' reference.
	 * @see #getRfRef()
	 * @generated
	 */
	void setRfRef(ReplacementFragmentReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitInvocation(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitInvocation(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // Invocation
