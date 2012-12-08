/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.Substitution#getReplacementInstance <em>Replacement Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getSubstitution()
 * @model abstract="true"
 *        annotation="doc description='Substitution is the general notion of variability specifications that specify a substitution to be done on the copy of the base model.' semantics='If replacementInstance is specified, the placement from this instance will be used. Further semantics of the substitution is given by its specializations.'"
 * @generated
 */
public interface Substitution extends ExecutablePrimitive {
	/**
	 * Returns the value of the '<em><b>Replacement Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replacement Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replacement Instance</em>' reference.
	 * @see #setReplacementInstance(ReplacementFragmentReference)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getSubstitution_ReplacementInstance()
	 * @model annotation="doc description='Points to the ReplacementFragmentReference, which stores a given instance of a replacement fragment to be used in the substitution.'"
	 * @generated
	 */
	ReplacementFragmentReference getReplacementInstance();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.Substitution#getReplacementInstance <em>Replacement Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replacement Instance</em>' reference.
	 * @see #getReplacementInstance()
	 * @generated
	 */
	void setReplacementInstance(ReplacementFragmentReference value);

} // Substitution
