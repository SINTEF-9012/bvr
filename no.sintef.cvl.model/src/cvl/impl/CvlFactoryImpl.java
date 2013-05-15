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
public class CvlFactoryImpl extends EFactoryImpl implements CvlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CvlFactory init() {
		try {
			CvlFactory theCvlFactory = (CvlFactory)EPackage.Registry.INSTANCE.getEFactory("http:///cvl.ecore"); 
			if (theCvlFactory != null) {
				return theCvlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CvlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CvlFactoryImpl() {
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
			case CvlPackage.CHOICE: return createChoice();
			case CvlPackage.MULTIPLICITY_INTERVAL: return createMultiplicityInterval();
			case CvlPackage.VSPEC_DERIVATION: return createVSpecDerivation();
			case CvlPackage.VCLASSIFIER: return createVClassifier();
			case CvlPackage.CHOICE_RESOLUTUION: return createChoiceResolutuion();
			case CvlPackage.VINSTANCE: return createVInstance();
			case CvlPackage.FRAGMENT_SUBSTITUTION: return createFragmentSubstitution();
			case CvlPackage.PLACEMENT_FRAGMENT: return createPlacementFragment();
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE: return createReplacementFragmentType();
			case CvlPackage.VARIABLETYPE: return createVariabletype();
			case CvlPackage.OBJECT_SUBSTITUTION: return createObjectSubstitution();
			case CvlPackage.OBJECT_HANDLE: return createObjectHandle();
			case CvlPackage.BASE_MODEL_HANDLE: return createBaseModelHandle();
			case CvlPackage.VARIABLE: return createVariable();
			case CvlPackage.VARIABLE_VALUE_ASSIGNMENT: return createVariableValueAssignment();
			case CvlPackage.PRIMITVE_TYPE: return createPrimitveType();
			case CvlPackage.OBJECT_TYPE: return createObjectType();
			case CvlPackage.VINTERFACE: return createVInterface();
			case CvlPackage.CONSTRAINT: return createConstraint();
			case CvlPackage.SLOT_ASSIGNMENT: return createSlotAssignment();
			case CvlPackage.OBJECT_EXISTENCE: return createObjectExistence();
			case CvlPackage.LINK_END_SUBSTITUTION: return createLinkEndSubstitution();
			case CvlPackage.LINK_HANDLE: return createLinkHandle();
			case CvlPackage.CONFIGURABLE_UNIT: return createConfigurableUnit();
			case CvlPackage.CV_SPEC: return createCVSpec();
			case CvlPackage.VCONFIGURATION: return createVConfiguration();
			case CvlPackage.LINK_EXISTENCE: return createLinkExistence();
			case CvlPackage.OPAQUE_VARIATION_POINT: return createOpaqueVariationPoint();
			case CvlPackage.OVP_TYPE: return createOVPType();
			case CvlPackage.OVP_SEMANTIC_SPEC: return createOVPSemanticSpec();
			case CvlPackage.OBJECT_SPECIFICATION: return createObjectSpecification();
			case CvlPackage.REPLACEMENT_FRAGMENT_SPECIFICATION: return createReplacementFragmentSpecification();
			case CvlPackage.VPACKAGE: return createVPackage();
			case CvlPackage.TO_BINDING: return createToBinding();
			case CvlPackage.TO_PLACEMENT: return createToPlacement();
			case CvlPackage.TO_REPLACEMENT: return createToReplacement();
			case CvlPackage.FROM_BINDING: return createFromBinding();
			case CvlPackage.FROM_PLACEMENT: return createFromPlacement();
			case CvlPackage.FROM_REPLACEMENT: return createFromReplacement();
			case CvlPackage.VSPEC_REF: return createVSpecRef();
			case CvlPackage.BCL_EXPRESSION: return createBCLExpression();
			case CvlPackage.OPAQUE_CONSTRAINT: return createOpaqueConstraint();
			case CvlPackage.SLOT_VALUE_EXISTENCE: return createSlotValueExistence();
			case CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION: return createParametricLinkEndSubstitution();
			case CvlPackage.PARAMETRIC_OBJECT_SUBSTITUTION: return createParametricObjectSubstitution();
			case CvlPackage.PARAMETRIC_SLOT_ASSIGNMET: return createParametricSlotAssignmet();
			case CvlPackage.CHOICE_DERIVATION: return createChoiceDerivation();
			case CvlPackage.VARIABLE_DERIVATION: return createVariableDerivation();
			case CvlPackage.CV_SPEC_DERIVATION: return createCVSpecDerivation();
			case CvlPackage.CONFIGURABLE_UNIT_USAGE: return createConfigurableUnitUsage();
			case CvlPackage.PRIMITIVE_VALUE_SPECIFICATION: return createPrimitiveValueSpecification();
			case CvlPackage.BCL_CONSTRAINT: return createBCLConstraint();
			case CvlPackage.OPERATION_CALL_EXP: return createOperationCallExp();
			case CvlPackage.BOOLEAN_LITERAL_EXP: return createBooleanLiteralExp();
			case CvlPackage.STRING_LITERAL_EXP: return createStringLiteralExp();
			case CvlPackage.NUMERIC_LITERAL_EXP: return createNumericLiteralExp();
			case CvlPackage.INTEGER_LITERAL_EXP: return createIntegerLiteralExp();
			case CvlPackage.UNLIMITED_LITERAL_EXP: return createUnlimitedLiteralExp();
			case CvlPackage.REAL_LITERAL_EXP: return createRealLiteralExp();
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
			case CvlPackage.PRIMITIVE_TYPE_ENUM:
				return createPrimitiveTypeEnumFromString(eDataType, initialValue);
			case CvlPackage.OPERATION:
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
			case CvlPackage.PRIMITIVE_TYPE_ENUM:
				return convertPrimitiveTypeEnumToString(eDataType, instanceValue);
			case CvlPackage.OPERATION:
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
	public CvlPackage getCvlPackage() {
		return (CvlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CvlPackage getPackage() {
		return CvlPackage.eINSTANCE;
	}

} //CvlFactoryImpl
