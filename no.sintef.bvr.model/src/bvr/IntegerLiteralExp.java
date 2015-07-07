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
 * A representation of the model object '<em><b>Integer Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A literal expression that represents integer numbers.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.IntegerLiteralExp#getInteger <em>Integer</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getIntegerLiteralExp()
 * @model
 * @generated
 */
public interface IntegerLiteralExp extends NumericLiteralExp {
	/**
	 * Returns the value of the '<em><b>Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The integer value of the IntegerLiteralExpression.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Integer</em>' attribute.
	 * @see #setInteger(int)
	 * @see bvr.BvrPackage#getIntegerLiteralExp_Integer()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getInteger();

	/**
	 * Sets the value of the '{@link bvr.IntegerLiteralExp#getInteger <em>Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer</em>' attribute.
	 * @see #getInteger()
	 * @generated
	 */
	void setInteger(int value);

} // IntegerLiteralExp
