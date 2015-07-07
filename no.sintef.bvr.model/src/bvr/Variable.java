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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p class="MsoNormal"><span style="font-size:8pt;font-family:Tahoma;">A variable is a VSpec whose resolution requires providing a value of its specified type. When a parametric variation point is bound to a variable, the value provided for the variable as resolution will be used as the actual parameter when applying the variation point during materialization.</span></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.Variable#getDefaulValue <em>Defaul Value</em>}</li>
 *   <li>{@link bvr.Variable#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends VSpec {
	/**
	 * Returns the value of the '<em><b>Defaul Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The default value of this Variable.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Defaul Value</em>' containment reference.
	 * @see #setDefaulValue(ValueSpecification)
	 * @see bvr.BvrPackage#getVariable_DefaulValue()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ValueSpecification getDefaulValue();

	/**
	 * Sets the value of the '{@link bvr.Variable#getDefaulValue <em>Defaul Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defaul Value</em>' containment reference.
	 * @see #getDefaulValue()
	 * @generated
	 */
	void setDefaulValue(ValueSpecification value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The type of the variable.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Variabletype)
	 * @see bvr.BvrPackage#getVariable_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Variabletype getType();

	/**
	 * Sets the value of the '{@link bvr.Variable#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Variabletype value);

} // Variable
