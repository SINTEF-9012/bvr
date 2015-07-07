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
import bvr.ResolutionLiteralDefinition;
import bvr.VType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolution Literal Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.ResolutionLiteralDefinitionImpl#getLiteralType <em>Literal Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResolutionLiteralDefinitionImpl extends CompoundResolutionImpl implements ResolutionLiteralDefinition {
	/**
	 * The cached value of the '{@link #getLiteralType() <em>Literal Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralType()
	 * @generated
	 * @ordered
	 */
	protected VType literalType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResolutionLiteralDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.RESOLUTION_LITERAL_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VType getLiteralType() {
		if (literalType != null && literalType.eIsProxy()) {
			InternalEObject oldLiteralType = (InternalEObject)literalType;
			literalType = (VType)eResolveProxy(oldLiteralType);
			if (literalType != oldLiteralType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.RESOLUTION_LITERAL_DEFINITION__LITERAL_TYPE, oldLiteralType, literalType));
			}
		}
		return literalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VType basicGetLiteralType() {
		return literalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiteralType(VType newLiteralType) {
		VType oldLiteralType = literalType;
		literalType = newLiteralType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.RESOLUTION_LITERAL_DEFINITION__LITERAL_TYPE, oldLiteralType, literalType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.RESOLUTION_LITERAL_DEFINITION__LITERAL_TYPE:
				if (resolve) return getLiteralType();
				return basicGetLiteralType();
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
			case BvrPackage.RESOLUTION_LITERAL_DEFINITION__LITERAL_TYPE:
				setLiteralType((VType)newValue);
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
			case BvrPackage.RESOLUTION_LITERAL_DEFINITION__LITERAL_TYPE:
				setLiteralType((VType)null);
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
			case BvrPackage.RESOLUTION_LITERAL_DEFINITION__LITERAL_TYPE:
				return literalType != null;
		}
		return super.eIsSet(featureID);
	}

} //ResolutionLiteralDefinitionImpl
