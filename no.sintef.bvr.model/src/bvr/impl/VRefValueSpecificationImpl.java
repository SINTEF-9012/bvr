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
import bvr.VRefValueSpecification;
import bvr.VSpecResolution;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VRef Value Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.VRefValueSpecificationImpl#getVSpecResolution <em>VSpec Resolution</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VRefValueSpecificationImpl extends ValueSpecificationImpl implements VRefValueSpecification {
	/**
	 * The cached value of the '{@link #getVSpecResolution() <em>VSpec Resolution</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVSpecResolution()
	 * @generated
	 * @ordered
	 */
	protected EList<VSpecResolution> vSpecResolution;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VRefValueSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.VREF_VALUE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VSpecResolution> getVSpecResolution() {
		if (vSpecResolution == null) {
			vSpecResolution = new EObjectResolvingEList<VSpecResolution>(VSpecResolution.class, this, BvrPackage.VREF_VALUE_SPECIFICATION__VSPEC_RESOLUTION);
		}
		return vSpecResolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.VREF_VALUE_SPECIFICATION__VSPEC_RESOLUTION:
				return getVSpecResolution();
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
			case BvrPackage.VREF_VALUE_SPECIFICATION__VSPEC_RESOLUTION:
				getVSpecResolution().clear();
				getVSpecResolution().addAll((Collection<? extends VSpecResolution>)newValue);
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
			case BvrPackage.VREF_VALUE_SPECIFICATION__VSPEC_RESOLUTION:
				getVSpecResolution().clear();
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
			case BvrPackage.VREF_VALUE_SPECIFICATION__VSPEC_RESOLUTION:
				return vSpecResolution != null && !vSpecResolution.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VRefValueSpecificationImpl
