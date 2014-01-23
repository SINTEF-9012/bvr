/**
 */
package bvr.impl;

import bvr.Choice;
import bvr.ChoiceVariationPoint;
import bvr.BvrPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.ChoiceVariationPointImpl#getBindingChoice <em>Binding Choice</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ChoiceVariationPointImpl extends VariationPointImpl implements ChoiceVariationPoint {
	/**
	 * The cached value of the '{@link #getBindingChoice() <em>Binding Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingChoice()
	 * @generated
	 * @ordered
	 */
	protected Choice bindingChoice;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceVariationPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.CHOICE_VARIATION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice getBindingChoice() {
		if (bindingChoice != null && bindingChoice.eIsProxy()) {
			InternalEObject oldBindingChoice = (InternalEObject)bindingChoice;
			bindingChoice = (Choice)eResolveProxy(oldBindingChoice);
			if (bindingChoice != oldBindingChoice) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE, oldBindingChoice, bindingChoice));
			}
		}
		return bindingChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice basicGetBindingChoice() {
		return bindingChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingChoice(Choice newBindingChoice) {
		Choice oldBindingChoice = bindingChoice;
		bindingChoice = newBindingChoice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE, oldBindingChoice, bindingChoice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE:
				if (resolve) return getBindingChoice();
				return basicGetBindingChoice();
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
			case BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE:
				setBindingChoice((Choice)newValue);
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
			case BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE:
				setBindingChoice((Choice)null);
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
			case BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE:
				return bindingChoice != null;
		}
		return super.eIsSet(featureID);
	}

} //ChoiceVariationPointImpl
