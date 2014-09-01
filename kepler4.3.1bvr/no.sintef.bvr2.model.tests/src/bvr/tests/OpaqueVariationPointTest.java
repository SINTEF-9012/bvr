/**
 */
package bvr.tests;

import bvr.BvrFactory;
import bvr.OpaqueVariationPoint;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Opaque Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OpaqueVariationPointTest extends VariationPointTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OpaqueVariationPointTest.class);
	}

	/**
	 * Constructs a new Opaque Variation Point test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueVariationPointTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Opaque Variation Point test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OpaqueVariationPoint getFixture() {
		return (OpaqueVariationPoint)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BvrFactory.eINSTANCE.createOpaqueVariationPoint());
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

} //OpaqueVariationPointTest
