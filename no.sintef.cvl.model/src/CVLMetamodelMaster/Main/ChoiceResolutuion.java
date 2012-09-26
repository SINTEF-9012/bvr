/**
 */
package CVLMetamodelMaster.Main;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice Resolutuion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A ChoiceResolution is a VSpecResolution which resolves a single choice by deciding it positively (True) or negatively (False).</p><p></p><p>####CVLSemanticStart####</p><p>Invariant</p><p>Invariant : If a choice is selected, the number of selected children must correspond to the multiplicity interval of the resolvedChoice</p><p>OCL :</p><p>-- ChoiceResolution</p><p>-- If a choice is selected, the number of selected children must correspond to the multiplicity interval of the resolvedChoice</p><p>context ChoiceResolutuion :</p><p>inv selectedChildrenMustCorrespondsToMultiplicityInterval :</p><p>if self.resolvedChoice.groupMultiplicity-&gt;isEmpty()</p><p>then</p><p>(self.resolvedChoice.groupMultiplicity.upper &lt;&gt; (-1)</p><p>and self.resolvedChoice.groupMultiplicity.lower &lt;= self.childResolution-&gt;select (choiceRes | choiceRes.oclAsType(ChoiceResolutuion).decision)-&gt;size()</p><p>and self.childResolution-&gt;select (choiceRes | choiceRes.oclAsType(ChoiceResolutuion).decision)-&gt;size() &gt;= self.resolvedChoice.groupMultiplicity.upper</p><p>)</p><p>or</p><p>(self.resolvedChoice.groupMultiplicity.upper == (-1)</p><p>and self.resolvedChoice.groupMultiplicity.lower &lt;= self.childResolution-&gt;select (choiceRes | choiceRes.oclAsType(ChoiceResolutuion).decision)-&gt;size()</p><p>)</p><p>else</p><p>-- no choice must be selected</p><p>self.childResolution-&gt;select (choiceRes | choiceRes.oclAsType(ChoiceResolutuion).decision)-&gt;isEmpty()</p><p>endif</p><p>Dynamic semantics</p><p>Pre and post condition</p><p>Pre-condition :</p><p>None</p><p>Post-condition:</p><p>After a Choice Resolution has been executed, the resolvedChoice is constained in the selected VSpecs set if the boolean decision is set to true, otherwise, the resolvedChoice is contained in the unselected VSpec set.</p><p>OCL :</p><p>-- ChoiceResolution</p><p>context ChoiceResolutuion::eval(ctx : CVLExecutionContext):</p><p>pre :</p><p>post :</p><p>self.decision implies</p><p>ctx.selectedVSpecs-&gt;includes(self.resolvedChoice)</p><p>and not self.decision implies</p><p>ctx.unselectedVSpecs-&gt;includes(self.resolvedChoice)</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.ChoiceResolutuion#getResolvedChoice <em>Resolved Choice</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.ChoiceResolutuion#isDecision <em>Decision</em>}</li>
 * </ul>
 * </p>
 *
 * @see CVLMetamodelMaster.Main.MainPackage#getChoiceResolutuion()
 * @model
 * @generated
 */
public interface ChoiceResolutuion extends VSpecResolution {
	/**
	 * Returns the value of the '<em><b>Resolved Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The resolved choice of this resolution.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolved Choice</em>' reference.
	 * @see #setResolvedChoice(Choice)
	 * @see CVLMetamodelMaster.Main.MainPackage#getChoiceResolutuion_ResolvedChoice()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Choice getResolvedChoice();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.ChoiceResolutuion#getResolvedChoice <em>Resolved Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved Choice</em>' reference.
	 * @see #getResolvedChoice()
	 * @generated
	 */
	void setResolvedChoice(Choice value);

	/**
	 * Returns the value of the '<em><b>Decision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The yes/no decision resolving the choice.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Decision</em>' attribute.
	 * @see #setDecision(boolean)
	 * @see CVLMetamodelMaster.Main.MainPackage#getChoiceResolutuion_Decision()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isDecision();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.ChoiceResolutuion#isDecision <em>Decision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decision</em>' attribute.
	 * @see #isDecision()
	 * @generated
	 */
	void setDecision(boolean value);

} // ChoiceResolutuion
