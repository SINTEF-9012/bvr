/**
 */
package bvr.tests;

import bvr.BvrFactory;
import bvr.ReplacementFragmentType;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Replacement Fragment Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReplacementFragmentTypeTest extends VariabletypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ReplacementFragmentTypeTest.class);
	}

	/**
	 * Constructs a new Replacement Fragment Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Replacement Fragment Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ReplacementFragmentType getFixture() {
		return (ReplacementFragmentType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BvrFactory.eINSTANCE.createReplacementFragmentType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ReplacementFragmentTypeTest
