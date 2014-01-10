/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation;

import org.bangbangbang.cvl.Choice;
import org.bangbangbang.cvl.VSpec;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation#getContext <em>Context</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation#getSystemChoice <em>System Choice</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getChoiceRelation()
 * @model
 * @generated
 */
public interface ChoiceRelation extends EObject {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(VSpec)
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getChoiceRelation_Context()
	 * @model required="true"
	 * @generated
	 */
	VSpec getContext();

	/**
	 * Sets the value of the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(VSpec value);

	/**
	 * Returns the value of the '<em><b>System Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Choice</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Choice</em>' reference.
	 * @see #setSystemChoice(Choice)
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getChoiceRelation_SystemChoice()
	 * @model required="true"
	 * @generated
	 */
	Choice getSystemChoice();

	/**
	 * Sets the value of the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation#getSystemChoice <em>System Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Choice</em>' reference.
	 * @see #getSystemChoice()
	 * @generated
	 */
	void setSystemChoice(Choice value);

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link org.bangbangbang.cvl.system.cvlsystemrelation.AbstractChoiceReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getChoiceRelation_References()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractChoiceReference> getReferences();

} // ChoiceRelation
