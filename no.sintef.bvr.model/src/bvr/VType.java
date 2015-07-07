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
 * A representation of the model object '<em><b>VType</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>VType is a type of VNodes which means that it represents a pattern of reuse - a subtree of a VNode tree. VTypes are referred by ChoiceOccurrences and VClassOccurrences.</p><p>Thus we may informally understand a VType by the following formulas: ChoiceOccurrence+VType == Choice ; VClassOccurrence+VType == VClassifier.</p><p></p>
 * <!-- end-model-doc -->
 *
 *
 * @see bvr.BvrPackage#getVType()
 * @model
 * @generated
 */
public interface VType extends CompoundNode, VPackageable {
} // VType
