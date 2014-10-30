/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.Choice;
import bvr.ChoiceOccurrence;
import bvr.ChoiceVariationPoint;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.ChoiceVariationPointImpl#getBindingChoice <em>Binding Choice</em>}</li>
 *   <li>{@link bvr.impl.ChoiceVariationPointImpl#getBindingChoiceOcc <em>Binding Choice Occ</em>}</li>
 *   <li>{@link bvr.impl.ChoiceVariationPointImpl#isResolution_kind <em>Resolution kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ChoiceVariationPointImpl extends VariationPointImpl implements ChoiceVariationPoint {
	/**
	 * The cached value of the '{@link #getBindingChoice() <em>Binding Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingChoice()
	 * @generated
	 * @ordered
	 */
	protected Choice bindingChoice;

	/**
	 * The cached value of the '{@link #getBindingChoiceOcc() <em>Binding Choice Occ</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingChoiceOcc()
	 * @generated
	 * @ordered
	 */
	protected ChoiceOccurrence bindingChoiceOcc;

	/**
	 * The default value of the '{@link #isResolution_kind() <em>Resolution kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolution_kind()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOLUTION_KIND_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isResolution_kind() <em>Resolution kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolution_kind()
	 * @generated
	 * @ordered
	 */
	protected boolean resolution_kind = RESOLUTION_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceVariationPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.CHOICE_VARIATION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice getBindingChoice() {
		if (bindingChoice != null && bindingChoice.eIsProxy()) {
			InternalEObject oldBindingChoice = (InternalEObject)bindingChoice;
			bindingChoice = (Choice)eResolveProxy(oldBindingChoice);
			if (bindingChoice != oldBindingChoice) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE, oldBindingChoice, bindingChoice));
			}
		}
		return bindingChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice basicGetBindingChoice() {
		return bindingChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingChoice(Choice newBindingChoice) {
		Choice oldBindingChoice = bindingChoice;
		bindingChoice = newBindingChoice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE, oldBindingChoice, bindingChoice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoiceOccurrence getBindingChoiceOcc() {
		if (bindingChoiceOcc != null && bindingChoiceOcc.eIsProxy()) {
			InternalEObject oldBindingChoiceOcc = (InternalEObject)bindingChoiceOcc;
			bindingChoiceOcc = (ChoiceOccurrence)eResolveProxy(oldBindingChoiceOcc);
			if (bindingChoiceOcc != oldBindingChoiceOcc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE_OCC, oldBindingChoiceOcc, bindingChoiceOcc));
			}
		}
		return bindingChoiceOcc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoiceOccurrence basicGetBindingChoiceOcc() {
		return bindingChoiceOcc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingChoiceOcc(ChoiceOccurrence newBindingChoiceOcc) {
		ChoiceOccurrence oldBindingChoiceOcc = bindingChoiceOcc;
		bindingChoiceOcc = newBindingChoiceOcc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE_OCC, oldBindingChoiceOcc, bindingChoiceOcc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResolution_kind() {
		return resolution_kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolution_kind(boolean newResolution_kind) {
		boolean oldResolution_kind = resolution_kind;
		resolution_kind = newResolution_kind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.CHOICE_VARIATION_POINT__RESOLUTION_KIND, oldResolution_kind, resolution_kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE:
				if (resolve) return getBindingChoice();
				return basicGetBindingChoice();
			case BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE_OCC:
				if (resolve) return getBindingChoiceOcc();
				return basicGetBindingChoiceOcc();
			case BvrPackage.CHOICE_VARIATION_POINT__RESOLUTION_KIND:
				return isResolution_kind();
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
			case BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE:
				setBindingChoice((Choice)newValue);
				return;
			case BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE_OCC:
				setBindingChoiceOcc((ChoiceOccurrence)newValue);
				return;
			case BvrPackage.CHOICE_VARIATION_POINT__RESOLUTION_KIND:
				setResolution_kind((Boolean)newValue);
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
			case BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE:
				setBindingChoice((Choice)null);
				return;
			case BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE_OCC:
				setBindingChoiceOcc((ChoiceOccurrence)null);
				return;
			case BvrPackage.CHOICE_VARIATION_POINT__RESOLUTION_KIND:
				setResolution_kind(RESOLUTION_KIND_EDEFAULT);
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
			case BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE:
				return bindingChoice != null;
			case BvrPackage.CHOICE_VARIATION_POINT__BINDING_CHOICE_OCC:
				return bindingChoiceOcc != null;
			case BvrPackage.CHOICE_VARIATION_POINT__RESOLUTION_KIND:
				return resolution_kind != RESOLUTION_KIND_EDEFAULT;
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
		result.append(" (resolution_kind: ");
		result.append(resolution_kind);
		result.append(')');
		return result.toString();
	}

} //ChoiceVariationPointImpl
