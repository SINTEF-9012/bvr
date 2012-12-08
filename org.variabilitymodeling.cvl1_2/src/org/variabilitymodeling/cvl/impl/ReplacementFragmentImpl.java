/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.impl;



import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.variabilitymodeling.cvl.CvlPackage;
import org.variabilitymodeling.cvl.PlacementLiteral;
import org.variabilitymodeling.cvl.ReplacementBoundaryElement;
import org.variabilitymodeling.cvl.ReplacementFragment;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Replacement Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.ReplacementFragmentImpl#getBoundaryElement <em>Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.ReplacementFragmentImpl#getPlacements <em>Placements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReplacementFragmentImpl extends CVLNamedElementImpl implements ReplacementFragment {
	/**
	 * The cached value of the '{@link #getBoundaryElement() <em>Boundary Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundaryElement()
	 * @generated
	 * @ordered
	 */
	protected EList<ReplacementBoundaryElement> boundaryElement;

	/**
	 * The cached value of the '{@link #getPlacements() <em>Placements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlacements()
	 * @generated
	 * @ordered
	 */
	protected EList<PlacementLiteral> placements;

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
	public EList<ReplacementBoundaryElement> getBoundaryElement() {
		if (boundaryElement == null) {
			boundaryElement = new EObjectContainmentEList<ReplacementBoundaryElement>(ReplacementBoundaryElement.class, this, CvlPackage.REPLACEMENT_FRAGMENT__BOUNDARY_ELEMENT);
		}
		return boundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PlacementLiteral> getPlacements() {
		if (placements == null) {
			placements = new EObjectContainmentEList<PlacementLiteral>(PlacementLiteral.class, this, CvlPackage.REPLACEMENT_FRAGMENT__PLACEMENTS);
		}
		return placements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitReplacementFragment(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.REPLACEMENT_FRAGMENT__BOUNDARY_ELEMENT:
				return ((InternalEList<?>)getBoundaryElement()).basicRemove(otherEnd, msgs);
			case CvlPackage.REPLACEMENT_FRAGMENT__PLACEMENTS:
				return ((InternalEList<?>)getPlacements()).basicRemove(otherEnd, msgs);
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
			case CvlPackage.REPLACEMENT_FRAGMENT__BOUNDARY_ELEMENT:
				return getBoundaryElement();
			case CvlPackage.REPLACEMENT_FRAGMENT__PLACEMENTS:
				return getPlacements();
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
			case CvlPackage.REPLACEMENT_FRAGMENT__BOUNDARY_ELEMENT:
				getBoundaryElement().clear();
				getBoundaryElement().addAll((Collection<? extends ReplacementBoundaryElement>)newValue);
				return;
			case CvlPackage.REPLACEMENT_FRAGMENT__PLACEMENTS:
				getPlacements().clear();
				getPlacements().addAll((Collection<? extends PlacementLiteral>)newValue);
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
			case CvlPackage.REPLACEMENT_FRAGMENT__BOUNDARY_ELEMENT:
				getBoundaryElement().clear();
				return;
			case CvlPackage.REPLACEMENT_FRAGMENT__PLACEMENTS:
				getPlacements().clear();
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
			case CvlPackage.REPLACEMENT_FRAGMENT__BOUNDARY_ELEMENT:
				return boundaryElement != null && !boundaryElement.isEmpty();
			case CvlPackage.REPLACEMENT_FRAGMENT__PLACEMENTS:
				return placements != null && !placements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ReplacementFragmentImpl
