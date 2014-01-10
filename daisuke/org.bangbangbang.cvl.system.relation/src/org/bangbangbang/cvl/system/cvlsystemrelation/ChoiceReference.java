/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation;

import org.bangbangbang.cvl.Choice;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceReference#getClassifiers <em>Classifiers</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceReference#getChoice <em>Choice</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getChoiceReference()
 * @model
 * @generated
 */
public interface ChoiceReference extends AbstractChoiceReference {
	/**
	 * Returns the value of the '<em><b>Classifiers</b></em>' containment reference list.
	 * The list contents are of type {@link org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifiers</em>' containment reference list.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getChoiceReference_Classifiers()
	 * @model containment="true"
	 * @generated
	 */
	EList<VClassifierReference> getClassifiers();

	/**
	 * Returns the value of the '<em><b>Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Choice</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choice</em>' reference.
	 * @see #setChoice(Choice)
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getChoiceReference_Choice()
	 * @model required="true"
	 * @generated
	 */
	Choice getChoice();

	/**
	 * Sets the value of the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceReference#getChoice <em>Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Choice</em>' reference.
	 * @see #getChoice()
	 * @generated
	 */
	void setChoice(Choice value);

} // ChoiceReference
