/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation;

import org.bangbangbang.cvl.VPackageable;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CVL Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference#getRelations <em>Relations</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference#getCvl <em>Cvl</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getCVLReference()
 * @model
 * @generated
 */
public interface CVLReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
	 * The list contents are of type {@link org.bangbangbang.cvl.system.cvlsystemrelation.VSpecRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' containment reference list.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getCVLReference_Relations()
	 * @model containment="true"
	 * @generated
	 */
	EList<VSpecRelation> getRelations();

	/**
	 * Returns the value of the '<em><b>Cvl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cvl</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cvl</em>' reference.
	 * @see #setCvl(VPackageable)
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getCVLReference_Cvl()
	 * @model
	 * @generated
	 */
	VPackageable getCvl();

	/**
	 * Sets the value of the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference#getCvl <em>Cvl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cvl</em>' reference.
	 * @see #getCvl()
	 * @generated
	 */
	void setCvl(VPackageable value);

} // CVLReference
