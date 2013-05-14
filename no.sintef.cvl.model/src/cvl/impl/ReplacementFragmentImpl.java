/**
 */
package cvl.impl;

import cvl.CvlPackage;
import cvl.PlacementFragment;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragment;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Replacement Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.ReplacementFragmentImpl#getReplacementBoundaryElement <em>Replacement Boundary Element</em>}</li>
 *   <li>{@link cvl.impl.ReplacementFragmentImpl#getPlacementFragment <em>Placement Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReplacementFragmentImpl extends VariationPointImpl implements ReplacementFragment {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReplacementFragmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.REPLACEMENT_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReplacementBoundaryElement> getReplacementBoundaryElement() {
		if (replacementBoundaryElement == null) {
			replacementBoundaryElement = new EObjectContainmentEList<ReplacementBoundaryElement>(ReplacementBoundaryElement.class, this, CvlPackage.REPLACEMENT_FRAGMENT__REPLACEMENT_BOUNDARY_ELEMENT);
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
			placementFragment = new EObjectContainmentEList<PlacementFragment>(PlacementFragment.class, this, CvlPackage.REPLACEMENT_FRAGMENT__PLACEMENT_FRAGMENT);
		}
		return placementFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.REPLACEMENT_FRAGMENT__REPLACEMENT_BOUNDARY_ELEMENT:
				return ((InternalEList<?>)getReplacementBoundaryElement()).basicRemove(otherEnd, msgs);
			case CvlPackage.REPLACEMENT_FRAGMENT__PLACEMENT_FRAGMENT:
				return ((InternalEList<?>)getPlacementFragment()).basicRemove(otherEnd, msgs);
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
			case CvlPackage.REPLACEMENT_FRAGMENT__REPLACEMENT_BOUNDARY_ELEMENT:
				return getReplacementBoundaryElement();
			case CvlPackage.REPLACEMENT_FRAGMENT__PLACEMENT_FRAGMENT:
				return getPlacementFragment();
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
			case CvlPackage.REPLACEMENT_FRAGMENT__REPLACEMENT_BOUNDARY_ELEMENT:
				getReplacementBoundaryElement().clear();
				getReplacementBoundaryElement().addAll((Collection<? extends ReplacementBoundaryElement>)newValue);
				return;
			case CvlPackage.REPLACEMENT_FRAGMENT__PLACEMENT_FRAGMENT:
				getPlacementFragment().clear();
				getPlacementFragment().addAll((Collection<? extends PlacementFragment>)newValue);
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
			case CvlPackage.REPLACEMENT_FRAGMENT__REPLACEMENT_BOUNDARY_ELEMENT:
				getReplacementBoundaryElement().clear();
				return;
			case CvlPackage.REPLACEMENT_FRAGMENT__PLACEMENT_FRAGMENT:
				getPlacementFragment().clear();
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
			case CvlPackage.REPLACEMENT_FRAGMENT__REPLACEMENT_BOUNDARY_ELEMENT:
				return replacementBoundaryElement != null && !replacementBoundaryElement.isEmpty();
			case CvlPackage.REPLACEMENT_FRAGMENT__PLACEMENT_FRAGMENT:
				return placementFragment != null && !placementFragment.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ReplacementFragmentImpl
