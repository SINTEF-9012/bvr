/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.variabilitymodeling.cvl.CvlPackage;
import org.variabilitymodeling.cvl.ReplacementFragmentReference;
import org.variabilitymodeling.cvl.Substitution;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.SubstitutionImpl#getReplacementInstance <em>Replacement Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SubstitutionImpl extends ExecutablePrimitiveImpl implements Substitution {
	/**
	 * The cached value of the '{@link #getReplacementInstance() <em>Replacement Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplacementInstance()
	 * @generated
	 * @ordered
	 */
	protected ReplacementFragmentReference replacementInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.SUBSTITUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentReference getReplacementInstance() {
		if (replacementInstance != null && replacementInstance.eIsProxy()) {
			InternalEObject oldReplacementInstance = (InternalEObject)replacementInstance;
			replacementInstance = (ReplacementFragmentReference)eResolveProxy(oldReplacementInstance);
			if (replacementInstance != oldReplacementInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.SUBSTITUTION__REPLACEMENT_INSTANCE, oldReplacementInstance, replacementInstance));
			}
		}
		return replacementInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentReference basicGetReplacementInstance() {
		return replacementInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplacementInstance(ReplacementFragmentReference newReplacementInstance) {
		ReplacementFragmentReference oldReplacementInstance = replacementInstance;
		replacementInstance = newReplacementInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.SUBSTITUTION__REPLACEMENT_INSTANCE, oldReplacementInstance, replacementInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CvlPackage.SUBSTITUTION__REPLACEMENT_INSTANCE:
				if (resolve) return getReplacementInstance();
				return basicGetReplacementInstance();
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
			case CvlPackage.SUBSTITUTION__REPLACEMENT_INSTANCE:
				setReplacementInstance((ReplacementFragmentReference)newValue);
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
			case CvlPackage.SUBSTITUTION__REPLACEMENT_INSTANCE:
				setReplacementInstance((ReplacementFragmentReference)null);
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
			case CvlPackage.SUBSTITUTION__REPLACEMENT_INSTANCE:
				return replacementInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //SubstitutionImpl
