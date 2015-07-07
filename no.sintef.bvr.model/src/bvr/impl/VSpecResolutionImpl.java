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
import bvr.VSpec;
import bvr.VSpecResolution;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VSpec Resolution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.VSpecResolutionImpl#getResolvedVSpec <em>Resolved VSpec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VSpecResolutionImpl extends NamedElementImpl implements VSpecResolution {
	/**
	 * The cached value of the '{@link #getResolvedVSpec() <em>Resolved VSpec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedVSpec()
	 * @generated
	 * @ordered
	 */
	protected VSpec resolvedVSpec;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VSpecResolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.VSPEC_RESOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec getResolvedVSpec() {
		if (resolvedVSpec != null && resolvedVSpec.eIsProxy()) {
			InternalEObject oldResolvedVSpec = (InternalEObject)resolvedVSpec;
			resolvedVSpec = (VSpec)eResolveProxy(oldResolvedVSpec);
			if (resolvedVSpec != oldResolvedVSpec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.VSPEC_RESOLUTION__RESOLVED_VSPEC, oldResolvedVSpec, resolvedVSpec));
			}
		}
		return resolvedVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec basicGetResolvedVSpec() {
		return resolvedVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolvedVSpec(VSpec newResolvedVSpec) {
		VSpec oldResolvedVSpec = resolvedVSpec;
		resolvedVSpec = newResolvedVSpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.VSPEC_RESOLUTION__RESOLVED_VSPEC, oldResolvedVSpec, resolvedVSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.VSPEC_RESOLUTION__RESOLVED_VSPEC:
				if (resolve) return getResolvedVSpec();
				return basicGetResolvedVSpec();
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
			case BvrPackage.VSPEC_RESOLUTION__RESOLVED_VSPEC:
				setResolvedVSpec((VSpec)newValue);
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
			case BvrPackage.VSPEC_RESOLUTION__RESOLVED_VSPEC:
				setResolvedVSpec((VSpec)null);
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
			case BvrPackage.VSPEC_RESOLUTION__RESOLVED_VSPEC:
				return resolvedVSpec != null;
		}
		return super.eIsSet(featureID);
	}

} //VSpecResolutionImpl
