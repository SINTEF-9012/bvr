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
 * A representation of the model object '<em><b>Iterator Resolution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.IteratorResolution#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.IteratorResolution#getChoice <em>Choice</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getIteratorResolution()
 * @model annotation="doc description='An iterator resolution specifies the iterator to be resolved, and which executable elements to be chosen.' semantics='Chosen executable elements in the specified iterator will be executed.'"
 * @generated
 */
public interface IteratorResolution extends ResolutionSpecification {
	/**
	 * Returns the value of the '<em><b>Iterator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator</em>' reference.
	 * @see #setIterator(Iterator)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getIteratorResolution_Iterator()
	 * @model required="true"
	 *        annotation="doc description='Specifies the iterator that will be resolved.'"
	 * @generated
	 */
	Iterator getIterator();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.IteratorResolution#getIterator <em>Iterator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator</em>' reference.
	 * @see #getIterator()
	 * @generated
	 */
	void setIterator(Iterator value);

	/**
	 * Returns the value of the '<em><b>Choice</b></em>' containment reference list.
	 * The list contents are of type {@link org.variabilitymodeling.cvl.ResolutionElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Choice</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choice</em>' containment reference list.
	 * @see org.variabilitymodeling.cvl.CvlPackage#getIteratorResolution_Choice()
	 * @model containment="true"
	 *        annotation="doc description='Specifies the chosen executable elements to be executed.'"
	 * @generated
	 */
	EList<ResolutionElement> getChoice();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitIteratorResolution(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitIteratorResolution(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // IteratorResolution
