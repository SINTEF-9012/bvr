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
 * A representation of the model object '<em><b>OR</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getOR()
 * @model annotation="doc description='Specifies an OR expression.' semantics='Evaluates to true if at least one of the expressions is true.'"
 * @generated
 */
public interface OR extends Binary {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitOR(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitOR(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // OR
