/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.ObjectHandle;
import bvr.ParametricSlotAssignment;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parametric Slot Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.ParametricSlotAssignmentImpl#getSlotIdentifier <em>Slot Identifier</em>}</li>
 *   <li>{@link bvr.impl.ParametricSlotAssignmentImpl#getSlotOwner <em>Slot Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParametricSlotAssignmentImpl extends ParametricVariationPointImpl implements ParametricSlotAssignment {
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
	protected ParametricSlotAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.PARAMETRIC_SLOT_ASSIGNMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_IDENTIFIER, oldSlotIdentifier, slotIdentifier));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_OWNER, oldSlotOwner, newSlotOwner);
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
				msgs = ((InternalEObject)slotOwner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_OWNER, null, msgs);
			if (newSlotOwner != null)
				msgs = ((InternalEObject)newSlotOwner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_OWNER, null, msgs);
			msgs = basicSetSlotOwner(newSlotOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_OWNER, newSlotOwner, newSlotOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_OWNER:
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
			case BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_IDENTIFIER:
				return getSlotIdentifier();
			case BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_OWNER:
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
			case BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_IDENTIFIER:
				setSlotIdentifier((String)newValue);
				return;
			case BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_OWNER:
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
			case BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_IDENTIFIER:
				setSlotIdentifier(SLOT_IDENTIFIER_EDEFAULT);
				return;
			case BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_OWNER:
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
			case BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_IDENTIFIER:
				return SLOT_IDENTIFIER_EDEFAULT == null ? slotIdentifier != null : !SLOT_IDENTIFIER_EDEFAULT.equals(slotIdentifier);
			case BvrPackage.PARAMETRIC_SLOT_ASSIGNMENT__SLOT_OWNER:
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

} //ParametricSlotAssignmentImpl
