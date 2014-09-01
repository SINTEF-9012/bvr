/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.ObjectHandle;
import bvr.PlacementBoundaryElement;
import bvr.PlacementFragment;

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
 *   <li>{@link bvr.impl.PlacementFragmentImpl#getPlacementBoundaryElement <em>Placement Boundary Element</em>}</li>
 *   <li>{@link bvr.impl.PlacementFragmentImpl#getSourceObject <em>Source Object</em>}</li>
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
	 * The cached value of the '{@link #getSourceObject() <em>Source Object</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceObject()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectHandle> sourceObject;

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
		return BvrPackage.Literals.PLACEMENT_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PlacementBoundaryElement> getPlacementBoundaryElement() {
		if (placementBoundaryElement == null) {
			placementBoundaryElement = new EObjectContainmentEList<PlacementBoundaryElement>(PlacementBoundaryElement.class, this, BvrPackage.PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT);
		}
		return placementBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectHandle> getSourceObject() {
		if (sourceObject == null) {
			sourceObject = new EObjectContainmentEList<ObjectHandle>(ObjectHandle.class, this, BvrPackage.PLACEMENT_FRAGMENT__SOURCE_OBJECT);
		}
		return sourceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT:
				return ((InternalEList<?>)getPlacementBoundaryElement()).basicRemove(otherEnd, msgs);
			case BvrPackage.PLACEMENT_FRAGMENT__SOURCE_OBJECT:
				return ((InternalEList<?>)getSourceObject()).basicRemove(otherEnd, msgs);
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
			case BvrPackage.PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT:
				return getPlacementBoundaryElement();
			case BvrPackage.PLACEMENT_FRAGMENT__SOURCE_OBJECT:
				return getSourceObject();
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
			case BvrPackage.PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT:
				getPlacementBoundaryElement().clear();
				getPlacementBoundaryElement().addAll((Collection<? extends PlacementBoundaryElement>)newValue);
				return;
			case BvrPackage.PLACEMENT_FRAGMENT__SOURCE_OBJECT:
				getSourceObject().clear();
				getSourceObject().addAll((Collection<? extends ObjectHandle>)newValue);
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
			case BvrPackage.PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT:
				getPlacementBoundaryElement().clear();
				return;
			case BvrPackage.PLACEMENT_FRAGMENT__SOURCE_OBJECT:
				getSourceObject().clear();
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
			case BvrPackage.PLACEMENT_FRAGMENT__PLACEMENT_BOUNDARY_ELEMENT:
				return placementBoundaryElement != null && !placementBoundaryElement.isEmpty();
			case BvrPackage.PLACEMENT_FRAGMENT__SOURCE_OBJECT:
				return sourceObject != null && !sourceObject.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PlacementFragmentImpl
