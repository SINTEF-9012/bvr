/**
 */
package cvl.impl;

import cvl.ObjectHandle;
import cvl.ParametricObjectSubstitution;
import cvl.cvlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parametric Object Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.ParametricObjectSubstitutionImpl#getPlacementObject <em>Placement Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParametricObjectSubstitutionImpl extends ParametricVariationPointImpl implements ParametricObjectSubstitution {
	/**
	 * The cached value of the '{@link #getPlacementObject() <em>Placement Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlacementObject()
	 * @generated
	 * @ordered
	 */
	protected ObjectHandle placementObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParametricObjectSubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return cvlPackage.Literals.PARAMETRIC_OBJECT_SUBSTITUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectHandle getPlacementObject() {
		return placementObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlacementObject(ObjectHandle newPlacementObject, NotificationChain msgs) {
		ObjectHandle oldPlacementObject = placementObject;
		placementObject = newPlacementObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, cvlPackage.PARAMETRIC_OBJECT_SUBSTITUTION__PLACEMENT_OBJECT, oldPlacementObject, newPlacementObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlacementObject(ObjectHandle newPlacementObject) {
		if (newPlacementObject != placementObject) {
			NotificationChain msgs = null;
			if (placementObject != null)
				msgs = ((InternalEObject)placementObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - cvlPackage.PARAMETRIC_OBJECT_SUBSTITUTION__PLACEMENT_OBJECT, null, msgs);
			if (newPlacementObject != null)
				msgs = ((InternalEObject)newPlacementObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - cvlPackage.PARAMETRIC_OBJECT_SUBSTITUTION__PLACEMENT_OBJECT, null, msgs);
			msgs = basicSetPlacementObject(newPlacementObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.PARAMETRIC_OBJECT_SUBSTITUTION__PLACEMENT_OBJECT, newPlacementObject, newPlacementObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case cvlPackage.PARAMETRIC_OBJECT_SUBSTITUTION__PLACEMENT_OBJECT:
				return basicSetPlacementObject(null, msgs);
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
			case cvlPackage.PARAMETRIC_OBJECT_SUBSTITUTION__PLACEMENT_OBJECT:
				return getPlacementObject();
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
			case cvlPackage.PARAMETRIC_OBJECT_SUBSTITUTION__PLACEMENT_OBJECT:
				setPlacementObject((ObjectHandle)newValue);
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
			case cvlPackage.PARAMETRIC_OBJECT_SUBSTITUTION__PLACEMENT_OBJECT:
				setPlacementObject((ObjectHandle)null);
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
			case cvlPackage.PARAMETRIC_OBJECT_SUBSTITUTION__PLACEMENT_OBJECT:
				return placementObject != null;
		}
		return super.eIsSet(featureID);
	}

} //ParametricObjectSubstitutionImpl
