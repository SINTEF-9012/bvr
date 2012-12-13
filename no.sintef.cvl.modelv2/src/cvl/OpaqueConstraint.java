/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opaque Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A Constraint imposes additional restrictions that cannot be expressed in the base language. Each constraint has associated a VSpec context. It allows expressing universal quantification without explicit quantification phrases such as ''for all elements belonging to...'. Constraints written in a context are applied to each named VSpec that is available in this context.</p><p>The full constraint language (with classifiers) has set semantics for all non-propositional expressions (VSpecs, Integers, etc.). The small language (without classifiers) relies mostly on propositional formulas. A Constraint contains GeneralExpressions, which are always expected to evaluate to a boolean value. In case of set semantics GeneralExpressions are always LogicalExps, while in the small language they are LogicalExps or VSpecReferences. In the small language VSpecReferences have propositional semantics and are treated as Boolean choices.</p><p>####CVLSemanticStart####</p><p><b></b>Invariant :<b></b> Each constraint must have a VSpec context</p><p><b></b>OCL :<b></b></p><p>-- Constraint</p><p>-- Each Constraint must have a VSpec context</p><p>context Constraint :</p><p>inv hasAVSpecContext :</p><p>not (self._context == (null))</p><p>####CVLSemanticEnd####</p><p></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.OpaqueConstraint#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link cvl.OpaqueConstraint#getConstraintLanguage <em>Constraint Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getOpaqueConstraint()
 * @model
 * @generated
 */
public interface OpaqueConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Constraint as an opaque String.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraint</em>' attribute.
	 * @see #setConstraint(String)
	 * @see cvl.cvlPackage#getOpaqueConstraint_Constraint()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getConstraint();

	/**
	 * Sets the value of the '{@link cvl.OpaqueConstraint#getConstraint <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' attribute.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(String value);

	/**
	 * Returns the value of the '<em><b>Constraint Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Language of the OpaqueConstraint as a String.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraint Language</em>' attribute.
	 * @see #setConstraintLanguage(String)
	 * @see cvl.cvlPackage#getOpaqueConstraint_ConstraintLanguage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getConstraintLanguage();

	/**
	 * Sets the value of the '{@link cvl.OpaqueConstraint#getConstraintLanguage <em>Constraint Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Language</em>' attribute.
	 * @see #getConstraintLanguage()
	 * @generated
	 */
	void setConstraintLanguage(String value);

} // OpaqueConstraint
