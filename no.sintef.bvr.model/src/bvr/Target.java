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
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>Target represents the substance of what a VSpec is about. VSpecs are in fact variability decision points, and even in the same VNode tree there may be several VSpecs that refer to the same substance, but the paths to the decision point differ. Constraints talk about Targets.</p><p>The substance of what a VSpec is about does not necessarily mean a piece of the base model, but may sometimes refer to exactly that. The essence of "substance" is that the same abstract decision can be reached in different ways in the VSpec tree (variability model).</p>
 * <!-- end-model-doc -->
 *
 *
 * @see bvr.BvrPackage#getTarget()
 * @model
 * @generated
 */
public interface Target extends NamedElement {
} // Target
