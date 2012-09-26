/**
 */
package CVLMetamodelMaster.Main.impl;

import CVLMetamodelMaster.Main.Choice;
import CVLMetamodelMaster.Main.ChoiceDerivation;
import CVLMetamodelMaster.Main.Constraint;
import CVLMetamodelMaster.Main.MainPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice Derivation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.impl.ChoiceDerivationImpl#getDerivingConstraint <em>Deriving Constraint</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.impl.ChoiceDerivationImpl#getDerivedChoice <em>Derived Choice</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChoiceDerivationImpl extends VSpecDerivationImpl implements ChoiceDerivation {
	/**
	 * The cached value of the '{@link #getDerivingConstraint() <em>Deriving Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivingConstraint()
	 * @generated
	 * @ordered
	 */
	protected Constraint derivingConstraint;

	/**
	 * The cached value of the '{@link #getDerivedChoice() <em>Derived Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedChoice()
	 * @generated
	 * @ordered
	 */
	protected Choice derivedChoice;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceDerivationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MainPackage.Literals.CHOICE_DERIVATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint getDerivingConstraint() {
		return derivingConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDerivingConstraint(Constraint newDerivingConstraint, NotificationChain msgs) {
		Constraint oldDerivingConstraint = derivingConstraint;
		derivingConstraint = newDerivingConstraint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MainPackage.CHOICE_DERIVATION__DERIVING_CONSTRAINT, oldDerivingConstraint, newDerivingConstraint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivingConstraint(Constraint newDerivingConstraint) {
		if (newDerivingConstraint != derivingConstraint) {
			NotificationChain msgs = null;
			if (derivingConstraint != null)
				msgs = ((InternalEObject)derivingConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MainPackage.CHOICE_DERIVATION__DERIVING_CONSTRAINT, null, msgs);
			if (newDerivingConstraint != null)
				msgs = ((InternalEObject)newDerivingConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MainPackage.CHOICE_DERIVATION__DERIVING_CONSTRAINT, null, msgs);
			msgs = basicSetDerivingConstraint(newDerivingConstraint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.CHOICE_DERIVATION__DERIVING_CONSTRAINT, newDerivingConstraint, newDerivingConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice getDerivedChoice() {
		if (derivedChoice != null && derivedChoice.eIsProxy()) {
			InternalEObject oldDerivedChoice = (InternalEObject)derivedChoice;
			derivedChoice = (Choice)eResolveProxy(oldDerivedChoice);
			if (derivedChoice != oldDerivedChoice) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MainPackage.CHOICE_DERIVATION__DERIVED_CHOICE, oldDerivedChoice, derivedChoice));
			}
		}
		return derivedChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice basicGetDerivedChoice() {
		return derivedChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivedChoice(Choice newDerivedChoice) {
		Choice oldDerivedChoice = derivedChoice;
		derivedChoice = newDerivedChoice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.CHOICE_DERIVATION__DERIVED_CHOICE, oldDerivedChoice, derivedChoice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MainPackage.CHOICE_DERIVATION__DERIVING_CONSTRAINT:
				return basicSetDerivingConstraint(null, msgs);
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
			case MainPackage.CHOICE_DERIVATION__DERIVING_CONSTRAINT:
				return getDerivingConstraint();
			case MainPackage.CHOICE_DERIVATION__DERIVED_CHOICE:
				if (resolve) return getDerivedChoice();
				return basicGetDerivedChoice();
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
			case MainPackage.CHOICE_DERIVATION__DERIVING_CONSTRAINT:
				setDerivingConstraint((Constraint)newValue);
				return;
			case MainPackage.CHOICE_DERIVATION__DERIVED_CHOICE:
				setDerivedChoice((Choice)newValue);
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
			case MainPackage.CHOICE_DERIVATION__DERIVING_CONSTRAINT:
				setDerivingConstraint((Constraint)null);
				return;
			case MainPackage.CHOICE_DERIVATION__DERIVED_CHOICE:
				setDerivedChoice((Choice)null);
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
			case MainPackage.CHOICE_DERIVATION__DERIVING_CONSTRAINT:
				return derivingConstraint != null;
			case MainPackage.CHOICE_DERIVATION__DERIVED_CHOICE:
				return derivedChoice != null;
		}
		return super.eIsSet(featureID);
	}

} //ChoiceDerivationImpl
