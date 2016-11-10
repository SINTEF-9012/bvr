/**
 */
package realop.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import realop.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RealopFactoryImpl extends EFactoryImpl implements RealopFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RealopFactory init() {
		try {
			RealopFactory theRealopFactory = (RealopFactory)EPackage.Registry.INSTANCE.getEFactory(RealopPackage.eNS_URI);
			if (theRealopFactory != null) {
				return theRealopFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RealopFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealopFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RealopPackage.REALOP: return createRealop();
			case RealopPackage.OPERATOR: return createOperator();
			case RealopPackage.EXPRESSION: return createExpression();
			case RealopPackage.OR_EXP: return createOrExp();
			case RealopPackage.AND_EXP: return createAndExp();
			case RealopPackage.XOR_EXP: return createXorExp();
			case RealopPackage.NOT_EXP: return createNotExp();
			case RealopPackage.IS_REALISED: return createIsRealised();
			case RealopPackage.IS_POSITIVE: return createIsPositive();
			case RealopPackage.IS_NEGATIVE: return createIsNegative();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Realop createRealop() {
		RealopImpl realop = new RealopImpl();
		return realop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator createOperator() {
		OperatorImpl operator = new OperatorImpl();
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrExp createOrExp() {
		OrExpImpl orExp = new OrExpImpl();
		return orExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndExp createAndExp() {
		AndExpImpl andExp = new AndExpImpl();
		return andExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XorExp createXorExp() {
		XorExpImpl xorExp = new XorExpImpl();
		return xorExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotExp createNotExp() {
		NotExpImpl notExp = new NotExpImpl();
		return notExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsRealised createIsRealised() {
		IsRealisedImpl isRealised = new IsRealisedImpl();
		return isRealised;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsPositive createIsPositive() {
		IsPositiveImpl isPositive = new IsPositiveImpl();
		return isPositive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsNegative createIsNegative() {
		IsNegativeImpl isNegative = new IsNegativeImpl();
		return isNegative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealopPackage getRealopPackage() {
		return (RealopPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RealopPackage getPackage() {
		return RealopPackage.eINSTANCE;
	}

} //RealopFactoryImpl
