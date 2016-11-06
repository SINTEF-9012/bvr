/**
 */
package dvlconfig.impl;

import dvlconfig.Config;
import dvlconfig.DvlconfigPackage;
import dvlconfig.Goal;
import dvlconfig.Operator;
import dvlconfig.Original;
import dvlconfig.Realop;
import dvlconfig.Resource;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dvlconfig.impl.ConfigImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link dvlconfig.impl.ConfigImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link dvlconfig.impl.ConfigImpl#getOriginal <em>Original</em>}</li>
 *   <li>{@link dvlconfig.impl.ConfigImpl#getGoals <em>Goals</em>}</li>
 *   <li>{@link dvlconfig.impl.ConfigImpl#getRealop <em>Realop</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigImpl extends MinimalEObjectImpl.Container implements Config {
	/**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<Operator> operators;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resources;

	/**
	 * The cached value of the '{@link #getOriginal() <em>Original</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginal()
	 * @generated
	 * @ordered
	 */
	protected Original original;

	/**
	 * The cached value of the '{@link #getGoals() <em>Goals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoals()
	 * @generated
	 * @ordered
	 */
	protected EList<Goal> goals;

	/**
	 * The cached value of the '{@link #getRealop() <em>Realop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealop()
	 * @generated
	 * @ordered
	 */
	protected Realop realop;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DvlconfigPackage.Literals.CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operator> getOperators() {
		if (operators == null) {
			operators = new EObjectContainmentEList<Operator>(Operator.class, this, DvlconfigPackage.CONFIG__OPERATORS);
		}
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<Resource>(Resource.class, this, DvlconfigPackage.CONFIG__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Original getOriginal() {
		return original;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOriginal(Original newOriginal, NotificationChain msgs) {
		Original oldOriginal = original;
		original = newOriginal;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DvlconfigPackage.CONFIG__ORIGINAL, oldOriginal, newOriginal);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginal(Original newOriginal) {
		if (newOriginal != original) {
			NotificationChain msgs = null;
			if (original != null)
				msgs = ((InternalEObject)original).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DvlconfigPackage.CONFIG__ORIGINAL, null, msgs);
			if (newOriginal != null)
				msgs = ((InternalEObject)newOriginal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DvlconfigPackage.CONFIG__ORIGINAL, null, msgs);
			msgs = basicSetOriginal(newOriginal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DvlconfigPackage.CONFIG__ORIGINAL, newOriginal, newOriginal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Goal> getGoals() {
		if (goals == null) {
			goals = new EObjectContainmentEList<Goal>(Goal.class, this, DvlconfigPackage.CONFIG__GOALS);
		}
		return goals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Realop getRealop() {
		return realop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRealop(Realop newRealop, NotificationChain msgs) {
		Realop oldRealop = realop;
		realop = newRealop;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DvlconfigPackage.CONFIG__REALOP, oldRealop, newRealop);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRealop(Realop newRealop) {
		if (newRealop != realop) {
			NotificationChain msgs = null;
			if (realop != null)
				msgs = ((InternalEObject)realop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DvlconfigPackage.CONFIG__REALOP, null, msgs);
			if (newRealop != null)
				msgs = ((InternalEObject)newRealop).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DvlconfigPackage.CONFIG__REALOP, null, msgs);
			msgs = basicSetRealop(newRealop, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DvlconfigPackage.CONFIG__REALOP, newRealop, newRealop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DvlconfigPackage.CONFIG__OPERATORS:
				return ((InternalEList<?>)getOperators()).basicRemove(otherEnd, msgs);
			case DvlconfigPackage.CONFIG__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
			case DvlconfigPackage.CONFIG__ORIGINAL:
				return basicSetOriginal(null, msgs);
			case DvlconfigPackage.CONFIG__GOALS:
				return ((InternalEList<?>)getGoals()).basicRemove(otherEnd, msgs);
			case DvlconfigPackage.CONFIG__REALOP:
				return basicSetRealop(null, msgs);
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
			case DvlconfigPackage.CONFIG__OPERATORS:
				return getOperators();
			case DvlconfigPackage.CONFIG__RESOURCES:
				return getResources();
			case DvlconfigPackage.CONFIG__ORIGINAL:
				return getOriginal();
			case DvlconfigPackage.CONFIG__GOALS:
				return getGoals();
			case DvlconfigPackage.CONFIG__REALOP:
				return getRealop();
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
			case DvlconfigPackage.CONFIG__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends Operator>)newValue);
				return;
			case DvlconfigPackage.CONFIG__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends Resource>)newValue);
				return;
			case DvlconfigPackage.CONFIG__ORIGINAL:
				setOriginal((Original)newValue);
				return;
			case DvlconfigPackage.CONFIG__GOALS:
				getGoals().clear();
				getGoals().addAll((Collection<? extends Goal>)newValue);
				return;
			case DvlconfigPackage.CONFIG__REALOP:
				setRealop((Realop)newValue);
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
			case DvlconfigPackage.CONFIG__OPERATORS:
				getOperators().clear();
				return;
			case DvlconfigPackage.CONFIG__RESOURCES:
				getResources().clear();
				return;
			case DvlconfigPackage.CONFIG__ORIGINAL:
				setOriginal((Original)null);
				return;
			case DvlconfigPackage.CONFIG__GOALS:
				getGoals().clear();
				return;
			case DvlconfigPackage.CONFIG__REALOP:
				setRealop((Realop)null);
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
			case DvlconfigPackage.CONFIG__OPERATORS:
				return operators != null && !operators.isEmpty();
			case DvlconfigPackage.CONFIG__RESOURCES:
				return resources != null && !resources.isEmpty();
			case DvlconfigPackage.CONFIG__ORIGINAL:
				return original != null;
			case DvlconfigPackage.CONFIG__GOALS:
				return goals != null && !goals.isEmpty();
			case DvlconfigPackage.CONFIG__REALOP:
				return realop != null;
		}
		return super.eIsSet(featureID);
	}

} //ConfigImpl
