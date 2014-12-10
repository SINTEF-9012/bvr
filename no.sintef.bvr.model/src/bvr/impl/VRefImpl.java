/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.VRef;
import bvr.VSpec;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VRef</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.VRefImpl#getRefVSpec <em>Ref VSpec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VRefImpl extends VariabletypeImpl implements VRef {
	/**
	 * The cached value of the '{@link #getRefVSpec() <em>Ref VSpec</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefVSpec()
	 * @generated
	 * @ordered
	 */
	protected EList<VSpec> refVSpec;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.VREF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VSpec> getRefVSpec() {
		if (refVSpec == null) {
			refVSpec = new EObjectResolvingEList<VSpec>(VSpec.class, this, BvrPackage.VREF__REF_VSPEC);
		}
		return refVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.VREF__REF_VSPEC:
				return getRefVSpec();
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
			case BvrPackage.VREF__REF_VSPEC:
				getRefVSpec().clear();
				getRefVSpec().addAll((Collection<? extends VSpec>)newValue);
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
			case BvrPackage.VREF__REF_VSPEC:
				getRefVSpec().clear();
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
			case BvrPackage.VREF__REF_VSPEC:
				return refVSpec != null && !refVSpec.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VRefImpl
