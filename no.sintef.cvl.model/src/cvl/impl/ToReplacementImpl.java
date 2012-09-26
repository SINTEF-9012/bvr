/**
 */
package cvl.impl;

import cvl.ObjectHandle;
import cvl.ToPlacement;
import cvl.ToReplacement;
import cvl.cvlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>To Replacement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.ToReplacementImpl#getInsideBoundaryElement <em>Inside Boundary Element</em>}</li>
 *   <li>{@link cvl.impl.ToReplacementImpl#getToPlacement <em>To Placement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToReplacementImpl extends ReplacementBoundaryElementImpl implements ToReplacement {
	/**
	 * The cached value of the '{@link #getInsideBoundaryElement() <em>Inside Boundary Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsideBoundaryElement()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectHandle> insideBoundaryElement;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToReplacementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return cvlPackage.Literals.TO_REPLACEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectHandle> getInsideBoundaryElement() {
		if (insideBoundaryElement == null) {
			insideBoundaryElement = new EObjectResolvingEList<ObjectHandle>(ObjectHandle.class, this, cvlPackage.TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT);
		}
		return insideBoundaryElement;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, cvlPackage.TO_REPLACEMENT__TO_PLACEMENT, oldToPlacement, toPlacement));
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
	public NotificationChain basicSetToPlacement(ToPlacement newToPlacement, NotificationChain msgs) {
		ToPlacement oldToPlacement = toPlacement;
		toPlacement = newToPlacement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, cvlPackage.TO_REPLACEMENT__TO_PLACEMENT, oldToPlacement, newToPlacement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToPlacement(ToPlacement newToPlacement) {
		if (newToPlacement != toPlacement) {
			NotificationChain msgs = null;
			if (toPlacement != null)
				msgs = ((InternalEObject)toPlacement).eInverseRemove(this, cvlPackage.TO_PLACEMENT__TO_REPLACEMENT, ToPlacement.class, msgs);
			if (newToPlacement != null)
				msgs = ((InternalEObject)newToPlacement).eInverseAdd(this, cvlPackage.TO_PLACEMENT__TO_REPLACEMENT, ToPlacement.class, msgs);
			msgs = basicSetToPlacement(newToPlacement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.TO_REPLACEMENT__TO_PLACEMENT, newToPlacement, newToPlacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case cvlPackage.TO_REPLACEMENT__TO_PLACEMENT:
				if (toPlacement != null)
					msgs = ((InternalEObject)toPlacement).eInverseRemove(this, cvlPackage.TO_PLACEMENT__TO_REPLACEMENT, ToPlacement.class, msgs);
				return basicSetToPlacement((ToPlacement)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case cvlPackage.TO_REPLACEMENT__TO_PLACEMENT:
				return basicSetToPlacement(null, msgs);
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
			case cvlPackage.TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				return getInsideBoundaryElement();
			case cvlPackage.TO_REPLACEMENT__TO_PLACEMENT:
				if (resolve) return getToPlacement();
				return basicGetToPlacement();
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
			case cvlPackage.TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				getInsideBoundaryElement().clear();
				getInsideBoundaryElement().addAll((Collection<? extends ObjectHandle>)newValue);
				return;
			case cvlPackage.TO_REPLACEMENT__TO_PLACEMENT:
				setToPlacement((ToPlacement)newValue);
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
			case cvlPackage.TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				getInsideBoundaryElement().clear();
				return;
			case cvlPackage.TO_REPLACEMENT__TO_PLACEMENT:
				setToPlacement((ToPlacement)null);
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
			case cvlPackage.TO_REPLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				return insideBoundaryElement != null && !insideBoundaryElement.isEmpty();
			case cvlPackage.TO_REPLACEMENT__TO_PLACEMENT:
				return toPlacement != null;
		}
		return super.eIsSet(featureID);
	}

} //ToReplacementImpl
