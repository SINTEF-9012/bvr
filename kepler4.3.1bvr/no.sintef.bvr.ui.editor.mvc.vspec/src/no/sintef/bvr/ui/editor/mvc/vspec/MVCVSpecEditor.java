package no.sintef.bvr.ui.editor.mvc.vspec;

import java.awt.Toolkit;
import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;

import bvr.VType;
import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.model.IBVRTransactionalVTypeState;
import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.observer.ResourceSavedSubject;
import no.sintef.bvr.tool.observer.ResourceSetEditedSubject;
import no.sintef.bvr.ui.editor.common.IBVRTypeEditorInput;
import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.RefreshViewEvent;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;


public class MVCVSpecEditor extends MVCEditor {

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);
	}
	
	@Override
	public void setTitle() {
		setPartName(new File(filename).getName() + " (VSpec)");
	}
	
	@Override
	public void setContents() {
		jApplet.add(((VSpecRootController) controllerNotifiable).getEditorRootPanel());
	}
	

	@Override
	public void createView() {
		((ResourceSubject) toolModel).attach(this);
		
		controllerNotifiable = new VSpecRootController(toolModel);
		List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		ResourceSetEditedSubject subject = testResourceSetEditedSubject(subjects);
		subject.attach(this);
		ResourceResourceSetSubjectMap.eINSTANCE.testResourceSubject(resourceURI, subject);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.attach(this);
	}

	@Override
	public void update(ResourceSubject subject) {
		if(subject instanceof ResourceSetEditedSubject){
			toolModel.markNotSaved();
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new RefreshViewEvent(jApplet, controllerNotifiable));
		}
		if(subject instanceof ResourceSavedSubject){
			toolModel.markSaved();
		}
		if(subject instanceof IBVRTransactionalVTypeState) {
			final TypeIEditorInput<VType> typeInput = new TypeIEditorInput<VType>(((FileEditorInput) getEditorInput()).getFile());
			typeInput.setVType((VType) ((IBVRTransactionalVTypeState<?, ?>) subject).getVType());
			final Logger logger = Context.eINSTANCE.logger;
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
						IWorkbenchPage page = getSite().getPage();
						try {
							page.openEditor(typeInput, "no.sintef.bvr.ui.editor.mvc.type.BVRMVCTypeEditor", true, IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);
						} catch (PartInitException e) {
							logger.error("cannot open BVR type editor", e);
						}
				}
				
			});
		}
		super.update(subject);
	}
	
	@Override
	public void dispose() {
		((ResourceSubject) toolModel).detach(this);
		
		List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		ResourceSetEditedSubject subject = testResourceSetEditedSubject(subjects);
		subject.detach(this);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.detach(this);
		super.dispose();
	}
	
	class TypeIEditorInput<VTYPE extends VType> extends FileEditorInput implements IBVRTypeEditorInput<VTYPE> {
		
		private VTYPE vType;
		
		public VTYPE getVType(){
			return vType;
		}
		
		public void setVType(VTYPE _vType){
			vType = _vType;
		}

		public TypeIEditorInput(IFile file) {
			super(file);
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof IBVRTypeEditorInput && vType != null)
				return vType.equals(((IBVRTypeEditorInput<?>) obj).getVType()) &&
						getFile().equals(((FileEditorInput) obj).getFile());
			
			return super.equals(obj);
		}
	}
}
