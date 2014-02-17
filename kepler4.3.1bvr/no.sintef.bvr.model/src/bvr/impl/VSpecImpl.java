/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.MultiplicityInterval;
import bvr.VSpec;
import bvr.VSpecDerivation;

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
 *   <li>{@link bvr.impl.VSpecImpl#getGroupMultiplicity <em>Group Multiplicity</em>}</li>
 *   <li>{@link bvr.impl.VSpecImpl#getResolutionTime <em>Resolution Time</em>}</li>
 *   <li>{@link bvr.impl.VSpecImpl#getOwnedVSpecDerivation <em>Owned VSpec Derivation</em>}</li>
 *   <li>{@link bvr.impl.VSpecImpl#getChild <em>Child</em>}</li>
 *   <li>{@link bvr.impl.VSpecImpl#getComment <em>Comment</em>}</li>
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
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

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
		return BvrPackage.Literals.VSPEC;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BvrPackage.VSPEC__GROUP_MULTIPLICITY, oldGroupMultiplicity, newGroupMultiplicity);
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
				msgs = ((InternalEObject)groupMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BvrPackage.VSPEC__GROUP_MULTIPLICITY, null, msgs);
			if (newGroupMultiplicity != null)
				msgs = ((InternalEObject)newGroupMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BvrPackage.VSPEC__GROUP_MULTIPLICITY, null, msgs);
			msgs = basicSetGroupMultiplicity(newGroupMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.VSPEC__GROUP_MULTIPLICITY, newGroupMultiplicity, newGroupMultiplicity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.VSPEC__RESOLUTION_TIME, oldResolutionTime, resolutionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VSpecDerivation> getOwnedVSpecDerivation() {
		if (ownedVSpecDerivation == null) {
			ownedVSpecDerivation = new EObjectContainmentEList<VSpecDerivation>(VSpecDerivation.class, this, BvrPackage.VSPEC__OWNED_VSPEC_DERIVATION);
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
			child = new EObjectContainmentEList<VSpec>(VSpec.class, this, BvrPackage.VSPEC__CHILD);
		}
		return child;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.VSPEC__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BvrPackage.VSPEC__GROUP_MULTIPLICITY:
				return basicSetGroupMultiplicity(null, msgs);
			case BvrPackage.VSPEC__OWNED_VSPEC_DERIVATION:
				return ((InternalEList<?>)getOwnedVSpecDerivation()).basicRemove(otherEnd, msgs);
			case BvrPackage.VSPEC__CHILD:
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
			case BvrPackage.VSPEC__GROUP_MULTIPLICITY:
				return getGroupMultiplicity();
			case BvrPackage.VSPEC__RESOLUTION_TIME:
				return getResolutionTime();
			case BvrPackage.VSPEC__OWNED_VSPEC_DERIVATION:
				return getOwnedVSpecDerivation();
			case BvrPackage.VSPEC__CHILD:
				return getChild();
			case BvrPackage.VSPEC__COMMENT:
				return getComment();
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
			case BvrPackage.VSPEC__GROUP_MULTIPLICITY:
				setGroupMultiplicity((MultiplicityInterval)newValue);
				return;
			case BvrPackage.VSPEC__RESOLUTION_TIME:
				setResolutionTime((String)newValue);
				return;
			case BvrPackage.VSPEC__OWNED_VSPEC_DERIVATION:
				getOwnedVSpecDerivation().clear();
				getOwnedVSpecDerivation().addAll((Collection<? extends VSpecDerivation>)newValue);
				return;
			case BvrPackage.VSPEC__CHILD:
				getChild().clear();
				getChild().addAll((Collection<? extends VSpec>)newValue);
				return;
			case BvrPackage.VSPEC__COMMENT:
				setComment((String)newValue);
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
			case BvrPackage.VSPEC__GROUP_MULTIPLICITY:
				setGroupMultiplicity((MultiplicityInterval)null);
				return;
			case BvrPackage.VSPEC__RESOLUTION_TIME:
				setResolutionTime(RESOLUTION_TIME_EDEFAULT);
				return;
			case BvrPackage.VSPEC__OWNED_VSPEC_DERIVATION:
				getOwnedVSpecDerivation().clear();
				return;
			case BvrPackage.VSPEC__CHILD:
				getChild().clear();
				return;
			case BvrPackage.VSPEC__COMMENT:
				setComment(COMMENT_EDEFAULT);
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
			case BvrPackage.VSPEC__GROUP_MULTIPLICITY:
				return groupMultiplicity != null;
			case BvrPackage.VSPEC__RESOLUTION_TIME:
				return RESOLUTION_TIME_EDEFAULT == null ? resolutionTime != null : !RESOLUTION_TIME_EDEFAULT.equals(resolutionTime);
			case BvrPackage.VSPEC__OWNED_VSPEC_DERIVATION:
				return ownedVSpecDerivation != null && !ownedVSpecDerivation.isEmpty();
			case BvrPackage.VSPEC__CHILD:
				return child != null && !child.isEmpty();
			case BvrPackage.VSPEC__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
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
		result.append(", comment: ");
		result.append(comment);
		result.append(')');
		return result.toString();
	}

} //VSpecImpl
