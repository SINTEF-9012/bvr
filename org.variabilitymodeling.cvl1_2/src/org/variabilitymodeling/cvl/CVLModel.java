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
 * A representation of the model object '<em><b>CVL Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.CVLModel#getVariabilitySpecification <em>Variability Specification</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.CVLModel#getResolutionSpecification <em>Resolution Specification</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.CVLModel#getBase <em>Base</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getCVLModel()
 * @model annotation="doc description='A CVL model is the root of the repository that describes the variabilities and resolutions relative to a specific base model.' semantics='CVL models are executed and the appropriate base model is copied and transformed according to the semantic rules. See BaseModel to get a definition of what portion of the base model to start with.\r\n\r\nA CVL Model assumes that model elements are connected by one-way references (see ModelElement).\r\nThe CVL execution will copy a portion of the base model as the starting point of the execution. The portion that is copied is the base model tree defined by the following:\r\n1. CVLModel.base points out a model element, say me\r\n2. From me follow container reference as far as it goes. This model element defines the root of the tree that will define the base model to be copied.'"
 * @generated
 */
public interface CVLModel extends CVLNamedElement {
	/**
	 * Returns the value of the '<em><b>Variability Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variability Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variability Specification</em>' containment reference.
	 * @see #setVariabilitySpecification(VariabilitySpecification)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getCVLModel_VariabilitySpecification()
	 * @model containment="true"
	 *        annotation="doc description='CVL Model contains a Variability Specification.'"
	 * @generated
	 */
	VariabilitySpecification getVariabilitySpecification();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.CVLModel#getVariabilitySpecification <em>Variability Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variability Specification</em>' containment reference.
	 * @see #getVariabilitySpecification()
	 * @generated
	 */
	void setVariabilitySpecification(VariabilitySpecification value);

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
	 * @see org.variabilitymodeling.cvl.CvlPackage#getCVLModel_ResolutionSpecification()
	 * @model containment="true"
	 *        annotation="doc description='CVL Model contains a number of Resolution Specifications.'"
	 * @generated
	 */
	EList<ResolutionSpecification> getResolutionSpecification();

	/**
	 * Returns the value of the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' reference.
	 * @see #setBase(EObject)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getCVLModel_Base()
	 * @model annotation="doc description='The base pointer provides a link to the base model.'"
	 * @generated
	 */
	EObject getBase();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.CVLModel#getBase <em>Base</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' reference.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(EObject value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitCVLModel(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitCVLModel(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // CVLModel
