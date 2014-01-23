/**
 */
package bvr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VConfiguration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A VConfiguration is a kind of VSpecResolution which resolves a CVSpec by providing resolutions to the VSpecs in its type, which is a VInterface.VConfigurations are used to resolve configurable units.<br></p><p></p><p>####BVRSemanticStart####</p><p>Invariant : The resolutions in a configuration resolve only VSpecs of its VInterface</p><p>OCL :</p><p>-- VConfiguration</p><p>-- The resolutions in a configuration resolve only VSpecs of its VInterface</p><p>def : isContained ( in vps : VSpec ) : Boolean =</p><p>self.resolvedVIRef.vInterface.vSpec->exists(v | v = vps</p><p>or</p><p>( if not (v.childVSpec->isEmpty())</p><p>then</p><p>v.childVSpec->exists (child | isContained (child) = true)</p><p>endif</p><p>)</p><p>)</p><p>context VConfiguration</p><p>inv resolve_only_vspec_in_VInterface :</p><p>self.vSpecResolution->forAll(vspecRes | isContained(vspecRes.resolvedVSpec))</p><p>####BVRSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.VConfiguration#getMember <em>Member</em>}</li>
 *   <li>{@link bvr.VConfiguration#isIsPartial <em>Is Partial</em>}</li>
 *   <li>{@link bvr.VConfiguration#getResolvedCVSpec <em>Resolved CV Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getVConfiguration()
 * @model
 * @generated
 */
public interface VConfiguration extends VSpecResolution, VPackageable {
	/**
	 * Returns the value of the '<em><b>Member</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.VSpecResolution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The members of the VConfiguration.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Member</em>' containment reference list.
	 * @see bvr.BvrPackage#getVConfiguration_Member()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VSpecResolution> getMember();

	/**
	 * Returns the value of the '<em><b>Is Partial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Specifies if the VConfiguration is partial.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Partial</em>' attribute.
	 * @see #setIsPartial(boolean)
	 * @see bvr.BvrPackage#getVConfiguration_IsPartial()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isIsPartial();

	/**
	 * Sets the value of the '{@link bvr.VConfiguration#isIsPartial <em>Is Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Partial</em>' attribute.
	 * @see #isIsPartial()
	 * @generated
	 */
	void setIsPartial(boolean value);

	/**
	 * Returns the value of the '<em><b>Resolved CV Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The resolved CVSpec.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolved CV Spec</em>' reference.
	 * @see #setResolvedCVSpec(CVSpec)
	 * @see bvr.BvrPackage#getVConfiguration_ResolvedCVSpec()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CVSpec getResolvedCVSpec();

	/**
	 * Sets the value of the '{@link bvr.VConfiguration#getResolvedCVSpec <em>Resolved CV Spec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved CV Spec</em>' reference.
	 * @see #getResolvedCVSpec()
	 * @generated
	 */
	void setResolvedCVSpec(CVSpec value);

} // VConfiguration
