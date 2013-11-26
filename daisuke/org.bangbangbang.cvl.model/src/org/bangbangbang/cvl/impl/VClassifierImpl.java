/**
 */
package org.bangbangbang.cvl.impl;

import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.MultiplicityInterval;
import org.bangbangbang.cvl.VClassifier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VClassifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.impl.VClassifierImpl#getInstanceMultiplicity <em>Instance Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VClassifierImpl extends VSpecImpl implements VClassifier {
	/**
	 * The cached value of the '{@link #getInstanceMultiplicity() <em>Instance Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityInterval instanceMultiplicity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.VCLASSIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityInterval getInstanceMultiplicity() {
		return instanceMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInstanceMultiplicity(MultiplicityInterval newInstanceMultiplicity, NotificationChain msgs) {
		MultiplicityInterval oldInstanceMultiplicity = instanceMultiplicity;
		instanceMultiplicity = newInstanceMultiplicity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CvlPackage.VCLASSIFIER__INSTANCE_MULTIPLICITY, oldInstanceMultiplicity, newInstanceMultiplicity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceMultiplicity(MultiplicityInterval newInstanceMultiplicity) {
		if (newInstanceMultiplicity != instanceMultiplicity) {
			NotificationChain msgs = null;
			if (instanceMultiplicity != null)
				msgs = ((InternalEObject)instanceMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CvlPackage.VCLASSIFIER__INSTANCE_MULTIPLICITY, null, msgs);
			if (newInstanceMultiplicity != null)
				msgs = ((InternalEObject)newInstanceMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CvlPackage.VCLASSIFIER__INSTANCE_MULTIPLICITY, null, msgs);
			msgs = basicSetInstanceMultiplicity(newInstanceMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.VCLASSIFIER__INSTANCE_MULTIPLICITY, newInstanceMultiplicity, newInstanceMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.VCLASSIFIER__INSTANCE_MULTIPLICITY:
				return basicSetInstanceMultiplicity(null, msgs);
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
			case CvlPackage.VCLASSIFIER__INSTANCE_MULTIPLICITY:
				return getInstanceMultiplicity();
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
			case CvlPackage.VCLASSIFIER__INSTANCE_MULTIPLICITY:
				setInstanceMultiplicity((MultiplicityInterval)newValue);
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
			case CvlPackage.VCLASSIFIER__INSTANCE_MULTIPLICITY:
				setInstanceMultiplicity((MultiplicityInterval)null);
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
			case CvlPackage.VCLASSIFIER__INSTANCE_MULTIPLICITY:
				return instanceMultiplicity != null;
		}
		return super.eIsSet(featureID);
	}

} //VClassifierImpl
