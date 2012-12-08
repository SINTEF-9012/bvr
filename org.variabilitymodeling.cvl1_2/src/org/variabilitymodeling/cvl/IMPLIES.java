/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;

import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IMPLIES</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getIMPLIES()
 * @model annotation="doc description='Specifies an IMPLIES expression.' semantics='The left expression implies the right expression.'"
 * @generated
 */
public interface IMPLIES extends Binary {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitIMPLIES(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitIMPLIES(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // IMPLIES
