/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.Choice;
import bvr.ChoiceOccurrence;
import bvr.ChoiceResolution;
import bvr.VClassOccurrence;
import bvr.VClassifier;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice Resolution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.ChoiceResolutionImpl#getResolvedChoice <em>Resolved Choice</em>}</li>
 *   <li>{@link bvr.impl.ChoiceResolutionImpl#getResolvedChoiceOcc <em>Resolved Choice Occ</em>}</li>
 *   <li>{@link bvr.impl.ChoiceResolutionImpl#getResolvedVClassOcc <em>Resolved VClass Occ</em>}</li>
 *   <li>{@link bvr.impl.ChoiceResolutionImpl#getResolvedVClassifier <em>Resolved VClassifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ChoiceResolutionImpl extends VSpecResolutionImpl implements ChoiceResolution {
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
	 * The cached value of the '{@link #getResolvedChoiceOcc() <em>Resolved Choice Occ</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedChoiceOcc()
	 * @generated
	 * @ordered
	 */
	protected ChoiceOccurrence resolvedChoiceOcc;

	/**
	 * The cached value of the '{@link #getResolvedVClassOcc() <em>Resolved VClass Occ</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedVClassOcc()
	 * @generated
	 * @ordered
	 */
	protected VClassOccurrence resolvedVClassOcc;

	/**
	 * The cached value of the '{@link #getResolvedVClassifier() <em>Resolved VClassifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedVClassifier()
	 * @generated
	 * @ordered
	 */
	protected VClassifier resolvedVClassifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceResolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.CHOICE_RESOLUTION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.CHOICE_RESOLUTION__RESOLVED_CHOICE, oldResolvedChoice, resolvedChoice));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE_RESOLUTION__RESOLVED_CHOICE, oldResolvedChoice, resolvedChoice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoiceOccurrence getResolvedChoiceOcc() {
		if (resolvedChoiceOcc != null && resolvedChoiceOcc.eIsProxy()) {
			InternalEObject oldResolvedChoiceOcc = (InternalEObject)resolvedChoiceOcc;
			resolvedChoiceOcc = (ChoiceOccurrence)eResolveProxy(oldResolvedChoiceOcc);
			if (resolvedChoiceOcc != oldResolvedChoiceOcc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.CHOICE_RESOLUTION__RESOLVED_CHOICE_OCC, oldResolvedChoiceOcc, resolvedChoiceOcc));
			}
		}
		return resolvedChoiceOcc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoiceOccurrence basicGetResolvedChoiceOcc() {
		return resolvedChoiceOcc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolvedChoiceOcc(ChoiceOccurrence newResolvedChoiceOcc) {
		ChoiceOccurrence oldResolvedChoiceOcc = resolvedChoiceOcc;
		resolvedChoiceOcc = newResolvedChoiceOcc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE_RESOLUTION__RESOLVED_CHOICE_OCC, oldResolvedChoiceOcc, resolvedChoiceOcc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VClassOccurrence getResolvedVClassOcc() {
		if (resolvedVClassOcc != null && resolvedVClassOcc.eIsProxy()) {
			InternalEObject oldResolvedVClassOcc = (InternalEObject)resolvedVClassOcc;
			resolvedVClassOcc = (VClassOccurrence)eResolveProxy(oldResolvedVClassOcc);
			if (resolvedVClassOcc != oldResolvedVClassOcc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.CHOICE_RESOLUTION__RESOLVED_VCLASS_OCC, oldResolvedVClassOcc, resolvedVClassOcc));
			}
		}
		return resolvedVClassOcc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VClassOccurrence basicGetResolvedVClassOcc() {
		return resolvedVClassOcc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolvedVClassOcc(VClassOccurrence newResolvedVClassOcc) {
		VClassOccurrence oldResolvedVClassOcc = resolvedVClassOcc;
		resolvedVClassOcc = newResolvedVClassOcc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE_RESOLUTION__RESOLVED_VCLASS_OCC, oldResolvedVClassOcc, resolvedVClassOcc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VClassifier getResolvedVClassifier() {
		if (resolvedVClassifier != null && resolvedVClassifier.eIsProxy()) {
			InternalEObject oldResolvedVClassifier = (InternalEObject)resolvedVClassifier;
			resolvedVClassifier = (VClassifier)eResolveProxy(oldResolvedVClassifier);
			if (resolvedVClassifier != oldResolvedVClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.CHOICE_RESOLUTION__RESOLVED_VCLASSIFIER, oldResolvedVClassifier, resolvedVClassifier));
			}
		}
		return resolvedVClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VClassifier basicGetResolvedVClassifier() {
		return resolvedVClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolvedVClassifier(VClassifier newResolvedVClassifier) {
		VClassifier oldResolvedVClassifier = resolvedVClassifier;
		resolvedVClassifier = newResolvedVClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE_RESOLUTION__RESOLVED_VCLASSIFIER, oldResolvedVClassifier, resolvedVClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_CHOICE:
				if (resolve) return getResolvedChoice();
				return basicGetResolvedChoice();
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_CHOICE_OCC:
				if (resolve) return getResolvedChoiceOcc();
				return basicGetResolvedChoiceOcc();
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_VCLASS_OCC:
				if (resolve) return getResolvedVClassOcc();
				return basicGetResolvedVClassOcc();
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_VCLASSIFIER:
				if (resolve) return getResolvedVClassifier();
				return basicGetResolvedVClassifier();
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
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_CHOICE:
				setResolvedChoice((Choice)newValue);
				return;
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_CHOICE_OCC:
				setResolvedChoiceOcc((ChoiceOccurrence)newValue);
				return;
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_VCLASS_OCC:
				setResolvedVClassOcc((VClassOccurrence)newValue);
				return;
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_VCLASSIFIER:
				setResolvedVClassifier((VClassifier)newValue);
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
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_CHOICE:
				setResolvedChoice((Choice)null);
				return;
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_CHOICE_OCC:
				setResolvedChoiceOcc((ChoiceOccurrence)null);
				return;
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_VCLASS_OCC:
				setResolvedVClassOcc((VClassOccurrence)null);
				return;
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_VCLASSIFIER:
				setResolvedVClassifier((VClassifier)null);
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
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_CHOICE:
				return resolvedChoice != null;
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_CHOICE_OCC:
				return resolvedChoiceOcc != null;
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_VCLASS_OCC:
				return resolvedVClassOcc != null;
			case BvrPackage.CHOICE_RESOLUTION__RESOLVED_VCLASSIFIER:
				return resolvedVClassifier != null;
		}
		return super.eIsSet(featureID);
	}

} //ChoiceResolutionImpl
