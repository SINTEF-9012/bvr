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
import bvr.RepeatableVariationPoint;
import bvr.VClassOccurrence;
import bvr.VClassifier;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repeatable Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.RepeatableVariationPointImpl#getBindingClassifier <em>Binding Classifier</em>}</li>
 *   <li>{@link bvr.impl.RepeatableVariationPointImpl#getBindingVClassOcc <em>Binding VClass Occ</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RepeatableVariationPointImpl extends VariationPointImpl implements RepeatableVariationPoint {
	/**
	 * The cached value of the '{@link #getBindingClassifier() <em>Binding Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingClassifier()
	 * @generated
	 * @ordered
	 */
	protected VClassifier bindingClassifier;

	/**
	 * The cached value of the '{@link #getBindingVClassOcc() <em>Binding VClass Occ</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingVClassOcc()
	 * @generated
	 * @ordered
	 */
	protected VClassOccurrence bindingVClassOcc;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepeatableVariationPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.REPEATABLE_VARIATION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VClassifier getBindingClassifier() {
		if (bindingClassifier != null && bindingClassifier.eIsProxy()) {
			InternalEObject oldBindingClassifier = (InternalEObject)bindingClassifier;
			bindingClassifier = (VClassifier)eResolveProxy(oldBindingClassifier);
			if (bindingClassifier != oldBindingClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_CLASSIFIER, oldBindingClassifier, bindingClassifier));
			}
		}
		return bindingClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VClassifier basicGetBindingClassifier() {
		return bindingClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingClassifier(VClassifier newBindingClassifier) {
		VClassifier oldBindingClassifier = bindingClassifier;
		bindingClassifier = newBindingClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_CLASSIFIER, oldBindingClassifier, bindingClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VClassOccurrence getBindingVClassOcc() {
		if (bindingVClassOcc != null && bindingVClassOcc.eIsProxy()) {
			InternalEObject oldBindingVClassOcc = (InternalEObject)bindingVClassOcc;
			bindingVClassOcc = (VClassOccurrence)eResolveProxy(oldBindingVClassOcc);
			if (bindingVClassOcc != oldBindingVClassOcc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_VCLASS_OCC, oldBindingVClassOcc, bindingVClassOcc));
			}
		}
		return bindingVClassOcc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VClassOccurrence basicGetBindingVClassOcc() {
		return bindingVClassOcc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingVClassOcc(VClassOccurrence newBindingVClassOcc) {
		VClassOccurrence oldBindingVClassOcc = bindingVClassOcc;
		bindingVClassOcc = newBindingVClassOcc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_VCLASS_OCC, oldBindingVClassOcc, bindingVClassOcc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_CLASSIFIER:
				if (resolve) return getBindingClassifier();
				return basicGetBindingClassifier();
			case BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_VCLASS_OCC:
				if (resolve) return getBindingVClassOcc();
				return basicGetBindingVClassOcc();
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
			case BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_CLASSIFIER:
				setBindingClassifier((VClassifier)newValue);
				return;
			case BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_VCLASS_OCC:
				setBindingVClassOcc((VClassOccurrence)newValue);
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
			case BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_CLASSIFIER:
				setBindingClassifier((VClassifier)null);
				return;
			case BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_VCLASS_OCC:
				setBindingVClassOcc((VClassOccurrence)null);
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
			case BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_CLASSIFIER:
				return bindingClassifier != null;
			case BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_VCLASS_OCC:
				return bindingVClassOcc != null;
		}
		return super.eIsSet(featureID);
	}

} //RepeatableVariationPointImpl
