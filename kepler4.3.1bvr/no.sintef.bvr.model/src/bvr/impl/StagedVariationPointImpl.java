/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.StagedVariationPoint;
import bvr.VSpec;
import bvr.VariationPoint;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Staged Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.StagedVariationPointImpl#getBindingStagedVP <em>Binding Staged VP</em>}</li>
 *   <li>{@link bvr.impl.StagedVariationPointImpl#getMember <em>Member</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StagedVariationPointImpl extends VariationPointImpl implements StagedVariationPoint {
	/**
	 * The cached value of the '{@link #getBindingStagedVP() <em>Binding Staged VP</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingStagedVP()
	 * @generated
	 * @ordered
	 */
	protected VSpec bindingStagedVP;

	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected EList<VariationPoint> member;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StagedVariationPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.STAGED_VARIATION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec getBindingStagedVP() {
		if (bindingStagedVP != null && bindingStagedVP.eIsProxy()) {
			InternalEObject oldBindingStagedVP = (InternalEObject)bindingStagedVP;
			bindingStagedVP = (VSpec)eResolveProxy(oldBindingStagedVP);
			if (bindingStagedVP != oldBindingStagedVP) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.STAGED_VARIATION_POINT__BINDING_STAGED_VP, oldBindingStagedVP, bindingStagedVP));
			}
		}
		return bindingStagedVP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec basicGetBindingStagedVP() {
		return bindingStagedVP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingStagedVP(VSpec newBindingStagedVP) {
		VSpec oldBindingStagedVP = bindingStagedVP;
		bindingStagedVP = newBindingStagedVP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.STAGED_VARIATION_POINT__BINDING_STAGED_VP, oldBindingStagedVP, bindingStagedVP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariationPoint> getMember() {
		if (member == null) {
			member = new EObjectContainmentWithInverseEList<VariationPoint>(VariationPoint.class, this, BvrPackage.STAGED_VARIATION_POINT__MEMBER, BvrPackage.VARIATION_POINT__STAGED_VARIATION_POINT);
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.STAGED_VARIATION_POINT__MEMBER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMember()).basicAdd(otherEnd, msgs);
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
			case BvrPackage.STAGED_VARIATION_POINT__MEMBER:
				return ((InternalEList<?>)getMember()).basicRemove(otherEnd, msgs);
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
			case BvrPackage.STAGED_VARIATION_POINT__BINDING_STAGED_VP:
				if (resolve) return getBindingStagedVP();
				return basicGetBindingStagedVP();
			case BvrPackage.STAGED_VARIATION_POINT__MEMBER:
				return getMember();
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
			case BvrPackage.STAGED_VARIATION_POINT__BINDING_STAGED_VP:
				setBindingStagedVP((VSpec)newValue);
				return;
			case BvrPackage.STAGED_VARIATION_POINT__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends VariationPoint>)newValue);
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
			case BvrPackage.STAGED_VARIATION_POINT__BINDING_STAGED_VP:
				setBindingStagedVP((VSpec)null);
				return;
			case BvrPackage.STAGED_VARIATION_POINT__MEMBER:
				getMember().clear();
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
			case BvrPackage.STAGED_VARIATION_POINT__BINDING_STAGED_VP:
				return bindingStagedVP != null;
			case BvrPackage.STAGED_VARIATION_POINT__MEMBER:
				return member != null && !member.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StagedVariationPointImpl
