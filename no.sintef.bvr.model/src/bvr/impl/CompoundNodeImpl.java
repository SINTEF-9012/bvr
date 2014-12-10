/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.CompoundNode;
import bvr.Target;
import bvr.VNode;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compound Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.CompoundNodeImpl#getMember <em>Member</em>}</li>
 *   <li>{@link bvr.impl.CompoundNodeImpl#getOwnedTargets <em>Owned Targets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompoundNodeImpl extends VNodeImpl implements CompoundNode {
	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected EList<VNode> member;

	/**
	 * The cached value of the '{@link #getOwnedTargets() <em>Owned Targets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<Target> ownedTargets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompoundNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.COMPOUND_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VNode> getMember() {
		if (member == null) {
			member = new EObjectContainmentEList<VNode>(VNode.class, this, BvrPackage.COMPOUND_NODE__MEMBER);
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Target> getOwnedTargets() {
		if (ownedTargets == null) {
			ownedTargets = new EObjectContainmentEList<Target>(Target.class, this, BvrPackage.COMPOUND_NODE__OWNED_TARGETS);
		}
		return ownedTargets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.COMPOUND_NODE__MEMBER:
				return ((InternalEList<?>)getMember()).basicRemove(otherEnd, msgs);
			case BvrPackage.COMPOUND_NODE__OWNED_TARGETS:
				return ((InternalEList<?>)getOwnedTargets()).basicRemove(otherEnd, msgs);
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
			case BvrPackage.COMPOUND_NODE__MEMBER:
				return getMember();
			case BvrPackage.COMPOUND_NODE__OWNED_TARGETS:
				return getOwnedTargets();
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
			case BvrPackage.COMPOUND_NODE__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends VNode>)newValue);
				return;
			case BvrPackage.COMPOUND_NODE__OWNED_TARGETS:
				getOwnedTargets().clear();
				getOwnedTargets().addAll((Collection<? extends Target>)newValue);
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
			case BvrPackage.COMPOUND_NODE__MEMBER:
				getMember().clear();
				return;
			case BvrPackage.COMPOUND_NODE__OWNED_TARGETS:
				getOwnedTargets().clear();
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
			case BvrPackage.COMPOUND_NODE__MEMBER:
				return member != null && !member.isEmpty();
			case BvrPackage.COMPOUND_NODE__OWNED_TARGETS:
				return ownedTargets != null && !ownedTargets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompoundNodeImpl
