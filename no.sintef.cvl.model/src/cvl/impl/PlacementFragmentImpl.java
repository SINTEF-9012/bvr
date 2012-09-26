/**
 */
package cvl.impl;

import cvl.PlacementBoundaryElement;
import cvl.PlacementFragment;
import cvl.cvlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Placement Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.PlacementFragmentImpl#getPlacementBoundaryElement <em>Placement Boundary Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlacementFragmentImpl extends VariationPointImpl implements PlacementFragment {
	/**
	 * The cached value of the '{@link #getPlacementBoundaryElement() <em>Placement Boundary Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlacementBoundaryElement()
	 * @generated
	 * @ordered
	 */
	protected EList<PlacementBoundaryElement> placementBoundaryElement;

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
		return cvlPackage.Literals.PLACEMENT_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PlacementBoundaryElement> getPlacementBoundaryElement() {
		if (placementBoundaryElement == null) {
			placementBoundaryElement = new EObjectContainmentEList<PlacementBoundaryElement>(PlacementBoundaryElement.class, this, cvlPackage.PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT);
		}
		return placementBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case cvlPackage.PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT:
				return ((InternalEList<?>)getPlacementBoundaryElement()).basicRemove(otherEnd, msgs);
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
			case cvlPackage.PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT:
				return getPlacementBoundaryElement();
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
			case cvlPackage.PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT:
				getPlacementBoundaryElement().clear();
				getPlacementBoundaryElement().addAll((Collection<? extends PlacementBoundaryElement>)newValue);
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
			case cvlPackage.PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT:
				getPlacementBoundaryElement().clear();
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
			case cvlPackage.PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT:
				return placementBoundaryElement != null && !placementBoundaryElement.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PlacementFragmentImpl
