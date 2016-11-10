/**
 */
package realop;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see realop.RealopPackage
 * @generated
 */
public interface RealopFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RealopFactory eINSTANCE = realop.impl.RealopFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Realop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Realop</em>'.
	 * @generated
	 */
	Realop createRealop();

	/**
	 * Returns a new object of class '<em>Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operator</em>'.
	 * @generated
	 */
	Operator createOperator();

	/**
	 * Returns a new object of class '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression</em>'.
	 * @generated
	 */
	Expression createExpression();

	/**
	 * Returns a new object of class '<em>Or Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Exp</em>'.
	 * @generated
	 */
	OrExp createOrExp();

	/**
	 * Returns a new object of class '<em>And Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Exp</em>'.
	 * @generated
	 */
	AndExp createAndExp();

	/**
	 * Returns a new object of class '<em>Xor Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xor Exp</em>'.
	 * @generated
	 */
	XorExp createXorExp();

	/**
	 * Returns a new object of class '<em>Not Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Exp</em>'.
	 * @generated
	 */
	NotExp createNotExp();

	/**
	 * Returns a new object of class '<em>Is Realised</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Realised</em>'.
	 * @generated
	 */
	IsRealised createIsRealised();

	/**
	 * Returns a new object of class '<em>Is Positive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Positive</em>'.
	 * @generated
	 */
	IsPositive createIsPositive();

	/**
	 * Returns a new object of class '<em>Is Negative</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Negative</em>'.
	 * @generated
	 */
	IsNegative createIsNegative();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RealopPackage getRealopPackage();

} //RealopFactory
