/**
 */
package cvl.impl;

import cvl.ObjectHandle;
import cvl.SlotValueExistence;
import cvl.cvlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slot Value Existence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.SlotValueExistenceImpl#getSlotIdentifier <em>Slot Identifier</em>}</li>
 *   <li>{@link cvl.impl.SlotValueExistenceImpl#getSlotOwner <em>Slot Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SlotValueExistenceImpl extends ChoiceVariationPointImpl implements SlotValueExistence {
	/**
	 * The default value of the '{@link #getSlotIdentifier() <em>Slot Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlotIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String SLOT_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSlotIdentifier() <em>Slot Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlotIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String slotIdentifier = SLOT_IDENTIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSlotOwner() <em>Slot Owner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlotOwner()
	 * @generated
	 * @ordered
	 */
	protected ObjectHandle slotOwner;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SlotValueExistenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return cvlPackage.Literals.SLOT_VALUE_EXISTENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSlotIdentifier() {
		return slotIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlotIdentifier(String newSlotIdentifier) {
		String oldSlotIdentifier = slotIdentifier;
		slotIdentifier = newSlotIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_IDENTIFIER, oldSlotIdentifier, slotIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectHandle getSlotOwner() {
		return slotOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSlotOwner(ObjectHandle newSlotOwner, NotificationChain msgs) {
		ObjectHandle oldSlotOwner = slotOwner;
		slotOwner = newSlotOwner;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_OWNER, oldSlotOwner, newSlotOwner);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlotOwner(ObjectHandle newSlotOwner) {
		if (newSlotOwner != slotOwner) {
			NotificationChain msgs = null;
			if (slotOwner != null)
				msgs = ((InternalEObject)slotOwner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_OWNER, null, msgs);
			if (newSlotOwner != null)
				msgs = ((InternalEObject)newSlotOwner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_OWNER, null, msgs);
			msgs = basicSetSlotOwner(newSlotOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_OWNER, newSlotOwner, newSlotOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_OWNER:
				return basicSetSlotOwner(null, msgs);
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
			case cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_IDENTIFIER:
				return getSlotIdentifier();
			case cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_OWNER:
				return getSlotOwner();
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
			case cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_IDENTIFIER:
				setSlotIdentifier((String)newValue);
				return;
			case cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_OWNER:
				setSlotOwner((ObjectHandle)newValue);
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
			case cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_IDENTIFIER:
				setSlotIdentifier(SLOT_IDENTIFIER_EDEFAULT);
				return;
			case cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_OWNER:
				setSlotOwner((ObjectHandle)null);
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
			case cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_IDENTIFIER:
				return SLOT_IDENTIFIER_EDEFAULT == null ? slotIdentifier != null : !SLOT_IDENTIFIER_EDEFAULT.equals(slotIdentifier);
			case cvlPackage.SLOT_VALUE_EXISTENCE__SLOT_OWNER:
				return slotOwner != null;
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
		result.append(" (slotIdentifier: ");
		result.append(slotIdentifier);
		result.append(')');
		return result.toString();
	}

} //SlotValueExistenceImpl
