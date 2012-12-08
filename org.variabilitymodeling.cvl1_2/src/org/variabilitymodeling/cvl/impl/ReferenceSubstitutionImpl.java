/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.impl;



import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.variabilitymodeling.cvl.CvlPackage;
import org.variabilitymodeling.cvl.PlacementObject;
import org.variabilitymodeling.cvl.ReferenceSubstitution;
import org.variabilitymodeling.cvl.ReplacementObject;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.ReferenceSubstitutionImpl#getPlacement <em>Placement</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.ReferenceSubstitutionImpl#getReplacement <em>Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceSubstitutionImpl extends SubstitutionImpl implements ReferenceSubstitution {
	/**
	 * The cached value of the '{@link #getPlacement() <em>Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlacement()
	 * @generated
	 * @ordered
	 */
	protected PlacementObject placement;

	/**
	 * The cached value of the '{@link #getReplacement() <em>Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplacement()
	 * @generated
	 * @ordered
	 */
	protected ReplacementObject replacement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceSubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.REFERENCE_SUBSTITUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacementObject getPlacement() {
		if (placement != null && placement.eIsProxy()) {
			InternalEObject oldPlacement = (InternalEObject)placement;
			placement = (PlacementObject)eResolveProxy(oldPlacement);
			if (placement != oldPlacement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.REFERENCE_SUBSTITUTION__PLACEMENT, oldPlacement, placement));
			}
		}
		return placement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacementObject basicGetPlacement() {
		return placement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlacement(PlacementObject newPlacement) {
		PlacementObject oldPlacement = placement;
		placement = newPlacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.REFERENCE_SUBSTITUTION__PLACEMENT, oldPlacement, placement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementObject getReplacement() {
		if (replacement != null && replacement.eIsProxy()) {
			InternalEObject oldReplacement = (InternalEObject)replacement;
			replacement = (ReplacementObject)eResolveProxy(oldReplacement);
			if (replacement != oldReplacement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.REFERENCE_SUBSTITUTION__REPLACEMENT, oldReplacement, replacement));
			}
		}
		return replacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementObject basicGetReplacement() {
		return replacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplacement(ReplacementObject newReplacement) {
		ReplacementObject oldReplacement = replacement;
		replacement = newReplacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.REFERENCE_SUBSTITUTION__REPLACEMENT, oldReplacement, replacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitReferenceSubstitution(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CvlPackage.REFERENCE_SUBSTITUTION__PLACEMENT:
				if (resolve) return getPlacement();
				return basicGetPlacement();
			case CvlPackage.REFERENCE_SUBSTITUTION__REPLACEMENT:
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
			case CvlPackage.REFERENCE_SUBSTITUTION__PLACEMENT:
				setPlacement((PlacementObject)newValue);
				return;
			case CvlPackage.REFERENCE_SUBSTITUTION__REPLACEMENT:
				setReplacement((ReplacementObject)newValue);
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
			case CvlPackage.REFERENCE_SUBSTITUTION__PLACEMENT:
				setPlacement((PlacementObject)null);
				return;
			case CvlPackage.REFERENCE_SUBSTITUTION__REPLACEMENT:
				setReplacement((ReplacementObject)null);
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
			case CvlPackage.REFERENCE_SUBSTITUTION__PLACEMENT:
				return placement != null;
			case CvlPackage.REFERENCE_SUBSTITUTION__REPLACEMENT:
				return replacement != null;
		}
		return super.eIsSet(featureID);
	}

} //ReferenceSubstitutionImpl
