/**
 */
package cvl.impl;

import cvl.CvlPackage;
import cvl.ReplacementFragmentType;
import cvl.ReplacementFragment;
import cvl.ValueSpecification;
import cvl.Variable;
import cvl.Variabletype;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.VariableImpl#getReplacementFragmentTypesubsetstype <em>Replacement Fragment Typesubsetstype</em>}</li>
 *   <li>{@link cvl.impl.VariableImpl#getDefaulValue <em>Defaul Value</em>}</li>
 *   <li>{@link cvl.impl.VariableImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl extends VSpecImpl implements Variable {
	/**
	 * The cached value of the '{@link #getReplacementFragmentTypesubsetstype() <em>Replacement Fragment Typesubsetstype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplacementFragmentTypesubsetstype()
	 * @generated
	 * @ordered
	 */
	protected ReplacementFragmentType replacementFragmentTypesubsetstype;

	/**
	 * The cached value of the '{@link #getDefaulValue() <em>Defaul Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaulValue()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification defaulValue;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Variabletype type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentType getReplacementFragmentTypesubsetstype() {
		if (replacementFragmentTypesubsetstype != null && replacementFragmentTypesubsetstype.eIsProxy()) {
			InternalEObject oldReplacementFragmentTypesubsetstype = (InternalEObject)replacementFragmentTypesubsetstype;
			replacementFragmentTypesubsetstype = (ReplacementFragmentType)eResolveProxy(oldReplacementFragmentTypesubsetstype);
			if (replacementFragmentTypesubsetstype != oldReplacementFragmentTypesubsetstype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.VARIABLE__REPLACEMENT_FRAGMENT_TYPESUBSETSTYPE, oldReplacementFragmentTypesubsetstype, replacementFragmentTypesubsetstype));
			}
		}
		return replacementFragmentTypesubsetstype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacementFragmentType basicGetReplacementFragmentTypesubsetstype() {
		return replacementFragmentTypesubsetstype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplacementFragmentTypesubsetstype(ReplacementFragmentType newReplacementFragmentTypesubsetstype) {
		ReplacementFragmentType oldReplacementFragmentTypesubsetstype = replacementFragmentTypesubsetstype;
		replacementFragmentTypesubsetstype = newReplacementFragmentTypesubsetstype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.VARIABLE__REPLACEMENT_FRAGMENT_TYPESUBSETSTYPE, oldReplacementFragmentTypesubsetstype, replacementFragmentTypesubsetstype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification getDefaulValue() {
		return defaulValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaulValue(ValueSpecification newDefaulValue, NotificationChain msgs) {
		ValueSpecification oldDefaulValue = defaulValue;
		defaulValue = newDefaulValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CvlPackage.VARIABLE__DEFAUL_VALUE, oldDefaulValue, newDefaulValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaulValue(ValueSpecification newDefaulValue) {
		if (newDefaulValue != defaulValue) {
			NotificationChain msgs = null;
			if (defaulValue != null)
				msgs = ((InternalEObject)defaulValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CvlPackage.VARIABLE__DEFAUL_VALUE, null, msgs);
			if (newDefaulValue != null)
				msgs = ((InternalEObject)newDefaulValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CvlPackage.VARIABLE__DEFAUL_VALUE, null, msgs);
			msgs = basicSetDefaulValue(newDefaulValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.VARIABLE__DEFAUL_VALUE, newDefaulValue, newDefaulValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variabletype getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Variabletype)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.VARIABLE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variabletype basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Variabletype newType) {
		Variabletype oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.VARIABLE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.VARIABLE__DEFAUL_VALUE:
				return basicSetDefaulValue(null, msgs);
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
			case CvlPackage.VARIABLE__REPLACEMENT_FRAGMENT_TYPESUBSETSTYPE:
				if (resolve) return getReplacementFragmentTypesubsetstype();
				return basicGetReplacementFragmentTypesubsetstype();
			case CvlPackage.VARIABLE__DEFAUL_VALUE:
				return getDefaulValue();
			case CvlPackage.VARIABLE__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case CvlPackage.VARIABLE__REPLACEMENT_FRAGMENT_TYPESUBSETSTYPE:
				setReplacementFragmentTypesubsetstype((ReplacementFragmentType)newValue);
				return;
			case CvlPackage.VARIABLE__DEFAUL_VALUE:
				setDefaulValue((ValueSpecification)newValue);
				return;
			case CvlPackage.VARIABLE__TYPE:
				setType((Variabletype)newValue);
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
			case CvlPackage.VARIABLE__REPLACEMENT_FRAGMENT_TYPESUBSETSTYPE:
				setReplacementFragmentTypesubsetstype((ReplacementFragmentType)null);
				return;
			case CvlPackage.VARIABLE__DEFAUL_VALUE:
				setDefaulValue((ValueSpecification)null);
				return;
			case CvlPackage.VARIABLE__TYPE:
				setType((Variabletype)null);
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
			case CvlPackage.VARIABLE__REPLACEMENT_FRAGMENT_TYPESUBSETSTYPE:
				return replacementFragmentTypesubsetstype != null;
			case CvlPackage.VARIABLE__DEFAUL_VALUE:
				return defaulValue != null;
			case CvlPackage.VARIABLE__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableImpl
