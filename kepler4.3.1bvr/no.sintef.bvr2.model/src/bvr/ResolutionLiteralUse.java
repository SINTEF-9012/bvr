/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolution Literal Use</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>The use of a resolution literal. This is like an instance of a resolution type.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.ResolutionLiteralUse#getDefLiteral <em>Def Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getResolutionLiteralUse()
 * @model
 * @generated
 */
public interface ResolutionLiteralUse extends ChoiceResolution {
	/**
	 * Returns the value of the '<em><b>Def Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Referring to the resolution literal definition of this use</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Def Literal</em>' reference.
	 * @see #setDefLiteral(ResolutionLiteralDefinition)
	 * @see bvr.BvrPackage#getResolutionLiteralUse_DefLiteral()
	 * @model ordered="false"
	 * @generated
	 */
	ResolutionLiteralDefinition getDefLiteral();

	/**
	 * Sets the value of the '{@link bvr.ResolutionLiteralUse#getDefLiteral <em>Def Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Def Literal</em>' reference.
	 * @see #getDefLiteral()
	 * @generated
	 */
	void setDefLiteral(ResolutionLiteralDefinition value);

} // ResolutionLiteralUse
