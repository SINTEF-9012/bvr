/**
 */
package ari.impl;

import ari.ExpressionModel;
import ari.ExpressionNode;
import ari.Variable;
import ari.ariPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ari.impl.ExpressionModelImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link ari.impl.ExpressionModelImpl#getExpressionNode <em>Expression Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionModelImpl extends EObjectImpl implements ExpressionModel {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variable;

	/**
	 * The cached value of the '{@link #getExpressionNode() <em>Expression Node</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionNode()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpressionNode> expressionNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ariPackage.Literals.EXPRESSION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariable() {
		if (variable == null) {
			variable = new EObjectContainmentEList<Variable>(Variable.class, this, ariPackage.EXPRESSION_MODEL__VARIABLE);
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpressionNode> getExpressionNode() {
		if (expressionNode == null) {
			expressionNode = new EObjectContainmentEList<ExpressionNode>(ExpressionNode.class, this, ariPackage.EXPRESSION_MODEL__EXPRESSION_NODE);
		}
		return expressionNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ariPackage.EXPRESSION_MODEL__VARIABLE:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
			case ariPackage.EXPRESSION_MODEL__EXPRESSION_NODE:
				return ((InternalEList<?>)getExpressionNode()).basicRemove(otherEnd, msgs);
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
			case ariPackage.EXPRESSION_MODEL__VARIABLE:
				return getVariable();
			case ariPackage.EXPRESSION_MODEL__EXPRESSION_NODE:
				return getExpressionNode();
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
			case ariPackage.EXPRESSION_MODEL__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection<? extends Variable>)newValue);
				return;
			case ariPackage.EXPRESSION_MODEL__EXPRESSION_NODE:
				getExpressionNode().clear();
				getExpressionNode().addAll((Collection<? extends ExpressionNode>)newValue);
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
			case ariPackage.EXPRESSION_MODEL__VARIABLE:
				getVariable().clear();
				return;
			case ariPackage.EXPRESSION_MODEL__EXPRESSION_NODE:
				getExpressionNode().clear();
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
			case ariPackage.EXPRESSION_MODEL__VARIABLE:
				return variable != null && !variable.isEmpty();
			case ariPackage.EXPRESSION_MODEL__EXPRESSION_NODE:
				return expressionNode != null && !expressionNode.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExpressionModelImpl
