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

import bvr.BVRModel;
import bvr.BvrPackage;
import bvr.CompoundNode;
import bvr.CompoundResolution;
import bvr.ObjectHandle;
import bvr.VariationPoint;

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
 * An implementation of the model object '<em><b>BVR Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.BVRModelImpl#getVariabilityModel <em>Variability Model</em>}</li>
 *   <li>{@link bvr.impl.BVRModelImpl#getResolutionModels <em>Resolution Models</em>}</li>
 *   <li>{@link bvr.impl.BVRModelImpl#getBaseModelBase <em>Base Model Base</em>}</li>
 *   <li>{@link bvr.impl.BVRModelImpl#getBaseModelLibraries <em>Base Model Libraries</em>}</li>
 *   <li>{@link bvr.impl.BVRModelImpl#getRealizationModel <em>Realization Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BVRModelImpl extends VPackageImpl implements BVRModel {
	/**
	 * The cached value of the '{@link #getVariabilityModel() <em>Variability Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariabilityModel()
	 * @generated
	 * @ordered
	 */
	protected CompoundNode variabilityModel;

	/**
	 * The cached value of the '{@link #getResolutionModels() <em>Resolution Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolutionModels()
	 * @generated
	 * @ordered
	 */
	protected EList<CompoundResolution> resolutionModels;

	/**
	 * The cached value of the '{@link #getBaseModelBase() <em>Base Model Base</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseModelBase()
	 * @generated
	 * @ordered
	 */
	protected ObjectHandle baseModelBase;

	/**
	 * The cached value of the '{@link #getBaseModelLibraries() <em>Base Model Libraries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseModelLibraries()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectHandle> baseModelLibraries;

	/**
	 * The cached value of the '{@link #getRealizationModel() <em>Realization Model</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizationModel()
	 * @generated
	 * @ordered
	 */
	protected EList<VariationPoint> realizationModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BVRModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.BVR_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompoundNode getVariabilityModel() {
		return variabilityModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariabilityModel(CompoundNode newVariabilityModel, NotificationChain msgs) {
		CompoundNode oldVariabilityModel = variabilityModel;
		variabilityModel = newVariabilityModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BvrPackage.BVR_MODEL__VARIABILITY_MODEL, oldVariabilityModel, newVariabilityModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariabilityModel(CompoundNode newVariabilityModel) {
		if (newVariabilityModel != variabilityModel) {
			NotificationChain msgs = null;
			if (variabilityModel != null)
				msgs = ((InternalEObject)variabilityModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BvrPackage.BVR_MODEL__VARIABILITY_MODEL, null, msgs);
			if (newVariabilityModel != null)
				msgs = ((InternalEObject)newVariabilityModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BvrPackage.BVR_MODEL__VARIABILITY_MODEL, null, msgs);
			msgs = basicSetVariabilityModel(newVariabilityModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.BVR_MODEL__VARIABILITY_MODEL, newVariabilityModel, newVariabilityModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompoundResolution> getResolutionModels() {
		if (resolutionModels == null) {
			resolutionModels = new EObjectContainmentEList<CompoundResolution>(CompoundResolution.class, this, BvrPackage.BVR_MODEL__RESOLUTION_MODELS);
		}
		return resolutionModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectHandle getBaseModelBase() {
		return baseModelBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBaseModelBase(ObjectHandle newBaseModelBase, NotificationChain msgs) {
		ObjectHandle oldBaseModelBase = baseModelBase;
		baseModelBase = newBaseModelBase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BvrPackage.BVR_MODEL__BASE_MODEL_BASE, oldBaseModelBase, newBaseModelBase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseModelBase(ObjectHandle newBaseModelBase) {
		if (newBaseModelBase != baseModelBase) {
			NotificationChain msgs = null;
			if (baseModelBase != null)
				msgs = ((InternalEObject)baseModelBase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BvrPackage.BVR_MODEL__BASE_MODEL_BASE, null, msgs);
			if (newBaseModelBase != null)
				msgs = ((InternalEObject)newBaseModelBase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BvrPackage.BVR_MODEL__BASE_MODEL_BASE, null, msgs);
			msgs = basicSetBaseModelBase(newBaseModelBase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.BVR_MODEL__BASE_MODEL_BASE, newBaseModelBase, newBaseModelBase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectHandle> getBaseModelLibraries() {
		if (baseModelLibraries == null) {
			baseModelLibraries = new EObjectContainmentEList<ObjectHandle>(ObjectHandle.class, this, BvrPackage.BVR_MODEL__BASE_MODEL_LIBRARIES);
		}
		return baseModelLibraries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariationPoint> getRealizationModel() {
		if (realizationModel == null) {
			realizationModel = new EObjectContainmentEList<VariationPoint>(VariationPoint.class, this, BvrPackage.BVR_MODEL__REALIZATION_MODEL);
		}
		return realizationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.BVR_MODEL__VARIABILITY_MODEL:
				return basicSetVariabilityModel(null, msgs);
			case BvrPackage.BVR_MODEL__RESOLUTION_MODELS:
				return ((InternalEList<?>)getResolutionModels()).basicRemove(otherEnd, msgs);
			case BvrPackage.BVR_MODEL__BASE_MODEL_BASE:
				return basicSetBaseModelBase(null, msgs);
			case BvrPackage.BVR_MODEL__BASE_MODEL_LIBRARIES:
				return ((InternalEList<?>)getBaseModelLibraries()).basicRemove(otherEnd, msgs);
			case BvrPackage.BVR_MODEL__REALIZATION_MODEL:
				return ((InternalEList<?>)getRealizationModel()).basicRemove(otherEnd, msgs);
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
			case BvrPackage.BVR_MODEL__VARIABILITY_MODEL:
				return getVariabilityModel();
			case BvrPackage.BVR_MODEL__RESOLUTION_MODELS:
				return getResolutionModels();
			case BvrPackage.BVR_MODEL__BASE_MODEL_BASE:
				return getBaseModelBase();
			case BvrPackage.BVR_MODEL__BASE_MODEL_LIBRARIES:
				return getBaseModelLibraries();
			case BvrPackage.BVR_MODEL__REALIZATION_MODEL:
				return getRealizationModel();
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
			case BvrPackage.BVR_MODEL__VARIABILITY_MODEL:
				setVariabilityModel((CompoundNode)newValue);
				return;
			case BvrPackage.BVR_MODEL__RESOLUTION_MODELS:
				getResolutionModels().clear();
				getResolutionModels().addAll((Collection<? extends CompoundResolution>)newValue);
				return;
			case BvrPackage.BVR_MODEL__BASE_MODEL_BASE:
				setBaseModelBase((ObjectHandle)newValue);
				return;
			case BvrPackage.BVR_MODEL__BASE_MODEL_LIBRARIES:
				getBaseModelLibraries().clear();
				getBaseModelLibraries().addAll((Collection<? extends ObjectHandle>)newValue);
				return;
			case BvrPackage.BVR_MODEL__REALIZATION_MODEL:
				getRealizationModel().clear();
				getRealizationModel().addAll((Collection<? extends VariationPoint>)newValue);
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
			case BvrPackage.BVR_MODEL__VARIABILITY_MODEL:
				setVariabilityModel((CompoundNode)null);
				return;
			case BvrPackage.BVR_MODEL__RESOLUTION_MODELS:
				getResolutionModels().clear();
				return;
			case BvrPackage.BVR_MODEL__BASE_MODEL_BASE:
				setBaseModelBase((ObjectHandle)null);
				return;
			case BvrPackage.BVR_MODEL__BASE_MODEL_LIBRARIES:
				getBaseModelLibraries().clear();
				return;
			case BvrPackage.BVR_MODEL__REALIZATION_MODEL:
				getRealizationModel().clear();
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
			case BvrPackage.BVR_MODEL__VARIABILITY_MODEL:
				return variabilityModel != null;
			case BvrPackage.BVR_MODEL__RESOLUTION_MODELS:
				return resolutionModels != null && !resolutionModels.isEmpty();
			case BvrPackage.BVR_MODEL__BASE_MODEL_BASE:
				return baseModelBase != null;
			case BvrPackage.BVR_MODEL__BASE_MODEL_LIBRARIES:
				return baseModelLibraries != null && !baseModelLibraries.isEmpty();
			case BvrPackage.BVR_MODEL__REALIZATION_MODEL:
				return realizationModel != null && !realizationModel.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BVRModelImpl
