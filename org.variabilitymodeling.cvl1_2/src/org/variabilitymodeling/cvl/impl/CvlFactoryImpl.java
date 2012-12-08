/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.variabilitymodeling.cvl.*;

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
			CvlFactory theCvlFactory = (CvlFactory)EPackage.Registry.INSTANCE.getEFactory("http://org.variabilitymodeling.cvl"); 
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
			case CvlPackage.CVL_MODEL: return createCVLModel();
			case CvlPackage.REFERENCE_SUBSTITUTION: return createReferenceSubstitution();
			case CvlPackage.VALUE_SUBSTITUTION: return createValueSubstitution();
			case CvlPackage.FRAGMENT_SUBSTITUTION: return createFragmentSubstitution();
			case CvlPackage.PLACEMENT_FRAGMENT: return createPlacementFragment();
			case CvlPackage.REPLACEMENT_FRAGMENT: return createReplacementFragment();
			case CvlPackage.FROM_PLACEMENT: return createFromPlacement();
			case CvlPackage.TO_PLACEMENT: return createToPlacement();
			case CvlPackage.TO_REPLACEMENT: return createToReplacement();
			case CvlPackage.FROM_REPLACEMENT: return createFromReplacement();
			case CvlPackage.CVL_ELEMENT: return createCVLElement();
			case CvlPackage.TO_BINDING: return createToBinding();
			case CvlPackage.FROM_BINDING: return createFromBinding();
			case CvlPackage.COMPOSITE_VARIABILITY: return createCompositeVariability();
			case CvlPackage.PLACEMENT_VALUE: return createPlacementValue();
			case CvlPackage.PLACEMENT_OBJECT: return createPlacementObject();
			case CvlPackage.REPLACEMENT_VALUE: return createReplacementValue();
			case CvlPackage.REPLACEMENT_OBJECT: return createReplacementObject();
			case CvlPackage.RESOLUTION_ELEMENT: return createResolutionElement();
			case CvlPackage.TYPE: return createType();
			case CvlPackage.INVOCATION: return createInvocation();
			case CvlPackage.ITERATOR_RESOLUTION: return createIteratorResolution();
			case CvlPackage.ITERATOR: return createIterator();
			case CvlPackage.REPLACEMENT_FRAGMENT_REFERENCE: return createReplacementFragmentReference();
			case CvlPackage.ASSIGNMENT: return createAssignment();
			case CvlPackage.CONSTRAINT: return createConstraint();
			case CvlPackage.NOT: return createNOT();
			case CvlPackage.OR: return createOR();
			case CvlPackage.IMPLIES: return createIMPLIES();
			case CvlPackage.EXECUTABLE_PRIMITIVE_TERM: return createExecutablePrimitiveTerm();
			case CvlPackage.AND_: return createAND_();
			case CvlPackage.RESOLUTION_VALUE: return createResolutionValue();
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
			case CvlPackage.PLACEMENT_FRAGMENT_USAGE:
				return createPlacementFragmentUsageFromString(eDataType, initialValue);
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
			case CvlPackage.PLACEMENT_FRAGMENT_USAGE:
				return convertPlacementFragmentUsageToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVLModel createCVLModel() {
		CVLModelImpl cvlModel = new CVLModelImpl();
		return cvlModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceSubstitution createReferenceSubstitution() {
		ReferenceSubstitutionImpl referenceSubstitution = new ReferenceSubstitutionImpl();
		return referenceSubstitution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSubstitution createValueSubstitution() {
		ValueSubstitutionImpl valueSubstitution = new ValueSubstitutionImpl();
		return valueSubstitution;
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
	public ReplacementFragment createReplacementFragment() {
		ReplacementFragmentImpl replacementFragment = new ReplacementFragmentImpl();
		return replacementFragment;
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
	public FromReplacement createFromReplacement() {
		FromReplacementImpl fromReplacement = new FromReplacementImpl();
		return fromReplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVLElement createCVLElement() {
		CVLElementImpl cvlElement = new CVLElementImpl();
		return cvlElement;
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
	public FromBinding createFromBinding() {
		FromBindingImpl fromBinding = new FromBindingImpl();
		return fromBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeVariability createCompositeVariability() {
		CompositeVariabilityImpl compositeVariability = new CompositeVariabilityImpl();
		return compositeVariability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacementValue createPlacementValue() {
		PlacementValueImpl placementValue = new PlacementValueImpl();
		return placementValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacementObject createPlacementObject() {
		PlacementObjectImpl placementObject = new PlacementObjectImpl();
		return placementObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementValue createReplacementValue() {
		ReplacementValueImpl replacementValue = new ReplacementValueImpl();
		return replacementValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementObject createReplacementObject() {
		ReplacementObjectImpl replacementObject = new ReplacementObjectImpl();
		return replacementObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolutionElement createResolutionElement() {
		ResolutionElementImpl resolutionElement = new ResolutionElementImpl();
		return resolutionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createType() {
		TypeImpl type = new TypeImpl();
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invocation createInvocation() {
		InvocationImpl invocation = new InvocationImpl();
		return invocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IteratorResolution createIteratorResolution() {
		IteratorResolutionImpl iteratorResolution = new IteratorResolutionImpl();
		return iteratorResolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterator createIterator() {
		IteratorImpl iterator = new IteratorImpl();
		return iterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentReference createReplacementFragmentReference() {
		ReplacementFragmentReferenceImpl replacementFragmentReference = new ReplacementFragmentReferenceImpl();
		return replacementFragmentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
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
	public NOT createNOT() {
		NOTImpl not = new NOTImpl();
		return not;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OR createOR() {
		ORImpl or = new ORImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMPLIES createIMPLIES() {
		IMPLIESImpl implies = new IMPLIESImpl();
		return implies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutablePrimitiveTerm createExecutablePrimitiveTerm() {
		ExecutablePrimitiveTermImpl executablePrimitiveTerm = new ExecutablePrimitiveTermImpl();
		return executablePrimitiveTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AND_ createAND_() {
		AND_Impl anD_ = new AND_Impl();
		return anD_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolutionValue createResolutionValue() {
		ResolutionValueImpl resolutionValue = new ResolutionValueImpl();
		return resolutionValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacementFragmentUsage createPlacementFragmentUsageFromString(EDataType eDataType, String initialValue) {
		PlacementFragmentUsage result = PlacementFragmentUsage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPlacementFragmentUsageToString(EDataType eDataType, Object instanceValue) {
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
