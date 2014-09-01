/**
 */
package bvr.tests;

import bvr.BvrFactory;
import bvr.UnlimitedLiteralExp;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Unlimited Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnlimitedLiteralExpTest extends NumericLiteralExpTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(UnlimitedLiteralExpTest.class);
	}

	/**
	 * Constructs a new Unlimited Literal Exp test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnlimitedLiteralExpTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Unlimited Literal Exp test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected UnlimitedLiteralExp getFixture() {
		return (UnlimitedLiteralExp)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BvrFactory.eINSTANCE.createUnlimitedLiteralExp());
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

} //UnlimitedLiteralExpTest
