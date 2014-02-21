package no.sintef.bvr.ui.editor.commands;


import java.util.List;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;

import bvr.BCLConstraint;
import bvr.BvrPackage;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.Constraint;
import bvr.NamedElement;
import bvr.PrimitveType;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.Variable;
import bvr.VariableValueAssignment;

public class EditorEMFTransactionalCommands implements EditorCommands {

	static private EditorEMFTransactionalCommands eINSTANCE = null;
	
	static public EditorEMFTransactionalCommands Get(){
		if(eINSTANCE == null){
			eINSTANCE = new EditorEMFTransactionalCommands();
		}
		return eINSTANCE;
	}
	
	@Override
	public void addChoice(Choice choice, ConfigurableUnit cu) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpec(), choice);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addChoice(Choice choice, VSpec vs) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, vs, BvrPackage.eINSTANCE.getVSpec_Child(), choice);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public TransactionalEditingDomain testTransactionalEditingDomain() {
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain(Constants.EDITOR_DOMAIN); //$NON-NLS-1$
		if (editingDomain == null) {
			editingDomain = DiagramEditingDomainFactory.getInstance()
					.createEditingDomain();
			editingDomain.setID(Constants.EDITOR_DOMAIN); //$NON-NLS-1$
		}
		return editingDomain;
	}

	@Override
	public void createNewResolution(ChoiceResolutuion cr, ConfigurableUnit cu) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpecResolution(), cr);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void setResolutionDecision(ChoiceResolutuion cr, boolean decision) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = new SetCommand(editingDomain, cr, BvrPackage.eINSTANCE.getChoiceResolutuion_Decision(), decision);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void setChoiceResolvedVSpec(ChoiceResolutuion cr, Choice choice) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = new SetCommand(editingDomain, cr, BvrPackage.eINSTANCE.getVSpecResolution_ResolvedVSpec(), choice);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addChoiceResolved(Choice refrencedVSpec, VSpecResolution parentVSpecResolution, ChoiceResolutuion childChoiceResolution) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, parentVSpecResolution, BvrPackage.eINSTANCE.getVSpecResolution_Child(), childChoiceResolution);
		editingDomain.getCommandStack().execute(cmd);
		setChoiceResolvedVSpec(childChoiceResolution, refrencedVSpec);
	}

	@Override
	public void addVClassifierToVSpec(VSpec parentVSpec, VClassifier childCClassifier) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, parentVSpec, BvrPackage.eINSTANCE.getVSpec_Child(), childCClassifier);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVClassifierToConfigurableUnit(ConfigurableUnit cu, VClassifier childCClassifier) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpec(), childCClassifier);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addBCLConstraint(ConfigurableUnit cu, BCLConstraint constraint) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedConstraint(), constraint);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVariableType(ConfigurableUnit cu, PrimitveType primType) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVariabletype(), primType);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVariable(VSpec vSpec, Variable variable) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, vSpec, BvrPackage.eINSTANCE.getVSpec_Child(), variable);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVariableValueAssignment(VSpecResolution parentVSpecResolution, VariableValueAssignment varValueAssignment) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, parentVSpecResolution, BvrPackage.eINSTANCE.getVSpecResolution_Child(), varValueAssignment);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVInstance(VSpecResolution parentVSpecResolution, VInstance vInstance) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, parentVSpecResolution, BvrPackage.eINSTANCE.getVSpecResolution_Child(), vInstance);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeNamedElementVSpec(VSpec parentVSpec, NamedElement namedElement) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = new RemoveCommand(editingDomain, parentVSpec, BvrPackage.eINSTANCE.getVSpec_Child(), namedElement);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeNamedElementConfigurableUnit(ConfigurableUnit cu, NamedElement namedElement) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = new RemoveCommand(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpec(), namedElement);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVSpecToVSpec(VSpec parentVSpec, VSpec childVSpec) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, parentVSpec, BvrPackage.eINSTANCE.getVSpec_Child(), childVSpec);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVSpecToConfigurableUnit(ConfigurableUnit cu, VSpec childVSpec) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = new AddCommand(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpec(), childVSpec);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeConstraintConfigurableUnit(ConfigurableUnit cu, NamedElement namedElement) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = new RemoveCommand(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedConstraint(), namedElement);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeAllConstraintConfigurableUnit(ConfigurableUnit cu, List<Constraint> constraints) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = new RemoveCommand(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedConstraint(), constraints);
		editingDomain.getCommandStack().execute(cmd);
	}
}
