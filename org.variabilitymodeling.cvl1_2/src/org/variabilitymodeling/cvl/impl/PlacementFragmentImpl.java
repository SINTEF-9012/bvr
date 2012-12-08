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
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.variabilitymodeling.cvl.CvlPackage;
import org.variabilitymodeling.cvl.PlacementBoundaryElement;
import org.variabilitymodeling.cvl.PlacementFragment;
import org.variabilitymodeling.cvl.PlacementFragmentUsage;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Placement Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.PlacementFragmentImpl#getBoundaryElement <em>Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.PlacementFragmentImpl#getUsage <em>Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlacementFragmentImpl extends CVLNamedElementImpl implements PlacementFragment {
	/**
	 * The cached value of the '{@link #getBoundaryElement() <em>Boundary Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundaryElement()
	 * @generated
	 * @ordered
	 */
	protected EList<PlacementBoundaryElement> boundaryElement;

	/**
	 * The default value of the '{@link #getUsage() <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsage()
	 * @generated
	 * @ordered
	 */
	protected static final PlacementFragmentUsage USAGE_EDEFAULT = PlacementFragmentUsage.REPLACE;
	/**
	 * The cached value of the '{@link #getUsage() <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsage()
	 * @generated
	 * @ordered
	 */
	protected PlacementFragmentUsage usage = USAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlacementFragmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.PLACEMENT_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PlacementBoundaryElement> getBoundaryElement() {
		if (boundaryElement == null) {
			boundaryElement = new EObjectContainmentEList<PlacementBoundaryElement>(PlacementBoundaryElement.class, this, CvlPackage.PLACEMENT_FRAGMENT__BOUNDARY_ELEMENT);
		}
		return boundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacementFragmentUsage getUsage() {
		return usage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsage(PlacementFragmentUsage newUsage) {
		PlacementFragmentUsage oldUsage = usage;
		usage = newUsage == null ? USAGE_EDEFAULT : newUsage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.PLACEMENT_FRAGMENT__USAGE, oldUsage, usage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitPlacementFragment(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.PLACEMENT_FRAGMENT__BOUNDARY_ELEMENT:
				return ((InternalEList<?>)getBoundaryElement()).basicRemove(otherEnd, msgs);
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
			case CvlPackage.PLACEMENT_FRAGMENT__BOUNDARY_ELEMENT:
				return getBoundaryElement();
			case CvlPackage.PLACEMENT_FRAGMENT__USAGE:
				return getUsage();
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
			case CvlPackage.PLACEMENT_FRAGMENT__BOUNDARY_ELEMENT:
				getBoundaryElement().clear();
				getBoundaryElement().addAll((Collection<? extends PlacementBoundaryElement>)newValue);
				return;
			case CvlPackage.PLACEMENT_FRAGMENT__USAGE:
				setUsage((PlacementFragmentUsage)newValue);
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
			case CvlPackage.PLACEMENT_FRAGMENT__BOUNDARY_ELEMENT:
				getBoundaryElement().clear();
				return;
			case CvlPackage.PLACEMENT_FRAGMENT__USAGE:
				setUsage(USAGE_EDEFAULT);
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
			case CvlPackage.PLACEMENT_FRAGMENT__BOUNDARY_ELEMENT:
				return boundaryElement != null && !boundaryElement.isEmpty();
			case CvlPackage.PLACEMENT_FRAGMENT__USAGE:
				return usage != USAGE_EDEFAULT;
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
		result.append(" (usage: ");
		result.append(usage);
		result.append(')');
		return result.toString();
	}

} //PlacementFragmentImpl
