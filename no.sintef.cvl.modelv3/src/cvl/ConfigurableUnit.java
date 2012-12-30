/**
 */
package cvl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configurable Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p><span style="font-size:10pt;font-family:"Times New Roman";"></span><span style="font-size:8pt;"><span style="font-family:"Times New Roman";">A</span> configurable unit (CU) is a kind of variation point which references a base model object, and by doing so indicates the object is a container with inner variability. The latter is specified via contained variation points, so a configurable unit is a kind of variation point which may contain other variation points.</span></p><p><span style="font-size:8pt;">A configurable unit represents <span style="color:#000000;">a base model object which is a reusable component, configurable via an exposed variability interface</span>. The base model object is a container of other base model elements – objects and links – and the CVL configurable unit is a container of variation points defined against those elements, bound to VSpecs. For example, a configurable unit may have associated with it a UML package and contain variation points defined over elements in that package.</span></p><p><span style="font-size:8pt;">A CU hides its internals and exposes a variability interface (VInterface) to the external world, through which it may be configured. This is achieved by binding the CU to a CVSpec, whose type is the exposed interface. The configurable unit may then be configured by providing resolutions to the VSpecs in its interface.</span></p><p><span style="font-size:8pt;">Conceptually, a configurable unit and the base model object associated with it are one unified entity representing a reusable base model component. So the UML package above may be thought of as being configurable, though technically it is an external CVL element referencing the object through a handle.<br><br>CVL configurable units may contain other units, re-iterating the modular structure of the base model. For example, a UML package and a contained class may both be configurable, which means there will be two CVL configurable units, one for the package and one for the class, where the unit for the package contains that for the class. In this way, in addition to facilitating reusable components, configurable units also facilitate modular design.</span></p><p><span style="font-size:8pt;">Configurable units are also packaging/shipping elements and as such may also contain constraints, VSpec derivations, and VSpec resolutions.</span></p><p><span style="font-size:10pt;">####CVLSemanticStart####</span></p><p>Invariant :</p><p>Elements contained in the Configurable Unit associated with a given CVSpec must only point on elements in Interface associated with this given CVSpec</p><p></p><p>OCL :</p><p></p><p>-- ConfigurableUnit</p><p>-- Elements contained in the Configurable Unit associated with a given CVSpec must only point on elements</p><p>-- in Interface associated with this given CVSpec</p><p>context ConfigurableUnit :</p><p>def : isContained ( in vps : VSpec ) : Boolean =</p><p>self.bindingCVSpec.vInterface.vSpec->exists(v | v = vps</p><p>or</p><p>( if not (v.childVSpec->isEmpty())</p><p>then</p><p>v.childVSpec->exists (child | isContained (child) = true)</p><p>endif</p><p>)</p><p>)</p><p>inv consistencyInInterfacePointedByCVSpec :</p><p>not (self.ownedVariationPoint->exists (vp |</p><p>-- search in the VSpec</p><p>( vp.bindingVspec->exists ( vsp | not isContained(vsp) ) )</p><p>))</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.ConfigurableUnit#getOwnedVSpec <em>Owned VSpec</em>}</li>
 *   <li>{@link cvl.ConfigurableUnit#getOwnedVariationPoint <em>Owned Variation Point</em>}</li>
 *   <li>{@link cvl.ConfigurableUnit#getOwnedConstraint <em>Owned Constraint</em>}</li>
 *   <li>{@link cvl.ConfigurableUnit#getConfigurableContainerObject <em>Configurable Container Object</em>}</li>
 *   <li>{@link cvl.ConfigurableUnit#getOwnedVSpecResolution <em>Owned VSpec Resolution</em>}</li>
 *   <li>{@link cvl.ConfigurableUnit#getUnitInterface <em>Unit Interface</em>}</li>
 *   <li>{@link cvl.ConfigurableUnit#getOwnedVSpecDerivation <em>Owned VSpec Derivation</em>}</li>
 *   <li>{@link cvl.ConfigurableUnit#getOwnedVariabletype <em>Owned Variabletype</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getConfigurableUnit()
 * @model
 * @generated
 */
public interface ConfigurableUnit extends CompositeVariationPoint {
	/**
	 * Returns the value of the '<em><b>Owned VSpec</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.VSpec}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Internal VSpecs of the CU</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned VSpec</em>' containment reference list.
	 * @see cvl.cvlPackage#getConfigurableUnit_OwnedVSpec()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VSpec> getOwnedVSpec();

	/**
	 * Returns the value of the '<em><b>Owned Variation Point</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.VariationPoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Internal variation points against the content of the base model object referenced by the unit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Variation Point</em>' containment reference list.
	 * @see cvl.cvlPackage#getConfigurableUnit_OwnedVariationPoint()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VariationPoint> getOwnedVariationPoint();

	/**
	 * Returns the value of the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.Constraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The constraints wrt the internal VSPecs of the unit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Constraint</em>' containment reference list.
	 * @see cvl.cvlPackage#getConfigurableUnit_OwnedConstraint()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Constraint> getOwnedConstraint();

	/**
	 * Returns the value of the '<em><b>Configurable Container Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The container object in the base model which is configurable.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Configurable Container Object</em>' containment reference.
	 * @see #setConfigurableContainerObject(ObjectHandle)
	 * @see cvl.cvlPackage#getConfigurableUnit_ConfigurableContainerObject()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ObjectHandle getConfigurableContainerObject();

	/**
	 * Sets the value of the '{@link cvl.ConfigurableUnit#getConfigurableContainerObject <em>Configurable Container Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configurable Container Object</em>' containment reference.
	 * @see #getConfigurableContainerObject()
	 * @generated
	 */
	void setConfigurableContainerObject(ObjectHandle value);

	/**
	 * Returns the value of the '<em><b>Owned VSpec Resolution</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.VSpecResolution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The owned VSpec resolutions.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned VSpec Resolution</em>' containment reference list.
	 * @see cvl.cvlPackage#getConfigurableUnit_OwnedVSpecResolution()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VSpecResolution> getOwnedVSpecResolution();

	/**
	 * Returns the value of the '<em><b>Unit Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The interface of the unit. Derived as the type of the CVSpec to which the unit is bound.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unit Interface</em>' reference.
	 * @see #setUnitInterface(VInterface)
	 * @see cvl.cvlPackage#getConfigurableUnit_UnitInterface()
	 * @model required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	VInterface getUnitInterface();

	/**
	 * Sets the value of the '{@link cvl.ConfigurableUnit#getUnitInterface <em>Unit Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Interface</em>' reference.
	 * @see #getUnitInterface()
	 * @generated
	 */
	void setUnitInterface(VInterface value);

	/**
	 * Returns the value of the '<em><b>Owned VSpec Derivation</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.VSpecDerivation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The owned VSpec derivations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned VSpec Derivation</em>' containment reference list.
	 * @see cvl.cvlPackage#getConfigurableUnit_OwnedVSpecDerivation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VSpecDerivation> getOwnedVSpecDerivation();

	/**
	 * Returns the value of the '<em><b>Owned Variabletype</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.Variabletype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Variabletype</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Variabletype</em>' containment reference list.
	 * @see cvl.cvlPackage#getConfigurableUnit_OwnedVariabletype()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Variabletype> getOwnedVariabletype();

} // ConfigurableUnit
