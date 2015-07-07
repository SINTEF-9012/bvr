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
 * A representation of the model object '<em><b>Note</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>Notes are auxiliary information associated with the NamedElements, typically associated with VSpecs and the likes. When the kind is empty it is just a text.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.Note#getKind <em>Kind</em>}</li>
 *   <li>{@link bvr.Note#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getNote()
 * @model
 * @generated
 */
public interface Note extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"Comment"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>kind is a String that designates what this Note is about. kind can typically be an indication about some extra-functional property such as "response time", or "cost".</p><p>When kind is empty this means that the Note is a plain comment.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see bvr.BvrPackage#getNote_Kind()
	 * @model default="Comment" required="true" ordered="false"
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link bvr.Note#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Expr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>expr is the content of the Note. The interpretation of expr is given by the kind. It is tool-specific whether and how the Notes are processed by the tool.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expr</em>' attribute.
	 * @see #setExpr(String)
	 * @see bvr.BvrPackage#getNote_Expr()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getExpr();

	/**
	 * Sets the value of the '{@link bvr.Note#getExpr <em>Expr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' attribute.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(String value);

} // Note
