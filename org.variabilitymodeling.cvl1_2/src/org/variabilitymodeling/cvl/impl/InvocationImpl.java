/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.impl;



import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.variabilitymodeling.cvl.CvlPackage;
import org.variabilitymodeling.cvl.Invocation;
import org.variabilitymodeling.cvl.ReplacementFragmentReference;
import org.variabilitymodeling.cvl.ResolutionSpecification;
import org.variabilitymodeling.cvl.Type;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.InvocationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.InvocationImpl#getResolutionSpecification <em>Resolution Specification</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.InvocationImpl#getRfRef <em>Rf Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvocationImpl extends ExecutablePrimitiveImpl implements Invocation {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * The cached value of the '{@link #getResolutionSpecification() <em>Resolution Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolutionSpecification()
	 * @generated
	 * @ordered
	 */
	protected ResolutionSpecification resolutionSpecification;

	/**
	 * The cached value of the '{@link #getRfRef() <em>Rf Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRfRef()
	 * @generated
	 * @ordered
	 */
	protected ReplacementFragmentReference rfRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.INVOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.INVOCATION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.INVOCATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolutionSpecification getResolutionSpecification() {
		return resolutionSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResolutionSpecification(ResolutionSpecification newResolutionSpecification, NotificationChain msgs) {
		ResolutionSpecification oldResolutionSpecification = resolutionSpecification;
		resolutionSpecification = newResolutionSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CvlPackage.INVOCATION__RESOLUTION_SPECIFICATION, oldResolutionSpecification, newResolutionSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolutionSpecification(ResolutionSpecification newResolutionSpecification) {
		if (newResolutionSpecification != resolutionSpecification) {
			NotificationChain msgs = null;
			if (resolutionSpecification != null)
				msgs = ((InternalEObject)resolutionSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CvlPackage.INVOCATION__RESOLUTION_SPECIFICATION, null, msgs);
			if (newResolutionSpecification != null)
				msgs = ((InternalEObject)newResolutionSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CvlPackage.INVOCATION__RESOLUTION_SPECIFICATION, null, msgs);
			msgs = basicSetResolutionSpecification(newResolutionSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.INVOCATION__RESOLUTION_SPECIFICATION, newResolutionSpecification, newResolutionSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentReference getRfRef() {
		if (rfRef != null && rfRef.eIsProxy()) {
			InternalEObject oldRfRef = (InternalEObject)rfRef;
			rfRef = (ReplacementFragmentReference)eResolveProxy(oldRfRef);
			if (rfRef != oldRfRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.INVOCATION__RF_REF, oldRfRef, rfRef));
			}
		}
		return rfRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentReference basicGetRfRef() {
		return rfRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRfRef(ReplacementFragmentReference newRfRef) {
		ReplacementFragmentReference oldRfRef = rfRef;
		rfRef = newRfRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.INVOCATION__RF_REF, oldRfRef, rfRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitInvocation(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.INVOCATION__RESOLUTION_SPECIFICATION:
				return basicSetResolutionSpecification(null, msgs);
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
			case CvlPackage.INVOCATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case CvlPackage.INVOCATION__RESOLUTION_SPECIFICATION:
				return getResolutionSpecification();
			case CvlPackage.INVOCATION__RF_REF:
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
			case CvlPackage.INVOCATION__TYPE:
				setType((Type)newValue);
				return;
			case CvlPackage.INVOCATION__RESOLUTION_SPECIFICATION:
				setResolutionSpecification((ResolutionSpecification)newValue);
				return;
			case CvlPackage.INVOCATION__RF_REF:
				setRfRef((ReplacementFragmentReference)newValue);
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
			case CvlPackage.INVOCATION__TYPE:
				setType((Type)null);
				return;
			case CvlPackage.INVOCATION__RESOLUTION_SPECIFICATION:
				setResolutionSpecification((ResolutionSpecification)null);
				return;
			case CvlPackage.INVOCATION__RF_REF:
				setRfRef((ReplacementFragmentReference)null);
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
			case CvlPackage.INVOCATION__TYPE:
				return type != null;
			case CvlPackage.INVOCATION__RESOLUTION_SPECIFICATION:
				return resolutionSpecification != null;
			case CvlPackage.INVOCATION__RF_REF:
				return rfRef != null;
		}
		return super.eIsSet(featureID);
	}

} //InvocationImpl
