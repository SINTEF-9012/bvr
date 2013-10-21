/**
 */
package org.bangbangbang.cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VSpec Derivation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A VSpec derivation is a specification how to derive the resolution for a particular VSpec from resolutions for other VSpecs. When a VSpec derivation is specified for a VSpec the resolution model need not specify a resolution for it as it is calculated according to the VSpec derivation.</p><p></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.VSpecDerivation#getDerivedVSpec <em>Derived VSpec</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bangbangbang.cvl.CvlPackage#getVSpecDerivation()
 * @model
 * @generated
 */
public interface VSpecDerivation extends VPackageable {
	/**
	 * Returns the value of the '<em><b>Derived VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The VSpec whose value is derived by this derivation.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Derived VSpec</em>' reference.
	 * @see #setDerivedVSpec(VSpec)
	 * @see org.bangbangbang.cvl.CvlPackage#getVSpecDerivation_DerivedVSpec()
	 * @model ordered="false"
	 * @generated
	 */
	VSpec getDerivedVSpec();

	/**
	 * Sets the value of the '{@link org.bangbangbang.cvl.VSpecDerivation#getDerivedVSpec <em>Derived VSpec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived VSpec</em>' reference.
	 * @see #getDerivedVSpec()
	 * @generated
	 */
	void setDerivedVSpec(VSpec value);

} // VSpecDerivation
