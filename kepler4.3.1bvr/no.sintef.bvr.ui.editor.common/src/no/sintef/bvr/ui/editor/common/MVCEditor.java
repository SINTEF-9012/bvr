package no.sintef.bvr.ui.editor.common;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;

import javax.swing.JApplet;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRModelSingleton;
import no.sintef.bvr.tool.ui.loader.BVRNotifier;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRTransactionalModel;
import no.sintef.bvr.tool.ui.loader.BVRView;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

public abstract class MVCEditor extends EditorPart implements BVRNotifier {

	JTabbedPane pane = new JTabbedPane();
	protected JLayeredPane x = new JLayeredPane();
	protected URI resourceURI;
	
	private Frame frame;
	private Composite composite;

	public MVCEditor() {
		super();
		Context.eINSTANCE.setIWorkbenchWindow(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
	}

	protected BVRView v;
	protected BVRModel m;
	protected String filename;

	FileEditorInput fileinput;
	
	static IPartListener2 pl = null;

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {

		setSite(site);
		setInput(input);
		fileinput = (FileEditorInput) input;
		filename = fileinput.getFile().getLocation().toString();
		setContentDescription("BVREditor:" + filename);
		setTitle();

		if(pl == null){
			IPartListener2 pl = new IPartListener2() {
				public void partActivated(IWorkbenchPartReference partRef) {}
				public void partBroughtToTop(IWorkbenchPartReference partRef) {}
				public void partDeactivated(IWorkbenchPartReference partRef) {}
				public void partOpened(IWorkbenchPartReference partRef) {}
				public void partHidden(IWorkbenchPartReference partRef) {}
				public void partVisible(IWorkbenchPartReference partRef) {}
				public void partInputChanged(IWorkbenchPartReference partRef) {}
	
				@Override
				public void partClosed(IWorkbenchPartReference partRef) {
					IWorkbenchPart x = partRef.getPart(false);
					BVRModelSingleton.editorClosed(x);
				}
				
			};
			
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().addPartListener(pl);
		}
	
	}

	abstract public void setTitle();

	abstract public void setContents(JApplet a);

	abstract public void createView(final BVRNotifier ep);

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			m.getBVRM().writeToFile(filename);
			m.markSaved();
			notifyProbeDirty();
			fileinput.getFile().refreshLocal(IResource.DEPTH_ZERO, null);
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
		if (v != null) {
			return v.isDirty();
		} else {
			return false;
		}
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
		
		final BVRNotifier ep = this;
		final IWorkbenchPart iwp = this;

		new Thread() {
			public void run() {
				if (fileinput != null) {
					try {

						UIManager.setLookAndFeel(UIManager
								.getSystemLookAndFeelClassName());
						//m = BVRModelSingleton.getModel(new File(filename));
						m = Context.eINSTANCE.getModel(new File(filename));
						resourceURI = ((BVRTransactionalModel) m).getResource().getURI();

						//m = BVRModelSingleton.getModel(new File(filename), iwp);

						if (m != null) {
							JApplet a = new JApplet();
							createView(ep);
							// "The first child of the embedded frame must be a heavyweight component."
							frame.add(a);
							setContents(a);
							int w = (int) frame.getBounds().getWidth();
							int h = (int) frame.getBounds().getHeight();
							a.setSize(w, h);
							frame.revalidate();
							frame.repaint();
							ep.notifyProbeDirty();
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.err.println("Cannot open file" + e + " "
								+ e.getMessage());
					}
				}
			}
		}.start();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyProbeDirty() {
		firePropertyChange(ISaveablePart.PROP_DIRTY);
	}
}
