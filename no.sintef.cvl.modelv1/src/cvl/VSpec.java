/**
 */
package cvl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VSpec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p class="MsoNormal"><span style="font-size:8pt;font-family:Tahoma;">A VSpecs is a specification of abstract variability. VSpecs can be organized in trees structures representing implicit logical constraints on their resolutions. VSpecs can have variation points bound to them. To materialize a base model with a variability model over it, resolutions for the VSpecs must be provided.<br>VSpecs are organized as trees, representing logical constraints and guiding the materialization process. </span></p><p>A VSpec may optionally a group multiplicity specifying upper and lower multiplicities against its children. The meaning of this is that each positive resolution against a VSpec must have a number of positive child resolutions conforming to the multiplicity interval. A VSpec resolution is positive if it is a choice decided positively, or any classifier instantiation, or any value assignment to a variable.</p><p>####CVLSemanticStart####</p><p>Invariant : If the VSpec has a multiplicity interval, it must have a number of children included between the lowerMultiplicity and the upperMultiplicity</p><p>OCL :</p><p>-- VSpec</p><p>-- nbChild_with_MultiplicityInterval :</p><p>--If the VSpec has a multiplicity interval, it must have a number of children included between the lowerMultiplicity and the upperMultiplicity</p><p>context VSpec :</p><p>inv nbChild_with_MultiplicityInterval :</p><p>if not self.groupMultiplicity->isEmpty()</p><p>then (self.childVSpec->size() >= self.groupMultiplicity.lower and self.groupMultiplicity.lower</p><p>-1</p><p>and self.childVSpec->size() = self.groupMultiplicity.upper and self.groupMultiplicity.upper</p><p>-1)</p><p>-- Infinite upper</p><p>or (self.groupMultiplicity.lower</p><p>-1 and self.groupMultiplicity.upper == (-1) and self.childVSpec->size() >= self.groupMultiplicity.lower )</p><p>-- Infinite lower : no sense for practical purposes</p><p>else true</p><p>endif</p><p></p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.VSpec#getGroupMultiplicity <em>Group Multiplicity</em>}</li>
 *   <li>{@link cvl.VSpec#getResolutionTime <em>Resolution Time</em>}</li>
 *   <li>{@link cvl.VSpec#getOwnedVSpecDerivation <em>Owned VSpec Derivation</em>}</li>
 *   <li>{@link cvl.VSpec#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getVSpec()
 * @model abstract="true"
 * @generated
 */
public interface VSpec extends VPackageable {
	/**
	 * Returns the value of the '<em><b>Group Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     The group multiplicity of the VSpec. If the VSpec is resolved positively and has a group multiplicity then the number
	 *     of<br />
	 *     its children resolved positively must conform to the specified multiplicity interval.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Group Multiplicity</em>' containment reference.
	 * @see #setGroupMultiplicity(MultiplicityInterval)
	 * @see cvl.cvlPackage#getVSpec_GroupMultiplicity()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	MultiplicityInterval getGroupMultiplicity();

	/**
	 * Sets the value of the '{@link cvl.VSpec#getGroupMultiplicity <em>Group Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Multiplicity</em>' containment reference.
	 * @see #getGroupMultiplicity()
	 * @generated
	 */
	void setGroupMultiplicity(MultiplicityInterval value);

	/**
	 * Returns the value of the '<em><b>Resolution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The latest life-cycle stage at which this VSpec is expected to be resolved, e.g. "Design", "Link", "Build", "PostBuild", etc. It has no semantics within CVL.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolution Time</em>' attribute.
	 * @see #setResolutionTime(String)
	 * @see cvl.cvlPackage#getVSpec_ResolutionTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getResolutionTime();

	/**
	 * Sets the value of the '{@link cvl.VSpec#getResolutionTime <em>Resolution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolution Time</em>' attribute.
	 * @see #getResolutionTime()
	 * @generated
	 */
	void setResolutionTime(String value);

	/**
	 * Returns the value of the '<em><b>Owned VSpec Derivation</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.VSpecDerivation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The owned VSpecDerivations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned VSpec Derivation</em>' containment reference list.
	 * @see cvl.cvlPackage#getVSpec_OwnedVSpecDerivation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VSpecDerivation> getOwnedVSpecDerivation();

	/**
	 * Returns the value of the '<em><b>Child</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.VSpec}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Child VSpecs of this VSpec.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Child</em>' containment reference list.
	 * @see cvl.cvlPackage#getVSpec_Child()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VSpec> getChild();

} // VSpec
