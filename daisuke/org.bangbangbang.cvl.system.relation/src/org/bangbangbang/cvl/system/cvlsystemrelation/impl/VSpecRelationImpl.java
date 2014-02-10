/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation.impl;

import java.util.Collection;

import org.bangbangbang.cvl.VSpec;

import org.bangbangbang.cvl.system.cvlsystemrelation.AbstractChoiceReference;
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
 * An implementation of the model object '<em><b>VSpec Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.VSpecRelationImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.VSpecRelationImpl#getSystemVSpec <em>System VSpec</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.VSpecRelationImpl#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VSpecRelationImpl extends MinimalEObjectImpl.Container implements VSpecRelation {
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected VSpec context;

	/**
	 * The cached value of the '{@link #getSystemVSpec() <em>System VSpec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemVSpec()
	 * @generated
	 * @ordered
	 */
	protected VSpec systemVSpec;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractChoiceReference> references;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VSpecRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationPackage.Literals.VSPEC_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject)context;
			context = (VSpec)eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationPackage.VSPEC_RELATION__CONTEXT, oldContext, context));
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(VSpec newContext) {
		VSpec oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationPackage.VSPEC_RELATION__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec getSystemVSpec() {
		if (systemVSpec != null && systemVSpec.eIsProxy()) {
			InternalEObject oldSystemVSpec = (InternalEObject)systemVSpec;
			systemVSpec = (VSpec)eResolveProxy(oldSystemVSpec);
			if (systemVSpec != oldSystemVSpec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationPackage.VSPEC_RELATION__SYSTEM_VSPEC, oldSystemVSpec, systemVSpec));
			}
		}
		return systemVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSpec basicGetSystemVSpec() {
		return systemVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemVSpec(VSpec newSystemVSpec) {
		VSpec oldSystemVSpec = systemVSpec;
		systemVSpec = newSystemVSpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationPackage.VSPEC_RELATION__SYSTEM_VSPEC, oldSystemVSpec, systemVSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractChoiceReference> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList<AbstractChoiceReference>(AbstractChoiceReference.class, this, RelationPackage.VSPEC_RELATION__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationPackage.VSPEC_RELATION__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
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
			case RelationPackage.VSPEC_RELATION__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case RelationPackage.VSPEC_RELATION__SYSTEM_VSPEC:
				if (resolve) return getSystemVSpec();
				return basicGetSystemVSpec();
			case RelationPackage.VSPEC_RELATION__REFERENCES:
				return getReferences();
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
			case RelationPackage.VSPEC_RELATION__CONTEXT:
				setContext((VSpec)newValue);
				return;
			case RelationPackage.VSPEC_RELATION__SYSTEM_VSPEC:
				setSystemVSpec((VSpec)newValue);
				return;
			case RelationPackage.VSPEC_RELATION__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends AbstractChoiceReference>)newValue);
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
			case RelationPackage.VSPEC_RELATION__CONTEXT:
				setContext((VSpec)null);
				return;
			case RelationPackage.VSPEC_RELATION__SYSTEM_VSPEC:
				setSystemVSpec((VSpec)null);
				return;
			case RelationPackage.VSPEC_RELATION__REFERENCES:
				getReferences().clear();
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
			case RelationPackage.VSPEC_RELATION__CONTEXT:
				return context != null;
			case RelationPackage.VSPEC_RELATION__SYSTEM_VSPEC:
				return systemVSpec != null;
			case RelationPackage.VSPEC_RELATION__REFERENCES:
				return references != null && !references.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VSpecRelationImpl
