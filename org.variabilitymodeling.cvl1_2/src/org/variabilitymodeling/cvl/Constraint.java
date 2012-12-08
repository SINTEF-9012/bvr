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
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getConstraint()
 * @model annotation="doc description='Constraint is a way to describe restrictions to what resolutions can apply.' semantics='The CVL model will be validated using the specified constraints.'"
 * @generated
 */
public interface Constraint extends Declaration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitConstraint(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitConstraint(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // Constraint
