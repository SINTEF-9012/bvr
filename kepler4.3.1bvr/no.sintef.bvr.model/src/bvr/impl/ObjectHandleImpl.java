/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.ObjectHandle;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Handle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.ObjectHandleImpl#getMOFRef <em>MOF Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectHandleImpl extends MinimalEObjectImpl.Container implements ObjectHandle {
	/**
	 * The cached value of the '{@link #getMOFRef() <em>MOF Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMOFRef()
	 * @generated
	 * @ordered
	 */
	protected EObject mofRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectHandleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.OBJECT_HANDLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getMOFRef() {
		if (mofRef != null && mofRef.eIsProxy()) {
			InternalEObject oldMOFRef = (InternalEObject)mofRef;
			mofRef = eResolveProxy(oldMOFRef);
			if (mofRef != oldMOFRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.OBJECT_HANDLE__MOF_REF, oldMOFRef, mofRef));
			}
		}
		return mofRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetMOFRef() {
		return mofRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMOFRef(EObject newMOFRef) {
		EObject oldMOFRef = mofRef;
		mofRef = newMOFRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.OBJECT_HANDLE__MOF_REF, oldMOFRef, mofRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.OBJECT_HANDLE__MOF_REF:
				if (resolve) return getMOFRef();
				return basicGetMOFRef();
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
			case BvrPackage.OBJECT_HANDLE__MOF_REF:
				setMOFRef((EObject)newValue);
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
			case BvrPackage.OBJECT_HANDLE__MOF_REF:
				setMOFRef((EObject)null);
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
			case BvrPackage.OBJECT_HANDLE__MOF_REF:
				return mofRef != null;
		}
		return super.eIsSet(featureID);
	}

} //ObjectHandleImpl
