/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.StagedVariationPoint;
import bvr.VSpec;
import bvr.VariationPoint;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.VariationPointImpl#getBindingVSpec <em>Binding VSpec</em>}</li>
 *   <li>{@link bvr.impl.VariationPointImpl#getStagedVariationPoint <em>Staged Variation Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VariationPointImpl extends NamedElementImpl implements VariationPoint {
	/**
	 * The cached value of the '{@link #getBindingVSpec() <em>Binding VSpec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingVSpec()
	 * @generated
	 * @ordered
	 */
	protected VSpec bindingVSpec;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariationPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.VARIATION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec getBindingVSpec() {
		if (bindingVSpec != null && bindingVSpec.eIsProxy()) {
			InternalEObject oldBindingVSpec = (InternalEObject)bindingVSpec;
			bindingVSpec = (VSpec)eResolveProxy(oldBindingVSpec);
			if (bindingVSpec != oldBindingVSpec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.VARIATION_POINT__BINDING_VSPEC, oldBindingVSpec, bindingVSpec));
			}
		}
		return bindingVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec basicGetBindingVSpec() {
		return bindingVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingVSpec(VSpec newBindingVSpec) {
		VSpec oldBindingVSpec = bindingVSpec;
		bindingVSpec = newBindingVSpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.VARIATION_POINT__BINDING_VSPEC, oldBindingVSpec, bindingVSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StagedVariationPoint getStagedVariationPoint() {
		if (eContainerFeatureID() != BvrPackage.VARIATION_POINT__STAGED_VARIATION_POINT) return null;
		return (StagedVariationPoint)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStagedVariationPoint(StagedVariationPoint newStagedVariationPoint, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newStagedVariationPoint, BvrPackage.VARIATION_POINT__STAGED_VARIATION_POINT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStagedVariationPoint(StagedVariationPoint newStagedVariationPoint) {
		if (newStagedVariationPoint != eInternalContainer() || (eContainerFeatureID() != BvrPackage.VARIATION_POINT__STAGED_VARIATION_POINT && newStagedVariationPoint != null)) {
			if (EcoreUtil.isAncestor(this, newStagedVariationPoint))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newStagedVariationPoint != null)
				msgs = ((InternalEObject)newStagedVariationPoint).eInverseAdd(this, BvrPackage.STAGED_VARIATION_POINT__MEMBER, StagedVariationPoint.class, msgs);
			msgs = basicSetStagedVariationPoint(newStagedVariationPoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.VARIATION_POINT__STAGED_VARIATION_POINT, newStagedVariationPoint, newStagedVariationPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.VARIATION_POINT__STAGED_VARIATION_POINT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetStagedVariationPoint((StagedVariationPoint)otherEnd, msgs);
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
			case BvrPackage.VARIATION_POINT__STAGED_VARIATION_POINT:
				return basicSetStagedVariationPoint(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case BvrPackage.VARIATION_POINT__STAGED_VARIATION_POINT:
				return eInternalContainer().eInverseRemove(this, BvrPackage.STAGED_VARIATION_POINT__MEMBER, StagedVariationPoint.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.VARIATION_POINT__BINDING_VSPEC:
				if (resolve) return getBindingVSpec();
				return basicGetBindingVSpec();
			case BvrPackage.VARIATION_POINT__STAGED_VARIATION_POINT:
				return getStagedVariationPoint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BvrPackage.VARIATION_POINT__BINDING_VSPEC:
				setBindingVSpec((VSpec)newValue);
				return;
			case BvrPackage.VARIATION_POINT__STAGED_VARIATION_POINT:
				setStagedVariationPoint((StagedVariationPoint)newValue);
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
			case BvrPackage.VARIATION_POINT__BINDING_VSPEC:
				setBindingVSpec((VSpec)null);
				return;
			case BvrPackage.VARIATION_POINT__STAGED_VARIATION_POINT:
				setStagedVariationPoint((StagedVariationPoint)null);
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
			case BvrPackage.VARIATION_POINT__BINDING_VSPEC:
				return bindingVSpec != null;
			case BvrPackage.VARIATION_POINT__STAGED_VARIATION_POINT:
				return getStagedVariationPoint() != null;
		}
		return super.eIsSet(featureID);
	}

} //VariationPointImpl
