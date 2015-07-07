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
 * A representation of the model object '<em><b>VRef</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>Variability Reference. A VRef is a reference to a node in the VSpec tree (VNode).</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.VRef#getRefVSpec <em>Ref VSpec</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getVRef()
 * @model
 * @generated
 */
public interface VRef extends Variabletype {
	/**
	 * Returns the value of the '<em><b>Ref VSpec</b></em>' reference list.
	 * The list contents are of type {@link bvr.VSpec}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The VSpec referred by the VRef</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref VSpec</em>' reference list.
	 * @see bvr.BvrPackage#getVRef_RefVSpec()
	 * @model ordered="false"
	 * @generated
	 */
	EList<VSpec> getRefVSpec();

} // VRef
