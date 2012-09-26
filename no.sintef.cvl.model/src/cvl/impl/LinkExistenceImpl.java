/**
 */
package cvl.impl;

import cvl.LinkExistence;
import cvl.LinkHandle;
import cvl.cvlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Existence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.LinkExistenceImpl#getOptionalLink <em>Optional Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkExistenceImpl extends ChoiceVariationPointImpl implements LinkExistence {
	/**
	 * The cached value of the '{@link #getOptionalLink() <em>Optional Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalLink()
	 * @generated
	 * @ordered
	 */
	protected LinkHandle optionalLink;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkExistenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return cvlPackage.Literals.LINK_EXISTENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkHandle getOptionalLink() {
		return optionalLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOptionalLink(LinkHandle newOptionalLink, NotificationChain msgs) {
		LinkHandle oldOptionalLink = optionalLink;
		optionalLink = newOptionalLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, cvlPackage.LINK_EXISTENCE__OPTIONAL_LINK, oldOptionalLink, newOptionalLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionalLink(LinkHandle newOptionalLink) {
		if (newOptionalLink != optionalLink) {
			NotificationChain msgs = null;
			if (optionalLink != null)
				msgs = ((InternalEObject)optionalLink).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - cvlPackage.LINK_EXISTENCE__OPTIONAL_LINK, null, msgs);
			if (newOptionalLink != null)
				msgs = ((InternalEObject)newOptionalLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - cvlPackage.LINK_EXISTENCE__OPTIONAL_LINK, null, msgs);
			msgs = basicSetOptionalLink(newOptionalLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, cvlPackage.LINK_EXISTENCE__OPTIONAL_LINK, newOptionalLink, newOptionalLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case cvlPackage.LINK_EXISTENCE__OPTIONAL_LINK:
				return basicSetOptionalLink(null, msgs);
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
			case cvlPackage.LINK_EXISTENCE__OPTIONAL_LINK:
				return getOptionalLink();
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
			case cvlPackage.LINK_EXISTENCE__OPTIONAL_LINK:
				setOptionalLink((LinkHandle)newValue);
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
			case cvlPackage.LINK_EXISTENCE__OPTIONAL_LINK:
				setOptionalLink((LinkHandle)null);
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
			case cvlPackage.LINK_EXISTENCE__OPTIONAL_LINK:
				return optionalLink != null;
		}
		return super.eIsSet(featureID);
	}

} //LinkExistenceImpl
