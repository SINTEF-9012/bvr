/**
 */
package CVLMetamodelMaster.Main.impl;

import CVLMetamodelMaster.Main.MainPackage;
import CVLMetamodelMaster.Main.ObjectHandle;
import CVLMetamodelMaster.Main.SlotAssignment;
import CVLMetamodelMaster.Main.ValueSpecification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slot Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.impl.SlotAssignmentImpl#getSlotIdentifier <em>Slot Identifier</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.impl.SlotAssignmentImpl#getValue <em>Value</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.impl.SlotAssignmentImpl#getSlotOwner <em>Slot Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SlotAssignmentImpl extends ChoiceVariationPointImpl implements SlotAssignment {
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
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification value;

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
	protected SlotAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MainPackage.Literals.SLOT_ASSIGNMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.SLOT_ASSIGNMENT__SLOT_IDENTIFIER, oldSlotIdentifier, slotIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(ValueSpecification newValue, NotificationChain msgs) {
		ValueSpecification oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MainPackage.SLOT_ASSIGNMENT__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(ValueSpecification newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MainPackage.SLOT_ASSIGNMENT__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MainPackage.SLOT_ASSIGNMENT__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.SLOT_ASSIGNMENT__VALUE, newValue, newValue));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MainPackage.SLOT_ASSIGNMENT__SLOT_OWNER, oldSlotOwner, newSlotOwner);
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
				msgs = ((InternalEObject)slotOwner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MainPackage.SLOT_ASSIGNMENT__SLOT_OWNER, null, msgs);
			if (newSlotOwner != null)
				msgs = ((InternalEObject)newSlotOwner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MainPackage.SLOT_ASSIGNMENT__SLOT_OWNER, null, msgs);
			msgs = basicSetSlotOwner(newSlotOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.SLOT_ASSIGNMENT__SLOT_OWNER, newSlotOwner, newSlotOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MainPackage.SLOT_ASSIGNMENT__VALUE:
				return basicSetValue(null, msgs);
			case MainPackage.SLOT_ASSIGNMENT__SLOT_OWNER:
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
			case MainPackage.SLOT_ASSIGNMENT__SLOT_IDENTIFIER:
				return getSlotIdentifier();
			case MainPackage.SLOT_ASSIGNMENT__VALUE:
				return getValue();
			case MainPackage.SLOT_ASSIGNMENT__SLOT_OWNER:
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
			case MainPackage.SLOT_ASSIGNMENT__SLOT_IDENTIFIER:
				setSlotIdentifier((String)newValue);
				return;
			case MainPackage.SLOT_ASSIGNMENT__VALUE:
				setValue((ValueSpecification)newValue);
				return;
			case MainPackage.SLOT_ASSIGNMENT__SLOT_OWNER:
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
			case MainPackage.SLOT_ASSIGNMENT__SLOT_IDENTIFIER:
				setSlotIdentifier(SLOT_IDENTIFIER_EDEFAULT);
				return;
			case MainPackage.SLOT_ASSIGNMENT__VALUE:
				setValue((ValueSpecification)null);
				return;
			case MainPackage.SLOT_ASSIGNMENT__SLOT_OWNER:
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
			case MainPackage.SLOT_ASSIGNMENT__SLOT_IDENTIFIER:
				return SLOT_IDENTIFIER_EDEFAULT == null ? slotIdentifier != null : !SLOT_IDENTIFIER_EDEFAULT.equals(slotIdentifier);
			case MainPackage.SLOT_ASSIGNMENT__VALUE:
				return value != null;
			case MainPackage.SLOT_ASSIGNMENT__SLOT_OWNER:
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

} //SlotAssignmentImpl
