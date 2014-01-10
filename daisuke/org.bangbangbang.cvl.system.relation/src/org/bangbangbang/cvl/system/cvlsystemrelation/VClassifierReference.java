/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation;

import org.bangbangbang.cvl.VClassifier;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VClassifier Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference#getQuantifier <em>Quantifier</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference#getVclassifier <em>Vclassifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getVClassifierReference()
 * @model
 * @generated
 */
public interface VClassifierReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Quantifier</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bangbangbang.cvl.system.cvlsystemrelation.Quantifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantifier</em>' attribute.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.Quantifier
	 * @see #setQuantifier(Quantifier)
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getVClassifierReference_Quantifier()
	 * @model required="true"
	 * @generated
	 */
	Quantifier getQuantifier();

	/**
	 * Sets the value of the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference#getQuantifier <em>Quantifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantifier</em>' attribute.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.Quantifier
	 * @see #getQuantifier()
	 * @generated
	 */
	void setQuantifier(Quantifier value);

	/**
	 * Returns the value of the '<em><b>Vclassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vclassifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vclassifier</em>' reference.
	 * @see #setVclassifier(VClassifier)
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getVClassifierReference_Vclassifier()
	 * @model required="true"
	 * @generated
	 */
	VClassifier getVclassifier();

	/**
	 * Sets the value of the '{@link org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference#getVclassifier <em>Vclassifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vclassifier</em>' reference.
	 * @see #getVclassifier()
	 * @generated
	 */
	void setVclassifier(VClassifier value);

} // VClassifierReference
