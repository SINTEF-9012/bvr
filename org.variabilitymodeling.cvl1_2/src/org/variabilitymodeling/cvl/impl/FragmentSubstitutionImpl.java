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
import org.variabilitymodeling.cvl.BoundaryElementBinding;
import org.variabilitymodeling.cvl.CvlPackage;
import org.variabilitymodeling.cvl.FragmentSubstitution;
import org.variabilitymodeling.cvl.PlacementFragment;
import org.variabilitymodeling.cvl.ReplacementFragmentAbstract;
import org.variabilitymodeling.cvl.ReplacementFragmentBinding;
import org.variabilitymodeling.cvl.ReplacementFragmentReference;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fragment Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.FragmentSubstitutionImpl#getPlacement <em>Placement</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.FragmentSubstitutionImpl#getReplacement <em>Replacement</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.FragmentSubstitutionImpl#getRfRef <em>Rf Ref</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.FragmentSubstitutionImpl#getBoundaryElementBinding <em>Boundary Element Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FragmentSubstitutionImpl extends SubstitutionImpl implements FragmentSubstitution {
	/**
	 * The cached value of the '{@link #getPlacement() <em>Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlacement()
	 * @generated
	 * @ordered
	 */
	protected PlacementFragment placement;

	/**
	 * The cached value of the '{@link #getReplacement() <em>Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplacement()
	 * @generated
	 * @ordered
	 */
	protected ReplacementFragmentAbstract replacement;

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
	 * The cached value of the '{@link #getBoundaryElementBinding() <em>Boundary Element Binding</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundaryElementBinding()
	 * @generated
	 * @ordered
	 */
	protected EList<BoundaryElementBinding> boundaryElementBinding;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FragmentSubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.FRAGMENT_SUBSTITUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacementFragment getPlacement() {
		if (placement != null && placement.eIsProxy()) {
			InternalEObject oldPlacement = (InternalEObject)placement;
			placement = (PlacementFragment)eResolveProxy(oldPlacement);
			if (placement != oldPlacement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.FRAGMENT_SUBSTITUTION__PLACEMENT, oldPlacement, placement));
			}
		}
		return placement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlacementFragment basicGetPlacement() {
		return placement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlacement(PlacementFragment newPlacement) {
		PlacementFragment oldPlacement = placement;
		placement = newPlacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.FRAGMENT_SUBSTITUTION__PLACEMENT, oldPlacement, placement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentAbstract getReplacement() {
		if (replacement != null && replacement.eIsProxy()) {
			InternalEObject oldReplacement = (InternalEObject)replacement;
			replacement = (ReplacementFragmentAbstract)eResolveProxy(oldReplacement);
			if (replacement != oldReplacement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.FRAGMENT_SUBSTITUTION__REPLACEMENT, oldReplacement, replacement));
			}
		}
		return replacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentAbstract basicGetReplacement() {
		return replacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplacement(ReplacementFragmentAbstract newReplacement) {
		ReplacementFragmentAbstract oldReplacement = replacement;
		replacement = newReplacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.FRAGMENT_SUBSTITUTION__REPLACEMENT, oldReplacement, replacement));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.FRAGMENT_SUBSTITUTION__RF_REF, oldRfRef, rfRef));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.FRAGMENT_SUBSTITUTION__RF_REF, oldRfRef, rfRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BoundaryElementBinding> getBoundaryElementBinding() {
		if (boundaryElementBinding == null) {
			boundaryElementBinding = new EObjectContainmentEList<BoundaryElementBinding>(BoundaryElementBinding.class, this, CvlPackage.FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING);
		}
		return boundaryElementBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitFragmentSubstitution(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING:
				return ((InternalEList<?>)getBoundaryElementBinding()).basicRemove(otherEnd, msgs);
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
			case CvlPackage.FRAGMENT_SUBSTITUTION__PLACEMENT:
				if (resolve) return getPlacement();
				return basicGetPlacement();
			case CvlPackage.FRAGMENT_SUBSTITUTION__REPLACEMENT:
				if (resolve) return getReplacement();
				return basicGetReplacement();
			case CvlPackage.FRAGMENT_SUBSTITUTION__RF_REF:
				if (resolve) return getRfRef();
				return basicGetRfRef();
			case CvlPackage.FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING:
				return getBoundaryElementBinding();
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
			case CvlPackage.FRAGMENT_SUBSTITUTION__PLACEMENT:
				setPlacement((PlacementFragment)newValue);
				return;
			case CvlPackage.FRAGMENT_SUBSTITUTION__REPLACEMENT:
				setReplacement((ReplacementFragmentAbstract)newValue);
				return;
			case CvlPackage.FRAGMENT_SUBSTITUTION__RF_REF:
				setRfRef((ReplacementFragmentReference)newValue);
				return;
			case CvlPackage.FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING:
				getBoundaryElementBinding().clear();
				getBoundaryElementBinding().addAll((Collection<? extends BoundaryElementBinding>)newValue);
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
			case CvlPackage.FRAGMENT_SUBSTITUTION__PLACEMENT:
				setPlacement((PlacementFragment)null);
				return;
			case CvlPackage.FRAGMENT_SUBSTITUTION__REPLACEMENT:
				setReplacement((ReplacementFragmentAbstract)null);
				return;
			case CvlPackage.FRAGMENT_SUBSTITUTION__RF_REF:
				setRfRef((ReplacementFragmentReference)null);
				return;
			case CvlPackage.FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING:
				getBoundaryElementBinding().clear();
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
			case CvlPackage.FRAGMENT_SUBSTITUTION__PLACEMENT:
				return placement != null;
			case CvlPackage.FRAGMENT_SUBSTITUTION__REPLACEMENT:
				return replacement != null;
			case CvlPackage.FRAGMENT_SUBSTITUTION__RF_REF:
				return rfRef != null;
			case CvlPackage.FRAGMENT_SUBSTITUTION__BOUNDARY_ELEMENT_BINDING:
				return boundaryElementBinding != null && !boundaryElementBinding.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FragmentSubstitutionImpl
