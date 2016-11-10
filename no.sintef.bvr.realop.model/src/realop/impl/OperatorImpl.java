/**
 */
package realop.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import realop.Expression;
import realop.Operator;
import realop.RealopPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link realop.impl.OperatorImpl#getName <em>Name</em>}</li>
 *   <li>{@link realop.impl.OperatorImpl#getExpPre <em>Exp Pre</em>}</li>
 *   <li>{@link realop.impl.OperatorImpl#getExpPost <em>Exp Post</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorImpl extends MinimalEObjectImpl.Container implements Operator {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpPre() <em>Exp Pre</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpPre()
	 * @generated
	 * @ordered
	 */
	protected Expression expPre;

	/**
	 * The cached value of the '{@link #getExpPost() <em>Exp Post</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpPost()
	 * @generated
	 * @ordered
	 */
	protected Expression expPost;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RealopPackage.Literals.OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RealopPackage.OPERATOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpPre() {
		return expPre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpPre(Expression newExpPre, NotificationChain msgs) {
		Expression oldExpPre = expPre;
		expPre = newExpPre;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RealopPackage.OPERATOR__EXP_PRE, oldExpPre, newExpPre);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpPre(Expression newExpPre) {
		if (newExpPre != expPre) {
			NotificationChain msgs = null;
			if (expPre != null)
				msgs = ((InternalEObject)expPre).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RealopPackage.OPERATOR__EXP_PRE, null, msgs);
			if (newExpPre != null)
				msgs = ((InternalEObject)newExpPre).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RealopPackage.OPERATOR__EXP_PRE, null, msgs);
			msgs = basicSetExpPre(newExpPre, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RealopPackage.OPERATOR__EXP_PRE, newExpPre, newExpPre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpPost() {
		return expPost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpPost(Expression newExpPost, NotificationChain msgs) {
		Expression oldExpPost = expPost;
		expPost = newExpPost;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RealopPackage.OPERATOR__EXP_POST, oldExpPost, newExpPost);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpPost(Expression newExpPost) {
		if (newExpPost != expPost) {
			NotificationChain msgs = null;
			if (expPost != null)
				msgs = ((InternalEObject)expPost).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RealopPackage.OPERATOR__EXP_POST, null, msgs);
			if (newExpPost != null)
				msgs = ((InternalEObject)newExpPost).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RealopPackage.OPERATOR__EXP_POST, null, msgs);
			msgs = basicSetExpPost(newExpPost, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RealopPackage.OPERATOR__EXP_POST, newExpPost, newExpPost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RealopPackage.OPERATOR__EXP_PRE:
				return basicSetExpPre(null, msgs);
			case RealopPackage.OPERATOR__EXP_POST:
				return basicSetExpPost(null, msgs);
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
			case RealopPackage.OPERATOR__NAME:
				return getName();
			case RealopPackage.OPERATOR__EXP_PRE:
				return getExpPre();
			case RealopPackage.OPERATOR__EXP_POST:
				return getExpPost();
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
			case RealopPackage.OPERATOR__NAME:
				setName((String)newValue);
				return;
			case RealopPackage.OPERATOR__EXP_PRE:
				setExpPre((Expression)newValue);
				return;
			case RealopPackage.OPERATOR__EXP_POST:
				setExpPost((Expression)newValue);
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
			case RealopPackage.OPERATOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RealopPackage.OPERATOR__EXP_PRE:
				setExpPre((Expression)null);
				return;
			case RealopPackage.OPERATOR__EXP_POST:
				setExpPost((Expression)null);
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
			case RealopPackage.OPERATOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RealopPackage.OPERATOR__EXP_PRE:
				return expPre != null;
			case RealopPackage.OPERATOR__EXP_POST:
				return expPost != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //OperatorImpl
