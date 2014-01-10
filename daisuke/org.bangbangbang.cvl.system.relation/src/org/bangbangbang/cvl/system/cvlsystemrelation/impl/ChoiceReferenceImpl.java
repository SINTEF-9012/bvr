/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation.impl;

import java.util.Collection;

import org.bangbangbang.cvl.Choice;

import org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceReference;
import org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage;
import org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference;

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
 * An implementation of the model object '<em><b>Choice Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceReferenceImpl#getClassifiers <em>Classifiers</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.impl.ChoiceReferenceImpl#getChoice <em>Choice</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChoiceReferenceImpl extends AbstractChoiceReferenceImpl implements ChoiceReference {
	/**
	 * The cached value of the '{@link #getClassifiers() <em>Classifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<VClassifierReference> classifiers;

	/**
	 * The cached value of the '{@link #getChoice() <em>Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoice()
	 * @generated
	 * @ordered
	 */
	protected Choice choice;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationPackage.Literals.CHOICE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VClassifierReference> getClassifiers() {
		if (classifiers == null) {
			classifiers = new EObjectContainmentEList<VClassifierReference>(VClassifierReference.class, this, RelationPackage.CHOICE_REFERENCE__CLASSIFIERS);
		}
		return classifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice getChoice() {
		if (choice != null && choice.eIsProxy()) {
			InternalEObject oldChoice = (InternalEObject)choice;
			choice = (Choice)eResolveProxy(oldChoice);
			if (choice != oldChoice) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationPackage.CHOICE_REFERENCE__CHOICE, oldChoice, choice));
			}
		}
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice basicGetChoice() {
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChoice(Choice newChoice) {
		Choice oldChoice = choice;
		choice = newChoice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationPackage.CHOICE_REFERENCE__CHOICE, oldChoice, choice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationPackage.CHOICE_REFERENCE__CLASSIFIERS:
				return ((InternalEList<?>)getClassifiers()).basicRemove(otherEnd, msgs);
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
			case RelationPackage.CHOICE_REFERENCE__CLASSIFIERS:
				return getClassifiers();
			case RelationPackage.CHOICE_REFERENCE__CHOICE:
				if (resolve) return getChoice();
				return basicGetChoice();
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
			case RelationPackage.CHOICE_REFERENCE__CLASSIFIERS:
				getClassifiers().clear();
				getClassifiers().addAll((Collection<? extends VClassifierReference>)newValue);
				return;
			case RelationPackage.CHOICE_REFERENCE__CHOICE:
				setChoice((Choice)newValue);
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
			case RelationPackage.CHOICE_REFERENCE__CLASSIFIERS:
				getClassifiers().clear();
				return;
			case RelationPackage.CHOICE_REFERENCE__CHOICE:
				setChoice((Choice)null);
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
			case RelationPackage.CHOICE_REFERENCE__CLASSIFIERS:
				return classifiers != null && !classifiers.isEmpty();
			case RelationPackage.CHOICE_REFERENCE__CHOICE:
				return choice != null;
		}
		return super.eIsSet(featureID);
	}

} //ChoiceReferenceImpl
