/**
 */
package bvr;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     A ValueSpecification specifies a value which is either primitive, or an object of the base mode,&nbsp;or a fragment of
 *     the base model.&nbsp;
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.ValueSpecification#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getValueSpecification()
 * @model abstract="true"
 * @generated
 */
public interface ValueSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The type of the ValueSpecification.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Variabletype)
	 * @see bvr.BvrPackage#getValueSpecification_Type()
	 * @model required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Variabletype getType();

	/**
	 * Sets the value of the '{@link bvr.ValueSpecification#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Variabletype value);

} // ValueSpecification
