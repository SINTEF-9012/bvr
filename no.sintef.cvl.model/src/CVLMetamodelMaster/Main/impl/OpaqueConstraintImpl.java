/**
 */
package CVLMetamodelMaster.Main.impl;

import CVLMetamodelMaster.Main.MainPackage;
import CVLMetamodelMaster.Main.OpaqueConstraint;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opaque Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.impl.OpaqueConstraintImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.impl.OpaqueConstraintImpl#getConstraintLanguage <em>Constraint Language</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpaqueConstraintImpl extends ConstraintImpl implements OpaqueConstraint {
	/**
	 * The default value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSTRAINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected String constraint = CONSTRAINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getConstraintLanguage() <em>Constraint Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSTRAINT_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstraintLanguage() <em>Constraint Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintLanguage()
	 * @generated
	 * @ordered
	 */
	protected String constraintLanguage = CONSTRAINT_LANGUAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MainPackage.Literals.OPAQUE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConstraint() {
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraint(String newConstraint) {
		String oldConstraint = constraint;
		constraint = newConstraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.OPAQUE_CONSTRAINT__CONSTRAINT, oldConstraint, constraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConstraintLanguage() {
		return constraintLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintLanguage(String newConstraintLanguage) {
		String oldConstraintLanguage = constraintLanguage;
		constraintLanguage = newConstraintLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.OPAQUE_CONSTRAINT__CONSTRAINT_LANGUAGE, oldConstraintLanguage, constraintLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MainPackage.OPAQUE_CONSTRAINT__CONSTRAINT:
				return getConstraint();
			case MainPackage.OPAQUE_CONSTRAINT__CONSTRAINT_LANGUAGE:
				return getConstraintLanguage();
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
			case MainPackage.OPAQUE_CONSTRAINT__CONSTRAINT:
				setConstraint((String)newValue);
				return;
			case MainPackage.OPAQUE_CONSTRAINT__CONSTRAINT_LANGUAGE:
				setConstraintLanguage((String)newValue);
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
			case MainPackage.OPAQUE_CONSTRAINT__CONSTRAINT:
				setConstraint(CONSTRAINT_EDEFAULT);
				return;
			case MainPackage.OPAQUE_CONSTRAINT__CONSTRAINT_LANGUAGE:
				setConstraintLanguage(CONSTRAINT_LANGUAGE_EDEFAULT);
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
			case MainPackage.OPAQUE_CONSTRAINT__CONSTRAINT:
				return CONSTRAINT_EDEFAULT == null ? constraint != null : !CONSTRAINT_EDEFAULT.equals(constraint);
			case MainPackage.OPAQUE_CONSTRAINT__CONSTRAINT_LANGUAGE:
				return CONSTRAINT_LANGUAGE_EDEFAULT == null ? constraintLanguage != null : !CONSTRAINT_LANGUAGE_EDEFAULT.equals(constraintLanguage);
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
		result.append(" (constraint: ");
		result.append(constraint);
		result.append(", constraintLanguage: ");
		result.append(constraintLanguage);
		result.append(')');
		return result.toString();
	}

} //OpaqueConstraintImpl
