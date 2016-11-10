/**
 */
package realop.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import realop.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see realop.RealopPackage
 * @generated
 */
public class RealopAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RealopPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealopAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RealopPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealopSwitch<Adapter> modelSwitch =
		new RealopSwitch<Adapter>() {
			@Override
			public Adapter caseRealop(Realop object) {
				return createRealopAdapter();
			}
			@Override
			public Adapter caseOperator(Operator object) {
				return createOperatorAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseOrExp(OrExp object) {
				return createOrExpAdapter();
			}
			@Override
			public Adapter caseAndExp(AndExp object) {
				return createAndExpAdapter();
			}
			@Override
			public Adapter caseXorExp(XorExp object) {
				return createXorExpAdapter();
			}
			@Override
			public Adapter caseNotExp(NotExp object) {
				return createNotExpAdapter();
			}
			@Override
			public Adapter caseIsRealised(IsRealised object) {
				return createIsRealisedAdapter();
			}
			@Override
			public Adapter caseIsPositive(IsPositive object) {
				return createIsPositiveAdapter();
			}
			@Override
			public Adapter caseIsNegative(IsNegative object) {
				return createIsNegativeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link realop.Realop <em>Realop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see realop.Realop
	 * @generated
	 */
	public Adapter createRealopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link realop.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see realop.Operator
	 * @generated
	 */
	public Adapter createOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link realop.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see realop.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link realop.OrExp <em>Or Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see realop.OrExp
	 * @generated
	 */
	public Adapter createOrExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link realop.AndExp <em>And Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see realop.AndExp
	 * @generated
	 */
	public Adapter createAndExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link realop.XorExp <em>Xor Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see realop.XorExp
	 * @generated
	 */
	public Adapter createXorExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link realop.NotExp <em>Not Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see realop.NotExp
	 * @generated
	 */
	public Adapter createNotExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link realop.IsRealised <em>Is Realised</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see realop.IsRealised
	 * @generated
	 */
	public Adapter createIsRealisedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link realop.IsPositive <em>Is Positive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see realop.IsPositive
	 * @generated
	 */
	public Adapter createIsPositiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link realop.IsNegative <em>Is Negative</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see realop.IsNegative
	 * @generated
	 */
	public Adapter createIsNegativeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RealopAdapterFactory
