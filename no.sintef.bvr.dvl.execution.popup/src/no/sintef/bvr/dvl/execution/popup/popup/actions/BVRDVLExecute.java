package no.sintef.bvr.dvl.execution.popup.popup.actions;

import java.util.Iterator;
import java.util.List;

import no.sintef.bvr.dvl.execution.interfaces.errors.ConfigError;
import no.sintef.bvr.dvl.execution.interfaces.errors.PlannerError;
import no.sintef.bvr.dvl.execution.interfaces.errors.RealisationError;
import no.sintef.bvr.dvl.execution.interfaces.main.IDVLExecutor;
import no.sintef.bvr.dvl.execution.main.DVLExecutor;
import no.sintef.bvr.dvl.execution.popup.Activator;
import no.sintef.dvl.realisation.core.interfaces.errors.OperatorNotLocatedException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
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
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	@Override
	public void run(IAction action) {

		IStructuredSelection selection = (IStructuredSelection) currentSelection;
		IFile config_file = getConfiguration(selection);
		if (config_file == null) {
			MessageDialog.openError(shell, "BVR DVL::Execution", "Cannot find the configuration file, " + "should be located in the root directory "
					+ "of the project with name: " + config_name);
			return;
		}

		Iterator<?> iterator = selection.iterator();
		while (iterator.hasNext()) {
			Object selectedObject = iterator.next();
			IFile ifile = (IFile) Platform.getAdapterManager().getAdapter(selectedObject, IFile.class);
			if (ifile == null) {
				MessageDialog.openError(shell, "BVR DVL::Execution", "Selection is not a file");
				continue;
			}

			Job job = new Job("Realising the product: " + ifile.getName()) {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					Status status = new Status(Status.OK, Activator.PLUGIN_ID, "OK!");
					try {
						IDVLExecutor executor = new DVLExecutor(config_file);
						List<String> operators = executor.getOperators(ifile);
						executor.deriveProduct(getBaseName(ifile), operators);
						config_file.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
					} catch (PlannerError ex) {
						status = new Status(Status.ERROR, Activator.PLUGIN_ID, "Failed to find plan for '" + ifile.getName() + "' due to:\n'" + ex.getMessage()
								+ "'", ex);
					} catch (RealisationError ex) {
						status = new Status(Status.ERROR, Activator.PLUGIN_ID, "Failed to execute plan and " + "derive a product for '" + ifile.getName()
								+ "' due to:\n '" + ex.getMessage() + "'", ex);
					} catch (ConfigError ex) {
						status = new Status(Status.ERROR, Activator.PLUGIN_ID, "Check config. Configuration failure " + "due to:\n '" + ex.getMessage() + "'",
								ex);
					} catch (CoreException e) {
						status = new Status(Status.WARNING, Activator.PLUGIN_ID, "Could not refresh workspace..., please do it manually");
					} catch (OperatorNotLocatedException e) {
						status = new Status(Status.ERROR, Activator.PLUGIN_ID, "Operators are not located to produce products. Please install them!");
					}

					return status;
				}
			};

			job.schedule();
		}

	}

	private String getBaseName(IFile ifile) {
		String name = ifile.getName().replace(ifile.getFileExtension(), "");
		name = name.replace(".", "");
		return name;
	}

	private IFile getConfiguration(IStructuredSelection selection) {
		Object selectedObject = selection.getFirstElement();
		IFile ifile = (IFile) Platform.getAdapterManager().getAdapter(selectedObject, IFile.class);
		if (ifile == null)
			return null;

		IFile config_ifile = ifile.getProject().getFile(config_name);
		return (config_ifile.exists()) ? config_ifile : null;
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		currentSelection = selection;
	}
}
