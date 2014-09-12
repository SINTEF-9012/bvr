package no.sintef.bvr.ui.editor.commands;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IEditorReference;

import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.BVRModel;
import bvr.BoundaryElementBinding;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.Constraint;
//import bvr.Constraint;
import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.ObjectHandle;
import bvr.PlacementBoundaryElement;
import bvr.PlacementFragment;
import bvr.PosResolution;
//import bvr.PrimitveType;
import bvr.ReplacementBoundaryElement;
import bvr.ReplacementFragmentType;
import bvr.ToBinding;
import bvr.ToPlacement;
import bvr.ToReplacement;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VPackageable;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.Variable;
import bvr.Variabletype;
import bvr.VariationPoint;

public interface EditorCommands {
	
	public void addChoice(Choice choice, BVRModel bvrModel);
	
	public void addChoice(Choice choice, CompoundNode compoundNode);
	
	public TransactionalEditingDomain testTransactionalEditingDomain();
	
	public boolean testXMIResourceUnload(XMIResource resource, IEditorReference[] editorReferences);
	
	public void createNewResolution(PosResolution pr, BVRModel bvrModel);
	
	//public void setResolutionDecision(ChoiceResolutuion cr, boolean decision);
	
	//public void setChoiceResolvedVSpec(ChoiceResolutuion cr, Choice choice);
	
	//public void addChoiceResolved(Choice target, VSpecResolution vsper, ChoiceResolutuion cr);
	
	public void addVClassifierToVSpec(CompoundNode parentCompundNode, VClassifier childCClassifier);
	
	//public void addVClassifierToConfigurableUnit(ConfigurableUnit cu, VClassifier childCClassifier);
	public void addVClassifierToBVRModel(BVRModel bvrModel, VClassifier childClassifier);
	
	//public void addBCLConstraint(ConfigurableUnit cu, BCLConstraint constraint);
	
	//public void addVariableType(ConfigurableUnit cu, PrimitveType primType);
	
	public void addVariable(VSpec vSpec, Variable variable);
	
	//public void addVariableValueAssignment(VSpecResolution parentVSpecResolution, VariableValueAssignment varValueAssignment);
	
	//public void addVInstance(VSpecResolution parentVSpecResolution, VInstance vInstance);
	
	public void removeNamedElementVSpec(VSpec parentVSpec, NamedElement namedElement);
	
	public void removeVNodeCompoundNode(CompoundNode compoundNode, VNode vNode);
	
	//public void removeOwnedVSpecConfigurableUnit(ConfigurableUnit cu, NamedElement namedElement);
	
	public void addVSpecToVSpec(VSpec parentVSpec, VSpec childVSpec);

	//public void addVSpecToConfigurableUnit(ConfigurableUnit cu, VSpec childVSpec);
	
	//public void removeConstraintConfigurableUnit(ConfigurableUnit cu, NamedElement namedElement);
	
	//public void removeAllConstraintConfigurableUnit(ConfigurableUnit cu, List<Constraint> constraints);
	
	public void setName(NamedElement namedElement, String name);
	
	public void setVSpecComment(VSpec vSpec, String comment);
	
	public void setIsImpliedByParent(Choice choice, boolean isImplied);
	
	public void setVSpecGroupMultiplicity(VSpec vSpec, MultiplicityInterval eObject);
	
	public void setGroupMultiplicityUpperBound(MultiplicityInterval mInterval, int upperBound);
	
	public void setGroupMultiplicityLowerBound(MultiplicityInterval mInterval, int lowerBound);

	public void setTypeForVariable(Variable variable, Variabletype variableType);
	
	public void clearBCLConstraintExpressions(BCLConstraint constraint);
	
	public void addBCLExpressionConstraint(BCLConstraint constraint, BCLExpression expression);
	
	public void removeVSpecVariable(VSpec vSpec, Variable var);
	
	public void removeNamedElementVSpecResolution(VSpecResolution vSpecResolution, NamedElement namedElement);
	
	//public void removeOwnedVSpecResolutionConfigurableUnit(ConfigurableUnit cu, NamedElement namedElement);
	
	//public void removeOwnedVSpecResolutions(ConfigurableUnit cu);
	
	//public void addOwnedVSpecResolutionConfigurableUnit(ConfigurableUnit cu, VSpecResolution vSpecResolution);
	
	//public void addOwnedVSpecResolutionsConfigurableUnit(ConfigurableUnit cu, EList<VSpecResolution> vSpecResolutions);
	
	//public void addOwnedVariationPoint(ConfigurableUnit cu, VariationPoint variationPoint);
	
	//public void addOwnedVariationType(ConfigurableUnit cu, Variabletype variationType);
	
	//public void removeOwenedVariationPoint(ConfigurableUnit cu, VariationPoint variationPoint);
	
	//public void removeOwnedVariationType(ConfigurableUnit cu, Variabletype variationType);
	
	//public void removeOwenedVariationPoints(ConfigurableUnit cu, EList<VariationPoint> variationPoints);
	
	//public void removeOwnedVariationTypes(ConfigurableUnit cu, EList<Variabletype> variationTypes);
	
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
}
