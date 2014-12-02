/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.Constraint;
import bvr.MultiplicityInterval;
import bvr.VClassOccurrence;
import bvr.VNode;
import bvr.VType;
import bvr.Variable;

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
 * An implementation of the model object '<em><b>VClass Occurrence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.VClassOccurrenceImpl#getGroupMultiplicity <em>Group Multiplicity</em>}</li>
 *   <li>{@link bvr.impl.VClassOccurrenceImpl#getOwnedConstraint <em>Owned Constraint</em>}</li>
 *   <li>{@link bvr.impl.VClassOccurrenceImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link bvr.impl.VClassOccurrenceImpl#getVType <em>VType</em>}</li>
 *   <li>{@link bvr.impl.VClassOccurrenceImpl#getInstanceMultiplicity <em>Instance Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VClassOccurrenceImpl extends VSpecImpl implements VClassOccurrence {
	/**
	 * The cached value of the '{@link #getGroupMultiplicity() <em>Group Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityInterval groupMultiplicity;

	/**
	 * The cached value of the '{@link #getOwnedConstraint() <em>Owned Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> ownedConstraint;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variable;

	/**
	 * The cached value of the '{@link #getVType() <em>VType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVType()
	 * @generated
	 * @ordered
	 */
	protected VType vType;

	/**
	 * The cached value of the '{@link #getInstanceMultiplicity() <em>Instance Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityInterval instanceMultiplicity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VClassOccurrenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.VCLASS_OCCURRENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityInterval getGroupMultiplicity() {
		return groupMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroupMultiplicity(MultiplicityInterval newGroupMultiplicity, NotificationChain msgs) {
		MultiplicityInterval oldGroupMultiplicity = groupMultiplicity;
		groupMultiplicity = newGroupMultiplicity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BvrPackage.VCLASS_OCCURRENCE__GROUP_MULTIPLICITY, oldGroupMultiplicity, newGroupMultiplicity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupMultiplicity(MultiplicityInterval newGroupMultiplicity) {
		if (newGroupMultiplicity != groupMultiplicity) {
			NotificationChain msgs = null;
			if (groupMultiplicity != null)
				msgs = ((InternalEObject)groupMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BvrPackage.VCLASS_OCCURRENCE__GROUP_MULTIPLICITY, null, msgs);
			if (newGroupMultiplicity != null)
				msgs = ((InternalEObject)newGroupMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BvrPackage.VCLASS_OCCURRENCE__GROUP_MULTIPLICITY, null, msgs);
			msgs = basicSetGroupMultiplicity(newGroupMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.VCLASS_OCCURRENCE__GROUP_MULTIPLICITY, newGroupMultiplicity, newGroupMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getOwnedConstraint() {
		if (ownedConstraint == null) {
			ownedConstraint = new EObjectContainmentEList<Constraint>(Constraint.class, this, BvrPackage.VCLASS_OCCURRENCE__OWNED_CONSTRAINT);
		}
		return ownedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariable() {
		if (variable == null) {
			variable = new EObjectContainmentEList<Variable>(Variable.class, this, BvrPackage.VCLASS_OCCURRENCE__VARIABLE);
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VType getVType() {
		if (vType != null && vType.eIsProxy()) {
			InternalEObject oldVType = (InternalEObject)vType;
			vType = (VType)eResolveProxy(oldVType);
			if (vType != oldVType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.VCLASS_OCCURRENCE__VTYPE, oldVType, vType));
			}
		}
		return vType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VType basicGetVType() {
		return vType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVType(VType newVType) {
		VType oldVType = vType;
		vType = newVType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.VCLASS_OCCURRENCE__VTYPE, oldVType, vType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityInterval getInstanceMultiplicity() {
		return instanceMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInstanceMultiplicity(MultiplicityInterval newInstanceMultiplicity, NotificationChain msgs) {
		MultiplicityInterval oldInstanceMultiplicity = instanceMultiplicity;
		instanceMultiplicity = newInstanceMultiplicity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BvrPackage.VCLASS_OCCURRENCE__INSTANCE_MULTIPLICITY, oldInstanceMultiplicity, newInstanceMultiplicity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceMultiplicity(MultiplicityInterval newInstanceMultiplicity) {
		if (newInstanceMultiplicity != instanceMultiplicity) {
			NotificationChain msgs = null;
			if (instanceMultiplicity != null)
				msgs = ((InternalEObject)instanceMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BvrPackage.VCLASS_OCCURRENCE__INSTANCE_MULTIPLICITY, null, msgs);
			if (newInstanceMultiplicity != null)
				msgs = ((InternalEObject)newInstanceMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BvrPackage.VCLASS_OCCURRENCE__INSTANCE_MULTIPLICITY, null, msgs);
			msgs = basicSetInstanceMultiplicity(newInstanceMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.VCLASS_OCCURRENCE__INSTANCE_MULTIPLICITY, newInstanceMultiplicity, newInstanceMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.VCLASS_OCCURRENCE__GROUP_MULTIPLICITY:
				return basicSetGroupMultiplicity(null, msgs);
			case BvrPackage.VCLASS_OCCURRENCE__OWNED_CONSTRAINT:
				return ((InternalEList<?>)getOwnedConstraint()).basicRemove(otherEnd, msgs);
			case BvrPackage.VCLASS_OCCURRENCE__VARIABLE:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
			case BvrPackage.VCLASS_OCCURRENCE__INSTANCE_MULTIPLICITY:
				return basicSetInstanceMultiplicity(null, msgs);
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
			case BvrPackage.VCLASS_OCCURRENCE__GROUP_MULTIPLICITY:
				return getGroupMultiplicity();
			case BvrPackage.VCLASS_OCCURRENCE__OWNED_CONSTRAINT:
				return getOwnedConstraint();
			case BvrPackage.VCLASS_OCCURRENCE__VARIABLE:
				return getVariable();
			case BvrPackage.VCLASS_OCCURRENCE__VTYPE:
				if (resolve) return getVType();
				return basicGetVType();
			case BvrPackage.VCLASS_OCCURRENCE__INSTANCE_MULTIPLICITY:
				return getInstanceMultiplicity();
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
			case BvrPackage.VCLASS_OCCURRENCE__GROUP_MULTIPLICITY:
				setGroupMultiplicity((MultiplicityInterval)newValue);
				return;
			case BvrPackage.VCLASS_OCCURRENCE__OWNED_CONSTRAINT:
				getOwnedConstraint().clear();
				getOwnedConstraint().addAll((Collection<? extends Constraint>)newValue);
				return;
			case BvrPackage.VCLASS_OCCURRENCE__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection<? extends Variable>)newValue);
				return;
			case BvrPackage.VCLASS_OCCURRENCE__VTYPE:
				setVType((VType)newValue);
				return;
			case BvrPackage.VCLASS_OCCURRENCE__INSTANCE_MULTIPLICITY:
				setInstanceMultiplicity((MultiplicityInterval)newValue);
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
			case BvrPackage.VCLASS_OCCURRENCE__GROUP_MULTIPLICITY:
				setGroupMultiplicity((MultiplicityInterval)null);
				return;
			case BvrPackage.VCLASS_OCCURRENCE__OWNED_CONSTRAINT:
				getOwnedConstraint().clear();
				return;
			case BvrPackage.VCLASS_OCCURRENCE__VARIABLE:
				getVariable().clear();
				return;
			case BvrPackage.VCLASS_OCCURRENCE__VTYPE:
				setVType((VType)null);
				return;
			case BvrPackage.VCLASS_OCCURRENCE__INSTANCE_MULTIPLICITY:
				setInstanceMultiplicity((MultiplicityInterval)null);
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
			case BvrPackage.VCLASS_OCCURRENCE__GROUP_MULTIPLICITY:
				return groupMultiplicity != null;
			case BvrPackage.VCLASS_OCCURRENCE__OWNED_CONSTRAINT:
				return ownedConstraint != null && !ownedConstraint.isEmpty();
			case BvrPackage.VCLASS_OCCURRENCE__VARIABLE:
				return variable != null && !variable.isEmpty();
			case BvrPackage.VCLASS_OCCURRENCE__VTYPE:
				return vType != null;
			case BvrPackage.VCLASS_OCCURRENCE__INSTANCE_MULTIPLICITY:
				return instanceMultiplicity != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == VNode.class) {
			switch (derivedFeatureID) {
				case BvrPackage.VCLASS_OCCURRENCE__GROUP_MULTIPLICITY: return BvrPackage.VNODE__GROUP_MULTIPLICITY;
				case BvrPackage.VCLASS_OCCURRENCE__OWNED_CONSTRAINT: return BvrPackage.VNODE__OWNED_CONSTRAINT;
				case BvrPackage.VCLASS_OCCURRENCE__VARIABLE: return BvrPackage.VNODE__VARIABLE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == VNode.class) {
			switch (baseFeatureID) {
				case BvrPackage.VNODE__GROUP_MULTIPLICITY: return BvrPackage.VCLASS_OCCURRENCE__GROUP_MULTIPLICITY;
				case BvrPackage.VNODE__OWNED_CONSTRAINT: return BvrPackage.VCLASS_OCCURRENCE__OWNED_CONSTRAINT;
				case BvrPackage.VNODE__VARIABLE: return BvrPackage.VCLASS_OCCURRENCE__VARIABLE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //VClassOccurrenceImpl
