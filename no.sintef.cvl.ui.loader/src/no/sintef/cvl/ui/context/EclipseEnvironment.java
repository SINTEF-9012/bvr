package no.sintef.cvl.ui.context;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;

import no.sintef.cvl.engine.common.ResourceContentCopier;
import no.sintef.cvl.thirdparty.common.Utility;
import no.sintef.cvl.ui.common.ThirdpartyEditorSelector;
import no.sintef.cvl.ui.editor.RestrictedJFileChooser;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.FileHelper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ui.IWorkbenchWindow;

import splar.plugins.configuration.bdd.javabdd.catalog.Product;

public class EclipseEnvironment extends AbstractEnvironment {
	
	private IWorkbenchWindow iworkbench;
	private ThirdpartyEditorSelector editorselector;
	

	public EclipseEnvironment(IWorkbenchWindow workbench) {
		iworkbench = workbench;
		ThirdpartyEditorSelector.setWorkbeach(iworkbench);
		editorselector = ThirdpartyEditorSelector.getEditorSelector();
	}

	@Override
	public CVLModel loadModelFromFile(File file) {
		String platformPath = Utility.findFileInWorkspace(file);
		if(platformPath == null){
			throw new UnsupportedOperationException("can not locate a selected file in the workspace: " + file.getAbsolutePath());
		}
		String filePath = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator));
		FileHelper.saveLastLocation(filePath);
		return new CVLModel(file, platformPath, true);
	}

	@Override
	public void writeModelToFile(CVLModel model, File file) {
		String filepath = file.getAbsolutePath().replaceAll("\\\\", "/");
		if(!filepath.startsWith(Utility.getWorkspaceRowLocation())){
			throw new UnsupportedOperationException("can not save file, incorrect loacation");
		}
		filepath = filepath.replaceAll(Utility.getWorkspaceRowLocation(), "");
		try {
			model.getCVLM().writeToPlatformFile(filepath);
			model.setFile(file);
			model.setPlatform(true);
			model.setLoadFilename(filepath);
			String filePath = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator));
			FileHelper.saveLastLocation(filePath);
		} catch (IOException e) {
			String stackTrace = no.sintef.cvl.ui.common.Utility.getStackTraceAsString(e);
			LOG.error(stackTrace);
			throw new UnsupportedOperationException("can not save file, IOException " + e.getMessage());
		}
	}
	
	@Override
	public void writeProductsToFiles(HashMap<Resource, ResourceContentCopier> baseProductMap, File file) {
		String prefix = file.getName();
		String filepath = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator));
		filepath = filepath.replaceAll("\\\\", "/");
		if(!filepath.startsWith(Utility.getWorkspaceRowLocation())){
			throw new UnsupportedOperationException("can not save file, incorrect loacation");
		}
		filepath = filepath.replaceAll(Utility.getWorkspaceRowLocation(), "");
		
		for(Map.Entry<Resource, ResourceContentCopier> entry : baseProductMap.entrySet()){
			Resource resource = entry.getKey();
			ResourceContentCopier product = entry.getValue();
			
			URI resourceURI = resource.getURI();
			String baseName = resourceURI.segment(resourceURI.segmentCount() - 1);
			String productName = prefix + " " + baseName;
			String productFullName = filepath + productName;
			
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		    ResourceSet resSet = new ResourceSetImpl();
		    URI uri = URI.createPlatformResourceURI(productFullName, true);
		    Resource productResource = resSet.createResource(uri);
		    
		    //TO DO
		    //we should actually copy here a copy of the base model, but the engine currently
		    //performs substitutions on the base model
		    //productResource.getContents().addAll(product.values());
		    productResource.getContents().addAll(resource.getContents());
		    
		    Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMIResource.OPTION_ENCODING, ((XMIResource) resource).getEncoding());
			try {
				productResource.save(options);
			} catch (IOException e) {
				String stackTrace = no.sintef.cvl.ui.common.Utility.getStackTraceAsString(e);
				LOG.error(stackTrace);
			}
		}
	}

	@Override
	public void reloadModel(CVLModel model) {
		model.reload();
	}

	@Override
	public EObject getEObject(Object object) {
		return editorselector.getEObject(object);
	}

	@Override
	public List<Object> getSelections() {
		return editorselector.getSelections();
	}

	@Override
	public void highlightObjects(
			EList<HashMap<EObject, Integer>> objectsToHighlightList) {
		editorselector.highlightObjects(objectsToHighlightList);
	}

	@Override
	public void clearHighlights() {
		editorselector.clearHighlights();
	}

	@Override
	public JFileChooser getFileChooser() {
		String path = Utility.getWorkspaceRowLocation();
		RestrictedJFileChooser fc = new RestrictedJFileChooser(path);
		String lastLocation = FileHelper.lastLocation().replaceAll("\\\\", "/");
		if(lastLocation.startsWith(path))
			fc.setCurrentDirectory(new File(lastLocation));
		return fc;
	}
}
