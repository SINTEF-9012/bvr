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
import org.variabilitymodeling.cvl.CompositeVariability;
import org.variabilitymodeling.cvl.CvlPackage;
import org.variabilitymodeling.cvl.VariabilitySpecification;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Variability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.CompositeVariabilityImpl#getVariabilitySpecification <em>Variability Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeVariabilityImpl extends ExecutablePrimitiveImpl implements CompositeVariability {
	/**
	 * The cached value of the '{@link #getVariabilitySpecification() <em>Variability Specification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariabilitySpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<VariabilitySpecification> variabilitySpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeVariabilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.COMPOSITE_VARIABILITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariabilitySpecification> getVariabilitySpecification() {
		if (variabilitySpecification == null) {
			variabilitySpecification = new EObjectContainmentEList<VariabilitySpecification>(VariabilitySpecification.class, this, CvlPackage.COMPOSITE_VARIABILITY__VARIABILITY_SPECIFICATION);
		}
		return variabilitySpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitCompositeVariability(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.COMPOSITE_VARIABILITY__VARIABILITY_SPECIFICATION:
				return ((InternalEList<?>)getVariabilitySpecification()).basicRemove(otherEnd, msgs);
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
			case CvlPackage.COMPOSITE_VARIABILITY__VARIABILITY_SPECIFICATION:
				return getVariabilitySpecification();
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
			case CvlPackage.COMPOSITE_VARIABILITY__VARIABILITY_SPECIFICATION:
				getVariabilitySpecification().clear();
				getVariabilitySpecification().addAll((Collection<? extends VariabilitySpecification>)newValue);
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
			case CvlPackage.COMPOSITE_VARIABILITY__VARIABILITY_SPECIFICATION:
				getVariabilitySpecification().clear();
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
			case CvlPackage.COMPOSITE_VARIABILITY__VARIABILITY_SPECIFICATION:
				return variabilitySpecification != null && !variabilitySpecification.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeVariabilityImpl
