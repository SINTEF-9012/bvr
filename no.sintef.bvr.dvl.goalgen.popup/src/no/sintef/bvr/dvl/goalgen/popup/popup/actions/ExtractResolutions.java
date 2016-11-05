package no.sintef.bvr.dvl.goalgen.popup.popup.actions;


import no.sintef.bvr.dvl.goalgen.interfaces.main.IGoalGenerator;
import no.sintef.bvr.dvl.goalgen.main.GoalGenerator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class ExtractResolutions implements IObjectActionDelegate {

	private Shell shell;
	private ISelection currentSelection;
	
	/**
	 * Constructor for Action1.
	 */
	public ExtractResolutions() {
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
		Object selectedObject = selection.getFirstElement();
		if(!(selectedObject instanceof IAdaptable)) {
			MessageDialog.openError(shell, "Error", "Cannot find file with variability model");
			return;
		}
		IFile ifile = (IFile) Platform.getAdapterManager().getAdapter(selectedObject, IFile.class);
		if(ifile == null) {
			MessageDialog.openError(shell, "Error", "Cannot find file with variability model");
			return;
		}
		String model_path = ifile.getFullPath().toOSString();
		String goals_path = ifile.getLocation().toOSString().replace(ifile.getLocation().lastSegment(), "");
		IGoalGenerator generator = new GoalGenerator(model_path, goals_path);
		
		try {
			generator.generate();
			ifile.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch(Exception e) {
			MessageDialog.openError(
					shell,
					"Error",
					"Could not extract products due to: " + e.getMessage());
		}
		
		MessageDialog.openInformation(
			shell,
			"Extraction",
			"Done!");
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		currentSelection = selection;
	}

}
