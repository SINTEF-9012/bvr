/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From Replacement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.FromReplacement#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.FromReplacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.FromReplacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.FromReplacement#getInsideRef <em>Inside Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getFromReplacement()
 * @model annotation="doc description='FromReplacement is the kind of boundary element that defines the outwards boundary of the owning replacement fragment.\r\n\r\npropertyName is the name of the reference attribute of inside boundary model element that will be changed as part of a fragment substitution.\r\n\r\nThe insideBoundaryElements refer to the base model elements that will have their reference attributes updated as part of a fragment substitution.\r\n\r\nThe outsideBoundaryElement refers to the model elements on the outside of the replacement fragment. In a fragment substitution these references are used to define the extent of the replacement fragment.' semantics='The semantics of To Replacement can be found under Fragment Substitution.' constraint='outsideBoundaryElement = insideRef.outsideBoundaryElement\r\ninsideBoundaryElement != null xor insideRef != null\r\n'"
 * @generated
 */
public interface FromReplacement extends ReplacementBoundaryElement {
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
	 * @see org.variabilitymodeling.cvl.CvlPackage#getFromReplacement_PropertyName()
	 * @model annotation="doc description='Name of the attribute to be changed.'"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.FromReplacement#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Outside Boundary Element</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outside Boundary Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outside Boundary Element</em>' reference list.
	 * @see org.variabilitymodeling.cvl.CvlPackage#getFromReplacement_OutsideBoundaryElement()
	 * @model annotation="doc description='Outside model elements that are referred by model elements inside the fragment.  Used to distinguish miltiplicity references.'"
	 * @generated
	 */
	EList<EObject> getOutsideBoundaryElement();

	/**
	 * Returns the value of the '<em><b>Inside Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inside Boundary Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inside Boundary Element</em>' reference.
	 * @see #setInsideBoundaryElement(EObject)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getFromReplacement_InsideBoundaryElement()
	 * @model annotation="doc description='Inside model elements that refer outside model elements.'"
	 * @generated
	 */
	EObject getInsideBoundaryElement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.FromReplacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inside Boundary Element</em>' reference.
	 * @see #getInsideBoundaryElement()
	 * @generated
	 */
	void setInsideBoundaryElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Inside Ref</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.variabilitymodeling.cvl.FromPlacement#getReplacementBoundaryElement <em>Replacement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inside Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inside Ref</em>' reference.
	 * @see #setInsideRef(FromPlacement)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getFromReplacement_InsideRef()
	 * @see org.variabilitymodeling.cvl.FromPlacement#getReplacementBoundaryElement
	 * @model opposite="replacementBoundaryElement"
	 *        annotation="doc description='Reference to a FromPlacement contained by the replacement fragment.'"
	 * @generated
	 */
	FromPlacement getInsideRef();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.FromReplacement#getInsideRef <em>Inside Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inside Ref</em>' reference.
	 * @see #getInsideRef()
	 * @generated
	 */
	void setInsideRef(FromPlacement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitFromReplacement(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitFromReplacement(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // FromReplacement
