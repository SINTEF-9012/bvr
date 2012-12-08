/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.visitors.impl;




import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.variabilitymodeling.cvl.CvlPackage;
import org.variabilitymodeling.cvl.impl.CvlPackageImpl;
import org.variabilitymodeling.cvl.visitors.TopDownVisitor;
import org.variabilitymodeling.cvl.visitors.Visitable;
import org.variabilitymodeling.cvl.visitors.Visitor;
import org.variabilitymodeling.cvl.visitors.VisitorsFactory;
import org.variabilitymodeling.cvl.visitors.VisitorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisitorsPackageImpl extends EPackageImpl implements VisitorsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topDownVisitorEClass = null;

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
	 * @see org.variabilitymodeling.cvl.visitors.VisitorsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VisitorsPackageImpl() {
		super(eNS_URI, VisitorsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link VisitorsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VisitorsPackage init() {
		if (isInited) return (VisitorsPackage)EPackage.Registry.INSTANCE.getEPackage(VisitorsPackage.eNS_URI);

		// Obtain or create and register package
		VisitorsPackageImpl theVisitorsPackage = (VisitorsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VisitorsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VisitorsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		CvlPackageImpl theCvlPackage = (CvlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CvlPackage.eNS_URI) instanceof CvlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CvlPackage.eNS_URI) : CvlPackage.eINSTANCE);

		// Create package meta-data objects
		theVisitorsPackage.createPackageContents();
		theCvlPackage.createPackageContents();

		// Initialize created meta-data
		theVisitorsPackage.initializePackageContents();
		theCvlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVisitorsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VisitorsPackage.eNS_URI, theVisitorsPackage);
		return theVisitorsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitable() {
		return visitableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitor() {
		return visitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopDownVisitor() {
		return topDownVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitorsFactory getVisitorsFactory() {
		return (VisitorsFactory)getEFactoryInstance();
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
		visitableEClass = createEClass(VISITABLE);

		visitorEClass = createEClass(VISITOR);

		topDownVisitorEClass = createEClass(TOP_DOWN_VISITOR);
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
		CvlPackage theCvlPackage = (CvlPackage)EPackage.Registry.INSTANCE.getEPackage(CvlPackage.eNS_URI);

		// Create type parameters
		ETypeParameter visitorEClass_ContextType = addETypeParameter(visitorEClass, "ContextType");
		ETypeParameter visitorEClass_ResultType = addETypeParameter(visitorEClass, "ResultType");
		ETypeParameter topDownVisitorEClass_ContextType = addETypeParameter(topDownVisitorEClass, "ContextType");
		ETypeParameter topDownVisitorEClass_ResultType = addETypeParameter(topDownVisitorEClass, "ResultType");

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getVisitor());
		EGenericType g2 = createEGenericType(topDownVisitorEClass_ContextType);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(topDownVisitorEClass_ResultType);
		g1.getETypeArguments().add(g2);
		topDownVisitorEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(visitableEClass, Visitable.class, "Visitable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(visitableEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "C");
		ETypeParameter t2 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(visitorEClass, Visitor.class, "Visitor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(visitorEClass, null, "visitCVLModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getCVLModel(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitReferenceSubstitution", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getReferenceSubstitution(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitValueSubstitution", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getValueSubstitution(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitFragmentSubstitution", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getFragmentSubstitution(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitPlacementFragment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getPlacementFragment(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitReplacementFragment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getReplacementFragment(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitFromPlacement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getFromPlacement(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitToPlacement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getToPlacement(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitToReplacement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getToReplacement(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitFromReplacement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getFromReplacement(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitCVLElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getCVLElement(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitToBinding", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getToBinding(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitFromBinding", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getFromBinding(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitCompositeVariability", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getCompositeVariability(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitPlacementValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getPlacementValue(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitPlacementObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getPlacementObject(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitReplacementValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getReplacementValue(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitReplacementObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getReplacementObject(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitResolutionElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getResolutionElement(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getType(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitInvocation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getInvocation(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitIteratorResolution", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getIteratorResolution(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitIterator", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getIterator(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitReplacementFragmentReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getReplacementFragmentReference(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitAssignment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getAssignment(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getConstraint(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitNOT", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getNOT(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitOR", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getOR(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitIMPLIES", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getIMPLIES(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitExecutablePrimitiveTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getExecutablePrimitiveTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitAND_", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getAND_(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(visitorEClass, null, "visitResolutionValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getResolutionValue(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(visitorEClass_ResultType);
		initEOperation(op, g1);

		initEClass(topDownVisitorEClass, TopDownVisitor.class, "TopDownVisitor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(topDownVisitorEClass, null, "visitCVLModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getCVLModel(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitReferenceSubstitution", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getReferenceSubstitution(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitValueSubstitution", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getValueSubstitution(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitFragmentSubstitution", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getFragmentSubstitution(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitPlacementFragment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getPlacementFragment(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitReplacementFragment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getReplacementFragment(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitFromPlacement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getFromPlacement(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitToPlacement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getToPlacement(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitToReplacement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getToReplacement(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitFromReplacement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getFromReplacement(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitCVLElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getCVLElement(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitToBinding", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getToBinding(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitFromBinding", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getFromBinding(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitCompositeVariability", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getCompositeVariability(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitPlacementValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getPlacementValue(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitPlacementObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getPlacementObject(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitReplacementValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getReplacementValue(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitReplacementObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getReplacementObject(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitResolutionElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getResolutionElement(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getType(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitInvocation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getInvocation(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitIteratorResolution", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getIteratorResolution(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitIterator", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getIterator(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitReplacementFragmentReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getReplacementFragmentReference(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitAssignment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getAssignment(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getConstraint(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitNOT", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getNOT(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitOR", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getOR(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitIMPLIES", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getIMPLIES(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitExecutablePrimitiveTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getExecutablePrimitiveTerm(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitAND_", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getAND_(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		op = addEOperation(topDownVisitorEClass, null, "visitResolutionValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCvlPackage.getResolutionValue(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ContextType);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(topDownVisitorEClass_ResultType);
		initEOperation(op, g1);

		// Create annotations
		// kermeta
		createKermetaAnnotations();
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
		  (topDownVisitorEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "do\nif node.variabilitySpecification != void then node.variabilitySpecification.accept(self, context) end\nnode.resolutionSpecification.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "do\nnode.boundaryElementBinding.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "body", "do\nnode.boundaryElement.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "body", "do\nnode.boundaryElement.each{ e | e.accept(self, context) }\nnode.placements.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(6), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(7), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(8), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(9), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(10), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(11), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(12), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(13), 
		   source, 
		   new String[] {
			 "body", "do\nnode.variabilitySpecification.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(14), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(15), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(16), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(17), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(18), 
		   source, 
		   new String[] {
			 "body", "do\nnode.resolution.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(19), 
		   source, 
		   new String[] {
			 "body", "do\nif node.body != void then node.body.accept(self, context) end\nif node.replacement != void then node.replacement.accept(self, context) end\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(20), 
		   source, 
		   new String[] {
			 "body", "do\nif node.resolutionSpecification != void then node.resolutionSpecification.accept(self, context) end\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(21), 
		   source, 
		   new String[] {
			 "body", "do\nnode.choice.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(22), 
		   source, 
		   new String[] {
			 "body", "do\nnode.variabilitySpecification.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(23), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(24), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(25), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(26), 
		   source, 
		   new String[] {
			 "body", "do\nif node.term != void then node.term.accept(self, context) end\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(27), 
		   source, 
		   new String[] {
			 "body", "do\nif node.left != void then node.left.accept(self, context) end\nif node.right != void then node.right.accept(self, context) end\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(28), 
		   source, 
		   new String[] {
			 "body", "do\nif node.left != void then node.left.accept(self, context) end\nif node.right != void then node.right.accept(self, context) end\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(29), 
		   source, 
		   new String[] {
			 "body", "do\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(30), 
		   source, 
		   new String[] {
			 "body", "do\nif node.left != void then node.left.accept(self, context) end\nif node.right != void then node.right.accept(self, context) end\nend",
			 "isAbstract", "false"
		   });			
		addAnnotation
		  (topDownVisitorEClass.getEOperations().get(31), 
		   source, 
		   new String[] {
			 "body", "do\nnode.resolution.each{ e | e.accept(self, context) }\nend",
			 "isAbstract", "false"
		   });	
	}

} //VisitorsPackageImpl
