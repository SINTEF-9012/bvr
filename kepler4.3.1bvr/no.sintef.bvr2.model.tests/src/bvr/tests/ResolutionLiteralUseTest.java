/**
 */
package bvr.tests;

import bvr.BvrFactory;
import bvr.ResolutionLiteralUse;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Resolution Literal Use</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResolutionLiteralUseTest extends ChoiceResolutionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ResolutionLiteralUseTest.class);
	}

	/**
	 * Constructs a new Resolution Literal Use test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolutionLiteralUseTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Resolution Literal Use test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ResolutionLiteralUse getFixture() {
		return (ResolutionLiteralUse)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BvrFactory.eINSTANCE.createResolutionLiteralUse());
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

} //ResolutionLiteralUseTest
