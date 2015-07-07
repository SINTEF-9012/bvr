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
 * A representation of the model object '<em><b>Choice Resolution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A�ChoiceResolution�is�a VSpecResolution�which�resolves�a�single�choice�positively�(PosResolution)�or�negatively (NegResolution).</p><p></p><p>####CVLSemanticStart####</p><p>Invariant</p><p>Invariant : If a choice is selected, the number of selected children must correspond to the multiplicity interval of the resolvedChoice</p><p>OCL :</p><p>-- ChoiceResolution</p><p>-- If a choice is selected, the number of selected children must correspond to the multiplicity interval of the resolvedChoice</p><p>context ChoiceResolutuion :</p><p>inv selectedChildrenMustCorrespondsToMultiplicityInterval :</p><p>if self.resolvedChoice.groupMultiplicity-&gt;isEmpty()</p><p>then</p><p>(self.resolvedChoice.groupMultiplicity.upper &lt;&gt; (-1)</p><p>and self.resolvedChoice.groupMultiplicity.lower &lt;= self.childResolution-&gt;select (choiceRes | choiceRes.oclAsType(ChoiceResolutuion).decision)-&gt;size()</p><p>and self.childResolution-&gt;select (choiceRes | choiceRes.oclAsType(ChoiceResolutuion).decision)-&gt;size() &gt;= self.resolvedChoice.groupMultiplicity.upper</p><p>)</p><p>or</p><p>(self.resolvedChoice.groupMultiplicity.upper == (-1)</p><p>and self.resolvedChoice.groupMultiplicity.lower &lt;= self.childResolution-&gt;select (choiceRes | choiceRes.oclAsType(ChoiceResolutuion).decision)-&gt;size()</p><p>)</p><p>else</p><p>-- no choice must be selected</p><p>self.childResolution-&gt;select (choiceRes | choiceRes.oclAsType(ChoiceResolutuion).decision)-&gt;isEmpty()</p><p>endif</p><p>Dynamic semantics</p><p>Pre and post condition</p><p>Pre-condition :</p><p>None</p><p>Post-condition:</p><p>After a Choice Resolution has been executed, the resolvedChoice is constained in the selected VSpecs set if the boolean decision is set to true, otherwise, the resolvedChoice is contained in the unselected VSpec set.</p><p>OCL :</p><p>-- ChoiceResolution</p><p>context ChoiceResolutuion::eval(ctx : CVLExecutionContext):</p><p>pre :</p><p>post :</p><p>self.decision implies</p><p>ctx.selectedVSpecs-&gt;includes(self.resolvedChoice)</p><p>and not self.decision implies</p><p>ctx.unselectedVSpecs-&gt;includes(self.resolvedChoice)</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.ChoiceResolution#getResolvedChoice <em>Resolved Choice</em>}</li>
 *   <li>{@link bvr.ChoiceResolution#getResolvedChoiceOcc <em>Resolved Choice Occ</em>}</li>
 *   <li>{@link bvr.ChoiceResolution#getResolvedVClassOcc <em>Resolved VClass Occ</em>}</li>
 *   <li>{@link bvr.ChoiceResolution#getResolvedVClassifier <em>Resolved VClassifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getChoiceResolution()
 * @model abstract="true"
 * @generated
 */
public interface ChoiceResolution extends VSpecResolution {
	/**
	 * Returns the value of the '<em><b>Resolved Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The resolved choice of this resolution.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolved Choice</em>' reference.
	 * @see #setResolvedChoice(Choice)
	 * @see bvr.BvrPackage#getChoiceResolution_ResolvedChoice()
	 * @model ordered="false"
	 * @generated
	 */
	Choice getResolvedChoice();

	/**
	 * Sets the value of the '{@link bvr.ChoiceResolution#getResolvedChoice <em>Resolved Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved Choice</em>' reference.
	 * @see #getResolvedChoice()
	 * @generated
	 */
	void setResolvedChoice(Choice value);

	/**
	 * Returns the value of the '<em><b>Resolved Choice Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The resolved choice occurrence</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolved Choice Occ</em>' reference.
	 * @see #setResolvedChoiceOcc(ChoiceOccurrence)
	 * @see bvr.BvrPackage#getChoiceResolution_ResolvedChoiceOcc()
	 * @model ordered="false"
	 * @generated
	 */
	ChoiceOccurrence getResolvedChoiceOcc();

	/**
	 * Sets the value of the '{@link bvr.ChoiceResolution#getResolvedChoiceOcc <em>Resolved Choice Occ</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved Choice Occ</em>' reference.
	 * @see #getResolvedChoiceOcc()
	 * @generated
	 */
	void setResolvedChoiceOcc(ChoiceOccurrence value);

	/**
	 * Returns the value of the '<em><b>Resolved VClass Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The resolved VClass occurrence</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolved VClass Occ</em>' reference.
	 * @see #setResolvedVClassOcc(VClassOccurrence)
	 * @see bvr.BvrPackage#getChoiceResolution_ResolvedVClassOcc()
	 * @model ordered="false"
	 * @generated
	 */
	VClassOccurrence getResolvedVClassOcc();

	/**
	 * Sets the value of the '{@link bvr.ChoiceResolution#getResolvedVClassOcc <em>Resolved VClass Occ</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved VClass Occ</em>' reference.
	 * @see #getResolvedVClassOcc()
	 * @generated
	 */
	void setResolvedVClassOcc(VClassOccurrence value);

	/**
	 * Returns the value of the '<em><b>Resolved VClassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The resolved classifier</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolved VClassifier</em>' reference.
	 * @see #setResolvedVClassifier(VClassifier)
	 * @see bvr.BvrPackage#getChoiceResolution_ResolvedVClassifier()
	 * @model ordered="false"
	 * @generated
	 */
	VClassifier getResolvedVClassifier();

	/**
	 * Sets the value of the '{@link bvr.ChoiceResolution#getResolvedVClassifier <em>Resolved VClassifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved VClassifier</em>' reference.
	 * @see #getResolvedVClassifier()
	 * @generated
	 */
	void setResolvedVClassifier(VClassifier value);

} // ChoiceResolution
