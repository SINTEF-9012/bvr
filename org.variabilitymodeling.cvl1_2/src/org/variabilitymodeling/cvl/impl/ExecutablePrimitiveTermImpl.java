/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.impl;



import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.variabilitymodeling.cvl.CvlPackage;
import org.variabilitymodeling.cvl.ExecutablePrimitive;
import org.variabilitymodeling.cvl.ExecutablePrimitiveTerm;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Executable Primitive Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.ExecutablePrimitiveTermImpl#getPrimitive <em>Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutablePrimitiveTermImpl extends ConstraintImpl implements ExecutablePrimitiveTerm {
	/**
	 * The cached value of the '{@link #getPrimitive() <em>Primitive</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive()
	 * @generated
	 * @ordered
	 */
	protected ExecutablePrimitive primitive;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutablePrimitiveTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.EXECUTABLE_PRIMITIVE_TERM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutablePrimitive getPrimitive() {
		if (primitive != null && primitive.eIsProxy()) {
			InternalEObject oldPrimitive = (InternalEObject)primitive;
			primitive = (ExecutablePrimitive)eResolveProxy(oldPrimitive);
			if (primitive != oldPrimitive) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.EXECUTABLE_PRIMITIVE_TERM__PRIMITIVE, oldPrimitive, primitive));
			}
		}
		return primitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutablePrimitive basicGetPrimitive() {
		return primitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitive(ExecutablePrimitive newPrimitive) {
		ExecutablePrimitive oldPrimitive = primitive;
		primitive = newPrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.EXECUTABLE_PRIMITIVE_TERM__PRIMITIVE, oldPrimitive, primitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitExecutablePrimitiveTerm(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CvlPackage.EXECUTABLE_PRIMITIVE_TERM__PRIMITIVE:
				if (resolve) return getPrimitive();
				return basicGetPrimitive();
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
			case CvlPackage.EXECUTABLE_PRIMITIVE_TERM__PRIMITIVE:
				setPrimitive((ExecutablePrimitive)newValue);
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
			case CvlPackage.EXECUTABLE_PRIMITIVE_TERM__PRIMITIVE:
				setPrimitive((ExecutablePrimitive)null);
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
			case CvlPackage.EXECUTABLE_PRIMITIVE_TERM__PRIMITIVE:
				return primitive != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecutablePrimitiveTermImpl
