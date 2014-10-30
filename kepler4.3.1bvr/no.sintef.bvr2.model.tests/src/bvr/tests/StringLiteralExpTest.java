/**
 */
package bvr.tests;

import bvr.BvrFactory;
import bvr.StringLiteralExp;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>String Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StringLiteralExpTest extends BCLExpressionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StringLiteralExpTest.class);
	}

	/**
	 * Constructs a new String Literal Exp test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExpTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this String Literal Exp test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StringLiteralExp getFixture() {
		return (StringLiteralExp)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BvrFactory.eINSTANCE.createStringLiteralExp());
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

} //StringLiteralExpTest
