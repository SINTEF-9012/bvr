/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation.impl;

import org.bangbangbang.cvl.CvlPackage;

import org.bangbangbang.cvl.system.cvlsystemrelation.AbstractChoiceReference;
import org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference;
import org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceGroup;
import org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceReference;
import org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceRelation;
import org.bangbangbang.cvl.system.cvlsystemrelation.LogicalOperator;
import org.bangbangbang.cvl.system.cvlsystemrelation.Quantifier;
import org.bangbangbang.cvl.system.cvlsystemrelation.RelationFactory;
import org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage;
import org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RelationPackageImpl extends EPackageImpl implements RelationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvlReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractChoiceReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vClassifierReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum logicalOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum quantifierEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RelationPackageImpl() {
		super(eNS_URI, RelationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RelationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RelationPackage init() {
		if (isInited) return (RelationPackage)EPackage.Registry.INSTANCE.getEPackage(RelationPackage.eNS_URI);

		// Obtain or create and register package
		RelationPackageImpl theRelationPackage = (RelationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RelationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RelationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CvlPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRelationPackage.createPackageContents();

		// Initialize created meta-data
		theRelationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRelationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RelationPackage.eNS_URI, theRelationPackage);
		return theRelationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVLReference() {
		return cvlReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCVLReference_Relations() {
		return (EReference)cvlReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCVLReference_Cvl() {
		return (EReference)cvlReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoiceRelation() {
		return choiceRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceRelation_Context() {
		return (EReference)choiceRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceRelation_SystemChoice() {
		return (EReference)choiceRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceRelation_References() {
		return (EReference)choiceRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractChoiceReference() {
		return abstractChoiceReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoiceReference() {
		return choiceReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceReference_Classifiers() {
		return (EReference)choiceReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceReference_Choice() {
		return (EReference)choiceReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoiceGroup() {
		return choiceGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceGroup_Choices() {
		return (EReference)choiceGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChoiceGroup_Op() {
		return (EAttribute)choiceGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVClassifierReference() {
		return vClassifierReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVClassifierReference_Quantifier() {
		return (EAttribute)vClassifierReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVClassifierReference_Vclassifier() {
		return (EReference)vClassifierReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLogicalOperator() {
		return logicalOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getQuantifier() {
		return quantifierEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationFactory getRelationFactory() {
		return (RelationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		cvlReferenceEClass = createEClass(CVL_REFERENCE);
		createEReference(cvlReferenceEClass, CVL_REFERENCE__RELATIONS);
		createEReference(cvlReferenceEClass, CVL_REFERENCE__CVL);

		choiceRelationEClass = createEClass(CHOICE_RELATION);
		createEReference(choiceRelationEClass, CHOICE_RELATION__CONTEXT);
		createEReference(choiceRelationEClass, CHOICE_RELATION__SYSTEM_CHOICE);
		createEReference(choiceRelationEClass, CHOICE_RELATION__REFERENCES);

		abstractChoiceReferenceEClass = createEClass(ABSTRACT_CHOICE_REFERENCE);

		choiceReferenceEClass = createEClass(CHOICE_REFERENCE);
		createEReference(choiceReferenceEClass, CHOICE_REFERENCE__CLASSIFIERS);
		createEReference(choiceReferenceEClass, CHOICE_REFERENCE__CHOICE);

		choiceGroupEClass = createEClass(CHOICE_GROUP);
		createEReference(choiceGroupEClass, CHOICE_GROUP__CHOICES);
		createEAttribute(choiceGroupEClass, CHOICE_GROUP__OP);

		vClassifierReferenceEClass = createEClass(VCLASSIFIER_REFERENCE);
		createEAttribute(vClassifierReferenceEClass, VCLASSIFIER_REFERENCE__QUANTIFIER);
		createEReference(vClassifierReferenceEClass, VCLASSIFIER_REFERENCE__VCLASSIFIER);

		// Create enums
		logicalOperatorEEnum = createEEnum(LOGICAL_OPERATOR);
		quantifierEEnum = createEEnum(QUANTIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CvlPackage theCvlPackage = (CvlPackage)EPackage.Registry.INSTANCE.getEPackage(CvlPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		choiceReferenceEClass.getESuperTypes().add(this.getAbstractChoiceReference());
		choiceGroupEClass.getESuperTypes().add(this.getAbstractChoiceReference());

		// Initialize classes, features, and operations; add parameters
		initEClass(cvlReferenceEClass, CVLReference.class, "CVLReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCVLReference_Relations(), this.getChoiceRelation(), null, "relations", null, 0, -1, CVLReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCVLReference_Cvl(), theCvlPackage.getVPackageable(), null, "cvl", null, 0, 1, CVLReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(choiceRelationEClass, ChoiceRelation.class, "ChoiceRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoiceRelation_Context(), theCvlPackage.getVSpec(), null, "context", null, 1, 1, ChoiceRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChoiceRelation_SystemChoice(), theCvlPackage.getChoice(), null, "systemChoice", null, 1, 1, ChoiceRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChoiceRelation_References(), this.getAbstractChoiceReference(), null, "references", null, 0, -1, ChoiceRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractChoiceReferenceEClass, AbstractChoiceReference.class, "AbstractChoiceReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(choiceReferenceEClass, ChoiceReference.class, "ChoiceReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoiceReference_Classifiers(), this.getVClassifierReference(), null, "classifiers", null, 0, -1, ChoiceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChoiceReference_Choice(), theCvlPackage.getChoice(), null, "choice", null, 1, 1, ChoiceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(choiceGroupEClass, ChoiceGroup.class, "ChoiceGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoiceGroup_Choices(), this.getAbstractChoiceReference(), null, "choices", null, 0, -1, ChoiceGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChoiceGroup_Op(), this.getLogicalOperator(), "op", null, 1, 1, ChoiceGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vClassifierReferenceEClass, VClassifierReference.class, "VClassifierReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVClassifierReference_Quantifier(), this.getQuantifier(), "quantifier", null, 1, 1, VClassifierReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVClassifierReference_Vclassifier(), theCvlPackage.getVClassifier(), null, "vclassifier", null, 1, 1, VClassifierReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(logicalOperatorEEnum, LogicalOperator.class, "LogicalOperator");
		addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.AND);
		addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.OR);

		initEEnum(quantifierEEnum, Quantifier.class, "Quantifier");
		addEEnumLiteral(quantifierEEnum, Quantifier.FOR_ALL);
		addEEnumLiteral(quantifierEEnum, Quantifier.EXIST);

		// Create resource
		createResource(eNS_URI);
	}

} //RelationPackageImpl
