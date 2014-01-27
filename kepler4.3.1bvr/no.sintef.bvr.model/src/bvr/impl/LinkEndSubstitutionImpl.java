/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.LinkEndSubstitution;
import bvr.LinkHandle;
import bvr.ObjectHandle;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link End Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.LinkEndSubstitutionImpl#getLink <em>Link</em>}</li>
 *   <li>{@link bvr.impl.LinkEndSubstitutionImpl#getLinkEndIdentifier <em>Link End Identifier</em>}</li>
 *   <li>{@link bvr.impl.LinkEndSubstitutionImpl#getReplacementObject <em>Replacement Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkEndSubstitutionImpl extends ChoiceVariationPointImpl implements LinkEndSubstitution {
	/**
	 * The cached value of the '{@link #getLink() <em>Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected LinkHandle link;

	/**
	 * The default value of the '{@link #getLinkEndIdentifier() <em>Link End Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkEndIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_END_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkEndIdentifier() <em>Link End Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkEndIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String linkEndIdentifier = LINK_END_IDENTIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReplacementObject() <em>Replacement Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplacementObject()
	 * @generated
	 * @ordered
	 */
	protected ObjectHandle replacementObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkEndSubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.LINK_END_SUBSTITUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkHandle getLink() {
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLink(LinkHandle newLink, NotificationChain msgs) {
		LinkHandle oldLink = link;
		link = newLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BvrPackage.LINK_END_SUBSTITUTION__LINK, oldLink, newLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink(LinkHandle newLink) {
		if (newLink != link) {
			NotificationChain msgs = null;
			if (link != null)
				msgs = ((InternalEObject)link).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BvrPackage.LINK_END_SUBSTITUTION__LINK, null, msgs);
			if (newLink != null)
				msgs = ((InternalEObject)newLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BvrPackage.LINK_END_SUBSTITUTION__LINK, null, msgs);
			msgs = basicSetLink(newLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.LINK_END_SUBSTITUTION__LINK, newLink, newLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkEndIdentifier() {
		return linkEndIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkEndIdentifier(String newLinkEndIdentifier) {
		String oldLinkEndIdentifier = linkEndIdentifier;
		linkEndIdentifier = newLinkEndIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER, oldLinkEndIdentifier, linkEndIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectHandle getReplacementObject() {
		return replacementObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReplacementObject(ObjectHandle newReplacementObject, NotificationChain msgs) {
		ObjectHandle oldReplacementObject = replacementObject;
		replacementObject = newReplacementObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BvrPackage.LINK_END_SUBSTITUTION__REPLACEMENT_OBJECT, oldReplacementObject, newReplacementObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplacementObject(ObjectHandle newReplacementObject) {
		if (newReplacementObject != replacementObject) {
			NotificationChain msgs = null;
			if (replacementObject != null)
				msgs = ((InternalEObject)replacementObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BvrPackage.LINK_END_SUBSTITUTION__REPLACEMENT_OBJECT, null, msgs);
			if (newReplacementObject != null)
				msgs = ((InternalEObject)newReplacementObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BvrPackage.LINK_END_SUBSTITUTION__REPLACEMENT_OBJECT, null, msgs);
			msgs = basicSetReplacementObject(newReplacementObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.LINK_END_SUBSTITUTION__REPLACEMENT_OBJECT, newReplacementObject, newReplacementObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.LINK_END_SUBSTITUTION__LINK:
				return basicSetLink(null, msgs);
			case BvrPackage.LINK_END_SUBSTITUTION__REPLACEMENT_OBJECT:
				return basicSetReplacementObject(null, msgs);
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
			case BvrPackage.LINK_END_SUBSTITUTION__LINK:
				return getLink();
			case BvrPackage.LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER:
				return getLinkEndIdentifier();
			case BvrPackage.LINK_END_SUBSTITUTION__REPLACEMENT_OBJECT:
				return getReplacementObject();
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
			case BvrPackage.LINK_END_SUBSTITUTION__LINK:
				setLink((LinkHandle)newValue);
				return;
			case BvrPackage.LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER:
				setLinkEndIdentifier((String)newValue);
				return;
			case BvrPackage.LINK_END_SUBSTITUTION__REPLACEMENT_OBJECT:
				setReplacementObject((ObjectHandle)newValue);
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
			case BvrPackage.LINK_END_SUBSTITUTION__LINK:
				setLink((LinkHandle)null);
				return;
			case BvrPackage.LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER:
				setLinkEndIdentifier(LINK_END_IDENTIFIER_EDEFAULT);
				return;
			case BvrPackage.LINK_END_SUBSTITUTION__REPLACEMENT_OBJECT:
				setReplacementObject((ObjectHandle)null);
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
			case BvrPackage.LINK_END_SUBSTITUTION__LINK:
				return link != null;
			case BvrPackage.LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER:
				return LINK_END_IDENTIFIER_EDEFAULT == null ? linkEndIdentifier != null : !LINK_END_IDENTIFIER_EDEFAULT.equals(linkEndIdentifier);
			case BvrPackage.LINK_END_SUBSTITUTION__REPLACEMENT_OBJECT:
				return replacementObject != null;
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
		result.append(" (linkEndIdentifier: ");
		result.append(linkEndIdentifier);
		result.append(')');
		return result.toString();
	}

} //LinkEndSubstitutionImpl
