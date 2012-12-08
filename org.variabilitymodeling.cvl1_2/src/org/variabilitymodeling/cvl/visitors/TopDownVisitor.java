/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.visitors;

import org.variabilitymodeling.cvl.AND_;
import org.variabilitymodeling.cvl.Assignment;
import org.variabilitymodeling.cvl.CVLElement;
import org.variabilitymodeling.cvl.CVLModel;
import org.variabilitymodeling.cvl.CompositeResolution;
import org.variabilitymodeling.cvl.CompositeVariability;
import org.variabilitymodeling.cvl.Constraint;
import org.variabilitymodeling.cvl.ExecutablePrimitiveTerm;
import org.variabilitymodeling.cvl.FragmentSubstitution;
import org.variabilitymodeling.cvl.FromBinding;
import org.variabilitymodeling.cvl.FromPlacement;
import org.variabilitymodeling.cvl.FromReplacement;
import org.variabilitymodeling.cvl.IMPLIES;
import org.variabilitymodeling.cvl.Invocation;
import org.variabilitymodeling.cvl.Iterator;
import org.variabilitymodeling.cvl.IteratorResolution;
import org.variabilitymodeling.cvl.NOT;
import org.variabilitymodeling.cvl.OR;
import org.variabilitymodeling.cvl.PlacementFragment;
import org.variabilitymodeling.cvl.PlacementObject;
import org.variabilitymodeling.cvl.PlacementValue;
import org.variabilitymodeling.cvl.ReferenceSubstitution;
import org.variabilitymodeling.cvl.ReplacementFragment;
import org.variabilitymodeling.cvl.ReplacementFragmentBinding;
import org.variabilitymodeling.cvl.ReplacementFragmentReference;
import org.variabilitymodeling.cvl.ReplacementObject;
import org.variabilitymodeling.cvl.ReplacementValue;
import org.variabilitymodeling.cvl.ResolutionElement;
import org.variabilitymodeling.cvl.ResolutionValue;
import org.variabilitymodeling.cvl.ToBinding;
import org.variabilitymodeling.cvl.ToPlacement;
import org.variabilitymodeling.cvl.ToReplacement;
import org.variabilitymodeling.cvl.Type;
import org.variabilitymodeling.cvl.ValueSubstitution;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Top Down Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.variabilitymodeling.cvl.visitors.VisitorsPackage#getTopDownVisitor()
 * @model abstract="true"
 * @generated
 */
public interface TopDownVisitor<ContextType, ResultType> extends Visitor<ContextType, ResultType> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nif node.variabilitySpecification != void then node.variabilitySpecification.accept(self, context) end\nnode.resolutionSpecification.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (node.getVariabilitySpecification() != null) { node.getVariabilitySpecification().accept(this, context); }\nfor (int i=0; i<node.getResolutionSpecification().size(); i++) { ((cvl.ResolutionSpecification)node.getResolutionSpecification().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitCVLModel(CVLModel node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitReferenceSubstitution(ReferenceSubstitution node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitValueSubstitution(ValueSubstitution node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.boundaryElementBinding.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getBoundaryElementBinding().size(); i++) { ((cvl.BoundaryElementBinding)node.getBoundaryElementBinding().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitFragmentSubstitution(FragmentSubstitution node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.boundaryElement.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getBoundaryElement().size(); i++) { ((cvl.PlacementBoundaryElement)node.getBoundaryElement().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitPlacementFragment(PlacementFragment node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.boundaryElement.each{ e | e.accept(self, context) }\nnode.placements.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getBoundaryElement().size(); i++) { ((cvl.ReplacementBoundaryElement)node.getBoundaryElement().get(i)).accept(this, context); }\nfor (int i=0; i<node.getPlacements().size(); i++) { ((cvl.PlacementLiteral)node.getPlacements().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitReplacementFragment(ReplacementFragment node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitFromPlacement(FromPlacement node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitToPlacement(ToPlacement node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitToReplacement(ToReplacement node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitFromReplacement(FromReplacement node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitCVLElement(CVLElement node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitToBinding(ToBinding node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitFromBinding(FromBinding node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.variabilitySpecification.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getVariabilitySpecification().size(); i++) { ((cvl.VariabilitySpecification)node.getVariabilitySpecification().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitCompositeVariability(CompositeVariability node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitPlacementValue(PlacementValue node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitPlacementObject(PlacementObject node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitReplacementValue(ReplacementValue node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitReplacementObject(ReplacementObject node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.resolution.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getResolution().size(); i++) { ((cvl.IteratorResolution)node.getResolution().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitResolutionElement(ResolutionElement node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nif node.body != void then node.body.accept(self, context) end\nif node.replacement != void then node.replacement.accept(self, context) end\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (node.getBody() != null) { node.getBody().accept(this, context); }\nif (node.getReplacement() != null) { node.getReplacement().accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitType(Type node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nif node.resolutionSpecification != void then node.resolutionSpecification.accept(self, context) end\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (node.getResolutionSpecification() != null) { node.getResolutionSpecification().accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitInvocation(Invocation node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.choice.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getChoice().size(); i++) { ((cvl.ResolutionElement)node.getChoice().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitIteratorResolution(IteratorResolution node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.variabilitySpecification.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getVariabilitySpecification().size(); i++) { ((cvl.VariabilitySpecification)node.getVariabilitySpecification().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitIterator(Iterator node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitReplacementFragmentReference(ReplacementFragmentReference node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitAssignment(Assignment node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitConstraint(Constraint node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nif node.term != void then node.term.accept(self, context) end\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (node.getTerm() != null) { node.getTerm().accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitNOT(NOT node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nif node.left != void then node.left.accept(self, context) end\nif node.right != void then node.right.accept(self, context) end\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (node.getLeft() != null) { node.getLeft().accept(this, context); }\nif (node.getRight() != null) { node.getRight().accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitOR(OR node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nif node.left != void then node.left.accept(self, context) end\nif node.right != void then node.right.accept(self, context) end\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (node.getLeft() != null) { node.getLeft().accept(this, context); }\nif (node.getRight() != null) { node.getRight().accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitIMPLIES(IMPLIES node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitExecutablePrimitiveTerm(ExecutablePrimitiveTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nif node.left != void then node.left.accept(self, context) end\nif node.right != void then node.right.accept(self, context) end\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (node.getLeft() != null) { node.getLeft().accept(this, context); }\nif (node.getRight() != null) { node.getRight().accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitAND_(AND_ node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.resolution.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getResolution().size(); i++) { ((cvl.IteratorResolution)node.getResolution().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitResolutionValue(ResolutionValue node, ContextType context);

} // TopDownVisitor
