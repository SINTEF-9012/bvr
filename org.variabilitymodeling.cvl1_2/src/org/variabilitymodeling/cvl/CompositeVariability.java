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
 * A representation of the model object '<em><b>Composite Variability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.CompositeVariability#getVariabilitySpecification <em>Variability Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getCompositeVariability()
 * @model annotation="doc description='A CompositeVariability contains a ordered set of Variability Specifications.' semantics='The execution of a CompositeVariability consists of the execution of its executable primitives.'"
 * @generated
 */
public interface CompositeVariability extends ExecutablePrimitive {
	/**
	 * Returns the value of the '<em><b>Variability Specification</b></em>' containment reference list.
	 * The list contents are of type {@link org.variabilitymodeling.cvl.VariabilitySpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variability Specification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variability Specification</em>' containment reference list.
	 * @see org.variabilitymodeling.cvl.CvlPackage#getCompositeVariability_VariabilitySpecification()
	 * @model containment="true"
	 *        annotation="doc description='CompositeVariability contains a number of Variability Specifications.'"
	 * @generated
	 */
	EList<VariabilitySpecification> getVariabilitySpecification();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitCompositeVariability(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitCompositeVariability(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // CompositeVariability
