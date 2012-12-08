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
 * A representation of the model object '<em><b>Placement Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.PlacementObject#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.PlacementObject#getTargetObject <em>Target Object</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.PlacementObject#getReferredObject <em>Referred Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getPlacementObject()
 * @model annotation="doc description='A placement object represents a reference-typed attribute (with name propertyName) of the model element denoted by targetObject, a reference attribute that by a ReferenceSubstitution may be changed to denote a model element represented by a ReplacementObject.' semantics='Attribute with the name propertyName of the model element denoted by targetObject.' constraint='targetObject must have a reference attribute with name propertyName. This is really a constraint on the combined CVL and base model.'"
 * @generated
 */
public interface PlacementObject extends PlacementLiteral {
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
	 * @see org.variabilitymodeling.cvl.CvlPackage#getPlacementObject_PropertyName()
	 * @model annotation="doc description='Name of the attribute to be changed.'"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.PlacementObject#getPropertyName <em>Property Name</em>}' attribute.
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
	 * @see org.variabilitymodeling.cvl.CvlPackage#getPlacementObject_TargetObject()
	 * @model annotation="doc description='Containing object of the attribute to be changed.'"
	 * @generated
	 */
	EObject getTargetObject();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.PlacementObject#getTargetObject <em>Target Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Object</em>' reference.
	 * @see #getTargetObject()
	 * @generated
	 */
	void setTargetObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Referred Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Object</em>' reference.
	 * @see #setReferredObject(EObject)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getPlacementObject_ReferredObject()
	 * @model annotation="doc description='Reference to the previous referred object, to distinguish multiplicity references.'"
	 * @generated
	 */
	EObject getReferredObject();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.PlacementObject#getReferredObject <em>Referred Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Object</em>' reference.
	 * @see #getReferredObject()
	 * @generated
	 */
	void setReferredObject(EObject value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitPlacementObject(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitPlacementObject(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // PlacementObject
