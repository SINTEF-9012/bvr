/**
 */
package cvl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OVP Semantic Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>OVPSermanticSpec describes a transformation which will be performed by an OpaqueVariationPoint. The transformation is given as a string containing a textual definition of the transformation in the given transformation language. The transformation language is also given in the OVPSemanticSpec.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.OVPSemanticSpec#getModelTransformation <em>Model Transformation</em>}</li>
 *   <li>{@link cvl.OVPSemanticSpec#getTransfromationLanguage <em>Transfromation Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getOVPSemanticSpec()
 * @model
 * @generated
 */
public interface OVPSemanticSpec extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Transformation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Model Transformation specification as String.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Transformation</em>' attribute.
	 * @see #setModelTransformation(String)
	 * @see cvl.cvlPackage#getOVPSemanticSpec_ModelTransformation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getModelTransformation();

	/**
	 * Sets the value of the '{@link cvl.OVPSemanticSpec#getModelTransformation <em>Model Transformation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Transformation</em>' attribute.
	 * @see #getModelTransformation()
	 * @generated
	 */
	void setModelTransformation(String value);

	/**
	 * Returns the value of the '<em><b>Transfromation Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Language of the model transformation.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Transfromation Language</em>' attribute.
	 * @see #setTransfromationLanguage(String)
	 * @see cvl.cvlPackage#getOVPSemanticSpec_TransfromationLanguage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getTransfromationLanguage();

	/**
	 * Sets the value of the '{@link cvl.OVPSemanticSpec#getTransfromationLanguage <em>Transfromation Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transfromation Language</em>' attribute.
	 * @see #getTransfromationLanguage()
	 * @generated
	 */
	void setTransfromationLanguage(String value);

} // OVPSemanticSpec
