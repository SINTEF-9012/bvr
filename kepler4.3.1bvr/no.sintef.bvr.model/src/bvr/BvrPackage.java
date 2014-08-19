/**
 */
package bvr;

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
 * @see bvr.BvrFactory
 * @model kind="package"
 *        annotation="com.ibm.xtools.common.ui.reduction.editingCapabilities com.ibm.xtools.activities.umlBBFragment='1' com.ibm.xtools.activities.umlBBAction='1' com.ibm.xtools.activities.umlBBClassTemplateParameter='1' com.ibm.xtools.activities.umlBBPackageTemplateParameter='1' com.ibm.xtools.activities.umlBBSequence1='1' com.ibm.xtools.activities.umlBBRelationship1='1' com.ibm.xtools.activities.umlBBSequence2='1' com.ibm.xtools.activities.umlBBCollaborationUse='1' com.ibm.xtools.activities.umlBBRelationship2='1' com.ibm.xtools.activities.umlBBSubsystem='1' com.ibm.xtools.activities.umlBBComment1='1' com.ibm.xtools.activities.umlBBLifeLine='1' com.ibm.xtools.activities.umlBBComment2='1' com.ibm.xtools.activities.umlBBActivity1='1' com.ibm.xtools.activities.umlBBActivity2='1' com.ibm.xtools.activities.umlBBActivity3='1' com.ibm.xtools.activities.umlBBFunction='1' com.ibm.xtools.activities.umlBBActivityDiagram='1' com.ibm.xtools.activities.umlBBCommunication='1' com.ibm.xtools.activities.umlBBCollaboration='1' com.ibm.xtools.activities.umlBBClass='1' com.ibm.xtools.activities.umlBBInterface='1' com.ibm.xtools.activities.umlBBUseCaseDiagram='1' com.ibm.xtools.activities.umlBBTypes1='1' com.ibm.xtools.activities.umlBBTypes2='1' com.ibm.xtools.activities.umlBBComponentTemplateParameter='1' com.ibm.xtools.activities.umlBBTypes3='1' com.ibm.xtools.activities.umlBBTypes4='1' com.ibm.xtools.activities.umlBBUseCase1='1' com.ibm.xtools.activities.umlBBUseCase2='1' com.ibm.xtools.activities.umlBBPackage='1' com.ibm.xtools.activities.umlBBComponentDiagram='1' com.ibm.xtools.activities.umlBBInterfaceTemplateParameter='1' com.ibm.xtools.activities.umlBBClassDiagram='1' com.ibm.xtools.activities.umlBBRealization='1' com.ibm.xtools.activities.umlBBComponent='1' com.ibm.xtools.activities.umlBBSequenceDiagram='1'"
 * @generated
 */
public interface BvrPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "bvr";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///bvr.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "bvr";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BvrPackage eINSTANCE = bvr.impl.BvrPackageImpl.init();

	/**
	 * The meta object id for the '{@link bvr.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.NamedElementImpl
	 * @see bvr.impl.BvrPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NOTE = 1;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link bvr.impl.VSpecImpl <em>VSpec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.VSpecImpl
	 * @see bvr.impl.BvrPackageImpl#getVSpec()
	 * @generated
	 */
	int VSPEC = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC__NOTE = NAMED_ELEMENT__NOTE;

	/**
	 * The feature id for the '<em><b>Resolution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC__RESOLUTION_TIME = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC__TARGET = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>VSpec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>VSpec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ChoiceImpl
	 * @see bvr.impl.BvrPackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__NAME = VSPEC__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__NOTE = VSPEC__NOTE;

	/**
	 * The feature id for the '<em><b>Resolution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__RESOLUTION_TIME = VSPEC__RESOLUTION_TIME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__TARGET = VSPEC__TARGET;

	/**
	 * The feature id for the '<em><b>Default Resolution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__DEFAULT_RESOLUTION = VSPEC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Implied By Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__IS_IMPLIED_BY_PARENT = VSPEC_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = VSPEC_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_OPERATION_COUNT = VSPEC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.NoteImpl <em>Note</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.NoteImpl
	 * @see bvr.impl.BvrPackageImpl#getNote()
	 * @generated
	 */
	int NOTE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__NOTE = NAMED_ELEMENT__NOTE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__KIND = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__EXPR = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Note</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Note</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.TargetImpl <em>Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.TargetImpl
	 * @see bvr.impl.BvrPackageImpl#getTarget()
	 * @generated
	 */
	int TARGET = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__NOTE = NAMED_ELEMENT__NOTE;

	/**
	 * The number of structural features of the '<em>Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.VNodeImpl <em>VNode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.VNodeImpl
	 * @see bvr.impl.BvrPackageImpl#getVNode()
	 * @generated
	 */
	int VNODE = 6;

	/**
	 * The feature id for the '<em><b>Group Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNODE__GROUP_MULTIPLICITY = 0;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNODE__OWNED_CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNODE__VARIABLE = 2;

	/**
	 * The number of structural features of the '<em>VNode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNODE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>VNode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link bvr.impl.CompoundNodeImpl <em>Compound Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.CompoundNodeImpl
	 * @see bvr.impl.BvrPackageImpl#getCompoundNode()
	 * @generated
	 */
	int COMPOUND_NODE = 5;

	/**
	 * The feature id for the '<em><b>Group Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__GROUP_MULTIPLICITY = VNODE__GROUP_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__OWNED_CONSTRAINT = VNODE__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__VARIABLE = VNODE__VARIABLE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__MEMBER = VNODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__TARGET = VNODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Compound Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE_FEATURE_COUNT = VNODE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Compound Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE_OPERATION_COUNT = VNODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.MultiplicityIntervalImpl <em>Multiplicity Interval</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.MultiplicityIntervalImpl
	 * @see bvr.impl.BvrPackageImpl#getMultiplicityInterval()
	 * @generated
	 */
	int MULTIPLICITY_INTERVAL = 7;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_INTERVAL__UPPER = 0;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_INTERVAL__LOWER = 1;

	/**
	 * The number of structural features of the '<em>Multiplicity Interval</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_INTERVAL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Multiplicity Interval</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_INTERVAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ConstraintImpl
	 * @see bvr.impl.BvrPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NOTE = NAMED_ELEMENT__NOTE;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.VariableImpl
	 * @see bvr.impl.BvrPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = VSPEC__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NOTE = VSPEC__NOTE;

	/**
	 * The feature id for the '<em><b>Resolution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__RESOLUTION_TIME = VSPEC__RESOLUTION_TIME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TARGET = VSPEC__TARGET;

	/**
	 * The feature id for the '<em><b>Defaul Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__DEFAUL_VALUE = VSPEC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = VSPEC_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = VSPEC_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = VSPEC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ValueSpecificationImpl <em>Value Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ValueSpecificationImpl
	 * @see bvr.impl.BvrPackageImpl#getValueSpecification()
	 * @generated
	 */
	int VALUE_SPECIFICATION = 10;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link bvr.impl.VPackageableImpl <em>VPackageable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.VPackageableImpl
	 * @see bvr.impl.BvrPackageImpl#getVPackageable()
	 * @generated
	 */
	int VPACKAGEABLE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPACKAGEABLE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPACKAGEABLE__NOTE = NAMED_ELEMENT__NOTE;

	/**
	 * The number of structural features of the '<em>VPackageable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPACKAGEABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>VPackageable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPACKAGEABLE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.VariabletypeImpl <em>Variabletype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.VariabletypeImpl
	 * @see bvr.impl.BvrPackageImpl#getVariabletype()
	 * @generated
	 */
	int VARIABLETYPE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLETYPE__NAME = VPACKAGEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLETYPE__NOTE = VPACKAGEABLE__NOTE;

	/**
	 * The number of structural features of the '<em>Variabletype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLETYPE_FEATURE_COUNT = VPACKAGEABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Variabletype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLETYPE_OPERATION_COUNT = VPACKAGEABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.VClassifierImpl <em>VClassifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.VClassifierImpl
	 * @see bvr.impl.BvrPackageImpl#getVClassifier()
	 * @generated
	 */
	int VCLASSIFIER = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER__NAME = VSPEC__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER__NOTE = VSPEC__NOTE;

	/**
	 * The feature id for the '<em><b>Resolution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER__RESOLUTION_TIME = VSPEC__RESOLUTION_TIME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER__TARGET = VSPEC__TARGET;

	/**
	 * The feature id for the '<em><b>Instance Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER__INSTANCE_MULTIPLICITY = VSPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VClassifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER_FEATURE_COUNT = VSPEC_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>VClassifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER_OPERATION_COUNT = VSPEC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.VSpecResolutionImpl <em>VSpec Resolution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.VSpecResolutionImpl
	 * @see bvr.impl.BvrPackageImpl#getVSpecResolution()
	 * @generated
	 */
	int VSPEC_RESOLUTION = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_RESOLUTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_RESOLUTION__NOTE = NAMED_ELEMENT__NOTE;

	/**
	 * The feature id for the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_RESOLUTION__RESOLVED_VSPEC = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VSpec Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_RESOLUTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>VSpec Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_RESOLUTION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ChoiceResolutionImpl <em>Choice Resolution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ChoiceResolutionImpl
	 * @see bvr.impl.BvrPackageImpl#getChoiceResolution()
	 * @generated
	 */
	int CHOICE_RESOLUTION = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTION__NAME = VSPEC_RESOLUTION__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTION__NOTE = VSPEC_RESOLUTION__NOTE;

	/**
	 * The feature id for the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTION__RESOLVED_VSPEC = VSPEC_RESOLUTION__RESOLVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Resolved Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTION__RESOLVED_CHOICE = VSPEC_RESOLUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resolved Choice Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTION__RESOLVED_CHOICE_OCC = VSPEC_RESOLUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolved VClass Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTION__RESOLVED_VCLASS_OCC = VSPEC_RESOLUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resolved VClassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTION__RESOLVED_VCLASSIFIER = VSPEC_RESOLUTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Choice Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTION_FEATURE_COUNT = VSPEC_RESOLUTION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Choice Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTION_OPERATION_COUNT = VSPEC_RESOLUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ChoiceOccurrenceImpl <em>Choice Occurrence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ChoiceOccurrenceImpl
	 * @see bvr.impl.BvrPackageImpl#getChoiceOccurrence()
	 * @generated
	 */
	int CHOICE_OCCURRENCE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_OCCURRENCE__NAME = VSPEC__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_OCCURRENCE__NOTE = VSPEC__NOTE;

	/**
	 * The feature id for the '<em><b>Resolution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_OCCURRENCE__RESOLUTION_TIME = VSPEC__RESOLUTION_TIME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_OCCURRENCE__TARGET = VSPEC__TARGET;

	/**
	 * The feature id for the '<em><b>Group Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_OCCURRENCE__GROUP_MULTIPLICITY = VSPEC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_OCCURRENCE__OWNED_CONSTRAINT = VSPEC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_OCCURRENCE__VARIABLE = VSPEC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>VType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_OCCURRENCE__VTYPE = VSPEC_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Choice Occurrence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_OCCURRENCE_FEATURE_COUNT = VSPEC_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Choice Occurrence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_OCCURRENCE_OPERATION_COUNT = VSPEC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.VTypeImpl <em>VType</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.VTypeImpl
	 * @see bvr.impl.BvrPackageImpl#getVType()
	 * @generated
	 */
	int VTYPE = 17;

	/**
	 * The feature id for the '<em><b>Group Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VTYPE__GROUP_MULTIPLICITY = COMPOUND_NODE__GROUP_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VTYPE__OWNED_CONSTRAINT = COMPOUND_NODE__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VTYPE__VARIABLE = COMPOUND_NODE__VARIABLE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VTYPE__MEMBER = COMPOUND_NODE__MEMBER;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VTYPE__TARGET = COMPOUND_NODE__TARGET;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VTYPE__NAME = COMPOUND_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VTYPE__NOTE = COMPOUND_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>VType</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VTYPE_FEATURE_COUNT = COMPOUND_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>VType</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VTYPE_OPERATION_COUNT = COMPOUND_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.VClassOccurrenceImpl <em>VClass Occurrence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.VClassOccurrenceImpl
	 * @see bvr.impl.BvrPackageImpl#getVClassOccurrence()
	 * @generated
	 */
	int VCLASS_OCCURRENCE = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASS_OCCURRENCE__NAME = VSPEC__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASS_OCCURRENCE__NOTE = VSPEC__NOTE;

	/**
	 * The feature id for the '<em><b>Resolution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASS_OCCURRENCE__RESOLUTION_TIME = VSPEC__RESOLUTION_TIME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASS_OCCURRENCE__TARGET = VSPEC__TARGET;

	/**
	 * The feature id for the '<em><b>Group Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASS_OCCURRENCE__GROUP_MULTIPLICITY = VSPEC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASS_OCCURRENCE__OWNED_CONSTRAINT = VSPEC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASS_OCCURRENCE__VARIABLE = VSPEC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>VType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASS_OCCURRENCE__VTYPE = VSPEC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Instance Multiplicity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASS_OCCURRENCE__INSTANCE_MULTIPLICITY = VSPEC_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>VClass Occurrence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASS_OCCURRENCE_FEATURE_COUNT = VSPEC_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>VClass Occurrence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASS_OCCURRENCE_OPERATION_COUNT = VSPEC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.VariationPointImpl <em>Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.VariationPointImpl
	 * @see bvr.impl.BvrPackageImpl#getVariationPoint()
	 * @generated
	 */
	int VARIATION_POINT = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__NOTE = NAMED_ELEMENT__NOTE;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__BINDING_VSPEC = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Staged Variation Point</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__STAGED_VARIATION_POINT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.StagedVariationPointImpl <em>Staged Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.StagedVariationPointImpl
	 * @see bvr.impl.BvrPackageImpl#getStagedVariationPoint()
	 * @generated
	 */
	int STAGED_VARIATION_POINT = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGED_VARIATION_POINT__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGED_VARIATION_POINT__NOTE = VARIATION_POINT__NOTE;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGED_VARIATION_POINT__BINDING_VSPEC = VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Staged Variation Point</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGED_VARIATION_POINT__STAGED_VARIATION_POINT = VARIATION_POINT__STAGED_VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Binding Staged VP</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGED_VARIATION_POINT__BINDING_STAGED_VP = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGED_VARIATION_POINT__MEMBER = VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Staged Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGED_VARIATION_POINT_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Staged Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGED_VARIATION_POINT_OPERATION_COUNT = VARIATION_POINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ChoiceVariationPointImpl <em>Choice Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ChoiceVariationPointImpl
	 * @see bvr.impl.BvrPackageImpl#getChoiceVariationPoint()
	 * @generated
	 */
	int CHOICE_VARIATION_POINT = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_VARIATION_POINT__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_VARIATION_POINT__NOTE = VARIATION_POINT__NOTE;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_VARIATION_POINT__BINDING_VSPEC = VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Staged Variation Point</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_VARIATION_POINT__STAGED_VARIATION_POINT = VARIATION_POINT__STAGED_VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Binding Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_VARIATION_POINT__BINDING_CHOICE = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binding Choice Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_VARIATION_POINT__BINDING_CHOICE_OCC = VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolution kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_VARIATION_POINT__RESOLUTION_KIND = VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Choice Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_VARIATION_POINT_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Choice Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_VARIATION_POINT_OPERATION_COUNT = VARIATION_POINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.FragmentSubstitutionImpl <em>Fragment Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.FragmentSubstitutionImpl
	 * @see bvr.impl.BvrPackageImpl#getFragmentSubstitution()
	 * @generated
	 */
	int FRAGMENT_SUBSTITUTION = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__NAME = CHOICE_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__NOTE = CHOICE_VARIATION_POINT__NOTE;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__BINDING_VSPEC = CHOICE_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Staged Variation Point</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__STAGED_VARIATION_POINT = CHOICE_VARIATION_POINT__STAGED_VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Binding Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__BINDING_CHOICE = CHOICE_VARIATION_POINT__BINDING_CHOICE;

	/**
	 * The feature id for the '<em><b>Binding Choice Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__BINDING_CHOICE_OCC = CHOICE_VARIATION_POINT__BINDING_CHOICE_OCC;

	/**
	 * The feature id for the '<em><b>Resolution kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__RESOLUTION_KIND = CHOICE_VARIATION_POINT__RESOLUTION_KIND;

	/**
	 * The feature id for the '<em><b>Binding Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__BINDING_CLASSIFIER = CHOICE_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binding VClass Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__BINDING_VCLASS_OCC = CHOICE_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Boundary Element Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING = CHOICE_VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__PLACEMENT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Multi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__MULTI = CHOICE_VARIATION_POINT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__REPLACEMENT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Fragment Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION_FEATURE_COUNT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Fragment Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION_OPERATION_COUNT = CHOICE_VARIATION_POINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.RepeatableVariationPointImpl <em>Repeatable Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.RepeatableVariationPointImpl
	 * @see bvr.impl.BvrPackageImpl#getRepeatableVariationPoint()
	 * @generated
	 */
	int REPEATABLE_VARIATION_POINT = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEATABLE_VARIATION_POINT__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEATABLE_VARIATION_POINT__NOTE = VARIATION_POINT__NOTE;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEATABLE_VARIATION_POINT__BINDING_VSPEC = VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Staged Variation Point</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEATABLE_VARIATION_POINT__STAGED_VARIATION_POINT = VARIATION_POINT__STAGED_VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Binding Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEATABLE_VARIATION_POINT__BINDING_CLASSIFIER = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binding VClass Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEATABLE_VARIATION_POINT__BINDING_VCLASS_OCC = VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Repeatable Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEATABLE_VARIATION_POINT_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Repeatable Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEATABLE_VARIATION_POINT_OPERATION_COUNT = VARIATION_POINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.BoundaryElementBindingImpl <em>Boundary Element Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.BoundaryElementBindingImpl
	 * @see bvr.impl.BvrPackageImpl#getBoundaryElementBinding()
	 * @generated
	 */
	int BOUNDARY_ELEMENT_BINDING = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_ELEMENT_BINDING__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_ELEMENT_BINDING__NOTE = NAMED_ELEMENT__NOTE;

	/**
	 * The number of structural features of the '<em>Boundary Element Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boundary Element Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_ELEMENT_BINDING_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.PlacementFragmentImpl <em>Placement Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.PlacementFragmentImpl
	 * @see bvr.impl.BvrPackageImpl#getPlacementFragment()
	 * @generated
	 */
	int PLACEMENT_FRAGMENT = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT__NOTE = VARIATION_POINT__NOTE;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT__BINDING_VSPEC = VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Staged Variation Point</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT__STAGED_VARIATION_POINT = VARIATION_POINT__STAGED_VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Placement Boundary Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT__SOURCE_OBJECT = VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Placement Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Placement Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT_OPERATION_COUNT = VARIATION_POINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.PlacementBoundaryElementImpl <em>Placement Boundary Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.PlacementBoundaryElementImpl
	 * @see bvr.impl.BvrPackageImpl#getPlacementBoundaryElement()
	 * @generated
	 */
	int PLACEMENT_BOUNDARY_ELEMENT = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_BOUNDARY_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_BOUNDARY_ELEMENT__NOTE = NAMED_ELEMENT__NOTE;

	/**
	 * The number of structural features of the '<em>Placement Boundary Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Placement Boundary Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_BOUNDARY_ELEMENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ObjectHandleImpl <em>Object Handle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ObjectHandleImpl
	 * @see bvr.impl.BvrPackageImpl#getObjectHandle()
	 * @generated
	 */
	int OBJECT_HANDLE = 27;

	/**
	 * The feature id for the '<em><b>MOF Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_HANDLE__MOF_REF = 0;

	/**
	 * The number of structural features of the '<em>Object Handle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_HANDLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Object Handle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_HANDLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ReplacementFragmentTypeImpl <em>Replacement Fragment Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ReplacementFragmentTypeImpl
	 * @see bvr.impl.BvrPackageImpl#getReplacementFragmentType()
	 * @generated
	 */
	int REPLACEMENT_FRAGMENT_TYPE = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_TYPE__NAME = VARIABLETYPE__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_TYPE__NOTE = VARIABLETYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Replacement Boundary Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT = VARIABLETYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Placement Fragment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT = VARIABLETYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT = VARIABLETYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Replacement Fragment Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_TYPE_FEATURE_COUNT = VARIABLETYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Replacement Fragment Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_TYPE_OPERATION_COUNT = VARIABLETYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ReplacementBoundaryElementImpl <em>Replacement Boundary Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ReplacementBoundaryElementImpl
	 * @see bvr.impl.BvrPackageImpl#getReplacementBoundaryElement()
	 * @generated
	 */
	int REPLACEMENT_BOUNDARY_ELEMENT = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_BOUNDARY_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_BOUNDARY_ELEMENT__NOTE = NAMED_ELEMENT__NOTE;

	/**
	 * The number of structural features of the '<em>Replacement Boundary Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Replacement Boundary Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_BOUNDARY_ELEMENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ValueResolutionImpl <em>Value Resolution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ValueResolutionImpl
	 * @see bvr.impl.BvrPackageImpl#getValueResolution()
	 * @generated
	 */
	int VALUE_RESOLUTION = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RESOLUTION__NAME = VSPEC_RESOLUTION__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RESOLUTION__NOTE = VSPEC_RESOLUTION__NOTE;

	/**
	 * The feature id for the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RESOLUTION__RESOLVED_VSPEC = VSPEC_RESOLUTION__RESOLVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Resolved Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RESOLUTION__RESOLVED_VARIABLE = VSPEC_RESOLUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RESOLUTION__VALUE = VSPEC_RESOLUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Value Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RESOLUTION_FEATURE_COUNT = VSPEC_RESOLUTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Value Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RESOLUTION_OPERATION_COUNT = VSPEC_RESOLUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.PrimitveTypeImpl <em>Primitve Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.PrimitveTypeImpl
	 * @see bvr.impl.BvrPackageImpl#getPrimitveType()
	 * @generated
	 */
	int PRIMITVE_TYPE = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITVE_TYPE__NAME = VARIABLETYPE__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITVE_TYPE__NOTE = VARIABLETYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITVE_TYPE__TYPE = VARIABLETYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitve Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITVE_TYPE_FEATURE_COUNT = VARIABLETYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Primitve Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITVE_TYPE_OPERATION_COUNT = VARIABLETYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ObjectTypeImpl <em>Object Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ObjectTypeImpl
	 * @see bvr.impl.BvrPackageImpl#getObjectType()
	 * @generated
	 */
	int OBJECT_TYPE = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__NAME = VARIABLETYPE__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__NOTE = VARIABLETYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Meta Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__META_CLASS = VARIABLETYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE_FEATURE_COUNT = VARIABLETYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Object Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE_OPERATION_COUNT = VARIABLETYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.SlotAssignmentImpl <em>Slot Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.SlotAssignmentImpl
	 * @see bvr.impl.BvrPackageImpl#getSlotAssignment()
	 * @generated
	 */
	int SLOT_ASSIGNMENT = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT__NAME = CHOICE_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT__NOTE = CHOICE_VARIATION_POINT__NOTE;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT__BINDING_VSPEC = CHOICE_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Staged Variation Point</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT__STAGED_VARIATION_POINT = CHOICE_VARIATION_POINT__STAGED_VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Binding Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT__BINDING_CHOICE = CHOICE_VARIATION_POINT__BINDING_CHOICE;

	/**
	 * The feature id for the '<em><b>Binding Choice Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT__BINDING_CHOICE_OCC = CHOICE_VARIATION_POINT__BINDING_CHOICE_OCC;

	/**
	 * The feature id for the '<em><b>Resolution kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT__RESOLUTION_KIND = CHOICE_VARIATION_POINT__RESOLUTION_KIND;

	/**
	 * The feature id for the '<em><b>Slot Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT__SLOT_IDENTIFIER = CHOICE_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT__VALUE = CHOICE_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Slot Owner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT__SLOT_OWNER = CHOICE_VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Slot Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT_FEATURE_COUNT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Slot Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT_OPERATION_COUNT = CHOICE_VARIATION_POINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.OpaqueVariationPointImpl <em>Opaque Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.OpaqueVariationPointImpl
	 * @see bvr.impl.BvrPackageImpl#getOpaqueVariationPoint()
	 * @generated
	 */
	int OPAQUE_VARIATION_POINT = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT__NOTE = VARIATION_POINT__NOTE;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT__BINDING_VSPEC = VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Staged Variation Point</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT__STAGED_VARIATION_POINT = VARIATION_POINT__STAGED_VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Place Holder</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT__PLACE_HOLDER = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT__TYPE = VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Opaque Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Opaque Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT_OPERATION_COUNT = VARIATION_POINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.OVPTypeImpl <em>OVP Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.OVPTypeImpl
	 * @see bvr.impl.BvrPackageImpl#getOVPType()
	 * @generated
	 */
	int OVP_TYPE = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVP_TYPE__NAME = VPACKAGEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVP_TYPE__NOTE = VPACKAGEABLE__NOTE;

	/**
	 * The feature id for the '<em><b>Spec</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVP_TYPE__SPEC = VPACKAGEABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OVP Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVP_TYPE_FEATURE_COUNT = VPACKAGEABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>OVP Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVP_TYPE_OPERATION_COUNT = VPACKAGEABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.OVPSemanticSpecImpl <em>OVP Semantic Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.OVPSemanticSpecImpl
	 * @see bvr.impl.BvrPackageImpl#getOVPSemanticSpec()
	 * @generated
	 */
	int OVP_SEMANTIC_SPEC = 36;

	/**
	 * The feature id for the '<em><b>Model Transformation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVP_SEMANTIC_SPEC__MODEL_TRANSFORMATION = 0;

	/**
	 * The feature id for the '<em><b>Transfromation Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVP_SEMANTIC_SPEC__TRANSFROMATION_LANGUAGE = 1;

	/**
	 * The number of structural features of the '<em>OVP Semantic Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVP_SEMANTIC_SPEC_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>OVP Semantic Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVP_SEMANTIC_SPEC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ObjectSpecificationImpl <em>Object Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ObjectSpecificationImpl
	 * @see bvr.impl.BvrPackageImpl#getObjectSpecification()
	 * @generated
	 */
	int OBJECT_SPECIFICATION = 37;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_SPECIFICATION__TYPE = VALUE_SPECIFICATION__TYPE;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_SPECIFICATION__OBJECT = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_SPECIFICATION_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Object Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_SPECIFICATION_OPERATION_COUNT = VALUE_SPECIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ReplacementFragmentSpecificationImpl <em>Replacement Fragment Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ReplacementFragmentSpecificationImpl
	 * @see bvr.impl.BvrPackageImpl#getReplacementFragmentSpecification()
	 * @generated
	 */
	int REPLACEMENT_FRAGMENT_SPECIFICATION = 38;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_SPECIFICATION__TYPE = VALUE_SPECIFICATION__TYPE;

	/**
	 * The number of structural features of the '<em>Replacement Fragment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_SPECIFICATION_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Replacement Fragment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_SPECIFICATION_OPERATION_COUNT = VALUE_SPECIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.VPackageImpl <em>VPackage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.VPackageImpl
	 * @see bvr.impl.BvrPackageImpl#getVPackage()
	 * @generated
	 */
	int VPACKAGE = 39;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPACKAGE__NAME = VPACKAGEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPACKAGE__NOTE = VPACKAGEABLE__NOTE;

	/**
	 * The feature id for the '<em><b>Package Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPACKAGE__PACKAGE_ELEMENT = VPACKAGEABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VPackage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPACKAGE_FEATURE_COUNT = VPACKAGEABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>VPackage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPACKAGE_OPERATION_COUNT = VPACKAGEABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ToBindingImpl <em>To Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ToBindingImpl
	 * @see bvr.impl.BvrPackageImpl#getToBinding()
	 * @generated
	 */
	int TO_BINDING = 40;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_BINDING__NAME = BOUNDARY_ELEMENT_BINDING__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_BINDING__NOTE = BOUNDARY_ELEMENT_BINDING__NOTE;

	/**
	 * The feature id for the '<em><b>To Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_BINDING__TO_PLACEMENT = BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_BINDING__TO_REPLACEMENT = BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>To Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_BINDING_FEATURE_COUNT = BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>To Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_BINDING_OPERATION_COUNT = BOUNDARY_ELEMENT_BINDING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ToPlacementImpl <em>To Placement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ToPlacementImpl
	 * @see bvr.impl.BvrPackageImpl#getToPlacement()
	 * @generated
	 */
	int TO_PLACEMENT = 41;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT__NAME = PLACEMENT_BOUNDARY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT__NOTE = PLACEMENT_BOUNDARY_ELEMENT__NOTE;

	/**
	 * The feature id for the '<em><b>To Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT__TO_REPLACEMENT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT__PROPERTY_NAME = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inside Boundary Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Outside Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>To Placement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT_FEATURE_COUNT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>To Placement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT_OPERATION_COUNT = PLACEMENT_BOUNDARY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ToReplacementImpl <em>To Replacement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ToReplacementImpl
	 * @see bvr.impl.BvrPackageImpl#getToReplacement()
	 * @generated
	 */
	int TO_REPLACEMENT = 42;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_REPLACEMENT__NAME = REPLACEMENT_BOUNDARY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_REPLACEMENT__NOTE = REPLACEMENT_BOUNDARY_ELEMENT__NOTE;

	/**
	 * The feature id for the '<em><b>Inside Boundary Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outside Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_REPLACEMENT__TO_PLACEMENT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>To Replacement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_REPLACEMENT_FEATURE_COUNT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>To Replacement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_REPLACEMENT_OPERATION_COUNT = REPLACEMENT_BOUNDARY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.FromBindingImpl <em>From Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.FromBindingImpl
	 * @see bvr.impl.BvrPackageImpl#getFromBinding()
	 * @generated
	 */
	int FROM_BINDING = 43;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_BINDING__NAME = BOUNDARY_ELEMENT_BINDING__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_BINDING__NOTE = BOUNDARY_ELEMENT_BINDING__NOTE;

	/**
	 * The feature id for the '<em><b>From Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_BINDING__FROM_PLACEMENT = BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_BINDING__FROM_REPLACEMENT = BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>From Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_BINDING_FEATURE_COUNT = BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>From Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_BINDING_OPERATION_COUNT = BOUNDARY_ELEMENT_BINDING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.FromPlacementImpl <em>From Placement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.FromPlacementImpl
	 * @see bvr.impl.BvrPackageImpl#getFromPlacement()
	 * @generated
	 */
	int FROM_PLACEMENT = 44;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_PLACEMENT__NAME = PLACEMENT_BOUNDARY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_PLACEMENT__NOTE = PLACEMENT_BOUNDARY_ELEMENT__NOTE;

	/**
	 * The feature id for the '<em><b>From Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_PLACEMENT__FROM_REPLACEMENT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outside Boundary Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inside Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_PLACEMENT__INSIDE_BOUNDARY_ELEMENT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>From Placement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_PLACEMENT_FEATURE_COUNT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>From Placement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_PLACEMENT_OPERATION_COUNT = PLACEMENT_BOUNDARY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.FromReplacementImpl <em>From Replacement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.FromReplacementImpl
	 * @see bvr.impl.BvrPackageImpl#getFromReplacement()
	 * @generated
	 */
	int FROM_REPLACEMENT = 45;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT__NAME = REPLACEMENT_BOUNDARY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT__NOTE = REPLACEMENT_BOUNDARY_ELEMENT__NOTE;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT__PROPERTY_NAME = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inside Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outside Boundary Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>From Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT__FROM_PLACEMENT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>From Replacement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT_FEATURE_COUNT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>From Replacement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT_OPERATION_COUNT = REPLACEMENT_BOUNDARY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.BCLExpressionImpl <em>BCL Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.BCLExpressionImpl
	 * @see bvr.impl.BvrPackageImpl#getBCLExpression()
	 * @generated
	 */
	int BCL_EXPRESSION = 47;

	/**
	 * The number of structural features of the '<em>BCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCL_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>BCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCL_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link bvr.impl.TargetRefImpl <em>Target Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.TargetRefImpl
	 * @see bvr.impl.BvrPackageImpl#getTargetRef()
	 * @generated
	 */
	int TARGET_REF = 46;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_REF__TARGET = BCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Target Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_REF_FEATURE_COUNT = BCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Target Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_REF_OPERATION_COUNT = BCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.OpaqueConstraintImpl <em>Opaque Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.OpaqueConstraintImpl
	 * @see bvr.impl.BvrPackageImpl#getOpaqueConstraint()
	 * @generated
	 */
	int OPAQUE_CONSTRAINT = 48;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_CONSTRAINT__NOTE = CONSTRAINT__NOTE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_CONSTRAINT__CONSTRAINT = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_CONSTRAINT__CONSTRAINT_LANGUAGE = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Opaque Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Opaque Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_CONSTRAINT_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ParametricVariationPointImpl <em>Parametric Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ParametricVariationPointImpl
	 * @see bvr.impl.BvrPackageImpl#getParametricVariationPoint()
	 * @generated
	 */
	int PARAMETRIC_VARIATION_POINT = 49;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_VARIATION_POINT__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_VARIATION_POINT__NOTE = VARIATION_POINT__NOTE;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_VARIATION_POINT__BINDING_VSPEC = VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Staged Variation Point</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_VARIATION_POINT__STAGED_VARIATION_POINT = VARIATION_POINT__STAGED_VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Binding Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parametric Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_VARIATION_POINT_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parametric Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_VARIATION_POINT_OPERATION_COUNT = VARIATION_POINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ParametricSlotAssignmentImpl <em>Parametric Slot Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ParametricSlotAssignmentImpl
	 * @see bvr.impl.BvrPackageImpl#getParametricSlotAssignment()
	 * @generated
	 */
	int PARAMETRIC_SLOT_ASSIGNMENT = 50;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMENT__NAME = PARAMETRIC_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMENT__NOTE = PARAMETRIC_VARIATION_POINT__NOTE;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMENT__BINDING_VSPEC = PARAMETRIC_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Staged Variation Point</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMENT__STAGED_VARIATION_POINT = PARAMETRIC_VARIATION_POINT__STAGED_VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Binding Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMENT__BINDING_VARIABLE = PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE;

	/**
	 * The feature id for the '<em><b>Slot Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMENT__SLOT_IDENTIFIER = PARAMETRIC_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Slot Owner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMENT__SLOT_OWNER = PARAMETRIC_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parametric Slot Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMENT_FEATURE_COUNT = PARAMETRIC_VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Parametric Slot Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMENT_OPERATION_COUNT = PARAMETRIC_VARIATION_POINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.PrimitiveValueSpecificationImpl <em>Primitive Value Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.PrimitiveValueSpecificationImpl
	 * @see bvr.impl.BvrPackageImpl#getPrimitiveValueSpecification()
	 * @generated
	 */
	int PRIMITIVE_VALUE_SPECIFICATION = 51;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE_SPECIFICATION__TYPE = VALUE_SPECIFICATION__TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE_SPECIFICATION__EXPRESSION = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE_SPECIFICATION_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Primitive Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE_SPECIFICATION_OPERATION_COUNT = VALUE_SPECIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.BCLConstraintImpl <em>BCL Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.BCLConstraintImpl
	 * @see bvr.impl.BvrPackageImpl#getBCLConstraint()
	 * @generated
	 */
	int BCL_CONSTRAINT = 52;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCL_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCL_CONSTRAINT__NOTE = CONSTRAINT__NOTE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCL_CONSTRAINT__EXPRESSION = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BCL Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCL_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>BCL Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCL_CONSTRAINT_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.OperationCallExpImpl
	 * @see bvr.impl.BvrPackageImpl#getOperationCallExp()
	 * @generated
	 */
	int OPERATION_CALL_EXP = 53;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__ARGUMENT = BCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__OPERATION = BCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_FEATURE_COUNT = BCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_OPERATION_COUNT = BCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.BooleanLiteralExpImpl
	 * @see bvr.impl.BvrPackageImpl#getBooleanLiteralExp()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP = 54;

	/**
	 * The feature id for the '<em><b>Bool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__BOOL = BCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_FEATURE_COUNT = BCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_OPERATION_COUNT = BCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.StringLiteralExpImpl
	 * @see bvr.impl.BvrPackageImpl#getStringLiteralExp()
	 * @generated
	 */
	int STRING_LITERAL_EXP = 55;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__STRING = BCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_FEATURE_COUNT = BCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_OPERATION_COUNT = BCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.NumericLiteralExpImpl
	 * @see bvr.impl.BvrPackageImpl#getNumericLiteralExp()
	 * @generated
	 */
	int NUMERIC_LITERAL_EXP = 56;

	/**
	 * The number of structural features of the '<em>Numeric Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP_FEATURE_COUNT = BCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Numeric Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP_OPERATION_COUNT = BCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.IntegerLiteralExpImpl
	 * @see bvr.impl.BvrPackageImpl#getIntegerLiteralExp()
	 * @generated
	 */
	int INTEGER_LITERAL_EXP = 57;

	/**
	 * The feature id for the '<em><b>Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__INTEGER = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Integer Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_OPERATION_COUNT = NUMERIC_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.UnlimitedLiteralExpImpl <em>Unlimited Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.UnlimitedLiteralExpImpl
	 * @see bvr.impl.BvrPackageImpl#getUnlimitedLiteralExp()
	 * @generated
	 */
	int UNLIMITED_LITERAL_EXP = 58;

	/**
	 * The feature id for the '<em><b>Unlimited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_LITERAL_EXP__UNLIMITED = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unlimited Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unlimited Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_LITERAL_EXP_OPERATION_COUNT = NUMERIC_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.RealLiteralExpImpl
	 * @see bvr.impl.BvrPackageImpl#getRealLiteralExp()
	 * @generated
	 */
	int REAL_LITERAL_EXP = 59;

	/**
	 * The feature id for the '<em><b>Real</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__REAL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Real Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_OPERATION_COUNT = NUMERIC_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.CompoundResolutionImpl <em>Compound Resolution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.CompoundResolutionImpl
	 * @see bvr.impl.BvrPackageImpl#getCompoundResolution()
	 * @generated
	 */
	int COMPOUND_RESOLUTION = 60;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_RESOLUTION__NAME = CHOICE_RESOLUTION__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_RESOLUTION__NOTE = CHOICE_RESOLUTION__NOTE;

	/**
	 * The feature id for the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_RESOLUTION__RESOLVED_VSPEC = CHOICE_RESOLUTION__RESOLVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Resolved Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_RESOLUTION__RESOLVED_CHOICE = CHOICE_RESOLUTION__RESOLVED_CHOICE;

	/**
	 * The feature id for the '<em><b>Resolved Choice Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_RESOLUTION__RESOLVED_CHOICE_OCC = CHOICE_RESOLUTION__RESOLVED_CHOICE_OCC;

	/**
	 * The feature id for the '<em><b>Resolved VClass Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_RESOLUTION__RESOLVED_VCLASS_OCC = CHOICE_RESOLUTION__RESOLVED_VCLASS_OCC;

	/**
	 * The feature id for the '<em><b>Resolved VClassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_RESOLUTION__RESOLVED_VCLASSIFIER = CHOICE_RESOLUTION__RESOLVED_VCLASSIFIER;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_RESOLUTION__MEMBERS = CHOICE_RESOLUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compound Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_RESOLUTION_FEATURE_COUNT = CHOICE_RESOLUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Compound Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_RESOLUTION_OPERATION_COUNT = CHOICE_RESOLUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.NegResolutionImpl <em>Neg Resolution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.NegResolutionImpl
	 * @see bvr.impl.BvrPackageImpl#getNegResolution()
	 * @generated
	 */
	int NEG_RESOLUTION = 61;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG_RESOLUTION__NAME = CHOICE_RESOLUTION__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG_RESOLUTION__NOTE = CHOICE_RESOLUTION__NOTE;

	/**
	 * The feature id for the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG_RESOLUTION__RESOLVED_VSPEC = CHOICE_RESOLUTION__RESOLVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Resolved Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG_RESOLUTION__RESOLVED_CHOICE = CHOICE_RESOLUTION__RESOLVED_CHOICE;

	/**
	 * The feature id for the '<em><b>Resolved Choice Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG_RESOLUTION__RESOLVED_CHOICE_OCC = CHOICE_RESOLUTION__RESOLVED_CHOICE_OCC;

	/**
	 * The feature id for the '<em><b>Resolved VClass Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG_RESOLUTION__RESOLVED_VCLASS_OCC = CHOICE_RESOLUTION__RESOLVED_VCLASS_OCC;

	/**
	 * The feature id for the '<em><b>Resolved VClassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG_RESOLUTION__RESOLVED_VCLASSIFIER = CHOICE_RESOLUTION__RESOLVED_VCLASSIFIER;

	/**
	 * The number of structural features of the '<em>Neg Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG_RESOLUTION_FEATURE_COUNT = CHOICE_RESOLUTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Neg Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG_RESOLUTION_OPERATION_COUNT = CHOICE_RESOLUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.PosResolutionImpl <em>Pos Resolution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.PosResolutionImpl
	 * @see bvr.impl.BvrPackageImpl#getPosResolution()
	 * @generated
	 */
	int POS_RESOLUTION = 62;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_RESOLUTION__NAME = COMPOUND_RESOLUTION__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_RESOLUTION__NOTE = COMPOUND_RESOLUTION__NOTE;

	/**
	 * The feature id for the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_RESOLUTION__RESOLVED_VSPEC = COMPOUND_RESOLUTION__RESOLVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Resolved Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_RESOLUTION__RESOLVED_CHOICE = COMPOUND_RESOLUTION__RESOLVED_CHOICE;

	/**
	 * The feature id for the '<em><b>Resolved Choice Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_RESOLUTION__RESOLVED_CHOICE_OCC = COMPOUND_RESOLUTION__RESOLVED_CHOICE_OCC;

	/**
	 * The feature id for the '<em><b>Resolved VClass Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_RESOLUTION__RESOLVED_VCLASS_OCC = COMPOUND_RESOLUTION__RESOLVED_VCLASS_OCC;

	/**
	 * The feature id for the '<em><b>Resolved VClassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_RESOLUTION__RESOLVED_VCLASSIFIER = COMPOUND_RESOLUTION__RESOLVED_VCLASSIFIER;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_RESOLUTION__MEMBERS = COMPOUND_RESOLUTION__MEMBERS;

	/**
	 * The number of structural features of the '<em>Pos Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_RESOLUTION_FEATURE_COUNT = COMPOUND_RESOLUTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pos Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_RESOLUTION_OPERATION_COUNT = COMPOUND_RESOLUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.VRefImpl <em>VRef</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.VRefImpl
	 * @see bvr.impl.BvrPackageImpl#getVRef()
	 * @generated
	 */
	int VREF = 63;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREF__NAME = VARIABLETYPE__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREF__NOTE = VARIABLETYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Ref VSpec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREF__REF_VSPEC = VARIABLETYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VRef</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREF_FEATURE_COUNT = VARIABLETYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>VRef</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREF_OPERATION_COUNT = VARIABLETYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.VRefValueSpecificationImpl <em>VRef Value Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.VRefValueSpecificationImpl
	 * @see bvr.impl.BvrPackageImpl#getVRefValueSpecification()
	 * @generated
	 */
	int VREF_VALUE_SPECIFICATION = 64;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREF_VALUE_SPECIFICATION__TYPE = VALUE_SPECIFICATION__TYPE;

	/**
	 * The feature id for the '<em><b>VSpec Resolution</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREF_VALUE_SPECIFICATION__VSPEC_RESOLUTION = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VRef Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREF_VALUE_SPECIFICATION_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>VRef Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREF_VALUE_SPECIFICATION_OPERATION_COUNT = VALUE_SPECIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ResolutionLiteralDefinitionImpl <em>Resolution Literal Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ResolutionLiteralDefinitionImpl
	 * @see bvr.impl.BvrPackageImpl#getResolutionLiteralDefinition()
	 * @generated
	 */
	int RESOLUTION_LITERAL_DEFINITION = 65;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_DEFINITION__NAME = COMPOUND_RESOLUTION__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_DEFINITION__NOTE = COMPOUND_RESOLUTION__NOTE;

	/**
	 * The feature id for the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_DEFINITION__RESOLVED_VSPEC = COMPOUND_RESOLUTION__RESOLVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Resolved Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_DEFINITION__RESOLVED_CHOICE = COMPOUND_RESOLUTION__RESOLVED_CHOICE;

	/**
	 * The feature id for the '<em><b>Resolved Choice Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_DEFINITION__RESOLVED_CHOICE_OCC = COMPOUND_RESOLUTION__RESOLVED_CHOICE_OCC;

	/**
	 * The feature id for the '<em><b>Resolved VClass Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_DEFINITION__RESOLVED_VCLASS_OCC = COMPOUND_RESOLUTION__RESOLVED_VCLASS_OCC;

	/**
	 * The feature id for the '<em><b>Resolved VClassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_DEFINITION__RESOLVED_VCLASSIFIER = COMPOUND_RESOLUTION__RESOLVED_VCLASSIFIER;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_DEFINITION__MEMBERS = COMPOUND_RESOLUTION__MEMBERS;

	/**
	 * The feature id for the '<em><b>Literal Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_DEFINITION__LITERAL_TYPE = COMPOUND_RESOLUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resolution Literal Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_DEFINITION_FEATURE_COUNT = COMPOUND_RESOLUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resolution Literal Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_DEFINITION_OPERATION_COUNT = COMPOUND_RESOLUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.ResolutionLiteralUseImpl <em>Resolution Literal Use</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.ResolutionLiteralUseImpl
	 * @see bvr.impl.BvrPackageImpl#getResolutionLiteralUse()
	 * @generated
	 */
	int RESOLUTION_LITERAL_USE = 66;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_USE__NAME = CHOICE_RESOLUTION__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_USE__NOTE = CHOICE_RESOLUTION__NOTE;

	/**
	 * The feature id for the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_USE__RESOLVED_VSPEC = CHOICE_RESOLUTION__RESOLVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Resolved Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_USE__RESOLVED_CHOICE = CHOICE_RESOLUTION__RESOLVED_CHOICE;

	/**
	 * The feature id for the '<em><b>Resolved Choice Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_USE__RESOLVED_CHOICE_OCC = CHOICE_RESOLUTION__RESOLVED_CHOICE_OCC;

	/**
	 * The feature id for the '<em><b>Resolved VClass Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_USE__RESOLVED_VCLASS_OCC = CHOICE_RESOLUTION__RESOLVED_VCLASS_OCC;

	/**
	 * The feature id for the '<em><b>Resolved VClassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_USE__RESOLVED_VCLASSIFIER = CHOICE_RESOLUTION__RESOLVED_VCLASSIFIER;

	/**
	 * The feature id for the '<em><b>Def Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_USE__DEF_LITERAL = CHOICE_RESOLUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resolution Literal Use</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_USE_FEATURE_COUNT = CHOICE_RESOLUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resolution Literal Use</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_LITERAL_USE_OPERATION_COUNT = CHOICE_RESOLUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.impl.BVRModelImpl <em>BVR Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.impl.BVRModelImpl
	 * @see bvr.impl.BvrPackageImpl#getBVRModel()
	 * @generated
	 */
	int BVR_MODEL = 67;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVR_MODEL__NAME = VPACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVR_MODEL__NOTE = VPACKAGE__NOTE;

	/**
	 * The feature id for the '<em><b>Package Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVR_MODEL__PACKAGE_ELEMENT = VPACKAGE__PACKAGE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Variability Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVR_MODEL__VARIABILITY_MODEL = VPACKAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resolution Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVR_MODEL__RESOLUTION_MODELS = VPACKAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Model Base</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVR_MODEL__BASE_MODEL_BASE = VPACKAGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Model Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVR_MODEL__BASE_MODEL_LIBRARIES = VPACKAGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Realization Model</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVR_MODEL__REALIZATION_MODEL = VPACKAGE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>BVR Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVR_MODEL_FEATURE_COUNT = VPACKAGE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>BVR Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVR_MODEL_OPERATION_COUNT = VPACKAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link bvr.PrimitiveTypeEnum <em>Primitive Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.PrimitiveTypeEnum
	 * @see bvr.impl.BvrPackageImpl#getPrimitiveTypeEnum()
	 * @generated
	 */
	int PRIMITIVE_TYPE_ENUM = 68;

	/**
	 * The meta object id for the '{@link bvr.Operation <em>Operation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see bvr.Operation
	 * @see bvr.impl.BvrPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 69;


	/**
	 * Returns the meta object for class '{@link bvr.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see bvr.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for the attribute '{@link bvr.Choice#isDefaultResolution <em>Default Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Resolution</em>'.
	 * @see bvr.Choice#isDefaultResolution()
	 * @see #getChoice()
	 * @generated
	 */
	EAttribute getChoice_DefaultResolution();

	/**
	 * Returns the meta object for the attribute '{@link bvr.Choice#isIsImpliedByParent <em>Is Implied By Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Implied By Parent</em>'.
	 * @see bvr.Choice#isIsImpliedByParent()
	 * @see #getChoice()
	 * @generated
	 */
	EAttribute getChoice_IsImpliedByParent();

	/**
	 * Returns the meta object for class '{@link bvr.VSpec <em>VSpec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VSpec</em>'.
	 * @see bvr.VSpec
	 * @generated
	 */
	EClass getVSpec();

	/**
	 * Returns the meta object for the attribute '{@link bvr.VSpec#getResolutionTime <em>Resolution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolution Time</em>'.
	 * @see bvr.VSpec#getResolutionTime()
	 * @see #getVSpec()
	 * @generated
	 */
	EAttribute getVSpec_ResolutionTime();

	/**
	 * Returns the meta object for the reference '{@link bvr.VSpec#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see bvr.VSpec#getTarget()
	 * @see #getVSpec()
	 * @generated
	 */
	EReference getVSpec_Target();

	/**
	 * Returns the meta object for class '{@link bvr.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see bvr.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link bvr.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see bvr.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.NamedElement#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Note</em>'.
	 * @see bvr.NamedElement#getNote()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Note();

	/**
	 * Returns the meta object for class '{@link bvr.Note <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Note</em>'.
	 * @see bvr.Note
	 * @generated
	 */
	EClass getNote();

	/**
	 * Returns the meta object for the attribute '{@link bvr.Note#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see bvr.Note#getKind()
	 * @see #getNote()
	 * @generated
	 */
	EAttribute getNote_Kind();

	/**
	 * Returns the meta object for the attribute '{@link bvr.Note#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expr</em>'.
	 * @see bvr.Note#getExpr()
	 * @see #getNote()
	 * @generated
	 */
	EAttribute getNote_Expr();

	/**
	 * Returns the meta object for class '{@link bvr.Target <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target</em>'.
	 * @see bvr.Target
	 * @generated
	 */
	EClass getTarget();

	/**
	 * Returns the meta object for class '{@link bvr.CompoundNode <em>Compound Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Node</em>'.
	 * @see bvr.CompoundNode
	 * @generated
	 */
	EClass getCompoundNode();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.CompoundNode#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Member</em>'.
	 * @see bvr.CompoundNode#getMember()
	 * @see #getCompoundNode()
	 * @generated
	 */
	EReference getCompoundNode_Member();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.CompoundNode#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target</em>'.
	 * @see bvr.CompoundNode#getTarget()
	 * @see #getCompoundNode()
	 * @generated
	 */
	EReference getCompoundNode_Target();

	/**
	 * Returns the meta object for class '{@link bvr.VNode <em>VNode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VNode</em>'.
	 * @see bvr.VNode
	 * @generated
	 */
	EClass getVNode();

	/**
	 * Returns the meta object for the containment reference '{@link bvr.VNode#getGroupMultiplicity <em>Group Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Group Multiplicity</em>'.
	 * @see bvr.VNode#getGroupMultiplicity()
	 * @see #getVNode()
	 * @generated
	 */
	EReference getVNode_GroupMultiplicity();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.VNode#getOwnedConstraint <em>Owned Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Constraint</em>'.
	 * @see bvr.VNode#getOwnedConstraint()
	 * @see #getVNode()
	 * @generated
	 */
	EReference getVNode_OwnedConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.VNode#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see bvr.VNode#getVariable()
	 * @see #getVNode()
	 * @generated
	 */
	EReference getVNode_Variable();

	/**
	 * Returns the meta object for class '{@link bvr.MultiplicityInterval <em>Multiplicity Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity Interval</em>'.
	 * @see bvr.MultiplicityInterval
	 * @generated
	 */
	EClass getMultiplicityInterval();

	/**
	 * Returns the meta object for the attribute '{@link bvr.MultiplicityInterval#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see bvr.MultiplicityInterval#getUpper()
	 * @see #getMultiplicityInterval()
	 * @generated
	 */
	EAttribute getMultiplicityInterval_Upper();

	/**
	 * Returns the meta object for the attribute '{@link bvr.MultiplicityInterval#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see bvr.MultiplicityInterval#getLower()
	 * @see #getMultiplicityInterval()
	 * @generated
	 */
	EAttribute getMultiplicityInterval_Lower();

	/**
	 * Returns the meta object for class '{@link bvr.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see bvr.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for class '{@link bvr.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see bvr.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the containment reference '{@link bvr.Variable#getDefaulValue <em>Defaul Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Defaul Value</em>'.
	 * @see bvr.Variable#getDefaulValue()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_DefaulValue();

	/**
	 * Returns the meta object for the reference '{@link bvr.Variable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see bvr.Variable#getType()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Type();

	/**
	 * Returns the meta object for class '{@link bvr.ValueSpecification <em>Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Specification</em>'.
	 * @see bvr.ValueSpecification
	 * @generated
	 */
	EClass getValueSpecification();

	/**
	 * Returns the meta object for the reference '{@link bvr.ValueSpecification#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see bvr.ValueSpecification#getType()
	 * @see #getValueSpecification()
	 * @generated
	 */
	EReference getValueSpecification_Type();

	/**
	 * Returns the meta object for class '{@link bvr.Variabletype <em>Variabletype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variabletype</em>'.
	 * @see bvr.Variabletype
	 * @generated
	 */
	EClass getVariabletype();

	/**
	 * Returns the meta object for class '{@link bvr.VPackageable <em>VPackageable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VPackageable</em>'.
	 * @see bvr.VPackageable
	 * @generated
	 */
	EClass getVPackageable();

	/**
	 * Returns the meta object for class '{@link bvr.VClassifier <em>VClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VClassifier</em>'.
	 * @see bvr.VClassifier
	 * @generated
	 */
	EClass getVClassifier();

	/**
	 * Returns the meta object for the containment reference '{@link bvr.VClassifier#getInstanceMultiplicity <em>Instance Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Instance Multiplicity</em>'.
	 * @see bvr.VClassifier#getInstanceMultiplicity()
	 * @see #getVClassifier()
	 * @generated
	 */
	EReference getVClassifier_InstanceMultiplicity();

	/**
	 * Returns the meta object for class '{@link bvr.VSpecResolution <em>VSpec Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VSpec Resolution</em>'.
	 * @see bvr.VSpecResolution
	 * @generated
	 */
	EClass getVSpecResolution();

	/**
	 * Returns the meta object for the reference '{@link bvr.VSpecResolution#getResolvedVSpec <em>Resolved VSpec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved VSpec</em>'.
	 * @see bvr.VSpecResolution#getResolvedVSpec()
	 * @see #getVSpecResolution()
	 * @generated
	 */
	EReference getVSpecResolution_ResolvedVSpec();

	/**
	 * Returns the meta object for class '{@link bvr.ChoiceResolution <em>Choice Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice Resolution</em>'.
	 * @see bvr.ChoiceResolution
	 * @generated
	 */
	EClass getChoiceResolution();

	/**
	 * Returns the meta object for the reference '{@link bvr.ChoiceResolution#getResolvedChoice <em>Resolved Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved Choice</em>'.
	 * @see bvr.ChoiceResolution#getResolvedChoice()
	 * @see #getChoiceResolution()
	 * @generated
	 */
	EReference getChoiceResolution_ResolvedChoice();

	/**
	 * Returns the meta object for the reference '{@link bvr.ChoiceResolution#getResolvedChoiceOcc <em>Resolved Choice Occ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved Choice Occ</em>'.
	 * @see bvr.ChoiceResolution#getResolvedChoiceOcc()
	 * @see #getChoiceResolution()
	 * @generated
	 */
	EReference getChoiceResolution_ResolvedChoiceOcc();

	/**
	 * Returns the meta object for the reference '{@link bvr.ChoiceResolution#getResolvedVClassOcc <em>Resolved VClass Occ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved VClass Occ</em>'.
	 * @see bvr.ChoiceResolution#getResolvedVClassOcc()
	 * @see #getChoiceResolution()
	 * @generated
	 */
	EReference getChoiceResolution_ResolvedVClassOcc();

	/**
	 * Returns the meta object for the reference '{@link bvr.ChoiceResolution#getResolvedVClassifier <em>Resolved VClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved VClassifier</em>'.
	 * @see bvr.ChoiceResolution#getResolvedVClassifier()
	 * @see #getChoiceResolution()
	 * @generated
	 */
	EReference getChoiceResolution_ResolvedVClassifier();

	/**
	 * Returns the meta object for class '{@link bvr.ChoiceOccurrence <em>Choice Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice Occurrence</em>'.
	 * @see bvr.ChoiceOccurrence
	 * @generated
	 */
	EClass getChoiceOccurrence();

	/**
	 * Returns the meta object for the reference '{@link bvr.ChoiceOccurrence#getVType <em>VType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>VType</em>'.
	 * @see bvr.ChoiceOccurrence#getVType()
	 * @see #getChoiceOccurrence()
	 * @generated
	 */
	EReference getChoiceOccurrence_VType();

	/**
	 * Returns the meta object for class '{@link bvr.VType <em>VType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VType</em>'.
	 * @see bvr.VType
	 * @generated
	 */
	EClass getVType();

	/**
	 * Returns the meta object for class '{@link bvr.VClassOccurrence <em>VClass Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VClass Occurrence</em>'.
	 * @see bvr.VClassOccurrence
	 * @generated
	 */
	EClass getVClassOccurrence();

	/**
	 * Returns the meta object for the reference '{@link bvr.VClassOccurrence#getVType <em>VType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>VType</em>'.
	 * @see bvr.VClassOccurrence#getVType()
	 * @see #getVClassOccurrence()
	 * @generated
	 */
	EReference getVClassOccurrence_VType();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.VClassOccurrence#getInstanceMultiplicity <em>Instance Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instance Multiplicity</em>'.
	 * @see bvr.VClassOccurrence#getInstanceMultiplicity()
	 * @see #getVClassOccurrence()
	 * @generated
	 */
	EReference getVClassOccurrence_InstanceMultiplicity();

	/**
	 * Returns the meta object for class '{@link bvr.VariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variation Point</em>'.
	 * @see bvr.VariationPoint
	 * @generated
	 */
	EClass getVariationPoint();

	/**
	 * Returns the meta object for the reference '{@link bvr.VariationPoint#getBindingVSpec <em>Binding VSpec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding VSpec</em>'.
	 * @see bvr.VariationPoint#getBindingVSpec()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_BindingVSpec();

	/**
	 * Returns the meta object for the container reference '{@link bvr.VariationPoint#getStagedVariationPoint <em>Staged Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Staged Variation Point</em>'.
	 * @see bvr.VariationPoint#getStagedVariationPoint()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_StagedVariationPoint();

	/**
	 * Returns the meta object for class '{@link bvr.StagedVariationPoint <em>Staged Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Staged Variation Point</em>'.
	 * @see bvr.StagedVariationPoint
	 * @generated
	 */
	EClass getStagedVariationPoint();

	/**
	 * Returns the meta object for the reference '{@link bvr.StagedVariationPoint#getBindingStagedVP <em>Binding Staged VP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding Staged VP</em>'.
	 * @see bvr.StagedVariationPoint#getBindingStagedVP()
	 * @see #getStagedVariationPoint()
	 * @generated
	 */
	EReference getStagedVariationPoint_BindingStagedVP();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.StagedVariationPoint#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Member</em>'.
	 * @see bvr.StagedVariationPoint#getMember()
	 * @see #getStagedVariationPoint()
	 * @generated
	 */
	EReference getStagedVariationPoint_Member();

	/**
	 * Returns the meta object for class '{@link bvr.FragmentSubstitution <em>Fragment Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment Substitution</em>'.
	 * @see bvr.FragmentSubstitution
	 * @generated
	 */
	EClass getFragmentSubstitution();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.FragmentSubstitution#getBoundaryElementBinding <em>Boundary Element Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Boundary Element Binding</em>'.
	 * @see bvr.FragmentSubstitution#getBoundaryElementBinding()
	 * @see #getFragmentSubstitution()
	 * @generated
	 */
	EReference getFragmentSubstitution_BoundaryElementBinding();

	/**
	 * Returns the meta object for the reference '{@link bvr.FragmentSubstitution#getPlacement <em>Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Placement</em>'.
	 * @see bvr.FragmentSubstitution#getPlacement()
	 * @see #getFragmentSubstitution()
	 * @generated
	 */
	EReference getFragmentSubstitution_Placement();

	/**
	 * Returns the meta object for the attribute '{@link bvr.FragmentSubstitution#isMulti <em>Multi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi</em>'.
	 * @see bvr.FragmentSubstitution#isMulti()
	 * @see #getFragmentSubstitution()
	 * @generated
	 */
	EAttribute getFragmentSubstitution_Multi();

	/**
	 * Returns the meta object for the reference '{@link bvr.FragmentSubstitution#getReplacement <em>Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Replacement</em>'.
	 * @see bvr.FragmentSubstitution#getReplacement()
	 * @see #getFragmentSubstitution()
	 * @generated
	 */
	EReference getFragmentSubstitution_Replacement();

	/**
	 * Returns the meta object for class '{@link bvr.ChoiceVariationPoint <em>Choice Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice Variation Point</em>'.
	 * @see bvr.ChoiceVariationPoint
	 * @generated
	 */
	EClass getChoiceVariationPoint();

	/**
	 * Returns the meta object for the reference '{@link bvr.ChoiceVariationPoint#getBindingChoice <em>Binding Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding Choice</em>'.
	 * @see bvr.ChoiceVariationPoint#getBindingChoice()
	 * @see #getChoiceVariationPoint()
	 * @generated
	 */
	EReference getChoiceVariationPoint_BindingChoice();

	/**
	 * Returns the meta object for the reference '{@link bvr.ChoiceVariationPoint#getBindingChoiceOcc <em>Binding Choice Occ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding Choice Occ</em>'.
	 * @see bvr.ChoiceVariationPoint#getBindingChoiceOcc()
	 * @see #getChoiceVariationPoint()
	 * @generated
	 */
	EReference getChoiceVariationPoint_BindingChoiceOcc();

	/**
	 * Returns the meta object for the attribute '{@link bvr.ChoiceVariationPoint#isResolution_kind <em>Resolution kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolution kind</em>'.
	 * @see bvr.ChoiceVariationPoint#isResolution_kind()
	 * @see #getChoiceVariationPoint()
	 * @generated
	 */
	EAttribute getChoiceVariationPoint_Resolution_kind();

	/**
	 * Returns the meta object for class '{@link bvr.RepeatableVariationPoint <em>Repeatable Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repeatable Variation Point</em>'.
	 * @see bvr.RepeatableVariationPoint
	 * @generated
	 */
	EClass getRepeatableVariationPoint();

	/**
	 * Returns the meta object for the reference '{@link bvr.RepeatableVariationPoint#getBindingClassifier <em>Binding Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding Classifier</em>'.
	 * @see bvr.RepeatableVariationPoint#getBindingClassifier()
	 * @see #getRepeatableVariationPoint()
	 * @generated
	 */
	EReference getRepeatableVariationPoint_BindingClassifier();

	/**
	 * Returns the meta object for the reference '{@link bvr.RepeatableVariationPoint#getBindingVClassOcc <em>Binding VClass Occ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding VClass Occ</em>'.
	 * @see bvr.RepeatableVariationPoint#getBindingVClassOcc()
	 * @see #getRepeatableVariationPoint()
	 * @generated
	 */
	EReference getRepeatableVariationPoint_BindingVClassOcc();

	/**
	 * Returns the meta object for class '{@link bvr.BoundaryElementBinding <em>Boundary Element Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boundary Element Binding</em>'.
	 * @see bvr.BoundaryElementBinding
	 * @generated
	 */
	EClass getBoundaryElementBinding();

	/**
	 * Returns the meta object for class '{@link bvr.PlacementFragment <em>Placement Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placement Fragment</em>'.
	 * @see bvr.PlacementFragment
	 * @generated
	 */
	EClass getPlacementFragment();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.PlacementFragment#getPlacementBoundaryElement <em>Placement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Placement Boundary Element</em>'.
	 * @see bvr.PlacementFragment#getPlacementBoundaryElement()
	 * @see #getPlacementFragment()
	 * @generated
	 */
	EReference getPlacementFragment_PlacementBoundaryElement();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.PlacementFragment#getSourceObject <em>Source Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Object</em>'.
	 * @see bvr.PlacementFragment#getSourceObject()
	 * @see #getPlacementFragment()
	 * @generated
	 */
	EReference getPlacementFragment_SourceObject();

	/**
	 * Returns the meta object for class '{@link bvr.PlacementBoundaryElement <em>Placement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placement Boundary Element</em>'.
	 * @see bvr.PlacementBoundaryElement
	 * @generated
	 */
	EClass getPlacementBoundaryElement();

	/**
	 * Returns the meta object for class '{@link bvr.ObjectHandle <em>Object Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Handle</em>'.
	 * @see bvr.ObjectHandle
	 * @generated
	 */
	EClass getObjectHandle();

	/**
	 * Returns the meta object for the attribute '{@link bvr.ObjectHandle#getMOFRef <em>MOF Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>MOF Ref</em>'.
	 * @see bvr.ObjectHandle#getMOFRef()
	 * @see #getObjectHandle()
	 * @generated
	 */
	EAttribute getObjectHandle_MOFRef();

	/**
	 * Returns the meta object for class '{@link bvr.ReplacementFragmentType <em>Replacement Fragment Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Fragment Type</em>'.
	 * @see bvr.ReplacementFragmentType
	 * @generated
	 */
	EClass getReplacementFragmentType();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.ReplacementFragmentType#getReplacementBoundaryElement <em>Replacement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Replacement Boundary Element</em>'.
	 * @see bvr.ReplacementFragmentType#getReplacementBoundaryElement()
	 * @see #getReplacementFragmentType()
	 * @generated
	 */
	EReference getReplacementFragmentType_ReplacementBoundaryElement();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.ReplacementFragmentType#getPlacementFragment <em>Placement Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Placement Fragment</em>'.
	 * @see bvr.ReplacementFragmentType#getPlacementFragment()
	 * @see #getReplacementFragmentType()
	 * @generated
	 */
	EReference getReplacementFragmentType_PlacementFragment();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.ReplacementFragmentType#getSourceObject <em>Source Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Object</em>'.
	 * @see bvr.ReplacementFragmentType#getSourceObject()
	 * @see #getReplacementFragmentType()
	 * @generated
	 */
	EReference getReplacementFragmentType_SourceObject();

	/**
	 * Returns the meta object for class '{@link bvr.ReplacementBoundaryElement <em>Replacement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Boundary Element</em>'.
	 * @see bvr.ReplacementBoundaryElement
	 * @generated
	 */
	EClass getReplacementBoundaryElement();

	/**
	 * Returns the meta object for class '{@link bvr.ValueResolution <em>Value Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Resolution</em>'.
	 * @see bvr.ValueResolution
	 * @generated
	 */
	EClass getValueResolution();

	/**
	 * Returns the meta object for the reference '{@link bvr.ValueResolution#getResolvedVariable <em>Resolved Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved Variable</em>'.
	 * @see bvr.ValueResolution#getResolvedVariable()
	 * @see #getValueResolution()
	 * @generated
	 */
	EReference getValueResolution_ResolvedVariable();

	/**
	 * Returns the meta object for the containment reference '{@link bvr.ValueResolution#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see bvr.ValueResolution#getValue()
	 * @see #getValueResolution()
	 * @generated
	 */
	EReference getValueResolution_Value();

	/**
	 * Returns the meta object for class '{@link bvr.PrimitveType <em>Primitve Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitve Type</em>'.
	 * @see bvr.PrimitveType
	 * @generated
	 */
	EClass getPrimitveType();

	/**
	 * Returns the meta object for the attribute '{@link bvr.PrimitveType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see bvr.PrimitveType#getType()
	 * @see #getPrimitveType()
	 * @generated
	 */
	EAttribute getPrimitveType_Type();

	/**
	 * Returns the meta object for class '{@link bvr.ObjectType <em>Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Type</em>'.
	 * @see bvr.ObjectType
	 * @generated
	 */
	EClass getObjectType();

	/**
	 * Returns the meta object for the attribute '{@link bvr.ObjectType#getMetaClass <em>Meta Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Class</em>'.
	 * @see bvr.ObjectType#getMetaClass()
	 * @see #getObjectType()
	 * @generated
	 */
	EAttribute getObjectType_MetaClass();

	/**
	 * Returns the meta object for class '{@link bvr.SlotAssignment <em>Slot Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slot Assignment</em>'.
	 * @see bvr.SlotAssignment
	 * @generated
	 */
	EClass getSlotAssignment();

	/**
	 * Returns the meta object for the attribute '{@link bvr.SlotAssignment#getSlotIdentifier <em>Slot Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slot Identifier</em>'.
	 * @see bvr.SlotAssignment#getSlotIdentifier()
	 * @see #getSlotAssignment()
	 * @generated
	 */
	EAttribute getSlotAssignment_SlotIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link bvr.SlotAssignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see bvr.SlotAssignment#getValue()
	 * @see #getSlotAssignment()
	 * @generated
	 */
	EReference getSlotAssignment_Value();

	/**
	 * Returns the meta object for the containment reference '{@link bvr.SlotAssignment#getSlotOwner <em>Slot Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Slot Owner</em>'.
	 * @see bvr.SlotAssignment#getSlotOwner()
	 * @see #getSlotAssignment()
	 * @generated
	 */
	EReference getSlotAssignment_SlotOwner();

	/**
	 * Returns the meta object for class '{@link bvr.OpaqueVariationPoint <em>Opaque Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opaque Variation Point</em>'.
	 * @see bvr.OpaqueVariationPoint
	 * @generated
	 */
	EClass getOpaqueVariationPoint();

	/**
	 * Returns the meta object for the containment reference '{@link bvr.OpaqueVariationPoint#getPlaceHolder <em>Place Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Place Holder</em>'.
	 * @see bvr.OpaqueVariationPoint#getPlaceHolder()
	 * @see #getOpaqueVariationPoint()
	 * @generated
	 */
	EReference getOpaqueVariationPoint_PlaceHolder();

	/**
	 * Returns the meta object for the reference '{@link bvr.OpaqueVariationPoint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see bvr.OpaqueVariationPoint#getType()
	 * @see #getOpaqueVariationPoint()
	 * @generated
	 */
	EReference getOpaqueVariationPoint_Type();

	/**
	 * Returns the meta object for class '{@link bvr.OVPType <em>OVP Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OVP Type</em>'.
	 * @see bvr.OVPType
	 * @generated
	 */
	EClass getOVPType();

	/**
	 * Returns the meta object for the containment reference '{@link bvr.OVPType#getSpec <em>Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Spec</em>'.
	 * @see bvr.OVPType#getSpec()
	 * @see #getOVPType()
	 * @generated
	 */
	EReference getOVPType_Spec();

	/**
	 * Returns the meta object for class '{@link bvr.OVPSemanticSpec <em>OVP Semantic Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OVP Semantic Spec</em>'.
	 * @see bvr.OVPSemanticSpec
	 * @generated
	 */
	EClass getOVPSemanticSpec();

	/**
	 * Returns the meta object for the attribute '{@link bvr.OVPSemanticSpec#getModelTransformation <em>Model Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Transformation</em>'.
	 * @see bvr.OVPSemanticSpec#getModelTransformation()
	 * @see #getOVPSemanticSpec()
	 * @generated
	 */
	EAttribute getOVPSemanticSpec_ModelTransformation();

	/**
	 * Returns the meta object for the attribute '{@link bvr.OVPSemanticSpec#getTransfromationLanguage <em>Transfromation Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transfromation Language</em>'.
	 * @see bvr.OVPSemanticSpec#getTransfromationLanguage()
	 * @see #getOVPSemanticSpec()
	 * @generated
	 */
	EAttribute getOVPSemanticSpec_TransfromationLanguage();

	/**
	 * Returns the meta object for class '{@link bvr.ObjectSpecification <em>Object Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Specification</em>'.
	 * @see bvr.ObjectSpecification
	 * @generated
	 */
	EClass getObjectSpecification();

	/**
	 * Returns the meta object for the reference '{@link bvr.ObjectSpecification#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see bvr.ObjectSpecification#getObject()
	 * @see #getObjectSpecification()
	 * @generated
	 */
	EReference getObjectSpecification_Object();

	/**
	 * Returns the meta object for class '{@link bvr.ReplacementFragmentSpecification <em>Replacement Fragment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Fragment Specification</em>'.
	 * @see bvr.ReplacementFragmentSpecification
	 * @generated
	 */
	EClass getReplacementFragmentSpecification();

	/**
	 * Returns the meta object for class '{@link bvr.VPackage <em>VPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VPackage</em>'.
	 * @see bvr.VPackage
	 * @generated
	 */
	EClass getVPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.VPackage#getPackageElement <em>Package Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Package Element</em>'.
	 * @see bvr.VPackage#getPackageElement()
	 * @see #getVPackage()
	 * @generated
	 */
	EReference getVPackage_PackageElement();

	/**
	 * Returns the meta object for class '{@link bvr.ToBinding <em>To Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Binding</em>'.
	 * @see bvr.ToBinding
	 * @generated
	 */
	EClass getToBinding();

	/**
	 * Returns the meta object for the reference '{@link bvr.ToBinding#getToPlacement <em>To Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Placement</em>'.
	 * @see bvr.ToBinding#getToPlacement()
	 * @see #getToBinding()
	 * @generated
	 */
	EReference getToBinding_ToPlacement();

	/**
	 * Returns the meta object for the reference '{@link bvr.ToBinding#getToReplacement <em>To Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Replacement</em>'.
	 * @see bvr.ToBinding#getToReplacement()
	 * @see #getToBinding()
	 * @generated
	 */
	EReference getToBinding_ToReplacement();

	/**
	 * Returns the meta object for class '{@link bvr.ToPlacement <em>To Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Placement</em>'.
	 * @see bvr.ToPlacement
	 * @generated
	 */
	EClass getToPlacement();

	/**
	 * Returns the meta object for the reference '{@link bvr.ToPlacement#getToReplacement <em>To Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Replacement</em>'.
	 * @see bvr.ToPlacement#getToReplacement()
	 * @see #getToPlacement()
	 * @generated
	 */
	EReference getToPlacement_ToReplacement();

	/**
	 * Returns the meta object for the attribute '{@link bvr.ToPlacement#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see bvr.ToPlacement#getPropertyName()
	 * @see #getToPlacement()
	 * @generated
	 */
	EAttribute getToPlacement_PropertyName();

	/**
	 * Returns the meta object for the reference list '{@link bvr.ToPlacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inside Boundary Element</em>'.
	 * @see bvr.ToPlacement#getInsideBoundaryElement()
	 * @see #getToPlacement()
	 * @generated
	 */
	EReference getToPlacement_InsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link bvr.ToPlacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outside Boundary Element</em>'.
	 * @see bvr.ToPlacement#getOutsideBoundaryElement()
	 * @see #getToPlacement()
	 * @generated
	 */
	EReference getToPlacement_OutsideBoundaryElement();

	/**
	 * Returns the meta object for class '{@link bvr.ToReplacement <em>To Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Replacement</em>'.
	 * @see bvr.ToReplacement
	 * @generated
	 */
	EClass getToReplacement();

	/**
	 * Returns the meta object for the reference list '{@link bvr.ToReplacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inside Boundary Element</em>'.
	 * @see bvr.ToReplacement#getInsideBoundaryElement()
	 * @see #getToReplacement()
	 * @generated
	 */
	EReference getToReplacement_InsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link bvr.ToReplacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outside Boundary Element</em>'.
	 * @see bvr.ToReplacement#getOutsideBoundaryElement()
	 * @see #getToReplacement()
	 * @generated
	 */
	EReference getToReplacement_OutsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link bvr.ToReplacement#getToPlacement <em>To Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Placement</em>'.
	 * @see bvr.ToReplacement#getToPlacement()
	 * @see #getToReplacement()
	 * @generated
	 */
	EReference getToReplacement_ToPlacement();

	/**
	 * Returns the meta object for class '{@link bvr.FromBinding <em>From Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Binding</em>'.
	 * @see bvr.FromBinding
	 * @generated
	 */
	EClass getFromBinding();

	/**
	 * Returns the meta object for the reference '{@link bvr.FromBinding#getFromPlacement <em>From Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Placement</em>'.
	 * @see bvr.FromBinding#getFromPlacement()
	 * @see #getFromBinding()
	 * @generated
	 */
	EReference getFromBinding_FromPlacement();

	/**
	 * Returns the meta object for the reference '{@link bvr.FromBinding#getFromReplacement <em>From Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Replacement</em>'.
	 * @see bvr.FromBinding#getFromReplacement()
	 * @see #getFromBinding()
	 * @generated
	 */
	EReference getFromBinding_FromReplacement();

	/**
	 * Returns the meta object for class '{@link bvr.FromPlacement <em>From Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Placement</em>'.
	 * @see bvr.FromPlacement
	 * @generated
	 */
	EClass getFromPlacement();

	/**
	 * Returns the meta object for the reference '{@link bvr.FromPlacement#getFromReplacement <em>From Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Replacement</em>'.
	 * @see bvr.FromPlacement#getFromReplacement()
	 * @see #getFromPlacement()
	 * @generated
	 */
	EReference getFromPlacement_FromReplacement();

	/**
	 * Returns the meta object for the reference list '{@link bvr.FromPlacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outside Boundary Element</em>'.
	 * @see bvr.FromPlacement#getOutsideBoundaryElement()
	 * @see #getFromPlacement()
	 * @generated
	 */
	EReference getFromPlacement_OutsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link bvr.FromPlacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inside Boundary Element</em>'.
	 * @see bvr.FromPlacement#getInsideBoundaryElement()
	 * @see #getFromPlacement()
	 * @generated
	 */
	EReference getFromPlacement_InsideBoundaryElement();

	/**
	 * Returns the meta object for class '{@link bvr.FromReplacement <em>From Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Replacement</em>'.
	 * @see bvr.FromReplacement
	 * @generated
	 */
	EClass getFromReplacement();

	/**
	 * Returns the meta object for the attribute '{@link bvr.FromReplacement#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see bvr.FromReplacement#getPropertyName()
	 * @see #getFromReplacement()
	 * @generated
	 */
	EAttribute getFromReplacement_PropertyName();

	/**
	 * Returns the meta object for the reference '{@link bvr.FromReplacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inside Boundary Element</em>'.
	 * @see bvr.FromReplacement#getInsideBoundaryElement()
	 * @see #getFromReplacement()
	 * @generated
	 */
	EReference getFromReplacement_InsideBoundaryElement();

	/**
	 * Returns the meta object for the reference list '{@link bvr.FromReplacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outside Boundary Element</em>'.
	 * @see bvr.FromReplacement#getOutsideBoundaryElement()
	 * @see #getFromReplacement()
	 * @generated
	 */
	EReference getFromReplacement_OutsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link bvr.FromReplacement#getFromPlacement <em>From Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Placement</em>'.
	 * @see bvr.FromReplacement#getFromPlacement()
	 * @see #getFromReplacement()
	 * @generated
	 */
	EReference getFromReplacement_FromPlacement();

	/**
	 * Returns the meta object for class '{@link bvr.TargetRef <em>Target Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Ref</em>'.
	 * @see bvr.TargetRef
	 * @generated
	 */
	EClass getTargetRef();

	/**
	 * Returns the meta object for the reference '{@link bvr.TargetRef#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see bvr.TargetRef#getTarget()
	 * @see #getTargetRef()
	 * @generated
	 */
	EReference getTargetRef_Target();

	/**
	 * Returns the meta object for class '{@link bvr.BCLExpression <em>BCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BCL Expression</em>'.
	 * @see bvr.BCLExpression
	 * @generated
	 */
	EClass getBCLExpression();

	/**
	 * Returns the meta object for class '{@link bvr.OpaqueConstraint <em>Opaque Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opaque Constraint</em>'.
	 * @see bvr.OpaqueConstraint
	 * @generated
	 */
	EClass getOpaqueConstraint();

	/**
	 * Returns the meta object for the attribute '{@link bvr.OpaqueConstraint#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see bvr.OpaqueConstraint#getConstraint()
	 * @see #getOpaqueConstraint()
	 * @generated
	 */
	EAttribute getOpaqueConstraint_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link bvr.OpaqueConstraint#getConstraintLanguage <em>Constraint Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Language</em>'.
	 * @see bvr.OpaqueConstraint#getConstraintLanguage()
	 * @see #getOpaqueConstraint()
	 * @generated
	 */
	EAttribute getOpaqueConstraint_ConstraintLanguage();

	/**
	 * Returns the meta object for class '{@link bvr.ParametricVariationPoint <em>Parametric Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parametric Variation Point</em>'.
	 * @see bvr.ParametricVariationPoint
	 * @generated
	 */
	EClass getParametricVariationPoint();

	/**
	 * Returns the meta object for the reference '{@link bvr.ParametricVariationPoint#getBindingVariable <em>Binding Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding Variable</em>'.
	 * @see bvr.ParametricVariationPoint#getBindingVariable()
	 * @see #getParametricVariationPoint()
	 * @generated
	 */
	EReference getParametricVariationPoint_BindingVariable();

	/**
	 * Returns the meta object for class '{@link bvr.ParametricSlotAssignment <em>Parametric Slot Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parametric Slot Assignment</em>'.
	 * @see bvr.ParametricSlotAssignment
	 * @generated
	 */
	EClass getParametricSlotAssignment();

	/**
	 * Returns the meta object for the attribute '{@link bvr.ParametricSlotAssignment#getSlotIdentifier <em>Slot Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slot Identifier</em>'.
	 * @see bvr.ParametricSlotAssignment#getSlotIdentifier()
	 * @see #getParametricSlotAssignment()
	 * @generated
	 */
	EAttribute getParametricSlotAssignment_SlotIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link bvr.ParametricSlotAssignment#getSlotOwner <em>Slot Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Slot Owner</em>'.
	 * @see bvr.ParametricSlotAssignment#getSlotOwner()
	 * @see #getParametricSlotAssignment()
	 * @generated
	 */
	EReference getParametricSlotAssignment_SlotOwner();

	/**
	 * Returns the meta object for class '{@link bvr.PrimitiveValueSpecification <em>Primitive Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Value Specification</em>'.
	 * @see bvr.PrimitiveValueSpecification
	 * @generated
	 */
	EClass getPrimitiveValueSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link bvr.PrimitiveValueSpecification#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see bvr.PrimitiveValueSpecification#getExpression()
	 * @see #getPrimitiveValueSpecification()
	 * @generated
	 */
	EReference getPrimitiveValueSpecification_Expression();

	/**
	 * Returns the meta object for class '{@link bvr.BCLConstraint <em>BCL Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BCL Constraint</em>'.
	 * @see bvr.BCLConstraint
	 * @generated
	 */
	EClass getBCLConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.BCLConstraint#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expression</em>'.
	 * @see bvr.BCLConstraint#getExpression()
	 * @see #getBCLConstraint()
	 * @generated
	 */
	EReference getBCLConstraint_Expression();

	/**
	 * Returns the meta object for class '{@link bvr.OperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Exp</em>'.
	 * @see bvr.OperationCallExp
	 * @generated
	 */
	EClass getOperationCallExp();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.OperationCallExp#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see bvr.OperationCallExp#getArgument()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_Argument();

	/**
	 * Returns the meta object for the attribute '{@link bvr.OperationCallExp#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see bvr.OperationCallExp#getOperation()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EAttribute getOperationCallExp_Operation();

	/**
	 * Returns the meta object for class '{@link bvr.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp</em>'.
	 * @see bvr.BooleanLiteralExp
	 * @generated
	 */
	EClass getBooleanLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link bvr.BooleanLiteralExp#isBool <em>Bool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bool</em>'.
	 * @see bvr.BooleanLiteralExp#isBool()
	 * @see #getBooleanLiteralExp()
	 * @generated
	 */
	EAttribute getBooleanLiteralExp_Bool();

	/**
	 * Returns the meta object for class '{@link bvr.StringLiteralExp <em>String Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Exp</em>'.
	 * @see bvr.StringLiteralExp
	 * @generated
	 */
	EClass getStringLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link bvr.StringLiteralExp#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see bvr.StringLiteralExp#getString()
	 * @see #getStringLiteralExp()
	 * @generated
	 */
	EAttribute getStringLiteralExp_String();

	/**
	 * Returns the meta object for class '{@link bvr.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal Exp</em>'.
	 * @see bvr.NumericLiteralExp
	 * @generated
	 */
	EClass getNumericLiteralExp();

	/**
	 * Returns the meta object for class '{@link bvr.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal Exp</em>'.
	 * @see bvr.IntegerLiteralExp
	 * @generated
	 */
	EClass getIntegerLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link bvr.IntegerLiteralExp#getInteger <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer</em>'.
	 * @see bvr.IntegerLiteralExp#getInteger()
	 * @see #getIntegerLiteralExp()
	 * @generated
	 */
	EAttribute getIntegerLiteralExp_Integer();

	/**
	 * Returns the meta object for class '{@link bvr.UnlimitedLiteralExp <em>Unlimited Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlimited Literal Exp</em>'.
	 * @see bvr.UnlimitedLiteralExp
	 * @generated
	 */
	EClass getUnlimitedLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link bvr.UnlimitedLiteralExp#getUnlimited <em>Unlimited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unlimited</em>'.
	 * @see bvr.UnlimitedLiteralExp#getUnlimited()
	 * @see #getUnlimitedLiteralExp()
	 * @generated
	 */
	EAttribute getUnlimitedLiteralExp_Unlimited();

	/**
	 * Returns the meta object for class '{@link bvr.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal Exp</em>'.
	 * @see bvr.RealLiteralExp
	 * @generated
	 */
	EClass getRealLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link bvr.RealLiteralExp#getReal <em>Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Real</em>'.
	 * @see bvr.RealLiteralExp#getReal()
	 * @see #getRealLiteralExp()
	 * @generated
	 */
	EAttribute getRealLiteralExp_Real();

	/**
	 * Returns the meta object for class '{@link bvr.CompoundResolution <em>Compound Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Resolution</em>'.
	 * @see bvr.CompoundResolution
	 * @generated
	 */
	EClass getCompoundResolution();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.CompoundResolution#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see bvr.CompoundResolution#getMembers()
	 * @see #getCompoundResolution()
	 * @generated
	 */
	EReference getCompoundResolution_Members();

	/**
	 * Returns the meta object for class '{@link bvr.NegResolution <em>Neg Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Neg Resolution</em>'.
	 * @see bvr.NegResolution
	 * @generated
	 */
	EClass getNegResolution();

	/**
	 * Returns the meta object for class '{@link bvr.PosResolution <em>Pos Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pos Resolution</em>'.
	 * @see bvr.PosResolution
	 * @generated
	 */
	EClass getPosResolution();

	/**
	 * Returns the meta object for class '{@link bvr.VRef <em>VRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VRef</em>'.
	 * @see bvr.VRef
	 * @generated
	 */
	EClass getVRef();

	/**
	 * Returns the meta object for the reference list '{@link bvr.VRef#getRefVSpec <em>Ref VSpec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ref VSpec</em>'.
	 * @see bvr.VRef#getRefVSpec()
	 * @see #getVRef()
	 * @generated
	 */
	EReference getVRef_RefVSpec();

	/**
	 * Returns the meta object for class '{@link bvr.VRefValueSpecification <em>VRef Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VRef Value Specification</em>'.
	 * @see bvr.VRefValueSpecification
	 * @generated
	 */
	EClass getVRefValueSpecification();

	/**
	 * Returns the meta object for the reference list '{@link bvr.VRefValueSpecification#getVSpecResolution <em>VSpec Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>VSpec Resolution</em>'.
	 * @see bvr.VRefValueSpecification#getVSpecResolution()
	 * @see #getVRefValueSpecification()
	 * @generated
	 */
	EReference getVRefValueSpecification_VSpecResolution();

	/**
	 * Returns the meta object for class '{@link bvr.ResolutionLiteralDefinition <em>Resolution Literal Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolution Literal Definition</em>'.
	 * @see bvr.ResolutionLiteralDefinition
	 * @generated
	 */
	EClass getResolutionLiteralDefinition();

	/**
	 * Returns the meta object for the reference '{@link bvr.ResolutionLiteralDefinition#getLiteralType <em>Literal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Literal Type</em>'.
	 * @see bvr.ResolutionLiteralDefinition#getLiteralType()
	 * @see #getResolutionLiteralDefinition()
	 * @generated
	 */
	EReference getResolutionLiteralDefinition_LiteralType();

	/**
	 * Returns the meta object for class '{@link bvr.ResolutionLiteralUse <em>Resolution Literal Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolution Literal Use</em>'.
	 * @see bvr.ResolutionLiteralUse
	 * @generated
	 */
	EClass getResolutionLiteralUse();

	/**
	 * Returns the meta object for the reference '{@link bvr.ResolutionLiteralUse#getDefLiteral <em>Def Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Def Literal</em>'.
	 * @see bvr.ResolutionLiteralUse#getDefLiteral()
	 * @see #getResolutionLiteralUse()
	 * @generated
	 */
	EReference getResolutionLiteralUse_DefLiteral();

	/**
	 * Returns the meta object for class '{@link bvr.BVRModel <em>BVR Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BVR Model</em>'.
	 * @see bvr.BVRModel
	 * @generated
	 */
	EClass getBVRModel();

	/**
	 * Returns the meta object for the containment reference '{@link bvr.BVRModel#getVariabilityModel <em>Variability Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variability Model</em>'.
	 * @see bvr.BVRModel#getVariabilityModel()
	 * @see #getBVRModel()
	 * @generated
	 */
	EReference getBVRModel_VariabilityModel();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.BVRModel#getResolutionModels <em>Resolution Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resolution Models</em>'.
	 * @see bvr.BVRModel#getResolutionModels()
	 * @see #getBVRModel()
	 * @generated
	 */
	EReference getBVRModel_ResolutionModels();

	/**
	 * Returns the meta object for the containment reference '{@link bvr.BVRModel#getBaseModelBase <em>Base Model Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Base Model Base</em>'.
	 * @see bvr.BVRModel#getBaseModelBase()
	 * @see #getBVRModel()
	 * @generated
	 */
	EReference getBVRModel_BaseModelBase();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.BVRModel#getBaseModelLibraries <em>Base Model Libraries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Base Model Libraries</em>'.
	 * @see bvr.BVRModel#getBaseModelLibraries()
	 * @see #getBVRModel()
	 * @generated
	 */
	EReference getBVRModel_BaseModelLibraries();

	/**
	 * Returns the meta object for the containment reference list '{@link bvr.BVRModel#getRealizationModel <em>Realization Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Realization Model</em>'.
	 * @see bvr.BVRModel#getRealizationModel()
	 * @see #getBVRModel()
	 * @generated
	 */
	EReference getBVRModel_RealizationModel();

	/**
	 * Returns the meta object for enum '{@link bvr.PrimitiveTypeEnum <em>Primitive Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Type Enum</em>'.
	 * @see bvr.PrimitiveTypeEnum
	 * @generated
	 */
	EEnum getPrimitiveTypeEnum();

	/**
	 * Returns the meta object for enum '{@link bvr.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operation</em>'.
	 * @see bvr.Operation
	 * @generated
	 */
	EEnum getOperation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BvrFactory getBvrFactory();

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
		 * The meta object literal for the '{@link bvr.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ChoiceImpl
		 * @see bvr.impl.BvrPackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '<em><b>Default Resolution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHOICE__DEFAULT_RESOLUTION = eINSTANCE.getChoice_DefaultResolution();

		/**
		 * The meta object literal for the '<em><b>Is Implied By Parent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHOICE__IS_IMPLIED_BY_PARENT = eINSTANCE.getChoice_IsImpliedByParent();

		/**
		 * The meta object literal for the '{@link bvr.impl.VSpecImpl <em>VSpec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.VSpecImpl
		 * @see bvr.impl.BvrPackageImpl#getVSpec()
		 * @generated
		 */
		EClass VSPEC = eINSTANCE.getVSpec();

		/**
		 * The meta object literal for the '<em><b>Resolution Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VSPEC__RESOLUTION_TIME = eINSTANCE.getVSpec_ResolutionTime();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSPEC__TARGET = eINSTANCE.getVSpec_Target();

		/**
		 * The meta object literal for the '{@link bvr.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.NamedElementImpl
		 * @see bvr.impl.BvrPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ELEMENT__NOTE = eINSTANCE.getNamedElement_Note();

		/**
		 * The meta object literal for the '{@link bvr.impl.NoteImpl <em>Note</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.NoteImpl
		 * @see bvr.impl.BvrPackageImpl#getNote()
		 * @generated
		 */
		EClass NOTE = eINSTANCE.getNote();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTE__KIND = eINSTANCE.getNote_Kind();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTE__EXPR = eINSTANCE.getNote_Expr();

		/**
		 * The meta object literal for the '{@link bvr.impl.TargetImpl <em>Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.TargetImpl
		 * @see bvr.impl.BvrPackageImpl#getTarget()
		 * @generated
		 */
		EClass TARGET = eINSTANCE.getTarget();

		/**
		 * The meta object literal for the '{@link bvr.impl.CompoundNodeImpl <em>Compound Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.CompoundNodeImpl
		 * @see bvr.impl.BvrPackageImpl#getCompoundNode()
		 * @generated
		 */
		EClass COMPOUND_NODE = eINSTANCE.getCompoundNode();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND_NODE__MEMBER = eINSTANCE.getCompoundNode_Member();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND_NODE__TARGET = eINSTANCE.getCompoundNode_Target();

		/**
		 * The meta object literal for the '{@link bvr.impl.VNodeImpl <em>VNode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.VNodeImpl
		 * @see bvr.impl.BvrPackageImpl#getVNode()
		 * @generated
		 */
		EClass VNODE = eINSTANCE.getVNode();

		/**
		 * The meta object literal for the '<em><b>Group Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VNODE__GROUP_MULTIPLICITY = eINSTANCE.getVNode_GroupMultiplicity();

		/**
		 * The meta object literal for the '<em><b>Owned Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VNODE__OWNED_CONSTRAINT = eINSTANCE.getVNode_OwnedConstraint();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VNODE__VARIABLE = eINSTANCE.getVNode_Variable();

		/**
		 * The meta object literal for the '{@link bvr.impl.MultiplicityIntervalImpl <em>Multiplicity Interval</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.MultiplicityIntervalImpl
		 * @see bvr.impl.BvrPackageImpl#getMultiplicityInterval()
		 * @generated
		 */
		EClass MULTIPLICITY_INTERVAL = eINSTANCE.getMultiplicityInterval();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_INTERVAL__UPPER = eINSTANCE.getMultiplicityInterval_Upper();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_INTERVAL__LOWER = eINSTANCE.getMultiplicityInterval_Lower();

		/**
		 * The meta object literal for the '{@link bvr.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ConstraintImpl
		 * @see bvr.impl.BvrPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '{@link bvr.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.VariableImpl
		 * @see bvr.impl.BvrPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Defaul Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__DEFAUL_VALUE = eINSTANCE.getVariable_DefaulValue();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__TYPE = eINSTANCE.getVariable_Type();

		/**
		 * The meta object literal for the '{@link bvr.impl.ValueSpecificationImpl <em>Value Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ValueSpecificationImpl
		 * @see bvr.impl.BvrPackageImpl#getValueSpecification()
		 * @generated
		 */
		EClass VALUE_SPECIFICATION = eINSTANCE.getValueSpecification();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_SPECIFICATION__TYPE = eINSTANCE.getValueSpecification_Type();

		/**
		 * The meta object literal for the '{@link bvr.impl.VariabletypeImpl <em>Variabletype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.VariabletypeImpl
		 * @see bvr.impl.BvrPackageImpl#getVariabletype()
		 * @generated
		 */
		EClass VARIABLETYPE = eINSTANCE.getVariabletype();

		/**
		 * The meta object literal for the '{@link bvr.impl.VPackageableImpl <em>VPackageable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.VPackageableImpl
		 * @see bvr.impl.BvrPackageImpl#getVPackageable()
		 * @generated
		 */
		EClass VPACKAGEABLE = eINSTANCE.getVPackageable();

		/**
		 * The meta object literal for the '{@link bvr.impl.VClassifierImpl <em>VClassifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.VClassifierImpl
		 * @see bvr.impl.BvrPackageImpl#getVClassifier()
		 * @generated
		 */
		EClass VCLASSIFIER = eINSTANCE.getVClassifier();

		/**
		 * The meta object literal for the '<em><b>Instance Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VCLASSIFIER__INSTANCE_MULTIPLICITY = eINSTANCE.getVClassifier_InstanceMultiplicity();

		/**
		 * The meta object literal for the '{@link bvr.impl.VSpecResolutionImpl <em>VSpec Resolution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.VSpecResolutionImpl
		 * @see bvr.impl.BvrPackageImpl#getVSpecResolution()
		 * @generated
		 */
		EClass VSPEC_RESOLUTION = eINSTANCE.getVSpecResolution();

		/**
		 * The meta object literal for the '<em><b>Resolved VSpec</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSPEC_RESOLUTION__RESOLVED_VSPEC = eINSTANCE.getVSpecResolution_ResolvedVSpec();

		/**
		 * The meta object literal for the '{@link bvr.impl.ChoiceResolutionImpl <em>Choice Resolution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ChoiceResolutionImpl
		 * @see bvr.impl.BvrPackageImpl#getChoiceResolution()
		 * @generated
		 */
		EClass CHOICE_RESOLUTION = eINSTANCE.getChoiceResolution();

		/**
		 * The meta object literal for the '<em><b>Resolved Choice</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_RESOLUTION__RESOLVED_CHOICE = eINSTANCE.getChoiceResolution_ResolvedChoice();

		/**
		 * The meta object literal for the '<em><b>Resolved Choice Occ</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_RESOLUTION__RESOLVED_CHOICE_OCC = eINSTANCE.getChoiceResolution_ResolvedChoiceOcc();

		/**
		 * The meta object literal for the '<em><b>Resolved VClass Occ</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_RESOLUTION__RESOLVED_VCLASS_OCC = eINSTANCE.getChoiceResolution_ResolvedVClassOcc();

		/**
		 * The meta object literal for the '<em><b>Resolved VClassifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_RESOLUTION__RESOLVED_VCLASSIFIER = eINSTANCE.getChoiceResolution_ResolvedVClassifier();

		/**
		 * The meta object literal for the '{@link bvr.impl.ChoiceOccurrenceImpl <em>Choice Occurrence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ChoiceOccurrenceImpl
		 * @see bvr.impl.BvrPackageImpl#getChoiceOccurrence()
		 * @generated
		 */
		EClass CHOICE_OCCURRENCE = eINSTANCE.getChoiceOccurrence();

		/**
		 * The meta object literal for the '<em><b>VType</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_OCCURRENCE__VTYPE = eINSTANCE.getChoiceOccurrence_VType();

		/**
		 * The meta object literal for the '{@link bvr.impl.VTypeImpl <em>VType</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.VTypeImpl
		 * @see bvr.impl.BvrPackageImpl#getVType()
		 * @generated
		 */
		EClass VTYPE = eINSTANCE.getVType();

		/**
		 * The meta object literal for the '{@link bvr.impl.VClassOccurrenceImpl <em>VClass Occurrence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.VClassOccurrenceImpl
		 * @see bvr.impl.BvrPackageImpl#getVClassOccurrence()
		 * @generated
		 */
		EClass VCLASS_OCCURRENCE = eINSTANCE.getVClassOccurrence();

		/**
		 * The meta object literal for the '<em><b>VType</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VCLASS_OCCURRENCE__VTYPE = eINSTANCE.getVClassOccurrence_VType();

		/**
		 * The meta object literal for the '<em><b>Instance Multiplicity</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VCLASS_OCCURRENCE__INSTANCE_MULTIPLICITY = eINSTANCE.getVClassOccurrence_InstanceMultiplicity();

		/**
		 * The meta object literal for the '{@link bvr.impl.VariationPointImpl <em>Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.VariationPointImpl
		 * @see bvr.impl.BvrPackageImpl#getVariationPoint()
		 * @generated
		 */
		EClass VARIATION_POINT = eINSTANCE.getVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Binding VSpec</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION_POINT__BINDING_VSPEC = eINSTANCE.getVariationPoint_BindingVSpec();

		/**
		 * The meta object literal for the '<em><b>Staged Variation Point</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION_POINT__STAGED_VARIATION_POINT = eINSTANCE.getVariationPoint_StagedVariationPoint();

		/**
		 * The meta object literal for the '{@link bvr.impl.StagedVariationPointImpl <em>Staged Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.StagedVariationPointImpl
		 * @see bvr.impl.BvrPackageImpl#getStagedVariationPoint()
		 * @generated
		 */
		EClass STAGED_VARIATION_POINT = eINSTANCE.getStagedVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Binding Staged VP</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAGED_VARIATION_POINT__BINDING_STAGED_VP = eINSTANCE.getStagedVariationPoint_BindingStagedVP();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAGED_VARIATION_POINT__MEMBER = eINSTANCE.getStagedVariationPoint_Member();

		/**
		 * The meta object literal for the '{@link bvr.impl.FragmentSubstitutionImpl <em>Fragment Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.FragmentSubstitutionImpl
		 * @see bvr.impl.BvrPackageImpl#getFragmentSubstitution()
		 * @generated
		 */
		EClass FRAGMENT_SUBSTITUTION = eINSTANCE.getFragmentSubstitution();

		/**
		 * The meta object literal for the '<em><b>Boundary Element Binding</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING = eINSTANCE.getFragmentSubstitution_BoundaryElementBinding();

		/**
		 * The meta object literal for the '<em><b>Placement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT_SUBSTITUTION__PLACEMENT = eINSTANCE.getFragmentSubstitution_Placement();

		/**
		 * The meta object literal for the '<em><b>Multi</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FRAGMENT_SUBSTITUTION__MULTI = eINSTANCE.getFragmentSubstitution_Multi();

		/**
		 * The meta object literal for the '<em><b>Replacement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT_SUBSTITUTION__REPLACEMENT = eINSTANCE.getFragmentSubstitution_Replacement();

		/**
		 * The meta object literal for the '{@link bvr.impl.ChoiceVariationPointImpl <em>Choice Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ChoiceVariationPointImpl
		 * @see bvr.impl.BvrPackageImpl#getChoiceVariationPoint()
		 * @generated
		 */
		EClass CHOICE_VARIATION_POINT = eINSTANCE.getChoiceVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Binding Choice</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_VARIATION_POINT__BINDING_CHOICE = eINSTANCE.getChoiceVariationPoint_BindingChoice();

		/**
		 * The meta object literal for the '<em><b>Binding Choice Occ</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_VARIATION_POINT__BINDING_CHOICE_OCC = eINSTANCE.getChoiceVariationPoint_BindingChoiceOcc();

		/**
		 * The meta object literal for the '<em><b>Resolution kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHOICE_VARIATION_POINT__RESOLUTION_KIND = eINSTANCE.getChoiceVariationPoint_Resolution_kind();

		/**
		 * The meta object literal for the '{@link bvr.impl.RepeatableVariationPointImpl <em>Repeatable Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.RepeatableVariationPointImpl
		 * @see bvr.impl.BvrPackageImpl#getRepeatableVariationPoint()
		 * @generated
		 */
		EClass REPEATABLE_VARIATION_POINT = eINSTANCE.getRepeatableVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Binding Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPEATABLE_VARIATION_POINT__BINDING_CLASSIFIER = eINSTANCE.getRepeatableVariationPoint_BindingClassifier();

		/**
		 * The meta object literal for the '<em><b>Binding VClass Occ</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPEATABLE_VARIATION_POINT__BINDING_VCLASS_OCC = eINSTANCE.getRepeatableVariationPoint_BindingVClassOcc();

		/**
		 * The meta object literal for the '{@link bvr.impl.BoundaryElementBindingImpl <em>Boundary Element Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.BoundaryElementBindingImpl
		 * @see bvr.impl.BvrPackageImpl#getBoundaryElementBinding()
		 * @generated
		 */
		EClass BOUNDARY_ELEMENT_BINDING = eINSTANCE.getBoundaryElementBinding();

		/**
		 * The meta object literal for the '{@link bvr.impl.PlacementFragmentImpl <em>Placement Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.PlacementFragmentImpl
		 * @see bvr.impl.BvrPackageImpl#getPlacementFragment()
		 * @generated
		 */
		EClass PLACEMENT_FRAGMENT = eINSTANCE.getPlacementFragment();

		/**
		 * The meta object literal for the '<em><b>Placement Boundary Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT = eINSTANCE.getPlacementFragment_PlacementBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Source Object</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACEMENT_FRAGMENT__SOURCE_OBJECT = eINSTANCE.getPlacementFragment_SourceObject();

		/**
		 * The meta object literal for the '{@link bvr.impl.PlacementBoundaryElementImpl <em>Placement Boundary Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.PlacementBoundaryElementImpl
		 * @see bvr.impl.BvrPackageImpl#getPlacementBoundaryElement()
		 * @generated
		 */
		EClass PLACEMENT_BOUNDARY_ELEMENT = eINSTANCE.getPlacementBoundaryElement();

		/**
		 * The meta object literal for the '{@link bvr.impl.ObjectHandleImpl <em>Object Handle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ObjectHandleImpl
		 * @see bvr.impl.BvrPackageImpl#getObjectHandle()
		 * @generated
		 */
		EClass OBJECT_HANDLE = eINSTANCE.getObjectHandle();

		/**
		 * The meta object literal for the '<em><b>MOF Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_HANDLE__MOF_REF = eINSTANCE.getObjectHandle_MOFRef();

		/**
		 * The meta object literal for the '{@link bvr.impl.ReplacementFragmentTypeImpl <em>Replacement Fragment Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ReplacementFragmentTypeImpl
		 * @see bvr.impl.BvrPackageImpl#getReplacementFragmentType()
		 * @generated
		 */
		EClass REPLACEMENT_FRAGMENT_TYPE = eINSTANCE.getReplacementFragmentType();

		/**
		 * The meta object literal for the '<em><b>Replacement Boundary Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT = eINSTANCE.getReplacementFragmentType_ReplacementBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Placement Fragment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT = eINSTANCE.getReplacementFragmentType_PlacementFragment();

		/**
		 * The meta object literal for the '<em><b>Source Object</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT = eINSTANCE.getReplacementFragmentType_SourceObject();

		/**
		 * The meta object literal for the '{@link bvr.impl.ReplacementBoundaryElementImpl <em>Replacement Boundary Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ReplacementBoundaryElementImpl
		 * @see bvr.impl.BvrPackageImpl#getReplacementBoundaryElement()
		 * @generated
		 */
		EClass REPLACEMENT_BOUNDARY_ELEMENT = eINSTANCE.getReplacementBoundaryElement();

		/**
		 * The meta object literal for the '{@link bvr.impl.ValueResolutionImpl <em>Value Resolution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ValueResolutionImpl
		 * @see bvr.impl.BvrPackageImpl#getValueResolution()
		 * @generated
		 */
		EClass VALUE_RESOLUTION = eINSTANCE.getValueResolution();

		/**
		 * The meta object literal for the '<em><b>Resolved Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_RESOLUTION__RESOLVED_VARIABLE = eINSTANCE.getValueResolution_ResolvedVariable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_RESOLUTION__VALUE = eINSTANCE.getValueResolution_Value();

		/**
		 * The meta object literal for the '{@link bvr.impl.PrimitveTypeImpl <em>Primitve Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.PrimitveTypeImpl
		 * @see bvr.impl.BvrPackageImpl#getPrimitveType()
		 * @generated
		 */
		EClass PRIMITVE_TYPE = eINSTANCE.getPrimitveType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITVE_TYPE__TYPE = eINSTANCE.getPrimitveType_Type();

		/**
		 * The meta object literal for the '{@link bvr.impl.ObjectTypeImpl <em>Object Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ObjectTypeImpl
		 * @see bvr.impl.BvrPackageImpl#getObjectType()
		 * @generated
		 */
		EClass OBJECT_TYPE = eINSTANCE.getObjectType();

		/**
		 * The meta object literal for the '<em><b>Meta Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_TYPE__META_CLASS = eINSTANCE.getObjectType_MetaClass();

		/**
		 * The meta object literal for the '{@link bvr.impl.SlotAssignmentImpl <em>Slot Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.SlotAssignmentImpl
		 * @see bvr.impl.BvrPackageImpl#getSlotAssignment()
		 * @generated
		 */
		EClass SLOT_ASSIGNMENT = eINSTANCE.getSlotAssignment();

		/**
		 * The meta object literal for the '<em><b>Slot Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLOT_ASSIGNMENT__SLOT_IDENTIFIER = eINSTANCE.getSlotAssignment_SlotIdentifier();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT_ASSIGNMENT__VALUE = eINSTANCE.getSlotAssignment_Value();

		/**
		 * The meta object literal for the '<em><b>Slot Owner</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT_ASSIGNMENT__SLOT_OWNER = eINSTANCE.getSlotAssignment_SlotOwner();

		/**
		 * The meta object literal for the '{@link bvr.impl.OpaqueVariationPointImpl <em>Opaque Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.OpaqueVariationPointImpl
		 * @see bvr.impl.BvrPackageImpl#getOpaqueVariationPoint()
		 * @generated
		 */
		EClass OPAQUE_VARIATION_POINT = eINSTANCE.getOpaqueVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Place Holder</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPAQUE_VARIATION_POINT__PLACE_HOLDER = eINSTANCE.getOpaqueVariationPoint_PlaceHolder();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPAQUE_VARIATION_POINT__TYPE = eINSTANCE.getOpaqueVariationPoint_Type();

		/**
		 * The meta object literal for the '{@link bvr.impl.OVPTypeImpl <em>OVP Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.OVPTypeImpl
		 * @see bvr.impl.BvrPackageImpl#getOVPType()
		 * @generated
		 */
		EClass OVP_TYPE = eINSTANCE.getOVPType();

		/**
		 * The meta object literal for the '<em><b>Spec</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OVP_TYPE__SPEC = eINSTANCE.getOVPType_Spec();

		/**
		 * The meta object literal for the '{@link bvr.impl.OVPSemanticSpecImpl <em>OVP Semantic Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.OVPSemanticSpecImpl
		 * @see bvr.impl.BvrPackageImpl#getOVPSemanticSpec()
		 * @generated
		 */
		EClass OVP_SEMANTIC_SPEC = eINSTANCE.getOVPSemanticSpec();

		/**
		 * The meta object literal for the '<em><b>Model Transformation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OVP_SEMANTIC_SPEC__MODEL_TRANSFORMATION = eINSTANCE.getOVPSemanticSpec_ModelTransformation();

		/**
		 * The meta object literal for the '<em><b>Transfromation Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OVP_SEMANTIC_SPEC__TRANSFROMATION_LANGUAGE = eINSTANCE.getOVPSemanticSpec_TransfromationLanguage();

		/**
		 * The meta object literal for the '{@link bvr.impl.ObjectSpecificationImpl <em>Object Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ObjectSpecificationImpl
		 * @see bvr.impl.BvrPackageImpl#getObjectSpecification()
		 * @generated
		 */
		EClass OBJECT_SPECIFICATION = eINSTANCE.getObjectSpecification();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_SPECIFICATION__OBJECT = eINSTANCE.getObjectSpecification_Object();

		/**
		 * The meta object literal for the '{@link bvr.impl.ReplacementFragmentSpecificationImpl <em>Replacement Fragment Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ReplacementFragmentSpecificationImpl
		 * @see bvr.impl.BvrPackageImpl#getReplacementFragmentSpecification()
		 * @generated
		 */
		EClass REPLACEMENT_FRAGMENT_SPECIFICATION = eINSTANCE.getReplacementFragmentSpecification();

		/**
		 * The meta object literal for the '{@link bvr.impl.VPackageImpl <em>VPackage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.VPackageImpl
		 * @see bvr.impl.BvrPackageImpl#getVPackage()
		 * @generated
		 */
		EClass VPACKAGE = eINSTANCE.getVPackage();

		/**
		 * The meta object literal for the '<em><b>Package Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VPACKAGE__PACKAGE_ELEMENT = eINSTANCE.getVPackage_PackageElement();

		/**
		 * The meta object literal for the '{@link bvr.impl.ToBindingImpl <em>To Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ToBindingImpl
		 * @see bvr.impl.BvrPackageImpl#getToBinding()
		 * @generated
		 */
		EClass TO_BINDING = eINSTANCE.getToBinding();

		/**
		 * The meta object literal for the '<em><b>To Placement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_BINDING__TO_PLACEMENT = eINSTANCE.getToBinding_ToPlacement();

		/**
		 * The meta object literal for the '<em><b>To Replacement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_BINDING__TO_REPLACEMENT = eINSTANCE.getToBinding_ToReplacement();

		/**
		 * The meta object literal for the '{@link bvr.impl.ToPlacementImpl <em>To Placement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ToPlacementImpl
		 * @see bvr.impl.BvrPackageImpl#getToPlacement()
		 * @generated
		 */
		EClass TO_PLACEMENT = eINSTANCE.getToPlacement();

		/**
		 * The meta object literal for the '<em><b>To Replacement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_PLACEMENT__TO_REPLACEMENT = eINSTANCE.getToPlacement_ToReplacement();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TO_PLACEMENT__PROPERTY_NAME = eINSTANCE.getToPlacement_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Inside Boundary Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT = eINSTANCE.getToPlacement_InsideBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Outside Boundary Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = eINSTANCE.getToPlacement_OutsideBoundaryElement();

		/**
		 * The meta object literal for the '{@link bvr.impl.ToReplacementImpl <em>To Replacement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ToReplacementImpl
		 * @see bvr.impl.BvrPackageImpl#getToReplacement()
		 * @generated
		 */
		EClass TO_REPLACEMENT = eINSTANCE.getToReplacement();

		/**
		 * The meta object literal for the '<em><b>Inside Boundary Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT = eINSTANCE.getToReplacement_InsideBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Outside Boundary Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = eINSTANCE.getToReplacement_OutsideBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>To Placement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_REPLACEMENT__TO_PLACEMENT = eINSTANCE.getToReplacement_ToPlacement();

		/**
		 * The meta object literal for the '{@link bvr.impl.FromBindingImpl <em>From Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.FromBindingImpl
		 * @see bvr.impl.BvrPackageImpl#getFromBinding()
		 * @generated
		 */
		EClass FROM_BINDING = eINSTANCE.getFromBinding();

		/**
		 * The meta object literal for the '<em><b>From Placement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_BINDING__FROM_PLACEMENT = eINSTANCE.getFromBinding_FromPlacement();

		/**
		 * The meta object literal for the '<em><b>From Replacement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_BINDING__FROM_REPLACEMENT = eINSTANCE.getFromBinding_FromReplacement();

		/**
		 * The meta object literal for the '{@link bvr.impl.FromPlacementImpl <em>From Placement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.FromPlacementImpl
		 * @see bvr.impl.BvrPackageImpl#getFromPlacement()
		 * @generated
		 */
		EClass FROM_PLACEMENT = eINSTANCE.getFromPlacement();

		/**
		 * The meta object literal for the '<em><b>From Replacement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_PLACEMENT__FROM_REPLACEMENT = eINSTANCE.getFromPlacement_FromReplacement();

		/**
		 * The meta object literal for the '<em><b>Outside Boundary Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = eINSTANCE.getFromPlacement_OutsideBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Inside Boundary Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_PLACEMENT__INSIDE_BOUNDARY_ELEMENT = eINSTANCE.getFromPlacement_InsideBoundaryElement();

		/**
		 * The meta object literal for the '{@link bvr.impl.FromReplacementImpl <em>From Replacement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.FromReplacementImpl
		 * @see bvr.impl.BvrPackageImpl#getFromReplacement()
		 * @generated
		 */
		EClass FROM_REPLACEMENT = eINSTANCE.getFromReplacement();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FROM_REPLACEMENT__PROPERTY_NAME = eINSTANCE.getFromReplacement_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Inside Boundary Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT = eINSTANCE.getFromReplacement_InsideBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Outside Boundary Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = eINSTANCE.getFromReplacement_OutsideBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>From Placement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_REPLACEMENT__FROM_PLACEMENT = eINSTANCE.getFromReplacement_FromPlacement();

		/**
		 * The meta object literal for the '{@link bvr.impl.TargetRefImpl <em>Target Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.TargetRefImpl
		 * @see bvr.impl.BvrPackageImpl#getTargetRef()
		 * @generated
		 */
		EClass TARGET_REF = eINSTANCE.getTargetRef();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_REF__TARGET = eINSTANCE.getTargetRef_Target();

		/**
		 * The meta object literal for the '{@link bvr.impl.BCLExpressionImpl <em>BCL Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.BCLExpressionImpl
		 * @see bvr.impl.BvrPackageImpl#getBCLExpression()
		 * @generated
		 */
		EClass BCL_EXPRESSION = eINSTANCE.getBCLExpression();

		/**
		 * The meta object literal for the '{@link bvr.impl.OpaqueConstraintImpl <em>Opaque Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.OpaqueConstraintImpl
		 * @see bvr.impl.BvrPackageImpl#getOpaqueConstraint()
		 * @generated
		 */
		EClass OPAQUE_CONSTRAINT = eINSTANCE.getOpaqueConstraint();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPAQUE_CONSTRAINT__CONSTRAINT = eINSTANCE.getOpaqueConstraint_Constraint();

		/**
		 * The meta object literal for the '<em><b>Constraint Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPAQUE_CONSTRAINT__CONSTRAINT_LANGUAGE = eINSTANCE.getOpaqueConstraint_ConstraintLanguage();

		/**
		 * The meta object literal for the '{@link bvr.impl.ParametricVariationPointImpl <em>Parametric Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ParametricVariationPointImpl
		 * @see bvr.impl.BvrPackageImpl#getParametricVariationPoint()
		 * @generated
		 */
		EClass PARAMETRIC_VARIATION_POINT = eINSTANCE.getParametricVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Binding Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE = eINSTANCE.getParametricVariationPoint_BindingVariable();

		/**
		 * The meta object literal for the '{@link bvr.impl.ParametricSlotAssignmentImpl <em>Parametric Slot Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ParametricSlotAssignmentImpl
		 * @see bvr.impl.BvrPackageImpl#getParametricSlotAssignment()
		 * @generated
		 */
		EClass PARAMETRIC_SLOT_ASSIGNMENT = eINSTANCE.getParametricSlotAssignment();

		/**
		 * The meta object literal for the '<em><b>Slot Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETRIC_SLOT_ASSIGNMENT__SLOT_IDENTIFIER = eINSTANCE.getParametricSlotAssignment_SlotIdentifier();

		/**
		 * The meta object literal for the '<em><b>Slot Owner</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_SLOT_ASSIGNMENT__SLOT_OWNER = eINSTANCE.getParametricSlotAssignment_SlotOwner();

		/**
		 * The meta object literal for the '{@link bvr.impl.PrimitiveValueSpecificationImpl <em>Primitive Value Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.PrimitiveValueSpecificationImpl
		 * @see bvr.impl.BvrPackageImpl#getPrimitiveValueSpecification()
		 * @generated
		 */
		EClass PRIMITIVE_VALUE_SPECIFICATION = eINSTANCE.getPrimitiveValueSpecification();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_VALUE_SPECIFICATION__EXPRESSION = eINSTANCE.getPrimitiveValueSpecification_Expression();

		/**
		 * The meta object literal for the '{@link bvr.impl.BCLConstraintImpl <em>BCL Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.BCLConstraintImpl
		 * @see bvr.impl.BvrPackageImpl#getBCLConstraint()
		 * @generated
		 */
		EClass BCL_CONSTRAINT = eINSTANCE.getBCLConstraint();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BCL_CONSTRAINT__EXPRESSION = eINSTANCE.getBCLConstraint_Expression();

		/**
		 * The meta object literal for the '{@link bvr.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.OperationCallExpImpl
		 * @see bvr.impl.BvrPackageImpl#getOperationCallExp()
		 * @generated
		 */
		EClass OPERATION_CALL_EXP = eINSTANCE.getOperationCallExp();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_EXP__ARGUMENT = eINSTANCE.getOperationCallExp_Argument();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_CALL_EXP__OPERATION = eINSTANCE.getOperationCallExp_Operation();

		/**
		 * The meta object literal for the '{@link bvr.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.BooleanLiteralExpImpl
		 * @see bvr.impl.BvrPackageImpl#getBooleanLiteralExp()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXP = eINSTANCE.getBooleanLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Bool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_EXP__BOOL = eINSTANCE.getBooleanLiteralExp_Bool();

		/**
		 * The meta object literal for the '{@link bvr.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.StringLiteralExpImpl
		 * @see bvr.impl.BvrPackageImpl#getStringLiteralExp()
		 * @generated
		 */
		EClass STRING_LITERAL_EXP = eINSTANCE.getStringLiteralExp();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_EXP__STRING = eINSTANCE.getStringLiteralExp_String();

		/**
		 * The meta object literal for the '{@link bvr.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.NumericLiteralExpImpl
		 * @see bvr.impl.BvrPackageImpl#getNumericLiteralExp()
		 * @generated
		 */
		EClass NUMERIC_LITERAL_EXP = eINSTANCE.getNumericLiteralExp();

		/**
		 * The meta object literal for the '{@link bvr.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.IntegerLiteralExpImpl
		 * @see bvr.impl.BvrPackageImpl#getIntegerLiteralExp()
		 * @generated
		 */
		EClass INTEGER_LITERAL_EXP = eINSTANCE.getIntegerLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Integer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL_EXP__INTEGER = eINSTANCE.getIntegerLiteralExp_Integer();

		/**
		 * The meta object literal for the '{@link bvr.impl.UnlimitedLiteralExpImpl <em>Unlimited Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.UnlimitedLiteralExpImpl
		 * @see bvr.impl.BvrPackageImpl#getUnlimitedLiteralExp()
		 * @generated
		 */
		EClass UNLIMITED_LITERAL_EXP = eINSTANCE.getUnlimitedLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Unlimited</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNLIMITED_LITERAL_EXP__UNLIMITED = eINSTANCE.getUnlimitedLiteralExp_Unlimited();

		/**
		 * The meta object literal for the '{@link bvr.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.RealLiteralExpImpl
		 * @see bvr.impl.BvrPackageImpl#getRealLiteralExp()
		 * @generated
		 */
		EClass REAL_LITERAL_EXP = eINSTANCE.getRealLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Real</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_LITERAL_EXP__REAL = eINSTANCE.getRealLiteralExp_Real();

		/**
		 * The meta object literal for the '{@link bvr.impl.CompoundResolutionImpl <em>Compound Resolution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.CompoundResolutionImpl
		 * @see bvr.impl.BvrPackageImpl#getCompoundResolution()
		 * @generated
		 */
		EClass COMPOUND_RESOLUTION = eINSTANCE.getCompoundResolution();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND_RESOLUTION__MEMBERS = eINSTANCE.getCompoundResolution_Members();

		/**
		 * The meta object literal for the '{@link bvr.impl.NegResolutionImpl <em>Neg Resolution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.NegResolutionImpl
		 * @see bvr.impl.BvrPackageImpl#getNegResolution()
		 * @generated
		 */
		EClass NEG_RESOLUTION = eINSTANCE.getNegResolution();

		/**
		 * The meta object literal for the '{@link bvr.impl.PosResolutionImpl <em>Pos Resolution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.PosResolutionImpl
		 * @see bvr.impl.BvrPackageImpl#getPosResolution()
		 * @generated
		 */
		EClass POS_RESOLUTION = eINSTANCE.getPosResolution();

		/**
		 * The meta object literal for the '{@link bvr.impl.VRefImpl <em>VRef</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.VRefImpl
		 * @see bvr.impl.BvrPackageImpl#getVRef()
		 * @generated
		 */
		EClass VREF = eINSTANCE.getVRef();

		/**
		 * The meta object literal for the '<em><b>Ref VSpec</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VREF__REF_VSPEC = eINSTANCE.getVRef_RefVSpec();

		/**
		 * The meta object literal for the '{@link bvr.impl.VRefValueSpecificationImpl <em>VRef Value Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.VRefValueSpecificationImpl
		 * @see bvr.impl.BvrPackageImpl#getVRefValueSpecification()
		 * @generated
		 */
		EClass VREF_VALUE_SPECIFICATION = eINSTANCE.getVRefValueSpecification();

		/**
		 * The meta object literal for the '<em><b>VSpec Resolution</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VREF_VALUE_SPECIFICATION__VSPEC_RESOLUTION = eINSTANCE.getVRefValueSpecification_VSpecResolution();

		/**
		 * The meta object literal for the '{@link bvr.impl.ResolutionLiteralDefinitionImpl <em>Resolution Literal Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ResolutionLiteralDefinitionImpl
		 * @see bvr.impl.BvrPackageImpl#getResolutionLiteralDefinition()
		 * @generated
		 */
		EClass RESOLUTION_LITERAL_DEFINITION = eINSTANCE.getResolutionLiteralDefinition();

		/**
		 * The meta object literal for the '<em><b>Literal Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLUTION_LITERAL_DEFINITION__LITERAL_TYPE = eINSTANCE.getResolutionLiteralDefinition_LiteralType();

		/**
		 * The meta object literal for the '{@link bvr.impl.ResolutionLiteralUseImpl <em>Resolution Literal Use</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.ResolutionLiteralUseImpl
		 * @see bvr.impl.BvrPackageImpl#getResolutionLiteralUse()
		 * @generated
		 */
		EClass RESOLUTION_LITERAL_USE = eINSTANCE.getResolutionLiteralUse();

		/**
		 * The meta object literal for the '<em><b>Def Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLUTION_LITERAL_USE__DEF_LITERAL = eINSTANCE.getResolutionLiteralUse_DefLiteral();

		/**
		 * The meta object literal for the '{@link bvr.impl.BVRModelImpl <em>BVR Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.impl.BVRModelImpl
		 * @see bvr.impl.BvrPackageImpl#getBVRModel()
		 * @generated
		 */
		EClass BVR_MODEL = eINSTANCE.getBVRModel();

		/**
		 * The meta object literal for the '<em><b>Variability Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BVR_MODEL__VARIABILITY_MODEL = eINSTANCE.getBVRModel_VariabilityModel();

		/**
		 * The meta object literal for the '<em><b>Resolution Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BVR_MODEL__RESOLUTION_MODELS = eINSTANCE.getBVRModel_ResolutionModels();

		/**
		 * The meta object literal for the '<em><b>Base Model Base</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BVR_MODEL__BASE_MODEL_BASE = eINSTANCE.getBVRModel_BaseModelBase();

		/**
		 * The meta object literal for the '<em><b>Base Model Libraries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BVR_MODEL__BASE_MODEL_LIBRARIES = eINSTANCE.getBVRModel_BaseModelLibraries();

		/**
		 * The meta object literal for the '<em><b>Realization Model</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BVR_MODEL__REALIZATION_MODEL = eINSTANCE.getBVRModel_RealizationModel();

		/**
		 * The meta object literal for the '{@link bvr.PrimitiveTypeEnum <em>Primitive Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.PrimitiveTypeEnum
		 * @see bvr.impl.BvrPackageImpl#getPrimitiveTypeEnum()
		 * @generated
		 */
		EEnum PRIMITIVE_TYPE_ENUM = eINSTANCE.getPrimitiveTypeEnum();

		/**
		 * The meta object literal for the '{@link bvr.Operation <em>Operation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see bvr.Operation
		 * @see bvr.impl.BvrPackageImpl#getOperation()
		 * @generated
		 */
		EEnum OPERATION = eINSTANCE.getOperation();

	}

} //BvrPackage
