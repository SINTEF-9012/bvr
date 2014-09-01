/**
 */
package bvr.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>bvr</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class BvrTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new BvrTests("bvr Tests");
		suite.addTestSuite(ObjectSpecificationTest.class);
		suite.addTestSuite(ReplacementFragmentSpecificationTest.class);
		suite.addTestSuite(PrimitiveValueSpecificationTest.class);
		suite.addTestSuite(VRefValueSpecificationTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BvrTests(String name) {
		super(name);
	}

} //BvrTests
