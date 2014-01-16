package no.sintef.cvl.ui.editor.eclipse.editors;

import java.io.IOException;
import java.util.LinkedList;

import no.sintef.cvl.gmf.vspec.edit.parts.ConfigurableUnitEditPart;
import no.sintef.cvl.gmf.vspec.part.CVLMetamodelDiagramEditorPlugin;
import no.sintef.cvl.gmf.vspec.part.CVLMetamodelDiagramEditorUtil;
import no.sintef.cvl.gmf.vspec.part.CVLMetamodelVisualIDRegistry;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

public class BVRVSpecEditorGMF extends EditorPart {
	private EObject diagramRoot = null;

	public BVRVSpecEditorGMF() {
		super();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Nothing
	}

	@Override
	public void doSaveAs() {
		// Nothing
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
		// If exist cvl_diagram file, launch gmf editor and close this editor.
		// If not, generate cvl_diagram from cvl file and launch and close.

		// file existing check
		IFile diagramFile = null;
		if (input instanceof FileEditorInput) {
			FileEditorInput fei = (FileEditorInput) input;
			IPath p = fei.getFile().getFullPath();
			p = p.removeFileExtension();
			p = p.addFileExtension("cvl_diagram");
			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace()
					.getRoot();
			diagramFile = workspaceRoot.getFile(p);
			if (!diagramFile.exists()) {
				// Generate diagram file and loaunch
				generateDiagramFile(fei.getFile(), diagramFile);
			} else {
				// Launch diagram editor for existing file
				openDiagramFile(diagramFile);

			}
		}

		// Close this editor when activated.
		site.getPage().addPartListener(new IPartListener() {

			@Override
			public void partActivated(IWorkbenchPart part) {
				BVRVSpecEditorGMF.this.getSite().getPage()
						.closeEditor(BVRVSpecEditorGMF.this, false);
			}

			@Override
			public void partBroughtToTop(IWorkbenchPart part) {
				// Nothing
			}

			@Override
			public void partClosed(IWorkbenchPart part) {
				// Nothing
			}

			@Override
			public void partDeactivated(IWorkbenchPart part) {
				// Nothing
			}

			@Override
			public void partOpened(IWorkbenchPart part) {
				// Nothing
			}

		});
	}

	/**
	 * Copy from generated function of generating diagram file at
	 * CVLMetamodelInitDiagramFileAction and CVLMetamodelNewDiagramFileWizard
	 * 
	 * @param modelFile
	 * @param diagramFile
	 */
	public void generateDiagramFile(IFile modelFile, IFile diagramFile) {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		ResourceSet resourceSet = editingDomain.getResourceSet();
		URI domainModelURI = URI.createPlatformResourceURI(modelFile
				.getFullPath().toString(), true);

		try {
			Resource resource = resourceSet.getResource(domainModelURI, true);
			diagramRoot = (EObject) resource.getContents().get(0);
		} catch (WrappedException ex) {
			CVLMetamodelDiagramEditorPlugin.getInstance().logError(
					"Unable to load resource: " + domainModelURI, ex); //$NON-NLS-1$
		}

		LinkedList<IFile> affectedFiles = new LinkedList<IFile>();

		// CVLMetamodelDiagramEditorUtil.setCharset(diagramFile);
		affectedFiles.add(diagramFile);
		URI diagramModelURI = URI.createPlatformResourceURI(diagramFile
				.getFullPath().toString(), true);

		final Resource diagramResource = resourceSet
				.createResource(diagramModelURI);
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				editingDomain, "Init Diagram Command", affectedFiles) {

			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				int diagramVID = CVLMetamodelVisualIDRegistry
						.getDiagramVisualID(diagramRoot);
				if (diagramVID != ConfigurableUnitEditPart.VISUAL_ID) {
					return CommandResult
							.newErrorCommandResult("Incorrect Root Error");
				}
				Diagram diagram = ViewService
						.createDiagram(
								diagramRoot,
								ConfigurableUnitEditPart.MODEL_ID,
								CVLMetamodelDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				diagramResource.getContents().add(diagram);
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					new NullProgressMonitor(), null);
			diagramResource
					.save(CVLMetamodelDiagramEditorUtil.getSaveOptions());
			CVLMetamodelDiagramEditorUtil.openDiagram(diagramResource);
		} catch (ExecutionException e) {
			CVLMetamodelDiagramEditorPlugin.getInstance().logError(
					"Unable to create model and diagram", e); //$NON-NLS-1$
		} catch (IOException ex) {
			CVLMetamodelDiagramEditorPlugin.getInstance().logError(
					"Save operation failed for: " + diagramModelURI, ex); //$NON-NLS-1$
		} catch (PartInitException ex) {
			CVLMetamodelDiagramEditorPlugin.getInstance().logError(
					"Unable to open editor", ex); //$NON-NLS-1$
		}
		return;
	}

	/**
	 * 
	 * @param diagramFile
	 */
	public void openDiagramFile(IFile diagramFile) {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		ResourceSet resourceSet = editingDomain.getResourceSet();

		URI diagramModelURI = URI.createPlatformResourceURI(diagramFile
				.getFullPath().toString(), true);

		final Resource diagramResource = resourceSet.getResource(
				diagramModelURI, true);
		try {
			CVLMetamodelDiagramEditorUtil.openDiagram(diagramResource);

		} catch (PartInitException ex) {
			CVLMetamodelDiagramEditorPlugin.getInstance().logError(
					"Unable to open editor", ex); //$NON-NLS-1$
		}
		return;
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		// Nothing
	}

	@Override
	public void setFocus() {
		// Nothing

	}

}
