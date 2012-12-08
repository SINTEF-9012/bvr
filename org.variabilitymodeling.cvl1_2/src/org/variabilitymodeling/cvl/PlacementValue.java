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
 * A representation of the model object '<em><b>Placement Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.PlacementValue#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.PlacementValue#getTargetObject <em>Target Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getPlacementValue()
 * @model annotation="doc description='A placement value represents a value-typed attribute (with name propertyName) of the model element denoted by targetObject, an attribute that by a ValueSubstitution may get a new value represented by a ReplacementValue.' semantics='Attribute with the name propertyName of the model element denoted by targetObject.'"
 * @generated
 */
public interface PlacementValue extends PlacementLiteral {
	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getPlacementValue_PropertyName()
	 * @model annotation="doc description='Name of the attribute to be changed.'"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.PlacementValue#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

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
	 * @see org.variabilitymodeling.cvl.CvlPackage#getPlacementValue_TargetObject()
	 * @model annotation="doc description='Containing object of the attribute to be changed.'"
	 * @generated
	 */
	EObject getTargetObject();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.PlacementValue#getTargetObject <em>Target Object</em>}' reference.
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitPlacementValue(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitPlacementValue(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // PlacementValue
