/**
 */
package bvr.impl;

import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.BVRModel;
import bvr.BooleanLiteralExp;
import bvr.BoundaryElementBinding;
import bvr.BvrFactory;
import bvr.BvrPackage;
import bvr.Choice;
import bvr.ChoiceOccurrence;
import bvr.ChoiceResolution;
import bvr.ChoiceVariationPoint;
import bvr.CompoundNode;
import bvr.CompoundResolution;
import bvr.Constraint;
import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.FromReplacement;
import bvr.IntegerLiteralExp;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.NegResolution;
import bvr.Note;
import bvr.NumericLiteralExp;
import bvr.OVPSemanticSpec;
import bvr.OVPType;
import bvr.ObjectHandle;
import bvr.ObjectSpecification;
import bvr.ObjectType;
import bvr.OpaqueConstraint;
import bvr.OpaqueVariationPoint;
import bvr.Operation;
import bvr.OperationCallExp;
import bvr.ParametricSlotAssignment;
import bvr.ParametricVariationPoint;
import bvr.PlacementBoundaryElement;
import bvr.PlacementFragment;
import bvr.PosResolution;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.RealLiteralExp;
import bvr.RepeatableVariationPoint;
import bvr.ReplacementBoundaryElement;
import bvr.ReplacementFragmentSpecification;
import bvr.ReplacementFragmentType;
import bvr.ResolutionLiteralDefinition;
import bvr.ResolutionLiteralUse;
import bvr.SlotAssignment;
import bvr.StagedVariationPoint;
import bvr.StringLiteralExp;
import bvr.Target;
import bvr.TargetRef;
import bvr.ToBinding;
import bvr.ToPlacement;
import bvr.ToReplacement;
import bvr.UnlimitedLiteralExp;
import bvr.VClassOccurrence;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VPackage;
import bvr.VPackageable;
import bvr.VRef;
import bvr.VRefValueSpecification;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.VType;
import bvr.ValueResolution;
import bvr.ValueSpecification;
import bvr.Variable;
import bvr.Variabletype;
import bvr.VariationPoint;

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
public class BvrPackageImpl extends EPackageImpl implements BvrPackage {
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
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vNodeEClass = null;

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
	private EClass constraintEClass = null;

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
	private EClass variabletypeEClass = null;

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
	private EClass choiceResolutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceOccurrenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vClassOccurrenceEClass = null;

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
	private EClass stagedVariationPointEClass = null;

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
	private EClass objectHandleEClass = null;

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
	private EClass replacementBoundaryElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueResolutionEClass = null;

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
	private EClass slotAssignmentEClass = null;

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
	private EClass targetRefEClass = null;

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
	private EClass parametricSlotAssignmentEClass = null;

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
	private EClass compoundResolutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass negResolutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass posResolutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vRefValueSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolutionLiteralDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolutionLiteralUseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bvrModelEClass = null;

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
	 * @see bvr.BvrPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BvrPackageImpl() {
		super(eNS_URI, BvrFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BvrPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BvrPackage init() {
		if (isInited) return (BvrPackage)EPackage.Registry.INSTANCE.getEPackage(BvrPackage.eNS_URI);

		// Obtain or create and register package
		BvrPackageImpl theBvrPackage = (BvrPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BvrPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BvrPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theBvrPackage.createPackageContents();

		// Initialize created meta-data
		theBvrPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBvrPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BvrPackage.eNS_URI, theBvrPackage);
		return theBvrPackage;
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
	public EAttribute getVSpec_ResolutionTime() {
		return (EAttribute)vSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVSpec_Target() {
		return (EReference)vSpecEClass.getEStructuralFeatures().get(1);
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
	public EReference getNamedElement_Note() {
		return (EReference)namedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNote() {
		return noteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNote_Kind() {
		return (EAttribute)noteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNote_Expr() {
		return (EAttribute)noteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTarget() {
		return targetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompoundNode() {
		return compoundNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompoundNode_Member() {
		return (EReference)compoundNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompoundNode_OwnedTargets() {
		return (EReference)compoundNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVNode() {
		return vNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVNode_GroupMultiplicity() {
		return (EReference)vNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVNode_OwnedConstraint() {
		return (EReference)vNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVNode_Variable() {
		return (EReference)vNodeEClass.getEStructuralFeatures().get(2);
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
	public EClass getConstraint() {
		return constraintEClass;
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
	public EReference getVariable_DefaulValue() {
		return (EReference)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Type() {
		return (EReference)variableEClass.getEStructuralFeatures().get(1);
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
	public EClass getVariabletype() {
		return variabletypeEClass;
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
	public EClass getChoiceResolution() {
		return choiceResolutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceResolution_ResolvedChoice() {
		return (EReference)choiceResolutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceResolution_ResolvedChoiceOcc() {
		return (EReference)choiceResolutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceResolution_ResolvedVClassOcc() {
		return (EReference)choiceResolutionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceResolution_ResolvedVClassifier() {
		return (EReference)choiceResolutionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoiceOccurrence() {
		return choiceOccurrenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceOccurrence_VType() {
		return (EReference)choiceOccurrenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVType() {
		return vTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVClassOccurrence() {
		return vClassOccurrenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVClassOccurrence_VType() {
		return (EReference)vClassOccurrenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVClassOccurrence_InstanceMultiplicity() {
		return (EReference)vClassOccurrenceEClass.getEStructuralFeatures().get(1);
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
	public EReference getVariationPoint_StagedVariationPoint() {
		return (EReference)variationPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStagedVariationPoint() {
		return stagedVariationPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStagedVariationPoint_BindingStagedVP() {
		return (EReference)stagedVariationPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStagedVariationPoint_Member() {
		return (EReference)stagedVariationPointEClass.getEStructuralFeatures().get(1);
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
	public EReference getChoiceVariationPoint_BindingChoiceOcc() {
		return (EReference)choiceVariationPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChoiceVariationPoint_Resolution_kind() {
		return (EAttribute)choiceVariationPointEClass.getEStructuralFeatures().get(2);
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
	public EReference getRepeatableVariationPoint_BindingVClassOcc() {
		return (EReference)repeatableVariationPointEClass.getEStructuralFeatures().get(1);
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
	public EReference getPlacementFragment_SourceObject() {
		return (EReference)placementFragmentEClass.getEStructuralFeatures().get(1);
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
	public EClass getObjectHandle() {
		return objectHandleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectHandle_MOFRef() {
		return (EAttribute)objectHandleEClass.getEStructuralFeatures().get(0);
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
	public EReference getReplacementFragmentType_SourceObject() {
		return (EReference)replacementFragmentTypeEClass.getEStructuralFeatures().get(2);
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
	public EClass getValueResolution() {
		return valueResolutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueResolution_ResolvedVariable() {
		return (EReference)valueResolutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueResolution_Value() {
		return (EReference)valueResolutionEClass.getEStructuralFeatures().get(1);
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
	public EReference getOpaqueVariationPoint_Type() {
		return (EReference)opaqueVariationPointEClass.getEStructuralFeatures().get(1);
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
	public EClass getTargetRef() {
		return targetRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetRef_Target() {
		return (EReference)targetRefEClass.getEStructuralFeatures().get(0);
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
	public EClass getParametricSlotAssignment() {
		return parametricSlotAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParametricSlotAssignment_SlotIdentifier() {
		return (EAttribute)parametricSlotAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParametricSlotAssignment_SlotOwner() {
		return (EReference)parametricSlotAssignmentEClass.getEStructuralFeatures().get(1);
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
	public EClass getCompoundResolution() {
		return compoundResolutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompoundResolution_Members() {
		return (EReference)compoundResolutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNegResolution() {
		return negResolutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPosResolution() {
		return posResolutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVRef() {
		return vRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVRef_RefVSpec() {
		return (EReference)vRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVRefValueSpecification() {
		return vRefValueSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVRefValueSpecification_VSpecResolution() {
		return (EReference)vRefValueSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolutionLiteralDefinition() {
		return resolutionLiteralDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolutionLiteralDefinition_LiteralType() {
		return (EReference)resolutionLiteralDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolutionLiteralUse() {
		return resolutionLiteralUseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolutionLiteralUse_DefLiteral() {
		return (EReference)resolutionLiteralUseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBVRModel() {
		return bvrModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBVRModel_VariabilityModel() {
		return (EReference)bvrModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBVRModel_ResolutionModels() {
		return (EReference)bvrModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBVRModel_BaseModelBase() {
		return (EReference)bvrModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBVRModel_BaseModelLibraries() {
		return (EReference)bvrModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBVRModel_RealizationModel() {
		return (EReference)bvrModelEClass.getEStructuralFeatures().get(4);
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
	public BvrFactory getBvrFactory() {
		return (BvrFactory)getEFactoryInstance();
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
		createEAttribute(vSpecEClass, VSPEC__RESOLUTION_TIME);
		createEReference(vSpecEClass, VSPEC__TARGET);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
		createEReference(namedElementEClass, NAMED_ELEMENT__NOTE);

		noteEClass = createEClass(NOTE);
		createEAttribute(noteEClass, NOTE__KIND);
		createEAttribute(noteEClass, NOTE__EXPR);

		targetEClass = createEClass(TARGET);

		compoundNodeEClass = createEClass(COMPOUND_NODE);
		createEReference(compoundNodeEClass, COMPOUND_NODE__MEMBER);
		createEReference(compoundNodeEClass, COMPOUND_NODE__OWNED_TARGETS);

		vNodeEClass = createEClass(VNODE);
		createEReference(vNodeEClass, VNODE__GROUP_MULTIPLICITY);
		createEReference(vNodeEClass, VNODE__OWNED_CONSTRAINT);
		createEReference(vNodeEClass, VNODE__VARIABLE);

		multiplicityIntervalEClass = createEClass(MULTIPLICITY_INTERVAL);
		createEAttribute(multiplicityIntervalEClass, MULTIPLICITY_INTERVAL__UPPER);
		createEAttribute(multiplicityIntervalEClass, MULTIPLICITY_INTERVAL__LOWER);

		constraintEClass = createEClass(CONSTRAINT);

		variableEClass = createEClass(VARIABLE);
		createEReference(variableEClass, VARIABLE__DEFAUL_VALUE);
		createEReference(variableEClass, VARIABLE__TYPE);

		valueSpecificationEClass = createEClass(VALUE_SPECIFICATION);
		createEReference(valueSpecificationEClass, VALUE_SPECIFICATION__TYPE);

		variabletypeEClass = createEClass(VARIABLETYPE);

		vPackageableEClass = createEClass(VPACKAGEABLE);

		vClassifierEClass = createEClass(VCLASSIFIER);
		createEReference(vClassifierEClass, VCLASSIFIER__INSTANCE_MULTIPLICITY);

		vSpecResolutionEClass = createEClass(VSPEC_RESOLUTION);
		createEReference(vSpecResolutionEClass, VSPEC_RESOLUTION__RESOLVED_VSPEC);

		choiceResolutionEClass = createEClass(CHOICE_RESOLUTION);
		createEReference(choiceResolutionEClass, CHOICE_RESOLUTION__RESOLVED_CHOICE);
		createEReference(choiceResolutionEClass, CHOICE_RESOLUTION__RESOLVED_CHOICE_OCC);
		createEReference(choiceResolutionEClass, CHOICE_RESOLUTION__RESOLVED_VCLASS_OCC);
		createEReference(choiceResolutionEClass, CHOICE_RESOLUTION__RESOLVED_VCLASSIFIER);

		choiceOccurrenceEClass = createEClass(CHOICE_OCCURRENCE);
		createEReference(choiceOccurrenceEClass, CHOICE_OCCURRENCE__VTYPE);

		vTypeEClass = createEClass(VTYPE);

		vClassOccurrenceEClass = createEClass(VCLASS_OCCURRENCE);
		createEReference(vClassOccurrenceEClass, VCLASS_OCCURRENCE__VTYPE);
		createEReference(vClassOccurrenceEClass, VCLASS_OCCURRENCE__INSTANCE_MULTIPLICITY);

		variationPointEClass = createEClass(VARIATION_POINT);
		createEReference(variationPointEClass, VARIATION_POINT__BINDING_VSPEC);
		createEReference(variationPointEClass, VARIATION_POINT__STAGED_VARIATION_POINT);

		stagedVariationPointEClass = createEClass(STAGED_VARIATION_POINT);
		createEReference(stagedVariationPointEClass, STAGED_VARIATION_POINT__BINDING_STAGED_VP);
		createEReference(stagedVariationPointEClass, STAGED_VARIATION_POINT__MEMBER);

		fragmentSubstitutionEClass = createEClass(FRAGMENT_SUBSTITUTION);
		createEReference(fragmentSubstitutionEClass, FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING);
		createEReference(fragmentSubstitutionEClass, FRAGMENT_SUBSTITUTION__PLACEMENT);
		createEAttribute(fragmentSubstitutionEClass, FRAGMENT_SUBSTITUTION__MULTI);
		createEReference(fragmentSubstitutionEClass, FRAGMENT_SUBSTITUTION__REPLACEMENT);

		choiceVariationPointEClass = createEClass(CHOICE_VARIATION_POINT);
		createEReference(choiceVariationPointEClass, CHOICE_VARIATION_POINT__BINDING_CHOICE);
		createEReference(choiceVariationPointEClass, CHOICE_VARIATION_POINT__BINDING_CHOICE_OCC);
		createEAttribute(choiceVariationPointEClass, CHOICE_VARIATION_POINT__RESOLUTION_KIND);

		repeatableVariationPointEClass = createEClass(REPEATABLE_VARIATION_POINT);
		createEReference(repeatableVariationPointEClass, REPEATABLE_VARIATION_POINT__BINDING_CLASSIFIER);
		createEReference(repeatableVariationPointEClass, REPEATABLE_VARIATION_POINT__BINDING_VCLASS_OCC);

		boundaryElementBindingEClass = createEClass(BOUNDARY_ELEMENT_BINDING);

		placementFragmentEClass = createEClass(PLACEMENT_FRAGMENT);
		createEReference(placementFragmentEClass, PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT);
		createEReference(placementFragmentEClass, PLACEMENT_FRAGMENT__SOURCE_OBJECT);

		placementBoundaryElementEClass = createEClass(PLACEMENT_BOUNDARY_ELEMENT);

		objectHandleEClass = createEClass(OBJECT_HANDLE);
		createEAttribute(objectHandleEClass, OBJECT_HANDLE__MOF_REF);

		replacementFragmentTypeEClass = createEClass(REPLACEMENT_FRAGMENT_TYPE);
		createEReference(replacementFragmentTypeEClass, REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT);
		createEReference(replacementFragmentTypeEClass, REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT);
		createEReference(replacementFragmentTypeEClass, REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT);

		replacementBoundaryElementEClass = createEClass(REPLACEMENT_BOUNDARY_ELEMENT);

		valueResolutionEClass = createEClass(VALUE_RESOLUTION);
		createEReference(valueResolutionEClass, VALUE_RESOLUTION__RESOLVED_VARIABLE);
		createEReference(valueResolutionEClass, VALUE_RESOLUTION__VALUE);

		primitveTypeEClass = createEClass(PRIMITVE_TYPE);
		createEAttribute(primitveTypeEClass, PRIMITVE_TYPE__TYPE);

		objectTypeEClass = createEClass(OBJECT_TYPE);
		createEAttribute(objectTypeEClass, OBJECT_TYPE__META_CLASS);

		slotAssignmentEClass = createEClass(SLOT_ASSIGNMENT);
		createEAttribute(slotAssignmentEClass, SLOT_ASSIGNMENT__SLOT_IDENTIFIER);
		createEReference(slotAssignmentEClass, SLOT_ASSIGNMENT__VALUE);
		createEReference(slotAssignmentEClass, SLOT_ASSIGNMENT__SLOT_OWNER);

		opaqueVariationPointEClass = createEClass(OPAQUE_VARIATION_POINT);
		createEReference(opaqueVariationPointEClass, OPAQUE_VARIATION_POINT__PLACE_HOLDER);
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

		targetRefEClass = createEClass(TARGET_REF);
		createEReference(targetRefEClass, TARGET_REF__TARGET);

		bclExpressionEClass = createEClass(BCL_EXPRESSION);

		opaqueConstraintEClass = createEClass(OPAQUE_CONSTRAINT);
		createEAttribute(opaqueConstraintEClass, OPAQUE_CONSTRAINT__CONSTRAINT);
		createEAttribute(opaqueConstraintEClass, OPAQUE_CONSTRAINT__CONSTRAINT_LANGUAGE);

		parametricVariationPointEClass = createEClass(PARAMETRIC_VARIATION_POINT);
		createEReference(parametricVariationPointEClass, PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE);

		parametricSlotAssignmentEClass = createEClass(PARAMETRIC_SLOT_ASSIGNMENT);
		createEAttribute(parametricSlotAssignmentEClass, PARAMETRIC_SLOT_ASSIGNMENT__SLOT_IDENTIFIER);
		createEReference(parametricSlotAssignmentEClass, PARAMETRIC_SLOT_ASSIGNMENT__SLOT_OWNER);

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

		compoundResolutionEClass = createEClass(COMPOUND_RESOLUTION);
		createEReference(compoundResolutionEClass, COMPOUND_RESOLUTION__MEMBERS);

		negResolutionEClass = createEClass(NEG_RESOLUTION);

		posResolutionEClass = createEClass(POS_RESOLUTION);

		vRefEClass = createEClass(VREF);
		createEReference(vRefEClass, VREF__REF_VSPEC);

		vRefValueSpecificationEClass = createEClass(VREF_VALUE_SPECIFICATION);
		createEReference(vRefValueSpecificationEClass, VREF_VALUE_SPECIFICATION__VSPEC_RESOLUTION);

		resolutionLiteralDefinitionEClass = createEClass(RESOLUTION_LITERAL_DEFINITION);
		createEReference(resolutionLiteralDefinitionEClass, RESOLUTION_LITERAL_DEFINITION__LITERAL_TYPE);

		resolutionLiteralUseEClass = createEClass(RESOLUTION_LITERAL_USE);
		createEReference(resolutionLiteralUseEClass, RESOLUTION_LITERAL_USE__DEF_LITERAL);

		bvrModelEClass = createEClass(BVR_MODEL);
		createEReference(bvrModelEClass, BVR_MODEL__VARIABILITY_MODEL);
		createEReference(bvrModelEClass, BVR_MODEL__RESOLUTION_MODELS);
		createEReference(bvrModelEClass, BVR_MODEL__BASE_MODEL_BASE);
		createEReference(bvrModelEClass, BVR_MODEL__BASE_MODEL_LIBRARIES);
		createEReference(bvrModelEClass, BVR_MODEL__REALIZATION_MODEL);

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
		choiceEClass.getESuperTypes().add(this.getCompoundNode());
		vSpecEClass.getESuperTypes().add(this.getNamedElement());
		noteEClass.getESuperTypes().add(this.getNamedElement());
		targetEClass.getESuperTypes().add(this.getNamedElement());
		compoundNodeEClass.getESuperTypes().add(this.getVNode());
		constraintEClass.getESuperTypes().add(this.getNamedElement());
		variableEClass.getESuperTypes().add(this.getVSpec());
		variabletypeEClass.getESuperTypes().add(this.getVPackageable());
		vPackageableEClass.getESuperTypes().add(this.getNamedElement());
		vClassifierEClass.getESuperTypes().add(this.getVSpec());
		vClassifierEClass.getESuperTypes().add(this.getCompoundNode());
		vSpecResolutionEClass.getESuperTypes().add(this.getNamedElement());
		choiceResolutionEClass.getESuperTypes().add(this.getVSpecResolution());
		choiceOccurrenceEClass.getESuperTypes().add(this.getVSpec());
		choiceOccurrenceEClass.getESuperTypes().add(this.getVNode());
		vTypeEClass.getESuperTypes().add(this.getCompoundNode());
		vTypeEClass.getESuperTypes().add(this.getVPackageable());
		vClassOccurrenceEClass.getESuperTypes().add(this.getVSpec());
		vClassOccurrenceEClass.getESuperTypes().add(this.getVNode());
		variationPointEClass.getESuperTypes().add(this.getNamedElement());
		stagedVariationPointEClass.getESuperTypes().add(this.getVariationPoint());
		fragmentSubstitutionEClass.getESuperTypes().add(this.getChoiceVariationPoint());
		fragmentSubstitutionEClass.getESuperTypes().add(this.getRepeatableVariationPoint());
		choiceVariationPointEClass.getESuperTypes().add(this.getVariationPoint());
		repeatableVariationPointEClass.getESuperTypes().add(this.getVariationPoint());
		boundaryElementBindingEClass.getESuperTypes().add(this.getNamedElement());
		placementFragmentEClass.getESuperTypes().add(this.getVariationPoint());
		placementBoundaryElementEClass.getESuperTypes().add(this.getNamedElement());
		replacementFragmentTypeEClass.getESuperTypes().add(this.getVariabletype());
		replacementBoundaryElementEClass.getESuperTypes().add(this.getNamedElement());
		valueResolutionEClass.getESuperTypes().add(this.getVSpecResolution());
		primitveTypeEClass.getESuperTypes().add(this.getVariabletype());
		objectTypeEClass.getESuperTypes().add(this.getVariabletype());
		slotAssignmentEClass.getESuperTypes().add(this.getChoiceVariationPoint());
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
		targetRefEClass.getESuperTypes().add(this.getBCLExpression());
		opaqueConstraintEClass.getESuperTypes().add(this.getConstraint());
		parametricVariationPointEClass.getESuperTypes().add(this.getVariationPoint());
		parametricSlotAssignmentEClass.getESuperTypes().add(this.getParametricVariationPoint());
		primitiveValueSpecificationEClass.getESuperTypes().add(this.getValueSpecification());
		bclConstraintEClass.getESuperTypes().add(this.getConstraint());
		operationCallExpEClass.getESuperTypes().add(this.getBCLExpression());
		booleanLiteralExpEClass.getESuperTypes().add(this.getBCLExpression());
		stringLiteralExpEClass.getESuperTypes().add(this.getBCLExpression());
		numericLiteralExpEClass.getESuperTypes().add(this.getBCLExpression());
		integerLiteralExpEClass.getESuperTypes().add(this.getNumericLiteralExp());
		unlimitedLiteralExpEClass.getESuperTypes().add(this.getNumericLiteralExp());
		realLiteralExpEClass.getESuperTypes().add(this.getNumericLiteralExp());
		compoundResolutionEClass.getESuperTypes().add(this.getChoiceResolution());
		negResolutionEClass.getESuperTypes().add(this.getChoiceResolution());
		posResolutionEClass.getESuperTypes().add(this.getCompoundResolution());
		vRefEClass.getESuperTypes().add(this.getVariabletype());
		vRefValueSpecificationEClass.getESuperTypes().add(this.getValueSpecification());
		resolutionLiteralDefinitionEClass.getESuperTypes().add(this.getCompoundResolution());
		resolutionLiteralUseEClass.getESuperTypes().add(this.getChoiceResolution());
		bvrModelEClass.getESuperTypes().add(this.getVPackage());

		// Initialize classes, features, and operations; add parameters
		initEClass(choiceEClass, Choice.class, "Choice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChoice_DefaultResolution(), ecorePackage.getEBoolean(), "defaultResolution", null, 0, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getChoice_IsImpliedByParent(), ecorePackage.getEBoolean(), "isImpliedByParent", null, 1, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vSpecEClass, VSpec.class, "VSpec", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVSpec_ResolutionTime(), ecorePackage.getEString(), "resolutionTime", null, 1, 1, VSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVSpec_Target(), this.getTarget(), null, "target", null, 1, 1, VSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNamedElement_Note(), this.getNote(), null, "note", null, 0, -1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(noteEClass, Note.class, "Note", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNote_Kind(), ecorePackage.getEString(), "kind", "Comment", 1, 1, Note.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNote_Expr(), ecorePackage.getEString(), "expr", null, 1, 1, Note.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(targetEClass, Target.class, "Target", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compoundNodeEClass, CompoundNode.class, "CompoundNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompoundNode_Member(), this.getVNode(), null, "member", null, 0, -1, CompoundNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompoundNode_OwnedTargets(), this.getTarget(), null, "ownedTargets", null, 0, -1, CompoundNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vNodeEClass, VNode.class, "VNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVNode_GroupMultiplicity(), this.getMultiplicityInterval(), null, "groupMultiplicity", null, 0, 1, VNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVNode_OwnedConstraint(), this.getConstraint(), null, "ownedConstraint", null, 0, -1, VNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVNode_Variable(), this.getVariable(), null, "variable", null, 0, -1, VNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(multiplicityIntervalEClass, MultiplicityInterval.class, "MultiplicityInterval", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiplicityInterval_Upper(), ecorePackage.getEInt(), "upper", null, 1, 1, MultiplicityInterval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMultiplicityInterval_Lower(), ecorePackage.getEInt(), "lower", null, 1, 1, MultiplicityInterval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariable_DefaulValue(), this.getValueSpecification(), null, "defaulValue", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariable_Type(), this.getVariabletype(), null, "type", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(valueSpecificationEClass, ValueSpecification.class, "ValueSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValueSpecification_Type(), this.getVariabletype(), null, "type", null, 1, 1, ValueSpecification.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(variabletypeEClass, Variabletype.class, "Variabletype", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vPackageableEClass, VPackageable.class, "VPackageable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vClassifierEClass, VClassifier.class, "VClassifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVClassifier_InstanceMultiplicity(), this.getMultiplicityInterval(), null, "instanceMultiplicity", null, 1, 1, VClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vSpecResolutionEClass, VSpecResolution.class, "VSpecResolution", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVSpecResolution_ResolvedVSpec(), this.getVSpec(), null, "resolvedVSpec", null, 1, 1, VSpecResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(choiceResolutionEClass, ChoiceResolution.class, "ChoiceResolution", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoiceResolution_ResolvedChoice(), this.getChoice(), null, "resolvedChoice", null, 1, 1, ChoiceResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getChoiceResolution_ResolvedChoiceOcc(), this.getChoiceOccurrence(), null, "resolvedChoiceOcc", null, 1, 1, ChoiceResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getChoiceResolution_ResolvedVClassOcc(), this.getVClassOccurrence(), null, "resolvedVClassOcc", null, 1, 1, ChoiceResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getChoiceResolution_ResolvedVClassifier(), this.getVClassifier(), null, "resolvedVClassifier", null, 1, 1, ChoiceResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(choiceOccurrenceEClass, ChoiceOccurrence.class, "ChoiceOccurrence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoiceOccurrence_VType(), this.getVType(), null, "vType", null, 1, 1, ChoiceOccurrence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vTypeEClass, VType.class, "VType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vClassOccurrenceEClass, VClassOccurrence.class, "VClassOccurrence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVClassOccurrence_VType(), this.getVType(), null, "vType", null, 1, 1, VClassOccurrence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVClassOccurrence_InstanceMultiplicity(), this.getMultiplicityInterval(), null, "instanceMultiplicity", null, 0, -1, VClassOccurrence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variationPointEClass, VariationPoint.class, "VariationPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariationPoint_BindingVSpec(), this.getVSpec(), null, "bindingVSpec", null, 1, 1, VariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariationPoint_StagedVariationPoint(), this.getStagedVariationPoint(), this.getStagedVariationPoint_Member(), "stagedVariationPoint", null, 0, 1, VariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stagedVariationPointEClass, StagedVariationPoint.class, "StagedVariationPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStagedVariationPoint_BindingStagedVP(), this.getVSpec(), null, "bindingStagedVP", null, 1, 1, StagedVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStagedVariationPoint_Member(), this.getVariationPoint(), this.getVariationPoint_StagedVariationPoint(), "member", null, 0, -1, StagedVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fragmentSubstitutionEClass, FragmentSubstitution.class, "FragmentSubstitution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFragmentSubstitution_BoundaryElementBinding(), this.getBoundaryElementBinding(), null, "boundaryElementBinding", null, 0, -1, FragmentSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFragmentSubstitution_Placement(), this.getPlacementFragment(), null, "placement", null, 1, 1, FragmentSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFragmentSubstitution_Multi(), ecorePackage.getEBoolean(), "multi", null, 1, 1, FragmentSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFragmentSubstitution_Replacement(), this.getReplacementFragmentType(), null, "replacement", null, 0, 1, FragmentSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(choiceVariationPointEClass, ChoiceVariationPoint.class, "ChoiceVariationPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoiceVariationPoint_BindingChoice(), this.getChoice(), null, "bindingChoice", null, 0, 1, ChoiceVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getChoiceVariationPoint_BindingChoiceOcc(), this.getChoiceOccurrence(), null, "bindingChoiceOcc", null, 0, 1, ChoiceVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getChoiceVariationPoint_Resolution_kind(), ecorePackage.getEBoolean(), "resolution_kind", "True", 1, 1, ChoiceVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(repeatableVariationPointEClass, RepeatableVariationPoint.class, "RepeatableVariationPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepeatableVariationPoint_BindingClassifier(), this.getVClassifier(), null, "bindingClassifier", null, 0, 1, RepeatableVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRepeatableVariationPoint_BindingVClassOcc(), this.getVClassOccurrence(), null, "bindingVClassOcc", null, 0, 1, RepeatableVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(boundaryElementBindingEClass, BoundaryElementBinding.class, "BoundaryElementBinding", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(placementFragmentEClass, PlacementFragment.class, "PlacementFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlacementFragment_PlacementBoundaryElement(), this.getPlacementBoundaryElement(), null, "placementBoundaryElement", null, 0, -1, PlacementFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPlacementFragment_SourceObject(), this.getObjectHandle(), null, "sourceObject", null, 0, -1, PlacementFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(placementBoundaryElementEClass, PlacementBoundaryElement.class, "PlacementBoundaryElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectHandleEClass, ObjectHandle.class, "ObjectHandle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjectHandle_MOFRef(), ecorePackage.getEString(), "MOFRef", null, 1, 1, ObjectHandle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(replacementFragmentTypeEClass, ReplacementFragmentType.class, "ReplacementFragmentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReplacementFragmentType_ReplacementBoundaryElement(), this.getReplacementBoundaryElement(), null, "replacementBoundaryElement", null, 0, -1, ReplacementFragmentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getReplacementFragmentType_PlacementFragment(), this.getPlacementFragment(), null, "placementFragment", null, 0, -1, ReplacementFragmentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getReplacementFragmentType_SourceObject(), this.getObjectHandle(), null, "sourceObject", null, 0, -1, ReplacementFragmentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(replacementBoundaryElementEClass, ReplacementBoundaryElement.class, "ReplacementBoundaryElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueResolutionEClass, ValueResolution.class, "ValueResolution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValueResolution_ResolvedVariable(), this.getVariable(), null, "resolvedVariable", null, 1, 1, ValueResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getValueResolution_Value(), this.getValueSpecification(), null, "value", null, 1, 1, ValueResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(primitveTypeEClass, PrimitveType.class, "PrimitveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitveType_Type(), this.getPrimitiveTypeEnum(), "type", null, 1, 1, PrimitveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(objectTypeEClass, ObjectType.class, "ObjectType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjectType_MetaClass(), ecorePackage.getEString(), "metaClass", null, 1, 1, ObjectType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(slotAssignmentEClass, SlotAssignment.class, "SlotAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSlotAssignment_SlotIdentifier(), ecorePackage.getEString(), "slotIdentifier", null, 1, 1, SlotAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSlotAssignment_Value(), this.getValueSpecification(), null, "value", null, 0, 1, SlotAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSlotAssignment_SlotOwner(), this.getObjectHandle(), null, "slotOwner", null, 1, 1, SlotAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(opaqueVariationPointEClass, OpaqueVariationPoint.class, "OpaqueVariationPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOpaqueVariationPoint_PlaceHolder(), this.getObjectHandle(), null, "placeHolder", null, 1, 1, OpaqueVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
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

		initEClass(targetRefEClass, TargetRef.class, "TargetRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetRef_Target(), this.getTarget(), null, "target", null, 1, 1, TargetRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(bclExpressionEClass, BCLExpression.class, "BCLExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opaqueConstraintEClass, OpaqueConstraint.class, "OpaqueConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpaqueConstraint_Constraint(), ecorePackage.getEString(), "constraint", null, 1, 1, OpaqueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOpaqueConstraint_ConstraintLanguage(), ecorePackage.getEString(), "constraintLanguage", null, 1, 1, OpaqueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parametricVariationPointEClass, ParametricVariationPoint.class, "ParametricVariationPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParametricVariationPoint_BindingVariable(), this.getVariable(), null, "bindingVariable", null, 1, 1, ParametricVariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parametricSlotAssignmentEClass, ParametricSlotAssignment.class, "ParametricSlotAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParametricSlotAssignment_SlotIdentifier(), ecorePackage.getEString(), "slotIdentifier", null, 1, 1, ParametricSlotAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParametricSlotAssignment_SlotOwner(), this.getObjectHandle(), null, "slotOwner", null, 1, 1, ParametricSlotAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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

		initEClass(compoundResolutionEClass, CompoundResolution.class, "CompoundResolution", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompoundResolution_Members(), this.getVSpecResolution(), null, "members", null, 0, -1, CompoundResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(negResolutionEClass, NegResolution.class, "NegResolution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(posResolutionEClass, PosResolution.class, "PosResolution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vRefEClass, VRef.class, "VRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVRef_RefVSpec(), this.getVSpec(), null, "refVSpec", null, 0, -1, VRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vRefValueSpecificationEClass, VRefValueSpecification.class, "VRefValueSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVRefValueSpecification_VSpecResolution(), this.getVSpecResolution(), null, "vSpecResolution", null, 0, -1, VRefValueSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resolutionLiteralDefinitionEClass, ResolutionLiteralDefinition.class, "ResolutionLiteralDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResolutionLiteralDefinition_LiteralType(), this.getVType(), null, "literalType", null, 0, 1, ResolutionLiteralDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resolutionLiteralUseEClass, ResolutionLiteralUse.class, "ResolutionLiteralUse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResolutionLiteralUse_DefLiteral(), this.getResolutionLiteralDefinition(), null, "defLiteral", null, 0, 1, ResolutionLiteralUse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(bvrModelEClass, BVRModel.class, "BVRModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBVRModel_VariabilityModel(), this.getCompoundNode(), null, "variabilityModel", null, 1, 1, BVRModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBVRModel_ResolutionModels(), this.getCompoundResolution(), null, "resolutionModels", null, 0, -1, BVRModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBVRModel_BaseModelBase(), this.getObjectHandle(), null, "baseModelBase", null, 1, 1, BVRModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBVRModel_BaseModelLibraries(), this.getObjectHandle(), null, "baseModelLibraries", null, 0, -1, BVRModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBVRModel_RealizationModel(), this.getVariationPoint(), null, "realizationModel", null, 0, -1, BVRModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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

} //BvrPackageImpl
