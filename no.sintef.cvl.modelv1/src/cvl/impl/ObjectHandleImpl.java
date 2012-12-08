/**
 */
package cvl.impl;

import cvl.ObjectHandle;
import cvl.cvlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Handle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.ObjectHandleImpl#getMOFRef <em>MOF Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectHandleImpl extends BaseModelHandleImpl implements ObjectHandle {
	/**
	 * The default value of the '{@link #getMOFRef() <em>MOF Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMOFRef()
	 * @generated
	 * @ordered
	 */
	protected static final String MOF_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMOFRef() <em>MOF Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMOFRef()
	 * @generated
	 * @ordered
	 */
	protected String mofRef = MOF_REF_EDEFAULT;

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
		return cvlPackage.Literals.OBJECT_HANDLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMOFRef() {
		return mofRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMOFRef(String newMOFRef) {
		String oldMOFRef = mofRef;
		mofRef = newMOFRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.OBJECT_HANDLE__MOF_REF, oldMOFRef, mofRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case cvlPackage.OBJECT_HANDLE__MOF_REF:
				return getMOFRef();
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
			case cvlPackage.OBJECT_HANDLE__MOF_REF:
				setMOFRef((String)newValue);
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
			case cvlPackage.OBJECT_HANDLE__MOF_REF:
				setMOFRef(MOF_REF_EDEFAULT);
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
			case cvlPackage.OBJECT_HANDLE__MOF_REF:
				return MOF_REF_EDEFAULT == null ? mofRef != null : !MOF_REF_EDEFAULT.equals(mofRef);
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
		result.append(" (MOFRef: ");
		result.append(mofRef);
		result.append(')');
		return result.toString();
	}

} //ObjectHandleImpl
