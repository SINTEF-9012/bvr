package no.sintef.cvl.ui.editor.eclipse.editors;

import java.awt.Color;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;

import javax.swing.JApplet;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import no.sintef.cvl.tool.ui.loader.BVRNotifier;
import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.CVLModelSingleton;
import no.sintef.cvl.tool.ui.loader.CVLView;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public abstract class BVREditorMVC extends EditorPart implements ISaveablePart, IResourceChangeListener, BVRNotifier {

	JTabbedPane pane = new JTabbedPane();
	protected JLayeredPane x = new JLayeredPane();
	private Frame frame;
	private Composite composite;
	
	public BVREditorMVC(){
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}
	
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		
	}
	
	CVLView v;
	CVLModel m;
	protected String filename;

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		final BVRNotifier ep = this;
		
		setSite(site);
		setInput(input);
		final org.eclipse.ui.part.FileEditorInput inEditor = (org.eclipse.ui.part.FileEditorInput) input;
		filename = inEditor.getFile().getLocation().toString();
		setContentDescription("CVLEditor:" + filename);
		setTitle();
				
		new Thread(){
			public void run(){
				if(inEditor!= null){
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			        	m = CVLModelSingleton.getModel(new File(filename));
			        	if (m != null) {
			        		JApplet a = new JApplet(); 
			        		createView(ep);
			        		// "The first child of the embedded frame must be a heavyweight component."
			        		frame.add(a);
			        		setContents(a);
			        		int w = (int)frame.getBounds().getWidth();
			        		int h = (int)frame.getBounds().getHeight();
			        		a.setSize(w, h);
			        		frame.revalidate();
			        		frame.repaint();
			        		ep.notifyProbeDirty();
			        	}
					} catch(Exception e){
						e.printStackTrace();
						System.err.println("Cannot open file" + e + " " + e.getMessage());						
					}
		        }
			}
		}.start();
	}

	abstract void setTitle() ;
	
	abstract void setContents(JApplet a) ;

	abstract  void createView(final BVRNotifier ep) ;

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			m.getCVLM().writeToFile(filename);
			m.markSaved();
			notifyProbeDirty();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isDirty() {
		if(v != null){
			return v.isDirty();
		}else{
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
