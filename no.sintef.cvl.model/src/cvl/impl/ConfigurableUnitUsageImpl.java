/**
 */
package cvl.impl;

import cvl.ConfigurableUnit;
import cvl.ConfigurableUnitUsage;
import cvl.CvlPackage;
import cvl.LinkHandle;
import cvl.VInterface;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configurable Unit Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.ConfigurableUnitUsageImpl#getUsedUnit <em>Used Unit</em>}</li>
 *   <li>{@link cvl.impl.ConfigurableUnitUsageImpl#getUsageReference <em>Usage Reference</em>}</li>
 *   <li>{@link cvl.impl.ConfigurableUnitUsageImpl#getLinkEndIdentifier <em>Link End Identifier</em>}</li>
 *   <li>{@link cvl.impl.ConfigurableUnitUsageImpl#getUnitUsageInterface <em>Unit Usage Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurableUnitUsageImpl extends CompositeVariationPointImpl implements ConfigurableUnitUsage {
	/**
	 * The cached value of the '{@link #getUsedUnit() <em>Used Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedUnit()
	 * @generated
	 * @ordered
	 */
	protected ConfigurableUnit usedUnit;

	/**
	 * The cached value of the '{@link #getUsageReference() <em>Usage Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageReference()
	 * @generated
	 * @ordered
	 */
	protected LinkHandle usageReference;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurableUnitUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.CONFIGURABLE_UNIT_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurableUnit getUsedUnit() {
		if (usedUnit != null && usedUnit.eIsProxy()) {
			InternalEObject oldUsedUnit = (InternalEObject)usedUnit;
			usedUnit = (ConfigurableUnit)eResolveProxy(oldUsedUnit);
			if (usedUnit != oldUsedUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.CONFIGURABLE_UNIT_USAGE__USED_UNIT, oldUsedUnit, usedUnit));
			}
		}
		return usedUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurableUnit basicGetUsedUnit() {
		return usedUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedUnit(ConfigurableUnit newUsedUnit) {
		ConfigurableUnit oldUsedUnit = usedUnit;
		usedUnit = newUsedUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.CONFIGURABLE_UNIT_USAGE__USED_UNIT, oldUsedUnit, usedUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkHandle getUsageReference() {
		return usageReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUsageReference(LinkHandle newUsageReference, NotificationChain msgs) {
		LinkHandle oldUsageReference = usageReference;
		usageReference = newUsageReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CvlPackage.CONFIGURABLE_UNIT_USAGE__USAGE_REFERENCE, oldUsageReference, newUsageReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageReference(LinkHandle newUsageReference) {
		if (newUsageReference != usageReference) {
			NotificationChain msgs = null;
			if (usageReference != null)
				msgs = ((InternalEObject)usageReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CvlPackage.CONFIGURABLE_UNIT_USAGE__USAGE_REFERENCE, null, msgs);
			if (newUsageReference != null)
				msgs = ((InternalEObject)newUsageReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CvlPackage.CONFIGURABLE_UNIT_USAGE__USAGE_REFERENCE, null, msgs);
			msgs = basicSetUsageReference(newUsageReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.CONFIGURABLE_UNIT_USAGE__USAGE_REFERENCE, newUsageReference, newUsageReference));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.CONFIGURABLE_UNIT_USAGE__LINK_END_IDENTIFIER, oldLinkEndIdentifier, linkEndIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VInterface getUnitUsageInterface() {
		VInterface unitUsageInterface = basicGetUnitUsageInterface();
		return unitUsageInterface != null && unitUsageInterface.eIsProxy() ? (VInterface)eResolveProxy((InternalEObject)unitUsageInterface) : unitUsageInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VInterface basicGetUnitUsageInterface() {
		// TODO: implement this method to return the 'Unit Usage Interface' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitUsageInterface(VInterface newUnitUsageInterface) {
		// TODO: implement this method to set the 'Unit Usage Interface' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__USAGE_REFERENCE:
				return basicSetUsageReference(null, msgs);
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
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__USED_UNIT:
				if (resolve) return getUsedUnit();
				return basicGetUsedUnit();
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__USAGE_REFERENCE:
				return getUsageReference();
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__LINK_END_IDENTIFIER:
				return getLinkEndIdentifier();
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__UNIT_USAGE_INTERFACE:
				if (resolve) return getUnitUsageInterface();
				return basicGetUnitUsageInterface();
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
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__USED_UNIT:
				setUsedUnit((ConfigurableUnit)newValue);
				return;
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__USAGE_REFERENCE:
				setUsageReference((LinkHandle)newValue);
				return;
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__LINK_END_IDENTIFIER:
				setLinkEndIdentifier((String)newValue);
				return;
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__UNIT_USAGE_INTERFACE:
				setUnitUsageInterface((VInterface)newValue);
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
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__USED_UNIT:
				setUsedUnit((ConfigurableUnit)null);
				return;
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__USAGE_REFERENCE:
				setUsageReference((LinkHandle)null);
				return;
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__LINK_END_IDENTIFIER:
				setLinkEndIdentifier(LINK_END_IDENTIFIER_EDEFAULT);
				return;
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__UNIT_USAGE_INTERFACE:
				setUnitUsageInterface((VInterface)null);
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
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__USED_UNIT:
				return usedUnit != null;
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__USAGE_REFERENCE:
				return usageReference != null;
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__LINK_END_IDENTIFIER:
				return LINK_END_IDENTIFIER_EDEFAULT == null ? linkEndIdentifier != null : !LINK_END_IDENTIFIER_EDEFAULT.equals(linkEndIdentifier);
			case CvlPackage.CONFIGURABLE_UNIT_USAGE__UNIT_USAGE_INTERFACE:
				return basicGetUnitUsageInterface() != null;
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

} //ConfigurableUnitUsageImpl
