/**
 */
package CVLMetamodelMaster.Main;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VSpec Resolution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A VSpecResolution resolves a single VSpec. VSpecResolutions are organized as trees, mirroring the tree structure of the VSpecs they resolve.</p><p>####CVLSemanticStart####</p><p>Invariant : We must retrieve at least all of the resolvedVSpec's children associated with the VSpecResolution's vspec children</p><p>OCL :</p><p>-- VSpecResolution</p><p>-- We must retrieve at least all of the resolvedVSpec's children associated with the VSpecResolution's vspec children</p><p>-- So, the number of VSpecResolution's children must be >= to the number of resolvedVSpec' s children</p><p>context VSpecResolution</p><p>inv VSpecResChildrenCorrespondsToVSpecChildren :</p><p>self.childResolution->size() >= self.resolvedVSpec.childVSpec->size()</p><p>and</p><p>not (self.resolvedVSpec.childVSpec->exists (vSpec | not (self.childResolution->exists(vRes | vRes.resolvedVSpec == (VSpec)))))</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.VSpecResolution#getResolvedVSpec <em>Resolved VSpec</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.VSpecResolution#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see CVLMetamodelMaster.Main.MainPackage#getVSpecResolution()
 * @model abstract="true"
 * @generated
 */
public interface VSpecResolution extends VPackageable {
	/**
	 * Returns the value of the '<em><b>Resolved VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The&nbsp;VSpec&nbsp;this&nbsp;VSpecResolution&nbsp;resolves.Due to&nbsp;VSpec inheritance and VClassifiers, a given VPSec
	 * may have several VSpecResolutions resolving it, where each resolution is in the context of its parent.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolved VSpec</em>' reference.
	 * @see #setResolvedVSpec(VSpec)
	 * @see CVLMetamodelMaster.Main.MainPackage#getVSpecResolution_ResolvedVSpec()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VSpec getResolvedVSpec();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.VSpecResolution#getResolvedVSpec <em>Resolved VSpec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved VSpec</em>' reference.
	 * @see #getResolvedVSpec()
	 * @generated
	 */
	void setResolvedVSpec(VSpec value);

	/**
	 * Returns the value of the '<em><b>Child</b></em>' containment reference list.
	 * The list contents are of type {@link CVLMetamodelMaster.Main.VSpecResolution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The child resolutions of this VSpecResolution. A given VSpecResolution is interpreted in the context of its parent.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Child</em>' containment reference list.
	 * @see CVLMetamodelMaster.Main.MainPackage#getVSpecResolution_Child()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VSpecResolution> getChild();

} // VSpecResolution
