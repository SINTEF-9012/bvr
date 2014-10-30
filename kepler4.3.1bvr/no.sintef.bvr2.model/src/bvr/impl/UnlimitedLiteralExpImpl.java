/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.UnlimitedLiteralExp;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unlimited Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.UnlimitedLiteralExpImpl#getUnlimited <em>Unlimited</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnlimitedLiteralExpImpl extends NumericLiteralExpImpl implements UnlimitedLiteralExp {
	/**
	 * The default value of the '{@link #getUnlimited() <em>Unlimited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnlimited()
	 * @generated
	 * @ordered
	 */
	protected static final int UNLIMITED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUnlimited() <em>Unlimited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnlimited()
	 * @generated
	 * @ordered
	 */
	protected int unlimited = UNLIMITED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnlimitedLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.UNLIMITED_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUnlimited() {
		return unlimited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnlimited(int newUnlimited) {
		int oldUnlimited = unlimited;
		unlimited = newUnlimited;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.UNLIMITED_LITERAL_EXP__UNLIMITED, oldUnlimited, unlimited));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.UNLIMITED_LITERAL_EXP__UNLIMITED:
				return getUnlimited();
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
			case BvrPackage.UNLIMITED_LITERAL_EXP__UNLIMITED:
				setUnlimited((Integer)newValue);
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
			case BvrPackage.UNLIMITED_LITERAL_EXP__UNLIMITED:
				setUnlimited(UNLIMITED_EDEFAULT);
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
			case BvrPackage.UNLIMITED_LITERAL_EXP__UNLIMITED:
				return unlimited != UNLIMITED_EDEFAULT;
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
		result.append(" (unlimited: ");
		result.append(unlimited);
		result.append(')');
		return result.toString();
	}

} //UnlimitedLiteralExpImpl
