/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.visitors;


import org.eclipse.emf.ecore.EObject;
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
 * A representation of the model object '<em><b>Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.variabilitymodeling.cvl.visitors.VisitorsPackage#getVisitor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Visitor<ContextType, ResultType> extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitCVLModel(CVLModel node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitReferenceSubstitution(ReferenceSubstitution node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitValueSubstitution(ValueSubstitution node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitFragmentSubstitution(FragmentSubstitution node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitPlacementFragment(PlacementFragment node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitReplacementFragment(ReplacementFragment node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitFromPlacement(FromPlacement node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitToPlacement(ToPlacement node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitToReplacement(ToReplacement node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitFromReplacement(FromReplacement node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitCVLElement(CVLElement node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitToBinding(ToBinding node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitFromBinding(FromBinding node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitCompositeVariability(CompositeVariability node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitPlacementValue(PlacementValue node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitPlacementObject(PlacementObject node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitReplacementValue(ReplacementValue node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitReplacementObject(ReplacementObject node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitResolutionElement(ResolutionElement node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitType(Type node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitInvocation(Invocation node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitIteratorResolution(IteratorResolution node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitIterator(Iterator node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitReplacementFragmentReference(ReplacementFragmentReference node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitAssignment(Assignment node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitConstraint(Constraint node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitNOT(NOT node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitOR(OR node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitIMPLIES(IMPLIES node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitExecutablePrimitiveTerm(ExecutablePrimitiveTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitAND_(AND_ node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitResolutionValue(ResolutionValue node, ContextType context);

} // Visitor
