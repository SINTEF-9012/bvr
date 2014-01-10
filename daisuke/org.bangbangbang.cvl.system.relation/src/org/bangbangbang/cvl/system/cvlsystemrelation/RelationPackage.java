/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationFactory
 * @model kind="package"
 * @generated
 */
public interface RelationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cvlsystemrelation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cvlsystemrelation/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cvlsystemrelation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RelationPackage eINSTANCE = org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.CVLReferenceImpl <em>CVL Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.CVLReferenceImpl
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getCVLReference()
	 * @generated
	 */
	int CVL_REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVL_REFERENCE__RELATIONS = 0;

	/**
	 * The feature id for the '<em><b>Cvl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVL_REFERENCE__CVL = 1;

	/**
	 * The number of structural features of the '<em>CVL Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVL_REFERENCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>CVL Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVL_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceRelationImpl <em>Choice Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceRelationImpl
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getChoiceRelation()
	 * @generated
	 */
	int CHOICE_RELATION = 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RELATION__CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>System Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RELATION__SYSTEM_CHOICE = 1;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RELATION__REFERENCES = 2;

	/**
	 * The number of structural features of the '<em>Choice Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RELATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Choice Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RELATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.AbstractChoiceReferenceImpl <em>Abstract Choice Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.AbstractChoiceReferenceImpl
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getAbstractChoiceReference()
	 * @generated
	 */
	int ABSTRACT_CHOICE_REFERENCE = 2;

	/**
	 * The number of structural features of the '<em>Abstract Choice Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CHOICE_REFERENCE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Abstract Choice Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CHOICE_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceReferenceImpl <em>Choice Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceReferenceImpl
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getChoiceReference()
	 * @generated
	 */
	int CHOICE_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Classifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_REFERENCE__CLASSIFIERS = ABSTRACT_CHOICE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_REFERENCE__CHOICE = ABSTRACT_CHOICE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Choice Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_REFERENCE_FEATURE_COUNT = ABSTRACT_CHOICE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Choice Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_REFERENCE_OPERATION_COUNT = ABSTRACT_CHOICE_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceGroupImpl <em>Choice Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceGroupImpl
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getChoiceGroup()
	 * @generated
	 */
	int CHOICE_GROUP = 4;

	/**
	 * The feature id for the '<em><b>Choices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_GROUP__CHOICES = ABSTRACT_CHOICE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_GROUP__OP = ABSTRACT_CHOICE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Choice Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_GROUP_FEATURE_COUNT = ABSTRACT_CHOICE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Choice Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_GROUP_OPERATION_COUNT = ABSTRACT_CHOICE_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.VClassifierReferenceImpl <em>VClassifier Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.VClassifierReferenceImpl
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getVClassifierReference()
	 * @generated
	 */
	int VCLASSIFIER_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Quantifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER_REFERENCE__QUANTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Vclassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER_REFERENCE__VCLASSIFIER = 1;

	/**
	 * The number of structural features of the '<em>VClassifier Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER_REFERENCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>VClassifier Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.LogicalOperator <em>Logical Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.LogicalOperator
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getLogicalOperator()
	 * @generated
	 */
	int LOGICAL_OPERATOR = 6;

	/**
	 * The meta object id for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.Quantifier <em>Quantifier</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.Quantifier
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getQuantifier()
	 * @generated
	 */
	int QUANTIFIER = 7;


	/**
	 * Returns the meta object for class '{@link org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference <em>CVL Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVL Reference</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference
	 * @generated
	 */
	EClass getCVLReference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relations</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference#getRelations()
	 * @see #getCVLReference()
	 * @generated
	 */
	EReference getCVLReference_Relations();

	/**
	 * Returns the meta object for the reference '{@link org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference#getCvl <em>Cvl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Cvl</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference#getCvl()
	 * @see #getCVLReference()
	 * @generated
	 */
	EReference getCVLReference_Cvl();

	/**
	 * Returns the meta object for class '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation <em>Choice Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice Relation</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation
	 * @generated
	 */
	EClass getChoiceRelation();

	/**
	 * Returns the meta object for the reference '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation#getContext()
	 * @see #getChoiceRelation()
	 * @generated
	 */
	EReference getChoiceRelation_Context();

	/**
	 * Returns the meta object for the reference '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation#getSystemChoice <em>System Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System Choice</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation#getSystemChoice()
	 * @see #getChoiceRelation()
	 * @generated
	 */
	EReference getChoiceRelation_SystemChoice();

	/**
	 * Returns the meta object for the containment reference list '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation#getReferences()
	 * @see #getChoiceRelation()
	 * @generated
	 */
	EReference getChoiceRelation_References();

	/**
	 * Returns the meta object for class '{@link org.bangbangbang.cvl.system.cvlsystemrelation.AbstractChoiceReference <em>Abstract Choice Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Choice Reference</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.AbstractChoiceReference
	 * @generated
	 */
	EClass getAbstractChoiceReference();

	/**
	 * Returns the meta object for class '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceReference <em>Choice Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice Reference</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceReference
	 * @generated
	 */
	EClass getChoiceReference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceReference#getClassifiers <em>Classifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classifiers</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceReference#getClassifiers()
	 * @see #getChoiceReference()
	 * @generated
	 */
	EReference getChoiceReference_Classifiers();

	/**
	 * Returns the meta object for the reference '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceReference#getChoice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Choice</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceReference#getChoice()
	 * @see #getChoiceReference()
	 * @generated
	 */
	EReference getChoiceReference_Choice();

	/**
	 * Returns the meta object for class '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceGroup <em>Choice Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice Group</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceGroup
	 * @generated
	 */
	EClass getChoiceGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceGroup#getChoices <em>Choices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Choices</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceGroup#getChoices()
	 * @see #getChoiceGroup()
	 * @generated
	 */
	EReference getChoiceGroup_Choices();

	/**
	 * Returns the meta object for the attribute '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceGroup#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceGroup#getOp()
	 * @see #getChoiceGroup()
	 * @generated
	 */
	EAttribute getChoiceGroup_Op();

	/**
	 * Returns the meta object for class '{@link org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference <em>VClassifier Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VClassifier Reference</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference
	 * @generated
	 */
	EClass getVClassifierReference();

	/**
	 * Returns the meta object for the attribute '{@link org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference#getQuantifier <em>Quantifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantifier</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference#getQuantifier()
	 * @see #getVClassifierReference()
	 * @generated
	 */
	EAttribute getVClassifierReference_Quantifier();

	/**
	 * Returns the meta object for the reference '{@link org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference#getVclassifier <em>Vclassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vclassifier</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference#getVclassifier()
	 * @see #getVClassifierReference()
	 * @generated
	 */
	EReference getVClassifierReference_Vclassifier();

	/**
	 * Returns the meta object for enum '{@link org.bangbangbang.cvl.system.cvlsystemrelation.LogicalOperator <em>Logical Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Logical Operator</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.LogicalOperator
	 * @generated
	 */
	EEnum getLogicalOperator();

	/**
	 * Returns the meta object for enum '{@link org.bangbangbang.cvl.system.cvlsystemrelation.Quantifier <em>Quantifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Quantifier</em>'.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.Quantifier
	 * @generated
	 */
	EEnum getQuantifier();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RelationFactory getRelationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.CVLReferenceImpl <em>CVL Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.CVLReferenceImpl
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getCVLReference()
		 * @generated
		 */
		EClass CVL_REFERENCE = eINSTANCE.getCVLReference();

		/**
		 * The meta object literal for the '<em><b>Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CVL_REFERENCE__RELATIONS = eINSTANCE.getCVLReference_Relations();

		/**
		 * The meta object literal for the '<em><b>Cvl</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CVL_REFERENCE__CVL = eINSTANCE.getCVLReference_Cvl();

		/**
		 * The meta object literal for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceRelationImpl <em>Choice Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceRelationImpl
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getChoiceRelation()
		 * @generated
		 */
		EClass CHOICE_RELATION = eINSTANCE.getChoiceRelation();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_RELATION__CONTEXT = eINSTANCE.getChoiceRelation_Context();

		/**
		 * The meta object literal for the '<em><b>System Choice</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_RELATION__SYSTEM_CHOICE = eINSTANCE.getChoiceRelation_SystemChoice();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_RELATION__REFERENCES = eINSTANCE.getChoiceRelation_References();

		/**
		 * The meta object literal for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.AbstractChoiceReferenceImpl <em>Abstract Choice Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.AbstractChoiceReferenceImpl
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getAbstractChoiceReference()
		 * @generated
		 */
		EClass ABSTRACT_CHOICE_REFERENCE = eINSTANCE.getAbstractChoiceReference();

		/**
		 * The meta object literal for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceReferenceImpl <em>Choice Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceReferenceImpl
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getChoiceReference()
		 * @generated
		 */
		EClass CHOICE_REFERENCE = eINSTANCE.getChoiceReference();

		/**
		 * The meta object literal for the '<em><b>Classifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_REFERENCE__CLASSIFIERS = eINSTANCE.getChoiceReference_Classifiers();

		/**
		 * The meta object literal for the '<em><b>Choice</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_REFERENCE__CHOICE = eINSTANCE.getChoiceReference_Choice();

		/**
		 * The meta object literal for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceGroupImpl <em>Choice Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceGroupImpl
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getChoiceGroup()
		 * @generated
		 */
		EClass CHOICE_GROUP = eINSTANCE.getChoiceGroup();

		/**
		 * The meta object literal for the '<em><b>Choices</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_GROUP__CHOICES = eINSTANCE.getChoiceGroup_Choices();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHOICE_GROUP__OP = eINSTANCE.getChoiceGroup_Op();

		/**
		 * The meta object literal for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.VClassifierReferenceImpl <em>VClassifier Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.VClassifierReferenceImpl
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getVClassifierReference()
		 * @generated
		 */
		EClass VCLASSIFIER_REFERENCE = eINSTANCE.getVClassifierReference();

		/**
		 * The meta object literal for the '<em><b>Quantifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VCLASSIFIER_REFERENCE__QUANTIFIER = eINSTANCE.getVClassifierReference_Quantifier();

		/**
		 * The meta object literal for the '<em><b>Vclassifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VCLASSIFIER_REFERENCE__VCLASSIFIER = eINSTANCE.getVClassifierReference_Vclassifier();

		/**
		 * The meta object literal for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.LogicalOperator <em>Logical Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.LogicalOperator
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getLogicalOperator()
		 * @generated
		 */
		EEnum LOGICAL_OPERATOR = eINSTANCE.getLogicalOperator();

		/**
		 * The meta object literal for the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.Quantifier <em>Quantifier</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.Quantifier
		 * @see org.bangbangbang.cvl.system.cvlsystemrelation.impl.RelationPackageImpl#getQuantifier()
		 * @generated
		 */
		EEnum QUANTIFIER = eINSTANCE.getQuantifier();

	}

} //RelationPackage
