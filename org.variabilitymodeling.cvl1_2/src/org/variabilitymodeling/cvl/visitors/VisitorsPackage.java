/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.visitors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.variabilitymodeling.cvl.visitors.VisitorsFactory
 * @model kind="package"
 * @generated
 */
public interface VisitorsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "visitors";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "visitors";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "visitors";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VisitorsPackage eINSTANCE = org.variabilitymodeling.cvl.visitors.impl.VisitorsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.visitors.Visitable <em>Visitable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.visitors.Visitable
	 * @see org.variabilitymodeling.cvl.visitors.impl.VisitorsPackageImpl#getVisitable()
	 * @generated
	 */
	int VISITABLE = 0;

	/**
	 * The number of structural features of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.visitors.Visitor <em>Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.visitors.Visitor
	 * @see org.variabilitymodeling.cvl.visitors.impl.VisitorsPackageImpl#getVisitor()
	 * @generated
	 */
	int VISITOR = 1;

	/**
	 * The number of structural features of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.variabilitymodeling.cvl.visitors.impl.TopDownVisitorImpl <em>Top Down Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.variabilitymodeling.cvl.visitors.impl.TopDownVisitorImpl
	 * @see org.variabilitymodeling.cvl.visitors.impl.VisitorsPackageImpl#getTopDownVisitor()
	 * @generated
	 */
	int TOP_DOWN_VISITOR = 2;

	/**
	 * The number of structural features of the '<em>Top Down Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_DOWN_VISITOR_FEATURE_COUNT = VISITOR_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.visitors.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see org.variabilitymodeling.cvl.visitors.Visitable
	 * @generated
	 */
	EClass getVisitable();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.visitors.Visitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitor</em>'.
	 * @see org.variabilitymodeling.cvl.visitors.Visitor
	 * @generated
	 */
	EClass getVisitor();

	/**
	 * Returns the meta object for class '{@link org.variabilitymodeling.cvl.visitors.TopDownVisitor <em>Top Down Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Down Visitor</em>'.
	 * @see org.variabilitymodeling.cvl.visitors.TopDownVisitor
	 * @generated
	 */
	EClass getTopDownVisitor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VisitorsFactory getVisitorsFactory();

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
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.visitors.Visitable <em>Visitable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.visitors.Visitable
		 * @see org.variabilitymodeling.cvl.visitors.impl.VisitorsPackageImpl#getVisitable()
		 * @generated
		 */
		EClass VISITABLE = eINSTANCE.getVisitable();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.visitors.Visitor <em>Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.visitors.Visitor
		 * @see org.variabilitymodeling.cvl.visitors.impl.VisitorsPackageImpl#getVisitor()
		 * @generated
		 */
		EClass VISITOR = eINSTANCE.getVisitor();

		/**
		 * The meta object literal for the '{@link org.variabilitymodeling.cvl.visitors.impl.TopDownVisitorImpl <em>Top Down Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.variabilitymodeling.cvl.visitors.impl.TopDownVisitorImpl
		 * @see org.variabilitymodeling.cvl.visitors.impl.VisitorsPackageImpl#getTopDownVisitor()
		 * @generated
		 */
		EClass TOP_DOWN_VISITOR = eINSTANCE.getTopDownVisitor();

	}

} //VisitorsPackage
