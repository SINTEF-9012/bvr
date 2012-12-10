/**
 */
package cvl.impl;

import cvl.ParametricVariationPoint;
import cvl.Variable;
import cvl.cvlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parametric Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.ParametricVariationPointImpl#getBindingVariable <em>Binding Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParametricVariationPointImpl extends VariationPointImpl implements ParametricVariationPoint {
	/**
	 * The cached value of the '{@link #getBindingVariable() <em>Binding Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable bindingVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParametricVariationPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return cvlPackage.Literals.PARAMETRIC_VARIATION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getBindingVariable() {
		if (bindingVariable != null && bindingVariable.eIsProxy()) {
			InternalEObject oldBindingVariable = (InternalEObject)bindingVariable;
			bindingVariable = (Variable)eResolveProxy(oldBindingVariable);
			if (bindingVariable != oldBindingVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, cvlPackage.PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE, oldBindingVariable, bindingVariable));
			}
		}
		return bindingVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetBindingVariable() {
		return bindingVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingVariable(Variable newBindingVariable) {
		Variable oldBindingVariable = bindingVariable;
		bindingVariable = newBindingVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE, oldBindingVariable, bindingVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case cvlPackage.PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE:
				if (resolve) return getBindingVariable();
				return basicGetBindingVariable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case cvlPackage.PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE:
				setBindingVariable((Variable)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case cvlPackage.PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE:
				setBindingVariable((Variable)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case cvlPackage.PARAMETRIC_VARIATION_POINT__BINDING_VARIABLE:
				return bindingVariable != null;
		}
		return super.eIsSet(featureID);
	}

} //ParametricVariationPointImpl
