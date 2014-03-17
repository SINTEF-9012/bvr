package no.sintef.bvr.ui.editor.commands;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import bvr.BCLConstraint;
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

public interface EditorCommands {
	
	public void addChoice(Choice choice, ConfigurableUnit cu);
	
	public void addChoice(Choice choice, VSpec vs);
	
	public TransactionalEditingDomain testTransactionalEditingDomain();
	
	public void createNewResolution(ChoiceResolutuion cr, ConfigurableUnit cu);
	
	public void setResolutionDecision(ChoiceResolutuion cr, boolean decision);
	
	public void setChoiceResolvedVSpec(ChoiceResolutuion cr, Choice choice);
	
	public void addChoiceResolved(Choice target, VSpecResolution vsper, ChoiceResolutuion cr);
	
	public void addVClassifierToVSpec(VSpec parentVSpec, VClassifier childCClassifier);
	
	public void addVClassifierToConfigurableUnit(ConfigurableUnit cu, VClassifier childCClassifier);
	
	public void addBCLConstraint(ConfigurableUnit cu, BCLConstraint constraint);
	
	public void addVariableType(ConfigurableUnit cu, PrimitveType primType);
	
	public void addVariable(VSpec vSpec, Variable variable);
	
	public void addVariableValueAssignment(VSpecResolution parentVSpecResolution, VariableValueAssignment varValueAssignment);
	
	public void addVInstance(VSpecResolution parentVSpecResolution, VInstance vInstance);
	
	public void removeNamedElementVSpec(VSpec parentVSpec, NamedElement namedElement);
	
	public void removeNamedElementConfigurableUnit(ConfigurableUnit cu, NamedElement namedElement);
	
	public void addVSpecToVSpec(VSpec parentVSpec, VSpec childVSpec);

	public void addVSpecToConfigurableUnit(ConfigurableUnit cu, VSpec childVSpec);
	
	public void removeConstraintConfigurableUnit(ConfigurableUnit cu, NamedElement namedElement);
	
	public void removeAllConstraintConfigurableUnit(ConfigurableUnit cu, List<Constraint> constraints);
	
	public void setName(NamedElement namedElement, String name);
	
	public void setVSpecComment(VSpec vSpec, String comment);
	
	public void setIsImpliedByParent(Choice choice, boolean isImplied);
	
	public void setVSpecGroupMultiplicity(VSpec vSpec, MultiplicityInterval eObject);
}
