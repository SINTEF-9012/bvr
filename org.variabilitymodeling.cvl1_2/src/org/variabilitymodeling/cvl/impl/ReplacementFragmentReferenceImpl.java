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
import org.variabilitymodeling.cvl.ReplacementFragment;
import org.variabilitymodeling.cvl.ReplacementFragmentReference;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Replacement Fragment Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.ReplacementFragmentReferenceImpl#getRfRef <em>Rf Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReplacementFragmentReferenceImpl extends ReplacementFragmentAbstractImpl implements ReplacementFragmentReference {
	/**
	 * The cached value of the '{@link #getRfRef() <em>Rf Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRfRef()
	 * @generated
	 * @ordered
	 */
	protected ReplacementFragment rfRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReplacementFragmentReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.REPLACEMENT_FRAGMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragment getRfRef() {
		if (rfRef != null && rfRef.eIsProxy()) {
			InternalEObject oldRfRef = (InternalEObject)rfRef;
			rfRef = (ReplacementFragment)eResolveProxy(oldRfRef);
			if (rfRef != oldRfRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.REPLACEMENT_FRAGMENT_REFERENCE__RF_REF, oldRfRef, rfRef));
			}
		}
		return rfRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragment basicGetRfRef() {
		return rfRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRfRef(ReplacementFragment newRfRef) {
		ReplacementFragment oldRfRef = rfRef;
		rfRef = newRfRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.REPLACEMENT_FRAGMENT_REFERENCE__RF_REF, oldRfRef, rfRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitReplacementFragmentReference(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CvlPackage.REPLACEMENT_FRAGMENT_REFERENCE__RF_REF:
				if (resolve) return getRfRef();
				return basicGetRfRef();
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
			case CvlPackage.REPLACEMENT_FRAGMENT_REFERENCE__RF_REF:
				setRfRef((ReplacementFragment)newValue);
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
			case CvlPackage.REPLACEMENT_FRAGMENT_REFERENCE__RF_REF:
				setRfRef((ReplacementFragment)null);
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
			case CvlPackage.REPLACEMENT_FRAGMENT_REFERENCE__RF_REF:
				return rfRef != null;
		}
		return super.eIsSet(featureID);
	}

} //ReplacementFragmentReferenceImpl
