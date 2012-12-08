/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.variabilitymodeling.cvl.visitors.VisitorsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.variabilitymodeling.cvl.CvlFactory
 * @model kind="package"
 *        annotation="doc description='The following is a full normative description of each meta-classes.'"
 * @generated
 */
public interface CvlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cvl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.variabilitymodeling.cvl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cvl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CvlPackage eINSTANCE = org.variabilitymodeling.cvl.impl.CvlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.CVLElementImpl <em>CVL Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.CVLElementImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getCVLElement()
	 * @generated
	 */
	int CVL_ELEMENT = 13;

	/**
	 * The number of structural features of the '<em>CVL Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVL_ELEMENT_FEATURE_COUNT = VisitorsPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.CVLNamedElementImpl <em>CVL Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.CVLNamedElementImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getCVLNamedElement()
	 * @generated
	 */
	int CVL_NAMED_ELEMENT = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVL_NAMED_ELEMENT__NAME = CVL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CVL Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVL_NAMED_ELEMENT_FEATURE_COUNT = CVL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.CVLModelImpl <em>CVL Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.CVLModelImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getCVLModel()
	 * @generated
	 */
	int CVL_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVL_MODEL__NAME = CVL_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Variability Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVL_MODEL__VARIABILITY_SPECIFICATION = CVL_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resolution Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVL_MODEL__RESOLUTION_SPECIFICATION = CVL_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVL_MODEL__BASE = CVL_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CVL Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVL_MODEL_FEATURE_COUNT = CVL_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.VariabilitySpecificationImpl <em>Variability Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.VariabilitySpecificationImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getVariabilitySpecification()
	 * @generated
	 */
	int VARIABILITY_SPECIFICATION = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_SPECIFICATION__NAME = CVL_NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Variability Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_SPECIFICATION_FEATURE_COUNT = CVL_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ExecutablePrimitiveImpl <em>Executable Primitive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ExecutablePrimitiveImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getExecutablePrimitive()
	 * @generated
	 */
	int EXECUTABLE_PRIMITIVE = 36;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_PRIMITIVE__NAME = VARIABILITY_SPECIFICATION__NAME;

	/**
	 * The number of structural features of the '<em>Executable Primitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_PRIMITIVE_FEATURE_COUNT = VARIABILITY_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.SubstitutionImpl <em>Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.SubstitutionImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getSubstitution()
	 * @generated
	 */
	int SUBSTITUTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION__NAME = EXECUTABLE_PRIMITIVE__NAME;

	/**
	 * The feature id for the '<em><b>Replacement Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION__REPLACEMENT_INSTANCE = EXECUTABLE_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION_FEATURE_COUNT = EXECUTABLE_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ReferenceSubstitutionImpl <em>Reference Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ReferenceSubstitutionImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReferenceSubstitution()
	 * @generated
	 */
	int REFERENCE_SUBSTITUTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SUBSTITUTION__NAME = SUBSTITUTION__NAME;

	/**
	 * The feature id for the '<em><b>Replacement Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SUBSTITUTION__REPLACEMENT_INSTANCE = SUBSTITUTION__REPLACEMENT_INSTANCE;

	/**
	 * The feature id for the '<em><b>Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SUBSTITUTION__PLACEMENT = SUBSTITUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SUBSTITUTION__REPLACEMENT = SUBSTITUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SUBSTITUTION_FEATURE_COUNT = SUBSTITUTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ValueSubstitutionImpl <em>Value Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ValueSubstitutionImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getValueSubstitution()
	 * @generated
	 */
	int VALUE_SUBSTITUTION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SUBSTITUTION__NAME = SUBSTITUTION__NAME;

	/**
	 * The feature id for the '<em><b>Replacement Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SUBSTITUTION__REPLACEMENT_INSTANCE = SUBSTITUTION__REPLACEMENT_INSTANCE;

	/**
	 * The feature id for the '<em><b>Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SUBSTITUTION__PLACEMENT = SUBSTITUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SUBSTITUTION__REPLACEMENT = SUBSTITUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Value Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SUBSTITUTION_FEATURE_COUNT = SUBSTITUTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.FragmentSubstitutionImpl <em>Fragment Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.FragmentSubstitutionImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getFragmentSubstitution()
	 * @generated
	 */
	int FRAGMENT_SUBSTITUTION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__NAME = SUBSTITUTION__NAME;

	/**
	 * The feature id for the '<em><b>Replacement Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__REPLACEMENT_INSTANCE = SUBSTITUTION__REPLACEMENT_INSTANCE;

	/**
	 * The feature id for the '<em><b>Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__PLACEMENT = SUBSTITUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__REPLACEMENT = SUBSTITUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rf Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__RF_REF = SUBSTITUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Boundary Element Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING = SUBSTITUTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Fragment Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_SUBSTITUTION_FEATURE_COUNT = SUBSTITUTION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.PlacementFragmentImpl <em>Placement Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.PlacementFragmentImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getPlacementFragment()
	 * @generated
	 */
	int PLACEMENT_FRAGMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT__NAME = CVL_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Boundary Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT__BOUNDARY_ELEMENT = CVL_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT__USAGE = CVL_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Placement Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_FRAGMENT_FEATURE_COUNT = CVL_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ReplacementFragmentImpl <em>Replacement Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ReplacementFragmentImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementFragment()
	 * @generated
	 */
	int REPLACEMENT_FRAGMENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT__NAME = CVL_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Boundary Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT__BOUNDARY_ELEMENT = CVL_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Placements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT__PLACEMENTS = CVL_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Replacement Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_FEATURE_COUNT = CVL_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.PlacementBoundaryElementImpl <em>Placement Boundary Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.PlacementBoundaryElementImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getPlacementBoundaryElement()
	 * @generated
	 */
	int PLACEMENT_BOUNDARY_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_BOUNDARY_ELEMENT__NAME = CVL_NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Placement Boundary Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT = CVL_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ReplacementBoundaryElementImpl <em>Replacement Boundary Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ReplacementBoundaryElementImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementBoundaryElement()
	 * @generated
	 */
	int REPLACEMENT_BOUNDARY_ELEMENT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_BOUNDARY_ELEMENT__NAME = CVL_NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Replacement Boundary Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT = CVL_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.FromPlacementImpl <em>From Placement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.FromPlacementImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getFromPlacement()
	 * @generated
	 */
	int FROM_PLACEMENT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_PLACEMENT__NAME = PLACEMENT_BOUNDARY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Outside Boundary Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replacement Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>From Placement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_PLACEMENT_FEATURE_COUNT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ToPlacementImpl <em>To Placement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ToPlacementImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getToPlacement()
	 * @generated
	 */
	int TO_PLACEMENT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT__NAME = PLACEMENT_BOUNDARY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT__PROPERTY_NAME = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inside Boundary Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outside Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Outside Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT__OUTSIDE_REF = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>To Placement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_PLACEMENT_FEATURE_COUNT = PLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ToReplacementImpl <em>To Replacement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ToReplacementImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getToReplacement()
	 * @generated
	 */
	int TO_REPLACEMENT = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_REPLACEMENT__NAME = REPLACEMENT_BOUNDARY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Inside Boundary Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Placement Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>To Replacement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_REPLACEMENT_FEATURE_COUNT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.FromReplacementImpl <em>From Replacement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.FromReplacementImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getFromReplacement()
	 * @generated
	 */
	int FROM_REPLACEMENT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT__NAME = REPLACEMENT_BOUNDARY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT__PROPERTY_NAME = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outside Boundary Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inside Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Inside Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT__INSIDE_REF = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>From Replacement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_REPLACEMENT_FEATURE_COUNT = REPLACEMENT_BOUNDARY_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.BoundaryElementBindingImpl <em>Boundary Element Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.BoundaryElementBindingImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getBoundaryElementBinding()
	 * @generated
	 */
	int BOUNDARY_ELEMENT_BINDING = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_ELEMENT_BINDING__NAME = CVL_NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Boundary Element Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT = CVL_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ToBindingImpl <em>To Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ToBindingImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getToBinding()
	 * @generated
	 */
	int TO_BINDING = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_BINDING__NAME = BOUNDARY_ELEMENT_BINDING__NAME;

	/**
	 * The feature id for the '<em><b>To Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_BINDING__TO_PLACEMENT = BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_BINDING__TO_REPLACEMENT = BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>To Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_BINDING_FEATURE_COUNT = BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.FromBindingImpl <em>From Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.FromBindingImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getFromBinding()
	 * @generated
	 */
	int FROM_BINDING = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_BINDING__NAME = BOUNDARY_ELEMENT_BINDING__NAME;

	/**
	 * The feature id for the '<em><b>From Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_BINDING__FROM_PLACEMENT = BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_BINDING__FROM_REPLACEMENT = BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>From Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_BINDING_FEATURE_COUNT = BOUNDARY_ELEMENT_BINDING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.CompositeVariabilityImpl <em>Composite Variability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.CompositeVariabilityImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getCompositeVariability()
	 * @generated
	 */
	int COMPOSITE_VARIABILITY = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_VARIABILITY__NAME = EXECUTABLE_PRIMITIVE__NAME;

	/**
	 * The feature id for the '<em><b>Variability Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_VARIABILITY__VARIABILITY_SPECIFICATION = EXECUTABLE_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Variability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_VARIABILITY_FEATURE_COUNT = EXECUTABLE_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.DeclarationImpl <em>Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.DeclarationImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getDeclaration()
	 * @generated
	 */
	int DECLARATION = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION__NAME = VARIABILITY_SPECIFICATION__NAME;

	/**
	 * The number of structural features of the '<em>Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION_FEATURE_COUNT = VARIABILITY_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.PlacementLiteralImpl <em>Placement Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.PlacementLiteralImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getPlacementLiteral()
	 * @generated
	 */
	int PLACEMENT_LITERAL = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_LITERAL__NAME = DECLARATION__NAME;

	/**
	 * The number of structural features of the '<em>Placement Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_LITERAL_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ReplacementLiteralImpl <em>Replacement Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ReplacementLiteralImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementLiteral()
	 * @generated
	 */
	int REPLACEMENT_LITERAL = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_LITERAL__NAME = DECLARATION__NAME;

	/**
	 * The number of structural features of the '<em>Replacement Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_LITERAL_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.PlacementValueImpl <em>Placement Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.PlacementValueImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getPlacementValue()
	 * @generated
	 */
	int PLACEMENT_VALUE = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_VALUE__NAME = PLACEMENT_LITERAL__NAME;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_VALUE__PROPERTY_NAME = PLACEMENT_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_VALUE__TARGET_OBJECT = PLACEMENT_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Placement Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_VALUE_FEATURE_COUNT = PLACEMENT_LITERAL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.PlacementObjectImpl <em>Placement Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.PlacementObjectImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getPlacementObject()
	 * @generated
	 */
	int PLACEMENT_OBJECT = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_OBJECT__NAME = PLACEMENT_LITERAL__NAME;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_OBJECT__PROPERTY_NAME = PLACEMENT_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_OBJECT__TARGET_OBJECT = PLACEMENT_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_OBJECT__REFERRED_OBJECT = PLACEMENT_LITERAL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Placement Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEMENT_OBJECT_FEATURE_COUNT = PLACEMENT_LITERAL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ReplacementValueImpl <em>Replacement Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ReplacementValueImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementValue()
	 * @generated
	 */
	int REPLACEMENT_VALUE = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_VALUE__NAME = REPLACEMENT_LITERAL__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_VALUE__VALUE = REPLACEMENT_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Replacement Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_VALUE_FEATURE_COUNT = REPLACEMENT_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ReplacementObjectImpl <em>Replacement Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ReplacementObjectImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementObject()
	 * @generated
	 */
	int REPLACEMENT_OBJECT = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_OBJECT__NAME = REPLACEMENT_LITERAL__NAME;

	/**
	 * The feature id for the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_OBJECT__TARGET_OBJECT = REPLACEMENT_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Replacement Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_OBJECT_FEATURE_COUNT = REPLACEMENT_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ResolutionSpecificationImpl <em>Resolution Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ResolutionSpecificationImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getResolutionSpecification()
	 * @generated
	 */
	int RESOLUTION_SPECIFICATION = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_SPECIFICATION__NAME = CVL_NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Resolution Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_SPECIFICATION_FEATURE_COUNT = CVL_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ResolutionElementImpl <em>Resolution Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ResolutionElementImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getResolutionElement()
	 * @generated
	 */
	int RESOLUTION_ELEMENT = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_ELEMENT__NAME = RESOLUTION_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_ELEMENT__ELEMENT = RESOLUTION_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resolution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_ELEMENT__RESOLUTION = RESOLUTION_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resolution Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_ELEMENT_FEATURE_COUNT = RESOLUTION_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.TypeImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__BODY = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replacement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__REPLACEMENT = DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.InvocationImpl <em>Invocation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.InvocationImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getInvocation()
	 * @generated
	 */
	int INVOCATION = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION__NAME = EXECUTABLE_PRIMITIVE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION__TYPE = EXECUTABLE_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resolution Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION__RESOLUTION_SPECIFICATION = EXECUTABLE_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rf Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION__RF_REF = EXECUTABLE_PRIMITIVE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Invocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCATION_FEATURE_COUNT = EXECUTABLE_PRIMITIVE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.IteratorResolutionImpl <em>Iterator Resolution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.IteratorResolutionImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getIteratorResolution()
	 * @generated
	 */
	int ITERATOR_RESOLUTION = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_RESOLUTION__NAME = RESOLUTION_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_RESOLUTION__ITERATOR = RESOLUTION_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Choice</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_RESOLUTION__CHOICE = RESOLUTION_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Iterator Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_RESOLUTION_FEATURE_COUNT = RESOLUTION_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.IteratorImpl <em>Iterator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.IteratorImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getIterator()
	 * @generated
	 */
	int ITERATOR = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR__NAME = COMPOSITE_VARIABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Variability Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR__VARIABILITY_SPECIFICATION = COMPOSITE_VARIABILITY__VARIABILITY_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Upper Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR__UPPER_LIMIT = COMPOSITE_VARIABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lower Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR__LOWER_LIMIT = COMPOSITE_VARIABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR__IS_UNIQUE = COMPOSITE_VARIABILITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Iterator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_FEATURE_COUNT = COMPOSITE_VARIABILITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ReplacementFragmentAbstractImpl <em>Replacement Fragment Abstract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ReplacementFragmentAbstractImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementFragmentAbstract()
	 * @generated
	 */
	int REPLACEMENT_FRAGMENT_ABSTRACT = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_ABSTRACT__NAME = REPLACEMENT_LITERAL__NAME;

	/**
	 * The number of structural features of the '<em>Replacement Fragment Abstract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_ABSTRACT_FEATURE_COUNT = REPLACEMENT_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ReplacementFragmentReferenceImpl <em>Replacement Fragment Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ReplacementFragmentReferenceImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementFragmentReference()
	 * @generated
	 */
	int REPLACEMENT_FRAGMENT_REFERENCE = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_REFERENCE__NAME = REPLACEMENT_FRAGMENT_ABSTRACT__NAME;

	/**
	 * The feature id for the '<em><b>Rf Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_REFERENCE__RF_REF = REPLACEMENT_FRAGMENT_ABSTRACT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Replacement Fragment Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_FRAGMENT_REFERENCE_FEATURE_COUNT = REPLACEMENT_FRAGMENT_ABSTRACT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.AssignmentImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__NAME = EXECUTABLE_PRIMITIVE__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__VALUE = EXECUTABLE_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__TARGET = EXECUTABLE_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = EXECUTABLE_PRIMITIVE_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ConstraintImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 37;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = DECLARATION__NAME;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.NOTImpl <em>NOT</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.NOTImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getNOT()
	 * @generated
	 */
	int NOT = 38;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__TERM = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>NOT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.BinaryImpl <em>Binary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.BinaryImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getBinary()
	 * @generated
	 */
	int BINARY = 43;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY__LEFT = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY__RIGHT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ORImpl <em>OR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ORImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getOR()
	 * @generated
	 */
	int OR = 39;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__NAME = BINARY__NAME;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__LEFT = BINARY__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__RIGHT = BINARY__RIGHT;

	/**
	 * The number of structural features of the '<em>OR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = BINARY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.IMPLIESImpl <em>IMPLIES</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.IMPLIESImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getIMPLIES()
	 * @generated
	 */
	int IMPLIES = 40;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__NAME = BINARY__NAME;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__LEFT = BINARY__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__RIGHT = BINARY__RIGHT;

	/**
	 * The number of structural features of the '<em>IMPLIES</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_FEATURE_COUNT = BINARY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ExecutablePrimitiveTermImpl <em>Executable Primitive Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ExecutablePrimitiveTermImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getExecutablePrimitiveTerm()
	 * @generated
	 */
	int EXECUTABLE_PRIMITIVE_TERM = 41;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_PRIMITIVE_TERM__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Primitive</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_PRIMITIVE_TERM__PRIMITIVE = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Executable Primitive Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_PRIMITIVE_TERM_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.AND_Impl <em>AND </em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.AND_Impl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getAND_()
	 * @generated
	 */
	int AND_ = 42;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___NAME = BINARY__NAME;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___LEFT = BINARY__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___RIGHT = BINARY__RIGHT;

	/**
	 * The number of structural features of the '<em>AND </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__FEATURE_COUNT = BINARY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.impl.ResolutionValueImpl <em>Resolution Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.impl.ResolutionValueImpl
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getResolutionValue()
	 * @generated
	 */
	int RESOLUTION_VALUE = 44;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_VALUE__NAME = RESOLUTION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_VALUE__ELEMENT = RESOLUTION_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>Resolution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_VALUE__RESOLUTION = RESOLUTION_ELEMENT__RESOLUTION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_VALUE__VALUE = RESOLUTION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resolution Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_VALUE_FEATURE_COUNT = RESOLUTION_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.PlacementFragmentUsage <em>Placement Fragment Usage</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.PlacementFragmentUsage
	 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getPlacementFragmentUsage()
	 * @generated
	 */
	int PLACEMENT_FRAGMENT_USAGE = 45;


	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.CVLModel <em>CVL Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVL Model</em>'.
	 * @see org.variabilitymodeling.cvl.CVLModel
	 * @generated
	 */
	EClass getCVLModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.variabilitymodeling.cvl.CVLModel#getVariabilitySpecification <em>Variability Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variability Specification</em>'.
	 * @see org.variabilitymodeling.cvl.CVLModel#getVariabilitySpecification()
	 * @see #getCVLModel()
	 * @generated
	 */
	EReference getCVLModel_VariabilitySpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link org.variabilitymodeling.cvl.CVLModel#getResolutionSpecification <em>Resolution Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resolution Specification</em>'.
	 * @see org.variabilitymodeling.cvl.CVLModel#getResolutionSpecification()
	 * @see #getCVLModel()
	 * @generated
	 */
	EReference getCVLModel_ResolutionSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.CVLModel#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base</em>'.
	 * @see org.variabilitymodeling.cvl.CVLModel#getBase()
	 * @see #getCVLModel()
	 * @generated
	 */
	EReference getCVLModel_Base();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.Substitution <em>Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Substitution</em>'.
	 * @see org.variabilitymodeling.cvl.Substitution
	 * @generated
	 */
	EClass getSubstitution();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.Substitution#getReplacementInstance <em>Replacement Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Replacement Instance</em>'.
	 * @see org.variabilitymodeling.cvl.Substitution#getReplacementInstance()
	 * @see #getSubstitution()
	 * @generated
	 */
	EReference getSubstitution_ReplacementInstance();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ReferenceSubstitution <em>Reference Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Substitution</em>'.
	 * @see org.variabilitymodeling.cvl.ReferenceSubstitution
	 * @generated
	 */
	EClass getReferenceSubstitution();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.ReferenceSubstitution#getPlacement <em>Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Placement</em>'.
	 * @see org.variabilitymodeling.cvl.ReferenceSubstitution#getPlacement()
	 * @see #getReferenceSubstitution()
	 * @generated
	 */
	EReference getReferenceSubstitution_Placement();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.ReferenceSubstitution#getReplacement <em>Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Replacement</em>'.
	 * @see org.variabilitymodeling.cvl.ReferenceSubstitution#getReplacement()
	 * @see #getReferenceSubstitution()
	 * @generated
	 */
	EReference getReferenceSubstitution_Replacement();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ValueSubstitution <em>Value Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Substitution</em>'.
	 * @see org.variabilitymodeling.cvl.ValueSubstitution
	 * @generated
	 */
	EClass getValueSubstitution();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.ValueSubstitution#getPlacement <em>Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Placement</em>'.
	 * @see org.variabilitymodeling.cvl.ValueSubstitution#getPlacement()
	 * @see #getValueSubstitution()
	 * @generated
	 */
	EReference getValueSubstitution_Placement();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.ValueSubstitution#getReplacement <em>Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Replacement</em>'.
	 * @see org.variabilitymodeling.cvl.ValueSubstitution#getReplacement()
	 * @see #getValueSubstitution()
	 * @generated
	 */
	EReference getValueSubstitution_Replacement();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.FragmentSubstitution <em>Fragment Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment Substitution</em>'.
	 * @see org.variabilitymodeling.cvl.FragmentSubstitution
	 * @generated
	 */
	EClass getFragmentSubstitution();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.FragmentSubstitution#getPlacement <em>Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Placement</em>'.
	 * @see org.variabilitymodeling.cvl.FragmentSubstitution#getPlacement()
	 * @see #getFragmentSubstitution()
	 * @generated
	 */
	EReference getFragmentSubstitution_Placement();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.FragmentSubstitution#getReplacement <em>Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Replacement</em>'.
	 * @see org.variabilitymodeling.cvl.FragmentSubstitution#getReplacement()
	 * @see #getFragmentSubstitution()
	 * @generated
	 */
	EReference getFragmentSubstitution_Replacement();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.FragmentSubstitution#getRfRef <em>Rf Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rf Ref</em>'.
	 * @see org.variabilitymodeling.cvl.FragmentSubstitution#getRfRef()
	 * @see #getFragmentSubstitution()
	 * @generated
	 */
	EReference getFragmentSubstitution_RfRef();

	/**
	 * Returns the meta object for the containment reference list '{@link org.variabilitymodeling.cvl.FragmentSubstitution#getBoundaryElementBinding <em>Boundary Element Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Boundary Element Binding</em>'.
	 * @see org.variabilitymodeling.cvl.FragmentSubstitution#getBoundaryElementBinding()
	 * @see #getFragmentSubstitution()
	 * @generated
	 */
	EReference getFragmentSubstitution_BoundaryElementBinding();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.PlacementFragment <em>Placement Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placement Fragment</em>'.
	 * @see org.variabilitymodeling.cvl.PlacementFragment
	 * @generated
	 */
	EClass getPlacementFragment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.variabilitymodeling.cvl.PlacementFragment#getBoundaryElement <em>Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Boundary Element</em>'.
	 * @see org.variabilitymodeling.cvl.PlacementFragment#getBoundaryElement()
	 * @see #getPlacementFragment()
	 * @generated
	 */
	EReference getPlacementFragment_BoundaryElement();

	/**
	 * Returns the meta object for the attribute '{@link org.variabilitymodeling.cvl.PlacementFragment#getUsage <em>Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage</em>'.
	 * @see org.variabilitymodeling.cvl.PlacementFragment#getUsage()
	 * @see #getPlacementFragment()
	 * @generated
	 */
	EAttribute getPlacementFragment_Usage();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ReplacementFragment <em>Replacement Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Fragment</em>'.
	 * @see org.variabilitymodeling.cvl.ReplacementFragment
	 * @generated
	 */
	EClass getReplacementFragment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.variabilitymodeling.cvl.ReplacementFragment#getBoundaryElement <em>Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Boundary Element</em>'.
	 * @see org.variabilitymodeling.cvl.ReplacementFragment#getBoundaryElement()
	 * @see #getReplacementFragment()
	 * @generated
	 */
	EReference getReplacementFragment_BoundaryElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.variabilitymodeling.cvl.ReplacementFragment#getPlacements <em>Placements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Placements</em>'.
	 * @see org.variabilitymodeling.cvl.ReplacementFragment#getPlacements()
	 * @see #getReplacementFragment()
	 * @generated
	 */
	EReference getReplacementFragment_Placements();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.PlacementBoundaryElement <em>Placement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placement Boundary Element</em>'.
	 * @see org.variabilitymodeling.cvl.PlacementBoundaryElement
	 * @generated
	 */
	EClass getPlacementBoundaryElement();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ReplacementBoundaryElement <em>Replacement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Boundary Element</em>'.
	 * @see org.variabilitymodeling.cvl.ReplacementBoundaryElement
	 * @generated
	 */
	EClass getReplacementBoundaryElement();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.FromPlacement <em>From Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Placement</em>'.
	 * @see org.variabilitymodeling.cvl.FromPlacement
	 * @generated
	 */
	EClass getFromPlacement();

	/**
	 * Returns the meta object for the reference list '{@link org.variabilitymodeling.cvl.FromPlacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outside Boundary Element</em>'.
	 * @see org.variabilitymodeling.cvl.FromPlacement#getOutsideBoundaryElement()
	 * @see #getFromPlacement()
	 * @generated
	 */
	EReference getFromPlacement_OutsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.FromPlacement#getReplacementBoundaryElement <em>Replacement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Replacement Boundary Element</em>'.
	 * @see org.variabilitymodeling.cvl.FromPlacement#getReplacementBoundaryElement()
	 * @see #getFromPlacement()
	 * @generated
	 */
	EReference getFromPlacement_ReplacementBoundaryElement();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ToPlacement <em>To Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Placement</em>'.
	 * @see org.variabilitymodeling.cvl.ToPlacement
	 * @generated
	 */
	EClass getToPlacement();

	/**
	 * Returns the meta object for the attribute '{@link org.variabilitymodeling.cvl.ToPlacement#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.variabilitymodeling.cvl.ToPlacement#getPropertyName()
	 * @see #getToPlacement()
	 * @generated
	 */
	EAttribute getToPlacement_PropertyName();

	/**
	 * Returns the meta object for the reference list '{@link org.variabilitymodeling.cvl.ToPlacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inside Boundary Element</em>'.
	 * @see org.variabilitymodeling.cvl.ToPlacement#getInsideBoundaryElement()
	 * @see #getToPlacement()
	 * @generated
	 */
	EReference getToPlacement_InsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.ToPlacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outside Boundary Element</em>'.
	 * @see org.variabilitymodeling.cvl.ToPlacement#getOutsideBoundaryElement()
	 * @see #getToPlacement()
	 * @generated
	 */
	EReference getToPlacement_OutsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.ToPlacement#getOutsideRef <em>Outside Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outside Ref</em>'.
	 * @see org.variabilitymodeling.cvl.ToPlacement#getOutsideRef()
	 * @see #getToPlacement()
	 * @generated
	 */
	EReference getToPlacement_OutsideRef();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ToReplacement <em>To Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Replacement</em>'.
	 * @see org.variabilitymodeling.cvl.ToReplacement
	 * @generated
	 */
	EClass getToReplacement();

	/**
	 * Returns the meta object for the reference list '{@link org.variabilitymodeling.cvl.ToReplacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inside Boundary Element</em>'.
	 * @see org.variabilitymodeling.cvl.ToReplacement#getInsideBoundaryElement()
	 * @see #getToReplacement()
	 * @generated
	 */
	EReference getToReplacement_InsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.ToReplacement#getPlacementBoundaryElement <em>Placement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Placement Boundary Element</em>'.
	 * @see org.variabilitymodeling.cvl.ToReplacement#getPlacementBoundaryElement()
	 * @see #getToReplacement()
	 * @generated
	 */
	EReference getToReplacement_PlacementBoundaryElement();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.FromReplacement <em>From Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Replacement</em>'.
	 * @see org.variabilitymodeling.cvl.FromReplacement
	 * @generated
	 */
	EClass getFromReplacement();

	/**
	 * Returns the meta object for the attribute '{@link org.variabilitymodeling.cvl.FromReplacement#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.variabilitymodeling.cvl.FromReplacement#getPropertyName()
	 * @see #getFromReplacement()
	 * @generated
	 */
	EAttribute getFromReplacement_PropertyName();

	/**
	 * Returns the meta object for the reference list '{@link org.variabilitymodeling.cvl.FromReplacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outside Boundary Element</em>'.
	 * @see org.variabilitymodeling.cvl.FromReplacement#getOutsideBoundaryElement()
	 * @see #getFromReplacement()
	 * @generated
	 */
	EReference getFromReplacement_OutsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.FromReplacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inside Boundary Element</em>'.
	 * @see org.variabilitymodeling.cvl.FromReplacement#getInsideBoundaryElement()
	 * @see #getFromReplacement()
	 * @generated
	 */
	EReference getFromReplacement_InsideBoundaryElement();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.FromReplacement#getInsideRef <em>Inside Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inside Ref</em>'.
	 * @see org.variabilitymodeling.cvl.FromReplacement#getInsideRef()
	 * @see #getFromReplacement()
	 * @generated
	 */
	EReference getFromReplacement_InsideRef();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.CVLElement <em>CVL Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVL Element</em>'.
	 * @see org.variabilitymodeling.cvl.CVLElement
	 * @generated
	 */
	EClass getCVLElement();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.BoundaryElementBinding <em>Boundary Element Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boundary Element Binding</em>'.
	 * @see org.variabilitymodeling.cvl.BoundaryElementBinding
	 * @generated
	 */
	EClass getBoundaryElementBinding();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ToBinding <em>To Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Binding</em>'.
	 * @see org.variabilitymodeling.cvl.ToBinding
	 * @generated
	 */
	EClass getToBinding();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.ToBinding#getToPlacement <em>To Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Placement</em>'.
	 * @see org.variabilitymodeling.cvl.ToBinding#getToPlacement()
	 * @see #getToBinding()
	 * @generated
	 */
	EReference getToBinding_ToPlacement();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.ToBinding#getToReplacement <em>To Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Replacement</em>'.
	 * @see org.variabilitymodeling.cvl.ToBinding#getToReplacement()
	 * @see #getToBinding()
	 * @generated
	 */
	EReference getToBinding_ToReplacement();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.FromBinding <em>From Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Binding</em>'.
	 * @see org.variabilitymodeling.cvl.FromBinding
	 * @generated
	 */
	EClass getFromBinding();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.FromBinding#getFromPlacement <em>From Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Placement</em>'.
	 * @see org.variabilitymodeling.cvl.FromBinding#getFromPlacement()
	 * @see #getFromBinding()
	 * @generated
	 */
	EReference getFromBinding_FromPlacement();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.FromBinding#getFromReplacement <em>From Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Replacement</em>'.
	 * @see org.variabilitymodeling.cvl.FromBinding#getFromReplacement()
	 * @see #getFromBinding()
	 * @generated
	 */
	EReference getFromBinding_FromReplacement();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.CompositeVariability <em>Composite Variability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Variability</em>'.
	 * @see org.variabilitymodeling.cvl.CompositeVariability
	 * @generated
	 */
	EClass getCompositeVariability();

	/**
	 * Returns the meta object for the containment reference list '{@link org.variabilitymodeling.cvl.CompositeVariability#getVariabilitySpecification <em>Variability Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variability Specification</em>'.
	 * @see org.variabilitymodeling.cvl.CompositeVariability#getVariabilitySpecification()
	 * @see #getCompositeVariability()
	 * @generated
	 */
	EReference getCompositeVariability_VariabilitySpecification();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.VariabilitySpecification <em>Variability Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variability Specification</em>'.
	 * @see org.variabilitymodeling.cvl.VariabilitySpecification
	 * @generated
	 */
	EClass getVariabilitySpecification();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.CVLNamedElement <em>CVL Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVL Named Element</em>'.
	 * @see org.variabilitymodeling.cvl.CVLNamedElement
	 * @generated
	 */
	EClass getCVLNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.variabilitymodeling.cvl.CVLNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.variabilitymodeling.cvl.CVLNamedElement#getName()
	 * @see #getCVLNamedElement()
	 * @generated
	 */
	EAttribute getCVLNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.PlacementLiteral <em>Placement Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placement Literal</em>'.
	 * @see org.variabilitymodeling.cvl.PlacementLiteral
	 * @generated
	 */
	EClass getPlacementLiteral();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ReplacementLiteral <em>Replacement Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Literal</em>'.
	 * @see org.variabilitymodeling.cvl.ReplacementLiteral
	 * @generated
	 */
	EClass getReplacementLiteral();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.PlacementValue <em>Placement Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placement Value</em>'.
	 * @see org.variabilitymodeling.cvl.PlacementValue
	 * @generated
	 */
	EClass getPlacementValue();

	/**
	 * Returns the meta object for the attribute '{@link org.variabilitymodeling.cvl.PlacementValue#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.variabilitymodeling.cvl.PlacementValue#getPropertyName()
	 * @see #getPlacementValue()
	 * @generated
	 */
	EAttribute getPlacementValue_PropertyName();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.PlacementValue#getTargetObject <em>Target Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Object</em>'.
	 * @see org.variabilitymodeling.cvl.PlacementValue#getTargetObject()
	 * @see #getPlacementValue()
	 * @generated
	 */
	EReference getPlacementValue_TargetObject();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.PlacementObject <em>Placement Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placement Object</em>'.
	 * @see org.variabilitymodeling.cvl.PlacementObject
	 * @generated
	 */
	EClass getPlacementObject();

	/**
	 * Returns the meta object for the attribute '{@link org.variabilitymodeling.cvl.PlacementObject#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.variabilitymodeling.cvl.PlacementObject#getPropertyName()
	 * @see #getPlacementObject()
	 * @generated
	 */
	EAttribute getPlacementObject_PropertyName();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.PlacementObject#getTargetObject <em>Target Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Object</em>'.
	 * @see org.variabilitymodeling.cvl.PlacementObject#getTargetObject()
	 * @see #getPlacementObject()
	 * @generated
	 */
	EReference getPlacementObject_TargetObject();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.PlacementObject#getReferredObject <em>Referred Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Object</em>'.
	 * @see org.variabilitymodeling.cvl.PlacementObject#getReferredObject()
	 * @see #getPlacementObject()
	 * @generated
	 */
	EReference getPlacementObject_ReferredObject();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ReplacementValue <em>Replacement Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Value</em>'.
	 * @see org.variabilitymodeling.cvl.ReplacementValue
	 * @generated
	 */
	EClass getReplacementValue();

	/**
	 * Returns the meta object for the attribute '{@link org.variabilitymodeling.cvl.ReplacementValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.variabilitymodeling.cvl.ReplacementValue#getValue()
	 * @see #getReplacementValue()
	 * @generated
	 */
	EAttribute getReplacementValue_Value();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ReplacementObject <em>Replacement Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Object</em>'.
	 * @see org.variabilitymodeling.cvl.ReplacementObject
	 * @generated
	 */
	EClass getReplacementObject();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.ReplacementObject#getTargetObject <em>Target Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Object</em>'.
	 * @see org.variabilitymodeling.cvl.ReplacementObject#getTargetObject()
	 * @see #getReplacementObject()
	 * @generated
	 */
	EReference getReplacementObject_TargetObject();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ResolutionSpecification <em>Resolution Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolution Specification</em>'.
	 * @see org.variabilitymodeling.cvl.ResolutionSpecification
	 * @generated
	 */
	EClass getResolutionSpecification();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ResolutionElement <em>Resolution Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolution Element</em>'.
	 * @see org.variabilitymodeling.cvl.ResolutionElement
	 * @generated
	 */
	EClass getResolutionElement();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.ResolutionElement#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.variabilitymodeling.cvl.ResolutionElement#getElement()
	 * @see #getResolutionElement()
	 * @generated
	 */
	EReference getResolutionElement_Element();

	/**
	 * Returns the meta object for the containment reference list '{@link org.variabilitymodeling.cvl.ResolutionElement#getResolution <em>Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resolution</em>'.
	 * @see org.variabilitymodeling.cvl.ResolutionElement#getResolution()
	 * @see #getResolutionElement()
	 * @generated
	 */
	EReference getResolutionElement_Resolution();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.variabilitymodeling.cvl.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the containment reference '{@link org.variabilitymodeling.cvl.Type#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.variabilitymodeling.cvl.Type#getBody()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.variabilitymodeling.cvl.Type#getReplacement <em>Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Replacement</em>'.
	 * @see org.variabilitymodeling.cvl.Type#getReplacement()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_Replacement();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.Invocation <em>Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invocation</em>'.
	 * @see org.variabilitymodeling.cvl.Invocation
	 * @generated
	 */
	EClass getInvocation();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.Invocation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.variabilitymodeling.cvl.Invocation#getType()
	 * @see #getInvocation()
	 * @generated
	 */
	EReference getInvocation_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.variabilitymodeling.cvl.Invocation#getResolutionSpecification <em>Resolution Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resolution Specification</em>'.
	 * @see org.variabilitymodeling.cvl.Invocation#getResolutionSpecification()
	 * @see #getInvocation()
	 * @generated
	 */
	EReference getInvocation_ResolutionSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.Invocation#getRfRef <em>Rf Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rf Ref</em>'.
	 * @see org.variabilitymodeling.cvl.Invocation#getRfRef()
	 * @see #getInvocation()
	 * @generated
	 */
	EReference getInvocation_RfRef();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.IteratorResolution <em>Iterator Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Resolution</em>'.
	 * @see org.variabilitymodeling.cvl.IteratorResolution
	 * @generated
	 */
	EClass getIteratorResolution();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.IteratorResolution#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Iterator</em>'.
	 * @see org.variabilitymodeling.cvl.IteratorResolution#getIterator()
	 * @see #getIteratorResolution()
	 * @generated
	 */
	EReference getIteratorResolution_Iterator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.variabilitymodeling.cvl.IteratorResolution#getChoice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Choice</em>'.
	 * @see org.variabilitymodeling.cvl.IteratorResolution#getChoice()
	 * @see #getIteratorResolution()
	 * @generated
	 */
	EReference getIteratorResolution_Choice();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.Iterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator</em>'.
	 * @see org.variabilitymodeling.cvl.Iterator
	 * @generated
	 */
	EClass getIterator();

	/**
	 * Returns the meta object for the attribute '{@link org.variabilitymodeling.cvl.Iterator#getUpperLimit <em>Upper Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Limit</em>'.
	 * @see org.variabilitymodeling.cvl.Iterator#getUpperLimit()
	 * @see #getIterator()
	 * @generated
	 */
	EAttribute getIterator_UpperLimit();

	/**
	 * Returns the meta object for the attribute '{@link org.variabilitymodeling.cvl.Iterator#getLowerLimit <em>Lower Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Limit</em>'.
	 * @see org.variabilitymodeling.cvl.Iterator#getLowerLimit()
	 * @see #getIterator()
	 * @generated
	 */
	EAttribute getIterator_LowerLimit();

	/**
	 * Returns the meta object for the attribute '{@link org.variabilitymodeling.cvl.Iterator#isIsUnique <em>Is Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unique</em>'.
	 * @see org.variabilitymodeling.cvl.Iterator#isIsUnique()
	 * @see #getIterator()
	 * @generated
	 */
	EAttribute getIterator_IsUnique();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ReplacementFragmentReference <em>Replacement Fragment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Fragment Reference</em>'.
	 * @see org.variabilitymodeling.cvl.ReplacementFragmentReference
	 * @generated
	 */
	EClass getReplacementFragmentReference();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.ReplacementFragmentReference#getRfRef <em>Rf Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rf Ref</em>'.
	 * @see org.variabilitymodeling.cvl.ReplacementFragmentReference#getRfRef()
	 * @see #getReplacementFragmentReference()
	 * @generated
	 */
	EReference getReplacementFragmentReference_RfRef();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ReplacementFragmentAbstract <em>Replacement Fragment Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Fragment Abstract</em>'.
	 * @see org.variabilitymodeling.cvl.ReplacementFragmentAbstract
	 * @generated
	 */
	EClass getReplacementFragmentAbstract();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.variabilitymodeling.cvl.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.Assignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.variabilitymodeling.cvl.Assignment#getValue()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Value();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.Assignment#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.variabilitymodeling.cvl.Assignment#getTarget()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Target();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.Declaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declaration</em>'.
	 * @see org.variabilitymodeling.cvl.Declaration
	 * @generated
	 */
	EClass getDeclaration();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ExecutablePrimitive <em>Executable Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Executable Primitive</em>'.
	 * @see org.variabilitymodeling.cvl.ExecutablePrimitive
	 * @generated
	 */
	EClass getExecutablePrimitive();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.variabilitymodeling.cvl.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.NOT <em>NOT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NOT</em>'.
	 * @see org.variabilitymodeling.cvl.NOT
	 * @generated
	 */
	EClass getNOT();

	/**
	 * Returns the meta object for the containment reference '{@link org.variabilitymodeling.cvl.NOT#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see org.variabilitymodeling.cvl.NOT#getTerm()
	 * @see #getNOT()
	 * @generated
	 */
	EReference getNOT_Term();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.OR <em>OR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OR</em>'.
	 * @see org.variabilitymodeling.cvl.OR
	 * @generated
	 */
	EClass getOR();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.IMPLIES <em>IMPLIES</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IMPLIES</em>'.
	 * @see org.variabilitymodeling.cvl.IMPLIES
	 * @generated
	 */
	EClass getIMPLIES();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ExecutablePrimitiveTerm <em>Executable Primitive Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Executable Primitive Term</em>'.
	 * @see org.variabilitymodeling.cvl.ExecutablePrimitiveTerm
	 * @generated
	 */
	EClass getExecutablePrimitiveTerm();

	/**
	 * Returns the meta object for the reference '{@link org.variabilitymodeling.cvl.ExecutablePrimitiveTerm#getPrimitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primitive</em>'.
	 * @see org.variabilitymodeling.cvl.ExecutablePrimitiveTerm#getPrimitive()
	 * @see #getExecutablePrimitiveTerm()
	 * @generated
	 */
	EReference getExecutablePrimitiveTerm_Primitive();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.AND_ <em>AND </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AND </em>'.
	 * @see org.variabilitymodeling.cvl.AND_
	 * @generated
	 */
	EClass getAND_();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.Binary <em>Binary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary</em>'.
	 * @see org.variabilitymodeling.cvl.Binary
	 * @generated
	 */
	EClass getBinary();

	/**
	 * Returns the meta object for the containment reference '{@link org.variabilitymodeling.cvl.Binary#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.variabilitymodeling.cvl.Binary#getLeft()
	 * @see #getBinary()
	 * @generated
	 */
	EReference getBinary_Left();

	/**
	 * Returns the meta object for the containment reference '{@link org.variabilitymodeling.cvl.Binary#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.variabilitymodeling.cvl.Binary#getRight()
	 * @see #getBinary()
	 * @generated
	 */
	EReference getBinary_Right();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.ResolutionValue <em>Resolution Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolution Value</em>'.
	 * @see org.variabilitymodeling.cvl.ResolutionValue
	 * @generated
	 */
	EClass getResolutionValue();

	/**
	 * Returns the meta object for the attribute '{@link org.variabilitymodeling.cvl.ResolutionValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.variabilitymodeling.cvl.ResolutionValue#getValue()
	 * @see #getResolutionValue()
	 * @generated
	 */
	EAttribute getResolutionValue_Value();

	/**
	 * Returns the meta object for enum '{@link org.variabilitymodeling.cvl.PlacementFragmentUsage <em>Placement Fragment Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Placement Fragment Usage</em>'.
	 * @see org.variabilitymodeling.cvl.PlacementFragmentUsage
	 * @generated
	 */
	EEnum getPlacementFragmentUsage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CvlFactory getCvlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.CVLModelImpl <em>CVL Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.CVLModelImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getCVLModel()
		 * @generated
		 */
		EClass CVL_MODEL = eINSTANCE.getCVLModel();

		/**
		 * The meta object literal for the '<em><b>Variability Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CVL_MODEL__VARIABILITY_SPECIFICATION = eINSTANCE.getCVLModel_VariabilitySpecification();

		/**
		 * The meta object literal for the '<em><b>Resolution Specification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CVL_MODEL__RESOLUTION_SPECIFICATION = eINSTANCE.getCVLModel_ResolutionSpecification();

		/**
		 * The meta object literal for the '<em><b>Base</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CVL_MODEL__BASE = eINSTANCE.getCVLModel_Base();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.SubstitutionImpl <em>Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.SubstitutionImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getSubstitution()
		 * @generated
		 */
		EClass SUBSTITUTION = eINSTANCE.getSubstitution();

		/**
		 * The meta object literal for the '<em><b>Replacement Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSTITUTION__REPLACEMENT_INSTANCE = eINSTANCE.getSubstitution_ReplacementInstance();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ReferenceSubstitutionImpl <em>Reference Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ReferenceSubstitutionImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReferenceSubstitution()
		 * @generated
		 */
		EClass REFERENCE_SUBSTITUTION = eINSTANCE.getReferenceSubstitution();

		/**
		 * The meta object literal for the '<em><b>Placement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_SUBSTITUTION__PLACEMENT = eINSTANCE.getReferenceSubstitution_Placement();

		/**
		 * The meta object literal for the '<em><b>Replacement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_SUBSTITUTION__REPLACEMENT = eINSTANCE.getReferenceSubstitution_Replacement();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ValueSubstitutionImpl <em>Value Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ValueSubstitutionImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getValueSubstitution()
		 * @generated
		 */
		EClass VALUE_SUBSTITUTION = eINSTANCE.getValueSubstitution();

		/**
		 * The meta object literal for the '<em><b>Placement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_SUBSTITUTION__PLACEMENT = eINSTANCE.getValueSubstitution_Placement();

		/**
		 * The meta object literal for the '<em><b>Replacement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_SUBSTITUTION__REPLACEMENT = eINSTANCE.getValueSubstitution_Replacement();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.FragmentSubstitutionImpl <em>Fragment Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.FragmentSubstitutionImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getFragmentSubstitution()
		 * @generated
		 */
		EClass FRAGMENT_SUBSTITUTION = eINSTANCE.getFragmentSubstitution();

		/**
		 * The meta object literal for the '<em><b>Placement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT_SUBSTITUTION__PLACEMENT = eINSTANCE.getFragmentSubstitution_Placement();

		/**
		 * The meta object literal for the '<em><b>Replacement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT_SUBSTITUTION__REPLACEMENT = eINSTANCE.getFragmentSubstitution_Replacement();

		/**
		 * The meta object literal for the '<em><b>Rf Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT_SUBSTITUTION__RF_REF = eINSTANCE.getFragmentSubstitution_RfRef();

		/**
		 * The meta object literal for the '<em><b>Boundary Element Binding</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING = eINSTANCE.getFragmentSubstitution_BoundaryElementBinding();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.PlacementFragmentImpl <em>Placement Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.PlacementFragmentImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getPlacementFragment()
		 * @generated
		 */
		EClass PLACEMENT_FRAGMENT = eINSTANCE.getPlacementFragment();

		/**
		 * The meta object literal for the '<em><b>Boundary Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACEMENT_FRAGMENT__BOUNDARY_ELEMENT = eINSTANCE.getPlacementFragment_BoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Usage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACEMENT_FRAGMENT__USAGE = eINSTANCE.getPlacementFragment_Usage();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ReplacementFragmentImpl <em>Replacement Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ReplacementFragmentImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementFragment()
		 * @generated
		 */
		EClass REPLACEMENT_FRAGMENT = eINSTANCE.getReplacementFragment();

		/**
		 * The meta object literal for the '<em><b>Boundary Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACEMENT_FRAGMENT__BOUNDARY_ELEMENT = eINSTANCE.getReplacementFragment_BoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Placements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACEMENT_FRAGMENT__PLACEMENTS = eINSTANCE.getReplacementFragment_Placements();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.PlacementBoundaryElementImpl <em>Placement Boundary Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.PlacementBoundaryElementImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getPlacementBoundaryElement()
		 * @generated
		 */
		EClass PLACEMENT_BOUNDARY_ELEMENT = eINSTANCE.getPlacementBoundaryElement();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ReplacementBoundaryElementImpl <em>Replacement Boundary Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ReplacementBoundaryElementImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementBoundaryElement()
		 * @generated
		 */
		EClass REPLACEMENT_BOUNDARY_ELEMENT = eINSTANCE.getReplacementBoundaryElement();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.FromPlacementImpl <em>From Placement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.FromPlacementImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getFromPlacement()
		 * @generated
		 */
		EClass FROM_PLACEMENT = eINSTANCE.getFromPlacement();

		/**
		 * The meta object literal for the '<em><b>Outside Boundary Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = eINSTANCE.getFromPlacement_OutsideBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Replacement Boundary Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT = eINSTANCE.getFromPlacement_ReplacementBoundaryElement();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ToPlacementImpl <em>To Placement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ToPlacementImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getToPlacement()
		 * @generated
		 */
		EClass TO_PLACEMENT = eINSTANCE.getToPlacement();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TO_PLACEMENT__PROPERTY_NAME = eINSTANCE.getToPlacement_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Inside Boundary Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT = eINSTANCE.getToPlacement_InsideBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Outside Boundary Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = eINSTANCE.getToPlacement_OutsideBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Outside Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_PLACEMENT__OUTSIDE_REF = eINSTANCE.getToPlacement_OutsideRef();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ToReplacementImpl <em>To Replacement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ToReplacementImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getToReplacement()
		 * @generated
		 */
		EClass TO_REPLACEMENT = eINSTANCE.getToReplacement();

		/**
		 * The meta object literal for the '<em><b>Inside Boundary Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT = eINSTANCE.getToReplacement_InsideBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Placement Boundary Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT = eINSTANCE.getToReplacement_PlacementBoundaryElement();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.FromReplacementImpl <em>From Replacement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.FromReplacementImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getFromReplacement()
		 * @generated
		 */
		EClass FROM_REPLACEMENT = eINSTANCE.getFromReplacement();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FROM_REPLACEMENT__PROPERTY_NAME = eINSTANCE.getFromReplacement_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Outside Boundary Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT = eINSTANCE.getFromReplacement_OutsideBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Inside Boundary Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT = eINSTANCE.getFromReplacement_InsideBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Inside Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_REPLACEMENT__INSIDE_REF = eINSTANCE.getFromReplacement_InsideRef();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.CVLElementImpl <em>CVL Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.CVLElementImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getCVLElement()
		 * @generated
		 */
		EClass CVL_ELEMENT = eINSTANCE.getCVLElement();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.BoundaryElementBindingImpl <em>Boundary Element Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.BoundaryElementBindingImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getBoundaryElementBinding()
		 * @generated
		 */
		EClass BOUNDARY_ELEMENT_BINDING = eINSTANCE.getBoundaryElementBinding();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ToBindingImpl <em>To Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ToBindingImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getToBinding()
		 * @generated
		 */
		EClass TO_BINDING = eINSTANCE.getToBinding();

		/**
		 * The meta object literal for the '<em><b>To Placement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_BINDING__TO_PLACEMENT = eINSTANCE.getToBinding_ToPlacement();

		/**
		 * The meta object literal for the '<em><b>To Replacement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_BINDING__TO_REPLACEMENT = eINSTANCE.getToBinding_ToReplacement();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.FromBindingImpl <em>From Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.FromBindingImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getFromBinding()
		 * @generated
		 */
		EClass FROM_BINDING = eINSTANCE.getFromBinding();

		/**
		 * The meta object literal for the '<em><b>From Placement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_BINDING__FROM_PLACEMENT = eINSTANCE.getFromBinding_FromPlacement();

		/**
		 * The meta object literal for the '<em><b>From Replacement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_BINDING__FROM_REPLACEMENT = eINSTANCE.getFromBinding_FromReplacement();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.CompositeVariabilityImpl <em>Composite Variability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.CompositeVariabilityImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getCompositeVariability()
		 * @generated
		 */
		EClass COMPOSITE_VARIABILITY = eINSTANCE.getCompositeVariability();

		/**
		 * The meta object literal for the '<em><b>Variability Specification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_VARIABILITY__VARIABILITY_SPECIFICATION = eINSTANCE.getCompositeVariability_VariabilitySpecification();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.VariabilitySpecificationImpl <em>Variability Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.VariabilitySpecificationImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getVariabilitySpecification()
		 * @generated
		 */
		EClass VARIABILITY_SPECIFICATION = eINSTANCE.getVariabilitySpecification();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.CVLNamedElementImpl <em>CVL Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.CVLNamedElementImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getCVLNamedElement()
		 * @generated
		 */
		EClass CVL_NAMED_ELEMENT = eINSTANCE.getCVLNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVL_NAMED_ELEMENT__NAME = eINSTANCE.getCVLNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.PlacementLiteralImpl <em>Placement Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.PlacementLiteralImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getPlacementLiteral()
		 * @generated
		 */
		EClass PLACEMENT_LITERAL = eINSTANCE.getPlacementLiteral();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ReplacementLiteralImpl <em>Replacement Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ReplacementLiteralImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementLiteral()
		 * @generated
		 */
		EClass REPLACEMENT_LITERAL = eINSTANCE.getReplacementLiteral();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.PlacementValueImpl <em>Placement Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.PlacementValueImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getPlacementValue()
		 * @generated
		 */
		EClass PLACEMENT_VALUE = eINSTANCE.getPlacementValue();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACEMENT_VALUE__PROPERTY_NAME = eINSTANCE.getPlacementValue_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Target Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACEMENT_VALUE__TARGET_OBJECT = eINSTANCE.getPlacementValue_TargetObject();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.PlacementObjectImpl <em>Placement Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.PlacementObjectImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getPlacementObject()
		 * @generated
		 */
		EClass PLACEMENT_OBJECT = eINSTANCE.getPlacementObject();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACEMENT_OBJECT__PROPERTY_NAME = eINSTANCE.getPlacementObject_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Target Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACEMENT_OBJECT__TARGET_OBJECT = eINSTANCE.getPlacementObject_TargetObject();

		/**
		 * The meta object literal for the '<em><b>Referred Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACEMENT_OBJECT__REFERRED_OBJECT = eINSTANCE.getPlacementObject_ReferredObject();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ReplacementValueImpl <em>Replacement Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ReplacementValueImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementValue()
		 * @generated
		 */
		EClass REPLACEMENT_VALUE = eINSTANCE.getReplacementValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPLACEMENT_VALUE__VALUE = eINSTANCE.getReplacementValue_Value();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ReplacementObjectImpl <em>Replacement Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ReplacementObjectImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementObject()
		 * @generated
		 */
		EClass REPLACEMENT_OBJECT = eINSTANCE.getReplacementObject();

		/**
		 * The meta object literal for the '<em><b>Target Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACEMENT_OBJECT__TARGET_OBJECT = eINSTANCE.getReplacementObject_TargetObject();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ResolutionSpecificationImpl <em>Resolution Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ResolutionSpecificationImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getResolutionSpecification()
		 * @generated
		 */
		EClass RESOLUTION_SPECIFICATION = eINSTANCE.getResolutionSpecification();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ResolutionElementImpl <em>Resolution Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ResolutionElementImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getResolutionElement()
		 * @generated
		 */
		EClass RESOLUTION_ELEMENT = eINSTANCE.getResolutionElement();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLUTION_ELEMENT__ELEMENT = eINSTANCE.getResolutionElement_Element();

		/**
		 * The meta object literal for the '<em><b>Resolution</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLUTION_ELEMENT__RESOLUTION = eINSTANCE.getResolutionElement_Resolution();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.TypeImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__BODY = eINSTANCE.getType_Body();

		/**
		 * The meta object literal for the '<em><b>Replacement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__REPLACEMENT = eINSTANCE.getType_Replacement();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.InvocationImpl <em>Invocation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.InvocationImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getInvocation()
		 * @generated
		 */
		EClass INVOCATION = eINSTANCE.getInvocation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCATION__TYPE = eINSTANCE.getInvocation_Type();

		/**
		 * The meta object literal for the '<em><b>Resolution Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCATION__RESOLUTION_SPECIFICATION = eINSTANCE.getInvocation_ResolutionSpecification();

		/**
		 * The meta object literal for the '<em><b>Rf Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCATION__RF_REF = eINSTANCE.getInvocation_RfRef();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.IteratorResolutionImpl <em>Iterator Resolution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.IteratorResolutionImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getIteratorResolution()
		 * @generated
		 */
		EClass ITERATOR_RESOLUTION = eINSTANCE.getIteratorResolution();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_RESOLUTION__ITERATOR = eINSTANCE.getIteratorResolution_Iterator();

		/**
		 * The meta object literal for the '<em><b>Choice</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_RESOLUTION__CHOICE = eINSTANCE.getIteratorResolution_Choice();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.IteratorImpl <em>Iterator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.IteratorImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getIterator()
		 * @generated
		 */
		EClass ITERATOR = eINSTANCE.getIterator();

		/**
		 * The meta object literal for the '<em><b>Upper Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATOR__UPPER_LIMIT = eINSTANCE.getIterator_UpperLimit();

		/**
		 * The meta object literal for the '<em><b>Lower Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATOR__LOWER_LIMIT = eINSTANCE.getIterator_LowerLimit();

		/**
		 * The meta object literal for the '<em><b>Is Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATOR__IS_UNIQUE = eINSTANCE.getIterator_IsUnique();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ReplacementFragmentReferenceImpl <em>Replacement Fragment Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ReplacementFragmentReferenceImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementFragmentReference()
		 * @generated
		 */
		EClass REPLACEMENT_FRAGMENT_REFERENCE = eINSTANCE.getReplacementFragmentReference();

		/**
		 * The meta object literal for the '<em><b>Rf Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACEMENT_FRAGMENT_REFERENCE__RF_REF = eINSTANCE.getReplacementFragmentReference_RfRef();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ReplacementFragmentAbstractImpl <em>Replacement Fragment Abstract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ReplacementFragmentAbstractImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getReplacementFragmentAbstract()
		 * @generated
		 */
		EClass REPLACEMENT_FRAGMENT_ABSTRACT = eINSTANCE.getReplacementFragmentAbstract();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.AssignmentImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__TARGET = eINSTANCE.getAssignment_Target();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.DeclarationImpl <em>Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.DeclarationImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getDeclaration()
		 * @generated
		 */
		EClass DECLARATION = eINSTANCE.getDeclaration();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ExecutablePrimitiveImpl <em>Executable Primitive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ExecutablePrimitiveImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getExecutablePrimitive()
		 * @generated
		 */
		EClass EXECUTABLE_PRIMITIVE = eINSTANCE.getExecutablePrimitive();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ConstraintImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.NOTImpl <em>NOT</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.NOTImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getNOT()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNOT();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT__TERM = eINSTANCE.getNOT_Term();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ORImpl <em>OR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ORImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getOR()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOR();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.IMPLIESImpl <em>IMPLIES</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.IMPLIESImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getIMPLIES()
		 * @generated
		 */
		EClass IMPLIES = eINSTANCE.getIMPLIES();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ExecutablePrimitiveTermImpl <em>Executable Primitive Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ExecutablePrimitiveTermImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getExecutablePrimitiveTerm()
		 * @generated
		 */
		EClass EXECUTABLE_PRIMITIVE_TERM = eINSTANCE.getExecutablePrimitiveTerm();

		/**
		 * The meta object literal for the '<em><b>Primitive</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTABLE_PRIMITIVE_TERM__PRIMITIVE = eINSTANCE.getExecutablePrimitiveTerm_Primitive();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.AND_Impl <em>AND </em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.AND_Impl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getAND_()
		 * @generated
		 */
		EClass AND_ = eINSTANCE.getAND_();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.BinaryImpl <em>Binary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.BinaryImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getBinary()
		 * @generated
		 */
		EClass BINARY = eINSTANCE.getBinary();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY__LEFT = eINSTANCE.getBinary_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY__RIGHT = eINSTANCE.getBinary_Right();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.impl.ResolutionValueImpl <em>Resolution Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.impl.ResolutionValueImpl
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getResolutionValue()
		 * @generated
		 */
		EClass RESOLUTION_VALUE = eINSTANCE.getResolutionValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOLUTION_VALUE__VALUE = eINSTANCE.getResolutionValue_Value();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.PlacementFragmentUsage <em>Placement Fragment Usage</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.PlacementFragmentUsage
		 * @see org.variabilitymodeling.cvl.impl.CvlPackageImpl#getPlacementFragmentUsage()
		 * @generated
		 */
		EEnum PLACEMENT_FRAGMENT_USAGE = eINSTANCE.getPlacementFragmentUsage();

	}

} //CvlPackage
