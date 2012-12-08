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
 * An implementation of the model object '<em><b>To Placement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.ToPlacementImpl#getToReplacement <em>To Replacement</em>}</li>
 *   <li>{@link cvl.impl.ToPlacementImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link cvl.impl.ToPlacementImpl#getInsideBoundaryElement <em>Inside Boundary Element</em>}</li>
 *   <li>{@link cvl.impl.ToPlacementImpl#getOutsideBoundaryElement <em>Outside Boundary Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToPlacementImpl extends PlacementBoundaryElementImpl implements ToPlacement {
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
	 * The default value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected String propertyName = PROPERTY_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getOutsideBoundaryElement() <em>Outside Boundary Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutsideBoundaryElement()
	 * @generated
	 * @ordered
	 */
	protected ObjectHandle outsideBoundaryElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToPlacementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return cvlPackage.Literals.TO_PLACEMENT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, cvlPackage.TO_PLACEMENT__TO_REPLACEMENT, oldToReplacement, toReplacement));
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
	public NotificationChain basicSetToReplacement(ToReplacement newToReplacement, NotificationChain msgs) {
		ToReplacement oldToReplacement = toReplacement;
		toReplacement = newToReplacement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, cvlPackage.TO_PLACEMENT__TO_REPLACEMENT, oldToReplacement, newToReplacement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToReplacement(ToReplacement newToReplacement) {
		if (newToReplacement != toReplacement) {
			NotificationChain msgs = null;
			if (toReplacement != null)
				msgs = ((InternalEObject)toReplacement).eInverseRemove(this, cvlPackage.TO_REPLACEMENT__TO_PLACEMENT, ToReplacement.class, msgs);
			if (newToReplacement != null)
				msgs = ((InternalEObject)newToReplacement).eInverseAdd(this, cvlPackage.TO_REPLACEMENT__TO_PLACEMENT, ToReplacement.class, msgs);
			msgs = basicSetToReplacement(newToReplacement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.TO_PLACEMENT__TO_REPLACEMENT, newToReplacement, newToReplacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyName(String newPropertyName) {
		String oldPropertyName = propertyName;
		propertyName = newPropertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.TO_PLACEMENT__PROPERTY_NAME, oldPropertyName, propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectHandle> getInsideBoundaryElement() {
		if (insideBoundaryElement == null) {
			insideBoundaryElement = new EObjectResolvingEList<ObjectHandle>(ObjectHandle.class, this, cvlPackage.TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT);
		}
		return insideBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectHandle getOutsideBoundaryElement() {
		if (outsideBoundaryElement != null && outsideBoundaryElement.eIsProxy()) {
			InternalEObject oldOutsideBoundaryElement = (InternalEObject)outsideBoundaryElement;
			outsideBoundaryElement = (ObjectHandle)eResolveProxy(oldOutsideBoundaryElement);
			if (outsideBoundaryElement != oldOutsideBoundaryElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, cvlPackage.TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT, oldOutsideBoundaryElement, outsideBoundaryElement));
			}
		}
		return outsideBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectHandle basicGetOutsideBoundaryElement() {
		return outsideBoundaryElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutsideBoundaryElement(ObjectHandle newOutsideBoundaryElement) {
		ObjectHandle oldOutsideBoundaryElement = outsideBoundaryElement;
		outsideBoundaryElement = newOutsideBoundaryElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT, oldOutsideBoundaryElement, outsideBoundaryElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case cvlPackage.TO_PLACEMENT__TO_REPLACEMENT:
				if (toReplacement != null)
					msgs = ((InternalEObject)toReplacement).eInverseRemove(this, cvlPackage.TO_REPLACEMENT__TO_PLACEMENT, ToReplacement.class, msgs);
				return basicSetToReplacement((ToReplacement)otherEnd, msgs);
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
			case cvlPackage.TO_PLACEMENT__TO_REPLACEMENT:
				return basicSetToReplacement(null, msgs);
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
			case cvlPackage.TO_PLACEMENT__TO_REPLACEMENT:
				if (resolve) return getToReplacement();
				return basicGetToReplacement();
			case cvlPackage.TO_PLACEMENT__PROPERTY_NAME:
				return getPropertyName();
			case cvlPackage.TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				return getInsideBoundaryElement();
			case cvlPackage.TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				if (resolve) return getOutsideBoundaryElement();
				return basicGetOutsideBoundaryElement();
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
			case cvlPackage.TO_PLACEMENT__TO_REPLACEMENT:
				setToReplacement((ToReplacement)newValue);
				return;
			case cvlPackage.TO_PLACEMENT__PROPERTY_NAME:
				setPropertyName((String)newValue);
				return;
			case cvlPackage.TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				getInsideBoundaryElement().clear();
				getInsideBoundaryElement().addAll((Collection<? extends ObjectHandle>)newValue);
				return;
			case cvlPackage.TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				setOutsideBoundaryElement((ObjectHandle)newValue);
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
			case cvlPackage.TO_PLACEMENT__TO_REPLACEMENT:
				setToReplacement((ToReplacement)null);
				return;
			case cvlPackage.TO_PLACEMENT__PROPERTY_NAME:
				setPropertyName(PROPERTY_NAME_EDEFAULT);
				return;
			case cvlPackage.TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				getInsideBoundaryElement().clear();
				return;
			case cvlPackage.TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				setOutsideBoundaryElement((ObjectHandle)null);
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
			case cvlPackage.TO_PLACEMENT__TO_REPLACEMENT:
				return toReplacement != null;
			case cvlPackage.TO_PLACEMENT__PROPERTY_NAME:
				return PROPERTY_NAME_EDEFAULT == null ? propertyName != null : !PROPERTY_NAME_EDEFAULT.equals(propertyName);
			case cvlPackage.TO_PLACEMENT__INSIDE_BOUNDARY_ELEMENT:
				return insideBoundaryElement != null && !insideBoundaryElement.isEmpty();
			case cvlPackage.TO_PLACEMENT__OUTSIDE_BOUNDARY_ELEMENT:
				return outsideBoundaryElement != null;
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
		result.append(" (propertyName: ");
		result.append(propertyName);
		result.append(')');
		return result.toString();
	}

} //ToPlacementImpl
