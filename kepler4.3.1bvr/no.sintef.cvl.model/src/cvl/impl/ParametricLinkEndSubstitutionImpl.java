/**
 */
package cvl.impl;

import cvl.CvlPackage;
import cvl.LinkHandle;
import cvl.ParametricLinkEndSubstitution;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parametric Link End Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.ParametricLinkEndSubstitutionImpl#getLinkEndIdentifier <em>Link End Identifier</em>}</li>
 *   <li>{@link cvl.impl.ParametricLinkEndSubstitutionImpl#getLink <em>Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParametricLinkEndSubstitutionImpl extends ParametricVariationPointImpl implements ParametricLinkEndSubstitution {
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
	 * The cached value of the '{@link #getLink() <em>Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected LinkHandle link;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParametricLinkEndSubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.PARAMETRIC_LINK_END_SUBSTITUTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER, oldLinkEndIdentifier, linkEndIdentifier));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK, oldLink, newLink);
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
				msgs = ((InternalEObject)link).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK, null, msgs);
			if (newLink != null)
				msgs = ((InternalEObject)newLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK, null, msgs);
			msgs = basicSetLink(newLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK, newLink, newLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK:
				return basicSetLink(null, msgs);
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
			case CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER:
				return getLinkEndIdentifier();
			case CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK:
				return getLink();
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
			case CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER:
				setLinkEndIdentifier((String)newValue);
				return;
			case CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK:
				setLink((LinkHandle)newValue);
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
			case CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER:
				setLinkEndIdentifier(LINK_END_IDENTIFIER_EDEFAULT);
				return;
			case CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK:
				setLink((LinkHandle)null);
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
			case CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK_END_IDENTIFIER:
				return LINK_END_IDENTIFIER_EDEFAULT == null ? linkEndIdentifier != null : !LINK_END_IDENTIFIER_EDEFAULT.equals(linkEndIdentifier);
			case CvlPackage.PARAMETRIC_LINK_END_SUBSTITUTION__LINK:
				return link != null;
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

} //ParametricLinkEndSubstitutionImpl
