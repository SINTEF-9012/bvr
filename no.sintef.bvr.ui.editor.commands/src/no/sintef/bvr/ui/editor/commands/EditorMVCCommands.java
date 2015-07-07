/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.commands;

import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IEditorReference;

import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.BVRModel;
import bvr.BoundaryElementBinding;
import bvr.Choice;
import bvr.ChoiceOccurrence;
import bvr.ChoiceResolution;
import bvr.ChoiceVSpec;
// import bvr.ChoiceResolutuion;
import bvr.CompoundNode;
import bvr.CompoundResolution;
import bvr.Constraint;
// import bvr.ConfigurableUnit;
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
import bvr.VClassOccurrence;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VPackageable;
// import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.VType;
import bvr.ValueResolution;
import bvr.Variable;
// import bvr.VariableValueAssignment;
import bvr.Variabletype;
import bvr.VariationPoint;

public class EditorMVCCommands implements EditorCommands {

	static private EditorMVCCommands eINSTANCE = null;

	static public EditorMVCCommands Get() {
		if (eINSTANCE == null) {
			eINSTANCE = new EditorMVCCommands();
		}
		return eINSTANCE;
	}

	@Override
	public TransactionalEditingDomain testTransactionalEditingDomain() {
		throw new UnsupportedOperationException("Pure MVC does not support transactional model");
	}

	@Override
	public void setName(NamedElement namedElement, String name) {
		namedElement.setName(name);
	}

	@Override
	public void setIsImpliedByParent(ChoiceVSpec choice, boolean isImplied) {
		choice.setIsImpliedByParent(isImplied);
	}

	@Override
	public void setVNodeGroupMultiplicity(VNode vNode, MultiplicityInterval eObject) {
		// vSpec.setGroupMultiplicity(eObject);
	}

	@Override
	public void setGroupMultiplicityUpperBound(MultiplicityInterval mInterval, int upperBound) {
		mInterval.setUpper(upperBound);
	}

	@Override
	public void setGroupMultiplicityLowerBound(MultiplicityInterval mInterval, int lowerBound) {
		mInterval.setLower(lowerBound);
	}

	@Override
	public void setTypeForVariable(Variable variable, Variabletype variableType) {
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

	@Override
	public void addOwnedVariationType(BVRModel model, Variabletype variationType) {
		model.getPackageElement().add(variationType);
	}

	@Override
	public void addBoudaryElementBinding(FragmentSubstitution fragmentSubsitution, BoundaryElementBinding boundaryElementBinding) {
		fragmentSubsitution.getBoundaryElementBinding().add(boundaryElementBinding);
	}

	@Override
	public void removeBoudaryElementBinding(FragmentSubstitution fragmentSubsitution, BoundaryElementBinding boundaryElementBinding) {
		fragmentSubsitution.getBoundaryElementBinding().remove(boundaryElementBinding);

	}

	@Override
	public void removeBoudaryElementBindings(FragmentSubstitution fragmentSubsitution, EList<BoundaryElementBinding> boundaryElementBindings) {
		fragmentSubsitution.getBoundaryElementBinding().removeAll(boundaryElementBindings);
	}

	@Override
	public void clearBoudaryElementBindings(FragmentSubstitution fragmentSubsitution) {
		fragmentSubsitution.getBoundaryElementBinding().removeAll(fragmentSubsitution.getBoundaryElementBinding());
	}

	@Override
	public void addBoudaryElementBindings(FragmentSubstitution fragmentSubsitution, EList<BoundaryElementBinding> boundaryElementBindings) {
		fragmentSubsitution.getBoundaryElementBinding().addAll(boundaryElementBindings);
	}

	@Override
	public void setBindingVariationPoint(VariationPoint variationPoint, VSpec vSpec) {
		variationPoint.setBindingVSpec(vSpec);
	}

	@Override
	public void setToBindingToReplacement(ToBinding toBinding, ToReplacement toReplacement) {
		toBinding.setToReplacement(toReplacement);
	}

	@Override
	public void setFromBindingFromPlacement(FromBinding fromBinding, FromPlacement fromPlacement) {
		fromBinding.setFromPlacement(fromPlacement);
	}

	@Override
	public void addObjectHandlePlacement(PlacementFragment placement, ObjectHandle objectHandle) {
		placement.getSourceObject().add(objectHandle);

	}

	@Override
	public void addObjectHandleReplacement(ReplacementFragmentType replacement, ObjectHandle objectHandle) {
		replacement.getSourceObject().add(objectHandle);
	}

	@Override
	public void addPlacementBoundaryElement(PlacementFragment placement, PlacementBoundaryElement boundary) {
		placement.getPlacementBoundaryElement().add(boundary);

	}

	@Override
	public void addReplacementBoundaryElement(ReplacementFragmentType replacement, ReplacementBoundaryElement boundary) {
		replacement.getReplacementBoundaryElement().add(boundary);

	}

	@Override
	public void clearInsideBElementToPlacement(ToPlacement boundary) {
		boundary.getInsideBoundaryElement().clear();
	}

	@Override
	public void addInsideBElementToPlacement(ToPlacement boundary, ObjectHandle objectHandle) {
		boundary.getInsideBoundaryElement().add(objectHandle);
	}

	@Override
	public void addInsideBElementToPlacement(ToPlacement boundary, EList<ObjectHandle> objectHandle) {
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
	public boolean testXMIResourceUnload(XMIResource resource, IEditorReference[] editorReferences) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addVClassifierToVSpec(CompoundNode parentCompundNode, VClassifier childCClassifier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addVClassifierToBVRModel(BVRModel bvrModel, VClassifier childClassifier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addVariable(VNode parentVNode, Variable variable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeVSpecVariable(VSpec vSpec, Variable var) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeNamedElementVSpecResolution(VSpecResolution vSpecResolution, NamedElement namedElement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeVNodeCompoundNode(CompoundNode compoundNode, VNode vNode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeConstraintVNode(VNode vNode, Constraint constraint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeVariabilityModelBVRModel(BVRModel model, CompoundNode variabilityModel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPackagableElementBVRModel(BVRModel model, VPackageable vPackagable) {
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

	@Override
	public void createNote(NamedElement parent, Note commentNote) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNoteExp(Note note, String expr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enableBatchProcessing() {
		// TODO Auto-generated method stub

	}

	@Override
	public void disableBatchProcessing() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTargetToCompoundNode(CompoundNode namedElement, Target target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVSpecTarget(VSpec namedElement, Target target) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeOwnedVSpecResolution(BVRModel bvrModel, VSpecResolution parent) {
		// TODO Auto-generated method stub
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createNewResolution(PosResolution pr, BVRModel bvrModel) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addVNodeToCompoundNode(CompoundNode parent, VNode child) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addVariabilityModelToBVRModel(BVRModel model, CompoundNode compoundNode) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addRealizationVariationPoint(BVRModel model, VariationPoint variationPoint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeOwenedVariationPoints(BVRModel model, EList<VariationPoint> variationPoints) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeOwnedVariationTypes(BVRModel model, EList<Variabletype> variationTypes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setChoiceResolvedVSpec(ChoiceResolution cr, Choice choice) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeBVRModelCompoundResolutions(BVRModel model, EList<CompoundResolution> resolutions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addChoiceResoulution(VSpecResolution vsper, ChoiceResolution pr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addChoiceResoulution(VSpecResolution vsper, ChoiceResolution cr, int index) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addValueResolution(CompoundResolution compountResolution, ValueResolution valueResolution) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPrimitiveValueBCLExpression(PrimitiveValueSpecification primitiveValue, BCLExpression expression) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeSimpleExeCommand(SimpleExeCommandInterface command) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addVTypeCompoundNode(CompoundNode parent, VType vType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setChoiceOccurenceVType(ChoiceOccurrence choiceOccurence, VType vType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVClassOccurenceVType(VClassOccurrence vclassOccurence, VType vType) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addChoiceVClassOccurence(CompoundNode parent, VNode occurence) {
		// TODO Auto-generated method stub

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTargetCompoundNode(CompoundNode parent, Target target) {
		// TODO Auto-generated method stub

	}
}
