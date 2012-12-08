/**
 */
package cvl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>An named element is an element identifiable by name. Names are composed of letters, numbers, the underscore sign "_" and the dollar sign "$". The first character of a name must be a letter, an underscore or a dollar sign. Reserved keywords of the constraint language cannot be used as identifiers.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.NamedElement#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The name of the element. Names are composed of letters, numbers, the underscore sign "_"  and the dollar sign "$". The first character of a name must be a letter, an underscore or a dollar sign.  Reserved keywords of the constraint language cannot be used as identifiers.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see cvl.cvlPackage#getNamedElement_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cvl.NamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // NamedElement
