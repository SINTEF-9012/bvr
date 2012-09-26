/**
 */
package CVLMetamodelMaster.Main.impl;

import CVLMetamodelMaster.Main.CVSpec;
import CVLMetamodelMaster.Main.CVSpecDerivation;
import CVLMetamodelMaster.Main.MainPackage;
import CVLMetamodelMaster.Main.VSpecDerivation;

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
 * An implementation of the model object '<em><b>CV Spec Derivation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.impl.CVSpecDerivationImpl#getMemberDerivation <em>Member Derivation</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.impl.CVSpecDerivationImpl#getDerivingCVspec <em>Deriving CVspec</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.impl.CVSpecDerivationImpl#getDerivedCVSpec <em>Derived CV Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CVSpecDerivationImpl extends VSpecDerivationImpl implements CVSpecDerivation {
	/**
	 * The cached value of the '{@link #getMemberDerivation() <em>Member Derivation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberDerivation()
	 * @generated
	 * @ordered
	 */
	protected EList<VSpecDerivation> memberDerivation;

	/**
	 * The cached value of the '{@link #getDerivingCVspec() <em>Deriving CVspec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivingCVspec()
	 * @generated
	 * @ordered
	 */
	protected CVSpec derivingCVspec;

	/**
	 * The cached value of the '{@link #getDerivedCVSpec() <em>Derived CV Spec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedCVSpec()
	 * @generated
	 * @ordered
	 */
	protected CVSpec derivedCVSpec;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CVSpecDerivationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MainPackage.Literals.CV_SPEC_DERIVATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VSpecDerivation> getMemberDerivation() {
		if (memberDerivation == null) {
			memberDerivation = new EObjectContainmentEList<VSpecDerivation>(VSpecDerivation.class, this, MainPackage.CV_SPEC_DERIVATION__MEMBER_DERIVATION);
		}
		return memberDerivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSpec getDerivingCVspec() {
		if (derivingCVspec != null && derivingCVspec.eIsProxy()) {
			InternalEObject oldDerivingCVspec = (InternalEObject)derivingCVspec;
			derivingCVspec = (CVSpec)eResolveProxy(oldDerivingCVspec);
			if (derivingCVspec != oldDerivingCVspec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MainPackage.CV_SPEC_DERIVATION__DERIVING_CVSPEC, oldDerivingCVspec, derivingCVspec));
			}
		}
		return derivingCVspec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSpec basicGetDerivingCVspec() {
		return derivingCVspec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivingCVspec(CVSpec newDerivingCVspec) {
		CVSpec oldDerivingCVspec = derivingCVspec;
		derivingCVspec = newDerivingCVspec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.CV_SPEC_DERIVATION__DERIVING_CVSPEC, oldDerivingCVspec, derivingCVspec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSpec getDerivedCVSpec() {
		if (derivedCVSpec != null && derivedCVSpec.eIsProxy()) {
			InternalEObject oldDerivedCVSpec = (InternalEObject)derivedCVSpec;
			derivedCVSpec = (CVSpec)eResolveProxy(oldDerivedCVSpec);
			if (derivedCVSpec != oldDerivedCVSpec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MainPackage.CV_SPEC_DERIVATION__DERIVED_CV_SPEC, oldDerivedCVSpec, derivedCVSpec));
			}
		}
		return derivedCVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSpec basicGetDerivedCVSpec() {
		return derivedCVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivedCVSpec(CVSpec newDerivedCVSpec) {
		CVSpec oldDerivedCVSpec = derivedCVSpec;
		derivedCVSpec = newDerivedCVSpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.CV_SPEC_DERIVATION__DERIVED_CV_SPEC, oldDerivedCVSpec, derivedCVSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MainPackage.CV_SPEC_DERIVATION__MEMBER_DERIVATION:
				return ((InternalEList<?>)getMemberDerivation()).basicRemove(otherEnd, msgs);
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
			case MainPackage.CV_SPEC_DERIVATION__MEMBER_DERIVATION:
				return getMemberDerivation();
			case MainPackage.CV_SPEC_DERIVATION__DERIVING_CVSPEC:
				if (resolve) return getDerivingCVspec();
				return basicGetDerivingCVspec();
			case MainPackage.CV_SPEC_DERIVATION__DERIVED_CV_SPEC:
				if (resolve) return getDerivedCVSpec();
				return basicGetDerivedCVSpec();
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
			case MainPackage.CV_SPEC_DERIVATION__MEMBER_DERIVATION:
				getMemberDerivation().clear();
				getMemberDerivation().addAll((Collection<? extends VSpecDerivation>)newValue);
				return;
			case MainPackage.CV_SPEC_DERIVATION__DERIVING_CVSPEC:
				setDerivingCVspec((CVSpec)newValue);
				return;
			case MainPackage.CV_SPEC_DERIVATION__DERIVED_CV_SPEC:
				setDerivedCVSpec((CVSpec)newValue);
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
			case MainPackage.CV_SPEC_DERIVATION__MEMBER_DERIVATION:
				getMemberDerivation().clear();
				return;
			case MainPackage.CV_SPEC_DERIVATION__DERIVING_CVSPEC:
				setDerivingCVspec((CVSpec)null);
				return;
			case MainPackage.CV_SPEC_DERIVATION__DERIVED_CV_SPEC:
				setDerivedCVSpec((CVSpec)null);
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
			case MainPackage.CV_SPEC_DERIVATION__MEMBER_DERIVATION:
				return memberDerivation != null && !memberDerivation.isEmpty();
			case MainPackage.CV_SPEC_DERIVATION__DERIVING_CVSPEC:
				return derivingCVspec != null;
			case MainPackage.CV_SPEC_DERIVATION__DERIVED_CV_SPEC:
				return derivedCVSpec != null;
		}
		return super.eIsSet(featureID);
	}

} //CVSpecDerivationImpl
