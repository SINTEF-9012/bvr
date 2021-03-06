/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.environment.eclipse;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;

import no.sintef.bvr.common.engine.error.ContainmentBVRModelException;
import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.common.logging.ResetableLogger;
import no.sintef.bvr.engine.interfaces.common.IResourceContentCopier;
import no.sintef.bvr.thirdparty.common.PluginLogger;
import no.sintef.bvr.thirdparty.common.ProblemLoger;
import no.sintef.bvr.thirdparty.common.Utility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.context.ThirdpartyEditorSelector;
import no.sintef.bvr.tool.environment.AbstractEnvironment;
import no.sintef.bvr.tool.environment.ConfigHelper;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.interfaces.model.IBVREditingDomain;
import no.sintef.bvr.tool.model.BVREditingDomainFacade;
import no.sintef.bvr.tool.model.BVRSimpleToolModel;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.primitive.SymbolVSpec;
import no.sintef.bvr.tool.ui.editor.RestrictedJFileChooser;
import no.sintef.bvr.ui.editor.commands.EditorCommands;
import no.sintef.bvr.ui.editor.commands.EditorEMFTransactionalCommands;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IWorkbenchWindow;

import bvr.FragmentSubstitution;

public class EclipseEnvironment extends AbstractEnvironment {

	private IWorkbenchWindow iworkbench;
	private ThirdpartyEditorSelector editorselector;
	private Logger logger = PluginLogger.getLogger();
	private ResetableLogger problemLogger = ProblemLoger.getLogger();

	private ConfigHelper configHelper = EclipseConfigHelper.getConfig();
	private EditorCommands commands = EditorEMFTransactionalCommands.Get();
	private IBVREditingDomain currentExecutionEditingDomain;

	public EclipseEnvironment(IWorkbenchWindow workbench) {
		iworkbench = workbench;
		ThirdpartyEditorSelector.setWorkbeach(iworkbench);
		editorselector = ThirdpartyEditorSelector.getEditorSelector();
	}

	@Override
	public BVRToolModel loadModelFromFile(File file) {
		String platformPath = Utility.findFileInWorkspace(file);
		if (platformPath == null) {
			throw new UnsupportedOperationException("can not locate a selected file in the workspace: " + file.getAbsolutePath());
		}
		String filePath = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator));
		configHelper.saveLastLocation(filePath);
		return new BVRSimpleToolModel(file, platformPath, true);
	}

	@Override
	public void writeModelToFile(BVRToolModel model, File file) {
		String filepath = file.getAbsolutePath().replaceAll("\\\\", "/");
		if (!filepath.startsWith(Utility.getWorkspaceRowLocation())) {
			throw new UnsupportedOperationException("can not a VM model to the file, incorrect loacation: use workspace location");
		}
		filepath = filepath.replaceAll(Utility.getWorkspaceRowLocation(), "");
		try {
			model.getSPLCABVRModel().writeToPlatformFile(filepath);
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
	public void writeProductsToFiles(HashMap<Resource, IResourceContentCopier> baseProductMap, File file) {
		logger.debug("file absolute path to save product " + file.getAbsolutePath());
		String prefix = file.getName();
		String filepath = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator));
		filepath = (filepath.endsWith(File.separator)) ? filepath : filepath + File.separator;
		filepath = filepath.replaceAll("\\\\", "/");
		logger.debug("workspace location " + Utility.getWorkspaceRowLocation());
		if (!filepath.startsWith(Utility.getWorkspaceRowLocation()))
			throw new UnsupportedOperationException("can not save a product to the file, incorrect loacation: use workspace location");

		filepath = filepath.replaceAll(Utility.getWorkspaceRowLocation(), "");
		final HashMap<ResourceSet, String> messages = new HashMap<ResourceSet, String>();

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();

		IBVREditingDomain executionEditingDomain = getCurrentExecutionEditingDomain();

		if (executionEditingDomain == null) {
			logger.warn("current editing domain is not set, creating one to perform fragment substitutions. This can cause 'cannot modify without a write transaction' exception if model is openned in another transaction domain");
			executionEditingDomain = BVREditingDomainFacade.eINSTANCE.testExecutionEditingDomain(resSet);
		}

		TransactionalEditingDomain editingDomain = executionEditingDomain.getEditingDomain();

		for (Map.Entry<Resource, IResourceContentCopier> entry : baseProductMap.entrySet()) {
			final Resource resource = entry.getKey();

			URI resourceURI = resource.getURI();
			String baseName = resourceURI.segment(resourceURI.segmentCount() - 1);
			String productName = prefix + "_" + baseName;
			String productFullName = filepath + productName;

			logger.debug("product project uri " + productFullName);
			URI uri = URI.createPlatformResourceURI(productFullName, false);
			logger.debug("saving the product to file with platform uri " + uri);
			Resource productResource = resSet.createResource(uri);

			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					productResource.getContents().addAll(baseProductMap.get(resource).getCopiedContents(resource));

				}

			});

		}

		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				//TO DO:
				//we should actually save a copy of the base model which we copied in the first place before all transformations,
				//but the engine currently performs substitutions on the base model;
				//thus we simply copy the contents of the base model and save it
				//ResourceContentCopier product = entry.getValue();
				//productResource.getContents().addAll(product.values());

				//productResource.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));

				for (Resource resource : resSet.getResources()) {

					//IResourceContentCopier product = entry.getValue();
					//productResource.getContents().addAll(product.getCopiedContents(resource));

					Map<Object, Object> options = new HashMap<Object, Object>();
					options.put(XMIResource.OPTION_ENCODING, ((XMIResource) resource).getEncoding());
					try {
						resource.save(options);
					} catch (Exception e) {
						logger.error("some exception", e);
						messages.put(resSet, e.getMessage());
					}
				}
			}
		});

		if (!messages.isEmpty()) {
			String throwMessage = new String();
			for (Map.Entry<ResourceSet, String> message : messages.entrySet()) {
				ResourceSet resSet1 = message.getKey();
				String msg = message.getValue();
				throwMessage += resSet1.getResources() + " : " + msg + "\n";
			}
			throw new UnsupportedOperationException(throwMessage);
		}

		List<String> error_messages = executionEditingDomain.getErrorMessages();
		if (!error_messages.isEmpty()) {
			String throwMessage = new String();
			for (String message : error_messages) {
				throwMessage += executionEditingDomain.getResourceSet().getResources() + " : " + message + "\n";
			}
			throw new UnsupportedOperationException(throwMessage);
		}
	}

	@Override
	public void performSubstitutions(List<SymbolVSpec> symbols) {
		final HashMap<FragmentSubstitution, String> messagesFS = new HashMap<FragmentSubstitution, String>();
		IBVREditingDomain executionEditingDomain = getCurrentExecutionEditingDomain();

		for (final SymbolVSpec symbol : symbols) {
			logger.debug("processing Symbol " + symbol.getVSpec());
			EList<FragmentSubstitution> fragments = symbol.getFragmentSubstitutionsToExecute();
			TransactionalEditingDomain editingDomain = executionEditingDomain.getEditingDomain();

			for (final FragmentSubstitution fragment : fragments) {
				logger.debug("processing FragmentSubstitution " + fragment);
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

					@Override
					protected void doExecute() {
						try {
							Context.eINSTANCE.getSubEngine().subsitute(fragment, !symbol.getMulti());
						} catch (ContainmentBVRModelException e) {
							logger.error("bvr model failure", e);
							messagesFS.put(fragment, "bvr model failure:" + e.getMessage());
						} catch (Exception e) {
							logger.error("some exception", e);
							messagesFS.put(fragment, "some exception: " + e.getMessage());
						}
					}
				});
			}
		}

		List<String> messagesRS = executionEditingDomain.getErrorMessages();

		if (!messagesRS.isEmpty() || !messagesFS.isEmpty()) {
			String throwMessage = new String();
			for (String message : messagesRS) {
				throwMessage += "Resource problem " + executionEditingDomain.getResourceSet().getResources() + " : " + message + "\n";
			}
			for (Map.Entry<FragmentSubstitution, String> message : messagesFS.entrySet()) {
				FragmentSubstitution fs = message.getKey();
				String msg = message.getValue();
				throwMessage += "Execution exception for FS " + fs.getName() + " : " + msg + "\n";
			}
			throw new UnsupportedOperationException(throwMessage);
		}
	}

	@Override
	public void reloadModel(BVRToolModel model) {
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
	public void highlightObjects(EList<HashMap<EObject, Integer>> objectsToHighlightList) {
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
		if (lastLocation.startsWith(path))
			fc.setCurrentDirectory(new File(lastLocation));
		configHelper.saveLastLocation(fc.getCurrentDirectory().getAbsolutePath());
		return fc;
	}

	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public ResetableLogger getProblemLogger() {
		return problemLogger;
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
	public void disposeModel(BVRToolModel model) {
		IFile iFile = Utility.findIFileInWorkspaceFile(model.getFile());
		try {
			iFile.delete(true, null);
		} catch (CoreException e) {
			throw new RethrownException("failed to remove file", e);
		}
		model.dispose();
	}

	@Override
	public void setCurrentExecutionEditingDomain(IBVREditingDomain editingDomain) {
		currentExecutionEditingDomain = editingDomain;
	}

	@Override
	public IBVREditingDomain getCurrentExecutionEditingDomain() {
		return currentExecutionEditingDomain;
	}

}
