/**
 */
package bvr.tests;

import bvr.BvrFactory;
import bvr.ResolutionLiteralDefinition;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Resolution Literal Definition</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResolutionLiteralDefinitionTest extends CompoundResolutionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ResolutionLiteralDefinitionTest.class);
	}

	/**
	 * Constructs a new Resolution Literal Definition test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolutionLiteralDefinitionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Resolution Literal Definition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ResolutionLiteralDefinition getFixture() {
		return (ResolutionLiteralDefinition)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BvrFactory.eINSTANCE.createResolutionLiteralDefinition());
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

} //ResolutionLiteralDefinitionTest
