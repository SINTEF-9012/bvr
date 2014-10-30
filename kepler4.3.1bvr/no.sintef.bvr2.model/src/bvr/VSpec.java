/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VSpec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p class="MsoNormal"><span style="font-size:8pt;font-family:Tahoma;">VSpec is the metaclass for Variability Specifications. VSpecs are the decision points that need to be resolved, and therefore the VResolutionSpecifications refer to VSpecs. Furthermore, the VSpecs are what controls the materialization and therefore VSpecs are referred by VariationPoints. There are more specifics relating to the specializations of VSpec, VResolutionSpecification and VariationPoint</span></p><p><span style="font-size:8pt;font-family:Tahoma;"></span>####CVLSemanticStart####</p><p>Invariant : If the VSpec has a multiplicity interval, it must have a number of children included between the lowerMultiplicity and the upperMultiplicity</p><p>OCL :</p><p>-- VSpec</p><p>-- nbChild_with_MultiplicityInterval :</p><p>--If the VSpec has a multiplicity interval, it must have a number of children included between the lowerMultiplicity and the upperMultiplicity</p><p>context VSpec :</p><p>inv nbChild_with_MultiplicityInterval :</p><p>if not self.groupMultiplicity-&gt;isEmpty()</p><p>then (self.childVSpec-&gt;size() &gt;= self.groupMultiplicity.lower and self.groupMultiplicity.lower</p><p>-1</p><p>and self.childVSpec-&gt;size() = self.groupMultiplicity.upper and self.groupMultiplicity.upper</p><p>-1)</p><p>-- Infinite upper</p><p>or (self.groupMultiplicity.lower</p><p>-1 and self.groupMultiplicity.upper == (-1) and self.childVSpec-&gt;size() &gt;= self.groupMultiplicity.lower )</p><p>-- Infinite lower : no sense for practical purposes</p><p>else true</p><p>endif</p><p></p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.VSpec#getResolutionTime <em>Resolution Time</em>}</li>
 *   <li>{@link bvr.VSpec#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getVSpec()
 * @model abstract="true"
 * @generated
 */
public interface VSpec extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Resolution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The latest life-cycle stage at which this VSpec is expected to be resolved, e.g. "Design", "Link", "Build", "PostBuild", etc. It has no semantics within current BVR.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolution Time</em>' attribute.
	 * @see #setResolutionTime(String)
	 * @see bvr.BvrPackage#getVSpec_ResolutionTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getResolutionTime();

	/**
	 * Sets the value of the '{@link bvr.VSpec#getResolutionTime <em>Resolution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolution Time</em>' attribute.
	 * @see #getResolutionTime()
	 * @generated
	 */
	void setResolutionTime(String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The Target defining the substance of the choice represented by this VSpec. (Many VSpecs may refer the same Target meaning that all these VSpec decision points refer to the same substance)</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Target)
	 * @see bvr.BvrPackage#getVSpec_Target()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Target getTarget();

	/**
	 * Sets the value of the '{@link bvr.VSpec#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Target value);

} // VSpec
