package org.bangbangbang.cvl.m2m.popup.actions;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public abstract class AbstractCVLTransform implements IHandler {
	private String qvtoURI = null;
	private String addingPostfix = null;

	public void setQvtoURI(String qvtoURI) {
		this.qvtoURI = qvtoURI;
	}

	public void setAddingPostfix(String addingPostfix) {
		this.addingPostfix = addingPostfix;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Check , cvl file
		IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);
		ISelectionService service = window.getSelectionService();
		IStructuredSelection structured = (IStructuredSelection) service
				.getSelection();
		IFile inputFile = (IFile) structured.getFirstElement();
		IPath inputPath = inputFile.getLocation();

		// Show dialog for inputting output file name
		FileDialog dialog = new FileDialog(HandlerUtil.getActiveShell(event),
				SWT.SAVE);
		dialog.setText("Select CVL file for output");
		dialog.setFilterPath(inputFile.getParent().getLocation().toString()
				+ File.separator);
		dialog.setFilterExtensions(new String[] { "*.cvl" });
		dialog.setFileName(inputFile.getName().replaceAll(".cvl", addingPostfix + ".cvl"));
		String outputPathString = dialog.open();
		if (outputPathString == null) {
			return null;
		}
		// Invoke qvt operational
		URI transformationURI = URI
				.createURI(qvtoURI);
		// create executor for the given transformation
		TransformationExecutor executor = new TransformationExecutor(
				transformationURI);

		// define the transformation input
		// Remark: we take the objects from a resource, however
		// a list of arbitrary in-memory EObjects may be passed
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("cvl", new XMIResourceFactoryImpl());
		Resource inResource = resourceSet.getResource(
				URI.createURI("file://" + inputPath.toString()), true);
		EList<EObject> inObjects = inResource.getContents();

		// create the input extent with its initial contents
		ModelExtent input = new BasicModelExtent(inObjects);
		// create an empty extent to catch the output
		ModelExtent output = new BasicModelExtent();

		// setup the execution environment details ->
		// configuration properties, logger, monitor object etc.
		ExecutionContextImpl executionContext = new ExecutionContextImpl();
		executionContext.setConfigProperty("keepModeling", true);

		// run the transformation assigned to the executor with the given
		// input and output and execution context -> ChangeTheWorld(in, out)
		// Remark: variable arguments count is supported
		ExecutionDiagnostic result = executor.execute(executionContext, input,
				output);

		// check the result for success
		if (result.getSeverity() == Diagnostic.OK) {
			// the output objects got captured in the output extent
			List<EObject> outObjects = output.getContents();
			// let's persist them using a resource
			ResourceSet resourceSet2 = new ResourceSetImpl();
			resourceSet2.getResourceFactoryRegistry()
					.getExtensionToFactoryMap()
					.put("cvl", new XMIResourceFactoryImpl());
			Resource outResource = resourceSet2
					.createResource(URI.createURI("file://"
							+ outputPathString.replace('\\', '/')));
			outResource.getContents().addAll(outObjects);
			try {
				outResource.save(Collections.emptyMap());
				//TODO manual refresh 
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// turn the result diagnostic into status and send it to error log
			IStatus status = BasicDiagnostic.toIStatus(result);
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}
	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {

	}

}
