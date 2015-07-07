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
 * A representation of the model object '<em><b>Choice VSpec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p class="MsoNormal"><span style="font-size:8pt;font-family:Tahoma;">A ChoiceVSpec is a VSpec which either Choice or ChoiceOccurence.</span></p><p><span style="font-size:8pt;font-family:Tahoma;"></span>####CVLSemanticStart####</p><p>Invariant : If a choice is implied by parent, it must have a parent.</p><p>OCL :</p><p>-- Choice</p><p>-- If a choice is implied by parent, it must have a parent.</p><p>context Choice :</p><p>inv isImpliedByParentsImpliesAParent :</p><p>self.isImpliedByParent implies VSpec.allInstances()-&gt;exists(vSpec | vSpec.childVSpec-&gt;includes(self))</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.ChoiceVSpec#isDefaultResolution <em>Default Resolution</em>}</li>
 *   <li>{@link bvr.ChoiceVSpec#isIsImpliedByParent <em>Is Implied By Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getChoiceVSpec()
 * @model abstract="true"
 * @generated
 */
public interface ChoiceVSpec extends VSpec {
	/**
	 * Returns the value of the '<em><b>Default Resolution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The default resolution of this choice. (If True then the default is a PosResolution, if False then the default is a NegResolution)</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Resolution</em>' attribute.
	 * @see #setDefaultResolution(boolean)
	 * @see bvr.BvrPackage#getChoiceVSpec_DefaultResolution()
	 * @model ordered="false"
	 * @generated
	 */
	boolean isDefaultResolution();

	/**
	 * Sets the value of the '{@link bvr.ChoiceVSpec#isDefaultResolution <em>Default Resolution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Resolution</em>' attribute.
	 * @see #isDefaultResolution()
	 * @generated
	 */
	void setDefaultResolution(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Implied By Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>When True then resolving the parent VSpec positively implies deciding this choice  positively. A VSpec resolution is positive if it is a choice decided positively, or any classifier instantiation, or any value assignment to a variable.<br><br>For a root choice, True implies it must be resolved positively.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Implied By Parent</em>' attribute.
	 * @see #setIsImpliedByParent(boolean)
	 * @see bvr.BvrPackage#getChoiceVSpec_IsImpliedByParent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isIsImpliedByParent();

	/**
	 * Sets the value of the '{@link bvr.ChoiceVSpec#isIsImpliedByParent <em>Is Implied By Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Implied By Parent</em>' attribute.
	 * @see #isIsImpliedByParent()
	 * @generated
	 */
	void setIsImpliedByParent(boolean value);

} // ChoiceVSpec
