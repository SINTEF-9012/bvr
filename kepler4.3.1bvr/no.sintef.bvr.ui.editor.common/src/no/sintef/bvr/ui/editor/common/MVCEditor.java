/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package no.sintef.bvr.ui.editor.common;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.UIManager;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.observer.ResourceObserver;
import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.BVRTransactionalModel;
import no.sintef.bvr.tool.observer.ResourceSetEditedSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

public abstract class MVCEditor extends EditorPart implements ResourceObserver {

	protected JLayeredPane x = new JLayeredPane();
	protected URI resourceURI;
	protected CustomJApplet jApplet;

	protected BVRNotifiableController controllerNotifiable;
	protected BVRToolModel toolModel;
	protected String filename;

	protected FileEditorInput fileinput;
	protected IFile iResource;

	private Frame frame;
	private Composite composite;

	public MVCEditor() {
		super();
		Context.eINSTANCE.setIWorkbenchWindow(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow());

		// close BVR Type editors since they do not hold any refs to VType any
		// more when we reload eclipse
		IEditorReference[] editorRefs = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences();
		for (IEditorReference ref : editorRefs) {
			final IEditorPart editor = ref.getEditor(true);
			if (editor instanceof IMVCTypeEditor) {
				try {
					IEditorInput input = ref.getEditorInput();
					if (!(input instanceof IBVRTypeEditorInput)
							|| (input instanceof IBVRTypeEditorInput && ((IBVRTypeEditorInput<?>) input)
									.getVType() == null)) {
						Display.getDefault().asyncExec(new Runnable() {

							@Override
							public void run() {
								getSite().getPage().closeEditor(editor, false);
							}

						});
					}
				} catch (PartInitException e) {
					Context.eINSTANCE.logger.error(
							"can not close some editors ", e);
				}
			}
		}
	}

	public BVRToolModel getBVRModel() {
		return toolModel;
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
		fileinput = (FileEditorInput) input;
		filename = fileinput.getFile().getLocation().toString();
		setContentDescription("BVREditor:" + filename);
		iResource = fileinput.getFile();
		Context.eINSTANCE.problemLogger.setResource(iResource);
		setTitle();
	}

	abstract public void setTitle();

	abstract public void setContents();

	public abstract void createView();

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			toolModel.getBVRM().writeToFile(filename);
			fileinput.getFile().refreshLocal(IResource.DEPTH_ZERO, null);
			ResourceResourceSavedSubjectMap.eINSTANCE
					.pokeResourceSubjects(resourceURI);
		} catch (final IOException e) {
			new Thread() {
				public void run() {
					throw new RuntimeException("Error Saving: "
							+ e.getMessage(), e);
					/*
					 * JOptionPane.showMessageDialog(frame, "Error Saving: " +
					 * e.getMessage(), "Saving Failed",
					 * JOptionPane.ERROR_MESSAGE);
					 */
				}
			}.start();
		} catch (final CoreException e) {
			new Thread() {
				public void run() {
					throw new RuntimeException("Error Saving: "
							+ e.getMessage(), e);
					/*
					 * JOptionPane.showMessageDialog(frame, "Error Saving: " +
					 * e.getMessage(), "Saving Failed",
					 * JOptionPane.ERROR_MESSAGE);
					 */
				}
			}.start();
		}
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isDirty() {
		return (toolModel != null) ? toolModel.isNotSaved() : false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public void createPartControl(Composite parent) {
		composite = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
		FillLayout layout = new FillLayout();
		composite.setLayout(layout);
		frame = SWT_AWT.new_Frame(composite);

		if (fileinput != null) {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					Context.eINSTANCE.logger.error("failed to set  system look and feel", e);
				}

				toolModel = Context.eINSTANCE.testBVRToolModel(new File(
						filename));
				resourceURI = ((BVRTransactionalModel) toolModel).getResource()
						.getURI();

				jApplet = new CustomJApplet();
				Context.eINSTANCE.setActiveJApplet(jApplet);
				createView();
				// "The first child of the embedded frame must be a heavyweight component."
				frame.add(jApplet);
				setContents();
				int w = (int) frame.getBounds().getWidth();
				int h = (int) frame.getBounds().getHeight();
				jApplet.setSize(w, h);
				frame.revalidate();
				frame.repaint();
				firePropertyChange(ISaveablePart.PROP_DIRTY);

				// attach model as listener to any changes in the
				// resource
				synchronized (this) {
					List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE
							.getSubjects(resourceURI);
					ResourceSetEditedSubject subject = testResourceSetEditedSubject(subjects);
					ResourceResourceSetSubjectMap.eINSTANCE
							.testResourceSubject(resourceURI, subject);
					subject.attach((BVRTransactionalModel) toolModel);
				}

		}
	}

	@Override
	public void setFocus() {
		Context.eINSTANCE.setActiveJApplet(jApplet);
		Context.eINSTANCE.problemLogger.setResource(iResource);
	}

	public void update(ResourceSubject subject) {
		firePropertyChange(ISaveablePart.PROP_DIRTY);
	}

	@Override
	public void dispose() {
		super.dispose();
		Resource currentResource = ((BVRTransactionalModel) toolModel)
				.getResource();
		IEditorReference[] editorReferences = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences();
		boolean isCurrentResourceUsed = Context.eINSTANCE.getEditorCommands()
				.testXMIResourceUnload((XMIResource) currentResource,
						editorReferences);
		if (!isCurrentResourceUsed) {
			Context.eINSTANCE.logger.debug("resource unloaded "
					+ currentResource);
			Context.eINSTANCE.disposeModel(toolModel);
			Context.eINSTANCE.logger
					.debug("disposing the model object, because can not find any MVC editors");

			// detach model since there are no any editors which operate this
			// model
			List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE
					.getSubjects(resourceURI);
			ResourceSetEditedSubject subject = testResourceSetEditedSubject(subjects);
			subject.detach((BVRTransactionalModel) toolModel);
		}
	}

	protected ResourceSetEditedSubject testResourceSetEditedSubject(
			List<ResourceSubject> subjects) {
		if (subjects != null) {
			for (ResourceSubject s : subjects) {
				if (s instanceof ResourceSetEditedSubject) {
					return (ResourceSetEditedSubject) s;
				}
			}
		}
		ResourceSetEditedSubject subject = new ResourceSetEditedSubject(
				toolModel);
		return subject;
	}
}
