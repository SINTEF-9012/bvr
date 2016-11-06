/**
 */
package dvlconfig;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dvlconfig.Config#getOperators <em>Operators</em>}</li>
 *   <li>{@link dvlconfig.Config#getResources <em>Resources</em>}</li>
 *   <li>{@link dvlconfig.Config#getOriginal <em>Original</em>}</li>
 *   <li>{@link dvlconfig.Config#getGoals <em>Goals</em>}</li>
 *   <li>{@link dvlconfig.Config#getRealop <em>Realop</em>}</li>
 * </ul>
 * </p>
 *
 * @see dvlconfig.DvlconfigPackage#getConfig()
 * @model
 * @generated
 */
public interface Config extends EObject {
	/**
	 * Returns the value of the '<em><b>Operators</b></em>' containment reference list.
	 * The list contents are of type {@link dvlconfig.Operator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' containment reference list.
	 * @see dvlconfig.DvlconfigPackage#getConfig_Operators()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Operator> getOperators();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link dvlconfig.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see dvlconfig.DvlconfigPackage#getConfig_Resources()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Resource> getResources();

	/**
	 * Returns the value of the '<em><b>Original</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original</em>' containment reference.
	 * @see #setOriginal(Original)
	 * @see dvlconfig.DvlconfigPackage#getConfig_Original()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Original getOriginal();

	/**
	 * Sets the value of the '{@link dvlconfig.Config#getOriginal <em>Original</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original</em>' containment reference.
	 * @see #getOriginal()
	 * @generated
	 */
	void setOriginal(Original value);

	/**
	 * Returns the value of the '<em><b>Goals</b></em>' containment reference list.
	 * The list contents are of type {@link dvlconfig.Goal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goals</em>' containment reference list.
	 * @see dvlconfig.DvlconfigPackage#getConfig_Goals()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Goal> getGoals();

	/**
	 * Returns the value of the '<em><b>Realop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realop</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realop</em>' containment reference.
	 * @see #setRealop(Realop)
	 * @see dvlconfig.DvlconfigPackage#getConfig_Realop()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Realop getRealop();

	/**
	 * Sets the value of the '{@link dvlconfig.Config#getRealop <em>Realop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realop</em>' containment reference.
	 * @see #getRealop()
	 * @generated
	 */
	void setRealop(Realop value);

} // Config
