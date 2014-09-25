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
//import bvr.ChoiceResolutuion;
import bvr.CompoundNode;
import bvr.Constraint;
//import bvr.ConfigurableUnit;
import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.ObjectHandle;
import bvr.PlacementBoundaryElement;
import bvr.PlacementFragment;
import bvr.PosResolution;
import bvr.ReplacementBoundaryElement;
import bvr.ReplacementFragmentType;
import bvr.ToBinding;
import bvr.ToPlacement;
import bvr.ToReplacement;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VPackageable;
//import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.ValueSpecification;
import bvr.Variable;
//import bvr.VariableValueAssignment;
import bvr.Variabletype;
import bvr.VariationPoint;

public class EditorMVCCommands implements EditorCommands {
	
	static private EditorMVCCommands eINSTANCE = null;
	
	static public EditorMVCCommands Get(){
		if(eINSTANCE == null){
			eINSTANCE = new EditorMVCCommands();
		}
		return eINSTANCE;
	}

	/*@Override
	public void addChoice(Choice choice, ConfigurableUnit cu) {
		cu.getOwnedVSpec().add(choice);
	}*/

	/*@Override
	public void addChoice(Choice choice, VSpec vs) {
		vs.getChild().add(choice);
	}*/

	@Override
	public TransactionalEditingDomain testTransactionalEditingDomain() {
		throw new UnsupportedOperationException("Pure MVC does not support transactional model");
	}

	/*@Override
	public void createNewResolution(ChoiceResolutuion cr, ConfigurableUnit cu) {
		cu.getOwnedVSpecResolution().add(cr);
	}

	@Override
	public void setResolutionDecision(ChoiceResolutuion cr, boolean decision) {
		cr.setDecision(decision);	
	}

	@Override
	public void setChoiceResolvedVSpec(ChoiceResolutuion cr, Choice choice) {
		cr.setResolvedVSpec(choice);	
	}

	@Override
	public void addChoiceResolved(Choice target, VSpecResolution vsper, ChoiceResolutuion cr) {
		cr.setResolvedVSpec(target);
		vsper.getChild().add(cr);	
	}

	@Override
	public void addVClassifierToVSpec(VSpec parentVSpec, VClassifier childCClassifier) {
		parentVSpec.getChild().add(childCClassifier);
	}

	@Override
	public void addVClassifierToConfigurableUnit(ConfigurableUnit cu, VClassifier childCClassifier) {
		cu.getOwnedVSpec().add(childCClassifier);
	}

	@Override
	public void addBCLConstraint(ConfigurableUnit cu, BCLConstraint constraint) {
		cu.getOwnedConstraint().add(constraint);
	}

	@Override
	public void addVariableType(ConfigurableUnit cu, PrimitveType primType) {
		cu.getOwnedVariabletype().add(primType);
	}

	@Override
	public void addVariable(VSpec vSpec, Variable variable) {
		vSpec.getChild().add(variable);
	}

	@Override
	public void addVariableValueAssignment(VSpecResolution parentVSpecResolution, VariableValueAssignment varValueAssignment) {
		parentVSpecResolution.getChild().add(varValueAssignment);
	}

	@Override
	public void addVInstance(VSpecResolution parentVSpecResolution, VInstance vInstance) {
		parentVSpecResolution.getChild().add(vInstance);
	}

	@Override
	public void removeNamedElementVSpec(VSpec parentVSpec, NamedElement namedElement) {
		parentVSpec.getChild().remove(namedElement);
	}

	@Override
	public void removeOwnedVSpecConfigurableUnit(ConfigurableUnit cu, NamedElement namedElement) {
		cu.getOwnedVSpec().remove(namedElement);
	}

	@Override
	public void addVSpecToVSpec(VSpec parentVSpec, VSpec childVSpec) {
		parentVSpec.getChild().add(childVSpec);
	}

	@Override
	public void addVSpecToConfigurableUnit(ConfigurableUnit cu, VSpec childVSpec) {
		cu.getOwnedVSpec().add(childVSpec);
	}

	@Override
	public void removeConstraintConfigurableUnit(ConfigurableUnit cu, NamedElement namedElement) {
		cu.getOwnedConstraint().remove(namedElement);
	}

	@Override
	public void removeAllConstraintConfigurableUnit(ConfigurableUnit cu, List<Constraint> constraints) {
		cu.getOwnedConstraint().removeAll(constraints);
	}*/

	@Override
	public void setName(NamedElement namedElement, String name) {
		namedElement.setName(name);
	}

	@Override
	public void setVSpecComment(VSpec vSpec, String comment) {
		//vSpec.setComment(comment);
	}

	@Override
	public void setIsImpliedByParent(Choice choice, boolean isImplied) {
		choice.setIsImpliedByParent(isImplied);
	}
	
	@Override
	public void setVSpecGroupMultiplicity(VSpec vSpec, MultiplicityInterval eObject){
		//vSpec.setGroupMultiplicity(eObject);
	}
	
	@Override
	public void setGroupMultiplicityUpperBound(MultiplicityInterval mInterval, int upperBound){
		mInterval.setUpper(upperBound);
	}
	
	@Override
	public void setGroupMultiplicityLowerBound(MultiplicityInterval mInterval, int lowerBound){
		mInterval.setLower(lowerBound);
	}
	
	@Override
	public void setTypeForVariable(Variable variable, Variabletype variableType){
		variable.setType(variableType);
	}

	@Override
	public void clearBCLConstraintExpressions(BCLConstraint constraint) {
		constraint.getExpression().clear();
	}

	@Override
	public void addBCLExpressionConstraint(BCLConstraint constraint, BCLExpression expression) {
		constraint.getExpression().add(expression);
	}

/*	@Override
	public void removeVSpecVariable(VSpec vSpec, Variable var) {
		vSpec.getChild().remove(var);	
	}
	
	@Override
	public void removeNamedElementVSpecResolution(VSpecResolution vSpecResolution, NamedElement namedElement) {
		vSpecResolution.getChild().remove(namedElement);
	}

	@Override
	public void removeOwnedVSpecResolutionConfigurableUnit(ConfigurableUnit cu, NamedElement namedElement) {
		cu.getOwnedVSpecResolution().remove(namedElement);
	}
	
	@Override
	public void removeOwnedVSpecResolutions(ConfigurableUnit cu) {
		cu.getOwnedVSpecResolution().clear();
	}
	
	@Override
	public void addOwnedVSpecResolutionConfigurableUnit(ConfigurableUnit cu, VSpecResolution vSpecResolution){
		cu.getOwnedVSpecResolution().add(vSpecResolution);
	}

	@Override
	public void addOwnedVSpecResolutionsConfigurableUnit(ConfigurableUnit cu, EList<VSpecResolution> vSpecResolutions) {
		cu.getOwnedVSpecResolution().addAll(vSpecResolutions);
	}

	@Override
	public boolean testXMIResourceUnload(XMIResource resource, IEditorReference[] editorReferences) {
		throw new UnsupportedOperationException("not implemented for MVC editor");
	}
	
	@Override
	public void addOwnedVariationPoint(ConfigurableUnit cu, VariationPoint variationPoint){
		cu.getOwnedVariationPoint().add(variationPoint);
	}
	
	@Override
	public void addOwnedVariationType(ConfigurableUnit cu, Variabletype variationType) {
		cu.getOwnedVariabletype().add(variationType);
	}

	@Override
	public void removeOwenedVariationPoint(ConfigurableUnit cu, VariationPoint variationPoint) {
		cu.getOwnedVariationPoint().remove(variationPoint);
	}

	@Override
	public void removeOwnedVariationType(ConfigurableUnit cu, Variabletype variationType) {
		cu.getOwnedVariabletype().remove(variationType);
	}

	@Override
	public void removeOwenedVariationPoints(ConfigurableUnit cu, EList<VariationPoint> variationPoints) {
		cu.getOwnedVariationPoint().removeAll(variationPoints);
	}

	@Override
	public void removeOwnedVariationTypes(ConfigurableUnit cu, EList<Variabletype> variationTypes) {
		cu.getOwnedVariabletype().removeAll(variationTypes);
	}*/

	@Override
	public void addBoudaryElementBinding(
			FragmentSubstitution fragmentSubsitution,
			BoundaryElementBinding boundaryElementBinding) {
		fragmentSubsitution.getBoundaryElementBinding().add(boundaryElementBinding);
	}

	@Override
	public void removeBoudaryElementBinding(
			FragmentSubstitution fragmentSubsitution,
			BoundaryElementBinding boundaryElementBinding) {
		fragmentSubsitution.getBoundaryElementBinding().remove(boundaryElementBinding);
		
	}

	@Override
	public void removeBoudaryElementBindings(
			FragmentSubstitution fragmentSubsitution,
			EList<BoundaryElementBinding> boundaryElementBindings) {
		fragmentSubsitution.getBoundaryElementBinding().removeAll(boundaryElementBindings);
	}

	@Override
	public void clearBoudaryElementBindings(
			FragmentSubstitution fragmentSubsitution) {
		fragmentSubsitution.getBoundaryElementBinding().removeAll(fragmentSubsitution.getBoundaryElementBinding());
	}

	@Override
	public void addBoudaryElementBindings(
			FragmentSubstitution fragmentSubsitution,
			EList<BoundaryElementBinding> boundaryElementBindings) {
		fragmentSubsitution.getBoundaryElementBinding().addAll(boundaryElementBindings);
	}

	@Override
	public void setBindingVariationPoint(VariationPoint variationPoint,
			VSpec vSpec) {
		variationPoint.setBindingVSpec(vSpec);
	}

	@Override
	public void setToBindingToReplacement(ToBinding toBinding,
			ToReplacement toReplacement) {
		toBinding.setToReplacement(toReplacement);
	}

	@Override
	public void setFromBindingFromPlacement(FromBinding fromBinding,
			FromPlacement fromPlacement) {
		fromBinding.setFromPlacement(fromPlacement);
	}

	@Override
	public void addObjectHandlePlacement(PlacementFragment placement,
			ObjectHandle objectHandle) {
		placement.getSourceObject().add(objectHandle);
		
	}

	@Override
	public void addObjectHandleReplacement(ReplacementFragmentType replacement,
			ObjectHandle objectHandle) {
		replacement.getSourceObject().add(objectHandle);
	}

	@Override
	public void addPlacementBoundaryElement(PlacementFragment placement,
			PlacementBoundaryElement boundary) {
		placement.getPlacementBoundaryElement().add(boundary);
		
	}

	@Override
	public void addReplacementBoundaryElement(
			ReplacementFragmentType replacement,
			ReplacementBoundaryElement boundary) {
		replacement.getReplacementBoundaryElement().add(boundary);
		
	}

	@Override
	public void clearInsideBElementToPlacement(
			ToPlacement boundary) {
		boundary.getInsideBoundaryElement().clear();
	}

	@Override
	public void addInsideBElementToPlacement(
			ToPlacement boundary, ObjectHandle objectHandle) {
		boundary.getInsideBoundaryElement().add(objectHandle);
	}

	@Override
	public void addInsideBElementToPlacement(
			ToPlacement boundary, EList<ObjectHandle> objectHandle) {
		boundary.getInsideBoundaryElement().addAll(objectHandle);
	}

	@Override

	public void addChoice(Choice choice, BVRModel bvrModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addChoice(Choice choice, CompoundNode compoundNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean testXMIResourceUnload(XMIResource resource,
			IEditorReference[] editorReferences) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createNewResolution(PosResolution pr, BVRModel bvrModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVClassifierToVSpec(CompoundNode parentCompundNode,
			VClassifier childCClassifier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVClassifierToBVRModel(BVRModel bvrModel, VClassifier childClassifier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVariable(VSpec vSpec, Variable variable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeNamedElementVSpec(VSpec parentVSpec,
			NamedElement namedElement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVSpecToVSpec(VSpec parentVSpec, VSpec childVSpec) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeVSpecVariable(VSpec vSpec, Variable var) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeNamedElementVSpecResolution(
			VSpecResolution vSpecResolution, NamedElement namedElement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeVNodeCompoundNode(CompoundNode compoundNode, VNode vNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeConstraintCompoundNode(CompoundNode compoundNode,
			Constraint constraint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeVariabilityModelBVRModel(BVRModel model,
			CompoundNode variabilityModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPackagableElementBVRModel(BVRModel model,
			VPackageable vPackagable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VPackageable testPrimitiveTypes(BVRModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBCLConstraintVNode(VNode vNode, BCLConstraint bclConstraint) {

		// TODO Auto-generated method stub
	}
/*	public void SetValueForVariableValueAssignment(VariableValueAssignment elem, ValueSpecification value) {
	//TODO replace
}
*/
}
