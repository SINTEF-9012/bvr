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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IWorkbenchWindow;

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
		filepath = (filepath.endsWith(File.separator)) ? filepath : filepath + File.separator;
		filepath = filepath.replaceAll("\\\\", "/");
		if(!filepath.startsWith(Utility.getWorkspaceRowLocation())){
			throw new UnsupportedOperationException("can not save file, incorrect loacation");
		}
		filepath = filepath.replaceAll(Utility.getWorkspaceRowLocation(), "");
		final HashMap<ResourceSet, String> messages = new HashMap<ResourceSet, String>();
		
		for(Map.Entry<Resource, ResourceContentCopier> entry : baseProductMap.entrySet()){
			final Resource resource = entry.getKey();
			
			URI resourceURI = resource.getURI();
			String baseName = resourceURI.segment(resourceURI.segmentCount() - 1);
			String productName = prefix + "_" + baseName;
			String productFullName = filepath + productName;
			
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		    final ResourceSet resSet = new ResourceSetImpl();
		    URI uri = URI.createPlatformResourceURI(productFullName, true);
		    LOG.debug("saving a product to the file file " + uri);
		    final Resource productResource = resSet.createResource(uri);
		    
		    TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resSet);
		    editingDomain.addResourceSetListener(new ResourceSetListenerImpl(){

				@Override
				public void resourceSetChanged(ResourceSetChangeEvent event) {
					Transaction transaction = event.getTransaction();
					HashMap<String, Object> info = Utility.parseTransaction(transaction);
					if((Boolean) info.get(Utility.isOk))
						return;
					event.getEditingDomain().getResourceSet();
					messages.put(event.getEditingDomain().getResourceSet(), (String) info.get(Utility.message));
				}
		    	
		    });
		    
		    editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				
				@Override
				protected void doExecute() {
				    //TO DO:
				    //we should actually save a copy of the base model which we copied in the first place before all transformations,
					//but the engine currently performs substitutions on the base model;
					//thus we simply copy the contents of the base model and save it
				    //ResourceContentCopier product = entry.getValue();
				    //productResource.getContents().addAll(product.values());
					
				    productResource.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));
				    Map<Object, Object> options = new HashMap<Object, Object>();
					options.put(XMIResource.OPTION_ENCODING, ((XMIResource) resource).getEncoding());
					try {
						productResource.save(options);
					} catch (Exception e) {
						String stackTrace = no.sintef.cvl.ui.common.Utility.getStackTraceAsString(e);
						LOG.error(stackTrace);
						messages.put(resSet, e.getMessage());
					}
				}
			});
		}
		
		if(!messages.isEmpty()){
			String throwMessage = new String();
			for(Map.Entry<ResourceSet, String> message : messages.entrySet()){
				ResourceSet resSet = message.getKey();
				String msg = message.getValue();
				throwMessage += resSet.getResources() + " : " + msg + "\n";
			}
			throw new UnsupportedOperationException(throwMessage);
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
