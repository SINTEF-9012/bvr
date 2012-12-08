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
 * An implementation of the model object '<em><b>From Placement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.FromPlacementImpl#getOutsideBoundaryElement <em>Outside Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.FromPlacementImpl#getReplacementBoundaryElement <em>Replacement Boundary Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FromPlacementImpl extends PlacementBoundaryElementImpl implements FromPlacement {
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
	 * The cached value of the '{@link #getReplacementBoundaryElement() <em>Replacement Boundary Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplacementBoundaryElement()
	 * @generated
	 * @ordered
	 */
	protected FromReplacement replacementBoundaryElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FromPlacementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.FROM_PLACEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getOutsideBoundaryElement() {
		if (outsideBoundaryElement == null) {
			outsideBoundaryElement = new EObjectResolvingEList<EObject>(EObject.class, this, CvlPackage.FROM_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT);
		}
		return outsideBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromReplacement getReplacementBoundaryElement() {
		if (replacementBoundaryElement != null && replacementBoundaryElement.eIsProxy()) {
			InternalEObject oldReplacementBoundaryElement = (InternalEObject)replacementBoundaryElement;
			replacementBoundaryElement = (FromReplacement)eResolveProxy(oldReplacementBoundaryElement);
			if (replacementBoundaryElement != oldReplacementBoundaryElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT, oldReplacementBoundaryElement, replacementBoundaryElement));
			}
		}
		return replacementBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromReplacement basicGetReplacementBoundaryElement() {
		return replacementBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReplacementBoundaryElement(FromReplacement newReplacementBoundaryElement, NotificationChain msgs) {
		FromReplacement oldReplacementBoundaryElement = replacementBoundaryElement;
		replacementBoundaryElement = newReplacementBoundaryElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CvlPackage.FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT, oldReplacementBoundaryElement, newReplacementBoundaryElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplacementBoundaryElement(FromReplacement newReplacementBoundaryElement) {
		if (newReplacementBoundaryElement != replacementBoundaryElement) {
			NotificationChain msgs = null;
			if (replacementBoundaryElement != null)
				msgs = ((InternalEObject)replacementBoundaryElement).eInverseRemove(this, CvlPackage.FROM_REPLACEMENT__INSIDE_REF, FromReplacement.class, msgs);
			if (newReplacementBoundaryElement != null)
				msgs = ((InternalEObject)newReplacementBoundaryElement).eInverseAdd(this, CvlPackage.FROM_REPLACEMENT__INSIDE_REF, FromReplacement.class, msgs);
			msgs = basicSetReplacementBoundaryElement(newReplacementBoundaryElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT, newReplacementBoundaryElement, newReplacementBoundaryElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitFromPlacement(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT:
				if (replacementBoundaryElement != null)
					msgs = ((InternalEObject)replacementBoundaryElement).eInverseRemove(this, CvlPackage.FROM_REPLACEMENT__INSIDE_REF, FromReplacement.class, msgs);
				return basicSetReplacementBoundaryElement((FromReplacement)otherEnd, msgs);
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
			case CvlPackage.FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT:
				return basicSetReplacementBoundaryElement(null, msgs);
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
			case CvlPackage.FROM_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				return getOutsideBoundaryElement();
			case CvlPackage.FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT:
				if (resolve) return getReplacementBoundaryElement();
				return basicGetReplacementBoundaryElement();
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
			case CvlPackage.FROM_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				getOutsideBoundaryElement().clear();
				getOutsideBoundaryElement().addAll((Collection<? extends EObject>)newValue);
				return;
			case CvlPackage.FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT:
				setReplacementBoundaryElement((FromReplacement)newValue);
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
			case CvlPackage.FROM_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				getOutsideBoundaryElement().clear();
				return;
			case CvlPackage.FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT:
				setReplacementBoundaryElement((FromReplacement)null);
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
			case CvlPackage.FROM_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				return outsideBoundaryElement != null && !outsideBoundaryElement.isEmpty();
			case CvlPackage.FROM_PLACEMENT__REPLACEMENT_BOUNDARY_ELEMENT:
				return replacementBoundaryElement != null;
		}
		return super.eIsSet(featureID);
	}

} //FromPlacementImpl
