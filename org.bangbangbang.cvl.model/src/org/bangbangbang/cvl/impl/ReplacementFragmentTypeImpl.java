/**
 */
package org.bangbangbang.cvl.impl;

import java.util.Collection;

import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.ObjectHandle;
import org.bangbangbang.cvl.PlacementFragment;
import org.bangbangbang.cvl.ReplacementBoundaryElement;
import org.bangbangbang.cvl.ReplacementFragmentType;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Replacement Fragment Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.impl.ReplacementFragmentTypeImpl#getReplacementBoundaryElement <em>Replacement Boundary Element</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.impl.ReplacementFragmentTypeImpl#getPlacementFragment <em>Placement Fragment</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.impl.ReplacementFragmentTypeImpl#getSourceObject <em>Source Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReplacementFragmentTypeImpl extends VariabletypeImpl implements ReplacementFragmentType {
	/**
	 * The cached value of the '{@link #getReplacementBoundaryElement() <em>Replacement Boundary Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplacementBoundaryElement()
	 * @generated
	 * @ordered
	 */
	protected EList<ReplacementBoundaryElement> replacementBoundaryElement;

	/**
	 * The cached value of the '{@link #getPlacementFragment() <em>Placement Fragment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlacementFragment()
	 * @generated
	 * @ordered
	 */
	protected EList<PlacementFragment> placementFragment;

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
	protected ReplacementFragmentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.REPLACEMENT_FRAGMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReplacementBoundaryElement> getReplacementBoundaryElement() {
		if (replacementBoundaryElement == null) {
			replacementBoundaryElement = new EObjectContainmentEList<ReplacementBoundaryElement>(ReplacementBoundaryElement.class, this, CvlPackage.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT);
		}
		return replacementBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PlacementFragment> getPlacementFragment() {
		if (placementFragment == null) {
			placementFragment = new EObjectContainmentEList<PlacementFragment>(PlacementFragment.class, this, CvlPackage.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT);
		}
		return placementFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectHandle> getSourceObject() {
		if (sourceObject == null) {
			sourceObject = new EObjectContainmentEList<ObjectHandle>(ObjectHandle.class, this, CvlPackage.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT);
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
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT:
				return ((InternalEList<?>)getReplacementBoundaryElement()).basicRemove(otherEnd, msgs);
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT:
				return ((InternalEList<?>)getPlacementFragment()).basicRemove(otherEnd, msgs);
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT:
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
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT:
				return getReplacementBoundaryElement();
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT:
				return getPlacementFragment();
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT:
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
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT:
				getReplacementBoundaryElement().clear();
				getReplacementBoundaryElement().addAll((Collection<? extends ReplacementBoundaryElement>)newValue);
				return;
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT:
				getPlacementFragment().clear();
				getPlacementFragment().addAll((Collection<? extends PlacementFragment>)newValue);
				return;
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT:
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
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT:
				getReplacementBoundaryElement().clear();
				return;
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT:
				getPlacementFragment().clear();
				return;
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT:
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
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT:
				return replacementBoundaryElement != null && !replacementBoundaryElement.isEmpty();
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT:
				return placementFragment != null && !placementFragment.isEmpty();
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT:
				return sourceObject != null && !sourceObject.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ReplacementFragmentTypeImpl
