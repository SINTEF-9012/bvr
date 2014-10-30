/**
 */
package bvr.tests;

import bvr.BvrFactory;
import bvr.StagedVariationPoint;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Staged Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StagedVariationPointTest extends VariationPointTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StagedVariationPointTest.class);
	}

	/**
	 * Constructs a new Staged Variation Point test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StagedVariationPointTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Staged Variation Point test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StagedVariationPoint getFixture() {
		return (StagedVariationPoint)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BvrFactory.eINSTANCE.createStagedVariationPoint());
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

} //StagedVariationPointTest
