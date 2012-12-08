/**
 */
package cvl.impl;

import cvl.BaseModelHandle;
import cvl.OVPType;
import cvl.ObjectHandle;
import cvl.OpaqueVariationPoint;
import cvl.cvlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opaque Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.OpaqueVariationPointImpl#getPlaceHolder <em>Place Holder</em>}</li>
 *   <li>{@link cvl.impl.OpaqueVariationPointImpl#getSourceObject <em>Source Object</em>}</li>
 *   <li>{@link cvl.impl.OpaqueVariationPointImpl#getType <em>Type</em>}</li>
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
	protected BaseModelHandle placeHolder;

	/**
	 * The cached value of the '{@link #getSourceObject() <em>Source Object</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceObject()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectHandle> sourceObject;

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
		return cvlPackage.Literals.OPAQUE_VARIATION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseModelHandle getPlaceHolder() {
		return placeHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlaceHolder(BaseModelHandle newPlaceHolder, NotificationChain msgs) {
		BaseModelHandle oldPlaceHolder = placeHolder;
		placeHolder = newPlaceHolder;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, cvlPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER, oldPlaceHolder, newPlaceHolder);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlaceHolder(BaseModelHandle newPlaceHolder) {
		if (newPlaceHolder != placeHolder) {
			NotificationChain msgs = null;
			if (placeHolder != null)
				msgs = ((InternalEObject)placeHolder).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - cvlPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER, null, msgs);
			if (newPlaceHolder != null)
				msgs = ((InternalEObject)newPlaceHolder).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - cvlPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER, null, msgs);
			msgs = basicSetPlaceHolder(newPlaceHolder, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER, newPlaceHolder, newPlaceHolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectHandle> getSourceObject() {
		if (sourceObject == null) {
			sourceObject = new EObjectContainmentEList<ObjectHandle>(ObjectHandle.class, this, cvlPackage.OPAQUE_VARIATION_POINT__SOURCE_OBJECT);
		}
		return sourceObject;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, cvlPackage.OPAQUE_VARIATION_POINT__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.OPAQUE_VARIATION_POINT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case cvlPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER:
				return basicSetPlaceHolder(null, msgs);
			case cvlPackage.OPAQUE_VARIATION_POINT__SOURCE_OBJECT:
				return ((InternalEList<?>)getSourceObject()).basicRemove(otherEnd, msgs);
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
			case cvlPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER:
				return getPlaceHolder();
			case cvlPackage.OPAQUE_VARIATION_POINT__SOURCE_OBJECT:
				return getSourceObject();
			case cvlPackage.OPAQUE_VARIATION_POINT__TYPE:
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case cvlPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER:
				setPlaceHolder((BaseModelHandle)newValue);
				return;
			case cvlPackage.OPAQUE_VARIATION_POINT__SOURCE_OBJECT:
				getSourceObject().clear();
				getSourceObject().addAll((Collection<? extends ObjectHandle>)newValue);
				return;
			case cvlPackage.OPAQUE_VARIATION_POINT__TYPE:
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
			case cvlPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER:
				setPlaceHolder((BaseModelHandle)null);
				return;
			case cvlPackage.OPAQUE_VARIATION_POINT__SOURCE_OBJECT:
				getSourceObject().clear();
				return;
			case cvlPackage.OPAQUE_VARIATION_POINT__TYPE:
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
			case cvlPackage.OPAQUE_VARIATION_POINT__PLACE_HOLDER:
				return placeHolder != null;
			case cvlPackage.OPAQUE_VARIATION_POINT__SOURCE_OBJECT:
				return sourceObject != null && !sourceObject.isEmpty();
			case cvlPackage.OPAQUE_VARIATION_POINT__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

} //OpaqueVariationPointImpl
