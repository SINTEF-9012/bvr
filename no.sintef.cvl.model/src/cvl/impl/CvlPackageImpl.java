/**
 */
package cvl.impl;

import cvl.BCLConstraint;
import cvl.BCLExpression;
import cvl.BaseModelHandle;
import cvl.BooleanLiteralExp;
import cvl.BoundaryElementBinding;
import cvl.CVSpec;
import cvl.CVSpecDerivation;
import cvl.Choice;
import cvl.ChoiceDerivation;
import cvl.ChoiceResolutuion;
import cvl.ChoiceVariationPoint;
import cvl.CompositeVariationPoint;
import cvl.ConfigurableUnit;
import cvl.ConfigurableUnitUsage;
import cvl.Constraint;
import cvl.CvlFactory;
import cvl.CvlPackage;
import cvl.FragmentSubstitution;
import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.IntegerLiteralExp;
import cvl.LinkEndSubstitution;
import cvl.LinkExistence;
import cvl.LinkHandle;
import cvl.MultiplicityInterval;
import cvl.NamedElement;
import cvl.NumericLiteralExp;
import cvl.OVPSemanticSpec;
import cvl.OVPType;
import cvl.ObjectExistence;
import cvl.ObjectHandle;
import cvl.ObjectSpecification;
import cvl.ObjectSubstitution;
import cvl.ObjectType;
import cvl.OpaqueConstraint;
import cvl.OpaqueVariationPoint;
import cvl.Operation;
import cvl.OperationCallExp;
import cvl.ParametricLinkEndSubstitution;
import cvl.ParametricObjectSubstitution;
import cvl.ParametricSlotAssignmet;
import cvl.ParametricVariationPoint;
import cvl.PlacementBoundaryElement;
import cvl.PlacementFragment;
import cvl.PrimitiveTypeEnum;
import cvl.PrimitiveValueSpecification;
import cvl.PrimitveType;
import cvl.RealLiteralExp;
import cvl.RepeatableVariationPoint;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragmentSpecification;
import cvl.ReplacementFragmentType;
import cvl.SlotAssignment;
import cvl.SlotValueExistence;
import cvl.StringLiteralExp;
import cvl.ToBinding;
import cvl.ToPlacement;
import cvl.ToReplacement;
import cvl.UnlimitedLiteralExp;
import cvl.VClassifier;
import cvl.VConfiguration;
import cvl.VInstance;
import cvl.VInterface;
import cvl.VPackage;
import cvl.VPackageable;
import cvl.VSpec;
import cvl.VSpecDerivation;
import cvl.VSpecRef;
import cvl.VSpecResolution;
import cvl.ValueSpecification;
import cvl.Variable;
import cvl.VariableDerivation;
import cvl.VariableValueAssignment;
import cvl.Variabletype;
import cvl.VariationPoint;

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
public class CvlPackageImpl extends EPackageImpl implements CvlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vPackageableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicityIntervalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vSpecDerivationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vSpecResolutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceResolutuionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variationPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fragmentSubstitutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceVariationPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repeatableVariationPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundaryElementBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placementFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placementBoundaryElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replacementFragmentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variabletypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replacementBoundaryElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectSubstitutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectHandleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseModelHandleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableValueAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass slotAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectExistenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkEndSubstitutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkHandleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurableUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeVariationPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkExistenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opaqueVariationPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ovpTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ovpSemanticSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replacementFragmentSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toPlacementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toReplacementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fromBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fromPlacementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fromReplacementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vSpecRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bclExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opaqueConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parametricVariationPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass slotValueExistenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parametricLinkEndSubstitutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parametricObjectSubstitutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parametricSlotAssignmetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceDerivationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDerivationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvSpecDerivationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurableUnitUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveValueSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bclConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unlimitedLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum primitiveTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operationEEnum = null;

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
	 * @see cvl.CvlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CvlPackageImpl() {
		super(eNS_URI, CvlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CvlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CvlPackage init() {
		if (isInited) return (CvlPackage)EPackage.Registry.INSTANCE.getEPackage(CvlPackage.eNS_URI);

		// Obtain or create and register package
		CvlPackageImpl theCvlPackage = (CvlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CvlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CvlPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCvlPackage.createPackageContents();

		// Initialize created meta-data
		theCvlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCvlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CvlPackage.eNS_URI, theCvlPackage);
		return theCvlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoice() {
		return choiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChoice_DefaultResolution() {
		return (EAttribute)choiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChoice_IsImpliedByParent() {
		return (EAttribute)choiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVSpec() {
		return vSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVSpec_GroupMultiplicity() {
		return (EReference)vSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVSpec_ResolutionTime() {
		return (EAttribute)vSpecEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVSpec_OwnedVSpecDerivation() {
		return (EReference)vSpecEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVSpec_Child() {
		return (EReference)vSpecEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVPackageable() {
		return vPackageableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicityInterval() {
		return multiplicityIntervalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicityInterval_Upper() {
		return (EAttribute)multiplicityIntervalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicityInterval_Lower() {
		return (EAttribute)multiplicityIntervalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVSpecDerivation() {
		return vSpecDerivationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVSpecDerivation_DerivedVSpec() {
		return (EReference)vSpecDerivationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVClassifier() {
		return vClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVClassifier_InstanceMultiplicity() {
		return (EReference)vClassifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVSpecResolution() {
		return vSpecResolutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVSpecResolution_ResolvedVSpec() {
		return (EReference)vSpecResolutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVSpecResolution_Child() {
		return (EReference)vSpecResolutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoiceResolutuion() {
		return choiceResolutuionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceResolutuion_ResolvedChoice() {
		return (EReference)choiceResolutuionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChoiceResolutuion_Decision() {
		return (EAttribute)choiceResolutuionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVInstance() {
		return vInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVInstance_Type() {
		return (EReference)vInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariationPoint() {
		return variationPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariationPoint_BindingVSpec() {
		return (EReference)variationPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFragmentSubstitution() {
		return fragmentSubstitutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentSubstitution_BoundaryElementBinding() {
		return (EReference)fragmentSubstitutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentSubstitution_Placement() {
		return (EReference)fragmentSubstitutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFragmentSubstitution_Multi() {
		return (EAttribute)fragmentSubstitutionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentSubstitution_Replacement() {
		return (EReference)fragmentSubstitutionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentSubstitution_SourceObject() {
		return (EReference)fragmentSubstitutionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoiceVariationPoint() {
		return choiceVariationPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceVariationPoint_BindingChoice() {
		return (EReference)choiceVariationPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepeatableVariationPoint() {
		return repeatableVariationPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepeatableVariationPoint_BindingClassifier() {
		return (EReference)repeatableVariationPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundaryElementBinding() {
		return boundaryElementBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlacementFragment() {
		return placementFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlacementFragment_PlacementBoundaryElement() {
		return (EReference)placementFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlacementBoundaryElement() {
		return placementBoundaryElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplacementFragmentType() {
		return replacementFragmentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReplacementFragmentType_ReplacementBoundaryElement() {
		return (EReference)replacementFragmentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReplacementFragmentType_PlacementFragment() {
		return (EReference)replacementFragmentTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariabletype() {
		return variabletypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplacementBoundaryElement() {
		return replacementBoundaryElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectSubstitution() {
		return objectSubstitutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectSubstitution_PlacementObject() {
		return (EReference)objectSubstitutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectSubstitution_ReplacementObject() {
		return (EReference)objectSubstitutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectHandle() {
		return objectHandleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectHandle_MOFRef() {
		return (EReference)objectHandleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseModelHandle() {
		return baseModelHandleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_ReplacementFragmentTypesubsetstype() {
		return (EReference)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_DefaulValue() {
		return (EReference)variableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Type() {
		return (EReference)variableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueSpecification() {
		return valueSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueSpecification_Type() {
		return (EReference)valueSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableValueAssignment() {
		return variableValueAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableValueAssignment_ResolvedVariable() {
		return (EReference)variableValueAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableValueAssignment_Value() {
		return (EReference)variableValueAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitveType() {
		return primitveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitveType_Type() {
		return (EAttribute)primitveTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectType() {
		return objectTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectType_MetaClass() {
		return (EAttribute)objectTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVInterface() {
		return vInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVInterface_Member() {
		return (EReference)vInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVInterface_OwnedConstraint() {
		return (EReference)vInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Context() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSlotAssignment() {
		return slotAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSlotAssignment_SlotIdentifier() {
		return (EAttribute)slotAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSlotAssignment_Value() {
		return (EReference)slotAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSlotAssignment_SlotOwner() {
		return (EReference)slotAssignmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectExistence() {
		return objectExistenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectExistence_OptionalObject() {
		return (EReference)objectExistenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkEndSubstitution() {
		return linkEndSubstitutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkEndSubstitution_Link() {
		return (EReference)linkEndSubstitutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkEndSubstitution_LinkEndIdentifier() {
		return (EAttribute)linkEndSubstitutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkEndSubstitution_ReplacementObject() {
		return (EReference)linkEndSubstitutionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkHandle() {
		return linkHandleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkHandle_MOFRef() {
		return (EAttribute)linkHandleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurableUnit() {
		return configurableUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurableUnit_OwnedVSpec() {
		return (EReference)configurableUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurableUnit_OwnedVariationPoint() {
		return (EReference)configurableUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurableUnit_OwnedConstraint() {
		return (EReference)configurableUnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurableUnit_ConfigurableContainerObject() {
		return (EReference)configurableUnitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurableUnit_OwnedVSpecResolution() {
		return (EReference)configurableUnitEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurableUnit_UnitInterface() {
		return (EReference)configurableUnitEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurableUnit_OwnedVSpecDerivation() {
		return (EReference)configurableUnitEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurableUnit_OwnedVariabletype() {
		return (EReference)configurableUnitEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeVariationPoint() {
		return compositeVariationPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeVariationPoint_BindingCVSpec() {
		return (EReference)compositeVariationPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVSpec() {
		return cvSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCVSpec_Type() {
		return (EReference)cvSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVConfiguration() {
		return vConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVConfiguration_Member() {
		return (EReference)vConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVConfiguration_IsPartial() {
		return (EAttribute)vConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVConfiguration_ResolvedCVSpec() {
		return (EReference)vConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkExistence() {
		return linkExistenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkExistence_OptionalLink() {
		return (EReference)linkExistenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpaqueVariationPoint() {
		return opaqueVariationPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOpaqueVariationPoint_PlaceHolder() {
		return (EReference)opaqueVariationPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOpaqueVariationPoint_SourceObject() {
		return (EReference)opaqueVariationPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOpaqueVariationPoint_Type() {
		return (EReference)opaqueVariationPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOVPType() {
		return ovpTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOVPType_Spec() {
		return (EReference)ovpTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOVPSemanticSpec() {
		return ovpSemanticSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOVPSemanticSpec_ModelTransformation() {
		return (EAttribute)ovpSemanticSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOVPSemanticSpec_TransfromationLanguage() {
		return (EAttribute)ovpSemanticSpecEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectSpecification() {
		return objectSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectSpecification_Object() {
		return (EReference)objectSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplacementFragmentSpecification() {
		return replacementFragmentSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVPackage() {
		return vPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVPackage_PackageElement() {
		return (EReference)vPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToBinding() {
		return toBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToBinding_ToPlacement() {
		return (EReference)toBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToBinding_ToReplacement() {
		return (EReference)toBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToPlacement() {
		return toPlacementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToPlacement_ToReplacement() {
		return (EReference)toPlacementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToPlacement_PropertyName() {
		return (EAttribute)toPlacementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToPlacement_InsideBoundaryElement() {
		return (EReference)toPlacementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToPlacement_OutsideBoundaryElement() {
		return (EReference)toPlacementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToReplacement() {
		return toReplacementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToReplacement_InsideBoundaryElement() {
		return (EReference)toReplacementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToReplacement_OutsideBoundaryElement() {
		return (EReference)toReplacementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToReplacement_ToPlacement() {
		return (EReference)toReplacementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFromBinding() {
		return fromBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromBinding_FromPlacement() {
		return (EReference)fromBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromBinding_FromReplacement() {
		return (EReference)fromBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFromPlacement() {
		return fromPlacementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromPlacement_FromReplacement() {
		return (EReference)fromPlacementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromPlacement_OutsideBoundaryElement() {
		return (EReference)fromPlacementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromPlacement_InsideBoundaryElement() {
		return (EReference)fromPlacementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFromReplacement() {
		return fromReplacementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFromReplacement_PropertyName() {
		return (EAttribute)fromReplacementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromReplacement_InsideBoundaryElement() {
		return (EReference)fromReplacementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromReplacement_OutsideBoundaryElement() {
		return (EReference)fromReplacementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromReplacement_FromPlacement() {
		return (EReference)fromReplacementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVSpecRef() {
		return vSpecRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVSpecRef_VSpec() {
		return (EReference)vSpecRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBCLExpression() {
		return bclExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpaqueConstraint() {
		return opaqueConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpaqueConstraint_Constraint() {
		return (EAttribute)opaqueConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpaqueConstraint_ConstraintLanguage() {
		return (EAttribute)opaqueConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParametricVariationPoint() {
		return parametricVariationPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParametricVariationPoint_BindingVariable() {
		return (EReference)parametricVariationPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSlotValueExistence() {
		return slotValueExistenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSlotValueExistence_SlotIdentifier() {
		return (EAttribute)slotValueExistenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSlotValueExistence_SlotOwner() {
		return (EReference)slotValueExistenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParametricLinkEndSubstitution() {
		return parametricLinkEndSubstitutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParametricLinkEndSubstitution_LinkEndIdentifier() {
		return (EAttribute)parametricLinkEndSubstitutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParametricLinkEndSubstitution_Link() {
		return (EReference)parametricLinkEndSubstitutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParametricObjectSubstitution() {
		return parametricObjectSubstitutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParametricObjectSubstitution_PlacementObject() {
		return (EReference)parametricObjectSubstitutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParametricSlotAssignmet() {
		return parametricSlotAssignmetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParametricSlotAssignmet_SlotIdentifier() {
		return (EAttribute)parametricSlotAssignmetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParametricSlotAssignmet_SlotOwner() {
		return (EReference)parametricSlotAssignmetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoiceDerivation() {
		return choiceDerivationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceDerivation_DerivingConstraint() {
		return (EReference)choiceDerivationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceDerivation_DerivedChoice() {
		return (EReference)choiceDerivationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableDerivation() {
		return variableDerivationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDerivation_DerivingExpression() {
		return (EReference)variableDerivationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDerivation_DerivedVariable() {
		return (EReference)variableDerivationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVSpecDerivation() {
		return cvSpecDerivationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCVSpecDerivation_MemberDerivation() {
		return (EReference)cvSpecDerivationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCVSpecDerivation_DerivingCVspec() {
		return (EReference)cvSpecDerivationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCVSpecDerivation_DerivedCVSpec() {
		return (EReference)cvSpecDerivationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurableUnitUsage() {
		return configurableUnitUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurableUnitUsage_UsedUnit() {
		return (EReference)configurableUnitUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurableUnitUsage_UsageReference() {
		return (EReference)configurableUnitUsageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurableUnitUsage_LinkEndIdentifier() {
		return (EAttribute)configurableUnitUsageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurableUnitUsage_UnitUsageInterface() {
		return (EReference)configurableUnitUsageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveValueSpecification() {
		return primitiveValueSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveValueSpecification_Expression() {
		return (EReference)primitiveValueSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBCLConstraint() {
		return bclConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBCLConstraint_Expression() {
		return (EReference)bclConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationCallExp() {
		return operationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCallExp_Argument() {
		return (EReference)operationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationCallExp_Operation() {
		return (EAttribute)operationCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanLiteralExp() {
		return booleanLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanLiteralExp_Bool() {
		return (EAttribute)booleanLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringLiteralExp() {
		return stringLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringLiteralExp_String() {
		return (EAttribute)stringLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericLiteralExp() {
		return numericLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerLiteralExp() {
		return integerLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerLiteralExp_Integer() {
		return (EAttribute)integerLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnlimitedLiteralExp() {
		return unlimitedLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnlimitedLiteralExp_Unlimited() {
		return (EAttribute)unlimitedLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealLiteralExp() {
		return realLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRealLiteralExp_Real() {
		return (EAttribute)realLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPrimitiveTypeEnum() {
		return primitiveTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOperation() {
		return operationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CvlFactory getCvlFactory() {
		return (CvlFactory)getEFactoryInstance();
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
		choiceEClass = createEClass(CHOICE);
		createEAttribute(choiceEClass, CHOICE__DEFAULT_RESOLUTION);
		createEAttribute(choiceEClass, CHOICE__IS_IMPLIED_BY_PARENT);

		vSpecEClass = createEClass(VSPEC);
		createEReference(vSpecEClass, VSPEC__GROUP_MULTIPLICITY);
		createEAttribute(vSpecEClass, VSPEC__RESOLUTION_TIME);
		createEReference(vSpecEClass, VSPEC__OWNED_VSPEC_DERIVATION);
		createEReference(vSpecEClass, VSPEC__CHILD);

		vPackageableEClass = createEClass(VPACKAGEABLE);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		multiplicityIntervalEClass = createEClass(MULTIPLICITY_INTERVAL);
		createEAttribute(multiplicityIntervalEClass, MULTIPLICITY_INTERVAL__UPPER);
		createEAttribute(multiplicityIntervalEClass, MULTIPLICITY_INTERVAL__LOWER);

		vSpecDerivationEClass = createEClass(VSPEC_DERIVATION);
		createEReference(vSpecDerivationEClass, VSPEC_DERIVATION__DERIVED_VSPEC);

		vClassifierEClass = createEClass(VCLASSIFIER);
		createEReference(vClassifierEClass, VCLASSIFIER__INSTANCE_MULTIPLICITY);

		vSpecResolutionEClass = createEClass(VSPEC_RESOLUTION);
		createEReference(vSpecResolutionEClass, VSPEC_RESOLUTION__RESOLVED_VSPEC);
		createEReference(vSpecResolutionEClass, VSPEC_RESOLUTION__CHILD);

		choiceResolutuionEClass = createEClass(CHOICE_RESOLUTUION);
		createEReference(choiceResolutuionEClass, CHOICE_RESOLUTUION__RESOLVED_CHOICE);
		createEAttribute(choiceResolutuionEClass, CHOICE_RESOLUTUION__DECISION);

		vInstanceEClass = createEClass(VINSTANCE);
		createEReference(vInstanceEClass, VINSTANCE__TYPE);

		variationPointEClass = createEClass(VARIATION_POINT);
		createEReference(variationPointEClass, VARIATION_POINT__BINDING_VSPEC);

		fragmentSubstitutionEClass = createEClass(FRAGMENT_SUBSTITUTION);
		createEReference(fragmentSubstitutionEClass, FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING);
		createEReference(fragmentSubstitutionEClass, FRAGMENT_SUBSTITUTION__PLACEMENT);
		createEAttribute(fragmentSubstitutionEClass, FRAGMENT_SUBSTITUTION__MULTI);
		createEReference(fragmentSubstitutionEClass, FRAGMENT_SUBSTITUTION__REPLACEMENT);
		createEReference(fragmentSubstitutionEClass, FRAGMENT_SUBSTITUTION__SOURCE_OBJECT);

		choiceVariationPointEClass = createEClass(CHOICE_VARIATION_POINT);
		createEReference(choiceVariationPointEClass, CHOICE_VARIATION_POINT__BINDING_CHOICE);

		repeatableVariationPointEClass = createEClass(REPEATABLE_VARIATION_POINT);
		createEReference(repeatableVariationPointEClass, REPEATABLE_VARIATION_POINT__BINDING_CLASSIFIER);

		boundaryElementBindingEClass = createEClass(BOUNDARY_ELEMENT_BINDING);

		placementFragmentEClass = createEClass(PLACEMENT_FRAGMENT);
		createEReference(placementFragmentEClass, PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT);

		placementBoundaryElementEClass = createEClass(PLACEMENT_BOUNDARY_ELEMENT);

		replacementFragmentTypeEClass = createEClass(REPLACEMENT_FRAGMENT_TYPE);
		createEReference(replacementFragmentTypeEClass, REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT);
		createEReference(replacementFragmentTypeEClass, REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT);

		variabletypeEClass = createEClass(VARIABLETYPE);

		replacementBoundaryElementEClass = createEClass(REPLACEMENT_BOUNDARY_ELEMENT);

		objectSubstitutionEClass = createEClass(OBJECT_SUBSTITUTION);
		createEReference(objectSubstitutionEClass, OBJECT_SUBSTITUTION__PLACEMENT_OBJECT);
		createEReference(objectSubstitutionEClass, OBJECT_SUBSTITUTION__REPLACEMENT_OBJECT);

		objectHandleEClass = createEClass(OBJECT_HANDLE);
		createEReference(objectHandleEClass, OBJECT_HANDLE__MOF_REF);

		baseModelHandleEClass = createEClass(BASE_MODEL_HANDLE);

		variableEClass = createEClass(VARIABLE);
		createEReference(variableEClass, VARIABLE__REPLACEMENT_FRAGMENT_TYPESUBSETSTYPE);
		createEReference(variableEClass, VARIABLE__DEFAUL_VALUE);
		createEReference(variableEClass, VARIABLE__TYPE);

		valueSpecificationEClass = createEClass(VALUE_SPECIFICATION);
		createEReference(valueSpecificationEClass, VALUE_SPECIFICATION__TYPE);

		variableValueAssignmentEClass = createEClass(VARIABLE_VALUE_ASSIGNMENT);
		createEReference(variableValueAssignmentEClass, VARIABLE_VALUE_ASSIGNMENT__RESOLVED_VARIABLE);
		createEReference(variableValueAssignmentEClass, VARIABLE_VALUE_ASSIGNMENT__VALUE);

		primitveTypeEClass = createEClass(PRIMITVE_TYPE);
		createEAttribute(primitveTypeEClass, PRIMITVE_TYPE__TYPE);

		objectTypeEClass = createEClass(OBJECT_TYPE);
		createEAttribute(objectTypeEClass, OBJECT_TYPE__META_CLASS);

		vInterfaceEClass = createEClass(VINTERFACE);
		createEReference(vInterfaceEClass, VINTERFACE__MEMBER);
		createEReference(vInterfaceEClass, VINTERFACE__OWNED_CONSTRAINT);

		constraintEClass = createEClass(CONSTRAINT);
		createEReference(constraintEClass, CONSTRAINT__CONTEXT);

		slotAssignmentEClass = createEClass(SLOT_ASSIGNMENT);
		createEAttribute(slotAssignmentEClass, SLOT_ASSIGNMENT__SLOT_IDENTIFIER);
		createEReference(slotAssignmentEClass, SLOT_ASSIGNMENT__VALUE);
		createEReference(slotAssignmentEClass, SLOT_ASSIGNMENT__SLOT_OWNER);

		objectExistenceEClass = createEClass(OBJECT_EXISTENCE);
		createEReference(objectExistenceEClass, OBJECT_EXISTENCE__OPTIONAL_OBJECT);

		linkEndSubstitutionEClass = createEClass(LINK_END_SUBSTITUTION);
		createEReference(linkEndSubstitutionEClass, LINK_END_SUBSTITUTION__LINK);
		createEAttribute(linkEndSubstitutionEClass, LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER);
		createEReference(linkEndSubstitutionEClass, LINK_END_SUBSTITUTION__REPLACEMENT_OBJECT);

		linkHandleEClass = createEClass(LINK_HANDLE);
		createEAttribute(linkHandleEClass, LINK_HANDLE__MOF_REF);

		configurableUnitEClass = createEClass(CONFIGURABLE_UNIT);
		createEReference(configurableUnitEClass, CONFIGURABLE_UNIT__OWNED_VSPEC);
		createEReference(configurableUnitEClass, CONFIGURABLE_UNIT__OWNED_VARIATION_POINT);
		createEReference(configurableUnitEClass, CONFIGURABLE_UNIT__OWNED_CONSTRAINT);
		createEReference(configurableUnitEClass, CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT);
		createEReference(configurableUnitEClass, CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION);
		createEReference(configurableUnitEClass, CONFIGURABLE_UNIT__UNIT_INTERFACE);
		createEReference(configurableUnitEClass, CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION);
		createEReference(configurableUnitEClass, CONFIGURABLE_UNIT__OWNED_VARIABLETYPE);

		compositeVariationPointEClass = createEClass(COMPOSITE_VARIATION_POINT);
		createEReference(compositeVariationPointEClass, COMPOSITE_VARIATION_POINT__BINDING_CV_SPEC);

		cvSpecEClass = createEClass(CV_SPEC);
		createEReference(cvSpecEClass, CV_SPEC__TYPE);

		vConfigurationEClass = createEClass(VCONFIGURATION);
		createEReference(vConfigurationEClass, VCONFIGURATION__MEMBER);
		createEAttribute(vConfigurationEClass, VCONFIGURATION__IS_PARTIAL);
		createEReference(vConfigurationEClass, VCONFIGURATION__RESOLVED_CV_SPEC);

		linkExistenceEClass = createEClass(LINK_EXISTENCE);
		createEReference(linkExistenceEClass, LINK_EXISTENCE__OPTIONAL_LINK);

		opaqueVariationPointEClass = createEClass(OPAQUE_VARIATION_POINT);
		createEReference(opaqueVariationPointEClass, OPAQUE_VARIATION_POINT__PLACE_HOLDER);
		createEReference(opaqueVariationPointEClass, OPAQUE_VARIATION_POINT__SOURCE_OBJECT);
		createEReference(opaqueVariationPointEClass, OPAQUE_VARIATION_POINT__TYPE);

		ovpTypeEClass = createEClass(OVP_TYPE);
		createEReference(ovpTypeEClass, OVP_TYPE__SPEC);

		ovpSemanticSpecEClass = createEClass(OVP_SEMANTIC_SPEC);
		createEAttribute(ovpSemanticSpecEClass, OVP_SEMANTIC_SPEC__MODEL_TRANSFORMATION);
		createEAttribute(ovpSemanticSpecEClass, OVP_SEMANTIC_SPEC__TRANSFROMATION_LANGUAGE);

		objectSpecificationEClass = createEClass(OBJECT_SPECIFICATION);
		createEReference(objectSpecificationEClass, OBJECT_SPECIFICATION__OBJECT);

		replacementFragmentSpecificationEClass = createEClass(REPLACEMENT_FRAGMENT_SPECIFICATION);

		vPackageEClass = createEClass(VPACKAGE);
		createEReference(vPackageEClass, VPACKAGE__PACKAGE_ELEMENT);

		toBindingEClass = createEClass(TO_BINDING);
		createEReference(toBindingEClass, TO_BINDING__TO_PLACEMENT);
		createEReference(toBindingEClass, TO_BINDING__TO_REPLACEMENT);

		toPlacementEClass = createEClass(TO_PLACEMENT);
		createEReference(toPlacementEClass, TO_PLACEMENT__TO_REPLACEMENT);
		createEAttribute(toPlacementEClass, TO_PLACEMENT__PROPERTY_NAME);
		createEReference(toPlacementEClass, TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT);
		createEReference(toPlacementEClass, TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT);

		toReplacementEClass = createEClass(TO_REPLACEMENT);
		createEReference(toReplacementEClass, TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT);
		createEReference(toReplacementEClass, TO_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT);
		createEReference(toReplacementEClass, TO_REPLACEMENT__TO_PLACEMENT);

		fromBindingEClass = createEClass(FROM_BINDING);
		createEReference(fromBindingEClass, FROM_BINDING__FROM_PLACEMENT);
		createEReference(fromBindingEClass, FROM_BINDING__FROM_REPLACEMENT);

		fromPlacementEClass = createEClass(FROM_PLACEMENT);
		createEReference(fromPlacementEClass, FROM_PLACEMENT__FROM_REPLACEMENT);
		createEReference(fromPlacementEClass, FROM_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT);
		createEReference(fromPlacementEClass, FROM_PLACEMENT__INSIDE_BOUNDARY_ELEMENT);

		fromReplacementEClass = createEClass(FROM_REPLACEMENT);
		createEAttribute(fromReplacementEClass, FROM_REPLACEMENT__PROPERTY_NAME);
		createEReference(fromReplacementEClass, FROM_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT);
		createEReference(fromReplacementEClass, FROM_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT);
		createEReference(fromReplacementEClass, FROM_REPLACEMENT__FROM_PLACEMENT);

		vSpecRefEClass = createEClass(VSPEC_REF);
		createEReference(vSpecRefEClass, VSPEC_REF__VSPEC);

		bclExpressionEClass = createEClass(BCL_EXPRESSION);

		opaqueConstraintEClass = createEClass(OPAQUE_CONSTRAINT);
		createEAttribute(opaqueConstraintEClass, OPAQUE_CONSTRAINT__CONSTRAINT);
		createEAttribute(opaqueConstraintEClass, OPAQUE_CONSTRAINT__CONSTRAINT_LANGUAGE);

		parametricVariationPointEClass = createEClass(PARAMETRIC_VARIATION_POINT);
		createEReference(parametricVariationPointEClass, PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE);

		slotValueExistenceEClass = createEClass(SLOT_VALUE_EXISTENCE);
		createEAttribute(slotValueExistenceEClass, SLOT_VALUE_EXISTENCE__SLOT_IDENTIFIER);
		createEReference(slotValueExistenceEClass, SLOT_VALUE_EXISTENCE__SLOT_OWNER);

		parametricLinkEndSubstitutionEClass = createEClass(PARAMETRIC_LINK_END_SUBSTITUTION);
		createEAttribute(parametricLinkEndSubstitutionEClass, PARAMETRIC_LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER);
		createEReference(parametricLinkEndSubstitutionEClass, PARAMETRIC_LINK_END_SUBSTITUTION__LINK);

		parametricObjectSubstitutionEClass = createEClass(PARAMETRIC_OBJECT_SUBSTITUTION);
		createEReference(parametricObjectSubstitutionEClass, PARAMETRIC_OBJECT_SUBSTITUTION__PLACEMENT_OBJECT);

		parametricSlotAssignmetEClass = createEClass(PARAMETRIC_SLOT_ASSIGNMET);
		createEAttribute(parametricSlotAssignmetEClass, PARAMETRIC_SLOT_ASSIGNMET__SLOT_IDENTIFIER);
		createEReference(parametricSlotAssignmetEClass, PARAMETRIC_SLOT_ASSIGNMET__SLOT_OWNER);

		choiceDerivationEClass = createEClass(CHOICE_DERIVATION);
		createEReference(choiceDerivationEClass, CHOICE_DERIVATION__DERIVING_CONSTRAINT);
		createEReference(choiceDerivationEClass, CHOICE_DERIVATION__DERIVED_CHOICE);

		variableDerivationEClass = createEClass(VARIABLE_DERIVATION);
		createEReference(variableDerivationEClass, VARIABLE_DERIVATION__DERIVING_EXPRESSION);
		createEReference(variableDerivationEClass, VARIABLE_DERIVATION__DERIVED_VARIABLE);

		cvSpecDerivationEClass = createEClass(CV_SPEC_DERIVATION);
		createEReference(cvSpecDerivationEClass, CV_SPEC_DERIVATION__MEMBER_DERIVATION);
		createEReference(cvSpecDerivationEClass, CV_SPEC_DERIVATION__DERIVING_CVSPEC);
		createEReference(cvSpecDerivationEClass, CV_SPEC_DERIVATION__DERIVED_CV_SPEC);

		configurableUnitUsageEClass = createEClass(CONFIGURABLE_UNIT_USAGE);
		createEReference(configurableUnitUsageEClass, CONFIGURABLE_UNIT_USAGE__USED_UNIT);
		createEReference(configurableUnitUsageEClass, CONFIGURABLE_UNIT_USAGE__USAGE_REFERENCE);
		createEAttribute(configurableUnitUsageEClass, CONFIGURABLE_UNIT_USAGE__LINK_END_IDENTIFIER);
		createEReference(configurableUnitUsageEClass, CONFIGURABLE_UNIT_USAGE__UNIT_USAGE_INTERFACE);

		primitiveValueSpecificationEClass = createEClass(PRIMITIVE_VALUE_SPECIFICATION);
		createEReference(primitiveValueSpecificationEClass, PRIMITIVE_VALUE_SPECIFICATION__EXPRESSION);

		bclConstraintEClass = createEClass(BCL_CONSTRAINT);
		createEReference(bclConstraintEClass, BCL_CONSTRAINT__EXPRESSION);

		operationCallExpEClass = createEClass(OPERATION_CALL_EXP);
		createEReference(operationCallExpEClass, OPERATION_CALL_EXP__ARGUMENT);
		createEAttribute(operationCallExpEClass, OPERATION_CALL_EXP__OPERATION);

		booleanLiteralExpEClass = createEClass(BOOLEAN_LITERAL_EXP);
		createEAttribute(booleanLiteralExpEClass, BOOLEAN_LITERAL_EXP__BOOL);

		stringLiteralExpEClass = createEClass(STRING_LITERAL_EXP);
		createEAttribute(stringLiteralExpEClass, STRING_LITERAL_EXP__STRING);

		numericLiteralExpEClass = createEClass(NUMERIC_LITERAL_EXP);

		integerLiteralExpEClass = createEClass(INTEGER_LITERAL_EXP);
		createEAttribute(integerLiteralExpEClass, INTEGER_LITERAL_EXP__INTEGER);

		unlimitedLiteralExpEClass = createEClass(UNLIMITED_LITERAL_EXP);
		createEAttribute(unlimitedLiteralExpEClass, UNLIMITED_LITERAL_EXP__UNLIMITED);

		realLiteralExpEClass = createEClass(REAL_LITERAL_EXP);
		createEAttribute(realLiteralExpEClass, REAL_LITERAL_EXP__REAL);

		// Create enums
		primitiveTypeEnumEEnum = createEEnum(PRIMITIVE_TYPE_ENUM);
		operationEEnum = createEEnum(OPERATION);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		choiceEClass.getESuperTypes().add(this.getVSpec());
		vSpecEClass.getESuperTypes().add(this.getVPackageable());
		vPackageableEClass.getESuperTypes().add(this.getNamedElement());
		vSpecDerivationEClass.getESuperTypes().add(this.getVPackageable());
		vClassifierEClass.getESuperTypes().add(this.getVSpec());
		vSpecResolutionEClass.getESuperTypes().add(this.getVPackageable());
		choiceResolutuionEClass.getESuperTypes().add(this.getVSpecResolution());
		vInstanceEClass.getESuperTypes().add(this.getVSpecResolution());
		variationPointEClass.getESuperTypes().add(this.getVPackageable());
		fragmentSubstitutionEClass.getESuperTypes().add(this.getChoiceVariationPoint());
		fragmentSubstitutionEClass.getESuperTypes().add(this.getRepeatableVariationPoint());
		choiceVariationPointEClass.getESuperTypes().add(this.getVariationPoint());
		repeatableVariationPointEClass.getESuperTypes().add(this.getVariationPoint());
		placementFragmentEClass.getESuperTypes().add(this.getVariationPoint());
		replacementFragmentTypeEClass.getESuperTypes().add(this.getVariabletype());
		variabletypeEClass.getESuperTypes().add(this.getVPackageable());
		objectSubstitutionEClass.getESuperTypes().add(this.getChoiceVariationPoint());
		objectHandleEClass.getESuperTypes().add(this.getBaseModelHandle());
		variableEClass.getESuperTypes().add(this.getVSpec());
		variableValueAssignmentEClass.getESuperTypes().add(this.getVSpecResolution());
		primitveTypeEClass.getESuperTypes().add(this.getVariabletype());
		objectTypeEClass.getESuperTypes().add(this.getVariabletype());
		vInterfaceEClass.getESuperTypes().add(this.getVPackageable());
		constraintEClass.getESuperTypes().add(this.getVPackageable());
		slotAssignmentEClass.getESuperTypes().add(this.getChoiceVariationPoint());
		objectExistenceEClass.getESuperTypes().add(this.getChoiceVariationPoint());
		linkEndSubstitutionEClass.getESuperTypes().add(this.getChoiceVariationPoint());
		linkHandleEClass.getESuperTypes().add(this.getBaseModelHandle());
		configurableUnitEClass.getESuperTypes().add(this.getCompositeVariationPoint());
		compositeVariationPointEClass.getESuperTypes().add(this.getVariationPoint());
		cvSpecEClass.getESuperTypes().add(this.getVSpec());
		vConfigurationEClass.getESuperTypes().add(this.getVSpecResolution());
		vConfigurationEClass.getESuperTypes().add(this.getVPackageable());
		linkExistenceEClass.getESuperTypes().add(this.getChoiceVariationPoint());
		opaqueVariationPointEClass.getESuperTypes().add(this.getVariationPoint());
		ovpTypeEClass.getESuperTypes().add(this.getVPackageable());
		objectSpecificationEClass.getESuperTypes().add(this.getValueSpecification());
		replacementFragmentSpecificationEClass.getESuperTypes().add(this.getValueSpecification());
		vPackageEClass.getESuperTypes().add(this.getVPackageable());
		toBindingEClass.getESuperTypes().add(this.getBoundaryElementBinding());
		toPlacementEClass.getESuperTypes().add(this.getPlacementBoundaryElement());
		toReplacementEClass.getESuperTypes().add(this.getReplacementBoundaryElement());
		fromBindingEClass.getESuperTypes().add(this.getBoundaryElementBinding());
		fromPlacementEClass.getESuperTypes().add(this.getPlacementBoundaryElement());
		fromReplacementEClass.getESuperTypes().add(this.getReplacementBoundaryElement());
		vSpecRefEClass.getESuperTypes().add(this.getBCLExpression());
		opaqueConstraintEClass.getESuperTypes().add(this.getConstraint());
		parametricVariationPointEClass.getESuperTypes().add(this.getVariationPoint());
		slotValueExistenceEClass.getESuperTypes().add(this.getChoiceVariationPoint());
		parametricLinkEndSubstitutionEClass.getESuperTypes().add(this.getParametricVariationPoint());
		parametricObjectSubstitutionEClass.getESuperTypes().add(this.getParametricVariationPoint());
		parametricSlotAssignmetEClass.getESuperTypes().add(this.getParametricVariationPoint());
		choiceDerivationEClass.getESuperTypes().add(this.getVSpecDerivation());
		variableDerivationEClass.getESuperTypes().add(this.getVSpecDerivation());
		cvSpecDerivationEClass.getESuperTypes().add(this.getVSpecDerivation());
		configurableUnitUsageEClass.getESuperTypes().add(this.getCompositeVariationPoint());
		primitiveValueSpecificationEClass.getESuperTypes().add(this.getValueSpecification());
		bclConstraintEClass.getESuperTypes().add(this.getConstraint());
		operationCallExpEClass.getESuperTypes().add(this.getBCLExpression());
		booleanLiteralExpEClass.getESuperTypes().add(this.getBCLExpression());
		stringLiteralExpEClass.getESuperTypes().add(this.getBCLExpression());
		numericLiteralExpEClass.getESuperTypes().add(this.getBCLExpression());
		integerLiteralExpEClass.getESuperTypes().add(this.getNumericLiteralExp());
		unlimitedLiteralExpEClass.getESuperTypes().add(this.getNumericLiteralExp());
		realLiteralExpEClass.getESuperTypes().add(this.getNumericLiteralExp());

		// Initialize classes and features; add operations and parameters
		initEClass(choiceEClass, Choice.class, "Choice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChoice_DefaultResolution(), ecorePackage.getEBoolean(), "defaultResolution", null, 0, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getChoice_IsImpliedByParent(), ecorePackage.getEBoolean(), "isImpliedByParent", null, 1, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vSpecEClass, VSpec.class, "VSpec", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVSpec_GroupMultiplicity(), this.getMultiplicityInterval(), null, "groupMultiplicity", null, 0, 1, VSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVSpec_ResolutionTime(), ecorePackage.getEString(), "resolutionTime", null, 1, 1, VSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVSpec_OwnedVSpecDerivation(), this.getVSpecDerivation(), null, "ownedVSpecDerivation", null, 0, -1, VSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVSpec_Child(), this.getVSpec(), null, "child", null, 0, -1, VSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vPackageableEClass, VPackageable.class, "VPackageable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(multiplicityIntervalEClass, MultiplicityInterval.class, "MultiplicityInterval", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiplicityInterval_Upper(), ecorePackage.getEInt(), "upper", null, 1, 1, MultiplicityInterval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMultiplicityInterval_Lower(), ecorePackage.getEInt(), "lower", null, 1, 1, MultiplicityInterval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vSpecDerivationEClass, VSpecDerivation.class, "VSpecDerivation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVSpecDerivation_DerivedVSpec(), this.getVSpec(), null, "derivedVSpec", null, 0, 1, VSpecDerivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vClassifierEClass, VClassifier.class, "VClassifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVClassifier_InstanceMultiplicity(), this.getMultiplicityInterval(), null, "instanceMultiplicity", null, 1, 1, VClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vSpecResolutionEClass, VSpecResolution.class, "VSpecResolution", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVSpecResolution_ResolvedVSpec(), this.getVSpec(), null, "resolvedVSpec", null, 1, 1, VSpecResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVSpecResolution_Child(), this.getVSpecResolution(), null, "child", null, 0, -1, VSpecResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(choiceResolutuionEClass, ChoiceResolutuion.class, "ChoiceResolutuion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoiceResolutuion_ResolvedChoice(), this.getChoice(), null, "resolvedChoice", null, 1, 1, ChoiceResolutuion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getChoiceResolutuion_Decision(), ecorePackage.getEBoolean(), "decision", null, 1, 1, ChoiceResolutuion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vInstanceEClass, VInstance.class, "VInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVInstance_Type(), this.getVClassifier(), null, "type", null, 1, 1, VInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variationPointEClass, VariationPoint.class, "VariationPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariationPoint_BindingVSpec(), this.getVSpec(), null, "bindingVSpec", null, 1, 1, VariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fragmentSubstitutionEClass, FragmentSubstitution.class, "FragmentSubstitution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFragmentSubstitution_BoundaryElementBinding(), this.getBoundaryElementBinding(), null, "boundaryElementBinding", null, 0, -1, FragmentSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFragmentSubstitution_Placement(), this.getPlacementFragment(), null, "placement", null, 1, 1, FragmentSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFragmentSubstitution_Multi(), ecorePackage.getEBoolean(), "multi", null, 1, 1, FragmentSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFragmentSubstitution_Replacement(), this.getReplacementFragmentType(), null, "replacement", null, 0, 1, FragmentSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFragmentSubstitution_SourceObject(), this.getObjectHandle(), null, "sourceObject", null, 0, -1, FragmentSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(choiceVariationPointEClass, ChoiceVariationPoint.class, "ChoiceVariationPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoiceVariationPoint_BindingChoice(), this.getChoice(), null, "bindingChoice", null, 0, 1, ChoiceVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(repeatableVariationPointEClass, RepeatableVariationPoint.class, "RepeatableVariationPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepeatableVariationPoint_BindingClassifier(), this.getVClassifier(), null, "bindingClassifier", null, 0, 1, RepeatableVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(boundaryElementBindingEClass, BoundaryElementBinding.class, "BoundaryElementBinding", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(placementFragmentEClass, PlacementFragment.class, "PlacementFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlacementFragment_PlacementBoundaryElement(), this.getPlacementBoundaryElement(), null, "placementBoundaryElement", null, 0, -1, PlacementFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(placementBoundaryElementEClass, PlacementBoundaryElement.class, "PlacementBoundaryElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(replacementFragmentTypeEClass, ReplacementFragmentType.class, "ReplacementFragmentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReplacementFragmentType_ReplacementBoundaryElement(), this.getReplacementBoundaryElement(), null, "replacementBoundaryElement", null, 0, -1, ReplacementFragmentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getReplacementFragmentType_PlacementFragment(), this.getPlacementFragment(), null, "placementFragment", null, 0, -1, ReplacementFragmentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variabletypeEClass, Variabletype.class, "Variabletype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(replacementBoundaryElementEClass, ReplacementBoundaryElement.class, "ReplacementBoundaryElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectSubstitutionEClass, ObjectSubstitution.class, "ObjectSubstitution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectSubstitution_PlacementObject(), this.getObjectHandle(), null, "placementObject", null, 1, 1, ObjectSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getObjectSubstitution_ReplacementObject(), this.getObjectHandle(), null, "replacementObject", null, 1, 1, ObjectSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(objectHandleEClass, ObjectHandle.class, "ObjectHandle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectHandle_MOFRef(), ecorePackage.getEObject(), null, "MOFRef", null, 1, 1, ObjectHandle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(baseModelHandleEClass, BaseModelHandle.class, "BaseModelHandle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariable_ReplacementFragmentTypesubsetstype(), this.getReplacementFragmentType(), null, "replacementFragmentTypesubsetstype", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariable_DefaulValue(), this.getValueSpecification(), null, "defaulValue", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariable_Type(), this.getVariabletype(), null, "type", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(valueSpecificationEClass, ValueSpecification.class, "ValueSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValueSpecification_Type(), this.getVariabletype(), null, "type", null, 1, 1, ValueSpecification.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(variableValueAssignmentEClass, VariableValueAssignment.class, "VariableValueAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableValueAssignment_ResolvedVariable(), this.getVariable(), null, "resolvedVariable", null, 1, 1, VariableValueAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableValueAssignment_Value(), this.getValueSpecification(), null, "value", null, 1, 1, VariableValueAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(primitveTypeEClass, PrimitveType.class, "PrimitveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitveType_Type(), this.getPrimitiveTypeEnum(), "type", null, 1, 1, PrimitveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(objectTypeEClass, ObjectType.class, "ObjectType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjectType_MetaClass(), ecorePackage.getEString(), "metaClass", null, 1, 1, ObjectType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vInterfaceEClass, VInterface.class, "VInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVInterface_Member(), this.getVSpec(), null, "member", null, 0, -1, VInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVInterface_OwnedConstraint(), this.getConstraint(), null, "ownedConstraint", null, 0, -1, VInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraint_Context(), this.getVSpec(), null, "context", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(slotAssignmentEClass, SlotAssignment.class, "SlotAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSlotAssignment_SlotIdentifier(), ecorePackage.getEString(), "slotIdentifier", null, 1, 1, SlotAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSlotAssignment_Value(), this.getValueSpecification(), null, "value", null, 0, 1, SlotAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSlotAssignment_SlotOwner(), this.getObjectHandle(), null, "slotOwner", null, 1, 1, SlotAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(objectExistenceEClass, ObjectExistence.class, "ObjectExistence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectExistence_OptionalObject(), this.getObjectHandle(), null, "optionalObject", null, 1, 1, ObjectExistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(linkEndSubstitutionEClass, LinkEndSubstitution.class, "LinkEndSubstitution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinkEndSubstitution_Link(), this.getLinkHandle(), null, "link", null, 1, 1, LinkEndSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLinkEndSubstitution_LinkEndIdentifier(), ecorePackage.getEString(), "linkEndIdentifier", null, 1, 1, LinkEndSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLinkEndSubstitution_ReplacementObject(), this.getObjectHandle(), null, "replacementObject", null, 1, 1, LinkEndSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(linkHandleEClass, LinkHandle.class, "LinkHandle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLinkHandle_MOFRef(), ecorePackage.getEString(), "MOFRef", null, 1, 1, LinkHandle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(configurableUnitEClass, ConfigurableUnit.class, "ConfigurableUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigurableUnit_OwnedVSpec(), this.getVSpec(), null, "ownedVSpec", null, 0, -1, ConfigurableUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConfigurableUnit_OwnedVariationPoint(), this.getVariationPoint(), null, "ownedVariationPoint", null, 0, -1, ConfigurableUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConfigurableUnit_OwnedConstraint(), this.getConstraint(), null, "ownedConstraint", null, 0, -1, ConfigurableUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConfigurableUnit_ConfigurableContainerObject(), this.getObjectHandle(), null, "configurableContainerObject", null, 1, 1, ConfigurableUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConfigurableUnit_OwnedVSpecResolution(), this.getVSpecResolution(), null, "ownedVSpecResolution", null, 0, -1, ConfigurableUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConfigurableUnit_UnitInterface(), this.getVInterface(), null, "unitInterface", null, 1, 1, ConfigurableUnit.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getConfigurableUnit_OwnedVSpecDerivation(), this.getVSpecDerivation(), null, "ownedVSpecDerivation", null, 0, -1, ConfigurableUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConfigurableUnit_OwnedVariabletype(), this.getVariabletype(), null, "ownedVariabletype", null, 0, -1, ConfigurableUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(compositeVariationPointEClass, CompositeVariationPoint.class, "CompositeVariationPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeVariationPoint_BindingCVSpec(), this.getCVSpec(), null, "bindingCVSpec", null, 1, 1, CompositeVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cvSpecEClass, CVSpec.class, "CVSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCVSpec_Type(), this.getVInterface(), null, "type", null, 1, 1, CVSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vConfigurationEClass, VConfiguration.class, "VConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVConfiguration_Member(), this.getVSpecResolution(), null, "member", null, 0, -1, VConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVConfiguration_IsPartial(), ecorePackage.getEBoolean(), "isPartial", null, 1, 1, VConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVConfiguration_ResolvedCVSpec(), this.getCVSpec(), null, "resolvedCVSpec", null, 1, 1, VConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(linkExistenceEClass, LinkExistence.class, "LinkExistence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinkExistence_OptionalLink(), this.getLinkHandle(), null, "optionalLink", null, 1, 1, LinkExistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(opaqueVariationPointEClass, OpaqueVariationPoint.class, "OpaqueVariationPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOpaqueVariationPoint_PlaceHolder(), this.getBaseModelHandle(), null, "placeHolder", null, 1, 1, OpaqueVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOpaqueVariationPoint_SourceObject(), this.getObjectHandle(), null, "sourceObject", null, 1, -1, OpaqueVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOpaqueVariationPoint_Type(), this.getOVPType(), null, "type", null, 1, 1, OpaqueVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ovpTypeEClass, OVPType.class, "OVPType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOVPType_Spec(), this.getOVPSemanticSpec(), null, "spec", null, 1, 1, OVPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ovpSemanticSpecEClass, OVPSemanticSpec.class, "OVPSemanticSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOVPSemanticSpec_ModelTransformation(), ecorePackage.getEString(), "modelTransformation", null, 1, 1, OVPSemanticSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOVPSemanticSpec_TransfromationLanguage(), ecorePackage.getEString(), "transfromationLanguage", null, 1, 1, OVPSemanticSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(objectSpecificationEClass, ObjectSpecification.class, "ObjectSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectSpecification_Object(), this.getObjectHandle(), null, "object", null, 1, 1, ObjectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(replacementFragmentSpecificationEClass, ReplacementFragmentSpecification.class, "ReplacementFragmentSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vPackageEClass, VPackage.class, "VPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVPackage_PackageElement(), this.getVPackageable(), null, "packageElement", null, 0, -1, VPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(toBindingEClass, ToBinding.class, "ToBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getToBinding_ToPlacement(), this.getToPlacement(), null, "toPlacement", null, 1, 1, ToBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getToBinding_ToReplacement(), this.getToReplacement(), null, "toReplacement", null, 1, 1, ToBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(toPlacementEClass, ToPlacement.class, "ToPlacement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getToPlacement_ToReplacement(), this.getToReplacement(), this.getToReplacement_ToPlacement(), "toReplacement", null, 0, 1, ToPlacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getToPlacement_PropertyName(), ecorePackage.getEString(), "propertyName", null, 1, 1, ToPlacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getToPlacement_InsideBoundaryElement(), this.getObjectHandle(), null, "insideBoundaryElement", null, 0, -1, ToPlacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getToPlacement_OutsideBoundaryElement(), this.getObjectHandle(), null, "outsideBoundaryElement", null, 0, 1, ToPlacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(toReplacementEClass, ToReplacement.class, "ToReplacement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getToReplacement_InsideBoundaryElement(), this.getObjectHandle(), null, "insideBoundaryElement", null, 0, -1, ToReplacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getToReplacement_OutsideBoundaryElement(), this.getObjectHandle(), null, "outsideBoundaryElement", null, 0, 1, ToReplacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getToReplacement_ToPlacement(), this.getToPlacement(), this.getToPlacement_ToReplacement(), "toPlacement", null, 0, 1, ToReplacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fromBindingEClass, FromBinding.class, "FromBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFromBinding_FromPlacement(), this.getFromPlacement(), null, "fromPlacement", null, 1, 1, FromBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFromBinding_FromReplacement(), this.getFromReplacement(), null, "fromReplacement", null, 1, 1, FromBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fromPlacementEClass, FromPlacement.class, "FromPlacement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFromPlacement_FromReplacement(), this.getFromReplacement(), this.getFromReplacement_FromPlacement(), "fromReplacement", null, 0, 1, FromPlacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFromPlacement_OutsideBoundaryElement(), this.getObjectHandle(), null, "outsideBoundaryElement", null, 0, -1, FromPlacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFromPlacement_InsideBoundaryElement(), this.getObjectHandle(), null, "insideBoundaryElement", null, 0, 1, FromPlacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fromReplacementEClass, FromReplacement.class, "FromReplacement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFromReplacement_PropertyName(), ecorePackage.getEString(), "propertyName", null, 1, 1, FromReplacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFromReplacement_InsideBoundaryElement(), this.getObjectHandle(), null, "insideBoundaryElement", null, 0, 1, FromReplacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFromReplacement_OutsideBoundaryElement(), this.getObjectHandle(), null, "outsideBoundaryElement", null, 0, -1, FromReplacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFromReplacement_FromPlacement(), this.getFromPlacement(), this.getFromPlacement_FromReplacement(), "fromPlacement", null, 0, 1, FromReplacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vSpecRefEClass, VSpecRef.class, "VSpecRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVSpecRef_VSpec(), this.getVSpec(), null, "vSpec", null, 1, 1, VSpecRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(bclExpressionEClass, BCLExpression.class, "BCLExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opaqueConstraintEClass, OpaqueConstraint.class, "OpaqueConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpaqueConstraint_Constraint(), ecorePackage.getEString(), "constraint", null, 1, 1, OpaqueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOpaqueConstraint_ConstraintLanguage(), ecorePackage.getEString(), "constraintLanguage", null, 1, 1, OpaqueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parametricVariationPointEClass, ParametricVariationPoint.class, "ParametricVariationPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParametricVariationPoint_BindingVariable(), this.getVariable(), null, "bindingVariable", null, 1, 1, ParametricVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(slotValueExistenceEClass, SlotValueExistence.class, "SlotValueExistence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSlotValueExistence_SlotIdentifier(), ecorePackage.getEString(), "slotIdentifier", null, 1, 1, SlotValueExistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSlotValueExistence_SlotOwner(), this.getObjectHandle(), null, "slotOwner", null, 1, 1, SlotValueExistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parametricLinkEndSubstitutionEClass, ParametricLinkEndSubstitution.class, "ParametricLinkEndSubstitution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParametricLinkEndSubstitution_LinkEndIdentifier(), ecorePackage.getEString(), "linkEndIdentifier", null, 1, 1, ParametricLinkEndSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParametricLinkEndSubstitution_Link(), this.getLinkHandle(), null, "link", null, 1, 1, ParametricLinkEndSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parametricObjectSubstitutionEClass, ParametricObjectSubstitution.class, "ParametricObjectSubstitution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParametricObjectSubstitution_PlacementObject(), this.getObjectHandle(), null, "placementObject", null, 1, 1, ParametricObjectSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parametricSlotAssignmetEClass, ParametricSlotAssignmet.class, "ParametricSlotAssignmet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParametricSlotAssignmet_SlotIdentifier(), ecorePackage.getEString(), "slotIdentifier", null, 1, 1, ParametricSlotAssignmet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParametricSlotAssignmet_SlotOwner(), this.getObjectHandle(), null, "slotOwner", null, 1, 1, ParametricSlotAssignmet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(choiceDerivationEClass, ChoiceDerivation.class, "ChoiceDerivation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoiceDerivation_DerivingConstraint(), this.getConstraint(), null, "derivingConstraint", null, 1, 1, ChoiceDerivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getChoiceDerivation_DerivedChoice(), this.getChoice(), null, "derivedChoice", null, 1, 1, ChoiceDerivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableDerivationEClass, VariableDerivation.class, "VariableDerivation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableDerivation_DerivingExpression(), this.getBCLExpression(), null, "derivingExpression", null, 1, 1, VariableDerivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableDerivation_DerivedVariable(), this.getVariable(), null, "derivedVariable", null, 1, 1, VariableDerivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cvSpecDerivationEClass, CVSpecDerivation.class, "CVSpecDerivation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCVSpecDerivation_MemberDerivation(), this.getVSpecDerivation(), null, "memberDerivation", null, 0, -1, CVSpecDerivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCVSpecDerivation_DerivingCVspec(), this.getCVSpec(), null, "derivingCVspec", null, 1, 1, CVSpecDerivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCVSpecDerivation_DerivedCVSpec(), this.getCVSpec(), null, "derivedCVSpec", null, 1, 1, CVSpecDerivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(configurableUnitUsageEClass, ConfigurableUnitUsage.class, "ConfigurableUnitUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigurableUnitUsage_UsedUnit(), this.getConfigurableUnit(), null, "usedUnit", null, 1, 1, ConfigurableUnitUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConfigurableUnitUsage_UsageReference(), this.getLinkHandle(), null, "usageReference", null, 1, 1, ConfigurableUnitUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getConfigurableUnitUsage_LinkEndIdentifier(), ecorePackage.getEString(), "linkEndIdentifier", null, 1, 1, ConfigurableUnitUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConfigurableUnitUsage_UnitUsageInterface(), this.getVInterface(), null, "unitUsageInterface", null, 1, 1, ConfigurableUnitUsage.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(primitiveValueSpecificationEClass, PrimitiveValueSpecification.class, "PrimitiveValueSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimitiveValueSpecification_Expression(), this.getBCLExpression(), null, "expression", null, 1, 1, PrimitiveValueSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(bclConstraintEClass, BCLConstraint.class, "BCLConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBCLConstraint_Expression(), this.getBCLExpression(), null, "expression", null, 1, -1, BCLConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(operationCallExpEClass, OperationCallExp.class, "OperationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationCallExp_Argument(), this.getBCLExpression(), null, "argument", null, 0, -1, OperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOperationCallExp_Operation(), this.getOperation(), "operation", null, 1, 1, OperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(booleanLiteralExpEClass, BooleanLiteralExp.class, "BooleanLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteralExp_Bool(), ecorePackage.getEBoolean(), "bool", null, 1, 1, BooleanLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stringLiteralExpEClass, StringLiteralExp.class, "StringLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteralExp_String(), ecorePackage.getEString(), "string", null, 1, 1, StringLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(numericLiteralExpEClass, NumericLiteralExp.class, "NumericLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerLiteralExpEClass, IntegerLiteralExp.class, "IntegerLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteralExp_Integer(), ecorePackage.getEInt(), "integer", null, 1, 1, IntegerLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(unlimitedLiteralExpEClass, UnlimitedLiteralExp.class, "UnlimitedLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnlimitedLiteralExp_Unlimited(), ecorePackage.getEInt(), "unlimited", null, 1, 1, UnlimitedLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(realLiteralExpEClass, RealLiteralExp.class, "RealLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRealLiteralExp_Real(), ecorePackage.getEString(), "real", null, 1, 1, RealLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(primitiveTypeEnumEEnum, PrimitiveTypeEnum.class, "PrimitiveTypeEnum");
		addEEnumLiteral(primitiveTypeEnumEEnum, PrimitiveTypeEnum.STRING);
		addEEnumLiteral(primitiveTypeEnumEEnum, PrimitiveTypeEnum.BOOLEAN);
		addEEnumLiteral(primitiveTypeEnumEEnum, PrimitiveTypeEnum.INTEGER);
		addEEnumLiteral(primitiveTypeEnumEEnum, PrimitiveTypeEnum.REAL);
		addEEnumLiteral(primitiveTypeEnumEEnum, PrimitiveTypeEnum.UNLIMITED_NATURAL);

		initEEnum(operationEEnum, Operation.class, "Operation");
		addEEnumLiteral(operationEEnum, Operation.LOG_NOT);
		addEEnumLiteral(operationEEnum, Operation.LOG_AND);
		addEEnumLiteral(operationEEnum, Operation.LOG_OR);
		addEEnumLiteral(operationEEnum, Operation.LOG_IMPLIES);
		addEEnumLiteral(operationEEnum, Operation.LOG_XOR);
		addEEnumLiteral(operationEEnum, Operation.LOG_IFF);
		addEEnumLiteral(operationEEnum, Operation.ARITH_PLUS);
		addEEnumLiteral(operationEEnum, Operation.ARITH_MINUS);
		addEEnumLiteral(operationEEnum, Operation.ARITH_NEG);
		addEEnumLiteral(operationEEnum, Operation.ARITH_MULT);
		addEEnumLiteral(operationEEnum, Operation.ARITH_DEV);
		addEEnumLiteral(operationEEnum, Operation.STR_CONC);
		addEEnumLiteral(operationEEnum, Operation.EQ);
		addEEnumLiteral(operationEEnum, Operation.LTE);
		addEEnumLiteral(operationEEnum, Operation.GTE);
		addEEnumLiteral(operationEEnum, Operation.LT);
		addEEnumLiteral(operationEEnum, Operation.GT);
		addEEnumLiteral(operationEEnum, Operation.IS_DEFINED);
		addEEnumLiteral(operationEEnum, Operation.IS_UNDEFINED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// com.ibm.xtools.common.ui.reduction.editingCapabilities
		createComAnnotations();
	}

	/**
	 * Initializes the annotations for <b>com.ibm.xtools.common.ui.reduction.editingCapabilities</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createComAnnotations() {
		String source = "com.ibm.xtools.common.ui.reduction.editingCapabilities";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "com.ibm.xtools.activities.umlBBFragment", "1",
			 "com.ibm.xtools.activities.umlBBAction", "1",
			 "com.ibm.xtools.activities.umlBBClassTemplateParameter", "1",
			 "com.ibm.xtools.activities.umlBBPackageTemplateParameter", "1",
			 "com.ibm.xtools.activities.umlBBSequence1", "1",
			 "com.ibm.xtools.activities.umlBBRelationship1", "1",
			 "com.ibm.xtools.activities.umlBBSequence2", "1",
			 "com.ibm.xtools.activities.umlBBCollaborationUse", "1",
			 "com.ibm.xtools.activities.umlBBRelationship2", "1",
			 "com.ibm.xtools.activities.umlBBSubsystem", "1",
			 "com.ibm.xtools.activities.umlBBComment1", "1",
			 "com.ibm.xtools.activities.umlBBLifeLine", "1",
			 "com.ibm.xtools.activities.umlBBComment2", "1",
			 "com.ibm.xtools.activities.umlBBActivity1", "1",
			 "com.ibm.xtools.activities.umlBBActivity2", "1",
			 "com.ibm.xtools.activities.umlBBActivity3", "1",
			 "com.ibm.xtools.activities.umlBBFunction", "1",
			 "com.ibm.xtools.activities.umlBBActivityDiagram", "1",
			 "com.ibm.xtools.activities.umlBBCommunication", "1",
			 "com.ibm.xtools.activities.umlBBCollaboration", "1",
			 "com.ibm.xtools.activities.umlBBClass", "1",
			 "com.ibm.xtools.activities.umlBBInterface", "1",
			 "com.ibm.xtools.activities.umlBBUseCaseDiagram", "1",
			 "com.ibm.xtools.activities.umlBBTypes1", "1",
			 "com.ibm.xtools.activities.umlBBTypes2", "1",
			 "com.ibm.xtools.activities.umlBBComponentTemplateParameter", "1",
			 "com.ibm.xtools.activities.umlBBTypes3", "1",
			 "com.ibm.xtools.activities.umlBBTypes4", "1",
			 "com.ibm.xtools.activities.umlBBUseCase1", "1",
			 "com.ibm.xtools.activities.umlBBUseCase2", "1",
			 "com.ibm.xtools.activities.umlBBPackage", "1",
			 "com.ibm.xtools.activities.umlBBComponentDiagram", "1",
			 "com.ibm.xtools.activities.umlBBInterfaceTemplateParameter", "1",
			 "com.ibm.xtools.activities.umlBBClassDiagram", "1",
			 "com.ibm.xtools.activities.umlBBRealization", "1",
			 "com.ibm.xtools.activities.umlBBComponent", "1",
			 "com.ibm.xtools.activities.umlBBSequenceDiagram", "1"
		   });																																																																																																																																																																																																																					
	}

} //CvlPackageImpl
