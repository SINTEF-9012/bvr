/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation.impl;

import org.bangbangbang.cvl.VClassifier;

import org.bangbangbang.cvl.system.cvlsystemrelation.Quantifier;
import org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage;
import org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VClassifier Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.VClassifierReferenceImpl#getQuantifier <em>Quantifier</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.VClassifierReferenceImpl#getVclassifier <em>Vclassifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VClassifierReferenceImpl extends MinimalEObjectImpl.Container implements VClassifierReference {
	/**
	 * The default value of the '{@link #getQuantifier() <em>Quantifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantifier()
	 * @generated
	 * @ordered
	 */
	protected static final Quantifier QUANTIFIER_EDEFAULT = Quantifier.FOR_ALL;

	/**
	 * The cached value of the '{@link #getQuantifier() <em>Quantifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantifier()
	 * @generated
	 * @ordered
	 */
	protected Quantifier quantifier = QUANTIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVclassifier() <em>Vclassifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVclassifier()
	 * @generated
	 * @ordered
	 */
	protected VClassifier vclassifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VClassifierReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationPackage.Literals.VCLASSIFIER_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quantifier getQuantifier() {
		return quantifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuantifier(Quantifier newQuantifier) {
		Quantifier oldQuantifier = quantifier;
		quantifier = newQuantifier == null ? QUANTIFIER_EDEFAULT : newQuantifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationPackage.VCLASSIFIER_REFERENCE__QUANTIFIER, oldQuantifier, quantifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VClassifier getVclassifier() {
		if (vclassifier != null && vclassifier.eIsProxy()) {
			InternalEObject oldVclassifier = (InternalEObject)vclassifier;
			vclassifier = (VClassifier)eResolveProxy(oldVclassifier);
			if (vclassifier != oldVclassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationPackage.VCLASSIFIER_REFERENCE__VCLASSIFIER, oldVclassifier, vclassifier));
			}
		}
		return vclassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VClassifier basicGetVclassifier() {
		return vclassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVclassifier(VClassifier newVclassifier) {
		VClassifier oldVclassifier = vclassifier;
		vclassifier = newVclassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationPackage.VCLASSIFIER_REFERENCE__VCLASSIFIER, oldVclassifier, vclassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RelationPackage.VCLASSIFIER_REFERENCE__QUANTIFIER:
				return getQuantifier();
			case RelationPackage.VCLASSIFIER_REFERENCE__VCLASSIFIER:
				if (resolve) return getVclassifier();
				return basicGetVclassifier();
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
			case RelationPackage.VCLASSIFIER_REFERENCE__QUANTIFIER:
				setQuantifier((Quantifier)newValue);
				return;
			case RelationPackage.VCLASSIFIER_REFERENCE__VCLASSIFIER:
				setVclassifier((VClassifier)newValue);
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
			case RelationPackage.VCLASSIFIER_REFERENCE__QUANTIFIER:
				setQuantifier(QUANTIFIER_EDEFAULT);
				return;
			case RelationPackage.VCLASSIFIER_REFERENCE__VCLASSIFIER:
				setVclassifier((VClassifier)null);
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
			case RelationPackage.VCLASSIFIER_REFERENCE__QUANTIFIER:
				return quantifier != QUANTIFIER_EDEFAULT;
			case RelationPackage.VCLASSIFIER_REFERENCE__VCLASSIFIER:
				return vclassifier != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (quantifier: ");
		result.append(quantifier);
		result.append(')');
		return result.toString();
	}

} //VClassifierReferenceImpl
