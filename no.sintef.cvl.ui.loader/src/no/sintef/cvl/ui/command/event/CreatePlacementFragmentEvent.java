package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.strategy.impl.CreateBoundaryContext;
import no.sintef.cvl.ui.strategy.impl.GetSelectionContext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchWindow;

import cvl.ConfigurableUnit;
import cvl.CvlFactory;
import cvl.PlacementFragment;

public class CreatePlacementFragmentEvent implements ActionListener {

	private IWorkbenchWindow w;
	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;

	public CreatePlacementFragmentEvent(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views, IWorkbenchWindow w) {
		this.filePane = filePane;
		this.models = models;
		this.views = views;
		this.w = w;
	}
	
	static int count = 0;

	@Override
	public void actionPerformed(ActionEvent ev) {
		int tab = filePane.getSelectedIndex();
		CVLModel m = models.get(tab);
		
		ConfigurableUnit cu = m.getCU();
		
		PlacementFragment placement = CvlFactory.eINSTANCE.createPlacementFragment();
		
		GetSelectionContext selectionContext = new GetSelectionContext();
		try {
			EList<EObject> selectedObjects = selectionContext.getSelectedObjects();
			CreateBoundaryContext createBoundaryContext = new CreateBoundaryContext();
			createBoundaryContext.creatBoundaries(placement, selectedObjects);
			
			placement.setName(Constants.PLACEMENT_DEFAULT_NAME + count++);
			cu.getOwnedVariationPoint().add(placement);
		} catch (AbstractError e) {
			e.printStackTrace();
		}
		
		//views.get(tab).notifyRelalizationViewUpdate();
		views.get(tab).getConfigurableUnitSubject().notifyObserver();
	}
}


//int x = w.getWorkbench().getWorkbenchWindowCount();
/*

editor.get

if(editor instanceof EcoreEditor){
	EcoreEditor e = (EcoreEditor) editor;
	ISelection x = e.getSelection();
	JOptionPane.showMessageDialog(null, "Selection " + x.getClass());
}else{
	JOptionPane.showMessageDialog(null, "Unknown editor " + editor.getClass().getName() + ".." + EcoreEditor.class.getName());	
}
*/

//EcoreEditor e = w.getEcoreEditor();
//ISelection x = e.getSelection();*/

/*			JOptionPane.showMessageDialog(null, editor.getClass().getName());

if(editor.getClass().getSimpleName().equals("EcoreEditor")){
	try {
		Method method = editor.getClass().getMethod("getSelection");
		s = (ISelection) method.invoke(editor, new Object[0]);
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	}
	
	TreeSelection ts = (TreeSelection)s;
	
	List l = ts.toList();
	
	EObject e = (EObject)l.get(0);
	
	JOptionPane.showMessageDialog(null, "Selection e " + s.getClass() + " .. " + e);
}else if(editor.getClass().getSimpleName().equals("EcoreDiagramEditor")){
	EObject o = null;
	try {
		Method method = editor.getClass().getMethod("getDiagram");
		Object diagram = method.invoke(editor, new Object[0]);
		Method method2 = diagram.getClass().getMethod("getElement");
		o = (EObject)method2.invoke(diagram, new Object[0]);
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	}
	
	JOptionPane.showMessageDialog(null, "Selection d " + o);
}else{
	JOptionPane.showMessageDialog(null, "Unknown editor");
}
*/

//EcoreEditor
//EcoreDiagramEditor

/*
EObject e = null;
try {
	Object o = ss.getFirstElement();
	Method method = o.getClass().getMethod("resolveSemanticElement");
	e = (EObject) method.invoke(o, new Object[0]);
} catch (Exception ex) {
	JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
}*/