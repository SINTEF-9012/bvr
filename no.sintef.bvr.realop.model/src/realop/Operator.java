/**
 */
package realop;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link realop.Operator#getName <em>Name</em>}</li>
 *   <li>{@link realop.Operator#getExpPre <em>Exp Pre</em>}</li>
 *   <li>{@link realop.Operator#getExpPost <em>Exp Post</em>}</li>
 * </ul>
 * </p>
 *
 * @see realop.RealopPackage#getOperator()
 * @model
 * @generated
 */
public interface Operator extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see realop.RealopPackage#getOperator_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link realop.Operator#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Exp Pre</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp Pre</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp Pre</em>' containment reference.
	 * @see #setExpPre(Expression)
	 * @see realop.RealopPackage#getOperator_ExpPre()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpPre();

	/**
	 * Sets the value of the '{@link realop.Operator#getExpPre <em>Exp Pre</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp Pre</em>' containment reference.
	 * @see #getExpPre()
	 * @generated
	 */
	void setExpPre(Expression value);

	/**
	 * Returns the value of the '<em><b>Exp Post</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp Post</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp Post</em>' containment reference.
	 * @see #setExpPost(Expression)
	 * @see realop.RealopPackage#getOperator_ExpPost()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpPost();

	/**
	 * Sets the value of the '{@link realop.Operator#getExpPost <em>Exp Post</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp Post</em>' containment reference.
	 * @see #getExpPost()
	 * @generated
	 */
	void setExpPost(Expression value);

} // Operator
