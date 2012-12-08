/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;


import org.eclipse.emf.common.util.EList;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.Iterator#getUpperLimit <em>Upper Limit</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.Iterator#getLowerLimit <em>Lower Limit</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.Iterator#isIsUnique <em>Is Unique</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getIterator()
 * @model annotation="doc description='An iterator is a special kind of composite variability. While the execution of an ordinary composite variability may execute all the executable primitives of the composite variability, an iterator may impose restrictions on the number of executable primitives to be executed. Resolution specifications specify which of the executable primitives to execute.' semantics='The execution of an iterator implies the execution of a number of its contained executable primitives. The number is defined by the pair (lowerLimit, upperLimit):\r\n\r\n(0,1): none or at most one of the executable primitives can be chosen (by a resolution specification)to be executed.\r\n\r\n(1,1): exactly one of the executable primitives can be chosen (by a resolution specification)to be executed.\r\n\r\n(m,n): at least m and at most n executable primitives can be chosen (by a resolution specification)for execution; if isUnique is true then each executable primitive can only be executed once.\r\n\r\n(0,*): any number of the executable primitives can be executed; if isUnique is true then each executable primitive can only be executed once.' constraint='In case of (0,*) the value of isUnique must be specifified.'"
 * @generated
 */
public interface Iterator extends CompositeVariability {
	/**
	 * Returns the value of the '<em><b>Upper Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Limit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Limit</em>' attribute.
	 * @see #setUpperLimit(int)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getIterator_UpperLimit()
	 * @model annotation="doc description='Restricts the number of possible executions to an upper limit.'"
	 * @generated
	 */
	int getUpperLimit();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.Iterator#getUpperLimit <em>Upper Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Limit</em>' attribute.
	 * @see #getUpperLimit()
	 * @generated
	 */
	void setUpperLimit(int value);

	/**
	 * Returns the value of the '<em><b>Lower Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Limit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Limit</em>' attribute.
	 * @see #setLowerLimit(int)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getIterator_LowerLimit()
	 * @model annotation="doc description='Restricts the number of possible executions to a lower limit.'"
	 * @generated
	 */
	int getLowerLimit();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.Iterator#getLowerLimit <em>Lower Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Limit</em>' attribute.
	 * @see #getLowerLimit()
	 * @generated
	 */
	void setLowerLimit(int value);

	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(boolean)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getIterator_IsUnique()
	 * @model annotation="doc description='Defines whether each executable primitive can only be executed once.'"
	 * @generated
	 */
	boolean isIsUnique();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.Iterator#isIsUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #isIsUnique()
	 * @generated
	 */
	void setIsUnique(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitIterator(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitIterator(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // Iterator
