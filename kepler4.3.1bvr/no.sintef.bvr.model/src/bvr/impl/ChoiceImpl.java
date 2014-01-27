/**
 */
package bvr.impl;

import bvr.Choice;
import bvr.BvrPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.ChoiceImpl#isDefaultResolution <em>Default Resolution</em>}</li>
 *   <li>{@link bvr.impl.ChoiceImpl#isIsImpliedByParent <em>Is Implied By Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChoiceImpl extends VSpecImpl implements Choice {
	/**
	 * The default value of the '{@link #isDefaultResolution() <em>Default Resolution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefaultResolution()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_RESOLUTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefaultResolution() <em>Default Resolution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefaultResolution()
	 * @generated
	 * @ordered
	 */
	protected boolean defaultResolution = DEFAULT_RESOLUTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsImpliedByParent() <em>Is Implied By Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsImpliedByParent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_IMPLIED_BY_PARENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsImpliedByParent() <em>Is Implied By Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsImpliedByParent()
	 * @generated
	 * @ordered
	 */
	protected boolean isImpliedByParent = IS_IMPLIED_BY_PARENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.CHOICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefaultResolution() {
		return defaultResolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultResolution(boolean newDefaultResolution) {
		boolean oldDefaultResolution = defaultResolution;
		defaultResolution = newDefaultResolution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE__DEFAULT_RESOLUTION, oldDefaultResolution, defaultResolution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsImpliedByParent() {
		return isImpliedByParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsImpliedByParent(boolean newIsImpliedByParent) {
		boolean oldIsImpliedByParent = isImpliedByParent;
		isImpliedByParent = newIsImpliedByParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE__IS_IMPLIED_BY_PARENT, oldIsImpliedByParent, isImpliedByParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.CHOICE__DEFAULT_RESOLUTION:
				return isDefaultResolution();
			case BvrPackage.CHOICE__IS_IMPLIED_BY_PARENT:
				return isIsImpliedByParent();
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
			case BvrPackage.CHOICE__DEFAULT_RESOLUTION:
				setDefaultResolution((Boolean)newValue);
				return;
			case BvrPackage.CHOICE__IS_IMPLIED_BY_PARENT:
				setIsImpliedByParent((Boolean)newValue);
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
			case BvrPackage.CHOICE__DEFAULT_RESOLUTION:
				setDefaultResolution(DEFAULT_RESOLUTION_EDEFAULT);
				return;
			case BvrPackage.CHOICE__IS_IMPLIED_BY_PARENT:
				setIsImpliedByParent(IS_IMPLIED_BY_PARENT_EDEFAULT);
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
			case BvrPackage.CHOICE__DEFAULT_RESOLUTION:
				return defaultResolution != DEFAULT_RESOLUTION_EDEFAULT;
			case BvrPackage.CHOICE__IS_IMPLIED_BY_PARENT:
				return isImpliedByParent != IS_IMPLIED_BY_PARENT_EDEFAULT;
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
		result.append(" (defaultResolution: ");
		result.append(defaultResolution);
		result.append(", isImpliedByParent: ");
		result.append(isImpliedByParent);
		result.append(')');
		return result.toString();
	}

} //ChoiceImpl
