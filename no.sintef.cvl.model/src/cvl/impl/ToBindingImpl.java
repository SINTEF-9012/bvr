/**
 */
package cvl.impl;

import cvl.ToBinding;
import cvl.ToPlacement;
import cvl.ToReplacement;
import cvl.cvlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>To Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.ToBindingImpl#getToPlacement <em>To Placement</em>}</li>
 *   <li>{@link cvl.impl.ToBindingImpl#getToReplacement <em>To Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToBindingImpl extends BoundaryElementBindingImpl implements ToBinding {
	/**
	 * The cached value of the '{@link #getToPlacement() <em>To Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToPlacement()
	 * @generated
	 * @ordered
	 */
	protected ToPlacement toPlacement;

	/**
	 * The cached value of the '{@link #getToReplacement() <em>To Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToReplacement()
	 * @generated
	 * @ordered
	 */
	protected ToReplacement toReplacement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return cvlPackage.Literals.TO_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToPlacement getToPlacement() {
		if (toPlacement != null && toPlacement.eIsProxy()) {
			InternalEObject oldToPlacement = (InternalEObject)toPlacement;
			toPlacement = (ToPlacement)eResolveProxy(oldToPlacement);
			if (toPlacement != oldToPlacement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, cvlPackage.TO_BINDING__TO_PLACEMENT, oldToPlacement, toPlacement));
			}
		}
		return toPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToPlacement basicGetToPlacement() {
		return toPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToPlacement(ToPlacement newToPlacement) {
		ToPlacement oldToPlacement = toPlacement;
		toPlacement = newToPlacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.TO_BINDING__TO_PLACEMENT, oldToPlacement, toPlacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToReplacement getToReplacement() {
		if (toReplacement != null && toReplacement.eIsProxy()) {
			InternalEObject oldToReplacement = (InternalEObject)toReplacement;
			toReplacement = (ToReplacement)eResolveProxy(oldToReplacement);
			if (toReplacement != oldToReplacement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, cvlPackage.TO_BINDING__TO_REPLACEMENT, oldToReplacement, toReplacement));
			}
		}
		return toReplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToReplacement basicGetToReplacement() {
		return toReplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToReplacement(ToReplacement newToReplacement) {
		ToReplacement oldToReplacement = toReplacement;
		toReplacement = newToReplacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.TO_BINDING__TO_REPLACEMENT, oldToReplacement, toReplacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case cvlPackage.TO_BINDING__TO_PLACEMENT:
				if (resolve) return getToPlacement();
				return basicGetToPlacement();
			case cvlPackage.TO_BINDING__TO_REPLACEMENT:
				if (resolve) return getToReplacement();
				return basicGetToReplacement();
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
			case cvlPackage.TO_BINDING__TO_PLACEMENT:
				setToPlacement((ToPlacement)newValue);
				return;
			case cvlPackage.TO_BINDING__TO_REPLACEMENT:
				setToReplacement((ToReplacement)newValue);
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
			case cvlPackage.TO_BINDING__TO_PLACEMENT:
				setToPlacement((ToPlacement)null);
				return;
			case cvlPackage.TO_BINDING__TO_REPLACEMENT:
				setToReplacement((ToReplacement)null);
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
			case cvlPackage.TO_BINDING__TO_PLACEMENT:
				return toPlacement != null;
			case cvlPackage.TO_BINDING__TO_REPLACEMENT:
				return toReplacement != null;
		}
		return super.eIsSet(featureID);
	}

} //ToBindingImpl
