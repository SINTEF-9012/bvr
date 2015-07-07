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

import bvr.BoundaryElementBinding;
import bvr.BvrPackage;
import bvr.FragmentSubstitution;
import bvr.PlacementFragment;
import bvr.RepeatableVariationPoint;
import bvr.ReplacementFragmentType;
import bvr.VClassOccurrence;
import bvr.VClassifier;

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
 * An implementation of the model object '<em><b>Fragment Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.FragmentSubstitutionImpl#getBindingClassifier <em>Binding Classifier</em>}</li>
 *   <li>{@link bvr.impl.FragmentSubstitutionImpl#getBindingVClassOcc <em>Binding VClass Occ</em>}</li>
 *   <li>{@link bvr.impl.FragmentSubstitutionImpl#getBoundaryElementBinding <em>Boundary Element Binding</em>}</li>
 *   <li>{@link bvr.impl.FragmentSubstitutionImpl#getPlacement <em>Placement</em>}</li>
 *   <li>{@link bvr.impl.FragmentSubstitutionImpl#isMulti <em>Multi</em>}</li>
 *   <li>{@link bvr.impl.FragmentSubstitutionImpl#getReplacement <em>Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FragmentSubstitutionImpl extends ChoiceVariationPointImpl implements FragmentSubstitution {
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
	 * The cached value of the '{@link #getBoundaryElementBinding() <em>Boundary Element Binding</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundaryElementBinding()
	 * @generated
	 * @ordered
	 */
	protected EList<BoundaryElementBinding> boundaryElementBinding;

	/**
	 * The cached value of the '{@link #getPlacement() <em>Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlacement()
	 * @generated
	 * @ordered
	 */
	protected PlacementFragment placement;

	/**
	 * The default value of the '{@link #isMulti() <em>Multi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMulti()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTI_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMulti() <em>Multi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMulti()
	 * @generated
	 * @ordered
	 */
	protected boolean multi = MULTI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReplacement() <em>Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplacement()
	 * @generated
	 * @ordered
	 */
	protected ReplacementFragmentType replacement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FragmentSubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.FRAGMENT_SUBSTITUTION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_CLASSIFIER, oldBindingClassifier, bindingClassifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_CLASSIFIER, oldBindingClassifier, bindingClassifier));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_VCLASS_OCC, oldBindingVClassOcc, bindingVClassOcc));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_VCLASS_OCC, oldBindingVClassOcc, bindingVClassOcc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BoundaryElementBinding> getBoundaryElementBinding() {
		if (boundaryElementBinding == null) {
			boundaryElementBinding = new EObjectContainmentEList<BoundaryElementBinding>(BoundaryElementBinding.class, this, BvrPackage.FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING);
		}
		return boundaryElementBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacementFragment getPlacement() {
		if (placement != null && placement.eIsProxy()) {
			InternalEObject oldPlacement = (InternalEObject)placement;
			placement = (PlacementFragment)eResolveProxy(oldPlacement);
			if (placement != oldPlacement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.FRAGMENT_SUBSTITUTION__PLACEMENT, oldPlacement, placement));
			}
		}
		return placement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacementFragment basicGetPlacement() {
		return placement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlacement(PlacementFragment newPlacement) {
		PlacementFragment oldPlacement = placement;
		placement = newPlacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.FRAGMENT_SUBSTITUTION__PLACEMENT, oldPlacement, placement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMulti() {
		return multi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMulti(boolean newMulti) {
		boolean oldMulti = multi;
		multi = newMulti;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.FRAGMENT_SUBSTITUTION__MULTI, oldMulti, multi));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentType getReplacement() {
		if (replacement != null && replacement.eIsProxy()) {
			InternalEObject oldReplacement = (InternalEObject)replacement;
			replacement = (ReplacementFragmentType)eResolveProxy(oldReplacement);
			if (replacement != oldReplacement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.FRAGMENT_SUBSTITUTION__REPLACEMENT, oldReplacement, replacement));
			}
		}
		return replacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentType basicGetReplacement() {
		return replacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplacement(ReplacementFragmentType newReplacement) {
		ReplacementFragmentType oldReplacement = replacement;
		replacement = newReplacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.FRAGMENT_SUBSTITUTION__REPLACEMENT, oldReplacement, replacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING:
				return ((InternalEList<?>)getBoundaryElementBinding()).basicRemove(otherEnd, msgs);
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
			case BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_CLASSIFIER:
				if (resolve) return getBindingClassifier();
				return basicGetBindingClassifier();
			case BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_VCLASS_OCC:
				if (resolve) return getBindingVClassOcc();
				return basicGetBindingVClassOcc();
			case BvrPackage.FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING:
				return getBoundaryElementBinding();
			case BvrPackage.FRAGMENT_SUBSTITUTION__PLACEMENT:
				if (resolve) return getPlacement();
				return basicGetPlacement();
			case BvrPackage.FRAGMENT_SUBSTITUTION__MULTI:
				return isMulti();
			case BvrPackage.FRAGMENT_SUBSTITUTION__REPLACEMENT:
				if (resolve) return getReplacement();
				return basicGetReplacement();
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
			case BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_CLASSIFIER:
				setBindingClassifier((VClassifier)newValue);
				return;
			case BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_VCLASS_OCC:
				setBindingVClassOcc((VClassOccurrence)newValue);
				return;
			case BvrPackage.FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING:
				getBoundaryElementBinding().clear();
				getBoundaryElementBinding().addAll((Collection<? extends BoundaryElementBinding>)newValue);
				return;
			case BvrPackage.FRAGMENT_SUBSTITUTION__PLACEMENT:
				setPlacement((PlacementFragment)newValue);
				return;
			case BvrPackage.FRAGMENT_SUBSTITUTION__MULTI:
				setMulti((Boolean)newValue);
				return;
			case BvrPackage.FRAGMENT_SUBSTITUTION__REPLACEMENT:
				setReplacement((ReplacementFragmentType)newValue);
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
			case BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_CLASSIFIER:
				setBindingClassifier((VClassifier)null);
				return;
			case BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_VCLASS_OCC:
				setBindingVClassOcc((VClassOccurrence)null);
				return;
			case BvrPackage.FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING:
				getBoundaryElementBinding().clear();
				return;
			case BvrPackage.FRAGMENT_SUBSTITUTION__PLACEMENT:
				setPlacement((PlacementFragment)null);
				return;
			case BvrPackage.FRAGMENT_SUBSTITUTION__MULTI:
				setMulti(MULTI_EDEFAULT);
				return;
			case BvrPackage.FRAGMENT_SUBSTITUTION__REPLACEMENT:
				setReplacement((ReplacementFragmentType)null);
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
			case BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_CLASSIFIER:
				return bindingClassifier != null;
			case BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_VCLASS_OCC:
				return bindingVClassOcc != null;
			case BvrPackage.FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING:
				return boundaryElementBinding != null && !boundaryElementBinding.isEmpty();
			case BvrPackage.FRAGMENT_SUBSTITUTION__PLACEMENT:
				return placement != null;
			case BvrPackage.FRAGMENT_SUBSTITUTION__MULTI:
				return multi != MULTI_EDEFAULT;
			case BvrPackage.FRAGMENT_SUBSTITUTION__REPLACEMENT:
				return replacement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == RepeatableVariationPoint.class) {
			switch (derivedFeatureID) {
				case BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_CLASSIFIER: return BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_CLASSIFIER;
				case BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_VCLASS_OCC: return BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_VCLASS_OCC;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == RepeatableVariationPoint.class) {
			switch (baseFeatureID) {
				case BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_CLASSIFIER: return BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_CLASSIFIER;
				case BvrPackage.REPEATABLE_VARIATION_POINT__BINDING_VCLASS_OCC: return BvrPackage.FRAGMENT_SUBSTITUTION__BINDING_VCLASS_OCC;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (multi: ");
		result.append(multi);
		result.append(')');
		return result.toString();
	}

} //FragmentSubstitutionImpl
