/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.impl;



import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.variabilitymodeling.cvl.CVLModel;
import org.variabilitymodeling.cvl.CvlPackage;
import org.variabilitymodeling.cvl.ResolutionSpecification;
import org.variabilitymodeling.cvl.VariabilitySpecification;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CVL Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.CVLModelImpl#getVariabilitySpecification <em>Variability Specification</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.CVLModelImpl#getResolutionSpecification <em>Resolution Specification</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.CVLModelImpl#getBase <em>Base</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CVLModelImpl extends CVLNamedElementImpl implements CVLModel {
	/**
	 * The cached value of the '{@link #getVariabilitySpecification() <em>Variability Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariabilitySpecification()
	 * @generated
	 * @ordered
	 */
	protected VariabilitySpecification variabilitySpecification;

	/**
	 * The cached value of the '{@link #getResolutionSpecification() <em>Resolution Specification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolutionSpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<ResolutionSpecification> resolutionSpecification;

	/**
	 * The cached value of the '{@link #getBase() <em>Base</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase()
	 * @generated
	 * @ordered
	 */
	protected EObject base;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CVLModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.CVL_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilitySpecification getVariabilitySpecification() {
		return variabilitySpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariabilitySpecification(VariabilitySpecification newVariabilitySpecification, NotificationChain msgs) {
		VariabilitySpecification oldVariabilitySpecification = variabilitySpecification;
		variabilitySpecification = newVariabilitySpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CvlPackage.CVL_MODEL__VARIABILITY_SPECIFICATION, oldVariabilitySpecification, newVariabilitySpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariabilitySpecification(VariabilitySpecification newVariabilitySpecification) {
		if (newVariabilitySpecification != variabilitySpecification) {
			NotificationChain msgs = null;
			if (variabilitySpecification != null)
				msgs = ((InternalEObject)variabilitySpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CvlPackage.CVL_MODEL__VARIABILITY_SPECIFICATION, null, msgs);
			if (newVariabilitySpecification != null)
				msgs = ((InternalEObject)newVariabilitySpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CvlPackage.CVL_MODEL__VARIABILITY_SPECIFICATION, null, msgs);
			msgs = basicSetVariabilitySpecification(newVariabilitySpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.CVL_MODEL__VARIABILITY_SPECIFICATION, newVariabilitySpecification, newVariabilitySpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResolutionSpecification> getResolutionSpecification() {
		if (resolutionSpecification == null) {
			resolutionSpecification = new EObjectContainmentEList<ResolutionSpecification>(ResolutionSpecification.class, this, CvlPackage.CVL_MODEL__RESOLUTION_SPECIFICATION);
		}
		return resolutionSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getBase() {
		if (base != null && base.eIsProxy()) {
			InternalEObject oldBase = (InternalEObject)base;
			base = eResolveProxy(oldBase);
			if (base != oldBase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.CVL_MODEL__BASE, oldBase, base));
			}
		}
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetBase() {
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase(EObject newBase) {
		EObject oldBase = base;
		base = newBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.CVL_MODEL__BASE, oldBase, base));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitCVLModel(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.CVL_MODEL__VARIABILITY_SPECIFICATION:
				return basicSetVariabilitySpecification(null, msgs);
			case CvlPackage.CVL_MODEL__RESOLUTION_SPECIFICATION:
				return ((InternalEList<?>)getResolutionSpecification()).basicRemove(otherEnd, msgs);
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
			case CvlPackage.CVL_MODEL__VARIABILITY_SPECIFICATION:
				return getVariabilitySpecification();
			case CvlPackage.CVL_MODEL__RESOLUTION_SPECIFICATION:
				return getResolutionSpecification();
			case CvlPackage.CVL_MODEL__BASE:
				if (resolve) return getBase();
				return basicGetBase();
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
			case CvlPackage.CVL_MODEL__VARIABILITY_SPECIFICATION:
				setVariabilitySpecification((VariabilitySpecification)newValue);
				return;
			case CvlPackage.CVL_MODEL__RESOLUTION_SPECIFICATION:
				getResolutionSpecification().clear();
				getResolutionSpecification().addAll((Collection<? extends ResolutionSpecification>)newValue);
				return;
			case CvlPackage.CVL_MODEL__BASE:
				setBase((EObject)newValue);
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
			case CvlPackage.CVL_MODEL__VARIABILITY_SPECIFICATION:
				setVariabilitySpecification((VariabilitySpecification)null);
				return;
			case CvlPackage.CVL_MODEL__RESOLUTION_SPECIFICATION:
				getResolutionSpecification().clear();
				return;
			case CvlPackage.CVL_MODEL__BASE:
				setBase((EObject)null);
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
			case CvlPackage.CVL_MODEL__VARIABILITY_SPECIFICATION:
				return variabilitySpecification != null;
			case CvlPackage.CVL_MODEL__RESOLUTION_SPECIFICATION:
				return resolutionSpecification != null && !resolutionSpecification.isEmpty();
			case CvlPackage.CVL_MODEL__BASE:
				return base != null;
		}
		return super.eIsSet(featureID);
	}

} //CVLModelImpl
