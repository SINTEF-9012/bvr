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
import org.variabilitymodeling.cvl.ToPlacement;
import org.variabilitymodeling.cvl.ToReplacement;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>To Placement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.ToPlacementImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.ToPlacementImpl#getInsideBoundaryElement <em>Inside Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.ToPlacementImpl#getOutsideBoundaryElement <em>Outside Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.ToPlacementImpl#getOutsideRef <em>Outside Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToPlacementImpl extends PlacementBoundaryElementImpl implements ToPlacement {
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
	 * The cached value of the '{@link #getInsideBoundaryElement() <em>Inside Boundary Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsideBoundaryElement()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> insideBoundaryElement;

	/**
	 * The cached value of the '{@link #getOutsideBoundaryElement() <em>Outside Boundary Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutsideBoundaryElement()
	 * @generated
	 * @ordered
	 */
	protected EObject outsideBoundaryElement;

	/**
	 * The cached value of the '{@link #getOutsideRef() <em>Outside Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutsideRef()
	 * @generated
	 * @ordered
	 */
	protected ToReplacement outsideRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToPlacementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.TO_PLACEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.TO_PLACEMENT__PROPERTY_NAME, oldPropertyName, propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getInsideBoundaryElement() {
		if (insideBoundaryElement == null) {
			insideBoundaryElement = new EObjectResolvingEList<EObject>(EObject.class, this, CvlPackage.TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT);
		}
		return insideBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOutsideBoundaryElement() {
		if (outsideBoundaryElement != null && outsideBoundaryElement.eIsProxy()) {
			InternalEObject oldOutsideBoundaryElement = (InternalEObject)outsideBoundaryElement;
			outsideBoundaryElement = eResolveProxy(oldOutsideBoundaryElement);
			if (outsideBoundaryElement != oldOutsideBoundaryElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT, oldOutsideBoundaryElement, outsideBoundaryElement));
			}
		}
		return outsideBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOutsideBoundaryElement() {
		return outsideBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutsideBoundaryElement(EObject newOutsideBoundaryElement) {
		EObject oldOutsideBoundaryElement = outsideBoundaryElement;
		outsideBoundaryElement = newOutsideBoundaryElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT, oldOutsideBoundaryElement, outsideBoundaryElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToReplacement getOutsideRef() {
		if (outsideRef != null && outsideRef.eIsProxy()) {
			InternalEObject oldOutsideRef = (InternalEObject)outsideRef;
			outsideRef = (ToReplacement)eResolveProxy(oldOutsideRef);
			if (outsideRef != oldOutsideRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.TO_PLACEMENT__OUTSIDE_REF, oldOutsideRef, outsideRef));
			}
		}
		return outsideRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToReplacement basicGetOutsideRef() {
		return outsideRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutsideRef(ToReplacement newOutsideRef, NotificationChain msgs) {
		ToReplacement oldOutsideRef = outsideRef;
		outsideRef = newOutsideRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CvlPackage.TO_PLACEMENT__OUTSIDE_REF, oldOutsideRef, newOutsideRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutsideRef(ToReplacement newOutsideRef) {
		if (newOutsideRef != outsideRef) {
			NotificationChain msgs = null;
			if (outsideRef != null)
				msgs = ((InternalEObject)outsideRef).eInverseRemove(this, CvlPackage.TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT, ToReplacement.class, msgs);
			if (newOutsideRef != null)
				msgs = ((InternalEObject)newOutsideRef).eInverseAdd(this, CvlPackage.TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT, ToReplacement.class, msgs);
			msgs = basicSetOutsideRef(newOutsideRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.TO_PLACEMENT__OUTSIDE_REF, newOutsideRef, newOutsideRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitToPlacement(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.TO_PLACEMENT__OUTSIDE_REF:
				if (outsideRef != null)
					msgs = ((InternalEObject)outsideRef).eInverseRemove(this, CvlPackage.TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT, ToReplacement.class, msgs);
				return basicSetOutsideRef((ToReplacement)otherEnd, msgs);
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
			case CvlPackage.TO_PLACEMENT__OUTSIDE_REF:
				return basicSetOutsideRef(null, msgs);
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
			case CvlPackage.TO_PLACEMENT__PROPERTY_NAME:
				return getPropertyName();
			case CvlPackage.TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				return getInsideBoundaryElement();
			case CvlPackage.TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				if (resolve) return getOutsideBoundaryElement();
				return basicGetOutsideBoundaryElement();
			case CvlPackage.TO_PLACEMENT__OUTSIDE_REF:
				if (resolve) return getOutsideRef();
				return basicGetOutsideRef();
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
			case CvlPackage.TO_PLACEMENT__PROPERTY_NAME:
				setPropertyName((String)newValue);
				return;
			case CvlPackage.TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				getInsideBoundaryElement().clear();
				getInsideBoundaryElement().addAll((Collection<? extends EObject>)newValue);
				return;
			case CvlPackage.TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				setOutsideBoundaryElement((EObject)newValue);
				return;
			case CvlPackage.TO_PLACEMENT__OUTSIDE_REF:
				setOutsideRef((ToReplacement)newValue);
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
			case CvlPackage.TO_PLACEMENT__PROPERTY_NAME:
				setPropertyName(PROPERTY_NAME_EDEFAULT);
				return;
			case CvlPackage.TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				getInsideBoundaryElement().clear();
				return;
			case CvlPackage.TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				setOutsideBoundaryElement((EObject)null);
				return;
			case CvlPackage.TO_PLACEMENT__OUTSIDE_REF:
				setOutsideRef((ToReplacement)null);
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
			case CvlPackage.TO_PLACEMENT__PROPERTY_NAME:
				return PROPERTY_NAME_EDEFAULT == null ? propertyName != null : !PROPERTY_NAME_EDEFAULT.equals(propertyName);
			case CvlPackage.TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				return insideBoundaryElement != null && !insideBoundaryElement.isEmpty();
			case CvlPackage.TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				return outsideBoundaryElement != null;
			case CvlPackage.TO_PLACEMENT__OUTSIDE_REF:
				return outsideRef != null;
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

} //ToPlacementImpl
