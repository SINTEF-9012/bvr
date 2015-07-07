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
import bvr.PlacementFragment;
import bvr.ReplacementBoundaryElement;
import bvr.ReplacementFragmentType;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Replacement Fragment Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.ReplacementFragmentTypeImpl#getReplacementBoundaryElement <em>Replacement Boundary Element</em>}</li>
 *   <li>{@link bvr.impl.ReplacementFragmentTypeImpl#getPlacementFragment <em>Placement Fragment</em>}</li>
 *   <li>{@link bvr.impl.ReplacementFragmentTypeImpl#getSourceObject <em>Source Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReplacementFragmentTypeImpl extends VariabletypeImpl implements ReplacementFragmentType {
	/**
	 * The cached value of the '{@link #getReplacementBoundaryElement() <em>Replacement Boundary Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplacementBoundaryElement()
	 * @generated
	 * @ordered
	 */
	protected EList<ReplacementBoundaryElement> replacementBoundaryElement;

	/**
	 * The cached value of the '{@link #getPlacementFragment() <em>Placement Fragment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlacementFragment()
	 * @generated
	 * @ordered
	 */
	protected EList<PlacementFragment> placementFragment;

	/**
	 * The cached value of the '{@link #getSourceObject() <em>Source Object</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceObject()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectHandle> sourceObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReplacementFragmentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.REPLACEMENT_FRAGMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReplacementBoundaryElement> getReplacementBoundaryElement() {
		if (replacementBoundaryElement == null) {
			replacementBoundaryElement = new EObjectContainmentEList<ReplacementBoundaryElement>(ReplacementBoundaryElement.class, this, BvrPackage.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT);
		}
		return replacementBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PlacementFragment> getPlacementFragment() {
		if (placementFragment == null) {
			placementFragment = new EObjectContainmentEList<PlacementFragment>(PlacementFragment.class, this, BvrPackage.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT);
		}
		return placementFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectHandle> getSourceObject() {
		if (sourceObject == null) {
			sourceObject = new EObjectContainmentEList<ObjectHandle>(ObjectHandle.class, this, BvrPackage.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT);
		}
		return sourceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT:
				return ((InternalEList<?>)getReplacementBoundaryElement()).basicRemove(otherEnd, msgs);
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT:
				return ((InternalEList<?>)getPlacementFragment()).basicRemove(otherEnd, msgs);
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT:
				return ((InternalEList<?>)getSourceObject()).basicRemove(otherEnd, msgs);
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
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT:
				return getReplacementBoundaryElement();
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT:
				return getPlacementFragment();
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT:
				return getSourceObject();
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
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT:
				getReplacementBoundaryElement().clear();
				getReplacementBoundaryElement().addAll((Collection<? extends ReplacementBoundaryElement>)newValue);
				return;
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT:
				getPlacementFragment().clear();
				getPlacementFragment().addAll((Collection<? extends PlacementFragment>)newValue);
				return;
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT:
				getSourceObject().clear();
				getSourceObject().addAll((Collection<? extends ObjectHandle>)newValue);
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
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT:
				getReplacementBoundaryElement().clear();
				return;
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT:
				getPlacementFragment().clear();
				return;
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT:
				getSourceObject().clear();
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
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT:
				return replacementBoundaryElement != null && !replacementBoundaryElement.isEmpty();
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT:
				return placementFragment != null && !placementFragment.isEmpty();
			case BvrPackage.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT:
				return sourceObject != null && !sourceObject.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ReplacementFragmentTypeImpl
