package no.sintef.bvr.ui.editor.commands;


import java.io.File;
import java.util.ArrayList;
import java.util.List;










import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.part.FileEditorInput;

import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.BVRModel;
import bvr.BoundaryElementBinding;
import bvr.BvrFactory;
import bvr.BvrPackage;
import bvr.Choice;
import bvr.ChoiceOccurrence;
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
import bvr.PrimitveType;
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
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.VType;
import bvr.ValueResolution;
import bvr.Variable;
import bvr.Variabletype;
import bvr.VariationPoint;

public class EditorEMFTransactionalCommands implements EditorCommands {

	static private EditorEMFTransactionalCommands eINSTANCE = null;
	
	private boolean batchMode = false;
	private ArrayList<AbstractCommand> queue = new ArrayList<AbstractCommand>();
	
	static public EditorEMFTransactionalCommands Get(){
		if(eINSTANCE == null){
			eINSTANCE = new EditorEMFTransactionalCommands();
		}
		return eINSTANCE;
	}
	
	private void testCommandExecution(TransactionalEditingDomain domain, AbstractCommand command) {
		if(batchMode) {
			queue.add(command);
		} else {
			domain.getCommandStack().execute(command);
		}
	}

	@Override
	public TransactionalEditingDomain testTransactionalEditingDomain() {
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(Constants.EDITOR_DOMAIN);
		if (editingDomain == null) {
			editingDomain = TransactionalEditingDomainImpl.FactoryImpl.INSTANCE.createEditingDomain();
			editingDomain.setID(Constants.EDITOR_DOMAIN);
			TransactionalEditingDomain.Registry.INSTANCE.add(Constants.EDITOR_DOMAIN, editingDomain);
		}
		return editingDomain;
	}

	@Override
	public void setName(NamedElement namedElement, String name) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, namedElement, BvrPackage.eINSTANCE.getNamedElement_Name(), name);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void setIsImpliedByParent(Choice choice, boolean isImplied) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, choice, BvrPackage.eINSTANCE.getChoice_IsImpliedByParent(), isImplied);
		testCommandExecution(editingDomain, cmd);
	}
	
	@Override
	public void setGroupMultiplicityUpperBound(MultiplicityInterval mInterval, int upperBound){
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, mInterval, BvrPackage.eINSTANCE.getMultiplicityInterval_Upper(), upperBound);
		testCommandExecution(editingDomain, cmd);
	}
	
	@Override
	public void setGroupMultiplicityLowerBound(MultiplicityInterval mInterval, int lowerBound){
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, mInterval, BvrPackage.eINSTANCE.getMultiplicityInterval_Lower(), lowerBound);
		testCommandExecution(editingDomain, cmd);
	}
	
	@Override
	public void setTypeForVariable(Variable variable, Variabletype variableType){
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, variable, BvrPackage.eINSTANCE.getVariable_Type(), variableType);
		testCommandExecution(editingDomain, cmd);
	}
	
	@Override
	public void clearBCLConstraintExpressions(BCLConstraint constraint) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, constraint, BvrPackage.eINSTANCE.getBCLConstraint_Expression(), constraint.getExpression());
		testCommandExecution(editingDomain, cmd);
	}
	
	@Override
	public void addBCLExpressionConstraint(BCLConstraint constraint, BCLExpression expression) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, constraint, BvrPackage.eINSTANCE.getBCLConstraint_Expression(), expression);
		testCommandExecution(editingDomain, cmd);
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
					
					if (currentResource.equals(resource)){
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
	public void addOwnedVariationType(BVRModel model, Variabletype variationType) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, model, BvrPackage.eINSTANCE.getVPackage_PackageElement(), variationType);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void removeOwenedVariationPoints(BVRModel model, EList<VariationPoint> variationPoints) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, model, BvrPackage.eINSTANCE.getBVRModel_RealizationModel(), variationPoints);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void removeOwnedVariationTypes(BVRModel model, EList<Variabletype> variationTypes) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, model, BvrPackage.eINSTANCE.getVPackage_PackageElement(), variationTypes);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addBoudaryElementBinding(
			FragmentSubstitution fragmentSubsitution,
			BoundaryElementBinding boundaryElementBinding) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, fragmentSubsitution, BvrPackage.eINSTANCE.getBoundaryElementBinding(), boundaryElementBinding);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void removeBoudaryElementBinding(
			FragmentSubstitution fragmentSubsitution,
			BoundaryElementBinding boundaryElementBinding) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, fragmentSubsitution, BvrPackage.eINSTANCE.getBoundaryElementBinding(), boundaryElementBinding);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void removeBoudaryElementBindings(
			FragmentSubstitution fragmentSubsitution,
			EList<BoundaryElementBinding> boundaryElementBindings) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, fragmentSubsitution, BvrPackage.eINSTANCE.getBoundaryElementBinding(), boundaryElementBindings);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void clearBoudaryElementBindings(
			FragmentSubstitution fragmentSubsitution) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, fragmentSubsitution, BvrPackage.eINSTANCE.getBoundaryElementBinding(), fragmentSubsitution.getBoundaryElementBinding());
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addBoudaryElementBindings(
			FragmentSubstitution fragmentSubsitution,
			EList<BoundaryElementBinding> boundaryElementBindings) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, fragmentSubsitution, BvrPackage.eINSTANCE.getBoundaryElementBinding(), boundaryElementBindings);
		testCommandExecution(editingDomain, cmd);
	}
	
	@Override
	public void setBindingVariationPoint(VariationPoint variationPoint,
			VSpec vSpec) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, variationPoint, BvrPackage.eINSTANCE.getVariationPoint_BindingVSpec(), vSpec);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void setToBindingToReplacement(ToBinding toBinding,
			ToReplacement toReplacement) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, toBinding, BvrPackage.eINSTANCE.getToBinding_ToReplacement(), toReplacement);
		testCommandExecution(editingDomain, cmd);	
	}

	@Override
	public void setFromBindingFromPlacement(FromBinding fromBinding,
			FromPlacement fromPlacement) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, fromBinding, BvrPackage.eINSTANCE.getFromBinding_FromPlacement(), fromPlacement);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addObjectHandlePlacement(PlacementFragment placement,
			ObjectHandle objectHandle) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, placement, BvrPackage.eINSTANCE.getPlacementFragment_SourceObject(), objectHandle);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addObjectHandleReplacement(ReplacementFragmentType replacement,
			ObjectHandle objectHandle) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, replacement, BvrPackage.eINSTANCE.getReplacementFragmentType_SourceObject(), objectHandle);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addPlacementBoundaryElement(PlacementFragment placement,
			PlacementBoundaryElement boundary) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, placement, BvrPackage.eINSTANCE.getPlacementFragment_PlacementBoundaryElement(), boundary);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addReplacementBoundaryElement(
			ReplacementFragmentType replacement,
			ReplacementBoundaryElement boundary) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, replacement, BvrPackage.eINSTANCE.getReplacementFragmentType_ReplacementBoundaryElement(), boundary);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void clearInsideBElementToPlacement(ToPlacement boundary) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, boundary, BvrPackage.eINSTANCE.getToPlacement_InsideBoundaryElement(), boundary.getInsideBoundaryElement());
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addInsideBElementToPlacement(ToPlacement boundary,
			ObjectHandle objectHandle) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, boundary, BvrPackage.eINSTANCE.getToPlacement_InsideBoundaryElement(), objectHandle);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addInsideBElementToPlacement(ToPlacement boundary,
			EList<ObjectHandle> objectHandle) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, boundary, BvrPackage.eINSTANCE.getToPlacement_InsideBoundaryElement(), objectHandle);
		testCommandExecution(editingDomain, cmd);
	}


	@Override
	public void addChoice(Choice choice, BVRModel bvrModel) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, bvrModel, BvrPackage.eINSTANCE.getBVRModel_VariabilityModel(), choice);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addChoice(Choice choice, final CompoundNode compoundNode) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, compoundNode, BvrPackage.eINSTANCE.getCompoundNode(), (VNode) choice);
		testCommandExecution(editingDomain, cmd);
	}
	
	@Override
	public void removeVariabilityModelBVRModel(BVRModel model, CompoundNode variabilityModel) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, model, BvrPackage.eINSTANCE.getBVRModel_VariabilityModel(), null);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void createNewResolution(PosResolution pr, BVRModel bvrModel) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, bvrModel, BvrPackage.eINSTANCE.getBVRModel_ResolutionModels(), pr);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addVClassifierToVSpec(CompoundNode parentCompundNode, VClassifier childCClassifier) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, parentCompundNode, BvrPackage.eINSTANCE.getCompoundNode_Member(), childCClassifier);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addVClassifierToBVRModel(BVRModel bvrModel, VClassifier childClassifier) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, bvrModel, BvrPackage.eINSTANCE.getBVRModel_VariabilityModel(), childClassifier);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addVariable(VNode parentVNode, Variable variable) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, parentVNode, BvrPackage.eINSTANCE.getVNode_Variable(), variable);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void setVNodeGroupMultiplicity(VNode vNode, MultiplicityInterval eObject) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, vNode, BvrPackage.eINSTANCE.getVNode_GroupMultiplicity(), eObject);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void removeVSpecVariable(VSpec vSpec, Variable var) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, vSpec, BvrPackage.eINSTANCE.getVNode_Variable(), var);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void removeNamedElementVSpecResolution(
			VSpecResolution vSpecParent, NamedElement namedElement) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, vSpecParent, BvrPackage.eINSTANCE.getCompoundResolution_Members(), namedElement);
		testCommandExecution(editingDomain, cmd);
		
	}

	@Override
	public void removeVNodeCompoundNode(CompoundNode compoundNode, VNode vNode) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, compoundNode, BvrPackage.eINSTANCE.getCompoundNode_Member(), vNode);
		testCommandExecution(editingDomain, cmd);
	}
	
	@Override
	public void removeConstraintVNode(VNode vNode, Constraint constraint) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, vNode, BvrPackage.eINSTANCE.getVNode_OwnedConstraint(), constraint);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addPackagableElementBVRModel(BVRModel model, VPackageable vPackagable) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, model, BvrPackage.eINSTANCE.getVPackage_PackageElement(), vPackagable);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public VPackageable testPrimitiveTypes(BVRModel model) {
		EList<VPackageable> packagableElements = model.getPackageElement();
		PrimitveType primitiveType = null; 
		for(VPackageable vPack : packagableElements){
			if(vPack instanceof PrimitveType) {
				primitiveType = (PrimitveType) vPack;
				break;
			}
		}
		
		if(primitiveType == null){
			primitiveType = BvrFactory.eINSTANCE.createPrimitveType();
			addPackagableElementBVRModel(model, primitiveType);
		}
		
		return primitiveType;
	}

	@Override
	public void addBCLConstraintVNode(VNode vNode, BCLConstraint bclConstraint) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, vNode, BvrPackage.eINSTANCE.getVNode_OwnedConstraint(), bclConstraint);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void createNote(NamedElement parent, Note note) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, parent, BvrPackage.eINSTANCE.getNamedElement_Note(), note);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void updateNoteExp(Note note, String expr) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, note, BvrPackage.eINSTANCE.getNote_Expr(), expr);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void enableBatchProcessing() {
		batchMode = true;
	}

	@Override
	public void executeBatch() {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			
			@Override
			protected void doExecute() {
				for(AbstractCommand command : queue){
					command.execute();
				}
				queue.clear();
			}
		});
		
	}

	@Override
	public void disableBatchProcessing() {
		batchMode = false;
		queue.clear();
	}

	@Override
	public void addChoiceResoulution(VSpecResolution vsper, ChoiceResolution cr) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, vsper, BvrPackage.eINSTANCE.getVSpecResolution(), cr);
		testCommandExecution(editingDomain,cmd);
	}
	
	@Override
	public void addChoiceResoulution(VSpecResolution vsper, ChoiceResolution cr, int index) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, vsper, BvrPackage.eINSTANCE.getVSpecResolution(), cr, index);
		testCommandExecution(editingDomain,cmd);
	}
	
	@Override
	public void setChoiceResolvedVSpec(ChoiceResolution cr, Choice target) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, cr, BvrPackage.eINSTANCE.getVSpecResolution_ResolvedVSpec(), target);
		testCommandExecution(editingDomain,cmd);
	}

	@Override
	public void removeOwnedVSpecResolution(BVRModel bvrModel, VSpecResolution parent) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, bvrModel, BvrPackage.eINSTANCE.getBVRModel_ResolutionModels(), parent);
		testCommandExecution(editingDomain,cmd);
	}

	@Override
	public void addTargetToCompoundNode(CompoundNode compoundNode, Target target) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, compoundNode, BvrPackage.eINSTANCE.getCompoundNode_OwnedTargets(), target);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void setVSpecTarget(VSpec vSpec, Target target) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, vSpec, BvrPackage.eINSTANCE.getVSpec_Target(), target);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void reset() {
		disableBatchProcessing();
	}

	@Override
	public void addVNodeToCompoundNode(CompoundNode parent, VNode child) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, parent, BvrPackage.eINSTANCE.getCompoundNode_Member(), child);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addVariabilityModelToBVRModel(BVRModel model, CompoundNode compoundNode) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, model, BvrPackage.eINSTANCE.getBVRModel_VariabilityModel(), compoundNode);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addRealizationVariationPoint(BVRModel model, VariationPoint variationPoint) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, model, BvrPackage.eINSTANCE.getBVRModel_RealizationModel(), variationPoint);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void removeBVRModelCompoundResolutions(BVRModel model, EList<CompoundResolution> resolutions) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		RemoveCommand cmd = (RemoveCommand) RemoveCommand.create(editingDomain, model, BvrPackage.eINSTANCE.getBVRModel_ResolutionModels(), resolutions);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addValueResolution(CompoundResolution compountResolution, ValueResolution valueResolution) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, compountResolution, BvrPackage.eINSTANCE.getCompoundResolution_Members(), valueResolution);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void setPrimitiveValueBCLExpression(
			PrimitiveValueSpecification primitiveValue, BCLExpression expression) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, primitiveValue, BvrPackage.eINSTANCE.getPrimitiveValueSpecification_Expression(), expression);
		testCommandExecution(editingDomain, cmd);
	}
	
	@Override
	public void executeSimpleExeCommand(final SimpleExeCommandInterface command) {
		final List<Exception> exceptions = new ArrayList<Exception>();
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();   
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				try {
					command.execute();
				} catch (Exception e) {
					exceptions.add(e);
				}
			}
		});
		if(exceptions.size() != 0)
			throw new RuntimeException(exceptions.get(0));
	}

	@Override
	public void addVTypeCompoundNode(CompoundNode parent, VType vType) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, parent, BvrPackage.eINSTANCE.getCompoundNode_Member(), vType);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void setChoiceOccurenceVType(ChoiceOccurrence choiceOccurence,
			VType vType) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, choiceOccurence, BvrPackage.eINSTANCE.getChoiceOccurrence_VType(), vType);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void setVClassOccurenceVType(VClassOccurrence vclassOccurence,
			VType vType) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		SetCommand cmd = (SetCommand) SetCommand.create(editingDomain, vclassOccurence, BvrPackage.eINSTANCE.getVClassOccurrence_VType(), vType);
		testCommandExecution(editingDomain, cmd);
	}

	@Override
	public void addChoiceVClassOccurence(CompoundNode parent, VNode occurence) {
		TransactionalEditingDomain editingDomain = testTransactionalEditingDomain();
		AddCommand cmd = (AddCommand) AddCommand.create(editingDomain, parent, BvrPackage.eINSTANCE.getCompoundNode_Member(), occurence);
		testCommandExecution(editingDomain, cmd);
	}
}
