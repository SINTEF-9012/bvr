package no.sintef.bvr.tool.ui.loader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import no.sintef.bvr.tool.checker.ModelChecker;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.model.NoteFactory;
import no.sintef.bvr.tool.model.PrimitiveTypeFactory;
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import bvr.BVRModel;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.Note;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitveType;
import bvr.Target;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.Variable;

public class BVRTransactionalModel extends BVRToolModel implements ResourceObserver {
	private Resource resource;
	
	static private int choicCounter = 0;
	static private int variableCount = 0;
	static private int classifierCount = 0;
	
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
	public void addChoice(VSpec parentVSpec) {
		Choice c = BvrFactory.eINSTANCE.createChoice();
		c.setName("Choice "+choicCounter);
		
		//each vspec has to have target
		Target target = BvrFactory.eINSTANCE.createTarget();
		target.setName(c.getName());
		((CompoundNode) c).getOwnedTargets().add(target);
		
		if(parentVSpec != null){
			Context.eINSTANCE.getEditorCommands().addChoice(c, (CompoundNode) parentVSpec);
		}else{
			BVRModel model = bvrm.getRootBVRModel();
			if(model.getVariabilityModel() == null){
				Context.eINSTANCE.getEditorCommands().addChoice(c, model);
			}
		}
		choicCounter++;
	}

	@Override
	public void minimaizeVSpec(VSpec vspec) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void maximizeVSpec(VSpec vspec) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVSpecMinimized(VSpec vspec) {
		return minimizedVSpec.contains(vspec);
	}
	
	@Override
	public void minimaizeVSpecResolution(VSpecResolution vspecRes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void maximizeVSpecResolution(VSpecResolution vspecRes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVSpecResolutionMinimized(VSpecResolution vspecRes) {
		return minimizedVSpecResolution.contains(vspecRes);
	}
	
	@Override
	public void updateVariable(Variable variable, String name, String typeName){
		PrimitiveTypeFactory.getInstance().testModelsPrimitiveTypes(getBVRModel());
		
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
        
        PrimitveType primitivType = PrimitiveTypeFactory.getInstance().testPrimitiveType(getBVRModel(), t);
        Context.eINSTANCE.getEditorCommands().setTypeForVariable(variable, primitivType);
	}
	
	@Override
	public void updateName(NamedElement namedElement, String name) {
		Context.eINSTANCE.getEditorCommands().setName(namedElement, name);
	}
	
	@Override
	public void updateComment(NamedElement namedElement, String text) {
		Note commentNote = NoteFactory.eINSTANCE.testCommentNote(namedElement);
		Context.eINSTANCE.getEditorCommands().updateNoteExp(commentNote, text);
	}
	
	@Override
	public String getNodesCommentText(NamedElement namedElement) {
		Note commentNote = NoteFactory.eINSTANCE.testCommentNote(namedElement);
		return commentNote.getExpr();
	}
	
	@Override
	public void addVariable(VNode parentNode) {
		Variable var = BvrFactory.eINSTANCE.createVariable();
		
		PrimitveType primitivType = PrimitiveTypeFactory.getInstance().testPrimitiveType(getBVRModel(), PrimitiveTypeEnum.INTEGER);
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
	public void addVClassifier(VSpec parentVSpec) {
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
		
		if(parentVSpec != null){
			Context.eINSTANCE.getEditorCommands().addVClassifierToVSpec((CompoundNode) parentVSpec, c);
		}else{
			BVRModel model = bvrm.getRootBVRModel();
			if(model.getVariabilityModel() == null)
				Context.eINSTANCE.getEditorCommands().addVClassifierToBVRModel(model, c);
		}
		classifierCount++;
	}
}
