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
 * An implementation of the model object '<em><b>To Replacement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.ToReplacementImpl#getInsideBoundaryElement <em>Inside Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.ToReplacementImpl#getPlacementBoundaryElement <em>Placement Boundary Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToReplacementImpl extends ReplacementBoundaryElementImpl implements ToReplacement {
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
	 * The cached value of the '{@link #getPlacementBoundaryElement() <em>Placement Boundary Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlacementBoundaryElement()
	 * @generated
	 * @ordered
	 */
	protected ToPlacement placementBoundaryElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToReplacementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.TO_REPLACEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getInsideBoundaryElement() {
		if (insideBoundaryElement == null) {
			insideBoundaryElement = new EObjectResolvingEList<EObject>(EObject.class, this, CvlPackage.TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT);
		}
		return insideBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToPlacement getPlacementBoundaryElement() {
		if (placementBoundaryElement != null && placementBoundaryElement.eIsProxy()) {
			InternalEObject oldPlacementBoundaryElement = (InternalEObject)placementBoundaryElement;
			placementBoundaryElement = (ToPlacement)eResolveProxy(oldPlacementBoundaryElement);
			if (placementBoundaryElement != oldPlacementBoundaryElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT, oldPlacementBoundaryElement, placementBoundaryElement));
			}
		}
		return placementBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToPlacement basicGetPlacementBoundaryElement() {
		return placementBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlacementBoundaryElement(ToPlacement newPlacementBoundaryElement, NotificationChain msgs) {
		ToPlacement oldPlacementBoundaryElement = placementBoundaryElement;
		placementBoundaryElement = newPlacementBoundaryElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CvlPackage.TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT, oldPlacementBoundaryElement, newPlacementBoundaryElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlacementBoundaryElement(ToPlacement newPlacementBoundaryElement) {
		if (newPlacementBoundaryElement != placementBoundaryElement) {
			NotificationChain msgs = null;
			if (placementBoundaryElement != null)
				msgs = ((InternalEObject)placementBoundaryElement).eInverseRemove(this, CvlPackage.TO_PLACEMENT__OUTSIDE_REF, ToPlacement.class, msgs);
			if (newPlacementBoundaryElement != null)
				msgs = ((InternalEObject)newPlacementBoundaryElement).eInverseAdd(this, CvlPackage.TO_PLACEMENT__OUTSIDE_REF, ToPlacement.class, msgs);
			msgs = basicSetPlacementBoundaryElement(newPlacementBoundaryElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT, newPlacementBoundaryElement, newPlacementBoundaryElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitToReplacement(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT:
				if (placementBoundaryElement != null)
					msgs = ((InternalEObject)placementBoundaryElement).eInverseRemove(this, CvlPackage.TO_PLACEMENT__OUTSIDE_REF, ToPlacement.class, msgs);
				return basicSetPlacementBoundaryElement((ToPlacement)otherEnd, msgs);
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
			case CvlPackage.TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT:
				return basicSetPlacementBoundaryElement(null, msgs);
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
			case CvlPackage.TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				return getInsideBoundaryElement();
			case CvlPackage.TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT:
				if (resolve) return getPlacementBoundaryElement();
				return basicGetPlacementBoundaryElement();
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
			case CvlPackage.TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				getInsideBoundaryElement().clear();
				getInsideBoundaryElement().addAll((Collection<? extends EObject>)newValue);
				return;
			case CvlPackage.TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT:
				setPlacementBoundaryElement((ToPlacement)newValue);
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
			case CvlPackage.TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				getInsideBoundaryElement().clear();
				return;
			case CvlPackage.TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT:
				setPlacementBoundaryElement((ToPlacement)null);
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
			case CvlPackage.TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				return insideBoundaryElement != null && !insideBoundaryElement.isEmpty();
			case CvlPackage.TO_REPLACEMENT__PLACEMENT_BOUNDARY_ELEMENT:
				return placementBoundaryElement != null;
		}
		return super.eIsSet(featureID);
	}

} //ToReplacementImpl
