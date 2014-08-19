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
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.Choice#isDefaultResolution <em>Default Resolution</em>}</li>
 *   <li>{@link bvr.Choice#isIsImpliedByParent <em>Is Implied By Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getChoice()
 * @model
 * @generated
 */
public interface Choice extends VSpec {
	/**
	 * Returns the value of the '<em><b>Default Resolution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The default resolution of this choice. (If True then the default is a PosResolution, if False then the default is a NegResolution)</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Resolution</em>' attribute.
	 * @see #setDefaultResolution(boolean)
	 * @see bvr.BvrPackage#getChoice_DefaultResolution()
	 * @model ordered="false"
	 * @generated
	 */
	boolean isDefaultResolution();

	/**
	 * Sets the value of the '{@link bvr.Choice#isDefaultResolution <em>Default Resolution</em>}' attribute.
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
	 * @see bvr.BvrPackage#getChoice_IsImpliedByParent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isIsImpliedByParent();

	/**
	 * Sets the value of the '{@link bvr.Choice#isIsImpliedByParent <em>Is Implied By Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Implied By Parent</em>' attribute.
	 * @see #isIsImpliedByParent()
	 * @generated
	 */
	void setIsImpliedByParent(boolean value);

} // Choice
