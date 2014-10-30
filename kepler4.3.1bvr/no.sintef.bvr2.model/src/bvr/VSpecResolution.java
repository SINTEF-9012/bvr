/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VSpec Resolution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A VSpecResolution resolves a VSpec. VSpecResolutions are organized as trees, mirroring partially the tree structure of the VSpecs they resolve.</p><p>####CVLSemanticStart####</p><p>Invariant : We must retrieve at least all of the resolvedVSpec's children associated with the VSpecResolution's vspec children</p><p>OCL :</p><p>-- VSpecResolution</p><p>-- We must retrieve at least all of the resolvedVSpec's children associated with the VSpecResolution's vspec children</p><p>-- So, the number of VSpecResolution's children must be &gt;= to the number of resolvedVSpec' s children</p><p>context VSpecResolution</p><p>inv VSpecResChildrenCorrespondsToVSpecChildren :</p><p>self.childResolution-&gt;size() &gt;= self.resolvedVSpec.childVSpec-&gt;size()</p><p>and</p><p>not (self.resolvedVSpec.childVSpec-&gt;exists (vSpec | not (self.childResolution-&gt;exists(vRes | vRes.resolvedVSpec == (VSpec)))))</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.VSpecResolution#getResolvedVSpec <em>Resolved VSpec</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getVSpecResolution()
 * @model abstract="true"
 * @generated
 */
public interface VSpecResolution extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The VSpec this VSpecResolution resolves.Due to VSpec inheritance and VClassifiers, a given VSpec may have several VSpecResolutions resolving it, where each resolution is in the context of its parent.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolved VSpec</em>' reference.
	 * @see #setResolvedVSpec(VSpec)
	 * @see bvr.BvrPackage#getVSpecResolution_ResolvedVSpec()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VSpec getResolvedVSpec();

	/**
	 * Sets the value of the '{@link bvr.VSpecResolution#getResolvedVSpec <em>Resolved VSpec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved VSpec</em>' reference.
	 * @see #getResolvedVSpec()
	 * @generated
	 */
	void setResolvedVSpec(VSpec value);

} // VSpecResolution
