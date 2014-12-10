/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.VPackage;
import bvr.VPackageable;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VPackage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.VPackageImpl#getPackageElement <em>Package Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VPackageImpl extends VPackageableImpl implements VPackage {
	/**
	 * The cached value of the '{@link #getPackageElement() <em>Package Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageElement()
	 * @generated
	 * @ordered
	 */
	protected EList<VPackageable> packageElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.VPACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VPackageable> getPackageElement() {
		if (packageElement == null) {
			packageElement = new EObjectContainmentEList<VPackageable>(VPackageable.class, this, BvrPackage.VPACKAGE__PACKAGE_ELEMENT);
		}
		return packageElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.VPACKAGE__PACKAGE_ELEMENT:
				return ((InternalEList<?>)getPackageElement()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.VPACKAGE__PACKAGE_ELEMENT:
				return getPackageElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BvrPackage.VPACKAGE__PACKAGE_ELEMENT:
				getPackageElement().clear();
				getPackageElement().addAll((Collection<? extends VPackageable>)newValue);
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
			case BvrPackage.VPACKAGE__PACKAGE_ELEMENT:
				getPackageElement().clear();
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
			case BvrPackage.VPACKAGE__PACKAGE_ELEMENT:
				return packageElement != null && !packageElement.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VPackageImpl
