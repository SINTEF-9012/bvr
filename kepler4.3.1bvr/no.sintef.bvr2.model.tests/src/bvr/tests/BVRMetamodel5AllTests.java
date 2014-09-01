/**
 */
package bvr.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>BVRMetamodel5</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class BVRMetamodel5AllTests extends TestSuite {

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
		TestSuite suite = new BVRMetamodel5AllTests("BVRMetamodel5 Tests");
		suite.addTest(BvrTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BVRMetamodel5AllTests(String name) {
		super(name);
	}

} //BVRMetamodel5AllTests
