/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.CVSpec;
import bvr.CompositeVariationPoint;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.CompositeVariationPointImpl#getBindingCVSpec <em>Binding CV Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompositeVariationPointImpl extends VariationPointImpl implements CompositeVariationPoint {
	/**
	 * The cached value of the '{@link #getBindingCVSpec() <em>Binding CV Spec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingCVSpec()
	 * @generated
	 * @ordered
	 */
	protected CVSpec bindingCVSpec;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeVariationPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.COMPOSITE_VARIATION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSpec getBindingCVSpec() {
		if (bindingCVSpec != null && bindingCVSpec.eIsProxy()) {
			InternalEObject oldBindingCVSpec = (InternalEObject)bindingCVSpec;
			bindingCVSpec = (CVSpec)eResolveProxy(oldBindingCVSpec);
			if (bindingCVSpec != oldBindingCVSpec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.COMPOSITE_VARIATION_POINT__BINDING_CV_SPEC, oldBindingCVSpec, bindingCVSpec));
			}
		}
		return bindingCVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSpec basicGetBindingCVSpec() {
		return bindingCVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingCVSpec(CVSpec newBindingCVSpec) {
		CVSpec oldBindingCVSpec = bindingCVSpec;
		bindingCVSpec = newBindingCVSpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.COMPOSITE_VARIATION_POINT__BINDING_CV_SPEC, oldBindingCVSpec, bindingCVSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.COMPOSITE_VARIATION_POINT__BINDING_CV_SPEC:
				if (resolve) return getBindingCVSpec();
				return basicGetBindingCVSpec();
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
			case BvrPackage.COMPOSITE_VARIATION_POINT__BINDING_CV_SPEC:
				setBindingCVSpec((CVSpec)newValue);
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
			case BvrPackage.COMPOSITE_VARIATION_POINT__BINDING_CV_SPEC:
				setBindingCVSpec((CVSpec)null);
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
			case BvrPackage.COMPOSITE_VARIATION_POINT__BINDING_CV_SPEC:
				return bindingCVSpec != null;
		}
		return super.eIsSet(featureID);
	}

} //CompositeVariationPointImpl
