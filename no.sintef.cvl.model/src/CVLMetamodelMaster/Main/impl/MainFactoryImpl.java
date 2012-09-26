/**
 */
package CVLMetamodelMaster.Main.impl;

import CVLMetamodelMaster.Main.*;

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
public class MainFactoryImpl extends EFactoryImpl implements MainFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MainFactory init() {
		try {
			MainFactory theMainFactory = (MainFactory)EPackage.Registry.INSTANCE.getEFactory("http:///CVLMetamodelMaster/Main.ecore"); 
			if (theMainFactory != null) {
				return theMainFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MainFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MainFactoryImpl() {
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
			case MainPackage.CHOICE: return createChoice();
			case MainPackage.MULTIPLICITY_INTERVAL: return createMultiplicityInterval();
			case MainPackage.VSPEC_DERIVATION: return createVSpecDerivation();
			case MainPackage.VCLASSIFIER: return createVClassifier();
			case MainPackage.CHOICE_RESOLUTUION: return createChoiceResolutuion();
			case MainPackage.VINSTANCE: return createVInstance();
			case MainPackage.FRAGMENT_SUBSTITUTION: return createFragmentSubstitution();
			case MainPackage.PLACEMENT_FRAGMENT: return createPlacementFragment();
			case MainPackage.REPLACEMENT_FRAGMENT_TYPE: return createReplacementFragmentType();
			case MainPackage.VARIABLETYPE: return createVariabletype();
			case MainPackage.OBJECT_SUBSTITUTION: return createObjectSubstitution();
			case MainPackage.OBJECT_HANDLE: return createObjectHandle();
			case MainPackage.BASE_MODEL_HANDLE: return createBaseModelHandle();
			case MainPackage.VARIABLE: return createVariable();
			case MainPackage.VARIABLE_VALUE_ASSIGNMENT: return createVariableValueAssignment();
			case MainPackage.PRIMITVE_TYPE: return createPrimitveType();
			case MainPackage.OBJECT_TYPE: return createObjectType();
			case MainPackage.VINTERFACE: return createVInterface();
			case MainPackage.CONSTRAINT: return createConstraint();
			case MainPackage.SLOT_ASSIGNMENT: return createSlotAssignment();
			case MainPackage.OBJECT_EXISTENCE: return createObjectExistence();
			case MainPackage.LINK_END_SUBSTITUTION: return createLinkEndSubstitution();
			case MainPackage.LINK_HANDLE: return createLinkHandle();
			case MainPackage.CONFIGURABLE_UNIT: return createConfigurableUnit();
			case MainPackage.CV_SPEC: return createCVSpec();
			case MainPackage.VCONFIGURATION: return createVConfiguration();
			case MainPackage.LINK_EXISTENCE: return createLinkExistence();
			case MainPackage.OPAQUE_VARIATION_POINT: return createOpaqueVariationPoint();
			case MainPackage.OVP_TYPE: return createOVPType();
			case MainPackage.OVP_SEMANTIC_SPEC: return createOVPSemanticSpec();
			case MainPackage.OBJECT_SPECIFICATION: return createObjectSpecification();
			case MainPackage.REPLACEMENT_FRAGMENT_SPECIFICATION: return createReplacementFragmentSpecification();
			case MainPackage.VPACKAGE: return createVPackage();
			case MainPackage.TO_BINDING: return createToBinding();
			case MainPackage.TO_PLACEMENT: return createToPlacement();
			case MainPackage.TO_REPLACEMENT: return createToReplacement();
			case MainPackage.FROM_BINDING: return createFromBinding();
			case MainPackage.FROM_PLACEMENT: return createFromPlacement();
			case MainPackage.FROM_REPLACEMENT: return createFromReplacement();
			case MainPackage.VSPEC_REF: return createVSpecRef();
			case MainPackage.BCL_EXPRESSION: return createBCLExpression();
			case MainPackage.OPAQUE_CONSTRAINT: return createOpaqueConstraint();
			case MainPackage.SLOT_VALUE_EXISTENCE: return createSlotValueExistence();
			case MainPackage.PARAMETRIC_LINK_END_SUBSTITUTION: return createParametricLinkEndSubstitution();
			case MainPackage.PARAMETRIC_OBJECT_SUBSTITUTION: return createParametricObjectSubstitution();
			case MainPackage.PARAMETRIC_SLOT_ASSIGNMET: return createParametricSlotAssignmet();
			case MainPackage.CHOICE_DERIVATION: return createChoiceDerivation();
			case MainPackage.VARIABLE_DERIVATION: return createVariableDerivation();
			case MainPackage.CV_SPEC_DERIVATION: return createCVSpecDerivation();
			case MainPackage.CONFIGURABLE_UNIT_USAGE: return createConfigurableUnitUsage();
			case MainPackage.PRIMITIVE_VALUE_SPECIFICATION: return createPrimitiveValueSpecification();
			case MainPackage.BCL_CONSTRAINT: return createBCLConstraint();
			case MainPackage.OPERATION_CALL_EXP: return createOperationCallExp();
			case MainPackage.BOOLEAN_LITERAL_EXP: return createBooleanLiteralExp();
			case MainPackage.STRING_LITERAL_EXP: return createStringLiteralExp();
			case MainPackage.NUMERIC_LITERAL_EXP: return createNumericLiteralExp();
			case MainPackage.INTEGER_LITERAL_EXP: return createIntegerLiteralExp();
			case MainPackage.UNLIMITED_LITERAL_EXP: return createUnlimitedLiteralExp();
			case MainPackage.REAL_LITERAL_EXP: return createRealLiteralExp();
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
			case MainPackage.PRIMITIVE_TYPE_ENUM:
				return createPrimitiveTypeEnumFromString(eDataType, initialValue);
			case MainPackage.OPERATION:
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
			case MainPackage.PRIMITIVE_TYPE_ENUM:
				return convertPrimitiveTypeEnumToString(eDataType, instanceValue);
			case MainPackage.OPERATION:
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
	public MainPackage getMainPackage() {
		return (MainPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MainPackage getPackage() {
		return MainPackage.eINSTANCE;
	}

} //MainFactoryImpl
