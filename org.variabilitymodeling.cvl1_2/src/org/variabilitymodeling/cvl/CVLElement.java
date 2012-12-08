/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;

import org.variabilitymodeling.cvl.visitors.Visitable;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CVL Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getCVLElement()
 * @model
 * @generated
 */
public interface CVLElement extends Visitable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitCVLElement(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitCVLElement(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // CVLElement
