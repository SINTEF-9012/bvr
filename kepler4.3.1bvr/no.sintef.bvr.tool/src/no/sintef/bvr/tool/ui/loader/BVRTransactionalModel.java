package no.sintef.bvr.tool.ui.loader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import no.sintef.bvr.tool.context.Context;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import bvr.ConfigurableUnit;

public class BVRTransactionalModel extends BVRModel {
	private no.sintef.ict.splcatool.BVRModel bvrm;
	private File f;
	private boolean platform = false;
	private String loadFilename;
	private boolean saved = true;

	public BVRTransactionalModel() {

	}

	public BVRTransactionalModel(File sf, no.sintef.ict.splcatool.BVRModel x) {
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
	public no.sintef.ict.splcatool.BVRModel getBVRM() {
		return bvrm;
	}

	@Override
	public ConfigurableUnit getCU() {
		return bvrm.getCU();
	}

	@Override
	public File getFile() {
		return f;
	}

	private class BVRInnerModel extends no.sintef.ict.splcatool.BVRModel {
		private ConfigurableUnit cu = null;

		public BVRInnerModel(File f) {
			cu = loadFromFile(f);
		}

		@Override
		public ConfigurableUnit getCU() {
			return cu;
		}

		private ConfigurableUnit loadFromFile(File file) {
			TransactionalEditingDomain editingDomain = Context.eINSTANCE.getEditorCommands().testTransactionalEditingDomain();

			URIConverter converter = new ExtensibleURIConverterImpl();
			URI emptyFileURI = URI.createFileURI(ResourcesPlugin.getWorkspace()
					.getRoot().getLocation().toOSString() + File.separator);
			URI emptyPlatformURI = URI.createPlatformResourceURI("/", false);
			converter.getURIMap().put(emptyFileURI, emptyPlatformURI);
			URI platformURI = converter.normalize(URI.createFileURI(file
					.getAbsolutePath()));

			Resource resource = editingDomain.getResourceSet().getResource(
					platformURI, true);

			return (ConfigurableUnit) resource.getContents().get(0);
		}

		public void writeToFile(String filename) throws IOException {

			TransactionalEditingDomain editingDomain = Context.eINSTANCE.getEditorCommands().testTransactionalEditingDomain();
			
			URIConverter converter = new ExtensibleURIConverterImpl();
			URI emptyFileURI = URI.createFileURI(ResourcesPlugin.getWorkspace()
					.getRoot().getLocation().toOSString() + File.separator);
			URI emptyPlatformURI = URI.createPlatformResourceURI("/", false);
			converter.getURIMap().put(emptyFileURI, emptyPlatformURI);
			URI platformURI = converter.normalize(URI.createFileURI(filename));

			Resource resource = editingDomain.getResourceSet().getResource(
					platformURI, true);

			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMIResource.OPTION_ENCODING, "UTF-8");
			resource.save(options);
		}

	}
}
