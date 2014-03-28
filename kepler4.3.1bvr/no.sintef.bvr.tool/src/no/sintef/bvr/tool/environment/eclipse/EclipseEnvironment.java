package no.sintef.bvr.tool.environment.eclipse;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.engine.common.ResourceContentCopier;
import no.sintef.bvr.engine.error.ContainmentBVRModelException;
import no.sintef.bvr.thirdparty.common.PluginLogger;
import no.sintef.bvr.thirdparty.common.Utility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.context.ThirdpartyEditorSelector;
import no.sintef.bvr.tool.environment.AbstractEnvironment;
import no.sintef.bvr.tool.environment.ConfigHelper;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.primitive.Symbol;
import no.sintef.bvr.tool.ui.editor.RestrictedJFileChooser;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.ui.editor.commands.EditorCommands;
import no.sintef.bvr.ui.editor.commands.EditorEMFTransactionalCommands;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
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

import bvr.ConfigurableUnit;
import bvr.FragmentSubstitution;

public class EclipseEnvironment extends AbstractEnvironment {
	
	private IWorkbenchWindow iworkbench;
	private ThirdpartyEditorSelector editorselector;
	private Logger logger = PluginLogger.getLogger();
	private ConfigHelper configHelper = EclipseConfigHelper.getConfig();
	EList<TransactionalEditingDomain> editingDomains;
	private EditorCommands commands = EditorEMFTransactionalCommands.Get();
	

	public EclipseEnvironment(IWorkbenchWindow workbench) {
		iworkbench = workbench;
		ThirdpartyEditorSelector.setWorkbeach(iworkbench);
		editorselector = ThirdpartyEditorSelector.getEditorSelector();
		editingDomains = new BasicEList<TransactionalEditingDomain>();
	}

	@Override
	public BVRModel loadModelFromFile(File file) {
		String platformPath = Utility.findFileInWorkspace(file);
		if(platformPath == null){
			throw new UnsupportedOperationException("can not locate a selected file in the workspace: " + file.getAbsolutePath());
		}
		String filePath = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator));
		configHelper.saveLastLocation(filePath);
		return new BVRModel(file, platformPath, true);
	}

	@Override
	public void writeModelToFile(BVRModel model, File file) {
		String filepath = file.getAbsolutePath().replaceAll("\\\\", "/");
		if(!filepath.startsWith(Utility.getWorkspaceRowLocation())){
			throw new UnsupportedOperationException("can not a VM model to the file, incorrect loacation: use workspace location");
		}
		filepath = filepath.replaceAll(Utility.getWorkspaceRowLocation(), "");
		try {
			model.getBVRM().writeToPlatformFile(filepath);
			model.setFile(file);
			model.setPlatform(true);
			model.setLoadFilename(filepath);
			String filePath = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator));
			configHelper.saveLastLocation(filePath);
		} catch (IOException e) {
			logger.error("can not save file, IOException", e);
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
			throw new UnsupportedOperationException("can not save a product to the file, incorrect loacation: use workspace location");
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
		    logger.debug("saving a product to the file file " + uri);
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
						logger.error("some exception", e);
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
	
	public TransactionalEditingDomain getEdititingDomain(EList<TransactionalEditingDomain> editingDomains, ResourceSet resSet){
		for(TransactionalEditingDomain domain : editingDomains){
			if(domain.getResourceSet().equals(resSet))
				return domain;
		}
		return null;
	}
	
	@Override
	public void performSubstitutions(List<Symbol> symbols) {
		final HashMap<FragmentSubstitution, String> messagesFS = new HashMap<FragmentSubstitution, String>();
		final HashMap<ResourceSet, String> messagesRS = new HashMap<ResourceSet, String>();
		for(final Symbol symbol : symbols){
			logger.debug("processing Symbol " + symbol.getVSpec());
			EList<FragmentSubstitution> fragments = symbol.getFragmentSubstitutionsToExecute();
			
			ConfigurableUnit cu = symbol.getScope().getConfigurableUnit();
			ResourceSet resSet = cu.eResource().getResourceSet();
			TransactionalEditingDomain editingDomain = getEdititingDomain(editingDomains, resSet);
			if(editingDomain == null){
				editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resSet);
				editingDomain.addResourceSetListener(new ResourceSetListenerImpl(){

					@Override
					public void resourceSetChanged(ResourceSetChangeEvent event) {
						Transaction transaction = event.getTransaction();
						HashMap<String, Object> info = Utility.parseTransaction(transaction);
						if((Boolean) info.get(Utility.isOk))
							return;
						event.getEditingDomain().getResourceSet();
						messagesRS.put(event.getEditingDomain().getResourceSet(), (String) info.get(Utility.message));
					}
			    	
			    });
				editingDomains.add(editingDomain);
			}
			
			for(final FragmentSubstitution fragment : fragments){
				logger.debug("processing FragmentSubstitution " + fragment);
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					
					@Override
					protected void doExecute() {
						try {
							Context.eINSTANCE.getSubEngine().subsitute(fragment, !symbol.getMulti());
						} catch (ContainmentBVRModelException e) {
							logger.error("bvr model failure", e);
							messagesFS.put(fragment, "bvr model failure:" + e.getMessage());
						} catch (Exception e){
							logger.error("some exception", e);
							messagesFS.put(fragment, "some exception: " + e.getMessage());
						}
					}
				});
			}
		}
		
		if(!messagesRS.isEmpty() || !messagesFS.isEmpty()){
			String throwMessage = new String();
			for(Map.Entry<ResourceSet, String> message : messagesRS.entrySet()){
				ResourceSet resSet = message.getKey();
				String msg = message.getValue();
				throwMessage += "Resource problem " + resSet.getResources() + " : " + msg + "\n";
			}
			for(Map.Entry<FragmentSubstitution, String> message : messagesFS.entrySet()){
				FragmentSubstitution fs = message.getKey();
				String msg = message.getValue();
				throwMessage += "Execution exception for FS " + fs.getName() + " : " + msg + "\n";
			}
			throw new UnsupportedOperationException(throwMessage);
		}
	}

	@Override
	public void reloadModel(BVRModel model) {
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
		String lastLocation = configHelper.lastLocation().replaceAll("\\\\", "/");
		if(lastLocation.startsWith(path))
			fc.setCurrentDirectory(new File(lastLocation));
		configHelper.saveLastLocation(fc.getCurrentDirectory().getAbsolutePath());
		return fc;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}
	
	@Override
	public ConfigHelper getConfig() {
		return configHelper;
	}

	@Override
	public EditorCommands getEditorCommands() {
		return commands;
	}
	
	@Override
	public void disposeModel(BVRModel model) {
		IFile iFile = Utility.findIFileInWorkspaceFile(model.getFile());
		try {
			iFile.delete(true, null);
		} catch (CoreException e) {
			throw new RethrownException("failed to remove file", e);
		}
		model.dispose();
	}

}
