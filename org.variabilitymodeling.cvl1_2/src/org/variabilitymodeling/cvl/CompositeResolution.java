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
 * A representation of the model object '<em><b>Composite Resolution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.CompositeResolution#getResolutionSpecification <em>Resolution Specification</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.CompositeResolution#getCompositeVariability <em>Composite Variability</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getCompositeResolution()
 * @model
 * @generated
 */
public interface CompositeResolution extends ResolutionSpecification {
	/**
	 * Returns the value of the '<em><b>Resolution Specification</b></em>' containment reference list.
	 * The list contents are of type {@link org.variabilitymodeling.cvl.ResolutionSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolution Specification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolution Specification</em>' containment reference list.
	 * @see org.variabilitymodeling.cvl.CvlPackage#getCompositeResolution_ResolutionSpecification()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResolutionSpecification> getResolutionSpecification();

	/**
	 * Returns the value of the '<em><b>Composite Variability</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Variability</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Variability</em>' reference.
	 * @see #setCompositeVariability(CompositeVariability)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getCompositeResolution_CompositeVariability()
	 * @model required="true"
	 * @generated
	 */
	CompositeVariability getCompositeVariability();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.CompositeResolution#getCompositeVariability <em>Composite Variability</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Variability</em>' reference.
	 * @see #getCompositeVariability()
	 * @generated
	 */
	void setCompositeVariability(CompositeVariability value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitCompositeResolution(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitCompositeResolution(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // CompositeResolution
