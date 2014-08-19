/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.OVPType;
import bvr.ObjectHandle;
import bvr.OpaqueVariationPoint;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opaque Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.OpaqueVariationPointImpl#getPlaceHolder <em>Place Holder</em>}</li>
 *   <li>{@link bvr.impl.OpaqueVariationPointImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpaqueVariationPointImpl extends VariationPointImpl implements OpaqueVariationPoint {
	/**
	 * The cached value of the '{@link #getPlaceHolder() <em>Place Holder</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlaceHolder()
	 * @generated
	 * @ordered
	 */
	protected ObjectHandle placeHolder;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected OVPType type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueVariationPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.OPAQUE_VARIATION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectHandle getPlaceHolder() {
		return placeHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlaceHolder(ObjectHandle newPlaceHolder, NotificationChain msgs) {
		ObjectHandle oldPlaceHolder = placeHolder;
		placeHolder = newPlaceHolder;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BvrPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER, oldPlaceHolder, newPlaceHolder);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlaceHolder(ObjectHandle newPlaceHolder) {
		if (newPlaceHolder != placeHolder) {
			NotificationChain msgs = null;
			if (placeHolder != null)
				msgs = ((InternalEObject)placeHolder).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BvrPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER, null, msgs);
			if (newPlaceHolder != null)
				msgs = ((InternalEObject)newPlaceHolder).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BvrPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER, null, msgs);
			msgs = basicSetPlaceHolder(newPlaceHolder, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER, newPlaceHolder, newPlaceHolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OVPType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (OVPType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.OPAQUE_VARIATION_POINT__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OVPType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(OVPType newType) {
		OVPType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.OPAQUE_VARIATION_POINT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER:
				return basicSetPlaceHolder(null, msgs);
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
			case BvrPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER:
				return getPlaceHolder();
			case BvrPackage.OPAQUE_VARIATION_POINT__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case BvrPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER:
				setPlaceHolder((ObjectHandle)newValue);
				return;
			case BvrPackage.OPAQUE_VARIATION_POINT__TYPE:
				setType((OVPType)newValue);
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
			case BvrPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER:
				setPlaceHolder((ObjectHandle)null);
				return;
			case BvrPackage.OPAQUE_VARIATION_POINT__TYPE:
				setType((OVPType)null);
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
			case BvrPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER:
				return placeHolder != null;
			case BvrPackage.OPAQUE_VARIATION_POINT__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

} //OpaqueVariationPointImpl
