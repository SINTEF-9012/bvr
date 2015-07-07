/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.Choice;
import bvr.ChoiceVSpec;
import bvr.NamedElement;
import bvr.Note;
import bvr.Target;
import bvr.VSpec;
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
 *   <li>{@link bvr.impl.ChoiceImpl#getName <em>Name</em>}</li>
 *   <li>{@link bvr.impl.ChoiceImpl#getNote <em>Note</em>}</li>
 *   <li>{@link bvr.impl.ChoiceImpl#getResolutionTime <em>Resolution Time</em>}</li>
 *   <li>{@link bvr.impl.ChoiceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link bvr.impl.ChoiceImpl#isDefaultResolution <em>Default Resolution</em>}</li>
 *   <li>{@link bvr.impl.ChoiceImpl#isIsImpliedByParent <em>Is Implied By Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChoiceImpl extends CompoundNodeImpl implements Choice {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNote() <em>Note</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected EList<Note> note;

	/**
	 * The default value of the '{@link #getResolutionTime() <em>Resolution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolutionTime()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOLUTION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResolutionTime() <em>Resolution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolutionTime()
	 * @generated
	 * @ordered
	 */
	protected String resolutionTime = RESOLUTION_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Target target;

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
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Note> getNote() {
		if (note == null) {
			note = new EObjectContainmentEList<Note>(Note.class, this, BvrPackage.CHOICE__NOTE);
		}
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResolutionTime() {
		return resolutionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolutionTime(String newResolutionTime) {
		String oldResolutionTime = resolutionTime;
		resolutionTime = newResolutionTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE__RESOLUTION_TIME, oldResolutionTime, resolutionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Target getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Target)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.CHOICE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Target basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Target newTarget) {
		Target oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE__TARGET, oldTarget, target));
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
			case BvrPackage.CHOICE__NOTE:
				return ((InternalEList<?>)getNote()).basicRemove(otherEnd, msgs);
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
			case BvrPackage.CHOICE__NAME:
				return getName();
			case BvrPackage.CHOICE__NOTE:
				return getNote();
			case BvrPackage.CHOICE__RESOLUTION_TIME:
				return getResolutionTime();
			case BvrPackage.CHOICE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case BvrPackage.CHOICE__NAME:
				setName((String)newValue);
				return;
			case BvrPackage.CHOICE__NOTE:
				getNote().clear();
				getNote().addAll((Collection<? extends Note>)newValue);
				return;
			case BvrPackage.CHOICE__RESOLUTION_TIME:
				setResolutionTime((String)newValue);
				return;
			case BvrPackage.CHOICE__TARGET:
				setTarget((Target)newValue);
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
			case BvrPackage.CHOICE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BvrPackage.CHOICE__NOTE:
				getNote().clear();
				return;
			case BvrPackage.CHOICE__RESOLUTION_TIME:
				setResolutionTime(RESOLUTION_TIME_EDEFAULT);
				return;
			case BvrPackage.CHOICE__TARGET:
				setTarget((Target)null);
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
			case BvrPackage.CHOICE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BvrPackage.CHOICE__NOTE:
				return note != null && !note.isEmpty();
			case BvrPackage.CHOICE__RESOLUTION_TIME:
				return RESOLUTION_TIME_EDEFAULT == null ? resolutionTime != null : !RESOLUTION_TIME_EDEFAULT.equals(resolutionTime);
			case BvrPackage.CHOICE__TARGET:
				return target != null;
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
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case BvrPackage.CHOICE__NAME: return BvrPackage.NAMED_ELEMENT__NAME;
				case BvrPackage.CHOICE__NOTE: return BvrPackage.NAMED_ELEMENT__NOTE;
				default: return -1;
			}
		}
		if (baseClass == VSpec.class) {
			switch (derivedFeatureID) {
				case BvrPackage.CHOICE__RESOLUTION_TIME: return BvrPackage.VSPEC__RESOLUTION_TIME;
				case BvrPackage.CHOICE__TARGET: return BvrPackage.VSPEC__TARGET;
				default: return -1;
			}
		}
		if (baseClass == ChoiceVSpec.class) {
			switch (derivedFeatureID) {
				case BvrPackage.CHOICE__DEFAULT_RESOLUTION: return BvrPackage.CHOICE_VSPEC__DEFAULT_RESOLUTION;
				case BvrPackage.CHOICE__IS_IMPLIED_BY_PARENT: return BvrPackage.CHOICE_VSPEC__IS_IMPLIED_BY_PARENT;
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
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case BvrPackage.NAMED_ELEMENT__NAME: return BvrPackage.CHOICE__NAME;
				case BvrPackage.NAMED_ELEMENT__NOTE: return BvrPackage.CHOICE__NOTE;
				default: return -1;
			}
		}
		if (baseClass == VSpec.class) {
			switch (baseFeatureID) {
				case BvrPackage.VSPEC__RESOLUTION_TIME: return BvrPackage.CHOICE__RESOLUTION_TIME;
				case BvrPackage.VSPEC__TARGET: return BvrPackage.CHOICE__TARGET;
				default: return -1;
			}
		}
		if (baseClass == ChoiceVSpec.class) {
			switch (baseFeatureID) {
				case BvrPackage.CHOICE_VSPEC__DEFAULT_RESOLUTION: return BvrPackage.CHOICE__DEFAULT_RESOLUTION;
				case BvrPackage.CHOICE_VSPEC__IS_IMPLIED_BY_PARENT: return BvrPackage.CHOICE__IS_IMPLIED_BY_PARENT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", resolutionTime: ");
		result.append(resolutionTime);
		result.append(", defaultResolution: ");
		result.append(defaultResolution);
		result.append(", isImpliedByParent: ");
		result.append(isImpliedByParent);
		result.append(')');
		return result.toString();
	}

} //ChoiceImpl
