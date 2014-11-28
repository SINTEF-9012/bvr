package no.sintef.bvr.ui.editor.mvc.type;

import java.awt.Toolkit;
import java.io.File;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import bvr.VType;
import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.observer.ResourceSavedSubject;
import no.sintef.bvr.tool.observer.ResourceSetEditedSubject;
import no.sintef.bvr.ui.editor.common.IBVRTypeEditorInput;
import no.sintef.bvr.ui.editor.common.IMVCTypeEditor;
import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.RefreshViewEvent;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;

public class MVCTypeEditor extends MVCEditor implements IMVCTypeEditor {

	private IBVRTypeEditorInput typeInput;

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// close Type editor if VType is null
		final EditorPart editor = this;
		if (!(input instanceof IBVRTypeEditorInput)
				|| (input instanceof IBVRTypeEditorInput && ((IBVRTypeEditorInput<?>) input)
						.getVType() == null)) {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					getSite().getPage().closeEditor(editor, false);
				}
			});
		} else {
			typeInput = (IBVRTypeEditorInput) input;
		}
		super.init(site, input);
	}

	@Override
	public void setTitle() {
		if (typeInput == null)
			return;

		setPartName(new File(filename).getName() + " (VType) "
				+ ((VType) typeInput.getVType()).getName() + " : VType");
	}

	@Override
	public void setContents() {
		if (typeInput == null)
			return;

		jApplet.add(((VTypeRootController) controllerNotifiable)
				.getEditorRootPanel());
	}

	@Override
	public void createView() {
		if (typeInput == null)
			return;

		((ResourceSubject) toolModel).attach(this);
		controllerNotifiable = new VTypeRootController(toolModel,
				(VType) typeInput.getVType());
		List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE
				.getSubjects(resourceURI);
		ResourceSetEditedSubject subject = testResourceSetEditedSubject(subjects);
		subject.attach(this);
		ResourceResourceSetSubjectMap.eINSTANCE.testResourceSubject(
				resourceURI, subject);

		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE
				.testResourceSavedSubject(resourceURI);
		sbjct.attach(this);
	}

	@Override
	public void update(ResourceSubject subject) {
		if (subject instanceof ResourceSetEditedSubject) {
			toolModel.markNotSaved();
			Toolkit.getDefaultToolkit()
					.getSystemEventQueue()
					.postEvent(
							new RefreshViewEvent(jApplet, controllerNotifiable));
		}
		if (subject instanceof ResourceSavedSubject) {
			toolModel.markSaved();
		}
		super.update(subject);
	}

	@Override
	public void dispose() {
		((ResourceSubject) toolModel).detach(this);

		List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE
				.getSubjects(resourceURI);
		ResourceSetEditedSubject subject = testResourceSetEditedSubject(subjects);
		subject.detach(this);

		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE
				.testResourceSavedSubject(resourceURI);
		sbjct.detach(this);
		super.dispose();
	}

}
