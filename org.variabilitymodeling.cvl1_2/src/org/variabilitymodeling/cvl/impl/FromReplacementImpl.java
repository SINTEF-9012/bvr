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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.variabilitymodeling.cvl.CvlPackage;
import org.variabilitymodeling.cvl.FromPlacement;
import org.variabilitymodeling.cvl.FromReplacement;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>From Replacement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.FromReplacementImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.FromReplacementImpl#getOutsideBoundaryElement <em>Outside Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.FromReplacementImpl#getInsideBoundaryElement <em>Inside Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.FromReplacementImpl#getInsideRef <em>Inside Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FromReplacementImpl extends ReplacementBoundaryElementImpl implements FromReplacement {
	/**
	 * The default value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected String propertyName = PROPERTY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutsideBoundaryElement() <em>Outside Boundary Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutsideBoundaryElement()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> outsideBoundaryElement;

	/**
	 * The cached value of the '{@link #getInsideBoundaryElement() <em>Inside Boundary Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsideBoundaryElement()
	 * @generated
	 * @ordered
	 */
	protected EObject insideBoundaryElement;

	/**
	 * The cached value of the '{@link #getInsideRef() <em>Inside Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsideRef()
	 * @generated
	 * @ordered
	 */
	protected FromPlacement insideRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FromReplacementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.FROM_REPLACEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyName(String newPropertyName) {
		String oldPropertyName = propertyName;
		propertyName = newPropertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.FROM_REPLACEMENT__PROPERTY_NAME, oldPropertyName, propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getOutsideBoundaryElement() {
		if (outsideBoundaryElement == null) {
			outsideBoundaryElement = new EObjectResolvingEList<EObject>(EObject.class, this, CvlPackage.FROM_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT);
		}
		return outsideBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getInsideBoundaryElement() {
		if (insideBoundaryElement != null && insideBoundaryElement.eIsProxy()) {
			InternalEObject oldInsideBoundaryElement = (InternalEObject)insideBoundaryElement;
			insideBoundaryElement = eResolveProxy(oldInsideBoundaryElement);
			if (insideBoundaryElement != oldInsideBoundaryElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.FROM_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT, oldInsideBoundaryElement, insideBoundaryElement));
			}
		}
		return insideBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetInsideBoundaryElement() {
		return insideBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInsideBoundaryElement(EObject newInsideBoundaryElement) {
		EObject oldInsideBoundaryElement = insideBoundaryElement;
		insideBoundaryElement = newInsideBoundaryElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.FROM_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT, oldInsideBoundaryElement, insideBoundaryElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromPlacement getInsideRef() {
		if (insideRef != null && insideRef.eIsProxy()) {
			InternalEObject oldInsideRef = (InternalEObject)insideRef;
			insideRef = (FromPlacement)eResolveProxy(oldInsideRef);
			if (insideRef != oldInsideRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.FROM_REPLACEMENT__INSIDE_REF, oldInsideRef, insideRef));
			}
		}
		return insideRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromPlacement basicGetInsideRef() {
		return insideRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInsideRef(FromPlacement newInsideRef, NotificationChain msgs) {
		FromPlacement oldInsideRef = insideRef;
		insideRef = newInsideRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CvlPackage.FROM_REPLACEMENT__INSIDE_REF, oldInsideRef, newInsideRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInsideRef(FromPlacement newInsideRef) {
		if (newInsideRef != insideRef) {
			NotificationChain msgs = null;
			if (insideRef != null)
				msgs = ((InternalEObject)insideRef).eInverseRemove(this, CvlPackage.FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT, FromPlacement.class, msgs);
			if (newInsideRef != null)
				msgs = ((InternalEObject)newInsideRef).eInverseAdd(this, CvlPackage.FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT, FromPlacement.class, msgs);
			msgs = basicSetInsideRef(newInsideRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.FROM_REPLACEMENT__INSIDE_REF, newInsideRef, newInsideRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitFromReplacement(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.FROM_REPLACEMENT__INSIDE_REF:
				if (insideRef != null)
					msgs = ((InternalEObject)insideRef).eInverseRemove(this, CvlPackage.FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT, FromPlacement.class, msgs);
				return basicSetInsideRef((FromPlacement)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.FROM_REPLACEMENT__INSIDE_REF:
				return basicSetInsideRef(null, msgs);
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
			case CvlPackage.FROM_REPLACEMENT__PROPERTY_NAME:
				return getPropertyName();
			case CvlPackage.FROM_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				return getOutsideBoundaryElement();
			case CvlPackage.FROM_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				if (resolve) return getInsideBoundaryElement();
				return basicGetInsideBoundaryElement();
			case CvlPackage.FROM_REPLACEMENT__INSIDE_REF:
				if (resolve) return getInsideRef();
				return basicGetInsideRef();
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
			case CvlPackage.FROM_REPLACEMENT__PROPERTY_NAME:
				setPropertyName((String)newValue);
				return;
			case CvlPackage.FROM_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				getOutsideBoundaryElement().clear();
				getOutsideBoundaryElement().addAll((Collection<? extends EObject>)newValue);
				return;
			case CvlPackage.FROM_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				setInsideBoundaryElement((EObject)newValue);
				return;
			case CvlPackage.FROM_REPLACEMENT__INSIDE_REF:
				setInsideRef((FromPlacement)newValue);
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
			case CvlPackage.FROM_REPLACEMENT__PROPERTY_NAME:
				setPropertyName(PROPERTY_NAME_EDEFAULT);
				return;
			case CvlPackage.FROM_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				getOutsideBoundaryElement().clear();
				return;
			case CvlPackage.FROM_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				setInsideBoundaryElement((EObject)null);
				return;
			case CvlPackage.FROM_REPLACEMENT__INSIDE_REF:
				setInsideRef((FromPlacement)null);
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
			case CvlPackage.FROM_REPLACEMENT__PROPERTY_NAME:
				return PROPERTY_NAME_EDEFAULT == null ? propertyName != null : !PROPERTY_NAME_EDEFAULT.equals(propertyName);
			case CvlPackage.FROM_REPLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				return outsideBoundaryElement != null && !outsideBoundaryElement.isEmpty();
			case CvlPackage.FROM_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				return insideBoundaryElement != null;
			case CvlPackage.FROM_REPLACEMENT__INSIDE_REF:
				return insideRef != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (propertyName: ");
		result.append(propertyName);
		result.append(')');
		return result.toString();
	}

} //FromReplacementImpl
