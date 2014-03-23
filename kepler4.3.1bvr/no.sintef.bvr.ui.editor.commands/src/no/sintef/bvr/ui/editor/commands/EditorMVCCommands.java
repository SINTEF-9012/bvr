package no.sintef.bvr.ui.editor.commands;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.Constraint;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.PrimitveType;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.Variable;
import bvr.VariableValueAssignment;
import bvr.Variabletype;

public class EditorMVCCommands implements EditorCommands {
	
	static private EditorMVCCommands eINSTANCE = null;
	
	static public EditorMVCCommands Get(){
		if(eINSTANCE == null){
			eINSTANCE = new EditorMVCCommands();
		}
		return eINSTANCE;
	}

	@Override
	public void addChoice(Choice choice, ConfigurableUnit cu) {
		cu.getOwnedVSpec().add(choice);
	}

	@Override
	public void addChoice(Choice choice, VSpec vs) {
		vs.getChild().add(choice);
	}

	@Override
	public TransactionalEditingDomain testTransactionalEditingDomain() {
		throw new UnsupportedOperationException("Pure MVC does not support transactional model");
	}

	@Override
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
	}

	@Override
	public void setName(NamedElement namedElement, String name) {
		namedElement.setName(name);
	}

	@Override
	public void setVSpecComment(VSpec vSpec, String comment) {
		vSpec.setComment(comment);
	}

	@Override
	public void setIsImpliedByParent(Choice choice, boolean isImplied) {
		choice.setIsImpliedByParent(isImplied);
	}
	
	@Override
	public void setVSpecGroupMultiplicity(VSpec vSpec, MultiplicityInterval eObject){
		vSpec.setGroupMultiplicity(eObject);
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

	@Override
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
}
