/**
 */
package bvr.util;

import bvr.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see bvr.BvrPackage
 * @generated
 */
public class BvrAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BvrPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BvrAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BvrPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BvrSwitch<Adapter> modelSwitch =
		new BvrSwitch<Adapter>() {
			@Override
			public Adapter caseChoice(Choice object) {
				return createChoiceAdapter();
			}
			@Override
			public Adapter caseVSpec(VSpec object) {
				return createVSpecAdapter();
			}
			@Override
			public Adapter caseVPackageable(VPackageable object) {
				return createVPackageableAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseMultiplicityInterval(MultiplicityInterval object) {
				return createMultiplicityIntervalAdapter();
			}
			@Override
			public Adapter caseVSpecDerivation(VSpecDerivation object) {
				return createVSpecDerivationAdapter();
			}
			@Override
			public Adapter caseVClassifier(VClassifier object) {
				return createVClassifierAdapter();
			}
			@Override
			public Adapter caseVSpecResolution(VSpecResolution object) {
				return createVSpecResolutionAdapter();
			}
			@Override
			public Adapter caseChoiceResolutuion(ChoiceResolutuion object) {
				return createChoiceResolutuionAdapter();
			}
			@Override
			public Adapter caseVInstance(VInstance object) {
				return createVInstanceAdapter();
			}
			@Override
			public Adapter caseVariationPoint(VariationPoint object) {
				return createVariationPointAdapter();
			}
			@Override
			public Adapter caseFragmentSubstitution(FragmentSubstitution object) {
				return createFragmentSubstitutionAdapter();
			}
			@Override
			public Adapter caseChoiceVariationPoint(ChoiceVariationPoint object) {
				return createChoiceVariationPointAdapter();
			}
			@Override
			public Adapter caseRepeatableVariationPoint(RepeatableVariationPoint object) {
				return createRepeatableVariationPointAdapter();
			}
			@Override
			public Adapter caseBoundaryElementBinding(BoundaryElementBinding object) {
				return createBoundaryElementBindingAdapter();
			}
			@Override
			public Adapter casePlacementFragment(PlacementFragment object) {
				return createPlacementFragmentAdapter();
			}
			@Override
			public Adapter casePlacementBoundaryElement(PlacementBoundaryElement object) {
				return createPlacementBoundaryElementAdapter();
			}
			@Override
			public Adapter caseObjectHandle(ObjectHandle object) {
				return createObjectHandleAdapter();
			}
			@Override
			public Adapter caseBaseModelHandle(BaseModelHandle object) {
				return createBaseModelHandleAdapter();
			}
			@Override
			public Adapter caseReplacementFragmentType(ReplacementFragmentType object) {
				return createReplacementFragmentTypeAdapter();
			}
			@Override
			public Adapter caseVariabletype(Variabletype object) {
				return createVariabletypeAdapter();
			}
			@Override
			public Adapter caseReplacementBoundaryElement(ReplacementBoundaryElement object) {
				return createReplacementBoundaryElementAdapter();
			}
			@Override
			public Adapter caseObjectSubstitution(ObjectSubstitution object) {
				return createObjectSubstitutionAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter caseValueSpecification(ValueSpecification object) {
				return createValueSpecificationAdapter();
			}
			@Override
			public Adapter caseVariableValueAssignment(VariableValueAssignment object) {
				return createVariableValueAssignmentAdapter();
			}
			@Override
			public Adapter casePrimitveType(PrimitveType object) {
				return createPrimitveTypeAdapter();
			}
			@Override
			public Adapter caseObjectType(ObjectType object) {
				return createObjectTypeAdapter();
			}
			@Override
			public Adapter caseVInterface(VInterface object) {
				return createVInterfaceAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseSlotAssignment(SlotAssignment object) {
				return createSlotAssignmentAdapter();
			}
			@Override
			public Adapter caseObjectExistence(ObjectExistence object) {
				return createObjectExistenceAdapter();
			}
			@Override
			public Adapter caseLinkEndSubstitution(LinkEndSubstitution object) {
				return createLinkEndSubstitutionAdapter();
			}
			@Override
			public Adapter caseLinkHandle(LinkHandle object) {
				return createLinkHandleAdapter();
			}
			@Override
			public Adapter caseConfigurableUnit(ConfigurableUnit object) {
				return createConfigurableUnitAdapter();
			}
			@Override
			public Adapter caseCompositeVariationPoint(CompositeVariationPoint object) {
				return createCompositeVariationPointAdapter();
			}
			@Override
			public Adapter caseCVSpec(CVSpec object) {
				return createCVSpecAdapter();
			}
			@Override
			public Adapter caseVConfiguration(VConfiguration object) {
				return createVConfigurationAdapter();
			}
			@Override
			public Adapter caseLinkExistence(LinkExistence object) {
				return createLinkExistenceAdapter();
			}
			@Override
			public Adapter caseOpaqueVariationPoint(OpaqueVariationPoint object) {
				return createOpaqueVariationPointAdapter();
			}
			@Override
			public Adapter caseOVPType(OVPType object) {
				return createOVPTypeAdapter();
			}
			@Override
			public Adapter caseOVPSemanticSpec(OVPSemanticSpec object) {
				return createOVPSemanticSpecAdapter();
			}
			@Override
			public Adapter caseObjectSpecification(ObjectSpecification object) {
				return createObjectSpecificationAdapter();
			}
			@Override
			public Adapter caseReplacementFragmentSpecification(ReplacementFragmentSpecification object) {
				return createReplacementFragmentSpecificationAdapter();
			}
			@Override
			public Adapter caseVPackage(VPackage object) {
				return createVPackageAdapter();
			}
			@Override
			public Adapter caseToBinding(ToBinding object) {
				return createToBindingAdapter();
			}
			@Override
			public Adapter caseToPlacement(ToPlacement object) {
				return createToPlacementAdapter();
			}
			@Override
			public Adapter caseToReplacement(ToReplacement object) {
				return createToReplacementAdapter();
			}
			@Override
			public Adapter caseFromBinding(FromBinding object) {
				return createFromBindingAdapter();
			}
			@Override
			public Adapter caseFromPlacement(FromPlacement object) {
				return createFromPlacementAdapter();
			}
			@Override
			public Adapter caseFromReplacement(FromReplacement object) {
				return createFromReplacementAdapter();
			}
			@Override
			public Adapter caseVSpecRef(VSpecRef object) {
				return createVSpecRefAdapter();
			}
			@Override
			public Adapter caseBCLExpression(BCLExpression object) {
				return createBCLExpressionAdapter();
			}
			@Override
			public Adapter caseOpaqueConstraint(OpaqueConstraint object) {
				return createOpaqueConstraintAdapter();
			}
			@Override
			public Adapter caseParametricVariationPoint(ParametricVariationPoint object) {
				return createParametricVariationPointAdapter();
			}
			@Override
			public Adapter caseSlotValueExistence(SlotValueExistence object) {
				return createSlotValueExistenceAdapter();
			}
			@Override
			public Adapter caseParametricLinkEndSubstitution(ParametricLinkEndSubstitution object) {
				return createParametricLinkEndSubstitutionAdapter();
			}
			@Override
			public Adapter caseParametricObjectSubstitution(ParametricObjectSubstitution object) {
				return createParametricObjectSubstitutionAdapter();
			}
			@Override
			public Adapter caseParametricSlotAssignmet(ParametricSlotAssignmet object) {
				return createParametricSlotAssignmetAdapter();
			}
			@Override
			public Adapter caseChoiceDerivation(ChoiceDerivation object) {
				return createChoiceDerivationAdapter();
			}
			@Override
			public Adapter caseVariableDerivation(VariableDerivation object) {
				return createVariableDerivationAdapter();
			}
			@Override
			public Adapter caseCVSpecDerivation(CVSpecDerivation object) {
				return createCVSpecDerivationAdapter();
			}
			@Override
			public Adapter caseConfigurableUnitUsage(ConfigurableUnitUsage object) {
				return createConfigurableUnitUsageAdapter();
			}
			@Override
			public Adapter casePrimitiveValueSpecification(PrimitiveValueSpecification object) {
				return createPrimitiveValueSpecificationAdapter();
			}
			@Override
			public Adapter caseBCLConstraint(BCLConstraint object) {
				return createBCLConstraintAdapter();
			}
			@Override
			public Adapter caseOperationCallExp(OperationCallExp object) {
				return createOperationCallExpAdapter();
			}
			@Override
			public Adapter caseBooleanLiteralExp(BooleanLiteralExp object) {
				return createBooleanLiteralExpAdapter();
			}
			@Override
			public Adapter caseStringLiteralExp(StringLiteralExp object) {
				return createStringLiteralExpAdapter();
			}
			@Override
			public Adapter caseNumericLiteralExp(NumericLiteralExp object) {
				return createNumericLiteralExpAdapter();
			}
			@Override
			public Adapter caseIntegerLiteralExp(IntegerLiteralExp object) {
				return createIntegerLiteralExpAdapter();
			}
			@Override
			public Adapter caseUnlimitedLiteralExp(UnlimitedLiteralExp object) {
				return createUnlimitedLiteralExpAdapter();
			}
			@Override
			public Adapter caseRealLiteralExp(RealLiteralExp object) {
				return createRealLiteralExpAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link bvr.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.Choice
	 * @generated
	 */
	public Adapter createChoiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.VSpec <em>VSpec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.VSpec
	 * @generated
	 */
	public Adapter createVSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.VPackageable <em>VPackageable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.VPackageable
	 * @generated
	 */
	public Adapter createVPackageableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.MultiplicityInterval <em>Multiplicity Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.MultiplicityInterval
	 * @generated
	 */
	public Adapter createMultiplicityIntervalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.VSpecDerivation <em>VSpec Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.VSpecDerivation
	 * @generated
	 */
	public Adapter createVSpecDerivationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.VClassifier <em>VClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.VClassifier
	 * @generated
	 */
	public Adapter createVClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.VSpecResolution <em>VSpec Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.VSpecResolution
	 * @generated
	 */
	public Adapter createVSpecResolutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ChoiceResolutuion <em>Choice Resolutuion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ChoiceResolutuion
	 * @generated
	 */
	public Adapter createChoiceResolutuionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.VInstance <em>VInstance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.VInstance
	 * @generated
	 */
	public Adapter createVInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.VariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.VariationPoint
	 * @generated
	 */
	public Adapter createVariationPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.FragmentSubstitution <em>Fragment Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.FragmentSubstitution
	 * @generated
	 */
	public Adapter createFragmentSubstitutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ChoiceVariationPoint <em>Choice Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ChoiceVariationPoint
	 * @generated
	 */
	public Adapter createChoiceVariationPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.RepeatableVariationPoint <em>Repeatable Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.RepeatableVariationPoint
	 * @generated
	 */
	public Adapter createRepeatableVariationPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.BoundaryElementBinding <em>Boundary Element Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.BoundaryElementBinding
	 * @generated
	 */
	public Adapter createBoundaryElementBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.PlacementFragment <em>Placement Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.PlacementFragment
	 * @generated
	 */
	public Adapter createPlacementFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.PlacementBoundaryElement <em>Placement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.PlacementBoundaryElement
	 * @generated
	 */
	public Adapter createPlacementBoundaryElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ObjectHandle <em>Object Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ObjectHandle
	 * @generated
	 */
	public Adapter createObjectHandleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.BaseModelHandle <em>Base Model Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.BaseModelHandle
	 * @generated
	 */
	public Adapter createBaseModelHandleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ReplacementFragmentType <em>Replacement Fragment Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ReplacementFragmentType
	 * @generated
	 */
	public Adapter createReplacementFragmentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.Variabletype <em>Variabletype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.Variabletype
	 * @generated
	 */
	public Adapter createVariabletypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ReplacementBoundaryElement <em>Replacement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ReplacementBoundaryElement
	 * @generated
	 */
	public Adapter createReplacementBoundaryElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ObjectSubstitution <em>Object Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ObjectSubstitution
	 * @generated
	 */
	public Adapter createObjectSubstitutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ValueSpecification <em>Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ValueSpecification
	 * @generated
	 */
	public Adapter createValueSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.VariableValueAssignment <em>Variable Value Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.VariableValueAssignment
	 * @generated
	 */
	public Adapter createVariableValueAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.PrimitveType <em>Primitve Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.PrimitveType
	 * @generated
	 */
	public Adapter createPrimitveTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ObjectType <em>Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ObjectType
	 * @generated
	 */
	public Adapter createObjectTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.VInterface <em>VInterface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.VInterface
	 * @generated
	 */
	public Adapter createVInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.SlotAssignment <em>Slot Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.SlotAssignment
	 * @generated
	 */
	public Adapter createSlotAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ObjectExistence <em>Object Existence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ObjectExistence
	 * @generated
	 */
	public Adapter createObjectExistenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.LinkEndSubstitution <em>Link End Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.LinkEndSubstitution
	 * @generated
	 */
	public Adapter createLinkEndSubstitutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.LinkHandle <em>Link Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.LinkHandle
	 * @generated
	 */
	public Adapter createLinkHandleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ConfigurableUnit <em>Configurable Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ConfigurableUnit
	 * @generated
	 */
	public Adapter createConfigurableUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.CompositeVariationPoint <em>Composite Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.CompositeVariationPoint
	 * @generated
	 */
	public Adapter createCompositeVariationPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.CVSpec <em>CV Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.CVSpec
	 * @generated
	 */
	public Adapter createCVSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.VConfiguration <em>VConfiguration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.VConfiguration
	 * @generated
	 */
	public Adapter createVConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.LinkExistence <em>Link Existence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.LinkExistence
	 * @generated
	 */
	public Adapter createLinkExistenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.OpaqueVariationPoint <em>Opaque Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.OpaqueVariationPoint
	 * @generated
	 */
	public Adapter createOpaqueVariationPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.OVPType <em>OVP Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.OVPType
	 * @generated
	 */
	public Adapter createOVPTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.OVPSemanticSpec <em>OVP Semantic Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.OVPSemanticSpec
	 * @generated
	 */
	public Adapter createOVPSemanticSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ObjectSpecification <em>Object Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ObjectSpecification
	 * @generated
	 */
	public Adapter createObjectSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ReplacementFragmentSpecification <em>Replacement Fragment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ReplacementFragmentSpecification
	 * @generated
	 */
	public Adapter createReplacementFragmentSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.VPackage <em>VPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.VPackage
	 * @generated
	 */
	public Adapter createVPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ToBinding <em>To Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ToBinding
	 * @generated
	 */
	public Adapter createToBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ToPlacement <em>To Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ToPlacement
	 * @generated
	 */
	public Adapter createToPlacementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ToReplacement <em>To Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ToReplacement
	 * @generated
	 */
	public Adapter createToReplacementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.FromBinding <em>From Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.FromBinding
	 * @generated
	 */
	public Adapter createFromBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.FromPlacement <em>From Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.FromPlacement
	 * @generated
	 */
	public Adapter createFromPlacementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.FromReplacement <em>From Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.FromReplacement
	 * @generated
	 */
	public Adapter createFromReplacementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.VSpecRef <em>VSpec Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.VSpecRef
	 * @generated
	 */
	public Adapter createVSpecRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.BCLExpression <em>BCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.BCLExpression
	 * @generated
	 */
	public Adapter createBCLExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.OpaqueConstraint <em>Opaque Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.OpaqueConstraint
	 * @generated
	 */
	public Adapter createOpaqueConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ParametricVariationPoint <em>Parametric Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ParametricVariationPoint
	 * @generated
	 */
	public Adapter createParametricVariationPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.SlotValueExistence <em>Slot Value Existence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.SlotValueExistence
	 * @generated
	 */
	public Adapter createSlotValueExistenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ParametricLinkEndSubstitution <em>Parametric Link End Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ParametricLinkEndSubstitution
	 * @generated
	 */
	public Adapter createParametricLinkEndSubstitutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ParametricObjectSubstitution <em>Parametric Object Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ParametricObjectSubstitution
	 * @generated
	 */
	public Adapter createParametricObjectSubstitutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ParametricSlotAssignmet <em>Parametric Slot Assignmet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ParametricSlotAssignmet
	 * @generated
	 */
	public Adapter createParametricSlotAssignmetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ChoiceDerivation <em>Choice Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ChoiceDerivation
	 * @generated
	 */
	public Adapter createChoiceDerivationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.VariableDerivation <em>Variable Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.VariableDerivation
	 * @generated
	 */
	public Adapter createVariableDerivationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.CVSpecDerivation <em>CV Spec Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.CVSpecDerivation
	 * @generated
	 */
	public Adapter createCVSpecDerivationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.ConfigurableUnitUsage <em>Configurable Unit Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.ConfigurableUnitUsage
	 * @generated
	 */
	public Adapter createConfigurableUnitUsageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.PrimitiveValueSpecification <em>Primitive Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.PrimitiveValueSpecification
	 * @generated
	 */
	public Adapter createPrimitiveValueSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.BCLConstraint <em>BCL Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.BCLConstraint
	 * @generated
	 */
	public Adapter createBCLConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.OperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.OperationCallExp
	 * @generated
	 */
	public Adapter createOperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.BooleanLiteralExp
	 * @generated
	 */
	public Adapter createBooleanLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.StringLiteralExp <em>String Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.StringLiteralExp
	 * @generated
	 */
	public Adapter createStringLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.NumericLiteralExp
	 * @generated
	 */
	public Adapter createNumericLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.IntegerLiteralExp
	 * @generated
	 */
	public Adapter createIntegerLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.UnlimitedLiteralExp <em>Unlimited Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.UnlimitedLiteralExp
	 * @generated
	 */
	public Adapter createUnlimitedLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bvr.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bvr.RealLiteralExp
	 * @generated
	 */
	public Adapter createRealLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //BvrAdapterFactory
