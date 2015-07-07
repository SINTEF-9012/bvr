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
 * A representation of the model object '<em><b>Opaque Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>An Opaque�Constraint�imposes�additional�restrictions�that�cannot�be�expressed�in�the�basic constraint�language.</p><p>Opaque constraints can be expressed in any language (given by the language attribute) but cannot be directly understood as BVR.</p><p>Typically an opaque constraint must be used if there is a need to express�universal�quantification or other advanced expressiveness. OCL is an obvious choice for such a more advanced constraint language.</p><p></p><p></p><p></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.OpaqueConstraint#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link bvr.OpaqueConstraint#getConstraintLanguage <em>Constraint Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getOpaqueConstraint()
 * @model
 * @generated
 */
public interface OpaqueConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Constraint as an opaque String.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraint</em>' attribute.
	 * @see #setConstraint(String)
	 * @see bvr.BvrPackage#getOpaqueConstraint_Constraint()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getConstraint();

	/**
	 * Sets the value of the '{@link bvr.OpaqueConstraint#getConstraint <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' attribute.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(String value);

	/**
	 * Returns the value of the '<em><b>Constraint Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Language of the OpaqueConstraint as a String.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraint Language</em>' attribute.
	 * @see #setConstraintLanguage(String)
	 * @see bvr.BvrPackage#getOpaqueConstraint_ConstraintLanguage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getConstraintLanguage();

	/**
	 * Sets the value of the '{@link bvr.OpaqueConstraint#getConstraintLanguage <em>Constraint Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Language</em>' attribute.
	 * @see #getConstraintLanguage()
	 * @generated
	 */
	void setConstraintLanguage(String value);

} // OpaqueConstraint
