/**
 */
package cvl.impl;

import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.cvlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice Resolutuion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.ChoiceResolutuionImpl#getResolvedChoice <em>Resolved Choice</em>}</li>
 *   <li>{@link cvl.impl.ChoiceResolutuionImpl#isDecision <em>Decision</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChoiceResolutuionImpl extends VSpecResolutionImpl implements ChoiceResolutuion {
	/**
	 * The cached value of the '{@link #getResolvedChoice() <em>Resolved Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedChoice()
	 * @generated
	 * @ordered
	 */
	protected Choice resolvedChoice;

	/**
	 * The default value of the '{@link #isDecision() <em>Decision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDecision()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DECISION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDecision() <em>Decision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDecision()
	 * @generated
	 * @ordered
	 */
	protected boolean decision = DECISION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceResolutuionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return cvlPackage.Literals.CHOICE_RESOLUTUION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice getResolvedChoice() {
		if (resolvedChoice != null && resolvedChoice.eIsProxy()) {
			InternalEObject oldResolvedChoice = (InternalEObject)resolvedChoice;
			resolvedChoice = (Choice)eResolveProxy(oldResolvedChoice);
			if (resolvedChoice != oldResolvedChoice) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, cvlPackage.CHOICE_RESOLUTUION__RESOLVED_CHOICE, oldResolvedChoice, resolvedChoice));
			}
		}
		return resolvedChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice basicGetResolvedChoice() {
		return resolvedChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolvedChoice(Choice newResolvedChoice) {
		Choice oldResolvedChoice = resolvedChoice;
		resolvedChoice = newResolvedChoice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.CHOICE_RESOLUTUION__RESOLVED_CHOICE, oldResolvedChoice, resolvedChoice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDecision() {
		return decision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecision(boolean newDecision) {
		boolean oldDecision = decision;
		decision = newDecision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.CHOICE_RESOLUTUION__DECISION, oldDecision, decision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case cvlPackage.CHOICE_RESOLUTUION__RESOLVED_CHOICE:
				if (resolve) return getResolvedChoice();
				return basicGetResolvedChoice();
			case cvlPackage.CHOICE_RESOLUTUION__DECISION:
				return isDecision();
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
			case cvlPackage.CHOICE_RESOLUTUION__RESOLVED_CHOICE:
				setResolvedChoice((Choice)newValue);
				return;
			case cvlPackage.CHOICE_RESOLUTUION__DECISION:
				setDecision((Boolean)newValue);
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
			case cvlPackage.CHOICE_RESOLUTUION__RESOLVED_CHOICE:
				setResolvedChoice((Choice)null);
				return;
			case cvlPackage.CHOICE_RESOLUTUION__DECISION:
				setDecision(DECISION_EDEFAULT);
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
			case cvlPackage.CHOICE_RESOLUTUION__RESOLVED_CHOICE:
				return resolvedChoice != null;
			case cvlPackage.CHOICE_RESOLUTUION__DECISION:
				return decision != DECISION_EDEFAULT;
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
		result.append(" (decision: ");
		result.append(decision);
		result.append(')');
		return result.toString();
	}

} //ChoiceResolutuionImpl
