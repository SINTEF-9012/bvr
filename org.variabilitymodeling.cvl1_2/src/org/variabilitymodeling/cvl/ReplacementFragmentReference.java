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
 * A representation of the model object '<em><b>Replacement Fragment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.ReplacementFragmentReference#getRfRef <em>Rf Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getReplacementFragmentReference()
 * @model annotation="doc description='ReplacementFragmentReference represent an instance of a replacement fragment. It can only store instances of replacement fragments of the specified kind (ReplacementFragmentReference.rfRef).' semantics='The semantics of ReplacementFragmentReference can be found under Fragment Substitution.'"
 * @generated
 */
public interface ReplacementFragmentReference extends ReplacementFragmentAbstract {
	/**
	 * Returns the value of the '<em><b>Rf Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rf Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rf Ref</em>' reference.
	 * @see #setRfRef(ReplacementFragment)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getReplacementFragmentReference_RfRef()
	 * @model required="true"
	 *        annotation="doc description='Specifies the kind of replacement fragment this reference can store.'"
	 * @generated
	 */
	ReplacementFragment getRfRef();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ReplacementFragmentReference#getRfRef <em>Rf Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rf Ref</em>' reference.
	 * @see #getRfRef()
	 * @generated
	 */
	void setRfRef(ReplacementFragment value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitReplacementFragmentReference(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitReplacementFragmentReference(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ReplacementFragmentReference
