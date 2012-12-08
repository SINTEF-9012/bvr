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
 * A representation of the model object '<em><b>AND </b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getAND_()
 * @model annotation="doc description='Specifies an AND expression.' semantics='Evaluates to true if both expressions are true.'"
 * @generated
 */
public interface AND_ extends Binary {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitAND_(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitAND_(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // AND_
