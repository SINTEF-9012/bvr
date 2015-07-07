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
 * A representation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p class="MsoNormal"><span style="font-size:8pt;font-family:Tahoma;">A Choice is a VSpec and a VNode that represents a yes/no decision. When a VariationPoint is bound to a choice it is dependent upon whether the resolution is a PosResolution or a NegResolution to determine what VariationPoint to execute.</span></p><p><span style="font-size:8pt;font-family:Tahoma;"></span>####CVLSemanticStart####</p><p>Invariant : If a choice is implied by parent, it must have a parent.</p><p>OCL :</p><p>-- Choice</p><p>-- If a choice is implied by parent, it must have a parent.</p><p>context Choice :</p><p>inv isImpliedByParentsImpliesAParent :</p><p>self.isImpliedByParent implies VSpec.allInstances()-&gt;exists(vSpec | vSpec.childVSpec-&gt;includes(self))</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 *
 * @see bvr.BvrPackage#getChoice()
 * @model
 * @generated
 */
public interface Choice extends CompoundNode, ChoiceVSpec {

} // Choice
