/**
 */
package CVLMetamodelMaster.Main.impl;

import CVLMetamodelMaster.Main.MainPackage;
import CVLMetamodelMaster.Main.ValueSpecification;
import CVLMetamodelMaster.Main.Variable;
import CVLMetamodelMaster.Main.VariableValueAssignment;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Value Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.impl.VariableValueAssignmentImpl#getResolvedVariable <em>Resolved Variable</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.impl.VariableValueAssignmentImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableValueAssignmentImpl extends VSpecResolutionImpl implements VariableValueAssignment {
	/**
	 * The cached value of the '{@link #getResolvedVariable() <em>Resolved Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable resolvedVariable;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableValueAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MainPackage.Literals.VARIABLE_VALUE_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getResolvedVariable() {
		if (resolvedVariable != null && resolvedVariable.eIsProxy()) {
			InternalEObject oldResolvedVariable = (InternalEObject)resolvedVariable;
			resolvedVariable = (Variable)eResolveProxy(oldResolvedVariable);
			if (resolvedVariable != oldResolvedVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MainPackage.VARIABLE_VALUE_ASSIGNMENT__RESOLVED_VARIABLE, oldResolvedVariable, resolvedVariable));
			}
		}
		return resolvedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetResolvedVariable() {
		return resolvedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolvedVariable(Variable newResolvedVariable) {
		Variable oldResolvedVariable = resolvedVariable;
		resolvedVariable = newResolvedVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.VARIABLE_VALUE_ASSIGNMENT__RESOLVED_VARIABLE, oldResolvedVariable, resolvedVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(ValueSpecification newValue, NotificationChain msgs) {
		ValueSpecification oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MainPackage.VARIABLE_VALUE_ASSIGNMENT__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(ValueSpecification newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MainPackage.VARIABLE_VALUE_ASSIGNMENT__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MainPackage.VARIABLE_VALUE_ASSIGNMENT__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.VARIABLE_VALUE_ASSIGNMENT__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MainPackage.VARIABLE_VALUE_ASSIGNMENT__VALUE:
				return basicSetValue(null, msgs);
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
			case MainPackage.VARIABLE_VALUE_ASSIGNMENT__RESOLVED_VARIABLE:
				if (resolve) return getResolvedVariable();
				return basicGetResolvedVariable();
			case MainPackage.VARIABLE_VALUE_ASSIGNMENT__VALUE:
				return getValue();
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
			case MainPackage.VARIABLE_VALUE_ASSIGNMENT__RESOLVED_VARIABLE:
				setResolvedVariable((Variable)newValue);
				return;
			case MainPackage.VARIABLE_VALUE_ASSIGNMENT__VALUE:
				setValue((ValueSpecification)newValue);
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
			case MainPackage.VARIABLE_VALUE_ASSIGNMENT__RESOLVED_VARIABLE:
				setResolvedVariable((Variable)null);
				return;
			case MainPackage.VARIABLE_VALUE_ASSIGNMENT__VALUE:
				setValue((ValueSpecification)null);
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
			case MainPackage.VARIABLE_VALUE_ASSIGNMENT__RESOLVED_VARIABLE:
				return resolvedVariable != null;
			case MainPackage.VARIABLE_VALUE_ASSIGNMENT__VALUE:
				return value != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableValueAssignmentImpl
