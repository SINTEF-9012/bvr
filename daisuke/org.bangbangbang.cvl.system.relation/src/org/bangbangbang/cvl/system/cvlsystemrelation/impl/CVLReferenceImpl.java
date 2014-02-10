/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation.impl;

import java.util.Collection;
import org.bangbangbang.cvl.VPackageable;
import org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference;
import org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage;
import org.bangbangbang.cvl.system.cvlsystemrelation.VSpecRelation;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CVL Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.CVLReferenceImpl#getRelations <em>Relations</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.CVLReferenceImpl#getCvl <em>Cvl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CVLReferenceImpl extends MinimalEObjectImpl.Container implements CVLReference {
	/**
	 * The cached value of the '{@link #getRelations() <em>Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<VSpecRelation> relations;

	/**
	 * The cached value of the '{@link #getCvl() <em>Cvl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCvl()
	 * @generated
	 * @ordered
	 */
	protected VPackageable cvl;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CVLReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationPackage.Literals.CVL_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VSpecRelation> getRelations() {
		if (relations == null) {
			relations = new EObjectContainmentEList<VSpecRelation>(VSpecRelation.class, this, RelationPackage.CVL_REFERENCE__RELATIONS);
		}
		return relations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VPackageable getCvl() {
		if (cvl != null && cvl.eIsProxy()) {
			InternalEObject oldCvl = (InternalEObject)cvl;
			cvl = (VPackageable)eResolveProxy(oldCvl);
			if (cvl != oldCvl) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationPackage.CVL_REFERENCE__CVL, oldCvl, cvl));
			}
		}
		return cvl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VPackageable basicGetCvl() {
		return cvl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCvl(VPackageable newCvl) {
		VPackageable oldCvl = cvl;
		cvl = newCvl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationPackage.CVL_REFERENCE__CVL, oldCvl, cvl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationPackage.CVL_REFERENCE__RELATIONS:
				return ((InternalEList<?>)getRelations()).basicRemove(otherEnd, msgs);
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
			case RelationPackage.CVL_REFERENCE__RELATIONS:
				return getRelations();
			case RelationPackage.CVL_REFERENCE__CVL:
				if (resolve) return getCvl();
				return basicGetCvl();
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
			case RelationPackage.CVL_REFERENCE__RELATIONS:
				getRelations().clear();
				getRelations().addAll((Collection<? extends VSpecRelation>)newValue);
				return;
			case RelationPackage.CVL_REFERENCE__CVL:
				setCvl((VPackageable)newValue);
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
			case RelationPackage.CVL_REFERENCE__RELATIONS:
				getRelations().clear();
				return;
			case RelationPackage.CVL_REFERENCE__CVL:
				setCvl((VPackageable)null);
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
			case RelationPackage.CVL_REFERENCE__RELATIONS:
				return relations != null && !relations.isEmpty();
			case RelationPackage.CVL_REFERENCE__CVL:
				return cvl != null;
		}
		return super.eIsSet(featureID);
	}

} //CVLReferenceImpl
