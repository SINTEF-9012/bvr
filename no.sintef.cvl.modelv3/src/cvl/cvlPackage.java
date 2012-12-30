/**
 */
package cvl;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see cvl.cvlFactory
 * @model kind="package"
 *        annotation="com.ibm.xtools.common.ui.reduction.editingCapabilities com.ibm.xtools.activities.umlBBFragment='1' com.ibm.xtools.activities.umlBBAction='1' com.ibm.xtools.activities.umlBBClassTemplateParameter='1' com.ibm.xtools.activities.umlBBPackageTemplateParameter='1' com.ibm.xtools.activities.umlBBSequence1='1' com.ibm.xtools.activities.umlBBRelationship1='1' com.ibm.xtools.activities.umlBBSequence2='1' com.ibm.xtools.activities.umlBBCollaborationUse='1' com.ibm.xtools.activities.umlBBRelationship2='1' com.ibm.xtools.activities.umlBBSubsystem='1' com.ibm.xtools.activities.umlBBComment1='1' com.ibm.xtools.activities.umlBBLifeLine='1' com.ibm.xtools.activities.umlBBComment2='1' com.ibm.xtools.activities.umlBBActivity1='1' com.ibm.xtools.activities.umlBBActivity2='1' com.ibm.xtools.activities.umlBBActivity3='1' com.ibm.xtools.activities.umlBBFunction='1' com.ibm.xtools.activities.umlBBActivityDiagram='1' com.ibm.xtools.activities.umlBBCommunication='1' com.ibm.xtools.activities.umlBBCollaboration='1' com.ibm.xtools.activities.umlBBClass='1' com.ibm.xtools.activities.umlBBInterface='1' com.ibm.xtools.activities.umlBBUseCaseDiagram='1' com.ibm.xtools.activities.umlBBTypes1='1' com.ibm.xtools.activities.umlBBTypes2='1' com.ibm.xtools.activities.umlBBComponentTemplateParameter='1' com.ibm.xtools.activities.umlBBTypes3='1' com.ibm.xtools.activities.umlBBTypes4='1' com.ibm.xtools.activities.umlBBUseCase1='1' com.ibm.xtools.activities.umlBBUseCase2='1' com.ibm.xtools.activities.umlBBPackage='1' com.ibm.xtools.activities.umlBBComponentDiagram='1' com.ibm.xtools.activities.umlBBInterfaceTemplateParameter='1' com.ibm.xtools.activities.umlBBClassDiagram='1' com.ibm.xtools.activities.umlBBRealization='1' com.ibm.xtools.activities.umlBBComponent='1' com.ibm.xtools.activities.umlBBSequenceDiagram='1'"
 * @generated
 */
public interface cvlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cvl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///cvl.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cvl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	cvlPackage eINSTANCE = cvl.impl.cvlPackageImpl.init();

	/**
	 * The meta object id for the '{@link cvl.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.NamedElementImpl
	 * @see cvl.impl.cvlPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link cvl.impl.VPackageableImpl <em>VPackageable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VPackageableImpl
	 * @see cvl.impl.cvlPackageImpl#getVPackageable()
	 * @generated
	 */
	int VPACKAGEABLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPACKAGEABLE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>VPackageable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPACKAGEABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cvl.impl.VSpecImpl <em>VSpec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VSpecImpl
	 * @see cvl.impl.cvlPackageImpl#getVSpec()
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
	int VSPEC__NAME = VPACKAGEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Group Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC__GROUP_MULTIPLICITY = VPACKAGEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resolution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC__RESOLUTION_TIME = VPACKAGEABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned VSpec Derivation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC__OWNED_VSPEC_DERIVATION = VPACKAGEABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC__CHILD = VPACKAGEABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>VSpec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_FEATURE_COUNT = VPACKAGEABLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link cvl.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ChoiceImpl
	 * @see cvl.impl.cvlPackageImpl#getChoice()
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
	 * The feature id for the '<em><b>Group Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__GROUP_MULTIPLICITY = VSPEC__GROUP_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Resolution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__RESOLUTION_TIME = VSPEC__RESOLUTION_TIME;

	/**
	 * The feature id for the '<em><b>Owned VSpec Derivation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__OWNED_VSPEC_DERIVATION = VSPEC__OWNED_VSPEC_DERIVATION;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__CHILD = VSPEC__CHILD;

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
	 * The meta object id for the '{@link cvl.impl.MultiplicityIntervalImpl <em>Multiplicity Interval</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.MultiplicityIntervalImpl
	 * @see cvl.impl.cvlPackageImpl#getMultiplicityInterval()
	 * @generated
	 */
	int MULTIPLICITY_INTERVAL = 4;

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
	 * The meta object id for the '{@link cvl.impl.VSpecDerivationImpl <em>VSpec Derivation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VSpecDerivationImpl
	 * @see cvl.impl.cvlPackageImpl#getVSpecDerivation()
	 * @generated
	 */
	int VSPEC_DERIVATION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_DERIVATION__NAME = VPACKAGEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Derived VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_DERIVATION__DERIVED_VSPEC = VPACKAGEABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VSpec Derivation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_DERIVATION_FEATURE_COUNT = VPACKAGEABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.VClassifierImpl <em>VClassifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VClassifierImpl
	 * @see cvl.impl.cvlPackageImpl#getVClassifier()
	 * @generated
	 */
	int VCLASSIFIER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER__NAME = VSPEC__NAME;

	/**
	 * The feature id for the '<em><b>Group Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER__GROUP_MULTIPLICITY = VSPEC__GROUP_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Resolution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER__RESOLUTION_TIME = VSPEC__RESOLUTION_TIME;

	/**
	 * The feature id for the '<em><b>Owned VSpec Derivation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER__OWNED_VSPEC_DERIVATION = VSPEC__OWNED_VSPEC_DERIVATION;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCLASSIFIER__CHILD = VSPEC__CHILD;

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
	 * The meta object id for the '{@link cvl.impl.VSpecResolutionImpl <em>VSpec Resolution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VSpecResolutionImpl
	 * @see cvl.impl.cvlPackageImpl#getVSpecResolution()
	 * @generated
	 */
	int VSPEC_RESOLUTION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_RESOLUTION__NAME = VPACKAGEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_RESOLUTION__RESOLVED_VSPEC = VPACKAGEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_RESOLUTION__CHILD = VPACKAGEABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>VSpec Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_RESOLUTION_FEATURE_COUNT = VPACKAGEABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cvl.impl.ChoiceResolutuionImpl <em>Choice Resolutuion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ChoiceResolutuionImpl
	 * @see cvl.impl.cvlPackageImpl#getChoiceResolutuion()
	 * @generated
	 */
	int CHOICE_RESOLUTUION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTUION__NAME = VSPEC_RESOLUTION__NAME;

	/**
	 * The feature id for the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTUION__RESOLVED_VSPEC = VSPEC_RESOLUTION__RESOLVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTUION__CHILD = VSPEC_RESOLUTION__CHILD;

	/**
	 * The feature id for the '<em><b>Resolved Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTUION__RESOLVED_CHOICE = VSPEC_RESOLUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Decision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTUION__DECISION = VSPEC_RESOLUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Choice Resolutuion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_RESOLUTUION_FEATURE_COUNT = VSPEC_RESOLUTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cvl.impl.VInstanceImpl <em>VInstance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VInstanceImpl
	 * @see cvl.impl.cvlPackageImpl#getVInstance()
	 * @generated
	 */
	int VINSTANCE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VINSTANCE__NAME = VSPEC_RESOLUTION__NAME;

	/**
	 * The feature id for the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VINSTANCE__RESOLVED_VSPEC = VSPEC_RESOLUTION__RESOLVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VINSTANCE__CHILD = VSPEC_RESOLUTION__CHILD;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VINSTANCE__TYPE = VSPEC_RESOLUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VInstance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VINSTANCE_FEATURE_COUNT = VSPEC_RESOLUTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.VariationPointImpl <em>Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VariationPointImpl
	 * @see cvl.impl.cvlPackageImpl#getVariationPoint()
	 * @generated
	 */
	int VARIATION_POINT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__NAME = VPACKAGEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__BINDING_VSPEC = VPACKAGEABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_FEATURE_COUNT = VPACKAGEABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.ChoiceVariationPointImpl <em>Choice Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ChoiceVariationPointImpl
	 * @see cvl.impl.cvlPackageImpl#getChoiceVariationPoint()
	 * @generated
	 */
	int CHOICE_VARIATION_POINT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_VARIATION_POINT__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_VARIATION_POINT__BINDING_VSPEC = VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_VARIATION_POINT__BINDING_CHOICE = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Choice Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_VARIATION_POINT_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.FragmentSubstitutionImpl <em>Fragment Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.FragmentSubstitutionImpl
	 * @see cvl.impl.cvlPackageImpl#getFragmentSubstitution()
	 * @generated
	 */
	int FRAGMENT_SUBSTITUTION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__NAME = CHOICE_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__BINDING_VSPEC = CHOICE_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__BINDING_CHOICE = CHOICE_VARIATION_POINT__BINDING_CHOICE;

	/**
	 * The feature id for the '<em><b>Binding Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__BINDING_CLASSIFIER = CHOICE_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Boundary Element Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING = CHOICE_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__PLACEMENT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Multi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__MULTI = CHOICE_VARIATION_POINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__REPLACEMENT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__SOURCE_OBJECT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Fragment Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION_FEATURE_COUNT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link cvl.impl.RepeatableVariationPointImpl <em>Repeatable Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.RepeatableVariationPointImpl
	 * @see cvl.impl.cvlPackageImpl#getRepeatableVariationPoint()
	 * @generated
	 */
	int REPEATABLE_VARIATION_POINT = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEATABLE_VARIATION_POINT__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEATABLE_VARIATION_POINT__BINDING_VSPEC = VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEATABLE_VARIATION_POINT__BINDING_CLASSIFIER = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Repeatable Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEATABLE_VARIATION_POINT_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.BoundaryElementBindingImpl <em>Boundary Element Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.BoundaryElementBindingImpl
	 * @see cvl.impl.cvlPackageImpl#getBoundaryElementBinding()
	 * @generated
	 */
	int BOUNDARY_ELEMENT_BINDING = 14;

	/**
	 * The number of structural features of the '<em>Boundary Element Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link cvl.impl.PlacementFragmentImpl <em>Placement Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.PlacementFragmentImpl
	 * @see cvl.impl.cvlPackageImpl#getPlacementFragment()
	 * @generated
	 */
	int PLACEMENT_FRAGMENT = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT__BINDING_VSPEC = VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Placement Boundary Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Placement Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.PlacementBoundaryElementImpl <em>Placement Boundary Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.PlacementBoundaryElementImpl
	 * @see cvl.impl.cvlPackageImpl#getPlacementBoundaryElement()
	 * @generated
	 */
	int PLACEMENT_BOUNDARY_ELEMENT = 16;

	/**
	 * The number of structural features of the '<em>Placement Boundary Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link cvl.impl.VariabletypeImpl <em>Variabletype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VariabletypeImpl
	 * @see cvl.impl.cvlPackageImpl#getVariabletype()
	 * @generated
	 */
	int VARIABLETYPE = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLETYPE__NAME = VPACKAGEABLE__NAME;

	/**
	 * The number of structural features of the '<em>Variabletype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLETYPE_FEATURE_COUNT = VPACKAGEABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cvl.impl.ReplacementFragmentTypeImpl <em>Replacement Fragment Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ReplacementFragmentTypeImpl
	 * @see cvl.impl.cvlPackageImpl#getReplacementFragmentType()
	 * @generated
	 */
	int REPLACEMENT_FRAGMENT_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_TYPE__NAME = VARIABLETYPE__NAME;

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
	 * The number of structural features of the '<em>Replacement Fragment Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_TYPE_FEATURE_COUNT = VARIABLETYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cvl.impl.ReplacementBoundaryElementImpl <em>Replacement Boundary Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ReplacementBoundaryElementImpl
	 * @see cvl.impl.cvlPackageImpl#getReplacementBoundaryElement()
	 * @generated
	 */
	int REPLACEMENT_BOUNDARY_ELEMENT = 19;

	/**
	 * The number of structural features of the '<em>Replacement Boundary Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link cvl.impl.ObjectSubstitutionImpl <em>Object Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ObjectSubstitutionImpl
	 * @see cvl.impl.cvlPackageImpl#getObjectSubstitution()
	 * @generated
	 */
	int OBJECT_SUBSTITUTION = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_SUBSTITUTION__NAME = CHOICE_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_SUBSTITUTION__BINDING_VSPEC = CHOICE_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_SUBSTITUTION__BINDING_CHOICE = CHOICE_VARIATION_POINT__BINDING_CHOICE;

	/**
	 * The feature id for the '<em><b>Placement Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_SUBSTITUTION__PLACEMENT_OBJECT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replacement Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_SUBSTITUTION__REPLACEMENT_OBJECT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_SUBSTITUTION_FEATURE_COUNT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cvl.impl.BaseModelHandleImpl <em>Base Model Handle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.BaseModelHandleImpl
	 * @see cvl.impl.cvlPackageImpl#getBaseModelHandle()
	 * @generated
	 */
	int BASE_MODEL_HANDLE = 22;

	/**
	 * The number of structural features of the '<em>Base Model Handle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL_HANDLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link cvl.impl.ObjectHandleImpl <em>Object Handle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ObjectHandleImpl
	 * @see cvl.impl.cvlPackageImpl#getObjectHandle()
	 * @generated
	 */
	int OBJECT_HANDLE = 21;

	/**
	 * The feature id for the '<em><b>MOF Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_HANDLE__MOF_REF = BASE_MODEL_HANDLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Handle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_HANDLE_FEATURE_COUNT = BASE_MODEL_HANDLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VariableImpl
	 * @see cvl.impl.cvlPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = VSPEC__NAME;

	/**
	 * The feature id for the '<em><b>Group Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__GROUP_MULTIPLICITY = VSPEC__GROUP_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Resolution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__RESOLUTION_TIME = VSPEC__RESOLUTION_TIME;

	/**
	 * The feature id for the '<em><b>Owned VSpec Derivation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__OWNED_VSPEC_DERIVATION = VSPEC__OWNED_VSPEC_DERIVATION;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__CHILD = VSPEC__CHILD;

	/**
	 * The feature id for the '<em><b>Replacement Fragment Typesubsetstype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__REPLACEMENT_FRAGMENT_TYPESUBSETSTYPE = VSPEC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Defaul Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__DEFAUL_VALUE = VSPEC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = VSPEC_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = VSPEC_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link cvl.impl.ValueSpecificationImpl <em>Value Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ValueSpecificationImpl
	 * @see cvl.impl.cvlPackageImpl#getValueSpecification()
	 * @generated
	 */
	int VALUE_SPECIFICATION = 24;

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
	 * The meta object id for the '{@link cvl.impl.VariableValueAssignmentImpl <em>Variable Value Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VariableValueAssignmentImpl
	 * @see cvl.impl.cvlPackageImpl#getVariableValueAssignment()
	 * @generated
	 */
	int VARIABLE_VALUE_ASSIGNMENT = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_VALUE_ASSIGNMENT__NAME = VSPEC_RESOLUTION__NAME;

	/**
	 * The feature id for the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_VALUE_ASSIGNMENT__RESOLVED_VSPEC = VSPEC_RESOLUTION__RESOLVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_VALUE_ASSIGNMENT__CHILD = VSPEC_RESOLUTION__CHILD;

	/**
	 * The feature id for the '<em><b>Resolved Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_VALUE_ASSIGNMENT__RESOLVED_VARIABLE = VSPEC_RESOLUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_VALUE_ASSIGNMENT__VALUE = VSPEC_RESOLUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Value Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_VALUE_ASSIGNMENT_FEATURE_COUNT = VSPEC_RESOLUTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cvl.impl.PrimitveTypeImpl <em>Primitve Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.PrimitveTypeImpl
	 * @see cvl.impl.cvlPackageImpl#getPrimitveType()
	 * @generated
	 */
	int PRIMITVE_TYPE = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITVE_TYPE__NAME = VARIABLETYPE__NAME;

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
	 * The meta object id for the '{@link cvl.impl.ObjectTypeImpl <em>Object Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ObjectTypeImpl
	 * @see cvl.impl.cvlPackageImpl#getObjectType()
	 * @generated
	 */
	int OBJECT_TYPE = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__NAME = VARIABLETYPE__NAME;

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
	 * The meta object id for the '{@link cvl.impl.VInterfaceImpl <em>VInterface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VInterfaceImpl
	 * @see cvl.impl.cvlPackageImpl#getVInterface()
	 * @generated
	 */
	int VINTERFACE = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VINTERFACE__NAME = VPACKAGEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VINTERFACE__MEMBER = VPACKAGEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VINTERFACE__OWNED_CONSTRAINT = VPACKAGEABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>VInterface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VINTERFACE_FEATURE_COUNT = VPACKAGEABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cvl.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ConstraintImpl
	 * @see cvl.impl.cvlPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = VPACKAGEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CONTEXT = VPACKAGEABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = VPACKAGEABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.SlotAssignmentImpl <em>Slot Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.SlotAssignmentImpl
	 * @see cvl.impl.cvlPackageImpl#getSlotAssignment()
	 * @generated
	 */
	int SLOT_ASSIGNMENT = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT__NAME = CHOICE_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT__BINDING_VSPEC = CHOICE_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_ASSIGNMENT__BINDING_CHOICE = CHOICE_VARIATION_POINT__BINDING_CHOICE;

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
	 * The meta object id for the '{@link cvl.impl.ObjectExistenceImpl <em>Object Existence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ObjectExistenceImpl
	 * @see cvl.impl.cvlPackageImpl#getObjectExistence()
	 * @generated
	 */
	int OBJECT_EXISTENCE = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXISTENCE__NAME = CHOICE_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXISTENCE__BINDING_VSPEC = CHOICE_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXISTENCE__BINDING_CHOICE = CHOICE_VARIATION_POINT__BINDING_CHOICE;

	/**
	 * The feature id for the '<em><b>Optional Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXISTENCE__OPTIONAL_OBJECT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Existence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXISTENCE_FEATURE_COUNT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.LinkEndSubstitutionImpl <em>Link End Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.LinkEndSubstitutionImpl
	 * @see cvl.impl.cvlPackageImpl#getLinkEndSubstitution()
	 * @generated
	 */
	int LINK_END_SUBSTITUTION = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_END_SUBSTITUTION__NAME = CHOICE_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_END_SUBSTITUTION__BINDING_VSPEC = CHOICE_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_END_SUBSTITUTION__BINDING_CHOICE = CHOICE_VARIATION_POINT__BINDING_CHOICE;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_END_SUBSTITUTION__LINK = CHOICE_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Link End Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER = CHOICE_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Replacement Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_END_SUBSTITUTION__REPLACEMENT_OBJECT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Link End Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_END_SUBSTITUTION_FEATURE_COUNT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link cvl.impl.LinkHandleImpl <em>Link Handle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.LinkHandleImpl
	 * @see cvl.impl.cvlPackageImpl#getLinkHandle()
	 * @generated
	 */
	int LINK_HANDLE = 33;

	/**
	 * The feature id for the '<em><b>MOF Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_HANDLE__MOF_REF = BASE_MODEL_HANDLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Link Handle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_HANDLE_FEATURE_COUNT = BASE_MODEL_HANDLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.CompositeVariationPointImpl <em>Composite Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.CompositeVariationPointImpl
	 * @see cvl.impl.cvlPackageImpl#getCompositeVariationPoint()
	 * @generated
	 */
	int COMPOSITE_VARIATION_POINT = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_VARIATION_POINT__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_VARIATION_POINT__BINDING_VSPEC = VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding CV Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_VARIATION_POINT__BINDING_CV_SPEC = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_VARIATION_POINT_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.ConfigurableUnitImpl <em>Configurable Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ConfigurableUnitImpl
	 * @see cvl.impl.cvlPackageImpl#getConfigurableUnit()
	 * @generated
	 */
	int CONFIGURABLE_UNIT = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT__NAME = COMPOSITE_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT__BINDING_VSPEC = COMPOSITE_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding CV Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT__BINDING_CV_SPEC = COMPOSITE_VARIATION_POINT__BINDING_CV_SPEC;

	/**
	 * The feature id for the '<em><b>Owned VSpec</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT__OWNED_VSPEC = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Variation Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT__OWNED_VARIATION_POINT = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT__OWNED_CONSTRAINT = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Configurable Container Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned VSpec Resolution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Unit Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT__UNIT_INTERFACE = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Owned VSpec Derivation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Owned Variabletype</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT__OWNED_VARIABLETYPE = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Configurable Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT_FEATURE_COUNT = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link cvl.impl.CVSpecImpl <em>CV Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.CVSpecImpl
	 * @see cvl.impl.cvlPackageImpl#getCVSpec()
	 * @generated
	 */
	int CV_SPEC = 36;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CV_SPEC__NAME = VSPEC__NAME;

	/**
	 * The feature id for the '<em><b>Group Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CV_SPEC__GROUP_MULTIPLICITY = VSPEC__GROUP_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Resolution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CV_SPEC__RESOLUTION_TIME = VSPEC__RESOLUTION_TIME;

	/**
	 * The feature id for the '<em><b>Owned VSpec Derivation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CV_SPEC__OWNED_VSPEC_DERIVATION = VSPEC__OWNED_VSPEC_DERIVATION;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CV_SPEC__CHILD = VSPEC__CHILD;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CV_SPEC__TYPE = VSPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CV Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CV_SPEC_FEATURE_COUNT = VSPEC_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.VConfigurationImpl <em>VConfiguration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VConfigurationImpl
	 * @see cvl.impl.cvlPackageImpl#getVConfiguration()
	 * @generated
	 */
	int VCONFIGURATION = 37;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCONFIGURATION__NAME = VSPEC_RESOLUTION__NAME;

	/**
	 * The feature id for the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCONFIGURATION__RESOLVED_VSPEC = VSPEC_RESOLUTION__RESOLVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCONFIGURATION__CHILD = VSPEC_RESOLUTION__CHILD;

	/**
	 * The feature id for the '<em><b>Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCONFIGURATION__MEMBER = VSPEC_RESOLUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Partial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCONFIGURATION__IS_PARTIAL = VSPEC_RESOLUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolved CV Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCONFIGURATION__RESOLVED_CV_SPEC = VSPEC_RESOLUTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>VConfiguration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCONFIGURATION_FEATURE_COUNT = VSPEC_RESOLUTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link cvl.impl.LinkExistenceImpl <em>Link Existence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.LinkExistenceImpl
	 * @see cvl.impl.cvlPackageImpl#getLinkExistence()
	 * @generated
	 */
	int LINK_EXISTENCE = 38;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EXISTENCE__NAME = CHOICE_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EXISTENCE__BINDING_VSPEC = CHOICE_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EXISTENCE__BINDING_CHOICE = CHOICE_VARIATION_POINT__BINDING_CHOICE;

	/**
	 * The feature id for the '<em><b>Optional Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EXISTENCE__OPTIONAL_LINK = CHOICE_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Link Existence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EXISTENCE_FEATURE_COUNT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.OpaqueVariationPointImpl <em>Opaque Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.OpaqueVariationPointImpl
	 * @see cvl.impl.cvlPackageImpl#getOpaqueVariationPoint()
	 * @generated
	 */
	int OPAQUE_VARIATION_POINT = 39;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT__BINDING_VSPEC = VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Place Holder</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT__PLACE_HOLDER = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT__SOURCE_OBJECT = VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT__TYPE = VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Opaque Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_VARIATION_POINT_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link cvl.impl.OVPTypeImpl <em>OVP Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.OVPTypeImpl
	 * @see cvl.impl.cvlPackageImpl#getOVPType()
	 * @generated
	 */
	int OVP_TYPE = 40;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVP_TYPE__NAME = VPACKAGEABLE__NAME;

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
	 * The meta object id for the '{@link cvl.impl.OVPSemanticSpecImpl <em>OVP Semantic Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.OVPSemanticSpecImpl
	 * @see cvl.impl.cvlPackageImpl#getOVPSemanticSpec()
	 * @generated
	 */
	int OVP_SEMANTIC_SPEC = 41;

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
	 * The meta object id for the '{@link cvl.impl.ObjectSpecificationImpl <em>Object Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ObjectSpecificationImpl
	 * @see cvl.impl.cvlPackageImpl#getObjectSpecification()
	 * @generated
	 */
	int OBJECT_SPECIFICATION = 42;

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
	 * The meta object id for the '{@link cvl.impl.ReplacementFragmentSpecificationImpl <em>Replacement Fragment Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ReplacementFragmentSpecificationImpl
	 * @see cvl.impl.cvlPackageImpl#getReplacementFragmentSpecification()
	 * @generated
	 */
	int REPLACEMENT_FRAGMENT_SPECIFICATION = 43;

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
	 * The meta object id for the '{@link cvl.impl.VPackageImpl <em>VPackage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VPackageImpl
	 * @see cvl.impl.cvlPackageImpl#getVPackage()
	 * @generated
	 */
	int VPACKAGE = 44;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPACKAGE__NAME = VPACKAGEABLE__NAME;

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
	 * The meta object id for the '{@link cvl.impl.ToBindingImpl <em>To Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ToBindingImpl
	 * @see cvl.impl.cvlPackageImpl#getToBinding()
	 * @generated
	 */
	int TO_BINDING = 45;

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
	 * The meta object id for the '{@link cvl.impl.ToPlacementImpl <em>To Placement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ToPlacementImpl
	 * @see cvl.impl.cvlPackageImpl#getToPlacement()
	 * @generated
	 */
	int TO_PLACEMENT = 46;

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
	 * The meta object id for the '{@link cvl.impl.ToReplacementImpl <em>To Replacement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ToReplacementImpl
	 * @see cvl.impl.cvlPackageImpl#getToReplacement()
	 * @generated
	 */
	int TO_REPLACEMENT = 47;

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
	 * The meta object id for the '{@link cvl.impl.FromBindingImpl <em>From Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.FromBindingImpl
	 * @see cvl.impl.cvlPackageImpl#getFromBinding()
	 * @generated
	 */
	int FROM_BINDING = 48;

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
	 * The meta object id for the '{@link cvl.impl.FromPlacementImpl <em>From Placement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.FromPlacementImpl
	 * @see cvl.impl.cvlPackageImpl#getFromPlacement()
	 * @generated
	 */
	int FROM_PLACEMENT = 49;

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
	 * The meta object id for the '{@link cvl.impl.FromReplacementImpl <em>From Replacement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.FromReplacementImpl
	 * @see cvl.impl.cvlPackageImpl#getFromReplacement()
	 * @generated
	 */
	int FROM_REPLACEMENT = 50;

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
	 * The meta object id for the '{@link cvl.impl.BCLExpressionImpl <em>BCL Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.BCLExpressionImpl
	 * @see cvl.impl.cvlPackageImpl#getBCLExpression()
	 * @generated
	 */
	int BCL_EXPRESSION = 52;

	/**
	 * The number of structural features of the '<em>BCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCL_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link cvl.impl.VSpecRefImpl <em>VSpec Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VSpecRefImpl
	 * @see cvl.impl.cvlPackageImpl#getVSpecRef()
	 * @generated
	 */
	int VSPEC_REF = 51;

	/**
	 * The feature id for the '<em><b>VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_REF__VSPEC = BCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VSpec Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSPEC_REF_FEATURE_COUNT = BCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.OpaqueConstraintImpl <em>Opaque Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.OpaqueConstraintImpl
	 * @see cvl.impl.cvlPackageImpl#getOpaqueConstraint()
	 * @generated
	 */
	int OPAQUE_CONSTRAINT = 53;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_CONSTRAINT__CONTEXT = CONSTRAINT__CONTEXT;

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
	 * The meta object id for the '{@link cvl.impl.ParametricVariationPointImpl <em>Parametric Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ParametricVariationPointImpl
	 * @see cvl.impl.cvlPackageImpl#getParametricVariationPoint()
	 * @generated
	 */
	int PARAMETRIC_VARIATION_POINT = 54;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_VARIATION_POINT__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_VARIATION_POINT__BINDING_VSPEC = VARIATION_POINT__BINDING_VSPEC;

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
	 * The meta object id for the '{@link cvl.impl.SlotValueExistenceImpl <em>Slot Value Existence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.SlotValueExistenceImpl
	 * @see cvl.impl.cvlPackageImpl#getSlotValueExistence()
	 * @generated
	 */
	int SLOT_VALUE_EXISTENCE = 55;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_VALUE_EXISTENCE__NAME = CHOICE_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_VALUE_EXISTENCE__BINDING_VSPEC = CHOICE_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_VALUE_EXISTENCE__BINDING_CHOICE = CHOICE_VARIATION_POINT__BINDING_CHOICE;

	/**
	 * The feature id for the '<em><b>Slot Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_VALUE_EXISTENCE__SLOT_IDENTIFIER = CHOICE_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Slot Owner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_VALUE_EXISTENCE__SLOT_OWNER = CHOICE_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Slot Value Existence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_VALUE_EXISTENCE_FEATURE_COUNT = CHOICE_VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cvl.impl.ParametricLinkEndSubstitutionImpl <em>Parametric Link End Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ParametricLinkEndSubstitutionImpl
	 * @see cvl.impl.cvlPackageImpl#getParametricLinkEndSubstitution()
	 * @generated
	 */
	int PARAMETRIC_LINK_END_SUBSTITUTION = 56;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_LINK_END_SUBSTITUTION__NAME = PARAMETRIC_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_LINK_END_SUBSTITUTION__BINDING_VSPEC = PARAMETRIC_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_LINK_END_SUBSTITUTION__BINDING_VARIABLE = PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE;

	/**
	 * The feature id for the '<em><b>Link End Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER = PARAMETRIC_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_LINK_END_SUBSTITUTION__LINK = PARAMETRIC_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parametric Link End Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_LINK_END_SUBSTITUTION_FEATURE_COUNT = PARAMETRIC_VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cvl.impl.ParametricObjectSubstitutionImpl <em>Parametric Object Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ParametricObjectSubstitutionImpl
	 * @see cvl.impl.cvlPackageImpl#getParametricObjectSubstitution()
	 * @generated
	 */
	int PARAMETRIC_OBJECT_SUBSTITUTION = 57;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_OBJECT_SUBSTITUTION__NAME = PARAMETRIC_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_OBJECT_SUBSTITUTION__BINDING_VSPEC = PARAMETRIC_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_OBJECT_SUBSTITUTION__BINDING_VARIABLE = PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE;

	/**
	 * The feature id for the '<em><b>Placement Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_OBJECT_SUBSTITUTION__PLACEMENT_OBJECT = PARAMETRIC_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parametric Object Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_OBJECT_SUBSTITUTION_FEATURE_COUNT = PARAMETRIC_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cvl.impl.ParametricSlotAssignmetImpl <em>Parametric Slot Assignmet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ParametricSlotAssignmetImpl
	 * @see cvl.impl.cvlPackageImpl#getParametricSlotAssignmet()
	 * @generated
	 */
	int PARAMETRIC_SLOT_ASSIGNMET = 58;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMET__NAME = PARAMETRIC_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMET__BINDING_VSPEC = PARAMETRIC_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMET__BINDING_VARIABLE = PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE;

	/**
	 * The feature id for the '<em><b>Slot Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMET__SLOT_IDENTIFIER = PARAMETRIC_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Slot Owner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMET__SLOT_OWNER = PARAMETRIC_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parametric Slot Assignmet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_SLOT_ASSIGNMET_FEATURE_COUNT = PARAMETRIC_VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cvl.impl.ChoiceDerivationImpl <em>Choice Derivation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ChoiceDerivationImpl
	 * @see cvl.impl.cvlPackageImpl#getChoiceDerivation()
	 * @generated
	 */
	int CHOICE_DERIVATION = 59;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_DERIVATION__NAME = VSPEC_DERIVATION__NAME;

	/**
	 * The feature id for the '<em><b>Derived VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_DERIVATION__DERIVED_VSPEC = VSPEC_DERIVATION__DERIVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Deriving Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_DERIVATION__DERIVING_CONSTRAINT = VSPEC_DERIVATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Derived Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_DERIVATION__DERIVED_CHOICE = VSPEC_DERIVATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Choice Derivation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_DERIVATION_FEATURE_COUNT = VSPEC_DERIVATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cvl.impl.VariableDerivationImpl <em>Variable Derivation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.VariableDerivationImpl
	 * @see cvl.impl.cvlPackageImpl#getVariableDerivation()
	 * @generated
	 */
	int VARIABLE_DERIVATION = 60;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DERIVATION__NAME = VSPEC_DERIVATION__NAME;

	/**
	 * The feature id for the '<em><b>Derived VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DERIVATION__DERIVED_VSPEC = VSPEC_DERIVATION__DERIVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Deriving Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DERIVATION__DERIVING_EXPRESSION = VSPEC_DERIVATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Derived Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DERIVATION__DERIVED_VARIABLE = VSPEC_DERIVATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Derivation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DERIVATION_FEATURE_COUNT = VSPEC_DERIVATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cvl.impl.CVSpecDerivationImpl <em>CV Spec Derivation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.CVSpecDerivationImpl
	 * @see cvl.impl.cvlPackageImpl#getCVSpecDerivation()
	 * @generated
	 */
	int CV_SPEC_DERIVATION = 61;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CV_SPEC_DERIVATION__NAME = VSPEC_DERIVATION__NAME;

	/**
	 * The feature id for the '<em><b>Derived VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CV_SPEC_DERIVATION__DERIVED_VSPEC = VSPEC_DERIVATION__DERIVED_VSPEC;

	/**
	 * The feature id for the '<em><b>Member Derivation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CV_SPEC_DERIVATION__MEMBER_DERIVATION = VSPEC_DERIVATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deriving CVspec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CV_SPEC_DERIVATION__DERIVING_CVSPEC = VSPEC_DERIVATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Derived CV Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CV_SPEC_DERIVATION__DERIVED_CV_SPEC = VSPEC_DERIVATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CV Spec Derivation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CV_SPEC_DERIVATION_FEATURE_COUNT = VSPEC_DERIVATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link cvl.impl.ConfigurableUnitUsageImpl <em>Configurable Unit Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.ConfigurableUnitUsageImpl
	 * @see cvl.impl.cvlPackageImpl#getConfigurableUnitUsage()
	 * @generated
	 */
	int CONFIGURABLE_UNIT_USAGE = 62;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT_USAGE__NAME = COMPOSITE_VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT_USAGE__BINDING_VSPEC = COMPOSITE_VARIATION_POINT__BINDING_VSPEC;

	/**
	 * The feature id for the '<em><b>Binding CV Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT_USAGE__BINDING_CV_SPEC = COMPOSITE_VARIATION_POINT__BINDING_CV_SPEC;

	/**
	 * The feature id for the '<em><b>Used Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT_USAGE__USED_UNIT = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usage Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT_USAGE__USAGE_REFERENCE = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Link End Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT_USAGE__LINK_END_IDENTIFIER = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Unit Usage Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT_USAGE__UNIT_USAGE_INTERFACE = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Configurable Unit Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_UNIT_USAGE_FEATURE_COUNT = COMPOSITE_VARIATION_POINT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link cvl.impl.PrimitiveValueSpecificationImpl <em>Primitive Value Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.PrimitiveValueSpecificationImpl
	 * @see cvl.impl.cvlPackageImpl#getPrimitiveValueSpecification()
	 * @generated
	 */
	int PRIMITIVE_VALUE_SPECIFICATION = 63;

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
	 * The meta object id for the '{@link cvl.impl.BCLConstraintImpl <em>BCL Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.BCLConstraintImpl
	 * @see cvl.impl.cvlPackageImpl#getBCLConstraint()
	 * @generated
	 */
	int BCL_CONSTRAINT = 64;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCL_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCL_CONSTRAINT__CONTEXT = CONSTRAINT__CONTEXT;

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
	 * The meta object id for the '{@link cvl.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.OperationCallExpImpl
	 * @see cvl.impl.cvlPackageImpl#getOperationCallExp()
	 * @generated
	 */
	int OPERATION_CALL_EXP = 65;

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
	 * The meta object id for the '{@link cvl.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.BooleanLiteralExpImpl
	 * @see cvl.impl.cvlPackageImpl#getBooleanLiteralExp()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP = 66;

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
	 * The meta object id for the '{@link cvl.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.StringLiteralExpImpl
	 * @see cvl.impl.cvlPackageImpl#getStringLiteralExp()
	 * @generated
	 */
	int STRING_LITERAL_EXP = 67;

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
	 * The meta object id for the '{@link cvl.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.NumericLiteralExpImpl
	 * @see cvl.impl.cvlPackageImpl#getNumericLiteralExp()
	 * @generated
	 */
	int NUMERIC_LITERAL_EXP = 68;

	/**
	 * The number of structural features of the '<em>Numeric Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP_FEATURE_COUNT = BCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cvl.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.IntegerLiteralExpImpl
	 * @see cvl.impl.cvlPackageImpl#getIntegerLiteralExp()
	 * @generated
	 */
	int INTEGER_LITERAL_EXP = 69;

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
	 * The meta object id for the '{@link cvl.impl.UnlimitedLiteralExpImpl <em>Unlimited Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.UnlimitedLiteralExpImpl
	 * @see cvl.impl.cvlPackageImpl#getUnlimitedLiteralExp()
	 * @generated
	 */
	int UNLIMITED_LITERAL_EXP = 70;

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
	 * The meta object id for the '{@link cvl.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.impl.RealLiteralExpImpl
	 * @see cvl.impl.cvlPackageImpl#getRealLiteralExp()
	 * @generated
	 */
	int REAL_LITERAL_EXP = 71;

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
	 * The meta object id for the '{@link cvl.PrimitiveTypeEnum <em>Primitive Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.PrimitiveTypeEnum
	 * @see cvl.impl.cvlPackageImpl#getPrimitiveTypeEnum()
	 * @generated
	 */
	int PRIMITIVE_TYPE_ENUM = 72;

	/**
	 * The meta object id for the '{@link cvl.Operation <em>Operation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cvl.Operation
	 * @see cvl.impl.cvlPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 73;


	/**
	 * Returns the meta object for class '{@link cvl.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see cvl.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for the attribute '{@link cvl.Choice#isDefaultResolution <em>Default Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Resolution</em>'.
	 * @see cvl.Choice#isDefaultResolution()
	 * @see #getChoice()
	 * @generated
	 */
	EAttribute getChoice_DefaultResolution();

	/**
	 * Returns the meta object for the attribute '{@link cvl.Choice#isIsImpliedByParent <em>Is Implied By Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Implied By Parent</em>'.
	 * @see cvl.Choice#isIsImpliedByParent()
	 * @see #getChoice()
	 * @generated
	 */
	EAttribute getChoice_IsImpliedByParent();

	/**
	 * Returns the meta object for class '{@link cvl.VSpec <em>VSpec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VSpec</em>'.
	 * @see cvl.VSpec
	 * @generated
	 */
	EClass getVSpec();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.VSpec#getGroupMultiplicity <em>Group Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Group Multiplicity</em>'.
	 * @see cvl.VSpec#getGroupMultiplicity()
	 * @see #getVSpec()
	 * @generated
	 */
	EReference getVSpec_GroupMultiplicity();

	/**
	 * Returns the meta object for the attribute '{@link cvl.VSpec#getResolutionTime <em>Resolution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolution Time</em>'.
	 * @see cvl.VSpec#getResolutionTime()
	 * @see #getVSpec()
	 * @generated
	 */
	EAttribute getVSpec_ResolutionTime();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.VSpec#getOwnedVSpecDerivation <em>Owned VSpec Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned VSpec Derivation</em>'.
	 * @see cvl.VSpec#getOwnedVSpecDerivation()
	 * @see #getVSpec()
	 * @generated
	 */
	EReference getVSpec_OwnedVSpecDerivation();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.VSpec#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child</em>'.
	 * @see cvl.VSpec#getChild()
	 * @see #getVSpec()
	 * @generated
	 */
	EReference getVSpec_Child();

	/**
	 * Returns the meta object for class '{@link cvl.VPackageable <em>VPackageable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VPackageable</em>'.
	 * @see cvl.VPackageable
	 * @generated
	 */
	EClass getVPackageable();

	/**
	 * Returns the meta object for class '{@link cvl.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see cvl.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link cvl.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cvl.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link cvl.MultiplicityInterval <em>Multiplicity Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity Interval</em>'.
	 * @see cvl.MultiplicityInterval
	 * @generated
	 */
	EClass getMultiplicityInterval();

	/**
	 * Returns the meta object for the attribute '{@link cvl.MultiplicityInterval#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see cvl.MultiplicityInterval#getUpper()
	 * @see #getMultiplicityInterval()
	 * @generated
	 */
	EAttribute getMultiplicityInterval_Upper();

	/**
	 * Returns the meta object for the attribute '{@link cvl.MultiplicityInterval#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see cvl.MultiplicityInterval#getLower()
	 * @see #getMultiplicityInterval()
	 * @generated
	 */
	EAttribute getMultiplicityInterval_Lower();

	/**
	 * Returns the meta object for class '{@link cvl.VSpecDerivation <em>VSpec Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VSpec Derivation</em>'.
	 * @see cvl.VSpecDerivation
	 * @generated
	 */
	EClass getVSpecDerivation();

	/**
	 * Returns the meta object for the reference '{@link cvl.VSpecDerivation#getDerivedVSpec <em>Derived VSpec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Derived VSpec</em>'.
	 * @see cvl.VSpecDerivation#getDerivedVSpec()
	 * @see #getVSpecDerivation()
	 * @generated
	 */
	EReference getVSpecDerivation_DerivedVSpec();

	/**
	 * Returns the meta object for class '{@link cvl.VClassifier <em>VClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VClassifier</em>'.
	 * @see cvl.VClassifier
	 * @generated
	 */
	EClass getVClassifier();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.VClassifier#getInstanceMultiplicity <em>Instance Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Instance Multiplicity</em>'.
	 * @see cvl.VClassifier#getInstanceMultiplicity()
	 * @see #getVClassifier()
	 * @generated
	 */
	EReference getVClassifier_InstanceMultiplicity();

	/**
	 * Returns the meta object for class '{@link cvl.VSpecResolution <em>VSpec Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VSpec Resolution</em>'.
	 * @see cvl.VSpecResolution
	 * @generated
	 */
	EClass getVSpecResolution();

	/**
	 * Returns the meta object for the reference '{@link cvl.VSpecResolution#getResolvedVSpec <em>Resolved VSpec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved VSpec</em>'.
	 * @see cvl.VSpecResolution#getResolvedVSpec()
	 * @see #getVSpecResolution()
	 * @generated
	 */
	EReference getVSpecResolution_ResolvedVSpec();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.VSpecResolution#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child</em>'.
	 * @see cvl.VSpecResolution#getChild()
	 * @see #getVSpecResolution()
	 * @generated
	 */
	EReference getVSpecResolution_Child();

	/**
	 * Returns the meta object for class '{@link cvl.ChoiceResolutuion <em>Choice Resolutuion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice Resolutuion</em>'.
	 * @see cvl.ChoiceResolutuion
	 * @generated
	 */
	EClass getChoiceResolutuion();

	/**
	 * Returns the meta object for the reference '{@link cvl.ChoiceResolutuion#getResolvedChoice <em>Resolved Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved Choice</em>'.
	 * @see cvl.ChoiceResolutuion#getResolvedChoice()
	 * @see #getChoiceResolutuion()
	 * @generated
	 */
	EReference getChoiceResolutuion_ResolvedChoice();

	/**
	 * Returns the meta object for the attribute '{@link cvl.ChoiceResolutuion#isDecision <em>Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decision</em>'.
	 * @see cvl.ChoiceResolutuion#isDecision()
	 * @see #getChoiceResolutuion()
	 * @generated
	 */
	EAttribute getChoiceResolutuion_Decision();

	/**
	 * Returns the meta object for class '{@link cvl.VInstance <em>VInstance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VInstance</em>'.
	 * @see cvl.VInstance
	 * @generated
	 */
	EClass getVInstance();

	/**
	 * Returns the meta object for the reference '{@link cvl.VInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see cvl.VInstance#getType()
	 * @see #getVInstance()
	 * @generated
	 */
	EReference getVInstance_Type();

	/**
	 * Returns the meta object for class '{@link cvl.VariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variation Point</em>'.
	 * @see cvl.VariationPoint
	 * @generated
	 */
	EClass getVariationPoint();

	/**
	 * Returns the meta object for the reference '{@link cvl.VariationPoint#getBindingVSpec <em>Binding VSpec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding VSpec</em>'.
	 * @see cvl.VariationPoint#getBindingVSpec()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_BindingVSpec();

	/**
	 * Returns the meta object for class '{@link cvl.FragmentSubstitution <em>Fragment Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment Substitution</em>'.
	 * @see cvl.FragmentSubstitution
	 * @generated
	 */
	EClass getFragmentSubstitution();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.FragmentSubstitution#getBoundaryElementBinding <em>Boundary Element Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Boundary Element Binding</em>'.
	 * @see cvl.FragmentSubstitution#getBoundaryElementBinding()
	 * @see #getFragmentSubstitution()
	 * @generated
	 */
	EReference getFragmentSubstitution_BoundaryElementBinding();

	/**
	 * Returns the meta object for the reference '{@link cvl.FragmentSubstitution#getPlacement <em>Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Placement</em>'.
	 * @see cvl.FragmentSubstitution#getPlacement()
	 * @see #getFragmentSubstitution()
	 * @generated
	 */
	EReference getFragmentSubstitution_Placement();

	/**
	 * Returns the meta object for the attribute '{@link cvl.FragmentSubstitution#isMulti <em>Multi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi</em>'.
	 * @see cvl.FragmentSubstitution#isMulti()
	 * @see #getFragmentSubstitution()
	 * @generated
	 */
	EAttribute getFragmentSubstitution_Multi();

	/**
	 * Returns the meta object for the reference '{@link cvl.FragmentSubstitution#getReplacement <em>Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Replacement</em>'.
	 * @see cvl.FragmentSubstitution#getReplacement()
	 * @see #getFragmentSubstitution()
	 * @generated
	 */
	EReference getFragmentSubstitution_Replacement();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.FragmentSubstitution#getSourceObject <em>Source Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Object</em>'.
	 * @see cvl.FragmentSubstitution#getSourceObject()
	 * @see #getFragmentSubstitution()
	 * @generated
	 */
	EReference getFragmentSubstitution_SourceObject();

	/**
	 * Returns the meta object for class '{@link cvl.ChoiceVariationPoint <em>Choice Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice Variation Point</em>'.
	 * @see cvl.ChoiceVariationPoint
	 * @generated
	 */
	EClass getChoiceVariationPoint();

	/**
	 * Returns the meta object for the reference '{@link cvl.ChoiceVariationPoint#getBindingChoice <em>Binding Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding Choice</em>'.
	 * @see cvl.ChoiceVariationPoint#getBindingChoice()
	 * @see #getChoiceVariationPoint()
	 * @generated
	 */
	EReference getChoiceVariationPoint_BindingChoice();

	/**
	 * Returns the meta object for class '{@link cvl.RepeatableVariationPoint <em>Repeatable Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repeatable Variation Point</em>'.
	 * @see cvl.RepeatableVariationPoint
	 * @generated
	 */
	EClass getRepeatableVariationPoint();

	/**
	 * Returns the meta object for the reference '{@link cvl.RepeatableVariationPoint#getBindingClassifier <em>Binding Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding Classifier</em>'.
	 * @see cvl.RepeatableVariationPoint#getBindingClassifier()
	 * @see #getRepeatableVariationPoint()
	 * @generated
	 */
	EReference getRepeatableVariationPoint_BindingClassifier();

	/**
	 * Returns the meta object for class '{@link cvl.BoundaryElementBinding <em>Boundary Element Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boundary Element Binding</em>'.
	 * @see cvl.BoundaryElementBinding
	 * @generated
	 */
	EClass getBoundaryElementBinding();

	/**
	 * Returns the meta object for class '{@link cvl.PlacementFragment <em>Placement Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placement Fragment</em>'.
	 * @see cvl.PlacementFragment
	 * @generated
	 */
	EClass getPlacementFragment();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.PlacementFragment#getPlacementBoundaryElement <em>Placement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Placement Boundary Element</em>'.
	 * @see cvl.PlacementFragment#getPlacementBoundaryElement()
	 * @see #getPlacementFragment()
	 * @generated
	 */
	EReference getPlacementFragment_PlacementBoundaryElement();

	/**
	 * Returns the meta object for class '{@link cvl.PlacementBoundaryElement <em>Placement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placement Boundary Element</em>'.
	 * @see cvl.PlacementBoundaryElement
	 * @generated
	 */
	EClass getPlacementBoundaryElement();

	/**
	 * Returns the meta object for class '{@link cvl.ReplacementFragmentType <em>Replacement Fragment Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Fragment Type</em>'.
	 * @see cvl.ReplacementFragmentType
	 * @generated
	 */
	EClass getReplacementFragmentType();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.ReplacementFragmentType#getReplacementBoundaryElement <em>Replacement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Replacement Boundary Element</em>'.
	 * @see cvl.ReplacementFragmentType#getReplacementBoundaryElement()
	 * @see #getReplacementFragmentType()
	 * @generated
	 */
	EReference getReplacementFragmentType_ReplacementBoundaryElement();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.ReplacementFragmentType#getPlacementFragment <em>Placement Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Placement Fragment</em>'.
	 * @see cvl.ReplacementFragmentType#getPlacementFragment()
	 * @see #getReplacementFragmentType()
	 * @generated
	 */
	EReference getReplacementFragmentType_PlacementFragment();

	/**
	 * Returns the meta object for class '{@link cvl.Variabletype <em>Variabletype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variabletype</em>'.
	 * @see cvl.Variabletype
	 * @generated
	 */
	EClass getVariabletype();

	/**
	 * Returns the meta object for class '{@link cvl.ReplacementBoundaryElement <em>Replacement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Boundary Element</em>'.
	 * @see cvl.ReplacementBoundaryElement
	 * @generated
	 */
	EClass getReplacementBoundaryElement();

	/**
	 * Returns the meta object for class '{@link cvl.ObjectSubstitution <em>Object Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Substitution</em>'.
	 * @see cvl.ObjectSubstitution
	 * @generated
	 */
	EClass getObjectSubstitution();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.ObjectSubstitution#getPlacementObject <em>Placement Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Placement Object</em>'.
	 * @see cvl.ObjectSubstitution#getPlacementObject()
	 * @see #getObjectSubstitution()
	 * @generated
	 */
	EReference getObjectSubstitution_PlacementObject();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.ObjectSubstitution#getReplacementObject <em>Replacement Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Replacement Object</em>'.
	 * @see cvl.ObjectSubstitution#getReplacementObject()
	 * @see #getObjectSubstitution()
	 * @generated
	 */
	EReference getObjectSubstitution_ReplacementObject();

	/**
	 * Returns the meta object for class '{@link cvl.ObjectHandle <em>Object Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Handle</em>'.
	 * @see cvl.ObjectHandle
	 * @generated
	 */
	EClass getObjectHandle();

	/**
	 * Returns the meta object for the reference '{@link cvl.ObjectHandle#getMOFRef <em>MOF Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>MOF Ref</em>'.
	 * @see cvl.ObjectHandle#getMOFRef()
	 * @see #getObjectHandle()
	 * @generated
	 */
	EReference getObjectHandle_MOFRef();

	/**
	 * Returns the meta object for class '{@link cvl.BaseModelHandle <em>Base Model Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Model Handle</em>'.
	 * @see cvl.BaseModelHandle
	 * @generated
	 */
	EClass getBaseModelHandle();

	/**
	 * Returns the meta object for class '{@link cvl.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see cvl.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the reference '{@link cvl.Variable#getReplacementFragmentTypesubsetstype <em>Replacement Fragment Typesubsetstype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Replacement Fragment Typesubsetstype</em>'.
	 * @see cvl.Variable#getReplacementFragmentTypesubsetstype()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_ReplacementFragmentTypesubsetstype();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.Variable#getDefaulValue <em>Defaul Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Defaul Value</em>'.
	 * @see cvl.Variable#getDefaulValue()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_DefaulValue();

	/**
	 * Returns the meta object for the reference '{@link cvl.Variable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see cvl.Variable#getType()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Type();

	/**
	 * Returns the meta object for class '{@link cvl.ValueSpecification <em>Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Specification</em>'.
	 * @see cvl.ValueSpecification
	 * @generated
	 */
	EClass getValueSpecification();

	/**
	 * Returns the meta object for the reference '{@link cvl.ValueSpecification#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see cvl.ValueSpecification#getType()
	 * @see #getValueSpecification()
	 * @generated
	 */
	EReference getValueSpecification_Type();

	/**
	 * Returns the meta object for class '{@link cvl.VariableValueAssignment <em>Variable Value Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Value Assignment</em>'.
	 * @see cvl.VariableValueAssignment
	 * @generated
	 */
	EClass getVariableValueAssignment();

	/**
	 * Returns the meta object for the reference '{@link cvl.VariableValueAssignment#getResolvedVariable <em>Resolved Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved Variable</em>'.
	 * @see cvl.VariableValueAssignment#getResolvedVariable()
	 * @see #getVariableValueAssignment()
	 * @generated
	 */
	EReference getVariableValueAssignment_ResolvedVariable();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.VariableValueAssignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see cvl.VariableValueAssignment#getValue()
	 * @see #getVariableValueAssignment()
	 * @generated
	 */
	EReference getVariableValueAssignment_Value();

	/**
	 * Returns the meta object for class '{@link cvl.PrimitveType <em>Primitve Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitve Type</em>'.
	 * @see cvl.PrimitveType
	 * @generated
	 */
	EClass getPrimitveType();

	/**
	 * Returns the meta object for the attribute '{@link cvl.PrimitveType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see cvl.PrimitveType#getType()
	 * @see #getPrimitveType()
	 * @generated
	 */
	EAttribute getPrimitveType_Type();

	/**
	 * Returns the meta object for class '{@link cvl.ObjectType <em>Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Type</em>'.
	 * @see cvl.ObjectType
	 * @generated
	 */
	EClass getObjectType();

	/**
	 * Returns the meta object for the attribute '{@link cvl.ObjectType#getMetaClass <em>Meta Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Class</em>'.
	 * @see cvl.ObjectType#getMetaClass()
	 * @see #getObjectType()
	 * @generated
	 */
	EAttribute getObjectType_MetaClass();

	/**
	 * Returns the meta object for class '{@link cvl.VInterface <em>VInterface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VInterface</em>'.
	 * @see cvl.VInterface
	 * @generated
	 */
	EClass getVInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.VInterface#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Member</em>'.
	 * @see cvl.VInterface#getMember()
	 * @see #getVInterface()
	 * @generated
	 */
	EReference getVInterface_Member();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.VInterface#getOwnedConstraint <em>Owned Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Constraint</em>'.
	 * @see cvl.VInterface#getOwnedConstraint()
	 * @see #getVInterface()
	 * @generated
	 */
	EReference getVInterface_OwnedConstraint();

	/**
	 * Returns the meta object for class '{@link cvl.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see cvl.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the reference '{@link cvl.Constraint#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see cvl.Constraint#getContext()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Context();

	/**
	 * Returns the meta object for class '{@link cvl.SlotAssignment <em>Slot Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slot Assignment</em>'.
	 * @see cvl.SlotAssignment
	 * @generated
	 */
	EClass getSlotAssignment();

	/**
	 * Returns the meta object for the attribute '{@link cvl.SlotAssignment#getSlotIdentifier <em>Slot Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slot Identifier</em>'.
	 * @see cvl.SlotAssignment#getSlotIdentifier()
	 * @see #getSlotAssignment()
	 * @generated
	 */
	EAttribute getSlotAssignment_SlotIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.SlotAssignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see cvl.SlotAssignment#getValue()
	 * @see #getSlotAssignment()
	 * @generated
	 */
	EReference getSlotAssignment_Value();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.SlotAssignment#getSlotOwner <em>Slot Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Slot Owner</em>'.
	 * @see cvl.SlotAssignment#getSlotOwner()
	 * @see #getSlotAssignment()
	 * @generated
	 */
	EReference getSlotAssignment_SlotOwner();

	/**
	 * Returns the meta object for class '{@link cvl.ObjectExistence <em>Object Existence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Existence</em>'.
	 * @see cvl.ObjectExistence
	 * @generated
	 */
	EClass getObjectExistence();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.ObjectExistence#getOptionalObject <em>Optional Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Optional Object</em>'.
	 * @see cvl.ObjectExistence#getOptionalObject()
	 * @see #getObjectExistence()
	 * @generated
	 */
	EReference getObjectExistence_OptionalObject();

	/**
	 * Returns the meta object for class '{@link cvl.LinkEndSubstitution <em>Link End Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link End Substitution</em>'.
	 * @see cvl.LinkEndSubstitution
	 * @generated
	 */
	EClass getLinkEndSubstitution();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.LinkEndSubstitution#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link</em>'.
	 * @see cvl.LinkEndSubstitution#getLink()
	 * @see #getLinkEndSubstitution()
	 * @generated
	 */
	EReference getLinkEndSubstitution_Link();

	/**
	 * Returns the meta object for the attribute '{@link cvl.LinkEndSubstitution#getLinkEndIdentifier <em>Link End Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link End Identifier</em>'.
	 * @see cvl.LinkEndSubstitution#getLinkEndIdentifier()
	 * @see #getLinkEndSubstitution()
	 * @generated
	 */
	EAttribute getLinkEndSubstitution_LinkEndIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.LinkEndSubstitution#getReplacementObject <em>Replacement Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Replacement Object</em>'.
	 * @see cvl.LinkEndSubstitution#getReplacementObject()
	 * @see #getLinkEndSubstitution()
	 * @generated
	 */
	EReference getLinkEndSubstitution_ReplacementObject();

	/**
	 * Returns the meta object for class '{@link cvl.LinkHandle <em>Link Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Handle</em>'.
	 * @see cvl.LinkHandle
	 * @generated
	 */
	EClass getLinkHandle();

	/**
	 * Returns the meta object for the attribute '{@link cvl.LinkHandle#getMOFRef <em>MOF Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>MOF Ref</em>'.
	 * @see cvl.LinkHandle#getMOFRef()
	 * @see #getLinkHandle()
	 * @generated
	 */
	EAttribute getLinkHandle_MOFRef();

	/**
	 * Returns the meta object for class '{@link cvl.ConfigurableUnit <em>Configurable Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configurable Unit</em>'.
	 * @see cvl.ConfigurableUnit
	 * @generated
	 */
	EClass getConfigurableUnit();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.ConfigurableUnit#getOwnedVSpec <em>Owned VSpec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned VSpec</em>'.
	 * @see cvl.ConfigurableUnit#getOwnedVSpec()
	 * @see #getConfigurableUnit()
	 * @generated
	 */
	EReference getConfigurableUnit_OwnedVSpec();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.ConfigurableUnit#getOwnedVariationPoint <em>Owned Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Variation Point</em>'.
	 * @see cvl.ConfigurableUnit#getOwnedVariationPoint()
	 * @see #getConfigurableUnit()
	 * @generated
	 */
	EReference getConfigurableUnit_OwnedVariationPoint();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.ConfigurableUnit#getOwnedConstraint <em>Owned Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Constraint</em>'.
	 * @see cvl.ConfigurableUnit#getOwnedConstraint()
	 * @see #getConfigurableUnit()
	 * @generated
	 */
	EReference getConfigurableUnit_OwnedConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.ConfigurableUnit#getConfigurableContainerObject <em>Configurable Container Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configurable Container Object</em>'.
	 * @see cvl.ConfigurableUnit#getConfigurableContainerObject()
	 * @see #getConfigurableUnit()
	 * @generated
	 */
	EReference getConfigurableUnit_ConfigurableContainerObject();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.ConfigurableUnit#getOwnedVSpecResolution <em>Owned VSpec Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned VSpec Resolution</em>'.
	 * @see cvl.ConfigurableUnit#getOwnedVSpecResolution()
	 * @see #getConfigurableUnit()
	 * @generated
	 */
	EReference getConfigurableUnit_OwnedVSpecResolution();

	/**
	 * Returns the meta object for the reference '{@link cvl.ConfigurableUnit#getUnitInterface <em>Unit Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unit Interface</em>'.
	 * @see cvl.ConfigurableUnit#getUnitInterface()
	 * @see #getConfigurableUnit()
	 * @generated
	 */
	EReference getConfigurableUnit_UnitInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.ConfigurableUnit#getOwnedVSpecDerivation <em>Owned VSpec Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned VSpec Derivation</em>'.
	 * @see cvl.ConfigurableUnit#getOwnedVSpecDerivation()
	 * @see #getConfigurableUnit()
	 * @generated
	 */
	EReference getConfigurableUnit_OwnedVSpecDerivation();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.ConfigurableUnit#getOwnedVariabletype <em>Owned Variabletype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Variabletype</em>'.
	 * @see cvl.ConfigurableUnit#getOwnedVariabletype()
	 * @see #getConfigurableUnit()
	 * @generated
	 */
	EReference getConfigurableUnit_OwnedVariabletype();

	/**
	 * Returns the meta object for class '{@link cvl.CompositeVariationPoint <em>Composite Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Variation Point</em>'.
	 * @see cvl.CompositeVariationPoint
	 * @generated
	 */
	EClass getCompositeVariationPoint();

	/**
	 * Returns the meta object for the reference '{@link cvl.CompositeVariationPoint#getBindingCVSpec <em>Binding CV Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding CV Spec</em>'.
	 * @see cvl.CompositeVariationPoint#getBindingCVSpec()
	 * @see #getCompositeVariationPoint()
	 * @generated
	 */
	EReference getCompositeVariationPoint_BindingCVSpec();

	/**
	 * Returns the meta object for class '{@link cvl.CVSpec <em>CV Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CV Spec</em>'.
	 * @see cvl.CVSpec
	 * @generated
	 */
	EClass getCVSpec();

	/**
	 * Returns the meta object for the reference '{@link cvl.CVSpec#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see cvl.CVSpec#getType()
	 * @see #getCVSpec()
	 * @generated
	 */
	EReference getCVSpec_Type();

	/**
	 * Returns the meta object for class '{@link cvl.VConfiguration <em>VConfiguration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VConfiguration</em>'.
	 * @see cvl.VConfiguration
	 * @generated
	 */
	EClass getVConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.VConfiguration#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Member</em>'.
	 * @see cvl.VConfiguration#getMember()
	 * @see #getVConfiguration()
	 * @generated
	 */
	EReference getVConfiguration_Member();

	/**
	 * Returns the meta object for the attribute '{@link cvl.VConfiguration#isIsPartial <em>Is Partial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Partial</em>'.
	 * @see cvl.VConfiguration#isIsPartial()
	 * @see #getVConfiguration()
	 * @generated
	 */
	EAttribute getVConfiguration_IsPartial();

	/**
	 * Returns the meta object for the reference '{@link cvl.VConfiguration#getResolvedCVSpec <em>Resolved CV Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved CV Spec</em>'.
	 * @see cvl.VConfiguration#getResolvedCVSpec()
	 * @see #getVConfiguration()
	 * @generated
	 */
	EReference getVConfiguration_ResolvedCVSpec();

	/**
	 * Returns the meta object for class '{@link cvl.LinkExistence <em>Link Existence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Existence</em>'.
	 * @see cvl.LinkExistence
	 * @generated
	 */
	EClass getLinkExistence();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.LinkExistence#getOptionalLink <em>Optional Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Optional Link</em>'.
	 * @see cvl.LinkExistence#getOptionalLink()
	 * @see #getLinkExistence()
	 * @generated
	 */
	EReference getLinkExistence_OptionalLink();

	/**
	 * Returns the meta object for class '{@link cvl.OpaqueVariationPoint <em>Opaque Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opaque Variation Point</em>'.
	 * @see cvl.OpaqueVariationPoint
	 * @generated
	 */
	EClass getOpaqueVariationPoint();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.OpaqueVariationPoint#getPlaceHolder <em>Place Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Place Holder</em>'.
	 * @see cvl.OpaqueVariationPoint#getPlaceHolder()
	 * @see #getOpaqueVariationPoint()
	 * @generated
	 */
	EReference getOpaqueVariationPoint_PlaceHolder();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.OpaqueVariationPoint#getSourceObject <em>Source Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Object</em>'.
	 * @see cvl.OpaqueVariationPoint#getSourceObject()
	 * @see #getOpaqueVariationPoint()
	 * @generated
	 */
	EReference getOpaqueVariationPoint_SourceObject();

	/**
	 * Returns the meta object for the reference '{@link cvl.OpaqueVariationPoint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see cvl.OpaqueVariationPoint#getType()
	 * @see #getOpaqueVariationPoint()
	 * @generated
	 */
	EReference getOpaqueVariationPoint_Type();

	/**
	 * Returns the meta object for class '{@link cvl.OVPType <em>OVP Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OVP Type</em>'.
	 * @see cvl.OVPType
	 * @generated
	 */
	EClass getOVPType();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.OVPType#getSpec <em>Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Spec</em>'.
	 * @see cvl.OVPType#getSpec()
	 * @see #getOVPType()
	 * @generated
	 */
	EReference getOVPType_Spec();

	/**
	 * Returns the meta object for class '{@link cvl.OVPSemanticSpec <em>OVP Semantic Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OVP Semantic Spec</em>'.
	 * @see cvl.OVPSemanticSpec
	 * @generated
	 */
	EClass getOVPSemanticSpec();

	/**
	 * Returns the meta object for the attribute '{@link cvl.OVPSemanticSpec#getModelTransformation <em>Model Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Transformation</em>'.
	 * @see cvl.OVPSemanticSpec#getModelTransformation()
	 * @see #getOVPSemanticSpec()
	 * @generated
	 */
	EAttribute getOVPSemanticSpec_ModelTransformation();

	/**
	 * Returns the meta object for the attribute '{@link cvl.OVPSemanticSpec#getTransfromationLanguage <em>Transfromation Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transfromation Language</em>'.
	 * @see cvl.OVPSemanticSpec#getTransfromationLanguage()
	 * @see #getOVPSemanticSpec()
	 * @generated
	 */
	EAttribute getOVPSemanticSpec_TransfromationLanguage();

	/**
	 * Returns the meta object for class '{@link cvl.ObjectSpecification <em>Object Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Specification</em>'.
	 * @see cvl.ObjectSpecification
	 * @generated
	 */
	EClass getObjectSpecification();

	/**
	 * Returns the meta object for the reference '{@link cvl.ObjectSpecification#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see cvl.ObjectSpecification#getObject()
	 * @see #getObjectSpecification()
	 * @generated
	 */
	EReference getObjectSpecification_Object();

	/**
	 * Returns the meta object for class '{@link cvl.ReplacementFragmentSpecification <em>Replacement Fragment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Fragment Specification</em>'.
	 * @see cvl.ReplacementFragmentSpecification
	 * @generated
	 */
	EClass getReplacementFragmentSpecification();

	/**
	 * Returns the meta object for class '{@link cvl.VPackage <em>VPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VPackage</em>'.
	 * @see cvl.VPackage
	 * @generated
	 */
	EClass getVPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.VPackage#getPackageElement <em>Package Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Package Element</em>'.
	 * @see cvl.VPackage#getPackageElement()
	 * @see #getVPackage()
	 * @generated
	 */
	EReference getVPackage_PackageElement();

	/**
	 * Returns the meta object for class '{@link cvl.ToBinding <em>To Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Binding</em>'.
	 * @see cvl.ToBinding
	 * @generated
	 */
	EClass getToBinding();

	/**
	 * Returns the meta object for the reference '{@link cvl.ToBinding#getToPlacement <em>To Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Placement</em>'.
	 * @see cvl.ToBinding#getToPlacement()
	 * @see #getToBinding()
	 * @generated
	 */
	EReference getToBinding_ToPlacement();

	/**
	 * Returns the meta object for the reference '{@link cvl.ToBinding#getToReplacement <em>To Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Replacement</em>'.
	 * @see cvl.ToBinding#getToReplacement()
	 * @see #getToBinding()
	 * @generated
	 */
	EReference getToBinding_ToReplacement();

	/**
	 * Returns the meta object for class '{@link cvl.ToPlacement <em>To Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Placement</em>'.
	 * @see cvl.ToPlacement
	 * @generated
	 */
	EClass getToPlacement();

	/**
	 * Returns the meta object for the reference '{@link cvl.ToPlacement#getToReplacement <em>To Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Replacement</em>'.
	 * @see cvl.ToPlacement#getToReplacement()
	 * @see #getToPlacement()
	 * @generated
	 */
	EReference getToPlacement_ToReplacement();

	/**
	 * Returns the meta object for the attribute '{@link cvl.ToPlacement#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see cvl.ToPlacement#getPropertyName()
	 * @see #getToPlacement()
	 * @generated
	 */
	EAttribute getToPlacement_PropertyName();

	/**
	 * Returns the meta object for the reference list '{@link cvl.ToPlacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inside Boundary Element</em>'.
	 * @see cvl.ToPlacement#getInsideBoundaryElement()
	 * @see #getToPlacement()
	 * @generated
	 */
	EReference getToPlacement_InsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link cvl.ToPlacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outside Boundary Element</em>'.
	 * @see cvl.ToPlacement#getOutsideBoundaryElement()
	 * @see #getToPlacement()
	 * @generated
	 */
	EReference getToPlacement_OutsideBoundaryElement();

	/**
	 * Returns the meta object for class '{@link cvl.ToReplacement <em>To Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Replacement</em>'.
	 * @see cvl.ToReplacement
	 * @generated
	 */
	EClass getToReplacement();

	/**
	 * Returns the meta object for the reference list '{@link cvl.ToReplacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inside Boundary Element</em>'.
	 * @see cvl.ToReplacement#getInsideBoundaryElement()
	 * @see #getToReplacement()
	 * @generated
	 */
	EReference getToReplacement_InsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link cvl.ToReplacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outside Boundary Element</em>'.
	 * @see cvl.ToReplacement#getOutsideBoundaryElement()
	 * @see #getToReplacement()
	 * @generated
	 */
	EReference getToReplacement_OutsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link cvl.ToReplacement#getToPlacement <em>To Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Placement</em>'.
	 * @see cvl.ToReplacement#getToPlacement()
	 * @see #getToReplacement()
	 * @generated
	 */
	EReference getToReplacement_ToPlacement();

	/**
	 * Returns the meta object for class '{@link cvl.FromBinding <em>From Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Binding</em>'.
	 * @see cvl.FromBinding
	 * @generated
	 */
	EClass getFromBinding();

	/**
	 * Returns the meta object for the reference '{@link cvl.FromBinding#getFromPlacement <em>From Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Placement</em>'.
	 * @see cvl.FromBinding#getFromPlacement()
	 * @see #getFromBinding()
	 * @generated
	 */
	EReference getFromBinding_FromPlacement();

	/**
	 * Returns the meta object for the reference '{@link cvl.FromBinding#getFromReplacement <em>From Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Replacement</em>'.
	 * @see cvl.FromBinding#getFromReplacement()
	 * @see #getFromBinding()
	 * @generated
	 */
	EReference getFromBinding_FromReplacement();

	/**
	 * Returns the meta object for class '{@link cvl.FromPlacement <em>From Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Placement</em>'.
	 * @see cvl.FromPlacement
	 * @generated
	 */
	EClass getFromPlacement();

	/**
	 * Returns the meta object for the reference '{@link cvl.FromPlacement#getFromReplacement <em>From Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Replacement</em>'.
	 * @see cvl.FromPlacement#getFromReplacement()
	 * @see #getFromPlacement()
	 * @generated
	 */
	EReference getFromPlacement_FromReplacement();

	/**
	 * Returns the meta object for the reference list '{@link cvl.FromPlacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outside Boundary Element</em>'.
	 * @see cvl.FromPlacement#getOutsideBoundaryElement()
	 * @see #getFromPlacement()
	 * @generated
	 */
	EReference getFromPlacement_OutsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link cvl.FromPlacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inside Boundary Element</em>'.
	 * @see cvl.FromPlacement#getInsideBoundaryElement()
	 * @see #getFromPlacement()
	 * @generated
	 */
	EReference getFromPlacement_InsideBoundaryElement();

	/**
	 * Returns the meta object for class '{@link cvl.FromReplacement <em>From Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Replacement</em>'.
	 * @see cvl.FromReplacement
	 * @generated
	 */
	EClass getFromReplacement();

	/**
	 * Returns the meta object for the attribute '{@link cvl.FromReplacement#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see cvl.FromReplacement#getPropertyName()
	 * @see #getFromReplacement()
	 * @generated
	 */
	EAttribute getFromReplacement_PropertyName();

	/**
	 * Returns the meta object for the reference '{@link cvl.FromReplacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inside Boundary Element</em>'.
	 * @see cvl.FromReplacement#getInsideBoundaryElement()
	 * @see #getFromReplacement()
	 * @generated
	 */
	EReference getFromReplacement_InsideBoundaryElement();

	/**
	 * Returns the meta object for the reference list '{@link cvl.FromReplacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outside Boundary Element</em>'.
	 * @see cvl.FromReplacement#getOutsideBoundaryElement()
	 * @see #getFromReplacement()
	 * @generated
	 */
	EReference getFromReplacement_OutsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link cvl.FromReplacement#getFromPlacement <em>From Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Placement</em>'.
	 * @see cvl.FromReplacement#getFromPlacement()
	 * @see #getFromReplacement()
	 * @generated
	 */
	EReference getFromReplacement_FromPlacement();

	/**
	 * Returns the meta object for class '{@link cvl.VSpecRef <em>VSpec Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VSpec Ref</em>'.
	 * @see cvl.VSpecRef
	 * @generated
	 */
	EClass getVSpecRef();

	/**
	 * Returns the meta object for the reference '{@link cvl.VSpecRef#getVSpec <em>VSpec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>VSpec</em>'.
	 * @see cvl.VSpecRef#getVSpec()
	 * @see #getVSpecRef()
	 * @generated
	 */
	EReference getVSpecRef_VSpec();

	/**
	 * Returns the meta object for class '{@link cvl.BCLExpression <em>BCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BCL Expression</em>'.
	 * @see cvl.BCLExpression
	 * @generated
	 */
	EClass getBCLExpression();

	/**
	 * Returns the meta object for class '{@link cvl.OpaqueConstraint <em>Opaque Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opaque Constraint</em>'.
	 * @see cvl.OpaqueConstraint
	 * @generated
	 */
	EClass getOpaqueConstraint();

	/**
	 * Returns the meta object for the attribute '{@link cvl.OpaqueConstraint#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see cvl.OpaqueConstraint#getConstraint()
	 * @see #getOpaqueConstraint()
	 * @generated
	 */
	EAttribute getOpaqueConstraint_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link cvl.OpaqueConstraint#getConstraintLanguage <em>Constraint Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Language</em>'.
	 * @see cvl.OpaqueConstraint#getConstraintLanguage()
	 * @see #getOpaqueConstraint()
	 * @generated
	 */
	EAttribute getOpaqueConstraint_ConstraintLanguage();

	/**
	 * Returns the meta object for class '{@link cvl.ParametricVariationPoint <em>Parametric Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parametric Variation Point</em>'.
	 * @see cvl.ParametricVariationPoint
	 * @generated
	 */
	EClass getParametricVariationPoint();

	/**
	 * Returns the meta object for the reference '{@link cvl.ParametricVariationPoint#getBindingVariable <em>Binding Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding Variable</em>'.
	 * @see cvl.ParametricVariationPoint#getBindingVariable()
	 * @see #getParametricVariationPoint()
	 * @generated
	 */
	EReference getParametricVariationPoint_BindingVariable();

	/**
	 * Returns the meta object for class '{@link cvl.SlotValueExistence <em>Slot Value Existence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slot Value Existence</em>'.
	 * @see cvl.SlotValueExistence
	 * @generated
	 */
	EClass getSlotValueExistence();

	/**
	 * Returns the meta object for the attribute '{@link cvl.SlotValueExistence#getSlotIdentifier <em>Slot Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slot Identifier</em>'.
	 * @see cvl.SlotValueExistence#getSlotIdentifier()
	 * @see #getSlotValueExistence()
	 * @generated
	 */
	EAttribute getSlotValueExistence_SlotIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.SlotValueExistence#getSlotOwner <em>Slot Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Slot Owner</em>'.
	 * @see cvl.SlotValueExistence#getSlotOwner()
	 * @see #getSlotValueExistence()
	 * @generated
	 */
	EReference getSlotValueExistence_SlotOwner();

	/**
	 * Returns the meta object for class '{@link cvl.ParametricLinkEndSubstitution <em>Parametric Link End Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parametric Link End Substitution</em>'.
	 * @see cvl.ParametricLinkEndSubstitution
	 * @generated
	 */
	EClass getParametricLinkEndSubstitution();

	/**
	 * Returns the meta object for the attribute '{@link cvl.ParametricLinkEndSubstitution#getLinkEndIdentifier <em>Link End Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link End Identifier</em>'.
	 * @see cvl.ParametricLinkEndSubstitution#getLinkEndIdentifier()
	 * @see #getParametricLinkEndSubstitution()
	 * @generated
	 */
	EAttribute getParametricLinkEndSubstitution_LinkEndIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.ParametricLinkEndSubstitution#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link</em>'.
	 * @see cvl.ParametricLinkEndSubstitution#getLink()
	 * @see #getParametricLinkEndSubstitution()
	 * @generated
	 */
	EReference getParametricLinkEndSubstitution_Link();

	/**
	 * Returns the meta object for class '{@link cvl.ParametricObjectSubstitution <em>Parametric Object Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parametric Object Substitution</em>'.
	 * @see cvl.ParametricObjectSubstitution
	 * @generated
	 */
	EClass getParametricObjectSubstitution();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.ParametricObjectSubstitution#getPlacementObject <em>Placement Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Placement Object</em>'.
	 * @see cvl.ParametricObjectSubstitution#getPlacementObject()
	 * @see #getParametricObjectSubstitution()
	 * @generated
	 */
	EReference getParametricObjectSubstitution_PlacementObject();

	/**
	 * Returns the meta object for class '{@link cvl.ParametricSlotAssignmet <em>Parametric Slot Assignmet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parametric Slot Assignmet</em>'.
	 * @see cvl.ParametricSlotAssignmet
	 * @generated
	 */
	EClass getParametricSlotAssignmet();

	/**
	 * Returns the meta object for the attribute '{@link cvl.ParametricSlotAssignmet#getSlotIdentifier <em>Slot Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slot Identifier</em>'.
	 * @see cvl.ParametricSlotAssignmet#getSlotIdentifier()
	 * @see #getParametricSlotAssignmet()
	 * @generated
	 */
	EAttribute getParametricSlotAssignmet_SlotIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.ParametricSlotAssignmet#getSlotOwner <em>Slot Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Slot Owner</em>'.
	 * @see cvl.ParametricSlotAssignmet#getSlotOwner()
	 * @see #getParametricSlotAssignmet()
	 * @generated
	 */
	EReference getParametricSlotAssignmet_SlotOwner();

	/**
	 * Returns the meta object for class '{@link cvl.ChoiceDerivation <em>Choice Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice Derivation</em>'.
	 * @see cvl.ChoiceDerivation
	 * @generated
	 */
	EClass getChoiceDerivation();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.ChoiceDerivation#getDerivingConstraint <em>Deriving Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deriving Constraint</em>'.
	 * @see cvl.ChoiceDerivation#getDerivingConstraint()
	 * @see #getChoiceDerivation()
	 * @generated
	 */
	EReference getChoiceDerivation_DerivingConstraint();

	/**
	 * Returns the meta object for the reference '{@link cvl.ChoiceDerivation#getDerivedChoice <em>Derived Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Derived Choice</em>'.
	 * @see cvl.ChoiceDerivation#getDerivedChoice()
	 * @see #getChoiceDerivation()
	 * @generated
	 */
	EReference getChoiceDerivation_DerivedChoice();

	/**
	 * Returns the meta object for class '{@link cvl.VariableDerivation <em>Variable Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Derivation</em>'.
	 * @see cvl.VariableDerivation
	 * @generated
	 */
	EClass getVariableDerivation();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.VariableDerivation#getDerivingExpression <em>Deriving Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deriving Expression</em>'.
	 * @see cvl.VariableDerivation#getDerivingExpression()
	 * @see #getVariableDerivation()
	 * @generated
	 */
	EReference getVariableDerivation_DerivingExpression();

	/**
	 * Returns the meta object for the reference '{@link cvl.VariableDerivation#getDerivedVariable <em>Derived Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Derived Variable</em>'.
	 * @see cvl.VariableDerivation#getDerivedVariable()
	 * @see #getVariableDerivation()
	 * @generated
	 */
	EReference getVariableDerivation_DerivedVariable();

	/**
	 * Returns the meta object for class '{@link cvl.CVSpecDerivation <em>CV Spec Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CV Spec Derivation</em>'.
	 * @see cvl.CVSpecDerivation
	 * @generated
	 */
	EClass getCVSpecDerivation();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.CVSpecDerivation#getMemberDerivation <em>Member Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Member Derivation</em>'.
	 * @see cvl.CVSpecDerivation#getMemberDerivation()
	 * @see #getCVSpecDerivation()
	 * @generated
	 */
	EReference getCVSpecDerivation_MemberDerivation();

	/**
	 * Returns the meta object for the reference '{@link cvl.CVSpecDerivation#getDerivingCVspec <em>Deriving CVspec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Deriving CVspec</em>'.
	 * @see cvl.CVSpecDerivation#getDerivingCVspec()
	 * @see #getCVSpecDerivation()
	 * @generated
	 */
	EReference getCVSpecDerivation_DerivingCVspec();

	/**
	 * Returns the meta object for the reference '{@link cvl.CVSpecDerivation#getDerivedCVSpec <em>Derived CV Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Derived CV Spec</em>'.
	 * @see cvl.CVSpecDerivation#getDerivedCVSpec()
	 * @see #getCVSpecDerivation()
	 * @generated
	 */
	EReference getCVSpecDerivation_DerivedCVSpec();

	/**
	 * Returns the meta object for class '{@link cvl.ConfigurableUnitUsage <em>Configurable Unit Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configurable Unit Usage</em>'.
	 * @see cvl.ConfigurableUnitUsage
	 * @generated
	 */
	EClass getConfigurableUnitUsage();

	/**
	 * Returns the meta object for the reference '{@link cvl.ConfigurableUnitUsage#getUsedUnit <em>Used Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Used Unit</em>'.
	 * @see cvl.ConfigurableUnitUsage#getUsedUnit()
	 * @see #getConfigurableUnitUsage()
	 * @generated
	 */
	EReference getConfigurableUnitUsage_UsedUnit();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.ConfigurableUnitUsage#getUsageReference <em>Usage Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Usage Reference</em>'.
	 * @see cvl.ConfigurableUnitUsage#getUsageReference()
	 * @see #getConfigurableUnitUsage()
	 * @generated
	 */
	EReference getConfigurableUnitUsage_UsageReference();

	/**
	 * Returns the meta object for the attribute '{@link cvl.ConfigurableUnitUsage#getLinkEndIdentifier <em>Link End Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link End Identifier</em>'.
	 * @see cvl.ConfigurableUnitUsage#getLinkEndIdentifier()
	 * @see #getConfigurableUnitUsage()
	 * @generated
	 */
	EAttribute getConfigurableUnitUsage_LinkEndIdentifier();

	/**
	 * Returns the meta object for the reference '{@link cvl.ConfigurableUnitUsage#getUnitUsageInterface <em>Unit Usage Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unit Usage Interface</em>'.
	 * @see cvl.ConfigurableUnitUsage#getUnitUsageInterface()
	 * @see #getConfigurableUnitUsage()
	 * @generated
	 */
	EReference getConfigurableUnitUsage_UnitUsageInterface();

	/**
	 * Returns the meta object for class '{@link cvl.PrimitiveValueSpecification <em>Primitive Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Value Specification</em>'.
	 * @see cvl.PrimitiveValueSpecification
	 * @generated
	 */
	EClass getPrimitiveValueSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link cvl.PrimitiveValueSpecification#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see cvl.PrimitiveValueSpecification#getExpression()
	 * @see #getPrimitiveValueSpecification()
	 * @generated
	 */
	EReference getPrimitiveValueSpecification_Expression();

	/**
	 * Returns the meta object for class '{@link cvl.BCLConstraint <em>BCL Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BCL Constraint</em>'.
	 * @see cvl.BCLConstraint
	 * @generated
	 */
	EClass getBCLConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.BCLConstraint#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expression</em>'.
	 * @see cvl.BCLConstraint#getExpression()
	 * @see #getBCLConstraint()
	 * @generated
	 */
	EReference getBCLConstraint_Expression();

	/**
	 * Returns the meta object for class '{@link cvl.OperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Exp</em>'.
	 * @see cvl.OperationCallExp
	 * @generated
	 */
	EClass getOperationCallExp();

	/**
	 * Returns the meta object for the containment reference list '{@link cvl.OperationCallExp#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see cvl.OperationCallExp#getArgument()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_Argument();

	/**
	 * Returns the meta object for the attribute '{@link cvl.OperationCallExp#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see cvl.OperationCallExp#getOperation()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EAttribute getOperationCallExp_Operation();

	/**
	 * Returns the meta object for class '{@link cvl.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp</em>'.
	 * @see cvl.BooleanLiteralExp
	 * @generated
	 */
	EClass getBooleanLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link cvl.BooleanLiteralExp#isBool <em>Bool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bool</em>'.
	 * @see cvl.BooleanLiteralExp#isBool()
	 * @see #getBooleanLiteralExp()
	 * @generated
	 */
	EAttribute getBooleanLiteralExp_Bool();

	/**
	 * Returns the meta object for class '{@link cvl.StringLiteralExp <em>String Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Exp</em>'.
	 * @see cvl.StringLiteralExp
	 * @generated
	 */
	EClass getStringLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link cvl.StringLiteralExp#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see cvl.StringLiteralExp#getString()
	 * @see #getStringLiteralExp()
	 * @generated
	 */
	EAttribute getStringLiteralExp_String();

	/**
	 * Returns the meta object for class '{@link cvl.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal Exp</em>'.
	 * @see cvl.NumericLiteralExp
	 * @generated
	 */
	EClass getNumericLiteralExp();

	/**
	 * Returns the meta object for class '{@link cvl.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal Exp</em>'.
	 * @see cvl.IntegerLiteralExp
	 * @generated
	 */
	EClass getIntegerLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link cvl.IntegerLiteralExp#getInteger <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer</em>'.
	 * @see cvl.IntegerLiteralExp#getInteger()
	 * @see #getIntegerLiteralExp()
	 * @generated
	 */
	EAttribute getIntegerLiteralExp_Integer();

	/**
	 * Returns the meta object for class '{@link cvl.UnlimitedLiteralExp <em>Unlimited Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlimited Literal Exp</em>'.
	 * @see cvl.UnlimitedLiteralExp
	 * @generated
	 */
	EClass getUnlimitedLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link cvl.UnlimitedLiteralExp#getUnlimited <em>Unlimited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unlimited</em>'.
	 * @see cvl.UnlimitedLiteralExp#getUnlimited()
	 * @see #getUnlimitedLiteralExp()
	 * @generated
	 */
	EAttribute getUnlimitedLiteralExp_Unlimited();

	/**
	 * Returns the meta object for class '{@link cvl.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal Exp</em>'.
	 * @see cvl.RealLiteralExp
	 * @generated
	 */
	EClass getRealLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link cvl.RealLiteralExp#getReal <em>Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Real</em>'.
	 * @see cvl.RealLiteralExp#getReal()
	 * @see #getRealLiteralExp()
	 * @generated
	 */
	EAttribute getRealLiteralExp_Real();

	/**
	 * Returns the meta object for enum '{@link cvl.PrimitiveTypeEnum <em>Primitive Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Type Enum</em>'.
	 * @see cvl.PrimitiveTypeEnum
	 * @generated
	 */
	EEnum getPrimitiveTypeEnum();

	/**
	 * Returns the meta object for enum '{@link cvl.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operation</em>'.
	 * @see cvl.Operation
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
	cvlFactory getcvlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link cvl.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ChoiceImpl
		 * @see cvl.impl.cvlPackageImpl#getChoice()
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
		 * The meta object literal for the '{@link cvl.impl.VSpecImpl <em>VSpec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VSpecImpl
		 * @see cvl.impl.cvlPackageImpl#getVSpec()
		 * @generated
		 */
		EClass VSPEC = eINSTANCE.getVSpec();

		/**
		 * The meta object literal for the '<em><b>Group Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSPEC__GROUP_MULTIPLICITY = eINSTANCE.getVSpec_GroupMultiplicity();

		/**
		 * The meta object literal for the '<em><b>Resolution Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VSPEC__RESOLUTION_TIME = eINSTANCE.getVSpec_ResolutionTime();

		/**
		 * The meta object literal for the '<em><b>Owned VSpec Derivation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSPEC__OWNED_VSPEC_DERIVATION = eINSTANCE.getVSpec_OwnedVSpecDerivation();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSPEC__CHILD = eINSTANCE.getVSpec_Child();

		/**
		 * The meta object literal for the '{@link cvl.impl.VPackageableImpl <em>VPackageable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VPackageableImpl
		 * @see cvl.impl.cvlPackageImpl#getVPackageable()
		 * @generated
		 */
		EClass VPACKAGEABLE = eINSTANCE.getVPackageable();

		/**
		 * The meta object literal for the '{@link cvl.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.NamedElementImpl
		 * @see cvl.impl.cvlPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link cvl.impl.MultiplicityIntervalImpl <em>Multiplicity Interval</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.MultiplicityIntervalImpl
		 * @see cvl.impl.cvlPackageImpl#getMultiplicityInterval()
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
		 * The meta object literal for the '{@link cvl.impl.VSpecDerivationImpl <em>VSpec Derivation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VSpecDerivationImpl
		 * @see cvl.impl.cvlPackageImpl#getVSpecDerivation()
		 * @generated
		 */
		EClass VSPEC_DERIVATION = eINSTANCE.getVSpecDerivation();

		/**
		 * The meta object literal for the '<em><b>Derived VSpec</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSPEC_DERIVATION__DERIVED_VSPEC = eINSTANCE.getVSpecDerivation_DerivedVSpec();

		/**
		 * The meta object literal for the '{@link cvl.impl.VClassifierImpl <em>VClassifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VClassifierImpl
		 * @see cvl.impl.cvlPackageImpl#getVClassifier()
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
		 * The meta object literal for the '{@link cvl.impl.VSpecResolutionImpl <em>VSpec Resolution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VSpecResolutionImpl
		 * @see cvl.impl.cvlPackageImpl#getVSpecResolution()
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
		 * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSPEC_RESOLUTION__CHILD = eINSTANCE.getVSpecResolution_Child();

		/**
		 * The meta object literal for the '{@link cvl.impl.ChoiceResolutuionImpl <em>Choice Resolutuion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ChoiceResolutuionImpl
		 * @see cvl.impl.cvlPackageImpl#getChoiceResolutuion()
		 * @generated
		 */
		EClass CHOICE_RESOLUTUION = eINSTANCE.getChoiceResolutuion();

		/**
		 * The meta object literal for the '<em><b>Resolved Choice</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_RESOLUTUION__RESOLVED_CHOICE = eINSTANCE.getChoiceResolutuion_ResolvedChoice();

		/**
		 * The meta object literal for the '<em><b>Decision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHOICE_RESOLUTUION__DECISION = eINSTANCE.getChoiceResolutuion_Decision();

		/**
		 * The meta object literal for the '{@link cvl.impl.VInstanceImpl <em>VInstance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VInstanceImpl
		 * @see cvl.impl.cvlPackageImpl#getVInstance()
		 * @generated
		 */
		EClass VINSTANCE = eINSTANCE.getVInstance();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VINSTANCE__TYPE = eINSTANCE.getVInstance_Type();

		/**
		 * The meta object literal for the '{@link cvl.impl.VariationPointImpl <em>Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VariationPointImpl
		 * @see cvl.impl.cvlPackageImpl#getVariationPoint()
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
		 * The meta object literal for the '{@link cvl.impl.FragmentSubstitutionImpl <em>Fragment Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.FragmentSubstitutionImpl
		 * @see cvl.impl.cvlPackageImpl#getFragmentSubstitution()
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
		 * The meta object literal for the '<em><b>Source Object</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT_SUBSTITUTION__SOURCE_OBJECT = eINSTANCE.getFragmentSubstitution_SourceObject();

		/**
		 * The meta object literal for the '{@link cvl.impl.ChoiceVariationPointImpl <em>Choice Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ChoiceVariationPointImpl
		 * @see cvl.impl.cvlPackageImpl#getChoiceVariationPoint()
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
		 * The meta object literal for the '{@link cvl.impl.RepeatableVariationPointImpl <em>Repeatable Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.RepeatableVariationPointImpl
		 * @see cvl.impl.cvlPackageImpl#getRepeatableVariationPoint()
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
		 * The meta object literal for the '{@link cvl.impl.BoundaryElementBindingImpl <em>Boundary Element Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.BoundaryElementBindingImpl
		 * @see cvl.impl.cvlPackageImpl#getBoundaryElementBinding()
		 * @generated
		 */
		EClass BOUNDARY_ELEMENT_BINDING = eINSTANCE.getBoundaryElementBinding();

		/**
		 * The meta object literal for the '{@link cvl.impl.PlacementFragmentImpl <em>Placement Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.PlacementFragmentImpl
		 * @see cvl.impl.cvlPackageImpl#getPlacementFragment()
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
		 * The meta object literal for the '{@link cvl.impl.PlacementBoundaryElementImpl <em>Placement Boundary Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.PlacementBoundaryElementImpl
		 * @see cvl.impl.cvlPackageImpl#getPlacementBoundaryElement()
		 * @generated
		 */
		EClass PLACEMENT_BOUNDARY_ELEMENT = eINSTANCE.getPlacementBoundaryElement();

		/**
		 * The meta object literal for the '{@link cvl.impl.ReplacementFragmentTypeImpl <em>Replacement Fragment Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ReplacementFragmentTypeImpl
		 * @see cvl.impl.cvlPackageImpl#getReplacementFragmentType()
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
		 * The meta object literal for the '{@link cvl.impl.VariabletypeImpl <em>Variabletype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VariabletypeImpl
		 * @see cvl.impl.cvlPackageImpl#getVariabletype()
		 * @generated
		 */
		EClass VARIABLETYPE = eINSTANCE.getVariabletype();

		/**
		 * The meta object literal for the '{@link cvl.impl.ReplacementBoundaryElementImpl <em>Replacement Boundary Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ReplacementBoundaryElementImpl
		 * @see cvl.impl.cvlPackageImpl#getReplacementBoundaryElement()
		 * @generated
		 */
		EClass REPLACEMENT_BOUNDARY_ELEMENT = eINSTANCE.getReplacementBoundaryElement();

		/**
		 * The meta object literal for the '{@link cvl.impl.ObjectSubstitutionImpl <em>Object Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ObjectSubstitutionImpl
		 * @see cvl.impl.cvlPackageImpl#getObjectSubstitution()
		 * @generated
		 */
		EClass OBJECT_SUBSTITUTION = eINSTANCE.getObjectSubstitution();

		/**
		 * The meta object literal for the '<em><b>Placement Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_SUBSTITUTION__PLACEMENT_OBJECT = eINSTANCE.getObjectSubstitution_PlacementObject();

		/**
		 * The meta object literal for the '<em><b>Replacement Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_SUBSTITUTION__REPLACEMENT_OBJECT = eINSTANCE.getObjectSubstitution_ReplacementObject();

		/**
		 * The meta object literal for the '{@link cvl.impl.ObjectHandleImpl <em>Object Handle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ObjectHandleImpl
		 * @see cvl.impl.cvlPackageImpl#getObjectHandle()
		 * @generated
		 */
		EClass OBJECT_HANDLE = eINSTANCE.getObjectHandle();

		/**
		 * The meta object literal for the '<em><b>MOF Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_HANDLE__MOF_REF = eINSTANCE.getObjectHandle_MOFRef();

		/**
		 * The meta object literal for the '{@link cvl.impl.BaseModelHandleImpl <em>Base Model Handle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.BaseModelHandleImpl
		 * @see cvl.impl.cvlPackageImpl#getBaseModelHandle()
		 * @generated
		 */
		EClass BASE_MODEL_HANDLE = eINSTANCE.getBaseModelHandle();

		/**
		 * The meta object literal for the '{@link cvl.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VariableImpl
		 * @see cvl.impl.cvlPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Replacement Fragment Typesubsetstype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__REPLACEMENT_FRAGMENT_TYPESUBSETSTYPE = eINSTANCE.getVariable_ReplacementFragmentTypesubsetstype();

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
		 * The meta object literal for the '{@link cvl.impl.ValueSpecificationImpl <em>Value Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ValueSpecificationImpl
		 * @see cvl.impl.cvlPackageImpl#getValueSpecification()
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
		 * The meta object literal for the '{@link cvl.impl.VariableValueAssignmentImpl <em>Variable Value Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VariableValueAssignmentImpl
		 * @see cvl.impl.cvlPackageImpl#getVariableValueAssignment()
		 * @generated
		 */
		EClass VARIABLE_VALUE_ASSIGNMENT = eINSTANCE.getVariableValueAssignment();

		/**
		 * The meta object literal for the '<em><b>Resolved Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_VALUE_ASSIGNMENT__RESOLVED_VARIABLE = eINSTANCE.getVariableValueAssignment_ResolvedVariable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_VALUE_ASSIGNMENT__VALUE = eINSTANCE.getVariableValueAssignment_Value();

		/**
		 * The meta object literal for the '{@link cvl.impl.PrimitveTypeImpl <em>Primitve Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.PrimitveTypeImpl
		 * @see cvl.impl.cvlPackageImpl#getPrimitveType()
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
		 * The meta object literal for the '{@link cvl.impl.ObjectTypeImpl <em>Object Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ObjectTypeImpl
		 * @see cvl.impl.cvlPackageImpl#getObjectType()
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
		 * The meta object literal for the '{@link cvl.impl.VInterfaceImpl <em>VInterface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VInterfaceImpl
		 * @see cvl.impl.cvlPackageImpl#getVInterface()
		 * @generated
		 */
		EClass VINTERFACE = eINSTANCE.getVInterface();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VINTERFACE__MEMBER = eINSTANCE.getVInterface_Member();

		/**
		 * The meta object literal for the '<em><b>Owned Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VINTERFACE__OWNED_CONSTRAINT = eINSTANCE.getVInterface_OwnedConstraint();

		/**
		 * The meta object literal for the '{@link cvl.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ConstraintImpl
		 * @see cvl.impl.cvlPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__CONTEXT = eINSTANCE.getConstraint_Context();

		/**
		 * The meta object literal for the '{@link cvl.impl.SlotAssignmentImpl <em>Slot Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.SlotAssignmentImpl
		 * @see cvl.impl.cvlPackageImpl#getSlotAssignment()
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
		 * The meta object literal for the '{@link cvl.impl.ObjectExistenceImpl <em>Object Existence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ObjectExistenceImpl
		 * @see cvl.impl.cvlPackageImpl#getObjectExistence()
		 * @generated
		 */
		EClass OBJECT_EXISTENCE = eINSTANCE.getObjectExistence();

		/**
		 * The meta object literal for the '<em><b>Optional Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_EXISTENCE__OPTIONAL_OBJECT = eINSTANCE.getObjectExistence_OptionalObject();

		/**
		 * The meta object literal for the '{@link cvl.impl.LinkEndSubstitutionImpl <em>Link End Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.LinkEndSubstitutionImpl
		 * @see cvl.impl.cvlPackageImpl#getLinkEndSubstitution()
		 * @generated
		 */
		EClass LINK_END_SUBSTITUTION = eINSTANCE.getLinkEndSubstitution();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_END_SUBSTITUTION__LINK = eINSTANCE.getLinkEndSubstitution_Link();

		/**
		 * The meta object literal for the '<em><b>Link End Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER = eINSTANCE.getLinkEndSubstitution_LinkEndIdentifier();

		/**
		 * The meta object literal for the '<em><b>Replacement Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_END_SUBSTITUTION__REPLACEMENT_OBJECT = eINSTANCE.getLinkEndSubstitution_ReplacementObject();

		/**
		 * The meta object literal for the '{@link cvl.impl.LinkHandleImpl <em>Link Handle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.LinkHandleImpl
		 * @see cvl.impl.cvlPackageImpl#getLinkHandle()
		 * @generated
		 */
		EClass LINK_HANDLE = eINSTANCE.getLinkHandle();

		/**
		 * The meta object literal for the '<em><b>MOF Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_HANDLE__MOF_REF = eINSTANCE.getLinkHandle_MOFRef();

		/**
		 * The meta object literal for the '{@link cvl.impl.ConfigurableUnitImpl <em>Configurable Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ConfigurableUnitImpl
		 * @see cvl.impl.cvlPackageImpl#getConfigurableUnit()
		 * @generated
		 */
		EClass CONFIGURABLE_UNIT = eINSTANCE.getConfigurableUnit();

		/**
		 * The meta object literal for the '<em><b>Owned VSpec</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE_UNIT__OWNED_VSPEC = eINSTANCE.getConfigurableUnit_OwnedVSpec();

		/**
		 * The meta object literal for the '<em><b>Owned Variation Point</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE_UNIT__OWNED_VARIATION_POINT = eINSTANCE.getConfigurableUnit_OwnedVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Owned Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE_UNIT__OWNED_CONSTRAINT = eINSTANCE.getConfigurableUnit_OwnedConstraint();

		/**
		 * The meta object literal for the '<em><b>Configurable Container Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT = eINSTANCE.getConfigurableUnit_ConfigurableContainerObject();

		/**
		 * The meta object literal for the '<em><b>Owned VSpec Resolution</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION = eINSTANCE.getConfigurableUnit_OwnedVSpecResolution();

		/**
		 * The meta object literal for the '<em><b>Unit Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE_UNIT__UNIT_INTERFACE = eINSTANCE.getConfigurableUnit_UnitInterface();

		/**
		 * The meta object literal for the '<em><b>Owned VSpec Derivation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION = eINSTANCE.getConfigurableUnit_OwnedVSpecDerivation();

		/**
		 * The meta object literal for the '<em><b>Owned Variabletype</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE_UNIT__OWNED_VARIABLETYPE = eINSTANCE.getConfigurableUnit_OwnedVariabletype();

		/**
		 * The meta object literal for the '{@link cvl.impl.CompositeVariationPointImpl <em>Composite Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.CompositeVariationPointImpl
		 * @see cvl.impl.cvlPackageImpl#getCompositeVariationPoint()
		 * @generated
		 */
		EClass COMPOSITE_VARIATION_POINT = eINSTANCE.getCompositeVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Binding CV Spec</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_VARIATION_POINT__BINDING_CV_SPEC = eINSTANCE.getCompositeVariationPoint_BindingCVSpec();

		/**
		 * The meta object literal for the '{@link cvl.impl.CVSpecImpl <em>CV Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.CVSpecImpl
		 * @see cvl.impl.cvlPackageImpl#getCVSpec()
		 * @generated
		 */
		EClass CV_SPEC = eINSTANCE.getCVSpec();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CV_SPEC__TYPE = eINSTANCE.getCVSpec_Type();

		/**
		 * The meta object literal for the '{@link cvl.impl.VConfigurationImpl <em>VConfiguration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VConfigurationImpl
		 * @see cvl.impl.cvlPackageImpl#getVConfiguration()
		 * @generated
		 */
		EClass VCONFIGURATION = eINSTANCE.getVConfiguration();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VCONFIGURATION__MEMBER = eINSTANCE.getVConfiguration_Member();

		/**
		 * The meta object literal for the '<em><b>Is Partial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VCONFIGURATION__IS_PARTIAL = eINSTANCE.getVConfiguration_IsPartial();

		/**
		 * The meta object literal for the '<em><b>Resolved CV Spec</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VCONFIGURATION__RESOLVED_CV_SPEC = eINSTANCE.getVConfiguration_ResolvedCVSpec();

		/**
		 * The meta object literal for the '{@link cvl.impl.LinkExistenceImpl <em>Link Existence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.LinkExistenceImpl
		 * @see cvl.impl.cvlPackageImpl#getLinkExistence()
		 * @generated
		 */
		EClass LINK_EXISTENCE = eINSTANCE.getLinkExistence();

		/**
		 * The meta object literal for the '<em><b>Optional Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_EXISTENCE__OPTIONAL_LINK = eINSTANCE.getLinkExistence_OptionalLink();

		/**
		 * The meta object literal for the '{@link cvl.impl.OpaqueVariationPointImpl <em>Opaque Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.OpaqueVariationPointImpl
		 * @see cvl.impl.cvlPackageImpl#getOpaqueVariationPoint()
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
		 * The meta object literal for the '<em><b>Source Object</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPAQUE_VARIATION_POINT__SOURCE_OBJECT = eINSTANCE.getOpaqueVariationPoint_SourceObject();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPAQUE_VARIATION_POINT__TYPE = eINSTANCE.getOpaqueVariationPoint_Type();

		/**
		 * The meta object literal for the '{@link cvl.impl.OVPTypeImpl <em>OVP Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.OVPTypeImpl
		 * @see cvl.impl.cvlPackageImpl#getOVPType()
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
		 * The meta object literal for the '{@link cvl.impl.OVPSemanticSpecImpl <em>OVP Semantic Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.OVPSemanticSpecImpl
		 * @see cvl.impl.cvlPackageImpl#getOVPSemanticSpec()
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
		 * The meta object literal for the '{@link cvl.impl.ObjectSpecificationImpl <em>Object Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ObjectSpecificationImpl
		 * @see cvl.impl.cvlPackageImpl#getObjectSpecification()
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
		 * The meta object literal for the '{@link cvl.impl.ReplacementFragmentSpecificationImpl <em>Replacement Fragment Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ReplacementFragmentSpecificationImpl
		 * @see cvl.impl.cvlPackageImpl#getReplacementFragmentSpecification()
		 * @generated
		 */
		EClass REPLACEMENT_FRAGMENT_SPECIFICATION = eINSTANCE.getReplacementFragmentSpecification();

		/**
		 * The meta object literal for the '{@link cvl.impl.VPackageImpl <em>VPackage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VPackageImpl
		 * @see cvl.impl.cvlPackageImpl#getVPackage()
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
		 * The meta object literal for the '{@link cvl.impl.ToBindingImpl <em>To Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ToBindingImpl
		 * @see cvl.impl.cvlPackageImpl#getToBinding()
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
		 * The meta object literal for the '{@link cvl.impl.ToPlacementImpl <em>To Placement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ToPlacementImpl
		 * @see cvl.impl.cvlPackageImpl#getToPlacement()
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
		 * The meta object literal for the '{@link cvl.impl.ToReplacementImpl <em>To Replacement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ToReplacementImpl
		 * @see cvl.impl.cvlPackageImpl#getToReplacement()
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
		 * The meta object literal for the '{@link cvl.impl.FromBindingImpl <em>From Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.FromBindingImpl
		 * @see cvl.impl.cvlPackageImpl#getFromBinding()
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
		 * The meta object literal for the '{@link cvl.impl.FromPlacementImpl <em>From Placement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.FromPlacementImpl
		 * @see cvl.impl.cvlPackageImpl#getFromPlacement()
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
		 * The meta object literal for the '{@link cvl.impl.FromReplacementImpl <em>From Replacement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.FromReplacementImpl
		 * @see cvl.impl.cvlPackageImpl#getFromReplacement()
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
		 * The meta object literal for the '{@link cvl.impl.VSpecRefImpl <em>VSpec Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VSpecRefImpl
		 * @see cvl.impl.cvlPackageImpl#getVSpecRef()
		 * @generated
		 */
		EClass VSPEC_REF = eINSTANCE.getVSpecRef();

		/**
		 * The meta object literal for the '<em><b>VSpec</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSPEC_REF__VSPEC = eINSTANCE.getVSpecRef_VSpec();

		/**
		 * The meta object literal for the '{@link cvl.impl.BCLExpressionImpl <em>BCL Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.BCLExpressionImpl
		 * @see cvl.impl.cvlPackageImpl#getBCLExpression()
		 * @generated
		 */
		EClass BCL_EXPRESSION = eINSTANCE.getBCLExpression();

		/**
		 * The meta object literal for the '{@link cvl.impl.OpaqueConstraintImpl <em>Opaque Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.OpaqueConstraintImpl
		 * @see cvl.impl.cvlPackageImpl#getOpaqueConstraint()
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
		 * The meta object literal for the '{@link cvl.impl.ParametricVariationPointImpl <em>Parametric Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ParametricVariationPointImpl
		 * @see cvl.impl.cvlPackageImpl#getParametricVariationPoint()
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
		 * The meta object literal for the '{@link cvl.impl.SlotValueExistenceImpl <em>Slot Value Existence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.SlotValueExistenceImpl
		 * @see cvl.impl.cvlPackageImpl#getSlotValueExistence()
		 * @generated
		 */
		EClass SLOT_VALUE_EXISTENCE = eINSTANCE.getSlotValueExistence();

		/**
		 * The meta object literal for the '<em><b>Slot Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLOT_VALUE_EXISTENCE__SLOT_IDENTIFIER = eINSTANCE.getSlotValueExistence_SlotIdentifier();

		/**
		 * The meta object literal for the '<em><b>Slot Owner</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT_VALUE_EXISTENCE__SLOT_OWNER = eINSTANCE.getSlotValueExistence_SlotOwner();

		/**
		 * The meta object literal for the '{@link cvl.impl.ParametricLinkEndSubstitutionImpl <em>Parametric Link End Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ParametricLinkEndSubstitutionImpl
		 * @see cvl.impl.cvlPackageImpl#getParametricLinkEndSubstitution()
		 * @generated
		 */
		EClass PARAMETRIC_LINK_END_SUBSTITUTION = eINSTANCE.getParametricLinkEndSubstitution();

		/**
		 * The meta object literal for the '<em><b>Link End Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETRIC_LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER = eINSTANCE.getParametricLinkEndSubstitution_LinkEndIdentifier();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_LINK_END_SUBSTITUTION__LINK = eINSTANCE.getParametricLinkEndSubstitution_Link();

		/**
		 * The meta object literal for the '{@link cvl.impl.ParametricObjectSubstitutionImpl <em>Parametric Object Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ParametricObjectSubstitutionImpl
		 * @see cvl.impl.cvlPackageImpl#getParametricObjectSubstitution()
		 * @generated
		 */
		EClass PARAMETRIC_OBJECT_SUBSTITUTION = eINSTANCE.getParametricObjectSubstitution();

		/**
		 * The meta object literal for the '<em><b>Placement Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_OBJECT_SUBSTITUTION__PLACEMENT_OBJECT = eINSTANCE.getParametricObjectSubstitution_PlacementObject();

		/**
		 * The meta object literal for the '{@link cvl.impl.ParametricSlotAssignmetImpl <em>Parametric Slot Assignmet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ParametricSlotAssignmetImpl
		 * @see cvl.impl.cvlPackageImpl#getParametricSlotAssignmet()
		 * @generated
		 */
		EClass PARAMETRIC_SLOT_ASSIGNMET = eINSTANCE.getParametricSlotAssignmet();

		/**
		 * The meta object literal for the '<em><b>Slot Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETRIC_SLOT_ASSIGNMET__SLOT_IDENTIFIER = eINSTANCE.getParametricSlotAssignmet_SlotIdentifier();

		/**
		 * The meta object literal for the '<em><b>Slot Owner</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_SLOT_ASSIGNMET__SLOT_OWNER = eINSTANCE.getParametricSlotAssignmet_SlotOwner();

		/**
		 * The meta object literal for the '{@link cvl.impl.ChoiceDerivationImpl <em>Choice Derivation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ChoiceDerivationImpl
		 * @see cvl.impl.cvlPackageImpl#getChoiceDerivation()
		 * @generated
		 */
		EClass CHOICE_DERIVATION = eINSTANCE.getChoiceDerivation();

		/**
		 * The meta object literal for the '<em><b>Deriving Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_DERIVATION__DERIVING_CONSTRAINT = eINSTANCE.getChoiceDerivation_DerivingConstraint();

		/**
		 * The meta object literal for the '<em><b>Derived Choice</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_DERIVATION__DERIVED_CHOICE = eINSTANCE.getChoiceDerivation_DerivedChoice();

		/**
		 * The meta object literal for the '{@link cvl.impl.VariableDerivationImpl <em>Variable Derivation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.VariableDerivationImpl
		 * @see cvl.impl.cvlPackageImpl#getVariableDerivation()
		 * @generated
		 */
		EClass VARIABLE_DERIVATION = eINSTANCE.getVariableDerivation();

		/**
		 * The meta object literal for the '<em><b>Deriving Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DERIVATION__DERIVING_EXPRESSION = eINSTANCE.getVariableDerivation_DerivingExpression();

		/**
		 * The meta object literal for the '<em><b>Derived Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DERIVATION__DERIVED_VARIABLE = eINSTANCE.getVariableDerivation_DerivedVariable();

		/**
		 * The meta object literal for the '{@link cvl.impl.CVSpecDerivationImpl <em>CV Spec Derivation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.CVSpecDerivationImpl
		 * @see cvl.impl.cvlPackageImpl#getCVSpecDerivation()
		 * @generated
		 */
		EClass CV_SPEC_DERIVATION = eINSTANCE.getCVSpecDerivation();

		/**
		 * The meta object literal for the '<em><b>Member Derivation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CV_SPEC_DERIVATION__MEMBER_DERIVATION = eINSTANCE.getCVSpecDerivation_MemberDerivation();

		/**
		 * The meta object literal for the '<em><b>Deriving CVspec</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CV_SPEC_DERIVATION__DERIVING_CVSPEC = eINSTANCE.getCVSpecDerivation_DerivingCVspec();

		/**
		 * The meta object literal for the '<em><b>Derived CV Spec</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CV_SPEC_DERIVATION__DERIVED_CV_SPEC = eINSTANCE.getCVSpecDerivation_DerivedCVSpec();

		/**
		 * The meta object literal for the '{@link cvl.impl.ConfigurableUnitUsageImpl <em>Configurable Unit Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.ConfigurableUnitUsageImpl
		 * @see cvl.impl.cvlPackageImpl#getConfigurableUnitUsage()
		 * @generated
		 */
		EClass CONFIGURABLE_UNIT_USAGE = eINSTANCE.getConfigurableUnitUsage();

		/**
		 * The meta object literal for the '<em><b>Used Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE_UNIT_USAGE__USED_UNIT = eINSTANCE.getConfigurableUnitUsage_UsedUnit();

		/**
		 * The meta object literal for the '<em><b>Usage Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE_UNIT_USAGE__USAGE_REFERENCE = eINSTANCE.getConfigurableUnitUsage_UsageReference();

		/**
		 * The meta object literal for the '<em><b>Link End Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURABLE_UNIT_USAGE__LINK_END_IDENTIFIER = eINSTANCE.getConfigurableUnitUsage_LinkEndIdentifier();

		/**
		 * The meta object literal for the '<em><b>Unit Usage Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE_UNIT_USAGE__UNIT_USAGE_INTERFACE = eINSTANCE.getConfigurableUnitUsage_UnitUsageInterface();

		/**
		 * The meta object literal for the '{@link cvl.impl.PrimitiveValueSpecificationImpl <em>Primitive Value Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.PrimitiveValueSpecificationImpl
		 * @see cvl.impl.cvlPackageImpl#getPrimitiveValueSpecification()
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
		 * The meta object literal for the '{@link cvl.impl.BCLConstraintImpl <em>BCL Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.BCLConstraintImpl
		 * @see cvl.impl.cvlPackageImpl#getBCLConstraint()
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
		 * The meta object literal for the '{@link cvl.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.OperationCallExpImpl
		 * @see cvl.impl.cvlPackageImpl#getOperationCallExp()
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
		 * The meta object literal for the '{@link cvl.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.BooleanLiteralExpImpl
		 * @see cvl.impl.cvlPackageImpl#getBooleanLiteralExp()
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
		 * The meta object literal for the '{@link cvl.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.StringLiteralExpImpl
		 * @see cvl.impl.cvlPackageImpl#getStringLiteralExp()
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
		 * The meta object literal for the '{@link cvl.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.NumericLiteralExpImpl
		 * @see cvl.impl.cvlPackageImpl#getNumericLiteralExp()
		 * @generated
		 */
		EClass NUMERIC_LITERAL_EXP = eINSTANCE.getNumericLiteralExp();

		/**
		 * The meta object literal for the '{@link cvl.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.IntegerLiteralExpImpl
		 * @see cvl.impl.cvlPackageImpl#getIntegerLiteralExp()
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
		 * The meta object literal for the '{@link cvl.impl.UnlimitedLiteralExpImpl <em>Unlimited Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.UnlimitedLiteralExpImpl
		 * @see cvl.impl.cvlPackageImpl#getUnlimitedLiteralExp()
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
		 * The meta object literal for the '{@link cvl.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.impl.RealLiteralExpImpl
		 * @see cvl.impl.cvlPackageImpl#getRealLiteralExp()
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
		 * The meta object literal for the '{@link cvl.PrimitiveTypeEnum <em>Primitive Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.PrimitiveTypeEnum
		 * @see cvl.impl.cvlPackageImpl#getPrimitiveTypeEnum()
		 * @generated
		 */
		EEnum PRIMITIVE_TYPE_ENUM = eINSTANCE.getPrimitiveTypeEnum();

		/**
		 * The meta object literal for the '{@link cvl.Operation <em>Operation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cvl.Operation
		 * @see cvl.impl.cvlPackageImpl#getOperation()
		 * @generated
		 */
		EEnum OPERATION = eINSTANCE.getOperation();

	}

} //cvlPackage
