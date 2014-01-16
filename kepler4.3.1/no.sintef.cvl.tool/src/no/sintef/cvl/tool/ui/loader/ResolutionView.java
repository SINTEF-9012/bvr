package no.sintef.cvl.tool.ui.loader;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.demo.TextInBox;
import org.abego.treelayout.demo.TextInBoxNodeExtentProvider;
import org.abego.treelayout.util.DefaultConfiguration;
import org.abego.treelayout.util.DefaultTreeForTreeLayout;

import no.sintef.cvl.tool.common.Constants;
import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.exception.CVLModelException;
import no.sintef.cvl.tool.subject.ConfigurableUnitSubject;
import no.sintef.cvl.tool.subject.SelectedFragmentSubstitutionSubject;
import no.sintef.cvl.tool.ui.command.AddBCLConstraint;
import no.sintef.cvl.tool.ui.command.AddChoice;
import no.sintef.cvl.tool.ui.command.AddChoiceResolutuion;
import no.sintef.cvl.tool.ui.command.AddConfigurableUnit;
import no.sintef.cvl.tool.ui.command.AddGroupMultiplicity;
import no.sintef.cvl.tool.ui.command.AddOpaqueConstraint;
import no.sintef.cvl.tool.ui.command.AddVClassifier;
import no.sintef.cvl.tool.ui.command.AddVInstance;
import no.sintef.cvl.tool.ui.command.AddVariableValueAssignment;
import no.sintef.cvl.tool.ui.dropdown.VSpecResDropDownListener;
import no.sintef.cvl.tool.ui.editor.BindingJTable;
import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import no.sintef.cvl.tool.ui.editor.FragmentSubstitutionJTable;
import no.sintef.cvl.tool.ui.editor.SubstitutionFragmentJTable;
import no.sintef.cvl.ui.framework.TitledElement;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.cvl.ui.framework.elements.EditableModelPanel;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import cvl.BCLConstraint;
import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.ConfigurableUnit;
import cvl.Constraint;
import cvl.NamedElement;
import cvl.OpaqueConstraint;
import cvl.VClassifier;
import cvl.VInstance;
import cvl.VSpec;
import cvl.VSpecResolution;
import cvl.VariableValueAssignment;

public class ResolutionView extends CVLView{
	private CVLModel m;
	
	public JTabbedPane modelPane;
	
	// VSpec
	public JScrollPane vspecScrollPane;
	public EditableModelPanel vspecEpanel;
	private Map<JComponent, NamedElement> vspecvmMap;
	private CVLUIKernel vSpeccvluikernel;
	
	// Resolutions
	public JTabbedPane resPane;
	private List<JScrollPane> resolutionPanes;
	private List<EditableModelPanel> resolutionEpanels;
	private List<CVLUIKernel> resolutionkernels;
	private List<Map<JComponent, NamedElement>> resolutionvmMaps;
	private List<List<JComponent>> resolutionNodes;
	private List<List<Pair<JComponent, JComponent>>> resolutionBindings;
	
	private ConfigurableUnitSubject configurableUnitSubject;

	public CVLUIKernel getKernel() {
		return vSpeccvluikernel;
	}
	
	public ResolutionView(CVLModel m, BVRNotifier ep) {
		super();
		
		this.ep = ep;
		
		// Alloc
		
        resolutionPanes = new ArrayList<JScrollPane>();
        resolutionEpanels = new ArrayList<EditableModelPanel>();
        resolutionkernels = new ArrayList<CVLUIKernel>();
    	resolutionvmMaps = new ArrayList<Map<JComponent,NamedElement>>();
    	resolutionNodes = new ArrayList<List<JComponent>>();
    	resolutionBindings = new ArrayList<List<Pair<JComponent,JComponent>>>();
    	
    	//cvlViewSubject = new CVLViewSubject(this);
		
		this.m = m;
		
    	configurableUnitSubject = new ConfigurableUnitSubject(this.getCU());
	
    	vSpeccvluikernel = new CVLUIKernel(vspecvmMap, this, resolutionvmMaps);
		

		vspecScrollPane = new JScrollPane(vSpeccvluikernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        vspecEpanel = new EditableModelPanel(vspecScrollPane);        
        
        // Resolution panes
        resPane = new JTabbedPane();
        
        try {
			loadCVLResolutionView(m.getCVLM().getCU(), resolutionkernels, resPane);
		} catch (CVLModelException e) {
			e.printStackTrace();
		}
        
        autoLayoutResolutions();

	}
	
	public boolean isDirty() {
		return m.isNotSaved();
	}

	public ConfigurableUnitSubject getConfigurableUnitSubject(){
		return configurableUnitSubject;
	}

	public ConfigurableUnit getCU() {
		return m.getCU();
	}

	int choiceCount = 1;

	List<VSpec> minimized = new ArrayList<VSpec>();

	private BVRNotifier ep;

	private void autoLayoutResolutions() {
		for(int i = 0; i < resolutionPanes.size(); i++){
			Map<JComponent, TextInBox> nodemap = new HashMap<JComponent, TextInBox>();
			Map<TextInBox, JComponent> nodemapr = new HashMap<TextInBox, JComponent>();
			
			for(JComponent c : resolutionNodes.get(i)){
				String title = ((TitledElement)c).getTitle();
				//System.out.println(title);
				TextInBox t = new TextInBox(title, c.getWidth(), c.getHeight());
				nodemap.put(c, t);
				nodemapr.put(t, c);
			}
			
			TextInBox root = nodemap.get(resolutionNodes.get(i).get(0));
	
			DefaultTreeForTreeLayout<TextInBox> tree = new DefaultTreeForTreeLayout<TextInBox>(root);
			
			for(Pair<JComponent, JComponent> p : resolutionBindings.get(i)){
				TextInBox a = nodemap.get(p.a);
				TextInBox b = nodemap.get(p.b);
				tree.addChild(a, b);
			}
			
			// setup the tree layout configuration
			double gapBetweenLevels = 30;
			double gapBetweenNodes = 10;
			DefaultConfiguration<TextInBox> configuration = new DefaultConfiguration<TextInBox>(gapBetweenLevels, gapBetweenNodes);
	
			// create the NodeExtentProvider for TextInBox nodes
			TextInBoxNodeExtentProvider nodeExtentProvider = new TextInBoxNodeExtentProvider();
			TreeLayout<TextInBox> treeLayout = new TreeLayout<TextInBox>(tree, nodeExtentProvider, configuration);
			
			// Set positions
			for(JComponent c : resolutionNodes.get(i)){
				TextInBox t = nodemap.get(c);
				Map<TextInBox, Double> x = treeLayout.getNodeBounds();
				Double z = x.get(t);
				c.setBounds((int)z.getX(), (int)z.getY(), (int)z.getWidth(), (int)z.getHeight());
			}
		}
	}

	public void notifyResolutionViewUpdate() {
		// Save
		boolean isEmpty = resPane.getTabCount() == 0;
		int resmodels = getCU().getOwnedVSpecResolution().size();
		boolean modelIsEmpty = getCU().getOwnedVSpecResolution().size() == 0;
		
		int selected = 0;
		Point pos = null;
		if(!isEmpty){
			selected = resPane.getSelectedIndex();
			pos = resolutionPanes.get(selected).getViewport().getViewPosition();
		}
		
		// Clean up
		resPane.removeAll();
	    resolutionPanes = new ArrayList<JScrollPane>();
	    resolutionEpanels = new ArrayList<EditableModelPanel>();
	    resolutionkernels = new ArrayList<CVLUIKernel>();
		resolutionvmMaps = new ArrayList<Map<JComponent,NamedElement>>();
		resolutionNodes = new ArrayList<List<JComponent>>();
		resolutionBindings = new ArrayList<List<Pair<JComponent,JComponent>>>();
		
		choiceCount = 1;
	    
	    try {
			loadCVLResolutionView(m.getCVLM().getCU(), resolutionkernels, resPane);
		} catch (CVLModelException e) {
			e.printStackTrace();
		}
	    
	    autoLayoutResolutions();
	    
	    // Restore positions
	    if(!isEmpty && !modelIsEmpty && selected <= resmodels){
		    resPane.setSelectedIndex(selected);
		    resolutionPanes.get(selected).getViewport().setViewPosition(pos);
	    }
	    
	    // Mark dirty
	    m.markNotSaved();
	    ep.notifyProbeDirty();
	}

	private void loadCVLResolutionView(ConfigurableUnit cu, List<CVLUIKernel> resolutionkernels, JTabbedPane resPane) throws CVLModelException{
		resPane.addMouseListener(new VSpecResDropDownListener(m, cu, this));
		
		if(cu.getOwnedVSpecResolution().size() == 0) return;
		
		for(VSpecResolution v : cu.getOwnedVSpecResolution()){
			CVLUIKernel resKernel = new CVLUIKernel(vspecvmMap, this, resolutionvmMaps);
			resolutionkernels.add(resKernel);
	        JScrollPane scrollPane = new JScrollPane(resKernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        EditableModelPanel epanel = new EditableModelPanel(scrollPane);
	        
	        resolutionPanes.add(scrollPane);
	        resolutionEpanels.add(epanel);
	        Map<JComponent, NamedElement> vmMap = new HashMap<JComponent, NamedElement>();
	    	resolutionvmMaps.add(vmMap);
	        List<JComponent> nodes = new ArrayList<JComponent>();
	    	resolutionNodes.add(nodes);
	    	List<Pair<JComponent, JComponent>> bindings = new ArrayList<Pair<JComponent,JComponent>>();
	    	resolutionBindings.add(bindings);
			
			loadCVLResolutionView(v, resKernel, null, cu, vmMap, nodes, bindings);
			String tabtitle = "";
			if(v instanceof ChoiceResolutuion){
				ChoiceResolutuion cr = (ChoiceResolutuion) v;
				String choicename = "null";
				if(cr.getResolvedVSpec() != null){
					choicename = cr.getResolvedVSpec().getName();
				}
				tabtitle = choicename + " " + choiceCount;
				choiceCount++;
			}else if(v instanceof VInstance){
				VInstance vi = (VInstance) v;
				tabtitle = vi.getName() + ":" + vi.getResolvedVSpec().getName();
			}

			resPane.addTab(tabtitle, null, epanel, "");
		}
	}

	private void loadCVLResolutionView(VSpecResolution v, CVLUIKernel cvluikernel, JComponent parent, ConfigurableUnit cu, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings) throws CVLModelException {
		JComponent nextParent = null;
		
		// Add view
		//System.out.println(v.getClass().getSimpleName());
		if(v instanceof VInstance){
			//System.out.println(v + ", " + cvluikernel);
			
			nextParent = new AddVInstance().init(cvluikernel, v, parent, vmMap, nodes, bindings, this).execute();
			
			vmMap.put(nextParent, v);
			
		}else if(v instanceof ChoiceResolutuion){
			//System.out.println(v);
			
			nextParent = new AddChoiceResolutuion().init(cvluikernel, v, parent, vmMap, nodes, bindings, this).execute();
			
			vmMap.put(nextParent, v);
			
		}else if(v instanceof VariableValueAssignment){
			//System.out.println(v);
			
			nextParent = new AddVariableValueAssignment().init(cvluikernel, v, parent, vmMap, nodes, bindings, this).execute();
			
			vmMap.put(nextParent, v);
			
		}else{
			throw new CVLModelException("Unknown element: " + v.getClass());
		}
		
		// Recursive step
		//System.out.println();
		for(VSpecResolution vs : v.getChild()){
			//System.out.println("Treating " + vs.getResolvedVSpec().getName());
			loadCVLResolutionView(vs, cvluikernel, nextParent, cu, vmMap, nodes, bindings);
		}
	}

	@Override
	public void notifyVspecViewUpdate() {
		throw new UnsupportedOperationException();		
	}

	@Override
	public void notifyRelalizationViewReset() {
		throw new UnsupportedOperationException();		
	}

	@Override
	public void notifyAllViews() {
		throw new UnsupportedOperationException();		
	}

	@Override
	public void setMaximized(VSpec v) {
		throw new UnsupportedOperationException();		
	}

	@Override
	public void setMinimized(VSpec v) {
		throw new UnsupportedOperationException();		
	}
}
