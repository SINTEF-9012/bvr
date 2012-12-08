/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.visitors.impl;



import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;
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
import org.variabilitymodeling.cvl.visitors.TopDownVisitor;
import org.variabilitymodeling.cvl.visitors.VisitorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Down Visitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class TopDownVisitorImpl<ContextType, ResultType> extends EObjectImpl implements TopDownVisitor<ContextType, ResultType> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopDownVisitorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisitorsPackage.Literals.TOP_DOWN_VISITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitCVLModel(CVLModel node, ContextType context) {
		if (node.getVariabilitySpecification() != null) { node.getVariabilitySpecification().accept(this, context); }
		for (int i=0; i<node.getResolutionSpecification().size(); i++) { ((org.variabilitymodeling.cvl.ResolutionSpecification)node.getResolutionSpecification().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitReferenceSubstitution(ReferenceSubstitution node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitValueSubstitution(ValueSubstitution node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitFragmentSubstitution(FragmentSubstitution node, ContextType context) {
		for (int i=0; i<node.getBoundaryElementBinding().size(); i++) { ((org.variabilitymodeling.cvl.BoundaryElementBinding)node.getBoundaryElementBinding().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitPlacementFragment(PlacementFragment node, ContextType context) {
		for (int i=0; i<node.getBoundaryElement().size(); i++) { ((org.variabilitymodeling.cvl.PlacementBoundaryElement)node.getBoundaryElement().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ResultType visitReplacementFragment(ReplacementFragment node, ContextType context) {
		for (int i=0; i<node.getBoundaryElement().size(); i++) { ((org.variabilitymodeling.cvl.ReplacementBoundaryElement)node.getBoundaryElement().get(i)).accept(this, context); }
	//	for (int i=0; i<node.getPlacements().size(); i++) { ((cvl.PlacementLiteral)node.getPlacements().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitFromPlacement(FromPlacement node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitToPlacement(ToPlacement node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitToReplacement(ToReplacement node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitFromReplacement(FromReplacement node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitCVLElement(CVLElement node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitToBinding(ToBinding node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitFromBinding(FromBinding node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitCompositeVariability(CompositeVariability node, ContextType context) {
		for (int i=0; i<node.getVariabilitySpecification().size(); i++) { ((org.variabilitymodeling.cvl.VariabilitySpecification)node.getVariabilitySpecification().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitPlacementValue(PlacementValue node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitPlacementObject(PlacementObject node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitReplacementValue(ReplacementValue node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitReplacementObject(ReplacementObject node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitResolutionElement(ResolutionElement node, ContextType context) {
		for (int i=0; i<node.getResolution().size(); i++) { ((org.variabilitymodeling.cvl.IteratorResolution)node.getResolution().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitType(Type node, ContextType context) {
		if (node.getBody() != null) { node.getBody().accept(this, context); }
		if (node.getReplacement() != null) { node.getReplacement().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitInvocation(Invocation node, ContextType context) {
		if (node.getResolutionSpecification() != null) { node.getResolutionSpecification().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitIteratorResolution(IteratorResolution node, ContextType context) {
		for (int i=0; i<node.getChoice().size(); i++) { ((org.variabilitymodeling.cvl.ResolutionElement)node.getChoice().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitIterator(Iterator node, ContextType context) {
		for (int i=0; i<node.getVariabilitySpecification().size(); i++) { ((org.variabilitymodeling.cvl.VariabilitySpecification)node.getVariabilitySpecification().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitReplacementFragmentReference(ReplacementFragmentReference node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitAssignment(Assignment node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitConstraint(Constraint node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitNOT(NOT node, ContextType context) {
		if (node.getTerm() != null) { node.getTerm().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitOR(OR node, ContextType context) {
		if (node.getLeft() != null) { node.getLeft().accept(this, context); }
		if (node.getRight() != null) { node.getRight().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitIMPLIES(IMPLIES node, ContextType context) {
		if (node.getLeft() != null) { node.getLeft().accept(this, context); }
		if (node.getRight() != null) { node.getRight().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitExecutablePrimitiveTerm(ExecutablePrimitiveTerm node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitAND_(AND_ node, ContextType context) {
		if (node.getLeft() != null) { node.getLeft().accept(this, context); }
		if (node.getRight() != null) { node.getRight().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitResolutionValue(ResolutionValue node, ContextType context) {
		for (int i=0; i<node.getResolution().size(); i++) { ((org.variabilitymodeling.cvl.IteratorResolution)node.getResolution().get(i)).accept(this, context); }
		return null;
		
	}

} //TopDownVisitorImpl
