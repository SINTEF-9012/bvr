/**
 */
package cvl.impl;

import cvl.CvlPackage;
import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.FromReplacement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>From Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.FromBindingImpl#getFromPlacement <em>From Placement</em>}</li>
 *   <li>{@link cvl.impl.FromBindingImpl#getFromReplacement <em>From Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FromBindingImpl extends BoundaryElementBindingImpl implements FromBinding {
	/**
	 * The cached value of the '{@link #getFromPlacement() <em>From Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromPlacement()
	 * @generated
	 * @ordered
	 */
	protected FromPlacement fromPlacement;

	/**
	 * The cached value of the '{@link #getFromReplacement() <em>From Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromReplacement()
	 * @generated
	 * @ordered
	 */
	protected FromReplacement fromReplacement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FromBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.FROM_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromPlacement getFromPlacement() {
		if (fromPlacement != null && fromPlacement.eIsProxy()) {
			InternalEObject oldFromPlacement = (InternalEObject)fromPlacement;
			fromPlacement = (FromPlacement)eResolveProxy(oldFromPlacement);
			if (fromPlacement != oldFromPlacement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.FROM_BINDING__FROM_PLACEMENT, oldFromPlacement, fromPlacement));
			}
		}
		return fromPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromPlacement basicGetFromPlacement() {
		return fromPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromPlacement(FromPlacement newFromPlacement) {
		FromPlacement oldFromPlacement = fromPlacement;
		fromPlacement = newFromPlacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.FROM_BINDING__FROM_PLACEMENT, oldFromPlacement, fromPlacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromReplacement getFromReplacement() {
		if (fromReplacement != null && fromReplacement.eIsProxy()) {
			InternalEObject oldFromReplacement = (InternalEObject)fromReplacement;
			fromReplacement = (FromReplacement)eResolveProxy(oldFromReplacement);
			if (fromReplacement != oldFromReplacement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.FROM_BINDING__FROM_REPLACEMENT, oldFromReplacement, fromReplacement));
			}
		}
		return fromReplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromReplacement basicGetFromReplacement() {
		return fromReplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromReplacement(FromReplacement newFromReplacement) {
		FromReplacement oldFromReplacement = fromReplacement;
		fromReplacement = newFromReplacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.FROM_BINDING__FROM_REPLACEMENT, oldFromReplacement, fromReplacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CvlPackage.FROM_BINDING__FROM_PLACEMENT:
				if (resolve) return getFromPlacement();
				return basicGetFromPlacement();
			case CvlPackage.FROM_BINDING__FROM_REPLACEMENT:
				if (resolve) return getFromReplacement();
				return basicGetFromReplacement();
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
			case CvlPackage.FROM_BINDING__FROM_PLACEMENT:
				setFromPlacement((FromPlacement)newValue);
				return;
			case CvlPackage.FROM_BINDING__FROM_REPLACEMENT:
				setFromReplacement((FromReplacement)newValue);
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
			case CvlPackage.FROM_BINDING__FROM_PLACEMENT:
				setFromPlacement((FromPlacement)null);
				return;
			case CvlPackage.FROM_BINDING__FROM_REPLACEMENT:
				setFromReplacement((FromReplacement)null);
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
			case CvlPackage.FROM_BINDING__FROM_PLACEMENT:
				return fromPlacement != null;
			case CvlPackage.FROM_BINDING__FROM_REPLACEMENT:
				return fromReplacement != null;
		}
		return super.eIsSet(featureID);
	}

} //FromBindingImpl
