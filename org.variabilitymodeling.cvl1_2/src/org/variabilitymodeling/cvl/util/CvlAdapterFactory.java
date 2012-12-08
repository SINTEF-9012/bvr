/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.variabilitymodeling.cvl.*;
import org.variabilitymodeling.cvl.visitors.Visitable;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.variabilitymodeling.cvl.CvlPackage
 * @generated
 */
public class CvlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CvlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CvlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CvlPackage.eINSTANCE;
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
	protected CvlSwitch<Adapter> modelSwitch =
		new CvlSwitch<Adapter>() {
			@Override
			public Adapter caseCVLModel(CVLModel object) {
				return createCVLModelAdapter();
			}
			@Override
			public Adapter caseSubstitution(Substitution object) {
				return createSubstitutionAdapter();
			}
			@Override
			public Adapter caseReferenceSubstitution(ReferenceSubstitution object) {
				return createReferenceSubstitutionAdapter();
			}
			@Override
			public Adapter caseValueSubstitution(ValueSubstitution object) {
				return createValueSubstitutionAdapter();
			}
			@Override
			public Adapter caseFragmentSubstitution(FragmentSubstitution object) {
				return createFragmentSubstitutionAdapter();
			}
			@Override
			public Adapter casePlacementFragment(PlacementFragment object) {
				return createPlacementFragmentAdapter();
			}
			@Override
			public Adapter caseReplacementFragment(ReplacementFragment object) {
				return createReplacementFragmentAdapter();
			}
			@Override
			public Adapter casePlacementBoundaryElement(PlacementBoundaryElement object) {
				return createPlacementBoundaryElementAdapter();
			}
			@Override
			public Adapter caseReplacementBoundaryElement(ReplacementBoundaryElement object) {
				return createReplacementBoundaryElementAdapter();
			}
			@Override
			public Adapter caseFromPlacement(FromPlacement object) {
				return createFromPlacementAdapter();
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
			public Adapter caseFromReplacement(FromReplacement object) {
				return createFromReplacementAdapter();
			}
			@Override
			public Adapter caseCVLElement(CVLElement object) {
				return createCVLElementAdapter();
			}
			@Override
			public Adapter caseBoundaryElementBinding(BoundaryElementBinding object) {
				return createBoundaryElementBindingAdapter();
			}
			@Override
			public Adapter caseToBinding(ToBinding object) {
				return createToBindingAdapter();
			}
			@Override
			public Adapter caseFromBinding(FromBinding object) {
				return createFromBindingAdapter();
			}
			@Override
			public Adapter caseCompositeVariability(CompositeVariability object) {
				return createCompositeVariabilityAdapter();
			}
			@Override
			public Adapter caseVariabilitySpecification(VariabilitySpecification object) {
				return createVariabilitySpecificationAdapter();
			}
			@Override
			public Adapter caseCVLNamedElement(CVLNamedElement object) {
				return createCVLNamedElementAdapter();
			}
			@Override
			public Adapter casePlacementLiteral(PlacementLiteral object) {
				return createPlacementLiteralAdapter();
			}
			@Override
			public Adapter caseReplacementLiteral(ReplacementLiteral object) {
				return createReplacementLiteralAdapter();
			}
			@Override
			public Adapter casePlacementValue(PlacementValue object) {
				return createPlacementValueAdapter();
			}
			@Override
			public Adapter casePlacementObject(PlacementObject object) {
				return createPlacementObjectAdapter();
			}
			@Override
			public Adapter caseReplacementValue(ReplacementValue object) {
				return createReplacementValueAdapter();
			}
			@Override
			public Adapter caseReplacementObject(ReplacementObject object) {
				return createReplacementObjectAdapter();
			}
			@Override
			public Adapter caseResolutionSpecification(ResolutionSpecification object) {
				return createResolutionSpecificationAdapter();
			}
			@Override
			public Adapter caseResolutionElement(ResolutionElement object) {
				return createResolutionElementAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseInvocation(Invocation object) {
				return createInvocationAdapter();
			}
			@Override
			public Adapter caseIteratorResolution(IteratorResolution object) {
				return createIteratorResolutionAdapter();
			}
			@Override
			public Adapter caseIterator(Iterator object) {
				return createIteratorAdapter();
			}
			@Override
			public Adapter caseReplacementFragmentReference(ReplacementFragmentReference object) {
				return createReplacementFragmentReferenceAdapter();
			}
			@Override
			public Adapter caseReplacementFragmentAbstract(ReplacementFragmentAbstract object) {
				return createReplacementFragmentAbstractAdapter();
			}
			@Override
			public Adapter caseAssignment(Assignment object) {
				return createAssignmentAdapter();
			}
			@Override
			public Adapter caseDeclaration(Declaration object) {
				return createDeclarationAdapter();
			}
			@Override
			public Adapter caseExecutablePrimitive(ExecutablePrimitive object) {
				return createExecutablePrimitiveAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseNOT(NOT object) {
				return createNOTAdapter();
			}
			@Override
			public Adapter caseOR(OR object) {
				return createORAdapter();
			}
			@Override
			public Adapter caseIMPLIES(IMPLIES object) {
				return createIMPLIESAdapter();
			}
			@Override
			public Adapter caseExecutablePrimitiveTerm(ExecutablePrimitiveTerm object) {
				return createExecutablePrimitiveTermAdapter();
			}
			@Override
			public Adapter caseAND_(AND_ object) {
				return createAND_Adapter();
			}
			@Override
			public Adapter caseBinary(Binary object) {
				return createBinaryAdapter();
			}
			@Override
			public Adapter caseResolutionValue(ResolutionValue object) {
				return createResolutionValueAdapter();
			}
			@Override
			public Adapter caseVisitable(Visitable object) {
				return createVisitableAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.CVLModel <em>CVL Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.CVLModel
	 * @generated
	 */
	public Adapter createCVLModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.Substitution <em>Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.Substitution
	 * @generated
	 */
	public Adapter createSubstitutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ReferenceSubstitution <em>Reference Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ReferenceSubstitution
	 * @generated
	 */
	public Adapter createReferenceSubstitutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ValueSubstitution <em>Value Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ValueSubstitution
	 * @generated
	 */
	public Adapter createValueSubstitutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.FragmentSubstitution <em>Fragment Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.FragmentSubstitution
	 * @generated
	 */
	public Adapter createFragmentSubstitutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.PlacementFragment <em>Placement Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.PlacementFragment
	 * @generated
	 */
	public Adapter createPlacementFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ReplacementFragment <em>Replacement Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ReplacementFragment
	 * @generated
	 */
	public Adapter createReplacementFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.PlacementBoundaryElement <em>Placement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.PlacementBoundaryElement
	 * @generated
	 */
	public Adapter createPlacementBoundaryElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ReplacementBoundaryElement <em>Replacement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ReplacementBoundaryElement
	 * @generated
	 */
	public Adapter createReplacementBoundaryElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.FromPlacement <em>From Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.FromPlacement
	 * @generated
	 */
	public Adapter createFromPlacementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ToPlacement <em>To Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ToPlacement
	 * @generated
	 */
	public Adapter createToPlacementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ToReplacement <em>To Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ToReplacement
	 * @generated
	 */
	public Adapter createToReplacementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.FromReplacement <em>From Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.FromReplacement
	 * @generated
	 */
	public Adapter createFromReplacementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.CVLElement <em>CVL Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.CVLElement
	 * @generated
	 */
	public Adapter createCVLElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.BoundaryElementBinding <em>Boundary Element Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.BoundaryElementBinding
	 * @generated
	 */
	public Adapter createBoundaryElementBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ToBinding <em>To Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ToBinding
	 * @generated
	 */
	public Adapter createToBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.FromBinding <em>From Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.FromBinding
	 * @generated
	 */
	public Adapter createFromBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.CompositeVariability <em>Composite Variability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.CompositeVariability
	 * @generated
	 */
	public Adapter createCompositeVariabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.VariabilitySpecification <em>Variability Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.VariabilitySpecification
	 * @generated
	 */
	public Adapter createVariabilitySpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.CVLNamedElement <em>CVL Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.CVLNamedElement
	 * @generated
	 */
	public Adapter createCVLNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.PlacementLiteral <em>Placement Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.PlacementLiteral
	 * @generated
	 */
	public Adapter createPlacementLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ReplacementLiteral <em>Replacement Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ReplacementLiteral
	 * @generated
	 */
	public Adapter createReplacementLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.PlacementValue <em>Placement Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.PlacementValue
	 * @generated
	 */
	public Adapter createPlacementValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.PlacementObject <em>Placement Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.PlacementObject
	 * @generated
	 */
	public Adapter createPlacementObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ReplacementValue <em>Replacement Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ReplacementValue
	 * @generated
	 */
	public Adapter createReplacementValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ReplacementObject <em>Replacement Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ReplacementObject
	 * @generated
	 */
	public Adapter createReplacementObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ResolutionSpecification <em>Resolution Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ResolutionSpecification
	 * @generated
	 */
	public Adapter createResolutionSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ResolutionElement <em>Resolution Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ResolutionElement
	 * @generated
	 */
	public Adapter createResolutionElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.Invocation <em>Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.Invocation
	 * @generated
	 */
	public Adapter createInvocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.IteratorResolution <em>Iterator Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.IteratorResolution
	 * @generated
	 */
	public Adapter createIteratorResolutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.Iterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.Iterator
	 * @generated
	 */
	public Adapter createIteratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ReplacementFragmentReference <em>Replacement Fragment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ReplacementFragmentReference
	 * @generated
	 */
	public Adapter createReplacementFragmentReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ReplacementFragmentAbstract <em>Replacement Fragment Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ReplacementFragmentAbstract
	 * @generated
	 */
	public Adapter createReplacementFragmentAbstractAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.Assignment
	 * @generated
	 */
	public Adapter createAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.Declaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.Declaration
	 * @generated
	 */
	public Adapter createDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ExecutablePrimitive <em>Executable Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ExecutablePrimitive
	 * @generated
	 */
	public Adapter createExecutablePrimitiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.NOT <em>NOT</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.NOT
	 * @generated
	 */
	public Adapter createNOTAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.OR <em>OR</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.OR
	 * @generated
	 */
	public Adapter createORAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.IMPLIES <em>IMPLIES</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.IMPLIES
	 * @generated
	 */
	public Adapter createIMPLIESAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ExecutablePrimitiveTerm <em>Executable Primitive Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ExecutablePrimitiveTerm
	 * @generated
	 */
	public Adapter createExecutablePrimitiveTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.AND_ <em>AND </em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.AND_
	 * @generated
	 */
	public Adapter createAND_Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.Binary <em>Binary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.Binary
	 * @generated
	 */
	public Adapter createBinaryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.ResolutionValue <em>Resolution Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.ResolutionValue
	 * @generated
	 */
	public Adapter createResolutionValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.variabilitymodeling.cvl.visitors.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.variabilitymodeling.cvl.visitors.Visitable
	 * @generated
	 */
	public Adapter createVisitableAdapter() {
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

} //CvlAdapterFactory
