/**
 */
package cvl.impl;

import cvl.VSpec;
import cvl.VSpecResolution;
import cvl.cvlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VSpec Resolution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.VSpecResolutionImpl#getResolvedVSpec <em>Resolved VSpec</em>}</li>
 *   <li>{@link cvl.impl.VSpecResolutionImpl#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VSpecResolutionImpl extends VPackageableImpl implements VSpecResolution {
	/**
	 * The cached value of the '{@link #getResolvedVSpec() <em>Resolved VSpec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedVSpec()
	 * @generated
	 * @ordered
	 */
	protected VSpec resolvedVSpec;

	/**
	 * The cached value of the '{@link #getChild() <em>Child</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChild()
	 * @generated
	 * @ordered
	 */
	protected EList<VSpecResolution> child;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VSpecResolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return cvlPackage.Literals.VSPEC_RESOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec getResolvedVSpec() {
		if (resolvedVSpec != null && resolvedVSpec.eIsProxy()) {
			InternalEObject oldResolvedVSpec = (InternalEObject)resolvedVSpec;
			resolvedVSpec = (VSpec)eResolveProxy(oldResolvedVSpec);
			if (resolvedVSpec != oldResolvedVSpec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, cvlPackage.VSPEC_RESOLUTION__RESOLVED_VSPEC, oldResolvedVSpec, resolvedVSpec));
			}
		}
		return resolvedVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec basicGetResolvedVSpec() {
		return resolvedVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolvedVSpec(VSpec newResolvedVSpec) {
		VSpec oldResolvedVSpec = resolvedVSpec;
		resolvedVSpec = newResolvedVSpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.VSPEC_RESOLUTION__RESOLVED_VSPEC, oldResolvedVSpec, resolvedVSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VSpecResolution> getChild() {
		if (child == null) {
			child = new EObjectContainmentEList<VSpecResolution>(VSpecResolution.class, this, cvlPackage.VSPEC_RESOLUTION__CHILD);
		}
		return child;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case cvlPackage.VSPEC_RESOLUTION__CHILD:
				return ((InternalEList<?>)getChild()).basicRemove(otherEnd, msgs);
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
			case cvlPackage.VSPEC_RESOLUTION__RESOLVED_VSPEC:
				if (resolve) return getResolvedVSpec();
				return basicGetResolvedVSpec();
			case cvlPackage.VSPEC_RESOLUTION__CHILD:
				return getChild();
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
			case cvlPackage.VSPEC_RESOLUTION__RESOLVED_VSPEC:
				setResolvedVSpec((VSpec)newValue);
				return;
			case cvlPackage.VSPEC_RESOLUTION__CHILD:
				getChild().clear();
				getChild().addAll((Collection<? extends VSpecResolution>)newValue);
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
			case cvlPackage.VSPEC_RESOLUTION__RESOLVED_VSPEC:
				setResolvedVSpec((VSpec)null);
				return;
			case cvlPackage.VSPEC_RESOLUTION__CHILD:
				getChild().clear();
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
			case cvlPackage.VSPEC_RESOLUTION__RESOLVED_VSPEC:
				return resolvedVSpec != null;
			case cvlPackage.VSPEC_RESOLUTION__CHILD:
				return child != null && !child.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VSpecResolutionImpl
