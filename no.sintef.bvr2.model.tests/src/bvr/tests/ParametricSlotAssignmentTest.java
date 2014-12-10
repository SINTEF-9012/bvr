/**
 */
package bvr.tests;

import bvr.BvrFactory;
import bvr.ParametricSlotAssignment;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Parametric Slot Assignment</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParametricSlotAssignmentTest extends ParametricVariationPointTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ParametricSlotAssignmentTest.class);
	}

	/**
	 * Constructs a new Parametric Slot Assignment test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricSlotAssignmentTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Parametric Slot Assignment test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ParametricSlotAssignment getFixture() {
		return (ParametricSlotAssignment)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BvrFactory.eINSTANCE.createParametricSlotAssignment());
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

} //ParametricSlotAssignmentTest
