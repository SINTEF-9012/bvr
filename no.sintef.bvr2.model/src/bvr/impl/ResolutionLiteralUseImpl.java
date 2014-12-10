/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.ResolutionLiteralDefinition;
import bvr.ResolutionLiteralUse;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolution Literal Use</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.ResolutionLiteralUseImpl#getDefLiteral <em>Def Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResolutionLiteralUseImpl extends ChoiceResolutionImpl implements ResolutionLiteralUse {
	/**
	 * The cached value of the '{@link #getDefLiteral() <em>Def Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefLiteral()
	 * @generated
	 * @ordered
	 */
	protected ResolutionLiteralDefinition defLiteral;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResolutionLiteralUseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.RESOLUTION_LITERAL_USE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolutionLiteralDefinition getDefLiteral() {
		if (defLiteral != null && defLiteral.eIsProxy()) {
			InternalEObject oldDefLiteral = (InternalEObject)defLiteral;
			defLiteral = (ResolutionLiteralDefinition)eResolveProxy(oldDefLiteral);
			if (defLiteral != oldDefLiteral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.RESOLUTION_LITERAL_USE__DEF_LITERAL, oldDefLiteral, defLiteral));
			}
		}
		return defLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolutionLiteralDefinition basicGetDefLiteral() {
		return defLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefLiteral(ResolutionLiteralDefinition newDefLiteral) {
		ResolutionLiteralDefinition oldDefLiteral = defLiteral;
		defLiteral = newDefLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.RESOLUTION_LITERAL_USE__DEF_LITERAL, oldDefLiteral, defLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.RESOLUTION_LITERAL_USE__DEF_LITERAL:
				if (resolve) return getDefLiteral();
				return basicGetDefLiteral();
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
			case BvrPackage.RESOLUTION_LITERAL_USE__DEF_LITERAL:
				setDefLiteral((ResolutionLiteralDefinition)newValue);
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
			case BvrPackage.RESOLUTION_LITERAL_USE__DEF_LITERAL:
				setDefLiteral((ResolutionLiteralDefinition)null);
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
			case BvrPackage.RESOLUTION_LITERAL_USE__DEF_LITERAL:
				return defLiteral != null;
		}
		return super.eIsSet(featureID);
	}

} //ResolutionLiteralUseImpl
