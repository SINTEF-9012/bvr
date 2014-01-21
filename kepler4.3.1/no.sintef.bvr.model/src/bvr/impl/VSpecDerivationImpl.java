/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.VSpec;
import bvr.VSpecDerivation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VSpec Derivation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.VSpecDerivationImpl#getDerivedVSpec <em>Derived VSpec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VSpecDerivationImpl extends VPackageableImpl implements VSpecDerivation {
	/**
	 * The cached value of the '{@link #getDerivedVSpec() <em>Derived VSpec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedVSpec()
	 * @generated
	 * @ordered
	 */
	protected VSpec derivedVSpec;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VSpecDerivationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.VSPEC_DERIVATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec getDerivedVSpec() {
		if (derivedVSpec != null && derivedVSpec.eIsProxy()) {
			InternalEObject oldDerivedVSpec = (InternalEObject)derivedVSpec;
			derivedVSpec = (VSpec)eResolveProxy(oldDerivedVSpec);
			if (derivedVSpec != oldDerivedVSpec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.VSPEC_DERIVATION__DERIVED_VSPEC, oldDerivedVSpec, derivedVSpec));
			}
		}
		return derivedVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec basicGetDerivedVSpec() {
		return derivedVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivedVSpec(VSpec newDerivedVSpec) {
		VSpec oldDerivedVSpec = derivedVSpec;
		derivedVSpec = newDerivedVSpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.VSPEC_DERIVATION__DERIVED_VSPEC, oldDerivedVSpec, derivedVSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.VSPEC_DERIVATION__DERIVED_VSPEC:
				if (resolve) return getDerivedVSpec();
				return basicGetDerivedVSpec();
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
			case BvrPackage.VSPEC_DERIVATION__DERIVED_VSPEC:
				setDerivedVSpec((VSpec)newValue);
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
			case BvrPackage.VSPEC_DERIVATION__DERIVED_VSPEC:
				setDerivedVSpec((VSpec)null);
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
			case BvrPackage.VSPEC_DERIVATION__DERIVED_VSPEC:
				return derivedVSpec != null;
		}
		return super.eIsSet(featureID);
	}

} //VSpecDerivationImpl
