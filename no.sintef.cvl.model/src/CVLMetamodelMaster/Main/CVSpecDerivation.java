/**
 */
package CVLMetamodelMaster.Main;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CV Spec Derivation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A CVSpec derivation is a specification how to derive the resolution for a particular CVSpec from the resolution of another CVSpec</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.CVSpecDerivation#getMemberDerivation <em>Member Derivation</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.CVSpecDerivation#getDerivingCVspec <em>Deriving CVspec</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.CVSpecDerivation#getDerivedCVSpec <em>Derived CV Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @see CVLMetamodelMaster.Main.MainPackage#getCVSpecDerivation()
 * @model
 * @generated
 */
public interface CVSpecDerivation extends VSpecDerivation {
	/**
	 * Returns the value of the '<em><b>Member Derivation</b></em>' containment reference list.
	 * The list contents are of type {@link CVLMetamodelMaster.Main.VSpecDerivation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The member derivations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Member Derivation</em>' containment reference list.
	 * @see CVLMetamodelMaster.Main.MainPackage#getCVSpecDerivation_MemberDerivation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VSpecDerivation> getMemberDerivation();

	/**
	 * Returns the value of the '<em><b>Deriving CVspec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The deriving CVSpec.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Deriving CVspec</em>' reference.
	 * @see #setDerivingCVspec(CVSpec)
	 * @see CVLMetamodelMaster.Main.MainPackage#getCVSpecDerivation_DerivingCVspec()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CVSpec getDerivingCVspec();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.CVSpecDerivation#getDerivingCVspec <em>Deriving CVspec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deriving CVspec</em>' reference.
	 * @see #getDerivingCVspec()
	 * @generated
	 */
	void setDerivingCVspec(CVSpec value);

	/**
	 * Returns the value of the '<em><b>Derived CV Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The derived CVSpec.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Derived CV Spec</em>' reference.
	 * @see #setDerivedCVSpec(CVSpec)
	 * @see CVLMetamodelMaster.Main.MainPackage#getCVSpecDerivation_DerivedCVSpec()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CVSpec getDerivedCVSpec();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.CVSpecDerivation#getDerivedCVSpec <em>Derived CV Spec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived CV Spec</em>' reference.
	 * @see #getDerivedCVSpec()
	 * @generated
	 */
	void setDerivedCVSpec(CVSpec value);

} // CVSpecDerivation
