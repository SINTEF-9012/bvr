package no.sintef.bvr.ui.editor.common;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.observer.ResourceObserver;
import no.sintef.bvr.tool.observer.ResourceSetEditorSubject;
import no.sintef.bvr.tool.observer.ResourceSubject;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import no.sintef.bvr.tool.ui.loader.BVRTransactionalModel;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

public abstract class MVCEditor extends EditorPart implements ResourceObserver {

	JTabbedPane pane = new JTabbedPane();
	protected JLayeredPane x = new JLayeredPane();
	protected URI resourceURI;
	protected CustomJApplet jApplet;
	
	private Frame frame;
	private Composite composite;

	public MVCEditor() {
		super();
		Context.eINSTANCE.setIWorkbenchWindow(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
	}

	protected BVRToolView v;
	protected BVRToolModel m;
	protected String filename;

	FileEditorInput fileinput;
	protected IFile iResource;
	
	
	public BVRToolModel getBVRModel(){
		return m;
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {

		setSite(site);
		setInput(input);
		fileinput = (FileEditorInput) input;
		filename = fileinput.getFile().getLocation().toString();
		setContentDescription("BVREditor:" + filename);
		setTitle();
		iResource = fileinput.getFile();
		Context.eINSTANCE.logger.setResource(iResource);
	}

	abstract public void setTitle();

	abstract public void setContents();

	abstract public void createView();

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			m.getBVRM().writeToFile(filename);
			fileinput.getFile().refreshLocal(IResource.DEPTH_ZERO, null);
			ResourceResourceSavedSubjectMap.eINSTANCE.pokeResourceSubjects(resourceURI);
		} catch (final IOException e) {
			new Thread() {
				public void run() {
					JOptionPane.showMessageDialog(frame,
							"Error Saving: " + e.getMessage(), "Saving Failed",
							JOptionPane.ERROR_MESSAGE);
				}
			}.start();
		} catch (final CoreException e) {
			new Thread() {
				public void run() {
					JOptionPane.showMessageDialog(frame,
							"Error Saving: " + e.getMessage(), "Saving Failed",
							JOptionPane.ERROR_MESSAGE);
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
		return (m != null) ? m.isNotSaved() : false;
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
		
		new Thread() {
			public void run() {
				if (fileinput != null) {
					try {
						UIManager.setLookAndFeel(UIManager
								.getSystemLookAndFeelClassName());

						m = Context.eINSTANCE.getModel(new File(filename));
						resourceURI = ((BVRTransactionalModel) m).getResource().getURI();
						
						List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
						ResourceSetEditorSubject subject = testResourceSetEditedSubject(subjects);
						ResourceResourceSetSubjectMap.eINSTANCE.testResourceSubject(resourceURI, subject);

						if (m != null) {
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
						}
					} catch (Exception e) {
						Context.eINSTANCE.logger.error("Cannot open file " + e.getMessage() , e);
						throw new RuntimeException("Rethrowing exception", e);
					}
				}
			}
		}.start();
	}

	@Override
	public void setFocus() {
		Context.eINSTANCE.setActiveJApplet(jApplet);
		Context.eINSTANCE.logger.setResource(iResource);
	}
	
	public void update(ResourceSubject subject) {
		firePropertyChange(ISaveablePart.PROP_DIRTY);
	}
	
	@Override
	public void dispose() {
		super.dispose();		
		Resource currentResource = ((BVRTransactionalModel) m).getResource();
		IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
		boolean isCurrentResourceUsed = Context.eINSTANCE.getEditorCommands().testXMIResourceUnload((XMIResource) currentResource, editorReferences);
		if(!isCurrentResourceUsed){
			Context.eINSTANCE.logger.debug("resource unloaded " + currentResource);
			Context.eINSTANCE.disposeModel(m);
			Context.eINSTANCE.logger.debug("disposing the model object, because can not find any MVC editors");
			
			//clear problem view
			try {
				iResource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
			} catch (CoreException e) {
				throw new RuntimeException("Rethrowing exception", e);
			}
		}
	}
	
	protected ResourceSetEditorSubject testResourceSetEditedSubject(List<ResourceSubject> subjects){
		if(subjects != null){
			for(ResourceSubject s : subjects){
				if(s instanceof ResourceSetEditorSubject){
					return (ResourceSetEditorSubject) s;
				}
			}
		}
		ResourceSetEditorSubject subject = new ResourceSetEditorSubject(m);
		subject.attach((BVRTransactionalModel) m);
		return subject;
	}
}
