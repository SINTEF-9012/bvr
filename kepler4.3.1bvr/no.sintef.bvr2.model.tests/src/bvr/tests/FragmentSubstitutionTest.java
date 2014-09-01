/**
 */
package bvr.tests;

import bvr.BvrFactory;
import bvr.FragmentSubstitution;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Fragment Substitution</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FragmentSubstitutionTest extends ChoiceVariationPointTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FragmentSubstitutionTest.class);
	}

	/**
	 * Constructs a new Fragment Substitution test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FragmentSubstitutionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Fragment Substitution test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected FragmentSubstitution getFixture() {
		return (FragmentSubstitution)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BvrFactory.eINSTANCE.createFragmentSubstitution());
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

} //FragmentSubstitutionTest
