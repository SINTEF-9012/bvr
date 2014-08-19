/**
 */
package bvr.impl;

import bvr.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BvrFactoryImpl extends EFactoryImpl implements BvrFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BvrFactory init() {
		try {
			BvrFactory theBvrFactory = (BvrFactory)EPackage.Registry.INSTANCE.getEFactory(BvrPackage.eNS_URI);
			if (theBvrFactory != null) {
				return theBvrFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BvrFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BvrFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BvrPackage.CHOICE: return createChoice();
			case BvrPackage.NOTE: return createNote();
			case BvrPackage.TARGET: return createTarget();
			case BvrPackage.MULTIPLICITY_INTERVAL: return createMultiplicityInterval();
			case BvrPackage.CONSTRAINT: return createConstraint();
			case BvrPackage.VARIABLE: return createVariable();
			case BvrPackage.VCLASSIFIER: return createVClassifier();
			case BvrPackage.CHOICE_OCCURRENCE: return createChoiceOccurrence();
			case BvrPackage.VTYPE: return createVType();
			case BvrPackage.VCLASS_OCCURRENCE: return createVClassOccurrence();
			case BvrPackage.STAGED_VARIATION_POINT: return createStagedVariationPoint();
			case BvrPackage.FRAGMENT_SUBSTITUTION: return createFragmentSubstitution();
			case BvrPackage.PLACEMENT_FRAGMENT: return createPlacementFragment();
			case BvrPackage.OBJECT_HANDLE: return createObjectHandle();
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE: return createReplacementFragmentType();
			case BvrPackage.VALUE_RESOLUTION: return createValueResolution();
			case BvrPackage.PRIMITVE_TYPE: return createPrimitveType();
			case BvrPackage.OBJECT_TYPE: return createObjectType();
			case BvrPackage.SLOT_ASSIGNMENT: return createSlotAssignment();
			case BvrPackage.OPAQUE_VARIATION_POINT: return createOpaqueVariationPoint();
			case BvrPackage.OVP_TYPE: return createOVPType();
			case BvrPackage.OVP_SEMANTIC_SPEC: return createOVPSemanticSpec();
			case BvrPackage.OBJECT_SPECIFICATION: return createObjectSpecification();
			case BvrPackage.REPLACEMENT_FRAGMENT_SPECIFICATION: return createReplacementFragmentSpecification();
			case BvrPackage.VPACKAGE: return createVPackage();
			case BvrPackage.TO_BINDING: return createToBinding();
			case BvrPackage.TO_PLACEMENT: return createToPlacement();
			case BvrPackage.TO_REPLACEMENT: return createToReplacement();
			case BvrPackage.FROM_BINDING: return createFromBinding();
			case BvrPackage.FROM_PLACEMENT: return createFromPlacement();
			case BvrPackage.FROM_REPLACEMENT: return createFromReplacement();
			case BvrPackage.TARGET_REF: return createTargetRef();
			case BvrPackage.BCL_EXPRESSION: return createBCLExpression();
			case BvrPackage.OPAQUE_CONSTRAINT: return createOpaqueConstraint();
			case BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT: return createParametricSlotAssignment();
			case BvrPackage.PRIMITIVE_VALUE_SPECIFICATION: return createPrimitiveValueSpecification();
			case BvrPackage.BCL_CONSTRAINT: return createBCLConstraint();
			case BvrPackage.OPERATION_CALL_EXP: return createOperationCallExp();
			case BvrPackage.BOOLEAN_LITERAL_EXP: return createBooleanLiteralExp();
			case BvrPackage.STRING_LITERAL_EXP: return createStringLiteralExp();
			case BvrPackage.NUMERIC_LITERAL_EXP: return createNumericLiteralExp();
			case BvrPackage.INTEGER_LITERAL_EXP: return createIntegerLiteralExp();
			case BvrPackage.UNLIMITED_LITERAL_EXP: return createUnlimitedLiteralExp();
			case BvrPackage.REAL_LITERAL_EXP: return createRealLiteralExp();
			case BvrPackage.NEG_RESOLUTION: return createNegResolution();
			case BvrPackage.POS_RESOLUTION: return createPosResolution();
			case BvrPackage.VREF: return createVRef();
			case BvrPackage.VREF_VALUE_SPECIFICATION: return createVRefValueSpecification();
			case BvrPackage.RESOLUTION_LITERAL_DEFINITION: return createResolutionLiteralDefinition();
			case BvrPackage.RESOLUTION_LITERAL_USE: return createResolutionLiteralUse();
			case BvrPackage.BVR_MODEL: return createBVRModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case BvrPackage.PRIMITIVE_TYPE_ENUM:
				return createPrimitiveTypeEnumFromString(eDataType, initialValue);
			case BvrPackage.OPERATION:
				return createOperationFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case BvrPackage.PRIMITIVE_TYPE_ENUM:
				return convertPrimitiveTypeEnumToString(eDataType, instanceValue);
			case BvrPackage.OPERATION:
				return convertOperationToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice createChoice() {
		ChoiceImpl choice = new ChoiceImpl();
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Note createNote() {
		NoteImpl note = new NoteImpl();
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Target createTarget() {
		TargetImpl target = new TargetImpl();
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityInterval createMultiplicityInterval() {
		MultiplicityIntervalImpl multiplicityInterval = new MultiplicityIntervalImpl();
		return multiplicityInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VClassifier createVClassifier() {
		VClassifierImpl vClassifier = new VClassifierImpl();
		return vClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoiceOccurrence createChoiceOccurrence() {
		ChoiceOccurrenceImpl choiceOccurrence = new ChoiceOccurrenceImpl();
		return choiceOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VType createVType() {
		VTypeImpl vType = new VTypeImpl();
		return vType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VClassOccurrence createVClassOccurrence() {
		VClassOccurrenceImpl vClassOccurrence = new VClassOccurrenceImpl();
		return vClassOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StagedVariationPoint createStagedVariationPoint() {
		StagedVariationPointImpl stagedVariationPoint = new StagedVariationPointImpl();
		return stagedVariationPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FragmentSubstitution createFragmentSubstitution() {
		FragmentSubstitutionImpl fragmentSubstitution = new FragmentSubstitutionImpl();
		return fragmentSubstitution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacementFragment createPlacementFragment() {
		PlacementFragmentImpl placementFragment = new PlacementFragmentImpl();
		return placementFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectHandle createObjectHandle() {
		ObjectHandleImpl objectHandle = new ObjectHandleImpl();
		return objectHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentType createReplacementFragmentType() {
		ReplacementFragmentTypeImpl replacementFragmentType = new ReplacementFragmentTypeImpl();
		return replacementFragmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueResolution createValueResolution() {
		ValueResolutionImpl valueResolution = new ValueResolutionImpl();
		return valueResolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitveType createPrimitveType() {
		PrimitveTypeImpl primitveType = new PrimitveTypeImpl();
		return primitveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectType createObjectType() {
		ObjectTypeImpl objectType = new ObjectTypeImpl();
		return objectType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlotAssignment createSlotAssignment() {
		SlotAssignmentImpl slotAssignment = new SlotAssignmentImpl();
		return slotAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueVariationPoint createOpaqueVariationPoint() {
		OpaqueVariationPointImpl opaqueVariationPoint = new OpaqueVariationPointImpl();
		return opaqueVariationPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OVPType createOVPType() {
		OVPTypeImpl ovpType = new OVPTypeImpl();
		return ovpType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OVPSemanticSpec createOVPSemanticSpec() {
		OVPSemanticSpecImpl ovpSemanticSpec = new OVPSemanticSpecImpl();
		return ovpSemanticSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectSpecification createObjectSpecification() {
		ObjectSpecificationImpl objectSpecification = new ObjectSpecificationImpl();
		return objectSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentSpecification createReplacementFragmentSpecification() {
		ReplacementFragmentSpecificationImpl replacementFragmentSpecification = new ReplacementFragmentSpecificationImpl();
		return replacementFragmentSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VPackage createVPackage() {
		VPackageImpl vPackage = new VPackageImpl();
		return vPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToBinding createToBinding() {
		ToBindingImpl toBinding = new ToBindingImpl();
		return toBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToPlacement createToPlacement() {
		ToPlacementImpl toPlacement = new ToPlacementImpl();
		return toPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToReplacement createToReplacement() {
		ToReplacementImpl toReplacement = new ToReplacementImpl();
		return toReplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromBinding createFromBinding() {
		FromBindingImpl fromBinding = new FromBindingImpl();
		return fromBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromPlacement createFromPlacement() {
		FromPlacementImpl fromPlacement = new FromPlacementImpl();
		return fromPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromReplacement createFromReplacement() {
		FromReplacementImpl fromReplacement = new FromReplacementImpl();
		return fromReplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetRef createTargetRef() {
		TargetRefImpl targetRef = new TargetRefImpl();
		return targetRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BCLExpression createBCLExpression() {
		BCLExpressionImpl bclExpression = new BCLExpressionImpl();
		return bclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueConstraint createOpaqueConstraint() {
		OpaqueConstraintImpl opaqueConstraint = new OpaqueConstraintImpl();
		return opaqueConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricSlotAssignment createParametricSlotAssignment() {
		ParametricSlotAssignmentImpl parametricSlotAssignment = new ParametricSlotAssignmentImpl();
		return parametricSlotAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveValueSpecification createPrimitiveValueSpecification() {
		PrimitiveValueSpecificationImpl primitiveValueSpecification = new PrimitiveValueSpecificationImpl();
		return primitiveValueSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BCLConstraint createBCLConstraint() {
		BCLConstraintImpl bclConstraint = new BCLConstraintImpl();
		return bclConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExp createOperationCallExp() {
		OperationCallExpImpl operationCallExp = new OperationCallExpImpl();
		return operationCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteralExp createBooleanLiteralExp() {
		BooleanLiteralExpImpl booleanLiteralExp = new BooleanLiteralExpImpl();
		return booleanLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExp createStringLiteralExp() {
		StringLiteralExpImpl stringLiteralExp = new StringLiteralExpImpl();
		return stringLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericLiteralExp createNumericLiteralExp() {
		NumericLiteralExpImpl numericLiteralExp = new NumericLiteralExpImpl();
		return numericLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerLiteralExp createIntegerLiteralExp() {
		IntegerLiteralExpImpl integerLiteralExp = new IntegerLiteralExpImpl();
		return integerLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnlimitedLiteralExp createUnlimitedLiteralExp() {
		UnlimitedLiteralExpImpl unlimitedLiteralExp = new UnlimitedLiteralExpImpl();
		return unlimitedLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealLiteralExp createRealLiteralExp() {
		RealLiteralExpImpl realLiteralExp = new RealLiteralExpImpl();
		return realLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NegResolution createNegResolution() {
		NegResolutionImpl negResolution = new NegResolutionImpl();
		return negResolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PosResolution createPosResolution() {
		PosResolutionImpl posResolution = new PosResolutionImpl();
		return posResolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VRef createVRef() {
		VRefImpl vRef = new VRefImpl();
		return vRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VRefValueSpecification createVRefValueSpecification() {
		VRefValueSpecificationImpl vRefValueSpecification = new VRefValueSpecificationImpl();
		return vRefValueSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolutionLiteralDefinition createResolutionLiteralDefinition() {
		ResolutionLiteralDefinitionImpl resolutionLiteralDefinition = new ResolutionLiteralDefinitionImpl();
		return resolutionLiteralDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolutionLiteralUse createResolutionLiteralUse() {
		ResolutionLiteralUseImpl resolutionLiteralUse = new ResolutionLiteralUseImpl();
		return resolutionLiteralUse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BVRModel createBVRModel() {
		BVRModelImpl bvrModel = new BVRModelImpl();
		return bvrModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeEnum createPrimitiveTypeEnumFromString(EDataType eDataType, String initialValue) {
		PrimitiveTypeEnum result = PrimitiveTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperationFromString(EDataType eDataType, String initialValue) {
		Operation result = Operation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BvrPackage getBvrPackage() {
		return (BvrPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BvrPackage getPackage() {
		return BvrPackage.eINSTANCE;
	}

} //BvrFactoryImpl
