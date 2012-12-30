/**
 */
package cvl.impl;

import cvl.*;

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
public class cvlFactoryImpl extends EFactoryImpl implements cvlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static cvlFactory init() {
		try {
			cvlFactory thecvlFactory = (cvlFactory)EPackage.Registry.INSTANCE.getEFactory("http:///cvl.ecore"); 
			if (thecvlFactory != null) {
				return thecvlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new cvlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public cvlFactoryImpl() {
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
			case cvlPackage.CHOICE: return createChoice();
			case cvlPackage.MULTIPLICITY_INTERVAL: return createMultiplicityInterval();
			case cvlPackage.VSPEC_DERIVATION: return createVSpecDerivation();
			case cvlPackage.VCLASSIFIER: return createVClassifier();
			case cvlPackage.CHOICE_RESOLUTUION: return createChoiceResolutuion();
			case cvlPackage.VINSTANCE: return createVInstance();
			case cvlPackage.FRAGMENT_SUBSTITUTION: return createFragmentSubstitution();
			case cvlPackage.PLACEMENT_FRAGMENT: return createPlacementFragment();
			case cvlPackage.REPLACEMENT_FRAGMENT_TYPE: return createReplacementFragmentType();
			case cvlPackage.VARIABLETYPE: return createVariabletype();
			case cvlPackage.OBJECT_SUBSTITUTION: return createObjectSubstitution();
			case cvlPackage.OBJECT_HANDLE: return createObjectHandle();
			case cvlPackage.BASE_MODEL_HANDLE: return createBaseModelHandle();
			case cvlPackage.VARIABLE: return createVariable();
			case cvlPackage.VARIABLE_VALUE_ASSIGNMENT: return createVariableValueAssignment();
			case cvlPackage.PRIMITVE_TYPE: return createPrimitveType();
			case cvlPackage.OBJECT_TYPE: return createObjectType();
			case cvlPackage.VINTERFACE: return createVInterface();
			case cvlPackage.CONSTRAINT: return createConstraint();
			case cvlPackage.SLOT_ASSIGNMENT: return createSlotAssignment();
			case cvlPackage.OBJECT_EXISTENCE: return createObjectExistence();
			case cvlPackage.LINK_END_SUBSTITUTION: return createLinkEndSubstitution();
			case cvlPackage.LINK_HANDLE: return createLinkHandle();
			case cvlPackage.CONFIGURABLE_UNIT: return createConfigurableUnit();
			case cvlPackage.CV_SPEC: return createCVSpec();
			case cvlPackage.VCONFIGURATION: return createVConfiguration();
			case cvlPackage.LINK_EXISTENCE: return createLinkExistence();
			case cvlPackage.OPAQUE_VARIATION_POINT: return createOpaqueVariationPoint();
			case cvlPackage.OVP_TYPE: return createOVPType();
			case cvlPackage.OVP_SEMANTIC_SPEC: return createOVPSemanticSpec();
			case cvlPackage.OBJECT_SPECIFICATION: return createObjectSpecification();
			case cvlPackage.REPLACEMENT_FRAGMENT_SPECIFICATION: return createReplacementFragmentSpecification();
			case cvlPackage.VPACKAGE: return createVPackage();
			case cvlPackage.TO_BINDING: return createToBinding();
			case cvlPackage.TO_PLACEMENT: return createToPlacement();
			case cvlPackage.TO_REPLACEMENT: return createToReplacement();
			case cvlPackage.FROM_BINDING: return createFromBinding();
			case cvlPackage.FROM_PLACEMENT: return createFromPlacement();
			case cvlPackage.FROM_REPLACEMENT: return createFromReplacement();
			case cvlPackage.VSPEC_REF: return createVSpecRef();
			case cvlPackage.BCL_EXPRESSION: return createBCLExpression();
			case cvlPackage.OPAQUE_CONSTRAINT: return createOpaqueConstraint();
			case cvlPackage.SLOT_VALUE_EXISTENCE: return createSlotValueExistence();
			case cvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION: return createParametricLinkEndSubstitution();
			case cvlPackage.PARAMETRIC_OBJECT_SUBSTITUTION: return createParametricObjectSubstitution();
			case cvlPackage.PARAMETRIC_SLOT_ASSIGNMET: return createParametricSlotAssignmet();
			case cvlPackage.CHOICE_DERIVATION: return createChoiceDerivation();
			case cvlPackage.VARIABLE_DERIVATION: return createVariableDerivation();
			case cvlPackage.CV_SPEC_DERIVATION: return createCVSpecDerivation();
			case cvlPackage.CONFIGURABLE_UNIT_USAGE: return createConfigurableUnitUsage();
			case cvlPackage.PRIMITIVE_VALUE_SPECIFICATION: return createPrimitiveValueSpecification();
			case cvlPackage.BCL_CONSTRAINT: return createBCLConstraint();
			case cvlPackage.OPERATION_CALL_EXP: return createOperationCallExp();
			case cvlPackage.BOOLEAN_LITERAL_EXP: return createBooleanLiteralExp();
			case cvlPackage.STRING_LITERAL_EXP: return createStringLiteralExp();
			case cvlPackage.NUMERIC_LITERAL_EXP: return createNumericLiteralExp();
			case cvlPackage.INTEGER_LITERAL_EXP: return createIntegerLiteralExp();
			case cvlPackage.UNLIMITED_LITERAL_EXP: return createUnlimitedLiteralExp();
			case cvlPackage.REAL_LITERAL_EXP: return createRealLiteralExp();
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
			case cvlPackage.PRIMITIVE_TYPE_ENUM:
				return createPrimitiveTypeEnumFromString(eDataType, initialValue);
			case cvlPackage.OPERATION:
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
			case cvlPackage.PRIMITIVE_TYPE_ENUM:
				return convertPrimitiveTypeEnumToString(eDataType, instanceValue);
			case cvlPackage.OPERATION:
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
	public MultiplicityInterval createMultiplicityInterval() {
		MultiplicityIntervalImpl multiplicityInterval = new MultiplicityIntervalImpl();
		return multiplicityInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpecDerivation createVSpecDerivation() {
		VSpecDerivationImpl vSpecDerivation = new VSpecDerivationImpl();
		return vSpecDerivation;
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
	public ChoiceResolutuion createChoiceResolutuion() {
		ChoiceResolutuionImpl choiceResolutuion = new ChoiceResolutuionImpl();
		return choiceResolutuion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VInstance createVInstance() {
		VInstanceImpl vInstance = new VInstanceImpl();
		return vInstance;
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
	public ReplacementFragmentType createReplacementFragmentType() {
		ReplacementFragmentTypeImpl replacementFragmentType = new ReplacementFragmentTypeImpl();
		return replacementFragmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variabletype createVariabletype() {
		VariabletypeImpl variabletype = new VariabletypeImpl();
		return variabletype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectSubstitution createObjectSubstitution() {
		ObjectSubstitutionImpl objectSubstitution = new ObjectSubstitutionImpl();
		return objectSubstitution;
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
	public BaseModelHandle createBaseModelHandle() {
		BaseModelHandleImpl baseModelHandle = new BaseModelHandleImpl();
		return baseModelHandle;
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
	public VariableValueAssignment createVariableValueAssignment() {
		VariableValueAssignmentImpl variableValueAssignment = new VariableValueAssignmentImpl();
		return variableValueAssignment;
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
	public VInterface createVInterface() {
		VInterfaceImpl vInterface = new VInterfaceImpl();
		return vInterface;
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
	public SlotAssignment createSlotAssignment() {
		SlotAssignmentImpl slotAssignment = new SlotAssignmentImpl();
		return slotAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectExistence createObjectExistence() {
		ObjectExistenceImpl objectExistence = new ObjectExistenceImpl();
		return objectExistence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkEndSubstitution createLinkEndSubstitution() {
		LinkEndSubstitutionImpl linkEndSubstitution = new LinkEndSubstitutionImpl();
		return linkEndSubstitution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkHandle createLinkHandle() {
		LinkHandleImpl linkHandle = new LinkHandleImpl();
		return linkHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurableUnit createConfigurableUnit() {
		ConfigurableUnitImpl configurableUnit = new ConfigurableUnitImpl();
		return configurableUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSpec createCVSpec() {
		CVSpecImpl cvSpec = new CVSpecImpl();
		return cvSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VConfiguration createVConfiguration() {
		VConfigurationImpl vConfiguration = new VConfigurationImpl();
		return vConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkExistence createLinkExistence() {
		LinkExistenceImpl linkExistence = new LinkExistenceImpl();
		return linkExistence;
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
	public VSpecRef createVSpecRef() {
		VSpecRefImpl vSpecRef = new VSpecRefImpl();
		return vSpecRef;
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
	public SlotValueExistence createSlotValueExistence() {
		SlotValueExistenceImpl slotValueExistence = new SlotValueExistenceImpl();
		return slotValueExistence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricLinkEndSubstitution createParametricLinkEndSubstitution() {
		ParametricLinkEndSubstitutionImpl parametricLinkEndSubstitution = new ParametricLinkEndSubstitutionImpl();
		return parametricLinkEndSubstitution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricObjectSubstitution createParametricObjectSubstitution() {
		ParametricObjectSubstitutionImpl parametricObjectSubstitution = new ParametricObjectSubstitutionImpl();
		return parametricObjectSubstitution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricSlotAssignmet createParametricSlotAssignmet() {
		ParametricSlotAssignmetImpl parametricSlotAssignmet = new ParametricSlotAssignmetImpl();
		return parametricSlotAssignmet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoiceDerivation createChoiceDerivation() {
		ChoiceDerivationImpl choiceDerivation = new ChoiceDerivationImpl();
		return choiceDerivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDerivation createVariableDerivation() {
		VariableDerivationImpl variableDerivation = new VariableDerivationImpl();
		return variableDerivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSpecDerivation createCVSpecDerivation() {
		CVSpecDerivationImpl cvSpecDerivation = new CVSpecDerivationImpl();
		return cvSpecDerivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurableUnitUsage createConfigurableUnitUsage() {
		ConfigurableUnitUsageImpl configurableUnitUsage = new ConfigurableUnitUsageImpl();
		return configurableUnitUsage;
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
	public cvlPackage getcvlPackage() {
		return (cvlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static cvlPackage getPackage() {
		return cvlPackage.eINSTANCE;
	}

} //cvlFactoryImpl
