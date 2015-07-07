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
 * A representation of the model object '<em><b>Resolution Literal Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>Defines Resolution Literal as a named subtree of VSpecResolutions. This can then be reused through ResolutionLiteralUses.</p><p>Typically ResolutionLiteralDefinitions are used to name and store subproducts that are either existing or planned.</p><p>####CVLSemanticStart####</p><p>Invariant : Let the ResolutionLiteralDefinition be 'rlit' and its owner 'rlitown' then rlitown.resolvedVSpec owns rlit.literalType.</p><p>Informally this means that the resolution literals are placed in the resolution model parallel to where the corresponding VType is placed in the variability model.</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.ResolutionLiteralDefinition#getLiteralType <em>Literal Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getResolutionLiteralDefinition()
 * @model
 * @generated
 */
public interface ResolutionLiteralDefinition extends CompoundResolution {
	/**
	 * Returns the value of the '<em><b>Literal Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The VType defining the details of the ResolutionLiteralDefinition. There must be pairwise correspondence between elements of the ResolutionLiteralDefinition tree and that of the literalType tree.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Literal Type</em>' reference.
	 * @see #setLiteralType(VType)
	 * @see bvr.BvrPackage#getResolutionLiteralDefinition_LiteralType()
	 * @model ordered="false"
	 * @generated
	 */
	VType getLiteralType();

	/**
	 * Sets the value of the '{@link bvr.ResolutionLiteralDefinition#getLiteralType <em>Literal Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal Type</em>' reference.
	 * @see #getLiteralType()
	 * @generated
	 */
	void setLiteralType(VType value);

} // ResolutionLiteralDefinition
