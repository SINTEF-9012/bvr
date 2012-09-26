/**
 */
package CVLMetamodelMaster.Main.impl;

import CVLMetamodelMaster.Main.MainPackage;
import CVLMetamodelMaster.Main.MultiplicityInterval;
import CVLMetamodelMaster.Main.VSpec;
import CVLMetamodelMaster.Main.VSpecDerivation;

import java.util.Collection;

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
 * An implementation of the model object '<em><b>VSpec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.impl.VSpecImpl#getGroupMultiplicity <em>Group Multiplicity</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.impl.VSpecImpl#getResolutionTime <em>Resolution Time</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.impl.VSpecImpl#getOwnedVSpecDerivation <em>Owned VSpec Derivation</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.impl.VSpecImpl#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VSpecImpl extends VPackageableImpl implements VSpec {
	/**
	 * The cached value of the '{@link #getGroupMultiplicity() <em>Group Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityInterval groupMultiplicity;

	/**
	 * The default value of the '{@link #getResolutionTime() <em>Resolution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolutionTime()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOLUTION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResolutionTime() <em>Resolution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolutionTime()
	 * @generated
	 * @ordered
	 */
	protected String resolutionTime = RESOLUTION_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedVSpecDerivation() <em>Owned VSpec Derivation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVSpecDerivation()
	 * @generated
	 * @ordered
	 */
	protected EList<VSpecDerivation> ownedVSpecDerivation;

	/**
	 * The cached value of the '{@link #getChild() <em>Child</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChild()
	 * @generated
	 * @ordered
	 */
	protected EList<VSpec> child;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VSpecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MainPackage.Literals.VSPEC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityInterval getGroupMultiplicity() {
		return groupMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroupMultiplicity(MultiplicityInterval newGroupMultiplicity, NotificationChain msgs) {
		MultiplicityInterval oldGroupMultiplicity = groupMultiplicity;
		groupMultiplicity = newGroupMultiplicity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MainPackage.VSPEC__GROUP_MULTIPLICITY, oldGroupMultiplicity, newGroupMultiplicity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupMultiplicity(MultiplicityInterval newGroupMultiplicity) {
		if (newGroupMultiplicity != groupMultiplicity) {
			NotificationChain msgs = null;
			if (groupMultiplicity != null)
				msgs = ((InternalEObject)groupMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MainPackage.VSPEC__GROUP_MULTIPLICITY, null, msgs);
			if (newGroupMultiplicity != null)
				msgs = ((InternalEObject)newGroupMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MainPackage.VSPEC__GROUP_MULTIPLICITY, null, msgs);
			msgs = basicSetGroupMultiplicity(newGroupMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.VSPEC__GROUP_MULTIPLICITY, newGroupMultiplicity, newGroupMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResolutionTime() {
		return resolutionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolutionTime(String newResolutionTime) {
		String oldResolutionTime = resolutionTime;
		resolutionTime = newResolutionTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MainPackage.VSPEC__RESOLUTION_TIME, oldResolutionTime, resolutionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VSpecDerivation> getOwnedVSpecDerivation() {
		if (ownedVSpecDerivation == null) {
			ownedVSpecDerivation = new EObjectContainmentEList<VSpecDerivation>(VSpecDerivation.class, this, MainPackage.VSPEC__OWNED_VSPEC_DERIVATION);
		}
		return ownedVSpecDerivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VSpec> getChild() {
		if (child == null) {
			child = new EObjectContainmentEList<VSpec>(VSpec.class, this, MainPackage.VSPEC__CHILD);
		}
		return child;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MainPackage.VSPEC__GROUP_MULTIPLICITY:
				return basicSetGroupMultiplicity(null, msgs);
			case MainPackage.VSPEC__OWNED_VSPEC_DERIVATION:
				return ((InternalEList<?>)getOwnedVSpecDerivation()).basicRemove(otherEnd, msgs);
			case MainPackage.VSPEC__CHILD:
				return ((InternalEList<?>)getChild()).basicRemove(otherEnd, msgs);
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
			case MainPackage.VSPEC__GROUP_MULTIPLICITY:
				return getGroupMultiplicity();
			case MainPackage.VSPEC__RESOLUTION_TIME:
				return getResolutionTime();
			case MainPackage.VSPEC__OWNED_VSPEC_DERIVATION:
				return getOwnedVSpecDerivation();
			case MainPackage.VSPEC__CHILD:
				return getChild();
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
			case MainPackage.VSPEC__GROUP_MULTIPLICITY:
				setGroupMultiplicity((MultiplicityInterval)newValue);
				return;
			case MainPackage.VSPEC__RESOLUTION_TIME:
				setResolutionTime((String)newValue);
				return;
			case MainPackage.VSPEC__OWNED_VSPEC_DERIVATION:
				getOwnedVSpecDerivation().clear();
				getOwnedVSpecDerivation().addAll((Collection<? extends VSpecDerivation>)newValue);
				return;
			case MainPackage.VSPEC__CHILD:
				getChild().clear();
				getChild().addAll((Collection<? extends VSpec>)newValue);
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
			case MainPackage.VSPEC__GROUP_MULTIPLICITY:
				setGroupMultiplicity((MultiplicityInterval)null);
				return;
			case MainPackage.VSPEC__RESOLUTION_TIME:
				setResolutionTime(RESOLUTION_TIME_EDEFAULT);
				return;
			case MainPackage.VSPEC__OWNED_VSPEC_DERIVATION:
				getOwnedVSpecDerivation().clear();
				return;
			case MainPackage.VSPEC__CHILD:
				getChild().clear();
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
			case MainPackage.VSPEC__GROUP_MULTIPLICITY:
				return groupMultiplicity != null;
			case MainPackage.VSPEC__RESOLUTION_TIME:
				return RESOLUTION_TIME_EDEFAULT == null ? resolutionTime != null : !RESOLUTION_TIME_EDEFAULT.equals(resolutionTime);
			case MainPackage.VSPEC__OWNED_VSPEC_DERIVATION:
				return ownedVSpecDerivation != null && !ownedVSpecDerivation.isEmpty();
			case MainPackage.VSPEC__CHILD:
				return child != null && !child.isEmpty();
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
		result.append(" (resolutionTime: ");
		result.append(resolutionTime);
		result.append(')');
		return result.toString();
	}

} //VSpecImpl
