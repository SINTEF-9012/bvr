package no.sintef.bvr.ui.editor.commands;


import no.sintef.bvr.common.command.SimpleExeCommandInterface;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IEditorReference;

import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.BVRModel;
import bvr.BoundaryElementBinding;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.CompoundNode;
import bvr.CompoundResolution;
import bvr.Constraint;
import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.Note;
import bvr.ObjectHandle;
import bvr.PlacementBoundaryElement;
import bvr.PlacementFragment;
import bvr.PosResolution;
import bvr.PrimitiveValueSpecification;
import bvr.ReplacementBoundaryElement;
import bvr.ReplacementFragmentType;
import bvr.Target;
import bvr.ToBinding;
import bvr.ToPlacement;
import bvr.ToReplacement;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VPackageable;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.ValueResolution;
import bvr.Variable;
import bvr.Variabletype;
import bvr.VariationPoint;

public interface EditorCommands {
	
	public void addChoice(Choice choice, BVRModel bvrModel);
	
	public void addChoice(Choice choice, CompoundNode compoundNode);
	
	public TransactionalEditingDomain testTransactionalEditingDomain();
	
	public boolean testXMIResourceUnload(XMIResource resource, IEditorReference[] editorReferences);
	
	public void setChoiceResolvedVSpec(ChoiceResolution cr, Choice choice);
	
	public void addChoiceResoulution(VSpecResolution vsper, ChoiceResolution pr);
	
	public void addVClassifierToVSpec(CompoundNode parentCompundNode, VClassifier childCClassifier);
	
	public void addVClassifierToBVRModel(BVRModel bvrModel, VClassifier childClassifier);
	
	public void addVNodeToCompoundNode(CompoundNode parent, VNode child);
	
	public void addVariabilityModelToBVRModel(BVRModel model, CompoundNode compoundNode);
	
	public void addVariable(VNode parentVNode, Variable variable);
	
	public void removeVNodeCompoundNode(CompoundNode compoundNode, VNode vNode);
	
	public void setName(NamedElement namedElement, String name);
	
	public void setIsImpliedByParent(Choice choice, boolean isImplied);
	
	public void setVNodeGroupMultiplicity(VNode vNode, MultiplicityInterval eObject);
	
	public void setGroupMultiplicityUpperBound(MultiplicityInterval mInterval, int upperBound);
	
	public void setGroupMultiplicityLowerBound(MultiplicityInterval mInterval, int lowerBound);

	public void setTypeForVariable(Variable variable, Variabletype variableType);
	
	public void clearBCLConstraintExpressions(BCLConstraint constraint);
	
	public void addBCLExpressionConstraint(BCLConstraint constraint, BCLExpression expression);
	
	public void removeVSpecVariable(VSpec vSpec, Variable var);
	
	public void removeNamedElementVSpecResolution(VSpecResolution vSpecResolutionParent, NamedElement namedElement);
	
	public void addRealizationVariationPoint(BVRModel model, VariationPoint variationPoint);
	
	public void addOwnedVariationType(BVRModel model, Variabletype variationType);
	
	public void removeOwenedVariationPoints(BVRModel model, EList<VariationPoint> variationPoints);
	
	public void removeOwnedVariationTypes(BVRModel model, EList<Variabletype> variationTypes);
	
	public void addBoudaryElementBinding(FragmentSubstitution fragmentSubsitution, BoundaryElementBinding boundaryElementBinding);
	
	public void addBoudaryElementBindings(FragmentSubstitution fragmentSubsitution, EList<BoundaryElementBinding> boundaryElementBindings);
	
	public void removeBoudaryElementBinding(FragmentSubstitution fragmentSubsitution, BoundaryElementBinding boundaryElementBinding);
	
	public void removeBoudaryElementBindings(FragmentSubstitution fragmentSubsitution, EList<BoundaryElementBinding> boundaryElementBindings);
	
	public void clearBoudaryElementBindings(FragmentSubstitution fragmentSubsitution);
	
	public void setBindingVariationPoint(VariationPoint variationPoint, VSpec vSpec);
	
	public void setToBindingToReplacement(ToBinding toBinding, ToReplacement toReplacement);
	
	public void setFromBindingFromPlacement(FromBinding fromBinding, FromPlacement fromPlacement);
	
	public void addObjectHandlePlacement(PlacementFragment placement, ObjectHandle objectHandle);
	
	public void addObjectHandleReplacement(ReplacementFragmentType replacement, ObjectHandle objectHandle);
	
	public void addPlacementBoundaryElement(PlacementFragment placement, PlacementBoundaryElement boundary);
	
	public void addReplacementBoundaryElement(ReplacementFragmentType replacement, ReplacementBoundaryElement boundary);
	
	public void clearInsideBElementToPlacement(ToPlacement boundary);
	
	public void addInsideBElementToPlacement(ToPlacement boundary, ObjectHandle objectHandle);
	
	public void addInsideBElementToPlacement(ToPlacement boundary, EList<ObjectHandle> objectHandle);


	public void removeConstraintCompoundNode(CompoundNode compoundNode, Constraint constraint);

	public void removeVariabilityModelBVRModel(BVRModel model, CompoundNode variabilityModel);
	
	public void addPackagableElementBVRModel(BVRModel model, VPackageable vPackagable);
	
	public VPackageable testPrimitiveTypes(BVRModel model);
	
	public void addBCLConstraintVNode(VNode vNode, BCLConstraint bclConstraint);

	public void createNote(NamedElement parent, Note commentNote);
	
	public void updateNoteExp(Note note, String expr);
	
	public void enableBatchProcessing();
	
	public void disableBatchProcessing();
	
	public void executeBatch();

	public void removeOwnedVSpecResolution(BVRModel bvrModel, VSpecResolution parent);

	void createNewResolution(PosResolution pr, BVRModel bvrModel);

	public void addTargetToCompoundNode(CompoundNode namedElement, Target target);

	public void setVSpecTarget(VSpec namedElement, Target target);

	public void reset();
	
	public void removeBVRModelCompoundResolutions(BVRModel model, EList<CompoundResolution> resolutions);

	public void addChoiceResoulution(VSpecResolution vsper, ChoiceResolution cr, int index);

	public void addValueResolution(CompoundResolution compountResolution, ValueResolution valueResolution);

	public void setPrimitiveValueBCLExpression(
			PrimitiveValueSpecification primitiveValue, BCLExpression expression);
	
	public void executeSimpleExeCommand(SimpleExeCommandInterface command);
}
