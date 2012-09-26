/**
 */
package CVLMetamodelMaster.Main.impl;

import CVLMetamodelMaster.Main.MainPackage;
import CVLMetamodelMaster.Main.VSpec;
import CVLMetamodelMaster.Main.VariationPoint;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.impl.VariationPointImpl#getBindingVSpec <em>Binding VSpec</em>}</li>
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
		return MainPackage.Literals.VARIATION_POINT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MainPackage.VARIATION_POINT__BINDING_VSPEC, oldBindingVSpec, bindingVSpec));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.VARIATION_POINT__BINDING_VSPEC, oldBindingVSpec, bindingVSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MainPackage.VARIATION_POINT__BINDING_VSPEC:
				if (resolve) return getBindingVSpec();
				return basicGetBindingVSpec();
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
			case MainPackage.VARIATION_POINT__BINDING_VSPEC:
				setBindingVSpec((VSpec)newValue);
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
			case MainPackage.VARIATION_POINT__BINDING_VSPEC:
				setBindingVSpec((VSpec)null);
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
			case MainPackage.VARIATION_POINT__BINDING_VSPEC:
				return bindingVSpec != null;
		}
		return super.eIsSet(featureID);
	}

} //VariationPointImpl
