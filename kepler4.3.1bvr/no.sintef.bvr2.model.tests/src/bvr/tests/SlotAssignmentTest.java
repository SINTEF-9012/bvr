/**
 */
package bvr.tests;

import bvr.BvrFactory;
import bvr.SlotAssignment;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Slot Assignment</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SlotAssignmentTest extends ChoiceVariationPointTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SlotAssignmentTest.class);
	}

	/**
	 * Constructs a new Slot Assignment test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlotAssignmentTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Slot Assignment test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SlotAssignment getFixture() {
		return (SlotAssignment)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BvrFactory.eINSTANCE.createSlotAssignment());
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

} //SlotAssignmentTest
