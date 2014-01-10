/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation.impl;

import java.util.Collection;

import org.bangbangbang.cvl.system.cvlsystemrelation.AbstractChoiceReference;
import org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceGroup;
import org.bangbangbang.cvl.system.cvlsystemrelation.LogicalOperator;
import org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceGroupImpl#getChoices <em>Choices</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceGroupImpl#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChoiceGroupImpl extends AbstractChoiceReferenceImpl implements ChoiceGroup {
	/**
	 * The cached value of the '{@link #getChoices() <em>Choices</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoices()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractChoiceReference> choices;

	/**
	 * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected static final LogicalOperator OP_EDEFAULT = LogicalOperator.AND;

	/**
	 * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected LogicalOperator op = OP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationPackage.Literals.CHOICE_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractChoiceReference> getChoices() {
		if (choices == null) {
			choices = new EObjectResolvingEList<AbstractChoiceReference>(AbstractChoiceReference.class, this, RelationPackage.CHOICE_GROUP__CHOICES);
		}
		return choices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalOperator getOp() {
		return op;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp(LogicalOperator newOp) {
		LogicalOperator oldOp = op;
		op = newOp == null ? OP_EDEFAULT : newOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationPackage.CHOICE_GROUP__OP, oldOp, op));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RelationPackage.CHOICE_GROUP__CHOICES:
				return getChoices();
			case RelationPackage.CHOICE_GROUP__OP:
				return getOp();
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
			case RelationPackage.CHOICE_GROUP__CHOICES:
				getChoices().clear();
				getChoices().addAll((Collection<? extends AbstractChoiceReference>)newValue);
				return;
			case RelationPackage.CHOICE_GROUP__OP:
				setOp((LogicalOperator)newValue);
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
			case RelationPackage.CHOICE_GROUP__CHOICES:
				getChoices().clear();
				return;
			case RelationPackage.CHOICE_GROUP__OP:
				setOp(OP_EDEFAULT);
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
			case RelationPackage.CHOICE_GROUP__CHOICES:
				return choices != null && !choices.isEmpty();
			case RelationPackage.CHOICE_GROUP__OP:
				return op != OP_EDEFAULT;
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
		result.append(" (op: ");
		result.append(op);
		result.append(')');
		return result.toString();
	}

} //ChoiceGroupImpl
