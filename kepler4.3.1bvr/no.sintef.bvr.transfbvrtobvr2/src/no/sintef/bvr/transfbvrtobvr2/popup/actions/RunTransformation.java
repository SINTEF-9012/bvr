package no.sintef.bvr.transfbvrtobvr2.popup.actions;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.sintef.bvr.transfbvrtobvr2.Activator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

public class RunTransformation implements IObjectActionDelegate {

	private Shell shell;
	
	/**
	 * Constructor for Action1.
	 */
	public RunTransformation() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		
		ISelectionService ssr = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = ssr.getSelection();
		if(!(selection instanceof StructuredSelection)){
			MessageDialog.openWarning(shell, "No Selection", "Can not find any selection...");
			return;
		}
		
		StructuredSelection strSelection = (StructuredSelection) selection;
		Object obj = strSelection.getFirstElement();
		IFile file = (IFile) Platform.getAdapterManager().getAdapter(obj, IFile.class);
		
		final String fileName = file.getLocation().segment(file.getLocation().segmentCount() -1);
		InputDialog inputDialog = new InputDialog(shell, "Enter new file name", "File name:", fileName, new IInputValidator() {
			
			public String isValid(String newText) {
				if(!newText.endsWith(".bvr")){
					return "INVALID EXTENSION!";
				}
				if(newText.equals(fileName)){
					return "INVALID FILE NAME!";
				}
				return null;
			}
		});
		
		int code = inputDialog.open();
		if(code != InputDialog.OK) {
			return;
		}
		
		String newFileName = inputDialog.getValue();
		
		URI transformationURI = URI.createURI("platform:/plugin/no.sintef.bvr.transformation0to2/transforms/bvrTobvr2.qvto");
		TransformationExecutor qvtExecutor = new TransformationExecutor(transformationURI);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource inResource = resourceSet.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);
		EList<EObject> inObjects = inResource.getContents();
		
		ModelExtent inModelExtend = new BasicModelExtent(inObjects);
		ModelExtent outModelExtend = new BasicModelExtent();
		
		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true);
		
		
		ExecutionDiagnostic result = qvtExecutor.execute(context, inModelExtend, outModelExtend);
		if(result.getSeverity() == Diagnostic.OK){
				List<EObject> outObjects = outModelExtend.getContents();
				ResourceSetImpl resourceSetResult = new ResourceSetImpl();
				
				try {
					String relativeNewPath = file.getFullPath().toString().replaceFirst(file.getFullPath().segment(file.getFullPath().segmentCount() -1), newFileName);
					Resource outResource = resourceSetResult.createResource(URI.createURI("platform:/resource/" + relativeNewPath));
					outResource.getContents().addAll(outObjects);
					Map<Object, Object> options = new HashMap<Object, Object>();
					outResource.save(options);
				} catch (Exception e) {
					e.printStackTrace();
					MessageDialog.openError(shell, "Error saving the transformation or creating of the resource", e.getStackTrace().toString());
				}
		}else {
			// turn the result diagnostic into status and send it to error log			
			IStatus status = BasicDiagnostic.toIStatus(result);
			Activator.getDefault().getLog().log(status);
			MessageDialog.openError(shell, "Error during transformation", status.toString());
		}
	}
	

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
