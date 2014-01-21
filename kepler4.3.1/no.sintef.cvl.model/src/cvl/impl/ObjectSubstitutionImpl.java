/**
 */
package cvl.impl;

import cvl.CvlPackage;
import cvl.ObjectHandle;
import cvl.ObjectSubstitution;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.ObjectSubstitutionImpl#getPlacementObject <em>Placement Object</em>}</li>
 *   <li>{@link cvl.impl.ObjectSubstitutionImpl#getReplacementObject <em>Replacement Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectSubstitutionImpl extends ChoiceVariationPointImpl implements ObjectSubstitution {
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
	 * The cached value of the '{@link #getReplacementObject() <em>Replacement Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplacementObject()
	 * @generated
	 * @ordered
	 */
	protected ObjectHandle replacementObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectSubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.OBJECT_SUBSTITUTION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CvlPackage.OBJECT_SUBSTITUTION__PLACEMENT_OBJECT, oldPlacementObject, newPlacementObject);
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
				msgs = ((InternalEObject)placementObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CvlPackage.OBJECT_SUBSTITUTION__PLACEMENT_OBJECT, null, msgs);
			if (newPlacementObject != null)
				msgs = ((InternalEObject)newPlacementObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CvlPackage.OBJECT_SUBSTITUTION__PLACEMENT_OBJECT, null, msgs);
			msgs = basicSetPlacementObject(newPlacementObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.OBJECT_SUBSTITUTION__PLACEMENT_OBJECT, newPlacementObject, newPlacementObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectHandle getReplacementObject() {
		return replacementObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReplacementObject(ObjectHandle newReplacementObject, NotificationChain msgs) {
		ObjectHandle oldReplacementObject = replacementObject;
		replacementObject = newReplacementObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CvlPackage.OBJECT_SUBSTITUTION__REPLACEMENT_OBJECT, oldReplacementObject, newReplacementObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplacementObject(ObjectHandle newReplacementObject) {
		if (newReplacementObject != replacementObject) {
			NotificationChain msgs = null;
			if (replacementObject != null)
				msgs = ((InternalEObject)replacementObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CvlPackage.OBJECT_SUBSTITUTION__REPLACEMENT_OBJECT, null, msgs);
			if (newReplacementObject != null)
				msgs = ((InternalEObject)newReplacementObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CvlPackage.OBJECT_SUBSTITUTION__REPLACEMENT_OBJECT, null, msgs);
			msgs = basicSetReplacementObject(newReplacementObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.OBJECT_SUBSTITUTION__REPLACEMENT_OBJECT, newReplacementObject, newReplacementObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.OBJECT_SUBSTITUTION__PLACEMENT_OBJECT:
				return basicSetPlacementObject(null, msgs);
			case CvlPackage.OBJECT_SUBSTITUTION__REPLACEMENT_OBJECT:
				return basicSetReplacementObject(null, msgs);
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
			case CvlPackage.OBJECT_SUBSTITUTION__PLACEMENT_OBJECT:
				return getPlacementObject();
			case CvlPackage.OBJECT_SUBSTITUTION__REPLACEMENT_OBJECT:
				return getReplacementObject();
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
			case CvlPackage.OBJECT_SUBSTITUTION__PLACEMENT_OBJECT:
				setPlacementObject((ObjectHandle)newValue);
				return;
			case CvlPackage.OBJECT_SUBSTITUTION__REPLACEMENT_OBJECT:
				setReplacementObject((ObjectHandle)newValue);
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
			case CvlPackage.OBJECT_SUBSTITUTION__PLACEMENT_OBJECT:
				setPlacementObject((ObjectHandle)null);
				return;
			case CvlPackage.OBJECT_SUBSTITUTION__REPLACEMENT_OBJECT:
				setReplacementObject((ObjectHandle)null);
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
			case CvlPackage.OBJECT_SUBSTITUTION__PLACEMENT_OBJECT:
				return placementObject != null;
			case CvlPackage.OBJECT_SUBSTITUTION__REPLACEMENT_OBJECT:
				return replacementObject != null;
		}
		return super.eIsSet(featureID);
	}

} //ObjectSubstitutionImpl
