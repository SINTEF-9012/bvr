package no.sintef.bvr.ui.editor.commands;


import java.io.File;
import java.util.List;











import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.part.FileEditorInput;

import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.BoundaryElementBinding;
import bvr.BvrPackage;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.Constraint;
import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.ObjectHandle;
import bvr.PlacementBoundaryElement;
import bvr.PlacementFragment;
import bvr.PrimitveType;
import bvr.ReplacementBoundaryElement;
import bvr.ReplacementFragmentType;
import bvr.ToBinding;
import bvr.ToPlacement;
import bvr.ToReplacement;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.Variable;
import bvr.VariableValueAssignment;
import bvr.Variabletype;
import bvr.VariationPoint;

public class EditorEMFTransactionalCommands implements EditorCommands {

	static private EditorEMFTransactionalCommands eINSTANCE = null;
	
	static public EditorEMFTransactionalCommands Get(){
		if(eINSTANCE == null){
			eINSTANCE = new EditorEMFTransactionalCommands();
		}
		return eINSTANCE;
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
	public void addChoice(Choice choice, ConfigurableUnit cu) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpec(), choice);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addChoice(Choice choice, VSpec vs) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, vs, BvrPackage.eINSTANCE.getVSpec_Child(), choice);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void createNewResolution(ChoiceResolutuion cr, ConfigurableUnit cu) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpecResolution(), cr);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void setResolutionDecision(ChoiceResolutuion cr, boolean decision) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, cr, BvrPackage.eINSTANCE.getChoiceResolutuion_Decision(), decision);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void setChoiceResolvedVSpec(ChoiceResolutuion cr, Choice choice) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, cr, BvrPackage.eINSTANCE.getVSpecResolution_ResolvedVSpec(), choice);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addChoiceResolved(Choice refrencedVSpec, VSpecResolution parentVSpecResolution, ChoiceResolutuion childChoiceResolution) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, parentVSpecResolution, BvrPackage.eINSTANCE.getVSpecResolution_Child(), childChoiceResolution);
		editingDomain.getCommandStack().execute(cmd);
		setChoiceResolvedVSpec(childChoiceResolution, refrencedVSpec);
	}

	@Override
	public void addVClassifierToVSpec(VSpec parentVSpec, VClassifier childCClassifier) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, parentVSpec, BvrPackage.eINSTANCE.getVSpec_Child(), childCClassifier);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVClassifierToConfigurableUnit(ConfigurableUnit cu, VClassifier childCClassifier) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpec(), childCClassifier);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addBCLConstraint(ConfigurableUnit cu, BCLConstraint constraint) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedConstraint(), constraint);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVariableType(ConfigurableUnit cu, PrimitveType primType) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVariabletype(), primType);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVariable(VSpec vSpec, Variable variable) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, vSpec, BvrPackage.eINSTANCE.getVSpec_Child(), variable);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVariableValueAssignment(VSpecResolution parentVSpecResolution, VariableValueAssignment varValueAssignment) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, parentVSpecResolution, BvrPackage.eINSTANCE.getVSpecResolution_Child(), varValueAssignment);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVInstance(VSpecResolution parentVSpecResolution, VInstance vInstance) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, parentVSpecResolution, BvrPackage.eINSTANCE.getVSpecResolution_Child(), vInstance);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeNamedElementVSpec(VSpec parentVSpec, NamedElement namedElement) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, parentVSpec, BvrPackage.eINSTANCE.getVSpec_Child(), namedElement);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeOwnedVSpecConfigurableUnit(ConfigurableUnit cu, NamedElement namedElement) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpec(), namedElement);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVSpecToVSpec(VSpec parentVSpec, VSpec childVSpec) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, parentVSpec, BvrPackage.eINSTANCE.getVSpec_Child(), childVSpec);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addVSpecToConfigurableUnit(ConfigurableUnit cu, VSpec childVSpec) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpec(), childVSpec);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeConstraintConfigurableUnit(ConfigurableUnit cu, NamedElement namedElement) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedConstraint(), namedElement);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeAllConstraintConfigurableUnit(ConfigurableUnit cu, List<Constraint> constraints) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedConstraint(), constraints);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void setName(NamedElement namedElement, String name) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, namedElement, BvrPackage.eINSTANCE.getNamedElement_Name(), name);
		editingDomain.getCommandStack().execute(cmd);
	}
	
	@Override
	public void setVSpecComment(VSpec vSpec, String comment) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, vSpec, BvrPackage.eINSTANCE.getVSpec_Comment(), comment);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void setIsImpliedByParent(Choice choice, boolean isImplied) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, choice, BvrPackage.eINSTANCE.getChoice_IsImpliedByParent(), isImplied);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void setVSpecGroupMultiplicity(VSpec vSpec, MultiplicityInterval eObject) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, vSpec, BvrPackage.eINSTANCE.getVSpec_GroupMultiplicity(), eObject);
		editingDomain.getCommandStack().execute(cmd);
	}
	
	@Override
	public void setGroupMultiplicityUpperBound(MultiplicityInterval mInterval, int upperBound){
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, mInterval, BvrPackage.eINSTANCE.getMultiplicityInterval_Upper(), upperBound);
		editingDomain.getCommandStack().execute(cmd);
	}
	
	@Override
	public void setGroupMultiplicityLowerBound(MultiplicityInterval mInterval, int lowerBound){
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, mInterval, BvrPackage.eINSTANCE.getMultiplicityInterval_Lower(), lowerBound);
		editingDomain.getCommandStack().execute(cmd);
	}
	
	@Override
	public void setTypeForVariable(Variable variable, Variabletype variableType){
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, variable, BvrPackage.eINSTANCE.getVariable_Type(), variableType);
		editingDomain.getCommandStack().execute(cmd);
	}
	
	@Override
	public void clearBCLConstraintExpressions(BCLConstraint constraint) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, constraint, BvrPackage.eINSTANCE.getBCLConstraint_Expression(), constraint.getExpression());
		editingDomain.getCommandStack().execute(cmd);
	}
	
	@Override
	public void addBCLExpressionConstraint(BCLConstraint constraint, BCLExpression expression) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, constraint, BvrPackage.eINSTANCE.getBCLConstraint_Expression(), expression);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeVSpecVariable(VSpec vSpec, Variable var) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, vSpec, BvrPackage.eINSTANCE.getVSpec_Child(), var);
		editingDomain.getCommandStack().execute(cmd);
	}
	
	@Override
	public void removeNamedElementVSpecResolution(VSpecResolution vSpecResolution, NamedElement namedElement) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, vSpecResolution, BvrPackage.eINSTANCE.getVSpecResolution_Child(), namedElement);
		editingDomain.getCommandStack().execute(cmd);
	}
	
	@Override
	public void removeOwnedVSpecResolutionConfigurableUnit(ConfigurableUnit cu, NamedElement namedElement) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpecResolution(), namedElement);
		editingDomain.getCommandStack().execute(cmd);
	}
	
	@Override
	public void removeOwnedVSpecResolutions(ConfigurableUnit cu) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpecResolution(), cu.getOwnedVSpecResolution());
		editingDomain.getCommandStack().execute(cmd);
	}
	
	@Override
	public void addOwnedVSpecResolutionConfigurableUnit(ConfigurableUnit cu, VSpecResolution vSpecResolution){
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpecResolution(), vSpecResolution);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addOwnedVSpecResolutionsConfigurableUnit(ConfigurableUnit cu, EList<VSpecResolution> vSpecResolutions) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVSpecResolution(), vSpecResolutions);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public boolean testXMIResourceUnload(XMIResource resource, IEditorReference[] editorReferences) {
		boolean isResourceUsed = false;
		for(IEditorReference ref : editorReferences){
			IEditorPart editorPart = ref.getEditor(false);
			if(editorPart != null) {
				IEditorInput editorInput = editorPart.getEditorInput();
				if(editorInput instanceof FileEditorInput){
					URIConverter converter = new ExtensibleURIConverterImpl();
					URI emptyFileURI = URI.createFileURI(ResourcesPlugin.getWorkspace()
							.getRoot().getLocation().toOSString() + File.separator);
					URI emptyPlatformURI = URI.createPlatformResourceURI("/", false);
					converter.getURIMap().put(emptyFileURI, emptyPlatformURI);
					URI platformURI = converter.normalize(URI.createFileURI(((FileEditorInput) editorInput).getPath().toOSString()));
					
					TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
					Resource currentResource = editingDomain.getResourceSet().getResource(platformURI, true);
					
					if(currentResource instanceof GMFResource){
						GMFResource gmfResource = (GMFResource) currentResource;
						if(gmfResource.getContents().get(0) instanceof Diagram){
							Diagram diagram = (Diagram) gmfResource.getContents().get(0);
							if(diagram.getElement().eResource().equals(resource)){
								isResourceUsed = true;
								break;
							}

						}						
					} else if (currentResource.equals(resource)){
						isResourceUsed = true;
					}
					
				}
			}
		}
		
		if(!isResourceUsed)
			resource.unload();
		return isResourceUsed;
	}
	
	@Override
	public void addOwnedVariationPoint(ConfigurableUnit cu, VariationPoint variationPoint){
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVariationPoint(), variationPoint);
		editingDomain.getCommandStack().execute(cmd);
	}
	
	@Override
	public void addOwnedVariationType(ConfigurableUnit cu, Variabletype variationType) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVariabletype(), variationType);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeOwenedVariationPoint(ConfigurableUnit cu, VariationPoint variationPoint) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVariationPoint(), variationPoint);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeOwnedVariationType(ConfigurableUnit cu, Variabletype variationType) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVariabletype(), variationType);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeOwenedVariationPoints(ConfigurableUnit cu, EList<VariationPoint> variationPoints) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVariationPoint(), variationPoints);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeOwnedVariationTypes(ConfigurableUnit cu, EList<Variabletype> variationTypes) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, cu, BvrPackage.eINSTANCE.getConfigurableUnit_OwnedVariabletype(), variationTypes);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addBoudaryElementBinding(
			FragmentSubstitution fragmentSubsitution,
			BoundaryElementBinding boundaryElementBinding) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, fragmentSubsitution, BvrPackage.eINSTANCE.getBoundaryElementBinding(), boundaryElementBinding);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeBoudaryElementBinding(
			FragmentSubstitution fragmentSubsitution,
			BoundaryElementBinding boundaryElementBinding) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, fragmentSubsitution, BvrPackage.eINSTANCE.getBoundaryElementBinding(), boundaryElementBinding);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void removeBoudaryElementBindings(
			FragmentSubstitution fragmentSubsitution,
			EList<BoundaryElementBinding> boundaryElementBindings) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, fragmentSubsitution, BvrPackage.eINSTANCE.getBoundaryElementBinding(), boundaryElementBindings);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void clearBoudaryElementBindings(
			FragmentSubstitution fragmentSubsitution) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, fragmentSubsitution, BvrPackage.eINSTANCE.getBoundaryElementBinding(), fragmentSubsitution.getBoundaryElementBinding());
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addBoudaryElementBindings(
			FragmentSubstitution fragmentSubsitution,
			EList<BoundaryElementBinding> boundaryElementBindings) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, fragmentSubsitution, BvrPackage.eINSTANCE.getBoundaryElementBinding(), boundaryElementBindings);
		editingDomain.getCommandStack().execute(cmd);
	}
	
	@Override
	public void setBindingVariationPoint(VariationPoint variationPoint,
			VSpec vSpec) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, variationPoint, BvrPackage.eINSTANCE.getVariationPoint_BindingVSpec(), vSpec);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void setToBindingToReplacement(ToBinding toBinding,
			ToReplacement toReplacement) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, toBinding, BvrPackage.eINSTANCE.getToBinding_ToReplacement(), toReplacement);
		editingDomain.getCommandStack().execute(cmd);		
	}

	@Override
	public void setFromBindingFromPlacement(FromBinding fromBinding,
			FromPlacement fromPlacement) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, fromBinding, BvrPackage.eINSTANCE.getFromBinding_FromPlacement(), fromPlacement);
		editingDomain.getCommandStack().execute(cmd);		
	}

	@Override
	public void addObjectHandlePlacement(PlacementFragment placement,
			ObjectHandle objectHandle) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, placement, BvrPackage.eINSTANCE.getPlacementFragment_SourceObject(), objectHandle);
		editingDomain.getCommandStack().execute(cmd);	
	}

	@Override
	public void addObjectHandleReplacement(ReplacementFragmentType replacement,
			ObjectHandle objectHandle) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, replacement, BvrPackage.eINSTANCE.getReplacementFragmentType_SourceObject(), objectHandle);
		editingDomain.getCommandStack().execute(cmd);	
	}

	@Override
	public void addPlacementBoundaryElement(PlacementFragment placement,
			PlacementBoundaryElement boundary) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, placement, BvrPackage.eINSTANCE.getPlacementFragment_PlacementBoundaryElement(), boundary);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addReplacementBoundaryElement(
			ReplacementFragmentType replacement,
			ReplacementBoundaryElement boundary) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, replacement, BvrPackage.eINSTANCE.getReplacementFragmentType_ReplacementBoundaryElement(), boundary);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void clearInsideBElementToPlacement(ToPlacement boundary) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, boundary, BvrPackage.eINSTANCE.getToPlacement_InsideBoundaryElement(), boundary.getInsideBoundaryElement());
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addInsideBElementToPlacement(ToPlacement boundary,
			ObjectHandle objectHandle) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, boundary, BvrPackage.eINSTANCE.getToPlacement_InsideBoundaryElement(), objectHandle);
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void addInsideBElementToPlacement(ToPlacement boundary,
			EList<ObjectHandle> objectHandle) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, boundary, BvrPackage.eINSTANCE.getToPlacement_InsideBoundaryElement(), objectHandle);
		editingDomain.getCommandStack().execute(cmd);
	}

}
