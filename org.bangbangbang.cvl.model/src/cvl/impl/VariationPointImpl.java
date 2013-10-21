/**
 */
package cvl.impl;

import cvl.CvlPackage;
import cvl.ObjectHandle;
import cvl.VSpec;
import cvl.VariationPoint;

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
 * An implementation of the model object '<em><b>Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.VariationPointImpl#getBindingVSpec <em>Binding VSpec</em>}</li>
 *   <li>{@link cvl.impl.VariationPointImpl#getSourceObject <em>Source Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VariationPointImpl extends VPackageableImpl implements VariationPoint {
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
	 * The cached value of the '{@link #getSourceObject() <em>Source Object</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceObject()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectHandle> sourceObject;

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
		return CvlPackage.Literals.VARIATION_POINT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.VARIATION_POINT__BINDING_VSPEC, oldBindingVSpec, bindingVSpec));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.VARIATION_POINT__BINDING_VSPEC, oldBindingVSpec, bindingVSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectHandle> getSourceObject() {
		if (sourceObject == null) {
			sourceObject = new EObjectContainmentEList<ObjectHandle>(ObjectHandle.class, this, CvlPackage.VARIATION_POINT__SOURCE_OBJECT);
		}
		return sourceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.VARIATION_POINT__SOURCE_OBJECT:
				return ((InternalEList<?>)getSourceObject()).basicRemove(otherEnd, msgs);
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
			case CvlPackage.VARIATION_POINT__BINDING_VSPEC:
				if (resolve) return getBindingVSpec();
				return basicGetBindingVSpec();
			case CvlPackage.VARIATION_POINT__SOURCE_OBJECT:
				return getSourceObject();
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
			case CvlPackage.VARIATION_POINT__BINDING_VSPEC:
				setBindingVSpec((VSpec)newValue);
				return;
			case CvlPackage.VARIATION_POINT__SOURCE_OBJECT:
				getSourceObject().clear();
				getSourceObject().addAll((Collection<? extends ObjectHandle>)newValue);
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
			case CvlPackage.VARIATION_POINT__BINDING_VSPEC:
				setBindingVSpec((VSpec)null);
				return;
			case CvlPackage.VARIATION_POINT__SOURCE_OBJECT:
				getSourceObject().clear();
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
			case CvlPackage.VARIATION_POINT__BINDING_VSPEC:
				return bindingVSpec != null;
			case CvlPackage.VARIATION_POINT__SOURCE_OBJECT:
				return sourceObject != null && !sourceObject.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VariationPointImpl
