/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceGroup#getChoices <em>Choices</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceGroup#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getChoiceGroup()
 * @model
 * @generated
 */
public interface ChoiceGroup extends AbstractChoiceReference {
	/**
	 * Returns the value of the '<em><b>Choices</b></em>' reference list.
	 * The list contents are of type {@link org.bangbangbang.cvl.system.cvlsystemrelation.AbstractChoiceReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Choices</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choices</em>' reference list.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getChoiceGroup_Choices()
	 * @model
	 * @generated
	 */
	EList<AbstractChoiceReference> getChoices();

	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bangbangbang.cvl.system.cvlsystemrelation.LogicalOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.LogicalOperator
	 * @see #setOp(LogicalOperator)
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getChoiceGroup_Op()
	 * @model required="true"
	 * @generated
	 */
	LogicalOperator getOp();

	/**
	 * Sets the value of the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceGroup#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.LogicalOperator
	 * @see #getOp()
	 * @generated
	 */
	void setOp(LogicalOperator value);

} // ChoiceGroup
