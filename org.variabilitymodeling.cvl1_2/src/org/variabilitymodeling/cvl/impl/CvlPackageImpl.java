/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.impl;




import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.variabilitymodeling.cvl.Assignment;
import org.variabilitymodeling.cvl.Binary;
import org.variabilitymodeling.cvl.BoundaryElementBinding;
import org.variabilitymodeling.cvl.CVLElement;
import org.variabilitymodeling.cvl.CVLModel;
import org.variabilitymodeling.cvl.CVLNamedElement;
import org.variabilitymodeling.cvl.CompositeResolution;
import org.variabilitymodeling.cvl.CompositeVariability;
import org.variabilitymodeling.cvl.Constraint;
import org.variabilitymodeling.cvl.CvlFactory;
import org.variabilitymodeling.cvl.CvlPackage;
import org.variabilitymodeling.cvl.Declaration;
import org.variabilitymodeling.cvl.ExecutablePrimitive;
import org.variabilitymodeling.cvl.ExecutablePrimitiveTerm;
import org.variabilitymodeling.cvl.FragmentSubstitution;
import org.variabilitymodeling.cvl.FromBinding;
import org.variabilitymodeling.cvl.FromPlacement;
import org.variabilitymodeling.cvl.FromReplacement;
import org.variabilitymodeling.cvl.Invocation;
import org.variabilitymodeling.cvl.Iterator;
import org.variabilitymodeling.cvl.IteratorResolution;
import org.variabilitymodeling.cvl.PlacementBoundaryElement;
import org.variabilitymodeling.cvl.PlacementFragment;
import org.variabilitymodeling.cvl.PlacementFragmentUsage;
import org.variabilitymodeling.cvl.PlacementLiteral;
import org.variabilitymodeling.cvl.PlacementObject;
import org.variabilitymodeling.cvl.PlacementValue;
import org.variabilitymodeling.cvl.ReferenceSubstitution;
import org.variabilitymodeling.cvl.ReplacementBoundaryElement;
import org.variabilitymodeling.cvl.ReplacementFragment;
import org.variabilitymodeling.cvl.ReplacementFragmentAbstract;
import org.variabilitymodeling.cvl.ReplacementFragmentBinding;
import org.variabilitymodeling.cvl.ReplacementFragmentReference;
import org.variabilitymodeling.cvl.ReplacementLiteral;
import org.variabilitymodeling.cvl.ReplacementObject;
import org.variabilitymodeling.cvl.ReplacementValue;
import org.variabilitymodeling.cvl.ResolutionElement;
import org.variabilitymodeling.cvl.ResolutionSpecification;
import org.variabilitymodeling.cvl.ResolutionValue;
import org.variabilitymodeling.cvl.Substitution;
import org.variabilitymodeling.cvl.ToBinding;
import org.variabilitymodeling.cvl.ToPlacement;
import org.variabilitymodeling.cvl.ToReplacement;
import org.variabilitymodeling.cvl.Type;
import org.variabilitymodeling.cvl.ValueSubstitution;
import org.variabilitymodeling.cvl.VariabilitySpecification;
import org.variabilitymodeling.cvl.visitors.VisitorsPackage;
import org.variabilitymodeling.cvl.visitors.impl.VisitorsPackageImpl;

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
	private EClass cvlModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass substitutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceSubstitutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueSubstitutionEClass = null;

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
	private EClass placementFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replacementFragmentEClass = null;

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
	private EClass replacementBoundaryElementEClass = null;

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
	private EClass fromReplacementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvlElementEClass = null;

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
	private EClass toBindingEClass = null;

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
	private EClass compositeVariabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variabilitySpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvlNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placementLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replacementLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placementValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placementObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replacementValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replacementObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolutionSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolutionElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iteratorResolutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iteratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replacementFragmentReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replacementFragmentAbstractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executablePrimitiveEClass = null;

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
	private EClass notEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass impliesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executablePrimitiveTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anD_EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolutionValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum placementFragmentUsageEEnum = null;

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
	 * @see org.variabilitymodeling.cvl.CvlPackage#eNS_URI
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

		// Obtain or create and register interdependencies
		VisitorsPackageImpl theVisitorsPackage = (VisitorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VisitorsPackage.eNS_URI) instanceof VisitorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VisitorsPackage.eNS_URI) : VisitorsPackage.eINSTANCE);

		// Create package meta-data objects
		theCvlPackage.createPackageContents();
		theVisitorsPackage.createPackageContents();

		// Initialize created meta-data
		theCvlPackage.initializePackageContents();
		theVisitorsPackage.initializePackageContents();

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
	public EClass getCVLModel() {
		return cvlModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCVLModel_VariabilitySpecification() {
		return (EReference)cvlModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCVLModel_ResolutionSpecification() {
		return (EReference)cvlModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCVLModel_Base() {
		return (EReference)cvlModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubstitution() {
		return substitutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubstitution_ReplacementInstance() {
		return (EReference)substitutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceSubstitution() {
		return referenceSubstitutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceSubstitution_Placement() {
		return (EReference)referenceSubstitutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceSubstitution_Replacement() {
		return (EReference)referenceSubstitutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueSubstitution() {
		return valueSubstitutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueSubstitution_Placement() {
		return (EReference)valueSubstitutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueSubstitution_Replacement() {
		return (EReference)valueSubstitutionEClass.getEStructuralFeatures().get(1);
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
	public EReference getFragmentSubstitution_Placement() {
		return (EReference)fragmentSubstitutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentSubstitution_Replacement() {
		return (EReference)fragmentSubstitutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentSubstitution_RfRef() {
		return (EReference)fragmentSubstitutionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentSubstitution_BoundaryElementBinding() {
		return (EReference)fragmentSubstitutionEClass.getEStructuralFeatures().get(3);
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
	public EReference getPlacementFragment_BoundaryElement() {
		return (EReference)placementFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlacementFragment_Usage() {
		return (EAttribute)placementFragmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplacementFragment() {
		return replacementFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReplacementFragment_BoundaryElement() {
		return (EReference)replacementFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReplacementFragment_Placements() {
		return (EReference)replacementFragmentEClass.getEStructuralFeatures().get(1);
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
	public EClass getReplacementBoundaryElement() {
		return replacementBoundaryElementEClass;
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
	public EReference getFromPlacement_OutsideBoundaryElement() {
		return (EReference)fromPlacementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromPlacement_ReplacementBoundaryElement() {
		return (EReference)fromPlacementEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getToPlacement_PropertyName() {
		return (EAttribute)toPlacementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToPlacement_InsideBoundaryElement() {
		return (EReference)toPlacementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToPlacement_OutsideBoundaryElement() {
		return (EReference)toPlacementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToPlacement_OutsideRef() {
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
	public EReference getToReplacement_PlacementBoundaryElement() {
		return (EReference)toReplacementEClass.getEStructuralFeatures().get(1);
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
	public EReference getFromReplacement_OutsideBoundaryElement() {
		return (EReference)fromReplacementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromReplacement_InsideBoundaryElement() {
		return (EReference)fromReplacementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromReplacement_InsideRef() {
		return (EReference)fromReplacementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVLElement() {
		return cvlElementEClass;
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
	public EClass getCompositeVariability() {
		return compositeVariabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeVariability_VariabilitySpecification() {
		return (EReference)compositeVariabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariabilitySpecification() {
		return variabilitySpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVLNamedElement() {
		return cvlNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVLNamedElement_Name() {
		return (EAttribute)cvlNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlacementLiteral() {
		return placementLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplacementLiteral() {
		return replacementLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlacementValue() {
		return placementValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlacementValue_PropertyName() {
		return (EAttribute)placementValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlacementValue_TargetObject() {
		return (EReference)placementValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlacementObject() {
		return placementObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlacementObject_PropertyName() {
		return (EAttribute)placementObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlacementObject_TargetObject() {
		return (EReference)placementObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlacementObject_ReferredObject() {
		return (EReference)placementObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplacementValue() {
		return replacementValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReplacementValue_Value() {
		return (EAttribute)replacementValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplacementObject() {
		return replacementObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReplacementObject_TargetObject() {
		return (EReference)replacementObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolutionSpecification() {
		return resolutionSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolutionElement() {
		return resolutionElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolutionElement_Element() {
		return (EReference)resolutionElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolutionElement_Resolution() {
		return (EReference)resolutionElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getType_Body() {
		return (EReference)typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getType_Replacement() {
		return (EReference)typeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvocation() {
		return invocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvocation_Type() {
		return (EReference)invocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvocation_ResolutionSpecification() {
		return (EReference)invocationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvocation_RfRef() {
		return (EReference)invocationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIteratorResolution() {
		return iteratorResolutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIteratorResolution_Iterator() {
		return (EReference)iteratorResolutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIteratorResolution_Choice() {
		return (EReference)iteratorResolutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterator() {
		return iteratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterator_UpperLimit() {
		return (EAttribute)iteratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterator_LowerLimit() {
		return (EAttribute)iteratorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterator_IsUnique() {
		return (EAttribute)iteratorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplacementFragmentReference() {
		return replacementFragmentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReplacementFragmentReference_RfRef() {
		return (EReference)replacementFragmentReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplacementFragmentAbstract() {
		return replacementFragmentAbstractEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignment() {
		return assignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_Value() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_Target() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclaration() {
		return declarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutablePrimitive() {
		return executablePrimitiveEClass;
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
	public EClass getNOT() {
		return notEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNOT_Term() {
		return (EReference)notEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOR() {
		return orEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIMPLIES() {
		return impliesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutablePrimitiveTerm() {
		return executablePrimitiveTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutablePrimitiveTerm_Primitive() {
		return (EReference)executablePrimitiveTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAND_() {
		return anD_EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinary() {
		return binaryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinary_Left() {
		return (EReference)binaryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinary_Right() {
		return (EReference)binaryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolutionValue() {
		return resolutionValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolutionValue_Value() {
		return (EAttribute)resolutionValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPlacementFragmentUsage() {
		return placementFragmentUsageEEnum;
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
		cvlModelEClass = createEClass(CVL_MODEL);
		createEReference(cvlModelEClass, CVL_MODEL__VARIABILITY_SPECIFICATION);
		createEReference(cvlModelEClass, CVL_MODEL__RESOLUTION_SPECIFICATION);
		createEReference(cvlModelEClass, CVL_MODEL__BASE);

		substitutionEClass = createEClass(SUBSTITUTION);
		createEReference(substitutionEClass, SUBSTITUTION__REPLACEMENT_INSTANCE);

		referenceSubstitutionEClass = createEClass(REFERENCE_SUBSTITUTION);
		createEReference(referenceSubstitutionEClass, REFERENCE_SUBSTITUTION__PLACEMENT);
		createEReference(referenceSubstitutionEClass, REFERENCE_SUBSTITUTION__REPLACEMENT);

		valueSubstitutionEClass = createEClass(VALUE_SUBSTITUTION);
		createEReference(valueSubstitutionEClass, VALUE_SUBSTITUTION__PLACEMENT);
		createEReference(valueSubstitutionEClass, VALUE_SUBSTITUTION__REPLACEMENT);

		fragmentSubstitutionEClass = createEClass(FRAGMENT_SUBSTITUTION);
		createEReference(fragmentSubstitutionEClass, FRAGMENT_SUBSTITUTION__PLACEMENT);
		createEReference(fragmentSubstitutionEClass, FRAGMENT_SUBSTITUTION__REPLACEMENT);
		createEReference(fragmentSubstitutionEClass, FRAGMENT_SUBSTITUTION__RF_REF);
		createEReference(fragmentSubstitutionEClass, FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING);

		placementFragmentEClass = createEClass(PLACEMENT_FRAGMENT);
		createEReference(placementFragmentEClass, PLACEMENT_FRAGMENT__BOUNDARY_ELEMENT);
		createEAttribute(placementFragmentEClass, PLACEMENT_FRAGMENT__USAGE);

		replacementFragmentEClass = createEClass(REPLACEMENT_FRAGMENT);
		createEReference(replacementFragmentEClass, REPLACEMENT_FRAGMENT__BOUNDARY_ELEMENT);
		createEReference(replacementFragmentEClass, REPLACEMENT_FRAGMENT__PLACEMENTS);

		placementBoundaryElementEClass = createEClass(PLACEMENT_BOUNDARY_ELEMENT);

		replacementBoundaryElementEClass = createEClass(REPLACEMENT_BOUNDARY_ELEMENT);

		fromPlacementEClass = createEClass(FROM_PLACEMENT);
		createEReference(fromPlacementEClass, FROM_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT);
		createEReference(fromPlacementEClass, FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT);

		toPlacementEClass = createEClass(TO_PLACEMENT);
		createEAttribute(toPlacementEClass, TO_PLACEMENT__PROPERTY_NAME);
		createEReference(toPlacementEClass, TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT);
		createEReference(toPlacementEClass, TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT);
		createEReference(toPlacementEClass, TO_PLACEMENT__OUTSIDE_REF);

		toReplacementEClass = createEClass(TO_REPLACEMENT);
		createEReference(toReplacementEClass, TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT);
		createEReference(toReplacementEClass, TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT);

		fromReplacementEClass = createEClass(FROM_REPLACEMENT);
		createEAttribute(fromReplacementEClass, FROM_REPLACEMENT__PROPERTY_NAME);
		createEReference(fromReplacementEClass, FROM_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT);
		createEReference(fromReplacementEClass, FROM_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT);
		createEReference(fromReplacementEClass, FROM_REPLACEMENT__INSIDE_REF);

		cvlElementEClass = createEClass(CVL_ELEMENT);

		boundaryElementBindingEClass = createEClass(BOUNDARY_ELEMENT_BINDING);

		toBindingEClass = createEClass(TO_BINDING);
		createEReference(toBindingEClass, TO_BINDING__TO_PLACEMENT);
		createEReference(toBindingEClass, TO_BINDING__TO_REPLACEMENT);

		fromBindingEClass = createEClass(FROM_BINDING);
		createEReference(fromBindingEClass, FROM_BINDING__FROM_PLACEMENT);
		createEReference(fromBindingEClass, FROM_BINDING__FROM_REPLACEMENT);

		compositeVariabilityEClass = createEClass(COMPOSITE_VARIABILITY);
		createEReference(compositeVariabilityEClass, COMPOSITE_VARIABILITY__VARIABILITY_SPECIFICATION);

		variabilitySpecificationEClass = createEClass(VARIABILITY_SPECIFICATION);

		cvlNamedElementEClass = createEClass(CVL_NAMED_ELEMENT);
		createEAttribute(cvlNamedElementEClass, CVL_NAMED_ELEMENT__NAME);

		placementLiteralEClass = createEClass(PLACEMENT_LITERAL);

		replacementLiteralEClass = createEClass(REPLACEMENT_LITERAL);

		placementValueEClass = createEClass(PLACEMENT_VALUE);
		createEAttribute(placementValueEClass, PLACEMENT_VALUE__PROPERTY_NAME);
		createEReference(placementValueEClass, PLACEMENT_VALUE__TARGET_OBJECT);

		placementObjectEClass = createEClass(PLACEMENT_OBJECT);
		createEAttribute(placementObjectEClass, PLACEMENT_OBJECT__PROPERTY_NAME);
		createEReference(placementObjectEClass, PLACEMENT_OBJECT__TARGET_OBJECT);
		createEReference(placementObjectEClass, PLACEMENT_OBJECT__REFERRED_OBJECT);

		replacementValueEClass = createEClass(REPLACEMENT_VALUE);
		createEAttribute(replacementValueEClass, REPLACEMENT_VALUE__VALUE);

		replacementObjectEClass = createEClass(REPLACEMENT_OBJECT);
		createEReference(replacementObjectEClass, REPLACEMENT_OBJECT__TARGET_OBJECT);

		resolutionSpecificationEClass = createEClass(RESOLUTION_SPECIFICATION);

		resolutionElementEClass = createEClass(RESOLUTION_ELEMENT);
		createEReference(resolutionElementEClass, RESOLUTION_ELEMENT__ELEMENT);
		createEReference(resolutionElementEClass, RESOLUTION_ELEMENT__RESOLUTION);

		typeEClass = createEClass(TYPE);
		createEReference(typeEClass, TYPE__BODY);
		createEReference(typeEClass, TYPE__REPLACEMENT);

		invocationEClass = createEClass(INVOCATION);
		createEReference(invocationEClass, INVOCATION__TYPE);
		createEReference(invocationEClass, INVOCATION__RESOLUTION_SPECIFICATION);
		createEReference(invocationEClass, INVOCATION__RF_REF);

		iteratorResolutionEClass = createEClass(ITERATOR_RESOLUTION);
		createEReference(iteratorResolutionEClass, ITERATOR_RESOLUTION__ITERATOR);
		createEReference(iteratorResolutionEClass, ITERATOR_RESOLUTION__CHOICE);

		iteratorEClass = createEClass(ITERATOR);
		createEAttribute(iteratorEClass, ITERATOR__UPPER_LIMIT);
		createEAttribute(iteratorEClass, ITERATOR__LOWER_LIMIT);
		createEAttribute(iteratorEClass, ITERATOR__IS_UNIQUE);

		replacementFragmentReferenceEClass = createEClass(REPLACEMENT_FRAGMENT_REFERENCE);
		createEReference(replacementFragmentReferenceEClass, REPLACEMENT_FRAGMENT_REFERENCE__RF_REF);

		replacementFragmentAbstractEClass = createEClass(REPLACEMENT_FRAGMENT_ABSTRACT);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEReference(assignmentEClass, ASSIGNMENT__VALUE);
		createEReference(assignmentEClass, ASSIGNMENT__TARGET);

		declarationEClass = createEClass(DECLARATION);

		executablePrimitiveEClass = createEClass(EXECUTABLE_PRIMITIVE);

		constraintEClass = createEClass(CONSTRAINT);

		notEClass = createEClass(NOT);
		createEReference(notEClass, NOT__TERM);

		orEClass = createEClass(OR);

		impliesEClass = createEClass(IMPLIES);

		executablePrimitiveTermEClass = createEClass(EXECUTABLE_PRIMITIVE_TERM);
		createEReference(executablePrimitiveTermEClass, EXECUTABLE_PRIMITIVE_TERM__PRIMITIVE);

		anD_EClass = createEClass(AND_);

		binaryEClass = createEClass(BINARY);
		createEReference(binaryEClass, BINARY__LEFT);
		createEReference(binaryEClass, BINARY__RIGHT);

		resolutionValueEClass = createEClass(RESOLUTION_VALUE);
		createEAttribute(resolutionValueEClass, RESOLUTION_VALUE__VALUE);

		// Create enums
		placementFragmentUsageEEnum = createEEnum(PLACEMENT_FRAGMENT_USAGE);
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

		// Obtain other dependent packages
		VisitorsPackage theVisitorsPackage = (VisitorsPackage)EPackage.Registry.INSTANCE.getEPackage(VisitorsPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theVisitorsPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cvlModelEClass.getESuperTypes().add(this.getCVLNamedElement());
		substitutionEClass.getESuperTypes().add(this.getExecutablePrimitive());
		referenceSubstitutionEClass.getESuperTypes().add(this.getSubstitution());
		valueSubstitutionEClass.getESuperTypes().add(this.getSubstitution());
		fragmentSubstitutionEClass.getESuperTypes().add(this.getSubstitution());
		placementFragmentEClass.getESuperTypes().add(this.getCVLNamedElement());
		placementFragmentEClass.getESuperTypes().add(this.getPlacementLiteral());
		replacementFragmentEClass.getESuperTypes().add(this.getCVLNamedElement());
		replacementFragmentEClass.getESuperTypes().add(this.getReplacementFragmentAbstract());
		placementBoundaryElementEClass.getESuperTypes().add(this.getCVLNamedElement());
		replacementBoundaryElementEClass.getESuperTypes().add(this.getCVLNamedElement());
		fromPlacementEClass.getESuperTypes().add(this.getPlacementBoundaryElement());
		toPlacementEClass.getESuperTypes().add(this.getPlacementBoundaryElement());
		toReplacementEClass.getESuperTypes().add(this.getReplacementBoundaryElement());
		fromReplacementEClass.getESuperTypes().add(this.getReplacementBoundaryElement());
		cvlElementEClass.getESuperTypes().add(theVisitorsPackage.getVisitable());
		boundaryElementBindingEClass.getESuperTypes().add(this.getCVLNamedElement());
		toBindingEClass.getESuperTypes().add(this.getBoundaryElementBinding());
		fromBindingEClass.getESuperTypes().add(this.getBoundaryElementBinding());
		compositeVariabilityEClass.getESuperTypes().add(this.getExecutablePrimitive());
		variabilitySpecificationEClass.getESuperTypes().add(this.getCVLNamedElement());
		cvlNamedElementEClass.getESuperTypes().add(this.getCVLElement());
		placementLiteralEClass.getESuperTypes().add(this.getDeclaration());
		replacementLiteralEClass.getESuperTypes().add(this.getDeclaration());
		placementValueEClass.getESuperTypes().add(this.getPlacementLiteral());
		placementObjectEClass.getESuperTypes().add(this.getPlacementLiteral());
		replacementValueEClass.getESuperTypes().add(this.getReplacementLiteral());
		replacementObjectEClass.getESuperTypes().add(this.getReplacementLiteral());
		resolutionSpecificationEClass.getESuperTypes().add(this.getCVLNamedElement());
		resolutionElementEClass.getESuperTypes().add(this.getResolutionSpecification());
		typeEClass.getESuperTypes().add(this.getDeclaration());
		invocationEClass.getESuperTypes().add(this.getExecutablePrimitive());
		iteratorResolutionEClass.getESuperTypes().add(this.getResolutionSpecification());
		iteratorEClass.getESuperTypes().add(this.getCompositeVariability());
		replacementFragmentReferenceEClass.getESuperTypes().add(this.getReplacementFragmentAbstract());
		replacementFragmentAbstractEClass.getESuperTypes().add(this.getReplacementLiteral());
		assignmentEClass.getESuperTypes().add(this.getExecutablePrimitive());
		declarationEClass.getESuperTypes().add(this.getVariabilitySpecification());
		executablePrimitiveEClass.getESuperTypes().add(this.getVariabilitySpecification());
		constraintEClass.getESuperTypes().add(this.getDeclaration());
		notEClass.getESuperTypes().add(this.getConstraint());
		orEClass.getESuperTypes().add(this.getBinary());
		impliesEClass.getESuperTypes().add(this.getBinary());
		executablePrimitiveTermEClass.getESuperTypes().add(this.getConstraint());
		anD_EClass.getESuperTypes().add(this.getBinary());
		binaryEClass.getESuperTypes().add(this.getConstraint());
		resolutionValueEClass.getESuperTypes().add(this.getResolutionElement());

		// Initialize classes and features; add operations and parameters
		initEClass(cvlModelEClass, CVLModel.class, "CVLModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCVLModel_VariabilitySpecification(), this.getVariabilitySpecification(), null, "variabilitySpecification", null, 0, 1, CVLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCVLModel_ResolutionSpecification(), this.getResolutionSpecification(), null, "resolutionSpecification", null, 0, -1, CVLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCVLModel_Base(), ecorePackage.getEObject(), null, "base", null, 0, 1, CVLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(cvlModelEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "C");
		ETypeParameter t2 = addETypeParameter(op, "R");
		EGenericType g1 = createEGenericType(theVisitorsPackage.getVisitor());
		EGenericType g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(substitutionEClass, Substitution.class, "Substitution", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubstitution_ReplacementInstance(), this.getReplacementFragmentReference(), null, "replacementInstance", null, 0, 1, Substitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceSubstitutionEClass, ReferenceSubstitution.class, "ReferenceSubstitution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceSubstitution_Placement(), this.getPlacementObject(), null, "placement", null, 1, 1, ReferenceSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceSubstitution_Replacement(), this.getReplacementObject(), null, "replacement", null, 1, 1, ReferenceSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(referenceSubstitutionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(valueSubstitutionEClass, ValueSubstitution.class, "ValueSubstitution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValueSubstitution_Placement(), this.getPlacementValue(), null, "placement", null, 1, 1, ValueSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValueSubstitution_Replacement(), this.getReplacementValue(), null, "replacement", null, 1, 1, ValueSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(valueSubstitutionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(fragmentSubstitutionEClass, FragmentSubstitution.class, "FragmentSubstitution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFragmentSubstitution_Placement(), this.getPlacementFragment(), null, "placement", null, 1, 1, FragmentSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFragmentSubstitution_Replacement(), this.getReplacementFragmentAbstract(), null, "replacement", null, 1, 1, FragmentSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFragmentSubstitution_RfRef(), this.getReplacementFragmentReference(), null, "rfRef", null, 0, 1, FragmentSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFragmentSubstitution_BoundaryElementBinding(), this.getBoundaryElementBinding(), null, "boundaryElementBinding", null, 0, -1, FragmentSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(fragmentSubstitutionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(placementFragmentEClass, PlacementFragment.class, "PlacementFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlacementFragment_BoundaryElement(), this.getPlacementBoundaryElement(), null, "boundaryElement", null, 0, -1, PlacementFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlacementFragment_Usage(), this.getPlacementFragmentUsage(), "usage", null, 0, 1, PlacementFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(placementFragmentEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(replacementFragmentEClass, ReplacementFragment.class, "ReplacementFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReplacementFragment_BoundaryElement(), this.getReplacementBoundaryElement(), null, "boundaryElement", null, 0, -1, ReplacementFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReplacementFragment_Placements(), this.getPlacementLiteral(), null, "placements", null, 0, -1, ReplacementFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(replacementFragmentEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(placementBoundaryElementEClass, PlacementBoundaryElement.class, "PlacementBoundaryElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(replacementBoundaryElementEClass, ReplacementBoundaryElement.class, "ReplacementBoundaryElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fromPlacementEClass, FromPlacement.class, "FromPlacement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFromPlacement_OutsideBoundaryElement(), ecorePackage.getEObject(), null, "outsideBoundaryElement", null, 0, -1, FromPlacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFromPlacement_ReplacementBoundaryElement(), this.getFromReplacement(), this.getFromReplacement_InsideRef(), "replacementBoundaryElement", null, 0, 1, FromPlacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(fromPlacementEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(toPlacementEClass, ToPlacement.class, "ToPlacement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getToPlacement_PropertyName(), ecorePackage.getEString(), "propertyName", null, 0, 1, ToPlacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getToPlacement_InsideBoundaryElement(), ecorePackage.getEObject(), null, "insideBoundaryElement", null, 0, -1, ToPlacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getToPlacement_OutsideBoundaryElement(), ecorePackage.getEObject(), null, "outsideBoundaryElement", null, 0, 1, ToPlacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getToPlacement_OutsideRef(), this.getToReplacement(), this.getToReplacement_PlacementBoundaryElement(), "outsideRef", null, 0, 1, ToPlacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(toPlacementEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(toReplacementEClass, ToReplacement.class, "ToReplacement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getToReplacement_InsideBoundaryElement(), ecorePackage.getEObject(), null, "insideBoundaryElement", null, 0, -1, ToReplacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getToReplacement_PlacementBoundaryElement(), this.getToPlacement(), this.getToPlacement_OutsideRef(), "placementBoundaryElement", null, 0, 1, ToReplacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(toReplacementEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(fromReplacementEClass, FromReplacement.class, "FromReplacement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFromReplacement_PropertyName(), ecorePackage.getEString(), "propertyName", null, 0, 1, FromReplacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFromReplacement_OutsideBoundaryElement(), ecorePackage.getEObject(), null, "outsideBoundaryElement", null, 0, -1, FromReplacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFromReplacement_InsideBoundaryElement(), ecorePackage.getEObject(), null, "insideBoundaryElement", null, 0, 1, FromReplacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFromReplacement_InsideRef(), this.getFromPlacement(), this.getFromPlacement_ReplacementBoundaryElement(), "insideRef", null, 0, 1, FromReplacement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(fromReplacementEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(cvlElementEClass, CVLElement.class, "CVLElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(cvlElementEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(boundaryElementBindingEClass, BoundaryElementBinding.class, "BoundaryElementBinding", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(toBindingEClass, ToBinding.class, "ToBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getToBinding_ToPlacement(), this.getToPlacement(), null, "toPlacement", null, 1, 1, ToBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getToBinding_ToReplacement(), this.getToReplacement(), null, "toReplacement", null, 1, 1, ToBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(toBindingEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(fromBindingEClass, FromBinding.class, "FromBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFromBinding_FromPlacement(), this.getFromPlacement(), null, "fromPlacement", null, 1, 1, FromBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFromBinding_FromReplacement(), this.getFromReplacement(), null, "fromReplacement", null, 1, 1, FromBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(fromBindingEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(compositeVariabilityEClass, CompositeVariability.class, "CompositeVariability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeVariability_VariabilitySpecification(), this.getVariabilitySpecification(), null, "variabilitySpecification", null, 0, -1, CompositeVariability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(compositeVariabilityEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(variabilitySpecificationEClass, VariabilitySpecification.class, "VariabilitySpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvlNamedElementEClass, CVLNamedElement.class, "CVLNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCVLNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, CVLNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(placementLiteralEClass, PlacementLiteral.class, "PlacementLiteral", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(replacementLiteralEClass, ReplacementLiteral.class, "ReplacementLiteral", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(placementValueEClass, PlacementValue.class, "PlacementValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlacementValue_PropertyName(), ecorePackage.getEString(), "propertyName", null, 0, 1, PlacementValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlacementValue_TargetObject(), ecorePackage.getEObject(), null, "targetObject", null, 0, 1, PlacementValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(placementValueEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(placementObjectEClass, PlacementObject.class, "PlacementObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlacementObject_PropertyName(), ecorePackage.getEString(), "propertyName", null, 0, 1, PlacementObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlacementObject_TargetObject(), ecorePackage.getEObject(), null, "targetObject", null, 0, 1, PlacementObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlacementObject_ReferredObject(), ecorePackage.getEObject(), null, "referredObject", null, 0, 1, PlacementObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(placementObjectEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(replacementValueEClass, ReplacementValue.class, "ReplacementValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReplacementValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, ReplacementValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(replacementValueEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(replacementObjectEClass, ReplacementObject.class, "ReplacementObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReplacementObject_TargetObject(), ecorePackage.getEObject(), null, "targetObject", null, 0, 1, ReplacementObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(replacementObjectEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(resolutionSpecificationEClass, ResolutionSpecification.class, "ResolutionSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resolutionElementEClass, ResolutionElement.class, "ResolutionElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResolutionElement_Element(), this.getExecutablePrimitive(), null, "element", null, 1, 1, ResolutionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResolutionElement_Resolution(), this.getIteratorResolution(), null, "resolution", null, 0, -1, ResolutionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(resolutionElementEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getType_Body(), this.getCompositeVariability(), null, "body", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getType_Replacement(), this.getReplacementFragment(), null, "replacement", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(typeEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(invocationEClass, Invocation.class, "Invocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInvocation_Type(), this.getType(), null, "type", null, 1, 1, Invocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInvocation_ResolutionSpecification(), this.getResolutionSpecification(), null, "resolutionSpecification", null, 0, 1, Invocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInvocation_RfRef(), this.getReplacementFragmentReference(), null, "rfRef", null, 1, 1, Invocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(invocationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(iteratorResolutionEClass, IteratorResolution.class, "IteratorResolution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIteratorResolution_Iterator(), this.getIterator(), null, "iterator", null, 1, 1, IteratorResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIteratorResolution_Choice(), this.getResolutionElement(), null, "choice", null, 0, -1, IteratorResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(iteratorResolutionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(iteratorEClass, Iterator.class, "Iterator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIterator_UpperLimit(), ecorePackage.getEInt(), "upperLimit", null, 0, 1, Iterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterator_LowerLimit(), ecorePackage.getEInt(), "lowerLimit", null, 0, 1, Iterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterator_IsUnique(), ecorePackage.getEBoolean(), "isUnique", null, 0, 1, Iterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(iteratorEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(replacementFragmentReferenceEClass, ReplacementFragmentReference.class, "ReplacementFragmentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReplacementFragmentReference_RfRef(), this.getReplacementFragment(), null, "rfRef", null, 1, 1, ReplacementFragmentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(replacementFragmentReferenceEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(replacementFragmentAbstractEClass, ReplacementFragmentAbstract.class, "ReplacementFragmentAbstract", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignment_Value(), this.getReplacementFragmentAbstract(), null, "value", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignment_Target(), this.getReplacementFragmentReference(), null, "target", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(assignmentEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(declarationEClass, Declaration.class, "Declaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(executablePrimitiveEClass, ExecutablePrimitive.class, "ExecutablePrimitive", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(constraintEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(notEClass, org.variabilitymodeling.cvl.NOT.class, "NOT", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNOT_Term(), this.getConstraint(), null, "term", null, 1, 1, org.variabilitymodeling.cvl.NOT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(notEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(orEClass, org.variabilitymodeling.cvl.OR.class, "OR", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(orEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(impliesEClass, org.variabilitymodeling.cvl.IMPLIES.class, "IMPLIES", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(impliesEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(executablePrimitiveTermEClass, ExecutablePrimitiveTerm.class, "ExecutablePrimitiveTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutablePrimitiveTerm_Primitive(), this.getExecutablePrimitive(), null, "primitive", null, 1, 1, ExecutablePrimitiveTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(executablePrimitiveTermEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(anD_EClass, org.variabilitymodeling.cvl.AND_.class, "AND_", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(anD_EClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(binaryEClass, Binary.class, "Binary", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinary_Left(), this.getConstraint(), null, "left", null, 1, 1, Binary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinary_Right(), this.getConstraint(), null, "right", null, 1, 1, Binary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resolutionValueEClass, ResolutionValue.class, "ResolutionValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResolutionValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, ResolutionValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(resolutionValueEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "C");
		t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(theVisitorsPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		// Initialize enums and add enum literals
		initEEnum(placementFragmentUsageEEnum, PlacementFragmentUsage.class, "PlacementFragmentUsage");
		addEEnumLiteral(placementFragmentUsageEEnum, PlacementFragmentUsage.REPLACE);
		addEEnumLiteral(placementFragmentUsageEEnum, PlacementFragmentUsage.ADD);
		addEEnumLiteral(placementFragmentUsageEEnum, PlacementFragmentUsage.ADD_REPLACE);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// doc
		createDocAnnotations();
		// kermeta
		createKermetaAnnotations();
	}

	/**
	 * Initializes the annotations for <b>doc</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDocAnnotations() {
		String source = "doc";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "description", "The following is a full normative description of each meta-classes."
		   });		
		addAnnotation
		  (cvlModelEClass, 
		   source, 
		   new String[] {
			 "description", "A CVL model is the root of the repository that describes the variabilities and resolutions relative to a specific base model.",
			 "semantics", "CVL models are executed and the appropriate base model is copied and transformed according to the semantic rules. See BaseModel to get a definition of what portion of the base model to start with.\r\n\r\nA CVL Model assumes that model elements are connected by one-way references (see ModelElement).\r\nThe CVL execution will copy a portion of the base model as the starting point of the execution. The portion that is copied is the base model tree defined by the following:\r\n1. CVLModel.base points out a model element, say me\r\n2. From me follow container reference as far as it goes. This model element defines the root of the tree that will define the base model to be copied."
		   });				
		addAnnotation
		  (getCVLModel_VariabilitySpecification(), 
		   source, 
		   new String[] {
			 "description", "CVL Model contains a Variability Specification."
		   });		
		addAnnotation
		  (getCVLModel_ResolutionSpecification(), 
		   source, 
		   new String[] {
			 "description", "CVL Model contains a number of Resolution Specifications."
		   });		
		addAnnotation
		  (getCVLModel_Base(), 
		   source, 
		   new String[] {
			 "description", "The base pointer provides a link to the base model."
		   });		
		addAnnotation
		  (substitutionEClass, 
		   source, 
		   new String[] {
			 "description", "Substitution is the general notion of variability specifications that specify a substitution to be done on the copy of the base model.",
			 "semantics", "If replacementInstance is specified, the placement from this instance will be used. Further semantics of the substitution is given by its specializations."
		   });		
		addAnnotation
		  (getSubstitution_ReplacementInstance(), 
		   source, 
		   new String[] {
			 "description", "Points to the ReplacementFragmentReference, which stores a given instance of a replacement fragment to be used in the substitution."
		   });		
		addAnnotation
		  (referenceSubstitutionEClass, 
		   source, 
		   new String[] {
			 "description", "The Reference Substitution defines a substitution that will change a reference attribute in the base model.",
			 "semantics", "The semantics of a reference substitution rs is:\r\n\r\nATTR(rs.placement.propertyName, vs.placement.targetObject) = rs.replacement.targetObject\r\n\r\nwhere ATTR is a reflective operation that, given a string and a reference to a model element, returns a reference (L-value) to the attribute (of the model element) with name given by the string."
		   });				
		addAnnotation
		  (getReferenceSubstitution_Placement(), 
		   source, 
		   new String[] {
			 "description", "Specifies the reference to be changed."
		   });		
		addAnnotation
		  (getReferenceSubstitution_Replacement(), 
		   source, 
		   new String[] {
			 "description", "Specifies the new object to be referred."
		   });		
		addAnnotation
		  (valueSubstitutionEClass, 
		   source, 
		   new String[] {
			 "description", "The ValueSubstitution defines a substitution that will change the value of an attribute of a base model element.",
			 "semantics", "The semantics of a ValueSubstitution vs is:\r\n\r\nATTR(vs.placement.propertyName, vs.placement.targetObject) = vs.replacement.value\r\n\r\nwhere ATTR is a reflective operation that given a string and a reference to a model element returns the reference (L-value) to the attribute (of the model element) with name given by the string.",
			 "constraint", "propertyName must be the name of an attribute of the model element."
		   });				
		addAnnotation
		  (getValueSubstitution_Placement(), 
		   source, 
		   new String[] {
			 "description", "Specifies the attribute to be changed."
		   });		
		addAnnotation
		  (getValueSubstitution_Replacement(), 
		   source, 
		   new String[] {
			 "description", "Specifies the new value of the attribute."
		   });		
		addAnnotation
		  (fragmentSubstitutionEClass, 
		   source, 
		   new String[] {
			 "description", "Fragment Substitution substitutes a fragment of the base model with another fragment of the base model.",
			 "semantics", "1. Delete the model elements defined by the PlacementFragment. \r\nThe placement model elements can be found through FragmentSubstitution.placement\'s placementBoundaryElements that are of class ToPlacement (using the model element references called insideBoundaryElement) and the transitive closure of all references from these, where the traversal is cut off at any reference that has \r\nthe same value as any of FragmentSubstitution.placement\'s PlacementBoundardyElement that are of class FromPlacement (using the model element references called outsideBoundaryElement). \r\n\r\n2. For the replacement fragments binding, copy its content onto the hole made by the deletion of the placement fragment. The placement and replacement boundary elements must correspond. \r\nThe content model elements can be found through FragmentSubstitution. replacement\'s  ReplacementBoundaryElement that are of type ToReplacement (using the model element references called insideBoundaryElement) and all model elements found through the transitive closure of all references from this set of model elements, where the traversal is cut off at any reference that has the same value as any of FragmentSubstitution.replacement\'s ReplacementBoundaryElement that are of type FromReplacement (using the model element references called outsideBoundaryElement).\r\n\r\n3. Binding boundary elements. The placement and replacement boundary elements are connected by bindings. The bindings are given by the BoundaryElementBindings.\r\n\r\n3.1. FromBinding: \r\n         fromReplacement.insideBoundaryElement.propertyName[] =      \r\n           fromPlacement.outsideBoundaryElement[]\r\n\r\n3.2. ToBinding: \r\n       toPlacement.outsideBoundaryElement.propertyName[] =  \r\n           toReplacement.insideBoundaryElement[]. \r\n\r\nThis definition in fact also covers attributes that have multiplicity. Such attributes may be seen as arrays or collections, and repeated reference assignments to such attributes during variability transformation will mean adding a new individual reference to the identifier collection.",
			 "constraint", "The boundary elements define all references going in and out of the placement fragment.\r\nThe boundary elements fully define all references going in \r\nand out of the replacement fragment."
		   });				
		addAnnotation
		  (getFragmentSubstitution_Placement(), 
		   source, 
		   new String[] {
			 "description", "Specifies the fragment to be replaced."
		   });		
		addAnnotation
		  (getFragmentSubstitution_Replacement(), 
		   source, 
		   new String[] {
			 "description", "The new fragment to be copied and used as replacement."
		   });		
		addAnnotation
		  (getFragmentSubstitution_RfRef(), 
		   source, 
		   new String[] {
			 "description", "Specifies which ReplacementFragmentReference that will store the instance of the replacement fragment used in this substitution."
		   });		
		addAnnotation
		  (getFragmentSubstitution_BoundaryElementBinding(), 
		   source, 
		   new String[] {
			 "description", "Specifies the binding betwwen the placement and replacement fragments."
		   });		
		addAnnotation
		  (placementFragmentEClass, 
		   source, 
		   new String[] {
			 "description", "A PlacementFragment defines a fragment (set of model elements) of the base model that will be replaced by a ReplacementFragment during the variability transformation. The set of model elements of the fragment will be deleted.",
			 "semantics", "The semantics of the Placement Fragment can be found under Fragment Substitution."
		   });				
		addAnnotation
		  (getPlacementFragment_BoundaryElement(), 
		   source, 
		   new String[] {
			 "description", "The boundary elements captures all the relations from and to the fragment."
		   });		
		addAnnotation
		  (replacementFragmentEClass, 
		   source, 
		   new String[] {
			 "description", "Replacement Fragment defines a fragment of the base model that will be used as replacement for some placement fragment of the base model.",
			 "semantics", "The semantics of Replacement Fragment can be found under Fragment Substitution.",
			 "constraint", "The pla\tcements contained in a replacement fragments should only involve model elements which are inside the replacement fragment. These placements can be used in all instances of a the replacement fragment."
		   });				
		addAnnotation
		  (getReplacementFragment_BoundaryElement(), 
		   source, 
		   new String[] {
			 "description", "The boundary elements captures all the relations from and to the fragment."
		   });		
		addAnnotation
		  (getReplacementFragment_Placements(), 
		   source, 
		   new String[] {
			 "description", "Set of placements contained by the replacement fragment."
		   });		
		addAnnotation
		  (placementBoundaryElementEClass, 
		   source, 
		   new String[] {
			 "description", "Represents the boundary between a placement fragment and the rest of the base model.",
			 "semantics", "The semantics of Variation Boundary Element is found under its specializations."
		   });		
		addAnnotation
		  (replacementBoundaryElementEClass, 
		   source, 
		   new String[] {
			 "description", "Represents the boundary between a replacement fragment and the rest of the base model.",
			 "semantics", "The semantics of Replacement Boundary Element is found under its specializations."
		   });		
		addAnnotation
		  (fromPlacementEClass, 
		   source, 
		   new String[] {
			 "description", "FromPlacement is the kind of boundary element that defines the outwards boundary of the owning placement fragment.\r\n\r\nThe outsideBoundaryElement refers to the model elements on the outside of the placement fragment. In a fragment substitution these have to be referred by model elements within the replacement fragment.",
			 "semantics", "The semantics of FromPlacement can be found under Fragment Substitution."
		   });				
		addAnnotation
		  (getFromPlacement_OutsideBoundaryElement(), 
		   source, 
		   new String[] {
			 "description", "Outside Model Element that are referred by the model elements inside the placement fragment."
		   });		
		addAnnotation
		  (getFromPlacement_ReplacementBoundaryElement(), 
		   source, 
		   new String[] {
			 "description", "Reference to a FromReplacement in a containing replacement fragment."
		   });		
		addAnnotation
		  (toPlacementEClass, 
		   source, 
		   new String[] {
			 "description", "ToPlacement is the kind of boundary element that defines the boundary between the owning placement fragment and the rest of the base model.\r\n\r\nThe insideBoundaryElements denote the ModelElements of owning fragment that are referred to by outside model elements.\r\n \r\nThe outsideBoundaryElement together with the propertyName denotes the attributes of model elements on the outside of the placement fragment that refer to the inside boundary model elements. ",
			 "semantics", "The semantics of To Placement can be found under Fragment Substitution.",
			 "constraint", "insideBoundaryElement = outsideRef.insideBoundaryElement\r\noutsideBoundaryElement != null xor outsideRef != null"
		   });				
		addAnnotation
		  (getToPlacement_PropertyName(), 
		   source, 
		   new String[] {
			 "description", "Name of the attribute to be changed."
		   });		
		addAnnotation
		  (getToPlacement_InsideBoundaryElement(), 
		   source, 
		   new String[] {
			 "description", "Model elements that are referred to by outside model elements. Used to distinguish miltiplicity references."
		   });		
		addAnnotation
		  (getToPlacement_OutsideBoundaryElement(), 
		   source, 
		   new String[] {
			 "description", "Outside model elements that refer model elements inside the fragment."
		   });		
		addAnnotation
		  (getToPlacement_OutsideRef(), 
		   source, 
		   new String[] {
			 "description", "Reference to a ToReplacement in a containing replacement fragment."
		   });		
		addAnnotation
		  (toReplacementEClass, 
		   source, 
		   new String[] {
			 "description", "ToReplacement is the kind of boundary element that defines the inwards boundary of the owning replacement fragment.\r\n\r\nThe insideBoundaryElement defines the starting points for the traversal to isolate the model elements that as part of a fragment substitution will be copied into the placement fragment.\r\n",
			 "semantics", "The semantics of To Replacement can be found under Fragment Substitution."
		   });				
		addAnnotation
		  (getToReplacement_InsideBoundaryElement(), 
		   source, 
		   new String[] {
			 "description", "Model elements that are referred to by outside model elements."
		   });		
		addAnnotation
		  (getToReplacement_PlacementBoundaryElement(), 
		   source, 
		   new String[] {
			 "description", "Reference to a ToPlacement contained by the replacement fragment."
		   });		
		addAnnotation
		  (fromReplacementEClass, 
		   source, 
		   new String[] {
			 "description", "FromReplacement is the kind of boundary element that defines the outwards boundary of the owning replacement fragment.\r\n\r\npropertyName is the name of the reference attribute of inside boundary model element that will be changed as part of a fragment substitution.\r\n\r\nThe insideBoundaryElements refer to the base model elements that will have their reference attributes updated as part of a fragment substitution.\r\n\r\nThe outsideBoundaryElement refers to the model elements on the outside of the replacement fragment. In a fragment substitution these references are used to define the extent of the replacement fragment.",
			 "semantics", "The semantics of To Replacement can be found under Fragment Substitution.",
			 "constraint", "outsideBoundaryElement = insideRef.outsideBoundaryElement\r\ninsideBoundaryElement != null xor insideRef != null\r\n"
		   });				
		addAnnotation
		  (getFromReplacement_PropertyName(), 
		   source, 
		   new String[] {
			 "description", "Name of the attribute to be changed."
		   });		
		addAnnotation
		  (getFromReplacement_OutsideBoundaryElement(), 
		   source, 
		   new String[] {
			 "description", "Outside model elements that are referred by model elements inside the fragment.  Used to distinguish miltiplicity references."
		   });		
		addAnnotation
		  (getFromReplacement_InsideBoundaryElement(), 
		   source, 
		   new String[] {
			 "description", "Inside model elements that refer outside model elements."
		   });		
		addAnnotation
		  (getFromReplacement_InsideRef(), 
		   source, 
		   new String[] {
			 "description", "Reference to a FromPlacement contained by the replacement fragment."
		   });				
		addAnnotation
		  (boundaryElementBindingEClass, 
		   source, 
		   new String[] {
			 "description", "Specifies the binding between the boundary elements of the placement fragment and the replacement fragment.",
			 "semantics", "The semantics of the BoundaryElementBinding is found under its specializations."
		   });		
		addAnnotation
		  (toBindingEClass, 
		   source, 
		   new String[] {
			 "description", "ToBinding defines a binding between boundary elements of kind  ToPlacement/ToReplacement.\r\n\r\nThe ToPlacement boundary element has to be bound to the ToReplacement.",
			 "semantics", "The semantics of the Placement Fragment can be found under Fragment Substitution."
		   });				
		addAnnotation
		  (getToBinding_ToPlacement(), 
		   source, 
		   new String[] {
			 "description", "Specifies the ToPlacement boundary element that is part of the binding."
		   });		
		addAnnotation
		  (getToBinding_ToReplacement(), 
		   source, 
		   new String[] {
			 "description", "Specifies the ToReplacement boundary element that is part of the binding."
		   });		
		addAnnotation
		  (fromBindingEClass, 
		   source, 
		   new String[] {
			 "description", "FromBinding defines a binding between boundary elements of kind FromPlacement/FromReplacement.\r\n\r\nThe FromPlacement boundary element that has to be bound to the FromPlacement.",
			 "semantics", "The semantics of the Placement Fragment can be found under Fragment Substitution."
		   });				
		addAnnotation
		  (getFromBinding_FromPlacement(), 
		   source, 
		   new String[] {
			 "description", "Specifies the FromPlacement boundary element that is part of the binding."
		   });		
		addAnnotation
		  (getFromBinding_FromReplacement(), 
		   source, 
		   new String[] {
			 "description", "Specifies the FromReplacement boundary element that is part of the binding."
		   });		
		addAnnotation
		  (compositeVariabilityEClass, 
		   source, 
		   new String[] {
			 "description", "A CompositeVariability contains a ordered set of Variability Specifications.",
			 "semantics", "The execution of a CompositeVariability consists of the execution of its executable primitives."
		   });				
		addAnnotation
		  (getCompositeVariability_VariabilitySpecification(), 
		   source, 
		   new String[] {
			 "description", "CompositeVariability contains a number of Variability Specifications."
		   });		
		addAnnotation
		  (variabilitySpecificationEClass, 
		   source, 
		   new String[] {
			 "description", "The VariabilitySpecifications of a CVLModel defines the variabilities on the base model represented by CVLModel. There are two kinds of VariabilitySpecifications: declarations and executable primitives.",
			 "semantics", "The semantics of the variability specification is given by the specializations."
		   });		
		addAnnotation
		  (placementLiteralEClass, 
		   source, 
		   new String[] {
			 "description", "A placement literaral represents a fragment of base model elements (or just a single element) that may be replaced by a replacement literal.",
			 "semantics", "The semantics of the placement literal is given by the specializations."
		   });		
		addAnnotation
		  (replacementLiteralEClass, 
		   source, 
		   new String[] {
			 "description", "A replacement literaral represents a fragment of base model elements (or just a single element) that may replace the model elements of a placement literal.",
			 "semantics", "The semantics of the replacement literal is given by the specializations."
		   });		
		addAnnotation
		  (placementValueEClass, 
		   source, 
		   new String[] {
			 "description", "A placement value represents a value-typed attribute (with name propertyName) of the model element denoted by targetObject, an attribute that by a ValueSubstitution may get a new value represented by a ReplacementValue.",
			 "semantics", "Attribute with the name propertyName of the model element denoted by targetObject."
		   });				
		addAnnotation
		  (getPlacementValue_PropertyName(), 
		   source, 
		   new String[] {
			 "description", "Name of the attribute to be changed."
		   });		
		addAnnotation
		  (getPlacementValue_TargetObject(), 
		   source, 
		   new String[] {
			 "description", "Containing object of the attribute to be changed."
		   });		
		addAnnotation
		  (placementObjectEClass, 
		   source, 
		   new String[] {
			 "description", "A placement object represents a reference-typed attribute (with name propertyName) of the model element denoted by targetObject, a reference attribute that by a ReferenceSubstitution may be changed to denote a model element represented by a ReplacementObject.",
			 "semantics", "Attribute with the name propertyName of the model element denoted by targetObject.",
			 "constraint", "targetObject must have a reference attribute with name propertyName. This is really a constraint on the combined CVL and base model."
		   });				
		addAnnotation
		  (getPlacementObject_PropertyName(), 
		   source, 
		   new String[] {
			 "description", "Name of the attribute to be changed."
		   });		
		addAnnotation
		  (getPlacementObject_TargetObject(), 
		   source, 
		   new String[] {
			 "description", "Containing object of the attribute to be changed."
		   });		
		addAnnotation
		  (getPlacementObject_ReferredObject(), 
		   source, 
		   new String[] {
			 "description", "Reference to the previous referred object, to distinguish multiplicity references."
		   });		
		addAnnotation
		  (replacementValueEClass, 
		   source, 
		   new String[] {
			 "description", "A value to replace the value of an attribute represented by a PlacementValue.",
			 "semantics", "The semantics of Replacement Value can be found under Value Substitution."
		   });				
		addAnnotation
		  (getReplacementValue_Value(), 
		   source, 
		   new String[] {
			 "description", "The value that will be used in the substitution."
		   });		
		addAnnotation
		  (replacementObjectEClass, 
		   source, 
		   new String[] {
			 "description", "Represents the model element that a reference attribute will denote after a reference substitution.",
			 "semantics", "The semantics of Replacement Value can be found under Reference Substitution."
		   });				
		addAnnotation
		  (getReplacementObject_TargetObject(), 
		   source, 
		   new String[] {
			 "description", "Reference to the element to be used as value in the substitution."
		   });		
		addAnnotation
		  (resolutionSpecificationEClass, 
		   source, 
		   new String[] {
			 "description", "The VariabilitySpecifications of a CVLModel defines the resolutions on the variability model represented by CVLModel.",
			 "semantics", "The semantics of the Resolution Specification is given by the specializations."
		   });		
		addAnnotation
		  (resolutionElementEClass, 
		   source, 
		   new String[] {
			 "description", "ResolutionElement contains the resolution values that will bind one specific executable primitive.",
			 "semantics", "A resolution element resolves a transformation represented by an executable primitive, so that this will be executed."
		   });				
		addAnnotation
		  (getResolutionElement_Element(), 
		   source, 
		   new String[] {
			 "description", "Specifies the executable primitive to be executed."
		   });		
		addAnnotation
		  (getResolutionElement_Resolution(), 
		   source, 
		   new String[] {
			 "description", "Specifies further iterator resolutions that are resolved."
		   });		
		addAnnotation
		  (typeEClass, 
		   source, 
		   new String[] {
			 "description", "A type defines the properties of instances, properties that are defined by the body composite variability. The type will configure and instantiate a replacement fragment.",
			 "semantics", "The local replacement fragment is instantiated. Substitutions in the body configure this instance. This instance is then stored to the ReplacementFragmentReference in the invocation.",
			 "constraint", "Substitutions in the body can only access placements in the local replacement fragment or in other replacement fragment instances."
		   });				
		addAnnotation
		  (getType_Body(), 
		   source, 
		   new String[] {
			 "description", "A CompositeVariability that contains a number of primitives."
		   });		
		addAnnotation
		  (getType_Replacement(), 
		   source, 
		   new String[] {
			 "description", "The local replacement fragment that will be instantiated and configured."
		   });		
		addAnnotation
		  (invocationEClass, 
		   source, 
		   new String[] {
			 "description", "Invocation represents the invocation of a type, execution of the executable primitives of its body, and yielding as result a ReplacementFragmentReference.",
			 "semantics", "The execution of an invocation implies the generation of an instance according to the type, execution of its executable primitives, and the return of a ReplacementFragmentReference that denotes the resulting replacement fragment."
		   });				
		addAnnotation
		  (getInvocation_Type(), 
		   source, 
		   new String[] {
			 "description", "The Type to be invoked."
		   });		
		addAnnotation
		  (getInvocation_ResolutionSpecification(), 
		   source, 
		   new String[] {
			 "description", "Specifies a resolution model to allow partial resolution of the type itself."
		   });		
		addAnnotation
		  (getInvocation_RfRef(), 
		   source, 
		   new String[] {
			 "description", "Specifies which ReplacementFragmentReference that will store the instance of the replacement fragment returned from the type."
		   });		
		addAnnotation
		  (iteratorResolutionEClass, 
		   source, 
		   new String[] {
			 "description", "An iterator resolution specifies the iterator to be resolved, and which executable elements to be chosen.",
			 "semantics", "Chosen executable elements in the specified iterator will be executed."
		   });				
		addAnnotation
		  (getIteratorResolution_Iterator(), 
		   source, 
		   new String[] {
			 "description", "Specifies the iterator that will be resolved."
		   });		
		addAnnotation
		  (getIteratorResolution_Choice(), 
		   source, 
		   new String[] {
			 "description", "Specifies the chosen executable elements to be executed."
		   });		
		addAnnotation
		  (iteratorEClass, 
		   source, 
		   new String[] {
			 "description", "An iterator is a special kind of composite variability. While the execution of an ordinary composite variability may execute all the executable primitives of the composite variability, an iterator may impose restrictions on the number of executable primitives to be executed. Resolution specifications specify which of the executable primitives to execute.",
			 "semantics", "The execution of an iterator implies the execution of a number of its contained executable primitives. The number is defined by the pair (lowerLimit, upperLimit):\r\n\r\n(0,1): none or at most one of the executable primitives can be chosen (by a resolution specification)to be executed.\r\n\r\n(1,1): exactly one of the executable primitives can be chosen (by a resolution specification)to be executed.\r\n\r\n(m,n): at least m and at most n executable primitives can be chosen (by a resolution specification)for execution; if isUnique is true then each executable primitive can only be executed once.\r\n\r\n(0,*): any number of the executable primitives can be executed; if isUnique is true then each executable primitive can only be executed once.",
			 "constraint", "In case of (0,*) the value of isUnique must be specifified."
		   });				
		addAnnotation
		  (getIterator_UpperLimit(), 
		   source, 
		   new String[] {
			 "description", "Restricts the number of possible executions to an upper limit."
		   });		
		addAnnotation
		  (getIterator_LowerLimit(), 
		   source, 
		   new String[] {
			 "description", "Restricts the number of possible executions to a lower limit."
		   });		
		addAnnotation
		  (getIterator_IsUnique(), 
		   source, 
		   new String[] {
			 "description", "Defines whether each executable primitive can only be executed once."
		   });		
		addAnnotation
		  (replacementFragmentReferenceEClass, 
		   source, 
		   new String[] {
			 "description", "ReplacementFragmentReference represent an instance of a replacement fragment. It can only store instances of replacement fragments of the specified kind (ReplacementFragmentReference.rfRef).",
			 "semantics", "The semantics of ReplacementFragmentReference can be found under Fragment Substitution."
		   });				
		addAnnotation
		  (getReplacementFragmentReference_RfRef(), 
		   source, 
		   new String[] {
			 "description", "Specifies the kind of replacement fragment this reference can store."
		   });		
		addAnnotation
		  (replacementFragmentAbstractEClass, 
		   source, 
		   new String[] {
			 "description", "ReplacementFragmentAbstract defines a fragment of the base model that will be used as replacement for some placement fragment of the base model.",
			 "semantics", "The semantics of the variability specification is given by the specializations."
		   });		
		addAnnotation
		  (assignmentEClass, 
		   source, 
		   new String[] {
			 "description", "Assign an instance of a replacement fragment to a ReplacementFragmentReference.",
			 "semantics", "The target ReplacementFragmentReference is assigned the value.",
			 "constraint", "The target and value have to be of the same kind of replacement fragment."
		   });				
		addAnnotation
		  (getAssignment_Value(), 
		   source, 
		   new String[] {
			 "description", "The value to be assigned to the target."
		   });		
		addAnnotation
		  (getAssignment_Target(), 
		   source, 
		   new String[] {
			 "description", "The ReplacementFragmentReference to be assigned a value."
		   });		
		addAnnotation
		  (declarationEClass, 
		   source, 
		   new String[] {
			 "description", "A Declaration defines either a type of composite variabilities, or fragments of the base model that are to be used by executable primitives.",
			 "semantics", "A Declaration introduces a type/literal that may be applied in executable primitives."
		   });		
		addAnnotation
		  (executablePrimitiveEClass, 
		   source, 
		   new String[] {
			 "description", "A CVL model is executed by executing its executable primitives. These will transform the copy of the base model according to substitutions.",
			 "semantics", "An executable primitive is executed if it is part of a variability specification of a CVLModel and selected for execution by a resolution specification."
		   });		
		addAnnotation
		  (constraintEClass, 
		   source, 
		   new String[] {
			 "description", "Constraint is a way to describe restrictions to what resolutions can apply.",
			 "semantics", "The CVL model will be validated using the specified constraints."
		   });				
		addAnnotation
		  (notEClass, 
		   source, 
		   new String[] {
			 "description", "Specifies an NOT expression.",
			 "semantics", "Negates the evaluation of the expression."
		   });				
		addAnnotation
		  (getNOT_Term(), 
		   source, 
		   new String[] {
			 "description", "Left side of expression."
		   });		
		addAnnotation
		  (orEClass, 
		   source, 
		   new String[] {
			 "description", "Specifies an OR expression.",
			 "semantics", "Evaluates to true if at least one of the expressions is true."
		   });				
		addAnnotation
		  (impliesEClass, 
		   source, 
		   new String[] {
			 "description", "Specifies an IMPLIES expression.",
			 "semantics", "The left expression implies the right expression."
		   });				
		addAnnotation
		  (executablePrimitiveTermEClass, 
		   source, 
		   new String[] {
			 "description", "Specifies an ExecutablePrimitive.",
			 "semantics", "The referred ExecutablePrimitive is used in the expression."
		   });				
		addAnnotation
		  (getExecutablePrimitiveTerm_Primitive(), 
		   source, 
		   new String[] {
			 "description", "Reference to an executable primitive."
		   });		
		addAnnotation
		  (anD_EClass, 
		   source, 
		   new String[] {
			 "description", "Specifies an AND expression.",
			 "semantics", "Evaluates to true if both expressions are true."
		   });				
		addAnnotation
		  (binaryEClass, 
		   source, 
		   new String[] {
			 "description", "Specifies a binary expression.",
			 "semantics", "The semantics of Binary is given by the specializations."
		   });		
		addAnnotation
		  (getBinary_Left(), 
		   source, 
		   new String[] {
			 "description", "Left side of expression."
		   });		
		addAnnotation
		  (getBinary_Right(), 
		   source, 
		   new String[] {
			 "description", "Right side of expression."
		   });		
		addAnnotation
		  (resolutionValueEClass, 
		   source, 
		   new String[] {
			 "description", "The resolution value gives the arguments to a value substitution.",
			 "semantics", "The resolution value will override the replacement value in the value substitution.",
			 "constraint", "The type of the resolution value has to be of the same kind as the placement value."
		   });				
		addAnnotation
		  (getResolutionValue_Value(), 
		   source, 
		   new String[] {
			 "description", "Defines a value to be used in a value substitution."
		   });
	}

	/**
	 * Initializes the annotations for <b>kermeta</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createKermetaAnnotations() {
		String source = "kermeta";					
		addAnnotation
		  (cvlModelEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitCVLModel(self, context)\nend",
			 "isAbstract", "false"
		   });									
		addAnnotation
		  (referenceSubstitutionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitReferenceSubstitution(self, context)\nend",
			 "isAbstract", "false"
		   });						
		addAnnotation
		  (valueSubstitutionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitValueSubstitution(self, context)\nend",
			 "isAbstract", "false"
		   });						
		addAnnotation
		  (fragmentSubstitutionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitFragmentSubstitution(self, context)\nend",
			 "isAbstract", "false"
		   });								
		addAnnotation
		  (placementFragmentEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitPlacementFragment(self, context)\nend",
			 "isAbstract", "false"
		   });					
		addAnnotation
		  (replacementFragmentEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitReplacementFragment(self, context)\nend",
			 "isAbstract", "false"
		   });								
		addAnnotation
		  (fromPlacementEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitFromPlacement(self, context)\nend",
			 "isAbstract", "false"
		   });						
		addAnnotation
		  (toPlacementEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitToPlacement(self, context)\nend",
			 "isAbstract", "false"
		   });								
		addAnnotation
		  (toReplacementEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitToReplacement(self, context)\nend",
			 "isAbstract", "false"
		   });						
		addAnnotation
		  (fromReplacementEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitFromReplacement(self, context)\nend",
			 "isAbstract", "false"
		   });							
		addAnnotation
		  (cvlElementEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitCVLElement(self, context)\nend",
			 "isAbstract", "false"
		   });					
		addAnnotation
		  (toBindingEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitToBinding(self, context)\nend",
			 "isAbstract", "false"
		   });						
		addAnnotation
		  (fromBindingEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitFromBinding(self, context)\nend",
			 "isAbstract", "false"
		   });						
		addAnnotation
		  (compositeVariabilityEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitCompositeVariability(self, context)\nend",
			 "isAbstract", "false"
		   });								
		addAnnotation
		  (placementValueEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitPlacementValue(self, context)\nend",
			 "isAbstract", "false"
		   });						
		addAnnotation
		  (placementObjectEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitPlacementObject(self, context)\nend",
			 "isAbstract", "false"
		   });							
		addAnnotation
		  (replacementValueEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitReplacementValue(self, context)\nend",
			 "isAbstract", "false"
		   });					
		addAnnotation
		  (replacementObjectEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitReplacementObject(self, context)\nend",
			 "isAbstract", "false"
		   });						
		addAnnotation
		  (resolutionElementEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitResolutionElement(self, context)\nend",
			 "isAbstract", "false"
		   });						
		addAnnotation
		  (typeEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitType(self, context)\nend",
			 "isAbstract", "false"
		   });						
		addAnnotation
		  (invocationEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitInvocation(self, context)\nend",
			 "isAbstract", "false"
		   });							
		addAnnotation
		  (iteratorResolutionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitIteratorResolution(self, context)\nend",
			 "isAbstract", "false"
		   });						
		addAnnotation
		  (iteratorEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitIterator(self, context)\nend",
			 "isAbstract", "false"
		   });							
		addAnnotation
		  (replacementFragmentReferenceEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitReplacementFragmentReference(self, context)\nend",
			 "isAbstract", "false"
		   });						
		addAnnotation
		  (assignmentEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitAssignment(self, context)\nend",
			 "isAbstract", "false"
		   });								
		addAnnotation
		  (constraintEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitConstraint(self, context)\nend",
			 "isAbstract", "false"
		   });				
		addAnnotation
		  (notEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitNOT(self, context)\nend",
			 "isAbstract", "false"
		   });					
		addAnnotation
		  (orEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitOR(self, context)\nend",
			 "isAbstract", "false"
		   });				
		addAnnotation
		  (impliesEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitIMPLIES(self, context)\nend",
			 "isAbstract", "false"
		   });				
		addAnnotation
		  (executablePrimitiveTermEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitExecutablePrimitiveTerm(self, context)\nend",
			 "isAbstract", "false"
		   });					
		addAnnotation
		  (anD_EClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitAND_(self, context)\nend",
			 "isAbstract", "false"
		   });							
		addAnnotation
		  (resolutionValueEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nresult := visitor.visitResolutionValue(self, context)\nend",
			 "isAbstract", "false"
		   });	
	}

} //CvlPackageImpl
