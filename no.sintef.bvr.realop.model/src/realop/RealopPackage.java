/**
 */
package realop;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see realop.RealopFactory
 * @model kind="package"
 * @generated
 */
public interface RealopPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "realop";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sintef.no/xtext/dsl/operator/Realop";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "realop";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RealopPackage eINSTANCE = realop.impl.RealopPackageImpl.init();

	/**
	 * The meta object id for the '{@link realop.impl.RealopImpl <em>Realop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see realop.impl.RealopImpl
	 * @see realop.impl.RealopPackageImpl#getRealop()
	 * @generated
	 */
	int REALOP = 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALOP__OPERATORS = 0;

	/**
	 * The number of structural features of the '<em>Realop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALOP_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Realop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALOP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link realop.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see realop.impl.OperatorImpl
	 * @see realop.impl.RealopPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Exp Pre</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__EXP_PRE = 1;

	/**
	 * The feature id for the '<em><b>Exp Post</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__EXP_POST = 2;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link realop.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see realop.impl.ExpressionImpl
	 * @see realop.impl.RealopPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 2;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link realop.impl.OrExpImpl <em>Or Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see realop.impl.OrExpImpl
	 * @see realop.impl.RealopPackageImpl#getOrExp()
	 * @generated
	 */
	int OR_EXP = 3;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXP__LEFT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXP__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Or Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Or Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXP_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link realop.impl.AndExpImpl <em>And Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see realop.impl.AndExpImpl
	 * @see realop.impl.RealopPackageImpl#getAndExp()
	 * @generated
	 */
	int AND_EXP = 4;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXP__LEFT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXP__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>And Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>And Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXP_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link realop.impl.XorExpImpl <em>Xor Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see realop.impl.XorExpImpl
	 * @see realop.impl.RealopPackageImpl#getXorExp()
	 * @generated
	 */
	int XOR_EXP = 5;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXP__LEFT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXP__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Xor Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Xor Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXP_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link realop.impl.NotExpImpl <em>Not Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see realop.impl.NotExpImpl
	 * @see realop.impl.RealopPackageImpl#getNotExp()
	 * @generated
	 */
	int NOT_EXP = 6;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXP__EXP = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Not Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Not Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXP_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link realop.impl.IsRealisedImpl <em>Is Realised</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see realop.impl.IsRealisedImpl
	 * @see realop.impl.RealopPackageImpl#getIsRealised()
	 * @generated
	 */
	int IS_REALISED = 7;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_REALISED__FEATURE_NAME = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Is Realised</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_REALISED_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Is Realised</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_REALISED_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link realop.impl.IsPositiveImpl <em>Is Positive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see realop.impl.IsPositiveImpl
	 * @see realop.impl.RealopPackageImpl#getIsPositive()
	 * @generated
	 */
	int IS_POSITIVE = 8;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_POSITIVE__FEATURE_NAME = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Is Positive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_POSITIVE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Is Positive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_POSITIVE_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link realop.impl.IsNegativeImpl <em>Is Negative</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see realop.impl.IsNegativeImpl
	 * @see realop.impl.RealopPackageImpl#getIsNegative()
	 * @generated
	 */
	int IS_NEGATIVE = 9;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_NEGATIVE__FEATURE_NAME = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Is Negative</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_NEGATIVE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Is Negative</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_NEGATIVE_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link realop.Realop <em>Realop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realop</em>'.
	 * @see realop.Realop
	 * @generated
	 */
	EClass getRealop();

	/**
	 * Returns the meta object for the containment reference list '{@link realop.Realop#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operators</em>'.
	 * @see realop.Realop#getOperators()
	 * @see #getRealop()
	 * @generated
	 */
	EReference getRealop_Operators();

	/**
	 * Returns the meta object for class '{@link realop.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see realop.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the attribute '{@link realop.Operator#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see realop.Operator#getName()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_Name();

	/**
	 * Returns the meta object for the containment reference '{@link realop.Operator#getExpPre <em>Exp Pre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp Pre</em>'.
	 * @see realop.Operator#getExpPre()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_ExpPre();

	/**
	 * Returns the meta object for the containment reference '{@link realop.Operator#getExpPost <em>Exp Post</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp Post</em>'.
	 * @see realop.Operator#getExpPost()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_ExpPost();

	/**
	 * Returns the meta object for class '{@link realop.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see realop.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link realop.OrExp <em>Or Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Exp</em>'.
	 * @see realop.OrExp
	 * @generated
	 */
	EClass getOrExp();

	/**
	 * Returns the meta object for the containment reference '{@link realop.OrExp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see realop.OrExp#getLeft()
	 * @see #getOrExp()
	 * @generated
	 */
	EReference getOrExp_Left();

	/**
	 * Returns the meta object for the containment reference '{@link realop.OrExp#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see realop.OrExp#getRight()
	 * @see #getOrExp()
	 * @generated
	 */
	EReference getOrExp_Right();

	/**
	 * Returns the meta object for class '{@link realop.AndExp <em>And Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Exp</em>'.
	 * @see realop.AndExp
	 * @generated
	 */
	EClass getAndExp();

	/**
	 * Returns the meta object for the containment reference '{@link realop.AndExp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see realop.AndExp#getLeft()
	 * @see #getAndExp()
	 * @generated
	 */
	EReference getAndExp_Left();

	/**
	 * Returns the meta object for the containment reference '{@link realop.AndExp#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see realop.AndExp#getRight()
	 * @see #getAndExp()
	 * @generated
	 */
	EReference getAndExp_Right();

	/**
	 * Returns the meta object for class '{@link realop.XorExp <em>Xor Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xor Exp</em>'.
	 * @see realop.XorExp
	 * @generated
	 */
	EClass getXorExp();

	/**
	 * Returns the meta object for the containment reference '{@link realop.XorExp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see realop.XorExp#getLeft()
	 * @see #getXorExp()
	 * @generated
	 */
	EReference getXorExp_Left();

	/**
	 * Returns the meta object for the containment reference '{@link realop.XorExp#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see realop.XorExp#getRight()
	 * @see #getXorExp()
	 * @generated
	 */
	EReference getXorExp_Right();

	/**
	 * Returns the meta object for class '{@link realop.NotExp <em>Not Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Exp</em>'.
	 * @see realop.NotExp
	 * @generated
	 */
	EClass getNotExp();

	/**
	 * Returns the meta object for the containment reference '{@link realop.NotExp#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp</em>'.
	 * @see realop.NotExp#getExp()
	 * @see #getNotExp()
	 * @generated
	 */
	EReference getNotExp_Exp();

	/**
	 * Returns the meta object for class '{@link realop.IsRealised <em>Is Realised</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Realised</em>'.
	 * @see realop.IsRealised
	 * @generated
	 */
	EClass getIsRealised();

	/**
	 * Returns the meta object for the attribute '{@link realop.IsRealised#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see realop.IsRealised#getFeatureName()
	 * @see #getIsRealised()
	 * @generated
	 */
	EAttribute getIsRealised_FeatureName();

	/**
	 * Returns the meta object for class '{@link realop.IsPositive <em>Is Positive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Positive</em>'.
	 * @see realop.IsPositive
	 * @generated
	 */
	EClass getIsPositive();

	/**
	 * Returns the meta object for the attribute '{@link realop.IsPositive#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see realop.IsPositive#getFeatureName()
	 * @see #getIsPositive()
	 * @generated
	 */
	EAttribute getIsPositive_FeatureName();

	/**
	 * Returns the meta object for class '{@link realop.IsNegative <em>Is Negative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Negative</em>'.
	 * @see realop.IsNegative
	 * @generated
	 */
	EClass getIsNegative();

	/**
	 * Returns the meta object for the attribute '{@link realop.IsNegative#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see realop.IsNegative#getFeatureName()
	 * @see #getIsNegative()
	 * @generated
	 */
	EAttribute getIsNegative_FeatureName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RealopFactory getRealopFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link realop.impl.RealopImpl <em>Realop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see realop.impl.RealopImpl
		 * @see realop.impl.RealopPackageImpl#getRealop()
		 * @generated
		 */
		EClass REALOP = eINSTANCE.getRealop();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALOP__OPERATORS = eINSTANCE.getRealop_Operators();

		/**
		 * The meta object literal for the '{@link realop.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see realop.impl.OperatorImpl
		 * @see realop.impl.RealopPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__NAME = eINSTANCE.getOperator_Name();

		/**
		 * The meta object literal for the '<em><b>Exp Pre</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__EXP_PRE = eINSTANCE.getOperator_ExpPre();

		/**
		 * The meta object literal for the '<em><b>Exp Post</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__EXP_POST = eINSTANCE.getOperator_ExpPost();

		/**
		 * The meta object literal for the '{@link realop.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see realop.impl.ExpressionImpl
		 * @see realop.impl.RealopPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link realop.impl.OrExpImpl <em>Or Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see realop.impl.OrExpImpl
		 * @see realop.impl.RealopPackageImpl#getOrExp()
		 * @generated
		 */
		EClass OR_EXP = eINSTANCE.getOrExp();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OR_EXP__LEFT = eINSTANCE.getOrExp_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OR_EXP__RIGHT = eINSTANCE.getOrExp_Right();

		/**
		 * The meta object literal for the '{@link realop.impl.AndExpImpl <em>And Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see realop.impl.AndExpImpl
		 * @see realop.impl.RealopPackageImpl#getAndExp()
		 * @generated
		 */
		EClass AND_EXP = eINSTANCE.getAndExp();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AND_EXP__LEFT = eINSTANCE.getAndExp_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AND_EXP__RIGHT = eINSTANCE.getAndExp_Right();

		/**
		 * The meta object literal for the '{@link realop.impl.XorExpImpl <em>Xor Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see realop.impl.XorExpImpl
		 * @see realop.impl.RealopPackageImpl#getXorExp()
		 * @generated
		 */
		EClass XOR_EXP = eINSTANCE.getXorExp();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XOR_EXP__LEFT = eINSTANCE.getXorExp_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XOR_EXP__RIGHT = eINSTANCE.getXorExp_Right();

		/**
		 * The meta object literal for the '{@link realop.impl.NotExpImpl <em>Not Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see realop.impl.NotExpImpl
		 * @see realop.impl.RealopPackageImpl#getNotExp()
		 * @generated
		 */
		EClass NOT_EXP = eINSTANCE.getNotExp();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_EXP__EXP = eINSTANCE.getNotExp_Exp();

		/**
		 * The meta object literal for the '{@link realop.impl.IsRealisedImpl <em>Is Realised</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see realop.impl.IsRealisedImpl
		 * @see realop.impl.RealopPackageImpl#getIsRealised()
		 * @generated
		 */
		EClass IS_REALISED = eINSTANCE.getIsRealised();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IS_REALISED__FEATURE_NAME = eINSTANCE.getIsRealised_FeatureName();

		/**
		 * The meta object literal for the '{@link realop.impl.IsPositiveImpl <em>Is Positive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see realop.impl.IsPositiveImpl
		 * @see realop.impl.RealopPackageImpl#getIsPositive()
		 * @generated
		 */
		EClass IS_POSITIVE = eINSTANCE.getIsPositive();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IS_POSITIVE__FEATURE_NAME = eINSTANCE.getIsPositive_FeatureName();

		/**
		 * The meta object literal for the '{@link realop.impl.IsNegativeImpl <em>Is Negative</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see realop.impl.IsNegativeImpl
		 * @see realop.impl.RealopPackageImpl#getIsNegative()
		 * @generated
		 */
		EClass IS_NEGATIVE = eINSTANCE.getIsNegative();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IS_NEGATIVE__FEATURE_NAME = eINSTANCE.getIsNegative_FeatureName();

	}

} //RealopPackage
