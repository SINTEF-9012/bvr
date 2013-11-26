/**
 */
package org.bangbangbang.cvl.impl;

import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.ObjectHandle;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Handle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.impl.ObjectHandleImpl#getMOFRef <em>MOF Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectHandleImpl extends BaseModelHandleImpl implements ObjectHandle {
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
		return CvlPackage.Literals.OBJECT_HANDLE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.OBJECT_HANDLE__MOF_REF, oldMOFRef, mofRef));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.OBJECT_HANDLE__MOF_REF, oldMOFRef, mofRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CvlPackage.OBJECT_HANDLE__MOF_REF:
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
			case CvlPackage.OBJECT_HANDLE__MOF_REF:
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
			case CvlPackage.OBJECT_HANDLE__MOF_REF:
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
			case CvlPackage.OBJECT_HANDLE__MOF_REF:
				return mofRef != null;
		}
		return super.eIsSet(featureID);
	}

} //ObjectHandleImpl
