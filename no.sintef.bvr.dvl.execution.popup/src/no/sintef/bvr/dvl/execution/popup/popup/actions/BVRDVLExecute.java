package no.sintef.bvr.dvl.execution.popup.popup.actions;

import java.util.Iterator;
import java.util.List;

import no.sintef.bvr.dvl.execution.interfaces.errors.ConfigError;
import no.sintef.bvr.dvl.execution.interfaces.errors.PlannerError;
import no.sintef.bvr.dvl.execution.interfaces.errors.RealisationError;
import no.sintef.bvr.dvl.execution.interfaces.main.IDVLExecutor;
import no.sintef.bvr.dvl.execution.main.DVLExecutor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class BVRDVLExecute implements IObjectActionDelegate {

	private Shell shell;
	private String config_name = "realisation.dvlconfig";
	private ISelection currentSelection;
	
	/**
	 * Constructor for Action1.
	 */
	public BVRDVLExecute() {
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
		
		IStructuredSelection selection = (IStructuredSelection) currentSelection;
		IFile config_file = getConfiguration(selection);
		if(config_file == null) {
			MessageDialog.openError(shell, 
					"BVR DVL::Execution", 
					"Cannot find the configuration file, "
					+ "should be located in the root directory "
					+ "of the project with name: " + config_name);
			return;
		}
		
		//String path_to_config = config_file.getFullPath().toOSString();
		IDVLExecutor executor = new DVLExecutor(config_file);
		
		Iterator<?> iterator = selection.iterator();
		while(iterator.hasNext()) {
			Object selectedObject = iterator.next();
			IFile ifile = (IFile) Platform.getAdapterManager().getAdapter(selectedObject, IFile.class);
			if(ifile == null) {
				MessageDialog.openError(shell, 
						"BVR DVL::Execution", 
						"Selection is not a file");
				continue;
			}
			
			try {
				//String path_resolution = ifile.getLocation().toOSString();
				List<String> operators = executor.getOperators(ifile);
				executor.deriveProduct(operators);
			}catch(PlannerError ex) {
				MessageDialog.openError(
						shell,
						"BVR DVL::Execution",
						"Failed to find plan for " +ifile.getName() + 
						" due to " + ex.getMessage());
			}catch(RealisationError ex) {
				MessageDialog.openError(
						shell,
						"BVR DVL::Execution",
						"Failed to execute plan and "
						+ "derive a product for " +ifile.getName() + 
						" due to " + ex.getMessage());
			} catch (ConfigError ex) {
				MessageDialog.openError(
						shell,
						"BVR DVL::Execution",
						"Check config. Configuration failure " +
						" due to " + ex.getMessage());
			}
			
		}
		try {
			config_file.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			MessageDialog.openInformation(
					shell,
					"BVR DVL::Execution",
					"All product are derived!");
		} catch (CoreException e) {
			MessageDialog.openError(
					shell,
					"BVR DVL::Execution",
					"Failed to refresh project");
			e.printStackTrace();
		}
	}
	
	private IFile getConfiguration(IStructuredSelection selection) {
		Object selectedObject = selection.getFirstElement();
		IFile ifile = (IFile) Platform.getAdapterManager().getAdapter(selectedObject, IFile.class);
		if(ifile == null)
			return null;
		
		IFile config_ifile = ifile.getProject().getFile(config_name);
		return (config_ifile.exists()) ? config_ifile : null;
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		currentSelection = selection;
	}

}
