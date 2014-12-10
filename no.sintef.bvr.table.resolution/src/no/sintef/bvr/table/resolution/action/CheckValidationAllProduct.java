package no.sintef.bvr.table.resolution.action;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.table.resolution.editors.BvrResolutionEditor;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.VSpecResolution;

public class CheckValidationAllProduct implements IHandler {
	EditingDomain editingDomain = null;
	IEditorPart editorPart = null;
	TreeViewer viewer = null;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		editorPart = HandlerUtil.getActiveEditorChecked(event);
		viewer = (TreeViewer) ((IViewerProvider) editorPart).getViewer();
		List<CheckValidationRootChoice.ViolationEntry> result = new ArrayList<CheckValidationRootChoice.ViolationEntry>();

		if (!(editorPart instanceof BvrResolutionEditor)) {
			return null;
		}
		BvrResolutionEditor bvrEditorPart = (BvrResolutionEditor) editorPart;
		editingDomain = bvrEditorPart.getEditingDomain();

		XMIResource resource = null;
		for (Resource res : editingDomain.getResourceSet().getResources()) {
			if (res instanceof XMIResource
					&& !(res instanceof GMFResource)
					&& ((XMIResource) res).getURI().equals(
							EditUIUtil.getURI(bvrEditorPart.getEditorInput()))) {
				resource =  (XMIResource) res;
			}
		}
		
		ConfigurableUnit cu = (ConfigurableUnit) resource.getContents().get(0);

		for (VSpecResolution vsr : cu.getOwnedVSpecResolution()) {
			if (vsr instanceof ChoiceResolutuion) {
				result = CheckValidationRootChoice.traverseResolutionTree(
						editingDomain, editorPart, viewer,
						(ChoiceResolutuion) vsr, result);
			}
		}
		if (result.size() == 0) {
			MessageDialog.openInformation(PlatformUI.getWorkbench()
					.getModalDialogShellProvider().getShell(),
					"Check Violation", "No Violation");

			return null;
		}

		ListDialog dialog = new ListDialog(PlatformUI.getWorkbench()
				.getModalDialogShellProvider().getShell());
		dialog.setContentProvider(new ArrayContentProvider());
		dialog.setInput(result.toArray());
		dialog.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				CheckValidationRootChoice.ViolationEntry entry;
				if (element instanceof CheckValidationRootChoice.ViolationEntry) {
					entry = (CheckValidationRootChoice.ViolationEntry) element;
					return entry.message;
				}
				return "";
			}

		});

		if (dialog.open() == Window.OK) {
			Object[] selection = dialog.getResult();
			if (selection.length > 0) {
				viewer.setSelection(new StructuredSelection(
						((CheckValidationRootChoice.ViolationEntry) selection[0]).target));
			}
		}

		return null;
	}

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

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
	public void removeHandlerListener(IHandlerListener handlerListener) {
	
	}

}
