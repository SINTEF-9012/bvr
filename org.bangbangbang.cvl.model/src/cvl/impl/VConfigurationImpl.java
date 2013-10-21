/**
 */
package cvl.impl;

import cvl.CVSpec;
import cvl.CvlPackage;
import cvl.VConfiguration;
import cvl.VSpecResolution;

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
 * An implementation of the model object '<em><b>VConfiguration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.VConfigurationImpl#getMember <em>Member</em>}</li>
 *   <li>{@link cvl.impl.VConfigurationImpl#isIsPartial <em>Is Partial</em>}</li>
 *   <li>{@link cvl.impl.VConfigurationImpl#getResolvedCVSpec <em>Resolved CV Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VConfigurationImpl extends VSpecResolutionImpl implements VConfiguration {
	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected EList<VSpecResolution> member;

	/**
	 * The default value of the '{@link #isIsPartial() <em>Is Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPartial()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PARTIAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPartial() <em>Is Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPartial()
	 * @generated
	 * @ordered
	 */
	protected boolean isPartial = IS_PARTIAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResolvedCVSpec() <em>Resolved CV Spec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedCVSpec()
	 * @generated
	 * @ordered
	 */
	protected CVSpec resolvedCVSpec;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.VCONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VSpecResolution> getMember() {
		if (member == null) {
			member = new EObjectContainmentEList<VSpecResolution>(VSpecResolution.class, this, CvlPackage.VCONFIGURATION__MEMBER);
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPartial() {
		return isPartial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPartial(boolean newIsPartial) {
		boolean oldIsPartial = isPartial;
		isPartial = newIsPartial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.VCONFIGURATION__IS_PARTIAL, oldIsPartial, isPartial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSpec getResolvedCVSpec() {
		if (resolvedCVSpec != null && resolvedCVSpec.eIsProxy()) {
			InternalEObject oldResolvedCVSpec = (InternalEObject)resolvedCVSpec;
			resolvedCVSpec = (CVSpec)eResolveProxy(oldResolvedCVSpec);
			if (resolvedCVSpec != oldResolvedCVSpec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.VCONFIGURATION__RESOLVED_CV_SPEC, oldResolvedCVSpec, resolvedCVSpec));
			}
		}
		return resolvedCVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSpec basicGetResolvedCVSpec() {
		return resolvedCVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolvedCVSpec(CVSpec newResolvedCVSpec) {
		CVSpec oldResolvedCVSpec = resolvedCVSpec;
		resolvedCVSpec = newResolvedCVSpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.VCONFIGURATION__RESOLVED_CV_SPEC, oldResolvedCVSpec, resolvedCVSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.VCONFIGURATION__MEMBER:
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
			case CvlPackage.VCONFIGURATION__MEMBER:
				return getMember();
			case CvlPackage.VCONFIGURATION__IS_PARTIAL:
				return isIsPartial();
			case CvlPackage.VCONFIGURATION__RESOLVED_CV_SPEC:
				if (resolve) return getResolvedCVSpec();
				return basicGetResolvedCVSpec();
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
			case CvlPackage.VCONFIGURATION__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends VSpecResolution>)newValue);
				return;
			case CvlPackage.VCONFIGURATION__IS_PARTIAL:
				setIsPartial((Boolean)newValue);
				return;
			case CvlPackage.VCONFIGURATION__RESOLVED_CV_SPEC:
				setResolvedCVSpec((CVSpec)newValue);
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
			case CvlPackage.VCONFIGURATION__MEMBER:
				getMember().clear();
				return;
			case CvlPackage.VCONFIGURATION__IS_PARTIAL:
				setIsPartial(IS_PARTIAL_EDEFAULT);
				return;
			case CvlPackage.VCONFIGURATION__RESOLVED_CV_SPEC:
				setResolvedCVSpec((CVSpec)null);
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
			case CvlPackage.VCONFIGURATION__MEMBER:
				return member != null && !member.isEmpty();
			case CvlPackage.VCONFIGURATION__IS_PARTIAL:
				return isPartial != IS_PARTIAL_EDEFAULT;
			case CvlPackage.VCONFIGURATION__RESOLVED_CV_SPEC:
				return resolvedCVSpec != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isPartial: ");
		result.append(isPartial);
		result.append(')');
		return result.toString();
	}

} //VConfigurationImpl
