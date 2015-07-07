/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
/**
 */
package bvr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BCL Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>Top class of a constraint. Contains basic constraint language expressions. </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.BCLConstraint#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getBCLConstraint()
 * @model
 * @generated
 */
public interface BCLConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.BCLExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The constraining expression of this BCLConstraint.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference list.
	 * @see bvr.BvrPackage#getBCLConstraint_Expression()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<BCLExpression> getExpression();

} // BCLConstraint
