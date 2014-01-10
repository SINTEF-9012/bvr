/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage
 * @generated
 */
public interface RelationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RelationFactory eINSTANCE = org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CVL Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVL Reference</em>'.
	 * @generated
	 */
	CVLReference createCVLReference();

	/**
	 * Returns a new object of class '<em>Choice Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice Relation</em>'.
	 * @generated
	 */
	ChoiceRelation createChoiceRelation();

	/**
	 * Returns a new object of class '<em>Choice Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice Reference</em>'.
	 * @generated
	 */
	ChoiceReference createChoiceReference();

	/**
	 * Returns a new object of class '<em>Choice Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice Group</em>'.
	 * @generated
	 */
	ChoiceGroup createChoiceGroup();

	/**
	 * Returns a new object of class '<em>VClassifier Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VClassifier Reference</em>'.
	 * @generated
	 */
	VClassifierReference createVClassifierReference();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RelationPackage getRelationPackage();

} //RelationFactory
