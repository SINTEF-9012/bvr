package no.sintef.bvr.tool.ui.loader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import no.sintef.bvr.common.logging.ResetableLogger;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.observer.ResourceObserver;
import no.sintef.bvr.tool.observer.ResourceSetEditedSubject;
import no.sintef.bvr.tool.observer.ResourceSubject;




import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import bvr.BVRModel;

public class BVRTransactionalModel extends BVRToolModel implements ResourceObserver {
	private Resource resource;
	
	public BVRTransactionalModel(File sf, no.sintef.ict.splcatool.SPLCABVRModel x) {
		bvrm = x;
		f = sf;
		loadFilename = sf.getAbsolutePath();
	}

	public BVRTransactionalModel(File sf) {
		f = sf;
		bvrm = new BVRInnerModel(f);
		loadFilename = sf.getAbsolutePath();
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
			Context.eINSTANCE.problemLogger.resetLogger();
		}
	}
	

}
