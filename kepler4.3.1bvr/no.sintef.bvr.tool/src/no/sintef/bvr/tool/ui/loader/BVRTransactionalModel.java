package no.sintef.bvr.tool.ui.loader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import no.sintef.bvr.tool.checker.ModelChecker;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.exception.UnimplementedBVRException;
import no.sintef.bvr.tool.model.ConstraintFacade;
import no.sintef.bvr.tool.model.NoteFacade;
import no.sintef.bvr.tool.model.PrimitiveTypeFacade;
import no.sintef.bvr.tool.model.TargetFacade;
import no.sintef.bvr.tool.observer.ResourceObserver;
import no.sintef.bvr.tool.observer.ResourceSetEditedSubject;
import no.sintef.bvr.tool.observer.ResourceSubject;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import bvr.BCLConstraint;
import bvr.BVRModel;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.Constraint;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.Note;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitveType;
import bvr.Target;
import bvr.TargetRef;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.Variable;
import bvr.Variabletype;
import bvr.VariationPoint;

public class BVRTransactionalModel extends BVRToolModel implements ResourceObserver {
	private Resource resource;
	
	static private int choicCounter = 0;
	static private int variableCount = 0;
	static private int classifierCount = 0;
	private NamedElement cutNamedElement = null;
	
	
	public BVRTransactionalModel(File sf, no.sintef.ict.splcatool.SPLCABVRModel x) {
		bvrm = x;
		f = sf;
		loadFilename = sf.getAbsolutePath();
		init();
	}

	public BVRTransactionalModel(File sf) {
		f = sf;
		bvrm = new BVRInnerModel(f);
		loadFilename = sf.getAbsolutePath();
		init();
	}
	
	private void init(){
		minimizedVSpec = new ArrayList<VSpec>();
		minimizedVSpecResolution = new ArrayList<VSpecResolution>();
		checkModel();
	}

	@Override
	public no.sintef.ict.splcatool.SPLCABVRModel getBVRM() {
		return bvrm;
	}

	@Override
	public BVRModel getBVRModel() {
		return bvrm.getRootBVRModel();
	}

	@Override
	public File getFile() {
		return f;
	}
	
	public Resource getResource(){
		return resource;
	}

	private class BVRInnerModel extends no.sintef.ict.splcatool.SPLCABVRModel {

		public BVRInnerModel(File f) {
			model = loadFromFile(f);
		}

		@Override
		public BVRModel getRootBVRModel() {
			return model;
		}

		private BVRModel loadFromFile(File file) {
			TransactionalEditingDomain editingDomain = Context.eINSTANCE.getEditorCommands().testTransactionalEditingDomain();

			URIConverter converter = new ExtensibleURIConverterImpl();
			URI emptyFileURI = URI.createFileURI(ResourcesPlugin.getWorkspace()
					.getRoot().getLocation().toOSString() + File.separator);
			URI emptyPlatformURI = URI.createPlatformResourceURI("/", false);
			converter.getURIMap().put(emptyFileURI, emptyPlatformURI);
			URI platformURI = converter.normalize(URI.createFileURI(file
					.getAbsolutePath()));

			resource = editingDomain.getResourceSet().getResource(
					platformURI, true);
			resource.setTrackingModification(true);
			
			return (BVRModel) resource.getContents().get(0);
		}

		public void writeToFile(String filename) throws IOException {

			TransactionalEditingDomain editingDomain = Context.eINSTANCE.getEditorCommands().testTransactionalEditingDomain();
			
			URIConverter converter = new ExtensibleURIConverterImpl();
			URI emptyFileURI = URI.createFileURI(ResourcesPlugin.getWorkspace()
					.getRoot().getLocation().toOSString() + File.separator);
			URI emptyPlatformURI = URI.createPlatformResourceURI("/", false);
			converter.getURIMap().put(emptyFileURI, emptyPlatformURI);
			URI platformURI = converter.normalize(URI.createFileURI(filename));

			resource = editingDomain.getResourceSet().getResource(
					platformURI, true);
			resource.setTrackingModification(true);

			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMIResource.OPTION_ENCODING, "UTF-8");
			resource.save(options);
		}

	}
	
	@Override
	public void update(ResourceSubject subject) {
		if(subject instanceof ResourceSetEditedSubject){
			checkModel();
		}
	}
	
	private void checkModel() {
		Job job = new Job("Checking model"){

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				Status status = new Status(Status.OK, Constants.PLUGIN_ID, "OK!");
				try {
					Context.eINSTANCE.problemLogger.resetLogger();
					ModelChecker.eINSTANCE.execute(getBVRModel());
				} catch (Exception error) {
					Context.eINSTANCE.logger.error("Model check failed", error);
					status = new Status(Status.ERROR, Constants.PLUGIN_ID, "Model check failed (see log for more details): " + error.getMessage(), error);
				}
				return status;
			}
		};
		job.schedule();
	}
	
	@Override
	public void addChoice(NamedElement parent) {
		Choice c = BvrFactory.eINSTANCE.createChoice();
		c.setName("Choice "+choicCounter);
		
		//each vspec has to have target
		Target target = BvrFactory.eINSTANCE.createTarget();
		target.setName(c.getName());
		((CompoundNode) c).getOwnedTargets().add(target);
		c.setTarget(target);
		
		if(parent instanceof CompoundNode){
			Context.eINSTANCE.getEditorCommands().addChoice(c, (CompoundNode) parent);
		}else if (parent instanceof BVRModel){
			BVRModel model = (BVRModel) parent;
			if(model.getVariabilityModel() == null){
				Context.eINSTANCE.getEditorCommands().addChoice(c, model);
			}
		}
		choicCounter++;
	}

	@Override
	public void minimaizeVSpec(VSpec vspec) {
		minimizedVSpec.add(vspec);
	}

	@Override
	public void maximizeVSpec(VSpec vspec) {
		minimizedVSpec.remove(vspec);
	}

	@Override
	public boolean isVSpecMinimized(VSpec vspec) {
		return minimizedVSpec.contains(vspec);
	}
	
	@Override
	public void minimaizeVSpecResolution(VSpecResolution vspecRes) {
		minimizedVSpecResolution.add(vspecRes);
	}

	@Override
	public void maximizeVSpecResolution(VSpecResolution vspecRes) {
		minimizedVSpecResolution.remove(vspecRes);
	}

	@Override
	public boolean isVSpecResolutionMinimized(VSpecResolution vspecRes) {
		return minimizedVSpecResolution.contains(vspecRes);
	}
	
	@Override
	public void updateVariable(Variable variable, String name, String typeName){
		PrimitiveTypeFacade.getInstance().testModelsPrimitiveTypes(getBVRModel());
		
		if(name.equals("")){
			Context.eINSTANCE.getEditorCommands().removeVSpecVariable((VSpec)variable.eContainer(), variable);
			return;
		}
		
		Context.eINSTANCE.getEditorCommands().setName(variable, name);

	
		PrimitiveTypeEnum t = null;
        for(PrimitiveTypeEnum x : PrimitiveTypeEnum.VALUES){
        	if(x.getName().equals(typeName)){
        		t = x;
        	}
        }
        
        if(t == null)
        	throw new UnsupportedOperationException("Invalid primitive type name " + typeName);
        
        PrimitveType primitivType = PrimitiveTypeFacade.getInstance().testPrimitiveType(getBVRModel(), t);
        Context.eINSTANCE.getEditorCommands().setTypeForVariable(variable, primitivType);
	}
	
	@Override
	public void updateName(NamedElement namedElement, String name) {	
		//update corresponding target accordingly if namedElement is VClassifier or Choice
		if(namedElement instanceof VClassifier || namedElement instanceof Choice){
			Target target = TargetFacade.eINSTANCE.testVSpecTarget((VSpec) namedElement);
			Context.eINSTANCE.getEditorCommands().setName(target, name);
		}
		
		Context.eINSTANCE.getEditorCommands().setName(namedElement, name);
	}
	
	@Override
	public void updateComment(NamedElement namedElement, String text) {
		Note commentNote = NoteFacade.eINSTANCE.testCommentNote(namedElement);
		Context.eINSTANCE.getEditorCommands().updateNoteExp(commentNote, text);
	}
	
	@Override
	public String getNodesCommentText(NamedElement namedElement) {
		return NoteFacade.eINSTANCE.getCommentText(namedElement);
	}
	
	@Override
	public void addVariable(VNode parentNode) {
		Variable var = BvrFactory.eINSTANCE.createVariable();
		
		PrimitveType primitivType = PrimitiveTypeFacade.getInstance().testPrimitiveType(getBVRModel(), PrimitiveTypeEnum.INTEGER);
		var.setName("Var" + variableCount);
		variableCount++;
		var.setType(primitivType);
		
		Context.eINSTANCE.getEditorCommands().addVariable(parentNode, var);
	}
	
	@Override
	public void setVClassifierLowerBound(VClassifier vClassifier, int lowerBound) {
		MultiplicityInterval interval = vClassifier.getInstanceMultiplicity();
		Context.eINSTANCE.getEditorCommands().setGroupMultiplicityLowerBound(interval, lowerBound);
	}
	
	@Override
	public void setVClassifierUpperBound(VClassifier vClassifier, int upperBound) {
		MultiplicityInterval interval = vClassifier.getInstanceMultiplicity();
		Context.eINSTANCE.getEditorCommands().setGroupMultiplicityUpperBound(interval, upperBound);
	}
	
	@Override
	public void addVClassifier(NamedElement parent) {
		VClassifier c = BvrFactory.eINSTANCE.createVClassifier();
		c.setName("Classifier"+classifierCount);
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(1);
		mi.setUpper(1);
		c.setInstanceMultiplicity(mi);
		
		//each vspec has to have target
		Target target = BvrFactory.eINSTANCE.createTarget();
		target.setName(c.getName());
		((CompoundNode) c).getOwnedTargets().add(target);
		c.setTarget(target);
		
		if(parent instanceof CompoundNode){
			Context.eINSTANCE.getEditorCommands().addVClassifierToVSpec((CompoundNode) parent, c);
		}else if(parent instanceof BVRModel) {
			BVRModel model = (BVRModel) parent;
			if(model.getVariabilityModel() == null)
				Context.eINSTANCE.getEditorCommands().addVClassifierToBVRModel(model, c);
		}
		classifierCount++;
	}
	
	@Override
	public void addBCLConstraint(VNode parentVNode) {
		ConstraintFacade.eINSTANCE.createBCLConstraint(parentVNode);
	}
	
	@Override
	public void updateBCLConstraint(BCLConstraint constraint, String strConstr) {
		ConstraintFacade.eINSTANCE.updateBCLConstraint(bvrm.getRootBVRModel(), constraint, strConstr);
	}
	
	@Override
	public void toggleChoiceOptionalMandotary(Choice choice) {
		Context.eINSTANCE.getEditorCommands().setIsImpliedByParent(choice, !choice.isIsImpliedByParent());
	}
	
	@Override
	public void cutNamedElement(NamedElement namedElement) {
		EObject parent = namedElement.eContainer();
		if(namedElement instanceof VNode){
			if(parent instanceof CompoundNode && namedElement instanceof VNode){
				Context.eINSTANCE.getEditorCommands().removeVNodeCompoundNode((CompoundNode) parent, (VNode) namedElement);
			}else if (parent instanceof BVRModel && namedElement instanceof CompoundNode) {
				Context.eINSTANCE.getEditorCommands().removeVariabilityModelBVRModel((BVRModel) parent, (CompoundNode) namedElement);
			}else{
				throw new UnexpectedException("not supported operation");
			}
		}else {
			throw new UnsupportedOperationException("Cut is not implemented for anything other than VNode " + namedElement);
		}		
		cutNamedElement = namedElement;
	}
	
	@Override
	public void pastNamedElementAsChild(NamedElement parent) {
		if(cutNamedElement != null){
			if(parent instanceof CompoundNode && cutNamedElement instanceof VNode){
				Context.eINSTANCE.getEditorCommands().addVNodeToCompoundNode((CompoundNode) parent, (VNode) cutNamedElement);
			} else if (parent instanceof BVRModel && cutNamedElement instanceof CompoundNode) {
				Context.eINSTANCE.getEditorCommands().addVariabilityModelToBVRModel((BVRModel) parent, (CompoundNode) cutNamedElement);
			}else{
				throw new UnexpectedException("not supported operation");
			}
			cutNamedElement = null;
		}
	}
	
	@Override
	public void pastNamedElementAsSibling(NamedElement sibling) {
		if(cutNamedElement != null){
			EObject parent = sibling.eContainer();
			if(parent instanceof CompoundNode && cutNamedElement instanceof VNode){
				Context.eINSTANCE.getEditorCommands().addVNodeToCompoundNode((CompoundNode) parent, (VNode) cutNamedElement);
			} else{
				throw new UnexpectedException("not supported operation");
			}
			cutNamedElement = null;
		}		
	}
	
	@Override
	public void setGroupMultiplicity(VNode parent, int lowerBound, int upperBound) {
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(lowerBound);
		mi.setUpper(upperBound);
		Context.eINSTANCE.getEditorCommands().setVNodeGroupMultiplicity(parent, mi);
	}
	
	@Override
	public void removeGroupMultiplicity(VNode parent) {
		Context.eINSTANCE.getEditorCommands().setVNodeGroupMultiplicity(parent, null);
	}
	
	@Override
	public String getBCLConstraintString(BCLConstraint constraint) {
		return ConstraintFacade.eINSTANCE.getBCLConstraintString(bvrm.getRootBVRModel(), constraint);
	}
	
	@Override
	public void removeNamedElement(NamedElement element) {
		EObject parent = element.eContainer();
		if(parent != null){
			if(parent instanceof CompoundNode){
				if(element instanceof Constraint){
					Context.eINSTANCE.getEditorCommands().removeConstraintCompoundNode((CompoundNode) parent, (Constraint) element);
				} else if(element instanceof VNode){
					Context.eINSTANCE.getEditorCommands().removeVNodeCompoundNode((CompoundNode) parent, (VNode) element);
				}else {
					throw new UnexpectedException("can not remove " + element + " with parent " + parent);
				}
			}else if(parent instanceof BVRModel){
				Context.eINSTANCE.getEditorCommands().removeVariabilityModelBVRModel((BVRModel) parent, (CompoundNode) element);
			}else {
				throw new UnexpectedException("can not remove " + element + " with parent " + parent);
			}
		}else{
			throw new UnexpectedException("can not find parent element to remove " + element);
		}
	}
	
	@Override
	public void deletePlacements(EList<VariationPoint> placements) {
		if(placements.size() > 0)
			Context.eINSTANCE.getEditorCommands().removeOwenedVariationPoints(getBVRModel(), placements);
	}
	
	@Override
	public void deleteReplacements(EList<Variabletype> replacements) {
		if(replacements.size() > 0)
			Context.eINSTANCE.getEditorCommands().removeOwnedVariationTypes(getBVRModel(), replacements);
	}
	
	@Override
	public void deleteFragments(EList<VariationPoint> fslist) {
		if(fslist.size() > 0)
			Context.eINSTANCE.getEditorCommands().removeOwenedVariationPoints(getBVRModel(), fslist);
	}
}
