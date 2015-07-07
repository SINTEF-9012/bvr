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
 * A representation of the model object '<em><b>VRef Value Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>VRefValueSpecification defines the value of a VRef. The following invariant must hold: VRefValueSpecification.vSpecResolution.resolvedVSpec == VRefValueSpecification.type.refVSpec (with the appropriate qualifiers when there is multiplicity)</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.VRefValueSpecification#getVSpecResolution <em>VSpec Resolution</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getVRefValueSpecification()
 * @model
 * @generated
 */
public interface VRefValueSpecification extends ValueSpecification {
	/**
	 * Returns the value of the '<em><b>VSpec Resolution</b></em>' reference list.
	 * The list contents are of type {@link bvr.VSpecResolution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The resolution reference such that VSpecResolution.resolvedVSpec == type.refVSpec</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>VSpec Resolution</em>' reference list.
	 * @see bvr.BvrPackage#getVRefValueSpecification_VSpecResolution()
	 * @model ordered="false"
	 * @generated
	 */
	EList<VSpecResolution> getVSpecResolution();

} // VRefValueSpecification
