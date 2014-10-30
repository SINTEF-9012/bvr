/**
 */
package bvr.tests;

import bvr.BvrFactory;
import bvr.PlacementFragment;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Placement Fragment</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PlacementFragmentTest extends VariationPointTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PlacementFragmentTest.class);
	}

	/**
	 * Constructs a new Placement Fragment test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacementFragmentTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Placement Fragment test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PlacementFragment getFixture() {
		return (PlacementFragment)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BvrFactory.eINSTANCE.createPlacementFragment());
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

} //PlacementFragmentTest
