package no.sintef.cvl.ui.editor.eclipse.editors;

import java.awt.Frame;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.FileHelper;

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
	private List<CVLView> views = new LinkedList<CVLView>();
	private List<CVLModel> models = new LinkedList<CVLModel>();
	
	public CVLModelUIEditor(){
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}
	
	
	
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		
	}


	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		
		setSite(site);
		setInput(input);
		final org.eclipse.ui.part.FileEditorInput inEditor = (org.eclipse.ui.part.FileEditorInput) input;
		setContentDescription("CVLEditor:"+inEditor.getFile().getLocation().toString());
				
		new Thread(){
			public void run(){
				if(inEditor!= null){
					try {
			            System.out.println("init=" + inEditor.getFile().getLocation().toString());
			        	CVLModel m = FileHelper.load(new File(inEditor.getFile().getLocation().toString()));
			        	if (m != null) {
			        		models.add(m);
			        		views.add(new CVLView(m, pane));
			        	}
					} catch(Exception e){
						System.err.println("Cannot open file"+e.getMessage());						
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
		Composite composite = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
        FillLayout layout = new FillLayout();
        composite.setLayout(layout);
        Frame frame = SWT_AWT.new_Frame(composite);
        frame.add(pane);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}


}
