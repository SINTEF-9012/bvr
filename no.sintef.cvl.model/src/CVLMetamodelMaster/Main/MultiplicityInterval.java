/**
 */
package CVLMetamodelMaster.Main;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity Interval</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A MultiplicityInterval specifies lower and upper multiplicities.</p><p>####CVLSemanticStart####</p><p><b></b>Invariant :<b></b> The value of the lower multiplicity must be inferior or equal to the upper multiplicity</p><p><b></b>OCL :<b></b></p><p>-- MultiplicityInterval</p><p>-- lower_inferior_upper : The value of the lower multiplicity must be inferior or equal to the upper multiplicity</p><p>context MultiplicityInterval :</p><p>inv lower_inferior_upper :</p><p>(self.upper == (-1))</p><p>or (self.lower &lt;&gt; -1 and self.upper &lt;&gt; -1 and self.lower &lt;= self.upper)</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.MultiplicityInterval#getUpper <em>Upper</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.MultiplicityInterval#getLower <em>Lower</em>}</li>
 * </ul>
 * </p>
 *
 * @see CVLMetamodelMaster.Main.MainPackage#getMultiplicityInterval()
 * @model
 * @generated
 */
public interface MultiplicityInterval extends EObject {
	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     The upper multiplicity.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(int)
	 * @see CVLMetamodelMaster.Main.MainPackage#getMultiplicityInterval_Upper()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getUpper();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.MultiplicityInterval#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(int value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     The lower multiplicity.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(int)
	 * @see CVLMetamodelMaster.Main.MainPackage#getMultiplicityInterval_Lower()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getLower();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.MultiplicityInterval#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(int value);

} // MultiplicityInterval
