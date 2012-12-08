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
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.Type#getBody <em>Body</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.Type#getReplacement <em>Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getType()
 * @model annotation="doc description='A type defines the properties of instances, properties that are defined by the body composite variability. The type will configure and instantiate a replacement fragment.' semantics='The local replacement fragment is instantiated. Substitutions in the body configure this instance. This instance is then stored to the ReplacementFragmentReference in the invocation.' constraint='Substitutions in the body can only access placements in the local replacement fragment or in other replacement fragment instances.'"
 * @generated
 */
public interface Type extends Declaration {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(CompositeVariability)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getType_Body()
	 * @model containment="true" required="true"
	 *        annotation="doc description='A CompositeVariability that contains a number of primitives.'"
	 * @generated
	 */
	CompositeVariability getBody();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.Type#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(CompositeVariability value);

	/**
	 * Returns the value of the '<em><b>Replacement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replacement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replacement</em>' containment reference.
	 * @see #setReplacement(ReplacementFragment)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getType_Replacement()
	 * @model containment="true" required="true"
	 *        annotation="doc description='The local replacement fragment that will be instantiated and configured.'"
	 * @generated
	 */
	ReplacementFragment getReplacement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.Type#getReplacement <em>Replacement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replacement</em>' containment reference.
	 * @see #getReplacement()
	 * @generated
	 */
	void setReplacement(ReplacementFragment value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitType(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitType(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // Type
