/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.Choice;

import bvr.CompoundNode;
import bvr.Constraint;
import bvr.MultiplicityInterval;
import bvr.Target;
import bvr.VNode;
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
 * An implementation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.ChoiceImpl#getGroupMultiplicity <em>Group Multiplicity</em>}</li>
 *   <li>{@link bvr.impl.ChoiceImpl#getOwnedConstraint <em>Owned Constraint</em>}</li>
 *   <li>{@link bvr.impl.ChoiceImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link bvr.impl.ChoiceImpl#getMember <em>Member</em>}</li>
 *   <li>{@link bvr.impl.ChoiceImpl#getOwnedTargets <em>Owned Targets</em>}</li>
 *   <li>{@link bvr.impl.ChoiceImpl#isDefaultResolution <em>Default Resolution</em>}</li>
 *   <li>{@link bvr.impl.ChoiceImpl#isIsImpliedByParent <em>Is Implied By Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChoiceImpl extends VSpecImpl implements Choice {
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
	 * The cached value of the '{@link #getMember() <em>Member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected EList<VNode> member;

	/**
	 * The cached value of the '{@link #getOwnedTargets() <em>Owned Targets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<Target> ownedTargets;

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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE__GROUP_MULTIPLICITY, oldGroupMultiplicity, newGroupMultiplicity);
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
				msgs = ((InternalEObject)groupMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BvrPackage.CHOICE__GROUP_MULTIPLICITY, null, msgs);
			if (newGroupMultiplicity != null)
				msgs = ((InternalEObject)newGroupMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BvrPackage.CHOICE__GROUP_MULTIPLICITY, null, msgs);
			msgs = basicSetGroupMultiplicity(newGroupMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE__GROUP_MULTIPLICITY, newGroupMultiplicity, newGroupMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getOwnedConstraint() {
		if (ownedConstraint == null) {
			ownedConstraint = new EObjectContainmentEList<Constraint>(Constraint.class, this, BvrPackage.CHOICE__OWNED_CONSTRAINT);
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
			variable = new EObjectContainmentEList<Variable>(Variable.class, this, BvrPackage.CHOICE__VARIABLE);
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VNode> getMember() {
		if (member == null) {
			member = new EObjectContainmentEList<VNode>(VNode.class, this, BvrPackage.CHOICE__MEMBER);
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Target> getOwnedTargets() {
		if (ownedTargets == null) {
			ownedTargets = new EObjectContainmentEList<Target>(Target.class, this, BvrPackage.CHOICE__OWNED_TARGETS);
		}
		return ownedTargets;
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.CHOICE__GROUP_MULTIPLICITY:
				return basicSetGroupMultiplicity(null, msgs);
			case BvrPackage.CHOICE__OWNED_CONSTRAINT:
				return ((InternalEList<?>)getOwnedConstraint()).basicRemove(otherEnd, msgs);
			case BvrPackage.CHOICE__VARIABLE:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
			case BvrPackage.CHOICE__MEMBER:
				return ((InternalEList<?>)getMember()).basicRemove(otherEnd, msgs);
			case BvrPackage.CHOICE__OWNED_TARGETS:
				return ((InternalEList<?>)getOwnedTargets()).basicRemove(otherEnd, msgs);
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
			case BvrPackage.CHOICE__GROUP_MULTIPLICITY:
				return getGroupMultiplicity();
			case BvrPackage.CHOICE__OWNED_CONSTRAINT:
				return getOwnedConstraint();
			case BvrPackage.CHOICE__VARIABLE:
				return getVariable();
			case BvrPackage.CHOICE__MEMBER:
				return getMember();
			case BvrPackage.CHOICE__OWNED_TARGETS:
				return getOwnedTargets();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BvrPackage.CHOICE__GROUP_MULTIPLICITY:
				setGroupMultiplicity((MultiplicityInterval)newValue);
				return;
			case BvrPackage.CHOICE__OWNED_CONSTRAINT:
				getOwnedConstraint().clear();
				getOwnedConstraint().addAll((Collection<? extends Constraint>)newValue);
				return;
			case BvrPackage.CHOICE__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection<? extends Variable>)newValue);
				return;
			case BvrPackage.CHOICE__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends VNode>)newValue);
				return;
			case BvrPackage.CHOICE__OWNED_TARGETS:
				getOwnedTargets().clear();
				getOwnedTargets().addAll((Collection<? extends Target>)newValue);
				return;
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
			case BvrPackage.CHOICE__GROUP_MULTIPLICITY:
				setGroupMultiplicity((MultiplicityInterval)null);
				return;
			case BvrPackage.CHOICE__OWNED_CONSTRAINT:
				getOwnedConstraint().clear();
				return;
			case BvrPackage.CHOICE__VARIABLE:
				getVariable().clear();
				return;
			case BvrPackage.CHOICE__MEMBER:
				getMember().clear();
				return;
			case BvrPackage.CHOICE__OWNED_TARGETS:
				getOwnedTargets().clear();
				return;
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
			case BvrPackage.CHOICE__GROUP_MULTIPLICITY:
				return groupMultiplicity != null;
			case BvrPackage.CHOICE__OWNED_CONSTRAINT:
				return ownedConstraint != null && !ownedConstraint.isEmpty();
			case BvrPackage.CHOICE__VARIABLE:
				return variable != null && !variable.isEmpty();
			case BvrPackage.CHOICE__MEMBER:
				return member != null && !member.isEmpty();
			case BvrPackage.CHOICE__OWNED_TARGETS:
				return ownedTargets != null && !ownedTargets.isEmpty();
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == VNode.class) {
			switch (derivedFeatureID) {
				case BvrPackage.CHOICE__GROUP_MULTIPLICITY: return BvrPackage.VNODE__GROUP_MULTIPLICITY;
				case BvrPackage.CHOICE__OWNED_CONSTRAINT: return BvrPackage.VNODE__OWNED_CONSTRAINT;
				case BvrPackage.CHOICE__VARIABLE: return BvrPackage.VNODE__VARIABLE;
				default: return -1;
			}
		}
		if (baseClass == CompoundNode.class) {
			switch (derivedFeatureID) {
				case BvrPackage.CHOICE__MEMBER: return BvrPackage.COMPOUND_NODE__MEMBER;
				case BvrPackage.CHOICE__OWNED_TARGETS: return BvrPackage.COMPOUND_NODE__OWNED_TARGETS;
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
				case BvrPackage.VNODE__GROUP_MULTIPLICITY: return BvrPackage.CHOICE__GROUP_MULTIPLICITY;
				case BvrPackage.VNODE__OWNED_CONSTRAINT: return BvrPackage.CHOICE__OWNED_CONSTRAINT;
				case BvrPackage.VNODE__VARIABLE: return BvrPackage.CHOICE__VARIABLE;
				default: return -1;
			}
		}
		if (baseClass == CompoundNode.class) {
			switch (baseFeatureID) {
				case BvrPackage.COMPOUND_NODE__MEMBER: return BvrPackage.CHOICE__MEMBER;
				case BvrPackage.COMPOUND_NODE__OWNED_TARGETS: return BvrPackage.CHOICE__OWNED_TARGETS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
