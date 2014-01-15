package no.sintef.cvl.ui.editor.eclipse.editors;

import java.awt.Frame;
import java.io.File;

import javax.swing.JApplet;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;

import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.VSpecView;

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
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class CVLModelUIEditor extends EditorPart implements IResourceChangeListener {

	JTabbedPane pane = new JTabbedPane();
	protected JLayeredPane x = new JLayeredPane();
	private Frame frame;
	private Composite composite;
	
	public CVLModelUIEditor(){
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}
	
	
	
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {	
		setSite(site);
		setInput(input);
		final org.eclipse.ui.part.FileEditorInput inEditor = (org.eclipse.ui.part.FileEditorInput) input;
		setContentDescription("CVLEditor:"+inEditor.getFile().getLocation().toString());
				
		new Thread(){
			public void run(){
				if(inEditor!= null){
					try {
			        	CVLModel m = new CVLModel(new File(inEditor.getFile().getLocation().toString()));
			        	if (m != null) {
			        		JApplet a = new JApplet(); 
			        		VSpecView v = new VSpecView(m, a, frame);
			        		// "The first child of the embedded frame must be a heavyweight component."
			        		frame.add(a);
			        		a.add(v.vspecEpanel);
			        		int w = (int)frame.getBounds().getWidth();
			        		int h = (int)frame.getBounds().getHeight();
			        		a.setSize(w, h);
			        		frame.revalidate();
			        		frame.repaint();
			        	}
					} catch(Exception e){
						e.printStackTrace();
						System.err.println("Cannot open file" + e + " " + e.getMessage());						
					}
		        }
			}
		}.start();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
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


}
